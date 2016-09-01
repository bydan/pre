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
import com.bydan.erp.facturacion.util.HistorialFormaPagoConstantesFunciones;
import com.bydan.erp.facturacion.util.HistorialFormaPagoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.HistorialFormaPagoParameterGeneral;
import com.bydan.erp.facturacion.business.entity.HistorialFormaPago;
import com.bydan.erp.facturacion.business.logic.HistorialFormaPagoLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

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
public class HistorialFormaPagoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(HistorialFormaPagoLogic.class);
	
	protected HistorialFormaPagoDataAccess historialformapagoDataAccess; 	
	protected HistorialFormaPago historialformapago;
	protected List<HistorialFormaPago> historialformapagos;
	protected Object historialformapagoObject;	
	protected List<Object> historialformapagosObject;
	
	public static ClassValidator<HistorialFormaPago> historialformapagoValidator = new ClassValidator<HistorialFormaPago>(HistorialFormaPago.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected HistorialFormaPagoLogicAdditional historialformapagoLogicAdditional=null;
	
	public HistorialFormaPagoLogicAdditional getHistorialFormaPagoLogicAdditional() {
		return this.historialformapagoLogicAdditional;
	}
	
	public void setHistorialFormaPagoLogicAdditional(HistorialFormaPagoLogicAdditional historialformapagoLogicAdditional) {
		try {
			this.historialformapagoLogicAdditional=historialformapagoLogicAdditional;
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
	
	
	
	
	public  HistorialFormaPagoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.historialformapagoDataAccess = new HistorialFormaPagoDataAccess();
			
			this.historialformapagos= new ArrayList<HistorialFormaPago>();
			this.historialformapago= new HistorialFormaPago();
			
			this.historialformapagoObject=new Object();
			this.historialformapagosObject=new ArrayList<Object>();
				
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
			
			this.historialformapagoDataAccess.setConnexionType(this.connexionType);
			this.historialformapagoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  HistorialFormaPagoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.historialformapagoDataAccess = new HistorialFormaPagoDataAccess();
			this.historialformapagos= new ArrayList<HistorialFormaPago>();
			this.historialformapago= new HistorialFormaPago();
			this.historialformapagoObject=new Object();
			this.historialformapagosObject=new ArrayList<Object>();
			
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
			
			this.historialformapagoDataAccess.setConnexionType(this.connexionType);
			this.historialformapagoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public HistorialFormaPago getHistorialFormaPago() throws Exception {	
		HistorialFormaPagoLogicAdditional.checkHistorialFormaPagoToGet(historialformapago,this.datosCliente,this.arrDatoGeneral);
		HistorialFormaPagoLogicAdditional.updateHistorialFormaPagoToGet(historialformapago,this.arrDatoGeneral);
		
		return historialformapago;
	}
		
	public void setHistorialFormaPago(HistorialFormaPago newHistorialFormaPago) {
		this.historialformapago = newHistorialFormaPago;
	}
	
	public HistorialFormaPagoDataAccess getHistorialFormaPagoDataAccess() {
		return historialformapagoDataAccess;
	}
	
	public void setHistorialFormaPagoDataAccess(HistorialFormaPagoDataAccess newhistorialformapagoDataAccess) {
		this.historialformapagoDataAccess = newhistorialformapagoDataAccess;
	}
	
	public List<HistorialFormaPago> getHistorialFormaPagos() throws Exception {		
		this.quitarHistorialFormaPagosNulos();
		
		HistorialFormaPagoLogicAdditional.checkHistorialFormaPagoToGets(historialformapagos,this.datosCliente,this.arrDatoGeneral);
		
		for (HistorialFormaPago historialformapagoLocal: historialformapagos ) {
			HistorialFormaPagoLogicAdditional.updateHistorialFormaPagoToGet(historialformapagoLocal,this.arrDatoGeneral);
		}
		
		return historialformapagos;
	}
	
	public void setHistorialFormaPagos(List<HistorialFormaPago> newHistorialFormaPagos) {
		this.historialformapagos = newHistorialFormaPagos;
	}
	
	public Object getHistorialFormaPagoObject() {	
		this.historialformapagoObject=this.historialformapagoDataAccess.getEntityObject();
		return this.historialformapagoObject;
	}
		
	public void setHistorialFormaPagoObject(Object newHistorialFormaPagoObject) {
		this.historialformapagoObject = newHistorialFormaPagoObject;
	}
	
	public List<Object> getHistorialFormaPagosObject() {		
		this.historialformapagosObject=this.historialformapagoDataAccess.getEntitiesObject();
		return this.historialformapagosObject;
	}
		
	public void setHistorialFormaPagosObject(List<Object> newHistorialFormaPagosObject) {
		this.historialformapagosObject = newHistorialFormaPagosObject;
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
		
		if(this.historialformapagoDataAccess!=null) {
			this.historialformapagoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			historialformapagoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			historialformapagoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		historialformapago = new  HistorialFormaPago();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			historialformapago=historialformapagoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.historialformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapago);
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
		historialformapago = new  HistorialFormaPago();
		  		  
        try {
			
			historialformapago=historialformapagoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.historialformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		historialformapago = new  HistorialFormaPago();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			historialformapago=historialformapagoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.historialformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapago);
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
		historialformapago = new  HistorialFormaPago();
		  		  
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
		historialformapago = new  HistorialFormaPago();
		  		  
        try {
			
			historialformapago=historialformapagoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.historialformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		historialformapago = new  HistorialFormaPago();
		  		  
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
		historialformapago = new  HistorialFormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =historialformapagoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		historialformapago = new  HistorialFormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=historialformapagoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		historialformapago = new  HistorialFormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =historialformapagoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		historialformapago = new  HistorialFormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=historialformapagoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		historialformapago = new  HistorialFormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =historialformapagoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		historialformapago = new  HistorialFormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=historialformapagoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		historialformapagos = new  ArrayList<HistorialFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapagos=historialformapagoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialFormaPago(historialformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
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
		historialformapagos = new  ArrayList<HistorialFormaPago>();
		  		  
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
		historialformapagos = new  ArrayList<HistorialFormaPago>();
		  		  
        try {			
			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapagos=historialformapagoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarHistorialFormaPago(historialformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		historialformapagos = new  ArrayList<HistorialFormaPago>();
		  		  
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
		historialformapagos = new  ArrayList<HistorialFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapagos=historialformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialFormaPago(historialformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
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
		historialformapagos = new  ArrayList<HistorialFormaPago>();
		  		  
        try {
			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapagos=historialformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialFormaPago(historialformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
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
		historialformapagos = new  ArrayList<HistorialFormaPago>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapagos=historialformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHistorialFormaPago(historialformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
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
		historialformapagos = new  ArrayList<HistorialFormaPago>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapagos=historialformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHistorialFormaPago(historialformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		historialformapago = new  HistorialFormaPago();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapago=historialformapagoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHistorialFormaPago(historialformapago);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapago);
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
		historialformapago = new  HistorialFormaPago();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapago=historialformapagoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHistorialFormaPago(historialformapago);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		historialformapagos = new  ArrayList<HistorialFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapagos=historialformapagoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialFormaPago(historialformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
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
		historialformapagos = new  ArrayList<HistorialFormaPago>();
		  		  
        try {
			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapagos=historialformapagoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHistorialFormaPago(historialformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosHistorialFormaPagosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		historialformapagos = new  ArrayList<HistorialFormaPago>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-getTodosHistorialFormaPagosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapagos=historialformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarHistorialFormaPago(historialformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
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
	
	public  void  getTodosHistorialFormaPagos(String sFinalQuery,Pagination pagination)throws Exception {
		historialformapagos = new  ArrayList<HistorialFormaPago>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			historialformapagos=historialformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarHistorialFormaPago(historialformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarHistorialFormaPago(HistorialFormaPago historialformapago) throws Exception {
		Boolean estaValidado=false;
		
		if(historialformapago.getIsNew() || historialformapago.getIsChanged()) { 
			this.invalidValues = historialformapagoValidator.getInvalidValues(historialformapago);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(historialformapago);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarHistorialFormaPago(List<HistorialFormaPago> HistorialFormaPagos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(HistorialFormaPago historialformapagoLocal:historialformapagos) {				
			estaValidadoObjeto=this.validarGuardarHistorialFormaPago(historialformapagoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarHistorialFormaPago(List<HistorialFormaPago> HistorialFormaPagos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarHistorialFormaPago(historialformapagos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarHistorialFormaPago(HistorialFormaPago HistorialFormaPago) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarHistorialFormaPago(historialformapago)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(HistorialFormaPago historialformapago) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+historialformapago.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=HistorialFormaPagoConstantesFunciones.getHistorialFormaPagoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"historialformapago","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(HistorialFormaPagoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(HistorialFormaPagoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveHistorialFormaPagoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-saveHistorialFormaPagoWithConnection");connexion.begin();			
			
			HistorialFormaPagoLogicAdditional.checkHistorialFormaPagoToSave(this.historialformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			HistorialFormaPagoLogicAdditional.updateHistorialFormaPagoToSave(this.historialformapago,this.arrDatoGeneral);
			
			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.historialformapago,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowHistorialFormaPago();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarHistorialFormaPago(this.historialformapago)) {
				HistorialFormaPagoDataAccess.save(this.historialformapago, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.historialformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			HistorialFormaPagoLogicAdditional.checkHistorialFormaPagoToSaveAfter(this.historialformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowHistorialFormaPago();
			
			connexion.commit();			
			
			if(this.historialformapago.getIsDeleted()) {
				this.historialformapago=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveHistorialFormaPago()throws Exception {	
		try {	
			
			HistorialFormaPagoLogicAdditional.checkHistorialFormaPagoToSave(this.historialformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			HistorialFormaPagoLogicAdditional.updateHistorialFormaPagoToSave(this.historialformapago,this.arrDatoGeneral);
			
			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.historialformapago,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarHistorialFormaPago(this.historialformapago)) {			
				HistorialFormaPagoDataAccess.save(this.historialformapago, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.historialformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			HistorialFormaPagoLogicAdditional.checkHistorialFormaPagoToSaveAfter(this.historialformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.historialformapago.getIsDeleted()) {
				this.historialformapago=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveHistorialFormaPagosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-saveHistorialFormaPagosWithConnection");connexion.begin();			
			
			HistorialFormaPagoLogicAdditional.checkHistorialFormaPagoToSaves(historialformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowHistorialFormaPagos();
			
			Boolean validadoTodosHistorialFormaPago=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(HistorialFormaPago historialformapagoLocal:historialformapagos) {		
				if(historialformapagoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				HistorialFormaPagoLogicAdditional.updateHistorialFormaPagoToSave(historialformapagoLocal,this.arrDatoGeneral);
	        	
				HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),historialformapagoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarHistorialFormaPago(historialformapagoLocal)) {
					HistorialFormaPagoDataAccess.save(historialformapagoLocal, connexion);				
				} else {
					validadoTodosHistorialFormaPago=false;
				}
			}
			
			if(!validadoTodosHistorialFormaPago) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			HistorialFormaPagoLogicAdditional.checkHistorialFormaPagoToSavesAfter(historialformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowHistorialFormaPagos();
			
			connexion.commit();		
			
			this.quitarHistorialFormaPagosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveHistorialFormaPagos()throws Exception {				
		 try {	
			HistorialFormaPagoLogicAdditional.checkHistorialFormaPagoToSaves(historialformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosHistorialFormaPago=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(HistorialFormaPago historialformapagoLocal:historialformapagos) {				
				if(historialformapagoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				HistorialFormaPagoLogicAdditional.updateHistorialFormaPagoToSave(historialformapagoLocal,this.arrDatoGeneral);
	        	
				HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),historialformapagoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarHistorialFormaPago(historialformapagoLocal)) {				
					HistorialFormaPagoDataAccess.save(historialformapagoLocal, connexion);				
				} else {
					validadoTodosHistorialFormaPago=false;
				}
			}
			
			if(!validadoTodosHistorialFormaPago) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			HistorialFormaPagoLogicAdditional.checkHistorialFormaPagoToSavesAfter(historialformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarHistorialFormaPagosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public HistorialFormaPagoParameterReturnGeneral procesarAccionHistorialFormaPagos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<HistorialFormaPago> historialformapagos,HistorialFormaPagoParameterReturnGeneral historialformapagoParameterGeneral)throws Exception {
		 try {	
			HistorialFormaPagoParameterReturnGeneral historialformapagoReturnGeneral=new HistorialFormaPagoParameterReturnGeneral();
	
			HistorialFormaPagoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,historialformapagos,historialformapagoParameterGeneral,historialformapagoReturnGeneral);
			
			return historialformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public HistorialFormaPagoParameterReturnGeneral procesarAccionHistorialFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<HistorialFormaPago> historialformapagos,HistorialFormaPagoParameterReturnGeneral historialformapagoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-procesarAccionHistorialFormaPagosWithConnection");connexion.begin();			
			
			HistorialFormaPagoParameterReturnGeneral historialformapagoReturnGeneral=new HistorialFormaPagoParameterReturnGeneral();
	
			HistorialFormaPagoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,historialformapagos,historialformapagoParameterGeneral,historialformapagoReturnGeneral);
			
			this.connexion.commit();
			
			return historialformapagoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public HistorialFormaPagoParameterReturnGeneral procesarEventosHistorialFormaPagos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<HistorialFormaPago> historialformapagos,HistorialFormaPago historialformapago,HistorialFormaPagoParameterReturnGeneral historialformapagoParameterGeneral,Boolean isEsNuevoHistorialFormaPago,ArrayList<Classe> clases)throws Exception {
		 try {	
			HistorialFormaPagoParameterReturnGeneral historialformapagoReturnGeneral=new HistorialFormaPagoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				historialformapagoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			HistorialFormaPagoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,historialformapagos,historialformapago,historialformapagoParameterGeneral,historialformapagoReturnGeneral,isEsNuevoHistorialFormaPago,clases);
			
			return historialformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public HistorialFormaPagoParameterReturnGeneral procesarEventosHistorialFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<HistorialFormaPago> historialformapagos,HistorialFormaPago historialformapago,HistorialFormaPagoParameterReturnGeneral historialformapagoParameterGeneral,Boolean isEsNuevoHistorialFormaPago,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-procesarEventosHistorialFormaPagosWithConnection");connexion.begin();			
			
			HistorialFormaPagoParameterReturnGeneral historialformapagoReturnGeneral=new HistorialFormaPagoParameterReturnGeneral();
	
			historialformapagoReturnGeneral.setHistorialFormaPago(historialformapago);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				historialformapagoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			HistorialFormaPagoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,historialformapagos,historialformapago,historialformapagoParameterGeneral,historialformapagoReturnGeneral,isEsNuevoHistorialFormaPago,clases);
			
			this.connexion.commit();
			
			return historialformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public HistorialFormaPagoParameterReturnGeneral procesarImportacionHistorialFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,HistorialFormaPagoParameterReturnGeneral historialformapagoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-procesarImportacionHistorialFormaPagosWithConnection");connexion.begin();			
			
			HistorialFormaPagoParameterReturnGeneral historialformapagoReturnGeneral=new HistorialFormaPagoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.historialformapagos=new ArrayList<HistorialFormaPago>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.historialformapago=new HistorialFormaPago();
				
				
				if(conColumnasBase) {this.historialformapago.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.historialformapago.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.historialformapago.setnumero_dias(Integer.parseInt(arrColumnas[iColumn++]));
				this.historialformapago.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.historialformapago.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.historialformapago.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.historialformapago.setporcentaje_retencion(Double.parseDouble(arrColumnas[iColumn++]));
				this.historialformapago.setbase_retencion(Double.parseDouble(arrColumnas[iColumn++]));
				this.historialformapago.setnumero_retencion(Integer.parseInt(arrColumnas[iColumn++]));
			this.historialformapago.setnombre_retencion(arrColumnas[iColumn++]);
				
				this.historialformapagos.add(this.historialformapago);
			}
			
			this.saveHistorialFormaPagos();
			
			this.connexion.commit();
			
			historialformapagoReturnGeneral.setConRetornoEstaProcesado(true);
			historialformapagoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return historialformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarHistorialFormaPagosEliminados() throws Exception {				
		
		List<HistorialFormaPago> historialformapagosAux= new ArrayList<HistorialFormaPago>();
		
		for(HistorialFormaPago historialformapago:historialformapagos) {
			if(!historialformapago.getIsDeleted()) {
				historialformapagosAux.add(historialformapago);
			}
		}
		
		historialformapagos=historialformapagosAux;
	}
	
	public void quitarHistorialFormaPagosNulos() throws Exception {				
		
		List<HistorialFormaPago> historialformapagosAux= new ArrayList<HistorialFormaPago>();
		
		for(HistorialFormaPago historialformapago : this.historialformapagos) {
			if(historialformapago==null) {
				historialformapagosAux.add(historialformapago);
			}
		}
		
		//this.historialformapagos=historialformapagosAux;
		
		this.historialformapagos.removeAll(historialformapagosAux);
	}
	
	public void getSetVersionRowHistorialFormaPagoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(historialformapago.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((historialformapago.getIsDeleted() || (historialformapago.getIsChanged()&&!historialformapago.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=historialformapagoDataAccess.getSetVersionRowHistorialFormaPago(connexion,historialformapago.getId());
				
				if(!historialformapago.getVersionRow().equals(timestamp)) {	
					historialformapago.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				historialformapago.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowHistorialFormaPago()throws Exception {	
		
		if(historialformapago.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((historialformapago.getIsDeleted() || (historialformapago.getIsChanged()&&!historialformapago.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=historialformapagoDataAccess.getSetVersionRowHistorialFormaPago(connexion,historialformapago.getId());
			
			try {							
				if(!historialformapago.getVersionRow().equals(timestamp)) {	
					historialformapago.setVersionRow(timestamp);
				}
				
				historialformapago.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowHistorialFormaPagosWithConnection()throws Exception {	
		if(historialformapagos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(HistorialFormaPago historialformapagoAux:historialformapagos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(historialformapagoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(historialformapagoAux.getIsDeleted() || (historialformapagoAux.getIsChanged()&&!historialformapagoAux.getIsNew())) {
						
						timestamp=historialformapagoDataAccess.getSetVersionRowHistorialFormaPago(connexion,historialformapagoAux.getId());
						
						if(!historialformapago.getVersionRow().equals(timestamp)) {	
							historialformapagoAux.setVersionRow(timestamp);
						}
								
						historialformapagoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowHistorialFormaPagos()throws Exception {	
		if(historialformapagos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(HistorialFormaPago historialformapagoAux:historialformapagos) {
					if(historialformapagoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(historialformapagoAux.getIsDeleted() || (historialformapagoAux.getIsChanged()&&!historialformapagoAux.getIsNew())) {
						
						timestamp=historialformapagoDataAccess.getSetVersionRowHistorialFormaPago(connexion,historialformapagoAux.getId());
						
						if(!historialformapagoAux.getVersionRow().equals(timestamp)) {	
							historialformapagoAux.setVersionRow(timestamp);
						}
						
													
						historialformapagoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public HistorialFormaPagoParameterReturnGeneral cargarCombosLoteForeignKeyHistorialFormaPagoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalFactura,String finalQueryGlobalTipoFormaPago,String finalQueryGlobalCuentaContable,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		HistorialFormaPagoParameterReturnGeneral  historialformapagoReturnGeneral =new HistorialFormaPagoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-cargarCombosLoteForeignKeyHistorialFormaPagoWithConnection");connexion.begin();
			
			historialformapagoReturnGeneral =new HistorialFormaPagoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			historialformapagoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			historialformapagoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			historialformapagoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			historialformapagoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			historialformapagoReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<TipoFormaPago> tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
			TipoFormaPagoLogic tipoformapagoLogic=new TipoFormaPagoLogic();
			tipoformapagoLogic.setConnexion(this.connexion);
			tipoformapagoLogic.getTipoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFormaPago.equals("NONE")) {
				tipoformapagoLogic.getTodosTipoFormaPagos(finalQueryGlobalTipoFormaPago,new Pagination());
				tipoformapagosForeignKey=tipoformapagoLogic.getTipoFormaPagos();
			}

			historialformapagoReturnGeneral.settipoformapagosForeignKey(tipoformapagosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			historialformapagoReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			historialformapagoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			historialformapagoReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return historialformapagoReturnGeneral;
	}
	
	public HistorialFormaPagoParameterReturnGeneral cargarCombosLoteForeignKeyHistorialFormaPago(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalFactura,String finalQueryGlobalTipoFormaPago,String finalQueryGlobalCuentaContable,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		HistorialFormaPagoParameterReturnGeneral  historialformapagoReturnGeneral =new HistorialFormaPagoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			historialformapagoReturnGeneral =new HistorialFormaPagoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			historialformapagoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			historialformapagoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			historialformapagoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			historialformapagoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			historialformapagoReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<TipoFormaPago> tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
			TipoFormaPagoLogic tipoformapagoLogic=new TipoFormaPagoLogic();
			tipoformapagoLogic.setConnexion(this.connexion);
			tipoformapagoLogic.getTipoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFormaPago.equals("NONE")) {
				tipoformapagoLogic.getTodosTipoFormaPagos(finalQueryGlobalTipoFormaPago,new Pagination());
				tipoformapagosForeignKey=tipoformapagoLogic.getTipoFormaPagos();
			}

			historialformapagoReturnGeneral.settipoformapagosForeignKey(tipoformapagosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			historialformapagoReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			historialformapagoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			historialformapagoReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return historialformapagoReturnGeneral;
	}
	
	
	public void deepLoad(HistorialFormaPago historialformapago,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			HistorialFormaPagoLogicAdditional.updateHistorialFormaPagoToGet(historialformapago,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		historialformapago.setEmpresa(historialformapagoDataAccess.getEmpresa(connexion,historialformapago));
		historialformapago.setSucursal(historialformapagoDataAccess.getSucursal(connexion,historialformapago));
		historialformapago.setEjercicio(historialformapagoDataAccess.getEjercicio(connexion,historialformapago));
		historialformapago.setPeriodo(historialformapagoDataAccess.getPeriodo(connexion,historialformapago));
		historialformapago.setFactura(historialformapagoDataAccess.getFactura(connexion,historialformapago));
		historialformapago.setTipoFormaPago(historialformapagoDataAccess.getTipoFormaPago(connexion,historialformapago));
		historialformapago.setCuentaContable(historialformapagoDataAccess.getCuentaContable(connexion,historialformapago));
		historialformapago.setAnio(historialformapagoDataAccess.getAnio(connexion,historialformapago));
		historialformapago.setMes(historialformapagoDataAccess.getMes(connexion,historialformapago));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				historialformapago.setEmpresa(historialformapagoDataAccess.getEmpresa(connexion,historialformapago));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				historialformapago.setSucursal(historialformapagoDataAccess.getSucursal(connexion,historialformapago));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				historialformapago.setEjercicio(historialformapagoDataAccess.getEjercicio(connexion,historialformapago));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				historialformapago.setPeriodo(historialformapagoDataAccess.getPeriodo(connexion,historialformapago));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				historialformapago.setFactura(historialformapagoDataAccess.getFactura(connexion,historialformapago));
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				historialformapago.setTipoFormaPago(historialformapagoDataAccess.getTipoFormaPago(connexion,historialformapago));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				historialformapago.setCuentaContable(historialformapagoDataAccess.getCuentaContable(connexion,historialformapago));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				historialformapago.setAnio(historialformapagoDataAccess.getAnio(connexion,historialformapago));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				historialformapago.setMes(historialformapagoDataAccess.getMes(connexion,historialformapago));
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
			historialformapago.setEmpresa(historialformapagoDataAccess.getEmpresa(connexion,historialformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialformapago.setSucursal(historialformapagoDataAccess.getSucursal(connexion,historialformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialformapago.setEjercicio(historialformapagoDataAccess.getEjercicio(connexion,historialformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialformapago.setPeriodo(historialformapagoDataAccess.getPeriodo(connexion,historialformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialformapago.setFactura(historialformapagoDataAccess.getFactura(connexion,historialformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialformapago.setTipoFormaPago(historialformapagoDataAccess.getTipoFormaPago(connexion,historialformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialformapago.setCuentaContable(historialformapagoDataAccess.getCuentaContable(connexion,historialformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialformapago.setAnio(historialformapagoDataAccess.getAnio(connexion,historialformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialformapago.setMes(historialformapagoDataAccess.getMes(connexion,historialformapago));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		historialformapago.setEmpresa(historialformapagoDataAccess.getEmpresa(connexion,historialformapago));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(historialformapago.getEmpresa(),isDeep,deepLoadType,clases);
				
		historialformapago.setSucursal(historialformapagoDataAccess.getSucursal(connexion,historialformapago));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(historialformapago.getSucursal(),isDeep,deepLoadType,clases);
				
		historialformapago.setEjercicio(historialformapagoDataAccess.getEjercicio(connexion,historialformapago));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(historialformapago.getEjercicio(),isDeep,deepLoadType,clases);
				
		historialformapago.setPeriodo(historialformapagoDataAccess.getPeriodo(connexion,historialformapago));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(historialformapago.getPeriodo(),isDeep,deepLoadType,clases);
				
		historialformapago.setFactura(historialformapagoDataAccess.getFactura(connexion,historialformapago));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(historialformapago.getFactura(),isDeep,deepLoadType,clases);
				
		historialformapago.setTipoFormaPago(historialformapagoDataAccess.getTipoFormaPago(connexion,historialformapago));
		TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
		tipoformapagoLogic.deepLoad(historialformapago.getTipoFormaPago(),isDeep,deepLoadType,clases);
				
		historialformapago.setCuentaContable(historialformapagoDataAccess.getCuentaContable(connexion,historialformapago));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(historialformapago.getCuentaContable(),isDeep,deepLoadType,clases);
				
		historialformapago.setAnio(historialformapagoDataAccess.getAnio(connexion,historialformapago));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(historialformapago.getAnio(),isDeep,deepLoadType,clases);
				
		historialformapago.setMes(historialformapagoDataAccess.getMes(connexion,historialformapago));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(historialformapago.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				historialformapago.setEmpresa(historialformapagoDataAccess.getEmpresa(connexion,historialformapago));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(historialformapago.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				historialformapago.setSucursal(historialformapagoDataAccess.getSucursal(connexion,historialformapago));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(historialformapago.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				historialformapago.setEjercicio(historialformapagoDataAccess.getEjercicio(connexion,historialformapago));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(historialformapago.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				historialformapago.setPeriodo(historialformapagoDataAccess.getPeriodo(connexion,historialformapago));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(historialformapago.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				historialformapago.setFactura(historialformapagoDataAccess.getFactura(connexion,historialformapago));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(historialformapago.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				historialformapago.setTipoFormaPago(historialformapagoDataAccess.getTipoFormaPago(connexion,historialformapago));
				TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
				tipoformapagoLogic.deepLoad(historialformapago.getTipoFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				historialformapago.setCuentaContable(historialformapagoDataAccess.getCuentaContable(connexion,historialformapago));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(historialformapago.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				historialformapago.setAnio(historialformapagoDataAccess.getAnio(connexion,historialformapago));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(historialformapago.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				historialformapago.setMes(historialformapagoDataAccess.getMes(connexion,historialformapago));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(historialformapago.getMes(),isDeep,deepLoadType,clases);				
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
			historialformapago.setEmpresa(historialformapagoDataAccess.getEmpresa(connexion,historialformapago));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(historialformapago.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialformapago.setSucursal(historialformapagoDataAccess.getSucursal(connexion,historialformapago));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(historialformapago.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialformapago.setEjercicio(historialformapagoDataAccess.getEjercicio(connexion,historialformapago));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(historialformapago.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialformapago.setPeriodo(historialformapagoDataAccess.getPeriodo(connexion,historialformapago));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(historialformapago.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialformapago.setFactura(historialformapagoDataAccess.getFactura(connexion,historialformapago));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(historialformapago.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialformapago.setTipoFormaPago(historialformapagoDataAccess.getTipoFormaPago(connexion,historialformapago));
			TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
			tipoformapagoLogic.deepLoad(historialformapago.getTipoFormaPago(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialformapago.setCuentaContable(historialformapagoDataAccess.getCuentaContable(connexion,historialformapago));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(historialformapago.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialformapago.setAnio(historialformapagoDataAccess.getAnio(connexion,historialformapago));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(historialformapago.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			historialformapago.setMes(historialformapagoDataAccess.getMes(connexion,historialformapago));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(historialformapago.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(HistorialFormaPago historialformapago,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			HistorialFormaPagoLogicAdditional.updateHistorialFormaPagoToSave(historialformapago,this.arrDatoGeneral);
			
HistorialFormaPagoDataAccess.save(historialformapago, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(historialformapago.getEmpresa(),connexion);

		SucursalDataAccess.save(historialformapago.getSucursal(),connexion);

		EjercicioDataAccess.save(historialformapago.getEjercicio(),connexion);

		PeriodoDataAccess.save(historialformapago.getPeriodo(),connexion);

		FacturaDataAccess.save(historialformapago.getFactura(),connexion);

		TipoFormaPagoDataAccess.save(historialformapago.getTipoFormaPago(),connexion);

		CuentaContableDataAccess.save(historialformapago.getCuentaContable(),connexion);

		AnioDataAccess.save(historialformapago.getAnio(),connexion);

		MesDataAccess.save(historialformapago.getMes(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(historialformapago.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(historialformapago.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(historialformapago.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(historialformapago.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(historialformapago.getFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				TipoFormaPagoDataAccess.save(historialformapago.getTipoFormaPago(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(historialformapago.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(historialformapago.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(historialformapago.getMes(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(historialformapago.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(historialformapago.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(historialformapago.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(historialformapago.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(historialformapago.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(historialformapago.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(historialformapago.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(historialformapago.getPeriodo(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(historialformapago.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(historialformapago.getFactura(),isDeep,deepLoadType,clases);
				

		TipoFormaPagoDataAccess.save(historialformapago.getTipoFormaPago(),connexion);
		TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
		tipoformapagoLogic.deepLoad(historialformapago.getTipoFormaPago(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(historialformapago.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(historialformapago.getCuentaContable(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(historialformapago.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(historialformapago.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(historialformapago.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(historialformapago.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(historialformapago.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(historialformapago.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(historialformapago.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(historialformapago.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(historialformapago.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(historialformapago.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(historialformapago.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(historialformapago.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(historialformapago.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(historialformapago.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				TipoFormaPagoDataAccess.save(historialformapago.getTipoFormaPago(),connexion);
				TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
				tipoformapagoLogic.deepSave(historialformapago.getTipoFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(historialformapago.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(historialformapago.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(historialformapago.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(historialformapago.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(historialformapago.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(historialformapago.getMes(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(HistorialFormaPago.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(historialformapago,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(historialformapago);
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
			this.deepLoad(this.historialformapago,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(HistorialFormaPago.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(historialformapagos!=null) {
				for(HistorialFormaPago historialformapago:historialformapagos) {
					this.deepLoad(historialformapago,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(historialformapagos);
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
			if(historialformapagos!=null) {
				for(HistorialFormaPago historialformapago:historialformapagos) {
					this.deepLoad(historialformapago,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(historialformapagos);
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
			this.getNewConnexionToDeep(HistorialFormaPago.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(historialformapago,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(HistorialFormaPago.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(historialformapagos!=null) {
				for(HistorialFormaPago historialformapago:historialformapagos) {
					this.deepSave(historialformapago,isDeep,deepLoadType,clases);
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
			if(historialformapagos!=null) {
				for(HistorialFormaPago historialformapago:historialformapagos) {
					this.deepSave(historialformapago,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getHistorialFormaPagosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,HistorialFormaPagoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagos=historialformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialFormaPagosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,HistorialFormaPagoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagos=historialformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHistorialFormaPagosFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,HistorialFormaPagoConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagos=historialformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialFormaPagosFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,HistorialFormaPagoConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagos=historialformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHistorialFormaPagosFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,HistorialFormaPagoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagos=historialformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialFormaPagosFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,HistorialFormaPagoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagos=historialformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHistorialFormaPagosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,HistorialFormaPagoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagos=historialformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialFormaPagosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,HistorialFormaPagoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagos=historialformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHistorialFormaPagosFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,HistorialFormaPagoConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagos=historialformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialFormaPagosFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,HistorialFormaPagoConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagos=historialformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHistorialFormaPagosFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,HistorialFormaPagoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagos=historialformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialFormaPagosFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,HistorialFormaPagoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagos=historialformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHistorialFormaPagosFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,HistorialFormaPagoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagos=historialformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialFormaPagosFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,HistorialFormaPagoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagos=historialformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHistorialFormaPagosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,HistorialFormaPagoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagos=historialformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialFormaPagosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,HistorialFormaPagoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagos=historialformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHistorialFormaPagosFK_IdTipoFormaPagoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_forma_pago)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HistorialFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_forma_pago,HistorialFormaPagoConstantesFunciones.IDTIPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFormaPago);

			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagos=historialformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHistorialFormaPagosFK_IdTipoFormaPago(String sFinalQuery,Pagination pagination,Long id_tipo_forma_pago)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_forma_pago,HistorialFormaPagoConstantesFunciones.IDTIPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFormaPago);

			HistorialFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			historialformapagos=historialformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HistorialFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesHistorialFormaPago(this.historialformapagos);
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
			if(HistorialFormaPagoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,HistorialFormaPagoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,HistorialFormaPago historialformapago,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(HistorialFormaPagoConstantesFunciones.ISCONAUDITORIA) {
				if(historialformapago.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HistorialFormaPagoDataAccess.TABLENAME, historialformapago.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(HistorialFormaPagoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////HistorialFormaPagoLogic.registrarAuditoriaDetallesHistorialFormaPago(connexion,historialformapago,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(historialformapago.getIsDeleted()) {
					/*if(!historialformapago.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,HistorialFormaPagoDataAccess.TABLENAME, historialformapago.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////HistorialFormaPagoLogic.registrarAuditoriaDetallesHistorialFormaPago(connexion,historialformapago,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HistorialFormaPagoDataAccess.TABLENAME, historialformapago.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(historialformapago.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HistorialFormaPagoDataAccess.TABLENAME, historialformapago.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(HistorialFormaPagoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////HistorialFormaPagoLogic.registrarAuditoriaDetallesHistorialFormaPago(connexion,historialformapago,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesHistorialFormaPago(Connexion connexion,HistorialFormaPago historialformapago)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(historialformapago.getIsNew()||!historialformapago.getid_empresa().equals(historialformapago.getHistorialFormaPagoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialformapago.getHistorialFormaPagoOriginal().getid_empresa()!=null)
				{
					strValorActual=historialformapago.getHistorialFormaPagoOriginal().getid_empresa().toString();
				}
				if(historialformapago.getid_empresa()!=null)
				{
					strValorNuevo=historialformapago.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialFormaPagoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(historialformapago.getIsNew()||!historialformapago.getid_sucursal().equals(historialformapago.getHistorialFormaPagoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialformapago.getHistorialFormaPagoOriginal().getid_sucursal()!=null)
				{
					strValorActual=historialformapago.getHistorialFormaPagoOriginal().getid_sucursal().toString();
				}
				if(historialformapago.getid_sucursal()!=null)
				{
					strValorNuevo=historialformapago.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialFormaPagoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(historialformapago.getIsNew()||!historialformapago.getid_ejercicio().equals(historialformapago.getHistorialFormaPagoOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialformapago.getHistorialFormaPagoOriginal().getid_ejercicio()!=null)
				{
					strValorActual=historialformapago.getHistorialFormaPagoOriginal().getid_ejercicio().toString();
				}
				if(historialformapago.getid_ejercicio()!=null)
				{
					strValorNuevo=historialformapago.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialFormaPagoConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(historialformapago.getIsNew()||!historialformapago.getid_periodo().equals(historialformapago.getHistorialFormaPagoOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialformapago.getHistorialFormaPagoOriginal().getid_periodo()!=null)
				{
					strValorActual=historialformapago.getHistorialFormaPagoOriginal().getid_periodo().toString();
				}
				if(historialformapago.getid_periodo()!=null)
				{
					strValorNuevo=historialformapago.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialFormaPagoConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(historialformapago.getIsNew()||!historialformapago.getid_factura().equals(historialformapago.getHistorialFormaPagoOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialformapago.getHistorialFormaPagoOriginal().getid_factura()!=null)
				{
					strValorActual=historialformapago.getHistorialFormaPagoOriginal().getid_factura().toString();
				}
				if(historialformapago.getid_factura()!=null)
				{
					strValorNuevo=historialformapago.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialFormaPagoConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(historialformapago.getIsNew()||!historialformapago.getid_tipo_forma_pago().equals(historialformapago.getHistorialFormaPagoOriginal().getid_tipo_forma_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialformapago.getHistorialFormaPagoOriginal().getid_tipo_forma_pago()!=null)
				{
					strValorActual=historialformapago.getHistorialFormaPagoOriginal().getid_tipo_forma_pago().toString();
				}
				if(historialformapago.getid_tipo_forma_pago()!=null)
				{
					strValorNuevo=historialformapago.getid_tipo_forma_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialFormaPagoConstantesFunciones.IDTIPOFORMAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(historialformapago.getIsNew()||!historialformapago.getid_cuenta_contable().equals(historialformapago.getHistorialFormaPagoOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialformapago.getHistorialFormaPagoOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=historialformapago.getHistorialFormaPagoOriginal().getid_cuenta_contable().toString();
				}
				if(historialformapago.getid_cuenta_contable()!=null)
				{
					strValorNuevo=historialformapago.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialFormaPagoConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(historialformapago.getIsNew()||!historialformapago.getnumero_dias().equals(historialformapago.getHistorialFormaPagoOriginal().getnumero_dias()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialformapago.getHistorialFormaPagoOriginal().getnumero_dias()!=null)
				{
					strValorActual=historialformapago.getHistorialFormaPagoOriginal().getnumero_dias().toString();
				}
				if(historialformapago.getnumero_dias()!=null)
				{
					strValorNuevo=historialformapago.getnumero_dias().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialFormaPagoConstantesFunciones.NUMERODIAS,strValorActual,strValorNuevo);
			}	
			
			if(historialformapago.getIsNew()||!historialformapago.getvalor().equals(historialformapago.getHistorialFormaPagoOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialformapago.getHistorialFormaPagoOriginal().getvalor()!=null)
				{
					strValorActual=historialformapago.getHistorialFormaPagoOriginal().getvalor().toString();
				}
				if(historialformapago.getvalor()!=null)
				{
					strValorNuevo=historialformapago.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialFormaPagoConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(historialformapago.getIsNew()||!historialformapago.getfecha().equals(historialformapago.getHistorialFormaPagoOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialformapago.getHistorialFormaPagoOriginal().getfecha()!=null)
				{
					strValorActual=historialformapago.getHistorialFormaPagoOriginal().getfecha().toString();
				}
				if(historialformapago.getfecha()!=null)
				{
					strValorNuevo=historialformapago.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialFormaPagoConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(historialformapago.getIsNew()||!historialformapago.getporcentaje().equals(historialformapago.getHistorialFormaPagoOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialformapago.getHistorialFormaPagoOriginal().getporcentaje()!=null)
				{
					strValorActual=historialformapago.getHistorialFormaPagoOriginal().getporcentaje().toString();
				}
				if(historialformapago.getporcentaje()!=null)
				{
					strValorNuevo=historialformapago.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialFormaPagoConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(historialformapago.getIsNew()||!historialformapago.getporcentaje_retencion().equals(historialformapago.getHistorialFormaPagoOriginal().getporcentaje_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialformapago.getHistorialFormaPagoOriginal().getporcentaje_retencion()!=null)
				{
					strValorActual=historialformapago.getHistorialFormaPagoOriginal().getporcentaje_retencion().toString();
				}
				if(historialformapago.getporcentaje_retencion()!=null)
				{
					strValorNuevo=historialformapago.getporcentaje_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialFormaPagoConstantesFunciones.PORCENTAJERETENCION,strValorActual,strValorNuevo);
			}	
			
			if(historialformapago.getIsNew()||!historialformapago.getbase_retencion().equals(historialformapago.getHistorialFormaPagoOriginal().getbase_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialformapago.getHistorialFormaPagoOriginal().getbase_retencion()!=null)
				{
					strValorActual=historialformapago.getHistorialFormaPagoOriginal().getbase_retencion().toString();
				}
				if(historialformapago.getbase_retencion()!=null)
				{
					strValorNuevo=historialformapago.getbase_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialFormaPagoConstantesFunciones.BASERETENCION,strValorActual,strValorNuevo);
			}	
			
			if(historialformapago.getIsNew()||!historialformapago.getnumero_retencion().equals(historialformapago.getHistorialFormaPagoOriginal().getnumero_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialformapago.getHistorialFormaPagoOriginal().getnumero_retencion()!=null)
				{
					strValorActual=historialformapago.getHistorialFormaPagoOriginal().getnumero_retencion().toString();
				}
				if(historialformapago.getnumero_retencion()!=null)
				{
					strValorNuevo=historialformapago.getnumero_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialFormaPagoConstantesFunciones.NUMERORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(historialformapago.getIsNew()||!historialformapago.getnombre_retencion().equals(historialformapago.getHistorialFormaPagoOriginal().getnombre_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialformapago.getHistorialFormaPagoOriginal().getnombre_retencion()!=null)
				{
					strValorActual=historialformapago.getHistorialFormaPagoOriginal().getnombre_retencion();
				}
				if(historialformapago.getnombre_retencion()!=null)
				{
					strValorNuevo=historialformapago.getnombre_retencion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialFormaPagoConstantesFunciones.NOMBRERETENCION,strValorActual,strValorNuevo);
			}	
			
			if(historialformapago.getIsNew()||!historialformapago.getid_anio().equals(historialformapago.getHistorialFormaPagoOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialformapago.getHistorialFormaPagoOriginal().getid_anio()!=null)
				{
					strValorActual=historialformapago.getHistorialFormaPagoOriginal().getid_anio().toString();
				}
				if(historialformapago.getid_anio()!=null)
				{
					strValorNuevo=historialformapago.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialFormaPagoConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(historialformapago.getIsNew()||!historialformapago.getid_mes().equals(historialformapago.getHistorialFormaPagoOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(historialformapago.getHistorialFormaPagoOriginal().getid_mes()!=null)
				{
					strValorActual=historialformapago.getHistorialFormaPagoOriginal().getid_mes().toString();
				}
				if(historialformapago.getid_mes()!=null)
				{
					strValorNuevo=historialformapago.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HistorialFormaPagoConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveHistorialFormaPagoRelacionesWithConnection(HistorialFormaPago historialformapago) throws Exception {

		if(!historialformapago.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveHistorialFormaPagoRelacionesBase(historialformapago,true);
		}
	}

	public void saveHistorialFormaPagoRelaciones(HistorialFormaPago historialformapago)throws Exception {

		if(!historialformapago.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveHistorialFormaPagoRelacionesBase(historialformapago,false);
		}
	}

	public void saveHistorialFormaPagoRelacionesBase(HistorialFormaPago historialformapago,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("HistorialFormaPago-saveRelacionesWithConnection");}
	

			this.setHistorialFormaPago(historialformapago);

			if(HistorialFormaPagoLogicAdditional.validarSaveRelaciones(historialformapago,this)) {

				HistorialFormaPagoLogicAdditional.updateRelacionesToSave(historialformapago,this);

				if((historialformapago.getIsNew()||historialformapago.getIsChanged())&&!historialformapago.getIsDeleted()) {
					this.saveHistorialFormaPago();
					this.saveHistorialFormaPagoRelacionesDetalles();

				} else if(historialformapago.getIsDeleted()) {
					this.saveHistorialFormaPagoRelacionesDetalles();
					this.saveHistorialFormaPago();
				}

				HistorialFormaPagoLogicAdditional.updateRelacionesToSaveAfter(historialformapago,this);

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
	
	
	private void saveHistorialFormaPagoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfHistorialFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=HistorialFormaPagoConstantesFunciones.getClassesForeignKeysOfHistorialFormaPago(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfHistorialFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=HistorialFormaPagoConstantesFunciones.getClassesRelationshipsOfHistorialFormaPago(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

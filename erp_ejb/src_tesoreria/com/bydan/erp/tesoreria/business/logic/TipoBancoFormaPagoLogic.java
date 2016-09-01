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
import com.bydan.erp.tesoreria.util.TipoBancoFormaPagoConstantesFunciones;
import com.bydan.erp.tesoreria.util.TipoBancoFormaPagoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TipoBancoFormaPagoParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.TipoBancoFormaPago;
import com.bydan.erp.tesoreria.business.logic.TipoBancoFormaPagoLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoBancoFormaPagoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoBancoFormaPagoLogic.class);
	
	protected TipoBancoFormaPagoDataAccess tipobancoformapagoDataAccess; 	
	protected TipoBancoFormaPago tipobancoformapago;
	protected List<TipoBancoFormaPago> tipobancoformapagos;
	protected Object tipobancoformapagoObject;	
	protected List<Object> tipobancoformapagosObject;
	
	public static ClassValidator<TipoBancoFormaPago> tipobancoformapagoValidator = new ClassValidator<TipoBancoFormaPago>(TipoBancoFormaPago.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoBancoFormaPagoLogicAdditional tipobancoformapagoLogicAdditional=null;
	
	public TipoBancoFormaPagoLogicAdditional getTipoBancoFormaPagoLogicAdditional() {
		return this.tipobancoformapagoLogicAdditional;
	}
	
	public void setTipoBancoFormaPagoLogicAdditional(TipoBancoFormaPagoLogicAdditional tipobancoformapagoLogicAdditional) {
		try {
			this.tipobancoformapagoLogicAdditional=tipobancoformapagoLogicAdditional;
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
	
	
	
	
	public  TipoBancoFormaPagoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipobancoformapagoDataAccess = new TipoBancoFormaPagoDataAccess();
			
			this.tipobancoformapagos= new ArrayList<TipoBancoFormaPago>();
			this.tipobancoformapago= new TipoBancoFormaPago();
			
			this.tipobancoformapagoObject=new Object();
			this.tipobancoformapagosObject=new ArrayList<Object>();
				
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
			
			this.tipobancoformapagoDataAccess.setConnexionType(this.connexionType);
			this.tipobancoformapagoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoBancoFormaPagoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipobancoformapagoDataAccess = new TipoBancoFormaPagoDataAccess();
			this.tipobancoformapagos= new ArrayList<TipoBancoFormaPago>();
			this.tipobancoformapago= new TipoBancoFormaPago();
			this.tipobancoformapagoObject=new Object();
			this.tipobancoformapagosObject=new ArrayList<Object>();
			
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
			
			this.tipobancoformapagoDataAccess.setConnexionType(this.connexionType);
			this.tipobancoformapagoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoBancoFormaPago getTipoBancoFormaPago() throws Exception {	
		TipoBancoFormaPagoLogicAdditional.checkTipoBancoFormaPagoToGet(tipobancoformapago,this.datosCliente,this.arrDatoGeneral);
		TipoBancoFormaPagoLogicAdditional.updateTipoBancoFormaPagoToGet(tipobancoformapago,this.arrDatoGeneral);
		
		return tipobancoformapago;
	}
		
	public void setTipoBancoFormaPago(TipoBancoFormaPago newTipoBancoFormaPago) {
		this.tipobancoformapago = newTipoBancoFormaPago;
	}
	
	public TipoBancoFormaPagoDataAccess getTipoBancoFormaPagoDataAccess() {
		return tipobancoformapagoDataAccess;
	}
	
	public void setTipoBancoFormaPagoDataAccess(TipoBancoFormaPagoDataAccess newtipobancoformapagoDataAccess) {
		this.tipobancoformapagoDataAccess = newtipobancoformapagoDataAccess;
	}
	
	public List<TipoBancoFormaPago> getTipoBancoFormaPagos() throws Exception {		
		this.quitarTipoBancoFormaPagosNulos();
		
		TipoBancoFormaPagoLogicAdditional.checkTipoBancoFormaPagoToGets(tipobancoformapagos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoBancoFormaPago tipobancoformapagoLocal: tipobancoformapagos ) {
			TipoBancoFormaPagoLogicAdditional.updateTipoBancoFormaPagoToGet(tipobancoformapagoLocal,this.arrDatoGeneral);
		}
		
		return tipobancoformapagos;
	}
	
	public void setTipoBancoFormaPagos(List<TipoBancoFormaPago> newTipoBancoFormaPagos) {
		this.tipobancoformapagos = newTipoBancoFormaPagos;
	}
	
	public Object getTipoBancoFormaPagoObject() {	
		this.tipobancoformapagoObject=this.tipobancoformapagoDataAccess.getEntityObject();
		return this.tipobancoformapagoObject;
	}
		
	public void setTipoBancoFormaPagoObject(Object newTipoBancoFormaPagoObject) {
		this.tipobancoformapagoObject = newTipoBancoFormaPagoObject;
	}
	
	public List<Object> getTipoBancoFormaPagosObject() {		
		this.tipobancoformapagosObject=this.tipobancoformapagoDataAccess.getEntitiesObject();
		return this.tipobancoformapagosObject;
	}
		
	public void setTipoBancoFormaPagosObject(List<Object> newTipoBancoFormaPagosObject) {
		this.tipobancoformapagosObject = newTipoBancoFormaPagosObject;
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
		
		if(this.tipobancoformapagoDataAccess!=null) {
			this.tipobancoformapagoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoFormaPago.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipobancoformapagoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipobancoformapagoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipobancoformapago = new  TipoBancoFormaPago();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoFormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipobancoformapago=tipobancoformapagoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipobancoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoBancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoFormaPago(this.tipobancoformapago);
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
		tipobancoformapago = new  TipoBancoFormaPago();
		  		  
        try {
			
			tipobancoformapago=tipobancoformapagoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipobancoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoBancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoFormaPago(this.tipobancoformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipobancoformapago = new  TipoBancoFormaPago();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoFormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipobancoformapago=tipobancoformapagoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipobancoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoBancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoFormaPago(this.tipobancoformapago);
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
		tipobancoformapago = new  TipoBancoFormaPago();
		  		  
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
		tipobancoformapago = new  TipoBancoFormaPago();
		  		  
        try {
			
			tipobancoformapago=tipobancoformapagoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipobancoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoBancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoFormaPago(this.tipobancoformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipobancoformapago = new  TipoBancoFormaPago();
		  		  
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
		tipobancoformapago = new  TipoBancoFormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoFormaPago.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipobancoformapagoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipobancoformapago = new  TipoBancoFormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipobancoformapagoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipobancoformapago = new  TipoBancoFormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoFormaPago.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipobancoformapagoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipobancoformapago = new  TipoBancoFormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipobancoformapagoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipobancoformapago = new  TipoBancoFormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoFormaPago.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipobancoformapagoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipobancoformapago = new  TipoBancoFormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipobancoformapagoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipobancoformapagos = new  ArrayList<TipoBancoFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoFormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoBancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoformapagos=tipobancoformapagoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoBancoFormaPago(tipobancoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoFormaPago(this.tipobancoformapagos);
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
		tipobancoformapagos = new  ArrayList<TipoBancoFormaPago>();
		  		  
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
		tipobancoformapagos = new  ArrayList<TipoBancoFormaPago>();
		  		  
        try {			
			TipoBancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoformapagos=tipobancoformapagoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoBancoFormaPago(tipobancoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoFormaPago(this.tipobancoformapagos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipobancoformapagos = new  ArrayList<TipoBancoFormaPago>();
		  		  
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
		tipobancoformapagos = new  ArrayList<TipoBancoFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoFormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoBancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoformapagos=tipobancoformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoBancoFormaPago(tipobancoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoFormaPago(this.tipobancoformapagos);
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
		tipobancoformapagos = new  ArrayList<TipoBancoFormaPago>();
		  		  
        try {
			TipoBancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoformapagos=tipobancoformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoBancoFormaPago(tipobancoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoFormaPago(this.tipobancoformapagos);
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
		tipobancoformapagos = new  ArrayList<TipoBancoFormaPago>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoFormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoBancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoformapagos=tipobancoformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoBancoFormaPago(tipobancoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoFormaPago(this.tipobancoformapagos);
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
		tipobancoformapagos = new  ArrayList<TipoBancoFormaPago>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoBancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoformapagos=tipobancoformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoBancoFormaPago(tipobancoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoFormaPago(this.tipobancoformapagos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipobancoformapago = new  TipoBancoFormaPago();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoFormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoBancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoformapago=tipobancoformapagoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoBancoFormaPago(tipobancoformapago);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoFormaPago(this.tipobancoformapago);
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
		tipobancoformapago = new  TipoBancoFormaPago();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoBancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoformapago=tipobancoformapagoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoBancoFormaPago(tipobancoformapago);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoFormaPago(this.tipobancoformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipobancoformapagos = new  ArrayList<TipoBancoFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoFormaPago.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoBancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoformapagos=tipobancoformapagoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoBancoFormaPago(tipobancoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoFormaPago(this.tipobancoformapagos);
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
		tipobancoformapagos = new  ArrayList<TipoBancoFormaPago>();
		  		  
        try {
			TipoBancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoformapagos=tipobancoformapagoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoBancoFormaPago(tipobancoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoFormaPago(this.tipobancoformapagos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoBancoFormaPagosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipobancoformapagos = new  ArrayList<TipoBancoFormaPago>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoFormaPago.class.getSimpleName()+"-getTodosTipoBancoFormaPagosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoBancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoformapagos=tipobancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoBancoFormaPago(tipobancoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoFormaPago(this.tipobancoformapagos);
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
	
	public  void  getTodosTipoBancoFormaPagos(String sFinalQuery,Pagination pagination)throws Exception {
		tipobancoformapagos = new  ArrayList<TipoBancoFormaPago>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoBancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipobancoformapagos=tipobancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoBancoFormaPago(tipobancoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoBancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoFormaPago(this.tipobancoformapagos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoBancoFormaPago(TipoBancoFormaPago tipobancoformapago) throws Exception {
		Boolean estaValidado=false;
		
		if(tipobancoformapago.getIsNew() || tipobancoformapago.getIsChanged()) { 
			this.invalidValues = tipobancoformapagoValidator.getInvalidValues(tipobancoformapago);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipobancoformapago);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoBancoFormaPago(List<TipoBancoFormaPago> TipoBancoFormaPagos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoBancoFormaPago tipobancoformapagoLocal:tipobancoformapagos) {				
			estaValidadoObjeto=this.validarGuardarTipoBancoFormaPago(tipobancoformapagoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoBancoFormaPago(List<TipoBancoFormaPago> TipoBancoFormaPagos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoBancoFormaPago(tipobancoformapagos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoBancoFormaPago(TipoBancoFormaPago TipoBancoFormaPago) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoBancoFormaPago(tipobancoformapago)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoBancoFormaPago tipobancoformapago) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipobancoformapago.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoBancoFormaPagoConstantesFunciones.getTipoBancoFormaPagoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipobancoformapago","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoBancoFormaPagoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoBancoFormaPagoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoBancoFormaPagoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoFormaPago.class.getSimpleName()+"-saveTipoBancoFormaPagoWithConnection");connexion.begin();			
			
			TipoBancoFormaPagoLogicAdditional.checkTipoBancoFormaPagoToSave(this.tipobancoformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoBancoFormaPagoLogicAdditional.updateTipoBancoFormaPagoToSave(this.tipobancoformapago,this.arrDatoGeneral);
			
			TipoBancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipobancoformapago,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoBancoFormaPago();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoBancoFormaPago(this.tipobancoformapago)) {
				TipoBancoFormaPagoDataAccess.save(this.tipobancoformapago, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipobancoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoBancoFormaPagoLogicAdditional.checkTipoBancoFormaPagoToSaveAfter(this.tipobancoformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoBancoFormaPago();
			
			connexion.commit();			
			
			if(this.tipobancoformapago.getIsDeleted()) {
				this.tipobancoformapago=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoBancoFormaPago()throws Exception {	
		try {	
			
			TipoBancoFormaPagoLogicAdditional.checkTipoBancoFormaPagoToSave(this.tipobancoformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoBancoFormaPagoLogicAdditional.updateTipoBancoFormaPagoToSave(this.tipobancoformapago,this.arrDatoGeneral);
			
			TipoBancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipobancoformapago,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoBancoFormaPago(this.tipobancoformapago)) {			
				TipoBancoFormaPagoDataAccess.save(this.tipobancoformapago, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipobancoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoBancoFormaPagoLogicAdditional.checkTipoBancoFormaPagoToSaveAfter(this.tipobancoformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipobancoformapago.getIsDeleted()) {
				this.tipobancoformapago=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoBancoFormaPagosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoFormaPago.class.getSimpleName()+"-saveTipoBancoFormaPagosWithConnection");connexion.begin();			
			
			TipoBancoFormaPagoLogicAdditional.checkTipoBancoFormaPagoToSaves(tipobancoformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoBancoFormaPagos();
			
			Boolean validadoTodosTipoBancoFormaPago=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoBancoFormaPago tipobancoformapagoLocal:tipobancoformapagos) {		
				if(tipobancoformapagoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoBancoFormaPagoLogicAdditional.updateTipoBancoFormaPagoToSave(tipobancoformapagoLocal,this.arrDatoGeneral);
	        	
				TipoBancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipobancoformapagoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoBancoFormaPago(tipobancoformapagoLocal)) {
					TipoBancoFormaPagoDataAccess.save(tipobancoformapagoLocal, connexion);				
				} else {
					validadoTodosTipoBancoFormaPago=false;
				}
			}
			
			if(!validadoTodosTipoBancoFormaPago) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoBancoFormaPagoLogicAdditional.checkTipoBancoFormaPagoToSavesAfter(tipobancoformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoBancoFormaPagos();
			
			connexion.commit();		
			
			this.quitarTipoBancoFormaPagosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoBancoFormaPagos()throws Exception {				
		 try {	
			TipoBancoFormaPagoLogicAdditional.checkTipoBancoFormaPagoToSaves(tipobancoformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoBancoFormaPago=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoBancoFormaPago tipobancoformapagoLocal:tipobancoformapagos) {				
				if(tipobancoformapagoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoBancoFormaPagoLogicAdditional.updateTipoBancoFormaPagoToSave(tipobancoformapagoLocal,this.arrDatoGeneral);
	        	
				TipoBancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipobancoformapagoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoBancoFormaPago(tipobancoformapagoLocal)) {				
					TipoBancoFormaPagoDataAccess.save(tipobancoformapagoLocal, connexion);				
				} else {
					validadoTodosTipoBancoFormaPago=false;
				}
			}
			
			if(!validadoTodosTipoBancoFormaPago) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoBancoFormaPagoLogicAdditional.checkTipoBancoFormaPagoToSavesAfter(tipobancoformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoBancoFormaPagosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoBancoFormaPagoParameterReturnGeneral procesarAccionTipoBancoFormaPagos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoBancoFormaPago> tipobancoformapagos,TipoBancoFormaPagoParameterReturnGeneral tipobancoformapagoParameterGeneral)throws Exception {
		 try {	
			TipoBancoFormaPagoParameterReturnGeneral tipobancoformapagoReturnGeneral=new TipoBancoFormaPagoParameterReturnGeneral();
	
			TipoBancoFormaPagoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipobancoformapagos,tipobancoformapagoParameterGeneral,tipobancoformapagoReturnGeneral);
			
			return tipobancoformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoBancoFormaPagoParameterReturnGeneral procesarAccionTipoBancoFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoBancoFormaPago> tipobancoformapagos,TipoBancoFormaPagoParameterReturnGeneral tipobancoformapagoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoFormaPago.class.getSimpleName()+"-procesarAccionTipoBancoFormaPagosWithConnection");connexion.begin();			
			
			TipoBancoFormaPagoParameterReturnGeneral tipobancoformapagoReturnGeneral=new TipoBancoFormaPagoParameterReturnGeneral();
	
			TipoBancoFormaPagoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipobancoformapagos,tipobancoformapagoParameterGeneral,tipobancoformapagoReturnGeneral);
			
			this.connexion.commit();
			
			return tipobancoformapagoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoBancoFormaPagoParameterReturnGeneral procesarEventosTipoBancoFormaPagos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoBancoFormaPago> tipobancoformapagos,TipoBancoFormaPago tipobancoformapago,TipoBancoFormaPagoParameterReturnGeneral tipobancoformapagoParameterGeneral,Boolean isEsNuevoTipoBancoFormaPago,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoBancoFormaPagoParameterReturnGeneral tipobancoformapagoReturnGeneral=new TipoBancoFormaPagoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipobancoformapagoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoBancoFormaPagoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipobancoformapagos,tipobancoformapago,tipobancoformapagoParameterGeneral,tipobancoformapagoReturnGeneral,isEsNuevoTipoBancoFormaPago,clases);
			
			return tipobancoformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoBancoFormaPagoParameterReturnGeneral procesarEventosTipoBancoFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoBancoFormaPago> tipobancoformapagos,TipoBancoFormaPago tipobancoformapago,TipoBancoFormaPagoParameterReturnGeneral tipobancoformapagoParameterGeneral,Boolean isEsNuevoTipoBancoFormaPago,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoFormaPago.class.getSimpleName()+"-procesarEventosTipoBancoFormaPagosWithConnection");connexion.begin();			
			
			TipoBancoFormaPagoParameterReturnGeneral tipobancoformapagoReturnGeneral=new TipoBancoFormaPagoParameterReturnGeneral();
	
			tipobancoformapagoReturnGeneral.setTipoBancoFormaPago(tipobancoformapago);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipobancoformapagoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoBancoFormaPagoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipobancoformapagos,tipobancoformapago,tipobancoformapagoParameterGeneral,tipobancoformapagoReturnGeneral,isEsNuevoTipoBancoFormaPago,clases);
			
			this.connexion.commit();
			
			return tipobancoformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoBancoFormaPagoParameterReturnGeneral procesarImportacionTipoBancoFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoBancoFormaPagoParameterReturnGeneral tipobancoformapagoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoFormaPago.class.getSimpleName()+"-procesarImportacionTipoBancoFormaPagosWithConnection");connexion.begin();			
			
			TipoBancoFormaPagoParameterReturnGeneral tipobancoformapagoReturnGeneral=new TipoBancoFormaPagoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipobancoformapagos=new ArrayList<TipoBancoFormaPago>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipobancoformapago=new TipoBancoFormaPago();
				
				
				if(conColumnasBase) {this.tipobancoformapago.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipobancoformapago.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipobancoformapago.setcodigo(arrColumnas[iColumn++]);
				this.tipobancoformapago.setnombre(arrColumnas[iColumn++]);
				
				this.tipobancoformapagos.add(this.tipobancoformapago);
			}
			
			this.saveTipoBancoFormaPagos();
			
			this.connexion.commit();
			
			tipobancoformapagoReturnGeneral.setConRetornoEstaProcesado(true);
			tipobancoformapagoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipobancoformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoBancoFormaPagosEliminados() throws Exception {				
		
		List<TipoBancoFormaPago> tipobancoformapagosAux= new ArrayList<TipoBancoFormaPago>();
		
		for(TipoBancoFormaPago tipobancoformapago:tipobancoformapagos) {
			if(!tipobancoformapago.getIsDeleted()) {
				tipobancoformapagosAux.add(tipobancoformapago);
			}
		}
		
		tipobancoformapagos=tipobancoformapagosAux;
	}
	
	public void quitarTipoBancoFormaPagosNulos() throws Exception {				
		
		List<TipoBancoFormaPago> tipobancoformapagosAux= new ArrayList<TipoBancoFormaPago>();
		
		for(TipoBancoFormaPago tipobancoformapago : this.tipobancoformapagos) {
			if(tipobancoformapago==null) {
				tipobancoformapagosAux.add(tipobancoformapago);
			}
		}
		
		//this.tipobancoformapagos=tipobancoformapagosAux;
		
		this.tipobancoformapagos.removeAll(tipobancoformapagosAux);
	}
	
	public void getSetVersionRowTipoBancoFormaPagoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipobancoformapago.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipobancoformapago.getIsDeleted() || (tipobancoformapago.getIsChanged()&&!tipobancoformapago.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipobancoformapagoDataAccess.getSetVersionRowTipoBancoFormaPago(connexion,tipobancoformapago.getId());
				
				if(!tipobancoformapago.getVersionRow().equals(timestamp)) {	
					tipobancoformapago.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipobancoformapago.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoBancoFormaPago()throws Exception {	
		
		if(tipobancoformapago.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipobancoformapago.getIsDeleted() || (tipobancoformapago.getIsChanged()&&!tipobancoformapago.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipobancoformapagoDataAccess.getSetVersionRowTipoBancoFormaPago(connexion,tipobancoformapago.getId());
			
			try {							
				if(!tipobancoformapago.getVersionRow().equals(timestamp)) {	
					tipobancoformapago.setVersionRow(timestamp);
				}
				
				tipobancoformapago.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoBancoFormaPagosWithConnection()throws Exception {	
		if(tipobancoformapagos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoBancoFormaPago tipobancoformapagoAux:tipobancoformapagos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipobancoformapagoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipobancoformapagoAux.getIsDeleted() || (tipobancoformapagoAux.getIsChanged()&&!tipobancoformapagoAux.getIsNew())) {
						
						timestamp=tipobancoformapagoDataAccess.getSetVersionRowTipoBancoFormaPago(connexion,tipobancoformapagoAux.getId());
						
						if(!tipobancoformapago.getVersionRow().equals(timestamp)) {	
							tipobancoformapagoAux.setVersionRow(timestamp);
						}
								
						tipobancoformapagoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoBancoFormaPagos()throws Exception {	
		if(tipobancoformapagos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoBancoFormaPago tipobancoformapagoAux:tipobancoformapagos) {
					if(tipobancoformapagoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipobancoformapagoAux.getIsDeleted() || (tipobancoformapagoAux.getIsChanged()&&!tipobancoformapagoAux.getIsNew())) {
						
						timestamp=tipobancoformapagoDataAccess.getSetVersionRowTipoBancoFormaPago(connexion,tipobancoformapagoAux.getId());
						
						if(!tipobancoformapagoAux.getVersionRow().equals(timestamp)) {	
							tipobancoformapagoAux.setVersionRow(timestamp);
						}
						
													
						tipobancoformapagoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoBancoFormaPagoParameterReturnGeneral cargarCombosLoteForeignKeyTipoBancoFormaPagoWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoBancoFormaPagoParameterReturnGeneral  tipobancoformapagoReturnGeneral =new TipoBancoFormaPagoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoFormaPago.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoBancoFormaPagoWithConnection");connexion.begin();
			
			tipobancoformapagoReturnGeneral =new TipoBancoFormaPagoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipobancoformapagoReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipobancoformapagoReturnGeneral;
	}
	
	public TipoBancoFormaPagoParameterReturnGeneral cargarCombosLoteForeignKeyTipoBancoFormaPago(String finalQueryGlobalEmpresa) throws Exception {
		TipoBancoFormaPagoParameterReturnGeneral  tipobancoformapagoReturnGeneral =new TipoBancoFormaPagoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipobancoformapagoReturnGeneral =new TipoBancoFormaPagoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipobancoformapagoReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipobancoformapagoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoBancoFormaPagoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			BancoFormaPagoLogic bancoformapagoLogic=new BancoFormaPagoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoFormaPago.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoBancoFormaPagoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(BancoFormaPago.class));
											
			

			bancoformapagoLogic.setConnexion(this.getConnexion());
			bancoformapagoLogic.setDatosCliente(this.datosCliente);
			bancoformapagoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoBancoFormaPago tipobancoformapago:this.tipobancoformapagos) {
				

				classes=new ArrayList<Classe>();
				classes=BancoFormaPagoConstantesFunciones.getClassesForeignKeysOfBancoFormaPago(new ArrayList<Classe>(),DeepLoadType.NONE);

				bancoformapagoLogic.setBancoFormaPagos(tipobancoformapago.bancoformapagos);
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
	
	public void deepLoad(TipoBancoFormaPago tipobancoformapago,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoBancoFormaPagoLogicAdditional.updateTipoBancoFormaPagoToGet(tipobancoformapago,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipobancoformapago.setEmpresa(tipobancoformapagoDataAccess.getEmpresa(connexion,tipobancoformapago));
		tipobancoformapago.setBancoFormaPagos(tipobancoformapagoDataAccess.getBancoFormaPagos(connexion,tipobancoformapago));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipobancoformapago.setEmpresa(tipobancoformapagoDataAccess.getEmpresa(connexion,tipobancoformapago));
				continue;
			}

			if(clas.clas.equals(BancoFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipobancoformapago.setBancoFormaPagos(tipobancoformapagoDataAccess.getBancoFormaPagos(connexion,tipobancoformapago));

				if(this.isConDeep) {
					BancoFormaPagoLogic bancoformapagoLogic= new BancoFormaPagoLogic(this.connexion);
					bancoformapagoLogic.setBancoFormaPagos(tipobancoformapago.getBancoFormaPagos());
					ArrayList<Classe> classesLocal=BancoFormaPagoConstantesFunciones.getClassesForeignKeysOfBancoFormaPago(new ArrayList<Classe>(),DeepLoadType.NONE);
					bancoformapagoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(bancoformapagoLogic.getBancoFormaPagos());
					tipobancoformapago.setBancoFormaPagos(bancoformapagoLogic.getBancoFormaPagos());
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
			tipobancoformapago.setEmpresa(tipobancoformapagoDataAccess.getEmpresa(connexion,tipobancoformapago));
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
			tipobancoformapago.setBancoFormaPagos(tipobancoformapagoDataAccess.getBancoFormaPagos(connexion,tipobancoformapago));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipobancoformapago.setEmpresa(tipobancoformapagoDataAccess.getEmpresa(connexion,tipobancoformapago));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipobancoformapago.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipobancoformapago.setBancoFormaPagos(tipobancoformapagoDataAccess.getBancoFormaPagos(connexion,tipobancoformapago));

		for(BancoFormaPago bancoformapago:tipobancoformapago.getBancoFormaPagos()) {
			BancoFormaPagoLogic bancoformapagoLogic= new BancoFormaPagoLogic(connexion);
			bancoformapagoLogic.deepLoad(bancoformapago,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipobancoformapago.setEmpresa(tipobancoformapagoDataAccess.getEmpresa(connexion,tipobancoformapago));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipobancoformapago.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(BancoFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipobancoformapago.setBancoFormaPagos(tipobancoformapagoDataAccess.getBancoFormaPagos(connexion,tipobancoformapago));

				for(BancoFormaPago bancoformapago:tipobancoformapago.getBancoFormaPagos()) {
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
			tipobancoformapago.setEmpresa(tipobancoformapagoDataAccess.getEmpresa(connexion,tipobancoformapago));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipobancoformapago.getEmpresa(),isDeep,deepLoadType,clases);
				
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
			tipobancoformapago.setBancoFormaPagos(tipobancoformapagoDataAccess.getBancoFormaPagos(connexion,tipobancoformapago));

			for(BancoFormaPago bancoformapago:tipobancoformapago.getBancoFormaPagos()) {
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
	
	public void deepSave(TipoBancoFormaPago tipobancoformapago,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoBancoFormaPagoLogicAdditional.updateTipoBancoFormaPagoToSave(tipobancoformapago,this.arrDatoGeneral);
			
TipoBancoFormaPagoDataAccess.save(tipobancoformapago, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipobancoformapago.getEmpresa(),connexion);

		for(BancoFormaPago bancoformapago:tipobancoformapago.getBancoFormaPagos()) {
			bancoformapago.setid_tipo_banco_forma_pago(tipobancoformapago.getId());
			BancoFormaPagoDataAccess.save(bancoformapago,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipobancoformapago.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(BancoFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(BancoFormaPago bancoformapago:tipobancoformapago.getBancoFormaPagos()) {
					bancoformapago.setid_tipo_banco_forma_pago(tipobancoformapago.getId());
					BancoFormaPagoDataAccess.save(bancoformapago,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipobancoformapago.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipobancoformapago.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(BancoFormaPago bancoformapago:tipobancoformapago.getBancoFormaPagos()) {
			BancoFormaPagoLogic bancoformapagoLogic= new BancoFormaPagoLogic(connexion);
			bancoformapago.setid_tipo_banco_forma_pago(tipobancoformapago.getId());
			BancoFormaPagoDataAccess.save(bancoformapago,connexion);
			bancoformapagoLogic.deepSave(bancoformapago,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipobancoformapago.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipobancoformapago.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(BancoFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(BancoFormaPago bancoformapago:tipobancoformapago.getBancoFormaPagos()) {
					BancoFormaPagoLogic bancoformapagoLogic= new BancoFormaPagoLogic(connexion);
					bancoformapago.setid_tipo_banco_forma_pago(tipobancoformapago.getId());
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
			this.getNewConnexionToDeep(TipoBancoFormaPago.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipobancoformapago,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoBancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoFormaPago(tipobancoformapago);
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
			this.deepLoad(this.tipobancoformapago,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoBancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoFormaPago(this.tipobancoformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoBancoFormaPago.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipobancoformapagos!=null) {
				for(TipoBancoFormaPago tipobancoformapago:tipobancoformapagos) {
					this.deepLoad(tipobancoformapago,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoBancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoFormaPago(tipobancoformapagos);
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
			if(tipobancoformapagos!=null) {
				for(TipoBancoFormaPago tipobancoformapago:tipobancoformapagos) {
					this.deepLoad(tipobancoformapago,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoBancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoFormaPago(tipobancoformapagos);
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
			this.getNewConnexionToDeep(TipoBancoFormaPago.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipobancoformapago,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoBancoFormaPago.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipobancoformapagos!=null) {
				for(TipoBancoFormaPago tipobancoformapago:tipobancoformapagos) {
					this.deepSave(tipobancoformapago,isDeep,deepLoadType,clases);
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
			if(tipobancoformapagos!=null) {
				for(TipoBancoFormaPago tipobancoformapago:tipobancoformapagos) {
					this.deepSave(tipobancoformapago,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoBancoFormaPagosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoBancoFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoBancoFormaPagoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoBancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipobancoformapagos=tipobancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoBancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoFormaPago(this.tipobancoformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoBancoFormaPagosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoBancoFormaPagoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoBancoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipobancoformapagos=tipobancoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoBancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoBancoFormaPago(this.tipobancoformapagos);
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
			if(TipoBancoFormaPagoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoBancoFormaPagoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoBancoFormaPago tipobancoformapago,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoBancoFormaPagoConstantesFunciones.ISCONAUDITORIA) {
				if(tipobancoformapago.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoBancoFormaPagoDataAccess.TABLENAME, tipobancoformapago.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoBancoFormaPagoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoBancoFormaPagoLogic.registrarAuditoriaDetallesTipoBancoFormaPago(connexion,tipobancoformapago,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipobancoformapago.getIsDeleted()) {
					/*if(!tipobancoformapago.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoBancoFormaPagoDataAccess.TABLENAME, tipobancoformapago.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoBancoFormaPagoLogic.registrarAuditoriaDetallesTipoBancoFormaPago(connexion,tipobancoformapago,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoBancoFormaPagoDataAccess.TABLENAME, tipobancoformapago.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipobancoformapago.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoBancoFormaPagoDataAccess.TABLENAME, tipobancoformapago.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoBancoFormaPagoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoBancoFormaPagoLogic.registrarAuditoriaDetallesTipoBancoFormaPago(connexion,tipobancoformapago,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoBancoFormaPago(Connexion connexion,TipoBancoFormaPago tipobancoformapago)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipobancoformapago.getIsNew()||!tipobancoformapago.getid_empresa().equals(tipobancoformapago.getTipoBancoFormaPagoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipobancoformapago.getTipoBancoFormaPagoOriginal().getid_empresa()!=null)
				{
					strValorActual=tipobancoformapago.getTipoBancoFormaPagoOriginal().getid_empresa().toString();
				}
				if(tipobancoformapago.getid_empresa()!=null)
				{
					strValorNuevo=tipobancoformapago.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoBancoFormaPagoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipobancoformapago.getIsNew()||!tipobancoformapago.getcodigo().equals(tipobancoformapago.getTipoBancoFormaPagoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipobancoformapago.getTipoBancoFormaPagoOriginal().getcodigo()!=null)
				{
					strValorActual=tipobancoformapago.getTipoBancoFormaPagoOriginal().getcodigo();
				}
				if(tipobancoformapago.getcodigo()!=null)
				{
					strValorNuevo=tipobancoformapago.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoBancoFormaPagoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipobancoformapago.getIsNew()||!tipobancoformapago.getnombre().equals(tipobancoformapago.getTipoBancoFormaPagoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipobancoformapago.getTipoBancoFormaPagoOriginal().getnombre()!=null)
				{
					strValorActual=tipobancoformapago.getTipoBancoFormaPagoOriginal().getnombre();
				}
				if(tipobancoformapago.getnombre()!=null)
				{
					strValorNuevo=tipobancoformapago.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoBancoFormaPagoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoBancoFormaPagoRelacionesWithConnection(TipoBancoFormaPago tipobancoformapago,List<BancoFormaPago> bancoformapagos) throws Exception {

		if(!tipobancoformapago.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoBancoFormaPagoRelacionesBase(tipobancoformapago,bancoformapagos,true);
		}
	}

	public void saveTipoBancoFormaPagoRelaciones(TipoBancoFormaPago tipobancoformapago,List<BancoFormaPago> bancoformapagos)throws Exception {

		if(!tipobancoformapago.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoBancoFormaPagoRelacionesBase(tipobancoformapago,bancoformapagos,false);
		}
	}

	public void saveTipoBancoFormaPagoRelacionesBase(TipoBancoFormaPago tipobancoformapago,List<BancoFormaPago> bancoformapagos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoBancoFormaPago-saveRelacionesWithConnection");}
	
			tipobancoformapago.setBancoFormaPagos(bancoformapagos);

			this.setTipoBancoFormaPago(tipobancoformapago);

			if(TipoBancoFormaPagoLogicAdditional.validarSaveRelaciones(tipobancoformapago,this)) {

				TipoBancoFormaPagoLogicAdditional.updateRelacionesToSave(tipobancoformapago,this);

				if((tipobancoformapago.getIsNew()||tipobancoformapago.getIsChanged())&&!tipobancoformapago.getIsDeleted()) {
					this.saveTipoBancoFormaPago();
					this.saveTipoBancoFormaPagoRelacionesDetalles(bancoformapagos);

				} else if(tipobancoformapago.getIsDeleted()) {
					this.saveTipoBancoFormaPagoRelacionesDetalles(bancoformapagos);
					this.saveTipoBancoFormaPago();
				}

				TipoBancoFormaPagoLogicAdditional.updateRelacionesToSaveAfter(tipobancoformapago,this);

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
	
	
	private void saveTipoBancoFormaPagoRelacionesDetalles(List<BancoFormaPago> bancoformapagos)throws Exception {
		try {
	

			Long idTipoBancoFormaPagoActual=this.getTipoBancoFormaPago().getId();

			BancoFormaPagoLogic bancoformapagoLogic_Desde_TipoBancoFormaPago=new BancoFormaPagoLogic();
			bancoformapagoLogic_Desde_TipoBancoFormaPago.setBancoFormaPagos(bancoformapagos);

			bancoformapagoLogic_Desde_TipoBancoFormaPago.setConnexion(this.getConnexion());
			bancoformapagoLogic_Desde_TipoBancoFormaPago.setDatosCliente(this.datosCliente);

			for(BancoFormaPago bancoformapago_Desde_TipoBancoFormaPago:bancoformapagoLogic_Desde_TipoBancoFormaPago.getBancoFormaPagos()) {
				bancoformapago_Desde_TipoBancoFormaPago.setid_tipo_banco_forma_pago(idTipoBancoFormaPagoActual);
			}

			bancoformapagoLogic_Desde_TipoBancoFormaPago.saveBancoFormaPagos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoBancoFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoBancoFormaPagoConstantesFunciones.getClassesForeignKeysOfTipoBancoFormaPago(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoBancoFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoBancoFormaPagoConstantesFunciones.getClassesRelationshipsOfTipoBancoFormaPago(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

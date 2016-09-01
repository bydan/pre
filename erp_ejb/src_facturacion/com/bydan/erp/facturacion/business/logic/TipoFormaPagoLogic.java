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
import com.bydan.erp.facturacion.util.TipoFormaPagoConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoFormaPagoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoFormaPagoParameterGeneral;
import com.bydan.erp.facturacion.business.entity.TipoFormaPago;
import com.bydan.erp.facturacion.business.logic.TipoFormaPagoLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoFormaPagoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoFormaPagoLogic.class);
	
	protected TipoFormaPagoDataAccess tipoformapagoDataAccess; 	
	protected TipoFormaPago tipoformapago;
	protected List<TipoFormaPago> tipoformapagos;
	protected Object tipoformapagoObject;	
	protected List<Object> tipoformapagosObject;
	
	public static ClassValidator<TipoFormaPago> tipoformapagoValidator = new ClassValidator<TipoFormaPago>(TipoFormaPago.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoFormaPagoLogicAdditional tipoformapagoLogicAdditional=null;
	
	public TipoFormaPagoLogicAdditional getTipoFormaPagoLogicAdditional() {
		return this.tipoformapagoLogicAdditional;
	}
	
	public void setTipoFormaPagoLogicAdditional(TipoFormaPagoLogicAdditional tipoformapagoLogicAdditional) {
		try {
			this.tipoformapagoLogicAdditional=tipoformapagoLogicAdditional;
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
	
	
	
	
	public  TipoFormaPagoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoformapagoDataAccess = new TipoFormaPagoDataAccess();
			
			this.tipoformapagos= new ArrayList<TipoFormaPago>();
			this.tipoformapago= new TipoFormaPago();
			
			this.tipoformapagoObject=new Object();
			this.tipoformapagosObject=new ArrayList<Object>();
				
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
			
			this.tipoformapagoDataAccess.setConnexionType(this.connexionType);
			this.tipoformapagoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoFormaPagoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoformapagoDataAccess = new TipoFormaPagoDataAccess();
			this.tipoformapagos= new ArrayList<TipoFormaPago>();
			this.tipoformapago= new TipoFormaPago();
			this.tipoformapagoObject=new Object();
			this.tipoformapagosObject=new ArrayList<Object>();
			
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
			
			this.tipoformapagoDataAccess.setConnexionType(this.connexionType);
			this.tipoformapagoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoFormaPago getTipoFormaPago() throws Exception {	
		TipoFormaPagoLogicAdditional.checkTipoFormaPagoToGet(tipoformapago,this.datosCliente,this.arrDatoGeneral);
		TipoFormaPagoLogicAdditional.updateTipoFormaPagoToGet(tipoformapago,this.arrDatoGeneral);
		
		return tipoformapago;
	}
		
	public void setTipoFormaPago(TipoFormaPago newTipoFormaPago) {
		this.tipoformapago = newTipoFormaPago;
	}
	
	public TipoFormaPagoDataAccess getTipoFormaPagoDataAccess() {
		return tipoformapagoDataAccess;
	}
	
	public void setTipoFormaPagoDataAccess(TipoFormaPagoDataAccess newtipoformapagoDataAccess) {
		this.tipoformapagoDataAccess = newtipoformapagoDataAccess;
	}
	
	public List<TipoFormaPago> getTipoFormaPagos() throws Exception {		
		this.quitarTipoFormaPagosNulos();
		
		TipoFormaPagoLogicAdditional.checkTipoFormaPagoToGets(tipoformapagos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoFormaPago tipoformapagoLocal: tipoformapagos ) {
			TipoFormaPagoLogicAdditional.updateTipoFormaPagoToGet(tipoformapagoLocal,this.arrDatoGeneral);
		}
		
		return tipoformapagos;
	}
	
	public void setTipoFormaPagos(List<TipoFormaPago> newTipoFormaPagos) {
		this.tipoformapagos = newTipoFormaPagos;
	}
	
	public Object getTipoFormaPagoObject() {	
		this.tipoformapagoObject=this.tipoformapagoDataAccess.getEntityObject();
		return this.tipoformapagoObject;
	}
		
	public void setTipoFormaPagoObject(Object newTipoFormaPagoObject) {
		this.tipoformapagoObject = newTipoFormaPagoObject;
	}
	
	public List<Object> getTipoFormaPagosObject() {		
		this.tipoformapagosObject=this.tipoformapagoDataAccess.getEntitiesObject();
		return this.tipoformapagosObject;
	}
		
	public void setTipoFormaPagosObject(List<Object> newTipoFormaPagosObject) {
		this.tipoformapagosObject = newTipoFormaPagosObject;
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
		
		if(this.tipoformapagoDataAccess!=null) {
			this.tipoformapagoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoformapagoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoformapagoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoformapago = new  TipoFormaPago();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoformapago=tipoformapagoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapago);
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
		tipoformapago = new  TipoFormaPago();
		  		  
        try {
			
			tipoformapago=tipoformapagoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoformapago = new  TipoFormaPago();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoformapago=tipoformapagoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapago);
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
		tipoformapago = new  TipoFormaPago();
		  		  
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
		tipoformapago = new  TipoFormaPago();
		  		  
        try {
			
			tipoformapago=tipoformapagoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoformapago = new  TipoFormaPago();
		  		  
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
		tipoformapago = new  TipoFormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoformapagoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoformapago = new  TipoFormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoformapagoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoformapago = new  TipoFormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoformapagoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoformapago = new  TipoFormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoformapagoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoformapago = new  TipoFormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoformapagoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoformapago = new  TipoFormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoformapagoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoformapagos = new  ArrayList<TipoFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoFormaPago(tipoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
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
		tipoformapagos = new  ArrayList<TipoFormaPago>();
		  		  
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
		tipoformapagos = new  ArrayList<TipoFormaPago>();
		  		  
        try {			
			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoFormaPago(tipoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoformapagos = new  ArrayList<TipoFormaPago>();
		  		  
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
		tipoformapagos = new  ArrayList<TipoFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoFormaPago(tipoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
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
		tipoformapagos = new  ArrayList<TipoFormaPago>();
		  		  
        try {
			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoFormaPago(tipoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
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
		tipoformapagos = new  ArrayList<TipoFormaPago>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoFormaPago(tipoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
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
		tipoformapagos = new  ArrayList<TipoFormaPago>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoFormaPago(tipoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoformapago = new  TipoFormaPago();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapago=tipoformapagoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoFormaPago(tipoformapago);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapago);
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
		tipoformapago = new  TipoFormaPago();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapago=tipoformapagoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoFormaPago(tipoformapago);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoformapagos = new  ArrayList<TipoFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapagos=tipoformapagoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoFormaPago(tipoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
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
		tipoformapagos = new  ArrayList<TipoFormaPago>();
		  		  
        try {
			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapagos=tipoformapagoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoFormaPago(tipoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoFormaPagosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoformapagos = new  ArrayList<TipoFormaPago>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-getTodosTipoFormaPagosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoFormaPago(tipoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
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
	
	public  void  getTodosTipoFormaPagos(String sFinalQuery,Pagination pagination)throws Exception {
		tipoformapagos = new  ArrayList<TipoFormaPago>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoFormaPago(tipoformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoFormaPago(TipoFormaPago tipoformapago) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoformapago.getIsNew() || tipoformapago.getIsChanged()) { 
			this.invalidValues = tipoformapagoValidator.getInvalidValues(tipoformapago);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoformapago);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoFormaPago(List<TipoFormaPago> TipoFormaPagos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoFormaPago tipoformapagoLocal:tipoformapagos) {				
			estaValidadoObjeto=this.validarGuardarTipoFormaPago(tipoformapagoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoFormaPago(List<TipoFormaPago> TipoFormaPagos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoFormaPago(tipoformapagos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoFormaPago(TipoFormaPago TipoFormaPago) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoFormaPago(tipoformapago)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoFormaPago tipoformapago) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoformapago.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoFormaPagoConstantesFunciones.getTipoFormaPagoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoformapago","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoFormaPagoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoFormaPagoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoFormaPagoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-saveTipoFormaPagoWithConnection");connexion.begin();			
			
			TipoFormaPagoLogicAdditional.checkTipoFormaPagoToSave(this.tipoformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoFormaPagoLogicAdditional.updateTipoFormaPagoToSave(this.tipoformapago,this.arrDatoGeneral);
			
			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoformapago,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoFormaPago();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoFormaPago(this.tipoformapago)) {
				TipoFormaPagoDataAccess.save(this.tipoformapago, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoFormaPagoLogicAdditional.checkTipoFormaPagoToSaveAfter(this.tipoformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoFormaPago();
			
			connexion.commit();			
			
			if(this.tipoformapago.getIsDeleted()) {
				this.tipoformapago=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoFormaPago()throws Exception {	
		try {	
			
			TipoFormaPagoLogicAdditional.checkTipoFormaPagoToSave(this.tipoformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoFormaPagoLogicAdditional.updateTipoFormaPagoToSave(this.tipoformapago,this.arrDatoGeneral);
			
			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoformapago,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoFormaPago(this.tipoformapago)) {			
				TipoFormaPagoDataAccess.save(this.tipoformapago, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoFormaPagoLogicAdditional.checkTipoFormaPagoToSaveAfter(this.tipoformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoformapago.getIsDeleted()) {
				this.tipoformapago=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoFormaPagosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-saveTipoFormaPagosWithConnection");connexion.begin();			
			
			TipoFormaPagoLogicAdditional.checkTipoFormaPagoToSaves(tipoformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoFormaPagos();
			
			Boolean validadoTodosTipoFormaPago=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoFormaPago tipoformapagoLocal:tipoformapagos) {		
				if(tipoformapagoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoFormaPagoLogicAdditional.updateTipoFormaPagoToSave(tipoformapagoLocal,this.arrDatoGeneral);
	        	
				TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoformapagoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoFormaPago(tipoformapagoLocal)) {
					TipoFormaPagoDataAccess.save(tipoformapagoLocal, connexion);				
				} else {
					validadoTodosTipoFormaPago=false;
				}
			}
			
			if(!validadoTodosTipoFormaPago) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoFormaPagoLogicAdditional.checkTipoFormaPagoToSavesAfter(tipoformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoFormaPagos();
			
			connexion.commit();		
			
			this.quitarTipoFormaPagosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoFormaPagos()throws Exception {				
		 try {	
			TipoFormaPagoLogicAdditional.checkTipoFormaPagoToSaves(tipoformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoFormaPago=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoFormaPago tipoformapagoLocal:tipoformapagos) {				
				if(tipoformapagoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoFormaPagoLogicAdditional.updateTipoFormaPagoToSave(tipoformapagoLocal,this.arrDatoGeneral);
	        	
				TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoformapagoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoFormaPago(tipoformapagoLocal)) {				
					TipoFormaPagoDataAccess.save(tipoformapagoLocal, connexion);				
				} else {
					validadoTodosTipoFormaPago=false;
				}
			}
			
			if(!validadoTodosTipoFormaPago) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoFormaPagoLogicAdditional.checkTipoFormaPagoToSavesAfter(tipoformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoFormaPagosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoFormaPagoParameterReturnGeneral procesarAccionTipoFormaPagos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoFormaPago> tipoformapagos,TipoFormaPagoParameterReturnGeneral tipoformapagoParameterGeneral)throws Exception {
		 try {	
			TipoFormaPagoParameterReturnGeneral tipoformapagoReturnGeneral=new TipoFormaPagoParameterReturnGeneral();
	
			TipoFormaPagoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoformapagos,tipoformapagoParameterGeneral,tipoformapagoReturnGeneral);
			
			return tipoformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoFormaPagoParameterReturnGeneral procesarAccionTipoFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoFormaPago> tipoformapagos,TipoFormaPagoParameterReturnGeneral tipoformapagoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-procesarAccionTipoFormaPagosWithConnection");connexion.begin();			
			
			TipoFormaPagoParameterReturnGeneral tipoformapagoReturnGeneral=new TipoFormaPagoParameterReturnGeneral();
	
			TipoFormaPagoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoformapagos,tipoformapagoParameterGeneral,tipoformapagoReturnGeneral);
			
			this.connexion.commit();
			
			return tipoformapagoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoFormaPagoParameterReturnGeneral procesarEventosTipoFormaPagos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoFormaPago> tipoformapagos,TipoFormaPago tipoformapago,TipoFormaPagoParameterReturnGeneral tipoformapagoParameterGeneral,Boolean isEsNuevoTipoFormaPago,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoFormaPagoParameterReturnGeneral tipoformapagoReturnGeneral=new TipoFormaPagoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoformapagoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoFormaPagoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoformapagos,tipoformapago,tipoformapagoParameterGeneral,tipoformapagoReturnGeneral,isEsNuevoTipoFormaPago,clases);
			
			return tipoformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoFormaPagoParameterReturnGeneral procesarEventosTipoFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoFormaPago> tipoformapagos,TipoFormaPago tipoformapago,TipoFormaPagoParameterReturnGeneral tipoformapagoParameterGeneral,Boolean isEsNuevoTipoFormaPago,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-procesarEventosTipoFormaPagosWithConnection");connexion.begin();			
			
			TipoFormaPagoParameterReturnGeneral tipoformapagoReturnGeneral=new TipoFormaPagoParameterReturnGeneral();
	
			tipoformapagoReturnGeneral.setTipoFormaPago(tipoformapago);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoformapagoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoFormaPagoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoformapagos,tipoformapago,tipoformapagoParameterGeneral,tipoformapagoReturnGeneral,isEsNuevoTipoFormaPago,clases);
			
			this.connexion.commit();
			
			return tipoformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoFormaPagoParameterReturnGeneral procesarImportacionTipoFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoFormaPagoParameterReturnGeneral tipoformapagoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-procesarImportacionTipoFormaPagosWithConnection");connexion.begin();			
			
			TipoFormaPagoParameterReturnGeneral tipoformapagoReturnGeneral=new TipoFormaPagoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoformapagos=new ArrayList<TipoFormaPago>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoformapago=new TipoFormaPago();
				
				
				if(conColumnasBase) {this.tipoformapago.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoformapago.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoformapago.setnombre(arrColumnas[iColumn++]);
				this.tipoformapago.setsiglas(arrColumnas[iColumn++]);
				this.tipoformapago.setcon_detalle(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.tipoformapago.setcon_cuotas(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.tipoformapago.setdescripcion(arrColumnas[iColumn++]);
				
				this.tipoformapagos.add(this.tipoformapago);
			}
			
			this.saveTipoFormaPagos();
			
			this.connexion.commit();
			
			tipoformapagoReturnGeneral.setConRetornoEstaProcesado(true);
			tipoformapagoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoFormaPagosEliminados() throws Exception {				
		
		List<TipoFormaPago> tipoformapagosAux= new ArrayList<TipoFormaPago>();
		
		for(TipoFormaPago tipoformapago:tipoformapagos) {
			if(!tipoformapago.getIsDeleted()) {
				tipoformapagosAux.add(tipoformapago);
			}
		}
		
		tipoformapagos=tipoformapagosAux;
	}
	
	public void quitarTipoFormaPagosNulos() throws Exception {				
		
		List<TipoFormaPago> tipoformapagosAux= new ArrayList<TipoFormaPago>();
		
		for(TipoFormaPago tipoformapago : this.tipoformapagos) {
			if(tipoformapago==null) {
				tipoformapagosAux.add(tipoformapago);
			}
		}
		
		//this.tipoformapagos=tipoformapagosAux;
		
		this.tipoformapagos.removeAll(tipoformapagosAux);
	}
	
	public void getSetVersionRowTipoFormaPagoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoformapago.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoformapago.getIsDeleted() || (tipoformapago.getIsChanged()&&!tipoformapago.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoformapagoDataAccess.getSetVersionRowTipoFormaPago(connexion,tipoformapago.getId());
				
				if(!tipoformapago.getVersionRow().equals(timestamp)) {	
					tipoformapago.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoformapago.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoFormaPago()throws Exception {	
		
		if(tipoformapago.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoformapago.getIsDeleted() || (tipoformapago.getIsChanged()&&!tipoformapago.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoformapagoDataAccess.getSetVersionRowTipoFormaPago(connexion,tipoformapago.getId());
			
			try {							
				if(!tipoformapago.getVersionRow().equals(timestamp)) {	
					tipoformapago.setVersionRow(timestamp);
				}
				
				tipoformapago.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoFormaPagosWithConnection()throws Exception {	
		if(tipoformapagos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoFormaPago tipoformapagoAux:tipoformapagos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoformapagoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoformapagoAux.getIsDeleted() || (tipoformapagoAux.getIsChanged()&&!tipoformapagoAux.getIsNew())) {
						
						timestamp=tipoformapagoDataAccess.getSetVersionRowTipoFormaPago(connexion,tipoformapagoAux.getId());
						
						if(!tipoformapago.getVersionRow().equals(timestamp)) {	
							tipoformapagoAux.setVersionRow(timestamp);
						}
								
						tipoformapagoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoFormaPagos()throws Exception {	
		if(tipoformapagos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoFormaPago tipoformapagoAux:tipoformapagos) {
					if(tipoformapagoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoformapagoAux.getIsDeleted() || (tipoformapagoAux.getIsChanged()&&!tipoformapagoAux.getIsNew())) {
						
						timestamp=tipoformapagoDataAccess.getSetVersionRowTipoFormaPago(connexion,tipoformapagoAux.getId());
						
						if(!tipoformapagoAux.getVersionRow().equals(timestamp)) {	
							tipoformapagoAux.setVersionRow(timestamp);
						}
						
													
						tipoformapagoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoFormaPagoParameterReturnGeneral cargarCombosLoteForeignKeyTipoFormaPagoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalTipoGrupoFormaPago,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalTransaccion,String finalQueryGlobalCuentaContable) throws Exception {
		TipoFormaPagoParameterReturnGeneral  tipoformapagoReturnGeneral =new TipoFormaPagoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoFormaPagoWithConnection");connexion.begin();
			
			tipoformapagoReturnGeneral =new TipoFormaPagoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoformapagoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			tipoformapagoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			tipoformapagoReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoGrupoFormaPago> tipogrupoformapagosForeignKey=new ArrayList<TipoGrupoFormaPago>();
			TipoGrupoFormaPagoLogic tipogrupoformapagoLogic=new TipoGrupoFormaPagoLogic();
			tipogrupoformapagoLogic.setConnexion(this.connexion);
			tipogrupoformapagoLogic.getTipoGrupoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGrupoFormaPago.equals("NONE")) {
				tipogrupoformapagoLogic.getTodosTipoGrupoFormaPagos(finalQueryGlobalTipoGrupoFormaPago,new Pagination());
				tipogrupoformapagosForeignKey=tipogrupoformapagoLogic.getTipoGrupoFormaPagos();
			}

			tipoformapagoReturnGeneral.settipogrupoformapagosForeignKey(tipogrupoformapagosForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			tipoformapagoReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			tipoformapagoReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			tipoformapagoReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoformapagoReturnGeneral;
	}
	
	public TipoFormaPagoParameterReturnGeneral cargarCombosLoteForeignKeyTipoFormaPago(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalTipoGrupoFormaPago,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalTransaccion,String finalQueryGlobalCuentaContable) throws Exception {
		TipoFormaPagoParameterReturnGeneral  tipoformapagoReturnGeneral =new TipoFormaPagoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoformapagoReturnGeneral =new TipoFormaPagoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoformapagoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			tipoformapagoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			tipoformapagoReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<TipoGrupoFormaPago> tipogrupoformapagosForeignKey=new ArrayList<TipoGrupoFormaPago>();
			TipoGrupoFormaPagoLogic tipogrupoformapagoLogic=new TipoGrupoFormaPagoLogic();
			tipogrupoformapagoLogic.setConnexion(this.connexion);
			tipogrupoformapagoLogic.getTipoGrupoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGrupoFormaPago.equals("NONE")) {
				tipogrupoformapagoLogic.getTodosTipoGrupoFormaPagos(finalQueryGlobalTipoGrupoFormaPago,new Pagination());
				tipogrupoformapagosForeignKey=tipogrupoformapagoLogic.getTipoGrupoFormaPagos();
			}

			tipoformapagoReturnGeneral.settipogrupoformapagosForeignKey(tipogrupoformapagosForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			tipoformapagoReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			tipoformapagoReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			tipoformapagoReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoformapagoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoFormaPagoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			RegistroFormaPagoBancoLogic registroformapagobancoLogic=new RegistroFormaPagoBancoLogic();
			DetaFormaPagoFactuLogic detaformapagofactuLogic=new DetaFormaPagoFactuLogic();
			GrupoClienteFormaPagoLogic grupoclienteformapagoLogic=new GrupoClienteFormaPagoLogic();
			DetaFormaPagoLogic detaformapagoLogic=new DetaFormaPagoLogic();
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic=new FormaPagoPuntoVentaLogic();
			FormaPagoLogic formapagoLogic=new FormaPagoLogic();
			FormaPagoInvenLogic formapagoinvenLogic=new FormaPagoInvenLogic();
			CierreCajaLogic cierrecajaLogic=new CierreCajaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoFormaPagoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(RegistroFormaPagoBanco.class));
			classes.add(new Classe(DetaFormaPagoFactu.class));
			classes.add(new Classe(GrupoClienteFormaPago.class));
			classes.add(new Classe(DetaFormaPago.class));
			classes.add(new Classe(FormaPagoPuntoVenta.class));
			classes.add(new Classe(FormaPago.class));
			classes.add(new Classe(FormaPagoInven.class));
			classes.add(new Classe(CierreCaja.class));
											
			

			registroformapagobancoLogic.setConnexion(this.getConnexion());
			registroformapagobancoLogic.setDatosCliente(this.datosCliente);
			registroformapagobancoLogic.setIsConRefrescarForeignKeys(true);

			detaformapagofactuLogic.setConnexion(this.getConnexion());
			detaformapagofactuLogic.setDatosCliente(this.datosCliente);
			detaformapagofactuLogic.setIsConRefrescarForeignKeys(true);

			grupoclienteformapagoLogic.setConnexion(this.getConnexion());
			grupoclienteformapagoLogic.setDatosCliente(this.datosCliente);
			grupoclienteformapagoLogic.setIsConRefrescarForeignKeys(true);

			detaformapagoLogic.setConnexion(this.getConnexion());
			detaformapagoLogic.setDatosCliente(this.datosCliente);
			detaformapagoLogic.setIsConRefrescarForeignKeys(true);

			formapagopuntoventaLogic.setConnexion(this.getConnexion());
			formapagopuntoventaLogic.setDatosCliente(this.datosCliente);
			formapagopuntoventaLogic.setIsConRefrescarForeignKeys(true);

			formapagoLogic.setConnexion(this.getConnexion());
			formapagoLogic.setDatosCliente(this.datosCliente);
			formapagoLogic.setIsConRefrescarForeignKeys(true);

			formapagoinvenLogic.setConnexion(this.getConnexion());
			formapagoinvenLogic.setDatosCliente(this.datosCliente);
			formapagoinvenLogic.setIsConRefrescarForeignKeys(true);

			cierrecajaLogic.setConnexion(this.getConnexion());
			cierrecajaLogic.setDatosCliente(this.datosCliente);
			cierrecajaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoFormaPago tipoformapago:this.tipoformapagos) {
				

				classes=new ArrayList<Classe>();
				classes=RegistroFormaPagoBancoConstantesFunciones.getClassesForeignKeysOfRegistroFormaPagoBanco(new ArrayList<Classe>(),DeepLoadType.NONE);

				registroformapagobancoLogic.setRegistroFormaPagoBancos(tipoformapago.registroformapagobancos);
				registroformapagobancoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetaFormaPagoFactuConstantesFunciones.getClassesForeignKeysOfDetaFormaPagoFactu(new ArrayList<Classe>(),DeepLoadType.NONE);

				detaformapagofactuLogic.setDetaFormaPagoFactus(tipoformapago.detaformapagofactus);
				detaformapagofactuLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=GrupoClienteFormaPagoConstantesFunciones.getClassesForeignKeysOfGrupoClienteFormaPago(new ArrayList<Classe>(),DeepLoadType.NONE);

				grupoclienteformapagoLogic.setGrupoClienteFormaPagos(tipoformapago.grupoclienteformapagos);
				grupoclienteformapagoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetaFormaPagoConstantesFunciones.getClassesForeignKeysOfDetaFormaPago(new ArrayList<Classe>(),DeepLoadType.NONE);

				detaformapagoLogic.setDetaFormaPagos(tipoformapago.detaformapagos);
				detaformapagoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=FormaPagoPuntoVentaConstantesFunciones.getClassesForeignKeysOfFormaPagoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				formapagopuntoventaLogic.setFormaPagoPuntoVentas(tipoformapago.formapagopuntoventas);
				formapagopuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=FormaPagoConstantesFunciones.getClassesForeignKeysOfFormaPago(new ArrayList<Classe>(),DeepLoadType.NONE);

				formapagoLogic.setFormaPagos(tipoformapago.formapagos);
				formapagoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=FormaPagoInvenConstantesFunciones.getClassesForeignKeysOfFormaPagoInven(new ArrayList<Classe>(),DeepLoadType.NONE);

				formapagoinvenLogic.setFormaPagoInvens(tipoformapago.formapagoinvens);
				formapagoinvenLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CierreCajaConstantesFunciones.getClassesForeignKeysOfCierreCaja(new ArrayList<Classe>(),DeepLoadType.NONE);

				cierrecajaLogic.setCierreCajas(tipoformapago.cierrecajas);
				cierrecajaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoFormaPago tipoformapago,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoFormaPagoLogicAdditional.updateTipoFormaPagoToGet(tipoformapago,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoformapago.setEmpresa(tipoformapagoDataAccess.getEmpresa(connexion,tipoformapago));
		tipoformapago.setSucursal(tipoformapagoDataAccess.getSucursal(connexion,tipoformapago));
		tipoformapago.setModulo(tipoformapagoDataAccess.getModulo(connexion,tipoformapago));
		tipoformapago.setTipoGrupoFormaPago(tipoformapagoDataAccess.getTipoGrupoFormaPago(connexion,tipoformapago));
		tipoformapago.setTipoTransaccionModulo(tipoformapagoDataAccess.getTipoTransaccionModulo(connexion,tipoformapago));
		tipoformapago.setTransaccion(tipoformapagoDataAccess.getTransaccion(connexion,tipoformapago));
		tipoformapago.setCuentaContable(tipoformapagoDataAccess.getCuentaContable(connexion,tipoformapago));
		tipoformapago.setRegistroFormaPagoBancos(tipoformapagoDataAccess.getRegistroFormaPagoBancos(connexion,tipoformapago));
		tipoformapago.setDetaFormaPagoFactus(tipoformapagoDataAccess.getDetaFormaPagoFactus(connexion,tipoformapago));
		tipoformapago.setGrupoClienteFormaPagos(tipoformapagoDataAccess.getGrupoClienteFormaPagos(connexion,tipoformapago));
		tipoformapago.setDetaFormaPagos(tipoformapagoDataAccess.getDetaFormaPagos(connexion,tipoformapago));
		tipoformapago.setFormaPagoPuntoVentas(tipoformapagoDataAccess.getFormaPagoPuntoVentas(connexion,tipoformapago));
		tipoformapago.setFormaPagos(tipoformapagoDataAccess.getFormaPagos(connexion,tipoformapago));
		tipoformapago.setFormaPagoInvens(tipoformapagoDataAccess.getFormaPagoInvens(connexion,tipoformapago));
		tipoformapago.setCierreCajas(tipoformapagoDataAccess.getCierreCajas(connexion,tipoformapago));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoformapago.setEmpresa(tipoformapagoDataAccess.getEmpresa(connexion,tipoformapago));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				tipoformapago.setSucursal(tipoformapagoDataAccess.getSucursal(connexion,tipoformapago));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				tipoformapago.setModulo(tipoformapagoDataAccess.getModulo(connexion,tipoformapago));
				continue;
			}

			if(clas.clas.equals(TipoGrupoFormaPago.class)) {
				tipoformapago.setTipoGrupoFormaPago(tipoformapagoDataAccess.getTipoGrupoFormaPago(connexion,tipoformapago));
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				tipoformapago.setTipoTransaccionModulo(tipoformapagoDataAccess.getTipoTransaccionModulo(connexion,tipoformapago));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				tipoformapago.setTransaccion(tipoformapagoDataAccess.getTransaccion(connexion,tipoformapago));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tipoformapago.setCuentaContable(tipoformapagoDataAccess.getCuentaContable(connexion,tipoformapago));
				continue;
			}

			if(clas.clas.equals(RegistroFormaPagoBanco.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoformapago.setRegistroFormaPagoBancos(tipoformapagoDataAccess.getRegistroFormaPagoBancos(connexion,tipoformapago));

				if(this.isConDeep) {
					RegistroFormaPagoBancoLogic registroformapagobancoLogic= new RegistroFormaPagoBancoLogic(this.connexion);
					registroformapagobancoLogic.setRegistroFormaPagoBancos(tipoformapago.getRegistroFormaPagoBancos());
					ArrayList<Classe> classesLocal=RegistroFormaPagoBancoConstantesFunciones.getClassesForeignKeysOfRegistroFormaPagoBanco(new ArrayList<Classe>(),DeepLoadType.NONE);
					registroformapagobancoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RegistroFormaPagoBancoConstantesFunciones.refrescarForeignKeysDescripcionesRegistroFormaPagoBanco(registroformapagobancoLogic.getRegistroFormaPagoBancos());
					tipoformapago.setRegistroFormaPagoBancos(registroformapagobancoLogic.getRegistroFormaPagoBancos());
				}

				continue;
			}

			if(clas.clas.equals(DetaFormaPagoFactu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoformapago.setDetaFormaPagoFactus(tipoformapagoDataAccess.getDetaFormaPagoFactus(connexion,tipoformapago));

				if(this.isConDeep) {
					DetaFormaPagoFactuLogic detaformapagofactuLogic= new DetaFormaPagoFactuLogic(this.connexion);
					detaformapagofactuLogic.setDetaFormaPagoFactus(tipoformapago.getDetaFormaPagoFactus());
					ArrayList<Classe> classesLocal=DetaFormaPagoFactuConstantesFunciones.getClassesForeignKeysOfDetaFormaPagoFactu(new ArrayList<Classe>(),DeepLoadType.NONE);
					detaformapagofactuLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetaFormaPagoFactuConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPagoFactu(detaformapagofactuLogic.getDetaFormaPagoFactus());
					tipoformapago.setDetaFormaPagoFactus(detaformapagofactuLogic.getDetaFormaPagoFactus());
				}

				continue;
			}

			if(clas.clas.equals(GrupoClienteFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoformapago.setGrupoClienteFormaPagos(tipoformapagoDataAccess.getGrupoClienteFormaPagos(connexion,tipoformapago));

				if(this.isConDeep) {
					GrupoClienteFormaPagoLogic grupoclienteformapagoLogic= new GrupoClienteFormaPagoLogic(this.connexion);
					grupoclienteformapagoLogic.setGrupoClienteFormaPagos(tipoformapago.getGrupoClienteFormaPagos());
					ArrayList<Classe> classesLocal=GrupoClienteFormaPagoConstantesFunciones.getClassesForeignKeysOfGrupoClienteFormaPago(new ArrayList<Classe>(),DeepLoadType.NONE);
					grupoclienteformapagoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					GrupoClienteFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesGrupoClienteFormaPago(grupoclienteformapagoLogic.getGrupoClienteFormaPagos());
					tipoformapago.setGrupoClienteFormaPagos(grupoclienteformapagoLogic.getGrupoClienteFormaPagos());
				}

				continue;
			}

			if(clas.clas.equals(DetaFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoformapago.setDetaFormaPagos(tipoformapagoDataAccess.getDetaFormaPagos(connexion,tipoformapago));

				if(this.isConDeep) {
					DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(this.connexion);
					detaformapagoLogic.setDetaFormaPagos(tipoformapago.getDetaFormaPagos());
					ArrayList<Classe> classesLocal=DetaFormaPagoConstantesFunciones.getClassesForeignKeysOfDetaFormaPago(new ArrayList<Classe>(),DeepLoadType.NONE);
					detaformapagoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(detaformapagoLogic.getDetaFormaPagos());
					tipoformapago.setDetaFormaPagos(detaformapagoLogic.getDetaFormaPagos());
				}

				continue;
			}

			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoformapago.setFormaPagoPuntoVentas(tipoformapagoDataAccess.getFormaPagoPuntoVentas(connexion,tipoformapago));

				if(this.isConDeep) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(this.connexion);
					formapagopuntoventaLogic.setFormaPagoPuntoVentas(tipoformapago.getFormaPagoPuntoVentas());
					ArrayList<Classe> classesLocal=FormaPagoPuntoVentaConstantesFunciones.getClassesForeignKeysOfFormaPagoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					formapagopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(formapagopuntoventaLogic.getFormaPagoPuntoVentas());
					tipoformapago.setFormaPagoPuntoVentas(formapagopuntoventaLogic.getFormaPagoPuntoVentas());
				}

				continue;
			}

			if(clas.clas.equals(FormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoformapago.setFormaPagos(tipoformapagoDataAccess.getFormaPagos(connexion,tipoformapago));

				if(this.isConDeep) {
					FormaPagoLogic formapagoLogic= new FormaPagoLogic(this.connexion);
					formapagoLogic.setFormaPagos(tipoformapago.getFormaPagos());
					ArrayList<Classe> classesLocal=FormaPagoConstantesFunciones.getClassesForeignKeysOfFormaPago(new ArrayList<Classe>(),DeepLoadType.NONE);
					formapagoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(formapagoLogic.getFormaPagos());
					tipoformapago.setFormaPagos(formapagoLogic.getFormaPagos());
				}

				continue;
			}

			if(clas.clas.equals(FormaPagoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoformapago.setFormaPagoInvens(tipoformapagoDataAccess.getFormaPagoInvens(connexion,tipoformapago));

				if(this.isConDeep) {
					FormaPagoInvenLogic formapagoinvenLogic= new FormaPagoInvenLogic(this.connexion);
					formapagoinvenLogic.setFormaPagoInvens(tipoformapago.getFormaPagoInvens());
					ArrayList<Classe> classesLocal=FormaPagoInvenConstantesFunciones.getClassesForeignKeysOfFormaPagoInven(new ArrayList<Classe>(),DeepLoadType.NONE);
					formapagoinvenLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(formapagoinvenLogic.getFormaPagoInvens());
					tipoformapago.setFormaPagoInvens(formapagoinvenLogic.getFormaPagoInvens());
				}

				continue;
			}

			if(clas.clas.equals(CierreCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoformapago.setCierreCajas(tipoformapagoDataAccess.getCierreCajas(connexion,tipoformapago));

				if(this.isConDeep) {
					CierreCajaLogic cierrecajaLogic= new CierreCajaLogic(this.connexion);
					cierrecajaLogic.setCierreCajas(tipoformapago.getCierreCajas());
					ArrayList<Classe> classesLocal=CierreCajaConstantesFunciones.getClassesForeignKeysOfCierreCaja(new ArrayList<Classe>(),DeepLoadType.NONE);
					cierrecajaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CierreCajaConstantesFunciones.refrescarForeignKeysDescripcionesCierreCaja(cierrecajaLogic.getCierreCajas());
					tipoformapago.setCierreCajas(cierrecajaLogic.getCierreCajas());
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
			tipoformapago.setEmpresa(tipoformapagoDataAccess.getEmpresa(connexion,tipoformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipoformapago.setSucursal(tipoformapagoDataAccess.getSucursal(connexion,tipoformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipoformapago.setModulo(tipoformapagoDataAccess.getModulo(connexion,tipoformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGrupoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipoformapago.setTipoGrupoFormaPago(tipoformapagoDataAccess.getTipoGrupoFormaPago(connexion,tipoformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipoformapago.setTipoTransaccionModulo(tipoformapagoDataAccess.getTipoTransaccionModulo(connexion,tipoformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipoformapago.setTransaccion(tipoformapagoDataAccess.getTransaccion(connexion,tipoformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipoformapago.setCuentaContable(tipoformapagoDataAccess.getCuentaContable(connexion,tipoformapago));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RegistroFormaPagoBanco.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RegistroFormaPagoBanco.class));
			tipoformapago.setRegistroFormaPagoBancos(tipoformapagoDataAccess.getRegistroFormaPagoBancos(connexion,tipoformapago));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetaFormaPagoFactu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetaFormaPagoFactu.class));
			tipoformapago.setDetaFormaPagoFactus(tipoformapagoDataAccess.getDetaFormaPagoFactus(connexion,tipoformapago));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoClienteFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GrupoClienteFormaPago.class));
			tipoformapago.setGrupoClienteFormaPagos(tipoformapagoDataAccess.getGrupoClienteFormaPagos(connexion,tipoformapago));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetaFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetaFormaPago.class));
			tipoformapago.setDetaFormaPagos(tipoformapagoDataAccess.getDetaFormaPagos(connexion,tipoformapago));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormaPagoPuntoVenta.class));
			tipoformapago.setFormaPagoPuntoVentas(tipoformapagoDataAccess.getFormaPagoPuntoVentas(connexion,tipoformapago));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormaPago.class));
			tipoformapago.setFormaPagos(tipoformapagoDataAccess.getFormaPagos(connexion,tipoformapago));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormaPagoInven.class));
			tipoformapago.setFormaPagoInvens(tipoformapagoDataAccess.getFormaPagoInvens(connexion,tipoformapago));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CierreCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CierreCaja.class));
			tipoformapago.setCierreCajas(tipoformapagoDataAccess.getCierreCajas(connexion,tipoformapago));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoformapago.setEmpresa(tipoformapagoDataAccess.getEmpresa(connexion,tipoformapago));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoformapago.getEmpresa(),isDeep,deepLoadType,clases);
				
		tipoformapago.setSucursal(tipoformapagoDataAccess.getSucursal(connexion,tipoformapago));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(tipoformapago.getSucursal(),isDeep,deepLoadType,clases);
				
		tipoformapago.setModulo(tipoformapagoDataAccess.getModulo(connexion,tipoformapago));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(tipoformapago.getModulo(),isDeep,deepLoadType,clases);
				
		tipoformapago.setTipoGrupoFormaPago(tipoformapagoDataAccess.getTipoGrupoFormaPago(connexion,tipoformapago));
		TipoGrupoFormaPagoLogic tipogrupoformapagoLogic= new TipoGrupoFormaPagoLogic(connexion);
		tipogrupoformapagoLogic.deepLoad(tipoformapago.getTipoGrupoFormaPago(),isDeep,deepLoadType,clases);
				
		tipoformapago.setTipoTransaccionModulo(tipoformapagoDataAccess.getTipoTransaccionModulo(connexion,tipoformapago));
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(tipoformapago.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		tipoformapago.setTransaccion(tipoformapagoDataAccess.getTransaccion(connexion,tipoformapago));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(tipoformapago.getTransaccion(),isDeep,deepLoadType,clases);
				
		tipoformapago.setCuentaContable(tipoformapagoDataAccess.getCuentaContable(connexion,tipoformapago));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(tipoformapago.getCuentaContable(),isDeep,deepLoadType,clases);
				

		tipoformapago.setRegistroFormaPagoBancos(tipoformapagoDataAccess.getRegistroFormaPagoBancos(connexion,tipoformapago));

		for(RegistroFormaPagoBanco registroformapagobanco:tipoformapago.getRegistroFormaPagoBancos()) {
			RegistroFormaPagoBancoLogic registroformapagobancoLogic= new RegistroFormaPagoBancoLogic(connexion);
			registroformapagobancoLogic.deepLoad(registroformapagobanco,isDeep,deepLoadType,clases);
		}

		tipoformapago.setDetaFormaPagoFactus(tipoformapagoDataAccess.getDetaFormaPagoFactus(connexion,tipoformapago));

		for(DetaFormaPagoFactu detaformapagofactu:tipoformapago.getDetaFormaPagoFactus()) {
			DetaFormaPagoFactuLogic detaformapagofactuLogic= new DetaFormaPagoFactuLogic(connexion);
			detaformapagofactuLogic.deepLoad(detaformapagofactu,isDeep,deepLoadType,clases);
		}

		tipoformapago.setGrupoClienteFormaPagos(tipoformapagoDataAccess.getGrupoClienteFormaPagos(connexion,tipoformapago));

		for(GrupoClienteFormaPago grupoclienteformapago:tipoformapago.getGrupoClienteFormaPagos()) {
			GrupoClienteFormaPagoLogic grupoclienteformapagoLogic= new GrupoClienteFormaPagoLogic(connexion);
			grupoclienteformapagoLogic.deepLoad(grupoclienteformapago,isDeep,deepLoadType,clases);
		}

		tipoformapago.setDetaFormaPagos(tipoformapagoDataAccess.getDetaFormaPagos(connexion,tipoformapago));

		for(DetaFormaPago detaformapago:tipoformapago.getDetaFormaPagos()) {
			DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(connexion);
			detaformapagoLogic.deepLoad(detaformapago,isDeep,deepLoadType,clases);
		}

		tipoformapago.setFormaPagoPuntoVentas(tipoformapagoDataAccess.getFormaPagoPuntoVentas(connexion,tipoformapago));

		for(FormaPagoPuntoVenta formapagopuntoventa:tipoformapago.getFormaPagoPuntoVentas()) {
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
			formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
		}

		tipoformapago.setFormaPagos(tipoformapagoDataAccess.getFormaPagos(connexion,tipoformapago));

		for(FormaPago formapago:tipoformapago.getFormaPagos()) {
			FormaPagoLogic formapagoLogic= new FormaPagoLogic(connexion);
			formapagoLogic.deepLoad(formapago,isDeep,deepLoadType,clases);
		}

		tipoformapago.setFormaPagoInvens(tipoformapagoDataAccess.getFormaPagoInvens(connexion,tipoformapago));

		for(FormaPagoInven formapagoinven:tipoformapago.getFormaPagoInvens()) {
			FormaPagoInvenLogic formapagoinvenLogic= new FormaPagoInvenLogic(connexion);
			formapagoinvenLogic.deepLoad(formapagoinven,isDeep,deepLoadType,clases);
		}

		tipoformapago.setCierreCajas(tipoformapagoDataAccess.getCierreCajas(connexion,tipoformapago));

		for(CierreCaja cierrecaja:tipoformapago.getCierreCajas()) {
			CierreCajaLogic cierrecajaLogic= new CierreCajaLogic(connexion);
			cierrecajaLogic.deepLoad(cierrecaja,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoformapago.setEmpresa(tipoformapagoDataAccess.getEmpresa(connexion,tipoformapago));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoformapago.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				tipoformapago.setSucursal(tipoformapagoDataAccess.getSucursal(connexion,tipoformapago));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(tipoformapago.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				tipoformapago.setModulo(tipoformapagoDataAccess.getModulo(connexion,tipoformapago));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(tipoformapago.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGrupoFormaPago.class)) {
				tipoformapago.setTipoGrupoFormaPago(tipoformapagoDataAccess.getTipoGrupoFormaPago(connexion,tipoformapago));
				TipoGrupoFormaPagoLogic tipogrupoformapagoLogic= new TipoGrupoFormaPagoLogic(connexion);
				tipogrupoformapagoLogic.deepLoad(tipoformapago.getTipoGrupoFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				tipoformapago.setTipoTransaccionModulo(tipoformapagoDataAccess.getTipoTransaccionModulo(connexion,tipoformapago));
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepLoad(tipoformapago.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				tipoformapago.setTransaccion(tipoformapagoDataAccess.getTransaccion(connexion,tipoformapago));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(tipoformapago.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				tipoformapago.setCuentaContable(tipoformapagoDataAccess.getCuentaContable(connexion,tipoformapago));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(tipoformapago.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RegistroFormaPagoBanco.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoformapago.setRegistroFormaPagoBancos(tipoformapagoDataAccess.getRegistroFormaPagoBancos(connexion,tipoformapago));

				for(RegistroFormaPagoBanco registroformapagobanco:tipoformapago.getRegistroFormaPagoBancos()) {
					RegistroFormaPagoBancoLogic registroformapagobancoLogic= new RegistroFormaPagoBancoLogic(connexion);
					registroformapagobancoLogic.deepLoad(registroformapagobanco,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetaFormaPagoFactu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoformapago.setDetaFormaPagoFactus(tipoformapagoDataAccess.getDetaFormaPagoFactus(connexion,tipoformapago));

				for(DetaFormaPagoFactu detaformapagofactu:tipoformapago.getDetaFormaPagoFactus()) {
					DetaFormaPagoFactuLogic detaformapagofactuLogic= new DetaFormaPagoFactuLogic(connexion);
					detaformapagofactuLogic.deepLoad(detaformapagofactu,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(GrupoClienteFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoformapago.setGrupoClienteFormaPagos(tipoformapagoDataAccess.getGrupoClienteFormaPagos(connexion,tipoformapago));

				for(GrupoClienteFormaPago grupoclienteformapago:tipoformapago.getGrupoClienteFormaPagos()) {
					GrupoClienteFormaPagoLogic grupoclienteformapagoLogic= new GrupoClienteFormaPagoLogic(connexion);
					grupoclienteformapagoLogic.deepLoad(grupoclienteformapago,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetaFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoformapago.setDetaFormaPagos(tipoformapagoDataAccess.getDetaFormaPagos(connexion,tipoformapago));

				for(DetaFormaPago detaformapago:tipoformapago.getDetaFormaPagos()) {
					DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(connexion);
					detaformapagoLogic.deepLoad(detaformapago,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoformapago.setFormaPagoPuntoVentas(tipoformapagoDataAccess.getFormaPagoPuntoVentas(connexion,tipoformapago));

				for(FormaPagoPuntoVenta formapagopuntoventa:tipoformapago.getFormaPagoPuntoVentas()) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
					formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoformapago.setFormaPagos(tipoformapagoDataAccess.getFormaPagos(connexion,tipoformapago));

				for(FormaPago formapago:tipoformapago.getFormaPagos()) {
					FormaPagoLogic formapagoLogic= new FormaPagoLogic(connexion);
					formapagoLogic.deepLoad(formapago,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormaPagoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoformapago.setFormaPagoInvens(tipoformapagoDataAccess.getFormaPagoInvens(connexion,tipoformapago));

				for(FormaPagoInven formapagoinven:tipoformapago.getFormaPagoInvens()) {
					FormaPagoInvenLogic formapagoinvenLogic= new FormaPagoInvenLogic(connexion);
					formapagoinvenLogic.deepLoad(formapagoinven,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CierreCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoformapago.setCierreCajas(tipoformapagoDataAccess.getCierreCajas(connexion,tipoformapago));

				for(CierreCaja cierrecaja:tipoformapago.getCierreCajas()) {
					CierreCajaLogic cierrecajaLogic= new CierreCajaLogic(connexion);
					cierrecajaLogic.deepLoad(cierrecaja,isDeep,deepLoadType,clases);
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
			tipoformapago.setEmpresa(tipoformapagoDataAccess.getEmpresa(connexion,tipoformapago));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoformapago.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipoformapago.setSucursal(tipoformapagoDataAccess.getSucursal(connexion,tipoformapago));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(tipoformapago.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipoformapago.setModulo(tipoformapagoDataAccess.getModulo(connexion,tipoformapago));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(tipoformapago.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGrupoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipoformapago.setTipoGrupoFormaPago(tipoformapagoDataAccess.getTipoGrupoFormaPago(connexion,tipoformapago));
			TipoGrupoFormaPagoLogic tipogrupoformapagoLogic= new TipoGrupoFormaPagoLogic(connexion);
			tipogrupoformapagoLogic.deepLoad(tipoformapago.getTipoGrupoFormaPago(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipoformapago.setTipoTransaccionModulo(tipoformapagoDataAccess.getTipoTransaccionModulo(connexion,tipoformapago));
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
			tipotransaccionmoduloLogic.deepLoad(tipoformapago.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipoformapago.setTransaccion(tipoformapagoDataAccess.getTransaccion(connexion,tipoformapago));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(tipoformapago.getTransaccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipoformapago.setCuentaContable(tipoformapagoDataAccess.getCuentaContable(connexion,tipoformapago));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(tipoformapago.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RegistroFormaPagoBanco.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RegistroFormaPagoBanco.class));
			tipoformapago.setRegistroFormaPagoBancos(tipoformapagoDataAccess.getRegistroFormaPagoBancos(connexion,tipoformapago));

			for(RegistroFormaPagoBanco registroformapagobanco:tipoformapago.getRegistroFormaPagoBancos()) {
				RegistroFormaPagoBancoLogic registroformapagobancoLogic= new RegistroFormaPagoBancoLogic(connexion);
				registroformapagobancoLogic.deepLoad(registroformapagobanco,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetaFormaPagoFactu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetaFormaPagoFactu.class));
			tipoformapago.setDetaFormaPagoFactus(tipoformapagoDataAccess.getDetaFormaPagoFactus(connexion,tipoformapago));

			for(DetaFormaPagoFactu detaformapagofactu:tipoformapago.getDetaFormaPagoFactus()) {
				DetaFormaPagoFactuLogic detaformapagofactuLogic= new DetaFormaPagoFactuLogic(connexion);
				detaformapagofactuLogic.deepLoad(detaformapagofactu,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoClienteFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GrupoClienteFormaPago.class));
			tipoformapago.setGrupoClienteFormaPagos(tipoformapagoDataAccess.getGrupoClienteFormaPagos(connexion,tipoformapago));

			for(GrupoClienteFormaPago grupoclienteformapago:tipoformapago.getGrupoClienteFormaPagos()) {
				GrupoClienteFormaPagoLogic grupoclienteformapagoLogic= new GrupoClienteFormaPagoLogic(connexion);
				grupoclienteformapagoLogic.deepLoad(grupoclienteformapago,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetaFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetaFormaPago.class));
			tipoformapago.setDetaFormaPagos(tipoformapagoDataAccess.getDetaFormaPagos(connexion,tipoformapago));

			for(DetaFormaPago detaformapago:tipoformapago.getDetaFormaPagos()) {
				DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(connexion);
				detaformapagoLogic.deepLoad(detaformapago,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormaPagoPuntoVenta.class));
			tipoformapago.setFormaPagoPuntoVentas(tipoformapagoDataAccess.getFormaPagoPuntoVentas(connexion,tipoformapago));

			for(FormaPagoPuntoVenta formapagopuntoventa:tipoformapago.getFormaPagoPuntoVentas()) {
				FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
				formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormaPago.class));
			tipoformapago.setFormaPagos(tipoformapagoDataAccess.getFormaPagos(connexion,tipoformapago));

			for(FormaPago formapago:tipoformapago.getFormaPagos()) {
				FormaPagoLogic formapagoLogic= new FormaPagoLogic(connexion);
				formapagoLogic.deepLoad(formapago,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormaPagoInven.class));
			tipoformapago.setFormaPagoInvens(tipoformapagoDataAccess.getFormaPagoInvens(connexion,tipoformapago));

			for(FormaPagoInven formapagoinven:tipoformapago.getFormaPagoInvens()) {
				FormaPagoInvenLogic formapagoinvenLogic= new FormaPagoInvenLogic(connexion);
				formapagoinvenLogic.deepLoad(formapagoinven,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CierreCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CierreCaja.class));
			tipoformapago.setCierreCajas(tipoformapagoDataAccess.getCierreCajas(connexion,tipoformapago));

			for(CierreCaja cierrecaja:tipoformapago.getCierreCajas()) {
				CierreCajaLogic cierrecajaLogic= new CierreCajaLogic(connexion);
				cierrecajaLogic.deepLoad(cierrecaja,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoFormaPago tipoformapago,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoFormaPagoLogicAdditional.updateTipoFormaPagoToSave(tipoformapago,this.arrDatoGeneral);
			
TipoFormaPagoDataAccess.save(tipoformapago, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoformapago.getEmpresa(),connexion);

		SucursalDataAccess.save(tipoformapago.getSucursal(),connexion);

		ModuloDataAccess.save(tipoformapago.getModulo(),connexion);

		TipoGrupoFormaPagoDataAccess.save(tipoformapago.getTipoGrupoFormaPago(),connexion);

		TipoTransaccionModuloDataAccess.save(tipoformapago.getTipoTransaccionModulo(),connexion);

		TransaccionDataAccess.save(tipoformapago.getTransaccion(),connexion);

		CuentaContableDataAccess.save(tipoformapago.getCuentaContable(),connexion);

		for(RegistroFormaPagoBanco registroformapagobanco:tipoformapago.getRegistroFormaPagoBancos()) {
			registroformapagobanco.setid_tipo_forma_pago(tipoformapago.getId());
			RegistroFormaPagoBancoDataAccess.save(registroformapagobanco,connexion);
		}

		for(DetaFormaPagoFactu detaformapagofactu:tipoformapago.getDetaFormaPagoFactus()) {
			detaformapagofactu.setid_tipo_forma_pago(tipoformapago.getId());
			DetaFormaPagoFactuDataAccess.save(detaformapagofactu,connexion);
		}

		for(GrupoClienteFormaPago grupoclienteformapago:tipoformapago.getGrupoClienteFormaPagos()) {
			grupoclienteformapago.setid_tipo_forma_pago(tipoformapago.getId());
			GrupoClienteFormaPagoDataAccess.save(grupoclienteformapago,connexion);
		}

		for(DetaFormaPago detaformapago:tipoformapago.getDetaFormaPagos()) {
			detaformapago.setid_tipo_forma_pago(tipoformapago.getId());
			DetaFormaPagoDataAccess.save(detaformapago,connexion);
		}

		for(FormaPagoPuntoVenta formapagopuntoventa:tipoformapago.getFormaPagoPuntoVentas()) {
			formapagopuntoventa.setid_tipo_forma_pago(tipoformapago.getId());
			FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
		}

		for(FormaPago formapago:tipoformapago.getFormaPagos()) {
			formapago.setid_tipo_forma_pago(tipoformapago.getId());
			FormaPagoDataAccess.save(formapago,connexion);
		}

		for(FormaPagoInven formapagoinven:tipoformapago.getFormaPagoInvens()) {
			formapagoinven.setid_tipo_forma_pago(tipoformapago.getId());
			FormaPagoInvenDataAccess.save(formapagoinven,connexion);
		}

		for(CierreCaja cierrecaja:tipoformapago.getCierreCajas()) {
			cierrecaja.setid_tipo_forma_pago(tipoformapago.getId());
			CierreCajaDataAccess.save(cierrecaja,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoformapago.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(tipoformapago.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(tipoformapago.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoGrupoFormaPago.class)) {
				TipoGrupoFormaPagoDataAccess.save(tipoformapago.getTipoGrupoFormaPago(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(tipoformapago.getTipoTransaccionModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(tipoformapago.getTransaccion(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tipoformapago.getCuentaContable(),connexion);
				continue;
			}


			if(clas.clas.equals(RegistroFormaPagoBanco.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RegistroFormaPagoBanco registroformapagobanco:tipoformapago.getRegistroFormaPagoBancos()) {
					registroformapagobanco.setid_tipo_forma_pago(tipoformapago.getId());
					RegistroFormaPagoBancoDataAccess.save(registroformapagobanco,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetaFormaPagoFactu.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetaFormaPagoFactu detaformapagofactu:tipoformapago.getDetaFormaPagoFactus()) {
					detaformapagofactu.setid_tipo_forma_pago(tipoformapago.getId());
					DetaFormaPagoFactuDataAccess.save(detaformapagofactu,connexion);
				}
				continue;
			}

			if(clas.clas.equals(GrupoClienteFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GrupoClienteFormaPago grupoclienteformapago:tipoformapago.getGrupoClienteFormaPagos()) {
					grupoclienteformapago.setid_tipo_forma_pago(tipoformapago.getId());
					GrupoClienteFormaPagoDataAccess.save(grupoclienteformapago,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetaFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetaFormaPago detaformapago:tipoformapago.getDetaFormaPagos()) {
					detaformapago.setid_tipo_forma_pago(tipoformapago.getId());
					DetaFormaPagoDataAccess.save(detaformapago,connexion);
				}
				continue;
			}

			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormaPagoPuntoVenta formapagopuntoventa:tipoformapago.getFormaPagoPuntoVentas()) {
					formapagopuntoventa.setid_tipo_forma_pago(tipoformapago.getId());
					FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
				}
				continue;
			}

			if(clas.clas.equals(FormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormaPago formapago:tipoformapago.getFormaPagos()) {
					formapago.setid_tipo_forma_pago(tipoformapago.getId());
					FormaPagoDataAccess.save(formapago,connexion);
				}
				continue;
			}

			if(clas.clas.equals(FormaPagoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormaPagoInven formapagoinven:tipoformapago.getFormaPagoInvens()) {
					formapagoinven.setid_tipo_forma_pago(tipoformapago.getId());
					FormaPagoInvenDataAccess.save(formapagoinven,connexion);
				}
				continue;
			}

			if(clas.clas.equals(CierreCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CierreCaja cierrecaja:tipoformapago.getCierreCajas()) {
					cierrecaja.setid_tipo_forma_pago(tipoformapago.getId());
					CierreCajaDataAccess.save(cierrecaja,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoformapago.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoformapago.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(tipoformapago.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(tipoformapago.getSucursal(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(tipoformapago.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(tipoformapago.getModulo(),isDeep,deepLoadType,clases);
				

		TipoGrupoFormaPagoDataAccess.save(tipoformapago.getTipoGrupoFormaPago(),connexion);
		TipoGrupoFormaPagoLogic tipogrupoformapagoLogic= new TipoGrupoFormaPagoLogic(connexion);
		tipogrupoformapagoLogic.deepLoad(tipoformapago.getTipoGrupoFormaPago(),isDeep,deepLoadType,clases);
				

		TipoTransaccionModuloDataAccess.save(tipoformapago.getTipoTransaccionModulo(),connexion);
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(tipoformapago.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(tipoformapago.getTransaccion(),connexion);
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(tipoformapago.getTransaccion(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(tipoformapago.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(tipoformapago.getCuentaContable(),isDeep,deepLoadType,clases);
				

		for(RegistroFormaPagoBanco registroformapagobanco:tipoformapago.getRegistroFormaPagoBancos()) {
			RegistroFormaPagoBancoLogic registroformapagobancoLogic= new RegistroFormaPagoBancoLogic(connexion);
			registroformapagobanco.setid_tipo_forma_pago(tipoformapago.getId());
			RegistroFormaPagoBancoDataAccess.save(registroformapagobanco,connexion);
			registroformapagobancoLogic.deepSave(registroformapagobanco,isDeep,deepLoadType,clases);
		}

		for(DetaFormaPagoFactu detaformapagofactu:tipoformapago.getDetaFormaPagoFactus()) {
			DetaFormaPagoFactuLogic detaformapagofactuLogic= new DetaFormaPagoFactuLogic(connexion);
			detaformapagofactu.setid_tipo_forma_pago(tipoformapago.getId());
			DetaFormaPagoFactuDataAccess.save(detaformapagofactu,connexion);
			detaformapagofactuLogic.deepSave(detaformapagofactu,isDeep,deepLoadType,clases);
		}

		for(GrupoClienteFormaPago grupoclienteformapago:tipoformapago.getGrupoClienteFormaPagos()) {
			GrupoClienteFormaPagoLogic grupoclienteformapagoLogic= new GrupoClienteFormaPagoLogic(connexion);
			grupoclienteformapago.setid_tipo_forma_pago(tipoformapago.getId());
			GrupoClienteFormaPagoDataAccess.save(grupoclienteformapago,connexion);
			grupoclienteformapagoLogic.deepSave(grupoclienteformapago,isDeep,deepLoadType,clases);
		}

		for(DetaFormaPago detaformapago:tipoformapago.getDetaFormaPagos()) {
			DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(connexion);
			detaformapago.setid_tipo_forma_pago(tipoformapago.getId());
			DetaFormaPagoDataAccess.save(detaformapago,connexion);
			detaformapagoLogic.deepSave(detaformapago,isDeep,deepLoadType,clases);
		}

		for(FormaPagoPuntoVenta formapagopuntoventa:tipoformapago.getFormaPagoPuntoVentas()) {
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
			formapagopuntoventa.setid_tipo_forma_pago(tipoformapago.getId());
			FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
			formapagopuntoventaLogic.deepSave(formapagopuntoventa,isDeep,deepLoadType,clases);
		}

		for(FormaPago formapago:tipoformapago.getFormaPagos()) {
			FormaPagoLogic formapagoLogic= new FormaPagoLogic(connexion);
			formapago.setid_tipo_forma_pago(tipoformapago.getId());
			FormaPagoDataAccess.save(formapago,connexion);
			formapagoLogic.deepSave(formapago,isDeep,deepLoadType,clases);
		}

		for(FormaPagoInven formapagoinven:tipoformapago.getFormaPagoInvens()) {
			FormaPagoInvenLogic formapagoinvenLogic= new FormaPagoInvenLogic(connexion);
			formapagoinven.setid_tipo_forma_pago(tipoformapago.getId());
			FormaPagoInvenDataAccess.save(formapagoinven,connexion);
			formapagoinvenLogic.deepSave(formapagoinven,isDeep,deepLoadType,clases);
		}

		for(CierreCaja cierrecaja:tipoformapago.getCierreCajas()) {
			CierreCajaLogic cierrecajaLogic= new CierreCajaLogic(connexion);
			cierrecaja.setid_tipo_forma_pago(tipoformapago.getId());
			CierreCajaDataAccess.save(cierrecaja,connexion);
			cierrecajaLogic.deepSave(cierrecaja,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoformapago.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipoformapago.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(tipoformapago.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(tipoformapago.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(tipoformapago.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(tipoformapago.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGrupoFormaPago.class)) {
				TipoGrupoFormaPagoDataAccess.save(tipoformapago.getTipoGrupoFormaPago(),connexion);
				TipoGrupoFormaPagoLogic tipogrupoformapagoLogic= new TipoGrupoFormaPagoLogic(connexion);
				tipogrupoformapagoLogic.deepSave(tipoformapago.getTipoGrupoFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(tipoformapago.getTipoTransaccionModulo(),connexion);
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepSave(tipoformapago.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(tipoformapago.getTransaccion(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(tipoformapago.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(tipoformapago.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(tipoformapago.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(RegistroFormaPagoBanco.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RegistroFormaPagoBanco registroformapagobanco:tipoformapago.getRegistroFormaPagoBancos()) {
					RegistroFormaPagoBancoLogic registroformapagobancoLogic= new RegistroFormaPagoBancoLogic(connexion);
					registroformapagobanco.setid_tipo_forma_pago(tipoformapago.getId());
					RegistroFormaPagoBancoDataAccess.save(registroformapagobanco,connexion);
					registroformapagobancoLogic.deepSave(registroformapagobanco,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetaFormaPagoFactu.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetaFormaPagoFactu detaformapagofactu:tipoformapago.getDetaFormaPagoFactus()) {
					DetaFormaPagoFactuLogic detaformapagofactuLogic= new DetaFormaPagoFactuLogic(connexion);
					detaformapagofactu.setid_tipo_forma_pago(tipoformapago.getId());
					DetaFormaPagoFactuDataAccess.save(detaformapagofactu,connexion);
					detaformapagofactuLogic.deepSave(detaformapagofactu,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(GrupoClienteFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GrupoClienteFormaPago grupoclienteformapago:tipoformapago.getGrupoClienteFormaPagos()) {
					GrupoClienteFormaPagoLogic grupoclienteformapagoLogic= new GrupoClienteFormaPagoLogic(connexion);
					grupoclienteformapago.setid_tipo_forma_pago(tipoformapago.getId());
					GrupoClienteFormaPagoDataAccess.save(grupoclienteformapago,connexion);
					grupoclienteformapagoLogic.deepSave(grupoclienteformapago,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetaFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetaFormaPago detaformapago:tipoformapago.getDetaFormaPagos()) {
					DetaFormaPagoLogic detaformapagoLogic= new DetaFormaPagoLogic(connexion);
					detaformapago.setid_tipo_forma_pago(tipoformapago.getId());
					DetaFormaPagoDataAccess.save(detaformapago,connexion);
					detaformapagoLogic.deepSave(detaformapago,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormaPagoPuntoVenta formapagopuntoventa:tipoformapago.getFormaPagoPuntoVentas()) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
					formapagopuntoventa.setid_tipo_forma_pago(tipoformapago.getId());
					FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
					formapagopuntoventaLogic.deepSave(formapagopuntoventa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormaPago formapago:tipoformapago.getFormaPagos()) {
					FormaPagoLogic formapagoLogic= new FormaPagoLogic(connexion);
					formapago.setid_tipo_forma_pago(tipoformapago.getId());
					FormaPagoDataAccess.save(formapago,connexion);
					formapagoLogic.deepSave(formapago,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormaPagoInven.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormaPagoInven formapagoinven:tipoformapago.getFormaPagoInvens()) {
					FormaPagoInvenLogic formapagoinvenLogic= new FormaPagoInvenLogic(connexion);
					formapagoinven.setid_tipo_forma_pago(tipoformapago.getId());
					FormaPagoInvenDataAccess.save(formapagoinven,connexion);
					formapagoinvenLogic.deepSave(formapagoinven,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CierreCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CierreCaja cierrecaja:tipoformapago.getCierreCajas()) {
					CierreCajaLogic cierrecajaLogic= new CierreCajaLogic(connexion);
					cierrecaja.setid_tipo_forma_pago(tipoformapago.getId());
					CierreCajaDataAccess.save(cierrecaja,connexion);
					cierrecajaLogic.deepSave(cierrecaja,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoFormaPago.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoformapago,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(tipoformapago);
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
			this.deepLoad(this.tipoformapago,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoFormaPago.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoformapagos!=null) {
				for(TipoFormaPago tipoformapago:tipoformapagos) {
					this.deepLoad(tipoformapago,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(tipoformapagos);
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
			if(tipoformapagos!=null) {
				for(TipoFormaPago tipoformapago:tipoformapagos) {
					this.deepLoad(tipoformapago,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(tipoformapagos);
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
			this.getNewConnexionToDeep(TipoFormaPago.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoformapago,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoFormaPago.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoformapagos!=null) {
				for(TipoFormaPago tipoformapago:tipoformapagos) {
					this.deepSave(tipoformapago,isDeep,deepLoadType,clases);
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
			if(tipoformapagos!=null) {
				for(TipoFormaPago tipoformapago:tipoformapagos) {
					this.deepSave(tipoformapago,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoFormaPagosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoFormaPagoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoFormaPagosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoFormaPagoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoFormaPagosBusquedaPorSiglasWithConnection(String sFinalQuery,Pagination pagination,String siglas)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralSiglas= new ParameterSelectionGeneral();
			parameterSelectionGeneralSiglas.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+siglas+"%",TipoFormaPagoConstantesFunciones.SIGLAS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralSiglas);

			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorSiglas","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoFormaPagosBusquedaPorSiglas(String sFinalQuery,Pagination pagination,String siglas)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralSiglas= new ParameterSelectionGeneral();
			parameterSelectionGeneralSiglas.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+siglas+"%",TipoFormaPagoConstantesFunciones.SIGLAS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralSiglas);

			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorSiglas","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoFormaPagosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoFormaPagoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoFormaPagosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoFormaPagoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoFormaPagosFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoFormaPagoConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoFormaPagosFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoFormaPagoConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoFormaPagosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TipoFormaPagoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoFormaPagosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,TipoFormaPagoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoFormaPagosFK_IdTipoFormaPagoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,TipoFormaPagoConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoFormaPagosFK_IdTipoFormaPago(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,TipoFormaPagoConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoFormaPagosFK_IdTipoGrupoFormaPagoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_grupo_forma_pago)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGrupoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGrupoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_grupo_forma_pago,TipoFormaPagoConstantesFunciones.IDTIPOGRUPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGrupoFormaPago);

			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGrupoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoFormaPagosFK_IdTipoGrupoFormaPago(String sFinalQuery,Pagination pagination,Long id_tipo_grupo_forma_pago)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGrupoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGrupoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_grupo_forma_pago,TipoFormaPagoConstantesFunciones.IDTIPOGRUPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGrupoFormaPago);

			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGrupoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoFormaPagosFK_IdTipoTransaccionModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,TipoFormaPagoConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoFormaPagosFK_IdTipoTransaccionModulo(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,TipoFormaPagoConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoFormaPagosFK_IdTransaccionWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,TipoFormaPagoConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoFormaPagosFK_IdTransaccion(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,TipoFormaPagoConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			TipoFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoformapagos=tipoformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPago(this.tipoformapagos);
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
			if(TipoFormaPagoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoFormaPagoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoFormaPago tipoformapago,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoFormaPagoConstantesFunciones.ISCONAUDITORIA) {
				if(tipoformapago.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoFormaPagoDataAccess.TABLENAME, tipoformapago.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoFormaPagoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoFormaPagoLogic.registrarAuditoriaDetallesTipoFormaPago(connexion,tipoformapago,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoformapago.getIsDeleted()) {
					/*if(!tipoformapago.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoFormaPagoDataAccess.TABLENAME, tipoformapago.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoFormaPagoLogic.registrarAuditoriaDetallesTipoFormaPago(connexion,tipoformapago,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoFormaPagoDataAccess.TABLENAME, tipoformapago.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoformapago.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoFormaPagoDataAccess.TABLENAME, tipoformapago.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoFormaPagoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoFormaPagoLogic.registrarAuditoriaDetallesTipoFormaPago(connexion,tipoformapago,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoFormaPago(Connexion connexion,TipoFormaPago tipoformapago)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoformapago.getIsNew()||!tipoformapago.getid_empresa().equals(tipoformapago.getTipoFormaPagoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoformapago.getTipoFormaPagoOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoformapago.getTipoFormaPagoOriginal().getid_empresa().toString();
				}
				if(tipoformapago.getid_empresa()!=null)
				{
					strValorNuevo=tipoformapago.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoFormaPagoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoformapago.getIsNew()||!tipoformapago.getid_sucursal().equals(tipoformapago.getTipoFormaPagoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoformapago.getTipoFormaPagoOriginal().getid_sucursal()!=null)
				{
					strValorActual=tipoformapago.getTipoFormaPagoOriginal().getid_sucursal().toString();
				}
				if(tipoformapago.getid_sucursal()!=null)
				{
					strValorNuevo=tipoformapago.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoFormaPagoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(tipoformapago.getIsNew()||!tipoformapago.getid_modulo().equals(tipoformapago.getTipoFormaPagoOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoformapago.getTipoFormaPagoOriginal().getid_modulo()!=null)
				{
					strValorActual=tipoformapago.getTipoFormaPagoOriginal().getid_modulo().toString();
				}
				if(tipoformapago.getid_modulo()!=null)
				{
					strValorNuevo=tipoformapago.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoFormaPagoConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(tipoformapago.getIsNew()||!tipoformapago.getid_tipo_grupo_forma_pago().equals(tipoformapago.getTipoFormaPagoOriginal().getid_tipo_grupo_forma_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoformapago.getTipoFormaPagoOriginal().getid_tipo_grupo_forma_pago()!=null)
				{
					strValorActual=tipoformapago.getTipoFormaPagoOriginal().getid_tipo_grupo_forma_pago().toString();
				}
				if(tipoformapago.getid_tipo_grupo_forma_pago()!=null)
				{
					strValorNuevo=tipoformapago.getid_tipo_grupo_forma_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoFormaPagoConstantesFunciones.IDTIPOGRUPOFORMAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoformapago.getIsNew()||!tipoformapago.getnombre().equals(tipoformapago.getTipoFormaPagoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoformapago.getTipoFormaPagoOriginal().getnombre()!=null)
				{
					strValorActual=tipoformapago.getTipoFormaPagoOriginal().getnombre();
				}
				if(tipoformapago.getnombre()!=null)
				{
					strValorNuevo=tipoformapago.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoFormaPagoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipoformapago.getIsNew()||!tipoformapago.getsiglas().equals(tipoformapago.getTipoFormaPagoOriginal().getsiglas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoformapago.getTipoFormaPagoOriginal().getsiglas()!=null)
				{
					strValorActual=tipoformapago.getTipoFormaPagoOriginal().getsiglas();
				}
				if(tipoformapago.getsiglas()!=null)
				{
					strValorNuevo=tipoformapago.getsiglas() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoFormaPagoConstantesFunciones.SIGLAS,strValorActual,strValorNuevo);
			}	
			
			if(tipoformapago.getIsNew()||!tipoformapago.getcon_detalle().equals(tipoformapago.getTipoFormaPagoOriginal().getcon_detalle()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoformapago.getTipoFormaPagoOriginal().getcon_detalle()!=null)
				{
					strValorActual=tipoformapago.getTipoFormaPagoOriginal().getcon_detalle().toString();
				}
				if(tipoformapago.getcon_detalle()!=null)
				{
					strValorNuevo=tipoformapago.getcon_detalle().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoFormaPagoConstantesFunciones.CONDETALLE,strValorActual,strValorNuevo);
			}	
			
			if(tipoformapago.getIsNew()||!tipoformapago.getcon_cuotas().equals(tipoformapago.getTipoFormaPagoOriginal().getcon_cuotas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoformapago.getTipoFormaPagoOriginal().getcon_cuotas()!=null)
				{
					strValorActual=tipoformapago.getTipoFormaPagoOriginal().getcon_cuotas().toString();
				}
				if(tipoformapago.getcon_cuotas()!=null)
				{
					strValorNuevo=tipoformapago.getcon_cuotas().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoFormaPagoConstantesFunciones.CONCUOTAS,strValorActual,strValorNuevo);
			}	
			
			if(tipoformapago.getIsNew()||!tipoformapago.getid_tipo_transaccion_modulo().equals(tipoformapago.getTipoFormaPagoOriginal().getid_tipo_transaccion_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoformapago.getTipoFormaPagoOriginal().getid_tipo_transaccion_modulo()!=null)
				{
					strValorActual=tipoformapago.getTipoFormaPagoOriginal().getid_tipo_transaccion_modulo().toString();
				}
				if(tipoformapago.getid_tipo_transaccion_modulo()!=null)
				{
					strValorNuevo=tipoformapago.getid_tipo_transaccion_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoFormaPagoConstantesFunciones.IDTIPOTRANSACCIONMODULO,strValorActual,strValorNuevo);
			}	
			
			if(tipoformapago.getIsNew()||!tipoformapago.getid_transaccion().equals(tipoformapago.getTipoFormaPagoOriginal().getid_transaccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoformapago.getTipoFormaPagoOriginal().getid_transaccion()!=null)
				{
					strValorActual=tipoformapago.getTipoFormaPagoOriginal().getid_transaccion().toString();
				}
				if(tipoformapago.getid_transaccion()!=null)
				{
					strValorNuevo=tipoformapago.getid_transaccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoFormaPagoConstantesFunciones.IDTRANSACCION,strValorActual,strValorNuevo);
			}	
			
			if(tipoformapago.getIsNew()||!tipoformapago.getid_cuenta_contable().equals(tipoformapago.getTipoFormaPagoOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoformapago.getTipoFormaPagoOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=tipoformapago.getTipoFormaPagoOriginal().getid_cuenta_contable().toString();
				}
				if(tipoformapago.getid_cuenta_contable()!=null)
				{
					strValorNuevo=tipoformapago.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoFormaPagoConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(tipoformapago.getIsNew()||!tipoformapago.getdescripcion().equals(tipoformapago.getTipoFormaPagoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoformapago.getTipoFormaPagoOriginal().getdescripcion()!=null)
				{
					strValorActual=tipoformapago.getTipoFormaPagoOriginal().getdescripcion();
				}
				if(tipoformapago.getdescripcion()!=null)
				{
					strValorNuevo=tipoformapago.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoFormaPagoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoFormaPagoRelacionesWithConnection(TipoFormaPago tipoformapago,List<RegistroFormaPagoBanco> registroformapagobancos,List<DetaFormaPagoFactu> detaformapagofactus,List<GrupoClienteFormaPago> grupoclienteformapagos,List<DetaFormaPago> detaformapagos,List<FormaPagoPuntoVenta> formapagopuntoventas,List<FormaPago> formapagos,List<FormaPagoInven> formapagoinvens,List<CierreCaja> cierrecajas) throws Exception {

		if(!tipoformapago.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoFormaPagoRelacionesBase(tipoformapago,registroformapagobancos,detaformapagofactus,grupoclienteformapagos,detaformapagos,formapagopuntoventas,formapagos,formapagoinvens,cierrecajas,true);
		}
	}

	public void saveTipoFormaPagoRelaciones(TipoFormaPago tipoformapago,List<RegistroFormaPagoBanco> registroformapagobancos,List<DetaFormaPagoFactu> detaformapagofactus,List<GrupoClienteFormaPago> grupoclienteformapagos,List<DetaFormaPago> detaformapagos,List<FormaPagoPuntoVenta> formapagopuntoventas,List<FormaPago> formapagos,List<FormaPagoInven> formapagoinvens,List<CierreCaja> cierrecajas)throws Exception {

		if(!tipoformapago.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoFormaPagoRelacionesBase(tipoformapago,registroformapagobancos,detaformapagofactus,grupoclienteformapagos,detaformapagos,formapagopuntoventas,formapagos,formapagoinvens,cierrecajas,false);
		}
	}

	public void saveTipoFormaPagoRelacionesBase(TipoFormaPago tipoformapago,List<RegistroFormaPagoBanco> registroformapagobancos,List<DetaFormaPagoFactu> detaformapagofactus,List<GrupoClienteFormaPago> grupoclienteformapagos,List<DetaFormaPago> detaformapagos,List<FormaPagoPuntoVenta> formapagopuntoventas,List<FormaPago> formapagos,List<FormaPagoInven> formapagoinvens,List<CierreCaja> cierrecajas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoFormaPago-saveRelacionesWithConnection");}
	
			tipoformapago.setRegistroFormaPagoBancos(registroformapagobancos);
			tipoformapago.setDetaFormaPagoFactus(detaformapagofactus);
			tipoformapago.setGrupoClienteFormaPagos(grupoclienteformapagos);
			tipoformapago.setDetaFormaPagos(detaformapagos);
			tipoformapago.setFormaPagoPuntoVentas(formapagopuntoventas);
			tipoformapago.setFormaPagos(formapagos);
			tipoformapago.setFormaPagoInvens(formapagoinvens);
			tipoformapago.setCierreCajas(cierrecajas);

			this.setTipoFormaPago(tipoformapago);

			if(TipoFormaPagoLogicAdditional.validarSaveRelaciones(tipoformapago,this)) {

				TipoFormaPagoLogicAdditional.updateRelacionesToSave(tipoformapago,this);

				if((tipoformapago.getIsNew()||tipoformapago.getIsChanged())&&!tipoformapago.getIsDeleted()) {
					this.saveTipoFormaPago();
					this.saveTipoFormaPagoRelacionesDetalles(registroformapagobancos,detaformapagofactus,grupoclienteformapagos,detaformapagos,formapagopuntoventas,formapagos,formapagoinvens,cierrecajas);

				} else if(tipoformapago.getIsDeleted()) {
					this.saveTipoFormaPagoRelacionesDetalles(registroformapagobancos,detaformapagofactus,grupoclienteformapagos,detaformapagos,formapagopuntoventas,formapagos,formapagoinvens,cierrecajas);
					this.saveTipoFormaPago();
				}

				TipoFormaPagoLogicAdditional.updateRelacionesToSaveAfter(tipoformapago,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			RegistroFormaPagoBancoConstantesFunciones.InicializarGeneralEntityAuxiliaresRegistroFormaPagoBancos(registroformapagobancos,true,true);
			DetaFormaPagoFactuConstantesFunciones.InicializarGeneralEntityAuxiliaresDetaFormaPagoFactus(detaformapagofactus,true,true);
			GrupoClienteFormaPagoConstantesFunciones.InicializarGeneralEntityAuxiliaresGrupoClienteFormaPagos(grupoclienteformapagos,true,true);
			DetaFormaPagoConstantesFunciones.InicializarGeneralEntityAuxiliaresDetaFormaPagos(detaformapagos,true,true);
			FormaPagoPuntoVentaConstantesFunciones.InicializarGeneralEntityAuxiliaresFormaPagoPuntoVentas(formapagopuntoventas,true,true);
			FormaPagoConstantesFunciones.InicializarGeneralEntityAuxiliaresFormaPagos(formapagos,true,true);
			FormaPagoInvenConstantesFunciones.InicializarGeneralEntityAuxiliaresFormaPagoInvens(formapagoinvens,true,true);
			CierreCajaConstantesFunciones.InicializarGeneralEntityAuxiliaresCierreCajas(cierrecajas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoFormaPagoRelacionesDetalles(List<RegistroFormaPagoBanco> registroformapagobancos,List<DetaFormaPagoFactu> detaformapagofactus,List<GrupoClienteFormaPago> grupoclienteformapagos,List<DetaFormaPago> detaformapagos,List<FormaPagoPuntoVenta> formapagopuntoventas,List<FormaPago> formapagos,List<FormaPagoInven> formapagoinvens,List<CierreCaja> cierrecajas)throws Exception {
		try {
	

			Long idTipoFormaPagoActual=this.getTipoFormaPago().getId();

			RegistroFormaPagoBancoLogic registroformapagobancoLogic_Desde_TipoFormaPago=new RegistroFormaPagoBancoLogic();
			registroformapagobancoLogic_Desde_TipoFormaPago.setRegistroFormaPagoBancos(registroformapagobancos);

			registroformapagobancoLogic_Desde_TipoFormaPago.setConnexion(this.getConnexion());
			registroformapagobancoLogic_Desde_TipoFormaPago.setDatosCliente(this.datosCliente);

			for(RegistroFormaPagoBanco registroformapagobanco_Desde_TipoFormaPago:registroformapagobancoLogic_Desde_TipoFormaPago.getRegistroFormaPagoBancos()) {
				registroformapagobanco_Desde_TipoFormaPago.setid_tipo_forma_pago(idTipoFormaPagoActual);
			}

			registroformapagobancoLogic_Desde_TipoFormaPago.saveRegistroFormaPagoBancos();

			DetaFormaPagoFactuLogic detaformapagofactuLogic_Desde_TipoFormaPago=new DetaFormaPagoFactuLogic();
			detaformapagofactuLogic_Desde_TipoFormaPago.setDetaFormaPagoFactus(detaformapagofactus);

			detaformapagofactuLogic_Desde_TipoFormaPago.setConnexion(this.getConnexion());
			detaformapagofactuLogic_Desde_TipoFormaPago.setDatosCliente(this.datosCliente);

			for(DetaFormaPagoFactu detaformapagofactu_Desde_TipoFormaPago:detaformapagofactuLogic_Desde_TipoFormaPago.getDetaFormaPagoFactus()) {
				detaformapagofactu_Desde_TipoFormaPago.setid_tipo_forma_pago(idTipoFormaPagoActual);

				detaformapagofactuLogic_Desde_TipoFormaPago.setDetaFormaPagoFactu(detaformapagofactu_Desde_TipoFormaPago);
				detaformapagofactuLogic_Desde_TipoFormaPago.saveDetaFormaPagoFactu();

				Long idDetaFormaPagoFactuActual=detaformapagofactu_Desde_TipoFormaPago.getId();

				DetaFormaPagoLogic detaformapagoLogic_Desde_DetaFormaPagoFactu=new DetaFormaPagoLogic();

				if(detaformapagofactu_Desde_TipoFormaPago.getDetaFormaPagos()==null){
					detaformapagofactu_Desde_TipoFormaPago.setDetaFormaPagos(new ArrayList<DetaFormaPago>());
				}

				detaformapagoLogic_Desde_DetaFormaPagoFactu.setDetaFormaPagos(detaformapagofactu_Desde_TipoFormaPago.getDetaFormaPagos());

				detaformapagoLogic_Desde_DetaFormaPagoFactu.setConnexion(this.getConnexion());
				detaformapagoLogic_Desde_DetaFormaPagoFactu.setDatosCliente(this.datosCliente);

				for(DetaFormaPago detaformapago_Desde_DetaFormaPagoFactu:detaformapagoLogic_Desde_DetaFormaPagoFactu.getDetaFormaPagos()) {
					detaformapago_Desde_DetaFormaPagoFactu.setid_deta_forma_pago_factu(idDetaFormaPagoFactuActual);

					detaformapagoLogic_Desde_DetaFormaPagoFactu.setDetaFormaPago(detaformapago_Desde_DetaFormaPagoFactu);
					detaformapagoLogic_Desde_DetaFormaPagoFactu.saveDetaFormaPago();

					Long idDetaFormaPagoActual=detaformapago_Desde_DetaFormaPagoFactu.getId();

					BancoFormaPagoLogic bancoformapagoLogic_Desde_DetaFormaPago=new BancoFormaPagoLogic();

					if(detaformapago_Desde_DetaFormaPagoFactu.getBancoFormaPagos()==null){
						detaformapago_Desde_DetaFormaPagoFactu.setBancoFormaPagos(new ArrayList<BancoFormaPago>());
					}

					bancoformapagoLogic_Desde_DetaFormaPago.setBancoFormaPagos(detaformapago_Desde_DetaFormaPagoFactu.getBancoFormaPagos());

					bancoformapagoLogic_Desde_DetaFormaPago.setConnexion(this.getConnexion());
					bancoformapagoLogic_Desde_DetaFormaPago.setDatosCliente(this.datosCliente);

					for(BancoFormaPago bancoformapago_Desde_DetaFormaPago:bancoformapagoLogic_Desde_DetaFormaPago.getBancoFormaPagos()) {
						bancoformapago_Desde_DetaFormaPago.setid_deta_forma_pago(idDetaFormaPagoActual);
					}

					bancoformapagoLogic_Desde_DetaFormaPago.saveBancoFormaPagos();
				}

			}


			GrupoClienteFormaPagoLogic grupoclienteformapagoLogic_Desde_TipoFormaPago=new GrupoClienteFormaPagoLogic();
			grupoclienteformapagoLogic_Desde_TipoFormaPago.setGrupoClienteFormaPagos(grupoclienteformapagos);

			grupoclienteformapagoLogic_Desde_TipoFormaPago.setConnexion(this.getConnexion());
			grupoclienteformapagoLogic_Desde_TipoFormaPago.setDatosCliente(this.datosCliente);

			for(GrupoClienteFormaPago grupoclienteformapago_Desde_TipoFormaPago:grupoclienteformapagoLogic_Desde_TipoFormaPago.getGrupoClienteFormaPagos()) {
				grupoclienteformapago_Desde_TipoFormaPago.setid_tipo_forma_pago(idTipoFormaPagoActual);
			}

			grupoclienteformapagoLogic_Desde_TipoFormaPago.saveGrupoClienteFormaPagos();

			DetaFormaPagoLogic detaformapagoLogic_Desde_TipoFormaPago=new DetaFormaPagoLogic();
			detaformapagoLogic_Desde_TipoFormaPago.setDetaFormaPagos(detaformapagos);

			detaformapagoLogic_Desde_TipoFormaPago.setConnexion(this.getConnexion());
			detaformapagoLogic_Desde_TipoFormaPago.setDatosCliente(this.datosCliente);

			for(DetaFormaPago detaformapago_Desde_TipoFormaPago:detaformapagoLogic_Desde_TipoFormaPago.getDetaFormaPagos()) {
				detaformapago_Desde_TipoFormaPago.setid_tipo_forma_pago(idTipoFormaPagoActual);

				detaformapagoLogic_Desde_TipoFormaPago.setDetaFormaPago(detaformapago_Desde_TipoFormaPago);
				detaformapagoLogic_Desde_TipoFormaPago.saveDetaFormaPago();

				Long idDetaFormaPagoActual=detaformapago_Desde_TipoFormaPago.getId();

				BancoFormaPagoLogic bancoformapagoLogic_Desde_DetaFormaPago=new BancoFormaPagoLogic();

				if(detaformapago_Desde_TipoFormaPago.getBancoFormaPagos()==null){
					detaformapago_Desde_TipoFormaPago.setBancoFormaPagos(new ArrayList<BancoFormaPago>());
				}

				bancoformapagoLogic_Desde_DetaFormaPago.setBancoFormaPagos(detaformapago_Desde_TipoFormaPago.getBancoFormaPagos());

				bancoformapagoLogic_Desde_DetaFormaPago.setConnexion(this.getConnexion());
				bancoformapagoLogic_Desde_DetaFormaPago.setDatosCliente(this.datosCliente);

				for(BancoFormaPago bancoformapago_Desde_DetaFormaPago:bancoformapagoLogic_Desde_DetaFormaPago.getBancoFormaPagos()) {
					bancoformapago_Desde_DetaFormaPago.setid_deta_forma_pago(idDetaFormaPagoActual);
				}

				bancoformapagoLogic_Desde_DetaFormaPago.saveBancoFormaPagos();
			}


			FormaPagoPuntoVentaLogic formapagopuntoventaLogic_Desde_TipoFormaPago=new FormaPagoPuntoVentaLogic();
			formapagopuntoventaLogic_Desde_TipoFormaPago.setFormaPagoPuntoVentas(formapagopuntoventas);

			formapagopuntoventaLogic_Desde_TipoFormaPago.setConnexion(this.getConnexion());
			formapagopuntoventaLogic_Desde_TipoFormaPago.setDatosCliente(this.datosCliente);

			for(FormaPagoPuntoVenta formapagopuntoventa_Desde_TipoFormaPago:formapagopuntoventaLogic_Desde_TipoFormaPago.getFormaPagoPuntoVentas()) {
				formapagopuntoventa_Desde_TipoFormaPago.setid_tipo_forma_pago(idTipoFormaPagoActual);
			}

			formapagopuntoventaLogic_Desde_TipoFormaPago.saveFormaPagoPuntoVentas();

			FormaPagoLogic formapagoLogic_Desde_TipoFormaPago=new FormaPagoLogic();
			formapagoLogic_Desde_TipoFormaPago.setFormaPagos(formapagos);

			formapagoLogic_Desde_TipoFormaPago.setConnexion(this.getConnexion());
			formapagoLogic_Desde_TipoFormaPago.setDatosCliente(this.datosCliente);

			for(FormaPago formapago_Desde_TipoFormaPago:formapagoLogic_Desde_TipoFormaPago.getFormaPagos()) {
				formapago_Desde_TipoFormaPago.setid_tipo_forma_pago(idTipoFormaPagoActual);

				formapagoLogic_Desde_TipoFormaPago.setFormaPago(formapago_Desde_TipoFormaPago);
				formapagoLogic_Desde_TipoFormaPago.saveFormaPago();

				Long idFormaPagoActual=formapago_Desde_TipoFormaPago.getId();

				FormularioRentaExtraLogic formulariorentaextraLogic_Desde_FormaPago=new FormularioRentaExtraLogic();

				if(formapago_Desde_TipoFormaPago.getFormularioRentaExtras()==null){
					formapago_Desde_TipoFormaPago.setFormularioRentaExtras(new ArrayList<FormularioRentaExtra>());
				}

				formulariorentaextraLogic_Desde_FormaPago.setFormularioRentaExtras(formapago_Desde_TipoFormaPago.getFormularioRentaExtras());

				formulariorentaextraLogic_Desde_FormaPago.setConnexion(this.getConnexion());
				formulariorentaextraLogic_Desde_FormaPago.setDatosCliente(this.datosCliente);

				for(FormularioRentaExtra formulariorentaextra_Desde_FormaPago:formulariorentaextraLogic_Desde_FormaPago.getFormularioRentaExtras()) {
					formulariorentaextra_Desde_FormaPago.setid_forma_pago(idFormaPagoActual);
				}

				formulariorentaextraLogic_Desde_FormaPago.saveFormularioRentaExtras();
			}


			FormaPagoInvenLogic formapagoinvenLogic_Desde_TipoFormaPago=new FormaPagoInvenLogic();
			formapagoinvenLogic_Desde_TipoFormaPago.setFormaPagoInvens(formapagoinvens);

			formapagoinvenLogic_Desde_TipoFormaPago.setConnexion(this.getConnexion());
			formapagoinvenLogic_Desde_TipoFormaPago.setDatosCliente(this.datosCliente);

			for(FormaPagoInven formapagoinven_Desde_TipoFormaPago:formapagoinvenLogic_Desde_TipoFormaPago.getFormaPagoInvens()) {
				formapagoinven_Desde_TipoFormaPago.setid_tipo_forma_pago(idTipoFormaPagoActual);
			}

			formapagoinvenLogic_Desde_TipoFormaPago.saveFormaPagoInvens();

			CierreCajaLogic cierrecajaLogic_Desde_TipoFormaPago=new CierreCajaLogic();
			cierrecajaLogic_Desde_TipoFormaPago.setCierreCajas(cierrecajas);

			cierrecajaLogic_Desde_TipoFormaPago.setConnexion(this.getConnexion());
			cierrecajaLogic_Desde_TipoFormaPago.setDatosCliente(this.datosCliente);

			for(CierreCaja cierrecaja_Desde_TipoFormaPago:cierrecajaLogic_Desde_TipoFormaPago.getCierreCajas()) {
				cierrecaja_Desde_TipoFormaPago.setid_tipo_forma_pago(idTipoFormaPagoActual);
			}

			cierrecajaLogic_Desde_TipoFormaPago.saveCierreCajas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoFormaPagoConstantesFunciones.getClassesForeignKeysOfTipoFormaPago(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoFormaPagoConstantesFunciones.getClassesRelationshipsOfTipoFormaPago(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

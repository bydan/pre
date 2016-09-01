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
import com.bydan.erp.contabilidad.util.TipoComprobanteConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoComprobanteParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoComprobanteParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.TipoComprobante;
//import com.bydan.erp.contabilidad.business.logic.TipoComprobanteLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.sris.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.produccion.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.importaciones.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.produccion.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoComprobanteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoComprobanteLogic.class);
	
	protected TipoComprobanteDataAccess tipocomprobanteDataAccess; 	
	protected TipoComprobante tipocomprobante;
	protected List<TipoComprobante> tipocomprobantes;
	protected Object tipocomprobanteObject;	
	protected List<Object> tipocomprobantesObject;
	
	public static ClassValidator<TipoComprobante> tipocomprobanteValidator = new ClassValidator<TipoComprobante>(TipoComprobante.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
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
	
	
	
	
	public  TipoComprobanteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipocomprobanteDataAccess = new TipoComprobanteDataAccess();
			
			this.tipocomprobantes= new ArrayList<TipoComprobante>();
			this.tipocomprobante= new TipoComprobante();
			
			this.tipocomprobanteObject=new Object();
			this.tipocomprobantesObject=new ArrayList<Object>();
				
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
			
			this.tipocomprobanteDataAccess.setConnexionType(this.connexionType);
			this.tipocomprobanteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoComprobanteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipocomprobanteDataAccess = new TipoComprobanteDataAccess();
			this.tipocomprobantes= new ArrayList<TipoComprobante>();
			this.tipocomprobante= new TipoComprobante();
			this.tipocomprobanteObject=new Object();
			this.tipocomprobantesObject=new ArrayList<Object>();
			
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
			
			this.tipocomprobanteDataAccess.setConnexionType(this.connexionType);
			this.tipocomprobanteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoComprobante getTipoComprobante() throws Exception {	
		//TipoComprobanteLogicAdditional.checkTipoComprobanteToGet(tipocomprobante,this.datosCliente,this.arrDatoGeneral);
		//TipoComprobanteLogicAdditional.updateTipoComprobanteToGet(tipocomprobante,this.arrDatoGeneral);
		
		return tipocomprobante;
	}
		
	public void setTipoComprobante(TipoComprobante newTipoComprobante) {
		this.tipocomprobante = newTipoComprobante;
	}
	
	public TipoComprobanteDataAccess getTipoComprobanteDataAccess() {
		return tipocomprobanteDataAccess;
	}
	
	public void setTipoComprobanteDataAccess(TipoComprobanteDataAccess newtipocomprobanteDataAccess) {
		this.tipocomprobanteDataAccess = newtipocomprobanteDataAccess;
	}
	
	public List<TipoComprobante> getTipoComprobantes() throws Exception {		
		this.quitarTipoComprobantesNulos();
		
		//TipoComprobanteLogicAdditional.checkTipoComprobanteToGets(tipocomprobantes,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoComprobante tipocomprobanteLocal: tipocomprobantes ) {
			//TipoComprobanteLogicAdditional.updateTipoComprobanteToGet(tipocomprobanteLocal,this.arrDatoGeneral);
		}
		
		return tipocomprobantes;
	}
	
	public void setTipoComprobantes(List<TipoComprobante> newTipoComprobantes) {
		this.tipocomprobantes = newTipoComprobantes;
	}
	
	public Object getTipoComprobanteObject() {	
		this.tipocomprobanteObject=this.tipocomprobanteDataAccess.getEntityObject();
		return this.tipocomprobanteObject;
	}
		
	public void setTipoComprobanteObject(Object newTipoComprobanteObject) {
		this.tipocomprobanteObject = newTipoComprobanteObject;
	}
	
	public List<Object> getTipoComprobantesObject() {		
		this.tipocomprobantesObject=this.tipocomprobanteDataAccess.getEntitiesObject();
		return this.tipocomprobantesObject;
	}
		
	public void setTipoComprobantesObject(List<Object> newTipoComprobantesObject) {
		this.tipocomprobantesObject = newTipoComprobantesObject;
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
		
		if(this.tipocomprobanteDataAccess!=null) {
			this.tipocomprobanteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComprobante.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipocomprobanteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipocomprobanteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipocomprobante = new  TipoComprobante();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComprobante.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocomprobante=tipocomprobanteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocomprobante,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(this.tipocomprobante);
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
		tipocomprobante = new  TipoComprobante();
		  		  
        try {
			
			tipocomprobante=tipocomprobanteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocomprobante,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(this.tipocomprobante);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipocomprobante = new  TipoComprobante();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComprobante.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocomprobante=tipocomprobanteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocomprobante,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(this.tipocomprobante);
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
		tipocomprobante = new  TipoComprobante();
		  		  
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
		tipocomprobante = new  TipoComprobante();
		  		  
        try {
			
			tipocomprobante=tipocomprobanteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocomprobante,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(this.tipocomprobante);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipocomprobante = new  TipoComprobante();
		  		  
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
		tipocomprobante = new  TipoComprobante();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComprobante.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipocomprobanteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocomprobante = new  TipoComprobante();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipocomprobanteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocomprobante = new  TipoComprobante();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComprobante.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipocomprobanteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocomprobante = new  TipoComprobante();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipocomprobanteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocomprobante = new  TipoComprobante();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComprobante.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipocomprobanteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocomprobante = new  TipoComprobante();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipocomprobanteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocomprobantes = new  ArrayList<TipoComprobante>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComprobante.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoComprobanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocomprobantes=tipocomprobanteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoComprobante(tipocomprobantes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(this.tipocomprobantes);
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
		tipocomprobantes = new  ArrayList<TipoComprobante>();
		  		  
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
		tipocomprobantes = new  ArrayList<TipoComprobante>();
		  		  
        try {			
			TipoComprobanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocomprobantes=tipocomprobanteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoComprobante(tipocomprobantes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(this.tipocomprobantes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipocomprobantes = new  ArrayList<TipoComprobante>();
		  		  
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
		tipocomprobantes = new  ArrayList<TipoComprobante>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComprobante.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoComprobanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocomprobantes=tipocomprobanteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoComprobante(tipocomprobantes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(this.tipocomprobantes);
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
		tipocomprobantes = new  ArrayList<TipoComprobante>();
		  		  
        try {
			TipoComprobanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocomprobantes=tipocomprobanteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoComprobante(tipocomprobantes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(this.tipocomprobantes);
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
		tipocomprobantes = new  ArrayList<TipoComprobante>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComprobante.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoComprobanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocomprobantes=tipocomprobanteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoComprobante(tipocomprobantes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(this.tipocomprobantes);
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
		tipocomprobantes = new  ArrayList<TipoComprobante>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoComprobanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocomprobantes=tipocomprobanteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoComprobante(tipocomprobantes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(this.tipocomprobantes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipocomprobante = new  TipoComprobante();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComprobante.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoComprobanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocomprobante=tipocomprobanteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoComprobante(tipocomprobante);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(this.tipocomprobante);
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
		tipocomprobante = new  TipoComprobante();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoComprobanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocomprobante=tipocomprobanteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoComprobante(tipocomprobante);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(this.tipocomprobante);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoComprobantesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipocomprobantes = new  ArrayList<TipoComprobante>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComprobante.class.getSimpleName()+"-getTodosTipoComprobantesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoComprobanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocomprobantes=tipocomprobanteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoComprobante(tipocomprobantes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(this.tipocomprobantes);
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
	
	public  void  getTodosTipoComprobantes(String sFinalQuery,Pagination pagination)throws Exception {
		tipocomprobantes = new  ArrayList<TipoComprobante>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoComprobanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocomprobantes=tipocomprobanteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoComprobante(tipocomprobantes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(this.tipocomprobantes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoComprobante(TipoComprobante tipocomprobante) throws Exception {
		Boolean estaValidado=false;
		
		if(tipocomprobante.getIsNew() || tipocomprobante.getIsChanged()) { 
			this.invalidValues = tipocomprobanteValidator.getInvalidValues(tipocomprobante);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipocomprobante);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoComprobante(List<TipoComprobante> TipoComprobantes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoComprobante tipocomprobanteLocal:tipocomprobantes) {				
			estaValidadoObjeto=this.validarGuardarTipoComprobante(tipocomprobanteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoComprobante(List<TipoComprobante> TipoComprobantes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoComprobante(tipocomprobantes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoComprobante(TipoComprobante TipoComprobante) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoComprobante(tipocomprobante)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoComprobante tipocomprobante) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipocomprobante.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoComprobanteConstantesFunciones.getTipoComprobanteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipocomprobante","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoComprobanteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoComprobanteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoComprobanteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComprobante.class.getSimpleName()+"-saveTipoComprobanteWithConnection");connexion.begin();			
			
			//TipoComprobanteLogicAdditional.checkTipoComprobanteToSave(this.tipocomprobante,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoComprobanteLogicAdditional.updateTipoComprobanteToSave(this.tipocomprobante,this.arrDatoGeneral);
			
			TipoComprobanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocomprobante,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoComprobante();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoComprobante(this.tipocomprobante)) {
				TipoComprobanteDataAccess.save(this.tipocomprobante, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipocomprobante,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoComprobanteLogicAdditional.checkTipoComprobanteToSaveAfter(this.tipocomprobante,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoComprobante();
			
			connexion.commit();			
			
			if(this.tipocomprobante.getIsDeleted()) {
				this.tipocomprobante=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoComprobante()throws Exception {	
		try {	
			
			//TipoComprobanteLogicAdditional.checkTipoComprobanteToSave(this.tipocomprobante,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoComprobanteLogicAdditional.updateTipoComprobanteToSave(this.tipocomprobante,this.arrDatoGeneral);
			
			TipoComprobanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocomprobante,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoComprobante(this.tipocomprobante)) {			
				TipoComprobanteDataAccess.save(this.tipocomprobante, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipocomprobante,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoComprobanteLogicAdditional.checkTipoComprobanteToSaveAfter(this.tipocomprobante,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipocomprobante.getIsDeleted()) {
				this.tipocomprobante=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoComprobantesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComprobante.class.getSimpleName()+"-saveTipoComprobantesWithConnection");connexion.begin();			
			
			//TipoComprobanteLogicAdditional.checkTipoComprobanteToSaves(tipocomprobantes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoComprobantes();
			
			Boolean validadoTodosTipoComprobante=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoComprobante tipocomprobanteLocal:tipocomprobantes) {		
				if(tipocomprobanteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoComprobanteLogicAdditional.updateTipoComprobanteToSave(tipocomprobanteLocal,this.arrDatoGeneral);
	        	
				TipoComprobanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocomprobanteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoComprobante(tipocomprobanteLocal)) {
					TipoComprobanteDataAccess.save(tipocomprobanteLocal, connexion);				
				} else {
					validadoTodosTipoComprobante=false;
				}
			}
			
			if(!validadoTodosTipoComprobante) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoComprobanteLogicAdditional.checkTipoComprobanteToSavesAfter(tipocomprobantes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoComprobantes();
			
			connexion.commit();		
			
			this.quitarTipoComprobantesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoComprobantes()throws Exception {				
		 try {	
			//TipoComprobanteLogicAdditional.checkTipoComprobanteToSaves(tipocomprobantes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoComprobante=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoComprobante tipocomprobanteLocal:tipocomprobantes) {				
				if(tipocomprobanteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoComprobanteLogicAdditional.updateTipoComprobanteToSave(tipocomprobanteLocal,this.arrDatoGeneral);
	        	
				TipoComprobanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocomprobanteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoComprobante(tipocomprobanteLocal)) {				
					TipoComprobanteDataAccess.save(tipocomprobanteLocal, connexion);				
				} else {
					validadoTodosTipoComprobante=false;
				}
			}
			
			if(!validadoTodosTipoComprobante) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoComprobanteLogicAdditional.checkTipoComprobanteToSavesAfter(tipocomprobantes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoComprobantesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoComprobanteParameterReturnGeneral procesarAccionTipoComprobantes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoComprobante> tipocomprobantes,TipoComprobanteParameterReturnGeneral tipocomprobanteParameterGeneral)throws Exception {
		 try {	
			TipoComprobanteParameterReturnGeneral tipocomprobanteReturnGeneral=new TipoComprobanteParameterReturnGeneral();
	
			
			return tipocomprobanteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoComprobanteParameterReturnGeneral procesarAccionTipoComprobantesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoComprobante> tipocomprobantes,TipoComprobanteParameterReturnGeneral tipocomprobanteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComprobante.class.getSimpleName()+"-procesarAccionTipoComprobantesWithConnection");connexion.begin();			
			
			TipoComprobanteParameterReturnGeneral tipocomprobanteReturnGeneral=new TipoComprobanteParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipocomprobanteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoComprobanteParameterReturnGeneral procesarEventosTipoComprobantes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoComprobante> tipocomprobantes,TipoComprobante tipocomprobante,TipoComprobanteParameterReturnGeneral tipocomprobanteParameterGeneral,Boolean isEsNuevoTipoComprobante,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoComprobanteParameterReturnGeneral tipocomprobanteReturnGeneral=new TipoComprobanteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocomprobanteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipocomprobanteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoComprobanteParameterReturnGeneral procesarEventosTipoComprobantesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoComprobante> tipocomprobantes,TipoComprobante tipocomprobante,TipoComprobanteParameterReturnGeneral tipocomprobanteParameterGeneral,Boolean isEsNuevoTipoComprobante,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComprobante.class.getSimpleName()+"-procesarEventosTipoComprobantesWithConnection");connexion.begin();			
			
			TipoComprobanteParameterReturnGeneral tipocomprobanteReturnGeneral=new TipoComprobanteParameterReturnGeneral();
	
			tipocomprobanteReturnGeneral.setTipoComprobante(tipocomprobante);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocomprobanteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipocomprobanteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoComprobanteParameterReturnGeneral procesarImportacionTipoComprobantesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoComprobanteParameterReturnGeneral tipocomprobanteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComprobante.class.getSimpleName()+"-procesarImportacionTipoComprobantesWithConnection");connexion.begin();			
			
			TipoComprobanteParameterReturnGeneral tipocomprobanteReturnGeneral=new TipoComprobanteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipocomprobantes=new ArrayList<TipoComprobante>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipocomprobante=new TipoComprobante();
				
				
				if(conColumnasBase) {this.tipocomprobante.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipocomprobante.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipocomprobante.setnombre(arrColumnas[iColumn++]);
				
				this.tipocomprobantes.add(this.tipocomprobante);
			}
			
			this.saveTipoComprobantes();
			
			this.connexion.commit();
			
			tipocomprobanteReturnGeneral.setConRetornoEstaProcesado(true);
			tipocomprobanteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipocomprobanteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoComprobantesEliminados() throws Exception {				
		
		List<TipoComprobante> tipocomprobantesAux= new ArrayList<TipoComprobante>();
		
		for(TipoComprobante tipocomprobante:tipocomprobantes) {
			if(!tipocomprobante.getIsDeleted()) {
				tipocomprobantesAux.add(tipocomprobante);
			}
		}
		
		tipocomprobantes=tipocomprobantesAux;
	}
	
	public void quitarTipoComprobantesNulos() throws Exception {				
		
		List<TipoComprobante> tipocomprobantesAux= new ArrayList<TipoComprobante>();
		
		for(TipoComprobante tipocomprobante : this.tipocomprobantes) {
			if(tipocomprobante==null) {
				tipocomprobantesAux.add(tipocomprobante);
			}
		}
		
		//this.tipocomprobantes=tipocomprobantesAux;
		
		this.tipocomprobantes.removeAll(tipocomprobantesAux);
	}
	
	public void getSetVersionRowTipoComprobanteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipocomprobante.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipocomprobante.getIsDeleted() || (tipocomprobante.getIsChanged()&&!tipocomprobante.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipocomprobanteDataAccess.getSetVersionRowTipoComprobante(connexion,tipocomprobante.getId());
				
				if(!tipocomprobante.getVersionRow().equals(timestamp)) {	
					tipocomprobante.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipocomprobante.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoComprobante()throws Exception {	
		
		if(tipocomprobante.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipocomprobante.getIsDeleted() || (tipocomprobante.getIsChanged()&&!tipocomprobante.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipocomprobanteDataAccess.getSetVersionRowTipoComprobante(connexion,tipocomprobante.getId());
			
			try {							
				if(!tipocomprobante.getVersionRow().equals(timestamp)) {	
					tipocomprobante.setVersionRow(timestamp);
				}
				
				tipocomprobante.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoComprobantesWithConnection()throws Exception {	
		if(tipocomprobantes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoComprobante tipocomprobanteAux:tipocomprobantes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipocomprobanteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocomprobanteAux.getIsDeleted() || (tipocomprobanteAux.getIsChanged()&&!tipocomprobanteAux.getIsNew())) {
						
						timestamp=tipocomprobanteDataAccess.getSetVersionRowTipoComprobante(connexion,tipocomprobanteAux.getId());
						
						if(!tipocomprobante.getVersionRow().equals(timestamp)) {	
							tipocomprobanteAux.setVersionRow(timestamp);
						}
								
						tipocomprobanteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoComprobantes()throws Exception {	
		if(tipocomprobantes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoComprobante tipocomprobanteAux:tipocomprobantes) {
					if(tipocomprobanteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocomprobanteAux.getIsDeleted() || (tipocomprobanteAux.getIsChanged()&&!tipocomprobanteAux.getIsNew())) {
						
						timestamp=tipocomprobanteDataAccess.getSetVersionRowTipoComprobante(connexion,tipocomprobanteAux.getId());
						
						if(!tipocomprobanteAux.getVersionRow().equals(timestamp)) {	
							tipocomprobanteAux.setVersionRow(timestamp);
						}
						
													
						tipocomprobanteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoComprobanteParameterReturnGeneral cargarCombosLoteForeignKeyTipoComprobanteWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoComprobanteParameterReturnGeneral  tipocomprobanteReturnGeneral =new TipoComprobanteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComprobante.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoComprobanteWithConnection");connexion.begin();
			
			tipocomprobanteReturnGeneral =new TipoComprobanteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipocomprobanteReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipocomprobanteReturnGeneral;
	}
	
	public TipoComprobanteParameterReturnGeneral cargarCombosLoteForeignKeyTipoComprobante(String finalQueryGlobalEmpresa) throws Exception {
		TipoComprobanteParameterReturnGeneral  tipocomprobanteReturnGeneral =new TipoComprobanteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipocomprobanteReturnGeneral =new TipoComprobanteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipocomprobanteReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipocomprobanteReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoComprobanteWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			TransaccionLocalLogic transaccionlocalLogic=new TransaccionLocalLogic();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			DocumentoAnuladoLogic documentoanuladoLogic=new DocumentoAnuladoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComprobante.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoComprobanteWithConnection");connexion.begin();
			
			
			classes.add(new Classe(TransaccionLocal.class));
			classes.add(new Classe(Transaccion.class));
			classes.add(new Classe(DocumentoAnulado.class));
											
			

			transaccionlocalLogic.setConnexion(this.getConnexion());
			transaccionlocalLogic.setDatosCliente(this.datosCliente);
			transaccionlocalLogic.setIsConRefrescarForeignKeys(true);

			transaccionLogic.setConnexion(this.getConnexion());
			transaccionLogic.setDatosCliente(this.datosCliente);
			transaccionLogic.setIsConRefrescarForeignKeys(true);

			documentoanuladoLogic.setConnexion(this.getConnexion());
			documentoanuladoLogic.setDatosCliente(this.datosCliente);
			documentoanuladoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoComprobante tipocomprobante:this.tipocomprobantes) {
				

				classes=new ArrayList<Classe>();
				classes=TransaccionLocalConstantesFunciones.getClassesForeignKeysOfTransaccionLocal(new ArrayList<Classe>(),DeepLoadType.NONE);

				transaccionlocalLogic.setTransaccionLocals(tipocomprobante.transaccionlocals);
				transaccionlocalLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=TransaccionConstantesFunciones.getClassesForeignKeysOfTransaccion(new ArrayList<Classe>(),DeepLoadType.NONE);

				transaccionLogic.setTransaccions(tipocomprobante.transaccions);
				transaccionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DocumentoAnuladoConstantesFunciones.getClassesForeignKeysOfDocumentoAnulado(new ArrayList<Classe>(),DeepLoadType.NONE);

				documentoanuladoLogic.setDocumentoAnulados(tipocomprobante.documentoanulados);
				documentoanuladoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoComprobante tipocomprobante,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoComprobanteLogicAdditional.updateTipoComprobanteToGet(tipocomprobante,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocomprobante.setEmpresa(tipocomprobanteDataAccess.getEmpresa(connexion,tipocomprobante));
		tipocomprobante.setTransaccionLocals(tipocomprobanteDataAccess.getTransaccionLocals(connexion,tipocomprobante));
		tipocomprobante.setTransaccions(tipocomprobanteDataAccess.getTransaccions(connexion,tipocomprobante));
		tipocomprobante.setDocumentoAnulados(tipocomprobanteDataAccess.getDocumentoAnulados(connexion,tipocomprobante));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipocomprobante.setEmpresa(tipocomprobanteDataAccess.getEmpresa(connexion,tipocomprobante));
				continue;
			}

			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocomprobante.setTransaccionLocals(tipocomprobanteDataAccess.getTransaccionLocals(connexion,tipocomprobante));

				if(this.isConDeep) {
					TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(this.connexion);
					transaccionlocalLogic.setTransaccionLocals(tipocomprobante.getTransaccionLocals());
					ArrayList<Classe> classesLocal=TransaccionLocalConstantesFunciones.getClassesForeignKeysOfTransaccionLocal(new ArrayList<Classe>(),DeepLoadType.NONE);
					transaccionlocalLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(transaccionlocalLogic.getTransaccionLocals());
					tipocomprobante.setTransaccionLocals(transaccionlocalLogic.getTransaccionLocals());
				}

				continue;
			}

			if(clas.clas.equals(Transaccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocomprobante.setTransaccions(tipocomprobanteDataAccess.getTransaccions(connexion,tipocomprobante));

				if(this.isConDeep) {
					TransaccionLogic transaccionLogic= new TransaccionLogic(this.connexion);
					transaccionLogic.setTransaccions(tipocomprobante.getTransaccions());
					ArrayList<Classe> classesLocal=TransaccionConstantesFunciones.getClassesForeignKeysOfTransaccion(new ArrayList<Classe>(),DeepLoadType.NONE);
					transaccionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TransaccionConstantesFunciones.refrescarForeignKeysDescripcionesTransaccion(transaccionLogic.getTransaccions());
					tipocomprobante.setTransaccions(transaccionLogic.getTransaccions());
				}

				continue;
			}

			if(clas.clas.equals(DocumentoAnulado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocomprobante.setDocumentoAnulados(tipocomprobanteDataAccess.getDocumentoAnulados(connexion,tipocomprobante));

				if(this.isConDeep) {
					DocumentoAnuladoLogic documentoanuladoLogic= new DocumentoAnuladoLogic(this.connexion);
					documentoanuladoLogic.setDocumentoAnulados(tipocomprobante.getDocumentoAnulados());
					ArrayList<Classe> classesLocal=DocumentoAnuladoConstantesFunciones.getClassesForeignKeysOfDocumentoAnulado(new ArrayList<Classe>(),DeepLoadType.NONE);
					documentoanuladoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DocumentoAnuladoConstantesFunciones.refrescarForeignKeysDescripcionesDocumentoAnulado(documentoanuladoLogic.getDocumentoAnulados());
					tipocomprobante.setDocumentoAnulados(documentoanuladoLogic.getDocumentoAnulados());
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
			tipocomprobante.setEmpresa(tipocomprobanteDataAccess.getEmpresa(connexion,tipocomprobante));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TransaccionLocal.class));
			tipocomprobante.setTransaccionLocals(tipocomprobanteDataAccess.getTransaccionLocals(connexion,tipocomprobante));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Transaccion.class));
			tipocomprobante.setTransaccions(tipocomprobanteDataAccess.getTransaccions(connexion,tipocomprobante));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DocumentoAnulado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DocumentoAnulado.class));
			tipocomprobante.setDocumentoAnulados(tipocomprobanteDataAccess.getDocumentoAnulados(connexion,tipocomprobante));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocomprobante.setEmpresa(tipocomprobanteDataAccess.getEmpresa(connexion,tipocomprobante));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipocomprobante.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipocomprobante.setTransaccionLocals(tipocomprobanteDataAccess.getTransaccionLocals(connexion,tipocomprobante));

		for(TransaccionLocal transaccionlocal:tipocomprobante.getTransaccionLocals()) {
			TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
			transaccionlocalLogic.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
		}

		tipocomprobante.setTransaccions(tipocomprobanteDataAccess.getTransaccions(connexion,tipocomprobante));

		for(Transaccion transaccion:tipocomprobante.getTransaccions()) {
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(transaccion,isDeep,deepLoadType,clases);
		}

		tipocomprobante.setDocumentoAnulados(tipocomprobanteDataAccess.getDocumentoAnulados(connexion,tipocomprobante));

		for(DocumentoAnulado documentoanulado:tipocomprobante.getDocumentoAnulados()) {
			DocumentoAnuladoLogic documentoanuladoLogic= new DocumentoAnuladoLogic(connexion);
			documentoanuladoLogic.deepLoad(documentoanulado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipocomprobante.setEmpresa(tipocomprobanteDataAccess.getEmpresa(connexion,tipocomprobante));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipocomprobante.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocomprobante.setTransaccionLocals(tipocomprobanteDataAccess.getTransaccionLocals(connexion,tipocomprobante));

				for(TransaccionLocal transaccionlocal:tipocomprobante.getTransaccionLocals()) {
					TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
					transaccionlocalLogic.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Transaccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocomprobante.setTransaccions(tipocomprobanteDataAccess.getTransaccions(connexion,tipocomprobante));

				for(Transaccion transaccion:tipocomprobante.getTransaccions()) {
					TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
					transaccionLogic.deepLoad(transaccion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DocumentoAnulado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocomprobante.setDocumentoAnulados(tipocomprobanteDataAccess.getDocumentoAnulados(connexion,tipocomprobante));

				for(DocumentoAnulado documentoanulado:tipocomprobante.getDocumentoAnulados()) {
					DocumentoAnuladoLogic documentoanuladoLogic= new DocumentoAnuladoLogic(connexion);
					documentoanuladoLogic.deepLoad(documentoanulado,isDeep,deepLoadType,clases);
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
			tipocomprobante.setEmpresa(tipocomprobanteDataAccess.getEmpresa(connexion,tipocomprobante));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipocomprobante.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TransaccionLocal.class));
			tipocomprobante.setTransaccionLocals(tipocomprobanteDataAccess.getTransaccionLocals(connexion,tipocomprobante));

			for(TransaccionLocal transaccionlocal:tipocomprobante.getTransaccionLocals()) {
				TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
				transaccionlocalLogic.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Transaccion.class));
			tipocomprobante.setTransaccions(tipocomprobanteDataAccess.getTransaccions(connexion,tipocomprobante));

			for(Transaccion transaccion:tipocomprobante.getTransaccions()) {
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(transaccion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DocumentoAnulado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DocumentoAnulado.class));
			tipocomprobante.setDocumentoAnulados(tipocomprobanteDataAccess.getDocumentoAnulados(connexion,tipocomprobante));

			for(DocumentoAnulado documentoanulado:tipocomprobante.getDocumentoAnulados()) {
				DocumentoAnuladoLogic documentoanuladoLogic= new DocumentoAnuladoLogic(connexion);
				documentoanuladoLogic.deepLoad(documentoanulado,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoComprobante tipocomprobante,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoComprobante.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipocomprobante,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(tipocomprobante);
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
			this.deepLoad(this.tipocomprobante,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(this.tipocomprobante);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoComprobante.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipocomprobantes!=null) {
				for(TipoComprobante tipocomprobante:tipocomprobantes) {
					this.deepLoad(tipocomprobante,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(tipocomprobantes);
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
			if(tipocomprobantes!=null) {
				for(TipoComprobante tipocomprobante:tipocomprobantes) {
					this.deepLoad(tipocomprobante,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(tipocomprobantes);
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
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoComprobantesBusquedaPorIdWithConnection(String sFinalQuery,Pagination pagination,Long id)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComprobante.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TipoComprobanteConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			TipoComprobanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorId","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocomprobantes=tipocomprobanteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(this.tipocomprobantes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoComprobantesBusquedaPorId(String sFinalQuery,Pagination pagination,Long id)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TipoComprobanteConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			TipoComprobanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorId","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocomprobantes=tipocomprobanteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(this.tipocomprobantes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoComprobantesBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComprobante.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoComprobanteConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoComprobanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocomprobantes=tipocomprobanteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(this.tipocomprobantes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoComprobantesBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoComprobanteConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoComprobanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocomprobantes=tipocomprobanteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(this.tipocomprobantes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoComprobantesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoComprobante.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoComprobanteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoComprobanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocomprobantes=tipocomprobanteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(this.tipocomprobantes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoComprobantesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoComprobanteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoComprobanteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocomprobantes=tipocomprobanteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoComprobanteConstantesFunciones.refrescarForeignKeysDescripcionesTipoComprobante(this.tipocomprobantes);
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
			if(TipoComprobanteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoComprobanteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoComprobante tipocomprobante,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoComprobanteConstantesFunciones.ISCONAUDITORIA) {
				if(tipocomprobante.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoComprobanteDataAccess.TABLENAME, tipocomprobante.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoComprobanteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoComprobanteLogic.registrarAuditoriaDetallesTipoComprobante(connexion,tipocomprobante,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipocomprobante.getIsDeleted()) {
					/*if(!tipocomprobante.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoComprobanteDataAccess.TABLENAME, tipocomprobante.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoComprobanteLogic.registrarAuditoriaDetallesTipoComprobante(connexion,tipocomprobante,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoComprobanteDataAccess.TABLENAME, tipocomprobante.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipocomprobante.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoComprobanteDataAccess.TABLENAME, tipocomprobante.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoComprobanteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoComprobanteLogic.registrarAuditoriaDetallesTipoComprobante(connexion,tipocomprobante,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoComprobante(Connexion connexion,TipoComprobante tipocomprobante)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipocomprobante.getIsNew()||!tipocomprobante.getid_empresa().equals(tipocomprobante.getTipoComprobanteOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocomprobante.getTipoComprobanteOriginal().getid_empresa()!=null)
				{
					strValorActual=tipocomprobante.getTipoComprobanteOriginal().getid_empresa().toString();
				}
				if(tipocomprobante.getid_empresa()!=null)
				{
					strValorNuevo=tipocomprobante.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoComprobanteConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipocomprobante.getIsNew()||!tipocomprobante.getnombre().equals(tipocomprobante.getTipoComprobanteOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocomprobante.getTipoComprobanteOriginal().getnombre()!=null)
				{
					strValorActual=tipocomprobante.getTipoComprobanteOriginal().getnombre();
				}
				if(tipocomprobante.getnombre()!=null)
				{
					strValorNuevo=tipocomprobante.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoComprobanteConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoComprobante(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoComprobanteConstantesFunciones.getClassesForeignKeysOfTipoComprobante(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoComprobante(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoComprobanteConstantesFunciones.getClassesRelationshipsOfTipoComprobante(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

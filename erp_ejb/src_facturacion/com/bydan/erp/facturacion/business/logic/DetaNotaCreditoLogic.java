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
import com.bydan.erp.facturacion.util.DetaNotaCreditoConstantesFunciones;
import com.bydan.erp.facturacion.util.DetaNotaCreditoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetaNotaCreditoParameterGeneral;
import com.bydan.erp.facturacion.business.entity.DetaNotaCredito;
import com.bydan.erp.facturacion.business.logic.DetaNotaCreditoLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetaNotaCreditoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetaNotaCreditoLogic.class);
	
	protected DetaNotaCreditoDataAccess detanotacreditoDataAccess; 	
	protected DetaNotaCredito detanotacredito;
	protected List<DetaNotaCredito> detanotacreditos;
	protected Object detanotacreditoObject;	
	protected List<Object> detanotacreditosObject;
	
	public static ClassValidator<DetaNotaCredito> detanotacreditoValidator = new ClassValidator<DetaNotaCredito>(DetaNotaCredito.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetaNotaCreditoLogicAdditional detanotacreditoLogicAdditional=null;
	
	public DetaNotaCreditoLogicAdditional getDetaNotaCreditoLogicAdditional() {
		return this.detanotacreditoLogicAdditional;
	}
	
	public void setDetaNotaCreditoLogicAdditional(DetaNotaCreditoLogicAdditional detanotacreditoLogicAdditional) {
		try {
			this.detanotacreditoLogicAdditional=detanotacreditoLogicAdditional;
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
	
	
	
	
	public  DetaNotaCreditoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detanotacreditoDataAccess = new DetaNotaCreditoDataAccess();
			
			this.detanotacreditos= new ArrayList<DetaNotaCredito>();
			this.detanotacredito= new DetaNotaCredito();
			
			this.detanotacreditoObject=new Object();
			this.detanotacreditosObject=new ArrayList<Object>();
				
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
			
			this.detanotacreditoDataAccess.setConnexionType(this.connexionType);
			this.detanotacreditoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetaNotaCreditoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detanotacreditoDataAccess = new DetaNotaCreditoDataAccess();
			this.detanotacreditos= new ArrayList<DetaNotaCredito>();
			this.detanotacredito= new DetaNotaCredito();
			this.detanotacreditoObject=new Object();
			this.detanotacreditosObject=new ArrayList<Object>();
			
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
			
			this.detanotacreditoDataAccess.setConnexionType(this.connexionType);
			this.detanotacreditoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetaNotaCredito getDetaNotaCredito() throws Exception {	
		DetaNotaCreditoLogicAdditional.checkDetaNotaCreditoToGet(detanotacredito,this.datosCliente,this.arrDatoGeneral);
		DetaNotaCreditoLogicAdditional.updateDetaNotaCreditoToGet(detanotacredito,this.arrDatoGeneral);
		
		return detanotacredito;
	}
		
	public void setDetaNotaCredito(DetaNotaCredito newDetaNotaCredito) {
		this.detanotacredito = newDetaNotaCredito;
	}
	
	public DetaNotaCreditoDataAccess getDetaNotaCreditoDataAccess() {
		return detanotacreditoDataAccess;
	}
	
	public void setDetaNotaCreditoDataAccess(DetaNotaCreditoDataAccess newdetanotacreditoDataAccess) {
		this.detanotacreditoDataAccess = newdetanotacreditoDataAccess;
	}
	
	public List<DetaNotaCredito> getDetaNotaCreditos() throws Exception {		
		this.quitarDetaNotaCreditosNulos();
		
		DetaNotaCreditoLogicAdditional.checkDetaNotaCreditoToGets(detanotacreditos,this.datosCliente,this.arrDatoGeneral);
		
		for (DetaNotaCredito detanotacreditoLocal: detanotacreditos ) {
			DetaNotaCreditoLogicAdditional.updateDetaNotaCreditoToGet(detanotacreditoLocal,this.arrDatoGeneral);
		}
		
		return detanotacreditos;
	}
	
	public void setDetaNotaCreditos(List<DetaNotaCredito> newDetaNotaCreditos) {
		this.detanotacreditos = newDetaNotaCreditos;
	}
	
	public Object getDetaNotaCreditoObject() {	
		this.detanotacreditoObject=this.detanotacreditoDataAccess.getEntityObject();
		return this.detanotacreditoObject;
	}
		
	public void setDetaNotaCreditoObject(Object newDetaNotaCreditoObject) {
		this.detanotacreditoObject = newDetaNotaCreditoObject;
	}
	
	public List<Object> getDetaNotaCreditosObject() {		
		this.detanotacreditosObject=this.detanotacreditoDataAccess.getEntitiesObject();
		return this.detanotacreditosObject;
	}
		
	public void setDetaNotaCreditosObject(List<Object> newDetaNotaCreditosObject) {
		this.detanotacreditosObject = newDetaNotaCreditosObject;
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
		
		if(this.detanotacreditoDataAccess!=null) {
			this.detanotacreditoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detanotacreditoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detanotacreditoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detanotacredito = new  DetaNotaCredito();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detanotacredito=detanotacreditoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detanotacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacredito);
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
		detanotacredito = new  DetaNotaCredito();
		  		  
        try {
			
			detanotacredito=detanotacreditoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detanotacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacredito);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detanotacredito = new  DetaNotaCredito();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detanotacredito=detanotacreditoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detanotacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacredito);
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
		detanotacredito = new  DetaNotaCredito();
		  		  
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
		detanotacredito = new  DetaNotaCredito();
		  		  
        try {
			
			detanotacredito=detanotacreditoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detanotacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacredito);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detanotacredito = new  DetaNotaCredito();
		  		  
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
		detanotacredito = new  DetaNotaCredito();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detanotacreditoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detanotacredito = new  DetaNotaCredito();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detanotacreditoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detanotacredito = new  DetaNotaCredito();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detanotacreditoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detanotacredito = new  DetaNotaCredito();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detanotacreditoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detanotacredito = new  DetaNotaCredito();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detanotacreditoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detanotacredito = new  DetaNotaCredito();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detanotacreditoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detanotacreditos = new  ArrayList<DetaNotaCredito>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetaNotaCredito(detanotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
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
		detanotacreditos = new  ArrayList<DetaNotaCredito>();
		  		  
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
		detanotacreditos = new  ArrayList<DetaNotaCredito>();
		  		  
        try {			
			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetaNotaCredito(detanotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detanotacreditos = new  ArrayList<DetaNotaCredito>();
		  		  
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
		detanotacreditos = new  ArrayList<DetaNotaCredito>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetaNotaCredito(detanotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
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
		detanotacreditos = new  ArrayList<DetaNotaCredito>();
		  		  
        try {
			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetaNotaCredito(detanotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
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
		detanotacreditos = new  ArrayList<DetaNotaCredito>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetaNotaCredito(detanotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
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
		detanotacreditos = new  ArrayList<DetaNotaCredito>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetaNotaCredito(detanotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detanotacredito = new  DetaNotaCredito();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacredito=detanotacreditoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetaNotaCredito(detanotacredito);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacredito);
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
		detanotacredito = new  DetaNotaCredito();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacredito=detanotacreditoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetaNotaCredito(detanotacredito);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacredito);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detanotacreditos = new  ArrayList<DetaNotaCredito>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacreditos=detanotacreditoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetaNotaCredito(detanotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
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
		detanotacreditos = new  ArrayList<DetaNotaCredito>();
		  		  
        try {
			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacreditos=detanotacreditoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetaNotaCredito(detanotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetaNotaCreditosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detanotacreditos = new  ArrayList<DetaNotaCredito>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getTodosDetaNotaCreditosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetaNotaCredito(detanotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
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
	
	public  void  getTodosDetaNotaCreditos(String sFinalQuery,Pagination pagination)throws Exception {
		detanotacreditos = new  ArrayList<DetaNotaCredito>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetaNotaCredito(detanotacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetaNotaCredito(DetaNotaCredito detanotacredito) throws Exception {
		Boolean estaValidado=false;
		
		if(detanotacredito.getIsNew() || detanotacredito.getIsChanged()) { 
			this.invalidValues = detanotacreditoValidator.getInvalidValues(detanotacredito);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detanotacredito);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetaNotaCredito(List<DetaNotaCredito> DetaNotaCreditos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetaNotaCredito detanotacreditoLocal:detanotacreditos) {				
			estaValidadoObjeto=this.validarGuardarDetaNotaCredito(detanotacreditoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetaNotaCredito(List<DetaNotaCredito> DetaNotaCreditos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetaNotaCredito(detanotacreditos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetaNotaCredito(DetaNotaCredito DetaNotaCredito) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetaNotaCredito(detanotacredito)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetaNotaCredito detanotacredito) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detanotacredito.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetaNotaCreditoConstantesFunciones.getDetaNotaCreditoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detanotacredito","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetaNotaCreditoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetaNotaCreditoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetaNotaCreditoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-saveDetaNotaCreditoWithConnection");connexion.begin();			
			
			DetaNotaCreditoLogicAdditional.checkDetaNotaCreditoToSave(this.detanotacredito,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetaNotaCreditoLogicAdditional.updateDetaNotaCreditoToSave(this.detanotacredito,this.arrDatoGeneral);
			
			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detanotacredito,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetaNotaCredito();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetaNotaCredito(this.detanotacredito)) {
				DetaNotaCreditoDataAccess.save(this.detanotacredito, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detanotacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetaNotaCreditoLogicAdditional.checkDetaNotaCreditoToSaveAfter(this.detanotacredito,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetaNotaCredito();
			
			connexion.commit();			
			
			if(this.detanotacredito.getIsDeleted()) {
				this.detanotacredito=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetaNotaCredito()throws Exception {	
		try {	
			
			DetaNotaCreditoLogicAdditional.checkDetaNotaCreditoToSave(this.detanotacredito,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetaNotaCreditoLogicAdditional.updateDetaNotaCreditoToSave(this.detanotacredito,this.arrDatoGeneral);
			
			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detanotacredito,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetaNotaCredito(this.detanotacredito)) {			
				DetaNotaCreditoDataAccess.save(this.detanotacredito, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detanotacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetaNotaCreditoLogicAdditional.checkDetaNotaCreditoToSaveAfter(this.detanotacredito,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detanotacredito.getIsDeleted()) {
				this.detanotacredito=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetaNotaCreditosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-saveDetaNotaCreditosWithConnection");connexion.begin();			
			
			DetaNotaCreditoLogicAdditional.checkDetaNotaCreditoToSaves(detanotacreditos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetaNotaCreditos();
			
			Boolean validadoTodosDetaNotaCredito=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetaNotaCredito detanotacreditoLocal:detanotacreditos) {		
				if(detanotacreditoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetaNotaCreditoLogicAdditional.updateDetaNotaCreditoToSave(detanotacreditoLocal,this.arrDatoGeneral);
	        	
				DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detanotacreditoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetaNotaCredito(detanotacreditoLocal)) {
					DetaNotaCreditoDataAccess.save(detanotacreditoLocal, connexion);				
				} else {
					validadoTodosDetaNotaCredito=false;
				}
			}
			
			if(!validadoTodosDetaNotaCredito) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetaNotaCreditoLogicAdditional.checkDetaNotaCreditoToSavesAfter(detanotacreditos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetaNotaCreditos();
			
			connexion.commit();		
			
			this.quitarDetaNotaCreditosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetaNotaCreditos()throws Exception {				
		 try {	
			DetaNotaCreditoLogicAdditional.checkDetaNotaCreditoToSaves(detanotacreditos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetaNotaCredito=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetaNotaCredito detanotacreditoLocal:detanotacreditos) {				
				if(detanotacreditoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetaNotaCreditoLogicAdditional.updateDetaNotaCreditoToSave(detanotacreditoLocal,this.arrDatoGeneral);
	        	
				DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detanotacreditoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetaNotaCredito(detanotacreditoLocal)) {				
					DetaNotaCreditoDataAccess.save(detanotacreditoLocal, connexion);				
				} else {
					validadoTodosDetaNotaCredito=false;
				}
			}
			
			if(!validadoTodosDetaNotaCredito) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetaNotaCreditoLogicAdditional.checkDetaNotaCreditoToSavesAfter(detanotacreditos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetaNotaCreditosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetaNotaCreditoParameterReturnGeneral procesarAccionDetaNotaCreditos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetaNotaCredito> detanotacreditos,DetaNotaCreditoParameterReturnGeneral detanotacreditoParameterGeneral)throws Exception {
		 try {	
			DetaNotaCreditoParameterReturnGeneral detanotacreditoReturnGeneral=new DetaNotaCreditoParameterReturnGeneral();
	
			DetaNotaCreditoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detanotacreditos,detanotacreditoParameterGeneral,detanotacreditoReturnGeneral);
			
			return detanotacreditoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetaNotaCreditoParameterReturnGeneral procesarAccionDetaNotaCreditosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetaNotaCredito> detanotacreditos,DetaNotaCreditoParameterReturnGeneral detanotacreditoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-procesarAccionDetaNotaCreditosWithConnection");connexion.begin();			
			
			DetaNotaCreditoParameterReturnGeneral detanotacreditoReturnGeneral=new DetaNotaCreditoParameterReturnGeneral();
	
			DetaNotaCreditoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detanotacreditos,detanotacreditoParameterGeneral,detanotacreditoReturnGeneral);
			
			this.connexion.commit();
			
			return detanotacreditoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetaNotaCreditoParameterReturnGeneral procesarEventosDetaNotaCreditos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetaNotaCredito> detanotacreditos,DetaNotaCredito detanotacredito,DetaNotaCreditoParameterReturnGeneral detanotacreditoParameterGeneral,Boolean isEsNuevoDetaNotaCredito,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetaNotaCreditoParameterReturnGeneral detanotacreditoReturnGeneral=new DetaNotaCreditoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detanotacreditoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetaNotaCreditoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detanotacreditos,detanotacredito,detanotacreditoParameterGeneral,detanotacreditoReturnGeneral,isEsNuevoDetaNotaCredito,clases);
			
			return detanotacreditoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetaNotaCreditoParameterReturnGeneral procesarEventosDetaNotaCreditosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetaNotaCredito> detanotacreditos,DetaNotaCredito detanotacredito,DetaNotaCreditoParameterReturnGeneral detanotacreditoParameterGeneral,Boolean isEsNuevoDetaNotaCredito,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-procesarEventosDetaNotaCreditosWithConnection");connexion.begin();			
			
			DetaNotaCreditoParameterReturnGeneral detanotacreditoReturnGeneral=new DetaNotaCreditoParameterReturnGeneral();
	
			detanotacreditoReturnGeneral.setDetaNotaCredito(detanotacredito);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detanotacreditoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetaNotaCreditoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detanotacreditos,detanotacredito,detanotacreditoParameterGeneral,detanotacreditoReturnGeneral,isEsNuevoDetaNotaCredito,clases);
			
			this.connexion.commit();
			
			return detanotacreditoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetaNotaCreditoParameterReturnGeneral procesarImportacionDetaNotaCreditosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetaNotaCreditoParameterReturnGeneral detanotacreditoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-procesarImportacionDetaNotaCreditosWithConnection");connexion.begin();			
			
			DetaNotaCreditoParameterReturnGeneral detanotacreditoReturnGeneral=new DetaNotaCreditoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detanotacreditos=new ArrayList<DetaNotaCredito>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detanotacredito=new DetaNotaCredito();
				
				
				if(conColumnasBase) {this.detanotacredito.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detanotacredito.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detanotacredito.setdescripcion(arrColumnas[iColumn++]);
				this.detanotacredito.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.detanotacredito.setprecio(Double.parseDouble(arrColumnas[iColumn++]));
				this.detanotacredito.setmonto(Double.parseDouble(arrColumnas[iColumn++]));
				this.detanotacredito.setcosto(Double.parseDouble(arrColumnas[iColumn++]));
				this.detanotacredito.setdescuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.detanotacredito.setdescuento2(Double.parseDouble(arrColumnas[iColumn++]));
				this.detanotacredito.setimpuesto(Double.parseDouble(arrColumnas[iColumn++]));
				this.detanotacredito.setporcen_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.detanotacredito.setporcen_descuen(Double.parseDouble(arrColumnas[iColumn++]));
				this.detanotacredito.setporcen_ice(Double.parseDouble(arrColumnas[iColumn++]));
				this.detanotacredito.setsub_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.detanotacredito.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				this.detanotacredito.setincluye_impuesto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.detanotacredito.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detanotacredito.setcodigo_lote(arrColumnas[iColumn++]);
				this.detanotacredito.setnumero_caja(arrColumnas[iColumn++]);
				
				this.detanotacreditos.add(this.detanotacredito);
			}
			
			this.saveDetaNotaCreditos();
			
			this.connexion.commit();
			
			detanotacreditoReturnGeneral.setConRetornoEstaProcesado(true);
			detanotacreditoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detanotacreditoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetaNotaCreditosEliminados() throws Exception {				
		
		List<DetaNotaCredito> detanotacreditosAux= new ArrayList<DetaNotaCredito>();
		
		for(DetaNotaCredito detanotacredito:detanotacreditos) {
			if(!detanotacredito.getIsDeleted()) {
				detanotacreditosAux.add(detanotacredito);
			}
		}
		
		detanotacreditos=detanotacreditosAux;
	}
	
	public void quitarDetaNotaCreditosNulos() throws Exception {				
		
		List<DetaNotaCredito> detanotacreditosAux= new ArrayList<DetaNotaCredito>();
		
		for(DetaNotaCredito detanotacredito : this.detanotacreditos) {
			if(detanotacredito==null) {
				detanotacreditosAux.add(detanotacredito);
			}
		}
		
		//this.detanotacreditos=detanotacreditosAux;
		
		this.detanotacreditos.removeAll(detanotacreditosAux);
	}
	
	public void getSetVersionRowDetaNotaCreditoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detanotacredito.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detanotacredito.getIsDeleted() || (detanotacredito.getIsChanged()&&!detanotacredito.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detanotacreditoDataAccess.getSetVersionRowDetaNotaCredito(connexion,detanotacredito.getId());
				
				if(!detanotacredito.getVersionRow().equals(timestamp)) {	
					detanotacredito.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detanotacredito.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetaNotaCredito()throws Exception {	
		
		if(detanotacredito.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detanotacredito.getIsDeleted() || (detanotacredito.getIsChanged()&&!detanotacredito.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detanotacreditoDataAccess.getSetVersionRowDetaNotaCredito(connexion,detanotacredito.getId());
			
			try {							
				if(!detanotacredito.getVersionRow().equals(timestamp)) {	
					detanotacredito.setVersionRow(timestamp);
				}
				
				detanotacredito.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetaNotaCreditosWithConnection()throws Exception {	
		if(detanotacreditos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetaNotaCredito detanotacreditoAux:detanotacreditos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detanotacreditoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detanotacreditoAux.getIsDeleted() || (detanotacreditoAux.getIsChanged()&&!detanotacreditoAux.getIsNew())) {
						
						timestamp=detanotacreditoDataAccess.getSetVersionRowDetaNotaCredito(connexion,detanotacreditoAux.getId());
						
						if(!detanotacredito.getVersionRow().equals(timestamp)) {	
							detanotacreditoAux.setVersionRow(timestamp);
						}
								
						detanotacreditoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetaNotaCreditos()throws Exception {	
		if(detanotacreditos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetaNotaCredito detanotacreditoAux:detanotacreditos) {
					if(detanotacreditoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detanotacreditoAux.getIsDeleted() || (detanotacreditoAux.getIsChanged()&&!detanotacreditoAux.getIsNew())) {
						
						timestamp=detanotacreditoDataAccess.getSetVersionRowDetaNotaCredito(connexion,detanotacreditoAux.getId());
						
						if(!detanotacreditoAux.getVersionRow().equals(timestamp)) {	
							detanotacreditoAux.setVersionRow(timestamp);
						}
						
													
						detanotacreditoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetaNotaCreditoParameterReturnGeneral cargarCombosLoteForeignKeyDetaNotaCreditoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalNotaCredito,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalTipoDetaNotaCredito,String finalQueryGlobalTipoDevolucionEmpresa,String finalQueryGlobalCentroCosto,String finalQueryGlobalEmpaque) throws Exception {
		DetaNotaCreditoParameterReturnGeneral  detanotacreditoReturnGeneral =new DetaNotaCreditoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetaNotaCreditoWithConnection");connexion.begin();
			
			detanotacreditoReturnGeneral =new DetaNotaCreditoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detanotacreditoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detanotacreditoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detanotacreditoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detanotacreditoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detanotacreditoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detanotacreditoReturnGeneral.setmessForeignKey(messForeignKey);


			List<NotaCredito> notacreditosForeignKey=new ArrayList<NotaCredito>();
			NotaCreditoLogic notacreditoLogic=new NotaCreditoLogic();
			notacreditoLogic.setConnexion(this.connexion);
			notacreditoLogic.getNotaCreditoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNotaCredito.equals("NONE")) {
				notacreditoLogic.getTodosNotaCreditos(finalQueryGlobalNotaCredito,new Pagination());
				notacreditosForeignKey=notacreditoLogic.getNotaCreditos();
			}

			detanotacreditoReturnGeneral.setnotacreditosForeignKey(notacreditosForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detanotacreditoReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detanotacreditoReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detanotacreditoReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<TipoDetaNotaCredito> tipodetanotacreditosForeignKey=new ArrayList<TipoDetaNotaCredito>();
			TipoDetaNotaCreditoLogic tipodetanotacreditoLogic=new TipoDetaNotaCreditoLogic();
			tipodetanotacreditoLogic.setConnexion(this.connexion);
			tipodetanotacreditoLogic.getTipoDetaNotaCreditoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDetaNotaCredito.equals("NONE")) {
				tipodetanotacreditoLogic.getTodosTipoDetaNotaCreditos(finalQueryGlobalTipoDetaNotaCredito,new Pagination());
				tipodetanotacreditosForeignKey=tipodetanotacreditoLogic.getTipoDetaNotaCreditos();
			}

			detanotacreditoReturnGeneral.settipodetanotacreditosForeignKey(tipodetanotacreditosForeignKey);


			List<TipoDevolucionEmpresa> tipodevolucionempresasForeignKey=new ArrayList<TipoDevolucionEmpresa>();
			TipoDevolucionEmpresaLogic tipodevolucionempresaLogic=new TipoDevolucionEmpresaLogic();
			tipodevolucionempresaLogic.setConnexion(this.connexion);
			tipodevolucionempresaLogic.getTipoDevolucionEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDevolucionEmpresa.equals("NONE")) {
				tipodevolucionempresaLogic.getTodosTipoDevolucionEmpresas(finalQueryGlobalTipoDevolucionEmpresa,new Pagination());
				tipodevolucionempresasForeignKey=tipodevolucionempresaLogic.getTipoDevolucionEmpresas();
			}

			detanotacreditoReturnGeneral.settipodevolucionempresasForeignKey(tipodevolucionempresasForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detanotacreditoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Empaque> empaquesForeignKey=new ArrayList<Empaque>();
			EmpaqueLogic empaqueLogic=new EmpaqueLogic();
			empaqueLogic.setConnexion(this.connexion);
			empaqueLogic.getEmpaqueDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpaque.equals("NONE")) {
				empaqueLogic.getTodosEmpaques(finalQueryGlobalEmpaque,new Pagination());
				empaquesForeignKey=empaqueLogic.getEmpaques();
			}

			detanotacreditoReturnGeneral.setempaquesForeignKey(empaquesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detanotacreditoReturnGeneral;
	}
	
	public DetaNotaCreditoParameterReturnGeneral cargarCombosLoteForeignKeyDetaNotaCredito(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalNotaCredito,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalTipoDetaNotaCredito,String finalQueryGlobalTipoDevolucionEmpresa,String finalQueryGlobalCentroCosto,String finalQueryGlobalEmpaque) throws Exception {
		DetaNotaCreditoParameterReturnGeneral  detanotacreditoReturnGeneral =new DetaNotaCreditoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detanotacreditoReturnGeneral =new DetaNotaCreditoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detanotacreditoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detanotacreditoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detanotacreditoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detanotacreditoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detanotacreditoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detanotacreditoReturnGeneral.setmessForeignKey(messForeignKey);


			List<NotaCredito> notacreditosForeignKey=new ArrayList<NotaCredito>();
			NotaCreditoLogic notacreditoLogic=new NotaCreditoLogic();
			notacreditoLogic.setConnexion(this.connexion);
			notacreditoLogic.getNotaCreditoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNotaCredito.equals("NONE")) {
				notacreditoLogic.getTodosNotaCreditos(finalQueryGlobalNotaCredito,new Pagination());
				notacreditosForeignKey=notacreditoLogic.getNotaCreditos();
			}

			detanotacreditoReturnGeneral.setnotacreditosForeignKey(notacreditosForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detanotacreditoReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detanotacreditoReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detanotacreditoReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<TipoDetaNotaCredito> tipodetanotacreditosForeignKey=new ArrayList<TipoDetaNotaCredito>();
			TipoDetaNotaCreditoLogic tipodetanotacreditoLogic=new TipoDetaNotaCreditoLogic();
			tipodetanotacreditoLogic.setConnexion(this.connexion);
			tipodetanotacreditoLogic.getTipoDetaNotaCreditoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDetaNotaCredito.equals("NONE")) {
				tipodetanotacreditoLogic.getTodosTipoDetaNotaCreditos(finalQueryGlobalTipoDetaNotaCredito,new Pagination());
				tipodetanotacreditosForeignKey=tipodetanotacreditoLogic.getTipoDetaNotaCreditos();
			}

			detanotacreditoReturnGeneral.settipodetanotacreditosForeignKey(tipodetanotacreditosForeignKey);


			List<TipoDevolucionEmpresa> tipodevolucionempresasForeignKey=new ArrayList<TipoDevolucionEmpresa>();
			TipoDevolucionEmpresaLogic tipodevolucionempresaLogic=new TipoDevolucionEmpresaLogic();
			tipodevolucionempresaLogic.setConnexion(this.connexion);
			tipodevolucionempresaLogic.getTipoDevolucionEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDevolucionEmpresa.equals("NONE")) {
				tipodevolucionempresaLogic.getTodosTipoDevolucionEmpresas(finalQueryGlobalTipoDevolucionEmpresa,new Pagination());
				tipodevolucionempresasForeignKey=tipodevolucionempresaLogic.getTipoDevolucionEmpresas();
			}

			detanotacreditoReturnGeneral.settipodevolucionempresasForeignKey(tipodevolucionempresasForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detanotacreditoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Empaque> empaquesForeignKey=new ArrayList<Empaque>();
			EmpaqueLogic empaqueLogic=new EmpaqueLogic();
			empaqueLogic.setConnexion(this.connexion);
			empaqueLogic.getEmpaqueDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpaque.equals("NONE")) {
				empaqueLogic.getTodosEmpaques(finalQueryGlobalEmpaque,new Pagination());
				empaquesForeignKey=empaqueLogic.getEmpaques();
			}

			detanotacreditoReturnGeneral.setempaquesForeignKey(empaquesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detanotacreditoReturnGeneral;
	}
	
	
	public void deepLoad(DetaNotaCredito detanotacredito,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetaNotaCreditoLogicAdditional.updateDetaNotaCreditoToGet(detanotacredito,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detanotacredito.setEmpresa(detanotacreditoDataAccess.getEmpresa(connexion,detanotacredito));
		detanotacredito.setSucursal(detanotacreditoDataAccess.getSucursal(connexion,detanotacredito));
		detanotacredito.setEjercicio(detanotacreditoDataAccess.getEjercicio(connexion,detanotacredito));
		detanotacredito.setPeriodo(detanotacreditoDataAccess.getPeriodo(connexion,detanotacredito));
		detanotacredito.setAnio(detanotacreditoDataAccess.getAnio(connexion,detanotacredito));
		detanotacredito.setMes(detanotacreditoDataAccess.getMes(connexion,detanotacredito));
		detanotacredito.setNotaCredito(detanotacreditoDataAccess.getNotaCredito(connexion,detanotacredito));
		detanotacredito.setBodega(detanotacreditoDataAccess.getBodega(connexion,detanotacredito));
		detanotacredito.setProducto(detanotacreditoDataAccess.getProducto(connexion,detanotacredito));
		detanotacredito.setUnidad(detanotacreditoDataAccess.getUnidad(connexion,detanotacredito));
		detanotacredito.setTipoDetaNotaCredito(detanotacreditoDataAccess.getTipoDetaNotaCredito(connexion,detanotacredito));
		detanotacredito.setTipoDevolucionEmpresa(detanotacreditoDataAccess.getTipoDevolucionEmpresa(connexion,detanotacredito));
		detanotacredito.setCentroCosto(detanotacreditoDataAccess.getCentroCosto(connexion,detanotacredito));
		detanotacredito.setEmpaque(detanotacreditoDataAccess.getEmpaque(connexion,detanotacredito));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detanotacredito.setEmpresa(detanotacreditoDataAccess.getEmpresa(connexion,detanotacredito));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detanotacredito.setSucursal(detanotacreditoDataAccess.getSucursal(connexion,detanotacredito));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detanotacredito.setEjercicio(detanotacreditoDataAccess.getEjercicio(connexion,detanotacredito));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detanotacredito.setPeriodo(detanotacreditoDataAccess.getPeriodo(connexion,detanotacredito));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detanotacredito.setAnio(detanotacreditoDataAccess.getAnio(connexion,detanotacredito));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detanotacredito.setMes(detanotacreditoDataAccess.getMes(connexion,detanotacredito));
				continue;
			}

			if(clas.clas.equals(NotaCredito.class)) {
				detanotacredito.setNotaCredito(detanotacreditoDataAccess.getNotaCredito(connexion,detanotacredito));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detanotacredito.setBodega(detanotacreditoDataAccess.getBodega(connexion,detanotacredito));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detanotacredito.setProducto(detanotacreditoDataAccess.getProducto(connexion,detanotacredito));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detanotacredito.setUnidad(detanotacreditoDataAccess.getUnidad(connexion,detanotacredito));
				continue;
			}

			if(clas.clas.equals(TipoDetaNotaCredito.class)) {
				detanotacredito.setTipoDetaNotaCredito(detanotacreditoDataAccess.getTipoDetaNotaCredito(connexion,detanotacredito));
				continue;
			}

			if(clas.clas.equals(TipoDevolucionEmpresa.class)) {
				detanotacredito.setTipoDevolucionEmpresa(detanotacreditoDataAccess.getTipoDevolucionEmpresa(connexion,detanotacredito));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detanotacredito.setCentroCosto(detanotacreditoDataAccess.getCentroCosto(connexion,detanotacredito));
				continue;
			}

			if(clas.clas.equals(Empaque.class)) {
				detanotacredito.setEmpaque(detanotacreditoDataAccess.getEmpaque(connexion,detanotacredito));
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
			detanotacredito.setEmpresa(detanotacreditoDataAccess.getEmpresa(connexion,detanotacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setSucursal(detanotacreditoDataAccess.getSucursal(connexion,detanotacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setEjercicio(detanotacreditoDataAccess.getEjercicio(connexion,detanotacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setPeriodo(detanotacreditoDataAccess.getPeriodo(connexion,detanotacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setAnio(detanotacreditoDataAccess.getAnio(connexion,detanotacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setMes(detanotacreditoDataAccess.getMes(connexion,detanotacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCredito.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setNotaCredito(detanotacreditoDataAccess.getNotaCredito(connexion,detanotacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setBodega(detanotacreditoDataAccess.getBodega(connexion,detanotacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setProducto(detanotacreditoDataAccess.getProducto(connexion,detanotacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setUnidad(detanotacreditoDataAccess.getUnidad(connexion,detanotacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDetaNotaCredito.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setTipoDetaNotaCredito(detanotacreditoDataAccess.getTipoDetaNotaCredito(connexion,detanotacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDevolucionEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setTipoDevolucionEmpresa(detanotacreditoDataAccess.getTipoDevolucionEmpresa(connexion,detanotacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setCentroCosto(detanotacreditoDataAccess.getCentroCosto(connexion,detanotacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empaque.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setEmpaque(detanotacreditoDataAccess.getEmpaque(connexion,detanotacredito));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detanotacredito.setEmpresa(detanotacreditoDataAccess.getEmpresa(connexion,detanotacredito));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detanotacredito.getEmpresa(),isDeep,deepLoadType,clases);
				
		detanotacredito.setSucursal(detanotacreditoDataAccess.getSucursal(connexion,detanotacredito));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detanotacredito.getSucursal(),isDeep,deepLoadType,clases);
				
		detanotacredito.setEjercicio(detanotacreditoDataAccess.getEjercicio(connexion,detanotacredito));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detanotacredito.getEjercicio(),isDeep,deepLoadType,clases);
				
		detanotacredito.setPeriodo(detanotacreditoDataAccess.getPeriodo(connexion,detanotacredito));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detanotacredito.getPeriodo(),isDeep,deepLoadType,clases);
				
		detanotacredito.setAnio(detanotacreditoDataAccess.getAnio(connexion,detanotacredito));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detanotacredito.getAnio(),isDeep,deepLoadType,clases);
				
		detanotacredito.setMes(detanotacreditoDataAccess.getMes(connexion,detanotacredito));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detanotacredito.getMes(),isDeep,deepLoadType,clases);
				
		detanotacredito.setNotaCredito(detanotacreditoDataAccess.getNotaCredito(connexion,detanotacredito));
		NotaCreditoLogic notacreditoLogic= new NotaCreditoLogic(connexion);
		notacreditoLogic.deepLoad(detanotacredito.getNotaCredito(),isDeep,deepLoadType,clases);
				
		detanotacredito.setBodega(detanotacreditoDataAccess.getBodega(connexion,detanotacredito));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detanotacredito.getBodega(),isDeep,deepLoadType,clases);
				
		detanotacredito.setProducto(detanotacreditoDataAccess.getProducto(connexion,detanotacredito));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detanotacredito.getProducto(),isDeep,deepLoadType,clases);
				
		detanotacredito.setUnidad(detanotacreditoDataAccess.getUnidad(connexion,detanotacredito));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detanotacredito.getUnidad(),isDeep,deepLoadType,clases);
				
		detanotacredito.setTipoDetaNotaCredito(detanotacreditoDataAccess.getTipoDetaNotaCredito(connexion,detanotacredito));
		TipoDetaNotaCreditoLogic tipodetanotacreditoLogic= new TipoDetaNotaCreditoLogic(connexion);
		tipodetanotacreditoLogic.deepLoad(detanotacredito.getTipoDetaNotaCredito(),isDeep,deepLoadType,clases);
				
		detanotacredito.setTipoDevolucionEmpresa(detanotacreditoDataAccess.getTipoDevolucionEmpresa(connexion,detanotacredito));
		TipoDevolucionEmpresaLogic tipodevolucionempresaLogic= new TipoDevolucionEmpresaLogic(connexion);
		tipodevolucionempresaLogic.deepLoad(detanotacredito.getTipoDevolucionEmpresa(),isDeep,deepLoadType,clases);
				
		detanotacredito.setCentroCosto(detanotacreditoDataAccess.getCentroCosto(connexion,detanotacredito));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detanotacredito.getCentroCosto(),isDeep,deepLoadType,clases);
				
		detanotacredito.setEmpaque(detanotacreditoDataAccess.getEmpaque(connexion,detanotacredito));
		EmpaqueLogic empaqueLogic= new EmpaqueLogic(connexion);
		empaqueLogic.deepLoad(detanotacredito.getEmpaque(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detanotacredito.setEmpresa(detanotacreditoDataAccess.getEmpresa(connexion,detanotacredito));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detanotacredito.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detanotacredito.setSucursal(detanotacreditoDataAccess.getSucursal(connexion,detanotacredito));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detanotacredito.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detanotacredito.setEjercicio(detanotacreditoDataAccess.getEjercicio(connexion,detanotacredito));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detanotacredito.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detanotacredito.setPeriodo(detanotacreditoDataAccess.getPeriodo(connexion,detanotacredito));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detanotacredito.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detanotacredito.setAnio(detanotacreditoDataAccess.getAnio(connexion,detanotacredito));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detanotacredito.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detanotacredito.setMes(detanotacreditoDataAccess.getMes(connexion,detanotacredito));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detanotacredito.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NotaCredito.class)) {
				detanotacredito.setNotaCredito(detanotacreditoDataAccess.getNotaCredito(connexion,detanotacredito));
				NotaCreditoLogic notacreditoLogic= new NotaCreditoLogic(connexion);
				notacreditoLogic.deepLoad(detanotacredito.getNotaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detanotacredito.setBodega(detanotacreditoDataAccess.getBodega(connexion,detanotacredito));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detanotacredito.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detanotacredito.setProducto(detanotacreditoDataAccess.getProducto(connexion,detanotacredito));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detanotacredito.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detanotacredito.setUnidad(detanotacreditoDataAccess.getUnidad(connexion,detanotacredito));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detanotacredito.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDetaNotaCredito.class)) {
				detanotacredito.setTipoDetaNotaCredito(detanotacreditoDataAccess.getTipoDetaNotaCredito(connexion,detanotacredito));
				TipoDetaNotaCreditoLogic tipodetanotacreditoLogic= new TipoDetaNotaCreditoLogic(connexion);
				tipodetanotacreditoLogic.deepLoad(detanotacredito.getTipoDetaNotaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDevolucionEmpresa.class)) {
				detanotacredito.setTipoDevolucionEmpresa(detanotacreditoDataAccess.getTipoDevolucionEmpresa(connexion,detanotacredito));
				TipoDevolucionEmpresaLogic tipodevolucionempresaLogic= new TipoDevolucionEmpresaLogic(connexion);
				tipodevolucionempresaLogic.deepLoad(detanotacredito.getTipoDevolucionEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detanotacredito.setCentroCosto(detanotacreditoDataAccess.getCentroCosto(connexion,detanotacredito));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(detanotacredito.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empaque.class)) {
				detanotacredito.setEmpaque(detanotacreditoDataAccess.getEmpaque(connexion,detanotacredito));
				EmpaqueLogic empaqueLogic= new EmpaqueLogic(connexion);
				empaqueLogic.deepLoad(detanotacredito.getEmpaque(),isDeep,deepLoadType,clases);				
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
			detanotacredito.setEmpresa(detanotacreditoDataAccess.getEmpresa(connexion,detanotacredito));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detanotacredito.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setSucursal(detanotacreditoDataAccess.getSucursal(connexion,detanotacredito));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detanotacredito.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setEjercicio(detanotacreditoDataAccess.getEjercicio(connexion,detanotacredito));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detanotacredito.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setPeriodo(detanotacreditoDataAccess.getPeriodo(connexion,detanotacredito));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detanotacredito.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setAnio(detanotacreditoDataAccess.getAnio(connexion,detanotacredito));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detanotacredito.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setMes(detanotacreditoDataAccess.getMes(connexion,detanotacredito));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detanotacredito.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCredito.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setNotaCredito(detanotacreditoDataAccess.getNotaCredito(connexion,detanotacredito));
			NotaCreditoLogic notacreditoLogic= new NotaCreditoLogic(connexion);
			notacreditoLogic.deepLoad(detanotacredito.getNotaCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setBodega(detanotacreditoDataAccess.getBodega(connexion,detanotacredito));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detanotacredito.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setProducto(detanotacreditoDataAccess.getProducto(connexion,detanotacredito));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detanotacredito.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setUnidad(detanotacreditoDataAccess.getUnidad(connexion,detanotacredito));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detanotacredito.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDetaNotaCredito.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setTipoDetaNotaCredito(detanotacreditoDataAccess.getTipoDetaNotaCredito(connexion,detanotacredito));
			TipoDetaNotaCreditoLogic tipodetanotacreditoLogic= new TipoDetaNotaCreditoLogic(connexion);
			tipodetanotacreditoLogic.deepLoad(detanotacredito.getTipoDetaNotaCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDevolucionEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setTipoDevolucionEmpresa(detanotacreditoDataAccess.getTipoDevolucionEmpresa(connexion,detanotacredito));
			TipoDevolucionEmpresaLogic tipodevolucionempresaLogic= new TipoDevolucionEmpresaLogic(connexion);
			tipodevolucionempresaLogic.deepLoad(detanotacredito.getTipoDevolucionEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setCentroCosto(detanotacreditoDataAccess.getCentroCosto(connexion,detanotacredito));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(detanotacredito.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empaque.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacredito.setEmpaque(detanotacreditoDataAccess.getEmpaque(connexion,detanotacredito));
			EmpaqueLogic empaqueLogic= new EmpaqueLogic(connexion);
			empaqueLogic.deepLoad(detanotacredito.getEmpaque(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetaNotaCredito detanotacredito,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetaNotaCreditoLogicAdditional.updateDetaNotaCreditoToSave(detanotacredito,this.arrDatoGeneral);
			
DetaNotaCreditoDataAccess.save(detanotacredito, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detanotacredito.getEmpresa(),connexion);

		SucursalDataAccess.save(detanotacredito.getSucursal(),connexion);

		EjercicioDataAccess.save(detanotacredito.getEjercicio(),connexion);

		PeriodoDataAccess.save(detanotacredito.getPeriodo(),connexion);

		AnioDataAccess.save(detanotacredito.getAnio(),connexion);

		MesDataAccess.save(detanotacredito.getMes(),connexion);

		NotaCreditoDataAccess.save(detanotacredito.getNotaCredito(),connexion);

		BodegaDataAccess.save(detanotacredito.getBodega(),connexion);

		ProductoDataAccess.save(detanotacredito.getProducto(),connexion);

		UnidadDataAccess.save(detanotacredito.getUnidad(),connexion);

		TipoDetaNotaCreditoDataAccess.save(detanotacredito.getTipoDetaNotaCredito(),connexion);

		TipoDevolucionEmpresaDataAccess.save(detanotacredito.getTipoDevolucionEmpresa(),connexion);

		CentroCostoDataAccess.save(detanotacredito.getCentroCosto(),connexion);

		EmpaqueDataAccess.save(detanotacredito.getEmpaque(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detanotacredito.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detanotacredito.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detanotacredito.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detanotacredito.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detanotacredito.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detanotacredito.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(NotaCredito.class)) {
				NotaCreditoDataAccess.save(detanotacredito.getNotaCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detanotacredito.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detanotacredito.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detanotacredito.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDetaNotaCredito.class)) {
				TipoDetaNotaCreditoDataAccess.save(detanotacredito.getTipoDetaNotaCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDevolucionEmpresa.class)) {
				TipoDevolucionEmpresaDataAccess.save(detanotacredito.getTipoDevolucionEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detanotacredito.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(Empaque.class)) {
				EmpaqueDataAccess.save(detanotacredito.getEmpaque(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detanotacredito.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detanotacredito.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detanotacredito.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detanotacredito.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detanotacredito.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detanotacredito.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detanotacredito.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detanotacredito.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detanotacredito.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detanotacredito.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detanotacredito.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detanotacredito.getMes(),isDeep,deepLoadType,clases);
				

		NotaCreditoDataAccess.save(detanotacredito.getNotaCredito(),connexion);
		NotaCreditoLogic notacreditoLogic= new NotaCreditoLogic(connexion);
		notacreditoLogic.deepLoad(detanotacredito.getNotaCredito(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detanotacredito.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detanotacredito.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detanotacredito.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detanotacredito.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detanotacredito.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detanotacredito.getUnidad(),isDeep,deepLoadType,clases);
				

		TipoDetaNotaCreditoDataAccess.save(detanotacredito.getTipoDetaNotaCredito(),connexion);
		TipoDetaNotaCreditoLogic tipodetanotacreditoLogic= new TipoDetaNotaCreditoLogic(connexion);
		tipodetanotacreditoLogic.deepLoad(detanotacredito.getTipoDetaNotaCredito(),isDeep,deepLoadType,clases);
				

		TipoDevolucionEmpresaDataAccess.save(detanotacredito.getTipoDevolucionEmpresa(),connexion);
		TipoDevolucionEmpresaLogic tipodevolucionempresaLogic= new TipoDevolucionEmpresaLogic(connexion);
		tipodevolucionempresaLogic.deepLoad(detanotacredito.getTipoDevolucionEmpresa(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(detanotacredito.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detanotacredito.getCentroCosto(),isDeep,deepLoadType,clases);
				

		EmpaqueDataAccess.save(detanotacredito.getEmpaque(),connexion);
		EmpaqueLogic empaqueLogic= new EmpaqueLogic(connexion);
		empaqueLogic.deepLoad(detanotacredito.getEmpaque(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detanotacredito.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detanotacredito.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detanotacredito.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detanotacredito.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detanotacredito.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detanotacredito.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detanotacredito.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detanotacredito.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detanotacredito.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detanotacredito.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detanotacredito.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detanotacredito.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NotaCredito.class)) {
				NotaCreditoDataAccess.save(detanotacredito.getNotaCredito(),connexion);
				NotaCreditoLogic notacreditoLogic= new NotaCreditoLogic(connexion);
				notacreditoLogic.deepSave(detanotacredito.getNotaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detanotacredito.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detanotacredito.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detanotacredito.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detanotacredito.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detanotacredito.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detanotacredito.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDetaNotaCredito.class)) {
				TipoDetaNotaCreditoDataAccess.save(detanotacredito.getTipoDetaNotaCredito(),connexion);
				TipoDetaNotaCreditoLogic tipodetanotacreditoLogic= new TipoDetaNotaCreditoLogic(connexion);
				tipodetanotacreditoLogic.deepSave(detanotacredito.getTipoDetaNotaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDevolucionEmpresa.class)) {
				TipoDevolucionEmpresaDataAccess.save(detanotacredito.getTipoDevolucionEmpresa(),connexion);
				TipoDevolucionEmpresaLogic tipodevolucionempresaLogic= new TipoDevolucionEmpresaLogic(connexion);
				tipodevolucionempresaLogic.deepSave(detanotacredito.getTipoDevolucionEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detanotacredito.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(detanotacredito.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empaque.class)) {
				EmpaqueDataAccess.save(detanotacredito.getEmpaque(),connexion);
				EmpaqueLogic empaqueLogic= new EmpaqueLogic(connexion);
				empaqueLogic.deepSave(detanotacredito.getEmpaque(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetaNotaCredito.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detanotacredito,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(detanotacredito);
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
			this.deepLoad(this.detanotacredito,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacredito);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetaNotaCredito.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detanotacreditos!=null) {
				for(DetaNotaCredito detanotacredito:detanotacreditos) {
					this.deepLoad(detanotacredito,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(detanotacreditos);
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
			if(detanotacreditos!=null) {
				for(DetaNotaCredito detanotacredito:detanotacreditos) {
					this.deepLoad(detanotacredito,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(detanotacreditos);
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
			this.getNewConnexionToDeep(DetaNotaCredito.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detanotacredito,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetaNotaCredito.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detanotacreditos!=null) {
				for(DetaNotaCredito detanotacredito:detanotacreditos) {
					this.deepSave(detanotacredito,isDeep,deepLoadType,clases);
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
			if(detanotacreditos!=null) {
				for(DetaNotaCredito detanotacredito:detanotacreditos) {
					this.deepSave(detanotacredito,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetaNotaCreditosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetaNotaCreditoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetaNotaCreditoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditosFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetaNotaCreditoConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditosFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetaNotaCreditoConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditosFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetaNotaCreditoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditosFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetaNotaCreditoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditosFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetaNotaCreditoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditosFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetaNotaCreditoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditosFK_IdEmpaqueWithConnection(String sFinalQuery,Pagination pagination,Long id_empaque)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpaque= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpaque.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empaque,DetaNotaCreditoConstantesFunciones.IDEMPAQUE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpaque);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpaque","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditosFK_IdEmpaque(String sFinalQuery,Pagination pagination,Long id_empaque)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpaque= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpaque.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empaque,DetaNotaCreditoConstantesFunciones.IDEMPAQUE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpaque);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpaque","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetaNotaCreditoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetaNotaCreditoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditosFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetaNotaCreditoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditosFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetaNotaCreditoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditosFK_IdNotaCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_nota_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_nota_credito,DetaNotaCreditoConstantesFunciones.IDNOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNotaCredito);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditosFK_IdNotaCredito(String sFinalQuery,Pagination pagination,Long id_nota_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_nota_credito,DetaNotaCreditoConstantesFunciones.IDNOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNotaCredito);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditosFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetaNotaCreditoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditosFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetaNotaCreditoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditosFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetaNotaCreditoConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditosFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetaNotaCreditoConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetaNotaCreditoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetaNotaCreditoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditosFK_IdTipoDetaNotaCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_deta_nota_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDetaNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDetaNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_deta_nota_credito,DetaNotaCreditoConstantesFunciones.IDTIPODETANOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDetaNotaCredito);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDetaNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditosFK_IdTipoDetaNotaCredito(String sFinalQuery,Pagination pagination,Long id_tipo_deta_nota_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDetaNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDetaNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_deta_nota_credito,DetaNotaCreditoConstantesFunciones.IDTIPODETANOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDetaNotaCredito);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDetaNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditosFK_IdTipoDevolucionEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_devolucion_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDevolucionEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDevolucionEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_devolucion_empresa,DetaNotaCreditoConstantesFunciones.IDTIPODEVOLUCIONEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDevolucionEmpresa);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDevolucionEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditosFK_IdTipoDevolucionEmpresa(String sFinalQuery,Pagination pagination,Long id_tipo_devolucion_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDevolucionEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDevolucionEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_devolucion_empresa,DetaNotaCreditoConstantesFunciones.IDTIPODEVOLUCIONEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDevolucionEmpresa);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDevolucionEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditosFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetaNotaCreditoConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditosFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetaNotaCreditoConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetaNotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(this.detanotacreditos);
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
			if(DetaNotaCreditoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetaNotaCreditoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetaNotaCredito detanotacredito,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetaNotaCreditoConstantesFunciones.ISCONAUDITORIA) {
				if(detanotacredito.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetaNotaCreditoDataAccess.TABLENAME, detanotacredito.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetaNotaCreditoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetaNotaCreditoLogic.registrarAuditoriaDetallesDetaNotaCredito(connexion,detanotacredito,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detanotacredito.getIsDeleted()) {
					/*if(!detanotacredito.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetaNotaCreditoDataAccess.TABLENAME, detanotacredito.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetaNotaCreditoLogic.registrarAuditoriaDetallesDetaNotaCredito(connexion,detanotacredito,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetaNotaCreditoDataAccess.TABLENAME, detanotacredito.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detanotacredito.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetaNotaCreditoDataAccess.TABLENAME, detanotacredito.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetaNotaCreditoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetaNotaCreditoLogic.registrarAuditoriaDetallesDetaNotaCredito(connexion,detanotacredito,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetaNotaCredito(Connexion connexion,DetaNotaCredito detanotacredito)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detanotacredito.getIsNew()||!detanotacredito.getid_empresa().equals(detanotacredito.getDetaNotaCreditoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getid_empresa()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getid_empresa().toString();
				}
				if(detanotacredito.getid_empresa()!=null)
				{
					strValorNuevo=detanotacredito.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getid_sucursal().equals(detanotacredito.getDetaNotaCreditoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getid_sucursal()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getid_sucursal().toString();
				}
				if(detanotacredito.getid_sucursal()!=null)
				{
					strValorNuevo=detanotacredito.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getid_ejercicio().equals(detanotacredito.getDetaNotaCreditoOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getid_ejercicio().toString();
				}
				if(detanotacredito.getid_ejercicio()!=null)
				{
					strValorNuevo=detanotacredito.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getid_periodo().equals(detanotacredito.getDetaNotaCreditoOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getid_periodo()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getid_periodo().toString();
				}
				if(detanotacredito.getid_periodo()!=null)
				{
					strValorNuevo=detanotacredito.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getid_anio().equals(detanotacredito.getDetaNotaCreditoOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getid_anio()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getid_anio().toString();
				}
				if(detanotacredito.getid_anio()!=null)
				{
					strValorNuevo=detanotacredito.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getid_mes().equals(detanotacredito.getDetaNotaCreditoOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getid_mes()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getid_mes().toString();
				}
				if(detanotacredito.getid_mes()!=null)
				{
					strValorNuevo=detanotacredito.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getid_nota_credito().equals(detanotacredito.getDetaNotaCreditoOriginal().getid_nota_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getid_nota_credito()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getid_nota_credito().toString();
				}
				if(detanotacredito.getid_nota_credito()!=null)
				{
					strValorNuevo=detanotacredito.getid_nota_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.IDNOTACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getid_bodega().equals(detanotacredito.getDetaNotaCreditoOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getid_bodega()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getid_bodega().toString();
				}
				if(detanotacredito.getid_bodega()!=null)
				{
					strValorNuevo=detanotacredito.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getid_producto().equals(detanotacredito.getDetaNotaCreditoOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getid_producto()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getid_producto().toString();
				}
				if(detanotacredito.getid_producto()!=null)
				{
					strValorNuevo=detanotacredito.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getid_unidad().equals(detanotacredito.getDetaNotaCreditoOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getid_unidad()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getid_unidad().toString();
				}
				if(detanotacredito.getid_unidad()!=null)
				{
					strValorNuevo=detanotacredito.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getid_tipo_deta_nota_credito().equals(detanotacredito.getDetaNotaCreditoOriginal().getid_tipo_deta_nota_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getid_tipo_deta_nota_credito()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getid_tipo_deta_nota_credito().toString();
				}
				if(detanotacredito.getid_tipo_deta_nota_credito()!=null)
				{
					strValorNuevo=detanotacredito.getid_tipo_deta_nota_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.IDTIPODETANOTACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getid_tipo_devolucion_empresa().equals(detanotacredito.getDetaNotaCreditoOriginal().getid_tipo_devolucion_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getid_tipo_devolucion_empresa()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getid_tipo_devolucion_empresa().toString();
				}
				if(detanotacredito.getid_tipo_devolucion_empresa()!=null)
				{
					strValorNuevo=detanotacredito.getid_tipo_devolucion_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.IDTIPODEVOLUCIONEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getdescripcion().equals(detanotacredito.getDetaNotaCreditoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getdescripcion()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getdescripcion();
				}
				if(detanotacredito.getdescripcion()!=null)
				{
					strValorNuevo=detanotacredito.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getcantidad().equals(detanotacredito.getDetaNotaCreditoOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getcantidad()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getcantidad().toString();
				}
				if(detanotacredito.getcantidad()!=null)
				{
					strValorNuevo=detanotacredito.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getprecio().equals(detanotacredito.getDetaNotaCreditoOriginal().getprecio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getprecio()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getprecio().toString();
				}
				if(detanotacredito.getprecio()!=null)
				{
					strValorNuevo=detanotacredito.getprecio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.PRECIO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getmonto().equals(detanotacredito.getDetaNotaCreditoOriginal().getmonto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getmonto()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getmonto().toString();
				}
				if(detanotacredito.getmonto()!=null)
				{
					strValorNuevo=detanotacredito.getmonto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.MONTO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getcosto().equals(detanotacredito.getDetaNotaCreditoOriginal().getcosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getcosto()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getcosto().toString();
				}
				if(detanotacredito.getcosto()!=null)
				{
					strValorNuevo=detanotacredito.getcosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.COSTO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getdescuento().equals(detanotacredito.getDetaNotaCreditoOriginal().getdescuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getdescuento()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getdescuento().toString();
				}
				if(detanotacredito.getdescuento()!=null)
				{
					strValorNuevo=detanotacredito.getdescuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.DESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getdescuento2().equals(detanotacredito.getDetaNotaCreditoOriginal().getdescuento2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getdescuento2()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getdescuento2().toString();
				}
				if(detanotacredito.getdescuento2()!=null)
				{
					strValorNuevo=detanotacredito.getdescuento2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.DESCUENTO2,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getimpuesto().equals(detanotacredito.getDetaNotaCreditoOriginal().getimpuesto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getimpuesto()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getimpuesto().toString();
				}
				if(detanotacredito.getimpuesto()!=null)
				{
					strValorNuevo=detanotacredito.getimpuesto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.IMPUESTO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getporcen_iva().equals(detanotacredito.getDetaNotaCreditoOriginal().getporcen_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getporcen_iva()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getporcen_iva().toString();
				}
				if(detanotacredito.getporcen_iva()!=null)
				{
					strValorNuevo=detanotacredito.getporcen_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.PORCENIVA,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getporcen_descuen().equals(detanotacredito.getDetaNotaCreditoOriginal().getporcen_descuen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getporcen_descuen()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getporcen_descuen().toString();
				}
				if(detanotacredito.getporcen_descuen()!=null)
				{
					strValorNuevo=detanotacredito.getporcen_descuen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.PORCENDESCUEN,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getporcen_ice().equals(detanotacredito.getDetaNotaCreditoOriginal().getporcen_ice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getporcen_ice()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getporcen_ice().toString();
				}
				if(detanotacredito.getporcen_ice()!=null)
				{
					strValorNuevo=detanotacredito.getporcen_ice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.PORCENICE,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getsub_total().equals(detanotacredito.getDetaNotaCreditoOriginal().getsub_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getsub_total()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getsub_total().toString();
				}
				if(detanotacredito.getsub_total()!=null)
				{
					strValorNuevo=detanotacredito.getsub_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.SUBTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.gettotal().equals(detanotacredito.getDetaNotaCreditoOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().gettotal()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().gettotal().toString();
				}
				if(detanotacredito.gettotal()!=null)
				{
					strValorNuevo=detanotacredito.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getid_centro_costo().equals(detanotacredito.getDetaNotaCreditoOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getid_centro_costo()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getid_centro_costo().toString();
				}
				if(detanotacredito.getid_centro_costo()!=null)
				{
					strValorNuevo=detanotacredito.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getid_empaque().equals(detanotacredito.getDetaNotaCreditoOriginal().getid_empaque()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getid_empaque()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getid_empaque().toString();
				}
				if(detanotacredito.getid_empaque()!=null)
				{
					strValorNuevo=detanotacredito.getid_empaque().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.IDEMPAQUE,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getincluye_impuesto().equals(detanotacredito.getDetaNotaCreditoOriginal().getincluye_impuesto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getincluye_impuesto()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getincluye_impuesto().toString();
				}
				if(detanotacredito.getincluye_impuesto()!=null)
				{
					strValorNuevo=detanotacredito.getincluye_impuesto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.INCLUYEIMPUESTO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getfecha_emision().equals(detanotacredito.getDetaNotaCreditoOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getfecha_emision()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getfecha_emision().toString();
				}
				if(detanotacredito.getfecha_emision()!=null)
				{
					strValorNuevo=detanotacredito.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getcodigo_lote().equals(detanotacredito.getDetaNotaCreditoOriginal().getcodigo_lote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getcodigo_lote()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getcodigo_lote();
				}
				if(detanotacredito.getcodigo_lote()!=null)
				{
					strValorNuevo=detanotacredito.getcodigo_lote() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.CODIGOLOTE,strValorActual,strValorNuevo);
			}	
			
			if(detanotacredito.getIsNew()||!detanotacredito.getnumero_caja().equals(detanotacredito.getDetaNotaCreditoOriginal().getnumero_caja()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacredito.getDetaNotaCreditoOriginal().getnumero_caja()!=null)
				{
					strValorActual=detanotacredito.getDetaNotaCreditoOriginal().getnumero_caja();
				}
				if(detanotacredito.getnumero_caja()!=null)
				{
					strValorNuevo=detanotacredito.getnumero_caja() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoConstantesFunciones.NUMEROCAJA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetaNotaCreditoRelacionesWithConnection(DetaNotaCredito detanotacredito) throws Exception {

		if(!detanotacredito.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetaNotaCreditoRelacionesBase(detanotacredito,true);
		}
	}

	public void saveDetaNotaCreditoRelaciones(DetaNotaCredito detanotacredito)throws Exception {

		if(!detanotacredito.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetaNotaCreditoRelacionesBase(detanotacredito,false);
		}
	}

	public void saveDetaNotaCreditoRelacionesBase(DetaNotaCredito detanotacredito,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetaNotaCredito-saveRelacionesWithConnection");}
	

			this.setDetaNotaCredito(detanotacredito);

			if(DetaNotaCreditoLogicAdditional.validarSaveRelaciones(detanotacredito,this)) {

				DetaNotaCreditoLogicAdditional.updateRelacionesToSave(detanotacredito,this);

				if((detanotacredito.getIsNew()||detanotacredito.getIsChanged())&&!detanotacredito.getIsDeleted()) {
					this.saveDetaNotaCredito();
					this.saveDetaNotaCreditoRelacionesDetalles();

				} else if(detanotacredito.getIsDeleted()) {
					this.saveDetaNotaCreditoRelacionesDetalles();
					this.saveDetaNotaCredito();
				}

				DetaNotaCreditoLogicAdditional.updateRelacionesToSaveAfter(detanotacredito,this);

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
	
	
	private void saveDetaNotaCreditoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetaNotaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetaNotaCreditoConstantesFunciones.getClassesForeignKeysOfDetaNotaCredito(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetaNotaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetaNotaCreditoConstantesFunciones.getClassesRelationshipsOfDetaNotaCredito(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

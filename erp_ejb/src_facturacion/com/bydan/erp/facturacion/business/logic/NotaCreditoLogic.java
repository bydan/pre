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
import com.bydan.erp.facturacion.util.NotaCreditoConstantesFunciones;
import com.bydan.erp.facturacion.util.NotaCreditoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.NotaCreditoParameterGeneral;
import com.bydan.erp.facturacion.business.entity.NotaCredito;
import com.bydan.erp.facturacion.business.logic.NotaCreditoLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;








@SuppressWarnings("unused")
public class NotaCreditoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(NotaCreditoLogic.class);
	
	protected NotaCreditoDataAccess notacreditoDataAccess; 	
	protected NotaCredito notacredito;
	protected List<NotaCredito> notacreditos;
	protected Object notacreditoObject;	
	protected List<Object> notacreditosObject;
	
	public static ClassValidator<NotaCredito> notacreditoValidator = new ClassValidator<NotaCredito>(NotaCredito.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected NotaCreditoLogicAdditional notacreditoLogicAdditional=null;
	
	public NotaCreditoLogicAdditional getNotaCreditoLogicAdditional() {
		return this.notacreditoLogicAdditional;
	}
	
	public void setNotaCreditoLogicAdditional(NotaCreditoLogicAdditional notacreditoLogicAdditional) {
		try {
			this.notacreditoLogicAdditional=notacreditoLogicAdditional;
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
	
	
	
	
	public  NotaCreditoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.notacreditoDataAccess = new NotaCreditoDataAccess();
			
			this.notacreditos= new ArrayList<NotaCredito>();
			this.notacredito= new NotaCredito();
			
			this.notacreditoObject=new Object();
			this.notacreditosObject=new ArrayList<Object>();
				
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
			
			this.notacreditoDataAccess.setConnexionType(this.connexionType);
			this.notacreditoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  NotaCreditoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.notacreditoDataAccess = new NotaCreditoDataAccess();
			this.notacreditos= new ArrayList<NotaCredito>();
			this.notacredito= new NotaCredito();
			this.notacreditoObject=new Object();
			this.notacreditosObject=new ArrayList<Object>();
			
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
			
			this.notacreditoDataAccess.setConnexionType(this.connexionType);
			this.notacreditoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public NotaCredito getNotaCredito() throws Exception {	
		NotaCreditoLogicAdditional.checkNotaCreditoToGet(notacredito,this.datosCliente,this.arrDatoGeneral);
		NotaCreditoLogicAdditional.updateNotaCreditoToGet(notacredito,this.arrDatoGeneral);
		
		return notacredito;
	}
		
	public void setNotaCredito(NotaCredito newNotaCredito) {
		this.notacredito = newNotaCredito;
	}
	
	public NotaCreditoDataAccess getNotaCreditoDataAccess() {
		return notacreditoDataAccess;
	}
	
	public void setNotaCreditoDataAccess(NotaCreditoDataAccess newnotacreditoDataAccess) {
		this.notacreditoDataAccess = newnotacreditoDataAccess;
	}
	
	public List<NotaCredito> getNotaCreditos() throws Exception {		
		this.quitarNotaCreditosNulos();
		
		NotaCreditoLogicAdditional.checkNotaCreditoToGets(notacreditos,this.datosCliente,this.arrDatoGeneral);
		
		for (NotaCredito notacreditoLocal: notacreditos ) {
			NotaCreditoLogicAdditional.updateNotaCreditoToGet(notacreditoLocal,this.arrDatoGeneral);
		}
		
		return notacreditos;
	}
	
	public void setNotaCreditos(List<NotaCredito> newNotaCreditos) {
		this.notacreditos = newNotaCreditos;
	}
	
	public Object getNotaCreditoObject() {	
		this.notacreditoObject=this.notacreditoDataAccess.getEntityObject();
		return this.notacreditoObject;
	}
		
	public void setNotaCreditoObject(Object newNotaCreditoObject) {
		this.notacreditoObject = newNotaCreditoObject;
	}
	
	public List<Object> getNotaCreditosObject() {		
		this.notacreditosObject=this.notacreditoDataAccess.getEntitiesObject();
		return this.notacreditosObject;
	}
		
	public void setNotaCreditosObject(List<Object> newNotaCreditosObject) {
		this.notacreditosObject = newNotaCreditosObject;
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
		
		if(this.notacreditoDataAccess!=null) {
			this.notacreditoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			notacreditoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			notacreditoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		notacredito = new  NotaCredito();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			notacredito=notacreditoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.notacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacredito);
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
		notacredito = new  NotaCredito();
		  		  
        try {
			
			notacredito=notacreditoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.notacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacredito);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		notacredito = new  NotaCredito();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			notacredito=notacreditoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.notacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacredito);
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
		notacredito = new  NotaCredito();
		  		  
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
		notacredito = new  NotaCredito();
		  		  
        try {
			
			notacredito=notacreditoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.notacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacredito);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		notacredito = new  NotaCredito();
		  		  
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
		notacredito = new  NotaCredito();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =notacreditoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		notacredito = new  NotaCredito();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=notacreditoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		notacredito = new  NotaCredito();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =notacreditoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		notacredito = new  NotaCredito();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=notacreditoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		notacredito = new  NotaCredito();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =notacreditoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		notacredito = new  NotaCredito();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=notacreditoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		notacreditos = new  ArrayList<NotaCredito>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditos=notacreditoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNotaCredito(notacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
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
		notacreditos = new  ArrayList<NotaCredito>();
		  		  
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
		notacreditos = new  ArrayList<NotaCredito>();
		  		  
        try {			
			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditos=notacreditoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarNotaCredito(notacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		notacreditos = new  ArrayList<NotaCredito>();
		  		  
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
		notacreditos = new  ArrayList<NotaCredito>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditos=notacreditoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNotaCredito(notacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
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
		notacreditos = new  ArrayList<NotaCredito>();
		  		  
        try {
			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditos=notacreditoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNotaCredito(notacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
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
		notacreditos = new  ArrayList<NotaCredito>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditos=notacreditoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNotaCredito(notacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
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
		notacreditos = new  ArrayList<NotaCredito>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditos=notacreditoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNotaCredito(notacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		notacredito = new  NotaCredito();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacredito=notacreditoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNotaCredito(notacredito);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacredito);
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
		notacredito = new  NotaCredito();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacredito=notacreditoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNotaCredito(notacredito);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacredito);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		notacreditos = new  ArrayList<NotaCredito>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditos=notacreditoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNotaCredito(notacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
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
		notacreditos = new  ArrayList<NotaCredito>();
		  		  
        try {
			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditos=notacreditoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNotaCredito(notacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosNotaCreditosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		notacreditos = new  ArrayList<NotaCredito>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getTodosNotaCreditosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNotaCredito(notacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
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
	
	public  void  getTodosNotaCreditos(String sFinalQuery,Pagination pagination)throws Exception {
		notacreditos = new  ArrayList<NotaCredito>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNotaCredito(notacreditos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarNotaCredito(NotaCredito notacredito) throws Exception {
		Boolean estaValidado=false;
		
		if(notacredito.getIsNew() || notacredito.getIsChanged()) { 
			this.invalidValues = notacreditoValidator.getInvalidValues(notacredito);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(notacredito);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarNotaCredito(List<NotaCredito> NotaCreditos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(NotaCredito notacreditoLocal:notacreditos) {				
			estaValidadoObjeto=this.validarGuardarNotaCredito(notacreditoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarNotaCredito(List<NotaCredito> NotaCreditos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNotaCredito(notacreditos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarNotaCredito(NotaCredito NotaCredito) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNotaCredito(notacredito)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(NotaCredito notacredito) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+notacredito.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=NotaCreditoConstantesFunciones.getNotaCreditoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"notacredito","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(NotaCreditoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(NotaCreditoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveNotaCreditoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-saveNotaCreditoWithConnection");connexion.begin();			
			
			NotaCreditoLogicAdditional.checkNotaCreditoToSave(this.notacredito,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NotaCreditoLogicAdditional.updateNotaCreditoToSave(this.notacredito,this.arrDatoGeneral);
			
			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.notacredito,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowNotaCredito();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNotaCredito(this.notacredito)) {
				NotaCreditoDataAccess.save(this.notacredito, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.notacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NotaCreditoLogicAdditional.checkNotaCreditoToSaveAfter(this.notacredito,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNotaCredito();
			
			connexion.commit();			
			
			if(this.notacredito.getIsDeleted()) {
				this.notacredito=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveNotaCredito()throws Exception {	
		try {	
			
			NotaCreditoLogicAdditional.checkNotaCreditoToSave(this.notacredito,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NotaCreditoLogicAdditional.updateNotaCreditoToSave(this.notacredito,this.arrDatoGeneral);
			
			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.notacredito,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNotaCredito(this.notacredito)) {			
				NotaCreditoDataAccess.save(this.notacredito, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.notacredito,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NotaCreditoLogicAdditional.checkNotaCreditoToSaveAfter(this.notacredito,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.notacredito.getIsDeleted()) {
				this.notacredito=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveNotaCreditosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-saveNotaCreditosWithConnection");connexion.begin();			
			
			NotaCreditoLogicAdditional.checkNotaCreditoToSaves(notacreditos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowNotaCreditos();
			
			Boolean validadoTodosNotaCredito=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NotaCredito notacreditoLocal:notacreditos) {		
				if(notacreditoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NotaCreditoLogicAdditional.updateNotaCreditoToSave(notacreditoLocal,this.arrDatoGeneral);
	        	
				NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),notacreditoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNotaCredito(notacreditoLocal)) {
					NotaCreditoDataAccess.save(notacreditoLocal, connexion);				
				} else {
					validadoTodosNotaCredito=false;
				}
			}
			
			if(!validadoTodosNotaCredito) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NotaCreditoLogicAdditional.checkNotaCreditoToSavesAfter(notacreditos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNotaCreditos();
			
			connexion.commit();		
			
			this.quitarNotaCreditosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveNotaCreditos()throws Exception {				
		 try {	
			NotaCreditoLogicAdditional.checkNotaCreditoToSaves(notacreditos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosNotaCredito=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NotaCredito notacreditoLocal:notacreditos) {				
				if(notacreditoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NotaCreditoLogicAdditional.updateNotaCreditoToSave(notacreditoLocal,this.arrDatoGeneral);
	        	
				NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),notacreditoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNotaCredito(notacreditoLocal)) {				
					NotaCreditoDataAccess.save(notacreditoLocal, connexion);				
				} else {
					validadoTodosNotaCredito=false;
				}
			}
			
			if(!validadoTodosNotaCredito) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NotaCreditoLogicAdditional.checkNotaCreditoToSavesAfter(notacreditos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarNotaCreditosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NotaCreditoParameterReturnGeneral procesarAccionNotaCreditos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NotaCredito> notacreditos,NotaCreditoParameterReturnGeneral notacreditoParameterGeneral)throws Exception {
		 try {	
			NotaCreditoParameterReturnGeneral notacreditoReturnGeneral=new NotaCreditoParameterReturnGeneral();
	
			NotaCreditoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,notacreditos,notacreditoParameterGeneral,notacreditoReturnGeneral);
			
			return notacreditoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NotaCreditoParameterReturnGeneral procesarAccionNotaCreditosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NotaCredito> notacreditos,NotaCreditoParameterReturnGeneral notacreditoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-procesarAccionNotaCreditosWithConnection");connexion.begin();			
			
			NotaCreditoParameterReturnGeneral notacreditoReturnGeneral=new NotaCreditoParameterReturnGeneral();
	
			NotaCreditoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,notacreditos,notacreditoParameterGeneral,notacreditoReturnGeneral);
			
			this.connexion.commit();
			
			return notacreditoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NotaCreditoParameterReturnGeneral procesarEventosNotaCreditos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NotaCredito> notacreditos,NotaCredito notacredito,NotaCreditoParameterReturnGeneral notacreditoParameterGeneral,Boolean isEsNuevoNotaCredito,ArrayList<Classe> clases)throws Exception {
		 try {	
			NotaCreditoParameterReturnGeneral notacreditoReturnGeneral=new NotaCreditoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				notacreditoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NotaCreditoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,notacreditos,notacredito,notacreditoParameterGeneral,notacreditoReturnGeneral,isEsNuevoNotaCredito,clases);
			
			return notacreditoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public NotaCreditoParameterReturnGeneral procesarEventosNotaCreditosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NotaCredito> notacreditos,NotaCredito notacredito,NotaCreditoParameterReturnGeneral notacreditoParameterGeneral,Boolean isEsNuevoNotaCredito,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-procesarEventosNotaCreditosWithConnection");connexion.begin();			
			
			NotaCreditoParameterReturnGeneral notacreditoReturnGeneral=new NotaCreditoParameterReturnGeneral();
	
			notacreditoReturnGeneral.setNotaCredito(notacredito);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				notacreditoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NotaCreditoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,notacreditos,notacredito,notacreditoParameterGeneral,notacreditoReturnGeneral,isEsNuevoNotaCredito,clases);
			
			this.connexion.commit();
			
			return notacreditoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NotaCreditoParameterReturnGeneral procesarImportacionNotaCreditosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,NotaCreditoParameterReturnGeneral notacreditoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-procesarImportacionNotaCreditosWithConnection");connexion.begin();			
			
			NotaCreditoParameterReturnGeneral notacreditoReturnGeneral=new NotaCreditoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.notacreditos=new ArrayList<NotaCredito>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.notacredito=new NotaCredito();
				
				
				if(conColumnasBase) {this.notacredito.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.notacredito.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.notacredito.setcodigo(arrColumnas[iColumn++]);
				this.notacredito.setnumero(arrColumnas[iColumn++]);
				this.notacredito.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.notacredito.setnumero_dias(Integer.parseInt(arrColumnas[iColumn++]));
				this.notacredito.setfecha_vencimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.notacredito.setcotizacion(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacredito.setdireccion(arrColumnas[iColumn++]);
				this.notacredito.settelefono(arrColumnas[iColumn++]);
				this.notacredito.setruc(arrColumnas[iColumn++]);
				this.notacredito.setdescripcion(arrColumnas[iColumn++]);
				this.notacredito.setdescuento_porcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacredito.settotal_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacredito.setsuman(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacredito.setdescuento_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacredito.settotal_sin_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacredito.settotal_descuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacredito.setflete(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacredito.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacredito.setsub_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacredito.setotro(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacredito.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacredito.setfinanciamiento(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacredito.setice(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacredito.setotro_valor(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.notacreditos.add(this.notacredito);
			}
			
			this.saveNotaCreditos();
			
			this.connexion.commit();
			
			notacreditoReturnGeneral.setConRetornoEstaProcesado(true);
			notacreditoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return notacreditoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarNotaCreditosEliminados() throws Exception {				
		
		List<NotaCredito> notacreditosAux= new ArrayList<NotaCredito>();
		
		for(NotaCredito notacredito:notacreditos) {
			if(!notacredito.getIsDeleted()) {
				notacreditosAux.add(notacredito);
			}
		}
		
		notacreditos=notacreditosAux;
	}
	
	public void quitarNotaCreditosNulos() throws Exception {				
		
		List<NotaCredito> notacreditosAux= new ArrayList<NotaCredito>();
		
		for(NotaCredito notacredito : this.notacreditos) {
			if(notacredito==null) {
				notacreditosAux.add(notacredito);
			}
		}
		
		//this.notacreditos=notacreditosAux;
		
		this.notacreditos.removeAll(notacreditosAux);
	}
	
	public void getSetVersionRowNotaCreditoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(notacredito.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((notacredito.getIsDeleted() || (notacredito.getIsChanged()&&!notacredito.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=notacreditoDataAccess.getSetVersionRowNotaCredito(connexion,notacredito.getId());
				
				if(!notacredito.getVersionRow().equals(timestamp)) {	
					notacredito.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				notacredito.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowNotaCredito()throws Exception {	
		
		if(notacredito.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((notacredito.getIsDeleted() || (notacredito.getIsChanged()&&!notacredito.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=notacreditoDataAccess.getSetVersionRowNotaCredito(connexion,notacredito.getId());
			
			try {							
				if(!notacredito.getVersionRow().equals(timestamp)) {	
					notacredito.setVersionRow(timestamp);
				}
				
				notacredito.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowNotaCreditosWithConnection()throws Exception {	
		if(notacreditos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(NotaCredito notacreditoAux:notacreditos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(notacreditoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(notacreditoAux.getIsDeleted() || (notacreditoAux.getIsChanged()&&!notacreditoAux.getIsNew())) {
						
						timestamp=notacreditoDataAccess.getSetVersionRowNotaCredito(connexion,notacreditoAux.getId());
						
						if(!notacredito.getVersionRow().equals(timestamp)) {	
							notacreditoAux.setVersionRow(timestamp);
						}
								
						notacreditoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowNotaCreditos()throws Exception {	
		if(notacreditos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(NotaCredito notacreditoAux:notacreditos) {
					if(notacreditoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(notacreditoAux.getIsDeleted() || (notacreditoAux.getIsChanged()&&!notacreditoAux.getIsNew())) {
						
						timestamp=notacreditoDataAccess.getSetVersionRowNotaCredito(connexion,notacreditoAux.getId());
						
						if(!notacreditoAux.getVersionRow().equals(timestamp)) {	
							notacreditoAux.setVersionRow(timestamp);
						}
						
													
						notacreditoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public NotaCreditoParameterReturnGeneral cargarCombosLoteForeignKeyNotaCreditoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalUsuario,String finalQueryGlobalMoneda,String finalQueryGlobalEmpleado,String finalQueryGlobalFormato,String finalQueryGlobalTipoPrecio,String finalQueryGlobalCliente,String finalQueryGlobalFactura,String finalQueryGlobalVendedor,String finalQueryGlobalResponsable,String finalQueryGlobalEstadoNotaCredito,String finalQueryGlobalCentroCosto,String finalQueryGlobalTipoCambio,String finalQueryGlobalTransporte,String finalQueryGlobalTransportista) throws Exception {
		NotaCreditoParameterReturnGeneral  notacreditoReturnGeneral =new NotaCreditoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-cargarCombosLoteForeignKeyNotaCreditoWithConnection");connexion.begin();
			
			notacreditoReturnGeneral =new NotaCreditoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			notacreditoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			notacreditoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			notacreditoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			notacreditoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			notacreditoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			notacreditoReturnGeneral.setmessForeignKey(messForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			notacreditoReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			notacreditoReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			notacreditoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			notacreditoReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			notacreditoReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			notacreditoReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			notacreditoReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			notacreditoReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Responsable> responsablesForeignKey=new ArrayList<Responsable>();
			ResponsableLogic responsableLogic=new ResponsableLogic();
			responsableLogic.setConnexion(this.connexion);
			responsableLogic.getResponsableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalResponsable.equals("NONE")) {
				responsableLogic.getTodosResponsables(finalQueryGlobalResponsable,new Pagination());
				responsablesForeignKey=responsableLogic.getResponsables();
			}

			notacreditoReturnGeneral.setresponsablesForeignKey(responsablesForeignKey);


			List<EstadoNotaCredito> estadonotacreditosForeignKey=new ArrayList<EstadoNotaCredito>();
			EstadoNotaCreditoLogic estadonotacreditoLogic=new EstadoNotaCreditoLogic();
			estadonotacreditoLogic.setConnexion(this.connexion);
			estadonotacreditoLogic.getEstadoNotaCreditoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoNotaCredito.equals("NONE")) {
				estadonotacreditoLogic.getTodosEstadoNotaCreditos(finalQueryGlobalEstadoNotaCredito,new Pagination());
				estadonotacreditosForeignKey=estadonotacreditoLogic.getEstadoNotaCreditos();
			}

			notacreditoReturnGeneral.setestadonotacreditosForeignKey(estadonotacreditosForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			notacreditoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			notacreditoReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<Transporte> transportesForeignKey=new ArrayList<Transporte>();
			TransporteLogic transporteLogic=new TransporteLogic();
			transporteLogic.setConnexion(this.connexion);
			transporteLogic.getTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransporte.equals("NONE")) {
				transporteLogic.getTodosTransportes(finalQueryGlobalTransporte,new Pagination());
				transportesForeignKey=transporteLogic.getTransportes();
			}

			notacreditoReturnGeneral.settransportesForeignKey(transportesForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			notacreditoReturnGeneral.settransportistasForeignKey(transportistasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return notacreditoReturnGeneral;
	}
	
	public NotaCreditoParameterReturnGeneral cargarCombosLoteForeignKeyNotaCredito(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalUsuario,String finalQueryGlobalMoneda,String finalQueryGlobalEmpleado,String finalQueryGlobalFormato,String finalQueryGlobalTipoPrecio,String finalQueryGlobalCliente,String finalQueryGlobalFactura,String finalQueryGlobalVendedor,String finalQueryGlobalResponsable,String finalQueryGlobalEstadoNotaCredito,String finalQueryGlobalCentroCosto,String finalQueryGlobalTipoCambio,String finalQueryGlobalTransporte,String finalQueryGlobalTransportista) throws Exception {
		NotaCreditoParameterReturnGeneral  notacreditoReturnGeneral =new NotaCreditoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			notacreditoReturnGeneral =new NotaCreditoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			notacreditoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			notacreditoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			notacreditoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			notacreditoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			notacreditoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			notacreditoReturnGeneral.setmessForeignKey(messForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			notacreditoReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			notacreditoReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			notacreditoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			notacreditoReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			notacreditoReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			notacreditoReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			notacreditoReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			notacreditoReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Responsable> responsablesForeignKey=new ArrayList<Responsable>();
			ResponsableLogic responsableLogic=new ResponsableLogic();
			responsableLogic.setConnexion(this.connexion);
			responsableLogic.getResponsableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalResponsable.equals("NONE")) {
				responsableLogic.getTodosResponsables(finalQueryGlobalResponsable,new Pagination());
				responsablesForeignKey=responsableLogic.getResponsables();
			}

			notacreditoReturnGeneral.setresponsablesForeignKey(responsablesForeignKey);


			List<EstadoNotaCredito> estadonotacreditosForeignKey=new ArrayList<EstadoNotaCredito>();
			EstadoNotaCreditoLogic estadonotacreditoLogic=new EstadoNotaCreditoLogic();
			estadonotacreditoLogic.setConnexion(this.connexion);
			estadonotacreditoLogic.getEstadoNotaCreditoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoNotaCredito.equals("NONE")) {
				estadonotacreditoLogic.getTodosEstadoNotaCreditos(finalQueryGlobalEstadoNotaCredito,new Pagination());
				estadonotacreditosForeignKey=estadonotacreditoLogic.getEstadoNotaCreditos();
			}

			notacreditoReturnGeneral.setestadonotacreditosForeignKey(estadonotacreditosForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			notacreditoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			notacreditoReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<Transporte> transportesForeignKey=new ArrayList<Transporte>();
			TransporteLogic transporteLogic=new TransporteLogic();
			transporteLogic.setConnexion(this.connexion);
			transporteLogic.getTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransporte.equals("NONE")) {
				transporteLogic.getTodosTransportes(finalQueryGlobalTransporte,new Pagination());
				transportesForeignKey=transporteLogic.getTransportes();
			}

			notacreditoReturnGeneral.settransportesForeignKey(transportesForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			notacreditoReturnGeneral.settransportistasForeignKey(transportistasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return notacreditoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyNotaCreditoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetaNotaCreditoLogic detanotacreditoLogic=new DetaNotaCreditoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyNotaCreditoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetaNotaCredito.class));
											
			

			detanotacreditoLogic.setConnexion(this.getConnexion());
			detanotacreditoLogic.setDatosCliente(this.datosCliente);
			detanotacreditoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(NotaCredito notacredito:this.notacreditos) {
				

				classes=new ArrayList<Classe>();
				classes=DetaNotaCreditoConstantesFunciones.getClassesForeignKeysOfDetaNotaCredito(new ArrayList<Classe>(),DeepLoadType.NONE);

				detanotacreditoLogic.setDetaNotaCreditos(notacredito.detanotacreditos);
				detanotacreditoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(NotaCredito notacredito,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			NotaCreditoLogicAdditional.updateNotaCreditoToGet(notacredito,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		notacredito.setEmpresa(notacreditoDataAccess.getEmpresa(connexion,notacredito));
		notacredito.setSucursal(notacreditoDataAccess.getSucursal(connexion,notacredito));
		notacredito.setEjercicio(notacreditoDataAccess.getEjercicio(connexion,notacredito));
		notacredito.setPeriodo(notacreditoDataAccess.getPeriodo(connexion,notacredito));
		notacredito.setAnio(notacreditoDataAccess.getAnio(connexion,notacredito));
		notacredito.setMes(notacreditoDataAccess.getMes(connexion,notacredito));
		notacredito.setUsuario(notacreditoDataAccess.getUsuario(connexion,notacredito));
		notacredito.setMoneda(notacreditoDataAccess.getMoneda(connexion,notacredito));
		notacredito.setEmpleado(notacreditoDataAccess.getEmpleado(connexion,notacredito));
		notacredito.setFormato(notacreditoDataAccess.getFormato(connexion,notacredito));
		notacredito.setTipoPrecio(notacreditoDataAccess.getTipoPrecio(connexion,notacredito));
		notacredito.setCliente(notacreditoDataAccess.getCliente(connexion,notacredito));
		notacredito.setFactura(notacreditoDataAccess.getFactura(connexion,notacredito));
		notacredito.setVendedor(notacreditoDataAccess.getVendedor(connexion,notacredito));
		notacredito.setResponsable(notacreditoDataAccess.getResponsable(connexion,notacredito));
		notacredito.setEstadoNotaCredito(notacreditoDataAccess.getEstadoNotaCredito(connexion,notacredito));
		notacredito.setCentroCosto(notacreditoDataAccess.getCentroCosto(connexion,notacredito));
		notacredito.setTipoCambio(notacreditoDataAccess.getTipoCambio(connexion,notacredito));
		notacredito.setTransporte(notacreditoDataAccess.getTransporte(connexion,notacredito));
		notacredito.setTransportista(notacreditoDataAccess.getTransportista(connexion,notacredito));
		notacredito.setDetaNotaCreditos(notacreditoDataAccess.getDetaNotaCreditos(connexion,notacredito));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				notacredito.setEmpresa(notacreditoDataAccess.getEmpresa(connexion,notacredito));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				notacredito.setSucursal(notacreditoDataAccess.getSucursal(connexion,notacredito));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				notacredito.setEjercicio(notacreditoDataAccess.getEjercicio(connexion,notacredito));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				notacredito.setPeriodo(notacreditoDataAccess.getPeriodo(connexion,notacredito));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				notacredito.setAnio(notacreditoDataAccess.getAnio(connexion,notacredito));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				notacredito.setMes(notacreditoDataAccess.getMes(connexion,notacredito));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				notacredito.setUsuario(notacreditoDataAccess.getUsuario(connexion,notacredito));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				notacredito.setMoneda(notacreditoDataAccess.getMoneda(connexion,notacredito));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				notacredito.setEmpleado(notacreditoDataAccess.getEmpleado(connexion,notacredito));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				notacredito.setFormato(notacreditoDataAccess.getFormato(connexion,notacredito));
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				notacredito.setTipoPrecio(notacreditoDataAccess.getTipoPrecio(connexion,notacredito));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				notacredito.setCliente(notacreditoDataAccess.getCliente(connexion,notacredito));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				notacredito.setFactura(notacreditoDataAccess.getFactura(connexion,notacredito));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				notacredito.setVendedor(notacreditoDataAccess.getVendedor(connexion,notacredito));
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				notacredito.setResponsable(notacreditoDataAccess.getResponsable(connexion,notacredito));
				continue;
			}

			if(clas.clas.equals(EstadoNotaCredito.class)) {
				notacredito.setEstadoNotaCredito(notacreditoDataAccess.getEstadoNotaCredito(connexion,notacredito));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				notacredito.setCentroCosto(notacreditoDataAccess.getCentroCosto(connexion,notacredito));
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				notacredito.setTipoCambio(notacreditoDataAccess.getTipoCambio(connexion,notacredito));
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				notacredito.setTransporte(notacreditoDataAccess.getTransporte(connexion,notacredito));
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				notacredito.setTransportista(notacreditoDataAccess.getTransportista(connexion,notacredito));
				continue;
			}

			if(clas.clas.equals(DetaNotaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				notacredito.setDetaNotaCreditos(notacreditoDataAccess.getDetaNotaCreditos(connexion,notacredito));

				if(this.isConDeep) {
					DetaNotaCreditoLogic detanotacreditoLogic= new DetaNotaCreditoLogic(this.connexion);
					detanotacreditoLogic.setDetaNotaCreditos(notacredito.getDetaNotaCreditos());
					ArrayList<Classe> classesLocal=DetaNotaCreditoConstantesFunciones.getClassesForeignKeysOfDetaNotaCredito(new ArrayList<Classe>(),DeepLoadType.NONE);
					detanotacreditoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetaNotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCredito(detanotacreditoLogic.getDetaNotaCreditos());
					notacredito.setDetaNotaCreditos(detanotacreditoLogic.getDetaNotaCreditos());
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
			notacredito.setEmpresa(notacreditoDataAccess.getEmpresa(connexion,notacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setSucursal(notacreditoDataAccess.getSucursal(connexion,notacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setEjercicio(notacreditoDataAccess.getEjercicio(connexion,notacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setPeriodo(notacreditoDataAccess.getPeriodo(connexion,notacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setAnio(notacreditoDataAccess.getAnio(connexion,notacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setMes(notacreditoDataAccess.getMes(connexion,notacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setUsuario(notacreditoDataAccess.getUsuario(connexion,notacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setMoneda(notacreditoDataAccess.getMoneda(connexion,notacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setEmpleado(notacreditoDataAccess.getEmpleado(connexion,notacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setFormato(notacreditoDataAccess.getFormato(connexion,notacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setTipoPrecio(notacreditoDataAccess.getTipoPrecio(connexion,notacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setCliente(notacreditoDataAccess.getCliente(connexion,notacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setFactura(notacreditoDataAccess.getFactura(connexion,notacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setVendedor(notacreditoDataAccess.getVendedor(connexion,notacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Responsable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setResponsable(notacreditoDataAccess.getResponsable(connexion,notacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoNotaCredito.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setEstadoNotaCredito(notacreditoDataAccess.getEstadoNotaCredito(connexion,notacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setCentroCosto(notacreditoDataAccess.getCentroCosto(connexion,notacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setTipoCambio(notacreditoDataAccess.getTipoCambio(connexion,notacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setTransporte(notacreditoDataAccess.getTransporte(connexion,notacredito));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setTransportista(notacreditoDataAccess.getTransportista(connexion,notacredito));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetaNotaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetaNotaCredito.class));
			notacredito.setDetaNotaCreditos(notacreditoDataAccess.getDetaNotaCreditos(connexion,notacredito));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		notacredito.setEmpresa(notacreditoDataAccess.getEmpresa(connexion,notacredito));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(notacredito.getEmpresa(),isDeep,deepLoadType,clases);
				
		notacredito.setSucursal(notacreditoDataAccess.getSucursal(connexion,notacredito));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(notacredito.getSucursal(),isDeep,deepLoadType,clases);
				
		notacredito.setEjercicio(notacreditoDataAccess.getEjercicio(connexion,notacredito));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(notacredito.getEjercicio(),isDeep,deepLoadType,clases);
				
		notacredito.setPeriodo(notacreditoDataAccess.getPeriodo(connexion,notacredito));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(notacredito.getPeriodo(),isDeep,deepLoadType,clases);
				
		notacredito.setAnio(notacreditoDataAccess.getAnio(connexion,notacredito));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(notacredito.getAnio(),isDeep,deepLoadType,clases);
				
		notacredito.setMes(notacreditoDataAccess.getMes(connexion,notacredito));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(notacredito.getMes(),isDeep,deepLoadType,clases);
				
		notacredito.setUsuario(notacreditoDataAccess.getUsuario(connexion,notacredito));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(notacredito.getUsuario(),isDeep,deepLoadType,clases);
				
		notacredito.setMoneda(notacreditoDataAccess.getMoneda(connexion,notacredito));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(notacredito.getMoneda(),isDeep,deepLoadType,clases);
				
		notacredito.setEmpleado(notacreditoDataAccess.getEmpleado(connexion,notacredito));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(notacredito.getEmpleado(),isDeep,deepLoadType,clases);
				
		notacredito.setFormato(notacreditoDataAccess.getFormato(connexion,notacredito));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(notacredito.getFormato(),isDeep,deepLoadType,clases);
				
		notacredito.setTipoPrecio(notacreditoDataAccess.getTipoPrecio(connexion,notacredito));
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(notacredito.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		notacredito.setCliente(notacreditoDataAccess.getCliente(connexion,notacredito));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(notacredito.getCliente(),isDeep,deepLoadType,clases);
				
		notacredito.setFactura(notacreditoDataAccess.getFactura(connexion,notacredito));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(notacredito.getFactura(),isDeep,deepLoadType,clases);
				
		notacredito.setVendedor(notacreditoDataAccess.getVendedor(connexion,notacredito));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(notacredito.getVendedor(),isDeep,deepLoadType,clases);
				
		notacredito.setResponsable(notacreditoDataAccess.getResponsable(connexion,notacredito));
		ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
		responsableLogic.deepLoad(notacredito.getResponsable(),isDeep,deepLoadType,clases);
				
		notacredito.setEstadoNotaCredito(notacreditoDataAccess.getEstadoNotaCredito(connexion,notacredito));
		EstadoNotaCreditoLogic estadonotacreditoLogic= new EstadoNotaCreditoLogic(connexion);
		estadonotacreditoLogic.deepLoad(notacredito.getEstadoNotaCredito(),isDeep,deepLoadType,clases);
				
		notacredito.setCentroCosto(notacreditoDataAccess.getCentroCosto(connexion,notacredito));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(notacredito.getCentroCosto(),isDeep,deepLoadType,clases);
				
		notacredito.setTipoCambio(notacreditoDataAccess.getTipoCambio(connexion,notacredito));
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(notacredito.getTipoCambio(),isDeep,deepLoadType,clases);
				
		notacredito.setTransporte(notacreditoDataAccess.getTransporte(connexion,notacredito));
		TransporteLogic transporteLogic= new TransporteLogic(connexion);
		transporteLogic.deepLoad(notacredito.getTransporte(),isDeep,deepLoadType,clases);
				
		notacredito.setTransportista(notacreditoDataAccess.getTransportista(connexion,notacredito));
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(notacredito.getTransportista(),isDeep,deepLoadType,clases);
				

		notacredito.setDetaNotaCreditos(notacreditoDataAccess.getDetaNotaCreditos(connexion,notacredito));

		for(DetaNotaCredito detanotacredito:notacredito.getDetaNotaCreditos()) {
			DetaNotaCreditoLogic detanotacreditoLogic= new DetaNotaCreditoLogic(connexion);
			detanotacreditoLogic.deepLoad(detanotacredito,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				notacredito.setEmpresa(notacreditoDataAccess.getEmpresa(connexion,notacredito));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(notacredito.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				notacredito.setSucursal(notacreditoDataAccess.getSucursal(connexion,notacredito));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(notacredito.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				notacredito.setEjercicio(notacreditoDataAccess.getEjercicio(connexion,notacredito));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(notacredito.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				notacredito.setPeriodo(notacreditoDataAccess.getPeriodo(connexion,notacredito));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(notacredito.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				notacredito.setAnio(notacreditoDataAccess.getAnio(connexion,notacredito));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(notacredito.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				notacredito.setMes(notacreditoDataAccess.getMes(connexion,notacredito));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(notacredito.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				notacredito.setUsuario(notacreditoDataAccess.getUsuario(connexion,notacredito));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(notacredito.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				notacredito.setMoneda(notacreditoDataAccess.getMoneda(connexion,notacredito));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(notacredito.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				notacredito.setEmpleado(notacreditoDataAccess.getEmpleado(connexion,notacredito));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(notacredito.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				notacredito.setFormato(notacreditoDataAccess.getFormato(connexion,notacredito));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(notacredito.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				notacredito.setTipoPrecio(notacreditoDataAccess.getTipoPrecio(connexion,notacredito));
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepLoad(notacredito.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				notacredito.setCliente(notacreditoDataAccess.getCliente(connexion,notacredito));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(notacredito.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				notacredito.setFactura(notacreditoDataAccess.getFactura(connexion,notacredito));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(notacredito.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				notacredito.setVendedor(notacreditoDataAccess.getVendedor(connexion,notacredito));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(notacredito.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				notacredito.setResponsable(notacreditoDataAccess.getResponsable(connexion,notacredito));
				ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
				responsableLogic.deepLoad(notacredito.getResponsable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoNotaCredito.class)) {
				notacredito.setEstadoNotaCredito(notacreditoDataAccess.getEstadoNotaCredito(connexion,notacredito));
				EstadoNotaCreditoLogic estadonotacreditoLogic= new EstadoNotaCreditoLogic(connexion);
				estadonotacreditoLogic.deepLoad(notacredito.getEstadoNotaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				notacredito.setCentroCosto(notacreditoDataAccess.getCentroCosto(connexion,notacredito));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(notacredito.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				notacredito.setTipoCambio(notacreditoDataAccess.getTipoCambio(connexion,notacredito));
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepLoad(notacredito.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				notacredito.setTransporte(notacreditoDataAccess.getTransporte(connexion,notacredito));
				TransporteLogic transporteLogic= new TransporteLogic(connexion);
				transporteLogic.deepLoad(notacredito.getTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				notacredito.setTransportista(notacreditoDataAccess.getTransportista(connexion,notacredito));
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepLoad(notacredito.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetaNotaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				notacredito.setDetaNotaCreditos(notacreditoDataAccess.getDetaNotaCreditos(connexion,notacredito));

				for(DetaNotaCredito detanotacredito:notacredito.getDetaNotaCreditos()) {
					DetaNotaCreditoLogic detanotacreditoLogic= new DetaNotaCreditoLogic(connexion);
					detanotacreditoLogic.deepLoad(detanotacredito,isDeep,deepLoadType,clases);
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
			notacredito.setEmpresa(notacreditoDataAccess.getEmpresa(connexion,notacredito));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(notacredito.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setSucursal(notacreditoDataAccess.getSucursal(connexion,notacredito));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(notacredito.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setEjercicio(notacreditoDataAccess.getEjercicio(connexion,notacredito));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(notacredito.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setPeriodo(notacreditoDataAccess.getPeriodo(connexion,notacredito));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(notacredito.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setAnio(notacreditoDataAccess.getAnio(connexion,notacredito));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(notacredito.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setMes(notacreditoDataAccess.getMes(connexion,notacredito));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(notacredito.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setUsuario(notacreditoDataAccess.getUsuario(connexion,notacredito));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(notacredito.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setMoneda(notacreditoDataAccess.getMoneda(connexion,notacredito));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(notacredito.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setEmpleado(notacreditoDataAccess.getEmpleado(connexion,notacredito));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(notacredito.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setFormato(notacreditoDataAccess.getFormato(connexion,notacredito));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(notacredito.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setTipoPrecio(notacreditoDataAccess.getTipoPrecio(connexion,notacredito));
			TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
			tipoprecioLogic.deepLoad(notacredito.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setCliente(notacreditoDataAccess.getCliente(connexion,notacredito));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(notacredito.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setFactura(notacreditoDataAccess.getFactura(connexion,notacredito));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(notacredito.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setVendedor(notacreditoDataAccess.getVendedor(connexion,notacredito));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(notacredito.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Responsable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setResponsable(notacreditoDataAccess.getResponsable(connexion,notacredito));
			ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
			responsableLogic.deepLoad(notacredito.getResponsable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoNotaCredito.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setEstadoNotaCredito(notacreditoDataAccess.getEstadoNotaCredito(connexion,notacredito));
			EstadoNotaCreditoLogic estadonotacreditoLogic= new EstadoNotaCreditoLogic(connexion);
			estadonotacreditoLogic.deepLoad(notacredito.getEstadoNotaCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setCentroCosto(notacreditoDataAccess.getCentroCosto(connexion,notacredito));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(notacredito.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setTipoCambio(notacreditoDataAccess.getTipoCambio(connexion,notacredito));
			TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
			tipocambioLogic.deepLoad(notacredito.getTipoCambio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setTransporte(notacreditoDataAccess.getTransporte(connexion,notacredito));
			TransporteLogic transporteLogic= new TransporteLogic(connexion);
			transporteLogic.deepLoad(notacredito.getTransporte(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacredito.setTransportista(notacreditoDataAccess.getTransportista(connexion,notacredito));
			TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
			transportistaLogic.deepLoad(notacredito.getTransportista(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetaNotaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetaNotaCredito.class));
			notacredito.setDetaNotaCreditos(notacreditoDataAccess.getDetaNotaCreditos(connexion,notacredito));

			for(DetaNotaCredito detanotacredito:notacredito.getDetaNotaCreditos()) {
				DetaNotaCreditoLogic detanotacreditoLogic= new DetaNotaCreditoLogic(connexion);
				detanotacreditoLogic.deepLoad(detanotacredito,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(NotaCredito notacredito,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			NotaCreditoLogicAdditional.updateNotaCreditoToSave(notacredito,this.arrDatoGeneral);
			
NotaCreditoDataAccess.save(notacredito, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(notacredito.getEmpresa(),connexion);

		SucursalDataAccess.save(notacredito.getSucursal(),connexion);

		EjercicioDataAccess.save(notacredito.getEjercicio(),connexion);

		PeriodoDataAccess.save(notacredito.getPeriodo(),connexion);

		AnioDataAccess.save(notacredito.getAnio(),connexion);

		MesDataAccess.save(notacredito.getMes(),connexion);

		UsuarioDataAccess.save(notacredito.getUsuario(),connexion);

		MonedaDataAccess.save(notacredito.getMoneda(),connexion);

		EmpleadoDataAccess.save(notacredito.getEmpleado(),connexion);

		FormatoDataAccess.save(notacredito.getFormato(),connexion);

		TipoPrecioDataAccess.save(notacredito.getTipoPrecio(),connexion);

		ClienteDataAccess.save(notacredito.getCliente(),connexion);

		FacturaDataAccess.save(notacredito.getFactura(),connexion);

		VendedorDataAccess.save(notacredito.getVendedor(),connexion);

		ResponsableDataAccess.save(notacredito.getResponsable(),connexion);

		EstadoNotaCreditoDataAccess.save(notacredito.getEstadoNotaCredito(),connexion);

		CentroCostoDataAccess.save(notacredito.getCentroCosto(),connexion);

		TipoCambioDataAccess.save(notacredito.getTipoCambio(),connexion);

		TransporteDataAccess.save(notacredito.getTransporte(),connexion);

		TransportistaDataAccess.save(notacredito.getTransportista(),connexion);

		for(DetaNotaCredito detanotacredito:notacredito.getDetaNotaCreditos()) {
			detanotacredito.setid_nota_credito(notacredito.getId());
			DetaNotaCreditoDataAccess.save(detanotacredito,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(notacredito.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(notacredito.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(notacredito.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(notacredito.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(notacredito.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(notacredito.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(notacredito.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(notacredito.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(notacredito.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(notacredito.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(notacredito.getTipoPrecio(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(notacredito.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(notacredito.getFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(notacredito.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				ResponsableDataAccess.save(notacredito.getResponsable(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoNotaCredito.class)) {
				EstadoNotaCreditoDataAccess.save(notacredito.getEstadoNotaCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(notacredito.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(notacredito.getTipoCambio(),connexion);
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				TransporteDataAccess.save(notacredito.getTransporte(),connexion);
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(notacredito.getTransportista(),connexion);
				continue;
			}


			if(clas.clas.equals(DetaNotaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetaNotaCredito detanotacredito:notacredito.getDetaNotaCreditos()) {
					detanotacredito.setid_nota_credito(notacredito.getId());
					DetaNotaCreditoDataAccess.save(detanotacredito,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(notacredito.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(notacredito.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(notacredito.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(notacredito.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(notacredito.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(notacredito.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(notacredito.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(notacredito.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(notacredito.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(notacredito.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(notacredito.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(notacredito.getMes(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(notacredito.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(notacredito.getUsuario(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(notacredito.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(notacredito.getMoneda(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(notacredito.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(notacredito.getEmpleado(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(notacredito.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(notacredito.getFormato(),isDeep,deepLoadType,clases);
				

		TipoPrecioDataAccess.save(notacredito.getTipoPrecio(),connexion);
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(notacredito.getTipoPrecio(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(notacredito.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(notacredito.getCliente(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(notacredito.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(notacredito.getFactura(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(notacredito.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(notacredito.getVendedor(),isDeep,deepLoadType,clases);
				

		ResponsableDataAccess.save(notacredito.getResponsable(),connexion);
		ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
		responsableLogic.deepLoad(notacredito.getResponsable(),isDeep,deepLoadType,clases);
				

		EstadoNotaCreditoDataAccess.save(notacredito.getEstadoNotaCredito(),connexion);
		EstadoNotaCreditoLogic estadonotacreditoLogic= new EstadoNotaCreditoLogic(connexion);
		estadonotacreditoLogic.deepLoad(notacredito.getEstadoNotaCredito(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(notacredito.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(notacredito.getCentroCosto(),isDeep,deepLoadType,clases);
				

		TipoCambioDataAccess.save(notacredito.getTipoCambio(),connexion);
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(notacredito.getTipoCambio(),isDeep,deepLoadType,clases);
				

		TransporteDataAccess.save(notacredito.getTransporte(),connexion);
		TransporteLogic transporteLogic= new TransporteLogic(connexion);
		transporteLogic.deepLoad(notacredito.getTransporte(),isDeep,deepLoadType,clases);
				

		TransportistaDataAccess.save(notacredito.getTransportista(),connexion);
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(notacredito.getTransportista(),isDeep,deepLoadType,clases);
				

		for(DetaNotaCredito detanotacredito:notacredito.getDetaNotaCreditos()) {
			DetaNotaCreditoLogic detanotacreditoLogic= new DetaNotaCreditoLogic(connexion);
			detanotacredito.setid_nota_credito(notacredito.getId());
			DetaNotaCreditoDataAccess.save(detanotacredito,connexion);
			detanotacreditoLogic.deepSave(detanotacredito,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(notacredito.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(notacredito.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(notacredito.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(notacredito.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(notacredito.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(notacredito.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(notacredito.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(notacredito.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(notacredito.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(notacredito.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(notacredito.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(notacredito.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(notacredito.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(notacredito.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(notacredito.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(notacredito.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(notacredito.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(notacredito.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(notacredito.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(notacredito.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(notacredito.getTipoPrecio(),connexion);
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepSave(notacredito.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(notacredito.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(notacredito.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(notacredito.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(notacredito.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(notacredito.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(notacredito.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				ResponsableDataAccess.save(notacredito.getResponsable(),connexion);
				ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
				responsableLogic.deepSave(notacredito.getResponsable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoNotaCredito.class)) {
				EstadoNotaCreditoDataAccess.save(notacredito.getEstadoNotaCredito(),connexion);
				EstadoNotaCreditoLogic estadonotacreditoLogic= new EstadoNotaCreditoLogic(connexion);
				estadonotacreditoLogic.deepSave(notacredito.getEstadoNotaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(notacredito.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(notacredito.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(notacredito.getTipoCambio(),connexion);
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepSave(notacredito.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				TransporteDataAccess.save(notacredito.getTransporte(),connexion);
				TransporteLogic transporteLogic= new TransporteLogic(connexion);
				transporteLogic.deepSave(notacredito.getTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(notacredito.getTransportista(),connexion);
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepSave(notacredito.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetaNotaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetaNotaCredito detanotacredito:notacredito.getDetaNotaCreditos()) {
					DetaNotaCreditoLogic detanotacreditoLogic= new DetaNotaCreditoLogic(connexion);
					detanotacredito.setid_nota_credito(notacredito.getId());
					DetaNotaCreditoDataAccess.save(detanotacredito,connexion);
					detanotacreditoLogic.deepSave(detanotacredito,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(NotaCredito.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(notacredito,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(notacredito);
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
			this.deepLoad(this.notacredito,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacredito);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(NotaCredito.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(notacreditos!=null) {
				for(NotaCredito notacredito:notacreditos) {
					this.deepLoad(notacredito,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(notacreditos);
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
			if(notacreditos!=null) {
				for(NotaCredito notacredito:notacreditos) {
					this.deepLoad(notacredito,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(notacreditos);
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
			this.getNewConnexionToDeep(NotaCredito.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(notacredito,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(NotaCredito.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(notacreditos!=null) {
				for(NotaCredito notacredito:notacreditos) {
					this.deepSave(notacredito,isDeep,deepLoadType,clases);
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
			if(notacreditos!=null) {
				for(NotaCredito notacredito:notacreditos) {
					this.deepSave(notacredito,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getNotaCreditosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",NotaCreditoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",NotaCreditoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditosBusquedaPorNumeroPreImpresoWithConnection(String sFinalQuery,Pagination pagination,String numero)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroPreImpreso= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroPreImpreso.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero+"%",NotaCreditoConstantesFunciones.NUMEROPREIMPRESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroPreImpreso);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNumeroPreImpreso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditosBusquedaPorNumeroPreImpreso(String sFinalQuery,Pagination pagination,String numero)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroPreImpreso= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroPreImpreso.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero+"%",NotaCreditoConstantesFunciones.NUMEROPREIMPRESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroPreImpreso);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNumeroPreImpreso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,NotaCreditoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,NotaCreditoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditosFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,NotaCreditoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditosFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,NotaCreditoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditosFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,NotaCreditoConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditosFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,NotaCreditoConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditosFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,NotaCreditoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditosFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,NotaCreditoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditosFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,NotaCreditoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditosFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,NotaCreditoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,NotaCreditoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,NotaCreditoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditosFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,NotaCreditoConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditosFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,NotaCreditoConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditosFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,NotaCreditoConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditosFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,NotaCreditoConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditosFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,NotaCreditoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditosFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,NotaCreditoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditosFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,NotaCreditoConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditosFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,NotaCreditoConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditosFK_IdNotaCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_nota_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_nota_credito,NotaCreditoConstantesFunciones.IDESTADONOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoNotaCredito);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditosFK_IdNotaCredito(String sFinalQuery,Pagination pagination,Long id_estado_nota_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoNotaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoNotaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_nota_credito,NotaCreditoConstantesFunciones.IDESTADONOTACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoNotaCredito);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNotaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditosFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,NotaCreditoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditosFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,NotaCreditoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditosFK_IdResponsableWithConnection(String sFinalQuery,Pagination pagination,Long id_responsable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidResponsable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidResponsable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_responsable,NotaCreditoConstantesFunciones.IDRESPONSABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidResponsable);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdResponsable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditosFK_IdResponsable(String sFinalQuery,Pagination pagination,Long id_responsable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidResponsable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidResponsable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_responsable,NotaCreditoConstantesFunciones.IDRESPONSABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidResponsable);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdResponsable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,NotaCreditoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,NotaCreditoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditosFK_IdTipoCambioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,NotaCreditoConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditosFK_IdTipoCambio(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,NotaCreditoConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditosFK_IdTipoPrecioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,NotaCreditoConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditosFK_IdTipoPrecio(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,NotaCreditoConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditosFK_IdTransporteWithConnection(String sFinalQuery,Pagination pagination,Long id_transporte)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transporte,NotaCreditoConstantesFunciones.IDTRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransporte);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditosFK_IdTransporte(String sFinalQuery,Pagination pagination,Long id_transporte)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transporte,NotaCreditoConstantesFunciones.IDTRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransporte);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditosFK_IdTransportistaWithConnection(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,NotaCreditoConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditosFK_IdTransportista(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,NotaCreditoConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditosFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,NotaCreditoConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditosFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,NotaCreditoConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditosFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCredito.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,NotaCreditoConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditosFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,NotaCreditoConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			NotaCreditoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditos=notacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesNotaCredito(this.notacreditos);
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
			if(NotaCreditoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,NotaCreditoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,NotaCredito notacredito,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(NotaCreditoConstantesFunciones.ISCONAUDITORIA) {
				if(notacredito.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NotaCreditoDataAccess.TABLENAME, notacredito.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NotaCreditoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NotaCreditoLogic.registrarAuditoriaDetallesNotaCredito(connexion,notacredito,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(notacredito.getIsDeleted()) {
					/*if(!notacredito.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,NotaCreditoDataAccess.TABLENAME, notacredito.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////NotaCreditoLogic.registrarAuditoriaDetallesNotaCredito(connexion,notacredito,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NotaCreditoDataAccess.TABLENAME, notacredito.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(notacredito.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NotaCreditoDataAccess.TABLENAME, notacredito.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NotaCreditoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NotaCreditoLogic.registrarAuditoriaDetallesNotaCredito(connexion,notacredito,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesNotaCredito(Connexion connexion,NotaCredito notacredito)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(notacredito.getIsNew()||!notacredito.getid_empresa().equals(notacredito.getNotaCreditoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getid_empresa()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getid_empresa().toString();
				}
				if(notacredito.getid_empresa()!=null)
				{
					strValorNuevo=notacredito.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getid_sucursal().equals(notacredito.getNotaCreditoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getid_sucursal()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getid_sucursal().toString();
				}
				if(notacredito.getid_sucursal()!=null)
				{
					strValorNuevo=notacredito.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getid_ejercicio().equals(notacredito.getNotaCreditoOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getid_ejercicio()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getid_ejercicio().toString();
				}
				if(notacredito.getid_ejercicio()!=null)
				{
					strValorNuevo=notacredito.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getid_periodo().equals(notacredito.getNotaCreditoOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getid_periodo()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getid_periodo().toString();
				}
				if(notacredito.getid_periodo()!=null)
				{
					strValorNuevo=notacredito.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getid_anio().equals(notacredito.getNotaCreditoOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getid_anio()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getid_anio().toString();
				}
				if(notacredito.getid_anio()!=null)
				{
					strValorNuevo=notacredito.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getid_mes().equals(notacredito.getNotaCreditoOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getid_mes()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getid_mes().toString();
				}
				if(notacredito.getid_mes()!=null)
				{
					strValorNuevo=notacredito.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getid_usuario().equals(notacredito.getNotaCreditoOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getid_usuario()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getid_usuario().toString();
				}
				if(notacredito.getid_usuario()!=null)
				{
					strValorNuevo=notacredito.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getcodigo().equals(notacredito.getNotaCreditoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getcodigo()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getcodigo();
				}
				if(notacredito.getcodigo()!=null)
				{
					strValorNuevo=notacredito.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getnumero().equals(notacredito.getNotaCreditoOriginal().getnumero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getnumero()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getnumero();
				}
				if(notacredito.getnumero()!=null)
				{
					strValorNuevo=notacredito.getnumero() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.NUMEROPREIMPRESO,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getfecha_emision().equals(notacredito.getNotaCreditoOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getfecha_emision()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getfecha_emision().toString();
				}
				if(notacredito.getfecha_emision()!=null)
				{
					strValorNuevo=notacredito.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getnumero_dias().equals(notacredito.getNotaCreditoOriginal().getnumero_dias()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getnumero_dias()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getnumero_dias().toString();
				}
				if(notacredito.getnumero_dias()!=null)
				{
					strValorNuevo=notacredito.getnumero_dias().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.NUMERODIAS,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getfecha_vencimiento().equals(notacredito.getNotaCreditoOriginal().getfecha_vencimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getfecha_vencimiento()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getfecha_vencimiento().toString();
				}
				if(notacredito.getfecha_vencimiento()!=null)
				{
					strValorNuevo=notacredito.getfecha_vencimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.FECHAVENCIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getid_moneda().equals(notacredito.getNotaCreditoOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getid_moneda()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getid_moneda().toString();
				}
				if(notacredito.getid_moneda()!=null)
				{
					strValorNuevo=notacredito.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getcotizacion().equals(notacredito.getNotaCreditoOriginal().getcotizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getcotizacion()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getcotizacion().toString();
				}
				if(notacredito.getcotizacion()!=null)
				{
					strValorNuevo=notacredito.getcotizacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.COTIZACION,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getid_empleado().equals(notacredito.getNotaCreditoOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getid_empleado()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getid_empleado().toString();
				}
				if(notacredito.getid_empleado()!=null)
				{
					strValorNuevo=notacredito.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getid_formato().equals(notacredito.getNotaCreditoOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getid_formato()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getid_formato().toString();
				}
				if(notacredito.getid_formato()!=null)
				{
					strValorNuevo=notacredito.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getid_tipo_precio().equals(notacredito.getNotaCreditoOriginal().getid_tipo_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getid_tipo_precio()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getid_tipo_precio().toString();
				}
				if(notacredito.getid_tipo_precio()!=null)
				{
					strValorNuevo=notacredito.getid_tipo_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.IDTIPOPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getid_cliente().equals(notacredito.getNotaCreditoOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getid_cliente()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getid_cliente().toString();
				}
				if(notacredito.getid_cliente()!=null)
				{
					strValorNuevo=notacredito.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getid_factura().equals(notacredito.getNotaCreditoOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getid_factura()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getid_factura().toString();
				}
				if(notacredito.getid_factura()!=null)
				{
					strValorNuevo=notacredito.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getdireccion().equals(notacredito.getNotaCreditoOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getdireccion()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getdireccion();
				}
				if(notacredito.getdireccion()!=null)
				{
					strValorNuevo=notacredito.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.gettelefono().equals(notacredito.getNotaCreditoOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().gettelefono()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().gettelefono();
				}
				if(notacredito.gettelefono()!=null)
				{
					strValorNuevo=notacredito.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getruc().equals(notacredito.getNotaCreditoOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getruc()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getruc();
				}
				if(notacredito.getruc()!=null)
				{
					strValorNuevo=notacredito.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getid_vendedor().equals(notacredito.getNotaCreditoOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getid_vendedor()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getid_vendedor().toString();
				}
				if(notacredito.getid_vendedor()!=null)
				{
					strValorNuevo=notacredito.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getid_responsable().equals(notacredito.getNotaCreditoOriginal().getid_responsable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getid_responsable()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getid_responsable().toString();
				}
				if(notacredito.getid_responsable()!=null)
				{
					strValorNuevo=notacredito.getid_responsable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.IDRESPONSABLE,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getid_estado_nota_credito().equals(notacredito.getNotaCreditoOriginal().getid_estado_nota_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getid_estado_nota_credito()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getid_estado_nota_credito().toString();
				}
				if(notacredito.getid_estado_nota_credito()!=null)
				{
					strValorNuevo=notacredito.getid_estado_nota_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.IDESTADONOTACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getdescripcion().equals(notacredito.getNotaCreditoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getdescripcion()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getdescripcion();
				}
				if(notacredito.getdescripcion()!=null)
				{
					strValorNuevo=notacredito.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getdescuento_porcentaje().equals(notacredito.getNotaCreditoOriginal().getdescuento_porcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getdescuento_porcentaje()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getdescuento_porcentaje().toString();
				}
				if(notacredito.getdescuento_porcentaje()!=null)
				{
					strValorNuevo=notacredito.getdescuento_porcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.DESCUENTOPORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.gettotal_iva().equals(notacredito.getNotaCreditoOriginal().gettotal_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().gettotal_iva()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().gettotal_iva().toString();
				}
				if(notacredito.gettotal_iva()!=null)
				{
					strValorNuevo=notacredito.gettotal_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.TOTALIVA,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getsuman().equals(notacredito.getNotaCreditoOriginal().getsuman()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getsuman()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getsuman().toString();
				}
				if(notacredito.getsuman()!=null)
				{
					strValorNuevo=notacredito.getsuman().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.SUMAN,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getdescuento_valor().equals(notacredito.getNotaCreditoOriginal().getdescuento_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getdescuento_valor()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getdescuento_valor().toString();
				}
				if(notacredito.getdescuento_valor()!=null)
				{
					strValorNuevo=notacredito.getdescuento_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.DESCUENTOVALOR,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.gettotal_sin_iva().equals(notacredito.getNotaCreditoOriginal().gettotal_sin_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().gettotal_sin_iva()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().gettotal_sin_iva().toString();
				}
				if(notacredito.gettotal_sin_iva()!=null)
				{
					strValorNuevo=notacredito.gettotal_sin_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.TOTALSINIVA,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.gettotal_descuento().equals(notacredito.getNotaCreditoOriginal().gettotal_descuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().gettotal_descuento()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().gettotal_descuento().toString();
				}
				if(notacredito.gettotal_descuento()!=null)
				{
					strValorNuevo=notacredito.gettotal_descuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.TOTALDESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getflete().equals(notacredito.getNotaCreditoOriginal().getflete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getflete()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getflete().toString();
				}
				if(notacredito.getflete()!=null)
				{
					strValorNuevo=notacredito.getflete().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.FLETE,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.gettotal().equals(notacredito.getNotaCreditoOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().gettotal()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().gettotal().toString();
				}
				if(notacredito.gettotal()!=null)
				{
					strValorNuevo=notacredito.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getsub_total().equals(notacredito.getNotaCreditoOriginal().getsub_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getsub_total()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getsub_total().toString();
				}
				if(notacredito.getsub_total()!=null)
				{
					strValorNuevo=notacredito.getsub_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.SUBTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getotro().equals(notacredito.getNotaCreditoOriginal().getotro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getotro()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getotro().toString();
				}
				if(notacredito.getotro()!=null)
				{
					strValorNuevo=notacredito.getotro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.OTRO,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getiva().equals(notacredito.getNotaCreditoOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getiva()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getiva().toString();
				}
				if(notacredito.getiva()!=null)
				{
					strValorNuevo=notacredito.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getfinanciamiento().equals(notacredito.getNotaCreditoOriginal().getfinanciamiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getfinanciamiento()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getfinanciamiento().toString();
				}
				if(notacredito.getfinanciamiento()!=null)
				{
					strValorNuevo=notacredito.getfinanciamiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.FINANCIAMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getice().equals(notacredito.getNotaCreditoOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getice()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getice().toString();
				}
				if(notacredito.getice()!=null)
				{
					strValorNuevo=notacredito.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getotro_valor().equals(notacredito.getNotaCreditoOriginal().getotro_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getotro_valor()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getotro_valor().toString();
				}
				if(notacredito.getotro_valor()!=null)
				{
					strValorNuevo=notacredito.getotro_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.OTROVALOR,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getretencion().equals(notacredito.getNotaCreditoOriginal().getretencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getretencion()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getretencion().toString();
				}
				if(notacredito.getretencion()!=null)
				{
					strValorNuevo=notacredito.getretencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.RETENCION,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getfecha().equals(notacredito.getNotaCreditoOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getfecha()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getfecha().toString();
				}
				if(notacredito.getfecha()!=null)
				{
					strValorNuevo=notacredito.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getes_cliente().equals(notacredito.getNotaCreditoOriginal().getes_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getes_cliente()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getes_cliente().toString();
				}
				if(notacredito.getes_cliente()!=null)
				{
					strValorNuevo=notacredito.getes_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.ESCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getid_centro_costo().equals(notacredito.getNotaCreditoOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getid_centro_costo()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getid_centro_costo().toString();
				}
				if(notacredito.getid_centro_costo()!=null)
				{
					strValorNuevo=notacredito.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getid_tipo_cambio().equals(notacredito.getNotaCreditoOriginal().getid_tipo_cambio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getid_tipo_cambio()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getid_tipo_cambio().toString();
				}
				if(notacredito.getid_tipo_cambio()!=null)
				{
					strValorNuevo=notacredito.getid_tipo_cambio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.IDTIPOCAMBIO,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getid_transporte().equals(notacredito.getNotaCreditoOriginal().getid_transporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getid_transporte()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getid_transporte().toString();
				}
				if(notacredito.getid_transporte()!=null)
				{
					strValorNuevo=notacredito.getid_transporte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.IDTRANSPORTE,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getid_transportista().equals(notacredito.getNotaCreditoOriginal().getid_transportista()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getid_transportista()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getid_transportista().toString();
				}
				if(notacredito.getid_transportista()!=null)
				{
					strValorNuevo=notacredito.getid_transportista().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.IDTRANSPORTISTA,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getfecha_cliente().equals(notacredito.getNotaCreditoOriginal().getfecha_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getfecha_cliente()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getfecha_cliente().toString();
				}
				if(notacredito.getfecha_cliente()!=null)
				{
					strValorNuevo=notacredito.getfecha_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.FECHACLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(notacredito.getIsNew()||!notacredito.getfecha_autorizacion().equals(notacredito.getNotaCreditoOriginal().getfecha_autorizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacredito.getNotaCreditoOriginal().getfecha_autorizacion()!=null)
				{
					strValorActual=notacredito.getNotaCreditoOriginal().getfecha_autorizacion().toString();
				}
				if(notacredito.getfecha_autorizacion()!=null)
				{
					strValorNuevo=notacredito.getfecha_autorizacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoConstantesFunciones.FECHAAUTORIZACION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveNotaCreditoRelacionesWithConnection(NotaCredito notacredito,List<DetaNotaCredito> detanotacreditos) throws Exception {

		if(!notacredito.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNotaCreditoRelacionesBase(notacredito,detanotacreditos,true);
		}
	}

	public void saveNotaCreditoRelaciones(NotaCredito notacredito,List<DetaNotaCredito> detanotacreditos)throws Exception {

		if(!notacredito.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNotaCreditoRelacionesBase(notacredito,detanotacreditos,false);
		}
	}

	public void saveNotaCreditoRelacionesBase(NotaCredito notacredito,List<DetaNotaCredito> detanotacreditos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("NotaCredito-saveRelacionesWithConnection");}
	
			notacredito.setDetaNotaCreditos(detanotacreditos);

			this.setNotaCredito(notacredito);

			if(NotaCreditoLogicAdditional.validarSaveRelaciones(notacredito,this)) {

				NotaCreditoLogicAdditional.updateRelacionesToSave(notacredito,this);

				if((notacredito.getIsNew()||notacredito.getIsChanged())&&!notacredito.getIsDeleted()) {
					this.saveNotaCredito();
					this.saveNotaCreditoRelacionesDetalles(detanotacreditos);

				} else if(notacredito.getIsDeleted()) {
					this.saveNotaCreditoRelacionesDetalles(detanotacreditos);
					this.saveNotaCredito();
				}

				NotaCreditoLogicAdditional.updateRelacionesToSaveAfter(notacredito,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetaNotaCreditoConstantesFunciones.InicializarGeneralEntityAuxiliaresDetaNotaCreditos(detanotacreditos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveNotaCreditoRelacionesDetalles(List<DetaNotaCredito> detanotacreditos)throws Exception {
		try {
	

			Long idNotaCreditoActual=this.getNotaCredito().getId();

			DetaNotaCreditoLogic detanotacreditoLogic_Desde_NotaCredito=new DetaNotaCreditoLogic();
			detanotacreditoLogic_Desde_NotaCredito.setDetaNotaCreditos(detanotacreditos);

			detanotacreditoLogic_Desde_NotaCredito.setConnexion(this.getConnexion());
			detanotacreditoLogic_Desde_NotaCredito.setDatosCliente(this.datosCliente);

			for(DetaNotaCredito detanotacredito_Desde_NotaCredito:detanotacreditoLogic_Desde_NotaCredito.getDetaNotaCreditos()) {
				detanotacredito_Desde_NotaCredito.setid_nota_credito(idNotaCreditoActual);
			}

			detanotacreditoLogic_Desde_NotaCredito.saveDetaNotaCreditos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfNotaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NotaCreditoConstantesFunciones.getClassesForeignKeysOfNotaCredito(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNotaCredito(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NotaCreditoConstantesFunciones.getClassesRelationshipsOfNotaCredito(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

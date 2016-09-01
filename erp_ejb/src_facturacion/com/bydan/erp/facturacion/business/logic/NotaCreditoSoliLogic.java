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
import com.bydan.erp.facturacion.util.NotaCreditoSoliConstantesFunciones;
import com.bydan.erp.facturacion.util.NotaCreditoSoliParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.NotaCreditoSoliParameterGeneral;
import com.bydan.erp.facturacion.business.entity.NotaCreditoSoli;
import com.bydan.erp.facturacion.business.logic.NotaCreditoSoliLogicAdditional;
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
public class NotaCreditoSoliLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(NotaCreditoSoliLogic.class);
	
	protected NotaCreditoSoliDataAccess notacreditosoliDataAccess; 	
	protected NotaCreditoSoli notacreditosoli;
	protected List<NotaCreditoSoli> notacreditosolis;
	protected Object notacreditosoliObject;	
	protected List<Object> notacreditosolisObject;
	
	public static ClassValidator<NotaCreditoSoli> notacreditosoliValidator = new ClassValidator<NotaCreditoSoli>(NotaCreditoSoli.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected NotaCreditoSoliLogicAdditional notacreditosoliLogicAdditional=null;
	
	public NotaCreditoSoliLogicAdditional getNotaCreditoSoliLogicAdditional() {
		return this.notacreditosoliLogicAdditional;
	}
	
	public void setNotaCreditoSoliLogicAdditional(NotaCreditoSoliLogicAdditional notacreditosoliLogicAdditional) {
		try {
			this.notacreditosoliLogicAdditional=notacreditosoliLogicAdditional;
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
	
	
	
	
	public  NotaCreditoSoliLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.notacreditosoliDataAccess = new NotaCreditoSoliDataAccess();
			
			this.notacreditosolis= new ArrayList<NotaCreditoSoli>();
			this.notacreditosoli= new NotaCreditoSoli();
			
			this.notacreditosoliObject=new Object();
			this.notacreditosolisObject=new ArrayList<Object>();
				
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
			
			this.notacreditosoliDataAccess.setConnexionType(this.connexionType);
			this.notacreditosoliDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  NotaCreditoSoliLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.notacreditosoliDataAccess = new NotaCreditoSoliDataAccess();
			this.notacreditosolis= new ArrayList<NotaCreditoSoli>();
			this.notacreditosoli= new NotaCreditoSoli();
			this.notacreditosoliObject=new Object();
			this.notacreditosolisObject=new ArrayList<Object>();
			
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
			
			this.notacreditosoliDataAccess.setConnexionType(this.connexionType);
			this.notacreditosoliDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public NotaCreditoSoli getNotaCreditoSoli() throws Exception {	
		NotaCreditoSoliLogicAdditional.checkNotaCreditoSoliToGet(notacreditosoli,this.datosCliente,this.arrDatoGeneral);
		NotaCreditoSoliLogicAdditional.updateNotaCreditoSoliToGet(notacreditosoli,this.arrDatoGeneral);
		
		return notacreditosoli;
	}
		
	public void setNotaCreditoSoli(NotaCreditoSoli newNotaCreditoSoli) {
		this.notacreditosoli = newNotaCreditoSoli;
	}
	
	public NotaCreditoSoliDataAccess getNotaCreditoSoliDataAccess() {
		return notacreditosoliDataAccess;
	}
	
	public void setNotaCreditoSoliDataAccess(NotaCreditoSoliDataAccess newnotacreditosoliDataAccess) {
		this.notacreditosoliDataAccess = newnotacreditosoliDataAccess;
	}
	
	public List<NotaCreditoSoli> getNotaCreditoSolis() throws Exception {		
		this.quitarNotaCreditoSolisNulos();
		
		NotaCreditoSoliLogicAdditional.checkNotaCreditoSoliToGets(notacreditosolis,this.datosCliente,this.arrDatoGeneral);
		
		for (NotaCreditoSoli notacreditosoliLocal: notacreditosolis ) {
			NotaCreditoSoliLogicAdditional.updateNotaCreditoSoliToGet(notacreditosoliLocal,this.arrDatoGeneral);
		}
		
		return notacreditosolis;
	}
	
	public void setNotaCreditoSolis(List<NotaCreditoSoli> newNotaCreditoSolis) {
		this.notacreditosolis = newNotaCreditoSolis;
	}
	
	public Object getNotaCreditoSoliObject() {	
		this.notacreditosoliObject=this.notacreditosoliDataAccess.getEntityObject();
		return this.notacreditosoliObject;
	}
		
	public void setNotaCreditoSoliObject(Object newNotaCreditoSoliObject) {
		this.notacreditosoliObject = newNotaCreditoSoliObject;
	}
	
	public List<Object> getNotaCreditoSolisObject() {		
		this.notacreditosolisObject=this.notacreditosoliDataAccess.getEntitiesObject();
		return this.notacreditosolisObject;
	}
		
	public void setNotaCreditoSolisObject(List<Object> newNotaCreditoSolisObject) {
		this.notacreditosolisObject = newNotaCreditoSolisObject;
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
		
		if(this.notacreditosoliDataAccess!=null) {
			this.notacreditosoliDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			notacreditosoliDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			notacreditosoliDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		notacreditosoli = new  NotaCreditoSoli();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			notacreditosoli=notacreditosoliDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.notacreditosoli,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosoli);
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
		notacreditosoli = new  NotaCreditoSoli();
		  		  
        try {
			
			notacreditosoli=notacreditosoliDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.notacreditosoli,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosoli);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		notacreditosoli = new  NotaCreditoSoli();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			notacreditosoli=notacreditosoliDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.notacreditosoli,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosoli);
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
		notacreditosoli = new  NotaCreditoSoli();
		  		  
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
		notacreditosoli = new  NotaCreditoSoli();
		  		  
        try {
			
			notacreditosoli=notacreditosoliDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.notacreditosoli,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosoli);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		notacreditosoli = new  NotaCreditoSoli();
		  		  
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
		notacreditosoli = new  NotaCreditoSoli();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =notacreditosoliDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		notacreditosoli = new  NotaCreditoSoli();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=notacreditosoliDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		notacreditosoli = new  NotaCreditoSoli();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =notacreditosoliDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		notacreditosoli = new  NotaCreditoSoli();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=notacreditosoliDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		notacreditosoli = new  NotaCreditoSoli();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =notacreditosoliDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		notacreditosoli = new  NotaCreditoSoli();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=notacreditosoliDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		notacreditosolis = new  ArrayList<NotaCreditoSoli>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNotaCreditoSoli(notacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
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
		notacreditosolis = new  ArrayList<NotaCreditoSoli>();
		  		  
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
		notacreditosolis = new  ArrayList<NotaCreditoSoli>();
		  		  
        try {			
			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarNotaCreditoSoli(notacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		notacreditosolis = new  ArrayList<NotaCreditoSoli>();
		  		  
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
		notacreditosolis = new  ArrayList<NotaCreditoSoli>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNotaCreditoSoli(notacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
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
		notacreditosolis = new  ArrayList<NotaCreditoSoli>();
		  		  
        try {
			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNotaCreditoSoli(notacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
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
		notacreditosolis = new  ArrayList<NotaCreditoSoli>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNotaCreditoSoli(notacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
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
		notacreditosolis = new  ArrayList<NotaCreditoSoli>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNotaCreditoSoli(notacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		notacreditosoli = new  NotaCreditoSoli();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditosoli=notacreditosoliDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNotaCreditoSoli(notacreditosoli);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosoli);
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
		notacreditosoli = new  NotaCreditoSoli();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditosoli=notacreditosoliDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNotaCreditoSoli(notacreditosoli);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosoli);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		notacreditosolis = new  ArrayList<NotaCreditoSoli>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditosolis=notacreditosoliDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNotaCreditoSoli(notacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
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
		notacreditosolis = new  ArrayList<NotaCreditoSoli>();
		  		  
        try {
			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditosolis=notacreditosoliDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNotaCreditoSoli(notacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosNotaCreditoSolisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		notacreditosolis = new  ArrayList<NotaCreditoSoli>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getTodosNotaCreditoSolisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNotaCreditoSoli(notacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
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
	
	public  void  getTodosNotaCreditoSolis(String sFinalQuery,Pagination pagination)throws Exception {
		notacreditosolis = new  ArrayList<NotaCreditoSoli>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNotaCreditoSoli(notacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarNotaCreditoSoli(NotaCreditoSoli notacreditosoli) throws Exception {
		Boolean estaValidado=false;
		
		if(notacreditosoli.getIsNew() || notacreditosoli.getIsChanged()) { 
			this.invalidValues = notacreditosoliValidator.getInvalidValues(notacreditosoli);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(notacreditosoli);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarNotaCreditoSoli(List<NotaCreditoSoli> NotaCreditoSolis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(NotaCreditoSoli notacreditosoliLocal:notacreditosolis) {				
			estaValidadoObjeto=this.validarGuardarNotaCreditoSoli(notacreditosoliLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarNotaCreditoSoli(List<NotaCreditoSoli> NotaCreditoSolis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNotaCreditoSoli(notacreditosolis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarNotaCreditoSoli(NotaCreditoSoli NotaCreditoSoli) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNotaCreditoSoli(notacreditosoli)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(NotaCreditoSoli notacreditosoli) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+notacreditosoli.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=NotaCreditoSoliConstantesFunciones.getNotaCreditoSoliLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"notacreditosoli","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(NotaCreditoSoliConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(NotaCreditoSoliConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveNotaCreditoSoliWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-saveNotaCreditoSoliWithConnection");connexion.begin();			
			
			NotaCreditoSoliLogicAdditional.checkNotaCreditoSoliToSave(this.notacreditosoli,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NotaCreditoSoliLogicAdditional.updateNotaCreditoSoliToSave(this.notacreditosoli,this.arrDatoGeneral);
			
			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.notacreditosoli,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowNotaCreditoSoli();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNotaCreditoSoli(this.notacreditosoli)) {
				NotaCreditoSoliDataAccess.save(this.notacreditosoli, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.notacreditosoli,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NotaCreditoSoliLogicAdditional.checkNotaCreditoSoliToSaveAfter(this.notacreditosoli,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNotaCreditoSoli();
			
			connexion.commit();			
			
			if(this.notacreditosoli.getIsDeleted()) {
				this.notacreditosoli=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveNotaCreditoSoli()throws Exception {	
		try {	
			
			NotaCreditoSoliLogicAdditional.checkNotaCreditoSoliToSave(this.notacreditosoli,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NotaCreditoSoliLogicAdditional.updateNotaCreditoSoliToSave(this.notacreditosoli,this.arrDatoGeneral);
			
			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.notacreditosoli,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNotaCreditoSoli(this.notacreditosoli)) {			
				NotaCreditoSoliDataAccess.save(this.notacreditosoli, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.notacreditosoli,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NotaCreditoSoliLogicAdditional.checkNotaCreditoSoliToSaveAfter(this.notacreditosoli,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.notacreditosoli.getIsDeleted()) {
				this.notacreditosoli=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveNotaCreditoSolisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-saveNotaCreditoSolisWithConnection");connexion.begin();			
			
			NotaCreditoSoliLogicAdditional.checkNotaCreditoSoliToSaves(notacreditosolis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowNotaCreditoSolis();
			
			Boolean validadoTodosNotaCreditoSoli=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NotaCreditoSoli notacreditosoliLocal:notacreditosolis) {		
				if(notacreditosoliLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NotaCreditoSoliLogicAdditional.updateNotaCreditoSoliToSave(notacreditosoliLocal,this.arrDatoGeneral);
	        	
				NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),notacreditosoliLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNotaCreditoSoli(notacreditosoliLocal)) {
					NotaCreditoSoliDataAccess.save(notacreditosoliLocal, connexion);				
				} else {
					validadoTodosNotaCreditoSoli=false;
				}
			}
			
			if(!validadoTodosNotaCreditoSoli) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NotaCreditoSoliLogicAdditional.checkNotaCreditoSoliToSavesAfter(notacreditosolis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNotaCreditoSolis();
			
			connexion.commit();		
			
			this.quitarNotaCreditoSolisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveNotaCreditoSolis()throws Exception {				
		 try {	
			NotaCreditoSoliLogicAdditional.checkNotaCreditoSoliToSaves(notacreditosolis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosNotaCreditoSoli=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NotaCreditoSoli notacreditosoliLocal:notacreditosolis) {				
				if(notacreditosoliLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NotaCreditoSoliLogicAdditional.updateNotaCreditoSoliToSave(notacreditosoliLocal,this.arrDatoGeneral);
	        	
				NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),notacreditosoliLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNotaCreditoSoli(notacreditosoliLocal)) {				
					NotaCreditoSoliDataAccess.save(notacreditosoliLocal, connexion);				
				} else {
					validadoTodosNotaCreditoSoli=false;
				}
			}
			
			if(!validadoTodosNotaCreditoSoli) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NotaCreditoSoliLogicAdditional.checkNotaCreditoSoliToSavesAfter(notacreditosolis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarNotaCreditoSolisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NotaCreditoSoliParameterReturnGeneral procesarAccionNotaCreditoSolis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NotaCreditoSoli> notacreditosolis,NotaCreditoSoliParameterReturnGeneral notacreditosoliParameterGeneral)throws Exception {
		 try {	
			NotaCreditoSoliParameterReturnGeneral notacreditosoliReturnGeneral=new NotaCreditoSoliParameterReturnGeneral();
	
			NotaCreditoSoliLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,notacreditosolis,notacreditosoliParameterGeneral,notacreditosoliReturnGeneral);
			
			return notacreditosoliReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NotaCreditoSoliParameterReturnGeneral procesarAccionNotaCreditoSolisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NotaCreditoSoli> notacreditosolis,NotaCreditoSoliParameterReturnGeneral notacreditosoliParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-procesarAccionNotaCreditoSolisWithConnection");connexion.begin();			
			
			NotaCreditoSoliParameterReturnGeneral notacreditosoliReturnGeneral=new NotaCreditoSoliParameterReturnGeneral();
	
			NotaCreditoSoliLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,notacreditosolis,notacreditosoliParameterGeneral,notacreditosoliReturnGeneral);
			
			this.connexion.commit();
			
			return notacreditosoliReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NotaCreditoSoliParameterReturnGeneral procesarEventosNotaCreditoSolis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NotaCreditoSoli> notacreditosolis,NotaCreditoSoli notacreditosoli,NotaCreditoSoliParameterReturnGeneral notacreditosoliParameterGeneral,Boolean isEsNuevoNotaCreditoSoli,ArrayList<Classe> clases)throws Exception {
		 try {	
			NotaCreditoSoliParameterReturnGeneral notacreditosoliReturnGeneral=new NotaCreditoSoliParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				notacreditosoliReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NotaCreditoSoliLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,notacreditosolis,notacreditosoli,notacreditosoliParameterGeneral,notacreditosoliReturnGeneral,isEsNuevoNotaCreditoSoli,clases);
			
			return notacreditosoliReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public NotaCreditoSoliParameterReturnGeneral procesarEventosNotaCreditoSolisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NotaCreditoSoli> notacreditosolis,NotaCreditoSoli notacreditosoli,NotaCreditoSoliParameterReturnGeneral notacreditosoliParameterGeneral,Boolean isEsNuevoNotaCreditoSoli,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-procesarEventosNotaCreditoSolisWithConnection");connexion.begin();			
			
			NotaCreditoSoliParameterReturnGeneral notacreditosoliReturnGeneral=new NotaCreditoSoliParameterReturnGeneral();
	
			notacreditosoliReturnGeneral.setNotaCreditoSoli(notacreditosoli);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				notacreditosoliReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NotaCreditoSoliLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,notacreditosolis,notacreditosoli,notacreditosoliParameterGeneral,notacreditosoliReturnGeneral,isEsNuevoNotaCreditoSoli,clases);
			
			this.connexion.commit();
			
			return notacreditosoliReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NotaCreditoSoliParameterReturnGeneral procesarImportacionNotaCreditoSolisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,NotaCreditoSoliParameterReturnGeneral notacreditosoliParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-procesarImportacionNotaCreditoSolisWithConnection");connexion.begin();			
			
			NotaCreditoSoliParameterReturnGeneral notacreditosoliReturnGeneral=new NotaCreditoSoliParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.notacreditosolis=new ArrayList<NotaCreditoSoli>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.notacreditosoli=new NotaCreditoSoli();
				
				
				if(conColumnasBase) {this.notacreditosoli.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.notacreditosoli.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.notacreditosoli.setcodigo(arrColumnas[iColumn++]);
				this.notacreditosoli.setnumero(arrColumnas[iColumn++]);
				this.notacreditosoli.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.notacreditosoli.setnumero_dias(Integer.parseInt(arrColumnas[iColumn++]));
				this.notacreditosoli.setfecha_vencimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.notacreditosoli.setcotizacion(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacreditosoli.setdireccion(arrColumnas[iColumn++]);
				this.notacreditosoli.settelefono(arrColumnas[iColumn++]);
				this.notacreditosoli.setruc(arrColumnas[iColumn++]);
				this.notacreditosoli.setdescripcion(arrColumnas[iColumn++]);
				this.notacreditosoli.setpenalizado(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.notacreditosoli.setdescuento_porcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacreditosoli.settotal_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacreditosoli.setsuman(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacreditosoli.setdescuento_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacreditosoli.settotal_sin_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacreditosoli.setdescuento_general(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacreditosoli.setflete(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacreditosoli.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacreditosoli.setsub_total(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacreditosoli.setotro(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacreditosoli.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacreditosoli.setfinanciamiento(Double.parseDouble(arrColumnas[iColumn++]));
				this.notacreditosoli.setotro_valor(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.notacreditosolis.add(this.notacreditosoli);
			}
			
			this.saveNotaCreditoSolis();
			
			this.connexion.commit();
			
			notacreditosoliReturnGeneral.setConRetornoEstaProcesado(true);
			notacreditosoliReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return notacreditosoliReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarNotaCreditoSolisEliminados() throws Exception {				
		
		List<NotaCreditoSoli> notacreditosolisAux= new ArrayList<NotaCreditoSoli>();
		
		for(NotaCreditoSoli notacreditosoli:notacreditosolis) {
			if(!notacreditosoli.getIsDeleted()) {
				notacreditosolisAux.add(notacreditosoli);
			}
		}
		
		notacreditosolis=notacreditosolisAux;
	}
	
	public void quitarNotaCreditoSolisNulos() throws Exception {				
		
		List<NotaCreditoSoli> notacreditosolisAux= new ArrayList<NotaCreditoSoli>();
		
		for(NotaCreditoSoli notacreditosoli : this.notacreditosolis) {
			if(notacreditosoli==null) {
				notacreditosolisAux.add(notacreditosoli);
			}
		}
		
		//this.notacreditosolis=notacreditosolisAux;
		
		this.notacreditosolis.removeAll(notacreditosolisAux);
	}
	
	public void getSetVersionRowNotaCreditoSoliWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(notacreditosoli.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((notacreditosoli.getIsDeleted() || (notacreditosoli.getIsChanged()&&!notacreditosoli.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=notacreditosoliDataAccess.getSetVersionRowNotaCreditoSoli(connexion,notacreditosoli.getId());
				
				if(!notacreditosoli.getVersionRow().equals(timestamp)) {	
					notacreditosoli.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				notacreditosoli.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowNotaCreditoSoli()throws Exception {	
		
		if(notacreditosoli.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((notacreditosoli.getIsDeleted() || (notacreditosoli.getIsChanged()&&!notacreditosoli.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=notacreditosoliDataAccess.getSetVersionRowNotaCreditoSoli(connexion,notacreditosoli.getId());
			
			try {							
				if(!notacreditosoli.getVersionRow().equals(timestamp)) {	
					notacreditosoli.setVersionRow(timestamp);
				}
				
				notacreditosoli.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowNotaCreditoSolisWithConnection()throws Exception {	
		if(notacreditosolis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(NotaCreditoSoli notacreditosoliAux:notacreditosolis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(notacreditosoliAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(notacreditosoliAux.getIsDeleted() || (notacreditosoliAux.getIsChanged()&&!notacreditosoliAux.getIsNew())) {
						
						timestamp=notacreditosoliDataAccess.getSetVersionRowNotaCreditoSoli(connexion,notacreditosoliAux.getId());
						
						if(!notacreditosoli.getVersionRow().equals(timestamp)) {	
							notacreditosoliAux.setVersionRow(timestamp);
						}
								
						notacreditosoliAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowNotaCreditoSolis()throws Exception {	
		if(notacreditosolis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(NotaCreditoSoli notacreditosoliAux:notacreditosolis) {
					if(notacreditosoliAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(notacreditosoliAux.getIsDeleted() || (notacreditosoliAux.getIsChanged()&&!notacreditosoliAux.getIsNew())) {
						
						timestamp=notacreditosoliDataAccess.getSetVersionRowNotaCreditoSoli(connexion,notacreditosoliAux.getId());
						
						if(!notacreditosoliAux.getVersionRow().equals(timestamp)) {	
							notacreditosoliAux.setVersionRow(timestamp);
						}
						
													
						notacreditosoliAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public NotaCreditoSoliParameterReturnGeneral cargarCombosLoteForeignKeyNotaCreditoSoliWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalUsuario,String finalQueryGlobalMoneda,String finalQueryGlobalEmpleado,String finalQueryGlobalFormato,String finalQueryGlobalTipoPrecio,String finalQueryGlobalCliente,String finalQueryGlobalFactura,String finalQueryGlobalTipoNotaCreditoSoli,String finalQueryGlobalResponsable,String finalQueryGlobalEstadoNotaCreditoSoli,String finalQueryGlobalCentroCosto,String finalQueryGlobalVendedor,String finalQueryGlobalTipoCambio,String finalQueryGlobalTransporte,String finalQueryGlobalTransportista) throws Exception {
		NotaCreditoSoliParameterReturnGeneral  notacreditosoliReturnGeneral =new NotaCreditoSoliParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-cargarCombosLoteForeignKeyNotaCreditoSoliWithConnection");connexion.begin();
			
			notacreditosoliReturnGeneral =new NotaCreditoSoliParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			notacreditosoliReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			notacreditosoliReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			notacreditosoliReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			notacreditosoliReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			notacreditosoliReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			notacreditosoliReturnGeneral.setmessForeignKey(messForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			notacreditosoliReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			notacreditosoliReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			notacreditosoliReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			notacreditosoliReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			notacreditosoliReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			notacreditosoliReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			notacreditosoliReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<TipoNotaCreditoSoli> tiponotacreditosolisForeignKey=new ArrayList<TipoNotaCreditoSoli>();
			TipoNotaCreditoSoliLogic tiponotacreditosoliLogic=new TipoNotaCreditoSoliLogic();
			tiponotacreditosoliLogic.setConnexion(this.connexion);
			tiponotacreditosoliLogic.getTipoNotaCreditoSoliDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoNotaCreditoSoli.equals("NONE")) {
				tiponotacreditosoliLogic.getTodosTipoNotaCreditoSolis(finalQueryGlobalTipoNotaCreditoSoli,new Pagination());
				tiponotacreditosolisForeignKey=tiponotacreditosoliLogic.getTipoNotaCreditoSolis();
			}

			notacreditosoliReturnGeneral.settiponotacreditosolisForeignKey(tiponotacreditosolisForeignKey);


			List<Responsable> responsablesForeignKey=new ArrayList<Responsable>();
			ResponsableLogic responsableLogic=new ResponsableLogic();
			responsableLogic.setConnexion(this.connexion);
			responsableLogic.getResponsableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalResponsable.equals("NONE")) {
				responsableLogic.getTodosResponsables(finalQueryGlobalResponsable,new Pagination());
				responsablesForeignKey=responsableLogic.getResponsables();
			}

			notacreditosoliReturnGeneral.setresponsablesForeignKey(responsablesForeignKey);


			List<EstadoNotaCredito> estadonotacreditosolisForeignKey=new ArrayList<EstadoNotaCredito>();
			EstadoNotaCreditoLogic estadonotacreditosoliLogic=new EstadoNotaCreditoLogic();
			estadonotacreditosoliLogic.setConnexion(this.connexion);
			estadonotacreditosoliLogic.getEstadoNotaCreditoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoNotaCreditoSoli.equals("NONE")) {
				estadonotacreditosoliLogic.getTodosEstadoNotaCreditos(finalQueryGlobalEstadoNotaCreditoSoli,new Pagination());
				estadonotacreditosolisForeignKey=estadonotacreditosoliLogic.getEstadoNotaCreditos();
			}

			notacreditosoliReturnGeneral.setestadonotacreditosolisForeignKey(estadonotacreditosolisForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			notacreditosoliReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			notacreditosoliReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			notacreditosoliReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<Transporte> transportesForeignKey=new ArrayList<Transporte>();
			TransporteLogic transporteLogic=new TransporteLogic();
			transporteLogic.setConnexion(this.connexion);
			transporteLogic.getTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransporte.equals("NONE")) {
				transporteLogic.getTodosTransportes(finalQueryGlobalTransporte,new Pagination());
				transportesForeignKey=transporteLogic.getTransportes();
			}

			notacreditosoliReturnGeneral.settransportesForeignKey(transportesForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			notacreditosoliReturnGeneral.settransportistasForeignKey(transportistasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return notacreditosoliReturnGeneral;
	}
	
	public NotaCreditoSoliParameterReturnGeneral cargarCombosLoteForeignKeyNotaCreditoSoli(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalUsuario,String finalQueryGlobalMoneda,String finalQueryGlobalEmpleado,String finalQueryGlobalFormato,String finalQueryGlobalTipoPrecio,String finalQueryGlobalCliente,String finalQueryGlobalFactura,String finalQueryGlobalTipoNotaCreditoSoli,String finalQueryGlobalResponsable,String finalQueryGlobalEstadoNotaCreditoSoli,String finalQueryGlobalCentroCosto,String finalQueryGlobalVendedor,String finalQueryGlobalTipoCambio,String finalQueryGlobalTransporte,String finalQueryGlobalTransportista) throws Exception {
		NotaCreditoSoliParameterReturnGeneral  notacreditosoliReturnGeneral =new NotaCreditoSoliParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			notacreditosoliReturnGeneral =new NotaCreditoSoliParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			notacreditosoliReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			notacreditosoliReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			notacreditosoliReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			notacreditosoliReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			notacreditosoliReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			notacreditosoliReturnGeneral.setmessForeignKey(messForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			notacreditosoliReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			notacreditosoliReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			notacreditosoliReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			notacreditosoliReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			notacreditosoliReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			notacreditosoliReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			notacreditosoliReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<TipoNotaCreditoSoli> tiponotacreditosolisForeignKey=new ArrayList<TipoNotaCreditoSoli>();
			TipoNotaCreditoSoliLogic tiponotacreditosoliLogic=new TipoNotaCreditoSoliLogic();
			tiponotacreditosoliLogic.setConnexion(this.connexion);
			tiponotacreditosoliLogic.getTipoNotaCreditoSoliDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoNotaCreditoSoli.equals("NONE")) {
				tiponotacreditosoliLogic.getTodosTipoNotaCreditoSolis(finalQueryGlobalTipoNotaCreditoSoli,new Pagination());
				tiponotacreditosolisForeignKey=tiponotacreditosoliLogic.getTipoNotaCreditoSolis();
			}

			notacreditosoliReturnGeneral.settiponotacreditosolisForeignKey(tiponotacreditosolisForeignKey);


			List<Responsable> responsablesForeignKey=new ArrayList<Responsable>();
			ResponsableLogic responsableLogic=new ResponsableLogic();
			responsableLogic.setConnexion(this.connexion);
			responsableLogic.getResponsableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalResponsable.equals("NONE")) {
				responsableLogic.getTodosResponsables(finalQueryGlobalResponsable,new Pagination());
				responsablesForeignKey=responsableLogic.getResponsables();
			}

			notacreditosoliReturnGeneral.setresponsablesForeignKey(responsablesForeignKey);


			List<EstadoNotaCredito> estadonotacreditosolisForeignKey=new ArrayList<EstadoNotaCredito>();
			EstadoNotaCreditoLogic estadonotacreditosoliLogic=new EstadoNotaCreditoLogic();
			estadonotacreditosoliLogic.setConnexion(this.connexion);
			estadonotacreditosoliLogic.getEstadoNotaCreditoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoNotaCreditoSoli.equals("NONE")) {
				estadonotacreditosoliLogic.getTodosEstadoNotaCreditos(finalQueryGlobalEstadoNotaCreditoSoli,new Pagination());
				estadonotacreditosolisForeignKey=estadonotacreditosoliLogic.getEstadoNotaCreditos();
			}

			notacreditosoliReturnGeneral.setestadonotacreditosolisForeignKey(estadonotacreditosolisForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			notacreditosoliReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			notacreditosoliReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			notacreditosoliReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);


			List<Transporte> transportesForeignKey=new ArrayList<Transporte>();
			TransporteLogic transporteLogic=new TransporteLogic();
			transporteLogic.setConnexion(this.connexion);
			transporteLogic.getTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransporte.equals("NONE")) {
				transporteLogic.getTodosTransportes(finalQueryGlobalTransporte,new Pagination());
				transportesForeignKey=transporteLogic.getTransportes();
			}

			notacreditosoliReturnGeneral.settransportesForeignKey(transportesForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			notacreditosoliReturnGeneral.settransportistasForeignKey(transportistasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return notacreditosoliReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyNotaCreditoSoliWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetaNotaCreditoSoliLogic detanotacreditosoliLogic=new DetaNotaCreditoSoliLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyNotaCreditoSoliWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetaNotaCreditoSoli.class));
											
			

			detanotacreditosoliLogic.setConnexion(this.getConnexion());
			detanotacreditosoliLogic.setDatosCliente(this.datosCliente);
			detanotacreditosoliLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(NotaCreditoSoli notacreditosoli:this.notacreditosolis) {
				

				classes=new ArrayList<Classe>();
				classes=DetaNotaCreditoSoliConstantesFunciones.getClassesForeignKeysOfDetaNotaCreditoSoli(new ArrayList<Classe>(),DeepLoadType.NONE);

				detanotacreditosoliLogic.setDetaNotaCreditoSolis(notacreditosoli.detanotacreditosolis);
				detanotacreditosoliLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(NotaCreditoSoli notacreditosoli,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			NotaCreditoSoliLogicAdditional.updateNotaCreditoSoliToGet(notacreditosoli,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		notacreditosoli.setEmpresa(notacreditosoliDataAccess.getEmpresa(connexion,notacreditosoli));
		notacreditosoli.setSucursal(notacreditosoliDataAccess.getSucursal(connexion,notacreditosoli));
		notacreditosoli.setEjercicio(notacreditosoliDataAccess.getEjercicio(connexion,notacreditosoli));
		notacreditosoli.setPeriodo(notacreditosoliDataAccess.getPeriodo(connexion,notacreditosoli));
		notacreditosoli.setAnio(notacreditosoliDataAccess.getAnio(connexion,notacreditosoli));
		notacreditosoli.setMes(notacreditosoliDataAccess.getMes(connexion,notacreditosoli));
		notacreditosoli.setUsuario(notacreditosoliDataAccess.getUsuario(connexion,notacreditosoli));
		notacreditosoli.setMoneda(notacreditosoliDataAccess.getMoneda(connexion,notacreditosoli));
		notacreditosoli.setEmpleado(notacreditosoliDataAccess.getEmpleado(connexion,notacreditosoli));
		notacreditosoli.setFormato(notacreditosoliDataAccess.getFormato(connexion,notacreditosoli));
		notacreditosoli.setTipoPrecio(notacreditosoliDataAccess.getTipoPrecio(connexion,notacreditosoli));
		notacreditosoli.setCliente(notacreditosoliDataAccess.getCliente(connexion,notacreditosoli));
		notacreditosoli.setFactura(notacreditosoliDataAccess.getFactura(connexion,notacreditosoli));
		notacreditosoli.setTipoNotaCreditoSoli(notacreditosoliDataAccess.getTipoNotaCreditoSoli(connexion,notacreditosoli));
		notacreditosoli.setResponsable(notacreditosoliDataAccess.getResponsable(connexion,notacreditosoli));
		notacreditosoli.setEstadoNotaCreditoSoli(notacreditosoliDataAccess.getEstadoNotaCreditoSoli(connexion,notacreditosoli));
		notacreditosoli.setCentroCosto(notacreditosoliDataAccess.getCentroCosto(connexion,notacreditosoli));
		notacreditosoli.setVendedor(notacreditosoliDataAccess.getVendedor(connexion,notacreditosoli));
		notacreditosoli.setTipoCambio(notacreditosoliDataAccess.getTipoCambio(connexion,notacreditosoli));
		notacreditosoli.setTransporte(notacreditosoliDataAccess.getTransporte(connexion,notacreditosoli));
		notacreditosoli.setTransportista(notacreditosoliDataAccess.getTransportista(connexion,notacreditosoli));
		notacreditosoli.setDetaNotaCreditoSolis(notacreditosoliDataAccess.getDetaNotaCreditoSolis(connexion,notacreditosoli));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				notacreditosoli.setEmpresa(notacreditosoliDataAccess.getEmpresa(connexion,notacreditosoli));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				notacreditosoli.setSucursal(notacreditosoliDataAccess.getSucursal(connexion,notacreditosoli));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				notacreditosoli.setEjercicio(notacreditosoliDataAccess.getEjercicio(connexion,notacreditosoli));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				notacreditosoli.setPeriodo(notacreditosoliDataAccess.getPeriodo(connexion,notacreditosoli));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				notacreditosoli.setAnio(notacreditosoliDataAccess.getAnio(connexion,notacreditosoli));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				notacreditosoli.setMes(notacreditosoliDataAccess.getMes(connexion,notacreditosoli));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				notacreditosoli.setUsuario(notacreditosoliDataAccess.getUsuario(connexion,notacreditosoli));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				notacreditosoli.setMoneda(notacreditosoliDataAccess.getMoneda(connexion,notacreditosoli));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				notacreditosoli.setEmpleado(notacreditosoliDataAccess.getEmpleado(connexion,notacreditosoli));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				notacreditosoli.setFormato(notacreditosoliDataAccess.getFormato(connexion,notacreditosoli));
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				notacreditosoli.setTipoPrecio(notacreditosoliDataAccess.getTipoPrecio(connexion,notacreditosoli));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				notacreditosoli.setCliente(notacreditosoliDataAccess.getCliente(connexion,notacreditosoli));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				notacreditosoli.setFactura(notacreditosoliDataAccess.getFactura(connexion,notacreditosoli));
				continue;
			}

			if(clas.clas.equals(TipoNotaCreditoSoli.class)) {
				notacreditosoli.setTipoNotaCreditoSoli(notacreditosoliDataAccess.getTipoNotaCreditoSoli(connexion,notacreditosoli));
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				notacreditosoli.setResponsable(notacreditosoliDataAccess.getResponsable(connexion,notacreditosoli));
				continue;
			}

			if(clas.clas.equals(EstadoNotaCredito.class)) {
				notacreditosoli.setEstadoNotaCreditoSoli(notacreditosoliDataAccess.getEstadoNotaCreditoSoli(connexion,notacreditosoli));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				notacreditosoli.setCentroCosto(notacreditosoliDataAccess.getCentroCosto(connexion,notacreditosoli));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				notacreditosoli.setVendedor(notacreditosoliDataAccess.getVendedor(connexion,notacreditosoli));
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				notacreditosoli.setTipoCambio(notacreditosoliDataAccess.getTipoCambio(connexion,notacreditosoli));
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				notacreditosoli.setTransporte(notacreditosoliDataAccess.getTransporte(connexion,notacreditosoli));
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				notacreditosoli.setTransportista(notacreditosoliDataAccess.getTransportista(connexion,notacreditosoli));
				continue;
			}

			if(clas.clas.equals(DetaNotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				notacreditosoli.setDetaNotaCreditoSolis(notacreditosoliDataAccess.getDetaNotaCreditoSolis(connexion,notacreditosoli));

				if(this.isConDeep) {
					DetaNotaCreditoSoliLogic detanotacreditosoliLogic= new DetaNotaCreditoSoliLogic(this.connexion);
					detanotacreditosoliLogic.setDetaNotaCreditoSolis(notacreditosoli.getDetaNotaCreditoSolis());
					ArrayList<Classe> classesLocal=DetaNotaCreditoSoliConstantesFunciones.getClassesForeignKeysOfDetaNotaCreditoSoli(new ArrayList<Classe>(),DeepLoadType.NONE);
					detanotacreditosoliLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(detanotacreditosoliLogic.getDetaNotaCreditoSolis());
					notacreditosoli.setDetaNotaCreditoSolis(detanotacreditosoliLogic.getDetaNotaCreditoSolis());
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
			notacreditosoli.setEmpresa(notacreditosoliDataAccess.getEmpresa(connexion,notacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setSucursal(notacreditosoliDataAccess.getSucursal(connexion,notacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setEjercicio(notacreditosoliDataAccess.getEjercicio(connexion,notacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setPeriodo(notacreditosoliDataAccess.getPeriodo(connexion,notacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setAnio(notacreditosoliDataAccess.getAnio(connexion,notacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setMes(notacreditosoliDataAccess.getMes(connexion,notacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setUsuario(notacreditosoliDataAccess.getUsuario(connexion,notacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setMoneda(notacreditosoliDataAccess.getMoneda(connexion,notacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setEmpleado(notacreditosoliDataAccess.getEmpleado(connexion,notacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setFormato(notacreditosoliDataAccess.getFormato(connexion,notacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setTipoPrecio(notacreditosoliDataAccess.getTipoPrecio(connexion,notacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setCliente(notacreditosoliDataAccess.getCliente(connexion,notacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setFactura(notacreditosoliDataAccess.getFactura(connexion,notacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoNotaCreditoSoli.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setTipoNotaCreditoSoli(notacreditosoliDataAccess.getTipoNotaCreditoSoli(connexion,notacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Responsable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setResponsable(notacreditosoliDataAccess.getResponsable(connexion,notacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoNotaCredito.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setEstadoNotaCreditoSoli(notacreditosoliDataAccess.getEstadoNotaCreditoSoli(connexion,notacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setCentroCosto(notacreditosoliDataAccess.getCentroCosto(connexion,notacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setVendedor(notacreditosoliDataAccess.getVendedor(connexion,notacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setTipoCambio(notacreditosoliDataAccess.getTipoCambio(connexion,notacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setTransporte(notacreditosoliDataAccess.getTransporte(connexion,notacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setTransportista(notacreditosoliDataAccess.getTransportista(connexion,notacreditosoli));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetaNotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetaNotaCreditoSoli.class));
			notacreditosoli.setDetaNotaCreditoSolis(notacreditosoliDataAccess.getDetaNotaCreditoSolis(connexion,notacreditosoli));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		notacreditosoli.setEmpresa(notacreditosoliDataAccess.getEmpresa(connexion,notacreditosoli));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(notacreditosoli.getEmpresa(),isDeep,deepLoadType,clases);
				
		notacreditosoli.setSucursal(notacreditosoliDataAccess.getSucursal(connexion,notacreditosoli));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(notacreditosoli.getSucursal(),isDeep,deepLoadType,clases);
				
		notacreditosoli.setEjercicio(notacreditosoliDataAccess.getEjercicio(connexion,notacreditosoli));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(notacreditosoli.getEjercicio(),isDeep,deepLoadType,clases);
				
		notacreditosoli.setPeriodo(notacreditosoliDataAccess.getPeriodo(connexion,notacreditosoli));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(notacreditosoli.getPeriodo(),isDeep,deepLoadType,clases);
				
		notacreditosoli.setAnio(notacreditosoliDataAccess.getAnio(connexion,notacreditosoli));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(notacreditosoli.getAnio(),isDeep,deepLoadType,clases);
				
		notacreditosoli.setMes(notacreditosoliDataAccess.getMes(connexion,notacreditosoli));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(notacreditosoli.getMes(),isDeep,deepLoadType,clases);
				
		notacreditosoli.setUsuario(notacreditosoliDataAccess.getUsuario(connexion,notacreditosoli));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(notacreditosoli.getUsuario(),isDeep,deepLoadType,clases);
				
		notacreditosoli.setMoneda(notacreditosoliDataAccess.getMoneda(connexion,notacreditosoli));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(notacreditosoli.getMoneda(),isDeep,deepLoadType,clases);
				
		notacreditosoli.setEmpleado(notacreditosoliDataAccess.getEmpleado(connexion,notacreditosoli));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(notacreditosoli.getEmpleado(),isDeep,deepLoadType,clases);
				
		notacreditosoli.setFormato(notacreditosoliDataAccess.getFormato(connexion,notacreditosoli));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(notacreditosoli.getFormato(),isDeep,deepLoadType,clases);
				
		notacreditosoli.setTipoPrecio(notacreditosoliDataAccess.getTipoPrecio(connexion,notacreditosoli));
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(notacreditosoli.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		notacreditosoli.setCliente(notacreditosoliDataAccess.getCliente(connexion,notacreditosoli));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(notacreditosoli.getCliente(),isDeep,deepLoadType,clases);
				
		notacreditosoli.setFactura(notacreditosoliDataAccess.getFactura(connexion,notacreditosoli));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(notacreditosoli.getFactura(),isDeep,deepLoadType,clases);
				
		notacreditosoli.setTipoNotaCreditoSoli(notacreditosoliDataAccess.getTipoNotaCreditoSoli(connexion,notacreditosoli));
		TipoNotaCreditoSoliLogic tiponotacreditosoliLogic= new TipoNotaCreditoSoliLogic(connexion);
		tiponotacreditosoliLogic.deepLoad(notacreditosoli.getTipoNotaCreditoSoli(),isDeep,deepLoadType,clases);
				
		notacreditosoli.setResponsable(notacreditosoliDataAccess.getResponsable(connexion,notacreditosoli));
		ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
		responsableLogic.deepLoad(notacreditosoli.getResponsable(),isDeep,deepLoadType,clases);
				
		notacreditosoli.setEstadoNotaCreditoSoli(notacreditosoliDataAccess.getEstadoNotaCreditoSoli(connexion,notacreditosoli));
		EstadoNotaCreditoLogic estadonotacreditosoliLogic= new EstadoNotaCreditoLogic(connexion);
		estadonotacreditosoliLogic.deepLoad(notacreditosoli.getEstadoNotaCreditoSoli(),isDeep,deepLoadType,clases);
				
		notacreditosoli.setCentroCosto(notacreditosoliDataAccess.getCentroCosto(connexion,notacreditosoli));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(notacreditosoli.getCentroCosto(),isDeep,deepLoadType,clases);
				
		notacreditosoli.setVendedor(notacreditosoliDataAccess.getVendedor(connexion,notacreditosoli));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(notacreditosoli.getVendedor(),isDeep,deepLoadType,clases);
				
		notacreditosoli.setTipoCambio(notacreditosoliDataAccess.getTipoCambio(connexion,notacreditosoli));
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(notacreditosoli.getTipoCambio(),isDeep,deepLoadType,clases);
				
		notacreditosoli.setTransporte(notacreditosoliDataAccess.getTransporte(connexion,notacreditosoli));
		TransporteLogic transporteLogic= new TransporteLogic(connexion);
		transporteLogic.deepLoad(notacreditosoli.getTransporte(),isDeep,deepLoadType,clases);
				
		notacreditosoli.setTransportista(notacreditosoliDataAccess.getTransportista(connexion,notacreditosoli));
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(notacreditosoli.getTransportista(),isDeep,deepLoadType,clases);
				

		notacreditosoli.setDetaNotaCreditoSolis(notacreditosoliDataAccess.getDetaNotaCreditoSolis(connexion,notacreditosoli));

		for(DetaNotaCreditoSoli detanotacreditosoli:notacreditosoli.getDetaNotaCreditoSolis()) {
			DetaNotaCreditoSoliLogic detanotacreditosoliLogic= new DetaNotaCreditoSoliLogic(connexion);
			detanotacreditosoliLogic.deepLoad(detanotacreditosoli,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				notacreditosoli.setEmpresa(notacreditosoliDataAccess.getEmpresa(connexion,notacreditosoli));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(notacreditosoli.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				notacreditosoli.setSucursal(notacreditosoliDataAccess.getSucursal(connexion,notacreditosoli));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(notacreditosoli.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				notacreditosoli.setEjercicio(notacreditosoliDataAccess.getEjercicio(connexion,notacreditosoli));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(notacreditosoli.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				notacreditosoli.setPeriodo(notacreditosoliDataAccess.getPeriodo(connexion,notacreditosoli));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(notacreditosoli.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				notacreditosoli.setAnio(notacreditosoliDataAccess.getAnio(connexion,notacreditosoli));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(notacreditosoli.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				notacreditosoli.setMes(notacreditosoliDataAccess.getMes(connexion,notacreditosoli));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(notacreditosoli.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				notacreditosoli.setUsuario(notacreditosoliDataAccess.getUsuario(connexion,notacreditosoli));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(notacreditosoli.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				notacreditosoli.setMoneda(notacreditosoliDataAccess.getMoneda(connexion,notacreditosoli));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(notacreditosoli.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				notacreditosoli.setEmpleado(notacreditosoliDataAccess.getEmpleado(connexion,notacreditosoli));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(notacreditosoli.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				notacreditosoli.setFormato(notacreditosoliDataAccess.getFormato(connexion,notacreditosoli));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(notacreditosoli.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				notacreditosoli.setTipoPrecio(notacreditosoliDataAccess.getTipoPrecio(connexion,notacreditosoli));
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepLoad(notacreditosoli.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				notacreditosoli.setCliente(notacreditosoliDataAccess.getCliente(connexion,notacreditosoli));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(notacreditosoli.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				notacreditosoli.setFactura(notacreditosoliDataAccess.getFactura(connexion,notacreditosoli));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(notacreditosoli.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoNotaCreditoSoli.class)) {
				notacreditosoli.setTipoNotaCreditoSoli(notacreditosoliDataAccess.getTipoNotaCreditoSoli(connexion,notacreditosoli));
				TipoNotaCreditoSoliLogic tiponotacreditosoliLogic= new TipoNotaCreditoSoliLogic(connexion);
				tiponotacreditosoliLogic.deepLoad(notacreditosoli.getTipoNotaCreditoSoli(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				notacreditosoli.setResponsable(notacreditosoliDataAccess.getResponsable(connexion,notacreditosoli));
				ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
				responsableLogic.deepLoad(notacreditosoli.getResponsable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoNotaCredito.class)) {
				notacreditosoli.setEstadoNotaCreditoSoli(notacreditosoliDataAccess.getEstadoNotaCreditoSoli(connexion,notacreditosoli));
				EstadoNotaCreditoLogic estadonotacreditoLogic= new EstadoNotaCreditoLogic(connexion);
				estadonotacreditoLogic.deepLoad(notacreditosoli.getEstadoNotaCreditoSoli(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				notacreditosoli.setCentroCosto(notacreditosoliDataAccess.getCentroCosto(connexion,notacreditosoli));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(notacreditosoli.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				notacreditosoli.setVendedor(notacreditosoliDataAccess.getVendedor(connexion,notacreditosoli));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(notacreditosoli.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				notacreditosoli.setTipoCambio(notacreditosoliDataAccess.getTipoCambio(connexion,notacreditosoli));
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepLoad(notacreditosoli.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				notacreditosoli.setTransporte(notacreditosoliDataAccess.getTransporte(connexion,notacreditosoli));
				TransporteLogic transporteLogic= new TransporteLogic(connexion);
				transporteLogic.deepLoad(notacreditosoli.getTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				notacreditosoli.setTransportista(notacreditosoliDataAccess.getTransportista(connexion,notacreditosoli));
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepLoad(notacreditosoli.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetaNotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				notacreditosoli.setDetaNotaCreditoSolis(notacreditosoliDataAccess.getDetaNotaCreditoSolis(connexion,notacreditosoli));

				for(DetaNotaCreditoSoli detanotacreditosoli:notacreditosoli.getDetaNotaCreditoSolis()) {
					DetaNotaCreditoSoliLogic detanotacreditosoliLogic= new DetaNotaCreditoSoliLogic(connexion);
					detanotacreditosoliLogic.deepLoad(detanotacreditosoli,isDeep,deepLoadType,clases);
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
			notacreditosoli.setEmpresa(notacreditosoliDataAccess.getEmpresa(connexion,notacreditosoli));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(notacreditosoli.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setSucursal(notacreditosoliDataAccess.getSucursal(connexion,notacreditosoli));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(notacreditosoli.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setEjercicio(notacreditosoliDataAccess.getEjercicio(connexion,notacreditosoli));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(notacreditosoli.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setPeriodo(notacreditosoliDataAccess.getPeriodo(connexion,notacreditosoli));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(notacreditosoli.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setAnio(notacreditosoliDataAccess.getAnio(connexion,notacreditosoli));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(notacreditosoli.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setMes(notacreditosoliDataAccess.getMes(connexion,notacreditosoli));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(notacreditosoli.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setUsuario(notacreditosoliDataAccess.getUsuario(connexion,notacreditosoli));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(notacreditosoli.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setMoneda(notacreditosoliDataAccess.getMoneda(connexion,notacreditosoli));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(notacreditosoli.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setEmpleado(notacreditosoliDataAccess.getEmpleado(connexion,notacreditosoli));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(notacreditosoli.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setFormato(notacreditosoliDataAccess.getFormato(connexion,notacreditosoli));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(notacreditosoli.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setTipoPrecio(notacreditosoliDataAccess.getTipoPrecio(connexion,notacreditosoli));
			TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
			tipoprecioLogic.deepLoad(notacreditosoli.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setCliente(notacreditosoliDataAccess.getCliente(connexion,notacreditosoli));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(notacreditosoli.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setFactura(notacreditosoliDataAccess.getFactura(connexion,notacreditosoli));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(notacreditosoli.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoNotaCreditoSoli.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setTipoNotaCreditoSoli(notacreditosoliDataAccess.getTipoNotaCreditoSoli(connexion,notacreditosoli));
			TipoNotaCreditoSoliLogic tiponotacreditosoliLogic= new TipoNotaCreditoSoliLogic(connexion);
			tiponotacreditosoliLogic.deepLoad(notacreditosoli.getTipoNotaCreditoSoli(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Responsable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setResponsable(notacreditosoliDataAccess.getResponsable(connexion,notacreditosoli));
			ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
			responsableLogic.deepLoad(notacreditosoli.getResponsable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoNotaCredito.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setEstadoNotaCreditoSoli(notacreditosoliDataAccess.getEstadoNotaCreditoSoli(connexion,notacreditosoli));
			EstadoNotaCreditoLogic estadonotacreditoLogic= new EstadoNotaCreditoLogic(connexion);
			estadonotacreditoLogic.deepLoad(notacreditosoli.getEstadoNotaCreditoSoli(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setCentroCosto(notacreditosoliDataAccess.getCentroCosto(connexion,notacreditosoli));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(notacreditosoli.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setVendedor(notacreditosoliDataAccess.getVendedor(connexion,notacreditosoli));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(notacreditosoli.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setTipoCambio(notacreditosoliDataAccess.getTipoCambio(connexion,notacreditosoli));
			TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
			tipocambioLogic.deepLoad(notacreditosoli.getTipoCambio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setTransporte(notacreditosoliDataAccess.getTransporte(connexion,notacreditosoli));
			TransporteLogic transporteLogic= new TransporteLogic(connexion);
			transporteLogic.deepLoad(notacreditosoli.getTransporte(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			notacreditosoli.setTransportista(notacreditosoliDataAccess.getTransportista(connexion,notacreditosoli));
			TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
			transportistaLogic.deepLoad(notacreditosoli.getTransportista(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetaNotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetaNotaCreditoSoli.class));
			notacreditosoli.setDetaNotaCreditoSolis(notacreditosoliDataAccess.getDetaNotaCreditoSolis(connexion,notacreditosoli));

			for(DetaNotaCreditoSoli detanotacreditosoli:notacreditosoli.getDetaNotaCreditoSolis()) {
				DetaNotaCreditoSoliLogic detanotacreditosoliLogic= new DetaNotaCreditoSoliLogic(connexion);
				detanotacreditosoliLogic.deepLoad(detanotacreditosoli,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(NotaCreditoSoli notacreditosoli,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			NotaCreditoSoliLogicAdditional.updateNotaCreditoSoliToSave(notacreditosoli,this.arrDatoGeneral);
			
NotaCreditoSoliDataAccess.save(notacreditosoli, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(notacreditosoli.getEmpresa(),connexion);

		SucursalDataAccess.save(notacreditosoli.getSucursal(),connexion);

		EjercicioDataAccess.save(notacreditosoli.getEjercicio(),connexion);

		PeriodoDataAccess.save(notacreditosoli.getPeriodo(),connexion);

		AnioDataAccess.save(notacreditosoli.getAnio(),connexion);

		MesDataAccess.save(notacreditosoli.getMes(),connexion);

		UsuarioDataAccess.save(notacreditosoli.getUsuario(),connexion);

		MonedaDataAccess.save(notacreditosoli.getMoneda(),connexion);

		EmpleadoDataAccess.save(notacreditosoli.getEmpleado(),connexion);

		FormatoDataAccess.save(notacreditosoli.getFormato(),connexion);

		TipoPrecioDataAccess.save(notacreditosoli.getTipoPrecio(),connexion);

		ClienteDataAccess.save(notacreditosoli.getCliente(),connexion);

		FacturaDataAccess.save(notacreditosoli.getFactura(),connexion);

		TipoNotaCreditoSoliDataAccess.save(notacreditosoli.getTipoNotaCreditoSoli(),connexion);

		ResponsableDataAccess.save(notacreditosoli.getResponsable(),connexion);

		EstadoNotaCreditoDataAccess.save(notacreditosoli.getEstadoNotaCreditoSoli(),connexion);

		CentroCostoDataAccess.save(notacreditosoli.getCentroCosto(),connexion);

		VendedorDataAccess.save(notacreditosoli.getVendedor(),connexion);

		TipoCambioDataAccess.save(notacreditosoli.getTipoCambio(),connexion);

		TransporteDataAccess.save(notacreditosoli.getTransporte(),connexion);

		TransportistaDataAccess.save(notacreditosoli.getTransportista(),connexion);

		for(DetaNotaCreditoSoli detanotacreditosoli:notacreditosoli.getDetaNotaCreditoSolis()) {
			detanotacreditosoli.setid_nota_credito_soli(notacreditosoli.getId());
			DetaNotaCreditoSoliDataAccess.save(detanotacreditosoli,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(notacreditosoli.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(notacreditosoli.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(notacreditosoli.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(notacreditosoli.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(notacreditosoli.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(notacreditosoli.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(notacreditosoli.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(notacreditosoli.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(notacreditosoli.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(notacreditosoli.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(notacreditosoli.getTipoPrecio(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(notacreditosoli.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(notacreditosoli.getFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoNotaCreditoSoli.class)) {
				TipoNotaCreditoSoliDataAccess.save(notacreditosoli.getTipoNotaCreditoSoli(),connexion);
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				ResponsableDataAccess.save(notacreditosoli.getResponsable(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoNotaCredito.class)) {
				EstadoNotaCreditoDataAccess.save(notacreditosoli.getEstadoNotaCreditoSoli(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(notacreditosoli.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(notacreditosoli.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(notacreditosoli.getTipoCambio(),connexion);
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				TransporteDataAccess.save(notacreditosoli.getTransporte(),connexion);
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(notacreditosoli.getTransportista(),connexion);
				continue;
			}


			if(clas.clas.equals(DetaNotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetaNotaCreditoSoli detanotacreditosoli:notacreditosoli.getDetaNotaCreditoSolis()) {
					detanotacreditosoli.setid_nota_credito_soli(notacreditosoli.getId());
					DetaNotaCreditoSoliDataAccess.save(detanotacreditosoli,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(notacreditosoli.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(notacreditosoli.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(notacreditosoli.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(notacreditosoli.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(notacreditosoli.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(notacreditosoli.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(notacreditosoli.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(notacreditosoli.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(notacreditosoli.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(notacreditosoli.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(notacreditosoli.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(notacreditosoli.getMes(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(notacreditosoli.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(notacreditosoli.getUsuario(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(notacreditosoli.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(notacreditosoli.getMoneda(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(notacreditosoli.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(notacreditosoli.getEmpleado(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(notacreditosoli.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(notacreditosoli.getFormato(),isDeep,deepLoadType,clases);
				

		TipoPrecioDataAccess.save(notacreditosoli.getTipoPrecio(),connexion);
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(notacreditosoli.getTipoPrecio(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(notacreditosoli.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(notacreditosoli.getCliente(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(notacreditosoli.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(notacreditosoli.getFactura(),isDeep,deepLoadType,clases);
				

		TipoNotaCreditoSoliDataAccess.save(notacreditosoli.getTipoNotaCreditoSoli(),connexion);
		TipoNotaCreditoSoliLogic tiponotacreditosoliLogic= new TipoNotaCreditoSoliLogic(connexion);
		tiponotacreditosoliLogic.deepLoad(notacreditosoli.getTipoNotaCreditoSoli(),isDeep,deepLoadType,clases);
				

		ResponsableDataAccess.save(notacreditosoli.getResponsable(),connexion);
		ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
		responsableLogic.deepLoad(notacreditosoli.getResponsable(),isDeep,deepLoadType,clases);
				

		EstadoNotaCreditoDataAccess.save(notacreditosoli.getEstadoNotaCreditoSoli(),connexion);
		EstadoNotaCreditoLogic estadonotacreditosoliLogic= new EstadoNotaCreditoLogic(connexion);
		estadonotacreditosoliLogic.deepLoad(notacreditosoli.getEstadoNotaCreditoSoli(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(notacreditosoli.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(notacreditosoli.getCentroCosto(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(notacreditosoli.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(notacreditosoli.getVendedor(),isDeep,deepLoadType,clases);
				

		TipoCambioDataAccess.save(notacreditosoli.getTipoCambio(),connexion);
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(notacreditosoli.getTipoCambio(),isDeep,deepLoadType,clases);
				

		TransporteDataAccess.save(notacreditosoli.getTransporte(),connexion);
		TransporteLogic transporteLogic= new TransporteLogic(connexion);
		transporteLogic.deepLoad(notacreditosoli.getTransporte(),isDeep,deepLoadType,clases);
				

		TransportistaDataAccess.save(notacreditosoli.getTransportista(),connexion);
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(notacreditosoli.getTransportista(),isDeep,deepLoadType,clases);
				

		for(DetaNotaCreditoSoli detanotacreditosoli:notacreditosoli.getDetaNotaCreditoSolis()) {
			DetaNotaCreditoSoliLogic detanotacreditosoliLogic= new DetaNotaCreditoSoliLogic(connexion);
			detanotacreditosoli.setid_nota_credito_soli(notacreditosoli.getId());
			DetaNotaCreditoSoliDataAccess.save(detanotacreditosoli,connexion);
			detanotacreditosoliLogic.deepSave(detanotacreditosoli,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(notacreditosoli.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(notacreditosoli.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(notacreditosoli.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(notacreditosoli.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(notacreditosoli.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(notacreditosoli.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(notacreditosoli.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(notacreditosoli.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(notacreditosoli.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(notacreditosoli.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(notacreditosoli.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(notacreditosoli.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(notacreditosoli.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(notacreditosoli.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(notacreditosoli.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(notacreditosoli.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(notacreditosoli.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(notacreditosoli.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(notacreditosoli.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(notacreditosoli.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(notacreditosoli.getTipoPrecio(),connexion);
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepSave(notacreditosoli.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(notacreditosoli.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(notacreditosoli.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(notacreditosoli.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(notacreditosoli.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoNotaCreditoSoli.class)) {
				TipoNotaCreditoSoliDataAccess.save(notacreditosoli.getTipoNotaCreditoSoli(),connexion);
				TipoNotaCreditoSoliLogic tiponotacreditosoliLogic= new TipoNotaCreditoSoliLogic(connexion);
				tiponotacreditosoliLogic.deepSave(notacreditosoli.getTipoNotaCreditoSoli(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Responsable.class)) {
				ResponsableDataAccess.save(notacreditosoli.getResponsable(),connexion);
				ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
				responsableLogic.deepSave(notacreditosoli.getResponsable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoNotaCredito.class)) {
				EstadoNotaCreditoDataAccess.save(notacreditosoli.getEstadoNotaCreditoSoli(),connexion);
				EstadoNotaCreditoLogic estadonotacreditoLogic= new EstadoNotaCreditoLogic(connexion);
				estadonotacreditoLogic.deepSave(notacreditosoli.getEstadoNotaCreditoSoli(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(notacreditosoli.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(notacreditosoli.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(notacreditosoli.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(notacreditosoli.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(notacreditosoli.getTipoCambio(),connexion);
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepSave(notacreditosoli.getTipoCambio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				TransporteDataAccess.save(notacreditosoli.getTransporte(),connexion);
				TransporteLogic transporteLogic= new TransporteLogic(connexion);
				transporteLogic.deepSave(notacreditosoli.getTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(notacreditosoli.getTransportista(),connexion);
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepSave(notacreditosoli.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetaNotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetaNotaCreditoSoli detanotacreditosoli:notacreditosoli.getDetaNotaCreditoSolis()) {
					DetaNotaCreditoSoliLogic detanotacreditosoliLogic= new DetaNotaCreditoSoliLogic(connexion);
					detanotacreditosoli.setid_nota_credito_soli(notacreditosoli.getId());
					DetaNotaCreditoSoliDataAccess.save(detanotacreditosoli,connexion);
					detanotacreditosoliLogic.deepSave(detanotacreditosoli,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(NotaCreditoSoli.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(notacreditosoli,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(notacreditosoli);
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
			this.deepLoad(this.notacreditosoli,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosoli);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(NotaCreditoSoli.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(notacreditosolis!=null) {
				for(NotaCreditoSoli notacreditosoli:notacreditosolis) {
					this.deepLoad(notacreditosoli,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(notacreditosolis);
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
			if(notacreditosolis!=null) {
				for(NotaCreditoSoli notacreditosoli:notacreditosolis) {
					this.deepLoad(notacreditosoli,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(notacreditosolis);
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
			this.getNewConnexionToDeep(NotaCreditoSoli.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(notacreditosoli,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(NotaCreditoSoli.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(notacreditosolis!=null) {
				for(NotaCreditoSoli notacreditosoli:notacreditosolis) {
					this.deepSave(notacreditosoli,isDeep,deepLoadType,clases);
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
			if(notacreditosolis!=null) {
				for(NotaCreditoSoli notacreditosoli:notacreditosolis) {
					this.deepSave(notacreditosoli,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getNotaCreditoSolisFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,NotaCreditoSoliConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoSolisFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,NotaCreditoSoliConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoSolisFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,NotaCreditoSoliConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoSolisFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,NotaCreditoSoliConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoSolisFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,NotaCreditoSoliConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoSolisFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,NotaCreditoSoliConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoSolisFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,NotaCreditoSoliConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoSolisFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,NotaCreditoSoliConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoSolisFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,NotaCreditoSoliConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoSolisFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,NotaCreditoSoliConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoSolisFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,NotaCreditoSoliConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoSolisFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,NotaCreditoSoliConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoSolisFK_IdEstadoNotaCreditoSoliWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_nota_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoNotaCreditoSoli= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoNotaCreditoSoli.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_nota_credito,NotaCreditoSoliConstantesFunciones.IDESTADONOTACREDITOSOLI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoNotaCreditoSoli);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoNotaCreditoSoli","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoSolisFK_IdEstadoNotaCreditoSoli(String sFinalQuery,Pagination pagination,Long id_estado_nota_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoNotaCreditoSoli= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoNotaCreditoSoli.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_nota_credito,NotaCreditoSoliConstantesFunciones.IDESTADONOTACREDITOSOLI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoNotaCreditoSoli);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoNotaCreditoSoli","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoSolisFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,NotaCreditoSoliConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoSolisFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,NotaCreditoSoliConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoSolisFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,NotaCreditoSoliConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoSolisFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,NotaCreditoSoliConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoSolisFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,NotaCreditoSoliConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoSolisFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,NotaCreditoSoliConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoSolisFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,NotaCreditoSoliConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoSolisFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,NotaCreditoSoliConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoSolisFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,NotaCreditoSoliConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoSolisFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,NotaCreditoSoliConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoSolisFK_IdResponsableWithConnection(String sFinalQuery,Pagination pagination,Long id_responsable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidResponsable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidResponsable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_responsable,NotaCreditoSoliConstantesFunciones.IDRESPONSABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidResponsable);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdResponsable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoSolisFK_IdResponsable(String sFinalQuery,Pagination pagination,Long id_responsable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidResponsable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidResponsable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_responsable,NotaCreditoSoliConstantesFunciones.IDRESPONSABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidResponsable);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdResponsable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoSolisFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,NotaCreditoSoliConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoSolisFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,NotaCreditoSoliConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoSolisFK_IdTipoCambioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,NotaCreditoSoliConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoSolisFK_IdTipoCambio(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,NotaCreditoSoliConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoSolisFK_IdTipoNotaCreditoSoliWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_nota_credito_soli)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoNotaCreditoSoli= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoNotaCreditoSoli.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_nota_credito_soli,NotaCreditoSoliConstantesFunciones.IDTIPONOTACREDITOSOLI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoNotaCreditoSoli);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoNotaCreditoSoli","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoSolisFK_IdTipoNotaCreditoSoli(String sFinalQuery,Pagination pagination,Long id_tipo_nota_credito_soli)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoNotaCreditoSoli= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoNotaCreditoSoli.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_nota_credito_soli,NotaCreditoSoliConstantesFunciones.IDTIPONOTACREDITOSOLI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoNotaCreditoSoli);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoNotaCreditoSoli","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoSolisFK_IdTipoPrecioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,NotaCreditoSoliConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoSolisFK_IdTipoPrecio(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,NotaCreditoSoliConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoSolisFK_IdTransporteWithConnection(String sFinalQuery,Pagination pagination,Long id_transporte)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transporte,NotaCreditoSoliConstantesFunciones.IDTRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransporte);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoSolisFK_IdTransporte(String sFinalQuery,Pagination pagination,Long id_transporte)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transporte,NotaCreditoSoliConstantesFunciones.IDTRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransporte);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoSolisFK_IdTransportistaWithConnection(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,NotaCreditoSoliConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoSolisFK_IdTransportista(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,NotaCreditoSoliConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoSolisFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,NotaCreditoSoliConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoSolisFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,NotaCreditoSoliConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getNotaCreditoSolisFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,NotaCreditoSoliConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNotaCreditoSolisFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,NotaCreditoSoliConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			NotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(this.notacreditosolis);
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
			if(NotaCreditoSoliConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,NotaCreditoSoliDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,NotaCreditoSoli notacreditosoli,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(NotaCreditoSoliConstantesFunciones.ISCONAUDITORIA) {
				if(notacreditosoli.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NotaCreditoSoliDataAccess.TABLENAME, notacreditosoli.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NotaCreditoSoliConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NotaCreditoSoliLogic.registrarAuditoriaDetallesNotaCreditoSoli(connexion,notacreditosoli,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(notacreditosoli.getIsDeleted()) {
					/*if(!notacreditosoli.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,NotaCreditoSoliDataAccess.TABLENAME, notacreditosoli.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////NotaCreditoSoliLogic.registrarAuditoriaDetallesNotaCreditoSoli(connexion,notacreditosoli,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NotaCreditoSoliDataAccess.TABLENAME, notacreditosoli.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(notacreditosoli.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NotaCreditoSoliDataAccess.TABLENAME, notacreditosoli.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NotaCreditoSoliConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NotaCreditoSoliLogic.registrarAuditoriaDetallesNotaCreditoSoli(connexion,notacreditosoli,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesNotaCreditoSoli(Connexion connexion,NotaCreditoSoli notacreditosoli)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getid_empresa().equals(notacreditosoli.getNotaCreditoSoliOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getid_empresa()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getid_empresa().toString();
				}
				if(notacreditosoli.getid_empresa()!=null)
				{
					strValorNuevo=notacreditosoli.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getid_sucursal().equals(notacreditosoli.getNotaCreditoSoliOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getid_sucursal()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getid_sucursal().toString();
				}
				if(notacreditosoli.getid_sucursal()!=null)
				{
					strValorNuevo=notacreditosoli.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getid_ejercicio().equals(notacreditosoli.getNotaCreditoSoliOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getid_ejercicio()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getid_ejercicio().toString();
				}
				if(notacreditosoli.getid_ejercicio()!=null)
				{
					strValorNuevo=notacreditosoli.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getid_periodo().equals(notacreditosoli.getNotaCreditoSoliOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getid_periodo()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getid_periodo().toString();
				}
				if(notacreditosoli.getid_periodo()!=null)
				{
					strValorNuevo=notacreditosoli.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getid_anio().equals(notacreditosoli.getNotaCreditoSoliOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getid_anio()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getid_anio().toString();
				}
				if(notacreditosoli.getid_anio()!=null)
				{
					strValorNuevo=notacreditosoli.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getid_mes().equals(notacreditosoli.getNotaCreditoSoliOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getid_mes()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getid_mes().toString();
				}
				if(notacreditosoli.getid_mes()!=null)
				{
					strValorNuevo=notacreditosoli.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getid_usuario().equals(notacreditosoli.getNotaCreditoSoliOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getid_usuario()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getid_usuario().toString();
				}
				if(notacreditosoli.getid_usuario()!=null)
				{
					strValorNuevo=notacreditosoli.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getcodigo().equals(notacreditosoli.getNotaCreditoSoliOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getcodigo()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getcodigo();
				}
				if(notacreditosoli.getcodigo()!=null)
				{
					strValorNuevo=notacreditosoli.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getnumero().equals(notacreditosoli.getNotaCreditoSoliOriginal().getnumero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getnumero()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getnumero();
				}
				if(notacreditosoli.getnumero()!=null)
				{
					strValorNuevo=notacreditosoli.getnumero() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.NUMEROPREIMPRESO,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getfecha_emision().equals(notacreditosoli.getNotaCreditoSoliOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getfecha_emision()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getfecha_emision().toString();
				}
				if(notacreditosoli.getfecha_emision()!=null)
				{
					strValorNuevo=notacreditosoli.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getnumero_dias().equals(notacreditosoli.getNotaCreditoSoliOriginal().getnumero_dias()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getnumero_dias()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getnumero_dias().toString();
				}
				if(notacreditosoli.getnumero_dias()!=null)
				{
					strValorNuevo=notacreditosoli.getnumero_dias().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.NUMERODIAS,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getfecha_vencimiento().equals(notacreditosoli.getNotaCreditoSoliOriginal().getfecha_vencimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getfecha_vencimiento()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getfecha_vencimiento().toString();
				}
				if(notacreditosoli.getfecha_vencimiento()!=null)
				{
					strValorNuevo=notacreditosoli.getfecha_vencimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.FECHAVENCIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getid_moneda().equals(notacreditosoli.getNotaCreditoSoliOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getid_moneda()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getid_moneda().toString();
				}
				if(notacreditosoli.getid_moneda()!=null)
				{
					strValorNuevo=notacreditosoli.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getid_empleado().equals(notacreditosoli.getNotaCreditoSoliOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getid_empleado()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getid_empleado().toString();
				}
				if(notacreditosoli.getid_empleado()!=null)
				{
					strValorNuevo=notacreditosoli.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getcotizacion().equals(notacreditosoli.getNotaCreditoSoliOriginal().getcotizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getcotizacion()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getcotizacion().toString();
				}
				if(notacreditosoli.getcotizacion()!=null)
				{
					strValorNuevo=notacreditosoli.getcotizacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.COTIZACION,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getid_formato().equals(notacreditosoli.getNotaCreditoSoliOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getid_formato()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getid_formato().toString();
				}
				if(notacreditosoli.getid_formato()!=null)
				{
					strValorNuevo=notacreditosoli.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getid_tipo_precio().equals(notacreditosoli.getNotaCreditoSoliOriginal().getid_tipo_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getid_tipo_precio()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getid_tipo_precio().toString();
				}
				if(notacreditosoli.getid_tipo_precio()!=null)
				{
					strValorNuevo=notacreditosoli.getid_tipo_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.IDTIPOPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getid_cliente().equals(notacreditosoli.getNotaCreditoSoliOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getid_cliente()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getid_cliente().toString();
				}
				if(notacreditosoli.getid_cliente()!=null)
				{
					strValorNuevo=notacreditosoli.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getid_factura().equals(notacreditosoli.getNotaCreditoSoliOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getid_factura()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getid_factura().toString();
				}
				if(notacreditosoli.getid_factura()!=null)
				{
					strValorNuevo=notacreditosoli.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getdireccion().equals(notacreditosoli.getNotaCreditoSoliOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getdireccion()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getdireccion();
				}
				if(notacreditosoli.getdireccion()!=null)
				{
					strValorNuevo=notacreditosoli.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.gettelefono().equals(notacreditosoli.getNotaCreditoSoliOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().gettelefono()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().gettelefono();
				}
				if(notacreditosoli.gettelefono()!=null)
				{
					strValorNuevo=notacreditosoli.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getruc().equals(notacreditosoli.getNotaCreditoSoliOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getruc()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getruc();
				}
				if(notacreditosoli.getruc()!=null)
				{
					strValorNuevo=notacreditosoli.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getid_tipo_nota_credito_soli().equals(notacreditosoli.getNotaCreditoSoliOriginal().getid_tipo_nota_credito_soli()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getid_tipo_nota_credito_soli()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getid_tipo_nota_credito_soli().toString();
				}
				if(notacreditosoli.getid_tipo_nota_credito_soli()!=null)
				{
					strValorNuevo=notacreditosoli.getid_tipo_nota_credito_soli().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.IDTIPONOTACREDITOSOLI,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getid_responsable().equals(notacreditosoli.getNotaCreditoSoliOriginal().getid_responsable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getid_responsable()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getid_responsable().toString();
				}
				if(notacreditosoli.getid_responsable()!=null)
				{
					strValorNuevo=notacreditosoli.getid_responsable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.IDRESPONSABLE,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getid_estado_nota_credito().equals(notacreditosoli.getNotaCreditoSoliOriginal().getid_estado_nota_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getid_estado_nota_credito()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getid_estado_nota_credito().toString();
				}
				if(notacreditosoli.getid_estado_nota_credito()!=null)
				{
					strValorNuevo=notacreditosoli.getid_estado_nota_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.IDESTADONOTACREDITOSOLI,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getdescripcion().equals(notacreditosoli.getNotaCreditoSoliOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getdescripcion()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getdescripcion();
				}
				if(notacreditosoli.getdescripcion()!=null)
				{
					strValorNuevo=notacreditosoli.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getpenalizado().equals(notacreditosoli.getNotaCreditoSoliOriginal().getpenalizado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getpenalizado()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getpenalizado().toString();
				}
				if(notacreditosoli.getpenalizado()!=null)
				{
					strValorNuevo=notacreditosoli.getpenalizado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.PENALIZADO,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getdescuento_porcentaje().equals(notacreditosoli.getNotaCreditoSoliOriginal().getdescuento_porcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getdescuento_porcentaje()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getdescuento_porcentaje().toString();
				}
				if(notacreditosoli.getdescuento_porcentaje()!=null)
				{
					strValorNuevo=notacreditosoli.getdescuento_porcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.DESCUENTOPORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.gettotal_iva().equals(notacreditosoli.getNotaCreditoSoliOriginal().gettotal_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().gettotal_iva()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().gettotal_iva().toString();
				}
				if(notacreditosoli.gettotal_iva()!=null)
				{
					strValorNuevo=notacreditosoli.gettotal_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.TOTALIVA,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getsuman().equals(notacreditosoli.getNotaCreditoSoliOriginal().getsuman()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getsuman()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getsuman().toString();
				}
				if(notacreditosoli.getsuman()!=null)
				{
					strValorNuevo=notacreditosoli.getsuman().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.SUMAN,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getdescuento_valor().equals(notacreditosoli.getNotaCreditoSoliOriginal().getdescuento_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getdescuento_valor()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getdescuento_valor().toString();
				}
				if(notacreditosoli.getdescuento_valor()!=null)
				{
					strValorNuevo=notacreditosoli.getdescuento_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.DESCUENTOVALOR,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.gettotal_sin_iva().equals(notacreditosoli.getNotaCreditoSoliOriginal().gettotal_sin_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().gettotal_sin_iva()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().gettotal_sin_iva().toString();
				}
				if(notacreditosoli.gettotal_sin_iva()!=null)
				{
					strValorNuevo=notacreditosoli.gettotal_sin_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.TOTALSINIVA,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getdescuento_general().equals(notacreditosoli.getNotaCreditoSoliOriginal().getdescuento_general()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getdescuento_general()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getdescuento_general().toString();
				}
				if(notacreditosoli.getdescuento_general()!=null)
				{
					strValorNuevo=notacreditosoli.getdescuento_general().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.DESCUENTOGENERAL,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getflete().equals(notacreditosoli.getNotaCreditoSoliOriginal().getflete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getflete()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getflete().toString();
				}
				if(notacreditosoli.getflete()!=null)
				{
					strValorNuevo=notacreditosoli.getflete().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.FLETE,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.gettotal().equals(notacreditosoli.getNotaCreditoSoliOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().gettotal()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().gettotal().toString();
				}
				if(notacreditosoli.gettotal()!=null)
				{
					strValorNuevo=notacreditosoli.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getsub_total().equals(notacreditosoli.getNotaCreditoSoliOriginal().getsub_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getsub_total()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getsub_total().toString();
				}
				if(notacreditosoli.getsub_total()!=null)
				{
					strValorNuevo=notacreditosoli.getsub_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.SUBTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getotro().equals(notacreditosoli.getNotaCreditoSoliOriginal().getotro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getotro()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getotro().toString();
				}
				if(notacreditosoli.getotro()!=null)
				{
					strValorNuevo=notacreditosoli.getotro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.OTRO,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getiva().equals(notacreditosoli.getNotaCreditoSoliOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getiva()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getiva().toString();
				}
				if(notacreditosoli.getiva()!=null)
				{
					strValorNuevo=notacreditosoli.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getfinanciamiento().equals(notacreditosoli.getNotaCreditoSoliOriginal().getfinanciamiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getfinanciamiento()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getfinanciamiento().toString();
				}
				if(notacreditosoli.getfinanciamiento()!=null)
				{
					strValorNuevo=notacreditosoli.getfinanciamiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.FINANCIAMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getotro_valor().equals(notacreditosoli.getNotaCreditoSoliOriginal().getotro_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getotro_valor()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getotro_valor().toString();
				}
				if(notacreditosoli.getotro_valor()!=null)
				{
					strValorNuevo=notacreditosoli.getotro_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.OTROVALOR,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getretencion().equals(notacreditosoli.getNotaCreditoSoliOriginal().getretencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getretencion()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getretencion().toString();
				}
				if(notacreditosoli.getretencion()!=null)
				{
					strValorNuevo=notacreditosoli.getretencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.RETENCION,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getice().equals(notacreditosoli.getNotaCreditoSoliOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getice()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getice().toString();
				}
				if(notacreditosoli.getice()!=null)
				{
					strValorNuevo=notacreditosoli.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getfecha().equals(notacreditosoli.getNotaCreditoSoliOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getfecha()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getfecha().toString();
				}
				if(notacreditosoli.getfecha()!=null)
				{
					strValorNuevo=notacreditosoli.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getid_centro_costo().equals(notacreditosoli.getNotaCreditoSoliOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getid_centro_costo()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getid_centro_costo().toString();
				}
				if(notacreditosoli.getid_centro_costo()!=null)
				{
					strValorNuevo=notacreditosoli.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getid_vendedor().equals(notacreditosoli.getNotaCreditoSoliOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getid_vendedor()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getid_vendedor().toString();
				}
				if(notacreditosoli.getid_vendedor()!=null)
				{
					strValorNuevo=notacreditosoli.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getid_tipo_cambio().equals(notacreditosoli.getNotaCreditoSoliOriginal().getid_tipo_cambio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getid_tipo_cambio()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getid_tipo_cambio().toString();
				}
				if(notacreditosoli.getid_tipo_cambio()!=null)
				{
					strValorNuevo=notacreditosoli.getid_tipo_cambio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.IDTIPOCAMBIO,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getid_transporte().equals(notacreditosoli.getNotaCreditoSoliOriginal().getid_transporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getid_transporte()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getid_transporte().toString();
				}
				if(notacreditosoli.getid_transporte()!=null)
				{
					strValorNuevo=notacreditosoli.getid_transporte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.IDTRANSPORTE,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getid_transportista().equals(notacreditosoli.getNotaCreditoSoliOriginal().getid_transportista()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getid_transportista()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getid_transportista().toString();
				}
				if(notacreditosoli.getid_transportista()!=null)
				{
					strValorNuevo=notacreditosoli.getid_transportista().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.IDTRANSPORTISTA,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getfecha_cliente().equals(notacreditosoli.getNotaCreditoSoliOriginal().getfecha_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getfecha_cliente()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getfecha_cliente().toString();
				}
				if(notacreditosoli.getfecha_cliente()!=null)
				{
					strValorNuevo=notacreditosoli.getfecha_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.FECHACLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(notacreditosoli.getIsNew()||!notacreditosoli.getfecha_autorizacion().equals(notacreditosoli.getNotaCreditoSoliOriginal().getfecha_autorizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(notacreditosoli.getNotaCreditoSoliOriginal().getfecha_autorizacion()!=null)
				{
					strValorActual=notacreditosoli.getNotaCreditoSoliOriginal().getfecha_autorizacion().toString();
				}
				if(notacreditosoli.getfecha_autorizacion()!=null)
				{
					strValorNuevo=notacreditosoli.getfecha_autorizacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NotaCreditoSoliConstantesFunciones.FECHAAUTORIZACION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveNotaCreditoSoliRelacionesWithConnection(NotaCreditoSoli notacreditosoli,List<DetaNotaCreditoSoli> detanotacreditosolis) throws Exception {

		if(!notacreditosoli.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNotaCreditoSoliRelacionesBase(notacreditosoli,detanotacreditosolis,true);
		}
	}

	public void saveNotaCreditoSoliRelaciones(NotaCreditoSoli notacreditosoli,List<DetaNotaCreditoSoli> detanotacreditosolis)throws Exception {

		if(!notacreditosoli.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNotaCreditoSoliRelacionesBase(notacreditosoli,detanotacreditosolis,false);
		}
	}

	public void saveNotaCreditoSoliRelacionesBase(NotaCreditoSoli notacreditosoli,List<DetaNotaCreditoSoli> detanotacreditosolis,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("NotaCreditoSoli-saveRelacionesWithConnection");}
	
			notacreditosoli.setDetaNotaCreditoSolis(detanotacreditosolis);

			this.setNotaCreditoSoli(notacreditosoli);

			if(NotaCreditoSoliLogicAdditional.validarSaveRelaciones(notacreditosoli,this)) {

				NotaCreditoSoliLogicAdditional.updateRelacionesToSave(notacreditosoli,this);

				if((notacreditosoli.getIsNew()||notacreditosoli.getIsChanged())&&!notacreditosoli.getIsDeleted()) {
					this.saveNotaCreditoSoli();
					this.saveNotaCreditoSoliRelacionesDetalles(detanotacreditosolis);

				} else if(notacreditosoli.getIsDeleted()) {
					this.saveNotaCreditoSoliRelacionesDetalles(detanotacreditosolis);
					this.saveNotaCreditoSoli();
				}

				NotaCreditoSoliLogicAdditional.updateRelacionesToSaveAfter(notacreditosoli,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetaNotaCreditoSoliConstantesFunciones.InicializarGeneralEntityAuxiliaresDetaNotaCreditoSolis(detanotacreditosolis,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveNotaCreditoSoliRelacionesDetalles(List<DetaNotaCreditoSoli> detanotacreditosolis)throws Exception {
		try {
	

			Long idNotaCreditoSoliActual=this.getNotaCreditoSoli().getId();

			DetaNotaCreditoSoliLogic detanotacreditosoliLogic_Desde_NotaCreditoSoli=new DetaNotaCreditoSoliLogic();
			detanotacreditosoliLogic_Desde_NotaCreditoSoli.setDetaNotaCreditoSolis(detanotacreditosolis);

			detanotacreditosoliLogic_Desde_NotaCreditoSoli.setConnexion(this.getConnexion());
			detanotacreditosoliLogic_Desde_NotaCreditoSoli.setDatosCliente(this.datosCliente);

			for(DetaNotaCreditoSoli detanotacreditosoli_Desde_NotaCreditoSoli:detanotacreditosoliLogic_Desde_NotaCreditoSoli.getDetaNotaCreditoSolis()) {
				detanotacreditosoli_Desde_NotaCreditoSoli.setid_nota_credito_soli(idNotaCreditoSoliActual);
			}

			detanotacreditosoliLogic_Desde_NotaCreditoSoli.saveDetaNotaCreditoSolis();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfNotaCreditoSoli(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NotaCreditoSoliConstantesFunciones.getClassesForeignKeysOfNotaCreditoSoli(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNotaCreditoSoli(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NotaCreditoSoliConstantesFunciones.getClassesRelationshipsOfNotaCreditoSoli(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

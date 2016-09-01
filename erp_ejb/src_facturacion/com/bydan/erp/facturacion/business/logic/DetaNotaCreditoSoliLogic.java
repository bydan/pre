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
import com.bydan.erp.facturacion.util.DetaNotaCreditoSoliConstantesFunciones;
import com.bydan.erp.facturacion.util.DetaNotaCreditoSoliParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetaNotaCreditoSoliParameterGeneral;
import com.bydan.erp.facturacion.business.entity.DetaNotaCreditoSoli;
import com.bydan.erp.facturacion.business.logic.DetaNotaCreditoSoliLogicAdditional;
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
public class DetaNotaCreditoSoliLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetaNotaCreditoSoliLogic.class);
	
	protected DetaNotaCreditoSoliDataAccess detanotacreditosoliDataAccess; 	
	protected DetaNotaCreditoSoli detanotacreditosoli;
	protected List<DetaNotaCreditoSoli> detanotacreditosolis;
	protected Object detanotacreditosoliObject;	
	protected List<Object> detanotacreditosolisObject;
	
	public static ClassValidator<DetaNotaCreditoSoli> detanotacreditosoliValidator = new ClassValidator<DetaNotaCreditoSoli>(DetaNotaCreditoSoli.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetaNotaCreditoSoliLogicAdditional detanotacreditosoliLogicAdditional=null;
	
	public DetaNotaCreditoSoliLogicAdditional getDetaNotaCreditoSoliLogicAdditional() {
		return this.detanotacreditosoliLogicAdditional;
	}
	
	public void setDetaNotaCreditoSoliLogicAdditional(DetaNotaCreditoSoliLogicAdditional detanotacreditosoliLogicAdditional) {
		try {
			this.detanotacreditosoliLogicAdditional=detanotacreditosoliLogicAdditional;
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
	
	
	
	
	public  DetaNotaCreditoSoliLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detanotacreditosoliDataAccess = new DetaNotaCreditoSoliDataAccess();
			
			this.detanotacreditosolis= new ArrayList<DetaNotaCreditoSoli>();
			this.detanotacreditosoli= new DetaNotaCreditoSoli();
			
			this.detanotacreditosoliObject=new Object();
			this.detanotacreditosolisObject=new ArrayList<Object>();
				
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
			
			this.detanotacreditosoliDataAccess.setConnexionType(this.connexionType);
			this.detanotacreditosoliDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetaNotaCreditoSoliLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detanotacreditosoliDataAccess = new DetaNotaCreditoSoliDataAccess();
			this.detanotacreditosolis= new ArrayList<DetaNotaCreditoSoli>();
			this.detanotacreditosoli= new DetaNotaCreditoSoli();
			this.detanotacreditosoliObject=new Object();
			this.detanotacreditosolisObject=new ArrayList<Object>();
			
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
			
			this.detanotacreditosoliDataAccess.setConnexionType(this.connexionType);
			this.detanotacreditosoliDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetaNotaCreditoSoli getDetaNotaCreditoSoli() throws Exception {	
		DetaNotaCreditoSoliLogicAdditional.checkDetaNotaCreditoSoliToGet(detanotacreditosoli,this.datosCliente,this.arrDatoGeneral);
		DetaNotaCreditoSoliLogicAdditional.updateDetaNotaCreditoSoliToGet(detanotacreditosoli,this.arrDatoGeneral);
		
		return detanotacreditosoli;
	}
		
	public void setDetaNotaCreditoSoli(DetaNotaCreditoSoli newDetaNotaCreditoSoli) {
		this.detanotacreditosoli = newDetaNotaCreditoSoli;
	}
	
	public DetaNotaCreditoSoliDataAccess getDetaNotaCreditoSoliDataAccess() {
		return detanotacreditosoliDataAccess;
	}
	
	public void setDetaNotaCreditoSoliDataAccess(DetaNotaCreditoSoliDataAccess newdetanotacreditosoliDataAccess) {
		this.detanotacreditosoliDataAccess = newdetanotacreditosoliDataAccess;
	}
	
	public List<DetaNotaCreditoSoli> getDetaNotaCreditoSolis() throws Exception {		
		this.quitarDetaNotaCreditoSolisNulos();
		
		DetaNotaCreditoSoliLogicAdditional.checkDetaNotaCreditoSoliToGets(detanotacreditosolis,this.datosCliente,this.arrDatoGeneral);
		
		for (DetaNotaCreditoSoli detanotacreditosoliLocal: detanotacreditosolis ) {
			DetaNotaCreditoSoliLogicAdditional.updateDetaNotaCreditoSoliToGet(detanotacreditosoliLocal,this.arrDatoGeneral);
		}
		
		return detanotacreditosolis;
	}
	
	public void setDetaNotaCreditoSolis(List<DetaNotaCreditoSoli> newDetaNotaCreditoSolis) {
		this.detanotacreditosolis = newDetaNotaCreditoSolis;
	}
	
	public Object getDetaNotaCreditoSoliObject() {	
		this.detanotacreditosoliObject=this.detanotacreditosoliDataAccess.getEntityObject();
		return this.detanotacreditosoliObject;
	}
		
	public void setDetaNotaCreditoSoliObject(Object newDetaNotaCreditoSoliObject) {
		this.detanotacreditosoliObject = newDetaNotaCreditoSoliObject;
	}
	
	public List<Object> getDetaNotaCreditoSolisObject() {		
		this.detanotacreditosolisObject=this.detanotacreditosoliDataAccess.getEntitiesObject();
		return this.detanotacreditosolisObject;
	}
		
	public void setDetaNotaCreditoSolisObject(List<Object> newDetaNotaCreditoSolisObject) {
		this.detanotacreditosolisObject = newDetaNotaCreditoSolisObject;
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
		
		if(this.detanotacreditosoliDataAccess!=null) {
			this.detanotacreditosoliDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detanotacreditosoliDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detanotacreditosoliDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detanotacreditosoli = new  DetaNotaCreditoSoli();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detanotacreditosoli=detanotacreditosoliDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detanotacreditosoli,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosoli);
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
		detanotacreditosoli = new  DetaNotaCreditoSoli();
		  		  
        try {
			
			detanotacreditosoli=detanotacreditosoliDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detanotacreditosoli,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosoli);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detanotacreditosoli = new  DetaNotaCreditoSoli();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detanotacreditosoli=detanotacreditosoliDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detanotacreditosoli,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosoli);
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
		detanotacreditosoli = new  DetaNotaCreditoSoli();
		  		  
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
		detanotacreditosoli = new  DetaNotaCreditoSoli();
		  		  
        try {
			
			detanotacreditosoli=detanotacreditosoliDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detanotacreditosoli,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosoli);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detanotacreditosoli = new  DetaNotaCreditoSoli();
		  		  
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
		detanotacreditosoli = new  DetaNotaCreditoSoli();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detanotacreditosoliDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detanotacreditosoli = new  DetaNotaCreditoSoli();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detanotacreditosoliDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detanotacreditosoli = new  DetaNotaCreditoSoli();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detanotacreditosoliDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detanotacreditosoli = new  DetaNotaCreditoSoli();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detanotacreditosoliDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detanotacreditosoli = new  DetaNotaCreditoSoli();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detanotacreditosoliDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detanotacreditosoli = new  DetaNotaCreditoSoli();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detanotacreditosoliDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detanotacreditosolis = new  ArrayList<DetaNotaCreditoSoli>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetaNotaCreditoSoli(detanotacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
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
		detanotacreditosolis = new  ArrayList<DetaNotaCreditoSoli>();
		  		  
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
		detanotacreditosolis = new  ArrayList<DetaNotaCreditoSoli>();
		  		  
        try {			
			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetaNotaCreditoSoli(detanotacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detanotacreditosolis = new  ArrayList<DetaNotaCreditoSoli>();
		  		  
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
		detanotacreditosolis = new  ArrayList<DetaNotaCreditoSoli>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetaNotaCreditoSoli(detanotacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
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
		detanotacreditosolis = new  ArrayList<DetaNotaCreditoSoli>();
		  		  
        try {
			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetaNotaCreditoSoli(detanotacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
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
		detanotacreditosolis = new  ArrayList<DetaNotaCreditoSoli>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetaNotaCreditoSoli(detanotacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
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
		detanotacreditosolis = new  ArrayList<DetaNotaCreditoSoli>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetaNotaCreditoSoli(detanotacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detanotacreditosoli = new  DetaNotaCreditoSoli();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacreditosoli=detanotacreditosoliDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetaNotaCreditoSoli(detanotacreditosoli);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosoli);
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
		detanotacreditosoli = new  DetaNotaCreditoSoli();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacreditosoli=detanotacreditosoliDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetaNotaCreditoSoli(detanotacreditosoli);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosoli);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detanotacreditosolis = new  ArrayList<DetaNotaCreditoSoli>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacreditosolis=detanotacreditosoliDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetaNotaCreditoSoli(detanotacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
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
		detanotacreditosolis = new  ArrayList<DetaNotaCreditoSoli>();
		  		  
        try {
			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacreditosolis=detanotacreditosoliDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetaNotaCreditoSoli(detanotacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetaNotaCreditoSolisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detanotacreditosolis = new  ArrayList<DetaNotaCreditoSoli>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getTodosDetaNotaCreditoSolisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetaNotaCreditoSoli(detanotacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
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
	
	public  void  getTodosDetaNotaCreditoSolis(String sFinalQuery,Pagination pagination)throws Exception {
		detanotacreditosolis = new  ArrayList<DetaNotaCreditoSoli>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetaNotaCreditoSoli(detanotacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetaNotaCreditoSoli(DetaNotaCreditoSoli detanotacreditosoli) throws Exception {
		Boolean estaValidado=false;
		
		if(detanotacreditosoli.getIsNew() || detanotacreditosoli.getIsChanged()) { 
			this.invalidValues = detanotacreditosoliValidator.getInvalidValues(detanotacreditosoli);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detanotacreditosoli);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetaNotaCreditoSoli(List<DetaNotaCreditoSoli> DetaNotaCreditoSolis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetaNotaCreditoSoli detanotacreditosoliLocal:detanotacreditosolis) {				
			estaValidadoObjeto=this.validarGuardarDetaNotaCreditoSoli(detanotacreditosoliLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetaNotaCreditoSoli(List<DetaNotaCreditoSoli> DetaNotaCreditoSolis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetaNotaCreditoSoli(detanotacreditosolis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetaNotaCreditoSoli(DetaNotaCreditoSoli DetaNotaCreditoSoli) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetaNotaCreditoSoli(detanotacreditosoli)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetaNotaCreditoSoli detanotacreditosoli) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detanotacreditosoli.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetaNotaCreditoSoliConstantesFunciones.getDetaNotaCreditoSoliLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detanotacreditosoli","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetaNotaCreditoSoliConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetaNotaCreditoSoliConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetaNotaCreditoSoliWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-saveDetaNotaCreditoSoliWithConnection");connexion.begin();			
			
			DetaNotaCreditoSoliLogicAdditional.checkDetaNotaCreditoSoliToSave(this.detanotacreditosoli,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetaNotaCreditoSoliLogicAdditional.updateDetaNotaCreditoSoliToSave(this.detanotacreditosoli,this.arrDatoGeneral);
			
			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detanotacreditosoli,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetaNotaCreditoSoli();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetaNotaCreditoSoli(this.detanotacreditosoli)) {
				DetaNotaCreditoSoliDataAccess.save(this.detanotacreditosoli, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detanotacreditosoli,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetaNotaCreditoSoliLogicAdditional.checkDetaNotaCreditoSoliToSaveAfter(this.detanotacreditosoli,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetaNotaCreditoSoli();
			
			connexion.commit();			
			
			if(this.detanotacreditosoli.getIsDeleted()) {
				this.detanotacreditosoli=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetaNotaCreditoSoli()throws Exception {	
		try {	
			
			DetaNotaCreditoSoliLogicAdditional.checkDetaNotaCreditoSoliToSave(this.detanotacreditosoli,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetaNotaCreditoSoliLogicAdditional.updateDetaNotaCreditoSoliToSave(this.detanotacreditosoli,this.arrDatoGeneral);
			
			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detanotacreditosoli,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetaNotaCreditoSoli(this.detanotacreditosoli)) {			
				DetaNotaCreditoSoliDataAccess.save(this.detanotacreditosoli, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detanotacreditosoli,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetaNotaCreditoSoliLogicAdditional.checkDetaNotaCreditoSoliToSaveAfter(this.detanotacreditosoli,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detanotacreditosoli.getIsDeleted()) {
				this.detanotacreditosoli=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetaNotaCreditoSolisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-saveDetaNotaCreditoSolisWithConnection");connexion.begin();			
			
			DetaNotaCreditoSoliLogicAdditional.checkDetaNotaCreditoSoliToSaves(detanotacreditosolis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetaNotaCreditoSolis();
			
			Boolean validadoTodosDetaNotaCreditoSoli=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetaNotaCreditoSoli detanotacreditosoliLocal:detanotacreditosolis) {		
				if(detanotacreditosoliLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetaNotaCreditoSoliLogicAdditional.updateDetaNotaCreditoSoliToSave(detanotacreditosoliLocal,this.arrDatoGeneral);
	        	
				DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detanotacreditosoliLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetaNotaCreditoSoli(detanotacreditosoliLocal)) {
					DetaNotaCreditoSoliDataAccess.save(detanotacreditosoliLocal, connexion);				
				} else {
					validadoTodosDetaNotaCreditoSoli=false;
				}
			}
			
			if(!validadoTodosDetaNotaCreditoSoli) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetaNotaCreditoSoliLogicAdditional.checkDetaNotaCreditoSoliToSavesAfter(detanotacreditosolis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetaNotaCreditoSolis();
			
			connexion.commit();		
			
			this.quitarDetaNotaCreditoSolisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetaNotaCreditoSolis()throws Exception {				
		 try {	
			DetaNotaCreditoSoliLogicAdditional.checkDetaNotaCreditoSoliToSaves(detanotacreditosolis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetaNotaCreditoSoli=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetaNotaCreditoSoli detanotacreditosoliLocal:detanotacreditosolis) {				
				if(detanotacreditosoliLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetaNotaCreditoSoliLogicAdditional.updateDetaNotaCreditoSoliToSave(detanotacreditosoliLocal,this.arrDatoGeneral);
	        	
				DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detanotacreditosoliLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetaNotaCreditoSoli(detanotacreditosoliLocal)) {				
					DetaNotaCreditoSoliDataAccess.save(detanotacreditosoliLocal, connexion);				
				} else {
					validadoTodosDetaNotaCreditoSoli=false;
				}
			}
			
			if(!validadoTodosDetaNotaCreditoSoli) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetaNotaCreditoSoliLogicAdditional.checkDetaNotaCreditoSoliToSavesAfter(detanotacreditosolis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetaNotaCreditoSolisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetaNotaCreditoSoliParameterReturnGeneral procesarAccionDetaNotaCreditoSolis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetaNotaCreditoSoli> detanotacreditosolis,DetaNotaCreditoSoliParameterReturnGeneral detanotacreditosoliParameterGeneral)throws Exception {
		 try {	
			DetaNotaCreditoSoliParameterReturnGeneral detanotacreditosoliReturnGeneral=new DetaNotaCreditoSoliParameterReturnGeneral();
	
			DetaNotaCreditoSoliLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detanotacreditosolis,detanotacreditosoliParameterGeneral,detanotacreditosoliReturnGeneral);
			
			return detanotacreditosoliReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetaNotaCreditoSoliParameterReturnGeneral procesarAccionDetaNotaCreditoSolisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetaNotaCreditoSoli> detanotacreditosolis,DetaNotaCreditoSoliParameterReturnGeneral detanotacreditosoliParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-procesarAccionDetaNotaCreditoSolisWithConnection");connexion.begin();			
			
			DetaNotaCreditoSoliParameterReturnGeneral detanotacreditosoliReturnGeneral=new DetaNotaCreditoSoliParameterReturnGeneral();
	
			DetaNotaCreditoSoliLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detanotacreditosolis,detanotacreditosoliParameterGeneral,detanotacreditosoliReturnGeneral);
			
			this.connexion.commit();
			
			return detanotacreditosoliReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetaNotaCreditoSoliParameterReturnGeneral procesarEventosDetaNotaCreditoSolis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetaNotaCreditoSoli> detanotacreditosolis,DetaNotaCreditoSoli detanotacreditosoli,DetaNotaCreditoSoliParameterReturnGeneral detanotacreditosoliParameterGeneral,Boolean isEsNuevoDetaNotaCreditoSoli,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetaNotaCreditoSoliParameterReturnGeneral detanotacreditosoliReturnGeneral=new DetaNotaCreditoSoliParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detanotacreditosoliReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetaNotaCreditoSoliLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detanotacreditosolis,detanotacreditosoli,detanotacreditosoliParameterGeneral,detanotacreditosoliReturnGeneral,isEsNuevoDetaNotaCreditoSoli,clases);
			
			return detanotacreditosoliReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetaNotaCreditoSoliParameterReturnGeneral procesarEventosDetaNotaCreditoSolisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetaNotaCreditoSoli> detanotacreditosolis,DetaNotaCreditoSoli detanotacreditosoli,DetaNotaCreditoSoliParameterReturnGeneral detanotacreditosoliParameterGeneral,Boolean isEsNuevoDetaNotaCreditoSoli,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-procesarEventosDetaNotaCreditoSolisWithConnection");connexion.begin();			
			
			DetaNotaCreditoSoliParameterReturnGeneral detanotacreditosoliReturnGeneral=new DetaNotaCreditoSoliParameterReturnGeneral();
	
			detanotacreditosoliReturnGeneral.setDetaNotaCreditoSoli(detanotacreditosoli);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detanotacreditosoliReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetaNotaCreditoSoliLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detanotacreditosolis,detanotacreditosoli,detanotacreditosoliParameterGeneral,detanotacreditosoliReturnGeneral,isEsNuevoDetaNotaCreditoSoli,clases);
			
			this.connexion.commit();
			
			return detanotacreditosoliReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetaNotaCreditoSoliParameterReturnGeneral procesarImportacionDetaNotaCreditoSolisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetaNotaCreditoSoliParameterReturnGeneral detanotacreditosoliParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-procesarImportacionDetaNotaCreditoSolisWithConnection");connexion.begin();			
			
			DetaNotaCreditoSoliParameterReturnGeneral detanotacreditosoliReturnGeneral=new DetaNotaCreditoSoliParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detanotacreditosolis=new ArrayList<DetaNotaCreditoSoli>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detanotacreditosoli=new DetaNotaCreditoSoli();
				
				
				if(conColumnasBase) {this.detanotacreditosoli.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detanotacreditosoli.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detanotacreditosoli.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.detanotacreditosoli.setprecio(Double.parseDouble(arrColumnas[iColumn++]));
				this.detanotacreditosoli.setporcen_descuen(Double.parseDouble(arrColumnas[iColumn++]));
				this.detanotacreditosoli.setdescuento(Double.parseDouble(arrColumnas[iColumn++]));
				this.detanotacreditosoli.setimpuesto(Double.parseDouble(arrColumnas[iColumn++]));
				this.detanotacreditosoli.setporcen_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.detanotacreditosoli.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				this.detanotacreditosoli.setdescripcion(arrColumnas[iColumn++]);
				
				this.detanotacreditosolis.add(this.detanotacreditosoli);
			}
			
			this.saveDetaNotaCreditoSolis();
			
			this.connexion.commit();
			
			detanotacreditosoliReturnGeneral.setConRetornoEstaProcesado(true);
			detanotacreditosoliReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detanotacreditosoliReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetaNotaCreditoSolisEliminados() throws Exception {				
		
		List<DetaNotaCreditoSoli> detanotacreditosolisAux= new ArrayList<DetaNotaCreditoSoli>();
		
		for(DetaNotaCreditoSoli detanotacreditosoli:detanotacreditosolis) {
			if(!detanotacreditosoli.getIsDeleted()) {
				detanotacreditosolisAux.add(detanotacreditosoli);
			}
		}
		
		detanotacreditosolis=detanotacreditosolisAux;
	}
	
	public void quitarDetaNotaCreditoSolisNulos() throws Exception {				
		
		List<DetaNotaCreditoSoli> detanotacreditosolisAux= new ArrayList<DetaNotaCreditoSoli>();
		
		for(DetaNotaCreditoSoli detanotacreditosoli : this.detanotacreditosolis) {
			if(detanotacreditosoli==null) {
				detanotacreditosolisAux.add(detanotacreditosoli);
			}
		}
		
		//this.detanotacreditosolis=detanotacreditosolisAux;
		
		this.detanotacreditosolis.removeAll(detanotacreditosolisAux);
	}
	
	public void getSetVersionRowDetaNotaCreditoSoliWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detanotacreditosoli.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detanotacreditosoli.getIsDeleted() || (detanotacreditosoli.getIsChanged()&&!detanotacreditosoli.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detanotacreditosoliDataAccess.getSetVersionRowDetaNotaCreditoSoli(connexion,detanotacreditosoli.getId());
				
				if(!detanotacreditosoli.getVersionRow().equals(timestamp)) {	
					detanotacreditosoli.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detanotacreditosoli.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetaNotaCreditoSoli()throws Exception {	
		
		if(detanotacreditosoli.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detanotacreditosoli.getIsDeleted() || (detanotacreditosoli.getIsChanged()&&!detanotacreditosoli.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detanotacreditosoliDataAccess.getSetVersionRowDetaNotaCreditoSoli(connexion,detanotacreditosoli.getId());
			
			try {							
				if(!detanotacreditosoli.getVersionRow().equals(timestamp)) {	
					detanotacreditosoli.setVersionRow(timestamp);
				}
				
				detanotacreditosoli.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetaNotaCreditoSolisWithConnection()throws Exception {	
		if(detanotacreditosolis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetaNotaCreditoSoli detanotacreditosoliAux:detanotacreditosolis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detanotacreditosoliAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detanotacreditosoliAux.getIsDeleted() || (detanotacreditosoliAux.getIsChanged()&&!detanotacreditosoliAux.getIsNew())) {
						
						timestamp=detanotacreditosoliDataAccess.getSetVersionRowDetaNotaCreditoSoli(connexion,detanotacreditosoliAux.getId());
						
						if(!detanotacreditosoli.getVersionRow().equals(timestamp)) {	
							detanotacreditosoliAux.setVersionRow(timestamp);
						}
								
						detanotacreditosoliAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetaNotaCreditoSolis()throws Exception {	
		if(detanotacreditosolis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetaNotaCreditoSoli detanotacreditosoliAux:detanotacreditosolis) {
					if(detanotacreditosoliAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detanotacreditosoliAux.getIsDeleted() || (detanotacreditosoliAux.getIsChanged()&&!detanotacreditosoliAux.getIsNew())) {
						
						timestamp=detanotacreditosoliDataAccess.getSetVersionRowDetaNotaCreditoSoli(connexion,detanotacreditosoliAux.getId());
						
						if(!detanotacreditosoliAux.getVersionRow().equals(timestamp)) {	
							detanotacreditosoliAux.setVersionRow(timestamp);
						}
						
													
						detanotacreditosoliAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetaNotaCreditoSoliParameterReturnGeneral cargarCombosLoteForeignKeyDetaNotaCreditoSoliWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalNotaCreditoSoli,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalEmpaque,String finalQueryGlobalTipoDevolucionEmpresa,String finalQueryGlobalCentroCosto) throws Exception {
		DetaNotaCreditoSoliParameterReturnGeneral  detanotacreditosoliReturnGeneral =new DetaNotaCreditoSoliParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetaNotaCreditoSoliWithConnection");connexion.begin();
			
			detanotacreditosoliReturnGeneral =new DetaNotaCreditoSoliParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detanotacreditosoliReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detanotacreditosoliReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detanotacreditosoliReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detanotacreditosoliReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detanotacreditosoliReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detanotacreditosoliReturnGeneral.setmessForeignKey(messForeignKey);


			List<NotaCreditoSoli> notacreditosolisForeignKey=new ArrayList<NotaCreditoSoli>();
			NotaCreditoSoliLogic notacreditosoliLogic=new NotaCreditoSoliLogic();
			notacreditosoliLogic.setConnexion(this.connexion);
			notacreditosoliLogic.getNotaCreditoSoliDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNotaCreditoSoli.equals("NONE")) {
				notacreditosoliLogic.getTodosNotaCreditoSolis(finalQueryGlobalNotaCreditoSoli,new Pagination());
				notacreditosolisForeignKey=notacreditosoliLogic.getNotaCreditoSolis();
			}

			detanotacreditosoliReturnGeneral.setnotacreditosolisForeignKey(notacreditosolisForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detanotacreditosoliReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detanotacreditosoliReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detanotacreditosoliReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<Empaque> empaquesForeignKey=new ArrayList<Empaque>();
			EmpaqueLogic empaqueLogic=new EmpaqueLogic();
			empaqueLogic.setConnexion(this.connexion);
			empaqueLogic.getEmpaqueDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpaque.equals("NONE")) {
				empaqueLogic.getTodosEmpaques(finalQueryGlobalEmpaque,new Pagination());
				empaquesForeignKey=empaqueLogic.getEmpaques();
			}

			detanotacreditosoliReturnGeneral.setempaquesForeignKey(empaquesForeignKey);


			List<TipoDevolucionEmpresa> tipodevolucionempresasForeignKey=new ArrayList<TipoDevolucionEmpresa>();
			TipoDevolucionEmpresaLogic tipodevolucionempresaLogic=new TipoDevolucionEmpresaLogic();
			tipodevolucionempresaLogic.setConnexion(this.connexion);
			tipodevolucionempresaLogic.getTipoDevolucionEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDevolucionEmpresa.equals("NONE")) {
				tipodevolucionempresaLogic.getTodosTipoDevolucionEmpresas(finalQueryGlobalTipoDevolucionEmpresa,new Pagination());
				tipodevolucionempresasForeignKey=tipodevolucionempresaLogic.getTipoDevolucionEmpresas();
			}

			detanotacreditosoliReturnGeneral.settipodevolucionempresasForeignKey(tipodevolucionempresasForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detanotacreditosoliReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detanotacreditosoliReturnGeneral;
	}
	
	public DetaNotaCreditoSoliParameterReturnGeneral cargarCombosLoteForeignKeyDetaNotaCreditoSoli(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalNotaCreditoSoli,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalEmpaque,String finalQueryGlobalTipoDevolucionEmpresa,String finalQueryGlobalCentroCosto) throws Exception {
		DetaNotaCreditoSoliParameterReturnGeneral  detanotacreditosoliReturnGeneral =new DetaNotaCreditoSoliParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detanotacreditosoliReturnGeneral =new DetaNotaCreditoSoliParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detanotacreditosoliReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detanotacreditosoliReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detanotacreditosoliReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detanotacreditosoliReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detanotacreditosoliReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detanotacreditosoliReturnGeneral.setmessForeignKey(messForeignKey);


			List<NotaCreditoSoli> notacreditosolisForeignKey=new ArrayList<NotaCreditoSoli>();
			NotaCreditoSoliLogic notacreditosoliLogic=new NotaCreditoSoliLogic();
			notacreditosoliLogic.setConnexion(this.connexion);
			notacreditosoliLogic.getNotaCreditoSoliDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNotaCreditoSoli.equals("NONE")) {
				notacreditosoliLogic.getTodosNotaCreditoSolis(finalQueryGlobalNotaCreditoSoli,new Pagination());
				notacreditosolisForeignKey=notacreditosoliLogic.getNotaCreditoSolis();
			}

			detanotacreditosoliReturnGeneral.setnotacreditosolisForeignKey(notacreditosolisForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detanotacreditosoliReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detanotacreditosoliReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detanotacreditosoliReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<Empaque> empaquesForeignKey=new ArrayList<Empaque>();
			EmpaqueLogic empaqueLogic=new EmpaqueLogic();
			empaqueLogic.setConnexion(this.connexion);
			empaqueLogic.getEmpaqueDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpaque.equals("NONE")) {
				empaqueLogic.getTodosEmpaques(finalQueryGlobalEmpaque,new Pagination());
				empaquesForeignKey=empaqueLogic.getEmpaques();
			}

			detanotacreditosoliReturnGeneral.setempaquesForeignKey(empaquesForeignKey);


			List<TipoDevolucionEmpresa> tipodevolucionempresasForeignKey=new ArrayList<TipoDevolucionEmpresa>();
			TipoDevolucionEmpresaLogic tipodevolucionempresaLogic=new TipoDevolucionEmpresaLogic();
			tipodevolucionempresaLogic.setConnexion(this.connexion);
			tipodevolucionempresaLogic.getTipoDevolucionEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDevolucionEmpresa.equals("NONE")) {
				tipodevolucionempresaLogic.getTodosTipoDevolucionEmpresas(finalQueryGlobalTipoDevolucionEmpresa,new Pagination());
				tipodevolucionempresasForeignKey=tipodevolucionempresaLogic.getTipoDevolucionEmpresas();
			}

			detanotacreditosoliReturnGeneral.settipodevolucionempresasForeignKey(tipodevolucionempresasForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detanotacreditosoliReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detanotacreditosoliReturnGeneral;
	}
	
	
	public void deepLoad(DetaNotaCreditoSoli detanotacreditosoli,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetaNotaCreditoSoliLogicAdditional.updateDetaNotaCreditoSoliToGet(detanotacreditosoli,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detanotacreditosoli.setEmpresa(detanotacreditosoliDataAccess.getEmpresa(connexion,detanotacreditosoli));
		detanotacreditosoli.setSucursal(detanotacreditosoliDataAccess.getSucursal(connexion,detanotacreditosoli));
		detanotacreditosoli.setEjercicio(detanotacreditosoliDataAccess.getEjercicio(connexion,detanotacreditosoli));
		detanotacreditosoli.setPeriodo(detanotacreditosoliDataAccess.getPeriodo(connexion,detanotacreditosoli));
		detanotacreditosoli.setAnio(detanotacreditosoliDataAccess.getAnio(connexion,detanotacreditosoli));
		detanotacreditosoli.setMes(detanotacreditosoliDataAccess.getMes(connexion,detanotacreditosoli));
		detanotacreditosoli.setNotaCreditoSoli(detanotacreditosoliDataAccess.getNotaCreditoSoli(connexion,detanotacreditosoli));
		detanotacreditosoli.setBodega(detanotacreditosoliDataAccess.getBodega(connexion,detanotacreditosoli));
		detanotacreditosoli.setProducto(detanotacreditosoliDataAccess.getProducto(connexion,detanotacreditosoli));
		detanotacreditosoli.setUnidad(detanotacreditosoliDataAccess.getUnidad(connexion,detanotacreditosoli));
		detanotacreditosoli.setEmpaque(detanotacreditosoliDataAccess.getEmpaque(connexion,detanotacreditosoli));
		detanotacreditosoli.setTipoDevolucionEmpresa(detanotacreditosoliDataAccess.getTipoDevolucionEmpresa(connexion,detanotacreditosoli));
		detanotacreditosoli.setCentroCosto(detanotacreditosoliDataAccess.getCentroCosto(connexion,detanotacreditosoli));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detanotacreditosoli.setEmpresa(detanotacreditosoliDataAccess.getEmpresa(connexion,detanotacreditosoli));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detanotacreditosoli.setSucursal(detanotacreditosoliDataAccess.getSucursal(connexion,detanotacreditosoli));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detanotacreditosoli.setEjercicio(detanotacreditosoliDataAccess.getEjercicio(connexion,detanotacreditosoli));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detanotacreditosoli.setPeriodo(detanotacreditosoliDataAccess.getPeriodo(connexion,detanotacreditosoli));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detanotacreditosoli.setAnio(detanotacreditosoliDataAccess.getAnio(connexion,detanotacreditosoli));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detanotacreditosoli.setMes(detanotacreditosoliDataAccess.getMes(connexion,detanotacreditosoli));
				continue;
			}

			if(clas.clas.equals(NotaCreditoSoli.class)) {
				detanotacreditosoli.setNotaCreditoSoli(detanotacreditosoliDataAccess.getNotaCreditoSoli(connexion,detanotacreditosoli));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detanotacreditosoli.setBodega(detanotacreditosoliDataAccess.getBodega(connexion,detanotacreditosoli));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detanotacreditosoli.setProducto(detanotacreditosoliDataAccess.getProducto(connexion,detanotacreditosoli));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detanotacreditosoli.setUnidad(detanotacreditosoliDataAccess.getUnidad(connexion,detanotacreditosoli));
				continue;
			}

			if(clas.clas.equals(Empaque.class)) {
				detanotacreditosoli.setEmpaque(detanotacreditosoliDataAccess.getEmpaque(connexion,detanotacreditosoli));
				continue;
			}

			if(clas.clas.equals(TipoDevolucionEmpresa.class)) {
				detanotacreditosoli.setTipoDevolucionEmpresa(detanotacreditosoliDataAccess.getTipoDevolucionEmpresa(connexion,detanotacreditosoli));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detanotacreditosoli.setCentroCosto(detanotacreditosoliDataAccess.getCentroCosto(connexion,detanotacreditosoli));
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
			detanotacreditosoli.setEmpresa(detanotacreditosoliDataAccess.getEmpresa(connexion,detanotacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setSucursal(detanotacreditosoliDataAccess.getSucursal(connexion,detanotacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setEjercicio(detanotacreditosoliDataAccess.getEjercicio(connexion,detanotacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setPeriodo(detanotacreditosoliDataAccess.getPeriodo(connexion,detanotacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setAnio(detanotacreditosoliDataAccess.getAnio(connexion,detanotacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setMes(detanotacreditosoliDataAccess.getMes(connexion,detanotacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoSoli.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setNotaCreditoSoli(detanotacreditosoliDataAccess.getNotaCreditoSoli(connexion,detanotacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setBodega(detanotacreditosoliDataAccess.getBodega(connexion,detanotacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setProducto(detanotacreditosoliDataAccess.getProducto(connexion,detanotacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setUnidad(detanotacreditosoliDataAccess.getUnidad(connexion,detanotacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empaque.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setEmpaque(detanotacreditosoliDataAccess.getEmpaque(connexion,detanotacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDevolucionEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setTipoDevolucionEmpresa(detanotacreditosoliDataAccess.getTipoDevolucionEmpresa(connexion,detanotacreditosoli));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setCentroCosto(detanotacreditosoliDataAccess.getCentroCosto(connexion,detanotacreditosoli));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detanotacreditosoli.setEmpresa(detanotacreditosoliDataAccess.getEmpresa(connexion,detanotacreditosoli));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detanotacreditosoli.getEmpresa(),isDeep,deepLoadType,clases);
				
		detanotacreditosoli.setSucursal(detanotacreditosoliDataAccess.getSucursal(connexion,detanotacreditosoli));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detanotacreditosoli.getSucursal(),isDeep,deepLoadType,clases);
				
		detanotacreditosoli.setEjercicio(detanotacreditosoliDataAccess.getEjercicio(connexion,detanotacreditosoli));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detanotacreditosoli.getEjercicio(),isDeep,deepLoadType,clases);
				
		detanotacreditosoli.setPeriodo(detanotacreditosoliDataAccess.getPeriodo(connexion,detanotacreditosoli));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detanotacreditosoli.getPeriodo(),isDeep,deepLoadType,clases);
				
		detanotacreditosoli.setAnio(detanotacreditosoliDataAccess.getAnio(connexion,detanotacreditosoli));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detanotacreditosoli.getAnio(),isDeep,deepLoadType,clases);
				
		detanotacreditosoli.setMes(detanotacreditosoliDataAccess.getMes(connexion,detanotacreditosoli));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detanotacreditosoli.getMes(),isDeep,deepLoadType,clases);
				
		detanotacreditosoli.setNotaCreditoSoli(detanotacreditosoliDataAccess.getNotaCreditoSoli(connexion,detanotacreditosoli));
		NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
		notacreditosoliLogic.deepLoad(detanotacreditosoli.getNotaCreditoSoli(),isDeep,deepLoadType,clases);
				
		detanotacreditosoli.setBodega(detanotacreditosoliDataAccess.getBodega(connexion,detanotacreditosoli));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detanotacreditosoli.getBodega(),isDeep,deepLoadType,clases);
				
		detanotacreditosoli.setProducto(detanotacreditosoliDataAccess.getProducto(connexion,detanotacreditosoli));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detanotacreditosoli.getProducto(),isDeep,deepLoadType,clases);
				
		detanotacreditosoli.setUnidad(detanotacreditosoliDataAccess.getUnidad(connexion,detanotacreditosoli));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detanotacreditosoli.getUnidad(),isDeep,deepLoadType,clases);
				
		detanotacreditosoli.setEmpaque(detanotacreditosoliDataAccess.getEmpaque(connexion,detanotacreditosoli));
		EmpaqueLogic empaqueLogic= new EmpaqueLogic(connexion);
		empaqueLogic.deepLoad(detanotacreditosoli.getEmpaque(),isDeep,deepLoadType,clases);
				
		detanotacreditosoli.setTipoDevolucionEmpresa(detanotacreditosoliDataAccess.getTipoDevolucionEmpresa(connexion,detanotacreditosoli));
		TipoDevolucionEmpresaLogic tipodevolucionempresaLogic= new TipoDevolucionEmpresaLogic(connexion);
		tipodevolucionempresaLogic.deepLoad(detanotacreditosoli.getTipoDevolucionEmpresa(),isDeep,deepLoadType,clases);
				
		detanotacreditosoli.setCentroCosto(detanotacreditosoliDataAccess.getCentroCosto(connexion,detanotacreditosoli));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detanotacreditosoli.getCentroCosto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detanotacreditosoli.setEmpresa(detanotacreditosoliDataAccess.getEmpresa(connexion,detanotacreditosoli));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detanotacreditosoli.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detanotacreditosoli.setSucursal(detanotacreditosoliDataAccess.getSucursal(connexion,detanotacreditosoli));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detanotacreditosoli.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detanotacreditosoli.setEjercicio(detanotacreditosoliDataAccess.getEjercicio(connexion,detanotacreditosoli));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detanotacreditosoli.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detanotacreditosoli.setPeriodo(detanotacreditosoliDataAccess.getPeriodo(connexion,detanotacreditosoli));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detanotacreditosoli.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detanotacreditosoli.setAnio(detanotacreditosoliDataAccess.getAnio(connexion,detanotacreditosoli));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detanotacreditosoli.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detanotacreditosoli.setMes(detanotacreditosoliDataAccess.getMes(connexion,detanotacreditosoli));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detanotacreditosoli.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NotaCreditoSoli.class)) {
				detanotacreditosoli.setNotaCreditoSoli(detanotacreditosoliDataAccess.getNotaCreditoSoli(connexion,detanotacreditosoli));
				NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
				notacreditosoliLogic.deepLoad(detanotacreditosoli.getNotaCreditoSoli(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detanotacreditosoli.setBodega(detanotacreditosoliDataAccess.getBodega(connexion,detanotacreditosoli));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detanotacreditosoli.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detanotacreditosoli.setProducto(detanotacreditosoliDataAccess.getProducto(connexion,detanotacreditosoli));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detanotacreditosoli.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detanotacreditosoli.setUnidad(detanotacreditosoliDataAccess.getUnidad(connexion,detanotacreditosoli));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detanotacreditosoli.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empaque.class)) {
				detanotacreditosoli.setEmpaque(detanotacreditosoliDataAccess.getEmpaque(connexion,detanotacreditosoli));
				EmpaqueLogic empaqueLogic= new EmpaqueLogic(connexion);
				empaqueLogic.deepLoad(detanotacreditosoli.getEmpaque(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDevolucionEmpresa.class)) {
				detanotacreditosoli.setTipoDevolucionEmpresa(detanotacreditosoliDataAccess.getTipoDevolucionEmpresa(connexion,detanotacreditosoli));
				TipoDevolucionEmpresaLogic tipodevolucionempresaLogic= new TipoDevolucionEmpresaLogic(connexion);
				tipodevolucionempresaLogic.deepLoad(detanotacreditosoli.getTipoDevolucionEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detanotacreditosoli.setCentroCosto(detanotacreditosoliDataAccess.getCentroCosto(connexion,detanotacreditosoli));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(detanotacreditosoli.getCentroCosto(),isDeep,deepLoadType,clases);				
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
			detanotacreditosoli.setEmpresa(detanotacreditosoliDataAccess.getEmpresa(connexion,detanotacreditosoli));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detanotacreditosoli.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setSucursal(detanotacreditosoliDataAccess.getSucursal(connexion,detanotacreditosoli));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detanotacreditosoli.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setEjercicio(detanotacreditosoliDataAccess.getEjercicio(connexion,detanotacreditosoli));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detanotacreditosoli.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setPeriodo(detanotacreditosoliDataAccess.getPeriodo(connexion,detanotacreditosoli));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detanotacreditosoli.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setAnio(detanotacreditosoliDataAccess.getAnio(connexion,detanotacreditosoli));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detanotacreditosoli.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setMes(detanotacreditosoliDataAccess.getMes(connexion,detanotacreditosoli));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detanotacreditosoli.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoSoli.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setNotaCreditoSoli(detanotacreditosoliDataAccess.getNotaCreditoSoli(connexion,detanotacreditosoli));
			NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
			notacreditosoliLogic.deepLoad(detanotacreditosoli.getNotaCreditoSoli(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setBodega(detanotacreditosoliDataAccess.getBodega(connexion,detanotacreditosoli));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detanotacreditosoli.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setProducto(detanotacreditosoliDataAccess.getProducto(connexion,detanotacreditosoli));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detanotacreditosoli.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setUnidad(detanotacreditosoliDataAccess.getUnidad(connexion,detanotacreditosoli));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detanotacreditosoli.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empaque.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setEmpaque(detanotacreditosoliDataAccess.getEmpaque(connexion,detanotacreditosoli));
			EmpaqueLogic empaqueLogic= new EmpaqueLogic(connexion);
			empaqueLogic.deepLoad(detanotacreditosoli.getEmpaque(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDevolucionEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setTipoDevolucionEmpresa(detanotacreditosoliDataAccess.getTipoDevolucionEmpresa(connexion,detanotacreditosoli));
			TipoDevolucionEmpresaLogic tipodevolucionempresaLogic= new TipoDevolucionEmpresaLogic(connexion);
			tipodevolucionempresaLogic.deepLoad(detanotacreditosoli.getTipoDevolucionEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detanotacreditosoli.setCentroCosto(detanotacreditosoliDataAccess.getCentroCosto(connexion,detanotacreditosoli));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(detanotacreditosoli.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetaNotaCreditoSoli detanotacreditosoli,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetaNotaCreditoSoliLogicAdditional.updateDetaNotaCreditoSoliToSave(detanotacreditosoli,this.arrDatoGeneral);
			
DetaNotaCreditoSoliDataAccess.save(detanotacreditosoli, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detanotacreditosoli.getEmpresa(),connexion);

		SucursalDataAccess.save(detanotacreditosoli.getSucursal(),connexion);

		EjercicioDataAccess.save(detanotacreditosoli.getEjercicio(),connexion);

		PeriodoDataAccess.save(detanotacreditosoli.getPeriodo(),connexion);

		AnioDataAccess.save(detanotacreditosoli.getAnio(),connexion);

		MesDataAccess.save(detanotacreditosoli.getMes(),connexion);

		NotaCreditoSoliDataAccess.save(detanotacreditosoli.getNotaCreditoSoli(),connexion);

		BodegaDataAccess.save(detanotacreditosoli.getBodega(),connexion);

		ProductoDataAccess.save(detanotacreditosoli.getProducto(),connexion);

		UnidadDataAccess.save(detanotacreditosoli.getUnidad(),connexion);

		EmpaqueDataAccess.save(detanotacreditosoli.getEmpaque(),connexion);

		TipoDevolucionEmpresaDataAccess.save(detanotacreditosoli.getTipoDevolucionEmpresa(),connexion);

		CentroCostoDataAccess.save(detanotacreditosoli.getCentroCosto(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detanotacreditosoli.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detanotacreditosoli.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detanotacreditosoli.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detanotacreditosoli.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detanotacreditosoli.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detanotacreditosoli.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(NotaCreditoSoli.class)) {
				NotaCreditoSoliDataAccess.save(detanotacreditosoli.getNotaCreditoSoli(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detanotacreditosoli.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detanotacreditosoli.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detanotacreditosoli.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(Empaque.class)) {
				EmpaqueDataAccess.save(detanotacreditosoli.getEmpaque(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDevolucionEmpresa.class)) {
				TipoDevolucionEmpresaDataAccess.save(detanotacreditosoli.getTipoDevolucionEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detanotacreditosoli.getCentroCosto(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detanotacreditosoli.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detanotacreditosoli.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detanotacreditosoli.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detanotacreditosoli.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detanotacreditosoli.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detanotacreditosoli.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detanotacreditosoli.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detanotacreditosoli.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detanotacreditosoli.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detanotacreditosoli.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detanotacreditosoli.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detanotacreditosoli.getMes(),isDeep,deepLoadType,clases);
				

		NotaCreditoSoliDataAccess.save(detanotacreditosoli.getNotaCreditoSoli(),connexion);
		NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
		notacreditosoliLogic.deepLoad(detanotacreditosoli.getNotaCreditoSoli(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detanotacreditosoli.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detanotacreditosoli.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detanotacreditosoli.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detanotacreditosoli.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detanotacreditosoli.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detanotacreditosoli.getUnidad(),isDeep,deepLoadType,clases);
				

		EmpaqueDataAccess.save(detanotacreditosoli.getEmpaque(),connexion);
		EmpaqueLogic empaqueLogic= new EmpaqueLogic(connexion);
		empaqueLogic.deepLoad(detanotacreditosoli.getEmpaque(),isDeep,deepLoadType,clases);
				

		TipoDevolucionEmpresaDataAccess.save(detanotacreditosoli.getTipoDevolucionEmpresa(),connexion);
		TipoDevolucionEmpresaLogic tipodevolucionempresaLogic= new TipoDevolucionEmpresaLogic(connexion);
		tipodevolucionempresaLogic.deepLoad(detanotacreditosoli.getTipoDevolucionEmpresa(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(detanotacreditosoli.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detanotacreditosoli.getCentroCosto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detanotacreditosoli.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detanotacreditosoli.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detanotacreditosoli.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detanotacreditosoli.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detanotacreditosoli.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detanotacreditosoli.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detanotacreditosoli.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detanotacreditosoli.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detanotacreditosoli.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detanotacreditosoli.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detanotacreditosoli.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detanotacreditosoli.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NotaCreditoSoli.class)) {
				NotaCreditoSoliDataAccess.save(detanotacreditosoli.getNotaCreditoSoli(),connexion);
				NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
				notacreditosoliLogic.deepSave(detanotacreditosoli.getNotaCreditoSoli(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detanotacreditosoli.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detanotacreditosoli.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detanotacreditosoli.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detanotacreditosoli.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detanotacreditosoli.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detanotacreditosoli.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empaque.class)) {
				EmpaqueDataAccess.save(detanotacreditosoli.getEmpaque(),connexion);
				EmpaqueLogic empaqueLogic= new EmpaqueLogic(connexion);
				empaqueLogic.deepSave(detanotacreditosoli.getEmpaque(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDevolucionEmpresa.class)) {
				TipoDevolucionEmpresaDataAccess.save(detanotacreditosoli.getTipoDevolucionEmpresa(),connexion);
				TipoDevolucionEmpresaLogic tipodevolucionempresaLogic= new TipoDevolucionEmpresaLogic(connexion);
				tipodevolucionempresaLogic.deepSave(detanotacreditosoli.getTipoDevolucionEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detanotacreditosoli.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(detanotacreditosoli.getCentroCosto(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetaNotaCreditoSoli.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detanotacreditosoli,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(detanotacreditosoli);
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
			this.deepLoad(this.detanotacreditosoli,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosoli);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetaNotaCreditoSoli.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detanotacreditosolis!=null) {
				for(DetaNotaCreditoSoli detanotacreditosoli:detanotacreditosolis) {
					this.deepLoad(detanotacreditosoli,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(detanotacreditosolis);
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
			if(detanotacreditosolis!=null) {
				for(DetaNotaCreditoSoli detanotacreditosoli:detanotacreditosolis) {
					this.deepLoad(detanotacreditosoli,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(detanotacreditosolis);
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
			this.getNewConnexionToDeep(DetaNotaCreditoSoli.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detanotacreditosoli,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetaNotaCreditoSoli.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detanotacreditosolis!=null) {
				for(DetaNotaCreditoSoli detanotacreditosoli:detanotacreditosolis) {
					this.deepSave(detanotacreditosoli,isDeep,deepLoadType,clases);
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
			if(detanotacreditosolis!=null) {
				for(DetaNotaCreditoSoli detanotacreditosoli:detanotacreditosolis) {
					this.deepSave(detanotacreditosoli,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetaNotaCreditoSolisFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetaNotaCreditoSoliConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditoSolisFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetaNotaCreditoSoliConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditoSolisFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetaNotaCreditoSoliConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditoSolisFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetaNotaCreditoSoliConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditoSolisFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetaNotaCreditoSoliConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditoSolisFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetaNotaCreditoSoliConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditoSolisFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetaNotaCreditoSoliConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditoSolisFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetaNotaCreditoSoliConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditoSolisFK_IdEmpaqueWithConnection(String sFinalQuery,Pagination pagination,Long id_empaque)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpaque= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpaque.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empaque,DetaNotaCreditoSoliConstantesFunciones.IDEMPAQUE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpaque);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpaque","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditoSolisFK_IdEmpaque(String sFinalQuery,Pagination pagination,Long id_empaque)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpaque= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpaque.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empaque,DetaNotaCreditoSoliConstantesFunciones.IDEMPAQUE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpaque);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpaque","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditoSolisFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetaNotaCreditoSoliConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditoSolisFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetaNotaCreditoSoliConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditoSolisFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetaNotaCreditoSoliConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditoSolisFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetaNotaCreditoSoliConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditoSolisFK_IdNotaCreditoSoliWithConnection(String sFinalQuery,Pagination pagination,Long id_nota_credito_soli)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNotaCreditoSoli= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNotaCreditoSoli.setParameterSelectionGeneralEqual(ParameterType.LONG,id_nota_credito_soli,DetaNotaCreditoSoliConstantesFunciones.IDNOTACREDITOSOLI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNotaCreditoSoli);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNotaCreditoSoli","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditoSolisFK_IdNotaCreditoSoli(String sFinalQuery,Pagination pagination,Long id_nota_credito_soli)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNotaCreditoSoli= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNotaCreditoSoli.setParameterSelectionGeneralEqual(ParameterType.LONG,id_nota_credito_soli,DetaNotaCreditoSoliConstantesFunciones.IDNOTACREDITOSOLI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNotaCreditoSoli);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNotaCreditoSoli","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditoSolisFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetaNotaCreditoSoliConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditoSolisFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetaNotaCreditoSoliConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditoSolisFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetaNotaCreditoSoliConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditoSolisFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetaNotaCreditoSoliConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditoSolisFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetaNotaCreditoSoliConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditoSolisFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetaNotaCreditoSoliConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditoSolisFK_IdTipoDevolucionEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_devolucion_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDevolucionEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDevolucionEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_devolucion_empresa,DetaNotaCreditoSoliConstantesFunciones.IDTIPODEVOLUCIONEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDevolucionEmpresa);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDevolucionEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditoSolisFK_IdTipoDevolucionEmpresa(String sFinalQuery,Pagination pagination,Long id_tipo_devolucion_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDevolucionEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDevolucionEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_devolucion_empresa,DetaNotaCreditoSoliConstantesFunciones.IDTIPODEVOLUCIONEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDevolucionEmpresa);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDevolucionEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaNotaCreditoSolisFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaNotaCreditoSoli.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetaNotaCreditoSoliConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaNotaCreditoSolisFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetaNotaCreditoSoliConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetaNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detanotacreditosolis=detanotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(this.detanotacreditosolis);
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
			if(DetaNotaCreditoSoliConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetaNotaCreditoSoliDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetaNotaCreditoSoli detanotacreditosoli,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetaNotaCreditoSoliConstantesFunciones.ISCONAUDITORIA) {
				if(detanotacreditosoli.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetaNotaCreditoSoliDataAccess.TABLENAME, detanotacreditosoli.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetaNotaCreditoSoliConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetaNotaCreditoSoliLogic.registrarAuditoriaDetallesDetaNotaCreditoSoli(connexion,detanotacreditosoli,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detanotacreditosoli.getIsDeleted()) {
					/*if(!detanotacreditosoli.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetaNotaCreditoSoliDataAccess.TABLENAME, detanotacreditosoli.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetaNotaCreditoSoliLogic.registrarAuditoriaDetallesDetaNotaCreditoSoli(connexion,detanotacreditosoli,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetaNotaCreditoSoliDataAccess.TABLENAME, detanotacreditosoli.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detanotacreditosoli.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetaNotaCreditoSoliDataAccess.TABLENAME, detanotacreditosoli.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetaNotaCreditoSoliConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetaNotaCreditoSoliLogic.registrarAuditoriaDetallesDetaNotaCreditoSoli(connexion,detanotacreditosoli,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetaNotaCreditoSoli(Connexion connexion,DetaNotaCreditoSoli detanotacreditosoli)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getid_empresa().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_empresa()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_empresa().toString();
				}
				if(detanotacreditosoli.getid_empresa()!=null)
				{
					strValorNuevo=detanotacreditosoli.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getid_sucursal().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_sucursal()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_sucursal().toString();
				}
				if(detanotacreditosoli.getid_sucursal()!=null)
				{
					strValorNuevo=detanotacreditosoli.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getid_ejercicio().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_ejercicio().toString();
				}
				if(detanotacreditosoli.getid_ejercicio()!=null)
				{
					strValorNuevo=detanotacreditosoli.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getid_periodo().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_periodo()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_periodo().toString();
				}
				if(detanotacreditosoli.getid_periodo()!=null)
				{
					strValorNuevo=detanotacreditosoli.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getid_anio().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_anio()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_anio().toString();
				}
				if(detanotacreditosoli.getid_anio()!=null)
				{
					strValorNuevo=detanotacreditosoli.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getid_mes().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_mes()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_mes().toString();
				}
				if(detanotacreditosoli.getid_mes()!=null)
				{
					strValorNuevo=detanotacreditosoli.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getid_nota_credito_soli().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_nota_credito_soli()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_nota_credito_soli()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_nota_credito_soli().toString();
				}
				if(detanotacreditosoli.getid_nota_credito_soli()!=null)
				{
					strValorNuevo=detanotacreditosoli.getid_nota_credito_soli().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.IDNOTACREDITOSOLI,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getid_bodega().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_bodega()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_bodega().toString();
				}
				if(detanotacreditosoli.getid_bodega()!=null)
				{
					strValorNuevo=detanotacreditosoli.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getid_producto().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_producto()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_producto().toString();
				}
				if(detanotacreditosoli.getid_producto()!=null)
				{
					strValorNuevo=detanotacreditosoli.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getid_unidad().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_unidad()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_unidad().toString();
				}
				if(detanotacreditosoli.getid_unidad()!=null)
				{
					strValorNuevo=detanotacreditosoli.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getid_empaque().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_empaque()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_empaque()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_empaque().toString();
				}
				if(detanotacreditosoli.getid_empaque()!=null)
				{
					strValorNuevo=detanotacreditosoli.getid_empaque().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.IDEMPAQUE,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getid_tipo_devolucion_empresa().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_tipo_devolucion_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_tipo_devolucion_empresa()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_tipo_devolucion_empresa().toString();
				}
				if(detanotacreditosoli.getid_tipo_devolucion_empresa()!=null)
				{
					strValorNuevo=detanotacreditosoli.getid_tipo_devolucion_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.IDTIPODEVOLUCIONEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getid_centro_costo().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_centro_costo()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getid_centro_costo().toString();
				}
				if(detanotacreditosoli.getid_centro_costo()!=null)
				{
					strValorNuevo=detanotacreditosoli.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getcantidad().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getcantidad()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getcantidad().toString();
				}
				if(detanotacreditosoli.getcantidad()!=null)
				{
					strValorNuevo=detanotacreditosoli.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getprecio().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getprecio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getprecio()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getprecio().toString();
				}
				if(detanotacreditosoli.getprecio()!=null)
				{
					strValorNuevo=detanotacreditosoli.getprecio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.PRECIO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getporcen_descuen().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getporcen_descuen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getporcen_descuen()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getporcen_descuen().toString();
				}
				if(detanotacreditosoli.getporcen_descuen()!=null)
				{
					strValorNuevo=detanotacreditosoli.getporcen_descuen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.PORCENDESCUEN,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getdescuento().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getdescuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getdescuento()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getdescuento().toString();
				}
				if(detanotacreditosoli.getdescuento()!=null)
				{
					strValorNuevo=detanotacreditosoli.getdescuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.DESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getimpuesto().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getimpuesto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getimpuesto()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getimpuesto().toString();
				}
				if(detanotacreditosoli.getimpuesto()!=null)
				{
					strValorNuevo=detanotacreditosoli.getimpuesto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.IMPUESTO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getporcen_iva().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getporcen_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getporcen_iva()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getporcen_iva().toString();
				}
				if(detanotacreditosoli.getporcen_iva()!=null)
				{
					strValorNuevo=detanotacreditosoli.getporcen_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.PORCENIVA,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.gettotal().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().gettotal()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().gettotal().toString();
				}
				if(detanotacreditosoli.gettotal()!=null)
				{
					strValorNuevo=detanotacreditosoli.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getdescripcion().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getdescripcion()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getdescripcion();
				}
				if(detanotacreditosoli.getdescripcion()!=null)
				{
					strValorNuevo=detanotacreditosoli.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getcodigo_lote().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getcodigo_lote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getcodigo_lote()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getcodigo_lote();
				}
				if(detanotacreditosoli.getcodigo_lote()!=null)
				{
					strValorNuevo=detanotacreditosoli.getcodigo_lote() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.CODIGOLOTE,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getnumero_caja().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getnumero_caja()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getnumero_caja()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getnumero_caja();
				}
				if(detanotacreditosoli.getnumero_caja()!=null)
				{
					strValorNuevo=detanotacreditosoli.getnumero_caja() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.NUMEROCAJA,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getdescuento2().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getdescuento2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getdescuento2()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getdescuento2().toString();
				}
				if(detanotacreditosoli.getdescuento2()!=null)
				{
					strValorNuevo=detanotacreditosoli.getdescuento2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.DESCUENTO2,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getcosto().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getcosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getcosto()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getcosto().toString();
				}
				if(detanotacreditosoli.getcosto()!=null)
				{
					strValorNuevo=detanotacreditosoli.getcosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.COSTO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getincluye_impuesto().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getincluye_impuesto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getincluye_impuesto()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getincluye_impuesto().toString();
				}
				if(detanotacreditosoli.getincluye_impuesto()!=null)
				{
					strValorNuevo=detanotacreditosoli.getincluye_impuesto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.INCLUYEIMPUESTO,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getporcen_ice().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getporcen_ice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getporcen_ice()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getporcen_ice().toString();
				}
				if(detanotacreditosoli.getporcen_ice()!=null)
				{
					strValorNuevo=detanotacreditosoli.getporcen_ice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.PORCENICE,strValorActual,strValorNuevo);
			}	
			
			if(detanotacreditosoli.getIsNew()||!detanotacreditosoli.getfecha_emision().equals(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getfecha_emision()!=null)
				{
					strValorActual=detanotacreditosoli.getDetaNotaCreditoSoliOriginal().getfecha_emision().toString();
				}
				if(detanotacreditosoli.getfecha_emision()!=null)
				{
					strValorNuevo=detanotacreditosoli.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaNotaCreditoSoliConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetaNotaCreditoSoliRelacionesWithConnection(DetaNotaCreditoSoli detanotacreditosoli) throws Exception {

		if(!detanotacreditosoli.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetaNotaCreditoSoliRelacionesBase(detanotacreditosoli,true);
		}
	}

	public void saveDetaNotaCreditoSoliRelaciones(DetaNotaCreditoSoli detanotacreditosoli)throws Exception {

		if(!detanotacreditosoli.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetaNotaCreditoSoliRelacionesBase(detanotacreditosoli,false);
		}
	}

	public void saveDetaNotaCreditoSoliRelacionesBase(DetaNotaCreditoSoli detanotacreditosoli,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetaNotaCreditoSoli-saveRelacionesWithConnection");}
	

			this.setDetaNotaCreditoSoli(detanotacreditosoli);

			if(DetaNotaCreditoSoliLogicAdditional.validarSaveRelaciones(detanotacreditosoli,this)) {

				DetaNotaCreditoSoliLogicAdditional.updateRelacionesToSave(detanotacreditosoli,this);

				if((detanotacreditosoli.getIsNew()||detanotacreditosoli.getIsChanged())&&!detanotacreditosoli.getIsDeleted()) {
					this.saveDetaNotaCreditoSoli();
					this.saveDetaNotaCreditoSoliRelacionesDetalles();

				} else if(detanotacreditosoli.getIsDeleted()) {
					this.saveDetaNotaCreditoSoliRelacionesDetalles();
					this.saveDetaNotaCreditoSoli();
				}

				DetaNotaCreditoSoliLogicAdditional.updateRelacionesToSaveAfter(detanotacreditosoli,this);

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
	
	
	private void saveDetaNotaCreditoSoliRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetaNotaCreditoSoli(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetaNotaCreditoSoliConstantesFunciones.getClassesForeignKeysOfDetaNotaCreditoSoli(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetaNotaCreditoSoli(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetaNotaCreditoSoliConstantesFunciones.getClassesRelationshipsOfDetaNotaCreditoSoli(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

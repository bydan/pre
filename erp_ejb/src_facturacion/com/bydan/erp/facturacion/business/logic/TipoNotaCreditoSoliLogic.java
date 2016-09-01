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
import com.bydan.erp.facturacion.util.TipoNotaCreditoSoliConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoNotaCreditoSoliParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoNotaCreditoSoliParameterGeneral;
import com.bydan.erp.facturacion.business.entity.TipoNotaCreditoSoli;
import com.bydan.erp.facturacion.business.logic.TipoNotaCreditoSoliLogicAdditional;
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
public class TipoNotaCreditoSoliLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoNotaCreditoSoliLogic.class);
	
	protected TipoNotaCreditoSoliDataAccess tiponotacreditosoliDataAccess; 	
	protected TipoNotaCreditoSoli tiponotacreditosoli;
	protected List<TipoNotaCreditoSoli> tiponotacreditosolis;
	protected Object tiponotacreditosoliObject;	
	protected List<Object> tiponotacreditosolisObject;
	
	public static ClassValidator<TipoNotaCreditoSoli> tiponotacreditosoliValidator = new ClassValidator<TipoNotaCreditoSoli>(TipoNotaCreditoSoli.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoNotaCreditoSoliLogicAdditional tiponotacreditosoliLogicAdditional=null;
	
	public TipoNotaCreditoSoliLogicAdditional getTipoNotaCreditoSoliLogicAdditional() {
		return this.tiponotacreditosoliLogicAdditional;
	}
	
	public void setTipoNotaCreditoSoliLogicAdditional(TipoNotaCreditoSoliLogicAdditional tiponotacreditosoliLogicAdditional) {
		try {
			this.tiponotacreditosoliLogicAdditional=tiponotacreditosoliLogicAdditional;
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
	
	
	
	
	public  TipoNotaCreditoSoliLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tiponotacreditosoliDataAccess = new TipoNotaCreditoSoliDataAccess();
			
			this.tiponotacreditosolis= new ArrayList<TipoNotaCreditoSoli>();
			this.tiponotacreditosoli= new TipoNotaCreditoSoli();
			
			this.tiponotacreditosoliObject=new Object();
			this.tiponotacreditosolisObject=new ArrayList<Object>();
				
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
			
			this.tiponotacreditosoliDataAccess.setConnexionType(this.connexionType);
			this.tiponotacreditosoliDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoNotaCreditoSoliLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tiponotacreditosoliDataAccess = new TipoNotaCreditoSoliDataAccess();
			this.tiponotacreditosolis= new ArrayList<TipoNotaCreditoSoli>();
			this.tiponotacreditosoli= new TipoNotaCreditoSoli();
			this.tiponotacreditosoliObject=new Object();
			this.tiponotacreditosolisObject=new ArrayList<Object>();
			
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
			
			this.tiponotacreditosoliDataAccess.setConnexionType(this.connexionType);
			this.tiponotacreditosoliDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoNotaCreditoSoli getTipoNotaCreditoSoli() throws Exception {	
		TipoNotaCreditoSoliLogicAdditional.checkTipoNotaCreditoSoliToGet(tiponotacreditosoli,this.datosCliente,this.arrDatoGeneral);
		TipoNotaCreditoSoliLogicAdditional.updateTipoNotaCreditoSoliToGet(tiponotacreditosoli,this.arrDatoGeneral);
		
		return tiponotacreditosoli;
	}
		
	public void setTipoNotaCreditoSoli(TipoNotaCreditoSoli newTipoNotaCreditoSoli) {
		this.tiponotacreditosoli = newTipoNotaCreditoSoli;
	}
	
	public TipoNotaCreditoSoliDataAccess getTipoNotaCreditoSoliDataAccess() {
		return tiponotacreditosoliDataAccess;
	}
	
	public void setTipoNotaCreditoSoliDataAccess(TipoNotaCreditoSoliDataAccess newtiponotacreditosoliDataAccess) {
		this.tiponotacreditosoliDataAccess = newtiponotacreditosoliDataAccess;
	}
	
	public List<TipoNotaCreditoSoli> getTipoNotaCreditoSolis() throws Exception {		
		this.quitarTipoNotaCreditoSolisNulos();
		
		TipoNotaCreditoSoliLogicAdditional.checkTipoNotaCreditoSoliToGets(tiponotacreditosolis,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoNotaCreditoSoli tiponotacreditosoliLocal: tiponotacreditosolis ) {
			TipoNotaCreditoSoliLogicAdditional.updateTipoNotaCreditoSoliToGet(tiponotacreditosoliLocal,this.arrDatoGeneral);
		}
		
		return tiponotacreditosolis;
	}
	
	public void setTipoNotaCreditoSolis(List<TipoNotaCreditoSoli> newTipoNotaCreditoSolis) {
		this.tiponotacreditosolis = newTipoNotaCreditoSolis;
	}
	
	public Object getTipoNotaCreditoSoliObject() {	
		this.tiponotacreditosoliObject=this.tiponotacreditosoliDataAccess.getEntityObject();
		return this.tiponotacreditosoliObject;
	}
		
	public void setTipoNotaCreditoSoliObject(Object newTipoNotaCreditoSoliObject) {
		this.tiponotacreditosoliObject = newTipoNotaCreditoSoliObject;
	}
	
	public List<Object> getTipoNotaCreditoSolisObject() {		
		this.tiponotacreditosolisObject=this.tiponotacreditosoliDataAccess.getEntitiesObject();
		return this.tiponotacreditosolisObject;
	}
		
	public void setTipoNotaCreditoSolisObject(List<Object> newTipoNotaCreditoSolisObject) {
		this.tiponotacreditosolisObject = newTipoNotaCreditoSolisObject;
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
		
		if(this.tiponotacreditosoliDataAccess!=null) {
			this.tiponotacreditosoliDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNotaCreditoSoli.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tiponotacreditosoliDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tiponotacreditosoliDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tiponotacreditosoli = new  TipoNotaCreditoSoli();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNotaCreditoSoli.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiponotacreditosoli=tiponotacreditosoliDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiponotacreditosoli,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesTipoNotaCreditoSoli(this.tiponotacreditosoli);
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
		tiponotacreditosoli = new  TipoNotaCreditoSoli();
		  		  
        try {
			
			tiponotacreditosoli=tiponotacreditosoliDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiponotacreditosoli,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesTipoNotaCreditoSoli(this.tiponotacreditosoli);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tiponotacreditosoli = new  TipoNotaCreditoSoli();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNotaCreditoSoli.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiponotacreditosoli=tiponotacreditosoliDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiponotacreditosoli,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesTipoNotaCreditoSoli(this.tiponotacreditosoli);
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
		tiponotacreditosoli = new  TipoNotaCreditoSoli();
		  		  
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
		tiponotacreditosoli = new  TipoNotaCreditoSoli();
		  		  
        try {
			
			tiponotacreditosoli=tiponotacreditosoliDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiponotacreditosoli,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesTipoNotaCreditoSoli(this.tiponotacreditosoli);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tiponotacreditosoli = new  TipoNotaCreditoSoli();
		  		  
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
		tiponotacreditosoli = new  TipoNotaCreditoSoli();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNotaCreditoSoli.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tiponotacreditosoliDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiponotacreditosoli = new  TipoNotaCreditoSoli();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tiponotacreditosoliDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiponotacreditosoli = new  TipoNotaCreditoSoli();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNotaCreditoSoli.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tiponotacreditosoliDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiponotacreditosoli = new  TipoNotaCreditoSoli();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tiponotacreditosoliDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiponotacreditosoli = new  TipoNotaCreditoSoli();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNotaCreditoSoli.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tiponotacreditosoliDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiponotacreditosoli = new  TipoNotaCreditoSoli();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tiponotacreditosoliDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiponotacreditosolis = new  ArrayList<TipoNotaCreditoSoli>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNotaCreditoSoli.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponotacreditosolis=tiponotacreditosoliDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoNotaCreditoSoli(tiponotacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesTipoNotaCreditoSoli(this.tiponotacreditosolis);
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
		tiponotacreditosolis = new  ArrayList<TipoNotaCreditoSoli>();
		  		  
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
		tiponotacreditosolis = new  ArrayList<TipoNotaCreditoSoli>();
		  		  
        try {			
			TipoNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponotacreditosolis=tiponotacreditosoliDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoNotaCreditoSoli(tiponotacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesTipoNotaCreditoSoli(this.tiponotacreditosolis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tiponotacreditosolis = new  ArrayList<TipoNotaCreditoSoli>();
		  		  
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
		tiponotacreditosolis = new  ArrayList<TipoNotaCreditoSoli>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNotaCreditoSoli.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponotacreditosolis=tiponotacreditosoliDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoNotaCreditoSoli(tiponotacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesTipoNotaCreditoSoli(this.tiponotacreditosolis);
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
		tiponotacreditosolis = new  ArrayList<TipoNotaCreditoSoli>();
		  		  
        try {
			TipoNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponotacreditosolis=tiponotacreditosoliDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoNotaCreditoSoli(tiponotacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesTipoNotaCreditoSoli(this.tiponotacreditosolis);
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
		tiponotacreditosolis = new  ArrayList<TipoNotaCreditoSoli>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNotaCreditoSoli.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponotacreditosolis=tiponotacreditosoliDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoNotaCreditoSoli(tiponotacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesTipoNotaCreditoSoli(this.tiponotacreditosolis);
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
		tiponotacreditosolis = new  ArrayList<TipoNotaCreditoSoli>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponotacreditosolis=tiponotacreditosoliDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoNotaCreditoSoli(tiponotacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesTipoNotaCreditoSoli(this.tiponotacreditosolis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tiponotacreditosoli = new  TipoNotaCreditoSoli();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNotaCreditoSoli.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponotacreditosoli=tiponotacreditosoliDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoNotaCreditoSoli(tiponotacreditosoli);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesTipoNotaCreditoSoli(this.tiponotacreditosoli);
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
		tiponotacreditosoli = new  TipoNotaCreditoSoli();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponotacreditosoli=tiponotacreditosoliDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoNotaCreditoSoli(tiponotacreditosoli);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesTipoNotaCreditoSoli(this.tiponotacreditosoli);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiponotacreditosolis = new  ArrayList<TipoNotaCreditoSoli>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNotaCreditoSoli.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponotacreditosolis=tiponotacreditosoliDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoNotaCreditoSoli(tiponotacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesTipoNotaCreditoSoli(this.tiponotacreditosolis);
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
		tiponotacreditosolis = new  ArrayList<TipoNotaCreditoSoli>();
		  		  
        try {
			TipoNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponotacreditosolis=tiponotacreditosoliDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoNotaCreditoSoli(tiponotacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesTipoNotaCreditoSoli(this.tiponotacreditosolis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoNotaCreditoSolisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tiponotacreditosolis = new  ArrayList<TipoNotaCreditoSoli>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNotaCreditoSoli.class.getSimpleName()+"-getTodosTipoNotaCreditoSolisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponotacreditosolis=tiponotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoNotaCreditoSoli(tiponotacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesTipoNotaCreditoSoli(this.tiponotacreditosolis);
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
	
	public  void  getTodosTipoNotaCreditoSolis(String sFinalQuery,Pagination pagination)throws Exception {
		tiponotacreditosolis = new  ArrayList<TipoNotaCreditoSoli>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiponotacreditosolis=tiponotacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoNotaCreditoSoli(tiponotacreditosolis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesTipoNotaCreditoSoli(this.tiponotacreditosolis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoNotaCreditoSoli(TipoNotaCreditoSoli tiponotacreditosoli) throws Exception {
		Boolean estaValidado=false;
		
		if(tiponotacreditosoli.getIsNew() || tiponotacreditosoli.getIsChanged()) { 
			this.invalidValues = tiponotacreditosoliValidator.getInvalidValues(tiponotacreditosoli);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tiponotacreditosoli);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoNotaCreditoSoli(List<TipoNotaCreditoSoli> TipoNotaCreditoSolis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoNotaCreditoSoli tiponotacreditosoliLocal:tiponotacreditosolis) {				
			estaValidadoObjeto=this.validarGuardarTipoNotaCreditoSoli(tiponotacreditosoliLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoNotaCreditoSoli(List<TipoNotaCreditoSoli> TipoNotaCreditoSolis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoNotaCreditoSoli(tiponotacreditosolis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoNotaCreditoSoli(TipoNotaCreditoSoli TipoNotaCreditoSoli) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoNotaCreditoSoli(tiponotacreditosoli)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoNotaCreditoSoli tiponotacreditosoli) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tiponotacreditosoli.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoNotaCreditoSoliConstantesFunciones.getTipoNotaCreditoSoliLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tiponotacreditosoli","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoNotaCreditoSoliConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoNotaCreditoSoliConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoNotaCreditoSoliWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNotaCreditoSoli.class.getSimpleName()+"-saveTipoNotaCreditoSoliWithConnection");connexion.begin();			
			
			TipoNotaCreditoSoliLogicAdditional.checkTipoNotaCreditoSoliToSave(this.tiponotacreditosoli,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoNotaCreditoSoliLogicAdditional.updateTipoNotaCreditoSoliToSave(this.tiponotacreditosoli,this.arrDatoGeneral);
			
			TipoNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiponotacreditosoli,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoNotaCreditoSoli();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoNotaCreditoSoli(this.tiponotacreditosoli)) {
				TipoNotaCreditoSoliDataAccess.save(this.tiponotacreditosoli, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tiponotacreditosoli,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoNotaCreditoSoliLogicAdditional.checkTipoNotaCreditoSoliToSaveAfter(this.tiponotacreditosoli,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoNotaCreditoSoli();
			
			connexion.commit();			
			
			if(this.tiponotacreditosoli.getIsDeleted()) {
				this.tiponotacreditosoli=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoNotaCreditoSoli()throws Exception {	
		try {	
			
			TipoNotaCreditoSoliLogicAdditional.checkTipoNotaCreditoSoliToSave(this.tiponotacreditosoli,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoNotaCreditoSoliLogicAdditional.updateTipoNotaCreditoSoliToSave(this.tiponotacreditosoli,this.arrDatoGeneral);
			
			TipoNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiponotacreditosoli,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoNotaCreditoSoli(this.tiponotacreditosoli)) {			
				TipoNotaCreditoSoliDataAccess.save(this.tiponotacreditosoli, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tiponotacreditosoli,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoNotaCreditoSoliLogicAdditional.checkTipoNotaCreditoSoliToSaveAfter(this.tiponotacreditosoli,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tiponotacreditosoli.getIsDeleted()) {
				this.tiponotacreditosoli=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoNotaCreditoSolisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNotaCreditoSoli.class.getSimpleName()+"-saveTipoNotaCreditoSolisWithConnection");connexion.begin();			
			
			TipoNotaCreditoSoliLogicAdditional.checkTipoNotaCreditoSoliToSaves(tiponotacreditosolis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoNotaCreditoSolis();
			
			Boolean validadoTodosTipoNotaCreditoSoli=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoNotaCreditoSoli tiponotacreditosoliLocal:tiponotacreditosolis) {		
				if(tiponotacreditosoliLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoNotaCreditoSoliLogicAdditional.updateTipoNotaCreditoSoliToSave(tiponotacreditosoliLocal,this.arrDatoGeneral);
	        	
				TipoNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiponotacreditosoliLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoNotaCreditoSoli(tiponotacreditosoliLocal)) {
					TipoNotaCreditoSoliDataAccess.save(tiponotacreditosoliLocal, connexion);				
				} else {
					validadoTodosTipoNotaCreditoSoli=false;
				}
			}
			
			if(!validadoTodosTipoNotaCreditoSoli) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoNotaCreditoSoliLogicAdditional.checkTipoNotaCreditoSoliToSavesAfter(tiponotacreditosolis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoNotaCreditoSolis();
			
			connexion.commit();		
			
			this.quitarTipoNotaCreditoSolisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoNotaCreditoSolis()throws Exception {				
		 try {	
			TipoNotaCreditoSoliLogicAdditional.checkTipoNotaCreditoSoliToSaves(tiponotacreditosolis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoNotaCreditoSoli=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoNotaCreditoSoli tiponotacreditosoliLocal:tiponotacreditosolis) {				
				if(tiponotacreditosoliLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoNotaCreditoSoliLogicAdditional.updateTipoNotaCreditoSoliToSave(tiponotacreditosoliLocal,this.arrDatoGeneral);
	        	
				TipoNotaCreditoSoliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiponotacreditosoliLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoNotaCreditoSoli(tiponotacreditosoliLocal)) {				
					TipoNotaCreditoSoliDataAccess.save(tiponotacreditosoliLocal, connexion);				
				} else {
					validadoTodosTipoNotaCreditoSoli=false;
				}
			}
			
			if(!validadoTodosTipoNotaCreditoSoli) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoNotaCreditoSoliLogicAdditional.checkTipoNotaCreditoSoliToSavesAfter(tiponotacreditosolis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoNotaCreditoSolisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoNotaCreditoSoliParameterReturnGeneral procesarAccionTipoNotaCreditoSolis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoNotaCreditoSoli> tiponotacreditosolis,TipoNotaCreditoSoliParameterReturnGeneral tiponotacreditosoliParameterGeneral)throws Exception {
		 try {	
			TipoNotaCreditoSoliParameterReturnGeneral tiponotacreditosoliReturnGeneral=new TipoNotaCreditoSoliParameterReturnGeneral();
	
			TipoNotaCreditoSoliLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiponotacreditosolis,tiponotacreditosoliParameterGeneral,tiponotacreditosoliReturnGeneral);
			
			return tiponotacreditosoliReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoNotaCreditoSoliParameterReturnGeneral procesarAccionTipoNotaCreditoSolisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoNotaCreditoSoli> tiponotacreditosolis,TipoNotaCreditoSoliParameterReturnGeneral tiponotacreditosoliParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNotaCreditoSoli.class.getSimpleName()+"-procesarAccionTipoNotaCreditoSolisWithConnection");connexion.begin();			
			
			TipoNotaCreditoSoliParameterReturnGeneral tiponotacreditosoliReturnGeneral=new TipoNotaCreditoSoliParameterReturnGeneral();
	
			TipoNotaCreditoSoliLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiponotacreditosolis,tiponotacreditosoliParameterGeneral,tiponotacreditosoliReturnGeneral);
			
			this.connexion.commit();
			
			return tiponotacreditosoliReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoNotaCreditoSoliParameterReturnGeneral procesarEventosTipoNotaCreditoSolis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoNotaCreditoSoli> tiponotacreditosolis,TipoNotaCreditoSoli tiponotacreditosoli,TipoNotaCreditoSoliParameterReturnGeneral tiponotacreditosoliParameterGeneral,Boolean isEsNuevoTipoNotaCreditoSoli,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoNotaCreditoSoliParameterReturnGeneral tiponotacreditosoliReturnGeneral=new TipoNotaCreditoSoliParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiponotacreditosoliReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoNotaCreditoSoliLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiponotacreditosolis,tiponotacreditosoli,tiponotacreditosoliParameterGeneral,tiponotacreditosoliReturnGeneral,isEsNuevoTipoNotaCreditoSoli,clases);
			
			return tiponotacreditosoliReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoNotaCreditoSoliParameterReturnGeneral procesarEventosTipoNotaCreditoSolisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoNotaCreditoSoli> tiponotacreditosolis,TipoNotaCreditoSoli tiponotacreditosoli,TipoNotaCreditoSoliParameterReturnGeneral tiponotacreditosoliParameterGeneral,Boolean isEsNuevoTipoNotaCreditoSoli,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNotaCreditoSoli.class.getSimpleName()+"-procesarEventosTipoNotaCreditoSolisWithConnection");connexion.begin();			
			
			TipoNotaCreditoSoliParameterReturnGeneral tiponotacreditosoliReturnGeneral=new TipoNotaCreditoSoliParameterReturnGeneral();
	
			tiponotacreditosoliReturnGeneral.setTipoNotaCreditoSoli(tiponotacreditosoli);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiponotacreditosoliReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoNotaCreditoSoliLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiponotacreditosolis,tiponotacreditosoli,tiponotacreditosoliParameterGeneral,tiponotacreditosoliReturnGeneral,isEsNuevoTipoNotaCreditoSoli,clases);
			
			this.connexion.commit();
			
			return tiponotacreditosoliReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoNotaCreditoSoliParameterReturnGeneral procesarImportacionTipoNotaCreditoSolisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoNotaCreditoSoliParameterReturnGeneral tiponotacreditosoliParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNotaCreditoSoli.class.getSimpleName()+"-procesarImportacionTipoNotaCreditoSolisWithConnection");connexion.begin();			
			
			TipoNotaCreditoSoliParameterReturnGeneral tiponotacreditosoliReturnGeneral=new TipoNotaCreditoSoliParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tiponotacreditosolis=new ArrayList<TipoNotaCreditoSoli>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tiponotacreditosoli=new TipoNotaCreditoSoli();
				
				
				if(conColumnasBase) {this.tiponotacreditosoli.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tiponotacreditosoli.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tiponotacreditosoli.setcodigo(arrColumnas[iColumn++]);
				this.tiponotacreditosoli.setnombre(arrColumnas[iColumn++]);
				
				this.tiponotacreditosolis.add(this.tiponotacreditosoli);
			}
			
			this.saveTipoNotaCreditoSolis();
			
			this.connexion.commit();
			
			tiponotacreditosoliReturnGeneral.setConRetornoEstaProcesado(true);
			tiponotacreditosoliReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tiponotacreditosoliReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoNotaCreditoSolisEliminados() throws Exception {				
		
		List<TipoNotaCreditoSoli> tiponotacreditosolisAux= new ArrayList<TipoNotaCreditoSoli>();
		
		for(TipoNotaCreditoSoli tiponotacreditosoli:tiponotacreditosolis) {
			if(!tiponotacreditosoli.getIsDeleted()) {
				tiponotacreditosolisAux.add(tiponotacreditosoli);
			}
		}
		
		tiponotacreditosolis=tiponotacreditosolisAux;
	}
	
	public void quitarTipoNotaCreditoSolisNulos() throws Exception {				
		
		List<TipoNotaCreditoSoli> tiponotacreditosolisAux= new ArrayList<TipoNotaCreditoSoli>();
		
		for(TipoNotaCreditoSoli tiponotacreditosoli : this.tiponotacreditosolis) {
			if(tiponotacreditosoli==null) {
				tiponotacreditosolisAux.add(tiponotacreditosoli);
			}
		}
		
		//this.tiponotacreditosolis=tiponotacreditosolisAux;
		
		this.tiponotacreditosolis.removeAll(tiponotacreditosolisAux);
	}
	
	public void getSetVersionRowTipoNotaCreditoSoliWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tiponotacreditosoli.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tiponotacreditosoli.getIsDeleted() || (tiponotacreditosoli.getIsChanged()&&!tiponotacreditosoli.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tiponotacreditosoliDataAccess.getSetVersionRowTipoNotaCreditoSoli(connexion,tiponotacreditosoli.getId());
				
				if(!tiponotacreditosoli.getVersionRow().equals(timestamp)) {	
					tiponotacreditosoli.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tiponotacreditosoli.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoNotaCreditoSoli()throws Exception {	
		
		if(tiponotacreditosoli.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tiponotacreditosoli.getIsDeleted() || (tiponotacreditosoli.getIsChanged()&&!tiponotacreditosoli.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tiponotacreditosoliDataAccess.getSetVersionRowTipoNotaCreditoSoli(connexion,tiponotacreditosoli.getId());
			
			try {							
				if(!tiponotacreditosoli.getVersionRow().equals(timestamp)) {	
					tiponotacreditosoli.setVersionRow(timestamp);
				}
				
				tiponotacreditosoli.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoNotaCreditoSolisWithConnection()throws Exception {	
		if(tiponotacreditosolis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoNotaCreditoSoli tiponotacreditosoliAux:tiponotacreditosolis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tiponotacreditosoliAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiponotacreditosoliAux.getIsDeleted() || (tiponotacreditosoliAux.getIsChanged()&&!tiponotacreditosoliAux.getIsNew())) {
						
						timestamp=tiponotacreditosoliDataAccess.getSetVersionRowTipoNotaCreditoSoli(connexion,tiponotacreditosoliAux.getId());
						
						if(!tiponotacreditosoli.getVersionRow().equals(timestamp)) {	
							tiponotacreditosoliAux.setVersionRow(timestamp);
						}
								
						tiponotacreditosoliAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoNotaCreditoSolis()throws Exception {	
		if(tiponotacreditosolis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoNotaCreditoSoli tiponotacreditosoliAux:tiponotacreditosolis) {
					if(tiponotacreditosoliAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiponotacreditosoliAux.getIsDeleted() || (tiponotacreditosoliAux.getIsChanged()&&!tiponotacreditosoliAux.getIsNew())) {
						
						timestamp=tiponotacreditosoliDataAccess.getSetVersionRowTipoNotaCreditoSoli(connexion,tiponotacreditosoliAux.getId());
						
						if(!tiponotacreditosoliAux.getVersionRow().equals(timestamp)) {	
							tiponotacreditosoliAux.setVersionRow(timestamp);
						}
						
													
						tiponotacreditosoliAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoNotaCreditoSoliWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			NotaCreditoSoliLogic notacreditosoliLogic=new NotaCreditoSoliLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoNotaCreditoSoli.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoNotaCreditoSoliWithConnection");connexion.begin();
			
			
			classes.add(new Classe(NotaCreditoSoli.class));
											
			

			notacreditosoliLogic.setConnexion(this.getConnexion());
			notacreditosoliLogic.setDatosCliente(this.datosCliente);
			notacreditosoliLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoNotaCreditoSoli tiponotacreditosoli:this.tiponotacreditosolis) {
				

				classes=new ArrayList<Classe>();
				classes=NotaCreditoSoliConstantesFunciones.getClassesForeignKeysOfNotaCreditoSoli(new ArrayList<Classe>(),DeepLoadType.NONE);

				notacreditosoliLogic.setNotaCreditoSolis(tiponotacreditosoli.notacreditosolis);
				notacreditosoliLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoNotaCreditoSoli tiponotacreditosoli,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoNotaCreditoSoliLogicAdditional.updateTipoNotaCreditoSoliToGet(tiponotacreditosoli,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiponotacreditosoli.setNotaCreditoSolis(tiponotacreditosoliDataAccess.getNotaCreditoSolis(connexion,tiponotacreditosoli));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiponotacreditosoli.setNotaCreditoSolis(tiponotacreditosoliDataAccess.getNotaCreditoSolis(connexion,tiponotacreditosoli));

				if(this.isConDeep) {
					NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(this.connexion);
					notacreditosoliLogic.setNotaCreditoSolis(tiponotacreditosoli.getNotaCreditoSolis());
					ArrayList<Classe> classesLocal=NotaCreditoSoliConstantesFunciones.getClassesForeignKeysOfNotaCreditoSoli(new ArrayList<Classe>(),DeepLoadType.NONE);
					notacreditosoliLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					NotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesNotaCreditoSoli(notacreditosoliLogic.getNotaCreditoSolis());
					tiponotacreditosoli.setNotaCreditoSolis(notacreditosoliLogic.getNotaCreditoSolis());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NotaCreditoSoli.class));
			tiponotacreditosoli.setNotaCreditoSolis(tiponotacreditosoliDataAccess.getNotaCreditoSolis(connexion,tiponotacreditosoli));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tiponotacreditosoli.setNotaCreditoSolis(tiponotacreditosoliDataAccess.getNotaCreditoSolis(connexion,tiponotacreditosoli));

		for(NotaCreditoSoli notacreditosoli:tiponotacreditosoli.getNotaCreditoSolis()) {
			NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
			notacreditosoliLogic.deepLoad(notacreditosoli,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiponotacreditosoli.setNotaCreditoSolis(tiponotacreditosoliDataAccess.getNotaCreditoSolis(connexion,tiponotacreditosoli));

				for(NotaCreditoSoli notacreditosoli:tiponotacreditosoli.getNotaCreditoSolis()) {
					NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
					notacreditosoliLogic.deepLoad(notacreditosoli,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NotaCreditoSoli.class));
			tiponotacreditosoli.setNotaCreditoSolis(tiponotacreditosoliDataAccess.getNotaCreditoSolis(connexion,tiponotacreditosoli));

			for(NotaCreditoSoli notacreditosoli:tiponotacreditosoli.getNotaCreditoSolis()) {
				NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
				notacreditosoliLogic.deepLoad(notacreditosoli,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoNotaCreditoSoli tiponotacreditosoli,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoNotaCreditoSoliLogicAdditional.updateTipoNotaCreditoSoliToSave(tiponotacreditosoli,this.arrDatoGeneral);
			
TipoNotaCreditoSoliDataAccess.save(tiponotacreditosoli, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(NotaCreditoSoli notacreditosoli:tiponotacreditosoli.getNotaCreditoSolis()) {
			notacreditosoli.setid_tipo_nota_credito_soli(tiponotacreditosoli.getId());
			NotaCreditoSoliDataAccess.save(notacreditosoli,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NotaCreditoSoli notacreditosoli:tiponotacreditosoli.getNotaCreditoSolis()) {
					notacreditosoli.setid_tipo_nota_credito_soli(tiponotacreditosoli.getId());
					NotaCreditoSoliDataAccess.save(notacreditosoli,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(NotaCreditoSoli notacreditosoli:tiponotacreditosoli.getNotaCreditoSolis()) {
			NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
			notacreditosoli.setid_tipo_nota_credito_soli(tiponotacreditosoli.getId());
			NotaCreditoSoliDataAccess.save(notacreditosoli,connexion);
			notacreditosoliLogic.deepSave(notacreditosoli,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(NotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NotaCreditoSoli notacreditosoli:tiponotacreditosoli.getNotaCreditoSolis()) {
					NotaCreditoSoliLogic notacreditosoliLogic= new NotaCreditoSoliLogic(connexion);
					notacreditosoli.setid_tipo_nota_credito_soli(tiponotacreditosoli.getId());
					NotaCreditoSoliDataAccess.save(notacreditosoli,connexion);
					notacreditosoliLogic.deepSave(notacreditosoli,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoNotaCreditoSoli.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tiponotacreditosoli,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesTipoNotaCreditoSoli(tiponotacreditosoli);
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
			this.deepLoad(this.tiponotacreditosoli,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesTipoNotaCreditoSoli(this.tiponotacreditosoli);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoNotaCreditoSoli.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tiponotacreditosolis!=null) {
				for(TipoNotaCreditoSoli tiponotacreditosoli:tiponotacreditosolis) {
					this.deepLoad(tiponotacreditosoli,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesTipoNotaCreditoSoli(tiponotacreditosolis);
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
			if(tiponotacreditosolis!=null) {
				for(TipoNotaCreditoSoli tiponotacreditosoli:tiponotacreditosolis) {
					this.deepLoad(tiponotacreditosoli,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesTipoNotaCreditoSoli(tiponotacreditosolis);
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
			this.getNewConnexionToDeep(TipoNotaCreditoSoli.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tiponotacreditosoli,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoNotaCreditoSoli.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tiponotacreditosolis!=null) {
				for(TipoNotaCreditoSoli tiponotacreditosoli:tiponotacreditosolis) {
					this.deepSave(tiponotacreditosoli,isDeep,deepLoadType,clases);
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
			if(tiponotacreditosolis!=null) {
				for(TipoNotaCreditoSoli tiponotacreditosoli:tiponotacreditosolis) {
					this.deepSave(tiponotacreditosoli,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoNotaCreditoSoliConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoNotaCreditoSoliDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoNotaCreditoSoli tiponotacreditosoli,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoNotaCreditoSoliConstantesFunciones.ISCONAUDITORIA) {
				if(tiponotacreditosoli.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoNotaCreditoSoliDataAccess.TABLENAME, tiponotacreditosoli.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoNotaCreditoSoliConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoNotaCreditoSoliLogic.registrarAuditoriaDetallesTipoNotaCreditoSoli(connexion,tiponotacreditosoli,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tiponotacreditosoli.getIsDeleted()) {
					/*if(!tiponotacreditosoli.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoNotaCreditoSoliDataAccess.TABLENAME, tiponotacreditosoli.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoNotaCreditoSoliLogic.registrarAuditoriaDetallesTipoNotaCreditoSoli(connexion,tiponotacreditosoli,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoNotaCreditoSoliDataAccess.TABLENAME, tiponotacreditosoli.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tiponotacreditosoli.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoNotaCreditoSoliDataAccess.TABLENAME, tiponotacreditosoli.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoNotaCreditoSoliConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoNotaCreditoSoliLogic.registrarAuditoriaDetallesTipoNotaCreditoSoli(connexion,tiponotacreditosoli,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoNotaCreditoSoli(Connexion connexion,TipoNotaCreditoSoli tiponotacreditosoli)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tiponotacreditosoli.getIsNew()||!tiponotacreditosoli.getcodigo().equals(tiponotacreditosoli.getTipoNotaCreditoSoliOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiponotacreditosoli.getTipoNotaCreditoSoliOriginal().getcodigo()!=null)
				{
					strValorActual=tiponotacreditosoli.getTipoNotaCreditoSoliOriginal().getcodigo();
				}
				if(tiponotacreditosoli.getcodigo()!=null)
				{
					strValorNuevo=tiponotacreditosoli.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoNotaCreditoSoliConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tiponotacreditosoli.getIsNew()||!tiponotacreditosoli.getnombre().equals(tiponotacreditosoli.getTipoNotaCreditoSoliOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiponotacreditosoli.getTipoNotaCreditoSoliOriginal().getnombre()!=null)
				{
					strValorActual=tiponotacreditosoli.getTipoNotaCreditoSoliOriginal().getnombre();
				}
				if(tiponotacreditosoli.getnombre()!=null)
				{
					strValorNuevo=tiponotacreditosoli.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoNotaCreditoSoliConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoNotaCreditoSoliRelacionesWithConnection(TipoNotaCreditoSoli tiponotacreditosoli,List<NotaCreditoSoli> notacreditosolis) throws Exception {

		if(!tiponotacreditosoli.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoNotaCreditoSoliRelacionesBase(tiponotacreditosoli,notacreditosolis,true);
		}
	}

	public void saveTipoNotaCreditoSoliRelaciones(TipoNotaCreditoSoli tiponotacreditosoli,List<NotaCreditoSoli> notacreditosolis)throws Exception {

		if(!tiponotacreditosoli.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoNotaCreditoSoliRelacionesBase(tiponotacreditosoli,notacreditosolis,false);
		}
	}

	public void saveTipoNotaCreditoSoliRelacionesBase(TipoNotaCreditoSoli tiponotacreditosoli,List<NotaCreditoSoli> notacreditosolis,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoNotaCreditoSoli-saveRelacionesWithConnection");}
	
			tiponotacreditosoli.setNotaCreditoSolis(notacreditosolis);

			this.setTipoNotaCreditoSoli(tiponotacreditosoli);

				if((tiponotacreditosoli.getIsNew()||tiponotacreditosoli.getIsChanged())&&!tiponotacreditosoli.getIsDeleted()) {
					this.saveTipoNotaCreditoSoli();
					this.saveTipoNotaCreditoSoliRelacionesDetalles(notacreditosolis);

				} else if(tiponotacreditosoli.getIsDeleted()) {
					this.saveTipoNotaCreditoSoliRelacionesDetalles(notacreditosolis);
					this.saveTipoNotaCreditoSoli();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			NotaCreditoSoliConstantesFunciones.InicializarGeneralEntityAuxiliaresNotaCreditoSolis(notacreditosolis,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoNotaCreditoSoliRelacionesDetalles(List<NotaCreditoSoli> notacreditosolis)throws Exception {
		try {
	

			Long idTipoNotaCreditoSoliActual=this.getTipoNotaCreditoSoli().getId();

			NotaCreditoSoliLogic notacreditosoliLogic_Desde_TipoNotaCreditoSoli=new NotaCreditoSoliLogic();
			notacreditosoliLogic_Desde_TipoNotaCreditoSoli.setNotaCreditoSolis(notacreditosolis);

			notacreditosoliLogic_Desde_TipoNotaCreditoSoli.setConnexion(this.getConnexion());
			notacreditosoliLogic_Desde_TipoNotaCreditoSoli.setDatosCliente(this.datosCliente);

			for(NotaCreditoSoli notacreditosoli_Desde_TipoNotaCreditoSoli:notacreditosoliLogic_Desde_TipoNotaCreditoSoli.getNotaCreditoSolis()) {
				notacreditosoli_Desde_TipoNotaCreditoSoli.setid_tipo_nota_credito_soli(idTipoNotaCreditoSoliActual);

				notacreditosoliLogic_Desde_TipoNotaCreditoSoli.setNotaCreditoSoli(notacreditosoli_Desde_TipoNotaCreditoSoli);
				notacreditosoliLogic_Desde_TipoNotaCreditoSoli.saveNotaCreditoSoli();

				Long idNotaCreditoSoliActual=notacreditosoli_Desde_TipoNotaCreditoSoli.getId();

				DetaNotaCreditoSoliLogic detanotacreditosoliLogic_Desde_NotaCreditoSoli=new DetaNotaCreditoSoliLogic();

				if(notacreditosoli_Desde_TipoNotaCreditoSoli.getDetaNotaCreditoSolis()==null){
					notacreditosoli_Desde_TipoNotaCreditoSoli.setDetaNotaCreditoSolis(new ArrayList<DetaNotaCreditoSoli>());
				}

				detanotacreditosoliLogic_Desde_NotaCreditoSoli.setDetaNotaCreditoSolis(notacreditosoli_Desde_TipoNotaCreditoSoli.getDetaNotaCreditoSolis());

				detanotacreditosoliLogic_Desde_NotaCreditoSoli.setConnexion(this.getConnexion());
				detanotacreditosoliLogic_Desde_NotaCreditoSoli.setDatosCliente(this.datosCliente);

				for(DetaNotaCreditoSoli detanotacreditosoli_Desde_NotaCreditoSoli:detanotacreditosoliLogic_Desde_NotaCreditoSoli.getDetaNotaCreditoSolis()) {
					detanotacreditosoli_Desde_NotaCreditoSoli.setid_nota_credito_soli(idNotaCreditoSoliActual);
				}

				detanotacreditosoliLogic_Desde_NotaCreditoSoli.saveDetaNotaCreditoSolis();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoNotaCreditoSoli(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoNotaCreditoSoliConstantesFunciones.getClassesForeignKeysOfTipoNotaCreditoSoli(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoNotaCreditoSoli(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoNotaCreditoSoliConstantesFunciones.getClassesRelationshipsOfTipoNotaCreditoSoli(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

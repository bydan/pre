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
import com.bydan.erp.contabilidad.util.TipoRetencionIvaConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoRetencionIvaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoRetencionIvaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.TipoRetencionIva;
import com.bydan.erp.contabilidad.business.logic.TipoRetencionIvaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.sris.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.sris.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoRetencionIvaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoRetencionIvaLogic.class);
	
	protected TipoRetencionIvaDataAccess tiporetencionivaDataAccess; 	
	protected TipoRetencionIva tiporetencioniva;
	protected List<TipoRetencionIva> tiporetencionivas;
	protected Object tiporetencionivaObject;	
	protected List<Object> tiporetencionivasObject;
	
	public static ClassValidator<TipoRetencionIva> tiporetencionivaValidator = new ClassValidator<TipoRetencionIva>(TipoRetencionIva.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoRetencionIvaLogicAdditional tiporetencionivaLogicAdditional=null;
	
	public TipoRetencionIvaLogicAdditional getTipoRetencionIvaLogicAdditional() {
		return this.tiporetencionivaLogicAdditional;
	}
	
	public void setTipoRetencionIvaLogicAdditional(TipoRetencionIvaLogicAdditional tiporetencionivaLogicAdditional) {
		try {
			this.tiporetencionivaLogicAdditional=tiporetencionivaLogicAdditional;
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
	
	
	
	
	public  TipoRetencionIvaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tiporetencionivaDataAccess = new TipoRetencionIvaDataAccess();
			
			this.tiporetencionivas= new ArrayList<TipoRetencionIva>();
			this.tiporetencioniva= new TipoRetencionIva();
			
			this.tiporetencionivaObject=new Object();
			this.tiporetencionivasObject=new ArrayList<Object>();
				
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
			
			this.tiporetencionivaDataAccess.setConnexionType(this.connexionType);
			this.tiporetencionivaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoRetencionIvaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tiporetencionivaDataAccess = new TipoRetencionIvaDataAccess();
			this.tiporetencionivas= new ArrayList<TipoRetencionIva>();
			this.tiporetencioniva= new TipoRetencionIva();
			this.tiporetencionivaObject=new Object();
			this.tiporetencionivasObject=new ArrayList<Object>();
			
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
			
			this.tiporetencionivaDataAccess.setConnexionType(this.connexionType);
			this.tiporetencionivaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoRetencionIva getTipoRetencionIva() throws Exception {	
		TipoRetencionIvaLogicAdditional.checkTipoRetencionIvaToGet(tiporetencioniva,this.datosCliente,this.arrDatoGeneral);
		TipoRetencionIvaLogicAdditional.updateTipoRetencionIvaToGet(tiporetencioniva,this.arrDatoGeneral);
		
		return tiporetencioniva;
	}
		
	public void setTipoRetencionIva(TipoRetencionIva newTipoRetencionIva) {
		this.tiporetencioniva = newTipoRetencionIva;
	}
	
	public TipoRetencionIvaDataAccess getTipoRetencionIvaDataAccess() {
		return tiporetencionivaDataAccess;
	}
	
	public void setTipoRetencionIvaDataAccess(TipoRetencionIvaDataAccess newtiporetencionivaDataAccess) {
		this.tiporetencionivaDataAccess = newtiporetencionivaDataAccess;
	}
	
	public List<TipoRetencionIva> getTipoRetencionIvas() throws Exception {		
		this.quitarTipoRetencionIvasNulos();
		
		TipoRetencionIvaLogicAdditional.checkTipoRetencionIvaToGets(tiporetencionivas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoRetencionIva tiporetencionivaLocal: tiporetencionivas ) {
			TipoRetencionIvaLogicAdditional.updateTipoRetencionIvaToGet(tiporetencionivaLocal,this.arrDatoGeneral);
		}
		
		return tiporetencionivas;
	}
	
	public void setTipoRetencionIvas(List<TipoRetencionIva> newTipoRetencionIvas) {
		this.tiporetencionivas = newTipoRetencionIvas;
	}
	
	public Object getTipoRetencionIvaObject() {	
		this.tiporetencionivaObject=this.tiporetencionivaDataAccess.getEntityObject();
		return this.tiporetencionivaObject;
	}
		
	public void setTipoRetencionIvaObject(Object newTipoRetencionIvaObject) {
		this.tiporetencionivaObject = newTipoRetencionIvaObject;
	}
	
	public List<Object> getTipoRetencionIvasObject() {		
		this.tiporetencionivasObject=this.tiporetencionivaDataAccess.getEntitiesObject();
		return this.tiporetencionivasObject;
	}
		
	public void setTipoRetencionIvasObject(List<Object> newTipoRetencionIvasObject) {
		this.tiporetencionivasObject = newTipoRetencionIvasObject;
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
		
		if(this.tiporetencionivaDataAccess!=null) {
			this.tiporetencionivaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionIva.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tiporetencionivaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tiporetencionivaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tiporetencioniva = new  TipoRetencionIva();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiporetencioniva=tiporetencionivaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporetencioniva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRetencionIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionIva(this.tiporetencioniva);
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
		tiporetencioniva = new  TipoRetencionIva();
		  		  
        try {
			
			tiporetencioniva=tiporetencionivaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporetencioniva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRetencionIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionIva(this.tiporetencioniva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tiporetencioniva = new  TipoRetencionIva();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiporetencioniva=tiporetencionivaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporetencioniva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRetencionIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionIva(this.tiporetencioniva);
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
		tiporetencioniva = new  TipoRetencionIva();
		  		  
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
		tiporetencioniva = new  TipoRetencionIva();
		  		  
        try {
			
			tiporetencioniva=tiporetencionivaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporetencioniva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRetencionIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionIva(this.tiporetencioniva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tiporetencioniva = new  TipoRetencionIva();
		  		  
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
		tiporetencioniva = new  TipoRetencionIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionIva.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tiporetencionivaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporetencioniva = new  TipoRetencionIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tiporetencionivaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiporetencioniva = new  TipoRetencionIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionIva.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tiporetencionivaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporetencioniva = new  TipoRetencionIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tiporetencionivaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiporetencioniva = new  TipoRetencionIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionIva.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tiporetencionivaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporetencioniva = new  TipoRetencionIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tiporetencionivaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiporetencionivas = new  ArrayList<TipoRetencionIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoRetencionIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencionivas=tiporetencionivaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRetencionIva(tiporetencionivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionIva(this.tiporetencionivas);
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
		tiporetencionivas = new  ArrayList<TipoRetencionIva>();
		  		  
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
		tiporetencionivas = new  ArrayList<TipoRetencionIva>();
		  		  
        try {			
			TipoRetencionIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencionivas=tiporetencionivaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoRetencionIva(tiporetencionivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionIva(this.tiporetencionivas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tiporetencionivas = new  ArrayList<TipoRetencionIva>();
		  		  
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
		tiporetencionivas = new  ArrayList<TipoRetencionIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoRetencionIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencionivas=tiporetencionivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRetencionIva(tiporetencionivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionIva(this.tiporetencionivas);
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
		tiporetencionivas = new  ArrayList<TipoRetencionIva>();
		  		  
        try {
			TipoRetencionIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencionivas=tiporetencionivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRetencionIva(tiporetencionivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionIva(this.tiporetencionivas);
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
		tiporetencionivas = new  ArrayList<TipoRetencionIva>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRetencionIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencionivas=tiporetencionivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRetencionIva(tiporetencionivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionIva(this.tiporetencionivas);
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
		tiporetencionivas = new  ArrayList<TipoRetencionIva>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRetencionIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencionivas=tiporetencionivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRetencionIva(tiporetencionivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionIva(this.tiporetencionivas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tiporetencioniva = new  TipoRetencionIva();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRetencionIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencioniva=tiporetencionivaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRetencionIva(tiporetencioniva);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionIva(this.tiporetencioniva);
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
		tiporetencioniva = new  TipoRetencionIva();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRetencionIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencioniva=tiporetencionivaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRetencionIva(tiporetencioniva);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionIva(this.tiporetencioniva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiporetencionivas = new  ArrayList<TipoRetencionIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionIva.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoRetencionIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencionivas=tiporetencionivaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRetencionIva(tiporetencionivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionIva(this.tiporetencionivas);
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
		tiporetencionivas = new  ArrayList<TipoRetencionIva>();
		  		  
        try {
			TipoRetencionIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencionivas=tiporetencionivaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRetencionIva(tiporetencionivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionIva(this.tiporetencionivas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoRetencionIvasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tiporetencionivas = new  ArrayList<TipoRetencionIva>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionIva.class.getSimpleName()+"-getTodosTipoRetencionIvasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRetencionIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencionivas=tiporetencionivaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoRetencionIva(tiporetencionivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionIva(this.tiporetencionivas);
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
	
	public  void  getTodosTipoRetencionIvas(String sFinalQuery,Pagination pagination)throws Exception {
		tiporetencionivas = new  ArrayList<TipoRetencionIva>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRetencionIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporetencionivas=tiporetencionivaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoRetencionIva(tiporetencionivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRetencionIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionIva(this.tiporetencionivas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoRetencionIva(TipoRetencionIva tiporetencioniva) throws Exception {
		Boolean estaValidado=false;
		
		if(tiporetencioniva.getIsNew() || tiporetencioniva.getIsChanged()) { 
			this.invalidValues = tiporetencionivaValidator.getInvalidValues(tiporetencioniva);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tiporetencioniva);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoRetencionIva(List<TipoRetencionIva> TipoRetencionIvas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoRetencionIva tiporetencionivaLocal:tiporetencionivas) {				
			estaValidadoObjeto=this.validarGuardarTipoRetencionIva(tiporetencionivaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoRetencionIva(List<TipoRetencionIva> TipoRetencionIvas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoRetencionIva(tiporetencionivas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoRetencionIva(TipoRetencionIva TipoRetencionIva) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoRetencionIva(tiporetencioniva)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoRetencionIva tiporetencioniva) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tiporetencioniva.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoRetencionIvaConstantesFunciones.getTipoRetencionIvaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tiporetencioniva","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoRetencionIvaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoRetencionIvaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoRetencionIvaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionIva.class.getSimpleName()+"-saveTipoRetencionIvaWithConnection");connexion.begin();			
			
			TipoRetencionIvaLogicAdditional.checkTipoRetencionIvaToSave(this.tiporetencioniva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoRetencionIvaLogicAdditional.updateTipoRetencionIvaToSave(this.tiporetencioniva,this.arrDatoGeneral);
			
			TipoRetencionIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiporetencioniva,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoRetencionIva();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoRetencionIva(this.tiporetencioniva)) {
				TipoRetencionIvaDataAccess.save(this.tiporetencioniva, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tiporetencioniva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoRetencionIvaLogicAdditional.checkTipoRetencionIvaToSaveAfter(this.tiporetencioniva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoRetencionIva();
			
			connexion.commit();			
			
			if(this.tiporetencioniva.getIsDeleted()) {
				this.tiporetencioniva=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoRetencionIva()throws Exception {	
		try {	
			
			TipoRetencionIvaLogicAdditional.checkTipoRetencionIvaToSave(this.tiporetencioniva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoRetencionIvaLogicAdditional.updateTipoRetencionIvaToSave(this.tiporetencioniva,this.arrDatoGeneral);
			
			TipoRetencionIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiporetencioniva,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoRetencionIva(this.tiporetencioniva)) {			
				TipoRetencionIvaDataAccess.save(this.tiporetencioniva, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tiporetencioniva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoRetencionIvaLogicAdditional.checkTipoRetencionIvaToSaveAfter(this.tiporetencioniva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tiporetencioniva.getIsDeleted()) {
				this.tiporetencioniva=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoRetencionIvasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionIva.class.getSimpleName()+"-saveTipoRetencionIvasWithConnection");connexion.begin();			
			
			TipoRetencionIvaLogicAdditional.checkTipoRetencionIvaToSaves(tiporetencionivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoRetencionIvas();
			
			Boolean validadoTodosTipoRetencionIva=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoRetencionIva tiporetencionivaLocal:tiporetencionivas) {		
				if(tiporetencionivaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoRetencionIvaLogicAdditional.updateTipoRetencionIvaToSave(tiporetencionivaLocal,this.arrDatoGeneral);
	        	
				TipoRetencionIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiporetencionivaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoRetencionIva(tiporetencionivaLocal)) {
					TipoRetencionIvaDataAccess.save(tiporetencionivaLocal, connexion);				
				} else {
					validadoTodosTipoRetencionIva=false;
				}
			}
			
			if(!validadoTodosTipoRetencionIva) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoRetencionIvaLogicAdditional.checkTipoRetencionIvaToSavesAfter(tiporetencionivas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoRetencionIvas();
			
			connexion.commit();		
			
			this.quitarTipoRetencionIvasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoRetencionIvas()throws Exception {				
		 try {	
			TipoRetencionIvaLogicAdditional.checkTipoRetencionIvaToSaves(tiporetencionivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoRetencionIva=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoRetencionIva tiporetencionivaLocal:tiporetencionivas) {				
				if(tiporetencionivaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoRetencionIvaLogicAdditional.updateTipoRetencionIvaToSave(tiporetencionivaLocal,this.arrDatoGeneral);
	        	
				TipoRetencionIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiporetencionivaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoRetencionIva(tiporetencionivaLocal)) {				
					TipoRetencionIvaDataAccess.save(tiporetencionivaLocal, connexion);				
				} else {
					validadoTodosTipoRetencionIva=false;
				}
			}
			
			if(!validadoTodosTipoRetencionIva) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoRetencionIvaLogicAdditional.checkTipoRetencionIvaToSavesAfter(tiporetencionivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoRetencionIvasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoRetencionIvaParameterReturnGeneral procesarAccionTipoRetencionIvas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoRetencionIva> tiporetencionivas,TipoRetencionIvaParameterReturnGeneral tiporetencionivaParameterGeneral)throws Exception {
		 try {	
			TipoRetencionIvaParameterReturnGeneral tiporetencionivaReturnGeneral=new TipoRetencionIvaParameterReturnGeneral();
	
			TipoRetencionIvaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiporetencionivas,tiporetencionivaParameterGeneral,tiporetencionivaReturnGeneral);
			
			return tiporetencionivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoRetencionIvaParameterReturnGeneral procesarAccionTipoRetencionIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoRetencionIva> tiporetencionivas,TipoRetencionIvaParameterReturnGeneral tiporetencionivaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionIva.class.getSimpleName()+"-procesarAccionTipoRetencionIvasWithConnection");connexion.begin();			
			
			TipoRetencionIvaParameterReturnGeneral tiporetencionivaReturnGeneral=new TipoRetencionIvaParameterReturnGeneral();
	
			TipoRetencionIvaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiporetencionivas,tiporetencionivaParameterGeneral,tiporetencionivaReturnGeneral);
			
			this.connexion.commit();
			
			return tiporetencionivaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoRetencionIvaParameterReturnGeneral procesarEventosTipoRetencionIvas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoRetencionIva> tiporetencionivas,TipoRetencionIva tiporetencioniva,TipoRetencionIvaParameterReturnGeneral tiporetencionivaParameterGeneral,Boolean isEsNuevoTipoRetencionIva,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoRetencionIvaParameterReturnGeneral tiporetencionivaReturnGeneral=new TipoRetencionIvaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiporetencionivaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoRetencionIvaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiporetencionivas,tiporetencioniva,tiporetencionivaParameterGeneral,tiporetencionivaReturnGeneral,isEsNuevoTipoRetencionIva,clases);
			
			return tiporetencionivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoRetencionIvaParameterReturnGeneral procesarEventosTipoRetencionIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoRetencionIva> tiporetencionivas,TipoRetencionIva tiporetencioniva,TipoRetencionIvaParameterReturnGeneral tiporetencionivaParameterGeneral,Boolean isEsNuevoTipoRetencionIva,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionIva.class.getSimpleName()+"-procesarEventosTipoRetencionIvasWithConnection");connexion.begin();			
			
			TipoRetencionIvaParameterReturnGeneral tiporetencionivaReturnGeneral=new TipoRetencionIvaParameterReturnGeneral();
	
			tiporetencionivaReturnGeneral.setTipoRetencionIva(tiporetencioniva);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiporetencionivaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoRetencionIvaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiporetencionivas,tiporetencioniva,tiporetencionivaParameterGeneral,tiporetencionivaReturnGeneral,isEsNuevoTipoRetencionIva,clases);
			
			this.connexion.commit();
			
			return tiporetencionivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoRetencionIvaParameterReturnGeneral procesarImportacionTipoRetencionIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoRetencionIvaParameterReturnGeneral tiporetencionivaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionIva.class.getSimpleName()+"-procesarImportacionTipoRetencionIvasWithConnection");connexion.begin();			
			
			TipoRetencionIvaParameterReturnGeneral tiporetencionivaReturnGeneral=new TipoRetencionIvaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tiporetencionivas=new ArrayList<TipoRetencionIva>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tiporetencioniva=new TipoRetencionIva();
				
				
				if(conColumnasBase) {this.tiporetencioniva.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tiporetencioniva.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tiporetencioniva.setcodigo(arrColumnas[iColumn++]);
				this.tiporetencioniva.setnombre(arrColumnas[iColumn++]);
				
				this.tiporetencionivas.add(this.tiporetencioniva);
			}
			
			this.saveTipoRetencionIvas();
			
			this.connexion.commit();
			
			tiporetencionivaReturnGeneral.setConRetornoEstaProcesado(true);
			tiporetencionivaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tiporetencionivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoRetencionIvasEliminados() throws Exception {				
		
		List<TipoRetencionIva> tiporetencionivasAux= new ArrayList<TipoRetencionIva>();
		
		for(TipoRetencionIva tiporetencioniva:tiporetencionivas) {
			if(!tiporetencioniva.getIsDeleted()) {
				tiporetencionivasAux.add(tiporetencioniva);
			}
		}
		
		tiporetencionivas=tiporetencionivasAux;
	}
	
	public void quitarTipoRetencionIvasNulos() throws Exception {				
		
		List<TipoRetencionIva> tiporetencionivasAux= new ArrayList<TipoRetencionIva>();
		
		for(TipoRetencionIva tiporetencioniva : this.tiporetencionivas) {
			if(tiporetencioniva==null) {
				tiporetencionivasAux.add(tiporetencioniva);
			}
		}
		
		//this.tiporetencionivas=tiporetencionivasAux;
		
		this.tiporetencionivas.removeAll(tiporetencionivasAux);
	}
	
	public void getSetVersionRowTipoRetencionIvaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tiporetencioniva.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tiporetencioniva.getIsDeleted() || (tiporetencioniva.getIsChanged()&&!tiporetencioniva.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tiporetencionivaDataAccess.getSetVersionRowTipoRetencionIva(connexion,tiporetencioniva.getId());
				
				if(!tiporetencioniva.getVersionRow().equals(timestamp)) {	
					tiporetencioniva.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tiporetencioniva.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoRetencionIva()throws Exception {	
		
		if(tiporetencioniva.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tiporetencioniva.getIsDeleted() || (tiporetencioniva.getIsChanged()&&!tiporetencioniva.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tiporetencionivaDataAccess.getSetVersionRowTipoRetencionIva(connexion,tiporetencioniva.getId());
			
			try {							
				if(!tiporetencioniva.getVersionRow().equals(timestamp)) {	
					tiporetencioniva.setVersionRow(timestamp);
				}
				
				tiporetencioniva.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoRetencionIvasWithConnection()throws Exception {	
		if(tiporetencionivas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoRetencionIva tiporetencionivaAux:tiporetencionivas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tiporetencionivaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiporetencionivaAux.getIsDeleted() || (tiporetencionivaAux.getIsChanged()&&!tiporetencionivaAux.getIsNew())) {
						
						timestamp=tiporetencionivaDataAccess.getSetVersionRowTipoRetencionIva(connexion,tiporetencionivaAux.getId());
						
						if(!tiporetencioniva.getVersionRow().equals(timestamp)) {	
							tiporetencionivaAux.setVersionRow(timestamp);
						}
								
						tiporetencionivaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoRetencionIvas()throws Exception {	
		if(tiporetencionivas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoRetencionIva tiporetencionivaAux:tiporetencionivas) {
					if(tiporetencionivaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiporetencionivaAux.getIsDeleted() || (tiporetencionivaAux.getIsChanged()&&!tiporetencionivaAux.getIsNew())) {
						
						timestamp=tiporetencionivaDataAccess.getSetVersionRowTipoRetencionIva(connexion,tiporetencionivaAux.getId());
						
						if(!tiporetencionivaAux.getVersionRow().equals(timestamp)) {	
							tiporetencionivaAux.setVersionRow(timestamp);
						}
						
													
						tiporetencionivaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoRetencionIvaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			TransaccionLocalLogic transaccionlocalLogic=new TransaccionLocalLogic();
			TarjetaCreditoLogic tarjetacreditoLogic=new TarjetaCreditoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRetencionIva.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoRetencionIvaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(TransaccionLocal.class));
			classes.add(new Classe(TarjetaCredito.class));
											
			

			transaccionlocalLogic.setConnexion(this.getConnexion());
			transaccionlocalLogic.setDatosCliente(this.datosCliente);
			transaccionlocalLogic.setIsConRefrescarForeignKeys(true);

			tarjetacreditoLogic.setConnexion(this.getConnexion());
			tarjetacreditoLogic.setDatosCliente(this.datosCliente);
			tarjetacreditoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoRetencionIva tiporetencioniva:this.tiporetencionivas) {
				

				classes=new ArrayList<Classe>();
				classes=TransaccionLocalConstantesFunciones.getClassesForeignKeysOfTransaccionLocal(new ArrayList<Classe>(),DeepLoadType.NONE);

				transaccionlocalLogic.setTransaccionLocals(tiporetencioniva.transaccionlocals);
				transaccionlocalLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=TarjetaCreditoConstantesFunciones.getClassesForeignKeysOfTarjetaCredito(new ArrayList<Classe>(),DeepLoadType.NONE);

				tarjetacreditoLogic.setTarjetaCreditos(tiporetencioniva.tarjetacreditos);
				tarjetacreditoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoRetencionIva tiporetencioniva,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoRetencionIvaLogicAdditional.updateTipoRetencionIvaToGet(tiporetencioniva,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiporetencioniva.setTransaccionLocals(tiporetencionivaDataAccess.getTransaccionLocals(connexion,tiporetencioniva));
		tiporetencioniva.setTarjetaCreditos(tiporetencionivaDataAccess.getTarjetaCreditos(connexion,tiporetencioniva));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiporetencioniva.setTransaccionLocals(tiporetencionivaDataAccess.getTransaccionLocals(connexion,tiporetencioniva));

				if(this.isConDeep) {
					TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(this.connexion);
					transaccionlocalLogic.setTransaccionLocals(tiporetencioniva.getTransaccionLocals());
					ArrayList<Classe> classesLocal=TransaccionLocalConstantesFunciones.getClassesForeignKeysOfTransaccionLocal(new ArrayList<Classe>(),DeepLoadType.NONE);
					transaccionlocalLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TransaccionLocalConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionLocal(transaccionlocalLogic.getTransaccionLocals());
					tiporetencioniva.setTransaccionLocals(transaccionlocalLogic.getTransaccionLocals());
				}

				continue;
			}

			if(clas.clas.equals(TarjetaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiporetencioniva.setTarjetaCreditos(tiporetencionivaDataAccess.getTarjetaCreditos(connexion,tiporetencioniva));

				if(this.isConDeep) {
					TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(this.connexion);
					tarjetacreditoLogic.setTarjetaCreditos(tiporetencioniva.getTarjetaCreditos());
					ArrayList<Classe> classesLocal=TarjetaCreditoConstantesFunciones.getClassesForeignKeysOfTarjetaCredito(new ArrayList<Classe>(),DeepLoadType.NONE);
					tarjetacreditoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(tarjetacreditoLogic.getTarjetaCreditos());
					tiporetencioniva.setTarjetaCreditos(tarjetacreditoLogic.getTarjetaCreditos());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


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
			tiporetencioniva.setTransaccionLocals(tiporetencionivaDataAccess.getTransaccionLocals(connexion,tiporetencioniva));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TarjetaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TarjetaCredito.class));
			tiporetencioniva.setTarjetaCreditos(tiporetencionivaDataAccess.getTarjetaCreditos(connexion,tiporetencioniva));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tiporetencioniva.setTransaccionLocals(tiporetencionivaDataAccess.getTransaccionLocals(connexion,tiporetencioniva));

		for(TransaccionLocal transaccionlocal:tiporetencioniva.getTransaccionLocals()) {
			TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
			transaccionlocalLogic.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
		}

		tiporetencioniva.setTarjetaCreditos(tiporetencionivaDataAccess.getTarjetaCreditos(connexion,tiporetencioniva));

		for(TarjetaCredito tarjetacredito:tiporetencioniva.getTarjetaCreditos()) {
			TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
			tarjetacreditoLogic.deepLoad(tarjetacredito,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiporetencioniva.setTransaccionLocals(tiporetencionivaDataAccess.getTransaccionLocals(connexion,tiporetencioniva));

				for(TransaccionLocal transaccionlocal:tiporetencioniva.getTransaccionLocals()) {
					TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
					transaccionlocalLogic.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TarjetaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiporetencioniva.setTarjetaCreditos(tiporetencionivaDataAccess.getTarjetaCreditos(connexion,tiporetencioniva));

				for(TarjetaCredito tarjetacredito:tiporetencioniva.getTarjetaCreditos()) {
					TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
					tarjetacreditoLogic.deepLoad(tarjetacredito,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


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
			tiporetencioniva.setTransaccionLocals(tiporetencionivaDataAccess.getTransaccionLocals(connexion,tiporetencioniva));

			for(TransaccionLocal transaccionlocal:tiporetencioniva.getTransaccionLocals()) {
				TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
				transaccionlocalLogic.deepLoad(transaccionlocal,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TarjetaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TarjetaCredito.class));
			tiporetencioniva.setTarjetaCreditos(tiporetencionivaDataAccess.getTarjetaCreditos(connexion,tiporetencioniva));

			for(TarjetaCredito tarjetacredito:tiporetencioniva.getTarjetaCreditos()) {
				TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
				tarjetacreditoLogic.deepLoad(tarjetacredito,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoRetencionIva tiporetencioniva,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoRetencionIvaLogicAdditional.updateTipoRetencionIvaToSave(tiporetencioniva,this.arrDatoGeneral);
			
TipoRetencionIvaDataAccess.save(tiporetencioniva, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(TransaccionLocal transaccionlocal:tiporetencioniva.getTransaccionLocals()) {
			transaccionlocal.setid_tipo_retencion_iva(tiporetencioniva.getId());
			TransaccionLocalDataAccess.save(transaccionlocal,connexion);
		}

		for(TarjetaCredito tarjetacredito:tiporetencioniva.getTarjetaCreditos()) {
			tarjetacredito.setid_tipo_retencion_iva(tiporetencioniva.getId());
			TarjetaCreditoDataAccess.save(tarjetacredito,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TransaccionLocal transaccionlocal:tiporetencioniva.getTransaccionLocals()) {
					transaccionlocal.setid_tipo_retencion_iva(tiporetencioniva.getId());
					TransaccionLocalDataAccess.save(transaccionlocal,connexion);
				}
				continue;
			}

			if(clas.clas.equals(TarjetaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TarjetaCredito tarjetacredito:tiporetencioniva.getTarjetaCreditos()) {
					tarjetacredito.setid_tipo_retencion_iva(tiporetencioniva.getId());
					TarjetaCreditoDataAccess.save(tarjetacredito,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(TransaccionLocal transaccionlocal:tiporetencioniva.getTransaccionLocals()) {
			TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
			transaccionlocal.setid_tipo_retencion_iva(tiporetencioniva.getId());
			TransaccionLocalDataAccess.save(transaccionlocal,connexion);
			transaccionlocalLogic.deepSave(transaccionlocal,isDeep,deepLoadType,clases);
		}

		for(TarjetaCredito tarjetacredito:tiporetencioniva.getTarjetaCreditos()) {
			TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
			tarjetacredito.setid_tipo_retencion_iva(tiporetencioniva.getId());
			TarjetaCreditoDataAccess.save(tarjetacredito,connexion);
			tarjetacreditoLogic.deepSave(tarjetacredito,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(TransaccionLocal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TransaccionLocal transaccionlocal:tiporetencioniva.getTransaccionLocals()) {
					TransaccionLocalLogic transaccionlocalLogic= new TransaccionLocalLogic(connexion);
					transaccionlocal.setid_tipo_retencion_iva(tiporetencioniva.getId());
					TransaccionLocalDataAccess.save(transaccionlocal,connexion);
					transaccionlocalLogic.deepSave(transaccionlocal,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TarjetaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TarjetaCredito tarjetacredito:tiporetencioniva.getTarjetaCreditos()) {
					TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
					tarjetacredito.setid_tipo_retencion_iva(tiporetencioniva.getId());
					TarjetaCreditoDataAccess.save(tarjetacredito,connexion);
					tarjetacreditoLogic.deepSave(tarjetacredito,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoRetencionIva.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tiporetencioniva,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoRetencionIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionIva(tiporetencioniva);
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
			this.deepLoad(this.tiporetencioniva,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoRetencionIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionIva(this.tiporetencioniva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoRetencionIva.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tiporetencionivas!=null) {
				for(TipoRetencionIva tiporetencioniva:tiporetencionivas) {
					this.deepLoad(tiporetencioniva,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoRetencionIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionIva(tiporetencionivas);
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
			if(tiporetencionivas!=null) {
				for(TipoRetencionIva tiporetencioniva:tiporetencionivas) {
					this.deepLoad(tiporetencioniva,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoRetencionIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRetencionIva(tiporetencionivas);
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
			this.getNewConnexionToDeep(TipoRetencionIva.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tiporetencioniva,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoRetencionIva.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tiporetencionivas!=null) {
				for(TipoRetencionIva tiporetencioniva:tiporetencionivas) {
					this.deepSave(tiporetencioniva,isDeep,deepLoadType,clases);
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
			if(tiporetencionivas!=null) {
				for(TipoRetencionIva tiporetencioniva:tiporetencionivas) {
					this.deepSave(tiporetencioniva,isDeep,deepLoadType,clases);
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
			if(TipoRetencionIvaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRetencionIvaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoRetencionIva tiporetencioniva,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoRetencionIvaConstantesFunciones.ISCONAUDITORIA) {
				if(tiporetencioniva.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRetencionIvaDataAccess.TABLENAME, tiporetencioniva.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoRetencionIvaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoRetencionIvaLogic.registrarAuditoriaDetallesTipoRetencionIva(connexion,tiporetencioniva,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tiporetencioniva.getIsDeleted()) {
					/*if(!tiporetencioniva.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoRetencionIvaDataAccess.TABLENAME, tiporetencioniva.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoRetencionIvaLogic.registrarAuditoriaDetallesTipoRetencionIva(connexion,tiporetencioniva,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRetencionIvaDataAccess.TABLENAME, tiporetencioniva.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tiporetencioniva.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRetencionIvaDataAccess.TABLENAME, tiporetencioniva.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoRetencionIvaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoRetencionIvaLogic.registrarAuditoriaDetallesTipoRetencionIva(connexion,tiporetencioniva,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoRetencionIva(Connexion connexion,TipoRetencionIva tiporetencioniva)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tiporetencioniva.getIsNew()||!tiporetencioniva.getcodigo().equals(tiporetencioniva.getTipoRetencionIvaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporetencioniva.getTipoRetencionIvaOriginal().getcodigo()!=null)
				{
					strValorActual=tiporetencioniva.getTipoRetencionIvaOriginal().getcodigo();
				}
				if(tiporetencioniva.getcodigo()!=null)
				{
					strValorNuevo=tiporetencioniva.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRetencionIvaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tiporetencioniva.getIsNew()||!tiporetencioniva.getnombre().equals(tiporetencioniva.getTipoRetencionIvaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporetencioniva.getTipoRetencionIvaOriginal().getnombre()!=null)
				{
					strValorActual=tiporetencioniva.getTipoRetencionIvaOriginal().getnombre();
				}
				if(tiporetencioniva.getnombre()!=null)
				{
					strValorNuevo=tiporetencioniva.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRetencionIvaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoRetencionIvaRelacionesWithConnection(TipoRetencionIva tiporetencioniva,List<TransaccionLocal> transaccionlocals,List<TarjetaCredito> tarjetacreditos) throws Exception {

		if(!tiporetencioniva.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoRetencionIvaRelacionesBase(tiporetencioniva,transaccionlocals,tarjetacreditos,true);
		}
	}

	public void saveTipoRetencionIvaRelaciones(TipoRetencionIva tiporetencioniva,List<TransaccionLocal> transaccionlocals,List<TarjetaCredito> tarjetacreditos)throws Exception {

		if(!tiporetencioniva.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoRetencionIvaRelacionesBase(tiporetencioniva,transaccionlocals,tarjetacreditos,false);
		}
	}

	public void saveTipoRetencionIvaRelacionesBase(TipoRetencionIva tiporetencioniva,List<TransaccionLocal> transaccionlocals,List<TarjetaCredito> tarjetacreditos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoRetencionIva-saveRelacionesWithConnection");}
	
			tiporetencioniva.setTransaccionLocals(transaccionlocals);
			tiporetencioniva.setTarjetaCreditos(tarjetacreditos);

			this.setTipoRetencionIva(tiporetencioniva);

				if((tiporetencioniva.getIsNew()||tiporetencioniva.getIsChanged())&&!tiporetencioniva.getIsDeleted()) {
					this.saveTipoRetencionIva();
					this.saveTipoRetencionIvaRelacionesDetalles(transaccionlocals,tarjetacreditos);

				} else if(tiporetencioniva.getIsDeleted()) {
					this.saveTipoRetencionIvaRelacionesDetalles(transaccionlocals,tarjetacreditos);
					this.saveTipoRetencionIva();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			TransaccionLocalConstantesFunciones.InicializarGeneralEntityAuxiliaresTransaccionLocals(transaccionlocals,true,true);
			TarjetaCreditoConstantesFunciones.InicializarGeneralEntityAuxiliaresTarjetaCreditos(tarjetacreditos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoRetencionIvaRelacionesDetalles(List<TransaccionLocal> transaccionlocals,List<TarjetaCredito> tarjetacreditos)throws Exception {
		try {
	

			Long idTipoRetencionIvaActual=this.getTipoRetencionIva().getId();

			TransaccionLocalLogic transaccionlocalLogic_Desde_TipoRetencionIva=new TransaccionLocalLogic();
			transaccionlocalLogic_Desde_TipoRetencionIva.setTransaccionLocals(transaccionlocals);

			transaccionlocalLogic_Desde_TipoRetencionIva.setConnexion(this.getConnexion());
			transaccionlocalLogic_Desde_TipoRetencionIva.setDatosCliente(this.datosCliente);

			for(TransaccionLocal transaccionlocal_Desde_TipoRetencionIva:transaccionlocalLogic_Desde_TipoRetencionIva.getTransaccionLocals()) {
				transaccionlocal_Desde_TipoRetencionIva.setid_tipo_retencion_iva(idTipoRetencionIvaActual);
			}

			transaccionlocalLogic_Desde_TipoRetencionIva.saveTransaccionLocals();

			TarjetaCreditoLogic tarjetacreditoLogic_Desde_TipoRetencionIva=new TarjetaCreditoLogic();
			tarjetacreditoLogic_Desde_TipoRetencionIva.setTarjetaCreditos(tarjetacreditos);

			tarjetacreditoLogic_Desde_TipoRetencionIva.setConnexion(this.getConnexion());
			tarjetacreditoLogic_Desde_TipoRetencionIva.setDatosCliente(this.datosCliente);

			for(TarjetaCredito tarjetacredito_Desde_TipoRetencionIva:tarjetacreditoLogic_Desde_TipoRetencionIva.getTarjetaCreditos()) {
				tarjetacredito_Desde_TipoRetencionIva.setid_tipo_retencion_iva(idTipoRetencionIvaActual);

				tarjetacreditoLogic_Desde_TipoRetencionIva.setTarjetaCredito(tarjetacredito_Desde_TipoRetencionIva);
				tarjetacreditoLogic_Desde_TipoRetencionIva.saveTarjetaCredito();

				Long idTarjetaCreditoActual=tarjetacredito_Desde_TipoRetencionIva.getId();

				TarjetaCreditoConexionLogic tarjetacreditoconexionLogic_Desde_TarjetaCredito=new TarjetaCreditoConexionLogic();

				if(tarjetacredito_Desde_TipoRetencionIva.getTarjetaCreditoConexions()==null){
					tarjetacredito_Desde_TipoRetencionIva.setTarjetaCreditoConexions(new ArrayList<TarjetaCreditoConexion>());
				}

				tarjetacreditoconexionLogic_Desde_TarjetaCredito.setTarjetaCreditoConexions(tarjetacredito_Desde_TipoRetencionIva.getTarjetaCreditoConexions());

				tarjetacreditoconexionLogic_Desde_TarjetaCredito.setConnexion(this.getConnexion());
				tarjetacreditoconexionLogic_Desde_TarjetaCredito.setDatosCliente(this.datosCliente);

				for(TarjetaCreditoConexion tarjetacreditoconexion_Desde_TarjetaCredito:tarjetacreditoconexionLogic_Desde_TarjetaCredito.getTarjetaCreditoConexions()) {
					tarjetacreditoconexion_Desde_TarjetaCredito.setid_tarjeta_credito(idTarjetaCreditoActual);
				}

				tarjetacreditoconexionLogic_Desde_TarjetaCredito.saveTarjetaCreditoConexions();

				TarjetaCreditoDescuentoLogic tarjetacreditodescuentoLogic_Desde_TarjetaCredito=new TarjetaCreditoDescuentoLogic();

				if(tarjetacredito_Desde_TipoRetencionIva.getTarjetaCreditoDescuentos()==null){
					tarjetacredito_Desde_TipoRetencionIva.setTarjetaCreditoDescuentos(new ArrayList<TarjetaCreditoDescuento>());
				}

				tarjetacreditodescuentoLogic_Desde_TarjetaCredito.setTarjetaCreditoDescuentos(tarjetacredito_Desde_TipoRetencionIva.getTarjetaCreditoDescuentos());

				tarjetacreditodescuentoLogic_Desde_TarjetaCredito.setConnexion(this.getConnexion());
				tarjetacreditodescuentoLogic_Desde_TarjetaCredito.setDatosCliente(this.datosCliente);

				for(TarjetaCreditoDescuento tarjetacreditodescuento_Desde_TarjetaCredito:tarjetacreditodescuentoLogic_Desde_TarjetaCredito.getTarjetaCreditoDescuentos()) {
					tarjetacreditodescuento_Desde_TarjetaCredito.setid_tarjeta_credito(idTarjetaCreditoActual);
				}

				tarjetacreditodescuentoLogic_Desde_TarjetaCredito.saveTarjetaCreditoDescuentos();

				FormaPagoPuntoVentaLogic formapagopuntoventaLogic_Desde_TarjetaCredito=new FormaPagoPuntoVentaLogic();

				if(tarjetacredito_Desde_TipoRetencionIva.getFormaPagoPuntoVentas()==null){
					tarjetacredito_Desde_TipoRetencionIva.setFormaPagoPuntoVentas(new ArrayList<FormaPagoPuntoVenta>());
				}

				formapagopuntoventaLogic_Desde_TarjetaCredito.setFormaPagoPuntoVentas(tarjetacredito_Desde_TipoRetencionIva.getFormaPagoPuntoVentas());

				formapagopuntoventaLogic_Desde_TarjetaCredito.setConnexion(this.getConnexion());
				formapagopuntoventaLogic_Desde_TarjetaCredito.setDatosCliente(this.datosCliente);

				for(FormaPagoPuntoVenta formapagopuntoventa_Desde_TarjetaCredito:formapagopuntoventaLogic_Desde_TarjetaCredito.getFormaPagoPuntoVentas()) {
					formapagopuntoventa_Desde_TarjetaCredito.setid_tarjeta_credito(idTarjetaCreditoActual);
				}

				formapagopuntoventaLogic_Desde_TarjetaCredito.saveFormaPagoPuntoVentas();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRetencionIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoRetencionIvaConstantesFunciones.getClassesForeignKeysOfTipoRetencionIva(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRetencionIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoRetencionIvaConstantesFunciones.getClassesRelationshipsOfTipoRetencionIva(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

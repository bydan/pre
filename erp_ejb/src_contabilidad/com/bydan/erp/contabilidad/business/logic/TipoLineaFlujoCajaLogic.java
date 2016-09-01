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
import com.bydan.erp.contabilidad.util.TipoLineaFlujoCajaConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoLineaFlujoCajaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoLineaFlujoCajaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.TipoLineaFlujoCaja;
import com.bydan.erp.contabilidad.business.logic.TipoLineaFlujoCajaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoLineaFlujoCajaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoLineaFlujoCajaLogic.class);
	
	protected TipoLineaFlujoCajaDataAccess tipolineaflujocajaDataAccess; 	
	protected TipoLineaFlujoCaja tipolineaflujocaja;
	protected List<TipoLineaFlujoCaja> tipolineaflujocajas;
	protected Object tipolineaflujocajaObject;	
	protected List<Object> tipolineaflujocajasObject;
	
	public static ClassValidator<TipoLineaFlujoCaja> tipolineaflujocajaValidator = new ClassValidator<TipoLineaFlujoCaja>(TipoLineaFlujoCaja.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoLineaFlujoCajaLogicAdditional tipolineaflujocajaLogicAdditional=null;
	
	public TipoLineaFlujoCajaLogicAdditional getTipoLineaFlujoCajaLogicAdditional() {
		return this.tipolineaflujocajaLogicAdditional;
	}
	
	public void setTipoLineaFlujoCajaLogicAdditional(TipoLineaFlujoCajaLogicAdditional tipolineaflujocajaLogicAdditional) {
		try {
			this.tipolineaflujocajaLogicAdditional=tipolineaflujocajaLogicAdditional;
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
	
	
	
	
	public  TipoLineaFlujoCajaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipolineaflujocajaDataAccess = new TipoLineaFlujoCajaDataAccess();
			
			this.tipolineaflujocajas= new ArrayList<TipoLineaFlujoCaja>();
			this.tipolineaflujocaja= new TipoLineaFlujoCaja();
			
			this.tipolineaflujocajaObject=new Object();
			this.tipolineaflujocajasObject=new ArrayList<Object>();
				
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
			
			this.tipolineaflujocajaDataAccess.setConnexionType(this.connexionType);
			this.tipolineaflujocajaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoLineaFlujoCajaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipolineaflujocajaDataAccess = new TipoLineaFlujoCajaDataAccess();
			this.tipolineaflujocajas= new ArrayList<TipoLineaFlujoCaja>();
			this.tipolineaflujocaja= new TipoLineaFlujoCaja();
			this.tipolineaflujocajaObject=new Object();
			this.tipolineaflujocajasObject=new ArrayList<Object>();
			
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
			
			this.tipolineaflujocajaDataAccess.setConnexionType(this.connexionType);
			this.tipolineaflujocajaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoLineaFlujoCaja getTipoLineaFlujoCaja() throws Exception {	
		TipoLineaFlujoCajaLogicAdditional.checkTipoLineaFlujoCajaToGet(tipolineaflujocaja,this.datosCliente,this.arrDatoGeneral);
		TipoLineaFlujoCajaLogicAdditional.updateTipoLineaFlujoCajaToGet(tipolineaflujocaja,this.arrDatoGeneral);
		
		return tipolineaflujocaja;
	}
		
	public void setTipoLineaFlujoCaja(TipoLineaFlujoCaja newTipoLineaFlujoCaja) {
		this.tipolineaflujocaja = newTipoLineaFlujoCaja;
	}
	
	public TipoLineaFlujoCajaDataAccess getTipoLineaFlujoCajaDataAccess() {
		return tipolineaflujocajaDataAccess;
	}
	
	public void setTipoLineaFlujoCajaDataAccess(TipoLineaFlujoCajaDataAccess newtipolineaflujocajaDataAccess) {
		this.tipolineaflujocajaDataAccess = newtipolineaflujocajaDataAccess;
	}
	
	public List<TipoLineaFlujoCaja> getTipoLineaFlujoCajas() throws Exception {		
		this.quitarTipoLineaFlujoCajasNulos();
		
		TipoLineaFlujoCajaLogicAdditional.checkTipoLineaFlujoCajaToGets(tipolineaflujocajas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoLineaFlujoCaja tipolineaflujocajaLocal: tipolineaflujocajas ) {
			TipoLineaFlujoCajaLogicAdditional.updateTipoLineaFlujoCajaToGet(tipolineaflujocajaLocal,this.arrDatoGeneral);
		}
		
		return tipolineaflujocajas;
	}
	
	public void setTipoLineaFlujoCajas(List<TipoLineaFlujoCaja> newTipoLineaFlujoCajas) {
		this.tipolineaflujocajas = newTipoLineaFlujoCajas;
	}
	
	public Object getTipoLineaFlujoCajaObject() {	
		this.tipolineaflujocajaObject=this.tipolineaflujocajaDataAccess.getEntityObject();
		return this.tipolineaflujocajaObject;
	}
		
	public void setTipoLineaFlujoCajaObject(Object newTipoLineaFlujoCajaObject) {
		this.tipolineaflujocajaObject = newTipoLineaFlujoCajaObject;
	}
	
	public List<Object> getTipoLineaFlujoCajasObject() {		
		this.tipolineaflujocajasObject=this.tipolineaflujocajaDataAccess.getEntitiesObject();
		return this.tipolineaflujocajasObject;
	}
		
	public void setTipoLineaFlujoCajasObject(List<Object> newTipoLineaFlujoCajasObject) {
		this.tipolineaflujocajasObject = newTipoLineaFlujoCajasObject;
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
		
		if(this.tipolineaflujocajaDataAccess!=null) {
			this.tipolineaflujocajaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipolineaflujocajaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipolineaflujocajaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipolineaflujocaja = new  TipoLineaFlujoCaja();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipolineaflujocaja=tipolineaflujocajaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipolineaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocaja);
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
		tipolineaflujocaja = new  TipoLineaFlujoCaja();
		  		  
        try {
			
			tipolineaflujocaja=tipolineaflujocajaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipolineaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipolineaflujocaja = new  TipoLineaFlujoCaja();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipolineaflujocaja=tipolineaflujocajaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipolineaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocaja);
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
		tipolineaflujocaja = new  TipoLineaFlujoCaja();
		  		  
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
		tipolineaflujocaja = new  TipoLineaFlujoCaja();
		  		  
        try {
			
			tipolineaflujocaja=tipolineaflujocajaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipolineaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipolineaflujocaja = new  TipoLineaFlujoCaja();
		  		  
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
		tipolineaflujocaja = new  TipoLineaFlujoCaja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipolineaflujocajaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipolineaflujocaja = new  TipoLineaFlujoCaja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipolineaflujocajaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipolineaflujocaja = new  TipoLineaFlujoCaja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipolineaflujocajaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipolineaflujocaja = new  TipoLineaFlujoCaja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipolineaflujocajaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipolineaflujocaja = new  TipoLineaFlujoCaja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipolineaflujocajaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipolineaflujocaja = new  TipoLineaFlujoCaja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipolineaflujocajaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipolineaflujocajas = new  ArrayList<TipoLineaFlujoCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolineaflujocajas=tipolineaflujocajaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoLineaFlujoCaja(tipolineaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocajas);
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
		tipolineaflujocajas = new  ArrayList<TipoLineaFlujoCaja>();
		  		  
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
		tipolineaflujocajas = new  ArrayList<TipoLineaFlujoCaja>();
		  		  
        try {			
			TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolineaflujocajas=tipolineaflujocajaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoLineaFlujoCaja(tipolineaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocajas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipolineaflujocajas = new  ArrayList<TipoLineaFlujoCaja>();
		  		  
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
		tipolineaflujocajas = new  ArrayList<TipoLineaFlujoCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolineaflujocajas=tipolineaflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoLineaFlujoCaja(tipolineaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocajas);
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
		tipolineaflujocajas = new  ArrayList<TipoLineaFlujoCaja>();
		  		  
        try {
			TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolineaflujocajas=tipolineaflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoLineaFlujoCaja(tipolineaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocajas);
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
		tipolineaflujocajas = new  ArrayList<TipoLineaFlujoCaja>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolineaflujocajas=tipolineaflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoLineaFlujoCaja(tipolineaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocajas);
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
		tipolineaflujocajas = new  ArrayList<TipoLineaFlujoCaja>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolineaflujocajas=tipolineaflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoLineaFlujoCaja(tipolineaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocajas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipolineaflujocaja = new  TipoLineaFlujoCaja();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolineaflujocaja=tipolineaflujocajaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoLineaFlujoCaja(tipolineaflujocaja);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocaja);
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
		tipolineaflujocaja = new  TipoLineaFlujoCaja();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolineaflujocaja=tipolineaflujocajaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoLineaFlujoCaja(tipolineaflujocaja);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipolineaflujocajas = new  ArrayList<TipoLineaFlujoCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolineaflujocajas=tipolineaflujocajaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoLineaFlujoCaja(tipolineaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocajas);
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
		tipolineaflujocajas = new  ArrayList<TipoLineaFlujoCaja>();
		  		  
        try {
			TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolineaflujocajas=tipolineaflujocajaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoLineaFlujoCaja(tipolineaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocajas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoLineaFlujoCajasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipolineaflujocajas = new  ArrayList<TipoLineaFlujoCaja>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-getTodosTipoLineaFlujoCajasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolineaflujocajas=tipolineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoLineaFlujoCaja(tipolineaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocajas);
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
	
	public  void  getTodosTipoLineaFlujoCajas(String sFinalQuery,Pagination pagination)throws Exception {
		tipolineaflujocajas = new  ArrayList<TipoLineaFlujoCaja>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolineaflujocajas=tipolineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoLineaFlujoCaja(tipolineaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocajas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoLineaFlujoCaja(TipoLineaFlujoCaja tipolineaflujocaja) throws Exception {
		Boolean estaValidado=false;
		
		if(tipolineaflujocaja.getIsNew() || tipolineaflujocaja.getIsChanged()) { 
			this.invalidValues = tipolineaflujocajaValidator.getInvalidValues(tipolineaflujocaja);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipolineaflujocaja);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoLineaFlujoCaja(List<TipoLineaFlujoCaja> TipoLineaFlujoCajas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoLineaFlujoCaja tipolineaflujocajaLocal:tipolineaflujocajas) {				
			estaValidadoObjeto=this.validarGuardarTipoLineaFlujoCaja(tipolineaflujocajaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoLineaFlujoCaja(List<TipoLineaFlujoCaja> TipoLineaFlujoCajas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoLineaFlujoCaja(tipolineaflujocajas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoLineaFlujoCaja(TipoLineaFlujoCaja TipoLineaFlujoCaja) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoLineaFlujoCaja(tipolineaflujocaja)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoLineaFlujoCaja tipolineaflujocaja) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipolineaflujocaja.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoLineaFlujoCajaConstantesFunciones.getTipoLineaFlujoCajaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipolineaflujocaja","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoLineaFlujoCajaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoLineaFlujoCajaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoLineaFlujoCajaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-saveTipoLineaFlujoCajaWithConnection");connexion.begin();			
			
			TipoLineaFlujoCajaLogicAdditional.checkTipoLineaFlujoCajaToSave(this.tipolineaflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoLineaFlujoCajaLogicAdditional.updateTipoLineaFlujoCajaToSave(this.tipolineaflujocaja,this.arrDatoGeneral);
			
			TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipolineaflujocaja,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoLineaFlujoCaja();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoLineaFlujoCaja(this.tipolineaflujocaja)) {
				TipoLineaFlujoCajaDataAccess.save(this.tipolineaflujocaja, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipolineaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoLineaFlujoCajaLogicAdditional.checkTipoLineaFlujoCajaToSaveAfter(this.tipolineaflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoLineaFlujoCaja();
			
			connexion.commit();			
			
			if(this.tipolineaflujocaja.getIsDeleted()) {
				this.tipolineaflujocaja=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoLineaFlujoCaja()throws Exception {	
		try {	
			
			TipoLineaFlujoCajaLogicAdditional.checkTipoLineaFlujoCajaToSave(this.tipolineaflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoLineaFlujoCajaLogicAdditional.updateTipoLineaFlujoCajaToSave(this.tipolineaflujocaja,this.arrDatoGeneral);
			
			TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipolineaflujocaja,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoLineaFlujoCaja(this.tipolineaflujocaja)) {			
				TipoLineaFlujoCajaDataAccess.save(this.tipolineaflujocaja, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipolineaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoLineaFlujoCajaLogicAdditional.checkTipoLineaFlujoCajaToSaveAfter(this.tipolineaflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipolineaflujocaja.getIsDeleted()) {
				this.tipolineaflujocaja=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoLineaFlujoCajasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-saveTipoLineaFlujoCajasWithConnection");connexion.begin();			
			
			TipoLineaFlujoCajaLogicAdditional.checkTipoLineaFlujoCajaToSaves(tipolineaflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoLineaFlujoCajas();
			
			Boolean validadoTodosTipoLineaFlujoCaja=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoLineaFlujoCaja tipolineaflujocajaLocal:tipolineaflujocajas) {		
				if(tipolineaflujocajaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoLineaFlujoCajaLogicAdditional.updateTipoLineaFlujoCajaToSave(tipolineaflujocajaLocal,this.arrDatoGeneral);
	        	
				TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipolineaflujocajaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoLineaFlujoCaja(tipolineaflujocajaLocal)) {
					TipoLineaFlujoCajaDataAccess.save(tipolineaflujocajaLocal, connexion);				
				} else {
					validadoTodosTipoLineaFlujoCaja=false;
				}
			}
			
			if(!validadoTodosTipoLineaFlujoCaja) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoLineaFlujoCajaLogicAdditional.checkTipoLineaFlujoCajaToSavesAfter(tipolineaflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoLineaFlujoCajas();
			
			connexion.commit();		
			
			this.quitarTipoLineaFlujoCajasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoLineaFlujoCajas()throws Exception {				
		 try {	
			TipoLineaFlujoCajaLogicAdditional.checkTipoLineaFlujoCajaToSaves(tipolineaflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoLineaFlujoCaja=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoLineaFlujoCaja tipolineaflujocajaLocal:tipolineaflujocajas) {				
				if(tipolineaflujocajaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoLineaFlujoCajaLogicAdditional.updateTipoLineaFlujoCajaToSave(tipolineaflujocajaLocal,this.arrDatoGeneral);
	        	
				TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipolineaflujocajaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoLineaFlujoCaja(tipolineaflujocajaLocal)) {				
					TipoLineaFlujoCajaDataAccess.save(tipolineaflujocajaLocal, connexion);				
				} else {
					validadoTodosTipoLineaFlujoCaja=false;
				}
			}
			
			if(!validadoTodosTipoLineaFlujoCaja) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoLineaFlujoCajaLogicAdditional.checkTipoLineaFlujoCajaToSavesAfter(tipolineaflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoLineaFlujoCajasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoLineaFlujoCajaParameterReturnGeneral procesarAccionTipoLineaFlujoCajas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoLineaFlujoCaja> tipolineaflujocajas,TipoLineaFlujoCajaParameterReturnGeneral tipolineaflujocajaParameterGeneral)throws Exception {
		 try {	
			TipoLineaFlujoCajaParameterReturnGeneral tipolineaflujocajaReturnGeneral=new TipoLineaFlujoCajaParameterReturnGeneral();
	
			TipoLineaFlujoCajaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipolineaflujocajas,tipolineaflujocajaParameterGeneral,tipolineaflujocajaReturnGeneral);
			
			return tipolineaflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoLineaFlujoCajaParameterReturnGeneral procesarAccionTipoLineaFlujoCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoLineaFlujoCaja> tipolineaflujocajas,TipoLineaFlujoCajaParameterReturnGeneral tipolineaflujocajaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-procesarAccionTipoLineaFlujoCajasWithConnection");connexion.begin();			
			
			TipoLineaFlujoCajaParameterReturnGeneral tipolineaflujocajaReturnGeneral=new TipoLineaFlujoCajaParameterReturnGeneral();
	
			TipoLineaFlujoCajaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipolineaflujocajas,tipolineaflujocajaParameterGeneral,tipolineaflujocajaReturnGeneral);
			
			this.connexion.commit();
			
			return tipolineaflujocajaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoLineaFlujoCajaParameterReturnGeneral procesarEventosTipoLineaFlujoCajas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoLineaFlujoCaja> tipolineaflujocajas,TipoLineaFlujoCaja tipolineaflujocaja,TipoLineaFlujoCajaParameterReturnGeneral tipolineaflujocajaParameterGeneral,Boolean isEsNuevoTipoLineaFlujoCaja,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoLineaFlujoCajaParameterReturnGeneral tipolineaflujocajaReturnGeneral=new TipoLineaFlujoCajaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipolineaflujocajaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoLineaFlujoCajaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipolineaflujocajas,tipolineaflujocaja,tipolineaflujocajaParameterGeneral,tipolineaflujocajaReturnGeneral,isEsNuevoTipoLineaFlujoCaja,clases);
			
			return tipolineaflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoLineaFlujoCajaParameterReturnGeneral procesarEventosTipoLineaFlujoCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoLineaFlujoCaja> tipolineaflujocajas,TipoLineaFlujoCaja tipolineaflujocaja,TipoLineaFlujoCajaParameterReturnGeneral tipolineaflujocajaParameterGeneral,Boolean isEsNuevoTipoLineaFlujoCaja,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-procesarEventosTipoLineaFlujoCajasWithConnection");connexion.begin();			
			
			TipoLineaFlujoCajaParameterReturnGeneral tipolineaflujocajaReturnGeneral=new TipoLineaFlujoCajaParameterReturnGeneral();
	
			tipolineaflujocajaReturnGeneral.setTipoLineaFlujoCaja(tipolineaflujocaja);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipolineaflujocajaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoLineaFlujoCajaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipolineaflujocajas,tipolineaflujocaja,tipolineaflujocajaParameterGeneral,tipolineaflujocajaReturnGeneral,isEsNuevoTipoLineaFlujoCaja,clases);
			
			this.connexion.commit();
			
			return tipolineaflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoLineaFlujoCajaParameterReturnGeneral procesarImportacionTipoLineaFlujoCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoLineaFlujoCajaParameterReturnGeneral tipolineaflujocajaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-procesarImportacionTipoLineaFlujoCajasWithConnection");connexion.begin();			
			
			TipoLineaFlujoCajaParameterReturnGeneral tipolineaflujocajaReturnGeneral=new TipoLineaFlujoCajaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipolineaflujocajas=new ArrayList<TipoLineaFlujoCaja>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipolineaflujocaja=new TipoLineaFlujoCaja();
				
				
				if(conColumnasBase) {this.tipolineaflujocaja.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipolineaflujocaja.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipolineaflujocaja.setnombre(arrColumnas[iColumn++]);
				this.tipolineaflujocaja.setcodigo_sri(arrColumnas[iColumn++]);
				
				this.tipolineaflujocajas.add(this.tipolineaflujocaja);
			}
			
			this.saveTipoLineaFlujoCajas();
			
			this.connexion.commit();
			
			tipolineaflujocajaReturnGeneral.setConRetornoEstaProcesado(true);
			tipolineaflujocajaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipolineaflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoLineaFlujoCajasEliminados() throws Exception {				
		
		List<TipoLineaFlujoCaja> tipolineaflujocajasAux= new ArrayList<TipoLineaFlujoCaja>();
		
		for(TipoLineaFlujoCaja tipolineaflujocaja:tipolineaflujocajas) {
			if(!tipolineaflujocaja.getIsDeleted()) {
				tipolineaflujocajasAux.add(tipolineaflujocaja);
			}
		}
		
		tipolineaflujocajas=tipolineaflujocajasAux;
	}
	
	public void quitarTipoLineaFlujoCajasNulos() throws Exception {				
		
		List<TipoLineaFlujoCaja> tipolineaflujocajasAux= new ArrayList<TipoLineaFlujoCaja>();
		
		for(TipoLineaFlujoCaja tipolineaflujocaja : this.tipolineaflujocajas) {
			if(tipolineaflujocaja==null) {
				tipolineaflujocajasAux.add(tipolineaflujocaja);
			}
		}
		
		//this.tipolineaflujocajas=tipolineaflujocajasAux;
		
		this.tipolineaflujocajas.removeAll(tipolineaflujocajasAux);
	}
	
	public void getSetVersionRowTipoLineaFlujoCajaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipolineaflujocaja.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipolineaflujocaja.getIsDeleted() || (tipolineaflujocaja.getIsChanged()&&!tipolineaflujocaja.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipolineaflujocajaDataAccess.getSetVersionRowTipoLineaFlujoCaja(connexion,tipolineaflujocaja.getId());
				
				if(!tipolineaflujocaja.getVersionRow().equals(timestamp)) {	
					tipolineaflujocaja.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipolineaflujocaja.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoLineaFlujoCaja()throws Exception {	
		
		if(tipolineaflujocaja.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipolineaflujocaja.getIsDeleted() || (tipolineaflujocaja.getIsChanged()&&!tipolineaflujocaja.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipolineaflujocajaDataAccess.getSetVersionRowTipoLineaFlujoCaja(connexion,tipolineaflujocaja.getId());
			
			try {							
				if(!tipolineaflujocaja.getVersionRow().equals(timestamp)) {	
					tipolineaflujocaja.setVersionRow(timestamp);
				}
				
				tipolineaflujocaja.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoLineaFlujoCajasWithConnection()throws Exception {	
		if(tipolineaflujocajas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoLineaFlujoCaja tipolineaflujocajaAux:tipolineaflujocajas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipolineaflujocajaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipolineaflujocajaAux.getIsDeleted() || (tipolineaflujocajaAux.getIsChanged()&&!tipolineaflujocajaAux.getIsNew())) {
						
						timestamp=tipolineaflujocajaDataAccess.getSetVersionRowTipoLineaFlujoCaja(connexion,tipolineaflujocajaAux.getId());
						
						if(!tipolineaflujocaja.getVersionRow().equals(timestamp)) {	
							tipolineaflujocajaAux.setVersionRow(timestamp);
						}
								
						tipolineaflujocajaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoLineaFlujoCajas()throws Exception {	
		if(tipolineaflujocajas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoLineaFlujoCaja tipolineaflujocajaAux:tipolineaflujocajas) {
					if(tipolineaflujocajaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipolineaflujocajaAux.getIsDeleted() || (tipolineaflujocajaAux.getIsChanged()&&!tipolineaflujocajaAux.getIsNew())) {
						
						timestamp=tipolineaflujocajaDataAccess.getSetVersionRowTipoLineaFlujoCaja(connexion,tipolineaflujocajaAux.getId());
						
						if(!tipolineaflujocajaAux.getVersionRow().equals(timestamp)) {	
							tipolineaflujocajaAux.setVersionRow(timestamp);
						}
						
													
						tipolineaflujocajaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoLineaFlujoCajaParameterReturnGeneral cargarCombosLoteForeignKeyTipoLineaFlujoCajaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoLineaFlujoCajaParameterReturnGeneral  tipolineaflujocajaReturnGeneral =new TipoLineaFlujoCajaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoLineaFlujoCajaWithConnection");connexion.begin();
			
			tipolineaflujocajaReturnGeneral =new TipoLineaFlujoCajaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipolineaflujocajaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipolineaflujocajaReturnGeneral;
	}
	
	public TipoLineaFlujoCajaParameterReturnGeneral cargarCombosLoteForeignKeyTipoLineaFlujoCaja(String finalQueryGlobalEmpresa) throws Exception {
		TipoLineaFlujoCajaParameterReturnGeneral  tipolineaflujocajaReturnGeneral =new TipoLineaFlujoCajaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipolineaflujocajaReturnGeneral =new TipoLineaFlujoCajaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipolineaflujocajaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipolineaflujocajaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoLineaFlujoCajaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			LineaFlujoCajaLogic lineaflujocajaLogic=new LineaFlujoCajaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoLineaFlujoCajaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(LineaFlujoCaja.class));
											
			

			lineaflujocajaLogic.setConnexion(this.getConnexion());
			lineaflujocajaLogic.setDatosCliente(this.datosCliente);
			lineaflujocajaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoLineaFlujoCaja tipolineaflujocaja:this.tipolineaflujocajas) {
				

				classes=new ArrayList<Classe>();
				classes=LineaFlujoCajaConstantesFunciones.getClassesForeignKeysOfLineaFlujoCaja(new ArrayList<Classe>(),DeepLoadType.NONE);

				lineaflujocajaLogic.setLineaFlujoCajas(tipolineaflujocaja.lineaflujocajas);
				lineaflujocajaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoLineaFlujoCaja tipolineaflujocaja,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoLineaFlujoCajaLogicAdditional.updateTipoLineaFlujoCajaToGet(tipolineaflujocaja,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipolineaflujocaja.setEmpresa(tipolineaflujocajaDataAccess.getEmpresa(connexion,tipolineaflujocaja));
		tipolineaflujocaja.setLineaFlujoCajas(tipolineaflujocajaDataAccess.getLineaFlujoCajas(connexion,tipolineaflujocaja));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipolineaflujocaja.setEmpresa(tipolineaflujocajaDataAccess.getEmpresa(connexion,tipolineaflujocaja));
				continue;
			}

			if(clas.clas.equals(LineaFlujoCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipolineaflujocaja.setLineaFlujoCajas(tipolineaflujocajaDataAccess.getLineaFlujoCajas(connexion,tipolineaflujocaja));

				if(this.isConDeep) {
					LineaFlujoCajaLogic lineaflujocajaLogic= new LineaFlujoCajaLogic(this.connexion);
					lineaflujocajaLogic.setLineaFlujoCajas(tipolineaflujocaja.getLineaFlujoCajas());
					ArrayList<Classe> classesLocal=LineaFlujoCajaConstantesFunciones.getClassesForeignKeysOfLineaFlujoCaja(new ArrayList<Classe>(),DeepLoadType.NONE);
					lineaflujocajaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(lineaflujocajaLogic.getLineaFlujoCajas());
					tipolineaflujocaja.setLineaFlujoCajas(lineaflujocajaLogic.getLineaFlujoCajas());
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
			tipolineaflujocaja.setEmpresa(tipolineaflujocajaDataAccess.getEmpresa(connexion,tipolineaflujocaja));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(LineaFlujoCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(LineaFlujoCaja.class));
			tipolineaflujocaja.setLineaFlujoCajas(tipolineaflujocajaDataAccess.getLineaFlujoCajas(connexion,tipolineaflujocaja));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipolineaflujocaja.setEmpresa(tipolineaflujocajaDataAccess.getEmpresa(connexion,tipolineaflujocaja));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipolineaflujocaja.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipolineaflujocaja.setLineaFlujoCajas(tipolineaflujocajaDataAccess.getLineaFlujoCajas(connexion,tipolineaflujocaja));

		for(LineaFlujoCaja lineaflujocaja:tipolineaflujocaja.getLineaFlujoCajas()) {
			LineaFlujoCajaLogic lineaflujocajaLogic= new LineaFlujoCajaLogic(connexion);
			lineaflujocajaLogic.deepLoad(lineaflujocaja,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipolineaflujocaja.setEmpresa(tipolineaflujocajaDataAccess.getEmpresa(connexion,tipolineaflujocaja));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipolineaflujocaja.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(LineaFlujoCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipolineaflujocaja.setLineaFlujoCajas(tipolineaflujocajaDataAccess.getLineaFlujoCajas(connexion,tipolineaflujocaja));

				for(LineaFlujoCaja lineaflujocaja:tipolineaflujocaja.getLineaFlujoCajas()) {
					LineaFlujoCajaLogic lineaflujocajaLogic= new LineaFlujoCajaLogic(connexion);
					lineaflujocajaLogic.deepLoad(lineaflujocaja,isDeep,deepLoadType,clases);
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
			tipolineaflujocaja.setEmpresa(tipolineaflujocajaDataAccess.getEmpresa(connexion,tipolineaflujocaja));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipolineaflujocaja.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(LineaFlujoCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(LineaFlujoCaja.class));
			tipolineaflujocaja.setLineaFlujoCajas(tipolineaflujocajaDataAccess.getLineaFlujoCajas(connexion,tipolineaflujocaja));

			for(LineaFlujoCaja lineaflujocaja:tipolineaflujocaja.getLineaFlujoCajas()) {
				LineaFlujoCajaLogic lineaflujocajaLogic= new LineaFlujoCajaLogic(connexion);
				lineaflujocajaLogic.deepLoad(lineaflujocaja,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoLineaFlujoCaja tipolineaflujocaja,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoLineaFlujoCajaLogicAdditional.updateTipoLineaFlujoCajaToSave(tipolineaflujocaja,this.arrDatoGeneral);
			
TipoLineaFlujoCajaDataAccess.save(tipolineaflujocaja, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipolineaflujocaja.getEmpresa(),connexion);

		for(LineaFlujoCaja lineaflujocaja:tipolineaflujocaja.getLineaFlujoCajas()) {
			lineaflujocaja.setid_tipo_linea_flujo_caja(tipolineaflujocaja.getId());
			LineaFlujoCajaDataAccess.save(lineaflujocaja,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipolineaflujocaja.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(LineaFlujoCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(LineaFlujoCaja lineaflujocaja:tipolineaflujocaja.getLineaFlujoCajas()) {
					lineaflujocaja.setid_tipo_linea_flujo_caja(tipolineaflujocaja.getId());
					LineaFlujoCajaDataAccess.save(lineaflujocaja,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipolineaflujocaja.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipolineaflujocaja.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(LineaFlujoCaja lineaflujocaja:tipolineaflujocaja.getLineaFlujoCajas()) {
			LineaFlujoCajaLogic lineaflujocajaLogic= new LineaFlujoCajaLogic(connexion);
			lineaflujocaja.setid_tipo_linea_flujo_caja(tipolineaflujocaja.getId());
			LineaFlujoCajaDataAccess.save(lineaflujocaja,connexion);
			lineaflujocajaLogic.deepSave(lineaflujocaja,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipolineaflujocaja.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipolineaflujocaja.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(LineaFlujoCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(LineaFlujoCaja lineaflujocaja:tipolineaflujocaja.getLineaFlujoCajas()) {
					LineaFlujoCajaLogic lineaflujocajaLogic= new LineaFlujoCajaLogic(connexion);
					lineaflujocaja.setid_tipo_linea_flujo_caja(tipolineaflujocaja.getId());
					LineaFlujoCajaDataAccess.save(lineaflujocaja,connexion);
					lineaflujocajaLogic.deepSave(lineaflujocaja,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoLineaFlujoCaja.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipolineaflujocaja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(tipolineaflujocaja);
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
			this.deepLoad(this.tipolineaflujocaja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoLineaFlujoCaja.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipolineaflujocajas!=null) {
				for(TipoLineaFlujoCaja tipolineaflujocaja:tipolineaflujocajas) {
					this.deepLoad(tipolineaflujocaja,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(tipolineaflujocajas);
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
			if(tipolineaflujocajas!=null) {
				for(TipoLineaFlujoCaja tipolineaflujocaja:tipolineaflujocajas) {
					this.deepLoad(tipolineaflujocaja,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(tipolineaflujocajas);
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
			this.getNewConnexionToDeep(TipoLineaFlujoCaja.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipolineaflujocaja,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoLineaFlujoCaja.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipolineaflujocajas!=null) {
				for(TipoLineaFlujoCaja tipolineaflujocaja:tipolineaflujocajas) {
					this.deepSave(tipolineaflujocaja,isDeep,deepLoadType,clases);
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
			if(tipolineaflujocajas!=null) {
				for(TipoLineaFlujoCaja tipolineaflujocaja:tipolineaflujocajas) {
					this.deepSave(tipolineaflujocaja,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoLineaFlujoCajasBusquedaPorCodigoSriWithConnection(String sFinalQuery,Pagination pagination,String codigo_sri)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigoSri= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigoSri.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo_sri+"%",TipoLineaFlujoCajaConstantesFunciones.CODIGOSRI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigoSri);

			TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigoSri","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipolineaflujocajas=tipolineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoLineaFlujoCajasBusquedaPorCodigoSri(String sFinalQuery,Pagination pagination,String codigo_sri)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigoSri= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigoSri.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo_sri+"%",TipoLineaFlujoCajaConstantesFunciones.CODIGOSRI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigoSri);

			TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigoSri","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipolineaflujocajas=tipolineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoLineaFlujoCajasBusquedaPorIdWithConnection(String sFinalQuery,Pagination pagination,Long id)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TipoLineaFlujoCajaConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorId","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipolineaflujocajas=tipolineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoLineaFlujoCajasBusquedaPorId(String sFinalQuery,Pagination pagination,Long id)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TipoLineaFlujoCajaConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorId","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipolineaflujocajas=tipolineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoLineaFlujoCajasBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoLineaFlujoCajaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipolineaflujocajas=tipolineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoLineaFlujoCajasBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoLineaFlujoCajaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipolineaflujocajas=tipolineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoLineaFlujoCajasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoLineaFlujoCajaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipolineaflujocajas=tipolineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoLineaFlujoCajasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoLineaFlujoCajaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoLineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipolineaflujocajas=tipolineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoLineaFlujoCajaPorNombreWithConnection(String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLineaFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoLineaFlujoCajaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipolineaflujocaja=tipolineaflujocajaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipolineaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocaja);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoLineaFlujoCajaPorNombre(String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoLineaFlujoCajaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipolineaflujocaja=tipolineaflujocajaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipolineaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoLineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoLineaFlujoCaja(this.tipolineaflujocaja);
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
			if(TipoLineaFlujoCajaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoLineaFlujoCajaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoLineaFlujoCaja tipolineaflujocaja,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoLineaFlujoCajaConstantesFunciones.ISCONAUDITORIA) {
				if(tipolineaflujocaja.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoLineaFlujoCajaDataAccess.TABLENAME, tipolineaflujocaja.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoLineaFlujoCajaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoLineaFlujoCajaLogic.registrarAuditoriaDetallesTipoLineaFlujoCaja(connexion,tipolineaflujocaja,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipolineaflujocaja.getIsDeleted()) {
					/*if(!tipolineaflujocaja.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoLineaFlujoCajaDataAccess.TABLENAME, tipolineaflujocaja.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoLineaFlujoCajaLogic.registrarAuditoriaDetallesTipoLineaFlujoCaja(connexion,tipolineaflujocaja,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoLineaFlujoCajaDataAccess.TABLENAME, tipolineaflujocaja.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipolineaflujocaja.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoLineaFlujoCajaDataAccess.TABLENAME, tipolineaflujocaja.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoLineaFlujoCajaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoLineaFlujoCajaLogic.registrarAuditoriaDetallesTipoLineaFlujoCaja(connexion,tipolineaflujocaja,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoLineaFlujoCaja(Connexion connexion,TipoLineaFlujoCaja tipolineaflujocaja)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipolineaflujocaja.getIsNew()||!tipolineaflujocaja.getid_empresa().equals(tipolineaflujocaja.getTipoLineaFlujoCajaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipolineaflujocaja.getTipoLineaFlujoCajaOriginal().getid_empresa()!=null)
				{
					strValorActual=tipolineaflujocaja.getTipoLineaFlujoCajaOriginal().getid_empresa().toString();
				}
				if(tipolineaflujocaja.getid_empresa()!=null)
				{
					strValorNuevo=tipolineaflujocaja.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoLineaFlujoCajaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipolineaflujocaja.getIsNew()||!tipolineaflujocaja.getnombre().equals(tipolineaflujocaja.getTipoLineaFlujoCajaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipolineaflujocaja.getTipoLineaFlujoCajaOriginal().getnombre()!=null)
				{
					strValorActual=tipolineaflujocaja.getTipoLineaFlujoCajaOriginal().getnombre();
				}
				if(tipolineaflujocaja.getnombre()!=null)
				{
					strValorNuevo=tipolineaflujocaja.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoLineaFlujoCajaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipolineaflujocaja.getIsNew()||!tipolineaflujocaja.getcodigo_sri().equals(tipolineaflujocaja.getTipoLineaFlujoCajaOriginal().getcodigo_sri()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipolineaflujocaja.getTipoLineaFlujoCajaOriginal().getcodigo_sri()!=null)
				{
					strValorActual=tipolineaflujocaja.getTipoLineaFlujoCajaOriginal().getcodigo_sri();
				}
				if(tipolineaflujocaja.getcodigo_sri()!=null)
				{
					strValorNuevo=tipolineaflujocaja.getcodigo_sri() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoLineaFlujoCajaConstantesFunciones.CODIGOSRI,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoLineaFlujoCajaRelacionesWithConnection(TipoLineaFlujoCaja tipolineaflujocaja,List<LineaFlujoCaja> lineaflujocajas) throws Exception {

		if(!tipolineaflujocaja.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoLineaFlujoCajaRelacionesBase(tipolineaflujocaja,lineaflujocajas,true);
		}
	}

	public void saveTipoLineaFlujoCajaRelaciones(TipoLineaFlujoCaja tipolineaflujocaja,List<LineaFlujoCaja> lineaflujocajas)throws Exception {

		if(!tipolineaflujocaja.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoLineaFlujoCajaRelacionesBase(tipolineaflujocaja,lineaflujocajas,false);
		}
	}

	public void saveTipoLineaFlujoCajaRelacionesBase(TipoLineaFlujoCaja tipolineaflujocaja,List<LineaFlujoCaja> lineaflujocajas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoLineaFlujoCaja-saveRelacionesWithConnection");}
	
			tipolineaflujocaja.setLineaFlujoCajas(lineaflujocajas);

			this.setTipoLineaFlujoCaja(tipolineaflujocaja);

			if(TipoLineaFlujoCajaLogicAdditional.validarSaveRelaciones(tipolineaflujocaja,this)) {

				TipoLineaFlujoCajaLogicAdditional.updateRelacionesToSave(tipolineaflujocaja,this);

				if((tipolineaflujocaja.getIsNew()||tipolineaflujocaja.getIsChanged())&&!tipolineaflujocaja.getIsDeleted()) {
					this.saveTipoLineaFlujoCaja();
					this.saveTipoLineaFlujoCajaRelacionesDetalles(lineaflujocajas);

				} else if(tipolineaflujocaja.getIsDeleted()) {
					this.saveTipoLineaFlujoCajaRelacionesDetalles(lineaflujocajas);
					this.saveTipoLineaFlujoCaja();
				}

				TipoLineaFlujoCajaLogicAdditional.updateRelacionesToSaveAfter(tipolineaflujocaja,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			LineaFlujoCajaConstantesFunciones.InicializarGeneralEntityAuxiliaresLineaFlujoCajas(lineaflujocajas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoLineaFlujoCajaRelacionesDetalles(List<LineaFlujoCaja> lineaflujocajas)throws Exception {
		try {
	

			Long idTipoLineaFlujoCajaActual=this.getTipoLineaFlujoCaja().getId();

			LineaFlujoCajaLogic lineaflujocajaLogic_Desde_TipoLineaFlujoCaja=new LineaFlujoCajaLogic();
			lineaflujocajaLogic_Desde_TipoLineaFlujoCaja.setLineaFlujoCajas(lineaflujocajas);

			lineaflujocajaLogic_Desde_TipoLineaFlujoCaja.setConnexion(this.getConnexion());
			lineaflujocajaLogic_Desde_TipoLineaFlujoCaja.setDatosCliente(this.datosCliente);

			for(LineaFlujoCaja lineaflujocaja_Desde_TipoLineaFlujoCaja:lineaflujocajaLogic_Desde_TipoLineaFlujoCaja.getLineaFlujoCajas()) {
				lineaflujocaja_Desde_TipoLineaFlujoCaja.setid_tipo_linea_flujo_caja(idTipoLineaFlujoCajaActual);
			}

			lineaflujocajaLogic_Desde_TipoLineaFlujoCaja.saveLineaFlujoCajas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoLineaFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoLineaFlujoCajaConstantesFunciones.getClassesForeignKeysOfTipoLineaFlujoCaja(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoLineaFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoLineaFlujoCajaConstantesFunciones.getClassesRelationshipsOfTipoLineaFlujoCaja(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

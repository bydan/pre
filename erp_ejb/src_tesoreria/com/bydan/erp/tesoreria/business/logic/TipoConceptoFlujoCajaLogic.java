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
import com.bydan.erp.tesoreria.util.TipoConceptoFlujoCajaConstantesFunciones;
import com.bydan.erp.tesoreria.util.TipoConceptoFlujoCajaParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TipoConceptoFlujoCajaParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.TipoConceptoFlujoCaja;
//import com.bydan.erp.tesoreria.business.logic.TipoConceptoFlujoCajaLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoConceptoFlujoCajaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoConceptoFlujoCajaLogic.class);
	
	protected TipoConceptoFlujoCajaDataAccess tipoconceptoflujocajaDataAccess; 	
	protected TipoConceptoFlujoCaja tipoconceptoflujocaja;
	protected List<TipoConceptoFlujoCaja> tipoconceptoflujocajas;
	protected Object tipoconceptoflujocajaObject;	
	protected List<Object> tipoconceptoflujocajasObject;
	
	public static ClassValidator<TipoConceptoFlujoCaja> tipoconceptoflujocajaValidator = new ClassValidator<TipoConceptoFlujoCaja>(TipoConceptoFlujoCaja.class);	
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
	
	
	
	
	public  TipoConceptoFlujoCajaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoconceptoflujocajaDataAccess = new TipoConceptoFlujoCajaDataAccess();
			
			this.tipoconceptoflujocajas= new ArrayList<TipoConceptoFlujoCaja>();
			this.tipoconceptoflujocaja= new TipoConceptoFlujoCaja();
			
			this.tipoconceptoflujocajaObject=new Object();
			this.tipoconceptoflujocajasObject=new ArrayList<Object>();
				
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
			
			this.tipoconceptoflujocajaDataAccess.setConnexionType(this.connexionType);
			this.tipoconceptoflujocajaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoConceptoFlujoCajaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoconceptoflujocajaDataAccess = new TipoConceptoFlujoCajaDataAccess();
			this.tipoconceptoflujocajas= new ArrayList<TipoConceptoFlujoCaja>();
			this.tipoconceptoflujocaja= new TipoConceptoFlujoCaja();
			this.tipoconceptoflujocajaObject=new Object();
			this.tipoconceptoflujocajasObject=new ArrayList<Object>();
			
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
			
			this.tipoconceptoflujocajaDataAccess.setConnexionType(this.connexionType);
			this.tipoconceptoflujocajaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoConceptoFlujoCaja getTipoConceptoFlujoCaja() throws Exception {	
		//TipoConceptoFlujoCajaLogicAdditional.checkTipoConceptoFlujoCajaToGet(tipoconceptoflujocaja,this.datosCliente,this.arrDatoGeneral);
		//TipoConceptoFlujoCajaLogicAdditional.updateTipoConceptoFlujoCajaToGet(tipoconceptoflujocaja,this.arrDatoGeneral);
		
		return tipoconceptoflujocaja;
	}
		
	public void setTipoConceptoFlujoCaja(TipoConceptoFlujoCaja newTipoConceptoFlujoCaja) {
		this.tipoconceptoflujocaja = newTipoConceptoFlujoCaja;
	}
	
	public TipoConceptoFlujoCajaDataAccess getTipoConceptoFlujoCajaDataAccess() {
		return tipoconceptoflujocajaDataAccess;
	}
	
	public void setTipoConceptoFlujoCajaDataAccess(TipoConceptoFlujoCajaDataAccess newtipoconceptoflujocajaDataAccess) {
		this.tipoconceptoflujocajaDataAccess = newtipoconceptoflujocajaDataAccess;
	}
	
	public List<TipoConceptoFlujoCaja> getTipoConceptoFlujoCajas() throws Exception {		
		this.quitarTipoConceptoFlujoCajasNulos();
		
		//TipoConceptoFlujoCajaLogicAdditional.checkTipoConceptoFlujoCajaToGets(tipoconceptoflujocajas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoConceptoFlujoCaja tipoconceptoflujocajaLocal: tipoconceptoflujocajas ) {
			//TipoConceptoFlujoCajaLogicAdditional.updateTipoConceptoFlujoCajaToGet(tipoconceptoflujocajaLocal,this.arrDatoGeneral);
		}
		
		return tipoconceptoflujocajas;
	}
	
	public void setTipoConceptoFlujoCajas(List<TipoConceptoFlujoCaja> newTipoConceptoFlujoCajas) {
		this.tipoconceptoflujocajas = newTipoConceptoFlujoCajas;
	}
	
	public Object getTipoConceptoFlujoCajaObject() {	
		this.tipoconceptoflujocajaObject=this.tipoconceptoflujocajaDataAccess.getEntityObject();
		return this.tipoconceptoflujocajaObject;
	}
		
	public void setTipoConceptoFlujoCajaObject(Object newTipoConceptoFlujoCajaObject) {
		this.tipoconceptoflujocajaObject = newTipoConceptoFlujoCajaObject;
	}
	
	public List<Object> getTipoConceptoFlujoCajasObject() {		
		this.tipoconceptoflujocajasObject=this.tipoconceptoflujocajaDataAccess.getEntitiesObject();
		return this.tipoconceptoflujocajasObject;
	}
		
	public void setTipoConceptoFlujoCajasObject(List<Object> newTipoConceptoFlujoCajasObject) {
		this.tipoconceptoflujocajasObject = newTipoConceptoFlujoCajasObject;
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
		
		if(this.tipoconceptoflujocajaDataAccess!=null) {
			this.tipoconceptoflujocajaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConceptoFlujoCaja.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoconceptoflujocajaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoconceptoflujocajaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoconceptoflujocaja = new  TipoConceptoFlujoCaja();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConceptoFlujoCaja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoconceptoflujocaja=tipoconceptoflujocajaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoconceptoflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocaja);
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
		tipoconceptoflujocaja = new  TipoConceptoFlujoCaja();
		  		  
        try {
			
			tipoconceptoflujocaja=tipoconceptoflujocajaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoconceptoflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoconceptoflujocaja = new  TipoConceptoFlujoCaja();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConceptoFlujoCaja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoconceptoflujocaja=tipoconceptoflujocajaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoconceptoflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocaja);
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
		tipoconceptoflujocaja = new  TipoConceptoFlujoCaja();
		  		  
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
		tipoconceptoflujocaja = new  TipoConceptoFlujoCaja();
		  		  
        try {
			
			tipoconceptoflujocaja=tipoconceptoflujocajaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoconceptoflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoconceptoflujocaja = new  TipoConceptoFlujoCaja();
		  		  
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
		tipoconceptoflujocaja = new  TipoConceptoFlujoCaja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConceptoFlujoCaja.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoconceptoflujocajaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoconceptoflujocaja = new  TipoConceptoFlujoCaja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoconceptoflujocajaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoconceptoflujocaja = new  TipoConceptoFlujoCaja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConceptoFlujoCaja.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoconceptoflujocajaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoconceptoflujocaja = new  TipoConceptoFlujoCaja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoconceptoflujocajaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoconceptoflujocaja = new  TipoConceptoFlujoCaja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConceptoFlujoCaja.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoconceptoflujocajaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoconceptoflujocaja = new  TipoConceptoFlujoCaja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoconceptoflujocajaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoconceptoflujocajas = new  ArrayList<TipoConceptoFlujoCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConceptoFlujoCaja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoConceptoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconceptoflujocajas=tipoconceptoflujocajaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoConceptoFlujoCaja(tipoconceptoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocajas);
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
		tipoconceptoflujocajas = new  ArrayList<TipoConceptoFlujoCaja>();
		  		  
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
		tipoconceptoflujocajas = new  ArrayList<TipoConceptoFlujoCaja>();
		  		  
        try {			
			TipoConceptoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconceptoflujocajas=tipoconceptoflujocajaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoConceptoFlujoCaja(tipoconceptoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocajas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoconceptoflujocajas = new  ArrayList<TipoConceptoFlujoCaja>();
		  		  
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
		tipoconceptoflujocajas = new  ArrayList<TipoConceptoFlujoCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConceptoFlujoCaja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoConceptoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconceptoflujocajas=tipoconceptoflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoConceptoFlujoCaja(tipoconceptoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocajas);
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
		tipoconceptoflujocajas = new  ArrayList<TipoConceptoFlujoCaja>();
		  		  
        try {
			TipoConceptoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconceptoflujocajas=tipoconceptoflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoConceptoFlujoCaja(tipoconceptoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocajas);
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
		tipoconceptoflujocajas = new  ArrayList<TipoConceptoFlujoCaja>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConceptoFlujoCaja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoConceptoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconceptoflujocajas=tipoconceptoflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoConceptoFlujoCaja(tipoconceptoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocajas);
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
		tipoconceptoflujocajas = new  ArrayList<TipoConceptoFlujoCaja>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoConceptoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconceptoflujocajas=tipoconceptoflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoConceptoFlujoCaja(tipoconceptoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocajas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoconceptoflujocaja = new  TipoConceptoFlujoCaja();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConceptoFlujoCaja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoConceptoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconceptoflujocaja=tipoconceptoflujocajaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoConceptoFlujoCaja(tipoconceptoflujocaja);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocaja);
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
		tipoconceptoflujocaja = new  TipoConceptoFlujoCaja();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoConceptoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconceptoflujocaja=tipoconceptoflujocajaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoConceptoFlujoCaja(tipoconceptoflujocaja);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoConceptoFlujoCajasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoconceptoflujocajas = new  ArrayList<TipoConceptoFlujoCaja>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConceptoFlujoCaja.class.getSimpleName()+"-getTodosTipoConceptoFlujoCajasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoConceptoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconceptoflujocajas=tipoconceptoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoConceptoFlujoCaja(tipoconceptoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocajas);
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
	
	public  void  getTodosTipoConceptoFlujoCajas(String sFinalQuery,Pagination pagination)throws Exception {
		tipoconceptoflujocajas = new  ArrayList<TipoConceptoFlujoCaja>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoConceptoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoconceptoflujocajas=tipoconceptoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoConceptoFlujoCaja(tipoconceptoflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocajas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoConceptoFlujoCaja(TipoConceptoFlujoCaja tipoconceptoflujocaja) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoconceptoflujocaja.getIsNew() || tipoconceptoflujocaja.getIsChanged()) { 
			this.invalidValues = tipoconceptoflujocajaValidator.getInvalidValues(tipoconceptoflujocaja);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoconceptoflujocaja);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoConceptoFlujoCaja(List<TipoConceptoFlujoCaja> TipoConceptoFlujoCajas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoConceptoFlujoCaja tipoconceptoflujocajaLocal:tipoconceptoflujocajas) {				
			estaValidadoObjeto=this.validarGuardarTipoConceptoFlujoCaja(tipoconceptoflujocajaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoConceptoFlujoCaja(List<TipoConceptoFlujoCaja> TipoConceptoFlujoCajas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoConceptoFlujoCaja(tipoconceptoflujocajas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoConceptoFlujoCaja(TipoConceptoFlujoCaja TipoConceptoFlujoCaja) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoConceptoFlujoCaja(tipoconceptoflujocaja)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoConceptoFlujoCaja tipoconceptoflujocaja) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoconceptoflujocaja.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoConceptoFlujoCajaConstantesFunciones.getTipoConceptoFlujoCajaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoconceptoflujocaja","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoConceptoFlujoCajaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoConceptoFlujoCajaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoConceptoFlujoCajaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConceptoFlujoCaja.class.getSimpleName()+"-saveTipoConceptoFlujoCajaWithConnection");connexion.begin();			
			
			//TipoConceptoFlujoCajaLogicAdditional.checkTipoConceptoFlujoCajaToSave(this.tipoconceptoflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoConceptoFlujoCajaLogicAdditional.updateTipoConceptoFlujoCajaToSave(this.tipoconceptoflujocaja,this.arrDatoGeneral);
			
			TipoConceptoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoconceptoflujocaja,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoConceptoFlujoCaja();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoConceptoFlujoCaja(this.tipoconceptoflujocaja)) {
				TipoConceptoFlujoCajaDataAccess.save(this.tipoconceptoflujocaja, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoconceptoflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoConceptoFlujoCajaLogicAdditional.checkTipoConceptoFlujoCajaToSaveAfter(this.tipoconceptoflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoConceptoFlujoCaja();
			
			connexion.commit();			
			
			if(this.tipoconceptoflujocaja.getIsDeleted()) {
				this.tipoconceptoflujocaja=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoConceptoFlujoCaja()throws Exception {	
		try {	
			
			//TipoConceptoFlujoCajaLogicAdditional.checkTipoConceptoFlujoCajaToSave(this.tipoconceptoflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoConceptoFlujoCajaLogicAdditional.updateTipoConceptoFlujoCajaToSave(this.tipoconceptoflujocaja,this.arrDatoGeneral);
			
			TipoConceptoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoconceptoflujocaja,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoConceptoFlujoCaja(this.tipoconceptoflujocaja)) {			
				TipoConceptoFlujoCajaDataAccess.save(this.tipoconceptoflujocaja, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoconceptoflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoConceptoFlujoCajaLogicAdditional.checkTipoConceptoFlujoCajaToSaveAfter(this.tipoconceptoflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoconceptoflujocaja.getIsDeleted()) {
				this.tipoconceptoflujocaja=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoConceptoFlujoCajasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConceptoFlujoCaja.class.getSimpleName()+"-saveTipoConceptoFlujoCajasWithConnection");connexion.begin();			
			
			//TipoConceptoFlujoCajaLogicAdditional.checkTipoConceptoFlujoCajaToSaves(tipoconceptoflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoConceptoFlujoCajas();
			
			Boolean validadoTodosTipoConceptoFlujoCaja=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoConceptoFlujoCaja tipoconceptoflujocajaLocal:tipoconceptoflujocajas) {		
				if(tipoconceptoflujocajaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoConceptoFlujoCajaLogicAdditional.updateTipoConceptoFlujoCajaToSave(tipoconceptoflujocajaLocal,this.arrDatoGeneral);
	        	
				TipoConceptoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoconceptoflujocajaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoConceptoFlujoCaja(tipoconceptoflujocajaLocal)) {
					TipoConceptoFlujoCajaDataAccess.save(tipoconceptoflujocajaLocal, connexion);				
				} else {
					validadoTodosTipoConceptoFlujoCaja=false;
				}
			}
			
			if(!validadoTodosTipoConceptoFlujoCaja) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoConceptoFlujoCajaLogicAdditional.checkTipoConceptoFlujoCajaToSavesAfter(tipoconceptoflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoConceptoFlujoCajas();
			
			connexion.commit();		
			
			this.quitarTipoConceptoFlujoCajasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoConceptoFlujoCajas()throws Exception {				
		 try {	
			//TipoConceptoFlujoCajaLogicAdditional.checkTipoConceptoFlujoCajaToSaves(tipoconceptoflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoConceptoFlujoCaja=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoConceptoFlujoCaja tipoconceptoflujocajaLocal:tipoconceptoflujocajas) {				
				if(tipoconceptoflujocajaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoConceptoFlujoCajaLogicAdditional.updateTipoConceptoFlujoCajaToSave(tipoconceptoflujocajaLocal,this.arrDatoGeneral);
	        	
				TipoConceptoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoconceptoflujocajaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoConceptoFlujoCaja(tipoconceptoflujocajaLocal)) {				
					TipoConceptoFlujoCajaDataAccess.save(tipoconceptoflujocajaLocal, connexion);				
				} else {
					validadoTodosTipoConceptoFlujoCaja=false;
				}
			}
			
			if(!validadoTodosTipoConceptoFlujoCaja) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoConceptoFlujoCajaLogicAdditional.checkTipoConceptoFlujoCajaToSavesAfter(tipoconceptoflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoConceptoFlujoCajasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoConceptoFlujoCajaParameterReturnGeneral procesarAccionTipoConceptoFlujoCajas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoConceptoFlujoCaja> tipoconceptoflujocajas,TipoConceptoFlujoCajaParameterReturnGeneral tipoconceptoflujocajaParameterGeneral)throws Exception {
		 try {	
			TipoConceptoFlujoCajaParameterReturnGeneral tipoconceptoflujocajaReturnGeneral=new TipoConceptoFlujoCajaParameterReturnGeneral();
	
			
			return tipoconceptoflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoConceptoFlujoCajaParameterReturnGeneral procesarAccionTipoConceptoFlujoCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoConceptoFlujoCaja> tipoconceptoflujocajas,TipoConceptoFlujoCajaParameterReturnGeneral tipoconceptoflujocajaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConceptoFlujoCaja.class.getSimpleName()+"-procesarAccionTipoConceptoFlujoCajasWithConnection");connexion.begin();			
			
			TipoConceptoFlujoCajaParameterReturnGeneral tipoconceptoflujocajaReturnGeneral=new TipoConceptoFlujoCajaParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipoconceptoflujocajaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoConceptoFlujoCajaParameterReturnGeneral procesarEventosTipoConceptoFlujoCajas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoConceptoFlujoCaja> tipoconceptoflujocajas,TipoConceptoFlujoCaja tipoconceptoflujocaja,TipoConceptoFlujoCajaParameterReturnGeneral tipoconceptoflujocajaParameterGeneral,Boolean isEsNuevoTipoConceptoFlujoCaja,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoConceptoFlujoCajaParameterReturnGeneral tipoconceptoflujocajaReturnGeneral=new TipoConceptoFlujoCajaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoconceptoflujocajaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipoconceptoflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoConceptoFlujoCajaParameterReturnGeneral procesarEventosTipoConceptoFlujoCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoConceptoFlujoCaja> tipoconceptoflujocajas,TipoConceptoFlujoCaja tipoconceptoflujocaja,TipoConceptoFlujoCajaParameterReturnGeneral tipoconceptoflujocajaParameterGeneral,Boolean isEsNuevoTipoConceptoFlujoCaja,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConceptoFlujoCaja.class.getSimpleName()+"-procesarEventosTipoConceptoFlujoCajasWithConnection");connexion.begin();			
			
			TipoConceptoFlujoCajaParameterReturnGeneral tipoconceptoflujocajaReturnGeneral=new TipoConceptoFlujoCajaParameterReturnGeneral();
	
			tipoconceptoflujocajaReturnGeneral.setTipoConceptoFlujoCaja(tipoconceptoflujocaja);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoconceptoflujocajaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipoconceptoflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoConceptoFlujoCajaParameterReturnGeneral procesarImportacionTipoConceptoFlujoCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoConceptoFlujoCajaParameterReturnGeneral tipoconceptoflujocajaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConceptoFlujoCaja.class.getSimpleName()+"-procesarImportacionTipoConceptoFlujoCajasWithConnection");connexion.begin();			
			
			TipoConceptoFlujoCajaParameterReturnGeneral tipoconceptoflujocajaReturnGeneral=new TipoConceptoFlujoCajaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoconceptoflujocajas=new ArrayList<TipoConceptoFlujoCaja>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoconceptoflujocaja=new TipoConceptoFlujoCaja();
				
				
				if(conColumnasBase) {this.tipoconceptoflujocaja.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoconceptoflujocaja.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoconceptoflujocaja.setcodigo(arrColumnas[iColumn++]);
				this.tipoconceptoflujocaja.setnombre(arrColumnas[iColumn++]);
				
				this.tipoconceptoflujocajas.add(this.tipoconceptoflujocaja);
			}
			
			this.saveTipoConceptoFlujoCajas();
			
			this.connexion.commit();
			
			tipoconceptoflujocajaReturnGeneral.setConRetornoEstaProcesado(true);
			tipoconceptoflujocajaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoconceptoflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoConceptoFlujoCajasEliminados() throws Exception {				
		
		List<TipoConceptoFlujoCaja> tipoconceptoflujocajasAux= new ArrayList<TipoConceptoFlujoCaja>();
		
		for(TipoConceptoFlujoCaja tipoconceptoflujocaja:tipoconceptoflujocajas) {
			if(!tipoconceptoflujocaja.getIsDeleted()) {
				tipoconceptoflujocajasAux.add(tipoconceptoflujocaja);
			}
		}
		
		tipoconceptoflujocajas=tipoconceptoflujocajasAux;
	}
	
	public void quitarTipoConceptoFlujoCajasNulos() throws Exception {				
		
		List<TipoConceptoFlujoCaja> tipoconceptoflujocajasAux= new ArrayList<TipoConceptoFlujoCaja>();
		
		for(TipoConceptoFlujoCaja tipoconceptoflujocaja : this.tipoconceptoflujocajas) {
			if(tipoconceptoflujocaja==null) {
				tipoconceptoflujocajasAux.add(tipoconceptoflujocaja);
			}
		}
		
		//this.tipoconceptoflujocajas=tipoconceptoflujocajasAux;
		
		this.tipoconceptoflujocajas.removeAll(tipoconceptoflujocajasAux);
	}
	
	public void getSetVersionRowTipoConceptoFlujoCajaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoconceptoflujocaja.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoconceptoflujocaja.getIsDeleted() || (tipoconceptoflujocaja.getIsChanged()&&!tipoconceptoflujocaja.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoconceptoflujocajaDataAccess.getSetVersionRowTipoConceptoFlujoCaja(connexion,tipoconceptoflujocaja.getId());
				
				if(!tipoconceptoflujocaja.getVersionRow().equals(timestamp)) {	
					tipoconceptoflujocaja.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoconceptoflujocaja.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoConceptoFlujoCaja()throws Exception {	
		
		if(tipoconceptoflujocaja.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoconceptoflujocaja.getIsDeleted() || (tipoconceptoflujocaja.getIsChanged()&&!tipoconceptoflujocaja.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoconceptoflujocajaDataAccess.getSetVersionRowTipoConceptoFlujoCaja(connexion,tipoconceptoflujocaja.getId());
			
			try {							
				if(!tipoconceptoflujocaja.getVersionRow().equals(timestamp)) {	
					tipoconceptoflujocaja.setVersionRow(timestamp);
				}
				
				tipoconceptoflujocaja.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoConceptoFlujoCajasWithConnection()throws Exception {	
		if(tipoconceptoflujocajas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoConceptoFlujoCaja tipoconceptoflujocajaAux:tipoconceptoflujocajas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoconceptoflujocajaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoconceptoflujocajaAux.getIsDeleted() || (tipoconceptoflujocajaAux.getIsChanged()&&!tipoconceptoflujocajaAux.getIsNew())) {
						
						timestamp=tipoconceptoflujocajaDataAccess.getSetVersionRowTipoConceptoFlujoCaja(connexion,tipoconceptoflujocajaAux.getId());
						
						if(!tipoconceptoflujocaja.getVersionRow().equals(timestamp)) {	
							tipoconceptoflujocajaAux.setVersionRow(timestamp);
						}
								
						tipoconceptoflujocajaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoConceptoFlujoCajas()throws Exception {	
		if(tipoconceptoflujocajas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoConceptoFlujoCaja tipoconceptoflujocajaAux:tipoconceptoflujocajas) {
					if(tipoconceptoflujocajaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoconceptoflujocajaAux.getIsDeleted() || (tipoconceptoflujocajaAux.getIsChanged()&&!tipoconceptoflujocajaAux.getIsNew())) {
						
						timestamp=tipoconceptoflujocajaDataAccess.getSetVersionRowTipoConceptoFlujoCaja(connexion,tipoconceptoflujocajaAux.getId());
						
						if(!tipoconceptoflujocajaAux.getVersionRow().equals(timestamp)) {	
							tipoconceptoflujocajaAux.setVersionRow(timestamp);
						}
						
													
						tipoconceptoflujocajaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoConceptoFlujoCajaParameterReturnGeneral cargarCombosLoteForeignKeyTipoConceptoFlujoCajaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoConceptoFlujoCajaParameterReturnGeneral  tipoconceptoflujocajaReturnGeneral =new TipoConceptoFlujoCajaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConceptoFlujoCaja.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoConceptoFlujoCajaWithConnection");connexion.begin();
			
			tipoconceptoflujocajaReturnGeneral =new TipoConceptoFlujoCajaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoconceptoflujocajaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoconceptoflujocajaReturnGeneral;
	}
	
	public TipoConceptoFlujoCajaParameterReturnGeneral cargarCombosLoteForeignKeyTipoConceptoFlujoCaja(String finalQueryGlobalEmpresa) throws Exception {
		TipoConceptoFlujoCajaParameterReturnGeneral  tipoconceptoflujocajaReturnGeneral =new TipoConceptoFlujoCajaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoconceptoflujocajaReturnGeneral =new TipoConceptoFlujoCajaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoconceptoflujocajaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoconceptoflujocajaReturnGeneral;
	}
	
	
	public void deepLoad(TipoConceptoFlujoCaja tipoconceptoflujocaja,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoConceptoFlujoCajaLogicAdditional.updateTipoConceptoFlujoCajaToGet(tipoconceptoflujocaja,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoconceptoflujocaja.setEmpresa(tipoconceptoflujocajaDataAccess.getEmpresa(connexion,tipoconceptoflujocaja));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoconceptoflujocaja.setEmpresa(tipoconceptoflujocajaDataAccess.getEmpresa(connexion,tipoconceptoflujocaja));
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
			tipoconceptoflujocaja.setEmpresa(tipoconceptoflujocajaDataAccess.getEmpresa(connexion,tipoconceptoflujocaja));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoconceptoflujocaja.setEmpresa(tipoconceptoflujocajaDataAccess.getEmpresa(connexion,tipoconceptoflujocaja));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoconceptoflujocaja.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoconceptoflujocaja.setEmpresa(tipoconceptoflujocajaDataAccess.getEmpresa(connexion,tipoconceptoflujocaja));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoconceptoflujocaja.getEmpresa(),isDeep,deepLoadType,clases);				
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
			tipoconceptoflujocaja.setEmpresa(tipoconceptoflujocajaDataAccess.getEmpresa(connexion,tipoconceptoflujocaja));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoconceptoflujocaja.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoConceptoFlujoCaja tipoconceptoflujocaja,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoConceptoFlujoCaja.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoconceptoflujocaja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(tipoconceptoflujocaja);
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
			this.deepLoad(this.tipoconceptoflujocaja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoConceptoFlujoCaja.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoconceptoflujocajas!=null) {
				for(TipoConceptoFlujoCaja tipoconceptoflujocaja:tipoconceptoflujocajas) {
					this.deepLoad(tipoconceptoflujocaja,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(tipoconceptoflujocajas);
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
			if(tipoconceptoflujocajas!=null) {
				for(TipoConceptoFlujoCaja tipoconceptoflujocaja:tipoconceptoflujocajas) {
					this.deepLoad(tipoconceptoflujocaja,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(tipoconceptoflujocajas);
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
	
	
	public void getTipoConceptoFlujoCajasBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConceptoFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoConceptoFlujoCajaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoConceptoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoconceptoflujocajas=tipoconceptoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoConceptoFlujoCajasBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoConceptoFlujoCajaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoConceptoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoconceptoflujocajas=tipoconceptoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoConceptoFlujoCajasBusquedaPorIdWithConnection(String sFinalQuery,Pagination pagination,Long id)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConceptoFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TipoConceptoFlujoCajaConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			TipoConceptoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorId","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoconceptoflujocajas=tipoconceptoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoConceptoFlujoCajasBusquedaPorId(String sFinalQuery,Pagination pagination,Long id)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TipoConceptoFlujoCajaConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			TipoConceptoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorId","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoconceptoflujocajas=tipoconceptoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoConceptoFlujoCajasBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConceptoFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoConceptoFlujoCajaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoConceptoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoconceptoflujocajas=tipoconceptoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoConceptoFlujoCajasBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoConceptoFlujoCajaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoConceptoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoconceptoflujocajas=tipoconceptoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoConceptoFlujoCajasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoConceptoFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoConceptoFlujoCajaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoConceptoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoconceptoflujocajas=tipoconceptoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoConceptoFlujoCajasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoConceptoFlujoCajaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoConceptoFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoconceptoflujocajas=tipoconceptoflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoConceptoFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesTipoConceptoFlujoCaja(this.tipoconceptoflujocajas);
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
			if(TipoConceptoFlujoCajaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoConceptoFlujoCajaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoConceptoFlujoCaja tipoconceptoflujocaja,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoConceptoFlujoCajaConstantesFunciones.ISCONAUDITORIA) {
				if(tipoconceptoflujocaja.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoConceptoFlujoCajaDataAccess.TABLENAME, tipoconceptoflujocaja.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoConceptoFlujoCajaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoConceptoFlujoCajaLogic.registrarAuditoriaDetallesTipoConceptoFlujoCaja(connexion,tipoconceptoflujocaja,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoconceptoflujocaja.getIsDeleted()) {
					/*if(!tipoconceptoflujocaja.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoConceptoFlujoCajaDataAccess.TABLENAME, tipoconceptoflujocaja.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoConceptoFlujoCajaLogic.registrarAuditoriaDetallesTipoConceptoFlujoCaja(connexion,tipoconceptoflujocaja,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoConceptoFlujoCajaDataAccess.TABLENAME, tipoconceptoflujocaja.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoconceptoflujocaja.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoConceptoFlujoCajaDataAccess.TABLENAME, tipoconceptoflujocaja.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoConceptoFlujoCajaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoConceptoFlujoCajaLogic.registrarAuditoriaDetallesTipoConceptoFlujoCaja(connexion,tipoconceptoflujocaja,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoConceptoFlujoCaja(Connexion connexion,TipoConceptoFlujoCaja tipoconceptoflujocaja)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoconceptoflujocaja.getIsNew()||!tipoconceptoflujocaja.getid_empresa().equals(tipoconceptoflujocaja.getTipoConceptoFlujoCajaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoconceptoflujocaja.getTipoConceptoFlujoCajaOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoconceptoflujocaja.getTipoConceptoFlujoCajaOriginal().getid_empresa().toString();
				}
				if(tipoconceptoflujocaja.getid_empresa()!=null)
				{
					strValorNuevo=tipoconceptoflujocaja.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoConceptoFlujoCajaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoconceptoflujocaja.getIsNew()||!tipoconceptoflujocaja.getcodigo().equals(tipoconceptoflujocaja.getTipoConceptoFlujoCajaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoconceptoflujocaja.getTipoConceptoFlujoCajaOriginal().getcodigo()!=null)
				{
					strValorActual=tipoconceptoflujocaja.getTipoConceptoFlujoCajaOriginal().getcodigo();
				}
				if(tipoconceptoflujocaja.getcodigo()!=null)
				{
					strValorNuevo=tipoconceptoflujocaja.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoConceptoFlujoCajaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoconceptoflujocaja.getIsNew()||!tipoconceptoflujocaja.getnombre().equals(tipoconceptoflujocaja.getTipoConceptoFlujoCajaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoconceptoflujocaja.getTipoConceptoFlujoCajaOriginal().getnombre()!=null)
				{
					strValorActual=tipoconceptoflujocaja.getTipoConceptoFlujoCajaOriginal().getnombre();
				}
				if(tipoconceptoflujocaja.getnombre()!=null)
				{
					strValorNuevo=tipoconceptoflujocaja.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoConceptoFlujoCajaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoConceptoFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoConceptoFlujoCajaConstantesFunciones.getClassesForeignKeysOfTipoConceptoFlujoCaja(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoConceptoFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoConceptoFlujoCajaConstantesFunciones.getClassesRelationshipsOfTipoConceptoFlujoCaja(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

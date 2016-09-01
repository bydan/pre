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
package com.bydan.erp.nomina.business.logic;

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
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.util.TipoContratoConstantesFunciones;
import com.bydan.erp.nomina.util.TipoContratoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoContratoParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoContrato;
import com.bydan.erp.nomina.business.logic.TipoContratoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoContratoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoContratoLogic.class);
	
	protected TipoContratoDataAccess tipocontratoDataAccess; 	
	protected TipoContrato tipocontrato;
	protected List<TipoContrato> tipocontratos;
	protected Object tipocontratoObject;	
	protected List<Object> tipocontratosObject;
	
	public static ClassValidator<TipoContrato> tipocontratoValidator = new ClassValidator<TipoContrato>(TipoContrato.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoContratoLogicAdditional tipocontratoLogicAdditional=null;
	
	public TipoContratoLogicAdditional getTipoContratoLogicAdditional() {
		return this.tipocontratoLogicAdditional;
	}
	
	public void setTipoContratoLogicAdditional(TipoContratoLogicAdditional tipocontratoLogicAdditional) {
		try {
			this.tipocontratoLogicAdditional=tipocontratoLogicAdditional;
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
	
	
	
	
	public  TipoContratoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipocontratoDataAccess = new TipoContratoDataAccess();
			
			this.tipocontratos= new ArrayList<TipoContrato>();
			this.tipocontrato= new TipoContrato();
			
			this.tipocontratoObject=new Object();
			this.tipocontratosObject=new ArrayList<Object>();
				
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
			
			this.tipocontratoDataAccess.setConnexionType(this.connexionType);
			this.tipocontratoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoContratoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipocontratoDataAccess = new TipoContratoDataAccess();
			this.tipocontratos= new ArrayList<TipoContrato>();
			this.tipocontrato= new TipoContrato();
			this.tipocontratoObject=new Object();
			this.tipocontratosObject=new ArrayList<Object>();
			
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
			
			this.tipocontratoDataAccess.setConnexionType(this.connexionType);
			this.tipocontratoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoContrato getTipoContrato() throws Exception {	
		TipoContratoLogicAdditional.checkTipoContratoToGet(tipocontrato,this.datosCliente,this.arrDatoGeneral);
		TipoContratoLogicAdditional.updateTipoContratoToGet(tipocontrato,this.arrDatoGeneral);
		
		return tipocontrato;
	}
		
	public void setTipoContrato(TipoContrato newTipoContrato) {
		this.tipocontrato = newTipoContrato;
	}
	
	public TipoContratoDataAccess getTipoContratoDataAccess() {
		return tipocontratoDataAccess;
	}
	
	public void setTipoContratoDataAccess(TipoContratoDataAccess newtipocontratoDataAccess) {
		this.tipocontratoDataAccess = newtipocontratoDataAccess;
	}
	
	public List<TipoContrato> getTipoContratos() throws Exception {		
		this.quitarTipoContratosNulos();
		
		TipoContratoLogicAdditional.checkTipoContratoToGets(tipocontratos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoContrato tipocontratoLocal: tipocontratos ) {
			TipoContratoLogicAdditional.updateTipoContratoToGet(tipocontratoLocal,this.arrDatoGeneral);
		}
		
		return tipocontratos;
	}
	
	public void setTipoContratos(List<TipoContrato> newTipoContratos) {
		this.tipocontratos = newTipoContratos;
	}
	
	public Object getTipoContratoObject() {	
		this.tipocontratoObject=this.tipocontratoDataAccess.getEntityObject();
		return this.tipocontratoObject;
	}
		
	public void setTipoContratoObject(Object newTipoContratoObject) {
		this.tipocontratoObject = newTipoContratoObject;
	}
	
	public List<Object> getTipoContratosObject() {		
		this.tipocontratosObject=this.tipocontratoDataAccess.getEntitiesObject();
		return this.tipocontratosObject;
	}
		
	public void setTipoContratosObject(List<Object> newTipoContratosObject) {
		this.tipocontratosObject = newTipoContratosObject;
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
		
		if(this.tipocontratoDataAccess!=null) {
			this.tipocontratoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoContrato.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipocontratoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipocontratoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipocontrato = new  TipoContrato();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoContrato.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocontrato=tipocontratoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocontrato,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(this.tipocontrato);
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
		tipocontrato = new  TipoContrato();
		  		  
        try {
			
			tipocontrato=tipocontratoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocontrato,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(this.tipocontrato);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipocontrato = new  TipoContrato();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoContrato.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocontrato=tipocontratoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocontrato,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(this.tipocontrato);
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
		tipocontrato = new  TipoContrato();
		  		  
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
		tipocontrato = new  TipoContrato();
		  		  
        try {
			
			tipocontrato=tipocontratoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocontrato,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(this.tipocontrato);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipocontrato = new  TipoContrato();
		  		  
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
		tipocontrato = new  TipoContrato();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoContrato.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipocontratoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocontrato = new  TipoContrato();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipocontratoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocontrato = new  TipoContrato();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoContrato.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipocontratoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocontrato = new  TipoContrato();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipocontratoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocontrato = new  TipoContrato();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoContrato.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipocontratoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocontrato = new  TipoContrato();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipocontratoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocontratos = new  ArrayList<TipoContrato>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoContrato.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoContratoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocontratos=tipocontratoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoContrato(tipocontratos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(this.tipocontratos);
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
		tipocontratos = new  ArrayList<TipoContrato>();
		  		  
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
		tipocontratos = new  ArrayList<TipoContrato>();
		  		  
        try {			
			TipoContratoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocontratos=tipocontratoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoContrato(tipocontratos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(this.tipocontratos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipocontratos = new  ArrayList<TipoContrato>();
		  		  
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
		tipocontratos = new  ArrayList<TipoContrato>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoContrato.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoContratoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocontratos=tipocontratoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoContrato(tipocontratos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(this.tipocontratos);
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
		tipocontratos = new  ArrayList<TipoContrato>();
		  		  
        try {
			TipoContratoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocontratos=tipocontratoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoContrato(tipocontratos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(this.tipocontratos);
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
		tipocontratos = new  ArrayList<TipoContrato>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoContrato.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoContratoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocontratos=tipocontratoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoContrato(tipocontratos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(this.tipocontratos);
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
		tipocontratos = new  ArrayList<TipoContrato>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoContratoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocontratos=tipocontratoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoContrato(tipocontratos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(this.tipocontratos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipocontrato = new  TipoContrato();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoContrato.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoContratoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocontrato=tipocontratoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoContrato(tipocontrato);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(this.tipocontrato);
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
		tipocontrato = new  TipoContrato();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoContratoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocontrato=tipocontratoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoContrato(tipocontrato);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(this.tipocontrato);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocontratos = new  ArrayList<TipoContrato>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoContrato.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoContratoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocontratos=tipocontratoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoContrato(tipocontratos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(this.tipocontratos);
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
		tipocontratos = new  ArrayList<TipoContrato>();
		  		  
        try {
			TipoContratoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocontratos=tipocontratoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoContrato(tipocontratos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(this.tipocontratos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoContratosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipocontratos = new  ArrayList<TipoContrato>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoContrato.class.getSimpleName()+"-getTodosTipoContratosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoContratoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocontratos=tipocontratoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoContrato(tipocontratos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(this.tipocontratos);
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
	
	public  void  getTodosTipoContratos(String sFinalQuery,Pagination pagination)throws Exception {
		tipocontratos = new  ArrayList<TipoContrato>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoContratoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocontratos=tipocontratoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoContrato(tipocontratos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(this.tipocontratos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoContrato(TipoContrato tipocontrato) throws Exception {
		Boolean estaValidado=false;
		
		if(tipocontrato.getIsNew() || tipocontrato.getIsChanged()) { 
			this.invalidValues = tipocontratoValidator.getInvalidValues(tipocontrato);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipocontrato);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoContrato(List<TipoContrato> TipoContratos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoContrato tipocontratoLocal:tipocontratos) {				
			estaValidadoObjeto=this.validarGuardarTipoContrato(tipocontratoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoContrato(List<TipoContrato> TipoContratos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoContrato(tipocontratos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoContrato(TipoContrato TipoContrato) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoContrato(tipocontrato)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoContrato tipocontrato) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipocontrato.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoContratoConstantesFunciones.getTipoContratoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipocontrato","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoContratoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoContratoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoContratoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoContrato.class.getSimpleName()+"-saveTipoContratoWithConnection");connexion.begin();			
			
			TipoContratoLogicAdditional.checkTipoContratoToSave(this.tipocontrato,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoContratoLogicAdditional.updateTipoContratoToSave(this.tipocontrato,this.arrDatoGeneral);
			
			TipoContratoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocontrato,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoContrato();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoContrato(this.tipocontrato)) {
				TipoContratoDataAccess.save(this.tipocontrato, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipocontrato,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoContratoLogicAdditional.checkTipoContratoToSaveAfter(this.tipocontrato,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoContrato();
			
			connexion.commit();			
			
			if(this.tipocontrato.getIsDeleted()) {
				this.tipocontrato=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoContrato()throws Exception {	
		try {	
			
			TipoContratoLogicAdditional.checkTipoContratoToSave(this.tipocontrato,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoContratoLogicAdditional.updateTipoContratoToSave(this.tipocontrato,this.arrDatoGeneral);
			
			TipoContratoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocontrato,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoContrato(this.tipocontrato)) {			
				TipoContratoDataAccess.save(this.tipocontrato, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipocontrato,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoContratoLogicAdditional.checkTipoContratoToSaveAfter(this.tipocontrato,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipocontrato.getIsDeleted()) {
				this.tipocontrato=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoContratosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoContrato.class.getSimpleName()+"-saveTipoContratosWithConnection");connexion.begin();			
			
			TipoContratoLogicAdditional.checkTipoContratoToSaves(tipocontratos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoContratos();
			
			Boolean validadoTodosTipoContrato=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoContrato tipocontratoLocal:tipocontratos) {		
				if(tipocontratoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoContratoLogicAdditional.updateTipoContratoToSave(tipocontratoLocal,this.arrDatoGeneral);
	        	
				TipoContratoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocontratoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoContrato(tipocontratoLocal)) {
					TipoContratoDataAccess.save(tipocontratoLocal, connexion);				
				} else {
					validadoTodosTipoContrato=false;
				}
			}
			
			if(!validadoTodosTipoContrato) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoContratoLogicAdditional.checkTipoContratoToSavesAfter(tipocontratos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoContratos();
			
			connexion.commit();		
			
			this.quitarTipoContratosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoContratos()throws Exception {				
		 try {	
			TipoContratoLogicAdditional.checkTipoContratoToSaves(tipocontratos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoContrato=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoContrato tipocontratoLocal:tipocontratos) {				
				if(tipocontratoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoContratoLogicAdditional.updateTipoContratoToSave(tipocontratoLocal,this.arrDatoGeneral);
	        	
				TipoContratoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocontratoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoContrato(tipocontratoLocal)) {				
					TipoContratoDataAccess.save(tipocontratoLocal, connexion);				
				} else {
					validadoTodosTipoContrato=false;
				}
			}
			
			if(!validadoTodosTipoContrato) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoContratoLogicAdditional.checkTipoContratoToSavesAfter(tipocontratos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoContratosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoContratoParameterReturnGeneral procesarAccionTipoContratos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoContrato> tipocontratos,TipoContratoParameterReturnGeneral tipocontratoParameterGeneral)throws Exception {
		 try {	
			TipoContratoParameterReturnGeneral tipocontratoReturnGeneral=new TipoContratoParameterReturnGeneral();
	
			TipoContratoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipocontratos,tipocontratoParameterGeneral,tipocontratoReturnGeneral);
			
			return tipocontratoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoContratoParameterReturnGeneral procesarAccionTipoContratosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoContrato> tipocontratos,TipoContratoParameterReturnGeneral tipocontratoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoContrato.class.getSimpleName()+"-procesarAccionTipoContratosWithConnection");connexion.begin();			
			
			TipoContratoParameterReturnGeneral tipocontratoReturnGeneral=new TipoContratoParameterReturnGeneral();
	
			TipoContratoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipocontratos,tipocontratoParameterGeneral,tipocontratoReturnGeneral);
			
			this.connexion.commit();
			
			return tipocontratoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoContratoParameterReturnGeneral procesarEventosTipoContratos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoContrato> tipocontratos,TipoContrato tipocontrato,TipoContratoParameterReturnGeneral tipocontratoParameterGeneral,Boolean isEsNuevoTipoContrato,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoContratoParameterReturnGeneral tipocontratoReturnGeneral=new TipoContratoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocontratoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoContratoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipocontratos,tipocontrato,tipocontratoParameterGeneral,tipocontratoReturnGeneral,isEsNuevoTipoContrato,clases);
			
			return tipocontratoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoContratoParameterReturnGeneral procesarEventosTipoContratosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoContrato> tipocontratos,TipoContrato tipocontrato,TipoContratoParameterReturnGeneral tipocontratoParameterGeneral,Boolean isEsNuevoTipoContrato,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoContrato.class.getSimpleName()+"-procesarEventosTipoContratosWithConnection");connexion.begin();			
			
			TipoContratoParameterReturnGeneral tipocontratoReturnGeneral=new TipoContratoParameterReturnGeneral();
	
			tipocontratoReturnGeneral.setTipoContrato(tipocontrato);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocontratoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoContratoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipocontratos,tipocontrato,tipocontratoParameterGeneral,tipocontratoReturnGeneral,isEsNuevoTipoContrato,clases);
			
			this.connexion.commit();
			
			return tipocontratoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoContratoParameterReturnGeneral procesarImportacionTipoContratosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoContratoParameterReturnGeneral tipocontratoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoContrato.class.getSimpleName()+"-procesarImportacionTipoContratosWithConnection");connexion.begin();			
			
			TipoContratoParameterReturnGeneral tipocontratoReturnGeneral=new TipoContratoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipocontratos=new ArrayList<TipoContrato>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipocontrato=new TipoContrato();
				
				
				if(conColumnasBase) {this.tipocontrato.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipocontrato.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipocontrato.setcodigo(arrColumnas[iColumn++]);
				this.tipocontrato.setnombre(arrColumnas[iColumn++]);
				this.tipocontrato.setnumero_dias(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.tipocontratos.add(this.tipocontrato);
			}
			
			this.saveTipoContratos();
			
			this.connexion.commit();
			
			tipocontratoReturnGeneral.setConRetornoEstaProcesado(true);
			tipocontratoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipocontratoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoContratosEliminados() throws Exception {				
		
		List<TipoContrato> tipocontratosAux= new ArrayList<TipoContrato>();
		
		for(TipoContrato tipocontrato:tipocontratos) {
			if(!tipocontrato.getIsDeleted()) {
				tipocontratosAux.add(tipocontrato);
			}
		}
		
		tipocontratos=tipocontratosAux;
	}
	
	public void quitarTipoContratosNulos() throws Exception {				
		
		List<TipoContrato> tipocontratosAux= new ArrayList<TipoContrato>();
		
		for(TipoContrato tipocontrato : this.tipocontratos) {
			if(tipocontrato==null) {
				tipocontratosAux.add(tipocontrato);
			}
		}
		
		//this.tipocontratos=tipocontratosAux;
		
		this.tipocontratos.removeAll(tipocontratosAux);
	}
	
	public void getSetVersionRowTipoContratoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipocontrato.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipocontrato.getIsDeleted() || (tipocontrato.getIsChanged()&&!tipocontrato.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipocontratoDataAccess.getSetVersionRowTipoContrato(connexion,tipocontrato.getId());
				
				if(!tipocontrato.getVersionRow().equals(timestamp)) {	
					tipocontrato.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipocontrato.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoContrato()throws Exception {	
		
		if(tipocontrato.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipocontrato.getIsDeleted() || (tipocontrato.getIsChanged()&&!tipocontrato.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipocontratoDataAccess.getSetVersionRowTipoContrato(connexion,tipocontrato.getId());
			
			try {							
				if(!tipocontrato.getVersionRow().equals(timestamp)) {	
					tipocontrato.setVersionRow(timestamp);
				}
				
				tipocontrato.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoContratosWithConnection()throws Exception {	
		if(tipocontratos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoContrato tipocontratoAux:tipocontratos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipocontratoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocontratoAux.getIsDeleted() || (tipocontratoAux.getIsChanged()&&!tipocontratoAux.getIsNew())) {
						
						timestamp=tipocontratoDataAccess.getSetVersionRowTipoContrato(connexion,tipocontratoAux.getId());
						
						if(!tipocontrato.getVersionRow().equals(timestamp)) {	
							tipocontratoAux.setVersionRow(timestamp);
						}
								
						tipocontratoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoContratos()throws Exception {	
		if(tipocontratos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoContrato tipocontratoAux:tipocontratos) {
					if(tipocontratoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocontratoAux.getIsDeleted() || (tipocontratoAux.getIsChanged()&&!tipocontratoAux.getIsNew())) {
						
						timestamp=tipocontratoDataAccess.getSetVersionRowTipoContrato(connexion,tipocontratoAux.getId());
						
						if(!tipocontratoAux.getVersionRow().equals(timestamp)) {	
							tipocontratoAux.setVersionRow(timestamp);
						}
						
													
						tipocontratoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoContratoParameterReturnGeneral cargarCombosLoteForeignKeyTipoContratoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalFormato) throws Exception {
		TipoContratoParameterReturnGeneral  tipocontratoReturnGeneral =new TipoContratoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoContrato.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoContratoWithConnection");connexion.begin();
			
			tipocontratoReturnGeneral =new TipoContratoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipocontratoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			tipocontratoReturnGeneral.setformatosForeignKey(formatosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipocontratoReturnGeneral;
	}
	
	public TipoContratoParameterReturnGeneral cargarCombosLoteForeignKeyTipoContrato(String finalQueryGlobalEmpresa,String finalQueryGlobalFormato) throws Exception {
		TipoContratoParameterReturnGeneral  tipocontratoReturnGeneral =new TipoContratoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipocontratoReturnGeneral =new TipoContratoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipocontratoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			tipocontratoReturnGeneral.setformatosForeignKey(formatosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipocontratoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoContratoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic=new DatoGeneralEmpleadoLogic();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoContrato.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoContratoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DatoGeneralEmpleado.class));
			classes.add(new Classe(Empleado.class));
											
			

			datogeneralempleadoLogic.setConnexion(this.getConnexion());
			datogeneralempleadoLogic.setDatosCliente(this.datosCliente);
			datogeneralempleadoLogic.setIsConRefrescarForeignKeys(true);

			empleadoLogic.setConnexion(this.getConnexion());
			empleadoLogic.setDatosCliente(this.datosCliente);
			empleadoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoContrato tipocontrato:this.tipocontratos) {
				

				classes=new ArrayList<Classe>();
				classes=DatoGeneralEmpleadoConstantesFunciones.getClassesForeignKeysOfDatoGeneralEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				datogeneralempleadoLogic.setDatoGeneralEmpleados(tipocontrato.datogeneralempleados);
				datogeneralempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EmpleadoConstantesFunciones.getClassesForeignKeysOfEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoLogic.setEmpleados(tipocontrato.empleados);
				empleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoContrato tipocontrato,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoContratoLogicAdditional.updateTipoContratoToGet(tipocontrato,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocontrato.setEmpresa(tipocontratoDataAccess.getEmpresa(connexion,tipocontrato));
		tipocontrato.setFormato(tipocontratoDataAccess.getFormato(connexion,tipocontrato));
		tipocontrato.setDatoGeneralEmpleados(tipocontratoDataAccess.getDatoGeneralEmpleados(connexion,tipocontrato));
		tipocontrato.setEmpleados(tipocontratoDataAccess.getEmpleados(connexion,tipocontrato));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipocontrato.setEmpresa(tipocontratoDataAccess.getEmpresa(connexion,tipocontrato));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				tipocontrato.setFormato(tipocontratoDataAccess.getFormato(connexion,tipocontrato));
				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocontrato.setDatoGeneralEmpleados(tipocontratoDataAccess.getDatoGeneralEmpleados(connexion,tipocontrato));

				if(this.isConDeep) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(this.connexion);
					datogeneralempleadoLogic.setDatoGeneralEmpleados(tipocontrato.getDatoGeneralEmpleados());
					ArrayList<Classe> classesLocal=DatoGeneralEmpleadoConstantesFunciones.getClassesForeignKeysOfDatoGeneralEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					datogeneralempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(datogeneralempleadoLogic.getDatoGeneralEmpleados());
					tipocontrato.setDatoGeneralEmpleados(datogeneralempleadoLogic.getDatoGeneralEmpleados());
				}

				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocontrato.setEmpleados(tipocontratoDataAccess.getEmpleados(connexion,tipocontrato));

				if(this.isConDeep) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(this.connexion);
					empleadoLogic.setEmpleados(tipocontrato.getEmpleados());
					ArrayList<Classe> classesLocal=EmpleadoConstantesFunciones.getClassesForeignKeysOfEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(empleadoLogic.getEmpleados());
					tipocontrato.setEmpleados(empleadoLogic.getEmpleados());
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
			tipocontrato.setEmpresa(tipocontratoDataAccess.getEmpresa(connexion,tipocontrato));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipocontrato.setFormato(tipocontratoDataAccess.getFormato(connexion,tipocontrato));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DatoGeneralEmpleado.class));
			tipocontrato.setDatoGeneralEmpleados(tipocontratoDataAccess.getDatoGeneralEmpleados(connexion,tipocontrato));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Empleado.class));
			tipocontrato.setEmpleados(tipocontratoDataAccess.getEmpleados(connexion,tipocontrato));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocontrato.setEmpresa(tipocontratoDataAccess.getEmpresa(connexion,tipocontrato));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipocontrato.getEmpresa(),isDeep,deepLoadType,clases);
				
		tipocontrato.setFormato(tipocontratoDataAccess.getFormato(connexion,tipocontrato));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(tipocontrato.getFormato(),isDeep,deepLoadType,clases);
				

		tipocontrato.setDatoGeneralEmpleados(tipocontratoDataAccess.getDatoGeneralEmpleados(connexion,tipocontrato));

		for(DatoGeneralEmpleado datogeneralempleado:tipocontrato.getDatoGeneralEmpleados()) {
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
			datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
		}

		tipocontrato.setEmpleados(tipocontratoDataAccess.getEmpleados(connexion,tipocontrato));

		for(Empleado empleado:tipocontrato.getEmpleados()) {
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipocontrato.setEmpresa(tipocontratoDataAccess.getEmpresa(connexion,tipocontrato));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipocontrato.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				tipocontrato.setFormato(tipocontratoDataAccess.getFormato(connexion,tipocontrato));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(tipocontrato.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocontrato.setDatoGeneralEmpleados(tipocontratoDataAccess.getDatoGeneralEmpleados(connexion,tipocontrato));

				for(DatoGeneralEmpleado datogeneralempleado:tipocontrato.getDatoGeneralEmpleados()) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
					datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocontrato.setEmpleados(tipocontratoDataAccess.getEmpleados(connexion,tipocontrato));

				for(Empleado empleado:tipocontrato.getEmpleados()) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
					empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
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
			tipocontrato.setEmpresa(tipocontratoDataAccess.getEmpresa(connexion,tipocontrato));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipocontrato.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipocontrato.setFormato(tipocontratoDataAccess.getFormato(connexion,tipocontrato));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(tipocontrato.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DatoGeneralEmpleado.class));
			tipocontrato.setDatoGeneralEmpleados(tipocontratoDataAccess.getDatoGeneralEmpleados(connexion,tipocontrato));

			for(DatoGeneralEmpleado datogeneralempleado:tipocontrato.getDatoGeneralEmpleados()) {
				DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
				datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Empleado.class));
			tipocontrato.setEmpleados(tipocontratoDataAccess.getEmpleados(connexion,tipocontrato));

			for(Empleado empleado:tipocontrato.getEmpleados()) {
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoContrato tipocontrato,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoContratoLogicAdditional.updateTipoContratoToSave(tipocontrato,this.arrDatoGeneral);
			
TipoContratoDataAccess.save(tipocontrato, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipocontrato.getEmpresa(),connexion);

		FormatoDataAccess.save(tipocontrato.getFormato(),connexion);

		for(DatoGeneralEmpleado datogeneralempleado:tipocontrato.getDatoGeneralEmpleados()) {
			datogeneralempleado.setid_tipo_contrato(tipocontrato.getId());
			DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
		}

		for(Empleado empleado:tipocontrato.getEmpleados()) {
			empleado.setid_tipo_contrato(tipocontrato.getId());
			EmpleadoDataAccess.save(empleado,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipocontrato.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(tipocontrato.getFormato(),connexion);
				continue;
			}


			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DatoGeneralEmpleado datogeneralempleado:tipocontrato.getDatoGeneralEmpleados()) {
					datogeneralempleado.setid_tipo_contrato(tipocontrato.getId());
					DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Empleado empleado:tipocontrato.getEmpleados()) {
					empleado.setid_tipo_contrato(tipocontrato.getId());
					EmpleadoDataAccess.save(empleado,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipocontrato.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipocontrato.getEmpresa(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(tipocontrato.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(tipocontrato.getFormato(),isDeep,deepLoadType,clases);
				

		for(DatoGeneralEmpleado datogeneralempleado:tipocontrato.getDatoGeneralEmpleados()) {
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
			datogeneralempleado.setid_tipo_contrato(tipocontrato.getId());
			DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
			datogeneralempleadoLogic.deepSave(datogeneralempleado,isDeep,deepLoadType,clases);
		}

		for(Empleado empleado:tipocontrato.getEmpleados()) {
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleado.setid_tipo_contrato(tipocontrato.getId());
			EmpleadoDataAccess.save(empleado,connexion);
			empleadoLogic.deepSave(empleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipocontrato.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipocontrato.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(tipocontrato.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(tipocontrato.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DatoGeneralEmpleado datogeneralempleado:tipocontrato.getDatoGeneralEmpleados()) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
					datogeneralempleado.setid_tipo_contrato(tipocontrato.getId());
					DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
					datogeneralempleadoLogic.deepSave(datogeneralempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Empleado empleado:tipocontrato.getEmpleados()) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
					empleado.setid_tipo_contrato(tipocontrato.getId());
					EmpleadoDataAccess.save(empleado,connexion);
					empleadoLogic.deepSave(empleado,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoContrato.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipocontrato,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(tipocontrato);
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
			this.deepLoad(this.tipocontrato,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(this.tipocontrato);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoContrato.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipocontratos!=null) {
				for(TipoContrato tipocontrato:tipocontratos) {
					this.deepLoad(tipocontrato,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(tipocontratos);
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
			if(tipocontratos!=null) {
				for(TipoContrato tipocontrato:tipocontratos) {
					this.deepLoad(tipocontrato,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(tipocontratos);
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
			this.getNewConnexionToDeep(TipoContrato.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipocontrato,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoContrato.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipocontratos!=null) {
				for(TipoContrato tipocontrato:tipocontratos) {
					this.deepSave(tipocontrato,isDeep,deepLoadType,clases);
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
			if(tipocontratos!=null) {
				for(TipoContrato tipocontrato:tipocontratos) {
					this.deepSave(tipocontrato,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoContratosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoContrato.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoContratoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoContratoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocontratos=tipocontratoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(this.tipocontratos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoContratosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoContratoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoContratoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocontratos=tipocontratoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(this.tipocontratos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoContratosFK_IdTipoContratoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoContrato.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,TipoContratoConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			TipoContratoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoContrato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocontratos=tipocontratoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(this.tipocontratos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoContratosFK_IdTipoContrato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,TipoContratoConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			TipoContratoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoContrato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocontratos=tipocontratoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoContratoConstantesFunciones.refrescarForeignKeysDescripcionesTipoContrato(this.tipocontratos);
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
			if(TipoContratoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoContratoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoContrato tipocontrato,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoContratoConstantesFunciones.ISCONAUDITORIA) {
				if(tipocontrato.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoContratoDataAccess.TABLENAME, tipocontrato.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoContratoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoContratoLogic.registrarAuditoriaDetallesTipoContrato(connexion,tipocontrato,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipocontrato.getIsDeleted()) {
					/*if(!tipocontrato.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoContratoDataAccess.TABLENAME, tipocontrato.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoContratoLogic.registrarAuditoriaDetallesTipoContrato(connexion,tipocontrato,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoContratoDataAccess.TABLENAME, tipocontrato.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipocontrato.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoContratoDataAccess.TABLENAME, tipocontrato.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoContratoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoContratoLogic.registrarAuditoriaDetallesTipoContrato(connexion,tipocontrato,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoContrato(Connexion connexion,TipoContrato tipocontrato)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipocontrato.getIsNew()||!tipocontrato.getid_empresa().equals(tipocontrato.getTipoContratoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocontrato.getTipoContratoOriginal().getid_empresa()!=null)
				{
					strValorActual=tipocontrato.getTipoContratoOriginal().getid_empresa().toString();
				}
				if(tipocontrato.getid_empresa()!=null)
				{
					strValorNuevo=tipocontrato.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoContratoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipocontrato.getIsNew()||!tipocontrato.getid_formato().equals(tipocontrato.getTipoContratoOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocontrato.getTipoContratoOriginal().getid_formato()!=null)
				{
					strValorActual=tipocontrato.getTipoContratoOriginal().getid_formato().toString();
				}
				if(tipocontrato.getid_formato()!=null)
				{
					strValorNuevo=tipocontrato.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoContratoConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(tipocontrato.getIsNew()||!tipocontrato.getcodigo().equals(tipocontrato.getTipoContratoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocontrato.getTipoContratoOriginal().getcodigo()!=null)
				{
					strValorActual=tipocontrato.getTipoContratoOriginal().getcodigo();
				}
				if(tipocontrato.getcodigo()!=null)
				{
					strValorNuevo=tipocontrato.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoContratoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipocontrato.getIsNew()||!tipocontrato.getnombre().equals(tipocontrato.getTipoContratoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocontrato.getTipoContratoOriginal().getnombre()!=null)
				{
					strValorActual=tipocontrato.getTipoContratoOriginal().getnombre();
				}
				if(tipocontrato.getnombre()!=null)
				{
					strValorNuevo=tipocontrato.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoContratoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipocontrato.getIsNew()||!tipocontrato.getnumero_dias().equals(tipocontrato.getTipoContratoOriginal().getnumero_dias()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocontrato.getTipoContratoOriginal().getnumero_dias()!=null)
				{
					strValorActual=tipocontrato.getTipoContratoOriginal().getnumero_dias().toString();
				}
				if(tipocontrato.getnumero_dias()!=null)
				{
					strValorNuevo=tipocontrato.getnumero_dias().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoContratoConstantesFunciones.NUMERODIAS,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoContratoRelacionesWithConnection(TipoContrato tipocontrato,List<DatoGeneralEmpleado> datogeneralempleados,List<Empleado> empleados) throws Exception {

		if(!tipocontrato.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoContratoRelacionesBase(tipocontrato,datogeneralempleados,empleados,true);
		}
	}

	public void saveTipoContratoRelaciones(TipoContrato tipocontrato,List<DatoGeneralEmpleado> datogeneralempleados,List<Empleado> empleados)throws Exception {

		if(!tipocontrato.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoContratoRelacionesBase(tipocontrato,datogeneralempleados,empleados,false);
		}
	}

	public void saveTipoContratoRelacionesBase(TipoContrato tipocontrato,List<DatoGeneralEmpleado> datogeneralempleados,List<Empleado> empleados,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoContrato-saveRelacionesWithConnection");}
	
			tipocontrato.setDatoGeneralEmpleados(datogeneralempleados);
			tipocontrato.setEmpleados(empleados);

			this.setTipoContrato(tipocontrato);

			if(TipoContratoLogicAdditional.validarSaveRelaciones(tipocontrato,this)) {

				TipoContratoLogicAdditional.updateRelacionesToSave(tipocontrato,this);

				if((tipocontrato.getIsNew()||tipocontrato.getIsChanged())&&!tipocontrato.getIsDeleted()) {
					this.saveTipoContrato();
					this.saveTipoContratoRelacionesDetalles(datogeneralempleados,empleados);

				} else if(tipocontrato.getIsDeleted()) {
					this.saveTipoContratoRelacionesDetalles(datogeneralempleados,empleados);
					this.saveTipoContrato();
				}

				TipoContratoLogicAdditional.updateRelacionesToSaveAfter(tipocontrato,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DatoGeneralEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresDatoGeneralEmpleados(datogeneralempleados,true,true);
			EmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleados(empleados,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoContratoRelacionesDetalles(List<DatoGeneralEmpleado> datogeneralempleados,List<Empleado> empleados)throws Exception {
		try {
	

			Long idTipoContratoActual=this.getTipoContrato().getId();

			DatoGeneralEmpleadoLogic datogeneralempleadoLogic_Desde_TipoContrato=new DatoGeneralEmpleadoLogic();
			datogeneralempleadoLogic_Desde_TipoContrato.setDatoGeneralEmpleados(datogeneralempleados);

			datogeneralempleadoLogic_Desde_TipoContrato.setConnexion(this.getConnexion());
			datogeneralempleadoLogic_Desde_TipoContrato.setDatosCliente(this.datosCliente);

			for(DatoGeneralEmpleado datogeneralempleado_Desde_TipoContrato:datogeneralempleadoLogic_Desde_TipoContrato.getDatoGeneralEmpleados()) {
				datogeneralempleado_Desde_TipoContrato.setid_tipo_contrato(idTipoContratoActual);
			}

			datogeneralempleadoLogic_Desde_TipoContrato.saveDatoGeneralEmpleados();

			EmpleadoLogic empleadoLogic_Desde_TipoContrato=new EmpleadoLogic();
			empleadoLogic_Desde_TipoContrato.setEmpleados(empleados);

			empleadoLogic_Desde_TipoContrato.setConnexion(this.getConnexion());
			empleadoLogic_Desde_TipoContrato.setDatosCliente(this.datosCliente);

			for(Empleado empleado_Desde_TipoContrato:empleadoLogic_Desde_TipoContrato.getEmpleados()) {
				empleado_Desde_TipoContrato.setid_tipo_contrato(idTipoContratoActual);

				empleadoLogic_Desde_TipoContrato.setEmpleado(empleado_Desde_TipoContrato);
				empleadoLogic_Desde_TipoContrato.saveEmpleado();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoContrato(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoContratoConstantesFunciones.getClassesForeignKeysOfTipoContrato(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoContrato(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoContratoConstantesFunciones.getClassesRelationshipsOfTipoContrato(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

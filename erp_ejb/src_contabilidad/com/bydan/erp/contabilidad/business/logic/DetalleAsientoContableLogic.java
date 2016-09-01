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
import com.bydan.erp.contabilidad.util.DetalleAsientoContableConstantesFunciones;
import com.bydan.erp.contabilidad.util.DetalleAsientoContableParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.DetalleAsientoContableParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.DetalleAsientoContable;
import com.bydan.erp.contabilidad.business.logic.DetalleAsientoContableLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetalleAsientoContableLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleAsientoContableLogic.class);
	
	protected DetalleAsientoContableDataAccess detalleasientocontableDataAccess; 	
	protected DetalleAsientoContable detalleasientocontable;
	protected List<DetalleAsientoContable> detalleasientocontables;
	protected Object detalleasientocontableObject;	
	protected List<Object> detalleasientocontablesObject;
	
	public static ClassValidator<DetalleAsientoContable> detalleasientocontableValidator = new ClassValidator<DetalleAsientoContable>(DetalleAsientoContable.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleAsientoContableLogicAdditional detalleasientocontableLogicAdditional=null;
	
	public DetalleAsientoContableLogicAdditional getDetalleAsientoContableLogicAdditional() {
		return this.detalleasientocontableLogicAdditional;
	}
	
	public void setDetalleAsientoContableLogicAdditional(DetalleAsientoContableLogicAdditional detalleasientocontableLogicAdditional) {
		try {
			this.detalleasientocontableLogicAdditional=detalleasientocontableLogicAdditional;
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
	
	
	
	
	public  DetalleAsientoContableLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalleasientocontableDataAccess = new DetalleAsientoContableDataAccess();
			
			this.detalleasientocontables= new ArrayList<DetalleAsientoContable>();
			this.detalleasientocontable= new DetalleAsientoContable();
			
			this.detalleasientocontableObject=new Object();
			this.detalleasientocontablesObject=new ArrayList<Object>();
				
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
			
			this.detalleasientocontableDataAccess.setConnexionType(this.connexionType);
			this.detalleasientocontableDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleAsientoContableLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalleasientocontableDataAccess = new DetalleAsientoContableDataAccess();
			this.detalleasientocontables= new ArrayList<DetalleAsientoContable>();
			this.detalleasientocontable= new DetalleAsientoContable();
			this.detalleasientocontableObject=new Object();
			this.detalleasientocontablesObject=new ArrayList<Object>();
			
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
			
			this.detalleasientocontableDataAccess.setConnexionType(this.connexionType);
			this.detalleasientocontableDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleAsientoContable getDetalleAsientoContable() throws Exception {	
		DetalleAsientoContableLogicAdditional.checkDetalleAsientoContableToGet(detalleasientocontable,this.datosCliente,this.arrDatoGeneral);
		DetalleAsientoContableLogicAdditional.updateDetalleAsientoContableToGet(detalleasientocontable,this.arrDatoGeneral);
		
		return detalleasientocontable;
	}
		
	public void setDetalleAsientoContable(DetalleAsientoContable newDetalleAsientoContable) {
		this.detalleasientocontable = newDetalleAsientoContable;
	}
	
	public DetalleAsientoContableDataAccess getDetalleAsientoContableDataAccess() {
		return detalleasientocontableDataAccess;
	}
	
	public void setDetalleAsientoContableDataAccess(DetalleAsientoContableDataAccess newdetalleasientocontableDataAccess) {
		this.detalleasientocontableDataAccess = newdetalleasientocontableDataAccess;
	}
	
	public List<DetalleAsientoContable> getDetalleAsientoContables() throws Exception {		
		this.quitarDetalleAsientoContablesNulos();
		
		DetalleAsientoContableLogicAdditional.checkDetalleAsientoContableToGets(detalleasientocontables,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleAsientoContable detalleasientocontableLocal: detalleasientocontables ) {
			DetalleAsientoContableLogicAdditional.updateDetalleAsientoContableToGet(detalleasientocontableLocal,this.arrDatoGeneral);
		}
		
		return detalleasientocontables;
	}
	
	public void setDetalleAsientoContables(List<DetalleAsientoContable> newDetalleAsientoContables) {
		this.detalleasientocontables = newDetalleAsientoContables;
	}
	
	public Object getDetalleAsientoContableObject() {	
		this.detalleasientocontableObject=this.detalleasientocontableDataAccess.getEntityObject();
		return this.detalleasientocontableObject;
	}
		
	public void setDetalleAsientoContableObject(Object newDetalleAsientoContableObject) {
		this.detalleasientocontableObject = newDetalleAsientoContableObject;
	}
	
	public List<Object> getDetalleAsientoContablesObject() {		
		this.detalleasientocontablesObject=this.detalleasientocontableDataAccess.getEntitiesObject();
		return this.detalleasientocontablesObject;
	}
		
	public void setDetalleAsientoContablesObject(List<Object> newDetalleAsientoContablesObject) {
		this.detalleasientocontablesObject = newDetalleAsientoContablesObject;
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
		
		if(this.detalleasientocontableDataAccess!=null) {
			this.detalleasientocontableDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalleasientocontableDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalleasientocontableDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalleasientocontable = new  DetalleAsientoContable();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleasientocontable=detalleasientocontableDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleasientocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontable);
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
		detalleasientocontable = new  DetalleAsientoContable();
		  		  
        try {
			
			detalleasientocontable=detalleasientocontableDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleasientocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalleasientocontable = new  DetalleAsientoContable();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleasientocontable=detalleasientocontableDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleasientocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontable);
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
		detalleasientocontable = new  DetalleAsientoContable();
		  		  
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
		detalleasientocontable = new  DetalleAsientoContable();
		  		  
        try {
			
			detalleasientocontable=detalleasientocontableDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleasientocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalleasientocontable = new  DetalleAsientoContable();
		  		  
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
		detalleasientocontable = new  DetalleAsientoContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalleasientocontableDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleasientocontable = new  DetalleAsientoContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalleasientocontableDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleasientocontable = new  DetalleAsientoContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalleasientocontableDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleasientocontable = new  DetalleAsientoContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalleasientocontableDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleasientocontable = new  DetalleAsientoContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalleasientocontableDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleasientocontable = new  DetalleAsientoContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalleasientocontableDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleasientocontables = new  ArrayList<DetalleAsientoContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleAsientoContable(detalleasientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
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
		detalleasientocontables = new  ArrayList<DetalleAsientoContable>();
		  		  
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
		detalleasientocontables = new  ArrayList<DetalleAsientoContable>();
		  		  
        try {			
			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleAsientoContable(detalleasientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalleasientocontables = new  ArrayList<DetalleAsientoContable>();
		  		  
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
		detalleasientocontables = new  ArrayList<DetalleAsientoContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleAsientoContable(detalleasientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
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
		detalleasientocontables = new  ArrayList<DetalleAsientoContable>();
		  		  
        try {
			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleAsientoContable(detalleasientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
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
		detalleasientocontables = new  ArrayList<DetalleAsientoContable>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleAsientoContable(detalleasientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
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
		detalleasientocontables = new  ArrayList<DetalleAsientoContable>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleAsientoContable(detalleasientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalleasientocontable = new  DetalleAsientoContable();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontable=detalleasientocontableDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleAsientoContable(detalleasientocontable);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontable);
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
		detalleasientocontable = new  DetalleAsientoContable();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontable=detalleasientocontableDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleAsientoContable(detalleasientocontable);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleasientocontables = new  ArrayList<DetalleAsientoContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontables=detalleasientocontableDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleAsientoContable(detalleasientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
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
		detalleasientocontables = new  ArrayList<DetalleAsientoContable>();
		  		  
        try {
			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontables=detalleasientocontableDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleAsientoContable(detalleasientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleAsientoContablesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalleasientocontables = new  ArrayList<DetalleAsientoContable>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-getTodosDetalleAsientoContablesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleAsientoContable(detalleasientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
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
	
	public  void  getTodosDetalleAsientoContables(String sFinalQuery,Pagination pagination)throws Exception {
		detalleasientocontables = new  ArrayList<DetalleAsientoContable>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleAsientoContable(detalleasientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleAsientoContable(DetalleAsientoContable detalleasientocontable) throws Exception {
		Boolean estaValidado=false;
		
		if(detalleasientocontable.getIsNew() || detalleasientocontable.getIsChanged()) { 
			this.invalidValues = detalleasientocontableValidator.getInvalidValues(detalleasientocontable);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalleasientocontable);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleAsientoContable(List<DetalleAsientoContable> DetalleAsientoContables) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleAsientoContable detalleasientocontableLocal:detalleasientocontables) {				
			estaValidadoObjeto=this.validarGuardarDetalleAsientoContable(detalleasientocontableLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleAsientoContable(List<DetalleAsientoContable> DetalleAsientoContables) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleAsientoContable(detalleasientocontables)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleAsientoContable(DetalleAsientoContable DetalleAsientoContable) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleAsientoContable(detalleasientocontable)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleAsientoContable detalleasientocontable) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalleasientocontable.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleAsientoContableConstantesFunciones.getDetalleAsientoContableLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalleasientocontable","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleAsientoContableConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleAsientoContableConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleAsientoContableWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-saveDetalleAsientoContableWithConnection");connexion.begin();			
			
			DetalleAsientoContableLogicAdditional.checkDetalleAsientoContableToSave(this.detalleasientocontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleAsientoContableLogicAdditional.updateDetalleAsientoContableToSave(this.detalleasientocontable,this.arrDatoGeneral);
			
			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleasientocontable,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleAsientoContable();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleAsientoContable(this.detalleasientocontable)) {
				DetalleAsientoContableDataAccess.save(this.detalleasientocontable, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalleasientocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleAsientoContableLogicAdditional.checkDetalleAsientoContableToSaveAfter(this.detalleasientocontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleAsientoContable();
			
			connexion.commit();			
			
			if(this.detalleasientocontable.getIsDeleted()) {
				this.detalleasientocontable=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleAsientoContable()throws Exception {	
		try {	
			
			DetalleAsientoContableLogicAdditional.checkDetalleAsientoContableToSave(this.detalleasientocontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleAsientoContableLogicAdditional.updateDetalleAsientoContableToSave(this.detalleasientocontable,this.arrDatoGeneral);
			
			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleasientocontable,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleAsientoContable(this.detalleasientocontable)) {			
				DetalleAsientoContableDataAccess.save(this.detalleasientocontable, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalleasientocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleAsientoContableLogicAdditional.checkDetalleAsientoContableToSaveAfter(this.detalleasientocontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalleasientocontable.getIsDeleted()) {
				this.detalleasientocontable=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleAsientoContablesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-saveDetalleAsientoContablesWithConnection");connexion.begin();			
			
			DetalleAsientoContableLogicAdditional.checkDetalleAsientoContableToSaves(detalleasientocontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleAsientoContables();
			
			Boolean validadoTodosDetalleAsientoContable=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleAsientoContable detalleasientocontableLocal:detalleasientocontables) {		
				if(detalleasientocontableLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleAsientoContableLogicAdditional.updateDetalleAsientoContableToSave(detalleasientocontableLocal,this.arrDatoGeneral);
	        	
				DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleasientocontableLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleAsientoContable(detalleasientocontableLocal)) {
					DetalleAsientoContableDataAccess.save(detalleasientocontableLocal, connexion);				
				} else {
					validadoTodosDetalleAsientoContable=false;
				}
			}
			
			if(!validadoTodosDetalleAsientoContable) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleAsientoContableLogicAdditional.checkDetalleAsientoContableToSavesAfter(detalleasientocontables,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleAsientoContables();
			
			connexion.commit();		
			
			this.quitarDetalleAsientoContablesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleAsientoContables()throws Exception {				
		 try {	
			DetalleAsientoContableLogicAdditional.checkDetalleAsientoContableToSaves(detalleasientocontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleAsientoContable=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleAsientoContable detalleasientocontableLocal:detalleasientocontables) {				
				if(detalleasientocontableLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleAsientoContableLogicAdditional.updateDetalleAsientoContableToSave(detalleasientocontableLocal,this.arrDatoGeneral);
	        	
				DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleasientocontableLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleAsientoContable(detalleasientocontableLocal)) {				
					DetalleAsientoContableDataAccess.save(detalleasientocontableLocal, connexion);				
				} else {
					validadoTodosDetalleAsientoContable=false;
				}
			}
			
			if(!validadoTodosDetalleAsientoContable) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleAsientoContableLogicAdditional.checkDetalleAsientoContableToSavesAfter(detalleasientocontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleAsientoContablesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleAsientoContableParameterReturnGeneral procesarAccionDetalleAsientoContables(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleAsientoContable> detalleasientocontables,DetalleAsientoContableParameterReturnGeneral detalleasientocontableParameterGeneral)throws Exception {
		 try {	
			DetalleAsientoContableParameterReturnGeneral detalleasientocontableReturnGeneral=new DetalleAsientoContableParameterReturnGeneral();
	
			DetalleAsientoContableLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleasientocontables,detalleasientocontableParameterGeneral,detalleasientocontableReturnGeneral);
			
			return detalleasientocontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleAsientoContableParameterReturnGeneral procesarAccionDetalleAsientoContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleAsientoContable> detalleasientocontables,DetalleAsientoContableParameterReturnGeneral detalleasientocontableParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-procesarAccionDetalleAsientoContablesWithConnection");connexion.begin();			
			
			DetalleAsientoContableParameterReturnGeneral detalleasientocontableReturnGeneral=new DetalleAsientoContableParameterReturnGeneral();
	
			DetalleAsientoContableLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleasientocontables,detalleasientocontableParameterGeneral,detalleasientocontableReturnGeneral);
			
			this.connexion.commit();
			
			return detalleasientocontableReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleAsientoContableParameterReturnGeneral procesarEventosDetalleAsientoContables(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleAsientoContable> detalleasientocontables,DetalleAsientoContable detalleasientocontable,DetalleAsientoContableParameterReturnGeneral detalleasientocontableParameterGeneral,Boolean isEsNuevoDetalleAsientoContable,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleAsientoContableParameterReturnGeneral detalleasientocontableReturnGeneral=new DetalleAsientoContableParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleasientocontableReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleAsientoContableLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleasientocontables,detalleasientocontable,detalleasientocontableParameterGeneral,detalleasientocontableReturnGeneral,isEsNuevoDetalleAsientoContable,clases);
			
			return detalleasientocontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleAsientoContableParameterReturnGeneral procesarEventosDetalleAsientoContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleAsientoContable> detalleasientocontables,DetalleAsientoContable detalleasientocontable,DetalleAsientoContableParameterReturnGeneral detalleasientocontableParameterGeneral,Boolean isEsNuevoDetalleAsientoContable,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-procesarEventosDetalleAsientoContablesWithConnection");connexion.begin();			
			
			DetalleAsientoContableParameterReturnGeneral detalleasientocontableReturnGeneral=new DetalleAsientoContableParameterReturnGeneral();
	
			detalleasientocontableReturnGeneral.setDetalleAsientoContable(detalleasientocontable);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleasientocontableReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleAsientoContableLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleasientocontables,detalleasientocontable,detalleasientocontableParameterGeneral,detalleasientocontableReturnGeneral,isEsNuevoDetalleAsientoContable,clases);
			
			this.connexion.commit();
			
			return detalleasientocontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleAsientoContableParameterReturnGeneral procesarImportacionDetalleAsientoContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleAsientoContableParameterReturnGeneral detalleasientocontableParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-procesarImportacionDetalleAsientoContablesWithConnection");connexion.begin();			
			
			DetalleAsientoContableParameterReturnGeneral detalleasientocontableReturnGeneral=new DetalleAsientoContableParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalleasientocontables=new ArrayList<DetalleAsientoContable>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalleasientocontable=new DetalleAsientoContable();
				
				

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalleasientocontable.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalleasientocontable.setnumero_documento(arrColumnas[iColumn++]);
				this.detalleasientocontable.setdebito_local(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleasientocontable.setcredito_local(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleasientocontable.setdebito_extran(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleasientocontable.setcredito_extran(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleasientocontable.setcotizacion(Double.parseDouble(arrColumnas[iColumn++]));
			this.detalleasientocontable.setdetalle(arrColumnas[iColumn++]);
				
				this.detalleasientocontables.add(this.detalleasientocontable);
			}
			
			this.saveDetalleAsientoContables();
			
			this.connexion.commit();
			
			detalleasientocontableReturnGeneral.setConRetornoEstaProcesado(true);
			detalleasientocontableReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalleasientocontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleAsientoContablesEliminados() throws Exception {				
		
		List<DetalleAsientoContable> detalleasientocontablesAux= new ArrayList<DetalleAsientoContable>();
		
		for(DetalleAsientoContable detalleasientocontable:detalleasientocontables) {
			if(!detalleasientocontable.getIsDeleted()) {
				detalleasientocontablesAux.add(detalleasientocontable);
			}
		}
		
		detalleasientocontables=detalleasientocontablesAux;
	}
	
	public void quitarDetalleAsientoContablesNulos() throws Exception {				
		
		List<DetalleAsientoContable> detalleasientocontablesAux= new ArrayList<DetalleAsientoContable>();
		
		for(DetalleAsientoContable detalleasientocontable : this.detalleasientocontables) {
			if(detalleasientocontable==null) {
				detalleasientocontablesAux.add(detalleasientocontable);
			}
		}
		
		//this.detalleasientocontables=detalleasientocontablesAux;
		
		this.detalleasientocontables.removeAll(detalleasientocontablesAux);
	}
	
	public void getSetVersionRowDetalleAsientoContableWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalleasientocontable.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalleasientocontable.getIsDeleted() || (detalleasientocontable.getIsChanged()&&!detalleasientocontable.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalleasientocontableDataAccess.getSetVersionRowDetalleAsientoContable(connexion,detalleasientocontable.getId());
				
				if(!detalleasientocontable.getVersionRow().equals(timestamp)) {	
					detalleasientocontable.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalleasientocontable.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleAsientoContable()throws Exception {	
		
		if(detalleasientocontable.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalleasientocontable.getIsDeleted() || (detalleasientocontable.getIsChanged()&&!detalleasientocontable.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalleasientocontableDataAccess.getSetVersionRowDetalleAsientoContable(connexion,detalleasientocontable.getId());
			
			try {							
				if(!detalleasientocontable.getVersionRow().equals(timestamp)) {	
					detalleasientocontable.setVersionRow(timestamp);
				}
				
				detalleasientocontable.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleAsientoContablesWithConnection()throws Exception {	
		if(detalleasientocontables!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleAsientoContable detalleasientocontableAux:detalleasientocontables) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalleasientocontableAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleasientocontableAux.getIsDeleted() || (detalleasientocontableAux.getIsChanged()&&!detalleasientocontableAux.getIsNew())) {
						
						timestamp=detalleasientocontableDataAccess.getSetVersionRowDetalleAsientoContable(connexion,detalleasientocontableAux.getId());
						
						if(!detalleasientocontable.getVersionRow().equals(timestamp)) {	
							detalleasientocontableAux.setVersionRow(timestamp);
						}
								
						detalleasientocontableAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleAsientoContables()throws Exception {	
		if(detalleasientocontables!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleAsientoContable detalleasientocontableAux:detalleasientocontables) {
					if(detalleasientocontableAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleasientocontableAux.getIsDeleted() || (detalleasientocontableAux.getIsChanged()&&!detalleasientocontableAux.getIsNew())) {
						
						timestamp=detalleasientocontableDataAccess.getSetVersionRowDetalleAsientoContable(connexion,detalleasientocontableAux.getId());
						
						if(!detalleasientocontableAux.getVersionRow().equals(timestamp)) {	
							detalleasientocontableAux.setVersionRow(timestamp);
						}
						
													
						detalleasientocontableAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleAsientoContableParameterReturnGeneral cargarCombosLoteForeignKeyDetalleAsientoContableWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalAsientoContable,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalCuentaContable,String finalQueryGlobalCentroActividad,String finalQueryGlobalCentroCosto,String finalQueryGlobalTipoCambio) throws Exception {
		DetalleAsientoContableParameterReturnGeneral  detalleasientocontableReturnGeneral =new DetalleAsientoContableParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleAsientoContableWithConnection");connexion.begin();
			
			detalleasientocontableReturnGeneral =new DetalleAsientoContableParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleasientocontableReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleasientocontableReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			detalleasientocontableReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleasientocontableReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalleasientocontableReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detalleasientocontableReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detalleasientocontableReturnGeneral.setmessForeignKey(messForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			detalleasientocontableReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<CentroActividad> centroactividadsForeignKey=new ArrayList<CentroActividad>();
			CentroActividadLogic centroactividadLogic=new CentroActividadLogic();
			centroactividadLogic.setConnexion(this.connexion);
			centroactividadLogic.getCentroActividadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroActividad.equals("NONE")) {
				centroactividadLogic.getTodosCentroActividads(finalQueryGlobalCentroActividad,new Pagination());
				centroactividadsForeignKey=centroactividadLogic.getCentroActividads();
			}

			detalleasientocontableReturnGeneral.setcentroactividadsForeignKey(centroactividadsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detalleasientocontableReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			detalleasientocontableReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalleasientocontableReturnGeneral;
	}
	
	public DetalleAsientoContableParameterReturnGeneral cargarCombosLoteForeignKeyDetalleAsientoContable(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalAsientoContable,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalCuentaContable,String finalQueryGlobalCentroActividad,String finalQueryGlobalCentroCosto,String finalQueryGlobalTipoCambio) throws Exception {
		DetalleAsientoContableParameterReturnGeneral  detalleasientocontableReturnGeneral =new DetalleAsientoContableParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalleasientocontableReturnGeneral =new DetalleAsientoContableParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleasientocontableReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleasientocontableReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			detalleasientocontableReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleasientocontableReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalleasientocontableReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detalleasientocontableReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detalleasientocontableReturnGeneral.setmessForeignKey(messForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			detalleasientocontableReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<CentroActividad> centroactividadsForeignKey=new ArrayList<CentroActividad>();
			CentroActividadLogic centroactividadLogic=new CentroActividadLogic();
			centroactividadLogic.setConnexion(this.connexion);
			centroactividadLogic.getCentroActividadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroActividad.equals("NONE")) {
				centroactividadLogic.getTodosCentroActividads(finalQueryGlobalCentroActividad,new Pagination());
				centroactividadsForeignKey=centroactividadLogic.getCentroActividads();
			}

			detalleasientocontableReturnGeneral.setcentroactividadsForeignKey(centroactividadsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detalleasientocontableReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<TipoCambio> tipocambiosForeignKey=new ArrayList<TipoCambio>();
			TipoCambioLogic tipocambioLogic=new TipoCambioLogic();
			tipocambioLogic.setConnexion(this.connexion);
			tipocambioLogic.getTipoCambioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCambio.equals("NONE")) {
				tipocambioLogic.getTodosTipoCambios(finalQueryGlobalTipoCambio,new Pagination());
				tipocambiosForeignKey=tipocambioLogic.getTipoCambios();
			}

			detalleasientocontableReturnGeneral.settipocambiosForeignKey(tipocambiosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalleasientocontableReturnGeneral;
	}
	
	
	public void deepLoad(DetalleAsientoContable detalleasientocontable,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleAsientoContableLogicAdditional.updateDetalleAsientoContableToGet(detalleasientocontable,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleasientocontable.setEmpresa(detalleasientocontableDataAccess.getEmpresa(connexion,detalleasientocontable));
		detalleasientocontable.setSucursal(detalleasientocontableDataAccess.getSucursal(connexion,detalleasientocontable));
		detalleasientocontable.setAsientoContable(detalleasientocontableDataAccess.getAsientoContable(connexion,detalleasientocontable));
		detalleasientocontable.setEjercicio(detalleasientocontableDataAccess.getEjercicio(connexion,detalleasientocontable));
		detalleasientocontable.setPeriodo(detalleasientocontableDataAccess.getPeriodo(connexion,detalleasientocontable));
		detalleasientocontable.setAnio(detalleasientocontableDataAccess.getAnio(connexion,detalleasientocontable));
		detalleasientocontable.setMes(detalleasientocontableDataAccess.getMes(connexion,detalleasientocontable));
		detalleasientocontable.setCuentaContable(detalleasientocontableDataAccess.getCuentaContable(connexion,detalleasientocontable));
		detalleasientocontable.setCentroActividad(detalleasientocontableDataAccess.getCentroActividad(connexion,detalleasientocontable));
		detalleasientocontable.setCentroCosto(detalleasientocontableDataAccess.getCentroCosto(connexion,detalleasientocontable));
		detalleasientocontable.setTipoCambio(detalleasientocontableDataAccess.getTipoCambio(connexion,detalleasientocontable));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleasientocontable.setEmpresa(detalleasientocontableDataAccess.getEmpresa(connexion,detalleasientocontable));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleasientocontable.setSucursal(detalleasientocontableDataAccess.getSucursal(connexion,detalleasientocontable));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				detalleasientocontable.setAsientoContable(detalleasientocontableDataAccess.getAsientoContable(connexion,detalleasientocontable));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalleasientocontable.setEjercicio(detalleasientocontableDataAccess.getEjercicio(connexion,detalleasientocontable));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalleasientocontable.setPeriodo(detalleasientocontableDataAccess.getPeriodo(connexion,detalleasientocontable));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detalleasientocontable.setAnio(detalleasientocontableDataAccess.getAnio(connexion,detalleasientocontable));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detalleasientocontable.setMes(detalleasientocontableDataAccess.getMes(connexion,detalleasientocontable));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				detalleasientocontable.setCuentaContable(detalleasientocontableDataAccess.getCuentaContable(connexion,detalleasientocontable));
				continue;
			}

			if(clas.clas.equals(CentroActividad.class)) {
				detalleasientocontable.setCentroActividad(detalleasientocontableDataAccess.getCentroActividad(connexion,detalleasientocontable));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detalleasientocontable.setCentroCosto(detalleasientocontableDataAccess.getCentroCosto(connexion,detalleasientocontable));
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				detalleasientocontable.setTipoCambio(detalleasientocontableDataAccess.getTipoCambio(connexion,detalleasientocontable));
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
			detalleasientocontable.setEmpresa(detalleasientocontableDataAccess.getEmpresa(connexion,detalleasientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontable.setSucursal(detalleasientocontableDataAccess.getSucursal(connexion,detalleasientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontable.setAsientoContable(detalleasientocontableDataAccess.getAsientoContable(connexion,detalleasientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontable.setEjercicio(detalleasientocontableDataAccess.getEjercicio(connexion,detalleasientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontable.setPeriodo(detalleasientocontableDataAccess.getPeriodo(connexion,detalleasientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontable.setAnio(detalleasientocontableDataAccess.getAnio(connexion,detalleasientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontable.setMes(detalleasientocontableDataAccess.getMes(connexion,detalleasientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontable.setCuentaContable(detalleasientocontableDataAccess.getCuentaContable(connexion,detalleasientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroActividad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontable.setCentroActividad(detalleasientocontableDataAccess.getCentroActividad(connexion,detalleasientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontable.setCentroCosto(detalleasientocontableDataAccess.getCentroCosto(connexion,detalleasientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontable.setTipoCambio(detalleasientocontableDataAccess.getTipoCambio(connexion,detalleasientocontable));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleasientocontable.setEmpresa(detalleasientocontableDataAccess.getEmpresa(connexion,detalleasientocontable));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleasientocontable.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalleasientocontable.setSucursal(detalleasientocontableDataAccess.getSucursal(connexion,detalleasientocontable));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleasientocontable.getSucursal(),isDeep,deepLoadType,clases);
				
		detalleasientocontable.setAsientoContable(detalleasientocontableDataAccess.getAsientoContable(connexion,detalleasientocontable));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(detalleasientocontable.getAsientoContable(),isDeep,deepLoadType,clases);
				
		detalleasientocontable.setEjercicio(detalleasientocontableDataAccess.getEjercicio(connexion,detalleasientocontable));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalleasientocontable.getEjercicio(),isDeep,deepLoadType,clases);
				
		detalleasientocontable.setPeriodo(detalleasientocontableDataAccess.getPeriodo(connexion,detalleasientocontable));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalleasientocontable.getPeriodo(),isDeep,deepLoadType,clases);
				
		detalleasientocontable.setAnio(detalleasientocontableDataAccess.getAnio(connexion,detalleasientocontable));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detalleasientocontable.getAnio(),isDeep,deepLoadType,clases);
				
		detalleasientocontable.setMes(detalleasientocontableDataAccess.getMes(connexion,detalleasientocontable));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detalleasientocontable.getMes(),isDeep,deepLoadType,clases);
				
		detalleasientocontable.setCuentaContable(detalleasientocontableDataAccess.getCuentaContable(connexion,detalleasientocontable));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(detalleasientocontable.getCuentaContable(),isDeep,deepLoadType,clases);
				
		detalleasientocontable.setCentroActividad(detalleasientocontableDataAccess.getCentroActividad(connexion,detalleasientocontable));
		CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
		centroactividadLogic.deepLoad(detalleasientocontable.getCentroActividad(),isDeep,deepLoadType,clases);
				
		detalleasientocontable.setCentroCosto(detalleasientocontableDataAccess.getCentroCosto(connexion,detalleasientocontable));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detalleasientocontable.getCentroCosto(),isDeep,deepLoadType,clases);
				
		detalleasientocontable.setTipoCambio(detalleasientocontableDataAccess.getTipoCambio(connexion,detalleasientocontable));
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(detalleasientocontable.getTipoCambio(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleasientocontable.setEmpresa(detalleasientocontableDataAccess.getEmpresa(connexion,detalleasientocontable));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalleasientocontable.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleasientocontable.setSucursal(detalleasientocontableDataAccess.getSucursal(connexion,detalleasientocontable));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detalleasientocontable.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				detalleasientocontable.setAsientoContable(detalleasientocontableDataAccess.getAsientoContable(connexion,detalleasientocontable));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(detalleasientocontable.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalleasientocontable.setEjercicio(detalleasientocontableDataAccess.getEjercicio(connexion,detalleasientocontable));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detalleasientocontable.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalleasientocontable.setPeriodo(detalleasientocontableDataAccess.getPeriodo(connexion,detalleasientocontable));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detalleasientocontable.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detalleasientocontable.setAnio(detalleasientocontableDataAccess.getAnio(connexion,detalleasientocontable));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detalleasientocontable.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detalleasientocontable.setMes(detalleasientocontableDataAccess.getMes(connexion,detalleasientocontable));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detalleasientocontable.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				detalleasientocontable.setCuentaContable(detalleasientocontableDataAccess.getCuentaContable(connexion,detalleasientocontable));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(detalleasientocontable.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroActividad.class)) {
				detalleasientocontable.setCentroActividad(detalleasientocontableDataAccess.getCentroActividad(connexion,detalleasientocontable));
				CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
				centroactividadLogic.deepLoad(detalleasientocontable.getCentroActividad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detalleasientocontable.setCentroCosto(detalleasientocontableDataAccess.getCentroCosto(connexion,detalleasientocontable));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(detalleasientocontable.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				detalleasientocontable.setTipoCambio(detalleasientocontableDataAccess.getTipoCambio(connexion,detalleasientocontable));
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepLoad(detalleasientocontable.getTipoCambio(),isDeep,deepLoadType,clases);				
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
			detalleasientocontable.setEmpresa(detalleasientocontableDataAccess.getEmpresa(connexion,detalleasientocontable));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalleasientocontable.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontable.setSucursal(detalleasientocontableDataAccess.getSucursal(connexion,detalleasientocontable));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detalleasientocontable.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontable.setAsientoContable(detalleasientocontableDataAccess.getAsientoContable(connexion,detalleasientocontable));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(detalleasientocontable.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontable.setEjercicio(detalleasientocontableDataAccess.getEjercicio(connexion,detalleasientocontable));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detalleasientocontable.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontable.setPeriodo(detalleasientocontableDataAccess.getPeriodo(connexion,detalleasientocontable));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detalleasientocontable.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontable.setAnio(detalleasientocontableDataAccess.getAnio(connexion,detalleasientocontable));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detalleasientocontable.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontable.setMes(detalleasientocontableDataAccess.getMes(connexion,detalleasientocontable));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detalleasientocontable.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontable.setCuentaContable(detalleasientocontableDataAccess.getCuentaContable(connexion,detalleasientocontable));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(detalleasientocontable.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroActividad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontable.setCentroActividad(detalleasientocontableDataAccess.getCentroActividad(connexion,detalleasientocontable));
			CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
			centroactividadLogic.deepLoad(detalleasientocontable.getCentroActividad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontable.setCentroCosto(detalleasientocontableDataAccess.getCentroCosto(connexion,detalleasientocontable));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(detalleasientocontable.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCambio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleasientocontable.setTipoCambio(detalleasientocontableDataAccess.getTipoCambio(connexion,detalleasientocontable));
			TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
			tipocambioLogic.deepLoad(detalleasientocontable.getTipoCambio(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleAsientoContable detalleasientocontable,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleAsientoContableLogicAdditional.updateDetalleAsientoContableToSave(detalleasientocontable,this.arrDatoGeneral);
			
DetalleAsientoContableDataAccess.save(detalleasientocontable, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleasientocontable.getEmpresa(),connexion);

		SucursalDataAccess.save(detalleasientocontable.getSucursal(),connexion);

		AsientoContableDataAccess.save(detalleasientocontable.getAsientoContable(),connexion);

		EjercicioDataAccess.save(detalleasientocontable.getEjercicio(),connexion);

		PeriodoDataAccess.save(detalleasientocontable.getPeriodo(),connexion);

		AnioDataAccess.save(detalleasientocontable.getAnio(),connexion);

		MesDataAccess.save(detalleasientocontable.getMes(),connexion);

		CuentaContableDataAccess.save(detalleasientocontable.getCuentaContable(),connexion);

		CentroActividadDataAccess.save(detalleasientocontable.getCentroActividad(),connexion);

		CentroCostoDataAccess.save(detalleasientocontable.getCentroCosto(),connexion);

		TipoCambioDataAccess.save(detalleasientocontable.getTipoCambio(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleasientocontable.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleasientocontable.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(detalleasientocontable.getAsientoContable(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalleasientocontable.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalleasientocontable.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detalleasientocontable.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detalleasientocontable.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(detalleasientocontable.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroActividad.class)) {
				CentroActividadDataAccess.save(detalleasientocontable.getCentroActividad(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detalleasientocontable.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(detalleasientocontable.getTipoCambio(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleasientocontable.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleasientocontable.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detalleasientocontable.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleasientocontable.getSucursal(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(detalleasientocontable.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(detalleasientocontable.getAsientoContable(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detalleasientocontable.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalleasientocontable.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detalleasientocontable.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalleasientocontable.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detalleasientocontable.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detalleasientocontable.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detalleasientocontable.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detalleasientocontable.getMes(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(detalleasientocontable.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(detalleasientocontable.getCuentaContable(),isDeep,deepLoadType,clases);
				

		CentroActividadDataAccess.save(detalleasientocontable.getCentroActividad(),connexion);
		CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
		centroactividadLogic.deepLoad(detalleasientocontable.getCentroActividad(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(detalleasientocontable.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detalleasientocontable.getCentroCosto(),isDeep,deepLoadType,clases);
				

		TipoCambioDataAccess.save(detalleasientocontable.getTipoCambio(),connexion);
		TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
		tipocambioLogic.deepLoad(detalleasientocontable.getTipoCambio(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleasientocontable.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalleasientocontable.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleasientocontable.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detalleasientocontable.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(detalleasientocontable.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(detalleasientocontable.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalleasientocontable.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detalleasientocontable.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalleasientocontable.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detalleasientocontable.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detalleasientocontable.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detalleasientocontable.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detalleasientocontable.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detalleasientocontable.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(detalleasientocontable.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(detalleasientocontable.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroActividad.class)) {
				CentroActividadDataAccess.save(detalleasientocontable.getCentroActividad(),connexion);
				CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
				centroactividadLogic.deepSave(detalleasientocontable.getCentroActividad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detalleasientocontable.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(detalleasientocontable.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCambio.class)) {
				TipoCambioDataAccess.save(detalleasientocontable.getTipoCambio(),connexion);
				TipoCambioLogic tipocambioLogic= new TipoCambioLogic(connexion);
				tipocambioLogic.deepSave(detalleasientocontable.getTipoCambio(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleAsientoContable.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalleasientocontable,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(detalleasientocontable);
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
			this.deepLoad(this.detalleasientocontable,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleAsientoContable.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalleasientocontables!=null) {
				for(DetalleAsientoContable detalleasientocontable:detalleasientocontables) {
					this.deepLoad(detalleasientocontable,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(detalleasientocontables);
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
			if(detalleasientocontables!=null) {
				for(DetalleAsientoContable detalleasientocontable:detalleasientocontables) {
					this.deepLoad(detalleasientocontable,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(detalleasientocontables);
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
			this.getNewConnexionToDeep(DetalleAsientoContable.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalleasientocontable,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleAsientoContable.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalleasientocontables!=null) {
				for(DetalleAsientoContable detalleasientocontable:detalleasientocontables) {
					this.deepSave(detalleasientocontable,isDeep,deepLoadType,clases);
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
			if(detalleasientocontables!=null) {
				for(DetalleAsientoContable detalleasientocontable:detalleasientocontables) {
					this.deepSave(detalleasientocontable,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleAsientoContablesFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleAsientoContableConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContablesFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleAsientoContableConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContablesFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,DetalleAsientoContableConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContablesFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,DetalleAsientoContableConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContablesFK_IdCentroActividadWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_actividad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroActividad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroActividad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_actividad,DetalleAsientoContableConstantesFunciones.IDCENTROACTIVIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroActividad);

			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroActividad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContablesFK_IdCentroActividad(String sFinalQuery,Pagination pagination,Long id_centro_actividad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroActividad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroActividad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_actividad,DetalleAsientoContableConstantesFunciones.IDCENTROACTIVIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroActividad);

			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroActividad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContablesFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetalleAsientoContableConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContablesFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetalleAsientoContableConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContablesFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,DetalleAsientoContableConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContablesFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,DetalleAsientoContableConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContablesFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleAsientoContableConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContablesFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleAsientoContableConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContablesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleAsientoContableConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContablesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleAsientoContableConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContablesFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleAsientoContableConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContablesFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleAsientoContableConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContablesFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleAsientoContableConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContablesFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleAsientoContableConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContablesFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleAsientoContableConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContablesFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleAsientoContableConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleAsientoContablesFK_IdTipoCambioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleAsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,DetalleAsientoContableConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleAsientoContablesFK_IdTipoCambio(String sFinalQuery,Pagination pagination,Long id_tipo_cambio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCambio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCambio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cambio,DetalleAsientoContableConstantesFunciones.IDTIPOCAMBIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCambio);

			DetalleAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCambio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleasientocontables=detalleasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(this.detalleasientocontables);
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
			if(DetalleAsientoContableConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleAsientoContableDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleAsientoContable detalleasientocontable,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleAsientoContableConstantesFunciones.ISCONAUDITORIA) {
				if(detalleasientocontable.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleAsientoContableDataAccess.TABLENAME, detalleasientocontable.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleAsientoContableConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleAsientoContableLogic.registrarAuditoriaDetallesDetalleAsientoContable(connexion,detalleasientocontable,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalleasientocontable.getIsDeleted()) {
					/*if(!detalleasientocontable.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleAsientoContableDataAccess.TABLENAME, detalleasientocontable.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleAsientoContableLogic.registrarAuditoriaDetallesDetalleAsientoContable(connexion,detalleasientocontable,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleAsientoContableDataAccess.TABLENAME, detalleasientocontable.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalleasientocontable.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleAsientoContableDataAccess.TABLENAME, detalleasientocontable.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleAsientoContableConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleAsientoContableLogic.registrarAuditoriaDetallesDetalleAsientoContable(connexion,detalleasientocontable,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleAsientoContable(Connexion connexion,DetalleAsientoContable detalleasientocontable)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalleasientocontable.getIsNew()||!detalleasientocontable.getid_empresa().equals(detalleasientocontable.getDetalleAsientoContableOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontable.getDetalleAsientoContableOriginal().getid_empresa()!=null)
				{
					strValorActual=detalleasientocontable.getDetalleAsientoContableOriginal().getid_empresa().toString();
				}
				if(detalleasientocontable.getid_empresa()!=null)
				{
					strValorNuevo=detalleasientocontable.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontable.getIsNew()||!detalleasientocontable.getid_sucursal().equals(detalleasientocontable.getDetalleAsientoContableOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontable.getDetalleAsientoContableOriginal().getid_sucursal()!=null)
				{
					strValorActual=detalleasientocontable.getDetalleAsientoContableOriginal().getid_sucursal().toString();
				}
				if(detalleasientocontable.getid_sucursal()!=null)
				{
					strValorNuevo=detalleasientocontable.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontable.getIsNew()||!detalleasientocontable.getid_asiento_contable().equals(detalleasientocontable.getDetalleAsientoContableOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontable.getDetalleAsientoContableOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=detalleasientocontable.getDetalleAsientoContableOriginal().getid_asiento_contable().toString();
				}
				if(detalleasientocontable.getid_asiento_contable()!=null)
				{
					strValorNuevo=detalleasientocontable.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontable.getIsNew()||!detalleasientocontable.getnumero_documento().equals(detalleasientocontable.getDetalleAsientoContableOriginal().getnumero_documento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontable.getDetalleAsientoContableOriginal().getnumero_documento()!=null)
				{
					strValorActual=detalleasientocontable.getDetalleAsientoContableOriginal().getnumero_documento();
				}
				if(detalleasientocontable.getnumero_documento()!=null)
				{
					strValorNuevo=detalleasientocontable.getnumero_documento() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableConstantesFunciones.NUMERODOCUMENTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontable.getIsNew()||!detalleasientocontable.getid_ejercicio().equals(detalleasientocontable.getDetalleAsientoContableOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontable.getDetalleAsientoContableOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detalleasientocontable.getDetalleAsientoContableOriginal().getid_ejercicio().toString();
				}
				if(detalleasientocontable.getid_ejercicio()!=null)
				{
					strValorNuevo=detalleasientocontable.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontable.getIsNew()||!detalleasientocontable.getid_periodo().equals(detalleasientocontable.getDetalleAsientoContableOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontable.getDetalleAsientoContableOriginal().getid_periodo()!=null)
				{
					strValorActual=detalleasientocontable.getDetalleAsientoContableOriginal().getid_periodo().toString();
				}
				if(detalleasientocontable.getid_periodo()!=null)
				{
					strValorNuevo=detalleasientocontable.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontable.getIsNew()||!detalleasientocontable.getid_anio().equals(detalleasientocontable.getDetalleAsientoContableOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontable.getDetalleAsientoContableOriginal().getid_anio()!=null)
				{
					strValorActual=detalleasientocontable.getDetalleAsientoContableOriginal().getid_anio().toString();
				}
				if(detalleasientocontable.getid_anio()!=null)
				{
					strValorNuevo=detalleasientocontable.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontable.getIsNew()||!detalleasientocontable.getid_mes().equals(detalleasientocontable.getDetalleAsientoContableOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontable.getDetalleAsientoContableOriginal().getid_mes()!=null)
				{
					strValorActual=detalleasientocontable.getDetalleAsientoContableOriginal().getid_mes().toString();
				}
				if(detalleasientocontable.getid_mes()!=null)
				{
					strValorNuevo=detalleasientocontable.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontable.getIsNew()||!detalleasientocontable.getid_cuenta_contable().equals(detalleasientocontable.getDetalleAsientoContableOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontable.getDetalleAsientoContableOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=detalleasientocontable.getDetalleAsientoContableOriginal().getid_cuenta_contable().toString();
				}
				if(detalleasientocontable.getid_cuenta_contable()!=null)
				{
					strValorNuevo=detalleasientocontable.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontable.getIsNew()||!detalleasientocontable.getdebito_local().equals(detalleasientocontable.getDetalleAsientoContableOriginal().getdebito_local()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontable.getDetalleAsientoContableOriginal().getdebito_local()!=null)
				{
					strValorActual=detalleasientocontable.getDetalleAsientoContableOriginal().getdebito_local().toString();
				}
				if(detalleasientocontable.getdebito_local()!=null)
				{
					strValorNuevo=detalleasientocontable.getdebito_local().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableConstantesFunciones.DEBITOLOCAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontable.getIsNew()||!detalleasientocontable.getcredito_local().equals(detalleasientocontable.getDetalleAsientoContableOriginal().getcredito_local()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontable.getDetalleAsientoContableOriginal().getcredito_local()!=null)
				{
					strValorActual=detalleasientocontable.getDetalleAsientoContableOriginal().getcredito_local().toString();
				}
				if(detalleasientocontable.getcredito_local()!=null)
				{
					strValorNuevo=detalleasientocontable.getcredito_local().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableConstantesFunciones.CREDITOLOCAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontable.getIsNew()||!detalleasientocontable.getdebito_extran().equals(detalleasientocontable.getDetalleAsientoContableOriginal().getdebito_extran()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontable.getDetalleAsientoContableOriginal().getdebito_extran()!=null)
				{
					strValorActual=detalleasientocontable.getDetalleAsientoContableOriginal().getdebito_extran().toString();
				}
				if(detalleasientocontable.getdebito_extran()!=null)
				{
					strValorNuevo=detalleasientocontable.getdebito_extran().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableConstantesFunciones.DEBITOEXTRAN,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontable.getIsNew()||!detalleasientocontable.getcredito_extran().equals(detalleasientocontable.getDetalleAsientoContableOriginal().getcredito_extran()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontable.getDetalleAsientoContableOriginal().getcredito_extran()!=null)
				{
					strValorActual=detalleasientocontable.getDetalleAsientoContableOriginal().getcredito_extran().toString();
				}
				if(detalleasientocontable.getcredito_extran()!=null)
				{
					strValorNuevo=detalleasientocontable.getcredito_extran().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableConstantesFunciones.CREDITOEXTRAN,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontable.getIsNew()||!detalleasientocontable.getid_centro_actividad().equals(detalleasientocontable.getDetalleAsientoContableOriginal().getid_centro_actividad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontable.getDetalleAsientoContableOriginal().getid_centro_actividad()!=null)
				{
					strValorActual=detalleasientocontable.getDetalleAsientoContableOriginal().getid_centro_actividad().toString();
				}
				if(detalleasientocontable.getid_centro_actividad()!=null)
				{
					strValorNuevo=detalleasientocontable.getid_centro_actividad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableConstantesFunciones.IDCENTROACTIVIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontable.getIsNew()||!detalleasientocontable.getid_centro_costo().equals(detalleasientocontable.getDetalleAsientoContableOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontable.getDetalleAsientoContableOriginal().getid_centro_costo()!=null)
				{
					strValorActual=detalleasientocontable.getDetalleAsientoContableOriginal().getid_centro_costo().toString();
				}
				if(detalleasientocontable.getid_centro_costo()!=null)
				{
					strValorNuevo=detalleasientocontable.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontable.getIsNew()||!detalleasientocontable.getcotizacion().equals(detalleasientocontable.getDetalleAsientoContableOriginal().getcotizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontable.getDetalleAsientoContableOriginal().getcotizacion()!=null)
				{
					strValorActual=detalleasientocontable.getDetalleAsientoContableOriginal().getcotizacion().toString();
				}
				if(detalleasientocontable.getcotizacion()!=null)
				{
					strValorNuevo=detalleasientocontable.getcotizacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableConstantesFunciones.COTIZACION,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontable.getIsNew()||!detalleasientocontable.getdetalle().equals(detalleasientocontable.getDetalleAsientoContableOriginal().getdetalle()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontable.getDetalleAsientoContableOriginal().getdetalle()!=null)
				{
					strValorActual=detalleasientocontable.getDetalleAsientoContableOriginal().getdetalle();
				}
				if(detalleasientocontable.getdetalle()!=null)
				{
					strValorNuevo=detalleasientocontable.getdetalle() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableConstantesFunciones.DETALLE,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontable.getIsNew()||!detalleasientocontable.getid_tipo_cambio().equals(detalleasientocontable.getDetalleAsientoContableOriginal().getid_tipo_cambio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontable.getDetalleAsientoContableOriginal().getid_tipo_cambio()!=null)
				{
					strValorActual=detalleasientocontable.getDetalleAsientoContableOriginal().getid_tipo_cambio().toString();
				}
				if(detalleasientocontable.getid_tipo_cambio()!=null)
				{
					strValorNuevo=detalleasientocontable.getid_tipo_cambio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableConstantesFunciones.IDTIPOCAMBIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontable.getIsNew()||!detalleasientocontable.getcon_centro_costo().equals(detalleasientocontable.getDetalleAsientoContableOriginal().getcon_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontable.getDetalleAsientoContableOriginal().getcon_centro_costo()!=null)
				{
					strValorActual=detalleasientocontable.getDetalleAsientoContableOriginal().getcon_centro_costo().toString();
				}
				if(detalleasientocontable.getcon_centro_costo()!=null)
				{
					strValorNuevo=detalleasientocontable.getcon_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableConstantesFunciones.CONCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontable.getIsNew()||!detalleasientocontable.getfecha().equals(detalleasientocontable.getDetalleAsientoContableOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontable.getDetalleAsientoContableOriginal().getfecha()!=null)
				{
					strValorActual=detalleasientocontable.getDetalleAsientoContableOriginal().getfecha().toString();
				}
				if(detalleasientocontable.getfecha()!=null)
				{
					strValorNuevo=detalleasientocontable.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(detalleasientocontable.getIsNew()||!detalleasientocontable.getnumero_deposito().equals(detalleasientocontable.getDetalleAsientoContableOriginal().getnumero_deposito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleasientocontable.getDetalleAsientoContableOriginal().getnumero_deposito()!=null)
				{
					strValorActual=detalleasientocontable.getDetalleAsientoContableOriginal().getnumero_deposito();
				}
				if(detalleasientocontable.getnumero_deposito()!=null)
				{
					strValorNuevo=detalleasientocontable.getnumero_deposito() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleAsientoContableConstantesFunciones.NUMERODEPOSITO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleAsientoContableRelacionesWithConnection(DetalleAsientoContable detalleasientocontable) throws Exception {

		if(!detalleasientocontable.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleAsientoContableRelacionesBase(detalleasientocontable,true);
		}
	}

	public void saveDetalleAsientoContableRelaciones(DetalleAsientoContable detalleasientocontable)throws Exception {

		if(!detalleasientocontable.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleAsientoContableRelacionesBase(detalleasientocontable,false);
		}
	}

	public void saveDetalleAsientoContableRelacionesBase(DetalleAsientoContable detalleasientocontable,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleAsientoContable-saveRelacionesWithConnection");}
	

			this.setDetalleAsientoContable(detalleasientocontable);

			if(DetalleAsientoContableLogicAdditional.validarSaveRelaciones(detalleasientocontable,this)) {

				DetalleAsientoContableLogicAdditional.updateRelacionesToSave(detalleasientocontable,this);

				if((detalleasientocontable.getIsNew()||detalleasientocontable.getIsChanged())&&!detalleasientocontable.getIsDeleted()) {
					this.saveDetalleAsientoContable();
					this.saveDetalleAsientoContableRelacionesDetalles();

				} else if(detalleasientocontable.getIsDeleted()) {
					this.saveDetalleAsientoContableRelacionesDetalles();
					this.saveDetalleAsientoContable();
				}

				DetalleAsientoContableLogicAdditional.updateRelacionesToSaveAfter(detalleasientocontable,this);

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
	
	
	private void saveDetalleAsientoContableRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleAsientoContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleAsientoContableConstantesFunciones.getClassesForeignKeysOfDetalleAsientoContable(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleAsientoContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleAsientoContableConstantesFunciones.getClassesRelationshipsOfDetalleAsientoContable(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

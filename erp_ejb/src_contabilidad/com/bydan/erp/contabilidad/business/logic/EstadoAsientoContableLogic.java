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
import com.bydan.erp.contabilidad.util.EstadoAsientoContableConstantesFunciones;
import com.bydan.erp.contabilidad.util.EstadoAsientoContableParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.EstadoAsientoContableParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.EstadoAsientoContable;
//import com.bydan.erp.contabilidad.business.logic.EstadoAsientoContableLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class EstadoAsientoContableLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoAsientoContableLogic.class);
	
	protected EstadoAsientoContableDataAccess estadoasientocontableDataAccess; 	
	protected EstadoAsientoContable estadoasientocontable;
	protected List<EstadoAsientoContable> estadoasientocontables;
	protected Object estadoasientocontableObject;	
	protected List<Object> estadoasientocontablesObject;
	
	public static ClassValidator<EstadoAsientoContable> estadoasientocontableValidator = new ClassValidator<EstadoAsientoContable>(EstadoAsientoContable.class);	
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
	
	
	
	
	public  EstadoAsientoContableLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadoasientocontableDataAccess = new EstadoAsientoContableDataAccess();
			
			this.estadoasientocontables= new ArrayList<EstadoAsientoContable>();
			this.estadoasientocontable= new EstadoAsientoContable();
			
			this.estadoasientocontableObject=new Object();
			this.estadoasientocontablesObject=new ArrayList<Object>();
				
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
			
			this.estadoasientocontableDataAccess.setConnexionType(this.connexionType);
			this.estadoasientocontableDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoAsientoContableLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadoasientocontableDataAccess = new EstadoAsientoContableDataAccess();
			this.estadoasientocontables= new ArrayList<EstadoAsientoContable>();
			this.estadoasientocontable= new EstadoAsientoContable();
			this.estadoasientocontableObject=new Object();
			this.estadoasientocontablesObject=new ArrayList<Object>();
			
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
			
			this.estadoasientocontableDataAccess.setConnexionType(this.connexionType);
			this.estadoasientocontableDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoAsientoContable getEstadoAsientoContable() throws Exception {	
		//EstadoAsientoContableLogicAdditional.checkEstadoAsientoContableToGet(estadoasientocontable,this.datosCliente,this.arrDatoGeneral);
		//EstadoAsientoContableLogicAdditional.updateEstadoAsientoContableToGet(estadoasientocontable,this.arrDatoGeneral);
		
		return estadoasientocontable;
	}
		
	public void setEstadoAsientoContable(EstadoAsientoContable newEstadoAsientoContable) {
		this.estadoasientocontable = newEstadoAsientoContable;
	}
	
	public EstadoAsientoContableDataAccess getEstadoAsientoContableDataAccess() {
		return estadoasientocontableDataAccess;
	}
	
	public void setEstadoAsientoContableDataAccess(EstadoAsientoContableDataAccess newestadoasientocontableDataAccess) {
		this.estadoasientocontableDataAccess = newestadoasientocontableDataAccess;
	}
	
	public List<EstadoAsientoContable> getEstadoAsientoContables() throws Exception {		
		this.quitarEstadoAsientoContablesNulos();
		
		//EstadoAsientoContableLogicAdditional.checkEstadoAsientoContableToGets(estadoasientocontables,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoAsientoContable estadoasientocontableLocal: estadoasientocontables ) {
			//EstadoAsientoContableLogicAdditional.updateEstadoAsientoContableToGet(estadoasientocontableLocal,this.arrDatoGeneral);
		}
		
		return estadoasientocontables;
	}
	
	public void setEstadoAsientoContables(List<EstadoAsientoContable> newEstadoAsientoContables) {
		this.estadoasientocontables = newEstadoAsientoContables;
	}
	
	public Object getEstadoAsientoContableObject() {	
		this.estadoasientocontableObject=this.estadoasientocontableDataAccess.getEntityObject();
		return this.estadoasientocontableObject;
	}
		
	public void setEstadoAsientoContableObject(Object newEstadoAsientoContableObject) {
		this.estadoasientocontableObject = newEstadoAsientoContableObject;
	}
	
	public List<Object> getEstadoAsientoContablesObject() {		
		this.estadoasientocontablesObject=this.estadoasientocontableDataAccess.getEntitiesObject();
		return this.estadoasientocontablesObject;
	}
		
	public void setEstadoAsientoContablesObject(List<Object> newEstadoAsientoContablesObject) {
		this.estadoasientocontablesObject = newEstadoAsientoContablesObject;
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
		
		if(this.estadoasientocontableDataAccess!=null) {
			this.estadoasientocontableDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContable.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadoasientocontableDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadoasientocontableDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadoasientocontable = new  EstadoAsientoContable();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoasientocontable=estadoasientocontableDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoasientocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContable(this.estadoasientocontable);
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
		estadoasientocontable = new  EstadoAsientoContable();
		  		  
        try {
			
			estadoasientocontable=estadoasientocontableDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoasientocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContable(this.estadoasientocontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadoasientocontable = new  EstadoAsientoContable();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoasientocontable=estadoasientocontableDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoasientocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContable(this.estadoasientocontable);
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
		estadoasientocontable = new  EstadoAsientoContable();
		  		  
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
		estadoasientocontable = new  EstadoAsientoContable();
		  		  
        try {
			
			estadoasientocontable=estadoasientocontableDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoasientocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContable(this.estadoasientocontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadoasientocontable = new  EstadoAsientoContable();
		  		  
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
		estadoasientocontable = new  EstadoAsientoContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContable.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadoasientocontableDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoasientocontable = new  EstadoAsientoContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadoasientocontableDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoasientocontable = new  EstadoAsientoContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContable.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadoasientocontableDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoasientocontable = new  EstadoAsientoContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadoasientocontableDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoasientocontable = new  EstadoAsientoContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContable.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadoasientocontableDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoasientocontable = new  EstadoAsientoContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadoasientocontableDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadoasientocontables = new  ArrayList<EstadoAsientoContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoasientocontables=estadoasientocontableDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoAsientoContable(estadoasientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContable(this.estadoasientocontables);
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
		estadoasientocontables = new  ArrayList<EstadoAsientoContable>();
		  		  
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
		estadoasientocontables = new  ArrayList<EstadoAsientoContable>();
		  		  
        try {			
			EstadoAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoasientocontables=estadoasientocontableDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoAsientoContable(estadoasientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContable(this.estadoasientocontables);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadoasientocontables = new  ArrayList<EstadoAsientoContable>();
		  		  
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
		estadoasientocontables = new  ArrayList<EstadoAsientoContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoasientocontables=estadoasientocontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoAsientoContable(estadoasientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContable(this.estadoasientocontables);
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
		estadoasientocontables = new  ArrayList<EstadoAsientoContable>();
		  		  
        try {
			EstadoAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoasientocontables=estadoasientocontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoAsientoContable(estadoasientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContable(this.estadoasientocontables);
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
		estadoasientocontables = new  ArrayList<EstadoAsientoContable>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoasientocontables=estadoasientocontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoAsientoContable(estadoasientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContable(this.estadoasientocontables);
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
		estadoasientocontables = new  ArrayList<EstadoAsientoContable>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoasientocontables=estadoasientocontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoAsientoContable(estadoasientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContable(this.estadoasientocontables);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadoasientocontable = new  EstadoAsientoContable();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoasientocontable=estadoasientocontableDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoAsientoContable(estadoasientocontable);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContable(this.estadoasientocontable);
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
		estadoasientocontable = new  EstadoAsientoContable();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoasientocontable=estadoasientocontableDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoAsientoContable(estadoasientocontable);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContable(this.estadoasientocontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosEstadoAsientoContablesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadoasientocontables = new  ArrayList<EstadoAsientoContable>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContable.class.getSimpleName()+"-getTodosEstadoAsientoContablesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoasientocontables=estadoasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoAsientoContable(estadoasientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContable(this.estadoasientocontables);
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
	
	public  void  getTodosEstadoAsientoContables(String sFinalQuery,Pagination pagination)throws Exception {
		estadoasientocontables = new  ArrayList<EstadoAsientoContable>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoasientocontables=estadoasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoAsientoContable(estadoasientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContable(this.estadoasientocontables);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoAsientoContable(EstadoAsientoContable estadoasientocontable) throws Exception {
		Boolean estaValidado=false;
		
		if(estadoasientocontable.getIsNew() || estadoasientocontable.getIsChanged()) { 
			this.invalidValues = estadoasientocontableValidator.getInvalidValues(estadoasientocontable);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadoasientocontable);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoAsientoContable(List<EstadoAsientoContable> EstadoAsientoContables) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoAsientoContable estadoasientocontableLocal:estadoasientocontables) {				
			estaValidadoObjeto=this.validarGuardarEstadoAsientoContable(estadoasientocontableLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoAsientoContable(List<EstadoAsientoContable> EstadoAsientoContables) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoAsientoContable(estadoasientocontables)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoAsientoContable(EstadoAsientoContable EstadoAsientoContable) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoAsientoContable(estadoasientocontable)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoAsientoContable estadoasientocontable) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadoasientocontable.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoAsientoContableConstantesFunciones.getEstadoAsientoContableLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadoasientocontable","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoAsientoContableConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoAsientoContableConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoAsientoContableWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContable.class.getSimpleName()+"-saveEstadoAsientoContableWithConnection");connexion.begin();			
			
			//EstadoAsientoContableLogicAdditional.checkEstadoAsientoContableToSave(this.estadoasientocontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoAsientoContableLogicAdditional.updateEstadoAsientoContableToSave(this.estadoasientocontable,this.arrDatoGeneral);
			
			EstadoAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoasientocontable,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoAsientoContable();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoAsientoContable(this.estadoasientocontable)) {
				EstadoAsientoContableDataAccess.save(this.estadoasientocontable, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadoasientocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoAsientoContableLogicAdditional.checkEstadoAsientoContableToSaveAfter(this.estadoasientocontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoAsientoContable();
			
			connexion.commit();			
			
			if(this.estadoasientocontable.getIsDeleted()) {
				this.estadoasientocontable=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoAsientoContable()throws Exception {	
		try {	
			
			//EstadoAsientoContableLogicAdditional.checkEstadoAsientoContableToSave(this.estadoasientocontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoAsientoContableLogicAdditional.updateEstadoAsientoContableToSave(this.estadoasientocontable,this.arrDatoGeneral);
			
			EstadoAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoasientocontable,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoAsientoContable(this.estadoasientocontable)) {			
				EstadoAsientoContableDataAccess.save(this.estadoasientocontable, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadoasientocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoAsientoContableLogicAdditional.checkEstadoAsientoContableToSaveAfter(this.estadoasientocontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadoasientocontable.getIsDeleted()) {
				this.estadoasientocontable=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoAsientoContablesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContable.class.getSimpleName()+"-saveEstadoAsientoContablesWithConnection");connexion.begin();			
			
			//EstadoAsientoContableLogicAdditional.checkEstadoAsientoContableToSaves(estadoasientocontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoAsientoContables();
			
			Boolean validadoTodosEstadoAsientoContable=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoAsientoContable estadoasientocontableLocal:estadoasientocontables) {		
				if(estadoasientocontableLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoAsientoContableLogicAdditional.updateEstadoAsientoContableToSave(estadoasientocontableLocal,this.arrDatoGeneral);
	        	
				EstadoAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoasientocontableLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoAsientoContable(estadoasientocontableLocal)) {
					EstadoAsientoContableDataAccess.save(estadoasientocontableLocal, connexion);				
				} else {
					validadoTodosEstadoAsientoContable=false;
				}
			}
			
			if(!validadoTodosEstadoAsientoContable) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoAsientoContableLogicAdditional.checkEstadoAsientoContableToSavesAfter(estadoasientocontables,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoAsientoContables();
			
			connexion.commit();		
			
			this.quitarEstadoAsientoContablesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoAsientoContables()throws Exception {				
		 try {	
			//EstadoAsientoContableLogicAdditional.checkEstadoAsientoContableToSaves(estadoasientocontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoAsientoContable=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoAsientoContable estadoasientocontableLocal:estadoasientocontables) {				
				if(estadoasientocontableLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoAsientoContableLogicAdditional.updateEstadoAsientoContableToSave(estadoasientocontableLocal,this.arrDatoGeneral);
	        	
				EstadoAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoasientocontableLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoAsientoContable(estadoasientocontableLocal)) {				
					EstadoAsientoContableDataAccess.save(estadoasientocontableLocal, connexion);				
				} else {
					validadoTodosEstadoAsientoContable=false;
				}
			}
			
			if(!validadoTodosEstadoAsientoContable) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoAsientoContableLogicAdditional.checkEstadoAsientoContableToSavesAfter(estadoasientocontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoAsientoContablesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoAsientoContableParameterReturnGeneral procesarAccionEstadoAsientoContables(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoAsientoContable> estadoasientocontables,EstadoAsientoContableParameterReturnGeneral estadoasientocontableParameterGeneral)throws Exception {
		 try {	
			EstadoAsientoContableParameterReturnGeneral estadoasientocontableReturnGeneral=new EstadoAsientoContableParameterReturnGeneral();
	
			
			return estadoasientocontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoAsientoContableParameterReturnGeneral procesarAccionEstadoAsientoContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoAsientoContable> estadoasientocontables,EstadoAsientoContableParameterReturnGeneral estadoasientocontableParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContable.class.getSimpleName()+"-procesarAccionEstadoAsientoContablesWithConnection");connexion.begin();			
			
			EstadoAsientoContableParameterReturnGeneral estadoasientocontableReturnGeneral=new EstadoAsientoContableParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return estadoasientocontableReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoAsientoContableParameterReturnGeneral procesarEventosEstadoAsientoContables(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoAsientoContable> estadoasientocontables,EstadoAsientoContable estadoasientocontable,EstadoAsientoContableParameterReturnGeneral estadoasientocontableParameterGeneral,Boolean isEsNuevoEstadoAsientoContable,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoAsientoContableParameterReturnGeneral estadoasientocontableReturnGeneral=new EstadoAsientoContableParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoasientocontableReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return estadoasientocontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoAsientoContableParameterReturnGeneral procesarEventosEstadoAsientoContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoAsientoContable> estadoasientocontables,EstadoAsientoContable estadoasientocontable,EstadoAsientoContableParameterReturnGeneral estadoasientocontableParameterGeneral,Boolean isEsNuevoEstadoAsientoContable,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContable.class.getSimpleName()+"-procesarEventosEstadoAsientoContablesWithConnection");connexion.begin();			
			
			EstadoAsientoContableParameterReturnGeneral estadoasientocontableReturnGeneral=new EstadoAsientoContableParameterReturnGeneral();
	
			estadoasientocontableReturnGeneral.setEstadoAsientoContable(estadoasientocontable);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoasientocontableReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return estadoasientocontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoAsientoContableParameterReturnGeneral procesarImportacionEstadoAsientoContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoAsientoContableParameterReturnGeneral estadoasientocontableParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContable.class.getSimpleName()+"-procesarImportacionEstadoAsientoContablesWithConnection");connexion.begin();			
			
			EstadoAsientoContableParameterReturnGeneral estadoasientocontableReturnGeneral=new EstadoAsientoContableParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadoasientocontables=new ArrayList<EstadoAsientoContable>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadoasientocontable=new EstadoAsientoContable();
				
				
				if(conColumnasBase) {this.estadoasientocontable.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadoasientocontable.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadoasientocontable.setcodigo(arrColumnas[iColumn++]);
				this.estadoasientocontable.setnombre(arrColumnas[iColumn++]);
				
				this.estadoasientocontables.add(this.estadoasientocontable);
			}
			
			this.saveEstadoAsientoContables();
			
			this.connexion.commit();
			
			estadoasientocontableReturnGeneral.setConRetornoEstaProcesado(true);
			estadoasientocontableReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadoasientocontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoAsientoContablesEliminados() throws Exception {				
		
		List<EstadoAsientoContable> estadoasientocontablesAux= new ArrayList<EstadoAsientoContable>();
		
		for(EstadoAsientoContable estadoasientocontable:estadoasientocontables) {
			if(!estadoasientocontable.getIsDeleted()) {
				estadoasientocontablesAux.add(estadoasientocontable);
			}
		}
		
		estadoasientocontables=estadoasientocontablesAux;
	}
	
	public void quitarEstadoAsientoContablesNulos() throws Exception {				
		
		List<EstadoAsientoContable> estadoasientocontablesAux= new ArrayList<EstadoAsientoContable>();
		
		for(EstadoAsientoContable estadoasientocontable : this.estadoasientocontables) {
			if(estadoasientocontable==null) {
				estadoasientocontablesAux.add(estadoasientocontable);
			}
		}
		
		//this.estadoasientocontables=estadoasientocontablesAux;
		
		this.estadoasientocontables.removeAll(estadoasientocontablesAux);
	}
	
	public void getSetVersionRowEstadoAsientoContableWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadoasientocontable.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadoasientocontable.getIsDeleted() || (estadoasientocontable.getIsChanged()&&!estadoasientocontable.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadoasientocontableDataAccess.getSetVersionRowEstadoAsientoContable(connexion,estadoasientocontable.getId());
				
				if(!estadoasientocontable.getVersionRow().equals(timestamp)) {	
					estadoasientocontable.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadoasientocontable.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoAsientoContable()throws Exception {	
		
		if(estadoasientocontable.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadoasientocontable.getIsDeleted() || (estadoasientocontable.getIsChanged()&&!estadoasientocontable.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadoasientocontableDataAccess.getSetVersionRowEstadoAsientoContable(connexion,estadoasientocontable.getId());
			
			try {							
				if(!estadoasientocontable.getVersionRow().equals(timestamp)) {	
					estadoasientocontable.setVersionRow(timestamp);
				}
				
				estadoasientocontable.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoAsientoContablesWithConnection()throws Exception {	
		if(estadoasientocontables!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoAsientoContable estadoasientocontableAux:estadoasientocontables) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadoasientocontableAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoasientocontableAux.getIsDeleted() || (estadoasientocontableAux.getIsChanged()&&!estadoasientocontableAux.getIsNew())) {
						
						timestamp=estadoasientocontableDataAccess.getSetVersionRowEstadoAsientoContable(connexion,estadoasientocontableAux.getId());
						
						if(!estadoasientocontable.getVersionRow().equals(timestamp)) {	
							estadoasientocontableAux.setVersionRow(timestamp);
						}
								
						estadoasientocontableAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoAsientoContables()throws Exception {	
		if(estadoasientocontables!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoAsientoContable estadoasientocontableAux:estadoasientocontables) {
					if(estadoasientocontableAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoasientocontableAux.getIsDeleted() || (estadoasientocontableAux.getIsChanged()&&!estadoasientocontableAux.getIsNew())) {
						
						timestamp=estadoasientocontableDataAccess.getSetVersionRowEstadoAsientoContable(connexion,estadoasientocontableAux.getId());
						
						if(!estadoasientocontableAux.getVersionRow().equals(timestamp)) {	
							estadoasientocontableAux.setVersionRow(timestamp);
						}
						
													
						estadoasientocontableAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EstadoAsientoContableParameterReturnGeneral cargarCombosLoteForeignKeyEstadoAsientoContableWithConnection(String finalQueryGlobalColorGeneral) throws Exception {
		EstadoAsientoContableParameterReturnGeneral  estadoasientocontableReturnGeneral =new EstadoAsientoContableParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContable.class.getSimpleName()+"-cargarCombosLoteForeignKeyEstadoAsientoContableWithConnection");connexion.begin();
			
			estadoasientocontableReturnGeneral =new EstadoAsientoContableParameterReturnGeneral();
			
			

			List<ColorGeneral> colorgeneralsForeignKey=new ArrayList<ColorGeneral>();
			ColorGeneralLogic colorgeneralLogic=new ColorGeneralLogic();
			colorgeneralLogic.setConnexion(this.connexion);
			colorgeneralLogic.getColorGeneralDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalColorGeneral.equals("NONE")) {
				colorgeneralLogic.getTodosColorGenerals(finalQueryGlobalColorGeneral,new Pagination());
				colorgeneralsForeignKey=colorgeneralLogic.getColorGenerals();
			}

			estadoasientocontableReturnGeneral.setcolorgeneralsForeignKey(colorgeneralsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return estadoasientocontableReturnGeneral;
	}
	
	public EstadoAsientoContableParameterReturnGeneral cargarCombosLoteForeignKeyEstadoAsientoContable(String finalQueryGlobalColorGeneral) throws Exception {
		EstadoAsientoContableParameterReturnGeneral  estadoasientocontableReturnGeneral =new EstadoAsientoContableParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			estadoasientocontableReturnGeneral =new EstadoAsientoContableParameterReturnGeneral();
			
			

			List<ColorGeneral> colorgeneralsForeignKey=new ArrayList<ColorGeneral>();
			ColorGeneralLogic colorgeneralLogic=new ColorGeneralLogic();
			colorgeneralLogic.setConnexion(this.connexion);
			colorgeneralLogic.getColorGeneralDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalColorGeneral.equals("NONE")) {
				colorgeneralLogic.getTodosColorGenerals(finalQueryGlobalColorGeneral,new Pagination());
				colorgeneralsForeignKey=colorgeneralLogic.getColorGenerals();
			}

			estadoasientocontableReturnGeneral.setcolorgeneralsForeignKey(colorgeneralsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return estadoasientocontableReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyEstadoAsientoContableWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ParametroContabilidadDefectoLogic parametrocontabilidaddefectoLogic=new ParametroContabilidadDefectoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContable.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoAsientoContableWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ParametroContabilidadDefecto.class));
											
			

			parametrocontabilidaddefectoLogic.setConnexion(this.getConnexion());
			parametrocontabilidaddefectoLogic.setDatosCliente(this.datosCliente);
			parametrocontabilidaddefectoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoAsientoContable estadoasientocontable:this.estadoasientocontables) {
				

				classes=new ArrayList<Classe>();
				classes=ParametroContabilidadDefectoConstantesFunciones.getClassesForeignKeysOfParametroContabilidadDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametrocontabilidaddefectoLogic.setParametroContabilidadDefectos(estadoasientocontable.parametrocontabilidaddefectos);
				parametrocontabilidaddefectoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoAsientoContable estadoasientocontable,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//EstadoAsientoContableLogicAdditional.updateEstadoAsientoContableToGet(estadoasientocontable,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadoasientocontable.setColorGeneral(estadoasientocontableDataAccess.getColorGeneral(connexion,estadoasientocontable));
		estadoasientocontable.setParametroContabilidadDefectos(estadoasientocontableDataAccess.getParametroContabilidadDefectos(connexion,estadoasientocontable));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ColorGeneral.class)) {
				estadoasientocontable.setColorGeneral(estadoasientocontableDataAccess.getColorGeneral(connexion,estadoasientocontable));
				continue;
			}

			if(clas.clas.equals(ParametroContabilidadDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoasientocontable.setParametroContabilidadDefectos(estadoasientocontableDataAccess.getParametroContabilidadDefectos(connexion,estadoasientocontable));

				if(this.isConDeep) {
					ParametroContabilidadDefectoLogic parametrocontabilidaddefectoLogic= new ParametroContabilidadDefectoLogic(this.connexion);
					parametrocontabilidaddefectoLogic.setParametroContabilidadDefectos(estadoasientocontable.getParametroContabilidadDefectos());
					ArrayList<Classe> classesLocal=ParametroContabilidadDefectoConstantesFunciones.getClassesForeignKeysOfParametroContabilidadDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametrocontabilidaddefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(parametrocontabilidaddefectoLogic.getParametroContabilidadDefectos());
					estadoasientocontable.setParametroContabilidadDefectos(parametrocontabilidaddefectoLogic.getParametroContabilidadDefectos());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ColorGeneral.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estadoasientocontable.setColorGeneral(estadoasientocontableDataAccess.getColorGeneral(connexion,estadoasientocontable));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroContabilidadDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroContabilidadDefecto.class));
			estadoasientocontable.setParametroContabilidadDefectos(estadoasientocontableDataAccess.getParametroContabilidadDefectos(connexion,estadoasientocontable));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadoasientocontable.setColorGeneral(estadoasientocontableDataAccess.getColorGeneral(connexion,estadoasientocontable));
		ColorGeneralLogic colorgeneralLogic= new ColorGeneralLogic(connexion);
		colorgeneralLogic.deepLoad(estadoasientocontable.getColorGeneral(),isDeep,deepLoadType,clases);
				

		estadoasientocontable.setParametroContabilidadDefectos(estadoasientocontableDataAccess.getParametroContabilidadDefectos(connexion,estadoasientocontable));

		for(ParametroContabilidadDefecto parametrocontabilidaddefecto:estadoasientocontable.getParametroContabilidadDefectos()) {
			ParametroContabilidadDefectoLogic parametrocontabilidaddefectoLogic= new ParametroContabilidadDefectoLogic(connexion);
			parametrocontabilidaddefectoLogic.deepLoad(parametrocontabilidaddefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ColorGeneral.class)) {
				estadoasientocontable.setColorGeneral(estadoasientocontableDataAccess.getColorGeneral(connexion,estadoasientocontable));
				ColorGeneralLogic colorgeneralLogic= new ColorGeneralLogic(connexion);
				colorgeneralLogic.deepLoad(estadoasientocontable.getColorGeneral(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ParametroContabilidadDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoasientocontable.setParametroContabilidadDefectos(estadoasientocontableDataAccess.getParametroContabilidadDefectos(connexion,estadoasientocontable));

				for(ParametroContabilidadDefecto parametrocontabilidaddefecto:estadoasientocontable.getParametroContabilidadDefectos()) {
					ParametroContabilidadDefectoLogic parametrocontabilidaddefectoLogic= new ParametroContabilidadDefectoLogic(connexion);
					parametrocontabilidaddefectoLogic.deepLoad(parametrocontabilidaddefecto,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ColorGeneral.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			estadoasientocontable.setColorGeneral(estadoasientocontableDataAccess.getColorGeneral(connexion,estadoasientocontable));
			ColorGeneralLogic colorgeneralLogic= new ColorGeneralLogic(connexion);
			colorgeneralLogic.deepLoad(estadoasientocontable.getColorGeneral(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroContabilidadDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroContabilidadDefecto.class));
			estadoasientocontable.setParametroContabilidadDefectos(estadoasientocontableDataAccess.getParametroContabilidadDefectos(connexion,estadoasientocontable));

			for(ParametroContabilidadDefecto parametrocontabilidaddefecto:estadoasientocontable.getParametroContabilidadDefectos()) {
				ParametroContabilidadDefectoLogic parametrocontabilidaddefectoLogic= new ParametroContabilidadDefectoLogic(connexion);
				parametrocontabilidaddefectoLogic.deepLoad(parametrocontabilidaddefecto,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoAsientoContable estadoasientocontable,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoAsientoContable.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadoasientocontable,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContable(estadoasientocontable);
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
			this.deepLoad(this.estadoasientocontable,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContable(this.estadoasientocontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoAsientoContable.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadoasientocontables!=null) {
				for(EstadoAsientoContable estadoasientocontable:estadoasientocontables) {
					this.deepLoad(estadoasientocontable,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContable(estadoasientocontables);
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
			if(estadoasientocontables!=null) {
				for(EstadoAsientoContable estadoasientocontable:estadoasientocontables) {
					this.deepLoad(estadoasientocontable,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContable(estadoasientocontables);
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
	
	
	public void getEstadoAsientoContablesFK_IdColorGeneralWithConnection(String sFinalQuery,Pagination pagination,Long id_color_general)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidColorGeneral= new ParameterSelectionGeneral();
			parameterSelectionGeneralidColorGeneral.setParameterSelectionGeneralEqual(ParameterType.LONG,id_color_general,EstadoAsientoContableConstantesFunciones.IDCOLORGENERAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidColorGeneral);

			EstadoAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdColorGeneral","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estadoasientocontables=estadoasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstadoAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContable(this.estadoasientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoAsientoContablesFK_IdColorGeneral(String sFinalQuery,Pagination pagination,Long id_color_general)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidColorGeneral= new ParameterSelectionGeneral();
			parameterSelectionGeneralidColorGeneral.setParameterSelectionGeneralEqual(ParameterType.LONG,id_color_general,EstadoAsientoContableConstantesFunciones.IDCOLORGENERAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidColorGeneral);

			EstadoAsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdColorGeneral","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			estadoasientocontables=estadoasientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EstadoAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContable(this.estadoasientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEstadoAsientoContablePorCodigoWithConnection(String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoAsientoContableConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadoasientocontable=estadoasientocontableDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadoasientocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContable(this.estadoasientocontable);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoAsientoContablePorCodigo(String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoAsientoContableConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadoasientocontable=estadoasientocontableDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadoasientocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContable(this.estadoasientocontable);
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
			if(EstadoAsientoContableConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoAsientoContableDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoAsientoContable estadoasientocontable,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoAsientoContableConstantesFunciones.ISCONAUDITORIA) {
				if(estadoasientocontable.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoAsientoContableDataAccess.TABLENAME, estadoasientocontable.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoAsientoContableConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoAsientoContableLogic.registrarAuditoriaDetallesEstadoAsientoContable(connexion,estadoasientocontable,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadoasientocontable.getIsDeleted()) {
					/*if(!estadoasientocontable.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoAsientoContableDataAccess.TABLENAME, estadoasientocontable.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoAsientoContableLogic.registrarAuditoriaDetallesEstadoAsientoContable(connexion,estadoasientocontable,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoAsientoContableDataAccess.TABLENAME, estadoasientocontable.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadoasientocontable.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoAsientoContableDataAccess.TABLENAME, estadoasientocontable.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoAsientoContableConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoAsientoContableLogic.registrarAuditoriaDetallesEstadoAsientoContable(connexion,estadoasientocontable,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoAsientoContable(Connexion connexion,EstadoAsientoContable estadoasientocontable)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadoasientocontable.getIsNew()||!estadoasientocontable.getcodigo().equals(estadoasientocontable.getEstadoAsientoContableOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoasientocontable.getEstadoAsientoContableOriginal().getcodigo()!=null)
				{
					strValorActual=estadoasientocontable.getEstadoAsientoContableOriginal().getcodigo();
				}
				if(estadoasientocontable.getcodigo()!=null)
				{
					strValorNuevo=estadoasientocontable.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoAsientoContableConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadoasientocontable.getIsNew()||!estadoasientocontable.getnombre().equals(estadoasientocontable.getEstadoAsientoContableOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoasientocontable.getEstadoAsientoContableOriginal().getnombre()!=null)
				{
					strValorActual=estadoasientocontable.getEstadoAsientoContableOriginal().getnombre();
				}
				if(estadoasientocontable.getnombre()!=null)
				{
					strValorNuevo=estadoasientocontable.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoAsientoContableConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(estadoasientocontable.getIsNew()||!estadoasientocontable.getid_color_general().equals(estadoasientocontable.getEstadoAsientoContableOriginal().getid_color_general()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoasientocontable.getEstadoAsientoContableOriginal().getid_color_general()!=null)
				{
					strValorActual=estadoasientocontable.getEstadoAsientoContableOriginal().getid_color_general().toString();
				}
				if(estadoasientocontable.getid_color_general()!=null)
				{
					strValorNuevo=estadoasientocontable.getid_color_general().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoAsientoContableConstantesFunciones.IDCOLORGENERAL,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoAsientoContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoAsientoContableConstantesFunciones.getClassesForeignKeysOfEstadoAsientoContable(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoAsientoContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoAsientoContableConstantesFunciones.getClassesRelationshipsOfEstadoAsientoContable(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

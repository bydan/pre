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
import com.bydan.erp.contabilidad.util.AsientoContableConstantesFunciones;
import com.bydan.erp.contabilidad.util.AsientoContableParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.AsientoContableParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.AsientoContable;
import com.bydan.erp.contabilidad.business.logic.AsientoContableLogicAdditional;
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
public class AsientoContableLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(AsientoContableLogic.class);
	
	protected AsientoContableDataAccess asientocontableDataAccess; 	
	protected AsientoContable asientocontable;
	protected List<AsientoContable> asientocontables;
	protected Object asientocontableObject;	
	protected List<Object> asientocontablesObject;
	
	public static ClassValidator<AsientoContable> asientocontableValidator = new ClassValidator<AsientoContable>(AsientoContable.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected AsientoContableLogicAdditional asientocontableLogicAdditional=null;
	
	public AsientoContableLogicAdditional getAsientoContableLogicAdditional() {
		return this.asientocontableLogicAdditional;
	}
	
	public void setAsientoContableLogicAdditional(AsientoContableLogicAdditional asientocontableLogicAdditional) {
		try {
			this.asientocontableLogicAdditional=asientocontableLogicAdditional;
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
	
	
	
	
	public  AsientoContableLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.asientocontableDataAccess = new AsientoContableDataAccess();
			
			this.asientocontables= new ArrayList<AsientoContable>();
			this.asientocontable= new AsientoContable();
			
			this.asientocontableObject=new Object();
			this.asientocontablesObject=new ArrayList<Object>();
				
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
			
			this.asientocontableDataAccess.setConnexionType(this.connexionType);
			this.asientocontableDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  AsientoContableLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.asientocontableDataAccess = new AsientoContableDataAccess();
			this.asientocontables= new ArrayList<AsientoContable>();
			this.asientocontable= new AsientoContable();
			this.asientocontableObject=new Object();
			this.asientocontablesObject=new ArrayList<Object>();
			
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
			
			this.asientocontableDataAccess.setConnexionType(this.connexionType);
			this.asientocontableDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public AsientoContable getAsientoContable() throws Exception {	
		AsientoContableLogicAdditional.checkAsientoContableToGet(asientocontable,this.datosCliente,this.arrDatoGeneral);
		AsientoContableLogicAdditional.updateAsientoContableToGet(asientocontable,this.arrDatoGeneral);
		
		return asientocontable;
	}
		
	public void setAsientoContable(AsientoContable newAsientoContable) {
		this.asientocontable = newAsientoContable;
	}
	
	public AsientoContableDataAccess getAsientoContableDataAccess() {
		return asientocontableDataAccess;
	}
	
	public void setAsientoContableDataAccess(AsientoContableDataAccess newasientocontableDataAccess) {
		this.asientocontableDataAccess = newasientocontableDataAccess;
	}
	
	public List<AsientoContable> getAsientoContables() throws Exception {		
		this.quitarAsientoContablesNulos();
		
		AsientoContableLogicAdditional.checkAsientoContableToGets(asientocontables,this.datosCliente,this.arrDatoGeneral);
		
		for (AsientoContable asientocontableLocal: asientocontables ) {
			AsientoContableLogicAdditional.updateAsientoContableToGet(asientocontableLocal,this.arrDatoGeneral);
		}
		
		return asientocontables;
	}
	
	public void setAsientoContables(List<AsientoContable> newAsientoContables) {
		this.asientocontables = newAsientoContables;
	}
	
	public Object getAsientoContableObject() {	
		this.asientocontableObject=this.asientocontableDataAccess.getEntityObject();
		return this.asientocontableObject;
	}
		
	public void setAsientoContableObject(Object newAsientoContableObject) {
		this.asientocontableObject = newAsientoContableObject;
	}
	
	public List<Object> getAsientoContablesObject() {		
		this.asientocontablesObject=this.asientocontableDataAccess.getEntitiesObject();
		return this.asientocontablesObject;
	}
		
	public void setAsientoContablesObject(List<Object> newAsientoContablesObject) {
		this.asientocontablesObject = newAsientoContablesObject;
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
		
		if(this.asientocontableDataAccess!=null) {
			this.asientocontableDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			asientocontableDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			asientocontableDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		asientocontable = new  AsientoContable();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			asientocontable=asientocontableDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.asientocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontable);
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
		asientocontable = new  AsientoContable();
		  		  
        try {
			
			asientocontable=asientocontableDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.asientocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		asientocontable = new  AsientoContable();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			asientocontable=asientocontableDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.asientocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontable);
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
		asientocontable = new  AsientoContable();
		  		  
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
		asientocontable = new  AsientoContable();
		  		  
        try {
			
			asientocontable=asientocontableDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.asientocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		asientocontable = new  AsientoContable();
		  		  
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
		asientocontable = new  AsientoContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =asientocontableDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		asientocontable = new  AsientoContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=asientocontableDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		asientocontable = new  AsientoContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =asientocontableDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		asientocontable = new  AsientoContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=asientocontableDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		asientocontable = new  AsientoContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =asientocontableDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		asientocontable = new  AsientoContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=asientocontableDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		asientocontables = new  ArrayList<AsientoContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontables=asientocontableDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsientoContable(asientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
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
		asientocontables = new  ArrayList<AsientoContable>();
		  		  
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
		asientocontables = new  ArrayList<AsientoContable>();
		  		  
        try {			
			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontables=asientocontableDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarAsientoContable(asientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		asientocontables = new  ArrayList<AsientoContable>();
		  		  
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
		asientocontables = new  ArrayList<AsientoContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontables=asientocontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsientoContable(asientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
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
		asientocontables = new  ArrayList<AsientoContable>();
		  		  
        try {
			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontables=asientocontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsientoContable(asientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
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
		asientocontables = new  ArrayList<AsientoContable>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontables=asientocontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAsientoContable(asientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
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
		asientocontables = new  ArrayList<AsientoContable>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontables=asientocontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAsientoContable(asientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		asientocontable = new  AsientoContable();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontable=asientocontableDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAsientoContable(asientocontable);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontable);
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
		asientocontable = new  AsientoContable();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontable=asientocontableDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAsientoContable(asientocontable);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		asientocontables = new  ArrayList<AsientoContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontables=asientocontableDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsientoContable(asientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
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
		asientocontables = new  ArrayList<AsientoContable>();
		  		  
        try {
			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontables=asientocontableDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAsientoContable(asientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosAsientoContablesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		asientocontables = new  ArrayList<AsientoContable>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getTodosAsientoContablesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAsientoContable(asientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
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
	
	public  void  getTodosAsientoContables(String sFinalQuery,Pagination pagination)throws Exception {
		asientocontables = new  ArrayList<AsientoContable>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAsientoContable(asientocontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarAsientoContable(AsientoContable asientocontable) throws Exception {
		Boolean estaValidado=false;
		
		if(asientocontable.getIsNew() || asientocontable.getIsChanged()) { 
			this.invalidValues = asientocontableValidator.getInvalidValues(asientocontable);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(asientocontable);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarAsientoContable(List<AsientoContable> AsientoContables) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(AsientoContable asientocontableLocal:asientocontables) {				
			estaValidadoObjeto=this.validarGuardarAsientoContable(asientocontableLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarAsientoContable(List<AsientoContable> AsientoContables) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAsientoContable(asientocontables)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarAsientoContable(AsientoContable AsientoContable) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAsientoContable(asientocontable)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(AsientoContable asientocontable) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+asientocontable.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=AsientoContableConstantesFunciones.getAsientoContableLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"asientocontable","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(AsientoContableConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(AsientoContableConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveAsientoContableWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-saveAsientoContableWithConnection");connexion.begin();			
			
			AsientoContableLogicAdditional.checkAsientoContableToSave(this.asientocontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AsientoContableLogicAdditional.updateAsientoContableToSave(this.asientocontable,this.arrDatoGeneral);
			
			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.asientocontable,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowAsientoContable();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAsientoContable(this.asientocontable)) {
				AsientoContableDataAccess.save(this.asientocontable, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.asientocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AsientoContableLogicAdditional.checkAsientoContableToSaveAfter(this.asientocontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAsientoContable();
			
			connexion.commit();			
			
			if(this.asientocontable.getIsDeleted()) {
				this.asientocontable=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveAsientoContable()throws Exception {	
		try {	
			
			AsientoContableLogicAdditional.checkAsientoContableToSave(this.asientocontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AsientoContableLogicAdditional.updateAsientoContableToSave(this.asientocontable,this.arrDatoGeneral);
			
			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.asientocontable,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAsientoContable(this.asientocontable)) {			
				AsientoContableDataAccess.save(this.asientocontable, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.asientocontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AsientoContableLogicAdditional.checkAsientoContableToSaveAfter(this.asientocontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.asientocontable.getIsDeleted()) {
				this.asientocontable=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveAsientoContablesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-saveAsientoContablesWithConnection");connexion.begin();			
			
			AsientoContableLogicAdditional.checkAsientoContableToSaves(asientocontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowAsientoContables();
			
			Boolean validadoTodosAsientoContable=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AsientoContable asientocontableLocal:asientocontables) {		
				if(asientocontableLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AsientoContableLogicAdditional.updateAsientoContableToSave(asientocontableLocal,this.arrDatoGeneral);
	        	
				AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),asientocontableLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAsientoContable(asientocontableLocal)) {
					AsientoContableDataAccess.save(asientocontableLocal, connexion);				
				} else {
					validadoTodosAsientoContable=false;
				}
			}
			
			if(!validadoTodosAsientoContable) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AsientoContableLogicAdditional.checkAsientoContableToSavesAfter(asientocontables,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAsientoContables();
			
			connexion.commit();		
			
			this.quitarAsientoContablesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveAsientoContables()throws Exception {				
		 try {	
			AsientoContableLogicAdditional.checkAsientoContableToSaves(asientocontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosAsientoContable=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AsientoContable asientocontableLocal:asientocontables) {				
				if(asientocontableLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AsientoContableLogicAdditional.updateAsientoContableToSave(asientocontableLocal,this.arrDatoGeneral);
	        	
				AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),asientocontableLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAsientoContable(asientocontableLocal)) {				
					AsientoContableDataAccess.save(asientocontableLocal, connexion);				
				} else {
					validadoTodosAsientoContable=false;
				}
			}
			
			if(!validadoTodosAsientoContable) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AsientoContableLogicAdditional.checkAsientoContableToSavesAfter(asientocontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarAsientoContablesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AsientoContableParameterReturnGeneral procesarAccionAsientoContables(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AsientoContable> asientocontables,AsientoContableParameterReturnGeneral asientocontableParameterGeneral)throws Exception {
		 try {	
			AsientoContableParameterReturnGeneral asientocontableReturnGeneral=new AsientoContableParameterReturnGeneral();
	
			AsientoContableLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,asientocontables,asientocontableParameterGeneral,asientocontableReturnGeneral);
			
			return asientocontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AsientoContableParameterReturnGeneral procesarAccionAsientoContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AsientoContable> asientocontables,AsientoContableParameterReturnGeneral asientocontableParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-procesarAccionAsientoContablesWithConnection");connexion.begin();			
			
			AsientoContableParameterReturnGeneral asientocontableReturnGeneral=new AsientoContableParameterReturnGeneral();
	
			AsientoContableLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,asientocontables,asientocontableParameterGeneral,asientocontableReturnGeneral);
			
			this.connexion.commit();
			
			return asientocontableReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AsientoContableParameterReturnGeneral procesarEventosAsientoContables(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AsientoContable> asientocontables,AsientoContable asientocontable,AsientoContableParameterReturnGeneral asientocontableParameterGeneral,Boolean isEsNuevoAsientoContable,ArrayList<Classe> clases)throws Exception {
		 try {	
			AsientoContableParameterReturnGeneral asientocontableReturnGeneral=new AsientoContableParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				asientocontableReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AsientoContableLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,asientocontables,asientocontable,asientocontableParameterGeneral,asientocontableReturnGeneral,isEsNuevoAsientoContable,clases);
			
			return asientocontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public AsientoContableParameterReturnGeneral procesarEventosAsientoContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AsientoContable> asientocontables,AsientoContable asientocontable,AsientoContableParameterReturnGeneral asientocontableParameterGeneral,Boolean isEsNuevoAsientoContable,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-procesarEventosAsientoContablesWithConnection");connexion.begin();			
			
			AsientoContableParameterReturnGeneral asientocontableReturnGeneral=new AsientoContableParameterReturnGeneral();
	
			asientocontableReturnGeneral.setAsientoContable(asientocontable);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				asientocontableReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AsientoContableLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,asientocontables,asientocontable,asientocontableParameterGeneral,asientocontableReturnGeneral,isEsNuevoAsientoContable,clases);
			
			this.connexion.commit();
			
			return asientocontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AsientoContableParameterReturnGeneral procesarImportacionAsientoContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,AsientoContableParameterReturnGeneral asientocontableParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-procesarImportacionAsientoContablesWithConnection");connexion.begin();			
			
			AsientoContableParameterReturnGeneral asientocontableReturnGeneral=new AsientoContableParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.asientocontables=new ArrayList<AsientoContable>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.asientocontable=new AsientoContable();
				
				
				if(conColumnasBase) {this.asientocontable.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.asientocontable.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.asientocontable.setcodigo(arrColumnas[iColumn++]);
				this.asientocontable.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.asientocontable.setnumero_mayor(arrColumnas[iColumn++]);
				this.asientocontable.setes_retencion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.asientocontable.setnumero_retencion(arrColumnas[iColumn++]);
				this.asientocontable.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.asientocontable.setes_retencion_iva(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.asientocontable.setnumero_retencion_iva(arrColumnas[iColumn++]);
				this.asientocontable.setcotizacion(Double.parseDouble(arrColumnas[iColumn++]));
			this.asientocontable.setbeneficiario(arrColumnas[iColumn++]);
			this.asientocontable.setdescripcion(arrColumnas[iColumn++]);
				this.asientocontable.setfecha_finalizacion(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				
				this.asientocontables.add(this.asientocontable);
			}
			
			this.saveAsientoContables();
			
			this.connexion.commit();
			
			asientocontableReturnGeneral.setConRetornoEstaProcesado(true);
			asientocontableReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return asientocontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarAsientoContablesEliminados() throws Exception {				
		
		List<AsientoContable> asientocontablesAux= new ArrayList<AsientoContable>();
		
		for(AsientoContable asientocontable:asientocontables) {
			if(!asientocontable.getIsDeleted()) {
				asientocontablesAux.add(asientocontable);
			}
		}
		
		asientocontables=asientocontablesAux;
	}
	
	public void quitarAsientoContablesNulos() throws Exception {				
		
		List<AsientoContable> asientocontablesAux= new ArrayList<AsientoContable>();
		
		for(AsientoContable asientocontable : this.asientocontables) {
			if(asientocontable==null) {
				asientocontablesAux.add(asientocontable);
			}
		}
		
		//this.asientocontables=asientocontablesAux;
		
		this.asientocontables.removeAll(asientocontablesAux);
	}
	
	public void getSetVersionRowAsientoContableWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(asientocontable.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((asientocontable.getIsDeleted() || (asientocontable.getIsChanged()&&!asientocontable.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=asientocontableDataAccess.getSetVersionRowAsientoContable(connexion,asientocontable.getId());
				
				if(!asientocontable.getVersionRow().equals(timestamp)) {	
					asientocontable.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				asientocontable.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowAsientoContable()throws Exception {	
		
		if(asientocontable.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((asientocontable.getIsDeleted() || (asientocontable.getIsChanged()&&!asientocontable.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=asientocontableDataAccess.getSetVersionRowAsientoContable(connexion,asientocontable.getId());
			
			try {							
				if(!asientocontable.getVersionRow().equals(timestamp)) {	
					asientocontable.setVersionRow(timestamp);
				}
				
				asientocontable.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowAsientoContablesWithConnection()throws Exception {	
		if(asientocontables!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(AsientoContable asientocontableAux:asientocontables) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(asientocontableAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(asientocontableAux.getIsDeleted() || (asientocontableAux.getIsChanged()&&!asientocontableAux.getIsNew())) {
						
						timestamp=asientocontableDataAccess.getSetVersionRowAsientoContable(connexion,asientocontableAux.getId());
						
						if(!asientocontable.getVersionRow().equals(timestamp)) {	
							asientocontableAux.setVersionRow(timestamp);
						}
								
						asientocontableAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowAsientoContables()throws Exception {	
		if(asientocontables!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(AsientoContable asientocontableAux:asientocontables) {
					if(asientocontableAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(asientocontableAux.getIsDeleted() || (asientocontableAux.getIsChanged()&&!asientocontableAux.getIsNew())) {
						
						timestamp=asientocontableDataAccess.getSetVersionRowAsientoContable(connexion,asientocontableAux.getId());
						
						if(!asientocontableAux.getVersionRow().equals(timestamp)) {	
							asientocontableAux.setVersionRow(timestamp);
						}
						
													
						asientocontableAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public AsientoContableParameterReturnGeneral cargarCombosLoteForeignKeyAsientoContableWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalModulo,String finalQueryGlobalUsuario,String finalQueryGlobalTipoDocumento,String finalQueryGlobalTipoMovimiento,String finalQueryGlobalMoneda,String finalQueryGlobalCliente,String finalQueryGlobalTipoDescripcionAsiento,String finalQueryGlobalFormato,String finalQueryGlobalEstadoAsientoContable,String finalQueryGlobalTipoMovimientoModulo) throws Exception {
		AsientoContableParameterReturnGeneral  asientocontableReturnGeneral =new AsientoContableParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-cargarCombosLoteForeignKeyAsientoContableWithConnection");connexion.begin();
			
			asientocontableReturnGeneral =new AsientoContableParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			asientocontableReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			asientocontableReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			asientocontableReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			asientocontableReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			asientocontableReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			asientocontableReturnGeneral.setmessForeignKey(messForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			asientocontableReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			asientocontableReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<TipoDocumento> tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentoLogic=new TipoDocumentoLogic();
			tipodocumentoLogic.setConnexion(this.connexion);
			tipodocumentoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumento.equals("NONE")) {
				tipodocumentoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumento,new Pagination());
				tipodocumentosForeignKey=tipodocumentoLogic.getTipoDocumentos();
			}

			asientocontableReturnGeneral.settipodocumentosForeignKey(tipodocumentosForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			asientocontableReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			asientocontableReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			asientocontableReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoDescripcionAsiento> tipodescripcionasientosForeignKey=new ArrayList<TipoDescripcionAsiento>();
			TipoDescripcionAsientoLogic tipodescripcionasientoLogic=new TipoDescripcionAsientoLogic();
			tipodescripcionasientoLogic.setConnexion(this.connexion);
			tipodescripcionasientoLogic.getTipoDescripcionAsientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDescripcionAsiento.equals("NONE")) {
				tipodescripcionasientoLogic.getTodosTipoDescripcionAsientos(finalQueryGlobalTipoDescripcionAsiento,new Pagination());
				tipodescripcionasientosForeignKey=tipodescripcionasientoLogic.getTipoDescripcionAsientos();
			}

			asientocontableReturnGeneral.settipodescripcionasientosForeignKey(tipodescripcionasientosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			asientocontableReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<EstadoAsientoContable> estadoasientocontablesForeignKey=new ArrayList<EstadoAsientoContable>();
			EstadoAsientoContableLogic estadoasientocontableLogic=new EstadoAsientoContableLogic();
			estadoasientocontableLogic.setConnexion(this.connexion);
			estadoasientocontableLogic.getEstadoAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoAsientoContable.equals("NONE")) {
				estadoasientocontableLogic.getTodosEstadoAsientoContables(finalQueryGlobalEstadoAsientoContable,new Pagination());
				estadoasientocontablesForeignKey=estadoasientocontableLogic.getEstadoAsientoContables();
			}

			asientocontableReturnGeneral.setestadoasientocontablesForeignKey(estadoasientocontablesForeignKey);


			List<TipoMovimientoModulo> tipomovimientomodulosForeignKey=new ArrayList<TipoMovimientoModulo>();
			TipoMovimientoModuloLogic tipomovimientomoduloLogic=new TipoMovimientoModuloLogic();
			tipomovimientomoduloLogic.setConnexion(this.connexion);
			tipomovimientomoduloLogic.getTipoMovimientoModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimientoModulo.equals("NONE")) {
				tipomovimientomoduloLogic.getTodosTipoMovimientoModulos(finalQueryGlobalTipoMovimientoModulo,new Pagination());
				tipomovimientomodulosForeignKey=tipomovimientomoduloLogic.getTipoMovimientoModulos();
			}

			asientocontableReturnGeneral.settipomovimientomodulosForeignKey(tipomovimientomodulosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return asientocontableReturnGeneral;
	}
	
	public AsientoContableParameterReturnGeneral cargarCombosLoteForeignKeyAsientoContable(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalModulo,String finalQueryGlobalUsuario,String finalQueryGlobalTipoDocumento,String finalQueryGlobalTipoMovimiento,String finalQueryGlobalMoneda,String finalQueryGlobalCliente,String finalQueryGlobalTipoDescripcionAsiento,String finalQueryGlobalFormato,String finalQueryGlobalEstadoAsientoContable,String finalQueryGlobalTipoMovimientoModulo) throws Exception {
		AsientoContableParameterReturnGeneral  asientocontableReturnGeneral =new AsientoContableParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			asientocontableReturnGeneral =new AsientoContableParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			asientocontableReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			asientocontableReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			asientocontableReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			asientocontableReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			asientocontableReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			asientocontableReturnGeneral.setmessForeignKey(messForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			asientocontableReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			asientocontableReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<TipoDocumento> tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentoLogic=new TipoDocumentoLogic();
			tipodocumentoLogic.setConnexion(this.connexion);
			tipodocumentoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumento.equals("NONE")) {
				tipodocumentoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumento,new Pagination());
				tipodocumentosForeignKey=tipodocumentoLogic.getTipoDocumentos();
			}

			asientocontableReturnGeneral.settipodocumentosForeignKey(tipodocumentosForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			asientocontableReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			asientocontableReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			asientocontableReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoDescripcionAsiento> tipodescripcionasientosForeignKey=new ArrayList<TipoDescripcionAsiento>();
			TipoDescripcionAsientoLogic tipodescripcionasientoLogic=new TipoDescripcionAsientoLogic();
			tipodescripcionasientoLogic.setConnexion(this.connexion);
			tipodescripcionasientoLogic.getTipoDescripcionAsientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDescripcionAsiento.equals("NONE")) {
				tipodescripcionasientoLogic.getTodosTipoDescripcionAsientos(finalQueryGlobalTipoDescripcionAsiento,new Pagination());
				tipodescripcionasientosForeignKey=tipodescripcionasientoLogic.getTipoDescripcionAsientos();
			}

			asientocontableReturnGeneral.settipodescripcionasientosForeignKey(tipodescripcionasientosForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			asientocontableReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<EstadoAsientoContable> estadoasientocontablesForeignKey=new ArrayList<EstadoAsientoContable>();
			EstadoAsientoContableLogic estadoasientocontableLogic=new EstadoAsientoContableLogic();
			estadoasientocontableLogic.setConnexion(this.connexion);
			estadoasientocontableLogic.getEstadoAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoAsientoContable.equals("NONE")) {
				estadoasientocontableLogic.getTodosEstadoAsientoContables(finalQueryGlobalEstadoAsientoContable,new Pagination());
				estadoasientocontablesForeignKey=estadoasientocontableLogic.getEstadoAsientoContables();
			}

			asientocontableReturnGeneral.setestadoasientocontablesForeignKey(estadoasientocontablesForeignKey);


			List<TipoMovimientoModulo> tipomovimientomodulosForeignKey=new ArrayList<TipoMovimientoModulo>();
			TipoMovimientoModuloLogic tipomovimientomoduloLogic=new TipoMovimientoModuloLogic();
			tipomovimientomoduloLogic.setConnexion(this.connexion);
			tipomovimientomoduloLogic.getTipoMovimientoModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimientoModulo.equals("NONE")) {
				tipomovimientomoduloLogic.getTodosTipoMovimientoModulos(finalQueryGlobalTipoMovimientoModulo,new Pagination());
				tipomovimientomodulosForeignKey=tipomovimientomoduloLogic.getTipoMovimientoModulos();
			}

			asientocontableReturnGeneral.settipomovimientomodulosForeignKey(tipomovimientomodulosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return asientocontableReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyAsientoContableWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			SriLogic sriLogic=new SriLogic();
			ImportarExportarLogic importarexportarLogic=new ImportarExportarLogic();
			DetalleMoviClienProveLogic detallemoviclienproveLogic=new DetalleMoviClienProveLogic();
			PrestamoLogic prestamoLogic=new PrestamoLogic();
			DetalleAsientoContableLogic detalleasientocontableLogic=new DetalleAsientoContableLogic();
			RetencionLogic retencionLogic=new RetencionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyAsientoContableWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Sri.class));
			classes.add(new Classe(ImportarExportar.class));
			classes.add(new Classe(DetalleMoviClienProve.class));
			classes.add(new Classe(Prestamo.class));
			classes.add(new Classe(DetalleAsientoContable.class));
			classes.add(new Classe(Retencion.class));
											
			

			sriLogic.setConnexion(this.getConnexion());
			sriLogic.setDatosCliente(this.datosCliente);
			sriLogic.setIsConRefrescarForeignKeys(true);

			importarexportarLogic.setConnexion(this.getConnexion());
			importarexportarLogic.setDatosCliente(this.datosCliente);
			importarexportarLogic.setIsConRefrescarForeignKeys(true);

			detallemoviclienproveLogic.setConnexion(this.getConnexion());
			detallemoviclienproveLogic.setDatosCliente(this.datosCliente);
			detallemoviclienproveLogic.setIsConRefrescarForeignKeys(true);

			prestamoLogic.setConnexion(this.getConnexion());
			prestamoLogic.setDatosCliente(this.datosCliente);
			prestamoLogic.setIsConRefrescarForeignKeys(true);

			detalleasientocontableLogic.setConnexion(this.getConnexion());
			detalleasientocontableLogic.setDatosCliente(this.datosCliente);
			detalleasientocontableLogic.setIsConRefrescarForeignKeys(true);

			retencionLogic.setConnexion(this.getConnexion());
			retencionLogic.setDatosCliente(this.datosCliente);
			retencionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(AsientoContable asientocontable:this.asientocontables) {
				

				classes=new ArrayList<Classe>();
				classes=SriConstantesFunciones.getClassesForeignKeysOfSri(new ArrayList<Classe>(),DeepLoadType.NONE);

				sriLogic.setSris(asientocontable.sris);
				sriLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ImportarExportarConstantesFunciones.getClassesForeignKeysOfImportarExportar(new ArrayList<Classe>(),DeepLoadType.NONE);

				importarexportarLogic.setImportarExportars(asientocontable.importarexportars);
				importarexportarLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetalleMoviClienProveConstantesFunciones.getClassesForeignKeysOfDetalleMoviClienProve(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallemoviclienproveLogic.setDetalleMoviClienProves(asientocontable.detallemoviclienproves);
				detallemoviclienproveLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PrestamoConstantesFunciones.getClassesForeignKeysOfPrestamo(new ArrayList<Classe>(),DeepLoadType.NONE);

				prestamoLogic.setPrestamos(asientocontable.prestamos);
				prestamoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetalleAsientoContableConstantesFunciones.getClassesForeignKeysOfDetalleAsientoContable(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleasientocontableLogic.setDetalleAsientoContables(asientocontable.detalleasientocontables);
				detalleasientocontableLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=RetencionConstantesFunciones.getClassesForeignKeysOfRetencion(new ArrayList<Classe>(),DeepLoadType.NONE);

				retencionLogic.setRetencions(asientocontable.retencions);
				retencionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(AsientoContable asientocontable,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			AsientoContableLogicAdditional.updateAsientoContableToGet(asientocontable,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		asientocontable.setEmpresa(asientocontableDataAccess.getEmpresa(connexion,asientocontable));
		asientocontable.setSucursal(asientocontableDataAccess.getSucursal(connexion,asientocontable));
		asientocontable.setEjercicio(asientocontableDataAccess.getEjercicio(connexion,asientocontable));
		asientocontable.setPeriodo(asientocontableDataAccess.getPeriodo(connexion,asientocontable));
		asientocontable.setAnio(asientocontableDataAccess.getAnio(connexion,asientocontable));
		asientocontable.setMes(asientocontableDataAccess.getMes(connexion,asientocontable));
		asientocontable.setModulo(asientocontableDataAccess.getModulo(connexion,asientocontable));
		asientocontable.setUsuario(asientocontableDataAccess.getUsuario(connexion,asientocontable));
		asientocontable.setTipoDocumento(asientocontableDataAccess.getTipoDocumento(connexion,asientocontable));
		asientocontable.setTipoMovimiento(asientocontableDataAccess.getTipoMovimiento(connexion,asientocontable));
		asientocontable.setMoneda(asientocontableDataAccess.getMoneda(connexion,asientocontable));
		asientocontable.setCliente(asientocontableDataAccess.getCliente(connexion,asientocontable));
		asientocontable.setTipoDescripcionAsiento(asientocontableDataAccess.getTipoDescripcionAsiento(connexion,asientocontable));
		asientocontable.setFormato(asientocontableDataAccess.getFormato(connexion,asientocontable));
		asientocontable.setEstadoAsientoContable(asientocontableDataAccess.getEstadoAsientoContable(connexion,asientocontable));
		asientocontable.setTipoMovimientoModulo(asientocontableDataAccess.getTipoMovimientoModulo(connexion,asientocontable));
		asientocontable.setSris(asientocontableDataAccess.getSris(connexion,asientocontable));
		asientocontable.setImportarExportars(asientocontableDataAccess.getImportarExportars(connexion,asientocontable));
		asientocontable.setDetalleMoviClienProves(asientocontableDataAccess.getDetalleMoviClienProves(connexion,asientocontable));
		asientocontable.setPrestamos(asientocontableDataAccess.getPrestamos(connexion,asientocontable));
		asientocontable.setDetalleAsientoContables(asientocontableDataAccess.getDetalleAsientoContables(connexion,asientocontable));
		asientocontable.setRetencions(asientocontableDataAccess.getRetencions(connexion,asientocontable));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				asientocontable.setEmpresa(asientocontableDataAccess.getEmpresa(connexion,asientocontable));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				asientocontable.setSucursal(asientocontableDataAccess.getSucursal(connexion,asientocontable));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				asientocontable.setEjercicio(asientocontableDataAccess.getEjercicio(connexion,asientocontable));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				asientocontable.setPeriodo(asientocontableDataAccess.getPeriodo(connexion,asientocontable));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				asientocontable.setAnio(asientocontableDataAccess.getAnio(connexion,asientocontable));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				asientocontable.setMes(asientocontableDataAccess.getMes(connexion,asientocontable));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				asientocontable.setModulo(asientocontableDataAccess.getModulo(connexion,asientocontable));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				asientocontable.setUsuario(asientocontableDataAccess.getUsuario(connexion,asientocontable));
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				asientocontable.setTipoDocumento(asientocontableDataAccess.getTipoDocumento(connexion,asientocontable));
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				asientocontable.setTipoMovimiento(asientocontableDataAccess.getTipoMovimiento(connexion,asientocontable));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				asientocontable.setMoneda(asientocontableDataAccess.getMoneda(connexion,asientocontable));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				asientocontable.setCliente(asientocontableDataAccess.getCliente(connexion,asientocontable));
				continue;
			}

			if(clas.clas.equals(TipoDescripcionAsiento.class)) {
				asientocontable.setTipoDescripcionAsiento(asientocontableDataAccess.getTipoDescripcionAsiento(connexion,asientocontable));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				asientocontable.setFormato(asientocontableDataAccess.getFormato(connexion,asientocontable));
				continue;
			}

			if(clas.clas.equals(EstadoAsientoContable.class)) {
				asientocontable.setEstadoAsientoContable(asientocontableDataAccess.getEstadoAsientoContable(connexion,asientocontable));
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				asientocontable.setTipoMovimientoModulo(asientocontableDataAccess.getTipoMovimientoModulo(connexion,asientocontable));
				continue;
			}

			if(clas.clas.equals(Sri.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				asientocontable.setSris(asientocontableDataAccess.getSris(connexion,asientocontable));

				if(this.isConDeep) {
					SriLogic sriLogic= new SriLogic(this.connexion);
					sriLogic.setSris(asientocontable.getSris());
					ArrayList<Classe> classesLocal=SriConstantesFunciones.getClassesForeignKeysOfSri(new ArrayList<Classe>(),DeepLoadType.NONE);
					sriLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SriConstantesFunciones.refrescarForeignKeysDescripcionesSri(sriLogic.getSris());
					asientocontable.setSris(sriLogic.getSris());
				}

				continue;
			}

			if(clas.clas.equals(ImportarExportar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				asientocontable.setImportarExportars(asientocontableDataAccess.getImportarExportars(connexion,asientocontable));

				if(this.isConDeep) {
					ImportarExportarLogic importarexportarLogic= new ImportarExportarLogic(this.connexion);
					importarexportarLogic.setImportarExportars(asientocontable.getImportarExportars());
					ArrayList<Classe> classesLocal=ImportarExportarConstantesFunciones.getClassesForeignKeysOfImportarExportar(new ArrayList<Classe>(),DeepLoadType.NONE);
					importarexportarLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(importarexportarLogic.getImportarExportars());
					asientocontable.setImportarExportars(importarexportarLogic.getImportarExportars());
				}

				continue;
			}

			if(clas.clas.equals(DetalleMoviClienProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				asientocontable.setDetalleMoviClienProves(asientocontableDataAccess.getDetalleMoviClienProves(connexion,asientocontable));

				if(this.isConDeep) {
					DetalleMoviClienProveLogic detallemoviclienproveLogic= new DetalleMoviClienProveLogic(this.connexion);
					detallemoviclienproveLogic.setDetalleMoviClienProves(asientocontable.getDetalleMoviClienProves());
					ArrayList<Classe> classesLocal=DetalleMoviClienProveConstantesFunciones.getClassesForeignKeysOfDetalleMoviClienProve(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallemoviclienproveLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(detallemoviclienproveLogic.getDetalleMoviClienProves());
					asientocontable.setDetalleMoviClienProves(detallemoviclienproveLogic.getDetalleMoviClienProves());
				}

				continue;
			}

			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				asientocontable.setPrestamos(asientocontableDataAccess.getPrestamos(connexion,asientocontable));

				if(this.isConDeep) {
					PrestamoLogic prestamoLogic= new PrestamoLogic(this.connexion);
					prestamoLogic.setPrestamos(asientocontable.getPrestamos());
					ArrayList<Classe> classesLocal=PrestamoConstantesFunciones.getClassesForeignKeysOfPrestamo(new ArrayList<Classe>(),DeepLoadType.NONE);
					prestamoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(prestamoLogic.getPrestamos());
					asientocontable.setPrestamos(prestamoLogic.getPrestamos());
				}

				continue;
			}

			if(clas.clas.equals(DetalleAsientoContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				asientocontable.setDetalleAsientoContables(asientocontableDataAccess.getDetalleAsientoContables(connexion,asientocontable));

				if(this.isConDeep) {
					DetalleAsientoContableLogic detalleasientocontableLogic= new DetalleAsientoContableLogic(this.connexion);
					detalleasientocontableLogic.setDetalleAsientoContables(asientocontable.getDetalleAsientoContables());
					ArrayList<Classe> classesLocal=DetalleAsientoContableConstantesFunciones.getClassesForeignKeysOfDetalleAsientoContable(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleasientocontableLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleAsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesDetalleAsientoContable(detalleasientocontableLogic.getDetalleAsientoContables());
					asientocontable.setDetalleAsientoContables(detalleasientocontableLogic.getDetalleAsientoContables());
				}

				continue;
			}

			if(clas.clas.equals(Retencion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				asientocontable.setRetencions(asientocontableDataAccess.getRetencions(connexion,asientocontable));

				if(this.isConDeep) {
					RetencionLogic retencionLogic= new RetencionLogic(this.connexion);
					retencionLogic.setRetencions(asientocontable.getRetencions());
					ArrayList<Classe> classesLocal=RetencionConstantesFunciones.getClassesForeignKeysOfRetencion(new ArrayList<Classe>(),DeepLoadType.NONE);
					retencionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RetencionConstantesFunciones.refrescarForeignKeysDescripcionesRetencion(retencionLogic.getRetencions());
					asientocontable.setRetencions(retencionLogic.getRetencions());
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
			asientocontable.setEmpresa(asientocontableDataAccess.getEmpresa(connexion,asientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setSucursal(asientocontableDataAccess.getSucursal(connexion,asientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setEjercicio(asientocontableDataAccess.getEjercicio(connexion,asientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setPeriodo(asientocontableDataAccess.getPeriodo(connexion,asientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setAnio(asientocontableDataAccess.getAnio(connexion,asientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setMes(asientocontableDataAccess.getMes(connexion,asientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setModulo(asientocontableDataAccess.getModulo(connexion,asientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setUsuario(asientocontableDataAccess.getUsuario(connexion,asientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setTipoDocumento(asientocontableDataAccess.getTipoDocumento(connexion,asientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setTipoMovimiento(asientocontableDataAccess.getTipoMovimiento(connexion,asientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setMoneda(asientocontableDataAccess.getMoneda(connexion,asientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setCliente(asientocontableDataAccess.getCliente(connexion,asientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDescripcionAsiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setTipoDescripcionAsiento(asientocontableDataAccess.getTipoDescripcionAsiento(connexion,asientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setFormato(asientocontableDataAccess.getFormato(connexion,asientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoAsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setEstadoAsientoContable(asientocontableDataAccess.getEstadoAsientoContable(connexion,asientocontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setTipoMovimientoModulo(asientocontableDataAccess.getTipoMovimientoModulo(connexion,asientocontable));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sri.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Sri.class));
			asientocontable.setSris(asientocontableDataAccess.getSris(connexion,asientocontable));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ImportarExportar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ImportarExportar.class));
			asientocontable.setImportarExportars(asientocontableDataAccess.getImportarExportars(connexion,asientocontable));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleMoviClienProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleMoviClienProve.class));
			asientocontable.setDetalleMoviClienProves(asientocontableDataAccess.getDetalleMoviClienProves(connexion,asientocontable));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Prestamo.class));
			asientocontable.setPrestamos(asientocontableDataAccess.getPrestamos(connexion,asientocontable));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleAsientoContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleAsientoContable.class));
			asientocontable.setDetalleAsientoContables(asientocontableDataAccess.getDetalleAsientoContables(connexion,asientocontable));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Retencion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Retencion.class));
			asientocontable.setRetencions(asientocontableDataAccess.getRetencions(connexion,asientocontable));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		asientocontable.setEmpresa(asientocontableDataAccess.getEmpresa(connexion,asientocontable));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(asientocontable.getEmpresa(),isDeep,deepLoadType,clases);
				
		asientocontable.setSucursal(asientocontableDataAccess.getSucursal(connexion,asientocontable));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(asientocontable.getSucursal(),isDeep,deepLoadType,clases);
				
		asientocontable.setEjercicio(asientocontableDataAccess.getEjercicio(connexion,asientocontable));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(asientocontable.getEjercicio(),isDeep,deepLoadType,clases);
				
		asientocontable.setPeriodo(asientocontableDataAccess.getPeriodo(connexion,asientocontable));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(asientocontable.getPeriodo(),isDeep,deepLoadType,clases);
				
		asientocontable.setAnio(asientocontableDataAccess.getAnio(connexion,asientocontable));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(asientocontable.getAnio(),isDeep,deepLoadType,clases);
				
		asientocontable.setMes(asientocontableDataAccess.getMes(connexion,asientocontable));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(asientocontable.getMes(),isDeep,deepLoadType,clases);
				
		asientocontable.setModulo(asientocontableDataAccess.getModulo(connexion,asientocontable));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(asientocontable.getModulo(),isDeep,deepLoadType,clases);
				
		asientocontable.setUsuario(asientocontableDataAccess.getUsuario(connexion,asientocontable));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(asientocontable.getUsuario(),isDeep,deepLoadType,clases);
				
		asientocontable.setTipoDocumento(asientocontableDataAccess.getTipoDocumento(connexion,asientocontable));
		TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentoLogic.deepLoad(asientocontable.getTipoDocumento(),isDeep,deepLoadType,clases);
				
		asientocontable.setTipoMovimiento(asientocontableDataAccess.getTipoMovimiento(connexion,asientocontable));
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(asientocontable.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		asientocontable.setMoneda(asientocontableDataAccess.getMoneda(connexion,asientocontable));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(asientocontable.getMoneda(),isDeep,deepLoadType,clases);
				
		asientocontable.setCliente(asientocontableDataAccess.getCliente(connexion,asientocontable));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(asientocontable.getCliente(),isDeep,deepLoadType,clases);
				
		asientocontable.setTipoDescripcionAsiento(asientocontableDataAccess.getTipoDescripcionAsiento(connexion,asientocontable));
		TipoDescripcionAsientoLogic tipodescripcionasientoLogic= new TipoDescripcionAsientoLogic(connexion);
		tipodescripcionasientoLogic.deepLoad(asientocontable.getTipoDescripcionAsiento(),isDeep,deepLoadType,clases);
				
		asientocontable.setFormato(asientocontableDataAccess.getFormato(connexion,asientocontable));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(asientocontable.getFormato(),isDeep,deepLoadType,clases);
				
		asientocontable.setEstadoAsientoContable(asientocontableDataAccess.getEstadoAsientoContable(connexion,asientocontable));
		EstadoAsientoContableLogic estadoasientocontableLogic= new EstadoAsientoContableLogic(connexion);
		estadoasientocontableLogic.deepLoad(asientocontable.getEstadoAsientoContable(),isDeep,deepLoadType,clases);
				
		asientocontable.setTipoMovimientoModulo(asientocontableDataAccess.getTipoMovimientoModulo(connexion,asientocontable));
		TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
		tipomovimientomoduloLogic.deepLoad(asientocontable.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);
				

		asientocontable.setSris(asientocontableDataAccess.getSris(connexion,asientocontable));

		for(Sri sri:asientocontable.getSris()) {
			SriLogic sriLogic= new SriLogic(connexion);
			sriLogic.deepLoad(sri,isDeep,deepLoadType,clases);
		}

		asientocontable.setImportarExportars(asientocontableDataAccess.getImportarExportars(connexion,asientocontable));

		for(ImportarExportar importarexportar:asientocontable.getImportarExportars()) {
			ImportarExportarLogic importarexportarLogic= new ImportarExportarLogic(connexion);
			importarexportarLogic.deepLoad(importarexportar,isDeep,deepLoadType,clases);
		}

		asientocontable.setDetalleMoviClienProves(asientocontableDataAccess.getDetalleMoviClienProves(connexion,asientocontable));

		for(DetalleMoviClienProve detallemoviclienprove:asientocontable.getDetalleMoviClienProves()) {
			DetalleMoviClienProveLogic detallemoviclienproveLogic= new DetalleMoviClienProveLogic(connexion);
			detallemoviclienproveLogic.deepLoad(detallemoviclienprove,isDeep,deepLoadType,clases);
		}

		asientocontable.setPrestamos(asientocontableDataAccess.getPrestamos(connexion,asientocontable));

		for(Prestamo prestamo:asientocontable.getPrestamos()) {
			PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
			prestamoLogic.deepLoad(prestamo,isDeep,deepLoadType,clases);
		}

		asientocontable.setDetalleAsientoContables(asientocontableDataAccess.getDetalleAsientoContables(connexion,asientocontable));

		for(DetalleAsientoContable detalleasientocontable:asientocontable.getDetalleAsientoContables()) {
			DetalleAsientoContableLogic detalleasientocontableLogic= new DetalleAsientoContableLogic(connexion);
			detalleasientocontableLogic.deepLoad(detalleasientocontable,isDeep,deepLoadType,clases);
		}

		asientocontable.setRetencions(asientocontableDataAccess.getRetencions(connexion,asientocontable));

		for(Retencion retencion:asientocontable.getRetencions()) {
			RetencionLogic retencionLogic= new RetencionLogic(connexion);
			retencionLogic.deepLoad(retencion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				asientocontable.setEmpresa(asientocontableDataAccess.getEmpresa(connexion,asientocontable));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(asientocontable.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				asientocontable.setSucursal(asientocontableDataAccess.getSucursal(connexion,asientocontable));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(asientocontable.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				asientocontable.setEjercicio(asientocontableDataAccess.getEjercicio(connexion,asientocontable));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(asientocontable.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				asientocontable.setPeriodo(asientocontableDataAccess.getPeriodo(connexion,asientocontable));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(asientocontable.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				asientocontable.setAnio(asientocontableDataAccess.getAnio(connexion,asientocontable));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(asientocontable.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				asientocontable.setMes(asientocontableDataAccess.getMes(connexion,asientocontable));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(asientocontable.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				asientocontable.setModulo(asientocontableDataAccess.getModulo(connexion,asientocontable));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(asientocontable.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				asientocontable.setUsuario(asientocontableDataAccess.getUsuario(connexion,asientocontable));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(asientocontable.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				asientocontable.setTipoDocumento(asientocontableDataAccess.getTipoDocumento(connexion,asientocontable));
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepLoad(asientocontable.getTipoDocumento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				asientocontable.setTipoMovimiento(asientocontableDataAccess.getTipoMovimiento(connexion,asientocontable));
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepLoad(asientocontable.getTipoMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				asientocontable.setMoneda(asientocontableDataAccess.getMoneda(connexion,asientocontable));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(asientocontable.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				asientocontable.setCliente(asientocontableDataAccess.getCliente(connexion,asientocontable));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(asientocontable.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDescripcionAsiento.class)) {
				asientocontable.setTipoDescripcionAsiento(asientocontableDataAccess.getTipoDescripcionAsiento(connexion,asientocontable));
				TipoDescripcionAsientoLogic tipodescripcionasientoLogic= new TipoDescripcionAsientoLogic(connexion);
				tipodescripcionasientoLogic.deepLoad(asientocontable.getTipoDescripcionAsiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				asientocontable.setFormato(asientocontableDataAccess.getFormato(connexion,asientocontable));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(asientocontable.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoAsientoContable.class)) {
				asientocontable.setEstadoAsientoContable(asientocontableDataAccess.getEstadoAsientoContable(connexion,asientocontable));
				EstadoAsientoContableLogic estadoasientocontableLogic= new EstadoAsientoContableLogic(connexion);
				estadoasientocontableLogic.deepLoad(asientocontable.getEstadoAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				asientocontable.setTipoMovimientoModulo(asientocontableDataAccess.getTipoMovimientoModulo(connexion,asientocontable));
				TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
				tipomovimientomoduloLogic.deepLoad(asientocontable.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sri.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				asientocontable.setSris(asientocontableDataAccess.getSris(connexion,asientocontable));

				for(Sri sri:asientocontable.getSris()) {
					SriLogic sriLogic= new SriLogic(connexion);
					sriLogic.deepLoad(sri,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ImportarExportar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				asientocontable.setImportarExportars(asientocontableDataAccess.getImportarExportars(connexion,asientocontable));

				for(ImportarExportar importarexportar:asientocontable.getImportarExportars()) {
					ImportarExportarLogic importarexportarLogic= new ImportarExportarLogic(connexion);
					importarexportarLogic.deepLoad(importarexportar,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleMoviClienProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				asientocontable.setDetalleMoviClienProves(asientocontableDataAccess.getDetalleMoviClienProves(connexion,asientocontable));

				for(DetalleMoviClienProve detallemoviclienprove:asientocontable.getDetalleMoviClienProves()) {
					DetalleMoviClienProveLogic detallemoviclienproveLogic= new DetalleMoviClienProveLogic(connexion);
					detallemoviclienproveLogic.deepLoad(detallemoviclienprove,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				asientocontable.setPrestamos(asientocontableDataAccess.getPrestamos(connexion,asientocontable));

				for(Prestamo prestamo:asientocontable.getPrestamos()) {
					PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
					prestamoLogic.deepLoad(prestamo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleAsientoContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				asientocontable.setDetalleAsientoContables(asientocontableDataAccess.getDetalleAsientoContables(connexion,asientocontable));

				for(DetalleAsientoContable detalleasientocontable:asientocontable.getDetalleAsientoContables()) {
					DetalleAsientoContableLogic detalleasientocontableLogic= new DetalleAsientoContableLogic(connexion);
					detalleasientocontableLogic.deepLoad(detalleasientocontable,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Retencion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				asientocontable.setRetencions(asientocontableDataAccess.getRetencions(connexion,asientocontable));

				for(Retencion retencion:asientocontable.getRetencions()) {
					RetencionLogic retencionLogic= new RetencionLogic(connexion);
					retencionLogic.deepLoad(retencion,isDeep,deepLoadType,clases);
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
			asientocontable.setEmpresa(asientocontableDataAccess.getEmpresa(connexion,asientocontable));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(asientocontable.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setSucursal(asientocontableDataAccess.getSucursal(connexion,asientocontable));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(asientocontable.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setEjercicio(asientocontableDataAccess.getEjercicio(connexion,asientocontable));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(asientocontable.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setPeriodo(asientocontableDataAccess.getPeriodo(connexion,asientocontable));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(asientocontable.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setAnio(asientocontableDataAccess.getAnio(connexion,asientocontable));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(asientocontable.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setMes(asientocontableDataAccess.getMes(connexion,asientocontable));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(asientocontable.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setModulo(asientocontableDataAccess.getModulo(connexion,asientocontable));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(asientocontable.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setUsuario(asientocontableDataAccess.getUsuario(connexion,asientocontable));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(asientocontable.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setTipoDocumento(asientocontableDataAccess.getTipoDocumento(connexion,asientocontable));
			TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
			tipodocumentoLogic.deepLoad(asientocontable.getTipoDocumento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setTipoMovimiento(asientocontableDataAccess.getTipoMovimiento(connexion,asientocontable));
			TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
			tipomovimientoLogic.deepLoad(asientocontable.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setMoneda(asientocontableDataAccess.getMoneda(connexion,asientocontable));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(asientocontable.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setCliente(asientocontableDataAccess.getCliente(connexion,asientocontable));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(asientocontable.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDescripcionAsiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setTipoDescripcionAsiento(asientocontableDataAccess.getTipoDescripcionAsiento(connexion,asientocontable));
			TipoDescripcionAsientoLogic tipodescripcionasientoLogic= new TipoDescripcionAsientoLogic(connexion);
			tipodescripcionasientoLogic.deepLoad(asientocontable.getTipoDescripcionAsiento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setFormato(asientocontableDataAccess.getFormato(connexion,asientocontable));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(asientocontable.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoAsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setEstadoAsientoContable(asientocontableDataAccess.getEstadoAsientoContable(connexion,asientocontable));
			EstadoAsientoContableLogic estadoasientocontableLogic= new EstadoAsientoContableLogic(connexion);
			estadoasientocontableLogic.deepLoad(asientocontable.getEstadoAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			asientocontable.setTipoMovimientoModulo(asientocontableDataAccess.getTipoMovimientoModulo(connexion,asientocontable));
			TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
			tipomovimientomoduloLogic.deepLoad(asientocontable.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sri.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Sri.class));
			asientocontable.setSris(asientocontableDataAccess.getSris(connexion,asientocontable));

			for(Sri sri:asientocontable.getSris()) {
				SriLogic sriLogic= new SriLogic(connexion);
				sriLogic.deepLoad(sri,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ImportarExportar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ImportarExportar.class));
			asientocontable.setImportarExportars(asientocontableDataAccess.getImportarExportars(connexion,asientocontable));

			for(ImportarExportar importarexportar:asientocontable.getImportarExportars()) {
				ImportarExportarLogic importarexportarLogic= new ImportarExportarLogic(connexion);
				importarexportarLogic.deepLoad(importarexportar,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleMoviClienProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleMoviClienProve.class));
			asientocontable.setDetalleMoviClienProves(asientocontableDataAccess.getDetalleMoviClienProves(connexion,asientocontable));

			for(DetalleMoviClienProve detallemoviclienprove:asientocontable.getDetalleMoviClienProves()) {
				DetalleMoviClienProveLogic detallemoviclienproveLogic= new DetalleMoviClienProveLogic(connexion);
				detallemoviclienproveLogic.deepLoad(detallemoviclienprove,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Prestamo.class));
			asientocontable.setPrestamos(asientocontableDataAccess.getPrestamos(connexion,asientocontable));

			for(Prestamo prestamo:asientocontable.getPrestamos()) {
				PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
				prestamoLogic.deepLoad(prestamo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleAsientoContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleAsientoContable.class));
			asientocontable.setDetalleAsientoContables(asientocontableDataAccess.getDetalleAsientoContables(connexion,asientocontable));

			for(DetalleAsientoContable detalleasientocontable:asientocontable.getDetalleAsientoContables()) {
				DetalleAsientoContableLogic detalleasientocontableLogic= new DetalleAsientoContableLogic(connexion);
				detalleasientocontableLogic.deepLoad(detalleasientocontable,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Retencion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Retencion.class));
			asientocontable.setRetencions(asientocontableDataAccess.getRetencions(connexion,asientocontable));

			for(Retencion retencion:asientocontable.getRetencions()) {
				RetencionLogic retencionLogic= new RetencionLogic(connexion);
				retencionLogic.deepLoad(retencion,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(AsientoContable asientocontable,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			AsientoContableLogicAdditional.updateAsientoContableToSave(asientocontable,this.arrDatoGeneral);
			
AsientoContableDataAccess.save(asientocontable, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(asientocontable.getEmpresa(),connexion);

		SucursalDataAccess.save(asientocontable.getSucursal(),connexion);

		EjercicioDataAccess.save(asientocontable.getEjercicio(),connexion);

		PeriodoDataAccess.save(asientocontable.getPeriodo(),connexion);

		AnioDataAccess.save(asientocontable.getAnio(),connexion);

		MesDataAccess.save(asientocontable.getMes(),connexion);

		ModuloDataAccess.save(asientocontable.getModulo(),connexion);

		UsuarioDataAccess.save(asientocontable.getUsuario(),connexion);

		TipoDocumentoDataAccess.save(asientocontable.getTipoDocumento(),connexion);

		TipoMovimientoDataAccess.save(asientocontable.getTipoMovimiento(),connexion);

		MonedaDataAccess.save(asientocontable.getMoneda(),connexion);

		ClienteDataAccess.save(asientocontable.getCliente(),connexion);

		TipoDescripcionAsientoDataAccess.save(asientocontable.getTipoDescripcionAsiento(),connexion);

		FormatoDataAccess.save(asientocontable.getFormato(),connexion);

		EstadoAsientoContableDataAccess.save(asientocontable.getEstadoAsientoContable(),connexion);

		TipoMovimientoModuloDataAccess.save(asientocontable.getTipoMovimientoModulo(),connexion);

		for(Sri sri:asientocontable.getSris()) {
			sri.setid_asiento_contable(asientocontable.getId());
			SriDataAccess.save(sri,connexion);
		}

		for(ImportarExportar importarexportar:asientocontable.getImportarExportars()) {
			importarexportar.setid_asiento_contable(asientocontable.getId());
			ImportarExportarDataAccess.save(importarexportar,connexion);
		}

		for(DetalleMoviClienProve detallemoviclienprove:asientocontable.getDetalleMoviClienProves()) {
			detallemoviclienprove.setid_asiento_contable(asientocontable.getId());
			DetalleMoviClienProveDataAccess.save(detallemoviclienprove,connexion);
		}

		for(Prestamo prestamo:asientocontable.getPrestamos()) {
			prestamo.setid_asiento_contable(asientocontable.getId());
			PrestamoDataAccess.save(prestamo,connexion);
		}

		for(DetalleAsientoContable detalleasientocontable:asientocontable.getDetalleAsientoContables()) {
			detalleasientocontable.setid_asiento_contable(asientocontable.getId());
			DetalleAsientoContableDataAccess.save(detalleasientocontable,connexion);
		}

		for(Retencion retencion:asientocontable.getRetencions()) {
			retencion.setid_asiento_contable(asientocontable.getId());
			RetencionDataAccess.save(retencion,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(asientocontable.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(asientocontable.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(asientocontable.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(asientocontable.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(asientocontable.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(asientocontable.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(asientocontable.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(asientocontable.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(asientocontable.getTipoDocumento(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(asientocontable.getTipoMovimiento(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(asientocontable.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(asientocontable.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDescripcionAsiento.class)) {
				TipoDescripcionAsientoDataAccess.save(asientocontable.getTipoDescripcionAsiento(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(asientocontable.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoAsientoContable.class)) {
				EstadoAsientoContableDataAccess.save(asientocontable.getEstadoAsientoContable(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				TipoMovimientoModuloDataAccess.save(asientocontable.getTipoMovimientoModulo(),connexion);
				continue;
			}


			if(clas.clas.equals(Sri.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Sri sri:asientocontable.getSris()) {
					sri.setid_asiento_contable(asientocontable.getId());
					SriDataAccess.save(sri,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ImportarExportar.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ImportarExportar importarexportar:asientocontable.getImportarExportars()) {
					importarexportar.setid_asiento_contable(asientocontable.getId());
					ImportarExportarDataAccess.save(importarexportar,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetalleMoviClienProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleMoviClienProve detallemoviclienprove:asientocontable.getDetalleMoviClienProves()) {
					detallemoviclienprove.setid_asiento_contable(asientocontable.getId());
					DetalleMoviClienProveDataAccess.save(detallemoviclienprove,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Prestamo prestamo:asientocontable.getPrestamos()) {
					prestamo.setid_asiento_contable(asientocontable.getId());
					PrestamoDataAccess.save(prestamo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetalleAsientoContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleAsientoContable detalleasientocontable:asientocontable.getDetalleAsientoContables()) {
					detalleasientocontable.setid_asiento_contable(asientocontable.getId());
					DetalleAsientoContableDataAccess.save(detalleasientocontable,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Retencion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Retencion retencion:asientocontable.getRetencions()) {
					retencion.setid_asiento_contable(asientocontable.getId());
					RetencionDataAccess.save(retencion,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(asientocontable.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(asientocontable.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(asientocontable.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(asientocontable.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(asientocontable.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(asientocontable.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(asientocontable.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(asientocontable.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(asientocontable.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(asientocontable.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(asientocontable.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(asientocontable.getMes(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(asientocontable.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(asientocontable.getModulo(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(asientocontable.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(asientocontable.getUsuario(),isDeep,deepLoadType,clases);
				

		TipoDocumentoDataAccess.save(asientocontable.getTipoDocumento(),connexion);
		TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentoLogic.deepLoad(asientocontable.getTipoDocumento(),isDeep,deepLoadType,clases);
				

		TipoMovimientoDataAccess.save(asientocontable.getTipoMovimiento(),connexion);
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(asientocontable.getTipoMovimiento(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(asientocontable.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(asientocontable.getMoneda(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(asientocontable.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(asientocontable.getCliente(),isDeep,deepLoadType,clases);
				

		TipoDescripcionAsientoDataAccess.save(asientocontable.getTipoDescripcionAsiento(),connexion);
		TipoDescripcionAsientoLogic tipodescripcionasientoLogic= new TipoDescripcionAsientoLogic(connexion);
		tipodescripcionasientoLogic.deepLoad(asientocontable.getTipoDescripcionAsiento(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(asientocontable.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(asientocontable.getFormato(),isDeep,deepLoadType,clases);
				

		EstadoAsientoContableDataAccess.save(asientocontable.getEstadoAsientoContable(),connexion);
		EstadoAsientoContableLogic estadoasientocontableLogic= new EstadoAsientoContableLogic(connexion);
		estadoasientocontableLogic.deepLoad(asientocontable.getEstadoAsientoContable(),isDeep,deepLoadType,clases);
				

		TipoMovimientoModuloDataAccess.save(asientocontable.getTipoMovimientoModulo(),connexion);
		TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
		tipomovimientomoduloLogic.deepLoad(asientocontable.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);
				

		for(Sri sri:asientocontable.getSris()) {
			SriLogic sriLogic= new SriLogic(connexion);
			sri.setid_asiento_contable(asientocontable.getId());
			SriDataAccess.save(sri,connexion);
			sriLogic.deepSave(sri,isDeep,deepLoadType,clases);
		}

		for(ImportarExportar importarexportar:asientocontable.getImportarExportars()) {
			ImportarExportarLogic importarexportarLogic= new ImportarExportarLogic(connexion);
			importarexportar.setid_asiento_contable(asientocontable.getId());
			ImportarExportarDataAccess.save(importarexportar,connexion);
			importarexportarLogic.deepSave(importarexportar,isDeep,deepLoadType,clases);
		}

		for(DetalleMoviClienProve detallemoviclienprove:asientocontable.getDetalleMoviClienProves()) {
			DetalleMoviClienProveLogic detallemoviclienproveLogic= new DetalleMoviClienProveLogic(connexion);
			detallemoviclienprove.setid_asiento_contable(asientocontable.getId());
			DetalleMoviClienProveDataAccess.save(detallemoviclienprove,connexion);
			detallemoviclienproveLogic.deepSave(detallemoviclienprove,isDeep,deepLoadType,clases);
		}

		for(Prestamo prestamo:asientocontable.getPrestamos()) {
			PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
			prestamo.setid_asiento_contable(asientocontable.getId());
			PrestamoDataAccess.save(prestamo,connexion);
			prestamoLogic.deepSave(prestamo,isDeep,deepLoadType,clases);
		}

		for(DetalleAsientoContable detalleasientocontable:asientocontable.getDetalleAsientoContables()) {
			DetalleAsientoContableLogic detalleasientocontableLogic= new DetalleAsientoContableLogic(connexion);
			detalleasientocontable.setid_asiento_contable(asientocontable.getId());
			DetalleAsientoContableDataAccess.save(detalleasientocontable,connexion);
			detalleasientocontableLogic.deepSave(detalleasientocontable,isDeep,deepLoadType,clases);
		}

		for(Retencion retencion:asientocontable.getRetencions()) {
			RetencionLogic retencionLogic= new RetencionLogic(connexion);
			retencion.setid_asiento_contable(asientocontable.getId());
			RetencionDataAccess.save(retencion,connexion);
			retencionLogic.deepSave(retencion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(asientocontable.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(asientocontable.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(asientocontable.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(asientocontable.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(asientocontable.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(asientocontable.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(asientocontable.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(asientocontable.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(asientocontable.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(asientocontable.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(asientocontable.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(asientocontable.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(asientocontable.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(asientocontable.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(asientocontable.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(asientocontable.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(asientocontable.getTipoDocumento(),connexion);
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepSave(asientocontable.getTipoDocumento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(asientocontable.getTipoMovimiento(),connexion);
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepSave(asientocontable.getTipoMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(asientocontable.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(asientocontable.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(asientocontable.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(asientocontable.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDescripcionAsiento.class)) {
				TipoDescripcionAsientoDataAccess.save(asientocontable.getTipoDescripcionAsiento(),connexion);
				TipoDescripcionAsientoLogic tipodescripcionasientoLogic= new TipoDescripcionAsientoLogic(connexion);
				tipodescripcionasientoLogic.deepSave(asientocontable.getTipoDescripcionAsiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(asientocontable.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(asientocontable.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoAsientoContable.class)) {
				EstadoAsientoContableDataAccess.save(asientocontable.getEstadoAsientoContable(),connexion);
				EstadoAsientoContableLogic estadoasientocontableLogic= new EstadoAsientoContableLogic(connexion);
				estadoasientocontableLogic.deepSave(asientocontable.getEstadoAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				TipoMovimientoModuloDataAccess.save(asientocontable.getTipoMovimientoModulo(),connexion);
				TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
				tipomovimientomoduloLogic.deepSave(asientocontable.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Sri.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Sri sri:asientocontable.getSris()) {
					SriLogic sriLogic= new SriLogic(connexion);
					sri.setid_asiento_contable(asientocontable.getId());
					SriDataAccess.save(sri,connexion);
					sriLogic.deepSave(sri,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ImportarExportar.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ImportarExportar importarexportar:asientocontable.getImportarExportars()) {
					ImportarExportarLogic importarexportarLogic= new ImportarExportarLogic(connexion);
					importarexportar.setid_asiento_contable(asientocontable.getId());
					ImportarExportarDataAccess.save(importarexportar,connexion);
					importarexportarLogic.deepSave(importarexportar,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleMoviClienProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleMoviClienProve detallemoviclienprove:asientocontable.getDetalleMoviClienProves()) {
					DetalleMoviClienProveLogic detallemoviclienproveLogic= new DetalleMoviClienProveLogic(connexion);
					detallemoviclienprove.setid_asiento_contable(asientocontable.getId());
					DetalleMoviClienProveDataAccess.save(detallemoviclienprove,connexion);
					detallemoviclienproveLogic.deepSave(detallemoviclienprove,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Prestamo prestamo:asientocontable.getPrestamos()) {
					PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
					prestamo.setid_asiento_contable(asientocontable.getId());
					PrestamoDataAccess.save(prestamo,connexion);
					prestamoLogic.deepSave(prestamo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleAsientoContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleAsientoContable detalleasientocontable:asientocontable.getDetalleAsientoContables()) {
					DetalleAsientoContableLogic detalleasientocontableLogic= new DetalleAsientoContableLogic(connexion);
					detalleasientocontable.setid_asiento_contable(asientocontable.getId());
					DetalleAsientoContableDataAccess.save(detalleasientocontable,connexion);
					detalleasientocontableLogic.deepSave(detalleasientocontable,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Retencion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Retencion retencion:asientocontable.getRetencions()) {
					RetencionLogic retencionLogic= new RetencionLogic(connexion);
					retencion.setid_asiento_contable(asientocontable.getId());
					RetencionDataAccess.save(retencion,connexion);
					retencionLogic.deepSave(retencion,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(AsientoContable.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(asientocontable,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(asientocontable);
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
			this.deepLoad(this.asientocontable,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(AsientoContable.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(asientocontables!=null) {
				for(AsientoContable asientocontable:asientocontables) {
					this.deepLoad(asientocontable,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(asientocontables);
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
			if(asientocontables!=null) {
				for(AsientoContable asientocontable:asientocontables) {
					this.deepLoad(asientocontable,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(asientocontables);
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
			this.getNewConnexionToDeep(AsientoContable.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(asientocontable,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(AsientoContable.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(asientocontables!=null) {
				for(AsientoContable asientocontable:asientocontables) {
					this.deepSave(asientocontable,isDeep,deepLoadType,clases);
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
			if(asientocontables!=null) {
				for(AsientoContable asientocontable:asientocontables) {
					this.deepSave(asientocontable,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getAsientoContablesBusquedaPorBeneficiarioWithConnection(String sFinalQuery,Pagination pagination,String beneficiario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralBeneficiario= new ParameterSelectionGeneral();
			parameterSelectionGeneralBeneficiario.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+beneficiario+"%",AsientoContableConstantesFunciones.BENEFICIARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralBeneficiario);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorBeneficiario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContablesBusquedaPorBeneficiario(String sFinalQuery,Pagination pagination,String beneficiario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralBeneficiario= new ParameterSelectionGeneral();
			parameterSelectionGeneralBeneficiario.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+beneficiario+"%",AsientoContableConstantesFunciones.BENEFICIARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralBeneficiario);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorBeneficiario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContablesBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",AsientoContableConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContablesBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",AsientoContableConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContablesBusquedaPorFechaEmisionWithConnection(String sFinalQuery,Pagination pagination,Date fecha_emision,Date fecha_emisionFinal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaEmision= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaEmision.setParameterSelectionGeneralMayorIgual(ParameterType.DATE,fecha_emision,AsientoContableConstantesFunciones.FECHAEMISION,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaEmision);

			ParameterSelectionGeneral parameterSelectionGeneralFechaEmisionFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaEmisionFinal.setParameterSelectionGeneralMenorIgual(ParameterType.DATE,fecha_emisionFinal,AsientoContableConstantesFunciones.FECHAEMISION,"Final",ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaEmisionFinal);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaEmision","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContablesBusquedaPorFechaEmision(String sFinalQuery,Pagination pagination,Date fecha_emision,Date fecha_emisionFinal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaEmision= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaEmision.setParameterSelectionGeneralMayorIgual(ParameterType.DATE,fecha_emision,AsientoContableConstantesFunciones.FECHAEMISION,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaEmision);

			ParameterSelectionGeneral parameterSelectionGeneralFechaEmisionFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaEmisionFinal.setParameterSelectionGeneralMenorIgual(ParameterType.DATE,fecha_emisionFinal,AsientoContableConstantesFunciones.FECHAEMISION,"Final",ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaEmisionFinal);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaEmision","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContablesBusquedaPorNumeroMayorWithConnection(String sFinalQuery,Pagination pagination,String numero_mayor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroMayor= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroMayor.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero_mayor+"%",AsientoContableConstantesFunciones.NUMEROMAYOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroMayor);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNumeroMayor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContablesBusquedaPorNumeroMayor(String sFinalQuery,Pagination pagination,String numero_mayor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroMayor= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroMayor.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero_mayor+"%",AsientoContableConstantesFunciones.NUMEROMAYOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroMayor);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNumeroMayor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContablesBusquedaPorNumeroRetencionWithConnection(String sFinalQuery,Pagination pagination,String numero_retencion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroRetencion.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero_retencion+"%",AsientoContableConstantesFunciones.NUMERORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroRetencion);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNumeroRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContablesBusquedaPorNumeroRetencion(String sFinalQuery,Pagination pagination,String numero_retencion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroRetencion.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero_retencion+"%",AsientoContableConstantesFunciones.NUMERORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroRetencion);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNumeroRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContablesBusquedaPorValorWithConnection(String sFinalQuery,Pagination pagination,Double valor,Double valorFinal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralValor= new ParameterSelectionGeneral();
			parameterSelectionGeneralValor.setParameterSelectionGeneralMayorIgual(ParameterType.DOUBLE,valor,AsientoContableConstantesFunciones.VALOR,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralValor);

			ParameterSelectionGeneral parameterSelectionGeneralValorFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralValorFinal.setParameterSelectionGeneralMenorIgual(ParameterType.DOUBLE,valorFinal,AsientoContableConstantesFunciones.VALOR,"Final",ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralValorFinal);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorValor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContablesBusquedaPorValor(String sFinalQuery,Pagination pagination,Double valor,Double valorFinal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralValor= new ParameterSelectionGeneral();
			parameterSelectionGeneralValor.setParameterSelectionGeneralMayorIgual(ParameterType.DOUBLE,valor,AsientoContableConstantesFunciones.VALOR,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralValor);

			ParameterSelectionGeneral parameterSelectionGeneralValorFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralValorFinal.setParameterSelectionGeneralMenorIgual(ParameterType.DOUBLE,valorFinal,AsientoContableConstantesFunciones.VALOR,"Final",ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralValorFinal);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorValor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContablesFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,AsientoContableConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContablesFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,AsientoContableConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContablesFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_asiento_contable,AsientoContableConstantesFunciones.IDESTADOASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoAsientoContable);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContablesFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_estado_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_asiento_contable,AsientoContableConstantesFunciones.IDESTADOASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoAsientoContable);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContablesFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,AsientoContableConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContablesFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,AsientoContableConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContablesFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,AsientoContableConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContablesFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,AsientoContableConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContablesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AsientoContableConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContablesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AsientoContableConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContablesFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,AsientoContableConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContablesFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,AsientoContableConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContablesFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,AsientoContableConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContablesFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,AsientoContableConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContablesFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,AsientoContableConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContablesFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,AsientoContableConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContablesFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,AsientoContableConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContablesFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,AsientoContableConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContablesFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,AsientoContableConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContablesFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,AsientoContableConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContablesFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,AsientoContableConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContablesFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,AsientoContableConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContablesFK_IdTipoDescripcionAsientoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_descripcion_asiento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDescripcionAsiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDescripcionAsiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_descripcion_asiento,AsientoContableConstantesFunciones.IDTIPODESCRIPCIONASIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDescripcionAsiento);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDescripcionAsiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContablesFK_IdTipoDescripcionAsiento(String sFinalQuery,Pagination pagination,Long id_tipo_descripcion_asiento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDescripcionAsiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDescripcionAsiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_descripcion_asiento,AsientoContableConstantesFunciones.IDTIPODESCRIPCIONASIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDescripcionAsiento);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDescripcionAsiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContablesFK_IdTipoDocumentoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_documento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento,AsientoContableConstantesFunciones.IDTIPODOCUMENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumento);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContablesFK_IdTipoDocumento(String sFinalQuery,Pagination pagination,Long id_tipo_documento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento,AsientoContableConstantesFunciones.IDTIPODOCUMENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumento);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContablesFK_IdTipoMovimientoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,AsientoContableConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContablesFK_IdTipoMovimiento(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,AsientoContableConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContablesFK_IdTipoMovimientoModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,AsientoContableConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimientoModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContablesFK_IdTipoMovimientoModulo(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,AsientoContableConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimientoModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAsientoContablesFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AsientoContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,AsientoContableConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAsientoContablesFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,AsientoContableConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			AsientoContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			asientocontables=asientocontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AsientoContableConstantesFunciones.refrescarForeignKeysDescripcionesAsientoContable(this.asientocontables);
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
			if(AsientoContableConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,AsientoContableDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,AsientoContable asientocontable,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(AsientoContableConstantesFunciones.ISCONAUDITORIA) {
				if(asientocontable.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AsientoContableDataAccess.TABLENAME, asientocontable.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AsientoContableConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AsientoContableLogic.registrarAuditoriaDetallesAsientoContable(connexion,asientocontable,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(asientocontable.getIsDeleted()) {
					/*if(!asientocontable.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,AsientoContableDataAccess.TABLENAME, asientocontable.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////AsientoContableLogic.registrarAuditoriaDetallesAsientoContable(connexion,asientocontable,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AsientoContableDataAccess.TABLENAME, asientocontable.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(asientocontable.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AsientoContableDataAccess.TABLENAME, asientocontable.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AsientoContableConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AsientoContableLogic.registrarAuditoriaDetallesAsientoContable(connexion,asientocontable,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesAsientoContable(Connexion connexion,AsientoContable asientocontable)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(asientocontable.getIsNew()||!asientocontable.getid_empresa().equals(asientocontable.getAsientoContableOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getid_empresa()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getid_empresa().toString();
				}
				if(asientocontable.getid_empresa()!=null)
				{
					strValorNuevo=asientocontable.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getid_sucursal().equals(asientocontable.getAsientoContableOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getid_sucursal()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getid_sucursal().toString();
				}
				if(asientocontable.getid_sucursal()!=null)
				{
					strValorNuevo=asientocontable.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getid_ejercicio().equals(asientocontable.getAsientoContableOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getid_ejercicio()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getid_ejercicio().toString();
				}
				if(asientocontable.getid_ejercicio()!=null)
				{
					strValorNuevo=asientocontable.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getid_periodo().equals(asientocontable.getAsientoContableOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getid_periodo()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getid_periodo().toString();
				}
				if(asientocontable.getid_periodo()!=null)
				{
					strValorNuevo=asientocontable.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getid_anio().equals(asientocontable.getAsientoContableOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getid_anio()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getid_anio().toString();
				}
				if(asientocontable.getid_anio()!=null)
				{
					strValorNuevo=asientocontable.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getid_mes().equals(asientocontable.getAsientoContableOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getid_mes()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getid_mes().toString();
				}
				if(asientocontable.getid_mes()!=null)
				{
					strValorNuevo=asientocontable.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getid_modulo().equals(asientocontable.getAsientoContableOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getid_modulo()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getid_modulo().toString();
				}
				if(asientocontable.getid_modulo()!=null)
				{
					strValorNuevo=asientocontable.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getid_usuario().equals(asientocontable.getAsientoContableOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getid_usuario()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getid_usuario().toString();
				}
				if(asientocontable.getid_usuario()!=null)
				{
					strValorNuevo=asientocontable.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getid_tipo_documento().equals(asientocontable.getAsientoContableOriginal().getid_tipo_documento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getid_tipo_documento()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getid_tipo_documento().toString();
				}
				if(asientocontable.getid_tipo_documento()!=null)
				{
					strValorNuevo=asientocontable.getid_tipo_documento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.IDTIPODOCUMENTO,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getcodigo().equals(asientocontable.getAsientoContableOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getcodigo()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getcodigo();
				}
				if(asientocontable.getcodigo()!=null)
				{
					strValorNuevo=asientocontable.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getfecha().equals(asientocontable.getAsientoContableOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getfecha()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getfecha().toString();
				}
				if(asientocontable.getfecha()!=null)
				{
					strValorNuevo=asientocontable.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getid_tipo_movimiento().equals(asientocontable.getAsientoContableOriginal().getid_tipo_movimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getid_tipo_movimiento()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getid_tipo_movimiento().toString();
				}
				if(asientocontable.getid_tipo_movimiento()!=null)
				{
					strValorNuevo=asientocontable.getid_tipo_movimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.IDTIPOMOVIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getnumero_mayor().equals(asientocontable.getAsientoContableOriginal().getnumero_mayor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getnumero_mayor()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getnumero_mayor();
				}
				if(asientocontable.getnumero_mayor()!=null)
				{
					strValorNuevo=asientocontable.getnumero_mayor() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.NUMEROMAYOR,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getid_moneda().equals(asientocontable.getAsientoContableOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getid_moneda()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getid_moneda().toString();
				}
				if(asientocontable.getid_moneda()!=null)
				{
					strValorNuevo=asientocontable.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getes_retencion().equals(asientocontable.getAsientoContableOriginal().getes_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getes_retencion()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getes_retencion().toString();
				}
				if(asientocontable.getes_retencion()!=null)
				{
					strValorNuevo=asientocontable.getes_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.ESRETENCION,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getnumero_retencion().equals(asientocontable.getAsientoContableOriginal().getnumero_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getnumero_retencion()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getnumero_retencion();
				}
				if(asientocontable.getnumero_retencion()!=null)
				{
					strValorNuevo=asientocontable.getnumero_retencion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.NUMERORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getvalor().equals(asientocontable.getAsientoContableOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getvalor()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getvalor().toString();
				}
				if(asientocontable.getvalor()!=null)
				{
					strValorNuevo=asientocontable.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getes_retencion_iva().equals(asientocontable.getAsientoContableOriginal().getes_retencion_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getes_retencion_iva()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getes_retencion_iva().toString();
				}
				if(asientocontable.getes_retencion_iva()!=null)
				{
					strValorNuevo=asientocontable.getes_retencion_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.ESRETENCIONIVA,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getnumero_retencion_iva().equals(asientocontable.getAsientoContableOriginal().getnumero_retencion_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getnumero_retencion_iva()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getnumero_retencion_iva();
				}
				if(asientocontable.getnumero_retencion_iva()!=null)
				{
					strValorNuevo=asientocontable.getnumero_retencion_iva() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.NUMERORETENCIONIVA,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getcotizacion().equals(asientocontable.getAsientoContableOriginal().getcotizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getcotizacion()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getcotizacion().toString();
				}
				if(asientocontable.getcotizacion()!=null)
				{
					strValorNuevo=asientocontable.getcotizacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.COTIZACION,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getid_cliente().equals(asientocontable.getAsientoContableOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getid_cliente()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getid_cliente().toString();
				}
				if(asientocontable.getid_cliente()!=null)
				{
					strValorNuevo=asientocontable.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getid_tipo_descripcion_asiento().equals(asientocontable.getAsientoContableOriginal().getid_tipo_descripcion_asiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getid_tipo_descripcion_asiento()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getid_tipo_descripcion_asiento().toString();
				}
				if(asientocontable.getid_tipo_descripcion_asiento()!=null)
				{
					strValorNuevo=asientocontable.getid_tipo_descripcion_asiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.IDTIPODESCRIPCIONASIENTO,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getid_formato().equals(asientocontable.getAsientoContableOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getid_formato()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getid_formato().toString();
				}
				if(asientocontable.getid_formato()!=null)
				{
					strValorNuevo=asientocontable.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getbeneficiario().equals(asientocontable.getAsientoContableOriginal().getbeneficiario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getbeneficiario()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getbeneficiario();
				}
				if(asientocontable.getbeneficiario()!=null)
				{
					strValorNuevo=asientocontable.getbeneficiario() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.BENEFICIARIO,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getdescripcion().equals(asientocontable.getAsientoContableOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getdescripcion()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getdescripcion();
				}
				if(asientocontable.getdescripcion()!=null)
				{
					strValorNuevo=asientocontable.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getfecha_emision().equals(asientocontable.getAsientoContableOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getfecha_emision()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getfecha_emision().toString();
				}
				if(asientocontable.getfecha_emision()!=null)
				{
					strValorNuevo=asientocontable.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getfecha_finalizacion().equals(asientocontable.getAsientoContableOriginal().getfecha_finalizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getfecha_finalizacion()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getfecha_finalizacion().toString();
				}
				if(asientocontable.getfecha_finalizacion()!=null)
				{
					strValorNuevo=asientocontable.getfecha_finalizacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.FECHAFINALIZACION,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getid_estado_asiento_contable().equals(asientocontable.getAsientoContableOriginal().getid_estado_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getid_estado_asiento_contable()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getid_estado_asiento_contable().toString();
				}
				if(asientocontable.getid_estado_asiento_contable()!=null)
				{
					strValorNuevo=asientocontable.getid_estado_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.IDESTADOASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(asientocontable.getIsNew()||!asientocontable.getid_tipo_movimiento_modulo().equals(asientocontable.getAsientoContableOriginal().getid_tipo_movimiento_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(asientocontable.getAsientoContableOriginal().getid_tipo_movimiento_modulo()!=null)
				{
					strValorActual=asientocontable.getAsientoContableOriginal().getid_tipo_movimiento_modulo().toString();
				}
				if(asientocontable.getid_tipo_movimiento_modulo()!=null)
				{
					strValorNuevo=asientocontable.getid_tipo_movimiento_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AsientoContableConstantesFunciones.IDTIPOMOVIMIENTOMODULO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveAsientoContableRelacionesWithConnection(AsientoContable asientocontable,List<Sri> sris,List<ImportarExportar> importarexportars,List<DetalleMoviClienProve> detallemoviclienproves,List<Prestamo> prestamos,List<DetalleAsientoContable> detalleasientocontables,List<Retencion> retencions) throws Exception {

		if(!asientocontable.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAsientoContableRelacionesBase(asientocontable,sris,importarexportars,detallemoviclienproves,prestamos,detalleasientocontables,retencions,true);
		}
	}

	public void saveAsientoContableRelaciones(AsientoContable asientocontable,List<Sri> sris,List<ImportarExportar> importarexportars,List<DetalleMoviClienProve> detallemoviclienproves,List<Prestamo> prestamos,List<DetalleAsientoContable> detalleasientocontables,List<Retencion> retencions)throws Exception {

		if(!asientocontable.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAsientoContableRelacionesBase(asientocontable,sris,importarexportars,detallemoviclienproves,prestamos,detalleasientocontables,retencions,false);
		}
	}

	public void saveAsientoContableRelacionesBase(AsientoContable asientocontable,List<Sri> sris,List<ImportarExportar> importarexportars,List<DetalleMoviClienProve> detallemoviclienproves,List<Prestamo> prestamos,List<DetalleAsientoContable> detalleasientocontables,List<Retencion> retencions,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("AsientoContable-saveRelacionesWithConnection");}
	
			asientocontable.setSris(sris);
			asientocontable.setImportarExportars(importarexportars);
			asientocontable.setDetalleMoviClienProves(detallemoviclienproves);
			asientocontable.setPrestamos(prestamos);
			asientocontable.setDetalleAsientoContables(detalleasientocontables);
			asientocontable.setRetencions(retencions);

			this.setAsientoContable(asientocontable);

			if(AsientoContableLogicAdditional.validarSaveRelaciones(asientocontable,this)) {

				AsientoContableLogicAdditional.updateRelacionesToSave(asientocontable,this);

				if((asientocontable.getIsNew()||asientocontable.getIsChanged())&&!asientocontable.getIsDeleted()) {
					this.saveAsientoContable();
					this.saveAsientoContableRelacionesDetalles(sris,importarexportars,detallemoviclienproves,prestamos,detalleasientocontables,retencions);

				} else if(asientocontable.getIsDeleted()) {
					this.saveAsientoContableRelacionesDetalles(sris,importarexportars,detallemoviclienproves,prestamos,detalleasientocontables,retencions);
					this.saveAsientoContable();
				}

				AsientoContableLogicAdditional.updateRelacionesToSaveAfter(asientocontable,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			SriConstantesFunciones.InicializarGeneralEntityAuxiliaresSris(sris,true,true);
			ImportarExportarConstantesFunciones.InicializarGeneralEntityAuxiliaresImportarExportars(importarexportars,true,true);
			DetalleMoviClienProveConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleMoviClienProves(detallemoviclienproves,true,true);
			PrestamoConstantesFunciones.InicializarGeneralEntityAuxiliaresPrestamos(prestamos,true,true);
			DetalleAsientoContableConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleAsientoContables(detalleasientocontables,true,true);
			RetencionConstantesFunciones.InicializarGeneralEntityAuxiliaresRetencions(retencions,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveAsientoContableRelacionesDetalles(List<Sri> sris,List<ImportarExportar> importarexportars,List<DetalleMoviClienProve> detallemoviclienproves,List<Prestamo> prestamos,List<DetalleAsientoContable> detalleasientocontables,List<Retencion> retencions)throws Exception {
		try {
	

			Long idAsientoContableActual=this.getAsientoContable().getId();

			SriLogic sriLogic_Desde_AsientoContable=new SriLogic();
			sriLogic_Desde_AsientoContable.setSris(sris);

			sriLogic_Desde_AsientoContable.setConnexion(this.getConnexion());
			sriLogic_Desde_AsientoContable.setDatosCliente(this.datosCliente);

			for(Sri sri_Desde_AsientoContable:sriLogic_Desde_AsientoContable.getSris()) {
				sri_Desde_AsientoContable.setid_asiento_contable(idAsientoContableActual);
			}

			sriLogic_Desde_AsientoContable.saveSris();

			ImportarExportarLogic importarexportarLogic_Desde_AsientoContable=new ImportarExportarLogic();
			importarexportarLogic_Desde_AsientoContable.setImportarExportars(importarexportars);

			importarexportarLogic_Desde_AsientoContable.setConnexion(this.getConnexion());
			importarexportarLogic_Desde_AsientoContable.setDatosCliente(this.datosCliente);

			for(ImportarExportar importarexportar_Desde_AsientoContable:importarexportarLogic_Desde_AsientoContable.getImportarExportars()) {
				importarexportar_Desde_AsientoContable.setid_asiento_contable(idAsientoContableActual);
			}

			importarexportarLogic_Desde_AsientoContable.saveImportarExportars();

			DetalleMoviClienProveLogic detallemoviclienproveLogic_Desde_AsientoContable=new DetalleMoviClienProveLogic();
			detallemoviclienproveLogic_Desde_AsientoContable.setDetalleMoviClienProves(detallemoviclienproves);

			detallemoviclienproveLogic_Desde_AsientoContable.setConnexion(this.getConnexion());
			detallemoviclienproveLogic_Desde_AsientoContable.setDatosCliente(this.datosCliente);

			for(DetalleMoviClienProve detallemoviclienprove_Desde_AsientoContable:detallemoviclienproveLogic_Desde_AsientoContable.getDetalleMoviClienProves()) {
				detallemoviclienprove_Desde_AsientoContable.setid_asiento_contable(idAsientoContableActual);
			}

			detallemoviclienproveLogic_Desde_AsientoContable.saveDetalleMoviClienProves();

			PrestamoLogic prestamoLogic_Desde_AsientoContable=new PrestamoLogic();
			prestamoLogic_Desde_AsientoContable.setPrestamos(prestamos);

			prestamoLogic_Desde_AsientoContable.setConnexion(this.getConnexion());
			prestamoLogic_Desde_AsientoContable.setDatosCliente(this.datosCliente);

			for(Prestamo prestamo_Desde_AsientoContable:prestamoLogic_Desde_AsientoContable.getPrestamos()) {
				prestamo_Desde_AsientoContable.setid_asiento_contable(idAsientoContableActual);

				prestamoLogic_Desde_AsientoContable.setPrestamo(prestamo_Desde_AsientoContable);
				prestamoLogic_Desde_AsientoContable.savePrestamo();

				Long idPrestamoActual=prestamo_Desde_AsientoContable.getId();

				AbonoPrestamoLogic abonoprestamoLogic_Desde_Prestamo=new AbonoPrestamoLogic();

				if(prestamo_Desde_AsientoContable.getAbonoPrestamos()==null){
					prestamo_Desde_AsientoContable.setAbonoPrestamos(new ArrayList<AbonoPrestamo>());
				}

				abonoprestamoLogic_Desde_Prestamo.setAbonoPrestamos(prestamo_Desde_AsientoContable.getAbonoPrestamos());

				abonoprestamoLogic_Desde_Prestamo.setConnexion(this.getConnexion());
				abonoprestamoLogic_Desde_Prestamo.setDatosCliente(this.datosCliente);

				for(AbonoPrestamo abonoprestamo_Desde_Prestamo:abonoprestamoLogic_Desde_Prestamo.getAbonoPrestamos()) {
					abonoprestamo_Desde_Prestamo.setid_prestamo(idPrestamoActual);
				}

				abonoprestamoLogic_Desde_Prestamo.saveAbonoPrestamos();

				CuotaLogic cuotaLogic_Desde_Prestamo=new CuotaLogic();

				if(prestamo_Desde_AsientoContable.getCuotas()==null){
					prestamo_Desde_AsientoContable.setCuotas(new ArrayList<Cuota>());
				}

				cuotaLogic_Desde_Prestamo.setCuotas(prestamo_Desde_AsientoContable.getCuotas());

				cuotaLogic_Desde_Prestamo.setConnexion(this.getConnexion());
				cuotaLogic_Desde_Prestamo.setDatosCliente(this.datosCliente);

				for(Cuota cuota_Desde_Prestamo:cuotaLogic_Desde_Prestamo.getCuotas()) {
					cuota_Desde_Prestamo.setid_prestamo(idPrestamoActual);
				}

				cuotaLogic_Desde_Prestamo.saveCuotas();
			}


			DetalleAsientoContableLogic detalleasientocontableLogic_Desde_AsientoContable=new DetalleAsientoContableLogic();
			detalleasientocontableLogic_Desde_AsientoContable.setDetalleAsientoContables(detalleasientocontables);

			detalleasientocontableLogic_Desde_AsientoContable.setConnexion(this.getConnexion());
			detalleasientocontableLogic_Desde_AsientoContable.setDatosCliente(this.datosCliente);

			for(DetalleAsientoContable detalleasientocontable_Desde_AsientoContable:detalleasientocontableLogic_Desde_AsientoContable.getDetalleAsientoContables()) {
				detalleasientocontable_Desde_AsientoContable.setid_asiento_contable(idAsientoContableActual);
			}

			detalleasientocontableLogic_Desde_AsientoContable.saveDetalleAsientoContables();

			RetencionLogic retencionLogic_Desde_AsientoContable=new RetencionLogic();
			retencionLogic_Desde_AsientoContable.setRetencions(retencions);

			retencionLogic_Desde_AsientoContable.setConnexion(this.getConnexion());
			retencionLogic_Desde_AsientoContable.setDatosCliente(this.datosCliente);

			for(Retencion retencion_Desde_AsientoContable:retencionLogic_Desde_AsientoContable.getRetencions()) {
				retencion_Desde_AsientoContable.setid_asiento_contable(idAsientoContableActual);
			}

			retencionLogic_Desde_AsientoContable.saveRetencions();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfAsientoContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AsientoContableConstantesFunciones.getClassesForeignKeysOfAsientoContable(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAsientoContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AsientoContableConstantesFunciones.getClassesRelationshipsOfAsientoContable(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

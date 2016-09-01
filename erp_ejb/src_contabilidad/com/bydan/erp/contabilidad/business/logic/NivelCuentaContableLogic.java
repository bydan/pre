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
import com.bydan.erp.contabilidad.util.NivelCuentaContableConstantesFunciones;
import com.bydan.erp.contabilidad.util.NivelCuentaContableParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.NivelCuentaContableParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.NivelCuentaContable;
import com.bydan.erp.contabilidad.business.logic.NivelCuentaContableLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class NivelCuentaContableLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(NivelCuentaContableLogic.class);
	
	protected NivelCuentaContableDataAccess nivelcuentacontableDataAccess; 	
	protected NivelCuentaContable nivelcuentacontable;
	protected List<NivelCuentaContable> nivelcuentacontables;
	protected Object nivelcuentacontableObject;	
	protected List<Object> nivelcuentacontablesObject;
	
	public static ClassValidator<NivelCuentaContable> nivelcuentacontableValidator = new ClassValidator<NivelCuentaContable>(NivelCuentaContable.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected NivelCuentaContableLogicAdditional nivelcuentacontableLogicAdditional=null;
	
	public NivelCuentaContableLogicAdditional getNivelCuentaContableLogicAdditional() {
		return this.nivelcuentacontableLogicAdditional;
	}
	
	public void setNivelCuentaContableLogicAdditional(NivelCuentaContableLogicAdditional nivelcuentacontableLogicAdditional) {
		try {
			this.nivelcuentacontableLogicAdditional=nivelcuentacontableLogicAdditional;
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
	
	
	
	
	public  NivelCuentaContableLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.nivelcuentacontableDataAccess = new NivelCuentaContableDataAccess();
			
			this.nivelcuentacontables= new ArrayList<NivelCuentaContable>();
			this.nivelcuentacontable= new NivelCuentaContable();
			
			this.nivelcuentacontableObject=new Object();
			this.nivelcuentacontablesObject=new ArrayList<Object>();
				
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
			
			this.nivelcuentacontableDataAccess.setConnexionType(this.connexionType);
			this.nivelcuentacontableDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  NivelCuentaContableLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.nivelcuentacontableDataAccess = new NivelCuentaContableDataAccess();
			this.nivelcuentacontables= new ArrayList<NivelCuentaContable>();
			this.nivelcuentacontable= new NivelCuentaContable();
			this.nivelcuentacontableObject=new Object();
			this.nivelcuentacontablesObject=new ArrayList<Object>();
			
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
			
			this.nivelcuentacontableDataAccess.setConnexionType(this.connexionType);
			this.nivelcuentacontableDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public NivelCuentaContable getNivelCuentaContable() throws Exception {	
		NivelCuentaContableLogicAdditional.checkNivelCuentaContableToGet(nivelcuentacontable,this.datosCliente,this.arrDatoGeneral);
		NivelCuentaContableLogicAdditional.updateNivelCuentaContableToGet(nivelcuentacontable,this.arrDatoGeneral);
		
		return nivelcuentacontable;
	}
		
	public void setNivelCuentaContable(NivelCuentaContable newNivelCuentaContable) {
		this.nivelcuentacontable = newNivelCuentaContable;
	}
	
	public NivelCuentaContableDataAccess getNivelCuentaContableDataAccess() {
		return nivelcuentacontableDataAccess;
	}
	
	public void setNivelCuentaContableDataAccess(NivelCuentaContableDataAccess newnivelcuentacontableDataAccess) {
		this.nivelcuentacontableDataAccess = newnivelcuentacontableDataAccess;
	}
	
	public List<NivelCuentaContable> getNivelCuentaContables() throws Exception {		
		this.quitarNivelCuentaContablesNulos();
		
		NivelCuentaContableLogicAdditional.checkNivelCuentaContableToGets(nivelcuentacontables,this.datosCliente,this.arrDatoGeneral);
		
		for (NivelCuentaContable nivelcuentacontableLocal: nivelcuentacontables ) {
			NivelCuentaContableLogicAdditional.updateNivelCuentaContableToGet(nivelcuentacontableLocal,this.arrDatoGeneral);
		}
		
		return nivelcuentacontables;
	}
	
	public void setNivelCuentaContables(List<NivelCuentaContable> newNivelCuentaContables) {
		this.nivelcuentacontables = newNivelCuentaContables;
	}
	
	public Object getNivelCuentaContableObject() {	
		this.nivelcuentacontableObject=this.nivelcuentacontableDataAccess.getEntityObject();
		return this.nivelcuentacontableObject;
	}
		
	public void setNivelCuentaContableObject(Object newNivelCuentaContableObject) {
		this.nivelcuentacontableObject = newNivelCuentaContableObject;
	}
	
	public List<Object> getNivelCuentaContablesObject() {		
		this.nivelcuentacontablesObject=this.nivelcuentacontableDataAccess.getEntitiesObject();
		return this.nivelcuentacontablesObject;
	}
		
	public void setNivelCuentaContablesObject(List<Object> newNivelCuentaContablesObject) {
		this.nivelcuentacontablesObject = newNivelCuentaContablesObject;
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
		
		if(this.nivelcuentacontableDataAccess!=null) {
			this.nivelcuentacontableDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuentaContable.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			nivelcuentacontableDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			nivelcuentacontableDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		nivelcuentacontable = new  NivelCuentaContable();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuentaContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			nivelcuentacontable=nivelcuentacontableDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.nivelcuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NivelCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuentaContable(this.nivelcuentacontable);
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
		nivelcuentacontable = new  NivelCuentaContable();
		  		  
        try {
			
			nivelcuentacontable=nivelcuentacontableDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.nivelcuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NivelCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuentaContable(this.nivelcuentacontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		nivelcuentacontable = new  NivelCuentaContable();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuentaContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			nivelcuentacontable=nivelcuentacontableDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.nivelcuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NivelCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuentaContable(this.nivelcuentacontable);
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
		nivelcuentacontable = new  NivelCuentaContable();
		  		  
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
		nivelcuentacontable = new  NivelCuentaContable();
		  		  
        try {
			
			nivelcuentacontable=nivelcuentacontableDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.nivelcuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NivelCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuentaContable(this.nivelcuentacontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		nivelcuentacontable = new  NivelCuentaContable();
		  		  
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
		nivelcuentacontable = new  NivelCuentaContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuentaContable.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =nivelcuentacontableDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		nivelcuentacontable = new  NivelCuentaContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=nivelcuentacontableDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		nivelcuentacontable = new  NivelCuentaContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuentaContable.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =nivelcuentacontableDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		nivelcuentacontable = new  NivelCuentaContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=nivelcuentacontableDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		nivelcuentacontable = new  NivelCuentaContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuentaContable.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =nivelcuentacontableDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		nivelcuentacontable = new  NivelCuentaContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=nivelcuentacontableDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		nivelcuentacontables = new  ArrayList<NivelCuentaContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuentaContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			NivelCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuentacontables=nivelcuentacontableDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNivelCuentaContable(nivelcuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuentaContable(this.nivelcuentacontables);
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
		nivelcuentacontables = new  ArrayList<NivelCuentaContable>();
		  		  
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
		nivelcuentacontables = new  ArrayList<NivelCuentaContable>();
		  		  
        try {			
			NivelCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuentacontables=nivelcuentacontableDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarNivelCuentaContable(nivelcuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuentaContable(this.nivelcuentacontables);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		nivelcuentacontables = new  ArrayList<NivelCuentaContable>();
		  		  
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
		nivelcuentacontables = new  ArrayList<NivelCuentaContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuentaContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			NivelCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuentacontables=nivelcuentacontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNivelCuentaContable(nivelcuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuentaContable(this.nivelcuentacontables);
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
		nivelcuentacontables = new  ArrayList<NivelCuentaContable>();
		  		  
        try {
			NivelCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuentacontables=nivelcuentacontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNivelCuentaContable(nivelcuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuentaContable(this.nivelcuentacontables);
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
		nivelcuentacontables = new  ArrayList<NivelCuentaContable>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuentaContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuentacontables=nivelcuentacontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNivelCuentaContable(nivelcuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuentaContable(this.nivelcuentacontables);
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
		nivelcuentacontables = new  ArrayList<NivelCuentaContable>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuentacontables=nivelcuentacontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNivelCuentaContable(nivelcuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuentaContable(this.nivelcuentacontables);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		nivelcuentacontable = new  NivelCuentaContable();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuentaContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuentacontable=nivelcuentacontableDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNivelCuentaContable(nivelcuentacontable);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuentaContable(this.nivelcuentacontable);
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
		nivelcuentacontable = new  NivelCuentaContable();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuentacontable=nivelcuentacontableDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNivelCuentaContable(nivelcuentacontable);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuentaContable(this.nivelcuentacontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		nivelcuentacontables = new  ArrayList<NivelCuentaContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuentaContable.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			NivelCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuentacontables=nivelcuentacontableDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNivelCuentaContable(nivelcuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuentaContable(this.nivelcuentacontables);
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
		nivelcuentacontables = new  ArrayList<NivelCuentaContable>();
		  		  
        try {
			NivelCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuentacontables=nivelcuentacontableDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNivelCuentaContable(nivelcuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuentaContable(this.nivelcuentacontables);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosNivelCuentaContablesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		nivelcuentacontables = new  ArrayList<NivelCuentaContable>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuentaContable.class.getSimpleName()+"-getTodosNivelCuentaContablesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuentacontables=nivelcuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNivelCuentaContable(nivelcuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuentaContable(this.nivelcuentacontables);
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
	
	public  void  getTodosNivelCuentaContables(String sFinalQuery,Pagination pagination)throws Exception {
		nivelcuentacontables = new  ArrayList<NivelCuentaContable>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuentacontables=nivelcuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNivelCuentaContable(nivelcuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuentaContable(this.nivelcuentacontables);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarNivelCuentaContable(NivelCuentaContable nivelcuentacontable) throws Exception {
		Boolean estaValidado=false;
		
		if(nivelcuentacontable.getIsNew() || nivelcuentacontable.getIsChanged()) { 
			this.invalidValues = nivelcuentacontableValidator.getInvalidValues(nivelcuentacontable);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(nivelcuentacontable);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarNivelCuentaContable(List<NivelCuentaContable> NivelCuentaContables) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(NivelCuentaContable nivelcuentacontableLocal:nivelcuentacontables) {				
			estaValidadoObjeto=this.validarGuardarNivelCuentaContable(nivelcuentacontableLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarNivelCuentaContable(List<NivelCuentaContable> NivelCuentaContables) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNivelCuentaContable(nivelcuentacontables)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarNivelCuentaContable(NivelCuentaContable NivelCuentaContable) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNivelCuentaContable(nivelcuentacontable)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(NivelCuentaContable nivelcuentacontable) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+nivelcuentacontable.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=NivelCuentaContableConstantesFunciones.getNivelCuentaContableLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"nivelcuentacontable","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(NivelCuentaContableConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(NivelCuentaContableConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveNivelCuentaContableWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuentaContable.class.getSimpleName()+"-saveNivelCuentaContableWithConnection");connexion.begin();			
			
			NivelCuentaContableLogicAdditional.checkNivelCuentaContableToSave(this.nivelcuentacontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NivelCuentaContableLogicAdditional.updateNivelCuentaContableToSave(this.nivelcuentacontable,this.arrDatoGeneral);
			
			NivelCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.nivelcuentacontable,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowNivelCuentaContable();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNivelCuentaContable(this.nivelcuentacontable)) {
				NivelCuentaContableDataAccess.save(this.nivelcuentacontable, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.nivelcuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NivelCuentaContableLogicAdditional.checkNivelCuentaContableToSaveAfter(this.nivelcuentacontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNivelCuentaContable();
			
			connexion.commit();			
			
			if(this.nivelcuentacontable.getIsDeleted()) {
				this.nivelcuentacontable=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveNivelCuentaContable()throws Exception {	
		try {	
			
			NivelCuentaContableLogicAdditional.checkNivelCuentaContableToSave(this.nivelcuentacontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NivelCuentaContableLogicAdditional.updateNivelCuentaContableToSave(this.nivelcuentacontable,this.arrDatoGeneral);
			
			NivelCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.nivelcuentacontable,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNivelCuentaContable(this.nivelcuentacontable)) {			
				NivelCuentaContableDataAccess.save(this.nivelcuentacontable, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.nivelcuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NivelCuentaContableLogicAdditional.checkNivelCuentaContableToSaveAfter(this.nivelcuentacontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.nivelcuentacontable.getIsDeleted()) {
				this.nivelcuentacontable=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveNivelCuentaContablesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuentaContable.class.getSimpleName()+"-saveNivelCuentaContablesWithConnection");connexion.begin();			
			
			NivelCuentaContableLogicAdditional.checkNivelCuentaContableToSaves(nivelcuentacontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowNivelCuentaContables();
			
			Boolean validadoTodosNivelCuentaContable=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NivelCuentaContable nivelcuentacontableLocal:nivelcuentacontables) {		
				if(nivelcuentacontableLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NivelCuentaContableLogicAdditional.updateNivelCuentaContableToSave(nivelcuentacontableLocal,this.arrDatoGeneral);
	        	
				NivelCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),nivelcuentacontableLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNivelCuentaContable(nivelcuentacontableLocal)) {
					NivelCuentaContableDataAccess.save(nivelcuentacontableLocal, connexion);				
				} else {
					validadoTodosNivelCuentaContable=false;
				}
			}
			
			if(!validadoTodosNivelCuentaContable) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NivelCuentaContableLogicAdditional.checkNivelCuentaContableToSavesAfter(nivelcuentacontables,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNivelCuentaContables();
			
			connexion.commit();		
			
			this.quitarNivelCuentaContablesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveNivelCuentaContables()throws Exception {				
		 try {	
			NivelCuentaContableLogicAdditional.checkNivelCuentaContableToSaves(nivelcuentacontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosNivelCuentaContable=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NivelCuentaContable nivelcuentacontableLocal:nivelcuentacontables) {				
				if(nivelcuentacontableLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NivelCuentaContableLogicAdditional.updateNivelCuentaContableToSave(nivelcuentacontableLocal,this.arrDatoGeneral);
	        	
				NivelCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),nivelcuentacontableLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNivelCuentaContable(nivelcuentacontableLocal)) {				
					NivelCuentaContableDataAccess.save(nivelcuentacontableLocal, connexion);				
				} else {
					validadoTodosNivelCuentaContable=false;
				}
			}
			
			if(!validadoTodosNivelCuentaContable) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NivelCuentaContableLogicAdditional.checkNivelCuentaContableToSavesAfter(nivelcuentacontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarNivelCuentaContablesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NivelCuentaContableParameterReturnGeneral procesarAccionNivelCuentaContables(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NivelCuentaContable> nivelcuentacontables,NivelCuentaContableParameterReturnGeneral nivelcuentacontableParameterGeneral)throws Exception {
		 try {	
			NivelCuentaContableParameterReturnGeneral nivelcuentacontableReturnGeneral=new NivelCuentaContableParameterReturnGeneral();
	
			NivelCuentaContableLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,nivelcuentacontables,nivelcuentacontableParameterGeneral,nivelcuentacontableReturnGeneral);
			
			return nivelcuentacontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NivelCuentaContableParameterReturnGeneral procesarAccionNivelCuentaContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NivelCuentaContable> nivelcuentacontables,NivelCuentaContableParameterReturnGeneral nivelcuentacontableParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuentaContable.class.getSimpleName()+"-procesarAccionNivelCuentaContablesWithConnection");connexion.begin();			
			
			NivelCuentaContableParameterReturnGeneral nivelcuentacontableReturnGeneral=new NivelCuentaContableParameterReturnGeneral();
	
			NivelCuentaContableLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,nivelcuentacontables,nivelcuentacontableParameterGeneral,nivelcuentacontableReturnGeneral);
			
			this.connexion.commit();
			
			return nivelcuentacontableReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NivelCuentaContableParameterReturnGeneral procesarEventosNivelCuentaContables(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NivelCuentaContable> nivelcuentacontables,NivelCuentaContable nivelcuentacontable,NivelCuentaContableParameterReturnGeneral nivelcuentacontableParameterGeneral,Boolean isEsNuevoNivelCuentaContable,ArrayList<Classe> clases)throws Exception {
		 try {	
			NivelCuentaContableParameterReturnGeneral nivelcuentacontableReturnGeneral=new NivelCuentaContableParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				nivelcuentacontableReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NivelCuentaContableLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,nivelcuentacontables,nivelcuentacontable,nivelcuentacontableParameterGeneral,nivelcuentacontableReturnGeneral,isEsNuevoNivelCuentaContable,clases);
			
			return nivelcuentacontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public NivelCuentaContableParameterReturnGeneral procesarEventosNivelCuentaContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NivelCuentaContable> nivelcuentacontables,NivelCuentaContable nivelcuentacontable,NivelCuentaContableParameterReturnGeneral nivelcuentacontableParameterGeneral,Boolean isEsNuevoNivelCuentaContable,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuentaContable.class.getSimpleName()+"-procesarEventosNivelCuentaContablesWithConnection");connexion.begin();			
			
			NivelCuentaContableParameterReturnGeneral nivelcuentacontableReturnGeneral=new NivelCuentaContableParameterReturnGeneral();
	
			nivelcuentacontableReturnGeneral.setNivelCuentaContable(nivelcuentacontable);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				nivelcuentacontableReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NivelCuentaContableLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,nivelcuentacontables,nivelcuentacontable,nivelcuentacontableParameterGeneral,nivelcuentacontableReturnGeneral,isEsNuevoNivelCuentaContable,clases);
			
			this.connexion.commit();
			
			return nivelcuentacontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NivelCuentaContableParameterReturnGeneral procesarImportacionNivelCuentaContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,NivelCuentaContableParameterReturnGeneral nivelcuentacontableParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuentaContable.class.getSimpleName()+"-procesarImportacionNivelCuentaContablesWithConnection");connexion.begin();			
			
			NivelCuentaContableParameterReturnGeneral nivelcuentacontableReturnGeneral=new NivelCuentaContableParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.nivelcuentacontables=new ArrayList<NivelCuentaContable>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.nivelcuentacontable=new NivelCuentaContable();
				
				
				if(conColumnasBase) {this.nivelcuentacontable.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.nivelcuentacontable.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.nivelcuentacontable.setnivel(Integer.parseInt(arrColumnas[iColumn++]));
				this.nivelcuentacontable.setnumero_digitos(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.nivelcuentacontables.add(this.nivelcuentacontable);
			}
			
			this.saveNivelCuentaContables();
			
			this.connexion.commit();
			
			nivelcuentacontableReturnGeneral.setConRetornoEstaProcesado(true);
			nivelcuentacontableReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return nivelcuentacontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarNivelCuentaContablesEliminados() throws Exception {				
		
		List<NivelCuentaContable> nivelcuentacontablesAux= new ArrayList<NivelCuentaContable>();
		
		for(NivelCuentaContable nivelcuentacontable:nivelcuentacontables) {
			if(!nivelcuentacontable.getIsDeleted()) {
				nivelcuentacontablesAux.add(nivelcuentacontable);
			}
		}
		
		nivelcuentacontables=nivelcuentacontablesAux;
	}
	
	public void quitarNivelCuentaContablesNulos() throws Exception {				
		
		List<NivelCuentaContable> nivelcuentacontablesAux= new ArrayList<NivelCuentaContable>();
		
		for(NivelCuentaContable nivelcuentacontable : this.nivelcuentacontables) {
			if(nivelcuentacontable==null) {
				nivelcuentacontablesAux.add(nivelcuentacontable);
			}
		}
		
		//this.nivelcuentacontables=nivelcuentacontablesAux;
		
		this.nivelcuentacontables.removeAll(nivelcuentacontablesAux);
	}
	
	public void getSetVersionRowNivelCuentaContableWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(nivelcuentacontable.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((nivelcuentacontable.getIsDeleted() || (nivelcuentacontable.getIsChanged()&&!nivelcuentacontable.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=nivelcuentacontableDataAccess.getSetVersionRowNivelCuentaContable(connexion,nivelcuentacontable.getId());
				
				if(!nivelcuentacontable.getVersionRow().equals(timestamp)) {	
					nivelcuentacontable.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				nivelcuentacontable.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowNivelCuentaContable()throws Exception {	
		
		if(nivelcuentacontable.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((nivelcuentacontable.getIsDeleted() || (nivelcuentacontable.getIsChanged()&&!nivelcuentacontable.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=nivelcuentacontableDataAccess.getSetVersionRowNivelCuentaContable(connexion,nivelcuentacontable.getId());
			
			try {							
				if(!nivelcuentacontable.getVersionRow().equals(timestamp)) {	
					nivelcuentacontable.setVersionRow(timestamp);
				}
				
				nivelcuentacontable.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowNivelCuentaContablesWithConnection()throws Exception {	
		if(nivelcuentacontables!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(NivelCuentaContable nivelcuentacontableAux:nivelcuentacontables) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(nivelcuentacontableAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(nivelcuentacontableAux.getIsDeleted() || (nivelcuentacontableAux.getIsChanged()&&!nivelcuentacontableAux.getIsNew())) {
						
						timestamp=nivelcuentacontableDataAccess.getSetVersionRowNivelCuentaContable(connexion,nivelcuentacontableAux.getId());
						
						if(!nivelcuentacontable.getVersionRow().equals(timestamp)) {	
							nivelcuentacontableAux.setVersionRow(timestamp);
						}
								
						nivelcuentacontableAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowNivelCuentaContables()throws Exception {	
		if(nivelcuentacontables!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(NivelCuentaContable nivelcuentacontableAux:nivelcuentacontables) {
					if(nivelcuentacontableAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(nivelcuentacontableAux.getIsDeleted() || (nivelcuentacontableAux.getIsChanged()&&!nivelcuentacontableAux.getIsNew())) {
						
						timestamp=nivelcuentacontableDataAccess.getSetVersionRowNivelCuentaContable(connexion,nivelcuentacontableAux.getId());
						
						if(!nivelcuentacontableAux.getVersionRow().equals(timestamp)) {	
							nivelcuentacontableAux.setVersionRow(timestamp);
						}
						
													
						nivelcuentacontableAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public NivelCuentaContableParameterReturnGeneral cargarCombosLoteForeignKeyNivelCuentaContableWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		NivelCuentaContableParameterReturnGeneral  nivelcuentacontableReturnGeneral =new NivelCuentaContableParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuentaContable.class.getSimpleName()+"-cargarCombosLoteForeignKeyNivelCuentaContableWithConnection");connexion.begin();
			
			nivelcuentacontableReturnGeneral =new NivelCuentaContableParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			nivelcuentacontableReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return nivelcuentacontableReturnGeneral;
	}
	
	public NivelCuentaContableParameterReturnGeneral cargarCombosLoteForeignKeyNivelCuentaContable(String finalQueryGlobalEmpresa) throws Exception {
		NivelCuentaContableParameterReturnGeneral  nivelcuentacontableReturnGeneral =new NivelCuentaContableParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			nivelcuentacontableReturnGeneral =new NivelCuentaContableParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			nivelcuentacontableReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return nivelcuentacontableReturnGeneral;
	}
	
	
	public void deepLoad(NivelCuentaContable nivelcuentacontable,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			NivelCuentaContableLogicAdditional.updateNivelCuentaContableToGet(nivelcuentacontable,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		nivelcuentacontable.setEmpresa(nivelcuentacontableDataAccess.getEmpresa(connexion,nivelcuentacontable));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				nivelcuentacontable.setEmpresa(nivelcuentacontableDataAccess.getEmpresa(connexion,nivelcuentacontable));
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
			nivelcuentacontable.setEmpresa(nivelcuentacontableDataAccess.getEmpresa(connexion,nivelcuentacontable));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		nivelcuentacontable.setEmpresa(nivelcuentacontableDataAccess.getEmpresa(connexion,nivelcuentacontable));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(nivelcuentacontable.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				nivelcuentacontable.setEmpresa(nivelcuentacontableDataAccess.getEmpresa(connexion,nivelcuentacontable));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(nivelcuentacontable.getEmpresa(),isDeep,deepLoadType,clases);				
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
			nivelcuentacontable.setEmpresa(nivelcuentacontableDataAccess.getEmpresa(connexion,nivelcuentacontable));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(nivelcuentacontable.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(NivelCuentaContable nivelcuentacontable,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			NivelCuentaContableLogicAdditional.updateNivelCuentaContableToSave(nivelcuentacontable,this.arrDatoGeneral);
			
NivelCuentaContableDataAccess.save(nivelcuentacontable, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(nivelcuentacontable.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(nivelcuentacontable.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(nivelcuentacontable.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(nivelcuentacontable.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(nivelcuentacontable.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(nivelcuentacontable.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(NivelCuentaContable.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(nivelcuentacontable,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NivelCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuentaContable(nivelcuentacontable);
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
			this.deepLoad(this.nivelcuentacontable,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NivelCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuentaContable(this.nivelcuentacontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(NivelCuentaContable.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(nivelcuentacontables!=null) {
				for(NivelCuentaContable nivelcuentacontable:nivelcuentacontables) {
					this.deepLoad(nivelcuentacontable,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					NivelCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuentaContable(nivelcuentacontables);
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
			if(nivelcuentacontables!=null) {
				for(NivelCuentaContable nivelcuentacontable:nivelcuentacontables) {
					this.deepLoad(nivelcuentacontable,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					NivelCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuentaContable(nivelcuentacontables);
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
			this.getNewConnexionToDeep(NivelCuentaContable.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(nivelcuentacontable,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(NivelCuentaContable.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(nivelcuentacontables!=null) {
				for(NivelCuentaContable nivelcuentacontable:nivelcuentacontables) {
					this.deepSave(nivelcuentacontable,isDeep,deepLoadType,clases);
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
			if(nivelcuentacontables!=null) {
				for(NivelCuentaContable nivelcuentacontable:nivelcuentacontables) {
					this.deepSave(nivelcuentacontable,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getNivelCuentaContablesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,NivelCuentaContableConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			NivelCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			nivelcuentacontables=nivelcuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NivelCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuentaContable(this.nivelcuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNivelCuentaContablesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,NivelCuentaContableConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			NivelCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			nivelcuentacontables=nivelcuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				NivelCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuentaContable(this.nivelcuentacontables);
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
			if(NivelCuentaContableConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,NivelCuentaContableDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,NivelCuentaContable nivelcuentacontable,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(NivelCuentaContableConstantesFunciones.ISCONAUDITORIA) {
				if(nivelcuentacontable.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NivelCuentaContableDataAccess.TABLENAME, nivelcuentacontable.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NivelCuentaContableConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NivelCuentaContableLogic.registrarAuditoriaDetallesNivelCuentaContable(connexion,nivelcuentacontable,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(nivelcuentacontable.getIsDeleted()) {
					/*if(!nivelcuentacontable.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,NivelCuentaContableDataAccess.TABLENAME, nivelcuentacontable.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////NivelCuentaContableLogic.registrarAuditoriaDetallesNivelCuentaContable(connexion,nivelcuentacontable,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NivelCuentaContableDataAccess.TABLENAME, nivelcuentacontable.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(nivelcuentacontable.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NivelCuentaContableDataAccess.TABLENAME, nivelcuentacontable.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NivelCuentaContableConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NivelCuentaContableLogic.registrarAuditoriaDetallesNivelCuentaContable(connexion,nivelcuentacontable,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesNivelCuentaContable(Connexion connexion,NivelCuentaContable nivelcuentacontable)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(nivelcuentacontable.getIsNew()||!nivelcuentacontable.getid_empresa().equals(nivelcuentacontable.getNivelCuentaContableOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(nivelcuentacontable.getNivelCuentaContableOriginal().getid_empresa()!=null)
				{
					strValorActual=nivelcuentacontable.getNivelCuentaContableOriginal().getid_empresa().toString();
				}
				if(nivelcuentacontable.getid_empresa()!=null)
				{
					strValorNuevo=nivelcuentacontable.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NivelCuentaContableConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(nivelcuentacontable.getIsNew()||!nivelcuentacontable.getnivel().equals(nivelcuentacontable.getNivelCuentaContableOriginal().getnivel()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(nivelcuentacontable.getNivelCuentaContableOriginal().getnivel()!=null)
				{
					strValorActual=nivelcuentacontable.getNivelCuentaContableOriginal().getnivel().toString();
				}
				if(nivelcuentacontable.getnivel()!=null)
				{
					strValorNuevo=nivelcuentacontable.getnivel().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NivelCuentaContableConstantesFunciones.NIVEL,strValorActual,strValorNuevo);
			}	
			
			if(nivelcuentacontable.getIsNew()||!nivelcuentacontable.getnumero_digitos().equals(nivelcuentacontable.getNivelCuentaContableOriginal().getnumero_digitos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(nivelcuentacontable.getNivelCuentaContableOriginal().getnumero_digitos()!=null)
				{
					strValorActual=nivelcuentacontable.getNivelCuentaContableOriginal().getnumero_digitos().toString();
				}
				if(nivelcuentacontable.getnumero_digitos()!=null)
				{
					strValorNuevo=nivelcuentacontable.getnumero_digitos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NivelCuentaContableConstantesFunciones.NUMERODIGITOS,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveNivelCuentaContableRelacionesWithConnection(NivelCuentaContable nivelcuentacontable) throws Exception {

		if(!nivelcuentacontable.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNivelCuentaContableRelacionesBase(nivelcuentacontable,true);
		}
	}

	public void saveNivelCuentaContableRelaciones(NivelCuentaContable nivelcuentacontable)throws Exception {

		if(!nivelcuentacontable.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNivelCuentaContableRelacionesBase(nivelcuentacontable,false);
		}
	}

	public void saveNivelCuentaContableRelacionesBase(NivelCuentaContable nivelcuentacontable,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("NivelCuentaContable-saveRelacionesWithConnection");}
	

			this.setNivelCuentaContable(nivelcuentacontable);

			if(NivelCuentaContableLogicAdditional.validarSaveRelaciones(nivelcuentacontable,this)) {

				NivelCuentaContableLogicAdditional.updateRelacionesToSave(nivelcuentacontable,this);

				if((nivelcuentacontable.getIsNew()||nivelcuentacontable.getIsChanged())&&!nivelcuentacontable.getIsDeleted()) {
					this.saveNivelCuentaContable();
					this.saveNivelCuentaContableRelacionesDetalles();

				} else if(nivelcuentacontable.getIsDeleted()) {
					this.saveNivelCuentaContableRelacionesDetalles();
					this.saveNivelCuentaContable();
				}

				NivelCuentaContableLogicAdditional.updateRelacionesToSaveAfter(nivelcuentacontable,this);

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
	
	
	private void saveNivelCuentaContableRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfNivelCuentaContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NivelCuentaContableConstantesFunciones.getClassesForeignKeysOfNivelCuentaContable(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNivelCuentaContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NivelCuentaContableConstantesFunciones.getClassesRelationshipsOfNivelCuentaContable(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

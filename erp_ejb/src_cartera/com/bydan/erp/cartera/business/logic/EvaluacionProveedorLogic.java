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
package com.bydan.erp.cartera.business.logic;

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
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.cartera.util.EvaluacionProveedorConstantesFunciones;
import com.bydan.erp.cartera.util.EvaluacionProveedorParameterReturnGeneral;
//import com.bydan.erp.cartera.util.EvaluacionProveedorParameterGeneral;
import com.bydan.erp.cartera.business.entity.EvaluacionProveedor;
import com.bydan.erp.cartera.business.logic.EvaluacionProveedorLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class EvaluacionProveedorLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EvaluacionProveedorLogic.class);
	
	protected EvaluacionProveedorDataAccess evaluacionproveedorDataAccess; 	
	protected EvaluacionProveedor evaluacionproveedor;
	protected List<EvaluacionProveedor> evaluacionproveedors;
	protected Object evaluacionproveedorObject;	
	protected List<Object> evaluacionproveedorsObject;
	
	public static ClassValidator<EvaluacionProveedor> evaluacionproveedorValidator = new ClassValidator<EvaluacionProveedor>(EvaluacionProveedor.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EvaluacionProveedorLogicAdditional evaluacionproveedorLogicAdditional=null;
	
	public EvaluacionProveedorLogicAdditional getEvaluacionProveedorLogicAdditional() {
		return this.evaluacionproveedorLogicAdditional;
	}
	
	public void setEvaluacionProveedorLogicAdditional(EvaluacionProveedorLogicAdditional evaluacionproveedorLogicAdditional) {
		try {
			this.evaluacionproveedorLogicAdditional=evaluacionproveedorLogicAdditional;
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
	
	
	
	
	public  EvaluacionProveedorLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.evaluacionproveedorDataAccess = new EvaluacionProveedorDataAccess();
			
			this.evaluacionproveedors= new ArrayList<EvaluacionProveedor>();
			this.evaluacionproveedor= new EvaluacionProveedor();
			
			this.evaluacionproveedorObject=new Object();
			this.evaluacionproveedorsObject=new ArrayList<Object>();
				
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
			
			this.evaluacionproveedorDataAccess.setConnexionType(this.connexionType);
			this.evaluacionproveedorDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EvaluacionProveedorLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.evaluacionproveedorDataAccess = new EvaluacionProveedorDataAccess();
			this.evaluacionproveedors= new ArrayList<EvaluacionProveedor>();
			this.evaluacionproveedor= new EvaluacionProveedor();
			this.evaluacionproveedorObject=new Object();
			this.evaluacionproveedorsObject=new ArrayList<Object>();
			
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
			
			this.evaluacionproveedorDataAccess.setConnexionType(this.connexionType);
			this.evaluacionproveedorDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EvaluacionProveedor getEvaluacionProveedor() throws Exception {	
		EvaluacionProveedorLogicAdditional.checkEvaluacionProveedorToGet(evaluacionproveedor,this.datosCliente,this.arrDatoGeneral);
		EvaluacionProveedorLogicAdditional.updateEvaluacionProveedorToGet(evaluacionproveedor,this.arrDatoGeneral);
		
		return evaluacionproveedor;
	}
		
	public void setEvaluacionProveedor(EvaluacionProveedor newEvaluacionProveedor) {
		this.evaluacionproveedor = newEvaluacionProveedor;
	}
	
	public EvaluacionProveedorDataAccess getEvaluacionProveedorDataAccess() {
		return evaluacionproveedorDataAccess;
	}
	
	public void setEvaluacionProveedorDataAccess(EvaluacionProveedorDataAccess newevaluacionproveedorDataAccess) {
		this.evaluacionproveedorDataAccess = newevaluacionproveedorDataAccess;
	}
	
	public List<EvaluacionProveedor> getEvaluacionProveedors() throws Exception {		
		this.quitarEvaluacionProveedorsNulos();
		
		EvaluacionProveedorLogicAdditional.checkEvaluacionProveedorToGets(evaluacionproveedors,this.datosCliente,this.arrDatoGeneral);
		
		for (EvaluacionProveedor evaluacionproveedorLocal: evaluacionproveedors ) {
			EvaluacionProveedorLogicAdditional.updateEvaluacionProveedorToGet(evaluacionproveedorLocal,this.arrDatoGeneral);
		}
		
		return evaluacionproveedors;
	}
	
	public void setEvaluacionProveedors(List<EvaluacionProveedor> newEvaluacionProveedors) {
		this.evaluacionproveedors = newEvaluacionProveedors;
	}
	
	public Object getEvaluacionProveedorObject() {	
		this.evaluacionproveedorObject=this.evaluacionproveedorDataAccess.getEntityObject();
		return this.evaluacionproveedorObject;
	}
		
	public void setEvaluacionProveedorObject(Object newEvaluacionProveedorObject) {
		this.evaluacionproveedorObject = newEvaluacionProveedorObject;
	}
	
	public List<Object> getEvaluacionProveedorsObject() {		
		this.evaluacionproveedorsObject=this.evaluacionproveedorDataAccess.getEntitiesObject();
		return this.evaluacionproveedorsObject;
	}
		
	public void setEvaluacionProveedorsObject(List<Object> newEvaluacionProveedorsObject) {
		this.evaluacionproveedorsObject = newEvaluacionProveedorsObject;
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
		
		if(this.evaluacionproveedorDataAccess!=null) {
			this.evaluacionproveedorDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			evaluacionproveedorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			evaluacionproveedorDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		evaluacionproveedor = new  EvaluacionProveedor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			evaluacionproveedor=evaluacionproveedorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.evaluacionproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedor);
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
		evaluacionproveedor = new  EvaluacionProveedor();
		  		  
        try {
			
			evaluacionproveedor=evaluacionproveedorDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.evaluacionproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		evaluacionproveedor = new  EvaluacionProveedor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			evaluacionproveedor=evaluacionproveedorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.evaluacionproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedor);
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
		evaluacionproveedor = new  EvaluacionProveedor();
		  		  
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
		evaluacionproveedor = new  EvaluacionProveedor();
		  		  
        try {
			
			evaluacionproveedor=evaluacionproveedorDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.evaluacionproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		evaluacionproveedor = new  EvaluacionProveedor();
		  		  
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
		evaluacionproveedor = new  EvaluacionProveedor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =evaluacionproveedorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		evaluacionproveedor = new  EvaluacionProveedor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=evaluacionproveedorDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		evaluacionproveedor = new  EvaluacionProveedor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =evaluacionproveedorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		evaluacionproveedor = new  EvaluacionProveedor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=evaluacionproveedorDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		evaluacionproveedor = new  EvaluacionProveedor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =evaluacionproveedorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		evaluacionproveedor = new  EvaluacionProveedor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=evaluacionproveedorDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		evaluacionproveedors = new  ArrayList<EvaluacionProveedor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionproveedors=evaluacionproveedorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEvaluacionProveedor(evaluacionproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedors);
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
		evaluacionproveedors = new  ArrayList<EvaluacionProveedor>();
		  		  
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
		evaluacionproveedors = new  ArrayList<EvaluacionProveedor>();
		  		  
        try {			
			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionproveedors=evaluacionproveedorDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEvaluacionProveedor(evaluacionproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		evaluacionproveedors = new  ArrayList<EvaluacionProveedor>();
		  		  
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
		evaluacionproveedors = new  ArrayList<EvaluacionProveedor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionproveedors=evaluacionproveedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEvaluacionProveedor(evaluacionproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedors);
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
		evaluacionproveedors = new  ArrayList<EvaluacionProveedor>();
		  		  
        try {
			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionproveedors=evaluacionproveedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEvaluacionProveedor(evaluacionproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedors);
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
		evaluacionproveedors = new  ArrayList<EvaluacionProveedor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionproveedors=evaluacionproveedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEvaluacionProveedor(evaluacionproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedors);
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
		evaluacionproveedors = new  ArrayList<EvaluacionProveedor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionproveedors=evaluacionproveedorDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEvaluacionProveedor(evaluacionproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		evaluacionproveedor = new  EvaluacionProveedor();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionproveedor=evaluacionproveedorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEvaluacionProveedor(evaluacionproveedor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedor);
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
		evaluacionproveedor = new  EvaluacionProveedor();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionproveedor=evaluacionproveedorDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEvaluacionProveedor(evaluacionproveedor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		evaluacionproveedors = new  ArrayList<EvaluacionProveedor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionproveedors=evaluacionproveedorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEvaluacionProveedor(evaluacionproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedors);
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
		evaluacionproveedors = new  ArrayList<EvaluacionProveedor>();
		  		  
        try {
			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionproveedors=evaluacionproveedorDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEvaluacionProveedor(evaluacionproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEvaluacionProveedorsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		evaluacionproveedors = new  ArrayList<EvaluacionProveedor>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-getTodosEvaluacionProveedorsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionproveedors=evaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEvaluacionProveedor(evaluacionproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedors);
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
	
	public  void  getTodosEvaluacionProveedors(String sFinalQuery,Pagination pagination)throws Exception {
		evaluacionproveedors = new  ArrayList<EvaluacionProveedor>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			evaluacionproveedors=evaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEvaluacionProveedor(evaluacionproveedors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEvaluacionProveedor(EvaluacionProveedor evaluacionproveedor) throws Exception {
		Boolean estaValidado=false;
		
		if(evaluacionproveedor.getIsNew() || evaluacionproveedor.getIsChanged()) { 
			this.invalidValues = evaluacionproveedorValidator.getInvalidValues(evaluacionproveedor);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(evaluacionproveedor);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEvaluacionProveedor(List<EvaluacionProveedor> EvaluacionProveedors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EvaluacionProveedor evaluacionproveedorLocal:evaluacionproveedors) {				
			estaValidadoObjeto=this.validarGuardarEvaluacionProveedor(evaluacionproveedorLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEvaluacionProveedor(List<EvaluacionProveedor> EvaluacionProveedors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEvaluacionProveedor(evaluacionproveedors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEvaluacionProveedor(EvaluacionProveedor EvaluacionProveedor) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEvaluacionProveedor(evaluacionproveedor)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EvaluacionProveedor evaluacionproveedor) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+evaluacionproveedor.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EvaluacionProveedorConstantesFunciones.getEvaluacionProveedorLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"evaluacionproveedor","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EvaluacionProveedorConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EvaluacionProveedorConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEvaluacionProveedorWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-saveEvaluacionProveedorWithConnection");connexion.begin();			
			
			EvaluacionProveedorLogicAdditional.checkEvaluacionProveedorToSave(this.evaluacionproveedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EvaluacionProveedorLogicAdditional.updateEvaluacionProveedorToSave(this.evaluacionproveedor,this.arrDatoGeneral);
			
			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.evaluacionproveedor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEvaluacionProveedor();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEvaluacionProveedor(this.evaluacionproveedor)) {
				EvaluacionProveedorDataAccess.save(this.evaluacionproveedor, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.evaluacionproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EvaluacionProveedorLogicAdditional.checkEvaluacionProveedorToSaveAfter(this.evaluacionproveedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEvaluacionProveedor();
			
			connexion.commit();			
			
			if(this.evaluacionproveedor.getIsDeleted()) {
				this.evaluacionproveedor=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEvaluacionProveedor()throws Exception {	
		try {	
			
			EvaluacionProveedorLogicAdditional.checkEvaluacionProveedorToSave(this.evaluacionproveedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EvaluacionProveedorLogicAdditional.updateEvaluacionProveedorToSave(this.evaluacionproveedor,this.arrDatoGeneral);
			
			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.evaluacionproveedor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEvaluacionProveedor(this.evaluacionproveedor)) {			
				EvaluacionProveedorDataAccess.save(this.evaluacionproveedor, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.evaluacionproveedor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EvaluacionProveedorLogicAdditional.checkEvaluacionProveedorToSaveAfter(this.evaluacionproveedor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.evaluacionproveedor.getIsDeleted()) {
				this.evaluacionproveedor=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEvaluacionProveedorsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-saveEvaluacionProveedorsWithConnection");connexion.begin();			
			
			EvaluacionProveedorLogicAdditional.checkEvaluacionProveedorToSaves(evaluacionproveedors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEvaluacionProveedors();
			
			Boolean validadoTodosEvaluacionProveedor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EvaluacionProveedor evaluacionproveedorLocal:evaluacionproveedors) {		
				if(evaluacionproveedorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EvaluacionProveedorLogicAdditional.updateEvaluacionProveedorToSave(evaluacionproveedorLocal,this.arrDatoGeneral);
	        	
				EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),evaluacionproveedorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEvaluacionProveedor(evaluacionproveedorLocal)) {
					EvaluacionProveedorDataAccess.save(evaluacionproveedorLocal, connexion);				
				} else {
					validadoTodosEvaluacionProveedor=false;
				}
			}
			
			if(!validadoTodosEvaluacionProveedor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EvaluacionProveedorLogicAdditional.checkEvaluacionProveedorToSavesAfter(evaluacionproveedors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEvaluacionProveedors();
			
			connexion.commit();		
			
			this.quitarEvaluacionProveedorsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEvaluacionProveedors()throws Exception {				
		 try {	
			EvaluacionProveedorLogicAdditional.checkEvaluacionProveedorToSaves(evaluacionproveedors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEvaluacionProveedor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EvaluacionProveedor evaluacionproveedorLocal:evaluacionproveedors) {				
				if(evaluacionproveedorLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EvaluacionProveedorLogicAdditional.updateEvaluacionProveedorToSave(evaluacionproveedorLocal,this.arrDatoGeneral);
	        	
				EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),evaluacionproveedorLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEvaluacionProveedor(evaluacionproveedorLocal)) {				
					EvaluacionProveedorDataAccess.save(evaluacionproveedorLocal, connexion);				
				} else {
					validadoTodosEvaluacionProveedor=false;
				}
			}
			
			if(!validadoTodosEvaluacionProveedor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EvaluacionProveedorLogicAdditional.checkEvaluacionProveedorToSavesAfter(evaluacionproveedors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEvaluacionProveedorsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EvaluacionProveedorParameterReturnGeneral procesarAccionEvaluacionProveedors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EvaluacionProveedor> evaluacionproveedors,EvaluacionProveedorParameterReturnGeneral evaluacionproveedorParameterGeneral)throws Exception {
		 try {	
			EvaluacionProveedorParameterReturnGeneral evaluacionproveedorReturnGeneral=new EvaluacionProveedorParameterReturnGeneral();
	
			EvaluacionProveedorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,evaluacionproveedors,evaluacionproveedorParameterGeneral,evaluacionproveedorReturnGeneral);
			
			return evaluacionproveedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EvaluacionProveedorParameterReturnGeneral procesarAccionEvaluacionProveedorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EvaluacionProveedor> evaluacionproveedors,EvaluacionProveedorParameterReturnGeneral evaluacionproveedorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-procesarAccionEvaluacionProveedorsWithConnection");connexion.begin();			
			
			EvaluacionProveedorParameterReturnGeneral evaluacionproveedorReturnGeneral=new EvaluacionProveedorParameterReturnGeneral();
	
			EvaluacionProveedorLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,evaluacionproveedors,evaluacionproveedorParameterGeneral,evaluacionproveedorReturnGeneral);
			
			this.connexion.commit();
			
			return evaluacionproveedorReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EvaluacionProveedorParameterReturnGeneral procesarEventosEvaluacionProveedors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EvaluacionProveedor> evaluacionproveedors,EvaluacionProveedor evaluacionproveedor,EvaluacionProveedorParameterReturnGeneral evaluacionproveedorParameterGeneral,Boolean isEsNuevoEvaluacionProveedor,ArrayList<Classe> clases)throws Exception {
		 try {	
			EvaluacionProveedorParameterReturnGeneral evaluacionproveedorReturnGeneral=new EvaluacionProveedorParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				evaluacionproveedorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EvaluacionProveedorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,evaluacionproveedors,evaluacionproveedor,evaluacionproveedorParameterGeneral,evaluacionproveedorReturnGeneral,isEsNuevoEvaluacionProveedor,clases);
			
			return evaluacionproveedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EvaluacionProveedorParameterReturnGeneral procesarEventosEvaluacionProveedorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EvaluacionProveedor> evaluacionproveedors,EvaluacionProveedor evaluacionproveedor,EvaluacionProveedorParameterReturnGeneral evaluacionproveedorParameterGeneral,Boolean isEsNuevoEvaluacionProveedor,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-procesarEventosEvaluacionProveedorsWithConnection");connexion.begin();			
			
			EvaluacionProveedorParameterReturnGeneral evaluacionproveedorReturnGeneral=new EvaluacionProveedorParameterReturnGeneral();
	
			evaluacionproveedorReturnGeneral.setEvaluacionProveedor(evaluacionproveedor);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				evaluacionproveedorReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EvaluacionProveedorLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,evaluacionproveedors,evaluacionproveedor,evaluacionproveedorParameterGeneral,evaluacionproveedorReturnGeneral,isEsNuevoEvaluacionProveedor,clases);
			
			this.connexion.commit();
			
			return evaluacionproveedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EvaluacionProveedorParameterReturnGeneral procesarImportacionEvaluacionProveedorsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EvaluacionProveedorParameterReturnGeneral evaluacionproveedorParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-procesarImportacionEvaluacionProveedorsWithConnection");connexion.begin();			
			
			EvaluacionProveedorParameterReturnGeneral evaluacionproveedorReturnGeneral=new EvaluacionProveedorParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.evaluacionproveedors=new ArrayList<EvaluacionProveedor>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.evaluacionproveedor=new EvaluacionProveedor();
				
				
				if(conColumnasBase) {this.evaluacionproveedor.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.evaluacionproveedor.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.evaluacionproveedor.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.evaluacionproveedor.setcontacto(arrColumnas[iColumn++]);
				this.evaluacionproveedor.setevaluado(arrColumnas[iColumn++]);
				this.evaluacionproveedor.setresultado(arrColumnas[iColumn++]);
			this.evaluacionproveedor.setresponsable(arrColumnas[iColumn++]);
				this.evaluacionproveedor.setfecha_desde(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.evaluacionproveedor.setfecha_hasta(Funciones.ConvertToDate(arrColumnas[iColumn++]));
			this.evaluacionproveedor.setobservacion(arrColumnas[iColumn++]);
				
				this.evaluacionproveedors.add(this.evaluacionproveedor);
			}
			
			this.saveEvaluacionProveedors();
			
			this.connexion.commit();
			
			evaluacionproveedorReturnGeneral.setConRetornoEstaProcesado(true);
			evaluacionproveedorReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return evaluacionproveedorReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEvaluacionProveedorsEliminados() throws Exception {				
		
		List<EvaluacionProveedor> evaluacionproveedorsAux= new ArrayList<EvaluacionProveedor>();
		
		for(EvaluacionProveedor evaluacionproveedor:evaluacionproveedors) {
			if(!evaluacionproveedor.getIsDeleted()) {
				evaluacionproveedorsAux.add(evaluacionproveedor);
			}
		}
		
		evaluacionproveedors=evaluacionproveedorsAux;
	}
	
	public void quitarEvaluacionProveedorsNulos() throws Exception {				
		
		List<EvaluacionProveedor> evaluacionproveedorsAux= new ArrayList<EvaluacionProveedor>();
		
		for(EvaluacionProveedor evaluacionproveedor : this.evaluacionproveedors) {
			if(evaluacionproveedor==null) {
				evaluacionproveedorsAux.add(evaluacionproveedor);
			}
		}
		
		//this.evaluacionproveedors=evaluacionproveedorsAux;
		
		this.evaluacionproveedors.removeAll(evaluacionproveedorsAux);
	}
	
	public void getSetVersionRowEvaluacionProveedorWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(evaluacionproveedor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((evaluacionproveedor.getIsDeleted() || (evaluacionproveedor.getIsChanged()&&!evaluacionproveedor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=evaluacionproveedorDataAccess.getSetVersionRowEvaluacionProveedor(connexion,evaluacionproveedor.getId());
				
				if(!evaluacionproveedor.getVersionRow().equals(timestamp)) {	
					evaluacionproveedor.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				evaluacionproveedor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEvaluacionProveedor()throws Exception {	
		
		if(evaluacionproveedor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((evaluacionproveedor.getIsDeleted() || (evaluacionproveedor.getIsChanged()&&!evaluacionproveedor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=evaluacionproveedorDataAccess.getSetVersionRowEvaluacionProveedor(connexion,evaluacionproveedor.getId());
			
			try {							
				if(!evaluacionproveedor.getVersionRow().equals(timestamp)) {	
					evaluacionproveedor.setVersionRow(timestamp);
				}
				
				evaluacionproveedor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEvaluacionProveedorsWithConnection()throws Exception {	
		if(evaluacionproveedors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EvaluacionProveedor evaluacionproveedorAux:evaluacionproveedors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(evaluacionproveedorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(evaluacionproveedorAux.getIsDeleted() || (evaluacionproveedorAux.getIsChanged()&&!evaluacionproveedorAux.getIsNew())) {
						
						timestamp=evaluacionproveedorDataAccess.getSetVersionRowEvaluacionProveedor(connexion,evaluacionproveedorAux.getId());
						
						if(!evaluacionproveedor.getVersionRow().equals(timestamp)) {	
							evaluacionproveedorAux.setVersionRow(timestamp);
						}
								
						evaluacionproveedorAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEvaluacionProveedors()throws Exception {	
		if(evaluacionproveedors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EvaluacionProveedor evaluacionproveedorAux:evaluacionproveedors) {
					if(evaluacionproveedorAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(evaluacionproveedorAux.getIsDeleted() || (evaluacionproveedorAux.getIsChanged()&&!evaluacionproveedorAux.getIsNew())) {
						
						timestamp=evaluacionproveedorDataAccess.getSetVersionRowEvaluacionProveedor(connexion,evaluacionproveedorAux.getId());
						
						if(!evaluacionproveedorAux.getVersionRow().equals(timestamp)) {	
							evaluacionproveedorAux.setVersionRow(timestamp);
						}
						
													
						evaluacionproveedorAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EvaluacionProveedorParameterReturnGeneral cargarCombosLoteForeignKeyEvaluacionProveedorWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalCliente) throws Exception {
		EvaluacionProveedorParameterReturnGeneral  evaluacionproveedorReturnGeneral =new EvaluacionProveedorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-cargarCombosLoteForeignKeyEvaluacionProveedorWithConnection");connexion.begin();
			
			evaluacionproveedorReturnGeneral =new EvaluacionProveedorParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			evaluacionproveedorReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			evaluacionproveedorReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			evaluacionproveedorReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			evaluacionproveedorReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			evaluacionproveedorReturnGeneral.setclientesForeignKey(clientesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return evaluacionproveedorReturnGeneral;
	}
	
	public EvaluacionProveedorParameterReturnGeneral cargarCombosLoteForeignKeyEvaluacionProveedor(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalCliente) throws Exception {
		EvaluacionProveedorParameterReturnGeneral  evaluacionproveedorReturnGeneral =new EvaluacionProveedorParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			evaluacionproveedorReturnGeneral =new EvaluacionProveedorParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			evaluacionproveedorReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			evaluacionproveedorReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			evaluacionproveedorReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			evaluacionproveedorReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			evaluacionproveedorReturnGeneral.setclientesForeignKey(clientesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return evaluacionproveedorReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyEvaluacionProveedorWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic=new DetalleEvaluacionProveedorLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEvaluacionProveedorWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleEvaluacionProveedor.class));
											
			

			detalleevaluacionproveedorLogic.setConnexion(this.getConnexion());
			detalleevaluacionproveedorLogic.setDatosCliente(this.datosCliente);
			detalleevaluacionproveedorLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EvaluacionProveedor evaluacionproveedor:this.evaluacionproveedors) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleEvaluacionProveedorConstantesFunciones.getClassesForeignKeysOfDetalleEvaluacionProveedor(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleevaluacionproveedorLogic.setDetalleEvaluacionProveedors(evaluacionproveedor.detalleevaluacionproveedors);
				detalleevaluacionproveedorLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EvaluacionProveedor evaluacionproveedor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EvaluacionProveedorLogicAdditional.updateEvaluacionProveedorToGet(evaluacionproveedor,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		evaluacionproveedor.setEmpresa(evaluacionproveedorDataAccess.getEmpresa(connexion,evaluacionproveedor));
		evaluacionproveedor.setSucursal(evaluacionproveedorDataAccess.getSucursal(connexion,evaluacionproveedor));
		evaluacionproveedor.setEjercicio(evaluacionproveedorDataAccess.getEjercicio(connexion,evaluacionproveedor));
		evaluacionproveedor.setPeriodo(evaluacionproveedorDataAccess.getPeriodo(connexion,evaluacionproveedor));
		evaluacionproveedor.setCliente(evaluacionproveedorDataAccess.getCliente(connexion,evaluacionproveedor));
		evaluacionproveedor.setDetalleEvaluacionProveedors(evaluacionproveedorDataAccess.getDetalleEvaluacionProveedors(connexion,evaluacionproveedor));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				evaluacionproveedor.setEmpresa(evaluacionproveedorDataAccess.getEmpresa(connexion,evaluacionproveedor));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				evaluacionproveedor.setSucursal(evaluacionproveedorDataAccess.getSucursal(connexion,evaluacionproveedor));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				evaluacionproveedor.setEjercicio(evaluacionproveedorDataAccess.getEjercicio(connexion,evaluacionproveedor));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				evaluacionproveedor.setPeriodo(evaluacionproveedorDataAccess.getPeriodo(connexion,evaluacionproveedor));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				evaluacionproveedor.setCliente(evaluacionproveedorDataAccess.getCliente(connexion,evaluacionproveedor));
				continue;
			}

			if(clas.clas.equals(DetalleEvaluacionProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				evaluacionproveedor.setDetalleEvaluacionProveedors(evaluacionproveedorDataAccess.getDetalleEvaluacionProveedors(connexion,evaluacionproveedor));

				if(this.isConDeep) {
					DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic= new DetalleEvaluacionProveedorLogic(this.connexion);
					detalleevaluacionproveedorLogic.setDetalleEvaluacionProveedors(evaluacionproveedor.getDetalleEvaluacionProveedors());
					ArrayList<Classe> classesLocal=DetalleEvaluacionProveedorConstantesFunciones.getClassesForeignKeysOfDetalleEvaluacionProveedor(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleevaluacionproveedorLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(detalleevaluacionproveedorLogic.getDetalleEvaluacionProveedors());
					evaluacionproveedor.setDetalleEvaluacionProveedors(detalleevaluacionproveedorLogic.getDetalleEvaluacionProveedors());
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
			evaluacionproveedor.setEmpresa(evaluacionproveedorDataAccess.getEmpresa(connexion,evaluacionproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionproveedor.setSucursal(evaluacionproveedorDataAccess.getSucursal(connexion,evaluacionproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionproveedor.setEjercicio(evaluacionproveedorDataAccess.getEjercicio(connexion,evaluacionproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionproveedor.setPeriodo(evaluacionproveedorDataAccess.getPeriodo(connexion,evaluacionproveedor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionproveedor.setCliente(evaluacionproveedorDataAccess.getCliente(connexion,evaluacionproveedor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleEvaluacionProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleEvaluacionProveedor.class));
			evaluacionproveedor.setDetalleEvaluacionProveedors(evaluacionproveedorDataAccess.getDetalleEvaluacionProveedors(connexion,evaluacionproveedor));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		evaluacionproveedor.setEmpresa(evaluacionproveedorDataAccess.getEmpresa(connexion,evaluacionproveedor));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(evaluacionproveedor.getEmpresa(),isDeep,deepLoadType,clases);
				
		evaluacionproveedor.setSucursal(evaluacionproveedorDataAccess.getSucursal(connexion,evaluacionproveedor));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(evaluacionproveedor.getSucursal(),isDeep,deepLoadType,clases);
				
		evaluacionproveedor.setEjercicio(evaluacionproveedorDataAccess.getEjercicio(connexion,evaluacionproveedor));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(evaluacionproveedor.getEjercicio(),isDeep,deepLoadType,clases);
				
		evaluacionproveedor.setPeriodo(evaluacionproveedorDataAccess.getPeriodo(connexion,evaluacionproveedor));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(evaluacionproveedor.getPeriodo(),isDeep,deepLoadType,clases);
				
		evaluacionproveedor.setCliente(evaluacionproveedorDataAccess.getCliente(connexion,evaluacionproveedor));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(evaluacionproveedor.getCliente(),isDeep,deepLoadType,clases);
				

		evaluacionproveedor.setDetalleEvaluacionProveedors(evaluacionproveedorDataAccess.getDetalleEvaluacionProveedors(connexion,evaluacionproveedor));

		for(DetalleEvaluacionProveedor detalleevaluacionproveedor:evaluacionproveedor.getDetalleEvaluacionProveedors()) {
			DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic= new DetalleEvaluacionProveedorLogic(connexion);
			detalleevaluacionproveedorLogic.deepLoad(detalleevaluacionproveedor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				evaluacionproveedor.setEmpresa(evaluacionproveedorDataAccess.getEmpresa(connexion,evaluacionproveedor));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(evaluacionproveedor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				evaluacionproveedor.setSucursal(evaluacionproveedorDataAccess.getSucursal(connexion,evaluacionproveedor));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(evaluacionproveedor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				evaluacionproveedor.setEjercicio(evaluacionproveedorDataAccess.getEjercicio(connexion,evaluacionproveedor));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(evaluacionproveedor.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				evaluacionproveedor.setPeriodo(evaluacionproveedorDataAccess.getPeriodo(connexion,evaluacionproveedor));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(evaluacionproveedor.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				evaluacionproveedor.setCliente(evaluacionproveedorDataAccess.getCliente(connexion,evaluacionproveedor));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(evaluacionproveedor.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleEvaluacionProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				evaluacionproveedor.setDetalleEvaluacionProveedors(evaluacionproveedorDataAccess.getDetalleEvaluacionProveedors(connexion,evaluacionproveedor));

				for(DetalleEvaluacionProveedor detalleevaluacionproveedor:evaluacionproveedor.getDetalleEvaluacionProveedors()) {
					DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic= new DetalleEvaluacionProveedorLogic(connexion);
					detalleevaluacionproveedorLogic.deepLoad(detalleevaluacionproveedor,isDeep,deepLoadType,clases);
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
			evaluacionproveedor.setEmpresa(evaluacionproveedorDataAccess.getEmpresa(connexion,evaluacionproveedor));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(evaluacionproveedor.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionproveedor.setSucursal(evaluacionproveedorDataAccess.getSucursal(connexion,evaluacionproveedor));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(evaluacionproveedor.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionproveedor.setEjercicio(evaluacionproveedorDataAccess.getEjercicio(connexion,evaluacionproveedor));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(evaluacionproveedor.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionproveedor.setPeriodo(evaluacionproveedorDataAccess.getPeriodo(connexion,evaluacionproveedor));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(evaluacionproveedor.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			evaluacionproveedor.setCliente(evaluacionproveedorDataAccess.getCliente(connexion,evaluacionproveedor));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(evaluacionproveedor.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleEvaluacionProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleEvaluacionProveedor.class));
			evaluacionproveedor.setDetalleEvaluacionProveedors(evaluacionproveedorDataAccess.getDetalleEvaluacionProveedors(connexion,evaluacionproveedor));

			for(DetalleEvaluacionProveedor detalleevaluacionproveedor:evaluacionproveedor.getDetalleEvaluacionProveedors()) {
				DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic= new DetalleEvaluacionProveedorLogic(connexion);
				detalleevaluacionproveedorLogic.deepLoad(detalleevaluacionproveedor,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EvaluacionProveedor evaluacionproveedor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EvaluacionProveedorLogicAdditional.updateEvaluacionProveedorToSave(evaluacionproveedor,this.arrDatoGeneral);
			
EvaluacionProveedorDataAccess.save(evaluacionproveedor, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(evaluacionproveedor.getEmpresa(),connexion);

		SucursalDataAccess.save(evaluacionproveedor.getSucursal(),connexion);

		EjercicioDataAccess.save(evaluacionproveedor.getEjercicio(),connexion);

		PeriodoDataAccess.save(evaluacionproveedor.getPeriodo(),connexion);

		ClienteDataAccess.save(evaluacionproveedor.getCliente(),connexion);

		for(DetalleEvaluacionProveedor detalleevaluacionproveedor:evaluacionproveedor.getDetalleEvaluacionProveedors()) {
			detalleevaluacionproveedor.setid_evaluacion_proveedor(evaluacionproveedor.getId());
			DetalleEvaluacionProveedorDataAccess.save(detalleevaluacionproveedor,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(evaluacionproveedor.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(evaluacionproveedor.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(evaluacionproveedor.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(evaluacionproveedor.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(evaluacionproveedor.getCliente(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleEvaluacionProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleEvaluacionProveedor detalleevaluacionproveedor:evaluacionproveedor.getDetalleEvaluacionProveedors()) {
					detalleevaluacionproveedor.setid_evaluacion_proveedor(evaluacionproveedor.getId());
					DetalleEvaluacionProveedorDataAccess.save(detalleevaluacionproveedor,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(evaluacionproveedor.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(evaluacionproveedor.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(evaluacionproveedor.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(evaluacionproveedor.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(evaluacionproveedor.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(evaluacionproveedor.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(evaluacionproveedor.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(evaluacionproveedor.getPeriodo(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(evaluacionproveedor.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(evaluacionproveedor.getCliente(),isDeep,deepLoadType,clases);
				

		for(DetalleEvaluacionProveedor detalleevaluacionproveedor:evaluacionproveedor.getDetalleEvaluacionProveedors()) {
			DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic= new DetalleEvaluacionProveedorLogic(connexion);
			detalleevaluacionproveedor.setid_evaluacion_proveedor(evaluacionproveedor.getId());
			DetalleEvaluacionProveedorDataAccess.save(detalleevaluacionproveedor,connexion);
			detalleevaluacionproveedorLogic.deepSave(detalleevaluacionproveedor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(evaluacionproveedor.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(evaluacionproveedor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(evaluacionproveedor.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(evaluacionproveedor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(evaluacionproveedor.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(evaluacionproveedor.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(evaluacionproveedor.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(evaluacionproveedor.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(evaluacionproveedor.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(evaluacionproveedor.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleEvaluacionProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleEvaluacionProveedor detalleevaluacionproveedor:evaluacionproveedor.getDetalleEvaluacionProveedors()) {
					DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic= new DetalleEvaluacionProveedorLogic(connexion);
					detalleevaluacionproveedor.setid_evaluacion_proveedor(evaluacionproveedor.getId());
					DetalleEvaluacionProveedorDataAccess.save(detalleevaluacionproveedor,connexion);
					detalleevaluacionproveedorLogic.deepSave(detalleevaluacionproveedor,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EvaluacionProveedor.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(evaluacionproveedor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(evaluacionproveedor);
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
			this.deepLoad(this.evaluacionproveedor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EvaluacionProveedor.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(evaluacionproveedors!=null) {
				for(EvaluacionProveedor evaluacionproveedor:evaluacionproveedors) {
					this.deepLoad(evaluacionproveedor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(evaluacionproveedors);
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
			if(evaluacionproveedors!=null) {
				for(EvaluacionProveedor evaluacionproveedor:evaluacionproveedors) {
					this.deepLoad(evaluacionproveedor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(evaluacionproveedors);
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
			this.getNewConnexionToDeep(EvaluacionProveedor.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(evaluacionproveedor,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EvaluacionProveedor.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(evaluacionproveedors!=null) {
				for(EvaluacionProveedor evaluacionproveedor:evaluacionproveedors) {
					this.deepSave(evaluacionproveedor,isDeep,deepLoadType,clases);
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
			if(evaluacionproveedors!=null) {
				for(EvaluacionProveedor evaluacionproveedor:evaluacionproveedors) {
					this.deepSave(evaluacionproveedor,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEvaluacionProveedorsFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,EvaluacionProveedorConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionproveedors=evaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionProveedorsFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,EvaluacionProveedorConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionproveedors=evaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionProveedorsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,EvaluacionProveedorConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionproveedors=evaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionProveedorsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,EvaluacionProveedorConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionproveedors=evaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionProveedorsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EvaluacionProveedorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionproveedors=evaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionProveedorsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EvaluacionProveedorConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionproveedors=evaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionProveedorsFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,EvaluacionProveedorConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionproveedors=evaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionProveedorsFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,EvaluacionProveedorConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionproveedors=evaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getEvaluacionProveedorsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EvaluacionProveedor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,EvaluacionProveedorConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionproveedors=evaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEvaluacionProveedorsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,EvaluacionProveedorConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			EvaluacionProveedorLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			evaluacionproveedors=evaluacionproveedorDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionProveedor(this.evaluacionproveedors);
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
			if(EvaluacionProveedorConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EvaluacionProveedorDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EvaluacionProveedor evaluacionproveedor,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EvaluacionProveedorConstantesFunciones.ISCONAUDITORIA) {
				if(evaluacionproveedor.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EvaluacionProveedorDataAccess.TABLENAME, evaluacionproveedor.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EvaluacionProveedorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EvaluacionProveedorLogic.registrarAuditoriaDetallesEvaluacionProveedor(connexion,evaluacionproveedor,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(evaluacionproveedor.getIsDeleted()) {
					/*if(!evaluacionproveedor.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EvaluacionProveedorDataAccess.TABLENAME, evaluacionproveedor.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EvaluacionProveedorLogic.registrarAuditoriaDetallesEvaluacionProveedor(connexion,evaluacionproveedor,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EvaluacionProveedorDataAccess.TABLENAME, evaluacionproveedor.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(evaluacionproveedor.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EvaluacionProveedorDataAccess.TABLENAME, evaluacionproveedor.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EvaluacionProveedorConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EvaluacionProveedorLogic.registrarAuditoriaDetallesEvaluacionProveedor(connexion,evaluacionproveedor,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEvaluacionProveedor(Connexion connexion,EvaluacionProveedor evaluacionproveedor)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(evaluacionproveedor.getIsNew()||!evaluacionproveedor.getid_empresa().equals(evaluacionproveedor.getEvaluacionProveedorOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionproveedor.getEvaluacionProveedorOriginal().getid_empresa()!=null)
				{
					strValorActual=evaluacionproveedor.getEvaluacionProveedorOriginal().getid_empresa().toString();
				}
				if(evaluacionproveedor.getid_empresa()!=null)
				{
					strValorNuevo=evaluacionproveedor.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionProveedorConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionproveedor.getIsNew()||!evaluacionproveedor.getid_sucursal().equals(evaluacionproveedor.getEvaluacionProveedorOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionproveedor.getEvaluacionProveedorOriginal().getid_sucursal()!=null)
				{
					strValorActual=evaluacionproveedor.getEvaluacionProveedorOriginal().getid_sucursal().toString();
				}
				if(evaluacionproveedor.getid_sucursal()!=null)
				{
					strValorNuevo=evaluacionproveedor.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionProveedorConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionproveedor.getIsNew()||!evaluacionproveedor.getid_ejercicio().equals(evaluacionproveedor.getEvaluacionProveedorOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionproveedor.getEvaluacionProveedorOriginal().getid_ejercicio()!=null)
				{
					strValorActual=evaluacionproveedor.getEvaluacionProveedorOriginal().getid_ejercicio().toString();
				}
				if(evaluacionproveedor.getid_ejercicio()!=null)
				{
					strValorNuevo=evaluacionproveedor.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionProveedorConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionproveedor.getIsNew()||!evaluacionproveedor.getid_periodo().equals(evaluacionproveedor.getEvaluacionProveedorOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionproveedor.getEvaluacionProveedorOriginal().getid_periodo()!=null)
				{
					strValorActual=evaluacionproveedor.getEvaluacionProveedorOriginal().getid_periodo().toString();
				}
				if(evaluacionproveedor.getid_periodo()!=null)
				{
					strValorNuevo=evaluacionproveedor.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionProveedorConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionproveedor.getIsNew()||!evaluacionproveedor.getid_cliente().equals(evaluacionproveedor.getEvaluacionProveedorOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionproveedor.getEvaluacionProveedorOriginal().getid_cliente()!=null)
				{
					strValorActual=evaluacionproveedor.getEvaluacionProveedorOriginal().getid_cliente().toString();
				}
				if(evaluacionproveedor.getid_cliente()!=null)
				{
					strValorNuevo=evaluacionproveedor.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionProveedorConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionproveedor.getIsNew()||!evaluacionproveedor.getfecha().equals(evaluacionproveedor.getEvaluacionProveedorOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionproveedor.getEvaluacionProveedorOriginal().getfecha()!=null)
				{
					strValorActual=evaluacionproveedor.getEvaluacionProveedorOriginal().getfecha().toString();
				}
				if(evaluacionproveedor.getfecha()!=null)
				{
					strValorNuevo=evaluacionproveedor.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionProveedorConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionproveedor.getIsNew()||!evaluacionproveedor.getcontacto().equals(evaluacionproveedor.getEvaluacionProveedorOriginal().getcontacto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionproveedor.getEvaluacionProveedorOriginal().getcontacto()!=null)
				{
					strValorActual=evaluacionproveedor.getEvaluacionProveedorOriginal().getcontacto();
				}
				if(evaluacionproveedor.getcontacto()!=null)
				{
					strValorNuevo=evaluacionproveedor.getcontacto() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionProveedorConstantesFunciones.CONTACTO,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionproveedor.getIsNew()||!evaluacionproveedor.getevaluado().equals(evaluacionproveedor.getEvaluacionProveedorOriginal().getevaluado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionproveedor.getEvaluacionProveedorOriginal().getevaluado()!=null)
				{
					strValorActual=evaluacionproveedor.getEvaluacionProveedorOriginal().getevaluado();
				}
				if(evaluacionproveedor.getevaluado()!=null)
				{
					strValorNuevo=evaluacionproveedor.getevaluado() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionProveedorConstantesFunciones.EVALUADO,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionproveedor.getIsNew()||!evaluacionproveedor.getresultado().equals(evaluacionproveedor.getEvaluacionProveedorOriginal().getresultado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionproveedor.getEvaluacionProveedorOriginal().getresultado()!=null)
				{
					strValorActual=evaluacionproveedor.getEvaluacionProveedorOriginal().getresultado();
				}
				if(evaluacionproveedor.getresultado()!=null)
				{
					strValorNuevo=evaluacionproveedor.getresultado() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionProveedorConstantesFunciones.RESULTADO,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionproveedor.getIsNew()||!evaluacionproveedor.getresponsable().equals(evaluacionproveedor.getEvaluacionProveedorOriginal().getresponsable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionproveedor.getEvaluacionProveedorOriginal().getresponsable()!=null)
				{
					strValorActual=evaluacionproveedor.getEvaluacionProveedorOriginal().getresponsable();
				}
				if(evaluacionproveedor.getresponsable()!=null)
				{
					strValorNuevo=evaluacionproveedor.getresponsable() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionProveedorConstantesFunciones.RESPONSABLE,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionproveedor.getIsNew()||!evaluacionproveedor.getfecha_desde().equals(evaluacionproveedor.getEvaluacionProveedorOriginal().getfecha_desde()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionproveedor.getEvaluacionProveedorOriginal().getfecha_desde()!=null)
				{
					strValorActual=evaluacionproveedor.getEvaluacionProveedorOriginal().getfecha_desde().toString();
				}
				if(evaluacionproveedor.getfecha_desde()!=null)
				{
					strValorNuevo=evaluacionproveedor.getfecha_desde().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionProveedorConstantesFunciones.FECHADESDE,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionproveedor.getIsNew()||!evaluacionproveedor.getfecha_hasta().equals(evaluacionproveedor.getEvaluacionProveedorOriginal().getfecha_hasta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionproveedor.getEvaluacionProveedorOriginal().getfecha_hasta()!=null)
				{
					strValorActual=evaluacionproveedor.getEvaluacionProveedorOriginal().getfecha_hasta().toString();
				}
				if(evaluacionproveedor.getfecha_hasta()!=null)
				{
					strValorNuevo=evaluacionproveedor.getfecha_hasta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionProveedorConstantesFunciones.FECHAHASTA,strValorActual,strValorNuevo);
			}	
			
			if(evaluacionproveedor.getIsNew()||!evaluacionproveedor.getobservacion().equals(evaluacionproveedor.getEvaluacionProveedorOriginal().getobservacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(evaluacionproveedor.getEvaluacionProveedorOriginal().getobservacion()!=null)
				{
					strValorActual=evaluacionproveedor.getEvaluacionProveedorOriginal().getobservacion();
				}
				if(evaluacionproveedor.getobservacion()!=null)
				{
					strValorNuevo=evaluacionproveedor.getobservacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EvaluacionProveedorConstantesFunciones.OBSERVACION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEvaluacionProveedorRelacionesWithConnection(EvaluacionProveedor evaluacionproveedor,List<DetalleEvaluacionProveedor> detalleevaluacionproveedors) throws Exception {

		if(!evaluacionproveedor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEvaluacionProveedorRelacionesBase(evaluacionproveedor,detalleevaluacionproveedors,true);
		}
	}

	public void saveEvaluacionProveedorRelaciones(EvaluacionProveedor evaluacionproveedor,List<DetalleEvaluacionProveedor> detalleevaluacionproveedors)throws Exception {

		if(!evaluacionproveedor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEvaluacionProveedorRelacionesBase(evaluacionproveedor,detalleevaluacionproveedors,false);
		}
	}

	public void saveEvaluacionProveedorRelacionesBase(EvaluacionProveedor evaluacionproveedor,List<DetalleEvaluacionProveedor> detalleevaluacionproveedors,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EvaluacionProveedor-saveRelacionesWithConnection");}
	
			evaluacionproveedor.setDetalleEvaluacionProveedors(detalleevaluacionproveedors);

			this.setEvaluacionProveedor(evaluacionproveedor);

			if(EvaluacionProveedorLogicAdditional.validarSaveRelaciones(evaluacionproveedor,this)) {

				EvaluacionProveedorLogicAdditional.updateRelacionesToSave(evaluacionproveedor,this);

				if((evaluacionproveedor.getIsNew()||evaluacionproveedor.getIsChanged())&&!evaluacionproveedor.getIsDeleted()) {
					this.saveEvaluacionProveedor();
					this.saveEvaluacionProveedorRelacionesDetalles(detalleevaluacionproveedors);

				} else if(evaluacionproveedor.getIsDeleted()) {
					this.saveEvaluacionProveedorRelacionesDetalles(detalleevaluacionproveedors);
					this.saveEvaluacionProveedor();
				}

				EvaluacionProveedorLogicAdditional.updateRelacionesToSaveAfter(evaluacionproveedor,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleEvaluacionProveedorConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleEvaluacionProveedors(detalleevaluacionproveedors,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEvaluacionProveedorRelacionesDetalles(List<DetalleEvaluacionProveedor> detalleevaluacionproveedors)throws Exception {
		try {
	

			Long idEvaluacionProveedorActual=this.getEvaluacionProveedor().getId();

			DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic_Desde_EvaluacionProveedor=new DetalleEvaluacionProveedorLogic();
			detalleevaluacionproveedorLogic_Desde_EvaluacionProveedor.setDetalleEvaluacionProveedors(detalleevaluacionproveedors);

			detalleevaluacionproveedorLogic_Desde_EvaluacionProveedor.setConnexion(this.getConnexion());
			detalleevaluacionproveedorLogic_Desde_EvaluacionProveedor.setDatosCliente(this.datosCliente);

			for(DetalleEvaluacionProveedor detalleevaluacionproveedor_Desde_EvaluacionProveedor:detalleevaluacionproveedorLogic_Desde_EvaluacionProveedor.getDetalleEvaluacionProveedors()) {
				detalleevaluacionproveedor_Desde_EvaluacionProveedor.setid_evaluacion_proveedor(idEvaluacionProveedorActual);
			}

			detalleevaluacionproveedorLogic_Desde_EvaluacionProveedor.saveDetalleEvaluacionProveedors();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEvaluacionProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EvaluacionProveedorConstantesFunciones.getClassesForeignKeysOfEvaluacionProveedor(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEvaluacionProveedor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EvaluacionProveedorConstantesFunciones.getClassesRelationshipsOfEvaluacionProveedor(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

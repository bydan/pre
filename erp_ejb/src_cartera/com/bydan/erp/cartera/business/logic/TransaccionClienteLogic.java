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
import com.bydan.erp.cartera.util.TransaccionClienteConstantesFunciones;
import com.bydan.erp.cartera.util.TransaccionClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TransaccionClienteParameterGeneral;
import com.bydan.erp.cartera.business.entity.TransaccionCliente;
import com.bydan.erp.cartera.business.logic.TransaccionClienteLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class TransaccionClienteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TransaccionClienteLogic.class);
	
	protected TransaccionClienteDataAccess transaccionclienteDataAccess; 	
	protected TransaccionCliente transaccioncliente;
	protected List<TransaccionCliente> transaccionclientes;
	protected Object transaccionclienteObject;	
	protected List<Object> transaccionclientesObject;
	
	public static ClassValidator<TransaccionCliente> transaccionclienteValidator = new ClassValidator<TransaccionCliente>(TransaccionCliente.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TransaccionClienteLogicAdditional transaccionclienteLogicAdditional=null;
	
	public TransaccionClienteLogicAdditional getTransaccionClienteLogicAdditional() {
		return this.transaccionclienteLogicAdditional;
	}
	
	public void setTransaccionClienteLogicAdditional(TransaccionClienteLogicAdditional transaccionclienteLogicAdditional) {
		try {
			this.transaccionclienteLogicAdditional=transaccionclienteLogicAdditional;
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
	
	
	
	
	public  TransaccionClienteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.transaccionclienteDataAccess = new TransaccionClienteDataAccess();
			
			this.transaccionclientes= new ArrayList<TransaccionCliente>();
			this.transaccioncliente= new TransaccionCliente();
			
			this.transaccionclienteObject=new Object();
			this.transaccionclientesObject=new ArrayList<Object>();
				
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
			
			this.transaccionclienteDataAccess.setConnexionType(this.connexionType);
			this.transaccionclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TransaccionClienteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.transaccionclienteDataAccess = new TransaccionClienteDataAccess();
			this.transaccionclientes= new ArrayList<TransaccionCliente>();
			this.transaccioncliente= new TransaccionCliente();
			this.transaccionclienteObject=new Object();
			this.transaccionclientesObject=new ArrayList<Object>();
			
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
			
			this.transaccionclienteDataAccess.setConnexionType(this.connexionType);
			this.transaccionclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TransaccionCliente getTransaccionCliente() throws Exception {	
		TransaccionClienteLogicAdditional.checkTransaccionClienteToGet(transaccioncliente,this.datosCliente,this.arrDatoGeneral);
		TransaccionClienteLogicAdditional.updateTransaccionClienteToGet(transaccioncliente,this.arrDatoGeneral);
		
		return transaccioncliente;
	}
		
	public void setTransaccionCliente(TransaccionCliente newTransaccionCliente) {
		this.transaccioncliente = newTransaccionCliente;
	}
	
	public TransaccionClienteDataAccess getTransaccionClienteDataAccess() {
		return transaccionclienteDataAccess;
	}
	
	public void setTransaccionClienteDataAccess(TransaccionClienteDataAccess newtransaccionclienteDataAccess) {
		this.transaccionclienteDataAccess = newtransaccionclienteDataAccess;
	}
	
	public List<TransaccionCliente> getTransaccionClientes() throws Exception {		
		this.quitarTransaccionClientesNulos();
		
		TransaccionClienteLogicAdditional.checkTransaccionClienteToGets(transaccionclientes,this.datosCliente,this.arrDatoGeneral);
		
		for (TransaccionCliente transaccionclienteLocal: transaccionclientes ) {
			TransaccionClienteLogicAdditional.updateTransaccionClienteToGet(transaccionclienteLocal,this.arrDatoGeneral);
		}
		
		return transaccionclientes;
	}
	
	public void setTransaccionClientes(List<TransaccionCliente> newTransaccionClientes) {
		this.transaccionclientes = newTransaccionClientes;
	}
	
	public Object getTransaccionClienteObject() {	
		this.transaccionclienteObject=this.transaccionclienteDataAccess.getEntityObject();
		return this.transaccionclienteObject;
	}
		
	public void setTransaccionClienteObject(Object newTransaccionClienteObject) {
		this.transaccionclienteObject = newTransaccionClienteObject;
	}
	
	public List<Object> getTransaccionClientesObject() {		
		this.transaccionclientesObject=this.transaccionclienteDataAccess.getEntitiesObject();
		return this.transaccionclientesObject;
	}
		
	public void setTransaccionClientesObject(List<Object> newTransaccionClientesObject) {
		this.transaccionclientesObject = newTransaccionClientesObject;
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
		
		if(this.transaccionclienteDataAccess!=null) {
			this.transaccionclienteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			transaccionclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			transaccionclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		transaccioncliente = new  TransaccionCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			transaccioncliente=transaccionclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transaccioncliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccioncliente);
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
		transaccioncliente = new  TransaccionCliente();
		  		  
        try {
			
			transaccioncliente=transaccionclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transaccioncliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccioncliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		transaccioncliente = new  TransaccionCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			transaccioncliente=transaccionclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transaccioncliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccioncliente);
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
		transaccioncliente = new  TransaccionCliente();
		  		  
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
		transaccioncliente = new  TransaccionCliente();
		  		  
        try {
			
			transaccioncliente=transaccionclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.transaccioncliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccioncliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		transaccioncliente = new  TransaccionCliente();
		  		  
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
		transaccioncliente = new  TransaccionCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =transaccionclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		transaccioncliente = new  TransaccionCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=transaccionclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		transaccioncliente = new  TransaccionCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =transaccionclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		transaccioncliente = new  TransaccionCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=transaccionclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		transaccioncliente = new  TransaccionCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =transaccionclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		transaccioncliente = new  TransaccionCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=transaccionclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		transaccionclientes = new  ArrayList<TransaccionCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccionCliente(transaccionclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
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
		transaccionclientes = new  ArrayList<TransaccionCliente>();
		  		  
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
		transaccionclientes = new  ArrayList<TransaccionCliente>();
		  		  
        try {			
			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTransaccionCliente(transaccionclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		transaccionclientes = new  ArrayList<TransaccionCliente>();
		  		  
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
		transaccionclientes = new  ArrayList<TransaccionCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccionCliente(transaccionclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
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
		transaccionclientes = new  ArrayList<TransaccionCliente>();
		  		  
        try {
			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccionCliente(transaccionclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
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
		transaccionclientes = new  ArrayList<TransaccionCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransaccionCliente(transaccionclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
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
		transaccionclientes = new  ArrayList<TransaccionCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransaccionCliente(transaccionclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		transaccioncliente = new  TransaccionCliente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioncliente=transaccionclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransaccionCliente(transaccioncliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccioncliente);
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
		transaccioncliente = new  TransaccionCliente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccioncliente=transaccionclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTransaccionCliente(transaccioncliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccioncliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		transaccionclientes = new  ArrayList<TransaccionCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionclientes=transaccionclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccionCliente(transaccionclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
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
		transaccionclientes = new  ArrayList<TransaccionCliente>();
		  		  
        try {
			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionclientes=transaccionclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTransaccionCliente(transaccionclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTransaccionClientesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		transaccionclientes = new  ArrayList<TransaccionCliente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-getTodosTransaccionClientesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTransaccionCliente(transaccionclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
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
	
	public  void  getTodosTransaccionClientes(String sFinalQuery,Pagination pagination)throws Exception {
		transaccionclientes = new  ArrayList<TransaccionCliente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTransaccionCliente(transaccionclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTransaccionCliente(TransaccionCliente transaccioncliente) throws Exception {
		Boolean estaValidado=false;
		
		if(transaccioncliente.getIsNew() || transaccioncliente.getIsChanged()) { 
			this.invalidValues = transaccionclienteValidator.getInvalidValues(transaccioncliente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(transaccioncliente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTransaccionCliente(List<TransaccionCliente> TransaccionClientes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TransaccionCliente transaccionclienteLocal:transaccionclientes) {				
			estaValidadoObjeto=this.validarGuardarTransaccionCliente(transaccionclienteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTransaccionCliente(List<TransaccionCliente> TransaccionClientes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTransaccionCliente(transaccionclientes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTransaccionCliente(TransaccionCliente TransaccionCliente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTransaccionCliente(transaccioncliente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TransaccionCliente transaccioncliente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+transaccioncliente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TransaccionClienteConstantesFunciones.getTransaccionClienteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"transaccioncliente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TransaccionClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TransaccionClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTransaccionClienteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-saveTransaccionClienteWithConnection");connexion.begin();			
			
			TransaccionClienteLogicAdditional.checkTransaccionClienteToSave(this.transaccioncliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TransaccionClienteLogicAdditional.updateTransaccionClienteToSave(this.transaccioncliente,this.arrDatoGeneral);
			
			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.transaccioncliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTransaccionCliente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTransaccionCliente(this.transaccioncliente)) {
				TransaccionClienteDataAccess.save(this.transaccioncliente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.transaccioncliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TransaccionClienteLogicAdditional.checkTransaccionClienteToSaveAfter(this.transaccioncliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTransaccionCliente();
			
			connexion.commit();			
			
			if(this.transaccioncliente.getIsDeleted()) {
				this.transaccioncliente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTransaccionCliente()throws Exception {	
		try {	
			
			TransaccionClienteLogicAdditional.checkTransaccionClienteToSave(this.transaccioncliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TransaccionClienteLogicAdditional.updateTransaccionClienteToSave(this.transaccioncliente,this.arrDatoGeneral);
			
			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.transaccioncliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTransaccionCliente(this.transaccioncliente)) {			
				TransaccionClienteDataAccess.save(this.transaccioncliente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.transaccioncliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TransaccionClienteLogicAdditional.checkTransaccionClienteToSaveAfter(this.transaccioncliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.transaccioncliente.getIsDeleted()) {
				this.transaccioncliente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTransaccionClientesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-saveTransaccionClientesWithConnection");connexion.begin();			
			
			TransaccionClienteLogicAdditional.checkTransaccionClienteToSaves(transaccionclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTransaccionClientes();
			
			Boolean validadoTodosTransaccionCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TransaccionCliente transaccionclienteLocal:transaccionclientes) {		
				if(transaccionclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TransaccionClienteLogicAdditional.updateTransaccionClienteToSave(transaccionclienteLocal,this.arrDatoGeneral);
	        	
				TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),transaccionclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTransaccionCliente(transaccionclienteLocal)) {
					TransaccionClienteDataAccess.save(transaccionclienteLocal, connexion);				
				} else {
					validadoTodosTransaccionCliente=false;
				}
			}
			
			if(!validadoTodosTransaccionCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TransaccionClienteLogicAdditional.checkTransaccionClienteToSavesAfter(transaccionclientes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTransaccionClientes();
			
			connexion.commit();		
			
			this.quitarTransaccionClientesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTransaccionClientes()throws Exception {				
		 try {	
			TransaccionClienteLogicAdditional.checkTransaccionClienteToSaves(transaccionclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTransaccionCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TransaccionCliente transaccionclienteLocal:transaccionclientes) {				
				if(transaccionclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TransaccionClienteLogicAdditional.updateTransaccionClienteToSave(transaccionclienteLocal,this.arrDatoGeneral);
	        	
				TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),transaccionclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTransaccionCliente(transaccionclienteLocal)) {				
					TransaccionClienteDataAccess.save(transaccionclienteLocal, connexion);				
				} else {
					validadoTodosTransaccionCliente=false;
				}
			}
			
			if(!validadoTodosTransaccionCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TransaccionClienteLogicAdditional.checkTransaccionClienteToSavesAfter(transaccionclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTransaccionClientesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TransaccionClienteParameterReturnGeneral procesarAccionTransaccionClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TransaccionCliente> transaccionclientes,TransaccionClienteParameterReturnGeneral transaccionclienteParameterGeneral)throws Exception {
		 try {	
			TransaccionClienteParameterReturnGeneral transaccionclienteReturnGeneral=new TransaccionClienteParameterReturnGeneral();
	
			TransaccionClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,transaccionclientes,transaccionclienteParameterGeneral,transaccionclienteReturnGeneral);
			
			return transaccionclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TransaccionClienteParameterReturnGeneral procesarAccionTransaccionClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TransaccionCliente> transaccionclientes,TransaccionClienteParameterReturnGeneral transaccionclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-procesarAccionTransaccionClientesWithConnection");connexion.begin();			
			
			TransaccionClienteParameterReturnGeneral transaccionclienteReturnGeneral=new TransaccionClienteParameterReturnGeneral();
	
			TransaccionClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,transaccionclientes,transaccionclienteParameterGeneral,transaccionclienteReturnGeneral);
			
			this.connexion.commit();
			
			return transaccionclienteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TransaccionClienteParameterReturnGeneral procesarEventosTransaccionClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TransaccionCliente> transaccionclientes,TransaccionCliente transaccioncliente,TransaccionClienteParameterReturnGeneral transaccionclienteParameterGeneral,Boolean isEsNuevoTransaccionCliente,ArrayList<Classe> clases)throws Exception {
		 try {	
			TransaccionClienteParameterReturnGeneral transaccionclienteReturnGeneral=new TransaccionClienteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				transaccionclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TransaccionClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,transaccionclientes,transaccioncliente,transaccionclienteParameterGeneral,transaccionclienteReturnGeneral,isEsNuevoTransaccionCliente,clases);
			
			return transaccionclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TransaccionClienteParameterReturnGeneral procesarEventosTransaccionClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TransaccionCliente> transaccionclientes,TransaccionCliente transaccioncliente,TransaccionClienteParameterReturnGeneral transaccionclienteParameterGeneral,Boolean isEsNuevoTransaccionCliente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-procesarEventosTransaccionClientesWithConnection");connexion.begin();			
			
			TransaccionClienteParameterReturnGeneral transaccionclienteReturnGeneral=new TransaccionClienteParameterReturnGeneral();
	
			transaccionclienteReturnGeneral.setTransaccionCliente(transaccioncliente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				transaccionclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TransaccionClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,transaccionclientes,transaccioncliente,transaccionclienteParameterGeneral,transaccionclienteReturnGeneral,isEsNuevoTransaccionCliente,clases);
			
			this.connexion.commit();
			
			return transaccionclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TransaccionClienteParameterReturnGeneral procesarImportacionTransaccionClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TransaccionClienteParameterReturnGeneral transaccionclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-procesarImportacionTransaccionClientesWithConnection");connexion.begin();			
			
			TransaccionClienteParameterReturnGeneral transaccionclienteReturnGeneral=new TransaccionClienteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.transaccionclientes=new ArrayList<TransaccionCliente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.transaccioncliente=new TransaccionCliente();
				
				
				if(conColumnasBase) {this.transaccioncliente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.transaccioncliente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.transaccioncliente.setnombre(arrColumnas[iColumn++]);
				
				this.transaccionclientes.add(this.transaccioncliente);
			}
			
			this.saveTransaccionClientes();
			
			this.connexion.commit();
			
			transaccionclienteReturnGeneral.setConRetornoEstaProcesado(true);
			transaccionclienteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return transaccionclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTransaccionClientesEliminados() throws Exception {				
		
		List<TransaccionCliente> transaccionclientesAux= new ArrayList<TransaccionCliente>();
		
		for(TransaccionCliente transaccioncliente:transaccionclientes) {
			if(!transaccioncliente.getIsDeleted()) {
				transaccionclientesAux.add(transaccioncliente);
			}
		}
		
		transaccionclientes=transaccionclientesAux;
	}
	
	public void quitarTransaccionClientesNulos() throws Exception {				
		
		List<TransaccionCliente> transaccionclientesAux= new ArrayList<TransaccionCliente>();
		
		for(TransaccionCliente transaccioncliente : this.transaccionclientes) {
			if(transaccioncliente==null) {
				transaccionclientesAux.add(transaccioncliente);
			}
		}
		
		//this.transaccionclientes=transaccionclientesAux;
		
		this.transaccionclientes.removeAll(transaccionclientesAux);
	}
	
	public void getSetVersionRowTransaccionClienteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(transaccioncliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((transaccioncliente.getIsDeleted() || (transaccioncliente.getIsChanged()&&!transaccioncliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=transaccionclienteDataAccess.getSetVersionRowTransaccionCliente(connexion,transaccioncliente.getId());
				
				if(!transaccioncliente.getVersionRow().equals(timestamp)) {	
					transaccioncliente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				transaccioncliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTransaccionCliente()throws Exception {	
		
		if(transaccioncliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((transaccioncliente.getIsDeleted() || (transaccioncliente.getIsChanged()&&!transaccioncliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=transaccionclienteDataAccess.getSetVersionRowTransaccionCliente(connexion,transaccioncliente.getId());
			
			try {							
				if(!transaccioncliente.getVersionRow().equals(timestamp)) {	
					transaccioncliente.setVersionRow(timestamp);
				}
				
				transaccioncliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTransaccionClientesWithConnection()throws Exception {	
		if(transaccionclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TransaccionCliente transaccionclienteAux:transaccionclientes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(transaccionclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(transaccionclienteAux.getIsDeleted() || (transaccionclienteAux.getIsChanged()&&!transaccionclienteAux.getIsNew())) {
						
						timestamp=transaccionclienteDataAccess.getSetVersionRowTransaccionCliente(connexion,transaccionclienteAux.getId());
						
						if(!transaccioncliente.getVersionRow().equals(timestamp)) {	
							transaccionclienteAux.setVersionRow(timestamp);
						}
								
						transaccionclienteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTransaccionClientes()throws Exception {	
		if(transaccionclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TransaccionCliente transaccionclienteAux:transaccionclientes) {
					if(transaccionclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(transaccionclienteAux.getIsDeleted() || (transaccionclienteAux.getIsChanged()&&!transaccionclienteAux.getIsNew())) {
						
						timestamp=transaccionclienteDataAccess.getSetVersionRowTransaccionCliente(connexion,transaccionclienteAux.getId());
						
						if(!transaccionclienteAux.getVersionRow().equals(timestamp)) {	
							transaccionclienteAux.setVersionRow(timestamp);
						}
						
													
						transaccionclienteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TransaccionClienteParameterReturnGeneral cargarCombosLoteForeignKeyTransaccionClienteWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalModulo,String finalQueryGlobalTransaccion1,String finalQueryGlobalTransaccion2,String finalQueryGlobalTransaccion3,String finalQueryGlobalTransaccion4,String finalQueryGlobalTransaccion5) throws Exception {
		TransaccionClienteParameterReturnGeneral  transaccionclienteReturnGeneral =new TransaccionClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-cargarCombosLoteForeignKeyTransaccionClienteWithConnection");connexion.begin();
			
			transaccionclienteReturnGeneral =new TransaccionClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			transaccionclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			transaccionclienteReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Transaccion> transaccion1sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion1Logic=new TransaccionLogic();
			transaccion1Logic.setConnexion(this.connexion);
			transaccion1Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion1.equals("NONE")) {
				transaccion1Logic.getTodosTransaccions(finalQueryGlobalTransaccion1,new Pagination());
				transaccion1sForeignKey=transaccion1Logic.getTransaccions();
			}

			transaccionclienteReturnGeneral.settransaccion1sForeignKey(transaccion1sForeignKey);


			List<Transaccion> transaccion2sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion2Logic=new TransaccionLogic();
			transaccion2Logic.setConnexion(this.connexion);
			transaccion2Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion2.equals("NONE")) {
				transaccion2Logic.getTodosTransaccions(finalQueryGlobalTransaccion2,new Pagination());
				transaccion2sForeignKey=transaccion2Logic.getTransaccions();
			}

			transaccionclienteReturnGeneral.settransaccion2sForeignKey(transaccion2sForeignKey);


			List<Transaccion> transaccion3sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion3Logic=new TransaccionLogic();
			transaccion3Logic.setConnexion(this.connexion);
			transaccion3Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion3.equals("NONE")) {
				transaccion3Logic.getTodosTransaccions(finalQueryGlobalTransaccion3,new Pagination());
				transaccion3sForeignKey=transaccion3Logic.getTransaccions();
			}

			transaccionclienteReturnGeneral.settransaccion3sForeignKey(transaccion3sForeignKey);


			List<Transaccion> transaccion4sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion4Logic=new TransaccionLogic();
			transaccion4Logic.setConnexion(this.connexion);
			transaccion4Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion4.equals("NONE")) {
				transaccion4Logic.getTodosTransaccions(finalQueryGlobalTransaccion4,new Pagination());
				transaccion4sForeignKey=transaccion4Logic.getTransaccions();
			}

			transaccionclienteReturnGeneral.settransaccion4sForeignKey(transaccion4sForeignKey);


			List<Transaccion> transaccion5sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion5Logic=new TransaccionLogic();
			transaccion5Logic.setConnexion(this.connexion);
			transaccion5Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion5.equals("NONE")) {
				transaccion5Logic.getTodosTransaccions(finalQueryGlobalTransaccion5,new Pagination());
				transaccion5sForeignKey=transaccion5Logic.getTransaccions();
			}

			transaccionclienteReturnGeneral.settransaccion5sForeignKey(transaccion5sForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return transaccionclienteReturnGeneral;
	}
	
	public TransaccionClienteParameterReturnGeneral cargarCombosLoteForeignKeyTransaccionCliente(String finalQueryGlobalEmpresa,String finalQueryGlobalModulo,String finalQueryGlobalTransaccion1,String finalQueryGlobalTransaccion2,String finalQueryGlobalTransaccion3,String finalQueryGlobalTransaccion4,String finalQueryGlobalTransaccion5) throws Exception {
		TransaccionClienteParameterReturnGeneral  transaccionclienteReturnGeneral =new TransaccionClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			transaccionclienteReturnGeneral =new TransaccionClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			transaccionclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			transaccionclienteReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Transaccion> transaccion1sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion1Logic=new TransaccionLogic();
			transaccion1Logic.setConnexion(this.connexion);
			transaccion1Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion1.equals("NONE")) {
				transaccion1Logic.getTodosTransaccions(finalQueryGlobalTransaccion1,new Pagination());
				transaccion1sForeignKey=transaccion1Logic.getTransaccions();
			}

			transaccionclienteReturnGeneral.settransaccion1sForeignKey(transaccion1sForeignKey);


			List<Transaccion> transaccion2sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion2Logic=new TransaccionLogic();
			transaccion2Logic.setConnexion(this.connexion);
			transaccion2Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion2.equals("NONE")) {
				transaccion2Logic.getTodosTransaccions(finalQueryGlobalTransaccion2,new Pagination());
				transaccion2sForeignKey=transaccion2Logic.getTransaccions();
			}

			transaccionclienteReturnGeneral.settransaccion2sForeignKey(transaccion2sForeignKey);


			List<Transaccion> transaccion3sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion3Logic=new TransaccionLogic();
			transaccion3Logic.setConnexion(this.connexion);
			transaccion3Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion3.equals("NONE")) {
				transaccion3Logic.getTodosTransaccions(finalQueryGlobalTransaccion3,new Pagination());
				transaccion3sForeignKey=transaccion3Logic.getTransaccions();
			}

			transaccionclienteReturnGeneral.settransaccion3sForeignKey(transaccion3sForeignKey);


			List<Transaccion> transaccion4sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion4Logic=new TransaccionLogic();
			transaccion4Logic.setConnexion(this.connexion);
			transaccion4Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion4.equals("NONE")) {
				transaccion4Logic.getTodosTransaccions(finalQueryGlobalTransaccion4,new Pagination());
				transaccion4sForeignKey=transaccion4Logic.getTransaccions();
			}

			transaccionclienteReturnGeneral.settransaccion4sForeignKey(transaccion4sForeignKey);


			List<Transaccion> transaccion5sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion5Logic=new TransaccionLogic();
			transaccion5Logic.setConnexion(this.connexion);
			transaccion5Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion5.equals("NONE")) {
				transaccion5Logic.getTodosTransaccions(finalQueryGlobalTransaccion5,new Pagination());
				transaccion5sForeignKey=transaccion5Logic.getTransaccions();
			}

			transaccionclienteReturnGeneral.settransaccion5sForeignKey(transaccion5sForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return transaccionclienteReturnGeneral;
	}
	
	
	public void deepLoad(TransaccionCliente transaccioncliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TransaccionClienteLogicAdditional.updateTransaccionClienteToGet(transaccioncliente,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		transaccioncliente.setEmpresa(transaccionclienteDataAccess.getEmpresa(connexion,transaccioncliente));
		transaccioncliente.setModulo(transaccionclienteDataAccess.getModulo(connexion,transaccioncliente));
		transaccioncliente.setTransaccion1(transaccionclienteDataAccess.getTransaccion1(connexion,transaccioncliente));
		transaccioncliente.setTransaccion2(transaccionclienteDataAccess.getTransaccion2(connexion,transaccioncliente));
		transaccioncliente.setTransaccion3(transaccionclienteDataAccess.getTransaccion3(connexion,transaccioncliente));
		transaccioncliente.setTransaccion4(transaccionclienteDataAccess.getTransaccion4(connexion,transaccioncliente));
		transaccioncliente.setTransaccion5(transaccionclienteDataAccess.getTransaccion5(connexion,transaccioncliente));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				transaccioncliente.setEmpresa(transaccionclienteDataAccess.getEmpresa(connexion,transaccioncliente));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				transaccioncliente.setModulo(transaccionclienteDataAccess.getModulo(connexion,transaccioncliente));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				transaccioncliente.setTransaccion1(transaccionclienteDataAccess.getTransaccion1(connexion,transaccioncliente));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				transaccioncliente.setTransaccion2(transaccionclienteDataAccess.getTransaccion2(connexion,transaccioncliente));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				transaccioncliente.setTransaccion3(transaccionclienteDataAccess.getTransaccion3(connexion,transaccioncliente));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				transaccioncliente.setTransaccion4(transaccionclienteDataAccess.getTransaccion4(connexion,transaccioncliente));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				transaccioncliente.setTransaccion5(transaccionclienteDataAccess.getTransaccion5(connexion,transaccioncliente));
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
			transaccioncliente.setEmpresa(transaccionclienteDataAccess.getEmpresa(connexion,transaccioncliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccioncliente.setModulo(transaccionclienteDataAccess.getModulo(connexion,transaccioncliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccioncliente.setTransaccion1(transaccionclienteDataAccess.getTransaccion1(connexion,transaccioncliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccioncliente.setTransaccion2(transaccionclienteDataAccess.getTransaccion2(connexion,transaccioncliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccioncliente.setTransaccion3(transaccionclienteDataAccess.getTransaccion3(connexion,transaccioncliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccioncliente.setTransaccion4(transaccionclienteDataAccess.getTransaccion4(connexion,transaccioncliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccioncliente.setTransaccion5(transaccionclienteDataAccess.getTransaccion5(connexion,transaccioncliente));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		transaccioncliente.setEmpresa(transaccionclienteDataAccess.getEmpresa(connexion,transaccioncliente));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(transaccioncliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		transaccioncliente.setModulo(transaccionclienteDataAccess.getModulo(connexion,transaccioncliente));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(transaccioncliente.getModulo(),isDeep,deepLoadType,clases);
				
		transaccioncliente.setTransaccion1(transaccionclienteDataAccess.getTransaccion1(connexion,transaccioncliente));
		TransaccionLogic transaccion1Logic= new TransaccionLogic(connexion);
		transaccion1Logic.deepLoad(transaccioncliente.getTransaccion1(),isDeep,deepLoadType,clases);
				
		transaccioncliente.setTransaccion2(transaccionclienteDataAccess.getTransaccion2(connexion,transaccioncliente));
		TransaccionLogic transaccion2Logic= new TransaccionLogic(connexion);
		transaccion2Logic.deepLoad(transaccioncliente.getTransaccion2(),isDeep,deepLoadType,clases);
				
		transaccioncliente.setTransaccion3(transaccionclienteDataAccess.getTransaccion3(connexion,transaccioncliente));
		TransaccionLogic transaccion3Logic= new TransaccionLogic(connexion);
		transaccion3Logic.deepLoad(transaccioncliente.getTransaccion3(),isDeep,deepLoadType,clases);
				
		transaccioncliente.setTransaccion4(transaccionclienteDataAccess.getTransaccion4(connexion,transaccioncliente));
		TransaccionLogic transaccion4Logic= new TransaccionLogic(connexion);
		transaccion4Logic.deepLoad(transaccioncliente.getTransaccion4(),isDeep,deepLoadType,clases);
				
		transaccioncliente.setTransaccion5(transaccionclienteDataAccess.getTransaccion5(connexion,transaccioncliente));
		TransaccionLogic transaccion5Logic= new TransaccionLogic(connexion);
		transaccion5Logic.deepLoad(transaccioncliente.getTransaccion5(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				transaccioncliente.setEmpresa(transaccionclienteDataAccess.getEmpresa(connexion,transaccioncliente));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(transaccioncliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				transaccioncliente.setModulo(transaccionclienteDataAccess.getModulo(connexion,transaccioncliente));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(transaccioncliente.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				transaccioncliente.setTransaccion1(transaccionclienteDataAccess.getTransaccion1(connexion,transaccioncliente));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(transaccioncliente.getTransaccion1(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				transaccioncliente.setTransaccion2(transaccionclienteDataAccess.getTransaccion2(connexion,transaccioncliente));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(transaccioncliente.getTransaccion2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				transaccioncliente.setTransaccion3(transaccionclienteDataAccess.getTransaccion3(connexion,transaccioncliente));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(transaccioncliente.getTransaccion3(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				transaccioncliente.setTransaccion4(transaccionclienteDataAccess.getTransaccion4(connexion,transaccioncliente));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(transaccioncliente.getTransaccion4(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				transaccioncliente.setTransaccion5(transaccionclienteDataAccess.getTransaccion5(connexion,transaccioncliente));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(transaccioncliente.getTransaccion5(),isDeep,deepLoadType,clases);				
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
			transaccioncliente.setEmpresa(transaccionclienteDataAccess.getEmpresa(connexion,transaccioncliente));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(transaccioncliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccioncliente.setModulo(transaccionclienteDataAccess.getModulo(connexion,transaccioncliente));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(transaccioncliente.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccioncliente.setTransaccion1(transaccionclienteDataAccess.getTransaccion1(connexion,transaccioncliente));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(transaccioncliente.getTransaccion1(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccioncliente.setTransaccion2(transaccionclienteDataAccess.getTransaccion2(connexion,transaccioncliente));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(transaccioncliente.getTransaccion2(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccioncliente.setTransaccion3(transaccionclienteDataAccess.getTransaccion3(connexion,transaccioncliente));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(transaccioncliente.getTransaccion3(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccioncliente.setTransaccion4(transaccionclienteDataAccess.getTransaccion4(connexion,transaccioncliente));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(transaccioncliente.getTransaccion4(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			transaccioncliente.setTransaccion5(transaccionclienteDataAccess.getTransaccion5(connexion,transaccioncliente));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(transaccioncliente.getTransaccion5(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TransaccionCliente transaccioncliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TransaccionClienteLogicAdditional.updateTransaccionClienteToSave(transaccioncliente,this.arrDatoGeneral);
			
TransaccionClienteDataAccess.save(transaccioncliente, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(transaccioncliente.getEmpresa(),connexion);

		ModuloDataAccess.save(transaccioncliente.getModulo(),connexion);

		TransaccionDataAccess.save(transaccioncliente.getTransaccion1(),connexion);

		TransaccionDataAccess.save(transaccioncliente.getTransaccion2(),connexion);

		TransaccionDataAccess.save(transaccioncliente.getTransaccion3(),connexion);

		TransaccionDataAccess.save(transaccioncliente.getTransaccion4(),connexion);

		TransaccionDataAccess.save(transaccioncliente.getTransaccion5(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(transaccioncliente.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(transaccioncliente.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(transaccioncliente.getTransaccion1(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(transaccioncliente.getTransaccion2(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(transaccioncliente.getTransaccion3(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(transaccioncliente.getTransaccion4(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(transaccioncliente.getTransaccion5(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(transaccioncliente.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(transaccioncliente.getEmpresa(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(transaccioncliente.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(transaccioncliente.getModulo(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(transaccioncliente.getTransaccion1(),connexion);
		TransaccionLogic transaccion1Logic= new TransaccionLogic(connexion);
		transaccion1Logic.deepLoad(transaccioncliente.getTransaccion1(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(transaccioncliente.getTransaccion2(),connexion);
		TransaccionLogic transaccion2Logic= new TransaccionLogic(connexion);
		transaccion2Logic.deepLoad(transaccioncliente.getTransaccion2(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(transaccioncliente.getTransaccion3(),connexion);
		TransaccionLogic transaccion3Logic= new TransaccionLogic(connexion);
		transaccion3Logic.deepLoad(transaccioncliente.getTransaccion3(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(transaccioncliente.getTransaccion4(),connexion);
		TransaccionLogic transaccion4Logic= new TransaccionLogic(connexion);
		transaccion4Logic.deepLoad(transaccioncliente.getTransaccion4(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(transaccioncliente.getTransaccion5(),connexion);
		TransaccionLogic transaccion5Logic= new TransaccionLogic(connexion);
		transaccion5Logic.deepLoad(transaccioncliente.getTransaccion5(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(transaccioncliente.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(transaccioncliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(transaccioncliente.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(transaccioncliente.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(transaccioncliente.getTransaccion1(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(transaccioncliente.getTransaccion1(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(transaccioncliente.getTransaccion2(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(transaccioncliente.getTransaccion2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(transaccioncliente.getTransaccion3(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(transaccioncliente.getTransaccion3(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(transaccioncliente.getTransaccion4(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(transaccioncliente.getTransaccion4(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(transaccioncliente.getTransaccion5(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(transaccioncliente.getTransaccion5(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TransaccionCliente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(transaccioncliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(transaccioncliente);
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
			this.deepLoad(this.transaccioncliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccioncliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TransaccionCliente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(transaccionclientes!=null) {
				for(TransaccionCliente transaccioncliente:transaccionclientes) {
					this.deepLoad(transaccioncliente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(transaccionclientes);
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
			if(transaccionclientes!=null) {
				for(TransaccionCliente transaccioncliente:transaccionclientes) {
					this.deepLoad(transaccioncliente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(transaccionclientes);
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
			this.getNewConnexionToDeep(TransaccionCliente.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(transaccioncliente,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TransaccionCliente.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(transaccionclientes!=null) {
				for(TransaccionCliente transaccioncliente:transaccionclientes) {
					this.deepSave(transaccioncliente,isDeep,deepLoadType,clases);
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
			if(transaccionclientes!=null) {
				for(TransaccionCliente transaccioncliente:transaccionclientes) {
					this.deepSave(transaccioncliente,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTransaccionClientesBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TransaccionClienteConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionClientesBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TransaccionClienteConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionClientesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TransaccionClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionClientesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TransaccionClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionClientesFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TransaccionClienteConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionClientesFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TransaccionClienteConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionClientesFK_IdTransaccion1WithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion1)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion1= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion1.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion1,TransaccionClienteConstantesFunciones.IDTRANSACCION1,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion1);

			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion1","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionClientesFK_IdTransaccion1(String sFinalQuery,Pagination pagination,Long id_transaccion1)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion1= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion1.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion1,TransaccionClienteConstantesFunciones.IDTRANSACCION1,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion1);

			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion1","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionClientesFK_IdTransaccion2WithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion2)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion2,TransaccionClienteConstantesFunciones.IDTRANSACCION2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion2);

			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionClientesFK_IdTransaccion2(String sFinalQuery,Pagination pagination,Long id_transaccion2)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion2,TransaccionClienteConstantesFunciones.IDTRANSACCION2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion2);

			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionClientesFK_IdTransaccion3WithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion3)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion3= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion3.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion3,TransaccionClienteConstantesFunciones.IDTRANSACCION3,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion3);

			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion3","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionClientesFK_IdTransaccion3(String sFinalQuery,Pagination pagination,Long id_transaccion3)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion3= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion3.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion3,TransaccionClienteConstantesFunciones.IDTRANSACCION3,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion3);

			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion3","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionClientesFK_IdTransaccion4WithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion4)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion4= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion4.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion4,TransaccionClienteConstantesFunciones.IDTRANSACCION4,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion4);

			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion4","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionClientesFK_IdTransaccion4(String sFinalQuery,Pagination pagination,Long id_transaccion4)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion4= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion4.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion4,TransaccionClienteConstantesFunciones.IDTRANSACCION4,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion4);

			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion4","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTransaccionClientesFK_IdTransaccion5WithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion5)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TransaccionCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion5= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion5.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion5,TransaccionClienteConstantesFunciones.IDTRANSACCION5,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion5);

			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion5","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTransaccionClientesFK_IdTransaccion5(String sFinalQuery,Pagination pagination,Long id_transaccion5)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion5= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion5.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion5,TransaccionClienteConstantesFunciones.IDTRANSACCION5,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion5);

			TransaccionClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion5","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			transaccionclientes=transaccionclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TransaccionClienteConstantesFunciones.refrescarForeignKeysDescripcionesTransaccionCliente(this.transaccionclientes);
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
			if(TransaccionClienteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TransaccionClienteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TransaccionCliente transaccioncliente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TransaccionClienteConstantesFunciones.ISCONAUDITORIA) {
				if(transaccioncliente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TransaccionClienteDataAccess.TABLENAME, transaccioncliente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TransaccionClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TransaccionClienteLogic.registrarAuditoriaDetallesTransaccionCliente(connexion,transaccioncliente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(transaccioncliente.getIsDeleted()) {
					/*if(!transaccioncliente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TransaccionClienteDataAccess.TABLENAME, transaccioncliente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TransaccionClienteLogic.registrarAuditoriaDetallesTransaccionCliente(connexion,transaccioncliente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TransaccionClienteDataAccess.TABLENAME, transaccioncliente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(transaccioncliente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TransaccionClienteDataAccess.TABLENAME, transaccioncliente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TransaccionClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TransaccionClienteLogic.registrarAuditoriaDetallesTransaccionCliente(connexion,transaccioncliente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTransaccionCliente(Connexion connexion,TransaccionCliente transaccioncliente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(transaccioncliente.getIsNew()||!transaccioncliente.getid_empresa().equals(transaccioncliente.getTransaccionClienteOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccioncliente.getTransaccionClienteOriginal().getid_empresa()!=null)
				{
					strValorActual=transaccioncliente.getTransaccionClienteOriginal().getid_empresa().toString();
				}
				if(transaccioncliente.getid_empresa()!=null)
				{
					strValorNuevo=transaccioncliente.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionClienteConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(transaccioncliente.getIsNew()||!transaccioncliente.getid_modulo().equals(transaccioncliente.getTransaccionClienteOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccioncliente.getTransaccionClienteOriginal().getid_modulo()!=null)
				{
					strValorActual=transaccioncliente.getTransaccionClienteOriginal().getid_modulo().toString();
				}
				if(transaccioncliente.getid_modulo()!=null)
				{
					strValorNuevo=transaccioncliente.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionClienteConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(transaccioncliente.getIsNew()||!transaccioncliente.getnombre().equals(transaccioncliente.getTransaccionClienteOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccioncliente.getTransaccionClienteOriginal().getnombre()!=null)
				{
					strValorActual=transaccioncliente.getTransaccionClienteOriginal().getnombre();
				}
				if(transaccioncliente.getnombre()!=null)
				{
					strValorNuevo=transaccioncliente.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionClienteConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(transaccioncliente.getIsNew()||!transaccioncliente.getid_transaccion1().equals(transaccioncliente.getTransaccionClienteOriginal().getid_transaccion1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccioncliente.getTransaccionClienteOriginal().getid_transaccion1()!=null)
				{
					strValorActual=transaccioncliente.getTransaccionClienteOriginal().getid_transaccion1().toString();
				}
				if(transaccioncliente.getid_transaccion1()!=null)
				{
					strValorNuevo=transaccioncliente.getid_transaccion1().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionClienteConstantesFunciones.IDTRANSACCION1,strValorActual,strValorNuevo);
			}	
			
			if(transaccioncliente.getIsNew()||!transaccioncliente.getid_transaccion2().equals(transaccioncliente.getTransaccionClienteOriginal().getid_transaccion2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccioncliente.getTransaccionClienteOriginal().getid_transaccion2()!=null)
				{
					strValorActual=transaccioncliente.getTransaccionClienteOriginal().getid_transaccion2().toString();
				}
				if(transaccioncliente.getid_transaccion2()!=null)
				{
					strValorNuevo=transaccioncliente.getid_transaccion2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionClienteConstantesFunciones.IDTRANSACCION2,strValorActual,strValorNuevo);
			}	
			
			if(transaccioncliente.getIsNew()||!transaccioncliente.getid_transaccion3().equals(transaccioncliente.getTransaccionClienteOriginal().getid_transaccion3()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccioncliente.getTransaccionClienteOriginal().getid_transaccion3()!=null)
				{
					strValorActual=transaccioncliente.getTransaccionClienteOriginal().getid_transaccion3().toString();
				}
				if(transaccioncliente.getid_transaccion3()!=null)
				{
					strValorNuevo=transaccioncliente.getid_transaccion3().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionClienteConstantesFunciones.IDTRANSACCION3,strValorActual,strValorNuevo);
			}	
			
			if(transaccioncliente.getIsNew()||!transaccioncliente.getid_transaccion4().equals(transaccioncliente.getTransaccionClienteOriginal().getid_transaccion4()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccioncliente.getTransaccionClienteOriginal().getid_transaccion4()!=null)
				{
					strValorActual=transaccioncliente.getTransaccionClienteOriginal().getid_transaccion4().toString();
				}
				if(transaccioncliente.getid_transaccion4()!=null)
				{
					strValorNuevo=transaccioncliente.getid_transaccion4().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionClienteConstantesFunciones.IDTRANSACCION4,strValorActual,strValorNuevo);
			}	
			
			if(transaccioncliente.getIsNew()||!transaccioncliente.getid_transaccion5().equals(transaccioncliente.getTransaccionClienteOriginal().getid_transaccion5()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(transaccioncliente.getTransaccionClienteOriginal().getid_transaccion5()!=null)
				{
					strValorActual=transaccioncliente.getTransaccionClienteOriginal().getid_transaccion5().toString();
				}
				if(transaccioncliente.getid_transaccion5()!=null)
				{
					strValorNuevo=transaccioncliente.getid_transaccion5().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TransaccionClienteConstantesFunciones.IDTRANSACCION5,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTransaccionClienteRelacionesWithConnection(TransaccionCliente transaccioncliente) throws Exception {

		if(!transaccioncliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTransaccionClienteRelacionesBase(transaccioncliente,true);
		}
	}

	public void saveTransaccionClienteRelaciones(TransaccionCliente transaccioncliente)throws Exception {

		if(!transaccioncliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTransaccionClienteRelacionesBase(transaccioncliente,false);
		}
	}

	public void saveTransaccionClienteRelacionesBase(TransaccionCliente transaccioncliente,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TransaccionCliente-saveRelacionesWithConnection");}
	

			this.setTransaccionCliente(transaccioncliente);

			if(TransaccionClienteLogicAdditional.validarSaveRelaciones(transaccioncliente,this)) {

				TransaccionClienteLogicAdditional.updateRelacionesToSave(transaccioncliente,this);

				if((transaccioncliente.getIsNew()||transaccioncliente.getIsChanged())&&!transaccioncliente.getIsDeleted()) {
					this.saveTransaccionCliente();
					this.saveTransaccionClienteRelacionesDetalles();

				} else if(transaccioncliente.getIsDeleted()) {
					this.saveTransaccionClienteRelacionesDetalles();
					this.saveTransaccionCliente();
				}

				TransaccionClienteLogicAdditional.updateRelacionesToSaveAfter(transaccioncliente,this);

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
	
	
	private void saveTransaccionClienteRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTransaccionCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TransaccionClienteConstantesFunciones.getClassesForeignKeysOfTransaccionCliente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransaccionCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TransaccionClienteConstantesFunciones.getClassesRelationshipsOfTransaccionCliente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

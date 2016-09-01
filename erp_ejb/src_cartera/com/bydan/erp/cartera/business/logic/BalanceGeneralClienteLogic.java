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
import com.bydan.erp.cartera.util.BalanceGeneralClienteConstantesFunciones;
import com.bydan.erp.cartera.util.BalanceGeneralClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.BalanceGeneralClienteParameterGeneral;
import com.bydan.erp.cartera.business.entity.BalanceGeneralCliente;
import com.bydan.erp.cartera.business.logic.BalanceGeneralClienteLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class BalanceGeneralClienteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(BalanceGeneralClienteLogic.class);
	
	protected BalanceGeneralClienteDataAccess balancegeneralclienteDataAccess; 	
	protected BalanceGeneralCliente balancegeneralcliente;
	protected List<BalanceGeneralCliente> balancegeneralclientes;
	protected Object balancegeneralclienteObject;	
	protected List<Object> balancegeneralclientesObject;
	
	public static ClassValidator<BalanceGeneralCliente> balancegeneralclienteValidator = new ClassValidator<BalanceGeneralCliente>(BalanceGeneralCliente.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected BalanceGeneralClienteLogicAdditional balancegeneralclienteLogicAdditional=null;
	
	public BalanceGeneralClienteLogicAdditional getBalanceGeneralClienteLogicAdditional() {
		return this.balancegeneralclienteLogicAdditional;
	}
	
	public void setBalanceGeneralClienteLogicAdditional(BalanceGeneralClienteLogicAdditional balancegeneralclienteLogicAdditional) {
		try {
			this.balancegeneralclienteLogicAdditional=balancegeneralclienteLogicAdditional;
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
	
	
	
	
	public  BalanceGeneralClienteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.balancegeneralclienteDataAccess = new BalanceGeneralClienteDataAccess();
			
			this.balancegeneralclientes= new ArrayList<BalanceGeneralCliente>();
			this.balancegeneralcliente= new BalanceGeneralCliente();
			
			this.balancegeneralclienteObject=new Object();
			this.balancegeneralclientesObject=new ArrayList<Object>();
				
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
			
			this.balancegeneralclienteDataAccess.setConnexionType(this.connexionType);
			this.balancegeneralclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  BalanceGeneralClienteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.balancegeneralclienteDataAccess = new BalanceGeneralClienteDataAccess();
			this.balancegeneralclientes= new ArrayList<BalanceGeneralCliente>();
			this.balancegeneralcliente= new BalanceGeneralCliente();
			this.balancegeneralclienteObject=new Object();
			this.balancegeneralclientesObject=new ArrayList<Object>();
			
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
			
			this.balancegeneralclienteDataAccess.setConnexionType(this.connexionType);
			this.balancegeneralclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public BalanceGeneralCliente getBalanceGeneralCliente() throws Exception {	
		BalanceGeneralClienteLogicAdditional.checkBalanceGeneralClienteToGet(balancegeneralcliente,this.datosCliente,this.arrDatoGeneral);
		BalanceGeneralClienteLogicAdditional.updateBalanceGeneralClienteToGet(balancegeneralcliente,this.arrDatoGeneral);
		
		return balancegeneralcliente;
	}
		
	public void setBalanceGeneralCliente(BalanceGeneralCliente newBalanceGeneralCliente) {
		this.balancegeneralcliente = newBalanceGeneralCliente;
	}
	
	public BalanceGeneralClienteDataAccess getBalanceGeneralClienteDataAccess() {
		return balancegeneralclienteDataAccess;
	}
	
	public void setBalanceGeneralClienteDataAccess(BalanceGeneralClienteDataAccess newbalancegeneralclienteDataAccess) {
		this.balancegeneralclienteDataAccess = newbalancegeneralclienteDataAccess;
	}
	
	public List<BalanceGeneralCliente> getBalanceGeneralClientes() throws Exception {		
		this.quitarBalanceGeneralClientesNulos();
		
		BalanceGeneralClienteLogicAdditional.checkBalanceGeneralClienteToGets(balancegeneralclientes,this.datosCliente,this.arrDatoGeneral);
		
		for (BalanceGeneralCliente balancegeneralclienteLocal: balancegeneralclientes ) {
			BalanceGeneralClienteLogicAdditional.updateBalanceGeneralClienteToGet(balancegeneralclienteLocal,this.arrDatoGeneral);
		}
		
		return balancegeneralclientes;
	}
	
	public void setBalanceGeneralClientes(List<BalanceGeneralCliente> newBalanceGeneralClientes) {
		this.balancegeneralclientes = newBalanceGeneralClientes;
	}
	
	public Object getBalanceGeneralClienteObject() {	
		this.balancegeneralclienteObject=this.balancegeneralclienteDataAccess.getEntityObject();
		return this.balancegeneralclienteObject;
	}
		
	public void setBalanceGeneralClienteObject(Object newBalanceGeneralClienteObject) {
		this.balancegeneralclienteObject = newBalanceGeneralClienteObject;
	}
	
	public List<Object> getBalanceGeneralClientesObject() {		
		this.balancegeneralclientesObject=this.balancegeneralclienteDataAccess.getEntitiesObject();
		return this.balancegeneralclientesObject;
	}
		
	public void setBalanceGeneralClientesObject(List<Object> newBalanceGeneralClientesObject) {
		this.balancegeneralclientesObject = newBalanceGeneralClientesObject;
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
		
		if(this.balancegeneralclienteDataAccess!=null) {
			this.balancegeneralclienteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BalanceGeneralCliente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			balancegeneralclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			balancegeneralclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		balancegeneralcliente = new  BalanceGeneralCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BalanceGeneralCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			balancegeneralcliente=balancegeneralclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.balancegeneralcliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(this.balancegeneralcliente);
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
		balancegeneralcliente = new  BalanceGeneralCliente();
		  		  
        try {
			
			balancegeneralcliente=balancegeneralclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.balancegeneralcliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(this.balancegeneralcliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		balancegeneralcliente = new  BalanceGeneralCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BalanceGeneralCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			balancegeneralcliente=balancegeneralclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.balancegeneralcliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(this.balancegeneralcliente);
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
		balancegeneralcliente = new  BalanceGeneralCliente();
		  		  
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
		balancegeneralcliente = new  BalanceGeneralCliente();
		  		  
        try {
			
			balancegeneralcliente=balancegeneralclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.balancegeneralcliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(this.balancegeneralcliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		balancegeneralcliente = new  BalanceGeneralCliente();
		  		  
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
		balancegeneralcliente = new  BalanceGeneralCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BalanceGeneralCliente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =balancegeneralclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		balancegeneralcliente = new  BalanceGeneralCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=balancegeneralclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		balancegeneralcliente = new  BalanceGeneralCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BalanceGeneralCliente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =balancegeneralclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		balancegeneralcliente = new  BalanceGeneralCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=balancegeneralclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		balancegeneralcliente = new  BalanceGeneralCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BalanceGeneralCliente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =balancegeneralclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		balancegeneralcliente = new  BalanceGeneralCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=balancegeneralclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		balancegeneralclientes = new  ArrayList<BalanceGeneralCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BalanceGeneralCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			BalanceGeneralClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			balancegeneralclientes=balancegeneralclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBalanceGeneralCliente(balancegeneralclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(this.balancegeneralclientes);
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
		balancegeneralclientes = new  ArrayList<BalanceGeneralCliente>();
		  		  
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
		balancegeneralclientes = new  ArrayList<BalanceGeneralCliente>();
		  		  
        try {			
			BalanceGeneralClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			balancegeneralclientes=balancegeneralclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarBalanceGeneralCliente(balancegeneralclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(this.balancegeneralclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		balancegeneralclientes = new  ArrayList<BalanceGeneralCliente>();
		  		  
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
		balancegeneralclientes = new  ArrayList<BalanceGeneralCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BalanceGeneralCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			BalanceGeneralClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			balancegeneralclientes=balancegeneralclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBalanceGeneralCliente(balancegeneralclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(this.balancegeneralclientes);
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
		balancegeneralclientes = new  ArrayList<BalanceGeneralCliente>();
		  		  
        try {
			BalanceGeneralClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			balancegeneralclientes=balancegeneralclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBalanceGeneralCliente(balancegeneralclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(this.balancegeneralclientes);
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
		balancegeneralclientes = new  ArrayList<BalanceGeneralCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BalanceGeneralCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BalanceGeneralClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			balancegeneralclientes=balancegeneralclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBalanceGeneralCliente(balancegeneralclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(this.balancegeneralclientes);
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
		balancegeneralclientes = new  ArrayList<BalanceGeneralCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BalanceGeneralClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			balancegeneralclientes=balancegeneralclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBalanceGeneralCliente(balancegeneralclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(this.balancegeneralclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		balancegeneralcliente = new  BalanceGeneralCliente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BalanceGeneralCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BalanceGeneralClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			balancegeneralcliente=balancegeneralclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBalanceGeneralCliente(balancegeneralcliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(this.balancegeneralcliente);
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
		balancegeneralcliente = new  BalanceGeneralCliente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BalanceGeneralClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			balancegeneralcliente=balancegeneralclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBalanceGeneralCliente(balancegeneralcliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(this.balancegeneralcliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		balancegeneralclientes = new  ArrayList<BalanceGeneralCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BalanceGeneralCliente.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			BalanceGeneralClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			balancegeneralclientes=balancegeneralclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBalanceGeneralCliente(balancegeneralclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(this.balancegeneralclientes);
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
		balancegeneralclientes = new  ArrayList<BalanceGeneralCliente>();
		  		  
        try {
			BalanceGeneralClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			balancegeneralclientes=balancegeneralclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBalanceGeneralCliente(balancegeneralclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(this.balancegeneralclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosBalanceGeneralClientesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		balancegeneralclientes = new  ArrayList<BalanceGeneralCliente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BalanceGeneralCliente.class.getSimpleName()+"-getTodosBalanceGeneralClientesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BalanceGeneralClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			balancegeneralclientes=balancegeneralclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarBalanceGeneralCliente(balancegeneralclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(this.balancegeneralclientes);
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
	
	public  void  getTodosBalanceGeneralClientes(String sFinalQuery,Pagination pagination)throws Exception {
		balancegeneralclientes = new  ArrayList<BalanceGeneralCliente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BalanceGeneralClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			balancegeneralclientes=balancegeneralclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarBalanceGeneralCliente(balancegeneralclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(this.balancegeneralclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarBalanceGeneralCliente(BalanceGeneralCliente balancegeneralcliente) throws Exception {
		Boolean estaValidado=false;
		
		if(balancegeneralcliente.getIsNew() || balancegeneralcliente.getIsChanged()) { 
			this.invalidValues = balancegeneralclienteValidator.getInvalidValues(balancegeneralcliente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(balancegeneralcliente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarBalanceGeneralCliente(List<BalanceGeneralCliente> BalanceGeneralClientes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(BalanceGeneralCliente balancegeneralclienteLocal:balancegeneralclientes) {				
			estaValidadoObjeto=this.validarGuardarBalanceGeneralCliente(balancegeneralclienteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarBalanceGeneralCliente(List<BalanceGeneralCliente> BalanceGeneralClientes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarBalanceGeneralCliente(balancegeneralclientes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarBalanceGeneralCliente(BalanceGeneralCliente BalanceGeneralCliente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarBalanceGeneralCliente(balancegeneralcliente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(BalanceGeneralCliente balancegeneralcliente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+balancegeneralcliente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=BalanceGeneralClienteConstantesFunciones.getBalanceGeneralClienteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"balancegeneralcliente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(BalanceGeneralClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(BalanceGeneralClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveBalanceGeneralClienteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BalanceGeneralCliente.class.getSimpleName()+"-saveBalanceGeneralClienteWithConnection");connexion.begin();			
			
			BalanceGeneralClienteLogicAdditional.checkBalanceGeneralClienteToSave(this.balancegeneralcliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			BalanceGeneralClienteLogicAdditional.updateBalanceGeneralClienteToSave(this.balancegeneralcliente,this.arrDatoGeneral);
			
			BalanceGeneralClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.balancegeneralcliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowBalanceGeneralCliente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarBalanceGeneralCliente(this.balancegeneralcliente)) {
				BalanceGeneralClienteDataAccess.save(this.balancegeneralcliente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.balancegeneralcliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			BalanceGeneralClienteLogicAdditional.checkBalanceGeneralClienteToSaveAfter(this.balancegeneralcliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowBalanceGeneralCliente();
			
			connexion.commit();			
			
			if(this.balancegeneralcliente.getIsDeleted()) {
				this.balancegeneralcliente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveBalanceGeneralCliente()throws Exception {	
		try {	
			
			BalanceGeneralClienteLogicAdditional.checkBalanceGeneralClienteToSave(this.balancegeneralcliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			BalanceGeneralClienteLogicAdditional.updateBalanceGeneralClienteToSave(this.balancegeneralcliente,this.arrDatoGeneral);
			
			BalanceGeneralClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.balancegeneralcliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarBalanceGeneralCliente(this.balancegeneralcliente)) {			
				BalanceGeneralClienteDataAccess.save(this.balancegeneralcliente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.balancegeneralcliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			BalanceGeneralClienteLogicAdditional.checkBalanceGeneralClienteToSaveAfter(this.balancegeneralcliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.balancegeneralcliente.getIsDeleted()) {
				this.balancegeneralcliente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveBalanceGeneralClientesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BalanceGeneralCliente.class.getSimpleName()+"-saveBalanceGeneralClientesWithConnection");connexion.begin();			
			
			BalanceGeneralClienteLogicAdditional.checkBalanceGeneralClienteToSaves(balancegeneralclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowBalanceGeneralClientes();
			
			Boolean validadoTodosBalanceGeneralCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(BalanceGeneralCliente balancegeneralclienteLocal:balancegeneralclientes) {		
				if(balancegeneralclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				BalanceGeneralClienteLogicAdditional.updateBalanceGeneralClienteToSave(balancegeneralclienteLocal,this.arrDatoGeneral);
	        	
				BalanceGeneralClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),balancegeneralclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarBalanceGeneralCliente(balancegeneralclienteLocal)) {
					BalanceGeneralClienteDataAccess.save(balancegeneralclienteLocal, connexion);				
				} else {
					validadoTodosBalanceGeneralCliente=false;
				}
			}
			
			if(!validadoTodosBalanceGeneralCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			BalanceGeneralClienteLogicAdditional.checkBalanceGeneralClienteToSavesAfter(balancegeneralclientes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowBalanceGeneralClientes();
			
			connexion.commit();		
			
			this.quitarBalanceGeneralClientesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveBalanceGeneralClientes()throws Exception {				
		 try {	
			BalanceGeneralClienteLogicAdditional.checkBalanceGeneralClienteToSaves(balancegeneralclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosBalanceGeneralCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(BalanceGeneralCliente balancegeneralclienteLocal:balancegeneralclientes) {				
				if(balancegeneralclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				BalanceGeneralClienteLogicAdditional.updateBalanceGeneralClienteToSave(balancegeneralclienteLocal,this.arrDatoGeneral);
	        	
				BalanceGeneralClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),balancegeneralclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarBalanceGeneralCliente(balancegeneralclienteLocal)) {				
					BalanceGeneralClienteDataAccess.save(balancegeneralclienteLocal, connexion);				
				} else {
					validadoTodosBalanceGeneralCliente=false;
				}
			}
			
			if(!validadoTodosBalanceGeneralCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			BalanceGeneralClienteLogicAdditional.checkBalanceGeneralClienteToSavesAfter(balancegeneralclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarBalanceGeneralClientesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public BalanceGeneralClienteParameterReturnGeneral procesarAccionBalanceGeneralClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<BalanceGeneralCliente> balancegeneralclientes,BalanceGeneralClienteParameterReturnGeneral balancegeneralclienteParameterGeneral)throws Exception {
		 try {	
			BalanceGeneralClienteParameterReturnGeneral balancegeneralclienteReturnGeneral=new BalanceGeneralClienteParameterReturnGeneral();
	
			BalanceGeneralClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,balancegeneralclientes,balancegeneralclienteParameterGeneral,balancegeneralclienteReturnGeneral);
			
			return balancegeneralclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public BalanceGeneralClienteParameterReturnGeneral procesarAccionBalanceGeneralClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<BalanceGeneralCliente> balancegeneralclientes,BalanceGeneralClienteParameterReturnGeneral balancegeneralclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BalanceGeneralCliente.class.getSimpleName()+"-procesarAccionBalanceGeneralClientesWithConnection");connexion.begin();			
			
			BalanceGeneralClienteParameterReturnGeneral balancegeneralclienteReturnGeneral=new BalanceGeneralClienteParameterReturnGeneral();
	
			BalanceGeneralClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,balancegeneralclientes,balancegeneralclienteParameterGeneral,balancegeneralclienteReturnGeneral);
			
			this.connexion.commit();
			
			return balancegeneralclienteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public BalanceGeneralClienteParameterReturnGeneral procesarEventosBalanceGeneralClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<BalanceGeneralCliente> balancegeneralclientes,BalanceGeneralCliente balancegeneralcliente,BalanceGeneralClienteParameterReturnGeneral balancegeneralclienteParameterGeneral,Boolean isEsNuevoBalanceGeneralCliente,ArrayList<Classe> clases)throws Exception {
		 try {	
			BalanceGeneralClienteParameterReturnGeneral balancegeneralclienteReturnGeneral=new BalanceGeneralClienteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				balancegeneralclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			BalanceGeneralClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,balancegeneralclientes,balancegeneralcliente,balancegeneralclienteParameterGeneral,balancegeneralclienteReturnGeneral,isEsNuevoBalanceGeneralCliente,clases);
			
			return balancegeneralclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public BalanceGeneralClienteParameterReturnGeneral procesarEventosBalanceGeneralClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<BalanceGeneralCliente> balancegeneralclientes,BalanceGeneralCliente balancegeneralcliente,BalanceGeneralClienteParameterReturnGeneral balancegeneralclienteParameterGeneral,Boolean isEsNuevoBalanceGeneralCliente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BalanceGeneralCliente.class.getSimpleName()+"-procesarEventosBalanceGeneralClientesWithConnection");connexion.begin();			
			
			BalanceGeneralClienteParameterReturnGeneral balancegeneralclienteReturnGeneral=new BalanceGeneralClienteParameterReturnGeneral();
	
			balancegeneralclienteReturnGeneral.setBalanceGeneralCliente(balancegeneralcliente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				balancegeneralclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			BalanceGeneralClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,balancegeneralclientes,balancegeneralcliente,balancegeneralclienteParameterGeneral,balancegeneralclienteReturnGeneral,isEsNuevoBalanceGeneralCliente,clases);
			
			this.connexion.commit();
			
			return balancegeneralclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public BalanceGeneralClienteParameterReturnGeneral procesarImportacionBalanceGeneralClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,BalanceGeneralClienteParameterReturnGeneral balancegeneralclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BalanceGeneralCliente.class.getSimpleName()+"-procesarImportacionBalanceGeneralClientesWithConnection");connexion.begin();			
			
			BalanceGeneralClienteParameterReturnGeneral balancegeneralclienteReturnGeneral=new BalanceGeneralClienteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.balancegeneralclientes=new ArrayList<BalanceGeneralCliente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.balancegeneralcliente=new BalanceGeneralCliente();
				
				
				if(conColumnasBase) {this.balancegeneralcliente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.balancegeneralcliente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.balancegeneralcliente.setcaja_bancos_disponible(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setcuentas_por_cobrar_clientes(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setinventario(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setotros_activos_corrientes(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.settotal_activos_corrientes(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setbienes_inmuebles(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setbienes_muebles(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setotros_activos_no_corrientes(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.settotal_activos_no_corrientes(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setventas_mensuales(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setcosto_ventas_mensuales(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setutilidad_bruta(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setgastos_operativos(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setsueldos(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setservicios(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setarriendos(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setimpuestos(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setutilidad_operativa(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setgastos_familiares(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setexcedente_antes_dividendos(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setdividendos_bancos_otros(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setexedente_neto_mensual(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setdeudas_bancarias(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setcuentas_por_pagar(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setanticipos_recibos(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setotras_cuentas_por_pagar(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setotras_deudas_familiares(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.settotal_pasivo_corriente(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setdeudas_bancarias_largo_plazo(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setotros_pasivos_largo_plazo(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.settotal_pasivo_no_corriente(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.settotal_pasivo(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setpatrimonio(Double.parseDouble(arrColumnas[iColumn++]));
				this.balancegeneralcliente.setdescripcion(arrColumnas[iColumn++]);
				
				this.balancegeneralclientes.add(this.balancegeneralcliente);
			}
			
			this.saveBalanceGeneralClientes();
			
			this.connexion.commit();
			
			balancegeneralclienteReturnGeneral.setConRetornoEstaProcesado(true);
			balancegeneralclienteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return balancegeneralclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarBalanceGeneralClientesEliminados() throws Exception {				
		
		List<BalanceGeneralCliente> balancegeneralclientesAux= new ArrayList<BalanceGeneralCliente>();
		
		for(BalanceGeneralCliente balancegeneralcliente:balancegeneralclientes) {
			if(!balancegeneralcliente.getIsDeleted()) {
				balancegeneralclientesAux.add(balancegeneralcliente);
			}
		}
		
		balancegeneralclientes=balancegeneralclientesAux;
	}
	
	public void quitarBalanceGeneralClientesNulos() throws Exception {				
		
		List<BalanceGeneralCliente> balancegeneralclientesAux= new ArrayList<BalanceGeneralCliente>();
		
		for(BalanceGeneralCliente balancegeneralcliente : this.balancegeneralclientes) {
			if(balancegeneralcliente==null) {
				balancegeneralclientesAux.add(balancegeneralcliente);
			}
		}
		
		//this.balancegeneralclientes=balancegeneralclientesAux;
		
		this.balancegeneralclientes.removeAll(balancegeneralclientesAux);
	}
	
	public void getSetVersionRowBalanceGeneralClienteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(balancegeneralcliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((balancegeneralcliente.getIsDeleted() || (balancegeneralcliente.getIsChanged()&&!balancegeneralcliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=balancegeneralclienteDataAccess.getSetVersionRowBalanceGeneralCliente(connexion,balancegeneralcliente.getId());
				
				if(!balancegeneralcliente.getVersionRow().equals(timestamp)) {	
					balancegeneralcliente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				balancegeneralcliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowBalanceGeneralCliente()throws Exception {	
		
		if(balancegeneralcliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((balancegeneralcliente.getIsDeleted() || (balancegeneralcliente.getIsChanged()&&!balancegeneralcliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=balancegeneralclienteDataAccess.getSetVersionRowBalanceGeneralCliente(connexion,balancegeneralcliente.getId());
			
			try {							
				if(!balancegeneralcliente.getVersionRow().equals(timestamp)) {	
					balancegeneralcliente.setVersionRow(timestamp);
				}
				
				balancegeneralcliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowBalanceGeneralClientesWithConnection()throws Exception {	
		if(balancegeneralclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(BalanceGeneralCliente balancegeneralclienteAux:balancegeneralclientes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(balancegeneralclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(balancegeneralclienteAux.getIsDeleted() || (balancegeneralclienteAux.getIsChanged()&&!balancegeneralclienteAux.getIsNew())) {
						
						timestamp=balancegeneralclienteDataAccess.getSetVersionRowBalanceGeneralCliente(connexion,balancegeneralclienteAux.getId());
						
						if(!balancegeneralcliente.getVersionRow().equals(timestamp)) {	
							balancegeneralclienteAux.setVersionRow(timestamp);
						}
								
						balancegeneralclienteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowBalanceGeneralClientes()throws Exception {	
		if(balancegeneralclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(BalanceGeneralCliente balancegeneralclienteAux:balancegeneralclientes) {
					if(balancegeneralclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(balancegeneralclienteAux.getIsDeleted() || (balancegeneralclienteAux.getIsChanged()&&!balancegeneralclienteAux.getIsNew())) {
						
						timestamp=balancegeneralclienteDataAccess.getSetVersionRowBalanceGeneralCliente(connexion,balancegeneralclienteAux.getId());
						
						if(!balancegeneralclienteAux.getVersionRow().equals(timestamp)) {	
							balancegeneralclienteAux.setVersionRow(timestamp);
						}
						
													
						balancegeneralclienteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public BalanceGeneralClienteParameterReturnGeneral cargarCombosLoteForeignKeyBalanceGeneralClienteWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente) throws Exception {
		BalanceGeneralClienteParameterReturnGeneral  balancegeneralclienteReturnGeneral =new BalanceGeneralClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BalanceGeneralCliente.class.getSimpleName()+"-cargarCombosLoteForeignKeyBalanceGeneralClienteWithConnection");connexion.begin();
			
			balancegeneralclienteReturnGeneral =new BalanceGeneralClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			balancegeneralclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			balancegeneralclienteReturnGeneral.setclientesForeignKey(clientesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return balancegeneralclienteReturnGeneral;
	}
	
	public BalanceGeneralClienteParameterReturnGeneral cargarCombosLoteForeignKeyBalanceGeneralCliente(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente) throws Exception {
		BalanceGeneralClienteParameterReturnGeneral  balancegeneralclienteReturnGeneral =new BalanceGeneralClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			balancegeneralclienteReturnGeneral =new BalanceGeneralClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			balancegeneralclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			balancegeneralclienteReturnGeneral.setclientesForeignKey(clientesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return balancegeneralclienteReturnGeneral;
	}
	
	
	public void deepLoad(BalanceGeneralCliente balancegeneralcliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			BalanceGeneralClienteLogicAdditional.updateBalanceGeneralClienteToGet(balancegeneralcliente,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		balancegeneralcliente.setEmpresa(balancegeneralclienteDataAccess.getEmpresa(connexion,balancegeneralcliente));
		balancegeneralcliente.setCliente(balancegeneralclienteDataAccess.getCliente(connexion,balancegeneralcliente));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				balancegeneralcliente.setEmpresa(balancegeneralclienteDataAccess.getEmpresa(connexion,balancegeneralcliente));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				balancegeneralcliente.setCliente(balancegeneralclienteDataAccess.getCliente(connexion,balancegeneralcliente));
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
			balancegeneralcliente.setEmpresa(balancegeneralclienteDataAccess.getEmpresa(connexion,balancegeneralcliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			balancegeneralcliente.setCliente(balancegeneralclienteDataAccess.getCliente(connexion,balancegeneralcliente));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		balancegeneralcliente.setEmpresa(balancegeneralclienteDataAccess.getEmpresa(connexion,balancegeneralcliente));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(balancegeneralcliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		balancegeneralcliente.setCliente(balancegeneralclienteDataAccess.getCliente(connexion,balancegeneralcliente));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(balancegeneralcliente.getCliente(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				balancegeneralcliente.setEmpresa(balancegeneralclienteDataAccess.getEmpresa(connexion,balancegeneralcliente));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(balancegeneralcliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				balancegeneralcliente.setCliente(balancegeneralclienteDataAccess.getCliente(connexion,balancegeneralcliente));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(balancegeneralcliente.getCliente(),isDeep,deepLoadType,clases);				
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
			balancegeneralcliente.setEmpresa(balancegeneralclienteDataAccess.getEmpresa(connexion,balancegeneralcliente));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(balancegeneralcliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			balancegeneralcliente.setCliente(balancegeneralclienteDataAccess.getCliente(connexion,balancegeneralcliente));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(balancegeneralcliente.getCliente(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(BalanceGeneralCliente balancegeneralcliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			BalanceGeneralClienteLogicAdditional.updateBalanceGeneralClienteToSave(balancegeneralcliente,this.arrDatoGeneral);
			
BalanceGeneralClienteDataAccess.save(balancegeneralcliente, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(balancegeneralcliente.getEmpresa(),connexion);

		ClienteDataAccess.save(balancegeneralcliente.getCliente(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(balancegeneralcliente.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(balancegeneralcliente.getCliente(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(balancegeneralcliente.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(balancegeneralcliente.getEmpresa(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(balancegeneralcliente.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(balancegeneralcliente.getCliente(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(balancegeneralcliente.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(balancegeneralcliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(balancegeneralcliente.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(balancegeneralcliente.getCliente(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(BalanceGeneralCliente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(balancegeneralcliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(balancegeneralcliente);
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
			this.deepLoad(this.balancegeneralcliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(this.balancegeneralcliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(BalanceGeneralCliente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(balancegeneralclientes!=null) {
				for(BalanceGeneralCliente balancegeneralcliente:balancegeneralclientes) {
					this.deepLoad(balancegeneralcliente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(balancegeneralclientes);
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
			if(balancegeneralclientes!=null) {
				for(BalanceGeneralCliente balancegeneralcliente:balancegeneralclientes) {
					this.deepLoad(balancegeneralcliente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(balancegeneralclientes);
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
			this.getNewConnexionToDeep(BalanceGeneralCliente.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(balancegeneralcliente,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(BalanceGeneralCliente.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(balancegeneralclientes!=null) {
				for(BalanceGeneralCliente balancegeneralcliente:balancegeneralclientes) {
					this.deepSave(balancegeneralcliente,isDeep,deepLoadType,clases);
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
			if(balancegeneralclientes!=null) {
				for(BalanceGeneralCliente balancegeneralcliente:balancegeneralclientes) {
					this.deepSave(balancegeneralcliente,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getBalanceGeneralClientesFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BalanceGeneralCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,BalanceGeneralClienteConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			BalanceGeneralClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			balancegeneralclientes=balancegeneralclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(this.balancegeneralclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBalanceGeneralClientesFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,BalanceGeneralClienteConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			BalanceGeneralClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			balancegeneralclientes=balancegeneralclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(this.balancegeneralclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBalanceGeneralClientesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BalanceGeneralCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,BalanceGeneralClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			BalanceGeneralClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			balancegeneralclientes=balancegeneralclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(this.balancegeneralclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBalanceGeneralClientesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,BalanceGeneralClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			BalanceGeneralClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			balancegeneralclientes=balancegeneralclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(this.balancegeneralclientes);
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
			if(BalanceGeneralClienteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,BalanceGeneralClienteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,BalanceGeneralCliente balancegeneralcliente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(BalanceGeneralClienteConstantesFunciones.ISCONAUDITORIA) {
				if(balancegeneralcliente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BalanceGeneralClienteDataAccess.TABLENAME, balancegeneralcliente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(BalanceGeneralClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////BalanceGeneralClienteLogic.registrarAuditoriaDetallesBalanceGeneralCliente(connexion,balancegeneralcliente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(balancegeneralcliente.getIsDeleted()) {
					/*if(!balancegeneralcliente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,BalanceGeneralClienteDataAccess.TABLENAME, balancegeneralcliente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////BalanceGeneralClienteLogic.registrarAuditoriaDetallesBalanceGeneralCliente(connexion,balancegeneralcliente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BalanceGeneralClienteDataAccess.TABLENAME, balancegeneralcliente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(balancegeneralcliente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BalanceGeneralClienteDataAccess.TABLENAME, balancegeneralcliente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(BalanceGeneralClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////BalanceGeneralClienteLogic.registrarAuditoriaDetallesBalanceGeneralCliente(connexion,balancegeneralcliente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesBalanceGeneralCliente(Connexion connexion,BalanceGeneralCliente balancegeneralcliente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getid_empresa().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getid_empresa()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getid_empresa().toString();
				}
				if(balancegeneralcliente.getid_empresa()!=null)
				{
					strValorNuevo=balancegeneralcliente.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getid_cliente().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getid_cliente()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getid_cliente().toString();
				}
				if(balancegeneralcliente.getid_cliente()!=null)
				{
					strValorNuevo=balancegeneralcliente.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getcaja_bancos_disponible().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getcaja_bancos_disponible()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getcaja_bancos_disponible()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getcaja_bancos_disponible().toString();
				}
				if(balancegeneralcliente.getcaja_bancos_disponible()!=null)
				{
					strValorNuevo=balancegeneralcliente.getcaja_bancos_disponible().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.CAJABANCOSDISPONIBLE,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getcuentas_por_cobrar_clientes().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getcuentas_por_cobrar_clientes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getcuentas_por_cobrar_clientes()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getcuentas_por_cobrar_clientes().toString();
				}
				if(balancegeneralcliente.getcuentas_por_cobrar_clientes()!=null)
				{
					strValorNuevo=balancegeneralcliente.getcuentas_por_cobrar_clientes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.CUENTASPORCOBRARCLIENTES,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getinventario().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getinventario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getinventario()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getinventario().toString();
				}
				if(balancegeneralcliente.getinventario()!=null)
				{
					strValorNuevo=balancegeneralcliente.getinventario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.INVENTARIO,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getotros_activos_corrientes().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getotros_activos_corrientes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getotros_activos_corrientes()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getotros_activos_corrientes().toString();
				}
				if(balancegeneralcliente.getotros_activos_corrientes()!=null)
				{
					strValorNuevo=balancegeneralcliente.getotros_activos_corrientes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.OTROSACTIVOSCORRIENTES,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.gettotal_activos_corrientes().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().gettotal_activos_corrientes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().gettotal_activos_corrientes()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().gettotal_activos_corrientes().toString();
				}
				if(balancegeneralcliente.gettotal_activos_corrientes()!=null)
				{
					strValorNuevo=balancegeneralcliente.gettotal_activos_corrientes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.TOTALACTIVOSCORRIENTES,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getbienes_inmuebles().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getbienes_inmuebles()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getbienes_inmuebles()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getbienes_inmuebles().toString();
				}
				if(balancegeneralcliente.getbienes_inmuebles()!=null)
				{
					strValorNuevo=balancegeneralcliente.getbienes_inmuebles().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.BIENESINMUEBLES,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getbienes_muebles().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getbienes_muebles()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getbienes_muebles()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getbienes_muebles().toString();
				}
				if(balancegeneralcliente.getbienes_muebles()!=null)
				{
					strValorNuevo=balancegeneralcliente.getbienes_muebles().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.BIENESMUEBLES,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getotros_activos_no_corrientes().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getotros_activos_no_corrientes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getotros_activos_no_corrientes()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getotros_activos_no_corrientes().toString();
				}
				if(balancegeneralcliente.getotros_activos_no_corrientes()!=null)
				{
					strValorNuevo=balancegeneralcliente.getotros_activos_no_corrientes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.OTROSACTIVOSNOCORRIENTES,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.gettotal_activos_no_corrientes().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().gettotal_activos_no_corrientes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().gettotal_activos_no_corrientes()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().gettotal_activos_no_corrientes().toString();
				}
				if(balancegeneralcliente.gettotal_activos_no_corrientes()!=null)
				{
					strValorNuevo=balancegeneralcliente.gettotal_activos_no_corrientes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.TOTALACTIVOSNOCORRIENTES,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getventas_mensuales().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getventas_mensuales()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getventas_mensuales()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getventas_mensuales().toString();
				}
				if(balancegeneralcliente.getventas_mensuales()!=null)
				{
					strValorNuevo=balancegeneralcliente.getventas_mensuales().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.VENTASMENSUALES,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getcosto_ventas_mensuales().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getcosto_ventas_mensuales()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getcosto_ventas_mensuales()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getcosto_ventas_mensuales().toString();
				}
				if(balancegeneralcliente.getcosto_ventas_mensuales()!=null)
				{
					strValorNuevo=balancegeneralcliente.getcosto_ventas_mensuales().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.COSTOVENTASMENSUALES,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getutilidad_bruta().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getutilidad_bruta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getutilidad_bruta()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getutilidad_bruta().toString();
				}
				if(balancegeneralcliente.getutilidad_bruta()!=null)
				{
					strValorNuevo=balancegeneralcliente.getutilidad_bruta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.UTILIDADBRUTA,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getgastos_operativos().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getgastos_operativos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getgastos_operativos()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getgastos_operativos().toString();
				}
				if(balancegeneralcliente.getgastos_operativos()!=null)
				{
					strValorNuevo=balancegeneralcliente.getgastos_operativos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.GASTOSOPERATIVOS,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getsueldos().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getsueldos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getsueldos()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getsueldos().toString();
				}
				if(balancegeneralcliente.getsueldos()!=null)
				{
					strValorNuevo=balancegeneralcliente.getsueldos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.SUELDOS,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getservicios().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getservicios()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getservicios()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getservicios().toString();
				}
				if(balancegeneralcliente.getservicios()!=null)
				{
					strValorNuevo=balancegeneralcliente.getservicios().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.SERVICIOS,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getarriendos().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getarriendos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getarriendos()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getarriendos().toString();
				}
				if(balancegeneralcliente.getarriendos()!=null)
				{
					strValorNuevo=balancegeneralcliente.getarriendos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.ARRIENDOS,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getimpuestos().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getimpuestos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getimpuestos()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getimpuestos().toString();
				}
				if(balancegeneralcliente.getimpuestos()!=null)
				{
					strValorNuevo=balancegeneralcliente.getimpuestos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.IMPUESTOS,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getutilidad_operativa().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getutilidad_operativa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getutilidad_operativa()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getutilidad_operativa().toString();
				}
				if(balancegeneralcliente.getutilidad_operativa()!=null)
				{
					strValorNuevo=balancegeneralcliente.getutilidad_operativa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.UTILIDADOPERATIVA,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getgastos_familiares().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getgastos_familiares()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getgastos_familiares()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getgastos_familiares().toString();
				}
				if(balancegeneralcliente.getgastos_familiares()!=null)
				{
					strValorNuevo=balancegeneralcliente.getgastos_familiares().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.GASTOSFAMILIARES,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getexcedente_antes_dividendos().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getexcedente_antes_dividendos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getexcedente_antes_dividendos()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getexcedente_antes_dividendos().toString();
				}
				if(balancegeneralcliente.getexcedente_antes_dividendos()!=null)
				{
					strValorNuevo=balancegeneralcliente.getexcedente_antes_dividendos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.EXCEDENTEANTESDIVIDENDOS,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getdividendos_bancos_otros().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getdividendos_bancos_otros()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getdividendos_bancos_otros()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getdividendos_bancos_otros().toString();
				}
				if(balancegeneralcliente.getdividendos_bancos_otros()!=null)
				{
					strValorNuevo=balancegeneralcliente.getdividendos_bancos_otros().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.DIVIDENDOSBANCOSOTROS,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getexedente_neto_mensual().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getexedente_neto_mensual()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getexedente_neto_mensual()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getexedente_neto_mensual().toString();
				}
				if(balancegeneralcliente.getexedente_neto_mensual()!=null)
				{
					strValorNuevo=balancegeneralcliente.getexedente_neto_mensual().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.EXEDENTENETOMENSUAL,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getdeudas_bancarias().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getdeudas_bancarias()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getdeudas_bancarias()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getdeudas_bancarias().toString();
				}
				if(balancegeneralcliente.getdeudas_bancarias()!=null)
				{
					strValorNuevo=balancegeneralcliente.getdeudas_bancarias().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.DEUDASBANCARIAS,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getcuentas_por_pagar().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getcuentas_por_pagar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getcuentas_por_pagar()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getcuentas_por_pagar().toString();
				}
				if(balancegeneralcliente.getcuentas_por_pagar()!=null)
				{
					strValorNuevo=balancegeneralcliente.getcuentas_por_pagar().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.CUENTASPORPAGAR,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getanticipos_recibos().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getanticipos_recibos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getanticipos_recibos()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getanticipos_recibos().toString();
				}
				if(balancegeneralcliente.getanticipos_recibos()!=null)
				{
					strValorNuevo=balancegeneralcliente.getanticipos_recibos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.ANTICIPOSRECIBOS,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getotras_cuentas_por_pagar().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getotras_cuentas_por_pagar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getotras_cuentas_por_pagar()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getotras_cuentas_por_pagar().toString();
				}
				if(balancegeneralcliente.getotras_cuentas_por_pagar()!=null)
				{
					strValorNuevo=balancegeneralcliente.getotras_cuentas_por_pagar().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.OTRASCUENTASPORPAGAR,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getotras_deudas_familiares().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getotras_deudas_familiares()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getotras_deudas_familiares()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getotras_deudas_familiares().toString();
				}
				if(balancegeneralcliente.getotras_deudas_familiares()!=null)
				{
					strValorNuevo=balancegeneralcliente.getotras_deudas_familiares().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.OTRASDEUDASFAMILIARES,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.gettotal_pasivo_corriente().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().gettotal_pasivo_corriente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().gettotal_pasivo_corriente()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().gettotal_pasivo_corriente().toString();
				}
				if(balancegeneralcliente.gettotal_pasivo_corriente()!=null)
				{
					strValorNuevo=balancegeneralcliente.gettotal_pasivo_corriente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.TOTALPASIVOCORRIENTE,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getdeudas_bancarias_largo_plazo().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getdeudas_bancarias_largo_plazo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getdeudas_bancarias_largo_plazo()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getdeudas_bancarias_largo_plazo().toString();
				}
				if(balancegeneralcliente.getdeudas_bancarias_largo_plazo()!=null)
				{
					strValorNuevo=balancegeneralcliente.getdeudas_bancarias_largo_plazo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.DEUDASBANCARIASLARGOPLAZO,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getotros_pasivos_largo_plazo().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getotros_pasivos_largo_plazo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getotros_pasivos_largo_plazo()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getotros_pasivos_largo_plazo().toString();
				}
				if(balancegeneralcliente.getotros_pasivos_largo_plazo()!=null)
				{
					strValorNuevo=balancegeneralcliente.getotros_pasivos_largo_plazo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.OTROSPASIVOSLARGOPLAZO,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.gettotal_pasivo_no_corriente().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().gettotal_pasivo_no_corriente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().gettotal_pasivo_no_corriente()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().gettotal_pasivo_no_corriente().toString();
				}
				if(balancegeneralcliente.gettotal_pasivo_no_corriente()!=null)
				{
					strValorNuevo=balancegeneralcliente.gettotal_pasivo_no_corriente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.TOTALPASIVONOCORRIENTE,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.gettotal_pasivo().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().gettotal_pasivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().gettotal_pasivo()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().gettotal_pasivo().toString();
				}
				if(balancegeneralcliente.gettotal_pasivo()!=null)
				{
					strValorNuevo=balancegeneralcliente.gettotal_pasivo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.TOTALPASIVO,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getpatrimonio().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getpatrimonio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getpatrimonio()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getpatrimonio().toString();
				}
				if(balancegeneralcliente.getpatrimonio()!=null)
				{
					strValorNuevo=balancegeneralcliente.getpatrimonio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.PATRIMONIO,strValorActual,strValorNuevo);
			}	
			
			if(balancegeneralcliente.getIsNew()||!balancegeneralcliente.getdescripcion().equals(balancegeneralcliente.getBalanceGeneralClienteOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(balancegeneralcliente.getBalanceGeneralClienteOriginal().getdescripcion()!=null)
				{
					strValorActual=balancegeneralcliente.getBalanceGeneralClienteOriginal().getdescripcion();
				}
				if(balancegeneralcliente.getdescripcion()!=null)
				{
					strValorNuevo=balancegeneralcliente.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BalanceGeneralClienteConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveBalanceGeneralClienteRelacionesWithConnection(BalanceGeneralCliente balancegeneralcliente) throws Exception {

		if(!balancegeneralcliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveBalanceGeneralClienteRelacionesBase(balancegeneralcliente,true);
		}
	}

	public void saveBalanceGeneralClienteRelaciones(BalanceGeneralCliente balancegeneralcliente)throws Exception {

		if(!balancegeneralcliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveBalanceGeneralClienteRelacionesBase(balancegeneralcliente,false);
		}
	}

	public void saveBalanceGeneralClienteRelacionesBase(BalanceGeneralCliente balancegeneralcliente,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("BalanceGeneralCliente-saveRelacionesWithConnection");}
	

			this.setBalanceGeneralCliente(balancegeneralcliente);

			if(BalanceGeneralClienteLogicAdditional.validarSaveRelaciones(balancegeneralcliente,this)) {

				BalanceGeneralClienteLogicAdditional.updateRelacionesToSave(balancegeneralcliente,this);

				if((balancegeneralcliente.getIsNew()||balancegeneralcliente.getIsChanged())&&!balancegeneralcliente.getIsDeleted()) {
					this.saveBalanceGeneralCliente();
					this.saveBalanceGeneralClienteRelacionesDetalles();

				} else if(balancegeneralcliente.getIsDeleted()) {
					this.saveBalanceGeneralClienteRelacionesDetalles();
					this.saveBalanceGeneralCliente();
				}

				BalanceGeneralClienteLogicAdditional.updateRelacionesToSaveAfter(balancegeneralcliente,this);

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
	
	
	private void saveBalanceGeneralClienteRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfBalanceGeneralCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=BalanceGeneralClienteConstantesFunciones.getClassesForeignKeysOfBalanceGeneralCliente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBalanceGeneralCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=BalanceGeneralClienteConstantesFunciones.getClassesRelationshipsOfBalanceGeneralCliente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

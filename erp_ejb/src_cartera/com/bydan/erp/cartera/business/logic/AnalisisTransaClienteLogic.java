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
import com.bydan.erp.cartera.util.AnalisisTransaClienteConstantesFunciones;
import com.bydan.erp.cartera.util.AnalisisTransaClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.AnalisisTransaClienteParameterGeneral;
import com.bydan.erp.cartera.business.entity.AnalisisTransaCliente;
import com.bydan.erp.cartera.business.logic.AnalisisTransaClienteLogicAdditional;
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
public class AnalisisTransaClienteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(AnalisisTransaClienteLogic.class);
	
	protected AnalisisTransaClienteDataAccess analisistransaclienteDataAccess; 	
	protected AnalisisTransaCliente analisistransacliente;
	protected List<AnalisisTransaCliente> analisistransaclientes;
	protected Object analisistransaclienteObject;	
	protected List<Object> analisistransaclientesObject;
	
	public static ClassValidator<AnalisisTransaCliente> analisistransaclienteValidator = new ClassValidator<AnalisisTransaCliente>(AnalisisTransaCliente.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected AnalisisTransaClienteLogicAdditional analisistransaclienteLogicAdditional=null;
	
	public AnalisisTransaClienteLogicAdditional getAnalisisTransaClienteLogicAdditional() {
		return this.analisistransaclienteLogicAdditional;
	}
	
	public void setAnalisisTransaClienteLogicAdditional(AnalisisTransaClienteLogicAdditional analisistransaclienteLogicAdditional) {
		try {
			this.analisistransaclienteLogicAdditional=analisistransaclienteLogicAdditional;
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
	
	
	
	
	public  AnalisisTransaClienteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.analisistransaclienteDataAccess = new AnalisisTransaClienteDataAccess();
			
			this.analisistransaclientes= new ArrayList<AnalisisTransaCliente>();
			this.analisistransacliente= new AnalisisTransaCliente();
			
			this.analisistransaclienteObject=new Object();
			this.analisistransaclientesObject=new ArrayList<Object>();
				
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
			
			this.analisistransaclienteDataAccess.setConnexionType(this.connexionType);
			this.analisistransaclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  AnalisisTransaClienteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.analisistransaclienteDataAccess = new AnalisisTransaClienteDataAccess();
			this.analisistransaclientes= new ArrayList<AnalisisTransaCliente>();
			this.analisistransacliente= new AnalisisTransaCliente();
			this.analisistransaclienteObject=new Object();
			this.analisistransaclientesObject=new ArrayList<Object>();
			
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
			
			this.analisistransaclienteDataAccess.setConnexionType(this.connexionType);
			this.analisistransaclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public AnalisisTransaCliente getAnalisisTransaCliente() throws Exception {	
		AnalisisTransaClienteLogicAdditional.checkAnalisisTransaClienteToGet(analisistransacliente,this.datosCliente,this.arrDatoGeneral);
		AnalisisTransaClienteLogicAdditional.updateAnalisisTransaClienteToGet(analisistransacliente,this.arrDatoGeneral);
		
		return analisistransacliente;
	}
		
	public void setAnalisisTransaCliente(AnalisisTransaCliente newAnalisisTransaCliente) {
		this.analisistransacliente = newAnalisisTransaCliente;
	}
	
	public AnalisisTransaClienteDataAccess getAnalisisTransaClienteDataAccess() {
		return analisistransaclienteDataAccess;
	}
	
	public void setAnalisisTransaClienteDataAccess(AnalisisTransaClienteDataAccess newanalisistransaclienteDataAccess) {
		this.analisistransaclienteDataAccess = newanalisistransaclienteDataAccess;
	}
	
	public List<AnalisisTransaCliente> getAnalisisTransaClientes() throws Exception {		
		this.quitarAnalisisTransaClientesNulos();
		
		AnalisisTransaClienteLogicAdditional.checkAnalisisTransaClienteToGets(analisistransaclientes,this.datosCliente,this.arrDatoGeneral);
		
		for (AnalisisTransaCliente analisistransaclienteLocal: analisistransaclientes ) {
			AnalisisTransaClienteLogicAdditional.updateAnalisisTransaClienteToGet(analisistransaclienteLocal,this.arrDatoGeneral);
		}
		
		return analisistransaclientes;
	}
	
	public void setAnalisisTransaClientes(List<AnalisisTransaCliente> newAnalisisTransaClientes) {
		this.analisistransaclientes = newAnalisisTransaClientes;
	}
	
	public Object getAnalisisTransaClienteObject() {	
		this.analisistransaclienteObject=this.analisistransaclienteDataAccess.getEntityObject();
		return this.analisistransaclienteObject;
	}
		
	public void setAnalisisTransaClienteObject(Object newAnalisisTransaClienteObject) {
		this.analisistransaclienteObject = newAnalisisTransaClienteObject;
	}
	
	public List<Object> getAnalisisTransaClientesObject() {		
		this.analisistransaclientesObject=this.analisistransaclienteDataAccess.getEntitiesObject();
		return this.analisistransaclientesObject;
	}
		
	public void setAnalisisTransaClientesObject(List<Object> newAnalisisTransaClientesObject) {
		this.analisistransaclientesObject = newAnalisisTransaClientesObject;
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
		
		if(this.analisistransaclienteDataAccess!=null) {
			this.analisistransaclienteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			analisistransaclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			analisistransaclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		analisistransacliente = new  AnalisisTransaCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			analisistransacliente=analisistransaclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.analisistransacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransacliente);
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
		analisistransacliente = new  AnalisisTransaCliente();
		  		  
        try {
			
			analisistransacliente=analisistransaclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.analisistransacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransacliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		analisistransacliente = new  AnalisisTransaCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			analisistransacliente=analisistransaclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.analisistransacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransacliente);
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
		analisistransacliente = new  AnalisisTransaCliente();
		  		  
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
		analisistransacliente = new  AnalisisTransaCliente();
		  		  
        try {
			
			analisistransacliente=analisistransaclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.analisistransacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransacliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		analisistransacliente = new  AnalisisTransaCliente();
		  		  
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
		analisistransacliente = new  AnalisisTransaCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =analisistransaclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		analisistransacliente = new  AnalisisTransaCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=analisistransaclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		analisistransacliente = new  AnalisisTransaCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =analisistransaclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		analisistransacliente = new  AnalisisTransaCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=analisistransaclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		analisistransacliente = new  AnalisisTransaCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =analisistransaclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		analisistransacliente = new  AnalisisTransaCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=analisistransaclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		analisistransaclientes = new  ArrayList<AnalisisTransaCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAnalisisTransaCliente(analisistransaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
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
		analisistransaclientes = new  ArrayList<AnalisisTransaCliente>();
		  		  
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
		analisistransaclientes = new  ArrayList<AnalisisTransaCliente>();
		  		  
        try {			
			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarAnalisisTransaCliente(analisistransaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		analisistransaclientes = new  ArrayList<AnalisisTransaCliente>();
		  		  
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
		analisistransaclientes = new  ArrayList<AnalisisTransaCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAnalisisTransaCliente(analisistransaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
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
		analisistransaclientes = new  ArrayList<AnalisisTransaCliente>();
		  		  
        try {
			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAnalisisTransaCliente(analisistransaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
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
		analisistransaclientes = new  ArrayList<AnalisisTransaCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAnalisisTransaCliente(analisistransaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
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
		analisistransaclientes = new  ArrayList<AnalisisTransaCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAnalisisTransaCliente(analisistransaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		analisistransacliente = new  AnalisisTransaCliente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			analisistransacliente=analisistransaclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAnalisisTransaCliente(analisistransacliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransacliente);
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
		analisistransacliente = new  AnalisisTransaCliente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			analisistransacliente=analisistransaclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAnalisisTransaCliente(analisistransacliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransacliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		analisistransaclientes = new  ArrayList<AnalisisTransaCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			analisistransaclientes=analisistransaclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAnalisisTransaCliente(analisistransaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
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
		analisistransaclientes = new  ArrayList<AnalisisTransaCliente>();
		  		  
        try {
			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			analisistransaclientes=analisistransaclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAnalisisTransaCliente(analisistransaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosAnalisisTransaClientesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		analisistransaclientes = new  ArrayList<AnalisisTransaCliente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getTodosAnalisisTransaClientesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAnalisisTransaCliente(analisistransaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
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
	
	public  void  getTodosAnalisisTransaClientes(String sFinalQuery,Pagination pagination)throws Exception {
		analisistransaclientes = new  ArrayList<AnalisisTransaCliente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAnalisisTransaCliente(analisistransaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarAnalisisTransaCliente(AnalisisTransaCliente analisistransacliente) throws Exception {
		Boolean estaValidado=false;
		
		if(analisistransacliente.getIsNew() || analisistransacliente.getIsChanged()) { 
			this.invalidValues = analisistransaclienteValidator.getInvalidValues(analisistransacliente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(analisistransacliente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarAnalisisTransaCliente(List<AnalisisTransaCliente> AnalisisTransaClientes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(AnalisisTransaCliente analisistransaclienteLocal:analisistransaclientes) {				
			estaValidadoObjeto=this.validarGuardarAnalisisTransaCliente(analisistransaclienteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarAnalisisTransaCliente(List<AnalisisTransaCliente> AnalisisTransaClientes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAnalisisTransaCliente(analisistransaclientes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarAnalisisTransaCliente(AnalisisTransaCliente AnalisisTransaCliente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAnalisisTransaCliente(analisistransacliente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(AnalisisTransaCliente analisistransacliente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+analisistransacliente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=AnalisisTransaClienteConstantesFunciones.getAnalisisTransaClienteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"analisistransacliente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(AnalisisTransaClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(AnalisisTransaClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveAnalisisTransaClienteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-saveAnalisisTransaClienteWithConnection");connexion.begin();			
			
			AnalisisTransaClienteLogicAdditional.checkAnalisisTransaClienteToSave(this.analisistransacliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AnalisisTransaClienteLogicAdditional.updateAnalisisTransaClienteToSave(this.analisistransacliente,this.arrDatoGeneral);
			
			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.analisistransacliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowAnalisisTransaCliente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAnalisisTransaCliente(this.analisistransacliente)) {
				AnalisisTransaClienteDataAccess.save(this.analisistransacliente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.analisistransacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AnalisisTransaClienteLogicAdditional.checkAnalisisTransaClienteToSaveAfter(this.analisistransacliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAnalisisTransaCliente();
			
			connexion.commit();			
			
			if(this.analisistransacliente.getIsDeleted()) {
				this.analisistransacliente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveAnalisisTransaCliente()throws Exception {	
		try {	
			
			AnalisisTransaClienteLogicAdditional.checkAnalisisTransaClienteToSave(this.analisistransacliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AnalisisTransaClienteLogicAdditional.updateAnalisisTransaClienteToSave(this.analisistransacliente,this.arrDatoGeneral);
			
			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.analisistransacliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAnalisisTransaCliente(this.analisistransacliente)) {			
				AnalisisTransaClienteDataAccess.save(this.analisistransacliente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.analisistransacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AnalisisTransaClienteLogicAdditional.checkAnalisisTransaClienteToSaveAfter(this.analisistransacliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.analisistransacliente.getIsDeleted()) {
				this.analisistransacliente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveAnalisisTransaClientesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-saveAnalisisTransaClientesWithConnection");connexion.begin();			
			
			AnalisisTransaClienteLogicAdditional.checkAnalisisTransaClienteToSaves(analisistransaclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowAnalisisTransaClientes();
			
			Boolean validadoTodosAnalisisTransaCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AnalisisTransaCliente analisistransaclienteLocal:analisistransaclientes) {		
				if(analisistransaclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AnalisisTransaClienteLogicAdditional.updateAnalisisTransaClienteToSave(analisistransaclienteLocal,this.arrDatoGeneral);
	        	
				AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),analisistransaclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAnalisisTransaCliente(analisistransaclienteLocal)) {
					AnalisisTransaClienteDataAccess.save(analisistransaclienteLocal, connexion);				
				} else {
					validadoTodosAnalisisTransaCliente=false;
				}
			}
			
			if(!validadoTodosAnalisisTransaCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AnalisisTransaClienteLogicAdditional.checkAnalisisTransaClienteToSavesAfter(analisistransaclientes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAnalisisTransaClientes();
			
			connexion.commit();		
			
			this.quitarAnalisisTransaClientesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveAnalisisTransaClientes()throws Exception {				
		 try {	
			AnalisisTransaClienteLogicAdditional.checkAnalisisTransaClienteToSaves(analisistransaclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosAnalisisTransaCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AnalisisTransaCliente analisistransaclienteLocal:analisistransaclientes) {				
				if(analisistransaclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AnalisisTransaClienteLogicAdditional.updateAnalisisTransaClienteToSave(analisistransaclienteLocal,this.arrDatoGeneral);
	        	
				AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),analisistransaclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAnalisisTransaCliente(analisistransaclienteLocal)) {				
					AnalisisTransaClienteDataAccess.save(analisistransaclienteLocal, connexion);				
				} else {
					validadoTodosAnalisisTransaCliente=false;
				}
			}
			
			if(!validadoTodosAnalisisTransaCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AnalisisTransaClienteLogicAdditional.checkAnalisisTransaClienteToSavesAfter(analisistransaclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarAnalisisTransaClientesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AnalisisTransaClienteParameterReturnGeneral procesarAccionAnalisisTransaClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AnalisisTransaCliente> analisistransaclientes,AnalisisTransaClienteParameterReturnGeneral analisistransaclienteParameterGeneral)throws Exception {
		 try {	
			AnalisisTransaClienteParameterReturnGeneral analisistransaclienteReturnGeneral=new AnalisisTransaClienteParameterReturnGeneral();
	
			AnalisisTransaClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,analisistransaclientes,analisistransaclienteParameterGeneral,analisistransaclienteReturnGeneral);
			
			return analisistransaclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AnalisisTransaClienteParameterReturnGeneral procesarAccionAnalisisTransaClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AnalisisTransaCliente> analisistransaclientes,AnalisisTransaClienteParameterReturnGeneral analisistransaclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-procesarAccionAnalisisTransaClientesWithConnection");connexion.begin();			
			
			AnalisisTransaClienteParameterReturnGeneral analisistransaclienteReturnGeneral=new AnalisisTransaClienteParameterReturnGeneral();
	
			AnalisisTransaClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,analisistransaclientes,analisistransaclienteParameterGeneral,analisistransaclienteReturnGeneral);
			
			this.connexion.commit();
			
			return analisistransaclienteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AnalisisTransaClienteParameterReturnGeneral procesarEventosAnalisisTransaClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AnalisisTransaCliente> analisistransaclientes,AnalisisTransaCliente analisistransacliente,AnalisisTransaClienteParameterReturnGeneral analisistransaclienteParameterGeneral,Boolean isEsNuevoAnalisisTransaCliente,ArrayList<Classe> clases)throws Exception {
		 try {	
			AnalisisTransaClienteParameterReturnGeneral analisistransaclienteReturnGeneral=new AnalisisTransaClienteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				analisistransaclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AnalisisTransaClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,analisistransaclientes,analisistransacliente,analisistransaclienteParameterGeneral,analisistransaclienteReturnGeneral,isEsNuevoAnalisisTransaCliente,clases);
			
			return analisistransaclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public AnalisisTransaClienteParameterReturnGeneral procesarEventosAnalisisTransaClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AnalisisTransaCliente> analisistransaclientes,AnalisisTransaCliente analisistransacliente,AnalisisTransaClienteParameterReturnGeneral analisistransaclienteParameterGeneral,Boolean isEsNuevoAnalisisTransaCliente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-procesarEventosAnalisisTransaClientesWithConnection");connexion.begin();			
			
			AnalisisTransaClienteParameterReturnGeneral analisistransaclienteReturnGeneral=new AnalisisTransaClienteParameterReturnGeneral();
	
			analisistransaclienteReturnGeneral.setAnalisisTransaCliente(analisistransacliente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				analisistransaclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AnalisisTransaClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,analisistransaclientes,analisistransacliente,analisistransaclienteParameterGeneral,analisistransaclienteReturnGeneral,isEsNuevoAnalisisTransaCliente,clases);
			
			this.connexion.commit();
			
			return analisistransaclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AnalisisTransaClienteParameterReturnGeneral procesarImportacionAnalisisTransaClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,AnalisisTransaClienteParameterReturnGeneral analisistransaclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-procesarImportacionAnalisisTransaClientesWithConnection");connexion.begin();			
			
			AnalisisTransaClienteParameterReturnGeneral analisistransaclienteReturnGeneral=new AnalisisTransaClienteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.analisistransaclientes=new ArrayList<AnalisisTransaCliente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.analisistransacliente=new AnalisisTransaCliente();
				
				
				if(conColumnasBase) {this.analisistransacliente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.analisistransacliente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.analisistransacliente.setnombre(arrColumnas[iColumn++]);
			this.analisistransacliente.setdescripcion(arrColumnas[iColumn++]);
				
				this.analisistransaclientes.add(this.analisistransacliente);
			}
			
			this.saveAnalisisTransaClientes();
			
			this.connexion.commit();
			
			analisistransaclienteReturnGeneral.setConRetornoEstaProcesado(true);
			analisistransaclienteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return analisistransaclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarAnalisisTransaClientesEliminados() throws Exception {				
		
		List<AnalisisTransaCliente> analisistransaclientesAux= new ArrayList<AnalisisTransaCliente>();
		
		for(AnalisisTransaCliente analisistransacliente:analisistransaclientes) {
			if(!analisistransacliente.getIsDeleted()) {
				analisistransaclientesAux.add(analisistransacliente);
			}
		}
		
		analisistransaclientes=analisistransaclientesAux;
	}
	
	public void quitarAnalisisTransaClientesNulos() throws Exception {				
		
		List<AnalisisTransaCliente> analisistransaclientesAux= new ArrayList<AnalisisTransaCliente>();
		
		for(AnalisisTransaCliente analisistransacliente : this.analisistransaclientes) {
			if(analisistransacliente==null) {
				analisistransaclientesAux.add(analisistransacliente);
			}
		}
		
		//this.analisistransaclientes=analisistransaclientesAux;
		
		this.analisistransaclientes.removeAll(analisistransaclientesAux);
	}
	
	public void getSetVersionRowAnalisisTransaClienteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(analisistransacliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((analisistransacliente.getIsDeleted() || (analisistransacliente.getIsChanged()&&!analisistransacliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=analisistransaclienteDataAccess.getSetVersionRowAnalisisTransaCliente(connexion,analisistransacliente.getId());
				
				if(!analisistransacliente.getVersionRow().equals(timestamp)) {	
					analisistransacliente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				analisistransacliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowAnalisisTransaCliente()throws Exception {	
		
		if(analisistransacliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((analisistransacliente.getIsDeleted() || (analisistransacliente.getIsChanged()&&!analisistransacliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=analisistransaclienteDataAccess.getSetVersionRowAnalisisTransaCliente(connexion,analisistransacliente.getId());
			
			try {							
				if(!analisistransacliente.getVersionRow().equals(timestamp)) {	
					analisistransacliente.setVersionRow(timestamp);
				}
				
				analisistransacliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowAnalisisTransaClientesWithConnection()throws Exception {	
		if(analisistransaclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(AnalisisTransaCliente analisistransaclienteAux:analisistransaclientes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(analisistransaclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(analisistransaclienteAux.getIsDeleted() || (analisistransaclienteAux.getIsChanged()&&!analisistransaclienteAux.getIsNew())) {
						
						timestamp=analisistransaclienteDataAccess.getSetVersionRowAnalisisTransaCliente(connexion,analisistransaclienteAux.getId());
						
						if(!analisistransacliente.getVersionRow().equals(timestamp)) {	
							analisistransaclienteAux.setVersionRow(timestamp);
						}
								
						analisistransaclienteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowAnalisisTransaClientes()throws Exception {	
		if(analisistransaclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(AnalisisTransaCliente analisistransaclienteAux:analisistransaclientes) {
					if(analisistransaclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(analisistransaclienteAux.getIsDeleted() || (analisistransaclienteAux.getIsChanged()&&!analisistransaclienteAux.getIsNew())) {
						
						timestamp=analisistransaclienteDataAccess.getSetVersionRowAnalisisTransaCliente(connexion,analisistransaclienteAux.getId());
						
						if(!analisistransaclienteAux.getVersionRow().equals(timestamp)) {	
							analisistransaclienteAux.setVersionRow(timestamp);
						}
						
													
						analisistransaclienteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public AnalisisTransaClienteParameterReturnGeneral cargarCombosLoteForeignKeyAnalisisTransaClienteWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalModulo,String finalQueryGlobalTransaccion,String finalQueryGlobalTransaccion1,String finalQueryGlobalTransaccion2,String finalQueryGlobalTransaccion3,String finalQueryGlobalTransaccion4,String finalQueryGlobalTransaccion5,String finalQueryGlobalTransaccion6,String finalQueryGlobalTransaccion7,String finalQueryGlobalTransaccion8,String finalQueryGlobalTransaccion9,String finalQueryGlobalTransaccion10) throws Exception {
		AnalisisTransaClienteParameterReturnGeneral  analisistransaclienteReturnGeneral =new AnalisisTransaClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-cargarCombosLoteForeignKeyAnalisisTransaClienteWithConnection");connexion.begin();
			
			analisistransaclienteReturnGeneral =new AnalisisTransaClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			analisistransaclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			analisistransaclienteReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			analisistransaclienteReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<Transaccion> transaccion1sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion1Logic=new TransaccionLogic();
			transaccion1Logic.setConnexion(this.connexion);
			transaccion1Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion1.equals("NONE")) {
				transaccion1Logic.getTodosTransaccions(finalQueryGlobalTransaccion1,new Pagination());
				transaccion1sForeignKey=transaccion1Logic.getTransaccions();
			}

			analisistransaclienteReturnGeneral.settransaccion1sForeignKey(transaccion1sForeignKey);


			List<Transaccion> transaccion2sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion2Logic=new TransaccionLogic();
			transaccion2Logic.setConnexion(this.connexion);
			transaccion2Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion2.equals("NONE")) {
				transaccion2Logic.getTodosTransaccions(finalQueryGlobalTransaccion2,new Pagination());
				transaccion2sForeignKey=transaccion2Logic.getTransaccions();
			}

			analisistransaclienteReturnGeneral.settransaccion2sForeignKey(transaccion2sForeignKey);


			List<Transaccion> transaccion3sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion3Logic=new TransaccionLogic();
			transaccion3Logic.setConnexion(this.connexion);
			transaccion3Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion3.equals("NONE")) {
				transaccion3Logic.getTodosTransaccions(finalQueryGlobalTransaccion3,new Pagination());
				transaccion3sForeignKey=transaccion3Logic.getTransaccions();
			}

			analisistransaclienteReturnGeneral.settransaccion3sForeignKey(transaccion3sForeignKey);


			List<Transaccion> transaccion4sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion4Logic=new TransaccionLogic();
			transaccion4Logic.setConnexion(this.connexion);
			transaccion4Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion4.equals("NONE")) {
				transaccion4Logic.getTodosTransaccions(finalQueryGlobalTransaccion4,new Pagination());
				transaccion4sForeignKey=transaccion4Logic.getTransaccions();
			}

			analisistransaclienteReturnGeneral.settransaccion4sForeignKey(transaccion4sForeignKey);


			List<Transaccion> transaccion5sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion5Logic=new TransaccionLogic();
			transaccion5Logic.setConnexion(this.connexion);
			transaccion5Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion5.equals("NONE")) {
				transaccion5Logic.getTodosTransaccions(finalQueryGlobalTransaccion5,new Pagination());
				transaccion5sForeignKey=transaccion5Logic.getTransaccions();
			}

			analisistransaclienteReturnGeneral.settransaccion5sForeignKey(transaccion5sForeignKey);


			List<Transaccion> transaccion6sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion6Logic=new TransaccionLogic();
			transaccion6Logic.setConnexion(this.connexion);
			transaccion6Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion6.equals("NONE")) {
				transaccion6Logic.getTodosTransaccions(finalQueryGlobalTransaccion6,new Pagination());
				transaccion6sForeignKey=transaccion6Logic.getTransaccions();
			}

			analisistransaclienteReturnGeneral.settransaccion6sForeignKey(transaccion6sForeignKey);


			List<Transaccion> transaccion7sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion7Logic=new TransaccionLogic();
			transaccion7Logic.setConnexion(this.connexion);
			transaccion7Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion7.equals("NONE")) {
				transaccion7Logic.getTodosTransaccions(finalQueryGlobalTransaccion7,new Pagination());
				transaccion7sForeignKey=transaccion7Logic.getTransaccions();
			}

			analisistransaclienteReturnGeneral.settransaccion7sForeignKey(transaccion7sForeignKey);


			List<Transaccion> transaccion8sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion8Logic=new TransaccionLogic();
			transaccion8Logic.setConnexion(this.connexion);
			transaccion8Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion8.equals("NONE")) {
				transaccion8Logic.getTodosTransaccions(finalQueryGlobalTransaccion8,new Pagination());
				transaccion8sForeignKey=transaccion8Logic.getTransaccions();
			}

			analisistransaclienteReturnGeneral.settransaccion8sForeignKey(transaccion8sForeignKey);


			List<Transaccion> transaccion9sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion9Logic=new TransaccionLogic();
			transaccion9Logic.setConnexion(this.connexion);
			transaccion9Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion9.equals("NONE")) {
				transaccion9Logic.getTodosTransaccions(finalQueryGlobalTransaccion9,new Pagination());
				transaccion9sForeignKey=transaccion9Logic.getTransaccions();
			}

			analisistransaclienteReturnGeneral.settransaccion9sForeignKey(transaccion9sForeignKey);


			List<Transaccion> transaccion10sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion10Logic=new TransaccionLogic();
			transaccion10Logic.setConnexion(this.connexion);
			transaccion10Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion10.equals("NONE")) {
				transaccion10Logic.getTodosTransaccions(finalQueryGlobalTransaccion10,new Pagination());
				transaccion10sForeignKey=transaccion10Logic.getTransaccions();
			}

			analisistransaclienteReturnGeneral.settransaccion10sForeignKey(transaccion10sForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return analisistransaclienteReturnGeneral;
	}
	
	public AnalisisTransaClienteParameterReturnGeneral cargarCombosLoteForeignKeyAnalisisTransaCliente(String finalQueryGlobalEmpresa,String finalQueryGlobalModulo,String finalQueryGlobalTransaccion,String finalQueryGlobalTransaccion1,String finalQueryGlobalTransaccion2,String finalQueryGlobalTransaccion3,String finalQueryGlobalTransaccion4,String finalQueryGlobalTransaccion5,String finalQueryGlobalTransaccion6,String finalQueryGlobalTransaccion7,String finalQueryGlobalTransaccion8,String finalQueryGlobalTransaccion9,String finalQueryGlobalTransaccion10) throws Exception {
		AnalisisTransaClienteParameterReturnGeneral  analisistransaclienteReturnGeneral =new AnalisisTransaClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			analisistransaclienteReturnGeneral =new AnalisisTransaClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			analisistransaclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			analisistransaclienteReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			analisistransaclienteReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<Transaccion> transaccion1sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion1Logic=new TransaccionLogic();
			transaccion1Logic.setConnexion(this.connexion);
			transaccion1Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion1.equals("NONE")) {
				transaccion1Logic.getTodosTransaccions(finalQueryGlobalTransaccion1,new Pagination());
				transaccion1sForeignKey=transaccion1Logic.getTransaccions();
			}

			analisistransaclienteReturnGeneral.settransaccion1sForeignKey(transaccion1sForeignKey);


			List<Transaccion> transaccion2sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion2Logic=new TransaccionLogic();
			transaccion2Logic.setConnexion(this.connexion);
			transaccion2Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion2.equals("NONE")) {
				transaccion2Logic.getTodosTransaccions(finalQueryGlobalTransaccion2,new Pagination());
				transaccion2sForeignKey=transaccion2Logic.getTransaccions();
			}

			analisistransaclienteReturnGeneral.settransaccion2sForeignKey(transaccion2sForeignKey);


			List<Transaccion> transaccion3sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion3Logic=new TransaccionLogic();
			transaccion3Logic.setConnexion(this.connexion);
			transaccion3Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion3.equals("NONE")) {
				transaccion3Logic.getTodosTransaccions(finalQueryGlobalTransaccion3,new Pagination());
				transaccion3sForeignKey=transaccion3Logic.getTransaccions();
			}

			analisistransaclienteReturnGeneral.settransaccion3sForeignKey(transaccion3sForeignKey);


			List<Transaccion> transaccion4sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion4Logic=new TransaccionLogic();
			transaccion4Logic.setConnexion(this.connexion);
			transaccion4Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion4.equals("NONE")) {
				transaccion4Logic.getTodosTransaccions(finalQueryGlobalTransaccion4,new Pagination());
				transaccion4sForeignKey=transaccion4Logic.getTransaccions();
			}

			analisistransaclienteReturnGeneral.settransaccion4sForeignKey(transaccion4sForeignKey);


			List<Transaccion> transaccion5sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion5Logic=new TransaccionLogic();
			transaccion5Logic.setConnexion(this.connexion);
			transaccion5Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion5.equals("NONE")) {
				transaccion5Logic.getTodosTransaccions(finalQueryGlobalTransaccion5,new Pagination());
				transaccion5sForeignKey=transaccion5Logic.getTransaccions();
			}

			analisistransaclienteReturnGeneral.settransaccion5sForeignKey(transaccion5sForeignKey);


			List<Transaccion> transaccion6sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion6Logic=new TransaccionLogic();
			transaccion6Logic.setConnexion(this.connexion);
			transaccion6Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion6.equals("NONE")) {
				transaccion6Logic.getTodosTransaccions(finalQueryGlobalTransaccion6,new Pagination());
				transaccion6sForeignKey=transaccion6Logic.getTransaccions();
			}

			analisistransaclienteReturnGeneral.settransaccion6sForeignKey(transaccion6sForeignKey);


			List<Transaccion> transaccion7sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion7Logic=new TransaccionLogic();
			transaccion7Logic.setConnexion(this.connexion);
			transaccion7Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion7.equals("NONE")) {
				transaccion7Logic.getTodosTransaccions(finalQueryGlobalTransaccion7,new Pagination());
				transaccion7sForeignKey=transaccion7Logic.getTransaccions();
			}

			analisistransaclienteReturnGeneral.settransaccion7sForeignKey(transaccion7sForeignKey);


			List<Transaccion> transaccion8sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion8Logic=new TransaccionLogic();
			transaccion8Logic.setConnexion(this.connexion);
			transaccion8Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion8.equals("NONE")) {
				transaccion8Logic.getTodosTransaccions(finalQueryGlobalTransaccion8,new Pagination());
				transaccion8sForeignKey=transaccion8Logic.getTransaccions();
			}

			analisistransaclienteReturnGeneral.settransaccion8sForeignKey(transaccion8sForeignKey);


			List<Transaccion> transaccion9sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion9Logic=new TransaccionLogic();
			transaccion9Logic.setConnexion(this.connexion);
			transaccion9Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion9.equals("NONE")) {
				transaccion9Logic.getTodosTransaccions(finalQueryGlobalTransaccion9,new Pagination());
				transaccion9sForeignKey=transaccion9Logic.getTransaccions();
			}

			analisistransaclienteReturnGeneral.settransaccion9sForeignKey(transaccion9sForeignKey);


			List<Transaccion> transaccion10sForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccion10Logic=new TransaccionLogic();
			transaccion10Logic.setConnexion(this.connexion);
			transaccion10Logic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion10.equals("NONE")) {
				transaccion10Logic.getTodosTransaccions(finalQueryGlobalTransaccion10,new Pagination());
				transaccion10sForeignKey=transaccion10Logic.getTransaccions();
			}

			analisistransaclienteReturnGeneral.settransaccion10sForeignKey(transaccion10sForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return analisistransaclienteReturnGeneral;
	}
	
	
	public void deepLoad(AnalisisTransaCliente analisistransacliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			AnalisisTransaClienteLogicAdditional.updateAnalisisTransaClienteToGet(analisistransacliente,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		analisistransacliente.setEmpresa(analisistransaclienteDataAccess.getEmpresa(connexion,analisistransacliente));
		analisistransacliente.setModulo(analisistransaclienteDataAccess.getModulo(connexion,analisistransacliente));
		analisistransacliente.setTransaccion(analisistransaclienteDataAccess.getTransaccion(connexion,analisistransacliente));
		analisistransacliente.setTransaccion1(analisistransaclienteDataAccess.getTransaccion1(connexion,analisistransacliente));
		analisistransacliente.setTransaccion2(analisistransaclienteDataAccess.getTransaccion2(connexion,analisistransacliente));
		analisistransacliente.setTransaccion3(analisistransaclienteDataAccess.getTransaccion3(connexion,analisistransacliente));
		analisistransacliente.setTransaccion4(analisistransaclienteDataAccess.getTransaccion4(connexion,analisistransacliente));
		analisistransacliente.setTransaccion5(analisistransaclienteDataAccess.getTransaccion5(connexion,analisistransacliente));
		analisistransacliente.setTransaccion6(analisistransaclienteDataAccess.getTransaccion6(connexion,analisistransacliente));
		analisistransacliente.setTransaccion7(analisistransaclienteDataAccess.getTransaccion7(connexion,analisistransacliente));
		analisistransacliente.setTransaccion8(analisistransaclienteDataAccess.getTransaccion8(connexion,analisistransacliente));
		analisistransacliente.setTransaccion9(analisistransaclienteDataAccess.getTransaccion9(connexion,analisistransacliente));
		analisistransacliente.setTransaccion10(analisistransaclienteDataAccess.getTransaccion10(connexion,analisistransacliente));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				analisistransacliente.setEmpresa(analisistransaclienteDataAccess.getEmpresa(connexion,analisistransacliente));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				analisistransacliente.setModulo(analisistransaclienteDataAccess.getModulo(connexion,analisistransacliente));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				analisistransacliente.setTransaccion(analisistransaclienteDataAccess.getTransaccion(connexion,analisistransacliente));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				analisistransacliente.setTransaccion1(analisistransaclienteDataAccess.getTransaccion1(connexion,analisistransacliente));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				analisistransacliente.setTransaccion2(analisistransaclienteDataAccess.getTransaccion2(connexion,analisistransacliente));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				analisistransacliente.setTransaccion3(analisistransaclienteDataAccess.getTransaccion3(connexion,analisistransacliente));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				analisistransacliente.setTransaccion4(analisistransaclienteDataAccess.getTransaccion4(connexion,analisistransacliente));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				analisistransacliente.setTransaccion5(analisistransaclienteDataAccess.getTransaccion5(connexion,analisistransacliente));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				analisistransacliente.setTransaccion6(analisistransaclienteDataAccess.getTransaccion6(connexion,analisistransacliente));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				analisistransacliente.setTransaccion7(analisistransaclienteDataAccess.getTransaccion7(connexion,analisistransacliente));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				analisistransacliente.setTransaccion8(analisistransaclienteDataAccess.getTransaccion8(connexion,analisistransacliente));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				analisistransacliente.setTransaccion9(analisistransaclienteDataAccess.getTransaccion9(connexion,analisistransacliente));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				analisistransacliente.setTransaccion10(analisistransaclienteDataAccess.getTransaccion10(connexion,analisistransacliente));
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
			analisistransacliente.setEmpresa(analisistransaclienteDataAccess.getEmpresa(connexion,analisistransacliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setModulo(analisistransaclienteDataAccess.getModulo(connexion,analisistransacliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setTransaccion(analisistransaclienteDataAccess.getTransaccion(connexion,analisistransacliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setTransaccion1(analisistransaclienteDataAccess.getTransaccion1(connexion,analisistransacliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setTransaccion2(analisistransaclienteDataAccess.getTransaccion2(connexion,analisistransacliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setTransaccion3(analisistransaclienteDataAccess.getTransaccion3(connexion,analisistransacliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setTransaccion4(analisistransaclienteDataAccess.getTransaccion4(connexion,analisistransacliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setTransaccion5(analisistransaclienteDataAccess.getTransaccion5(connexion,analisistransacliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setTransaccion6(analisistransaclienteDataAccess.getTransaccion6(connexion,analisistransacliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setTransaccion7(analisistransaclienteDataAccess.getTransaccion7(connexion,analisistransacliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setTransaccion8(analisistransaclienteDataAccess.getTransaccion8(connexion,analisistransacliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setTransaccion9(analisistransaclienteDataAccess.getTransaccion9(connexion,analisistransacliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setTransaccion10(analisistransaclienteDataAccess.getTransaccion10(connexion,analisistransacliente));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		analisistransacliente.setEmpresa(analisistransaclienteDataAccess.getEmpresa(connexion,analisistransacliente));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(analisistransacliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		analisistransacliente.setModulo(analisistransaclienteDataAccess.getModulo(connexion,analisistransacliente));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(analisistransacliente.getModulo(),isDeep,deepLoadType,clases);
				
		analisistransacliente.setTransaccion(analisistransaclienteDataAccess.getTransaccion(connexion,analisistransacliente));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(analisistransacliente.getTransaccion(),isDeep,deepLoadType,clases);
				
		analisistransacliente.setTransaccion1(analisistransaclienteDataAccess.getTransaccion1(connexion,analisistransacliente));
		TransaccionLogic transaccion1Logic= new TransaccionLogic(connexion);
		transaccion1Logic.deepLoad(analisistransacliente.getTransaccion1(),isDeep,deepLoadType,clases);
				
		analisistransacliente.setTransaccion2(analisistransaclienteDataAccess.getTransaccion2(connexion,analisistransacliente));
		TransaccionLogic transaccion2Logic= new TransaccionLogic(connexion);
		transaccion2Logic.deepLoad(analisistransacliente.getTransaccion2(),isDeep,deepLoadType,clases);
				
		analisistransacliente.setTransaccion3(analisistransaclienteDataAccess.getTransaccion3(connexion,analisistransacliente));
		TransaccionLogic transaccion3Logic= new TransaccionLogic(connexion);
		transaccion3Logic.deepLoad(analisistransacliente.getTransaccion3(),isDeep,deepLoadType,clases);
				
		analisistransacliente.setTransaccion4(analisistransaclienteDataAccess.getTransaccion4(connexion,analisistransacliente));
		TransaccionLogic transaccion4Logic= new TransaccionLogic(connexion);
		transaccion4Logic.deepLoad(analisistransacliente.getTransaccion4(),isDeep,deepLoadType,clases);
				
		analisistransacliente.setTransaccion5(analisistransaclienteDataAccess.getTransaccion5(connexion,analisistransacliente));
		TransaccionLogic transaccion5Logic= new TransaccionLogic(connexion);
		transaccion5Logic.deepLoad(analisistransacliente.getTransaccion5(),isDeep,deepLoadType,clases);
				
		analisistransacliente.setTransaccion6(analisistransaclienteDataAccess.getTransaccion6(connexion,analisistransacliente));
		TransaccionLogic transaccion6Logic= new TransaccionLogic(connexion);
		transaccion6Logic.deepLoad(analisistransacliente.getTransaccion6(),isDeep,deepLoadType,clases);
				
		analisistransacliente.setTransaccion7(analisistransaclienteDataAccess.getTransaccion7(connexion,analisistransacliente));
		TransaccionLogic transaccion7Logic= new TransaccionLogic(connexion);
		transaccion7Logic.deepLoad(analisistransacliente.getTransaccion7(),isDeep,deepLoadType,clases);
				
		analisistransacliente.setTransaccion8(analisistransaclienteDataAccess.getTransaccion8(connexion,analisistransacliente));
		TransaccionLogic transaccion8Logic= new TransaccionLogic(connexion);
		transaccion8Logic.deepLoad(analisistransacliente.getTransaccion8(),isDeep,deepLoadType,clases);
				
		analisistransacliente.setTransaccion9(analisistransaclienteDataAccess.getTransaccion9(connexion,analisistransacliente));
		TransaccionLogic transaccion9Logic= new TransaccionLogic(connexion);
		transaccion9Logic.deepLoad(analisistransacliente.getTransaccion9(),isDeep,deepLoadType,clases);
				
		analisistransacliente.setTransaccion10(analisistransaclienteDataAccess.getTransaccion10(connexion,analisistransacliente));
		TransaccionLogic transaccion10Logic= new TransaccionLogic(connexion);
		transaccion10Logic.deepLoad(analisistransacliente.getTransaccion10(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				analisistransacliente.setEmpresa(analisistransaclienteDataAccess.getEmpresa(connexion,analisistransacliente));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(analisistransacliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				analisistransacliente.setModulo(analisistransaclienteDataAccess.getModulo(connexion,analisistransacliente));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(analisistransacliente.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				analisistransacliente.setTransaccion(analisistransaclienteDataAccess.getTransaccion(connexion,analisistransacliente));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(analisistransacliente.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				analisistransacliente.setTransaccion1(analisistransaclienteDataAccess.getTransaccion1(connexion,analisistransacliente));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(analisistransacliente.getTransaccion1(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				analisistransacliente.setTransaccion2(analisistransaclienteDataAccess.getTransaccion2(connexion,analisistransacliente));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(analisistransacliente.getTransaccion2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				analisistransacliente.setTransaccion3(analisistransaclienteDataAccess.getTransaccion3(connexion,analisistransacliente));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(analisistransacliente.getTransaccion3(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				analisistransacliente.setTransaccion4(analisistransaclienteDataAccess.getTransaccion4(connexion,analisistransacliente));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(analisistransacliente.getTransaccion4(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				analisistransacliente.setTransaccion5(analisistransaclienteDataAccess.getTransaccion5(connexion,analisistransacliente));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(analisistransacliente.getTransaccion5(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				analisistransacliente.setTransaccion6(analisistransaclienteDataAccess.getTransaccion6(connexion,analisistransacliente));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(analisistransacliente.getTransaccion6(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				analisistransacliente.setTransaccion7(analisistransaclienteDataAccess.getTransaccion7(connexion,analisistransacliente));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(analisistransacliente.getTransaccion7(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				analisistransacliente.setTransaccion8(analisistransaclienteDataAccess.getTransaccion8(connexion,analisistransacliente));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(analisistransacliente.getTransaccion8(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				analisistransacliente.setTransaccion9(analisistransaclienteDataAccess.getTransaccion9(connexion,analisistransacliente));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(analisistransacliente.getTransaccion9(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				analisistransacliente.setTransaccion10(analisistransaclienteDataAccess.getTransaccion10(connexion,analisistransacliente));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(analisistransacliente.getTransaccion10(),isDeep,deepLoadType,clases);				
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
			analisistransacliente.setEmpresa(analisistransaclienteDataAccess.getEmpresa(connexion,analisistransacliente));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(analisistransacliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setModulo(analisistransaclienteDataAccess.getModulo(connexion,analisistransacliente));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(analisistransacliente.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setTransaccion(analisistransaclienteDataAccess.getTransaccion(connexion,analisistransacliente));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(analisistransacliente.getTransaccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setTransaccion1(analisistransaclienteDataAccess.getTransaccion1(connexion,analisistransacliente));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(analisistransacliente.getTransaccion1(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setTransaccion2(analisistransaclienteDataAccess.getTransaccion2(connexion,analisistransacliente));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(analisistransacliente.getTransaccion2(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setTransaccion3(analisistransaclienteDataAccess.getTransaccion3(connexion,analisistransacliente));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(analisistransacliente.getTransaccion3(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setTransaccion4(analisistransaclienteDataAccess.getTransaccion4(connexion,analisistransacliente));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(analisistransacliente.getTransaccion4(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setTransaccion5(analisistransaclienteDataAccess.getTransaccion5(connexion,analisistransacliente));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(analisistransacliente.getTransaccion5(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setTransaccion6(analisistransaclienteDataAccess.getTransaccion6(connexion,analisistransacliente));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(analisistransacliente.getTransaccion6(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setTransaccion7(analisistransaclienteDataAccess.getTransaccion7(connexion,analisistransacliente));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(analisistransacliente.getTransaccion7(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setTransaccion8(analisistransaclienteDataAccess.getTransaccion8(connexion,analisistransacliente));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(analisistransacliente.getTransaccion8(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setTransaccion9(analisistransaclienteDataAccess.getTransaccion9(connexion,analisistransacliente));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(analisistransacliente.getTransaccion9(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			analisistransacliente.setTransaccion10(analisistransaclienteDataAccess.getTransaccion10(connexion,analisistransacliente));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(analisistransacliente.getTransaccion10(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(AnalisisTransaCliente analisistransacliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			AnalisisTransaClienteLogicAdditional.updateAnalisisTransaClienteToSave(analisistransacliente,this.arrDatoGeneral);
			
AnalisisTransaClienteDataAccess.save(analisistransacliente, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(analisistransacliente.getEmpresa(),connexion);

		ModuloDataAccess.save(analisistransacliente.getModulo(),connexion);

		TransaccionDataAccess.save(analisistransacliente.getTransaccion(),connexion);

		TransaccionDataAccess.save(analisistransacliente.getTransaccion1(),connexion);

		TransaccionDataAccess.save(analisistransacliente.getTransaccion2(),connexion);

		TransaccionDataAccess.save(analisistransacliente.getTransaccion3(),connexion);

		TransaccionDataAccess.save(analisistransacliente.getTransaccion4(),connexion);

		TransaccionDataAccess.save(analisistransacliente.getTransaccion5(),connexion);

		TransaccionDataAccess.save(analisistransacliente.getTransaccion6(),connexion);

		TransaccionDataAccess.save(analisistransacliente.getTransaccion7(),connexion);

		TransaccionDataAccess.save(analisistransacliente.getTransaccion8(),connexion);

		TransaccionDataAccess.save(analisistransacliente.getTransaccion9(),connexion);

		TransaccionDataAccess.save(analisistransacliente.getTransaccion10(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(analisistransacliente.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(analisistransacliente.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(analisistransacliente.getTransaccion(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(analisistransacliente.getTransaccion1(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(analisistransacliente.getTransaccion2(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(analisistransacliente.getTransaccion3(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(analisistransacliente.getTransaccion4(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(analisistransacliente.getTransaccion5(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(analisistransacliente.getTransaccion6(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(analisistransacliente.getTransaccion7(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(analisistransacliente.getTransaccion8(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(analisistransacliente.getTransaccion9(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(analisistransacliente.getTransaccion10(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(analisistransacliente.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(analisistransacliente.getEmpresa(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(analisistransacliente.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(analisistransacliente.getModulo(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(analisistransacliente.getTransaccion(),connexion);
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(analisistransacliente.getTransaccion(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(analisistransacliente.getTransaccion1(),connexion);
		TransaccionLogic transaccion1Logic= new TransaccionLogic(connexion);
		transaccion1Logic.deepLoad(analisistransacliente.getTransaccion1(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(analisistransacliente.getTransaccion2(),connexion);
		TransaccionLogic transaccion2Logic= new TransaccionLogic(connexion);
		transaccion2Logic.deepLoad(analisistransacliente.getTransaccion2(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(analisistransacliente.getTransaccion3(),connexion);
		TransaccionLogic transaccion3Logic= new TransaccionLogic(connexion);
		transaccion3Logic.deepLoad(analisistransacliente.getTransaccion3(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(analisistransacliente.getTransaccion4(),connexion);
		TransaccionLogic transaccion4Logic= new TransaccionLogic(connexion);
		transaccion4Logic.deepLoad(analisistransacliente.getTransaccion4(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(analisistransacliente.getTransaccion5(),connexion);
		TransaccionLogic transaccion5Logic= new TransaccionLogic(connexion);
		transaccion5Logic.deepLoad(analisistransacliente.getTransaccion5(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(analisistransacliente.getTransaccion6(),connexion);
		TransaccionLogic transaccion6Logic= new TransaccionLogic(connexion);
		transaccion6Logic.deepLoad(analisistransacliente.getTransaccion6(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(analisistransacliente.getTransaccion7(),connexion);
		TransaccionLogic transaccion7Logic= new TransaccionLogic(connexion);
		transaccion7Logic.deepLoad(analisistransacliente.getTransaccion7(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(analisistransacliente.getTransaccion8(),connexion);
		TransaccionLogic transaccion8Logic= new TransaccionLogic(connexion);
		transaccion8Logic.deepLoad(analisistransacliente.getTransaccion8(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(analisistransacliente.getTransaccion9(),connexion);
		TransaccionLogic transaccion9Logic= new TransaccionLogic(connexion);
		transaccion9Logic.deepLoad(analisistransacliente.getTransaccion9(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(analisistransacliente.getTransaccion10(),connexion);
		TransaccionLogic transaccion10Logic= new TransaccionLogic(connexion);
		transaccion10Logic.deepLoad(analisistransacliente.getTransaccion10(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(analisistransacliente.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(analisistransacliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(analisistransacliente.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(analisistransacliente.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(analisistransacliente.getTransaccion(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(analisistransacliente.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(analisistransacliente.getTransaccion1(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(analisistransacliente.getTransaccion1(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(analisistransacliente.getTransaccion2(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(analisistransacliente.getTransaccion2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(analisistransacliente.getTransaccion3(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(analisistransacliente.getTransaccion3(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(analisistransacliente.getTransaccion4(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(analisistransacliente.getTransaccion4(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(analisistransacliente.getTransaccion5(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(analisistransacliente.getTransaccion5(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(analisistransacliente.getTransaccion6(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(analisistransacliente.getTransaccion6(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(analisistransacliente.getTransaccion7(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(analisistransacliente.getTransaccion7(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(analisistransacliente.getTransaccion8(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(analisistransacliente.getTransaccion8(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(analisistransacliente.getTransaccion9(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(analisistransacliente.getTransaccion9(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(analisistransacliente.getTransaccion10(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(analisistransacliente.getTransaccion10(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(AnalisisTransaCliente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(analisistransacliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(analisistransacliente);
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
			this.deepLoad(this.analisistransacliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransacliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(AnalisisTransaCliente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(analisistransaclientes!=null) {
				for(AnalisisTransaCliente analisistransacliente:analisistransaclientes) {
					this.deepLoad(analisistransacliente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(analisistransaclientes);
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
			if(analisistransaclientes!=null) {
				for(AnalisisTransaCliente analisistransacliente:analisistransaclientes) {
					this.deepLoad(analisistransacliente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(analisistransaclientes);
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
			this.getNewConnexionToDeep(AnalisisTransaCliente.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(analisistransacliente,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(AnalisisTransaCliente.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(analisistransaclientes!=null) {
				for(AnalisisTransaCliente analisistransacliente:analisistransaclientes) {
					this.deepSave(analisistransacliente,isDeep,deepLoadType,clases);
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
			if(analisistransaclientes!=null) {
				for(AnalisisTransaCliente analisistransacliente:analisistransaclientes) {
					this.deepSave(analisistransacliente,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getAnalisisTransaClientesBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",AnalisisTransaClienteConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAnalisisTransaClientesBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",AnalisisTransaClienteConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAnalisisTransaClientesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AnalisisTransaClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAnalisisTransaClientesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AnalisisTransaClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAnalisisTransaClientesFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,AnalisisTransaClienteConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAnalisisTransaClientesFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,AnalisisTransaClienteConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAnalisisTransaClientesFK_IdTransaccionWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,AnalisisTransaClienteConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAnalisisTransaClientesFK_IdTransaccion(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,AnalisisTransaClienteConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAnalisisTransaClientesFK_IdTransaccion1WithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion1)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion1= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion1.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion1,AnalisisTransaClienteConstantesFunciones.IDTRANSACCION1,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion1);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion1","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAnalisisTransaClientesFK_IdTransaccion1(String sFinalQuery,Pagination pagination,Long id_transaccion1)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion1= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion1.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion1,AnalisisTransaClienteConstantesFunciones.IDTRANSACCION1,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion1);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion1","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAnalisisTransaClientesFK_IdTransaccion10WithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion10)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion10= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion10.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion10,AnalisisTransaClienteConstantesFunciones.IDTRANSACCION10,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion10);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion10","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAnalisisTransaClientesFK_IdTransaccion10(String sFinalQuery,Pagination pagination,Long id_transaccion10)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion10= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion10.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion10,AnalisisTransaClienteConstantesFunciones.IDTRANSACCION10,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion10);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion10","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAnalisisTransaClientesFK_IdTransaccion2WithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion2)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion2,AnalisisTransaClienteConstantesFunciones.IDTRANSACCION2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion2);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAnalisisTransaClientesFK_IdTransaccion2(String sFinalQuery,Pagination pagination,Long id_transaccion2)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion2,AnalisisTransaClienteConstantesFunciones.IDTRANSACCION2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion2);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAnalisisTransaClientesFK_IdTransaccion4WithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion4)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion4= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion4.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion4,AnalisisTransaClienteConstantesFunciones.IDTRANSACCION4,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion4);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion4","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAnalisisTransaClientesFK_IdTransaccion4(String sFinalQuery,Pagination pagination,Long id_transaccion4)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion4= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion4.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion4,AnalisisTransaClienteConstantesFunciones.IDTRANSACCION4,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion4);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion4","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAnalisisTransaClientesFK_IdTransaccion5WithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion5)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion5= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion5.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion5,AnalisisTransaClienteConstantesFunciones.IDTRANSACCION5,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion5);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion5","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAnalisisTransaClientesFK_IdTransaccion5(String sFinalQuery,Pagination pagination,Long id_transaccion5)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion5= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion5.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion5,AnalisisTransaClienteConstantesFunciones.IDTRANSACCION5,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion5);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion5","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAnalisisTransaClientesFK_IdTransaccion6WithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion6)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion6= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion6.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion6,AnalisisTransaClienteConstantesFunciones.IDTRANSACCION6,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion6);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion6","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAnalisisTransaClientesFK_IdTransaccion6(String sFinalQuery,Pagination pagination,Long id_transaccion6)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion6= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion6.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion6,AnalisisTransaClienteConstantesFunciones.IDTRANSACCION6,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion6);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion6","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAnalisisTransaClientesFK_IdTransaccion7WithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion7)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion7= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion7.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion7,AnalisisTransaClienteConstantesFunciones.IDTRANSACCION7,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion7);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion7","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAnalisisTransaClientesFK_IdTransaccion7(String sFinalQuery,Pagination pagination,Long id_transaccion7)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion7= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion7.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion7,AnalisisTransaClienteConstantesFunciones.IDTRANSACCION7,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion7);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion7","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAnalisisTransaClientesFK_IdTransaccion8WithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion8)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion8= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion8.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion8,AnalisisTransaClienteConstantesFunciones.IDTRANSACCION8,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion8);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion8","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAnalisisTransaClientesFK_IdTransaccion8(String sFinalQuery,Pagination pagination,Long id_transaccion8)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion8= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion8.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion8,AnalisisTransaClienteConstantesFunciones.IDTRANSACCION8,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion8);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion8","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAnalisisTransaClientesFK_IdTransaccion9WithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion9)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion9= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion9.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion9,AnalisisTransaClienteConstantesFunciones.IDTRANSACCION9,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion9);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion9","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAnalisisTransaClientesFK_IdTransaccion9(String sFinalQuery,Pagination pagination,Long id_transaccion9)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion9= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion9.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion9,AnalisisTransaClienteConstantesFunciones.IDTRANSACCION9,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion9);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion9","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAnalisisTransaClientesFK_IdTransaccionTransaccio3WithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion3)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AnalisisTransaCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion3= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion3.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion3,AnalisisTransaClienteConstantesFunciones.IDTRANSACCION3,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion3);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionTransaccio3","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAnalisisTransaClientesFK_IdTransaccionTransaccio3(String sFinalQuery,Pagination pagination,Long id_transaccion3)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion3= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion3.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion3,AnalisisTransaClienteConstantesFunciones.IDTRANSACCION3,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion3);

			AnalisisTransaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionTransaccio3","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			analisistransaclientes=analisistransaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AnalisisTransaClienteConstantesFunciones.refrescarForeignKeysDescripcionesAnalisisTransaCliente(this.analisistransaclientes);
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
			if(AnalisisTransaClienteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,AnalisisTransaClienteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,AnalisisTransaCliente analisistransacliente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(AnalisisTransaClienteConstantesFunciones.ISCONAUDITORIA) {
				if(analisistransacliente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AnalisisTransaClienteDataAccess.TABLENAME, analisistransacliente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AnalisisTransaClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AnalisisTransaClienteLogic.registrarAuditoriaDetallesAnalisisTransaCliente(connexion,analisistransacliente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(analisistransacliente.getIsDeleted()) {
					/*if(!analisistransacliente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,AnalisisTransaClienteDataAccess.TABLENAME, analisistransacliente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////AnalisisTransaClienteLogic.registrarAuditoriaDetallesAnalisisTransaCliente(connexion,analisistransacliente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AnalisisTransaClienteDataAccess.TABLENAME, analisistransacliente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(analisistransacliente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AnalisisTransaClienteDataAccess.TABLENAME, analisistransacliente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AnalisisTransaClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AnalisisTransaClienteLogic.registrarAuditoriaDetallesAnalisisTransaCliente(connexion,analisistransacliente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesAnalisisTransaCliente(Connexion connexion,AnalisisTransaCliente analisistransacliente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(analisistransacliente.getIsNew()||!analisistransacliente.getid_empresa().equals(analisistransacliente.getAnalisisTransaClienteOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(analisistransacliente.getAnalisisTransaClienteOriginal().getid_empresa()!=null)
				{
					strValorActual=analisistransacliente.getAnalisisTransaClienteOriginal().getid_empresa().toString();
				}
				if(analisistransacliente.getid_empresa()!=null)
				{
					strValorNuevo=analisistransacliente.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnalisisTransaClienteConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(analisistransacliente.getIsNew()||!analisistransacliente.getid_modulo().equals(analisistransacliente.getAnalisisTransaClienteOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(analisistransacliente.getAnalisisTransaClienteOriginal().getid_modulo()!=null)
				{
					strValorActual=analisistransacliente.getAnalisisTransaClienteOriginal().getid_modulo().toString();
				}
				if(analisistransacliente.getid_modulo()!=null)
				{
					strValorNuevo=analisistransacliente.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnalisisTransaClienteConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(analisistransacliente.getIsNew()||!analisistransacliente.getnombre().equals(analisistransacliente.getAnalisisTransaClienteOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(analisistransacliente.getAnalisisTransaClienteOriginal().getnombre()!=null)
				{
					strValorActual=analisistransacliente.getAnalisisTransaClienteOriginal().getnombre();
				}
				if(analisistransacliente.getnombre()!=null)
				{
					strValorNuevo=analisistransacliente.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnalisisTransaClienteConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(analisistransacliente.getIsNew()||!analisistransacliente.getdescripcion().equals(analisistransacliente.getAnalisisTransaClienteOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(analisistransacliente.getAnalisisTransaClienteOriginal().getdescripcion()!=null)
				{
					strValorActual=analisistransacliente.getAnalisisTransaClienteOriginal().getdescripcion();
				}
				if(analisistransacliente.getdescripcion()!=null)
				{
					strValorNuevo=analisistransacliente.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnalisisTransaClienteConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(analisistransacliente.getIsNew()||!analisistransacliente.getid_transaccion().equals(analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion()!=null)
				{
					strValorActual=analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion().toString();
				}
				if(analisistransacliente.getid_transaccion()!=null)
				{
					strValorNuevo=analisistransacliente.getid_transaccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnalisisTransaClienteConstantesFunciones.IDTRANSACCION,strValorActual,strValorNuevo);
			}	
			
			if(analisistransacliente.getIsNew()||!analisistransacliente.getid_transaccion1().equals(analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion1()!=null)
				{
					strValorActual=analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion1().toString();
				}
				if(analisistransacliente.getid_transaccion1()!=null)
				{
					strValorNuevo=analisistransacliente.getid_transaccion1().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnalisisTransaClienteConstantesFunciones.IDTRANSACCION1,strValorActual,strValorNuevo);
			}	
			
			if(analisistransacliente.getIsNew()||!analisistransacliente.getid_transaccion2().equals(analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion2()!=null)
				{
					strValorActual=analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion2().toString();
				}
				if(analisistransacliente.getid_transaccion2()!=null)
				{
					strValorNuevo=analisistransacliente.getid_transaccion2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnalisisTransaClienteConstantesFunciones.IDTRANSACCION2,strValorActual,strValorNuevo);
			}	
			
			if(analisistransacliente.getIsNew()||!analisistransacliente.getid_transaccion3().equals(analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion3()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion3()!=null)
				{
					strValorActual=analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion3().toString();
				}
				if(analisistransacliente.getid_transaccion3()!=null)
				{
					strValorNuevo=analisistransacliente.getid_transaccion3().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnalisisTransaClienteConstantesFunciones.IDTRANSACCION3,strValorActual,strValorNuevo);
			}	
			
			if(analisistransacliente.getIsNew()||!analisistransacliente.getid_transaccion4().equals(analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion4()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion4()!=null)
				{
					strValorActual=analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion4().toString();
				}
				if(analisistransacliente.getid_transaccion4()!=null)
				{
					strValorNuevo=analisistransacliente.getid_transaccion4().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnalisisTransaClienteConstantesFunciones.IDTRANSACCION4,strValorActual,strValorNuevo);
			}	
			
			if(analisistransacliente.getIsNew()||!analisistransacliente.getid_transaccion5().equals(analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion5()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion5()!=null)
				{
					strValorActual=analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion5().toString();
				}
				if(analisistransacliente.getid_transaccion5()!=null)
				{
					strValorNuevo=analisistransacliente.getid_transaccion5().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnalisisTransaClienteConstantesFunciones.IDTRANSACCION5,strValorActual,strValorNuevo);
			}	
			
			if(analisistransacliente.getIsNew()||!analisistransacliente.getid_transaccion6().equals(analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion6()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion6()!=null)
				{
					strValorActual=analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion6().toString();
				}
				if(analisistransacliente.getid_transaccion6()!=null)
				{
					strValorNuevo=analisistransacliente.getid_transaccion6().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnalisisTransaClienteConstantesFunciones.IDTRANSACCION6,strValorActual,strValorNuevo);
			}	
			
			if(analisistransacliente.getIsNew()||!analisistransacliente.getid_transaccion7().equals(analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion7()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion7()!=null)
				{
					strValorActual=analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion7().toString();
				}
				if(analisistransacliente.getid_transaccion7()!=null)
				{
					strValorNuevo=analisistransacliente.getid_transaccion7().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnalisisTransaClienteConstantesFunciones.IDTRANSACCION7,strValorActual,strValorNuevo);
			}	
			
			if(analisistransacliente.getIsNew()||!analisistransacliente.getid_transaccion8().equals(analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion8()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion8()!=null)
				{
					strValorActual=analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion8().toString();
				}
				if(analisistransacliente.getid_transaccion8()!=null)
				{
					strValorNuevo=analisistransacliente.getid_transaccion8().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnalisisTransaClienteConstantesFunciones.IDTRANSACCION8,strValorActual,strValorNuevo);
			}	
			
			if(analisistransacliente.getIsNew()||!analisistransacliente.getid_transaccion9().equals(analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion9()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion9()!=null)
				{
					strValorActual=analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion9().toString();
				}
				if(analisistransacliente.getid_transaccion9()!=null)
				{
					strValorNuevo=analisistransacliente.getid_transaccion9().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnalisisTransaClienteConstantesFunciones.IDTRANSACCION9,strValorActual,strValorNuevo);
			}	
			
			if(analisistransacliente.getIsNew()||!analisistransacliente.getid_transaccion10().equals(analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion10()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion10()!=null)
				{
					strValorActual=analisistransacliente.getAnalisisTransaClienteOriginal().getid_transaccion10().toString();
				}
				if(analisistransacliente.getid_transaccion10()!=null)
				{
					strValorNuevo=analisistransacliente.getid_transaccion10().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AnalisisTransaClienteConstantesFunciones.IDTRANSACCION10,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveAnalisisTransaClienteRelacionesWithConnection(AnalisisTransaCliente analisistransacliente) throws Exception {

		if(!analisistransacliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAnalisisTransaClienteRelacionesBase(analisistransacliente,true);
		}
	}

	public void saveAnalisisTransaClienteRelaciones(AnalisisTransaCliente analisistransacliente)throws Exception {

		if(!analisistransacliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAnalisisTransaClienteRelacionesBase(analisistransacliente,false);
		}
	}

	public void saveAnalisisTransaClienteRelacionesBase(AnalisisTransaCliente analisistransacliente,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("AnalisisTransaCliente-saveRelacionesWithConnection");}
	

			this.setAnalisisTransaCliente(analisistransacliente);

			if(AnalisisTransaClienteLogicAdditional.validarSaveRelaciones(analisistransacliente,this)) {

				AnalisisTransaClienteLogicAdditional.updateRelacionesToSave(analisistransacliente,this);

				if((analisistransacliente.getIsNew()||analisistransacliente.getIsChanged())&&!analisistransacliente.getIsDeleted()) {
					this.saveAnalisisTransaCliente();
					this.saveAnalisisTransaClienteRelacionesDetalles();

				} else if(analisistransacliente.getIsDeleted()) {
					this.saveAnalisisTransaClienteRelacionesDetalles();
					this.saveAnalisisTransaCliente();
				}

				AnalisisTransaClienteLogicAdditional.updateRelacionesToSaveAfter(analisistransacliente,this);

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
	
	
	private void saveAnalisisTransaClienteRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfAnalisisTransaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AnalisisTransaClienteConstantesFunciones.getClassesForeignKeysOfAnalisisTransaCliente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAnalisisTransaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AnalisisTransaClienteConstantesFunciones.getClassesRelationshipsOfAnalisisTransaCliente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

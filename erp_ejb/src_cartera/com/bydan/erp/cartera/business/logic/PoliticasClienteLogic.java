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
import com.bydan.erp.cartera.util.PoliticasClienteConstantesFunciones;
import com.bydan.erp.cartera.util.PoliticasClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.PoliticasClienteParameterGeneral;
import com.bydan.erp.cartera.business.entity.PoliticasCliente;
import com.bydan.erp.cartera.business.logic.PoliticasClienteLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class PoliticasClienteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PoliticasClienteLogic.class);
	
	protected PoliticasClienteDataAccess politicasclienteDataAccess; 	
	protected PoliticasCliente politicascliente;
	protected List<PoliticasCliente> politicasclientes;
	protected Object politicasclienteObject;	
	protected List<Object> politicasclientesObject;
	
	public static ClassValidator<PoliticasCliente> politicasclienteValidator = new ClassValidator<PoliticasCliente>(PoliticasCliente.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PoliticasClienteLogicAdditional politicasclienteLogicAdditional=null;
	
	public PoliticasClienteLogicAdditional getPoliticasClienteLogicAdditional() {
		return this.politicasclienteLogicAdditional;
	}
	
	public void setPoliticasClienteLogicAdditional(PoliticasClienteLogicAdditional politicasclienteLogicAdditional) {
		try {
			this.politicasclienteLogicAdditional=politicasclienteLogicAdditional;
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
	
	
	
	
	public  PoliticasClienteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.politicasclienteDataAccess = new PoliticasClienteDataAccess();
			
			this.politicasclientes= new ArrayList<PoliticasCliente>();
			this.politicascliente= new PoliticasCliente();
			
			this.politicasclienteObject=new Object();
			this.politicasclientesObject=new ArrayList<Object>();
				
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
			
			this.politicasclienteDataAccess.setConnexionType(this.connexionType);
			this.politicasclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PoliticasClienteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.politicasclienteDataAccess = new PoliticasClienteDataAccess();
			this.politicasclientes= new ArrayList<PoliticasCliente>();
			this.politicascliente= new PoliticasCliente();
			this.politicasclienteObject=new Object();
			this.politicasclientesObject=new ArrayList<Object>();
			
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
			
			this.politicasclienteDataAccess.setConnexionType(this.connexionType);
			this.politicasclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PoliticasCliente getPoliticasCliente() throws Exception {	
		PoliticasClienteLogicAdditional.checkPoliticasClienteToGet(politicascliente,this.datosCliente,this.arrDatoGeneral);
		PoliticasClienteLogicAdditional.updatePoliticasClienteToGet(politicascliente,this.arrDatoGeneral);
		
		return politicascliente;
	}
		
	public void setPoliticasCliente(PoliticasCliente newPoliticasCliente) {
		this.politicascliente = newPoliticasCliente;
	}
	
	public PoliticasClienteDataAccess getPoliticasClienteDataAccess() {
		return politicasclienteDataAccess;
	}
	
	public void setPoliticasClienteDataAccess(PoliticasClienteDataAccess newpoliticasclienteDataAccess) {
		this.politicasclienteDataAccess = newpoliticasclienteDataAccess;
	}
	
	public List<PoliticasCliente> getPoliticasClientes() throws Exception {		
		this.quitarPoliticasClientesNulos();
		
		PoliticasClienteLogicAdditional.checkPoliticasClienteToGets(politicasclientes,this.datosCliente,this.arrDatoGeneral);
		
		for (PoliticasCliente politicasclienteLocal: politicasclientes ) {
			PoliticasClienteLogicAdditional.updatePoliticasClienteToGet(politicasclienteLocal,this.arrDatoGeneral);
		}
		
		return politicasclientes;
	}
	
	public void setPoliticasClientes(List<PoliticasCliente> newPoliticasClientes) {
		this.politicasclientes = newPoliticasClientes;
	}
	
	public Object getPoliticasClienteObject() {	
		this.politicasclienteObject=this.politicasclienteDataAccess.getEntityObject();
		return this.politicasclienteObject;
	}
		
	public void setPoliticasClienteObject(Object newPoliticasClienteObject) {
		this.politicasclienteObject = newPoliticasClienteObject;
	}
	
	public List<Object> getPoliticasClientesObject() {		
		this.politicasclientesObject=this.politicasclienteDataAccess.getEntitiesObject();
		return this.politicasclientesObject;
	}
		
	public void setPoliticasClientesObject(List<Object> newPoliticasClientesObject) {
		this.politicasclientesObject = newPoliticasClientesObject;
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
		
		if(this.politicasclienteDataAccess!=null) {
			this.politicasclienteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			politicasclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			politicasclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		politicascliente = new  PoliticasCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			politicascliente=politicasclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.politicascliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicascliente);
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
		politicascliente = new  PoliticasCliente();
		  		  
        try {
			
			politicascliente=politicasclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.politicascliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicascliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		politicascliente = new  PoliticasCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			politicascliente=politicasclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.politicascliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicascliente);
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
		politicascliente = new  PoliticasCliente();
		  		  
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
		politicascliente = new  PoliticasCliente();
		  		  
        try {
			
			politicascliente=politicasclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.politicascliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicascliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		politicascliente = new  PoliticasCliente();
		  		  
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
		politicascliente = new  PoliticasCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =politicasclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		politicascliente = new  PoliticasCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=politicasclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		politicascliente = new  PoliticasCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =politicasclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		politicascliente = new  PoliticasCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=politicasclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		politicascliente = new  PoliticasCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =politicasclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		politicascliente = new  PoliticasCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=politicasclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		politicasclientes = new  ArrayList<PoliticasCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			politicasclientes=politicasclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPoliticasCliente(politicasclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
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
		politicasclientes = new  ArrayList<PoliticasCliente>();
		  		  
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
		politicasclientes = new  ArrayList<PoliticasCliente>();
		  		  
        try {			
			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			politicasclientes=politicasclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPoliticasCliente(politicasclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		politicasclientes = new  ArrayList<PoliticasCliente>();
		  		  
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
		politicasclientes = new  ArrayList<PoliticasCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			politicasclientes=politicasclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPoliticasCliente(politicasclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
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
		politicasclientes = new  ArrayList<PoliticasCliente>();
		  		  
        try {
			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			politicasclientes=politicasclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPoliticasCliente(politicasclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
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
		politicasclientes = new  ArrayList<PoliticasCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			politicasclientes=politicasclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPoliticasCliente(politicasclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
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
		politicasclientes = new  ArrayList<PoliticasCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			politicasclientes=politicasclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPoliticasCliente(politicasclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		politicascliente = new  PoliticasCliente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			politicascliente=politicasclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPoliticasCliente(politicascliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicascliente);
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
		politicascliente = new  PoliticasCliente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			politicascliente=politicasclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPoliticasCliente(politicascliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicascliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosPoliticasClientesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		politicasclientes = new  ArrayList<PoliticasCliente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-getTodosPoliticasClientesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPoliticasCliente(politicasclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
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
	
	public  void  getTodosPoliticasClientes(String sFinalQuery,Pagination pagination)throws Exception {
		politicasclientes = new  ArrayList<PoliticasCliente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPoliticasCliente(politicasclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPoliticasCliente(PoliticasCliente politicascliente) throws Exception {
		Boolean estaValidado=false;
		
		if(politicascliente.getIsNew() || politicascliente.getIsChanged()) { 
			this.invalidValues = politicasclienteValidator.getInvalidValues(politicascliente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(politicascliente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPoliticasCliente(List<PoliticasCliente> PoliticasClientes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PoliticasCliente politicasclienteLocal:politicasclientes) {				
			estaValidadoObjeto=this.validarGuardarPoliticasCliente(politicasclienteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPoliticasCliente(List<PoliticasCliente> PoliticasClientes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPoliticasCliente(politicasclientes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPoliticasCliente(PoliticasCliente PoliticasCliente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPoliticasCliente(politicascliente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PoliticasCliente politicascliente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+politicascliente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PoliticasClienteConstantesFunciones.getPoliticasClienteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"politicascliente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PoliticasClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PoliticasClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePoliticasClienteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-savePoliticasClienteWithConnection");connexion.begin();			
			
			PoliticasClienteLogicAdditional.checkPoliticasClienteToSave(this.politicascliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PoliticasClienteLogicAdditional.updatePoliticasClienteToSave(this.politicascliente,this.arrDatoGeneral);
			
			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.politicascliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPoliticasCliente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPoliticasCliente(this.politicascliente)) {
				PoliticasClienteDataAccess.save(this.politicascliente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.politicascliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PoliticasClienteLogicAdditional.checkPoliticasClienteToSaveAfter(this.politicascliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPoliticasCliente();
			
			connexion.commit();			
			
			if(this.politicascliente.getIsDeleted()) {
				this.politicascliente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePoliticasCliente()throws Exception {	
		try {	
			
			PoliticasClienteLogicAdditional.checkPoliticasClienteToSave(this.politicascliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PoliticasClienteLogicAdditional.updatePoliticasClienteToSave(this.politicascliente,this.arrDatoGeneral);
			
			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.politicascliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPoliticasCliente(this.politicascliente)) {			
				PoliticasClienteDataAccess.save(this.politicascliente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.politicascliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PoliticasClienteLogicAdditional.checkPoliticasClienteToSaveAfter(this.politicascliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.politicascliente.getIsDeleted()) {
				this.politicascliente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePoliticasClientesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-savePoliticasClientesWithConnection");connexion.begin();			
			
			PoliticasClienteLogicAdditional.checkPoliticasClienteToSaves(politicasclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPoliticasClientes();
			
			Boolean validadoTodosPoliticasCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PoliticasCliente politicasclienteLocal:politicasclientes) {		
				if(politicasclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PoliticasClienteLogicAdditional.updatePoliticasClienteToSave(politicasclienteLocal,this.arrDatoGeneral);
	        	
				PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),politicasclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPoliticasCliente(politicasclienteLocal)) {
					PoliticasClienteDataAccess.save(politicasclienteLocal, connexion);				
				} else {
					validadoTodosPoliticasCliente=false;
				}
			}
			
			if(!validadoTodosPoliticasCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PoliticasClienteLogicAdditional.checkPoliticasClienteToSavesAfter(politicasclientes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPoliticasClientes();
			
			connexion.commit();		
			
			this.quitarPoliticasClientesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePoliticasClientes()throws Exception {				
		 try {	
			PoliticasClienteLogicAdditional.checkPoliticasClienteToSaves(politicasclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPoliticasCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PoliticasCliente politicasclienteLocal:politicasclientes) {				
				if(politicasclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PoliticasClienteLogicAdditional.updatePoliticasClienteToSave(politicasclienteLocal,this.arrDatoGeneral);
	        	
				PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),politicasclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPoliticasCliente(politicasclienteLocal)) {				
					PoliticasClienteDataAccess.save(politicasclienteLocal, connexion);				
				} else {
					validadoTodosPoliticasCliente=false;
				}
			}
			
			if(!validadoTodosPoliticasCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PoliticasClienteLogicAdditional.checkPoliticasClienteToSavesAfter(politicasclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPoliticasClientesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PoliticasClienteParameterReturnGeneral procesarAccionPoliticasClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PoliticasCliente> politicasclientes,PoliticasClienteParameterReturnGeneral politicasclienteParameterGeneral)throws Exception {
		 try {	
			PoliticasClienteParameterReturnGeneral politicasclienteReturnGeneral=new PoliticasClienteParameterReturnGeneral();
	
			PoliticasClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,politicasclientes,politicasclienteParameterGeneral,politicasclienteReturnGeneral);
			
			return politicasclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PoliticasClienteParameterReturnGeneral procesarAccionPoliticasClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PoliticasCliente> politicasclientes,PoliticasClienteParameterReturnGeneral politicasclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-procesarAccionPoliticasClientesWithConnection");connexion.begin();			
			
			PoliticasClienteParameterReturnGeneral politicasclienteReturnGeneral=new PoliticasClienteParameterReturnGeneral();
	
			PoliticasClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,politicasclientes,politicasclienteParameterGeneral,politicasclienteReturnGeneral);
			
			this.connexion.commit();
			
			return politicasclienteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PoliticasClienteParameterReturnGeneral procesarEventosPoliticasClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PoliticasCliente> politicasclientes,PoliticasCliente politicascliente,PoliticasClienteParameterReturnGeneral politicasclienteParameterGeneral,Boolean isEsNuevoPoliticasCliente,ArrayList<Classe> clases)throws Exception {
		 try {	
			PoliticasClienteParameterReturnGeneral politicasclienteReturnGeneral=new PoliticasClienteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				politicasclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PoliticasClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,politicasclientes,politicascliente,politicasclienteParameterGeneral,politicasclienteReturnGeneral,isEsNuevoPoliticasCliente,clases);
			
			return politicasclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PoliticasClienteParameterReturnGeneral procesarEventosPoliticasClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PoliticasCliente> politicasclientes,PoliticasCliente politicascliente,PoliticasClienteParameterReturnGeneral politicasclienteParameterGeneral,Boolean isEsNuevoPoliticasCliente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-procesarEventosPoliticasClientesWithConnection");connexion.begin();			
			
			PoliticasClienteParameterReturnGeneral politicasclienteReturnGeneral=new PoliticasClienteParameterReturnGeneral();
	
			politicasclienteReturnGeneral.setPoliticasCliente(politicascliente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				politicasclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PoliticasClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,politicasclientes,politicascliente,politicasclienteParameterGeneral,politicasclienteReturnGeneral,isEsNuevoPoliticasCliente,clases);
			
			this.connexion.commit();
			
			return politicasclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PoliticasClienteParameterReturnGeneral procesarImportacionPoliticasClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PoliticasClienteParameterReturnGeneral politicasclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-procesarImportacionPoliticasClientesWithConnection");connexion.begin();			
			
			PoliticasClienteParameterReturnGeneral politicasclienteReturnGeneral=new PoliticasClienteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.politicasclientes=new ArrayList<PoliticasCliente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.politicascliente=new PoliticasCliente();
				
				
				if(conColumnasBase) {this.politicascliente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.politicascliente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.politicascliente.setlimite_credito(Double.parseDouble(arrColumnas[iColumn++]));
				this.politicascliente.setfecha_inicio(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.politicascliente.setfecha_renovacion(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.politicascliente.setfecha_fin(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.politicascliente.setdias_neto_pago(Integer.parseInt(arrColumnas[iColumn++]));
				this.politicascliente.setdias_gracia(Integer.parseInt(arrColumnas[iColumn++]));
				this.politicascliente.setcupo(Double.parseDouble(arrColumnas[iColumn++]));
				this.politicascliente.setdescuento_general(Double.parseDouble(arrColumnas[iColumn++]));
				this.politicascliente.setdescuento_pronto_pago(Double.parseDouble(arrColumnas[iColumn++]));
				this.politicascliente.setcon_lista_precio(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.politicascliente.setcon_impuestos(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.politicascliente.setactivar_monto_facturacion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.politicascliente.setvalor_sobregiro(Double.parseDouble(arrColumnas[iColumn++]));
				this.politicascliente.setfecha_venci_sobregiro(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.politicascliente.setvalor_solicitado(Double.parseDouble(arrColumnas[iColumn++]));
				this.politicascliente.setvalor_aprobado(Double.parseDouble(arrColumnas[iColumn++]));
				this.politicascliente.setfecha_solicitud(Funciones.ConvertToDate(arrColumnas[iColumn++]));
			this.politicascliente.setobsevacion(arrColumnas[iColumn++]);
				this.politicascliente.setweb(arrColumnas[iColumn++]);
				this.politicascliente.setcasilla_postal(arrColumnas[iColumn++]);
				this.politicascliente.setforma_envio(arrColumnas[iColumn++]);
				this.politicascliente.setnumero_cuenta(arrColumnas[iColumn++]);
				
				this.politicasclientes.add(this.politicascliente);
			}
			
			this.savePoliticasClientes();
			
			this.connexion.commit();
			
			politicasclienteReturnGeneral.setConRetornoEstaProcesado(true);
			politicasclienteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return politicasclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPoliticasClientesEliminados() throws Exception {				
		
		List<PoliticasCliente> politicasclientesAux= new ArrayList<PoliticasCliente>();
		
		for(PoliticasCliente politicascliente:politicasclientes) {
			if(!politicascliente.getIsDeleted()) {
				politicasclientesAux.add(politicascliente);
			}
		}
		
		politicasclientes=politicasclientesAux;
	}
	
	public void quitarPoliticasClientesNulos() throws Exception {				
		
		List<PoliticasCliente> politicasclientesAux= new ArrayList<PoliticasCliente>();
		
		for(PoliticasCliente politicascliente : this.politicasclientes) {
			if(politicascliente==null) {
				politicasclientesAux.add(politicascliente);
			}
		}
		
		//this.politicasclientes=politicasclientesAux;
		
		this.politicasclientes.removeAll(politicasclientesAux);
	}
	
	public void getSetVersionRowPoliticasClienteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(politicascliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((politicascliente.getIsDeleted() || (politicascliente.getIsChanged()&&!politicascliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=politicasclienteDataAccess.getSetVersionRowPoliticasCliente(connexion,politicascliente.getId());
				
				if(!politicascliente.getVersionRow().equals(timestamp)) {	
					politicascliente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				politicascliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPoliticasCliente()throws Exception {	
		
		if(politicascliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((politicascliente.getIsDeleted() || (politicascliente.getIsChanged()&&!politicascliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=politicasclienteDataAccess.getSetVersionRowPoliticasCliente(connexion,politicascliente.getId());
			
			try {							
				if(!politicascliente.getVersionRow().equals(timestamp)) {	
					politicascliente.setVersionRow(timestamp);
				}
				
				politicascliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPoliticasClientesWithConnection()throws Exception {	
		if(politicasclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PoliticasCliente politicasclienteAux:politicasclientes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(politicasclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(politicasclienteAux.getIsDeleted() || (politicasclienteAux.getIsChanged()&&!politicasclienteAux.getIsNew())) {
						
						timestamp=politicasclienteDataAccess.getSetVersionRowPoliticasCliente(connexion,politicasclienteAux.getId());
						
						if(!politicascliente.getVersionRow().equals(timestamp)) {	
							politicasclienteAux.setVersionRow(timestamp);
						}
								
						politicasclienteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPoliticasClientes()throws Exception {	
		if(politicasclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PoliticasCliente politicasclienteAux:politicasclientes) {
					if(politicasclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(politicasclienteAux.getIsDeleted() || (politicasclienteAux.getIsChanged()&&!politicasclienteAux.getIsNew())) {
						
						timestamp=politicasclienteDataAccess.getSetVersionRowPoliticasCliente(connexion,politicasclienteAux.getId());
						
						if(!politicasclienteAux.getVersionRow().equals(timestamp)) {	
							politicasclienteAux.setVersionRow(timestamp);
						}
						
													
						politicasclienteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PoliticasClienteParameterReturnGeneral cargarCombosLoteForeignKeyPoliticasClienteWithConnection(String finalQueryGlobalCliente,String finalQueryGlobalEmpresa,String finalQueryGlobalTipoPrecio,String finalQueryGlobalTransporte,String finalQueryGlobalLineaNegocio,String finalQueryGlobalBanco,String finalQueryGlobalTipoCuentaBancoGlobal,String finalQueryGlobalEstadoPoliticasCliente) throws Exception {
		PoliticasClienteParameterReturnGeneral  politicasclienteReturnGeneral =new PoliticasClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-cargarCombosLoteForeignKeyPoliticasClienteWithConnection");connexion.begin();
			
			politicasclienteReturnGeneral =new PoliticasClienteParameterReturnGeneral();
			
			

			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			politicasclienteReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			politicasclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			politicasclienteReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<Transporte> transportesForeignKey=new ArrayList<Transporte>();
			TransporteLogic transporteLogic=new TransporteLogic();
			transporteLogic.setConnexion(this.connexion);
			transporteLogic.getTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransporte.equals("NONE")) {
				transporteLogic.getTodosTransportes(finalQueryGlobalTransporte,new Pagination());
				transportesForeignKey=transporteLogic.getTransportes();
			}

			politicasclienteReturnGeneral.settransportesForeignKey(transportesForeignKey);


			List<LineaNegocio> lineanegociosForeignKey=new ArrayList<LineaNegocio>();
			LineaNegocioLogic lineanegocioLogic=new LineaNegocioLogic();
			lineanegocioLogic.setConnexion(this.connexion);
			lineanegocioLogic.getLineaNegocioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaNegocio.equals("NONE")) {
				lineanegocioLogic.getTodosLineaNegocios(finalQueryGlobalLineaNegocio,new Pagination());
				lineanegociosForeignKey=lineanegocioLogic.getLineaNegocios();
			}

			politicasclienteReturnGeneral.setlineanegociosForeignKey(lineanegociosForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			politicasclienteReturnGeneral.setbancosForeignKey(bancosForeignKey);


			List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey=new ArrayList<TipoCuentaBancoGlobal>();
			TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic=new TipoCuentaBancoGlobalLogic();
			tipocuentabancoglobalLogic.setConnexion(this.connexion);
			tipocuentabancoglobalLogic.getTipoCuentaBancoGlobalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCuentaBancoGlobal.equals("NONE")) {
				tipocuentabancoglobalLogic.getTodosTipoCuentaBancoGlobals(finalQueryGlobalTipoCuentaBancoGlobal,new Pagination());
				tipocuentabancoglobalsForeignKey=tipocuentabancoglobalLogic.getTipoCuentaBancoGlobals();
			}

			politicasclienteReturnGeneral.settipocuentabancoglobalsForeignKey(tipocuentabancoglobalsForeignKey);


			List<EstadoPoliticasCliente> estadopoliticasclientesForeignKey=new ArrayList<EstadoPoliticasCliente>();
			EstadoPoliticasClienteLogic estadopoliticasclienteLogic=new EstadoPoliticasClienteLogic();
			estadopoliticasclienteLogic.setConnexion(this.connexion);
			estadopoliticasclienteLogic.getEstadoPoliticasClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPoliticasCliente.equals("NONE")) {
				estadopoliticasclienteLogic.getTodosEstadoPoliticasClientes(finalQueryGlobalEstadoPoliticasCliente,new Pagination());
				estadopoliticasclientesForeignKey=estadopoliticasclienteLogic.getEstadoPoliticasClientes();
			}

			politicasclienteReturnGeneral.setestadopoliticasclientesForeignKey(estadopoliticasclientesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return politicasclienteReturnGeneral;
	}
	
	public PoliticasClienteParameterReturnGeneral cargarCombosLoteForeignKeyPoliticasCliente(String finalQueryGlobalCliente,String finalQueryGlobalEmpresa,String finalQueryGlobalTipoPrecio,String finalQueryGlobalTransporte,String finalQueryGlobalLineaNegocio,String finalQueryGlobalBanco,String finalQueryGlobalTipoCuentaBancoGlobal,String finalQueryGlobalEstadoPoliticasCliente) throws Exception {
		PoliticasClienteParameterReturnGeneral  politicasclienteReturnGeneral =new PoliticasClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			politicasclienteReturnGeneral =new PoliticasClienteParameterReturnGeneral();
			
			

			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			politicasclienteReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			politicasclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			politicasclienteReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<Transporte> transportesForeignKey=new ArrayList<Transporte>();
			TransporteLogic transporteLogic=new TransporteLogic();
			transporteLogic.setConnexion(this.connexion);
			transporteLogic.getTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransporte.equals("NONE")) {
				transporteLogic.getTodosTransportes(finalQueryGlobalTransporte,new Pagination());
				transportesForeignKey=transporteLogic.getTransportes();
			}

			politicasclienteReturnGeneral.settransportesForeignKey(transportesForeignKey);


			List<LineaNegocio> lineanegociosForeignKey=new ArrayList<LineaNegocio>();
			LineaNegocioLogic lineanegocioLogic=new LineaNegocioLogic();
			lineanegocioLogic.setConnexion(this.connexion);
			lineanegocioLogic.getLineaNegocioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalLineaNegocio.equals("NONE")) {
				lineanegocioLogic.getTodosLineaNegocios(finalQueryGlobalLineaNegocio,new Pagination());
				lineanegociosForeignKey=lineanegocioLogic.getLineaNegocios();
			}

			politicasclienteReturnGeneral.setlineanegociosForeignKey(lineanegociosForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			politicasclienteReturnGeneral.setbancosForeignKey(bancosForeignKey);


			List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey=new ArrayList<TipoCuentaBancoGlobal>();
			TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic=new TipoCuentaBancoGlobalLogic();
			tipocuentabancoglobalLogic.setConnexion(this.connexion);
			tipocuentabancoglobalLogic.getTipoCuentaBancoGlobalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCuentaBancoGlobal.equals("NONE")) {
				tipocuentabancoglobalLogic.getTodosTipoCuentaBancoGlobals(finalQueryGlobalTipoCuentaBancoGlobal,new Pagination());
				tipocuentabancoglobalsForeignKey=tipocuentabancoglobalLogic.getTipoCuentaBancoGlobals();
			}

			politicasclienteReturnGeneral.settipocuentabancoglobalsForeignKey(tipocuentabancoglobalsForeignKey);


			List<EstadoPoliticasCliente> estadopoliticasclientesForeignKey=new ArrayList<EstadoPoliticasCliente>();
			EstadoPoliticasClienteLogic estadopoliticasclienteLogic=new EstadoPoliticasClienteLogic();
			estadopoliticasclienteLogic.setConnexion(this.connexion);
			estadopoliticasclienteLogic.getEstadoPoliticasClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoPoliticasCliente.equals("NONE")) {
				estadopoliticasclienteLogic.getTodosEstadoPoliticasClientes(finalQueryGlobalEstadoPoliticasCliente,new Pagination());
				estadopoliticasclientesForeignKey=estadopoliticasclienteLogic.getEstadoPoliticasClientes();
			}

			politicasclienteReturnGeneral.setestadopoliticasclientesForeignKey(estadopoliticasclientesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return politicasclienteReturnGeneral;
	}
	
	
	public void deepLoad(PoliticasCliente politicascliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PoliticasClienteLogicAdditional.updatePoliticasClienteToGet(politicascliente,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		politicascliente.setCliente(politicasclienteDataAccess.getCliente(connexion,politicascliente));
		politicascliente.setEmpresa(politicasclienteDataAccess.getEmpresa(connexion,politicascliente));
		politicascliente.setTipoPrecio(politicasclienteDataAccess.getTipoPrecio(connexion,politicascliente));
		politicascliente.setTransporte(politicasclienteDataAccess.getTransporte(connexion,politicascliente));
		politicascliente.setLineaNegocio(politicasclienteDataAccess.getLineaNegocio(connexion,politicascliente));
		politicascliente.setBanco(politicasclienteDataAccess.getBanco(connexion,politicascliente));
		politicascliente.setTipoCuentaBancoGlobal(politicasclienteDataAccess.getTipoCuentaBancoGlobal(connexion,politicascliente));
		politicascliente.setEstadoPoliticasCliente(politicasclienteDataAccess.getEstadoPoliticasCliente(connexion,politicascliente));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				politicascliente.setCliente(politicasclienteDataAccess.getCliente(connexion,politicascliente));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				politicascliente.setEmpresa(politicasclienteDataAccess.getEmpresa(connexion,politicascliente));
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				politicascliente.setTipoPrecio(politicasclienteDataAccess.getTipoPrecio(connexion,politicascliente));
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				politicascliente.setTransporte(politicasclienteDataAccess.getTransporte(connexion,politicascliente));
				continue;
			}

			if(clas.clas.equals(LineaNegocio.class)) {
				politicascliente.setLineaNegocio(politicasclienteDataAccess.getLineaNegocio(connexion,politicascliente));
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				politicascliente.setBanco(politicasclienteDataAccess.getBanco(connexion,politicascliente));
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				politicascliente.setTipoCuentaBancoGlobal(politicasclienteDataAccess.getTipoCuentaBancoGlobal(connexion,politicascliente));
				continue;
			}

			if(clas.clas.equals(EstadoPoliticasCliente.class)) {
				politicascliente.setEstadoPoliticasCliente(politicasclienteDataAccess.getEstadoPoliticasCliente(connexion,politicascliente));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			politicascliente.setCliente(politicasclienteDataAccess.getCliente(connexion,politicascliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			politicascliente.setEmpresa(politicasclienteDataAccess.getEmpresa(connexion,politicascliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			politicascliente.setTipoPrecio(politicasclienteDataAccess.getTipoPrecio(connexion,politicascliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			politicascliente.setTransporte(politicasclienteDataAccess.getTransporte(connexion,politicascliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(LineaNegocio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			politicascliente.setLineaNegocio(politicasclienteDataAccess.getLineaNegocio(connexion,politicascliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			politicascliente.setBanco(politicasclienteDataAccess.getBanco(connexion,politicascliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			politicascliente.setTipoCuentaBancoGlobal(politicasclienteDataAccess.getTipoCuentaBancoGlobal(connexion,politicascliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPoliticasCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			politicascliente.setEstadoPoliticasCliente(politicasclienteDataAccess.getEstadoPoliticasCliente(connexion,politicascliente));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		politicascliente.setCliente(politicasclienteDataAccess.getCliente(connexion,politicascliente));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(politicascliente.getCliente(),isDeep,deepLoadType,clases);
				
		politicascliente.setEmpresa(politicasclienteDataAccess.getEmpresa(connexion,politicascliente));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(politicascliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		politicascliente.setTipoPrecio(politicasclienteDataAccess.getTipoPrecio(connexion,politicascliente));
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(politicascliente.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		politicascliente.setTransporte(politicasclienteDataAccess.getTransporte(connexion,politicascliente));
		TransporteLogic transporteLogic= new TransporteLogic(connexion);
		transporteLogic.deepLoad(politicascliente.getTransporte(),isDeep,deepLoadType,clases);
				
		politicascliente.setLineaNegocio(politicasclienteDataAccess.getLineaNegocio(connexion,politicascliente));
		LineaNegocioLogic lineanegocioLogic= new LineaNegocioLogic(connexion);
		lineanegocioLogic.deepLoad(politicascliente.getLineaNegocio(),isDeep,deepLoadType,clases);
				
		politicascliente.setBanco(politicasclienteDataAccess.getBanco(connexion,politicascliente));
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(politicascliente.getBanco(),isDeep,deepLoadType,clases);
				
		politicascliente.setTipoCuentaBancoGlobal(politicasclienteDataAccess.getTipoCuentaBancoGlobal(connexion,politicascliente));
		TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
		tipocuentabancoglobalLogic.deepLoad(politicascliente.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);
				
		politicascliente.setEstadoPoliticasCliente(politicasclienteDataAccess.getEstadoPoliticasCliente(connexion,politicascliente));
		EstadoPoliticasClienteLogic estadopoliticasclienteLogic= new EstadoPoliticasClienteLogic(connexion);
		estadopoliticasclienteLogic.deepLoad(politicascliente.getEstadoPoliticasCliente(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				politicascliente.setCliente(politicasclienteDataAccess.getCliente(connexion,politicascliente));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(politicascliente.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				politicascliente.setEmpresa(politicasclienteDataAccess.getEmpresa(connexion,politicascliente));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(politicascliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				politicascliente.setTipoPrecio(politicasclienteDataAccess.getTipoPrecio(connexion,politicascliente));
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepLoad(politicascliente.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transporte.class)) {
				politicascliente.setTransporte(politicasclienteDataAccess.getTransporte(connexion,politicascliente));
				TransporteLogic transporteLogic= new TransporteLogic(connexion);
				transporteLogic.deepLoad(politicascliente.getTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(LineaNegocio.class)) {
				politicascliente.setLineaNegocio(politicasclienteDataAccess.getLineaNegocio(connexion,politicascliente));
				LineaNegocioLogic lineanegocioLogic= new LineaNegocioLogic(connexion);
				lineanegocioLogic.deepLoad(politicascliente.getLineaNegocio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				politicascliente.setBanco(politicasclienteDataAccess.getBanco(connexion,politicascliente));
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepLoad(politicascliente.getBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				politicascliente.setTipoCuentaBancoGlobal(politicasclienteDataAccess.getTipoCuentaBancoGlobal(connexion,politicascliente));
				TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
				tipocuentabancoglobalLogic.deepLoad(politicascliente.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoPoliticasCliente.class)) {
				politicascliente.setEstadoPoliticasCliente(politicasclienteDataAccess.getEstadoPoliticasCliente(connexion,politicascliente));
				EstadoPoliticasClienteLogic estadopoliticasclienteLogic= new EstadoPoliticasClienteLogic(connexion);
				estadopoliticasclienteLogic.deepLoad(politicascliente.getEstadoPoliticasCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			politicascliente.setCliente(politicasclienteDataAccess.getCliente(connexion,politicascliente));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(politicascliente.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			politicascliente.setEmpresa(politicasclienteDataAccess.getEmpresa(connexion,politicascliente));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(politicascliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			politicascliente.setTipoPrecio(politicasclienteDataAccess.getTipoPrecio(connexion,politicascliente));
			TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
			tipoprecioLogic.deepLoad(politicascliente.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			politicascliente.setTransporte(politicasclienteDataAccess.getTransporte(connexion,politicascliente));
			TransporteLogic transporteLogic= new TransporteLogic(connexion);
			transporteLogic.deepLoad(politicascliente.getTransporte(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(LineaNegocio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			politicascliente.setLineaNegocio(politicasclienteDataAccess.getLineaNegocio(connexion,politicascliente));
			LineaNegocioLogic lineanegocioLogic= new LineaNegocioLogic(connexion);
			lineanegocioLogic.deepLoad(politicascliente.getLineaNegocio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			politicascliente.setBanco(politicasclienteDataAccess.getBanco(connexion,politicascliente));
			BancoLogic bancoLogic= new BancoLogic(connexion);
			bancoLogic.deepLoad(politicascliente.getBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			politicascliente.setTipoCuentaBancoGlobal(politicasclienteDataAccess.getTipoCuentaBancoGlobal(connexion,politicascliente));
			TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
			tipocuentabancoglobalLogic.deepLoad(politicascliente.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoPoliticasCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			politicascliente.setEstadoPoliticasCliente(politicasclienteDataAccess.getEstadoPoliticasCliente(connexion,politicascliente));
			EstadoPoliticasClienteLogic estadopoliticasclienteLogic= new EstadoPoliticasClienteLogic(connexion);
			estadopoliticasclienteLogic.deepLoad(politicascliente.getEstadoPoliticasCliente(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PoliticasCliente politicascliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PoliticasCliente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(politicascliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(politicascliente);
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
			this.deepLoad(this.politicascliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicascliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PoliticasCliente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(politicasclientes!=null) {
				for(PoliticasCliente politicascliente:politicasclientes) {
					this.deepLoad(politicascliente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(politicasclientes);
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
			if(politicasclientes!=null) {
				for(PoliticasCliente politicascliente:politicasclientes) {
					this.deepLoad(politicascliente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(politicasclientes);
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
	
	
	public void getPoliticasClientesFK_IdBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,PoliticasClienteConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPoliticasClientesFK_IdBanco(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,PoliticasClienteConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPoliticasClientesFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,PoliticasClienteConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPoliticasClientesFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,PoliticasClienteConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPoliticasClientesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PoliticasClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPoliticasClientesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PoliticasClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPoliticasClientesFK_IdEstadoPoliticasClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_politicas_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPoliticasCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPoliticasCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_politicas_cliente,PoliticasClienteConstantesFunciones.IDESTADOPOLITICASCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPoliticasCliente);

			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPoliticasCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPoliticasClientesFK_IdEstadoPoliticasCliente(String sFinalQuery,Pagination pagination,Long id_estado_politicas_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoPoliticasCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoPoliticasCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_politicas_cliente,PoliticasClienteConstantesFunciones.IDESTADOPOLITICASCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoPoliticasCliente);

			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoPoliticasCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPoliticasClientesFK_IdLineaNegocioWithConnection(String sFinalQuery,Pagination pagination,Long id_linea_negocio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaNegocio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaNegocio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_negocio,PoliticasClienteConstantesFunciones.IDLINEANEGOCIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaNegocio);

			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaNegocio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPoliticasClientesFK_IdLineaNegocio(String sFinalQuery,Pagination pagination,Long id_linea_negocio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidLineaNegocio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidLineaNegocio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_linea_negocio,PoliticasClienteConstantesFunciones.IDLINEANEGOCIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidLineaNegocio);

			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdLineaNegocio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPoliticasClientesFK_IdTipoCuentaBancoGlobalWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cuenta_banco_global)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCuentaBancoGlobal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCuentaBancoGlobal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cuenta_banco_global,PoliticasClienteConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCuentaBancoGlobal);

			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCuentaBancoGlobal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPoliticasClientesFK_IdTipoCuentaBancoGlobal(String sFinalQuery,Pagination pagination,Long id_tipo_cuenta_banco_global)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCuentaBancoGlobal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCuentaBancoGlobal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cuenta_banco_global,PoliticasClienteConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCuentaBancoGlobal);

			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCuentaBancoGlobal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPoliticasClientesFK_IdTipoPrecioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,PoliticasClienteConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPoliticasClientesFK_IdTipoPrecio(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,PoliticasClienteConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPoliticasClientesFK_IdTransporteWithConnection(String sFinalQuery,Pagination pagination,Long id_transporte)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PoliticasCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transporte,PoliticasClienteConstantesFunciones.IDTRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransporte);

			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPoliticasClientesFK_IdTransporte(String sFinalQuery,Pagination pagination,Long id_transporte)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transporte,PoliticasClienteConstantesFunciones.IDTRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransporte);

			PoliticasClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(this.politicasclientes);
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
			if(PoliticasClienteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PoliticasClienteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PoliticasCliente politicascliente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PoliticasClienteConstantesFunciones.ISCONAUDITORIA) {
				if(politicascliente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PoliticasClienteDataAccess.TABLENAME, politicascliente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PoliticasClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PoliticasClienteLogic.registrarAuditoriaDetallesPoliticasCliente(connexion,politicascliente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(politicascliente.getIsDeleted()) {
					/*if(!politicascliente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PoliticasClienteDataAccess.TABLENAME, politicascliente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PoliticasClienteLogic.registrarAuditoriaDetallesPoliticasCliente(connexion,politicascliente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PoliticasClienteDataAccess.TABLENAME, politicascliente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(politicascliente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PoliticasClienteDataAccess.TABLENAME, politicascliente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PoliticasClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PoliticasClienteLogic.registrarAuditoriaDetallesPoliticasCliente(connexion,politicascliente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPoliticasCliente(Connexion connexion,PoliticasCliente politicascliente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(politicascliente.getIsNew()||!politicascliente.getid_empresa().equals(politicascliente.getPoliticasClienteOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getid_empresa()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getid_empresa().toString();
				}
				if(politicascliente.getid_empresa()!=null)
				{
					strValorNuevo=politicascliente.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getlimite_credito().equals(politicascliente.getPoliticasClienteOriginal().getlimite_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getlimite_credito()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getlimite_credito().toString();
				}
				if(politicascliente.getlimite_credito()!=null)
				{
					strValorNuevo=politicascliente.getlimite_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.LIMITECREDITO,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getfecha_inicio().equals(politicascliente.getPoliticasClienteOriginal().getfecha_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getfecha_inicio()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getfecha_inicio().toString();
				}
				if(politicascliente.getfecha_inicio()!=null)
				{
					strValorNuevo=politicascliente.getfecha_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.FECHAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getfecha_renovacion().equals(politicascliente.getPoliticasClienteOriginal().getfecha_renovacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getfecha_renovacion()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getfecha_renovacion().toString();
				}
				if(politicascliente.getfecha_renovacion()!=null)
				{
					strValorNuevo=politicascliente.getfecha_renovacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.FECHARENOVACION,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getfecha_fin().equals(politicascliente.getPoliticasClienteOriginal().getfecha_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getfecha_fin()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getfecha_fin().toString();
				}
				if(politicascliente.getfecha_fin()!=null)
				{
					strValorNuevo=politicascliente.getfecha_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.FECHAFIN,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getdias_neto_pago().equals(politicascliente.getPoliticasClienteOriginal().getdias_neto_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getdias_neto_pago()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getdias_neto_pago().toString();
				}
				if(politicascliente.getdias_neto_pago()!=null)
				{
					strValorNuevo=politicascliente.getdias_neto_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.DIASNETOPAGO,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getdias_gracia().equals(politicascliente.getPoliticasClienteOriginal().getdias_gracia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getdias_gracia()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getdias_gracia().toString();
				}
				if(politicascliente.getdias_gracia()!=null)
				{
					strValorNuevo=politicascliente.getdias_gracia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.DIASGRACIA,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getcupo().equals(politicascliente.getPoliticasClienteOriginal().getcupo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getcupo()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getcupo().toString();
				}
				if(politicascliente.getcupo()!=null)
				{
					strValorNuevo=politicascliente.getcupo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.CUPO,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getdescuento_general().equals(politicascliente.getPoliticasClienteOriginal().getdescuento_general()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getdescuento_general()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getdescuento_general().toString();
				}
				if(politicascliente.getdescuento_general()!=null)
				{
					strValorNuevo=politicascliente.getdescuento_general().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.DESCUENTOGENERAL,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getdescuento_pronto_pago().equals(politicascliente.getPoliticasClienteOriginal().getdescuento_pronto_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getdescuento_pronto_pago()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getdescuento_pronto_pago().toString();
				}
				if(politicascliente.getdescuento_pronto_pago()!=null)
				{
					strValorNuevo=politicascliente.getdescuento_pronto_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.DESCUENTOPRONTOPAGO,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getid_tipo_precio().equals(politicascliente.getPoliticasClienteOriginal().getid_tipo_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getid_tipo_precio()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getid_tipo_precio().toString();
				}
				if(politicascliente.getid_tipo_precio()!=null)
				{
					strValorNuevo=politicascliente.getid_tipo_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.IDTIPOPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getcon_lista_precio().equals(politicascliente.getPoliticasClienteOriginal().getcon_lista_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getcon_lista_precio()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getcon_lista_precio().toString();
				}
				if(politicascliente.getcon_lista_precio()!=null)
				{
					strValorNuevo=politicascliente.getcon_lista_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.CONLISTAPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getcon_impuestos().equals(politicascliente.getPoliticasClienteOriginal().getcon_impuestos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getcon_impuestos()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getcon_impuestos().toString();
				}
				if(politicascliente.getcon_impuestos()!=null)
				{
					strValorNuevo=politicascliente.getcon_impuestos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.CONIMPUESTOS,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getactivar_monto_facturacion().equals(politicascliente.getPoliticasClienteOriginal().getactivar_monto_facturacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getactivar_monto_facturacion()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getactivar_monto_facturacion().toString();
				}
				if(politicascliente.getactivar_monto_facturacion()!=null)
				{
					strValorNuevo=politicascliente.getactivar_monto_facturacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.ACTIVARMONTOFACTURACION,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getvalor_sobregiro().equals(politicascliente.getPoliticasClienteOriginal().getvalor_sobregiro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getvalor_sobregiro()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getvalor_sobregiro().toString();
				}
				if(politicascliente.getvalor_sobregiro()!=null)
				{
					strValorNuevo=politicascliente.getvalor_sobregiro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.VALORSOBREGIRO,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getfecha_venci_sobregiro().equals(politicascliente.getPoliticasClienteOriginal().getfecha_venci_sobregiro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getfecha_venci_sobregiro()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getfecha_venci_sobregiro().toString();
				}
				if(politicascliente.getfecha_venci_sobregiro()!=null)
				{
					strValorNuevo=politicascliente.getfecha_venci_sobregiro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.FECHAVENCISOBREGIRO,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getid_transporte().equals(politicascliente.getPoliticasClienteOriginal().getid_transporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getid_transporte()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getid_transporte().toString();
				}
				if(politicascliente.getid_transporte()!=null)
				{
					strValorNuevo=politicascliente.getid_transporte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.IDTRANSPORTE,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getvalor_solicitado().equals(politicascliente.getPoliticasClienteOriginal().getvalor_solicitado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getvalor_solicitado()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getvalor_solicitado().toString();
				}
				if(politicascliente.getvalor_solicitado()!=null)
				{
					strValorNuevo=politicascliente.getvalor_solicitado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.VALORSOLICITADO,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getvalor_aprobado().equals(politicascliente.getPoliticasClienteOriginal().getvalor_aprobado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getvalor_aprobado()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getvalor_aprobado().toString();
				}
				if(politicascliente.getvalor_aprobado()!=null)
				{
					strValorNuevo=politicascliente.getvalor_aprobado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.VALORAPROBADO,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getid_linea_negocio().equals(politicascliente.getPoliticasClienteOriginal().getid_linea_negocio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getid_linea_negocio()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getid_linea_negocio().toString();
				}
				if(politicascliente.getid_linea_negocio()!=null)
				{
					strValorNuevo=politicascliente.getid_linea_negocio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.IDLINEANEGOCIO,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getfecha_solicitud().equals(politicascliente.getPoliticasClienteOriginal().getfecha_solicitud()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getfecha_solicitud()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getfecha_solicitud().toString();
				}
				if(politicascliente.getfecha_solicitud()!=null)
				{
					strValorNuevo=politicascliente.getfecha_solicitud().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.FECHASOLICITUD,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getobsevacion().equals(politicascliente.getPoliticasClienteOriginal().getobsevacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getobsevacion()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getobsevacion();
				}
				if(politicascliente.getobsevacion()!=null)
				{
					strValorNuevo=politicascliente.getobsevacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.OBSEVACION,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getweb().equals(politicascliente.getPoliticasClienteOriginal().getweb()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getweb()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getweb();
				}
				if(politicascliente.getweb()!=null)
				{
					strValorNuevo=politicascliente.getweb() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.WEB,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getcasilla_postal().equals(politicascliente.getPoliticasClienteOriginal().getcasilla_postal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getcasilla_postal()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getcasilla_postal();
				}
				if(politicascliente.getcasilla_postal()!=null)
				{
					strValorNuevo=politicascliente.getcasilla_postal() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.CASILLAPOSTAL,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getforma_envio().equals(politicascliente.getPoliticasClienteOriginal().getforma_envio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getforma_envio()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getforma_envio();
				}
				if(politicascliente.getforma_envio()!=null)
				{
					strValorNuevo=politicascliente.getforma_envio() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.FORMAENVIO,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getid_banco().equals(politicascliente.getPoliticasClienteOriginal().getid_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getid_banco()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getid_banco().toString();
				}
				if(politicascliente.getid_banco()!=null)
				{
					strValorNuevo=politicascliente.getid_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.IDBANCO,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getid_tipo_cuenta_banco_global().equals(politicascliente.getPoliticasClienteOriginal().getid_tipo_cuenta_banco_global()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getid_tipo_cuenta_banco_global()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getid_tipo_cuenta_banco_global().toString();
				}
				if(politicascliente.getid_tipo_cuenta_banco_global()!=null)
				{
					strValorNuevo=politicascliente.getid_tipo_cuenta_banco_global().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getnumero_cuenta().equals(politicascliente.getPoliticasClienteOriginal().getnumero_cuenta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getnumero_cuenta()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getnumero_cuenta();
				}
				if(politicascliente.getnumero_cuenta()!=null)
				{
					strValorNuevo=politicascliente.getnumero_cuenta() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.NUMEROCUENTA,strValorActual,strValorNuevo);
			}	
			
			if(politicascliente.getIsNew()||!politicascliente.getid_estado_politicas_cliente().equals(politicascliente.getPoliticasClienteOriginal().getid_estado_politicas_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(politicascliente.getPoliticasClienteOriginal().getid_estado_politicas_cliente()!=null)
				{
					strValorActual=politicascliente.getPoliticasClienteOriginal().getid_estado_politicas_cliente().toString();
				}
				if(politicascliente.getid_estado_politicas_cliente()!=null)
				{
					strValorNuevo=politicascliente.getid_estado_politicas_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PoliticasClienteConstantesFunciones.IDESTADOPOLITICASCLIENTE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPoliticasCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PoliticasClienteConstantesFunciones.getClassesForeignKeysOfPoliticasCliente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPoliticasCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PoliticasClienteConstantesFunciones.getClassesRelationshipsOfPoliticasCliente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

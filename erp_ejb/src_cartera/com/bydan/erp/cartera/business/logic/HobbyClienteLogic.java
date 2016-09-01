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
import com.bydan.erp.cartera.util.HobbyClienteConstantesFunciones;
import com.bydan.erp.cartera.util.HobbyClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.HobbyClienteParameterGeneral;
import com.bydan.erp.cartera.business.entity.HobbyCliente;
import com.bydan.erp.cartera.business.logic.HobbyClienteLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class HobbyClienteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(HobbyClienteLogic.class);
	
	protected HobbyClienteDataAccess hobbyclienteDataAccess; 	
	protected HobbyCliente hobbycliente;
	protected List<HobbyCliente> hobbyclientes;
	protected Object hobbyclienteObject;	
	protected List<Object> hobbyclientesObject;
	
	public static ClassValidator<HobbyCliente> hobbyclienteValidator = new ClassValidator<HobbyCliente>(HobbyCliente.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected HobbyClienteLogicAdditional hobbyclienteLogicAdditional=null;
	
	public HobbyClienteLogicAdditional getHobbyClienteLogicAdditional() {
		return this.hobbyclienteLogicAdditional;
	}
	
	public void setHobbyClienteLogicAdditional(HobbyClienteLogicAdditional hobbyclienteLogicAdditional) {
		try {
			this.hobbyclienteLogicAdditional=hobbyclienteLogicAdditional;
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
	
	
	
	
	public  HobbyClienteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.hobbyclienteDataAccess = new HobbyClienteDataAccess();
			
			this.hobbyclientes= new ArrayList<HobbyCliente>();
			this.hobbycliente= new HobbyCliente();
			
			this.hobbyclienteObject=new Object();
			this.hobbyclientesObject=new ArrayList<Object>();
				
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
			
			this.hobbyclienteDataAccess.setConnexionType(this.connexionType);
			this.hobbyclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  HobbyClienteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.hobbyclienteDataAccess = new HobbyClienteDataAccess();
			this.hobbyclientes= new ArrayList<HobbyCliente>();
			this.hobbycliente= new HobbyCliente();
			this.hobbyclienteObject=new Object();
			this.hobbyclientesObject=new ArrayList<Object>();
			
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
			
			this.hobbyclienteDataAccess.setConnexionType(this.connexionType);
			this.hobbyclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public HobbyCliente getHobbyCliente() throws Exception {	
		HobbyClienteLogicAdditional.checkHobbyClienteToGet(hobbycliente,this.datosCliente,this.arrDatoGeneral);
		HobbyClienteLogicAdditional.updateHobbyClienteToGet(hobbycliente,this.arrDatoGeneral);
		
		return hobbycliente;
	}
		
	public void setHobbyCliente(HobbyCliente newHobbyCliente) {
		this.hobbycliente = newHobbyCliente;
	}
	
	public HobbyClienteDataAccess getHobbyClienteDataAccess() {
		return hobbyclienteDataAccess;
	}
	
	public void setHobbyClienteDataAccess(HobbyClienteDataAccess newhobbyclienteDataAccess) {
		this.hobbyclienteDataAccess = newhobbyclienteDataAccess;
	}
	
	public List<HobbyCliente> getHobbyClientes() throws Exception {		
		this.quitarHobbyClientesNulos();
		
		HobbyClienteLogicAdditional.checkHobbyClienteToGets(hobbyclientes,this.datosCliente,this.arrDatoGeneral);
		
		for (HobbyCliente hobbyclienteLocal: hobbyclientes ) {
			HobbyClienteLogicAdditional.updateHobbyClienteToGet(hobbyclienteLocal,this.arrDatoGeneral);
		}
		
		return hobbyclientes;
	}
	
	public void setHobbyClientes(List<HobbyCliente> newHobbyClientes) {
		this.hobbyclientes = newHobbyClientes;
	}
	
	public Object getHobbyClienteObject() {	
		this.hobbyclienteObject=this.hobbyclienteDataAccess.getEntityObject();
		return this.hobbyclienteObject;
	}
		
	public void setHobbyClienteObject(Object newHobbyClienteObject) {
		this.hobbyclienteObject = newHobbyClienteObject;
	}
	
	public List<Object> getHobbyClientesObject() {		
		this.hobbyclientesObject=this.hobbyclienteDataAccess.getEntitiesObject();
		return this.hobbyclientesObject;
	}
		
	public void setHobbyClientesObject(List<Object> newHobbyClientesObject) {
		this.hobbyclientesObject = newHobbyClientesObject;
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
		
		if(this.hobbyclienteDataAccess!=null) {
			this.hobbyclienteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HobbyCliente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			hobbyclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			hobbyclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		hobbycliente = new  HobbyCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HobbyCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			hobbycliente=hobbyclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.hobbycliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbycliente);
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
		hobbycliente = new  HobbyCliente();
		  		  
        try {
			
			hobbycliente=hobbyclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.hobbycliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbycliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		hobbycliente = new  HobbyCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HobbyCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			hobbycliente=hobbyclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.hobbycliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbycliente);
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
		hobbycliente = new  HobbyCliente();
		  		  
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
		hobbycliente = new  HobbyCliente();
		  		  
        try {
			
			hobbycliente=hobbyclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.hobbycliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbycliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		hobbycliente = new  HobbyCliente();
		  		  
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
		hobbycliente = new  HobbyCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HobbyCliente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =hobbyclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		hobbycliente = new  HobbyCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=hobbyclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		hobbycliente = new  HobbyCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HobbyCliente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =hobbyclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		hobbycliente = new  HobbyCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=hobbyclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		hobbycliente = new  HobbyCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HobbyCliente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =hobbyclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		hobbycliente = new  HobbyCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=hobbyclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		hobbyclientes = new  ArrayList<HobbyCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HobbyCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			HobbyClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobbyclientes=hobbyclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHobbyCliente(hobbyclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbyclientes);
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
		hobbyclientes = new  ArrayList<HobbyCliente>();
		  		  
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
		hobbyclientes = new  ArrayList<HobbyCliente>();
		  		  
        try {			
			HobbyClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobbyclientes=hobbyclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarHobbyCliente(hobbyclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbyclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		hobbyclientes = new  ArrayList<HobbyCliente>();
		  		  
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
		hobbyclientes = new  ArrayList<HobbyCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HobbyCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			HobbyClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobbyclientes=hobbyclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHobbyCliente(hobbyclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbyclientes);
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
		hobbyclientes = new  ArrayList<HobbyCliente>();
		  		  
        try {
			HobbyClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobbyclientes=hobbyclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHobbyCliente(hobbyclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbyclientes);
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
		hobbyclientes = new  ArrayList<HobbyCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HobbyCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HobbyClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobbyclientes=hobbyclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHobbyCliente(hobbyclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbyclientes);
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
		hobbyclientes = new  ArrayList<HobbyCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HobbyClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobbyclientes=hobbyclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHobbyCliente(hobbyclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbyclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		hobbycliente = new  HobbyCliente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HobbyCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HobbyClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobbycliente=hobbyclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHobbyCliente(hobbycliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbycliente);
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
		hobbycliente = new  HobbyCliente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HobbyClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobbycliente=hobbyclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHobbyCliente(hobbycliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbycliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		hobbyclientes = new  ArrayList<HobbyCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HobbyCliente.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			HobbyClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobbyclientes=hobbyclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHobbyCliente(hobbyclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbyclientes);
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
		hobbyclientes = new  ArrayList<HobbyCliente>();
		  		  
        try {
			HobbyClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobbyclientes=hobbyclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHobbyCliente(hobbyclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbyclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosHobbyClientesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		hobbyclientes = new  ArrayList<HobbyCliente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HobbyCliente.class.getSimpleName()+"-getTodosHobbyClientesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HobbyClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobbyclientes=hobbyclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarHobbyCliente(hobbyclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbyclientes);
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
	
	public  void  getTodosHobbyClientes(String sFinalQuery,Pagination pagination)throws Exception {
		hobbyclientes = new  ArrayList<HobbyCliente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HobbyClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			hobbyclientes=hobbyclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarHobbyCliente(hobbyclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbyclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarHobbyCliente(HobbyCliente hobbycliente) throws Exception {
		Boolean estaValidado=false;
		
		if(hobbycliente.getIsNew() || hobbycliente.getIsChanged()) { 
			this.invalidValues = hobbyclienteValidator.getInvalidValues(hobbycliente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(hobbycliente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarHobbyCliente(List<HobbyCliente> HobbyClientes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(HobbyCliente hobbyclienteLocal:hobbyclientes) {				
			estaValidadoObjeto=this.validarGuardarHobbyCliente(hobbyclienteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarHobbyCliente(List<HobbyCliente> HobbyClientes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarHobbyCliente(hobbyclientes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarHobbyCliente(HobbyCliente HobbyCliente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarHobbyCliente(hobbycliente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(HobbyCliente hobbycliente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+hobbycliente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=HobbyClienteConstantesFunciones.getHobbyClienteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"hobbycliente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(HobbyClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(HobbyClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveHobbyClienteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HobbyCliente.class.getSimpleName()+"-saveHobbyClienteWithConnection");connexion.begin();			
			
			HobbyClienteLogicAdditional.checkHobbyClienteToSave(this.hobbycliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			HobbyClienteLogicAdditional.updateHobbyClienteToSave(this.hobbycliente,this.arrDatoGeneral);
			
			HobbyClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.hobbycliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowHobbyCliente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarHobbyCliente(this.hobbycliente)) {
				HobbyClienteDataAccess.save(this.hobbycliente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.hobbycliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			HobbyClienteLogicAdditional.checkHobbyClienteToSaveAfter(this.hobbycliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowHobbyCliente();
			
			connexion.commit();			
			
			if(this.hobbycliente.getIsDeleted()) {
				this.hobbycliente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveHobbyCliente()throws Exception {	
		try {	
			
			HobbyClienteLogicAdditional.checkHobbyClienteToSave(this.hobbycliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			HobbyClienteLogicAdditional.updateHobbyClienteToSave(this.hobbycliente,this.arrDatoGeneral);
			
			HobbyClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.hobbycliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarHobbyCliente(this.hobbycliente)) {			
				HobbyClienteDataAccess.save(this.hobbycliente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.hobbycliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			HobbyClienteLogicAdditional.checkHobbyClienteToSaveAfter(this.hobbycliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.hobbycliente.getIsDeleted()) {
				this.hobbycliente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveHobbyClientesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HobbyCliente.class.getSimpleName()+"-saveHobbyClientesWithConnection");connexion.begin();			
			
			HobbyClienteLogicAdditional.checkHobbyClienteToSaves(hobbyclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowHobbyClientes();
			
			Boolean validadoTodosHobbyCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(HobbyCliente hobbyclienteLocal:hobbyclientes) {		
				if(hobbyclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				HobbyClienteLogicAdditional.updateHobbyClienteToSave(hobbyclienteLocal,this.arrDatoGeneral);
	        	
				HobbyClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),hobbyclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarHobbyCliente(hobbyclienteLocal)) {
					HobbyClienteDataAccess.save(hobbyclienteLocal, connexion);				
				} else {
					validadoTodosHobbyCliente=false;
				}
			}
			
			if(!validadoTodosHobbyCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			HobbyClienteLogicAdditional.checkHobbyClienteToSavesAfter(hobbyclientes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowHobbyClientes();
			
			connexion.commit();		
			
			this.quitarHobbyClientesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveHobbyClientes()throws Exception {				
		 try {	
			HobbyClienteLogicAdditional.checkHobbyClienteToSaves(hobbyclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosHobbyCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(HobbyCliente hobbyclienteLocal:hobbyclientes) {				
				if(hobbyclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				HobbyClienteLogicAdditional.updateHobbyClienteToSave(hobbyclienteLocal,this.arrDatoGeneral);
	        	
				HobbyClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),hobbyclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarHobbyCliente(hobbyclienteLocal)) {				
					HobbyClienteDataAccess.save(hobbyclienteLocal, connexion);				
				} else {
					validadoTodosHobbyCliente=false;
				}
			}
			
			if(!validadoTodosHobbyCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			HobbyClienteLogicAdditional.checkHobbyClienteToSavesAfter(hobbyclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarHobbyClientesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public HobbyClienteParameterReturnGeneral procesarAccionHobbyClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<HobbyCliente> hobbyclientes,HobbyClienteParameterReturnGeneral hobbyclienteParameterGeneral)throws Exception {
		 try {	
			HobbyClienteParameterReturnGeneral hobbyclienteReturnGeneral=new HobbyClienteParameterReturnGeneral();
	
			HobbyClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,hobbyclientes,hobbyclienteParameterGeneral,hobbyclienteReturnGeneral);
			
			return hobbyclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public HobbyClienteParameterReturnGeneral procesarAccionHobbyClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<HobbyCliente> hobbyclientes,HobbyClienteParameterReturnGeneral hobbyclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HobbyCliente.class.getSimpleName()+"-procesarAccionHobbyClientesWithConnection");connexion.begin();			
			
			HobbyClienteParameterReturnGeneral hobbyclienteReturnGeneral=new HobbyClienteParameterReturnGeneral();
	
			HobbyClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,hobbyclientes,hobbyclienteParameterGeneral,hobbyclienteReturnGeneral);
			
			this.connexion.commit();
			
			return hobbyclienteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public HobbyClienteParameterReturnGeneral procesarEventosHobbyClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<HobbyCliente> hobbyclientes,HobbyCliente hobbycliente,HobbyClienteParameterReturnGeneral hobbyclienteParameterGeneral,Boolean isEsNuevoHobbyCliente,ArrayList<Classe> clases)throws Exception {
		 try {	
			HobbyClienteParameterReturnGeneral hobbyclienteReturnGeneral=new HobbyClienteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				hobbyclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			HobbyClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,hobbyclientes,hobbycliente,hobbyclienteParameterGeneral,hobbyclienteReturnGeneral,isEsNuevoHobbyCliente,clases);
			
			return hobbyclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public HobbyClienteParameterReturnGeneral procesarEventosHobbyClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<HobbyCliente> hobbyclientes,HobbyCliente hobbycliente,HobbyClienteParameterReturnGeneral hobbyclienteParameterGeneral,Boolean isEsNuevoHobbyCliente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HobbyCliente.class.getSimpleName()+"-procesarEventosHobbyClientesWithConnection");connexion.begin();			
			
			HobbyClienteParameterReturnGeneral hobbyclienteReturnGeneral=new HobbyClienteParameterReturnGeneral();
	
			hobbyclienteReturnGeneral.setHobbyCliente(hobbycliente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				hobbyclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			HobbyClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,hobbyclientes,hobbycliente,hobbyclienteParameterGeneral,hobbyclienteReturnGeneral,isEsNuevoHobbyCliente,clases);
			
			this.connexion.commit();
			
			return hobbyclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public HobbyClienteParameterReturnGeneral procesarImportacionHobbyClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,HobbyClienteParameterReturnGeneral hobbyclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HobbyCliente.class.getSimpleName()+"-procesarImportacionHobbyClientesWithConnection");connexion.begin();			
			
			HobbyClienteParameterReturnGeneral hobbyclienteReturnGeneral=new HobbyClienteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.hobbyclientes=new ArrayList<HobbyCliente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.hobbycliente=new HobbyCliente();
				
				
				if(conColumnasBase) {this.hobbycliente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.hobbycliente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.hobbycliente.setdescripcion(arrColumnas[iColumn++]);
				
				this.hobbyclientes.add(this.hobbycliente);
			}
			
			this.saveHobbyClientes();
			
			this.connexion.commit();
			
			hobbyclienteReturnGeneral.setConRetornoEstaProcesado(true);
			hobbyclienteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return hobbyclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarHobbyClientesEliminados() throws Exception {				
		
		List<HobbyCliente> hobbyclientesAux= new ArrayList<HobbyCliente>();
		
		for(HobbyCliente hobbycliente:hobbyclientes) {
			if(!hobbycliente.getIsDeleted()) {
				hobbyclientesAux.add(hobbycliente);
			}
		}
		
		hobbyclientes=hobbyclientesAux;
	}
	
	public void quitarHobbyClientesNulos() throws Exception {				
		
		List<HobbyCliente> hobbyclientesAux= new ArrayList<HobbyCliente>();
		
		for(HobbyCliente hobbycliente : this.hobbyclientes) {
			if(hobbycliente==null) {
				hobbyclientesAux.add(hobbycliente);
			}
		}
		
		//this.hobbyclientes=hobbyclientesAux;
		
		this.hobbyclientes.removeAll(hobbyclientesAux);
	}
	
	public void getSetVersionRowHobbyClienteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(hobbycliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((hobbycliente.getIsDeleted() || (hobbycliente.getIsChanged()&&!hobbycliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=hobbyclienteDataAccess.getSetVersionRowHobbyCliente(connexion,hobbycliente.getId());
				
				if(!hobbycliente.getVersionRow().equals(timestamp)) {	
					hobbycliente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				hobbycliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowHobbyCliente()throws Exception {	
		
		if(hobbycliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((hobbycliente.getIsDeleted() || (hobbycliente.getIsChanged()&&!hobbycliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=hobbyclienteDataAccess.getSetVersionRowHobbyCliente(connexion,hobbycliente.getId());
			
			try {							
				if(!hobbycliente.getVersionRow().equals(timestamp)) {	
					hobbycliente.setVersionRow(timestamp);
				}
				
				hobbycliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowHobbyClientesWithConnection()throws Exception {	
		if(hobbyclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(HobbyCliente hobbyclienteAux:hobbyclientes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(hobbyclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(hobbyclienteAux.getIsDeleted() || (hobbyclienteAux.getIsChanged()&&!hobbyclienteAux.getIsNew())) {
						
						timestamp=hobbyclienteDataAccess.getSetVersionRowHobbyCliente(connexion,hobbyclienteAux.getId());
						
						if(!hobbycliente.getVersionRow().equals(timestamp)) {	
							hobbyclienteAux.setVersionRow(timestamp);
						}
								
						hobbyclienteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowHobbyClientes()throws Exception {	
		if(hobbyclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(HobbyCliente hobbyclienteAux:hobbyclientes) {
					if(hobbyclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(hobbyclienteAux.getIsDeleted() || (hobbyclienteAux.getIsChanged()&&!hobbyclienteAux.getIsNew())) {
						
						timestamp=hobbyclienteDataAccess.getSetVersionRowHobbyCliente(connexion,hobbyclienteAux.getId());
						
						if(!hobbyclienteAux.getVersionRow().equals(timestamp)) {	
							hobbyclienteAux.setVersionRow(timestamp);
						}
						
													
						hobbyclienteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public HobbyClienteParameterReturnGeneral cargarCombosLoteForeignKeyHobbyClienteWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalHobby) throws Exception {
		HobbyClienteParameterReturnGeneral  hobbyclienteReturnGeneral =new HobbyClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HobbyCliente.class.getSimpleName()+"-cargarCombosLoteForeignKeyHobbyClienteWithConnection");connexion.begin();
			
			hobbyclienteReturnGeneral =new HobbyClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			hobbyclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			hobbyclienteReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Hobby> hobbysForeignKey=new ArrayList<Hobby>();
			HobbyLogic hobbyLogic=new HobbyLogic();
			hobbyLogic.setConnexion(this.connexion);
			hobbyLogic.getHobbyDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalHobby.equals("NONE")) {
				hobbyLogic.getTodosHobbys(finalQueryGlobalHobby,new Pagination());
				hobbysForeignKey=hobbyLogic.getHobbys();
			}

			hobbyclienteReturnGeneral.sethobbysForeignKey(hobbysForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return hobbyclienteReturnGeneral;
	}
	
	public HobbyClienteParameterReturnGeneral cargarCombosLoteForeignKeyHobbyCliente(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalHobby) throws Exception {
		HobbyClienteParameterReturnGeneral  hobbyclienteReturnGeneral =new HobbyClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			hobbyclienteReturnGeneral =new HobbyClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			hobbyclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			hobbyclienteReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Hobby> hobbysForeignKey=new ArrayList<Hobby>();
			HobbyLogic hobbyLogic=new HobbyLogic();
			hobbyLogic.setConnexion(this.connexion);
			hobbyLogic.getHobbyDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalHobby.equals("NONE")) {
				hobbyLogic.getTodosHobbys(finalQueryGlobalHobby,new Pagination());
				hobbysForeignKey=hobbyLogic.getHobbys();
			}

			hobbyclienteReturnGeneral.sethobbysForeignKey(hobbysForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return hobbyclienteReturnGeneral;
	}
	
	
	public void deepLoad(HobbyCliente hobbycliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			HobbyClienteLogicAdditional.updateHobbyClienteToGet(hobbycliente,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		hobbycliente.setEmpresa(hobbyclienteDataAccess.getEmpresa(connexion,hobbycliente));
		hobbycliente.setCliente(hobbyclienteDataAccess.getCliente(connexion,hobbycliente));
		hobbycliente.setHobby(hobbyclienteDataAccess.getHobby(connexion,hobbycliente));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				hobbycliente.setEmpresa(hobbyclienteDataAccess.getEmpresa(connexion,hobbycliente));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				hobbycliente.setCliente(hobbyclienteDataAccess.getCliente(connexion,hobbycliente));
				continue;
			}

			if(clas.clas.equals(Hobby.class)) {
				hobbycliente.setHobby(hobbyclienteDataAccess.getHobby(connexion,hobbycliente));
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
			hobbycliente.setEmpresa(hobbyclienteDataAccess.getEmpresa(connexion,hobbycliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			hobbycliente.setCliente(hobbyclienteDataAccess.getCliente(connexion,hobbycliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Hobby.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			hobbycliente.setHobby(hobbyclienteDataAccess.getHobby(connexion,hobbycliente));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		hobbycliente.setEmpresa(hobbyclienteDataAccess.getEmpresa(connexion,hobbycliente));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(hobbycliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		hobbycliente.setCliente(hobbyclienteDataAccess.getCliente(connexion,hobbycliente));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(hobbycliente.getCliente(),isDeep,deepLoadType,clases);
				
		hobbycliente.setHobby(hobbyclienteDataAccess.getHobby(connexion,hobbycliente));
		HobbyLogic hobbyLogic= new HobbyLogic(connexion);
		hobbyLogic.deepLoad(hobbycliente.getHobby(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				hobbycliente.setEmpresa(hobbyclienteDataAccess.getEmpresa(connexion,hobbycliente));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(hobbycliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				hobbycliente.setCliente(hobbyclienteDataAccess.getCliente(connexion,hobbycliente));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(hobbycliente.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Hobby.class)) {
				hobbycliente.setHobby(hobbyclienteDataAccess.getHobby(connexion,hobbycliente));
				HobbyLogic hobbyLogic= new HobbyLogic(connexion);
				hobbyLogic.deepLoad(hobbycliente.getHobby(),isDeep,deepLoadType,clases);				
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
			hobbycliente.setEmpresa(hobbyclienteDataAccess.getEmpresa(connexion,hobbycliente));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(hobbycliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			hobbycliente.setCliente(hobbyclienteDataAccess.getCliente(connexion,hobbycliente));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(hobbycliente.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Hobby.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			hobbycliente.setHobby(hobbyclienteDataAccess.getHobby(connexion,hobbycliente));
			HobbyLogic hobbyLogic= new HobbyLogic(connexion);
			hobbyLogic.deepLoad(hobbycliente.getHobby(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(HobbyCliente hobbycliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			HobbyClienteLogicAdditional.updateHobbyClienteToSave(hobbycliente,this.arrDatoGeneral);
			
HobbyClienteDataAccess.save(hobbycliente, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(hobbycliente.getEmpresa(),connexion);

		ClienteDataAccess.save(hobbycliente.getCliente(),connexion);

		HobbyDataAccess.save(hobbycliente.getHobby(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(hobbycliente.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(hobbycliente.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Hobby.class)) {
				HobbyDataAccess.save(hobbycliente.getHobby(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(hobbycliente.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(hobbycliente.getEmpresa(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(hobbycliente.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(hobbycliente.getCliente(),isDeep,deepLoadType,clases);
				

		HobbyDataAccess.save(hobbycliente.getHobby(),connexion);
		HobbyLogic hobbyLogic= new HobbyLogic(connexion);
		hobbyLogic.deepLoad(hobbycliente.getHobby(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(hobbycliente.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(hobbycliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(hobbycliente.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(hobbycliente.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Hobby.class)) {
				HobbyDataAccess.save(hobbycliente.getHobby(),connexion);
				HobbyLogic hobbyLogic= new HobbyLogic(connexion);
				hobbyLogic.deepSave(hobbycliente.getHobby(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(HobbyCliente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(hobbycliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(hobbycliente);
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
			this.deepLoad(this.hobbycliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbycliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(HobbyCliente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(hobbyclientes!=null) {
				for(HobbyCliente hobbycliente:hobbyclientes) {
					this.deepLoad(hobbycliente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(hobbyclientes);
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
			if(hobbyclientes!=null) {
				for(HobbyCliente hobbycliente:hobbyclientes) {
					this.deepLoad(hobbycliente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(hobbyclientes);
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
			this.getNewConnexionToDeep(HobbyCliente.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(hobbycliente,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(HobbyCliente.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(hobbyclientes!=null) {
				for(HobbyCliente hobbycliente:hobbyclientes) {
					this.deepSave(hobbycliente,isDeep,deepLoadType,clases);
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
			if(hobbyclientes!=null) {
				for(HobbyCliente hobbycliente:hobbyclientes) {
					this.deepSave(hobbycliente,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getHobbyClientesFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HobbyCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,HobbyClienteConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			HobbyClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			hobbyclientes=hobbyclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbyclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHobbyClientesFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,HobbyClienteConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			HobbyClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			hobbyclientes=hobbyclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbyclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHobbyClientesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HobbyCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,HobbyClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			HobbyClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			hobbyclientes=hobbyclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbyclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHobbyClientesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,HobbyClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			HobbyClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			hobbyclientes=hobbyclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbyclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getHobbyClientesFK_IdHobbyWithConnection(String sFinalQuery,Pagination pagination,Long id_hobby)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,HobbyCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidHobby= new ParameterSelectionGeneral();
			parameterSelectionGeneralidHobby.setParameterSelectionGeneralEqual(ParameterType.LONG,id_hobby,HobbyClienteConstantesFunciones.IDHOBBY,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidHobby);

			HobbyClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdHobby","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			hobbyclientes=hobbyclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbyclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHobbyClientesFK_IdHobby(String sFinalQuery,Pagination pagination,Long id_hobby)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidHobby= new ParameterSelectionGeneral();
			parameterSelectionGeneralidHobby.setParameterSelectionGeneralEqual(ParameterType.LONG,id_hobby,HobbyClienteConstantesFunciones.IDHOBBY,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidHobby);

			HobbyClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdHobby","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			hobbyclientes=hobbyclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(this.hobbyclientes);
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
			if(HobbyClienteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,HobbyClienteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,HobbyCliente hobbycliente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(HobbyClienteConstantesFunciones.ISCONAUDITORIA) {
				if(hobbycliente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HobbyClienteDataAccess.TABLENAME, hobbycliente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(HobbyClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////HobbyClienteLogic.registrarAuditoriaDetallesHobbyCliente(connexion,hobbycliente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(hobbycliente.getIsDeleted()) {
					/*if(!hobbycliente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,HobbyClienteDataAccess.TABLENAME, hobbycliente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////HobbyClienteLogic.registrarAuditoriaDetallesHobbyCliente(connexion,hobbycliente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HobbyClienteDataAccess.TABLENAME, hobbycliente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(hobbycliente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HobbyClienteDataAccess.TABLENAME, hobbycliente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(HobbyClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////HobbyClienteLogic.registrarAuditoriaDetallesHobbyCliente(connexion,hobbycliente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesHobbyCliente(Connexion connexion,HobbyCliente hobbycliente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(hobbycliente.getIsNew()||!hobbycliente.getid_empresa().equals(hobbycliente.getHobbyClienteOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(hobbycliente.getHobbyClienteOriginal().getid_empresa()!=null)
				{
					strValorActual=hobbycliente.getHobbyClienteOriginal().getid_empresa().toString();
				}
				if(hobbycliente.getid_empresa()!=null)
				{
					strValorNuevo=hobbycliente.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HobbyClienteConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(hobbycliente.getIsNew()||!hobbycliente.getid_cliente().equals(hobbycliente.getHobbyClienteOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(hobbycliente.getHobbyClienteOriginal().getid_cliente()!=null)
				{
					strValorActual=hobbycliente.getHobbyClienteOriginal().getid_cliente().toString();
				}
				if(hobbycliente.getid_cliente()!=null)
				{
					strValorNuevo=hobbycliente.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HobbyClienteConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(hobbycliente.getIsNew()||!hobbycliente.getid_hobby().equals(hobbycliente.getHobbyClienteOriginal().getid_hobby()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(hobbycliente.getHobbyClienteOriginal().getid_hobby()!=null)
				{
					strValorActual=hobbycliente.getHobbyClienteOriginal().getid_hobby().toString();
				}
				if(hobbycliente.getid_hobby()!=null)
				{
					strValorNuevo=hobbycliente.getid_hobby().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HobbyClienteConstantesFunciones.IDHOBBY,strValorActual,strValorNuevo);
			}	
			
			if(hobbycliente.getIsNew()||!hobbycliente.getdescripcion().equals(hobbycliente.getHobbyClienteOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(hobbycliente.getHobbyClienteOriginal().getdescripcion()!=null)
				{
					strValorActual=hobbycliente.getHobbyClienteOriginal().getdescripcion();
				}
				if(hobbycliente.getdescripcion()!=null)
				{
					strValorNuevo=hobbycliente.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HobbyClienteConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveHobbyClienteRelacionesWithConnection(HobbyCliente hobbycliente) throws Exception {

		if(!hobbycliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveHobbyClienteRelacionesBase(hobbycliente,true);
		}
	}

	public void saveHobbyClienteRelaciones(HobbyCliente hobbycliente)throws Exception {

		if(!hobbycliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveHobbyClienteRelacionesBase(hobbycliente,false);
		}
	}

	public void saveHobbyClienteRelacionesBase(HobbyCliente hobbycliente,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("HobbyCliente-saveRelacionesWithConnection");}
	

			this.setHobbyCliente(hobbycliente);

			if(HobbyClienteLogicAdditional.validarSaveRelaciones(hobbycliente,this)) {

				HobbyClienteLogicAdditional.updateRelacionesToSave(hobbycliente,this);

				if((hobbycliente.getIsNew()||hobbycliente.getIsChanged())&&!hobbycliente.getIsDeleted()) {
					this.saveHobbyCliente();
					this.saveHobbyClienteRelacionesDetalles();

				} else if(hobbycliente.getIsDeleted()) {
					this.saveHobbyClienteRelacionesDetalles();
					this.saveHobbyCliente();
				}

				HobbyClienteLogicAdditional.updateRelacionesToSaveAfter(hobbycliente,this);

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
	
	
	private void saveHobbyClienteRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfHobbyCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=HobbyClienteConstantesFunciones.getClassesForeignKeysOfHobbyCliente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfHobbyCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=HobbyClienteConstantesFunciones.getClassesRelationshipsOfHobbyCliente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

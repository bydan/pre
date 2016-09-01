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
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.util.EmpaqueConstantesFunciones;
import com.bydan.erp.inventario.util.EmpaqueParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EmpaqueParameterGeneral;
import com.bydan.erp.inventario.business.entity.Empaque;
import com.bydan.erp.inventario.business.logic.EmpaqueLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class EmpaqueLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EmpaqueLogic.class);
	
	protected EmpaqueDataAccess empaqueDataAccess; 	
	protected Empaque empaque;
	protected List<Empaque> empaques;
	protected Object empaqueObject;	
	protected List<Object> empaquesObject;
	
	public static ClassValidator<Empaque> empaqueValidator = new ClassValidator<Empaque>(Empaque.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EmpaqueLogicAdditional empaqueLogicAdditional=null;
	
	public EmpaqueLogicAdditional getEmpaqueLogicAdditional() {
		return this.empaqueLogicAdditional;
	}
	
	public void setEmpaqueLogicAdditional(EmpaqueLogicAdditional empaqueLogicAdditional) {
		try {
			this.empaqueLogicAdditional=empaqueLogicAdditional;
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
	
	
	
	
	public  EmpaqueLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.empaqueDataAccess = new EmpaqueDataAccess();
			
			this.empaques= new ArrayList<Empaque>();
			this.empaque= new Empaque();
			
			this.empaqueObject=new Object();
			this.empaquesObject=new ArrayList<Object>();
				
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
			
			this.empaqueDataAccess.setConnexionType(this.connexionType);
			this.empaqueDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EmpaqueLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.empaqueDataAccess = new EmpaqueDataAccess();
			this.empaques= new ArrayList<Empaque>();
			this.empaque= new Empaque();
			this.empaqueObject=new Object();
			this.empaquesObject=new ArrayList<Object>();
			
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
			
			this.empaqueDataAccess.setConnexionType(this.connexionType);
			this.empaqueDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Empaque getEmpaque() throws Exception {	
		EmpaqueLogicAdditional.checkEmpaqueToGet(empaque,this.datosCliente,this.arrDatoGeneral);
		EmpaqueLogicAdditional.updateEmpaqueToGet(empaque,this.arrDatoGeneral);
		
		return empaque;
	}
		
	public void setEmpaque(Empaque newEmpaque) {
		this.empaque = newEmpaque;
	}
	
	public EmpaqueDataAccess getEmpaqueDataAccess() {
		return empaqueDataAccess;
	}
	
	public void setEmpaqueDataAccess(EmpaqueDataAccess newempaqueDataAccess) {
		this.empaqueDataAccess = newempaqueDataAccess;
	}
	
	public List<Empaque> getEmpaques() throws Exception {		
		this.quitarEmpaquesNulos();
		
		EmpaqueLogicAdditional.checkEmpaqueToGets(empaques,this.datosCliente,this.arrDatoGeneral);
		
		for (Empaque empaqueLocal: empaques ) {
			EmpaqueLogicAdditional.updateEmpaqueToGet(empaqueLocal,this.arrDatoGeneral);
		}
		
		return empaques;
	}
	
	public void setEmpaques(List<Empaque> newEmpaques) {
		this.empaques = newEmpaques;
	}
	
	public Object getEmpaqueObject() {	
		this.empaqueObject=this.empaqueDataAccess.getEntityObject();
		return this.empaqueObject;
	}
		
	public void setEmpaqueObject(Object newEmpaqueObject) {
		this.empaqueObject = newEmpaqueObject;
	}
	
	public List<Object> getEmpaquesObject() {		
		this.empaquesObject=this.empaqueDataAccess.getEntitiesObject();
		return this.empaquesObject;
	}
		
	public void setEmpaquesObject(List<Object> newEmpaquesObject) {
		this.empaquesObject = newEmpaquesObject;
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
		
		if(this.empaqueDataAccess!=null) {
			this.empaqueDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empaque.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			empaqueDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			empaqueDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		empaque = new  Empaque();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empaque.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empaque=empaqueDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empaque,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpaqueConstantesFunciones.refrescarForeignKeysDescripcionesEmpaque(this.empaque);
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
		empaque = new  Empaque();
		  		  
        try {
			
			empaque=empaqueDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empaque,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpaqueConstantesFunciones.refrescarForeignKeysDescripcionesEmpaque(this.empaque);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		empaque = new  Empaque();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empaque.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			empaque=empaqueDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empaque,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpaqueConstantesFunciones.refrescarForeignKeysDescripcionesEmpaque(this.empaque);
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
		empaque = new  Empaque();
		  		  
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
		empaque = new  Empaque();
		  		  
        try {
			
			empaque=empaqueDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.empaque,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EmpaqueConstantesFunciones.refrescarForeignKeysDescripcionesEmpaque(this.empaque);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		empaque = new  Empaque();
		  		  
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
		empaque = new  Empaque();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empaque.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =empaqueDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empaque = new  Empaque();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=empaqueDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empaque = new  Empaque();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empaque.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =empaqueDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empaque = new  Empaque();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=empaqueDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		empaque = new  Empaque();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empaque.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =empaqueDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		empaque = new  Empaque();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=empaqueDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empaques = new  ArrayList<Empaque>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empaque.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EmpaqueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empaques=empaqueDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpaque(empaques);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpaqueConstantesFunciones.refrescarForeignKeysDescripcionesEmpaque(this.empaques);
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
		empaques = new  ArrayList<Empaque>();
		  		  
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
		empaques = new  ArrayList<Empaque>();
		  		  
        try {			
			EmpaqueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empaques=empaqueDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEmpaque(empaques);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpaqueConstantesFunciones.refrescarForeignKeysDescripcionesEmpaque(this.empaques);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		empaques = new  ArrayList<Empaque>();
		  		  
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
		empaques = new  ArrayList<Empaque>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empaque.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EmpaqueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empaques=empaqueDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpaque(empaques);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpaqueConstantesFunciones.refrescarForeignKeysDescripcionesEmpaque(this.empaques);
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
		empaques = new  ArrayList<Empaque>();
		  		  
        try {
			EmpaqueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empaques=empaqueDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpaque(empaques);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpaqueConstantesFunciones.refrescarForeignKeysDescripcionesEmpaque(this.empaques);
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
		empaques = new  ArrayList<Empaque>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empaque.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpaqueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empaques=empaqueDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpaque(empaques);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpaqueConstantesFunciones.refrescarForeignKeysDescripcionesEmpaque(this.empaques);
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
		empaques = new  ArrayList<Empaque>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpaqueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empaques=empaqueDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpaque(empaques);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpaqueConstantesFunciones.refrescarForeignKeysDescripcionesEmpaque(this.empaques);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		empaque = new  Empaque();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empaque.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpaqueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empaque=empaqueDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpaque(empaque);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpaqueConstantesFunciones.refrescarForeignKeysDescripcionesEmpaque(this.empaque);
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
		empaque = new  Empaque();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpaqueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empaque=empaqueDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEmpaque(empaque);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpaqueConstantesFunciones.refrescarForeignKeysDescripcionesEmpaque(this.empaque);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		empaques = new  ArrayList<Empaque>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empaque.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EmpaqueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empaques=empaqueDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpaque(empaques);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpaqueConstantesFunciones.refrescarForeignKeysDescripcionesEmpaque(this.empaques);
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
		empaques = new  ArrayList<Empaque>();
		  		  
        try {
			EmpaqueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empaques=empaqueDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEmpaque(empaques);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpaqueConstantesFunciones.refrescarForeignKeysDescripcionesEmpaque(this.empaques);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEmpaquesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		empaques = new  ArrayList<Empaque>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empaque.class.getSimpleName()+"-getTodosEmpaquesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpaqueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empaques=empaqueDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpaque(empaques);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpaqueConstantesFunciones.refrescarForeignKeysDescripcionesEmpaque(this.empaques);
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
	
	public  void  getTodosEmpaques(String sFinalQuery,Pagination pagination)throws Exception {
		empaques = new  ArrayList<Empaque>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EmpaqueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			empaques=empaqueDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEmpaque(empaques);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EmpaqueConstantesFunciones.refrescarForeignKeysDescripcionesEmpaque(this.empaques);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEmpaque(Empaque empaque) throws Exception {
		Boolean estaValidado=false;
		
		if(empaque.getIsNew() || empaque.getIsChanged()) { 
			this.invalidValues = empaqueValidator.getInvalidValues(empaque);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(empaque);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEmpaque(List<Empaque> Empaques) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Empaque empaqueLocal:empaques) {				
			estaValidadoObjeto=this.validarGuardarEmpaque(empaqueLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEmpaque(List<Empaque> Empaques) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpaque(empaques)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEmpaque(Empaque Empaque) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEmpaque(empaque)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Empaque empaque) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+empaque.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EmpaqueConstantesFunciones.getEmpaqueLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"empaque","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EmpaqueConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EmpaqueConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEmpaqueWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empaque.class.getSimpleName()+"-saveEmpaqueWithConnection");connexion.begin();			
			
			EmpaqueLogicAdditional.checkEmpaqueToSave(this.empaque,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpaqueLogicAdditional.updateEmpaqueToSave(this.empaque,this.arrDatoGeneral);
			
			EmpaqueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empaque,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEmpaque();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpaque(this.empaque)) {
				EmpaqueDataAccess.save(this.empaque, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.empaque,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpaqueLogicAdditional.checkEmpaqueToSaveAfter(this.empaque,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpaque();
			
			connexion.commit();			
			
			if(this.empaque.getIsDeleted()) {
				this.empaque=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEmpaque()throws Exception {	
		try {	
			
			EmpaqueLogicAdditional.checkEmpaqueToSave(this.empaque,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EmpaqueLogicAdditional.updateEmpaqueToSave(this.empaque,this.arrDatoGeneral);
			
			EmpaqueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.empaque,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEmpaque(this.empaque)) {			
				EmpaqueDataAccess.save(this.empaque, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.empaque,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EmpaqueLogicAdditional.checkEmpaqueToSaveAfter(this.empaque,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.empaque.getIsDeleted()) {
				this.empaque=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEmpaquesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empaque.class.getSimpleName()+"-saveEmpaquesWithConnection");connexion.begin();			
			
			EmpaqueLogicAdditional.checkEmpaqueToSaves(empaques,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEmpaques();
			
			Boolean validadoTodosEmpaque=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Empaque empaqueLocal:empaques) {		
				if(empaqueLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpaqueLogicAdditional.updateEmpaqueToSave(empaqueLocal,this.arrDatoGeneral);
	        	
				EmpaqueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empaqueLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpaque(empaqueLocal)) {
					EmpaqueDataAccess.save(empaqueLocal, connexion);				
				} else {
					validadoTodosEmpaque=false;
				}
			}
			
			if(!validadoTodosEmpaque) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpaqueLogicAdditional.checkEmpaqueToSavesAfter(empaques,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEmpaques();
			
			connexion.commit();		
			
			this.quitarEmpaquesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEmpaques()throws Exception {				
		 try {	
			EmpaqueLogicAdditional.checkEmpaqueToSaves(empaques,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEmpaque=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Empaque empaqueLocal:empaques) {				
				if(empaqueLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EmpaqueLogicAdditional.updateEmpaqueToSave(empaqueLocal,this.arrDatoGeneral);
	        	
				EmpaqueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),empaqueLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEmpaque(empaqueLocal)) {				
					EmpaqueDataAccess.save(empaqueLocal, connexion);				
				} else {
					validadoTodosEmpaque=false;
				}
			}
			
			if(!validadoTodosEmpaque) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EmpaqueLogicAdditional.checkEmpaqueToSavesAfter(empaques,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEmpaquesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpaqueParameterReturnGeneral procesarAccionEmpaques(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Empaque> empaques,EmpaqueParameterReturnGeneral empaqueParameterGeneral)throws Exception {
		 try {	
			EmpaqueParameterReturnGeneral empaqueReturnGeneral=new EmpaqueParameterReturnGeneral();
	
			EmpaqueLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empaques,empaqueParameterGeneral,empaqueReturnGeneral);
			
			return empaqueReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EmpaqueParameterReturnGeneral procesarAccionEmpaquesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Empaque> empaques,EmpaqueParameterReturnGeneral empaqueParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empaque.class.getSimpleName()+"-procesarAccionEmpaquesWithConnection");connexion.begin();			
			
			EmpaqueParameterReturnGeneral empaqueReturnGeneral=new EmpaqueParameterReturnGeneral();
	
			EmpaqueLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,empaques,empaqueParameterGeneral,empaqueReturnGeneral);
			
			this.connexion.commit();
			
			return empaqueReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpaqueParameterReturnGeneral procesarEventosEmpaques(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Empaque> empaques,Empaque empaque,EmpaqueParameterReturnGeneral empaqueParameterGeneral,Boolean isEsNuevoEmpaque,ArrayList<Classe> clases)throws Exception {
		 try {	
			EmpaqueParameterReturnGeneral empaqueReturnGeneral=new EmpaqueParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empaqueReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpaqueLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empaques,empaque,empaqueParameterGeneral,empaqueReturnGeneral,isEsNuevoEmpaque,clases);
			
			return empaqueReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EmpaqueParameterReturnGeneral procesarEventosEmpaquesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Empaque> empaques,Empaque empaque,EmpaqueParameterReturnGeneral empaqueParameterGeneral,Boolean isEsNuevoEmpaque,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empaque.class.getSimpleName()+"-procesarEventosEmpaquesWithConnection");connexion.begin();			
			
			EmpaqueParameterReturnGeneral empaqueReturnGeneral=new EmpaqueParameterReturnGeneral();
	
			empaqueReturnGeneral.setEmpaque(empaque);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				empaqueReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EmpaqueLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,empaques,empaque,empaqueParameterGeneral,empaqueReturnGeneral,isEsNuevoEmpaque,clases);
			
			this.connexion.commit();
			
			return empaqueReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EmpaqueParameterReturnGeneral procesarImportacionEmpaquesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EmpaqueParameterReturnGeneral empaqueParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empaque.class.getSimpleName()+"-procesarImportacionEmpaquesWithConnection");connexion.begin();			
			
			EmpaqueParameterReturnGeneral empaqueReturnGeneral=new EmpaqueParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.empaques=new ArrayList<Empaque>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.empaque=new Empaque();
				
				
				if(conColumnasBase) {this.empaque.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.empaque.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.empaque.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.empaque.setdescripcion(arrColumnas[iColumn++]);
				
				this.empaques.add(this.empaque);
			}
			
			this.saveEmpaques();
			
			this.connexion.commit();
			
			empaqueReturnGeneral.setConRetornoEstaProcesado(true);
			empaqueReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return empaqueReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEmpaquesEliminados() throws Exception {				
		
		List<Empaque> empaquesAux= new ArrayList<Empaque>();
		
		for(Empaque empaque:empaques) {
			if(!empaque.getIsDeleted()) {
				empaquesAux.add(empaque);
			}
		}
		
		empaques=empaquesAux;
	}
	
	public void quitarEmpaquesNulos() throws Exception {				
		
		List<Empaque> empaquesAux= new ArrayList<Empaque>();
		
		for(Empaque empaque : this.empaques) {
			if(empaque==null) {
				empaquesAux.add(empaque);
			}
		}
		
		//this.empaques=empaquesAux;
		
		this.empaques.removeAll(empaquesAux);
	}
	
	public void getSetVersionRowEmpaqueWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(empaque.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((empaque.getIsDeleted() || (empaque.getIsChanged()&&!empaque.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=empaqueDataAccess.getSetVersionRowEmpaque(connexion,empaque.getId());
				
				if(!empaque.getVersionRow().equals(timestamp)) {	
					empaque.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				empaque.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEmpaque()throws Exception {	
		
		if(empaque.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((empaque.getIsDeleted() || (empaque.getIsChanged()&&!empaque.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=empaqueDataAccess.getSetVersionRowEmpaque(connexion,empaque.getId());
			
			try {							
				if(!empaque.getVersionRow().equals(timestamp)) {	
					empaque.setVersionRow(timestamp);
				}
				
				empaque.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEmpaquesWithConnection()throws Exception {	
		if(empaques!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Empaque empaqueAux:empaques) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(empaqueAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empaqueAux.getIsDeleted() || (empaqueAux.getIsChanged()&&!empaqueAux.getIsNew())) {
						
						timestamp=empaqueDataAccess.getSetVersionRowEmpaque(connexion,empaqueAux.getId());
						
						if(!empaque.getVersionRow().equals(timestamp)) {	
							empaqueAux.setVersionRow(timestamp);
						}
								
						empaqueAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEmpaques()throws Exception {	
		if(empaques!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Empaque empaqueAux:empaques) {
					if(empaqueAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(empaqueAux.getIsDeleted() || (empaqueAux.getIsChanged()&&!empaqueAux.getIsNew())) {
						
						timestamp=empaqueDataAccess.getSetVersionRowEmpaque(connexion,empaqueAux.getId());
						
						if(!empaqueAux.getVersionRow().equals(timestamp)) {	
							empaqueAux.setVersionRow(timestamp);
						}
						
													
						empaqueAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public EmpaqueParameterReturnGeneral cargarCombosLoteForeignKeyEmpaqueWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		EmpaqueParameterReturnGeneral  empaqueReturnGeneral =new EmpaqueParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empaque.class.getSimpleName()+"-cargarCombosLoteForeignKeyEmpaqueWithConnection");connexion.begin();
			
			empaqueReturnGeneral =new EmpaqueParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empaqueReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return empaqueReturnGeneral;
	}
	
	public EmpaqueParameterReturnGeneral cargarCombosLoteForeignKeyEmpaque(String finalQueryGlobalEmpresa) throws Exception {
		EmpaqueParameterReturnGeneral  empaqueReturnGeneral =new EmpaqueParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			empaqueReturnGeneral =new EmpaqueParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			empaqueReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return empaqueReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyEmpaqueWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleProformaLogic detalleproformaLogic=new DetalleProformaLogic();
			DetaNotaCreditoSoliLogic detanotacreditosoliLogic=new DetaNotaCreditoSoliLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empaque.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEmpaqueWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleProforma.class));
			classes.add(new Classe(DetaNotaCreditoSoli.class));
											
			

			detalleproformaLogic.setConnexion(this.getConnexion());
			detalleproformaLogic.setDatosCliente(this.datosCliente);
			detalleproformaLogic.setIsConRefrescarForeignKeys(true);

			detanotacreditosoliLogic.setConnexion(this.getConnexion());
			detanotacreditosoliLogic.setDatosCliente(this.datosCliente);
			detanotacreditosoliLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Empaque empaque:this.empaques) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleProformaConstantesFunciones.getClassesForeignKeysOfDetalleProforma(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleproformaLogic.setDetalleProformas(empaque.detalleproformas);
				detalleproformaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetaNotaCreditoSoliConstantesFunciones.getClassesForeignKeysOfDetaNotaCreditoSoli(new ArrayList<Classe>(),DeepLoadType.NONE);

				detanotacreditosoliLogic.setDetaNotaCreditoSolis(empaque.detanotacreditosolis);
				detanotacreditosoliLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Empaque empaque,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EmpaqueLogicAdditional.updateEmpaqueToGet(empaque,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empaque.setEmpresa(empaqueDataAccess.getEmpresa(connexion,empaque));
		empaque.setDetaNotaCreditoSolis(empaqueDataAccess.getDetaNotaCreditoSolis(connexion,empaque));
		empaque.setDetalleProformas(empaqueDataAccess.getDetalleProformas(connexion,empaque));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empaque.setEmpresa(empaqueDataAccess.getEmpresa(connexion,empaque));
				continue;
			}

			if(clas.clas.equals(DetaNotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empaque.setDetaNotaCreditoSolis(empaqueDataAccess.getDetaNotaCreditoSolis(connexion,empaque));

				if(this.isConDeep) {
					DetaNotaCreditoSoliLogic detanotacreditosoliLogic= new DetaNotaCreditoSoliLogic(this.connexion);
					detanotacreditosoliLogic.setDetaNotaCreditoSolis(empaque.getDetaNotaCreditoSolis());
					ArrayList<Classe> classesLocal=DetaNotaCreditoSoliConstantesFunciones.getClassesForeignKeysOfDetaNotaCreditoSoli(new ArrayList<Classe>(),DeepLoadType.NONE);
					detanotacreditosoliLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetaNotaCreditoSoliConstantesFunciones.refrescarForeignKeysDescripcionesDetaNotaCreditoSoli(detanotacreditosoliLogic.getDetaNotaCreditoSolis());
					empaque.setDetaNotaCreditoSolis(detanotacreditosoliLogic.getDetaNotaCreditoSolis());
				}

				continue;
			}

			if(clas.clas.equals(DetalleProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empaque.setDetalleProformas(empaqueDataAccess.getDetalleProformas(connexion,empaque));

				if(this.isConDeep) {
					DetalleProformaLogic detalleproformaLogic= new DetalleProformaLogic(this.connexion);
					detalleproformaLogic.setDetalleProformas(empaque.getDetalleProformas());
					ArrayList<Classe> classesLocal=DetalleProformaConstantesFunciones.getClassesForeignKeysOfDetalleProforma(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleproformaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleProformaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProforma(detalleproformaLogic.getDetalleProformas());
					empaque.setDetalleProformas(detalleproformaLogic.getDetalleProformas());
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
			empaque.setEmpresa(empaqueDataAccess.getEmpresa(connexion,empaque));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetaNotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetaNotaCreditoSoli.class));
			empaque.setDetaNotaCreditoSolis(empaqueDataAccess.getDetaNotaCreditoSolis(connexion,empaque));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleProforma.class));
			empaque.setDetalleProformas(empaqueDataAccess.getDetalleProformas(connexion,empaque));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		empaque.setEmpresa(empaqueDataAccess.getEmpresa(connexion,empaque));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empaque.getEmpresa(),isDeep,deepLoadType,clases);
				

		empaque.setDetaNotaCreditoSolis(empaqueDataAccess.getDetaNotaCreditoSolis(connexion,empaque));

		for(DetaNotaCreditoSoli detanotacreditosoli:empaque.getDetaNotaCreditoSolis()) {
			DetaNotaCreditoSoliLogic detanotacreditosoliLogic= new DetaNotaCreditoSoliLogic(connexion);
			detanotacreditosoliLogic.deepLoad(detanotacreditosoli,isDeep,deepLoadType,clases);
		}

		empaque.setDetalleProformas(empaqueDataAccess.getDetalleProformas(connexion,empaque));

		for(DetalleProforma detalleproforma:empaque.getDetalleProformas()) {
			DetalleProformaLogic detalleproformaLogic= new DetalleProformaLogic(connexion);
			detalleproformaLogic.deepLoad(detalleproforma,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				empaque.setEmpresa(empaqueDataAccess.getEmpresa(connexion,empaque));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(empaque.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetaNotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empaque.setDetaNotaCreditoSolis(empaqueDataAccess.getDetaNotaCreditoSolis(connexion,empaque));

				for(DetaNotaCreditoSoli detanotacreditosoli:empaque.getDetaNotaCreditoSolis()) {
					DetaNotaCreditoSoliLogic detanotacreditosoliLogic= new DetaNotaCreditoSoliLogic(connexion);
					detanotacreditosoliLogic.deepLoad(detanotacreditosoli,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				empaque.setDetalleProformas(empaqueDataAccess.getDetalleProformas(connexion,empaque));

				for(DetalleProforma detalleproforma:empaque.getDetalleProformas()) {
					DetalleProformaLogic detalleproformaLogic= new DetalleProformaLogic(connexion);
					detalleproformaLogic.deepLoad(detalleproforma,isDeep,deepLoadType,clases);
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
			empaque.setEmpresa(empaqueDataAccess.getEmpresa(connexion,empaque));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(empaque.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetaNotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetaNotaCreditoSoli.class));
			empaque.setDetaNotaCreditoSolis(empaqueDataAccess.getDetaNotaCreditoSolis(connexion,empaque));

			for(DetaNotaCreditoSoli detanotacreditosoli:empaque.getDetaNotaCreditoSolis()) {
				DetaNotaCreditoSoliLogic detanotacreditosoliLogic= new DetaNotaCreditoSoliLogic(connexion);
				detanotacreditosoliLogic.deepLoad(detanotacreditosoli,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleProforma.class));
			empaque.setDetalleProformas(empaqueDataAccess.getDetalleProformas(connexion,empaque));

			for(DetalleProforma detalleproforma:empaque.getDetalleProformas()) {
				DetalleProformaLogic detalleproformaLogic= new DetalleProformaLogic(connexion);
				detalleproformaLogic.deepLoad(detalleproforma,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Empaque empaque,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EmpaqueLogicAdditional.updateEmpaqueToSave(empaque,this.arrDatoGeneral);
			
EmpaqueDataAccess.save(empaque, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empaque.getEmpresa(),connexion);

		for(DetaNotaCreditoSoli detanotacreditosoli:empaque.getDetaNotaCreditoSolis()) {
			detanotacreditosoli.setid_empaque(empaque.getId());
			DetaNotaCreditoSoliDataAccess.save(detanotacreditosoli,connexion);
		}

		for(DetalleProforma detalleproforma:empaque.getDetalleProformas()) {
			detalleproforma.setid_empaque(empaque.getId());
			DetalleProformaDataAccess.save(detalleproforma,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empaque.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(DetaNotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetaNotaCreditoSoli detanotacreditosoli:empaque.getDetaNotaCreditoSolis()) {
					detanotacreditosoli.setid_empaque(empaque.getId());
					DetaNotaCreditoSoliDataAccess.save(detanotacreditosoli,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetalleProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleProforma detalleproforma:empaque.getDetalleProformas()) {
					detalleproforma.setid_empaque(empaque.getId());
					DetalleProformaDataAccess.save(detalleproforma,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(empaque.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(empaque.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(DetaNotaCreditoSoli detanotacreditosoli:empaque.getDetaNotaCreditoSolis()) {
			DetaNotaCreditoSoliLogic detanotacreditosoliLogic= new DetaNotaCreditoSoliLogic(connexion);
			detanotacreditosoli.setid_empaque(empaque.getId());
			DetaNotaCreditoSoliDataAccess.save(detanotacreditosoli,connexion);
			detanotacreditosoliLogic.deepSave(detanotacreditosoli,isDeep,deepLoadType,clases);
		}

		for(DetalleProforma detalleproforma:empaque.getDetalleProformas()) {
			DetalleProformaLogic detalleproformaLogic= new DetalleProformaLogic(connexion);
			detalleproforma.setid_empaque(empaque.getId());
			DetalleProformaDataAccess.save(detalleproforma,connexion);
			detalleproformaLogic.deepSave(detalleproforma,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(empaque.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(empaque.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetaNotaCreditoSoli.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetaNotaCreditoSoli detanotacreditosoli:empaque.getDetaNotaCreditoSolis()) {
					DetaNotaCreditoSoliLogic detanotacreditosoliLogic= new DetaNotaCreditoSoliLogic(connexion);
					detanotacreditosoli.setid_empaque(empaque.getId());
					DetaNotaCreditoSoliDataAccess.save(detanotacreditosoli,connexion);
					detanotacreditosoliLogic.deepSave(detanotacreditosoli,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleProforma.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleProforma detalleproforma:empaque.getDetalleProformas()) {
					DetalleProformaLogic detalleproformaLogic= new DetalleProformaLogic(connexion);
					detalleproforma.setid_empaque(empaque.getId());
					DetalleProformaDataAccess.save(detalleproforma,connexion);
					detalleproformaLogic.deepSave(detalleproforma,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Empaque.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(empaque,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpaqueConstantesFunciones.refrescarForeignKeysDescripcionesEmpaque(empaque);
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
			this.deepLoad(this.empaque,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EmpaqueConstantesFunciones.refrescarForeignKeysDescripcionesEmpaque(this.empaque);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Empaque.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(empaques!=null) {
				for(Empaque empaque:empaques) {
					this.deepLoad(empaque,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EmpaqueConstantesFunciones.refrescarForeignKeysDescripcionesEmpaque(empaques);
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
			if(empaques!=null) {
				for(Empaque empaque:empaques) {
					this.deepLoad(empaque,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EmpaqueConstantesFunciones.refrescarForeignKeysDescripcionesEmpaque(empaques);
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
			this.getNewConnexionToDeep(Empaque.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(empaque,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Empaque.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(empaques!=null) {
				for(Empaque empaque:empaques) {
					this.deepSave(empaque,isDeep,deepLoadType,clases);
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
			if(empaques!=null) {
				for(Empaque empaque:empaques) {
					this.deepSave(empaque,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEmpaquesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Empaque.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpaqueConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpaqueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empaques=empaqueDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpaqueConstantesFunciones.refrescarForeignKeysDescripcionesEmpaque(this.empaques);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEmpaquesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,EmpaqueConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			EmpaqueLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			empaques=empaqueDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				EmpaqueConstantesFunciones.refrescarForeignKeysDescripcionesEmpaque(this.empaques);
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
			if(EmpaqueConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpaqueDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Empaque empaque,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EmpaqueConstantesFunciones.ISCONAUDITORIA) {
				if(empaque.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpaqueDataAccess.TABLENAME, empaque.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpaqueConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpaqueLogic.registrarAuditoriaDetallesEmpaque(connexion,empaque,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(empaque.getIsDeleted()) {
					/*if(!empaque.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EmpaqueDataAccess.TABLENAME, empaque.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EmpaqueLogic.registrarAuditoriaDetallesEmpaque(connexion,empaque,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpaqueDataAccess.TABLENAME, empaque.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(empaque.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EmpaqueDataAccess.TABLENAME, empaque.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EmpaqueConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EmpaqueLogic.registrarAuditoriaDetallesEmpaque(connexion,empaque,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEmpaque(Connexion connexion,Empaque empaque)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(empaque.getIsNew()||!empaque.getid_empresa().equals(empaque.getEmpaqueOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empaque.getEmpaqueOriginal().getid_empresa()!=null)
				{
					strValorActual=empaque.getEmpaqueOriginal().getid_empresa().toString();
				}
				if(empaque.getid_empresa()!=null)
				{
					strValorNuevo=empaque.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpaqueConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(empaque.getIsNew()||!empaque.getvalor().equals(empaque.getEmpaqueOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empaque.getEmpaqueOriginal().getvalor()!=null)
				{
					strValorActual=empaque.getEmpaqueOriginal().getvalor().toString();
				}
				if(empaque.getvalor()!=null)
				{
					strValorNuevo=empaque.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpaqueConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(empaque.getIsNew()||!empaque.getdescripcion().equals(empaque.getEmpaqueOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(empaque.getEmpaqueOriginal().getdescripcion()!=null)
				{
					strValorActual=empaque.getEmpaqueOriginal().getdescripcion();
				}
				if(empaque.getdescripcion()!=null)
				{
					strValorNuevo=empaque.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EmpaqueConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEmpaqueRelacionesWithConnection(Empaque empaque,List<DetaNotaCreditoSoli> detanotacreditosolis,List<DetalleProforma> detalleproformas) throws Exception {

		if(!empaque.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpaqueRelacionesBase(empaque,detanotacreditosolis,detalleproformas,true);
		}
	}

	public void saveEmpaqueRelaciones(Empaque empaque,List<DetaNotaCreditoSoli> detanotacreditosolis,List<DetalleProforma> detalleproformas)throws Exception {

		if(!empaque.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEmpaqueRelacionesBase(empaque,detanotacreditosolis,detalleproformas,false);
		}
	}

	public void saveEmpaqueRelacionesBase(Empaque empaque,List<DetaNotaCreditoSoli> detanotacreditosolis,List<DetalleProforma> detalleproformas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Empaque-saveRelacionesWithConnection");}
	
			empaque.setDetaNotaCreditoSolis(detanotacreditosolis);
			empaque.setDetalleProformas(detalleproformas);

			this.setEmpaque(empaque);

			if(EmpaqueLogicAdditional.validarSaveRelaciones(empaque,this)) {

				EmpaqueLogicAdditional.updateRelacionesToSave(empaque,this);

				if((empaque.getIsNew()||empaque.getIsChanged())&&!empaque.getIsDeleted()) {
					this.saveEmpaque();
					this.saveEmpaqueRelacionesDetalles(detanotacreditosolis,detalleproformas);

				} else if(empaque.getIsDeleted()) {
					this.saveEmpaqueRelacionesDetalles(detanotacreditosolis,detalleproformas);
					this.saveEmpaque();
				}

				EmpaqueLogicAdditional.updateRelacionesToSaveAfter(empaque,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetaNotaCreditoSoliConstantesFunciones.InicializarGeneralEntityAuxiliaresDetaNotaCreditoSolis(detanotacreditosolis,true,true);
			DetalleProformaConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleProformas(detalleproformas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEmpaqueRelacionesDetalles(List<DetaNotaCreditoSoli> detanotacreditosolis,List<DetalleProforma> detalleproformas)throws Exception {
		try {
	

			Long idEmpaqueActual=this.getEmpaque().getId();

			DetaNotaCreditoSoliLogic detanotacreditosoliLogic_Desde_Empaque=new DetaNotaCreditoSoliLogic();
			detanotacreditosoliLogic_Desde_Empaque.setDetaNotaCreditoSolis(detanotacreditosolis);

			detanotacreditosoliLogic_Desde_Empaque.setConnexion(this.getConnexion());
			detanotacreditosoliLogic_Desde_Empaque.setDatosCliente(this.datosCliente);

			for(DetaNotaCreditoSoli detanotacreditosoli_Desde_Empaque:detanotacreditosoliLogic_Desde_Empaque.getDetaNotaCreditoSolis()) {
				detanotacreditosoli_Desde_Empaque.setid_empaque(idEmpaqueActual);
			}

			detanotacreditosoliLogic_Desde_Empaque.saveDetaNotaCreditoSolis();

			DetalleProformaLogic detalleproformaLogic_Desde_Empaque=new DetalleProformaLogic();
			detalleproformaLogic_Desde_Empaque.setDetalleProformas(detalleproformas);

			detalleproformaLogic_Desde_Empaque.setConnexion(this.getConnexion());
			detalleproformaLogic_Desde_Empaque.setDatosCliente(this.datosCliente);

			for(DetalleProforma detalleproforma_Desde_Empaque:detalleproformaLogic_Desde_Empaque.getDetalleProformas()) {
				detalleproforma_Desde_Empaque.setid_empaque(idEmpaqueActual);
			}

			detalleproformaLogic_Desde_Empaque.saveDetalleProformas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEmpaque(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpaqueConstantesFunciones.getClassesForeignKeysOfEmpaque(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpaque(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EmpaqueConstantesFunciones.getClassesRelationshipsOfEmpaque(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

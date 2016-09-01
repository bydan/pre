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
package com.bydan.erp.nomina.business.logic;

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
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.util.HerramientaConstantesFunciones;
import com.bydan.erp.nomina.util.HerramientaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.HerramientaParameterGeneral;
import com.bydan.erp.nomina.business.entity.Herramienta;
import com.bydan.erp.nomina.business.logic.HerramientaLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class HerramientaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(HerramientaLogic.class);
	
	protected HerramientaDataAccess herramientaDataAccess; 	
	protected Herramienta herramienta;
	protected List<Herramienta> herramientas;
	protected Object herramientaObject;	
	protected List<Object> herramientasObject;
	
	public static ClassValidator<Herramienta> herramientaValidator = new ClassValidator<Herramienta>(Herramienta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected HerramientaLogicAdditional herramientaLogicAdditional=null;
	
	public HerramientaLogicAdditional getHerramientaLogicAdditional() {
		return this.herramientaLogicAdditional;
	}
	
	public void setHerramientaLogicAdditional(HerramientaLogicAdditional herramientaLogicAdditional) {
		try {
			this.herramientaLogicAdditional=herramientaLogicAdditional;
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
	
	
	
	
	public  HerramientaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.herramientaDataAccess = new HerramientaDataAccess();
			
			this.herramientas= new ArrayList<Herramienta>();
			this.herramienta= new Herramienta();
			
			this.herramientaObject=new Object();
			this.herramientasObject=new ArrayList<Object>();
				
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
			
			this.herramientaDataAccess.setConnexionType(this.connexionType);
			this.herramientaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  HerramientaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.herramientaDataAccess = new HerramientaDataAccess();
			this.herramientas= new ArrayList<Herramienta>();
			this.herramienta= new Herramienta();
			this.herramientaObject=new Object();
			this.herramientasObject=new ArrayList<Object>();
			
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
			
			this.herramientaDataAccess.setConnexionType(this.connexionType);
			this.herramientaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Herramienta getHerramienta() throws Exception {	
		HerramientaLogicAdditional.checkHerramientaToGet(herramienta,this.datosCliente,this.arrDatoGeneral);
		HerramientaLogicAdditional.updateHerramientaToGet(herramienta,this.arrDatoGeneral);
		
		return herramienta;
	}
		
	public void setHerramienta(Herramienta newHerramienta) {
		this.herramienta = newHerramienta;
	}
	
	public HerramientaDataAccess getHerramientaDataAccess() {
		return herramientaDataAccess;
	}
	
	public void setHerramientaDataAccess(HerramientaDataAccess newherramientaDataAccess) {
		this.herramientaDataAccess = newherramientaDataAccess;
	}
	
	public List<Herramienta> getHerramientas() throws Exception {		
		this.quitarHerramientasNulos();
		
		HerramientaLogicAdditional.checkHerramientaToGets(herramientas,this.datosCliente,this.arrDatoGeneral);
		
		for (Herramienta herramientaLocal: herramientas ) {
			HerramientaLogicAdditional.updateHerramientaToGet(herramientaLocal,this.arrDatoGeneral);
		}
		
		return herramientas;
	}
	
	public void setHerramientas(List<Herramienta> newHerramientas) {
		this.herramientas = newHerramientas;
	}
	
	public Object getHerramientaObject() {	
		this.herramientaObject=this.herramientaDataAccess.getEntityObject();
		return this.herramientaObject;
	}
		
	public void setHerramientaObject(Object newHerramientaObject) {
		this.herramientaObject = newHerramientaObject;
	}
	
	public List<Object> getHerramientasObject() {		
		this.herramientasObject=this.herramientaDataAccess.getEntitiesObject();
		return this.herramientasObject;
	}
		
	public void setHerramientasObject(List<Object> newHerramientasObject) {
		this.herramientasObject = newHerramientasObject;
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
		
		if(this.herramientaDataAccess!=null) {
			this.herramientaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Herramienta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			herramientaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			herramientaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		herramienta = new  Herramienta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Herramienta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			herramienta=herramientaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.herramienta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HerramientaConstantesFunciones.refrescarForeignKeysDescripcionesHerramienta(this.herramienta);
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
		herramienta = new  Herramienta();
		  		  
        try {
			
			herramienta=herramientaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.herramienta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HerramientaConstantesFunciones.refrescarForeignKeysDescripcionesHerramienta(this.herramienta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		herramienta = new  Herramienta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Herramienta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			herramienta=herramientaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.herramienta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HerramientaConstantesFunciones.refrescarForeignKeysDescripcionesHerramienta(this.herramienta);
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
		herramienta = new  Herramienta();
		  		  
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
		herramienta = new  Herramienta();
		  		  
        try {
			
			herramienta=herramientaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.herramienta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				HerramientaConstantesFunciones.refrescarForeignKeysDescripcionesHerramienta(this.herramienta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		herramienta = new  Herramienta();
		  		  
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
		herramienta = new  Herramienta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Herramienta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =herramientaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		herramienta = new  Herramienta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=herramientaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		herramienta = new  Herramienta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Herramienta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =herramientaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		herramienta = new  Herramienta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=herramientaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		herramienta = new  Herramienta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Herramienta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =herramientaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		herramienta = new  Herramienta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=herramientaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		herramientas = new  ArrayList<Herramienta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Herramienta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			HerramientaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			herramientas=herramientaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHerramienta(herramientas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HerramientaConstantesFunciones.refrescarForeignKeysDescripcionesHerramienta(this.herramientas);
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
		herramientas = new  ArrayList<Herramienta>();
		  		  
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
		herramientas = new  ArrayList<Herramienta>();
		  		  
        try {			
			HerramientaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			herramientas=herramientaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarHerramienta(herramientas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HerramientaConstantesFunciones.refrescarForeignKeysDescripcionesHerramienta(this.herramientas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		herramientas = new  ArrayList<Herramienta>();
		  		  
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
		herramientas = new  ArrayList<Herramienta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Herramienta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			HerramientaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			herramientas=herramientaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHerramienta(herramientas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HerramientaConstantesFunciones.refrescarForeignKeysDescripcionesHerramienta(this.herramientas);
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
		herramientas = new  ArrayList<Herramienta>();
		  		  
        try {
			HerramientaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			herramientas=herramientaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHerramienta(herramientas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HerramientaConstantesFunciones.refrescarForeignKeysDescripcionesHerramienta(this.herramientas);
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
		herramientas = new  ArrayList<Herramienta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Herramienta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HerramientaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			herramientas=herramientaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHerramienta(herramientas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HerramientaConstantesFunciones.refrescarForeignKeysDescripcionesHerramienta(this.herramientas);
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
		herramientas = new  ArrayList<Herramienta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HerramientaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			herramientas=herramientaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHerramienta(herramientas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HerramientaConstantesFunciones.refrescarForeignKeysDescripcionesHerramienta(this.herramientas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		herramienta = new  Herramienta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Herramienta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HerramientaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			herramienta=herramientaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHerramienta(herramienta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HerramientaConstantesFunciones.refrescarForeignKeysDescripcionesHerramienta(this.herramienta);
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
		herramienta = new  Herramienta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HerramientaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			herramienta=herramientaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarHerramienta(herramienta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HerramientaConstantesFunciones.refrescarForeignKeysDescripcionesHerramienta(this.herramienta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		herramientas = new  ArrayList<Herramienta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Herramienta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			HerramientaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			herramientas=herramientaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHerramienta(herramientas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HerramientaConstantesFunciones.refrescarForeignKeysDescripcionesHerramienta(this.herramientas);
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
		herramientas = new  ArrayList<Herramienta>();
		  		  
        try {
			HerramientaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			herramientas=herramientaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarHerramienta(herramientas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HerramientaConstantesFunciones.refrescarForeignKeysDescripcionesHerramienta(this.herramientas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosHerramientasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		herramientas = new  ArrayList<Herramienta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Herramienta.class.getSimpleName()+"-getTodosHerramientasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HerramientaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			herramientas=herramientaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarHerramienta(herramientas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HerramientaConstantesFunciones.refrescarForeignKeysDescripcionesHerramienta(this.herramientas);
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
	
	public  void  getTodosHerramientas(String sFinalQuery,Pagination pagination)throws Exception {
		herramientas = new  ArrayList<Herramienta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			HerramientaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			herramientas=herramientaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarHerramienta(herramientas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				HerramientaConstantesFunciones.refrescarForeignKeysDescripcionesHerramienta(this.herramientas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarHerramienta(Herramienta herramienta) throws Exception {
		Boolean estaValidado=false;
		
		if(herramienta.getIsNew() || herramienta.getIsChanged()) { 
			this.invalidValues = herramientaValidator.getInvalidValues(herramienta);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(herramienta);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarHerramienta(List<Herramienta> Herramientas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Herramienta herramientaLocal:herramientas) {				
			estaValidadoObjeto=this.validarGuardarHerramienta(herramientaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarHerramienta(List<Herramienta> Herramientas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarHerramienta(herramientas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarHerramienta(Herramienta Herramienta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarHerramienta(herramienta)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Herramienta herramienta) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+herramienta.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=HerramientaConstantesFunciones.getHerramientaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"herramienta","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(HerramientaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(HerramientaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveHerramientaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Herramienta.class.getSimpleName()+"-saveHerramientaWithConnection");connexion.begin();			
			
			HerramientaLogicAdditional.checkHerramientaToSave(this.herramienta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			HerramientaLogicAdditional.updateHerramientaToSave(this.herramienta,this.arrDatoGeneral);
			
			HerramientaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.herramienta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowHerramienta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarHerramienta(this.herramienta)) {
				HerramientaDataAccess.save(this.herramienta, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.herramienta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			HerramientaLogicAdditional.checkHerramientaToSaveAfter(this.herramienta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowHerramienta();
			
			connexion.commit();			
			
			if(this.herramienta.getIsDeleted()) {
				this.herramienta=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveHerramienta()throws Exception {	
		try {	
			
			HerramientaLogicAdditional.checkHerramientaToSave(this.herramienta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			HerramientaLogicAdditional.updateHerramientaToSave(this.herramienta,this.arrDatoGeneral);
			
			HerramientaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.herramienta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarHerramienta(this.herramienta)) {			
				HerramientaDataAccess.save(this.herramienta, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.herramienta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			HerramientaLogicAdditional.checkHerramientaToSaveAfter(this.herramienta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.herramienta.getIsDeleted()) {
				this.herramienta=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveHerramientasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Herramienta.class.getSimpleName()+"-saveHerramientasWithConnection");connexion.begin();			
			
			HerramientaLogicAdditional.checkHerramientaToSaves(herramientas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowHerramientas();
			
			Boolean validadoTodosHerramienta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Herramienta herramientaLocal:herramientas) {		
				if(herramientaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				HerramientaLogicAdditional.updateHerramientaToSave(herramientaLocal,this.arrDatoGeneral);
	        	
				HerramientaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),herramientaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarHerramienta(herramientaLocal)) {
					HerramientaDataAccess.save(herramientaLocal, connexion);				
				} else {
					validadoTodosHerramienta=false;
				}
			}
			
			if(!validadoTodosHerramienta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			HerramientaLogicAdditional.checkHerramientaToSavesAfter(herramientas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowHerramientas();
			
			connexion.commit();		
			
			this.quitarHerramientasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveHerramientas()throws Exception {				
		 try {	
			HerramientaLogicAdditional.checkHerramientaToSaves(herramientas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosHerramienta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Herramienta herramientaLocal:herramientas) {				
				if(herramientaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				HerramientaLogicAdditional.updateHerramientaToSave(herramientaLocal,this.arrDatoGeneral);
	        	
				HerramientaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),herramientaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarHerramienta(herramientaLocal)) {				
					HerramientaDataAccess.save(herramientaLocal, connexion);				
				} else {
					validadoTodosHerramienta=false;
				}
			}
			
			if(!validadoTodosHerramienta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			HerramientaLogicAdditional.checkHerramientaToSavesAfter(herramientas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarHerramientasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public HerramientaParameterReturnGeneral procesarAccionHerramientas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Herramienta> herramientas,HerramientaParameterReturnGeneral herramientaParameterGeneral)throws Exception {
		 try {	
			HerramientaParameterReturnGeneral herramientaReturnGeneral=new HerramientaParameterReturnGeneral();
	
			HerramientaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,herramientas,herramientaParameterGeneral,herramientaReturnGeneral);
			
			return herramientaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public HerramientaParameterReturnGeneral procesarAccionHerramientasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Herramienta> herramientas,HerramientaParameterReturnGeneral herramientaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Herramienta.class.getSimpleName()+"-procesarAccionHerramientasWithConnection");connexion.begin();			
			
			HerramientaParameterReturnGeneral herramientaReturnGeneral=new HerramientaParameterReturnGeneral();
	
			HerramientaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,herramientas,herramientaParameterGeneral,herramientaReturnGeneral);
			
			this.connexion.commit();
			
			return herramientaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public HerramientaParameterReturnGeneral procesarEventosHerramientas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Herramienta> herramientas,Herramienta herramienta,HerramientaParameterReturnGeneral herramientaParameterGeneral,Boolean isEsNuevoHerramienta,ArrayList<Classe> clases)throws Exception {
		 try {	
			HerramientaParameterReturnGeneral herramientaReturnGeneral=new HerramientaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				herramientaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			HerramientaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,herramientas,herramienta,herramientaParameterGeneral,herramientaReturnGeneral,isEsNuevoHerramienta,clases);
			
			return herramientaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public HerramientaParameterReturnGeneral procesarEventosHerramientasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Herramienta> herramientas,Herramienta herramienta,HerramientaParameterReturnGeneral herramientaParameterGeneral,Boolean isEsNuevoHerramienta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Herramienta.class.getSimpleName()+"-procesarEventosHerramientasWithConnection");connexion.begin();			
			
			HerramientaParameterReturnGeneral herramientaReturnGeneral=new HerramientaParameterReturnGeneral();
	
			herramientaReturnGeneral.setHerramienta(herramienta);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				herramientaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			HerramientaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,herramientas,herramienta,herramientaParameterGeneral,herramientaReturnGeneral,isEsNuevoHerramienta,clases);
			
			this.connexion.commit();
			
			return herramientaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public HerramientaParameterReturnGeneral procesarImportacionHerramientasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,HerramientaParameterReturnGeneral herramientaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Herramienta.class.getSimpleName()+"-procesarImportacionHerramientasWithConnection");connexion.begin();			
			
			HerramientaParameterReturnGeneral herramientaReturnGeneral=new HerramientaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.herramientas=new ArrayList<Herramienta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.herramienta=new Herramienta();
				
				
				if(conColumnasBase) {this.herramienta.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.herramienta.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.herramienta.setnombre(arrColumnas[iColumn++]);
				this.herramienta.setdescripcion(arrColumnas[iColumn++]);
				
				this.herramientas.add(this.herramienta);
			}
			
			this.saveHerramientas();
			
			this.connexion.commit();
			
			herramientaReturnGeneral.setConRetornoEstaProcesado(true);
			herramientaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return herramientaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarHerramientasEliminados() throws Exception {				
		
		List<Herramienta> herramientasAux= new ArrayList<Herramienta>();
		
		for(Herramienta herramienta:herramientas) {
			if(!herramienta.getIsDeleted()) {
				herramientasAux.add(herramienta);
			}
		}
		
		herramientas=herramientasAux;
	}
	
	public void quitarHerramientasNulos() throws Exception {				
		
		List<Herramienta> herramientasAux= new ArrayList<Herramienta>();
		
		for(Herramienta herramienta : this.herramientas) {
			if(herramienta==null) {
				herramientasAux.add(herramienta);
			}
		}
		
		//this.herramientas=herramientasAux;
		
		this.herramientas.removeAll(herramientasAux);
	}
	
	public void getSetVersionRowHerramientaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(herramienta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((herramienta.getIsDeleted() || (herramienta.getIsChanged()&&!herramienta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=herramientaDataAccess.getSetVersionRowHerramienta(connexion,herramienta.getId());
				
				if(!herramienta.getVersionRow().equals(timestamp)) {	
					herramienta.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				herramienta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowHerramienta()throws Exception {	
		
		if(herramienta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((herramienta.getIsDeleted() || (herramienta.getIsChanged()&&!herramienta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=herramientaDataAccess.getSetVersionRowHerramienta(connexion,herramienta.getId());
			
			try {							
				if(!herramienta.getVersionRow().equals(timestamp)) {	
					herramienta.setVersionRow(timestamp);
				}
				
				herramienta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowHerramientasWithConnection()throws Exception {	
		if(herramientas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Herramienta herramientaAux:herramientas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(herramientaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(herramientaAux.getIsDeleted() || (herramientaAux.getIsChanged()&&!herramientaAux.getIsNew())) {
						
						timestamp=herramientaDataAccess.getSetVersionRowHerramienta(connexion,herramientaAux.getId());
						
						if(!herramienta.getVersionRow().equals(timestamp)) {	
							herramientaAux.setVersionRow(timestamp);
						}
								
						herramientaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowHerramientas()throws Exception {	
		if(herramientas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Herramienta herramientaAux:herramientas) {
					if(herramientaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(herramientaAux.getIsDeleted() || (herramientaAux.getIsChanged()&&!herramientaAux.getIsNew())) {
						
						timestamp=herramientaDataAccess.getSetVersionRowHerramienta(connexion,herramientaAux.getId());
						
						if(!herramientaAux.getVersionRow().equals(timestamp)) {	
							herramientaAux.setVersionRow(timestamp);
						}
						
													
						herramientaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public HerramientaParameterReturnGeneral cargarCombosLoteForeignKeyHerramientaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		HerramientaParameterReturnGeneral  herramientaReturnGeneral =new HerramientaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Herramienta.class.getSimpleName()+"-cargarCombosLoteForeignKeyHerramientaWithConnection");connexion.begin();
			
			herramientaReturnGeneral =new HerramientaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			herramientaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return herramientaReturnGeneral;
	}
	
	public HerramientaParameterReturnGeneral cargarCombosLoteForeignKeyHerramienta(String finalQueryGlobalEmpresa) throws Exception {
		HerramientaParameterReturnGeneral  herramientaReturnGeneral =new HerramientaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			herramientaReturnGeneral =new HerramientaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			herramientaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return herramientaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyHerramientaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			EmpleadoHerraLogic empleadoherraLogic=new EmpleadoHerraLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Herramienta.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyHerramientaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(EmpleadoHerra.class));
											
			

			empleadoherraLogic.setConnexion(this.getConnexion());
			empleadoherraLogic.setDatosCliente(this.datosCliente);
			empleadoherraLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Herramienta herramienta:this.herramientas) {
				

				classes=new ArrayList<Classe>();
				classes=EmpleadoHerraConstantesFunciones.getClassesForeignKeysOfEmpleadoHerra(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoherraLogic.setEmpleadoHerras(herramienta.empleadoherras);
				empleadoherraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Herramienta herramienta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			HerramientaLogicAdditional.updateHerramientaToGet(herramienta,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		herramienta.setEmpresa(herramientaDataAccess.getEmpresa(connexion,herramienta));
		herramienta.setEmpleadoHerras(herramientaDataAccess.getEmpleadoHerras(connexion,herramienta));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				herramienta.setEmpresa(herramientaDataAccess.getEmpresa(connexion,herramienta));
				continue;
			}

			if(clas.clas.equals(EmpleadoHerra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				herramienta.setEmpleadoHerras(herramientaDataAccess.getEmpleadoHerras(connexion,herramienta));

				if(this.isConDeep) {
					EmpleadoHerraLogic empleadoherraLogic= new EmpleadoHerraLogic(this.connexion);
					empleadoherraLogic.setEmpleadoHerras(herramienta.getEmpleadoHerras());
					ArrayList<Classe> classesLocal=EmpleadoHerraConstantesFunciones.getClassesForeignKeysOfEmpleadoHerra(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoherraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoHerraConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoHerra(empleadoherraLogic.getEmpleadoHerras());
					herramienta.setEmpleadoHerras(empleadoherraLogic.getEmpleadoHerras());
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
			herramienta.setEmpresa(herramientaDataAccess.getEmpresa(connexion,herramienta));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoHerra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoHerra.class));
			herramienta.setEmpleadoHerras(herramientaDataAccess.getEmpleadoHerras(connexion,herramienta));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		herramienta.setEmpresa(herramientaDataAccess.getEmpresa(connexion,herramienta));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(herramienta.getEmpresa(),isDeep,deepLoadType,clases);
				

		herramienta.setEmpleadoHerras(herramientaDataAccess.getEmpleadoHerras(connexion,herramienta));

		for(EmpleadoHerra empleadoherra:herramienta.getEmpleadoHerras()) {
			EmpleadoHerraLogic empleadoherraLogic= new EmpleadoHerraLogic(connexion);
			empleadoherraLogic.deepLoad(empleadoherra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				herramienta.setEmpresa(herramientaDataAccess.getEmpresa(connexion,herramienta));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(herramienta.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EmpleadoHerra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				herramienta.setEmpleadoHerras(herramientaDataAccess.getEmpleadoHerras(connexion,herramienta));

				for(EmpleadoHerra empleadoherra:herramienta.getEmpleadoHerras()) {
					EmpleadoHerraLogic empleadoherraLogic= new EmpleadoHerraLogic(connexion);
					empleadoherraLogic.deepLoad(empleadoherra,isDeep,deepLoadType,clases);
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
			herramienta.setEmpresa(herramientaDataAccess.getEmpresa(connexion,herramienta));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(herramienta.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoHerra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoHerra.class));
			herramienta.setEmpleadoHerras(herramientaDataAccess.getEmpleadoHerras(connexion,herramienta));

			for(EmpleadoHerra empleadoherra:herramienta.getEmpleadoHerras()) {
				EmpleadoHerraLogic empleadoherraLogic= new EmpleadoHerraLogic(connexion);
				empleadoherraLogic.deepLoad(empleadoherra,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Herramienta herramienta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			HerramientaLogicAdditional.updateHerramientaToSave(herramienta,this.arrDatoGeneral);
			
HerramientaDataAccess.save(herramienta, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(herramienta.getEmpresa(),connexion);

		for(EmpleadoHerra empleadoherra:herramienta.getEmpleadoHerras()) {
			empleadoherra.setid_herramienta(herramienta.getId());
			EmpleadoHerraDataAccess.save(empleadoherra,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(herramienta.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(EmpleadoHerra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoHerra empleadoherra:herramienta.getEmpleadoHerras()) {
					empleadoherra.setid_herramienta(herramienta.getId());
					EmpleadoHerraDataAccess.save(empleadoherra,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(herramienta.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(herramienta.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(EmpleadoHerra empleadoherra:herramienta.getEmpleadoHerras()) {
			EmpleadoHerraLogic empleadoherraLogic= new EmpleadoHerraLogic(connexion);
			empleadoherra.setid_herramienta(herramienta.getId());
			EmpleadoHerraDataAccess.save(empleadoherra,connexion);
			empleadoherraLogic.deepSave(empleadoherra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(herramienta.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(herramienta.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(EmpleadoHerra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoHerra empleadoherra:herramienta.getEmpleadoHerras()) {
					EmpleadoHerraLogic empleadoherraLogic= new EmpleadoHerraLogic(connexion);
					empleadoherra.setid_herramienta(herramienta.getId());
					EmpleadoHerraDataAccess.save(empleadoherra,connexion);
					empleadoherraLogic.deepSave(empleadoherra,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Herramienta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(herramienta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				HerramientaConstantesFunciones.refrescarForeignKeysDescripcionesHerramienta(herramienta);
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
			this.deepLoad(this.herramienta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				HerramientaConstantesFunciones.refrescarForeignKeysDescripcionesHerramienta(this.herramienta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Herramienta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(herramientas!=null) {
				for(Herramienta herramienta:herramientas) {
					this.deepLoad(herramienta,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					HerramientaConstantesFunciones.refrescarForeignKeysDescripcionesHerramienta(herramientas);
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
			if(herramientas!=null) {
				for(Herramienta herramienta:herramientas) {
					this.deepLoad(herramienta,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					HerramientaConstantesFunciones.refrescarForeignKeysDescripcionesHerramienta(herramientas);
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
			this.getNewConnexionToDeep(Herramienta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(herramienta,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Herramienta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(herramientas!=null) {
				for(Herramienta herramienta:herramientas) {
					this.deepSave(herramienta,isDeep,deepLoadType,clases);
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
			if(herramientas!=null) {
				for(Herramienta herramienta:herramientas) {
					this.deepSave(herramienta,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getHerramientasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Herramienta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,HerramientaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			HerramientaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			herramientas=herramientaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HerramientaConstantesFunciones.refrescarForeignKeysDescripcionesHerramienta(this.herramientas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getHerramientasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,HerramientaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			HerramientaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			herramientas=herramientaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				HerramientaConstantesFunciones.refrescarForeignKeysDescripcionesHerramienta(this.herramientas);
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
			if(HerramientaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,HerramientaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Herramienta herramienta,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(HerramientaConstantesFunciones.ISCONAUDITORIA) {
				if(herramienta.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HerramientaDataAccess.TABLENAME, herramienta.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(HerramientaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////HerramientaLogic.registrarAuditoriaDetallesHerramienta(connexion,herramienta,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(herramienta.getIsDeleted()) {
					/*if(!herramienta.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,HerramientaDataAccess.TABLENAME, herramienta.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////HerramientaLogic.registrarAuditoriaDetallesHerramienta(connexion,herramienta,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HerramientaDataAccess.TABLENAME, herramienta.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(herramienta.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,HerramientaDataAccess.TABLENAME, herramienta.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(HerramientaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////HerramientaLogic.registrarAuditoriaDetallesHerramienta(connexion,herramienta,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesHerramienta(Connexion connexion,Herramienta herramienta)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(herramienta.getIsNew()||!herramienta.getid_empresa().equals(herramienta.getHerramientaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(herramienta.getHerramientaOriginal().getid_empresa()!=null)
				{
					strValorActual=herramienta.getHerramientaOriginal().getid_empresa().toString();
				}
				if(herramienta.getid_empresa()!=null)
				{
					strValorNuevo=herramienta.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HerramientaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(herramienta.getIsNew()||!herramienta.getnombre().equals(herramienta.getHerramientaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(herramienta.getHerramientaOriginal().getnombre()!=null)
				{
					strValorActual=herramienta.getHerramientaOriginal().getnombre();
				}
				if(herramienta.getnombre()!=null)
				{
					strValorNuevo=herramienta.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HerramientaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(herramienta.getIsNew()||!herramienta.getdescripcion().equals(herramienta.getHerramientaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(herramienta.getHerramientaOriginal().getdescripcion()!=null)
				{
					strValorActual=herramienta.getHerramientaOriginal().getdescripcion();
				}
				if(herramienta.getdescripcion()!=null)
				{
					strValorNuevo=herramienta.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),HerramientaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveHerramientaRelacionesWithConnection(Herramienta herramienta,List<EmpleadoHerra> empleadoherras) throws Exception {

		if(!herramienta.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveHerramientaRelacionesBase(herramienta,empleadoherras,true);
		}
	}

	public void saveHerramientaRelaciones(Herramienta herramienta,List<EmpleadoHerra> empleadoherras)throws Exception {

		if(!herramienta.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveHerramientaRelacionesBase(herramienta,empleadoherras,false);
		}
	}

	public void saveHerramientaRelacionesBase(Herramienta herramienta,List<EmpleadoHerra> empleadoherras,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Herramienta-saveRelacionesWithConnection");}
	
			herramienta.setEmpleadoHerras(empleadoherras);

			this.setHerramienta(herramienta);

			if(HerramientaLogicAdditional.validarSaveRelaciones(herramienta,this)) {

				HerramientaLogicAdditional.updateRelacionesToSave(herramienta,this);

				if((herramienta.getIsNew()||herramienta.getIsChanged())&&!herramienta.getIsDeleted()) {
					this.saveHerramienta();
					this.saveHerramientaRelacionesDetalles(empleadoherras);

				} else if(herramienta.getIsDeleted()) {
					this.saveHerramientaRelacionesDetalles(empleadoherras);
					this.saveHerramienta();
				}

				HerramientaLogicAdditional.updateRelacionesToSaveAfter(herramienta,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			EmpleadoHerraConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleadoHerras(empleadoherras,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveHerramientaRelacionesDetalles(List<EmpleadoHerra> empleadoherras)throws Exception {
		try {
	

			Long idHerramientaActual=this.getHerramienta().getId();

			EmpleadoHerraLogic empleadoherraLogic_Desde_Herramienta=new EmpleadoHerraLogic();
			empleadoherraLogic_Desde_Herramienta.setEmpleadoHerras(empleadoherras);

			empleadoherraLogic_Desde_Herramienta.setConnexion(this.getConnexion());
			empleadoherraLogic_Desde_Herramienta.setDatosCliente(this.datosCliente);

			for(EmpleadoHerra empleadoherra_Desde_Herramienta:empleadoherraLogic_Desde_Herramienta.getEmpleadoHerras()) {
				empleadoherra_Desde_Herramienta.setid_herramienta(idHerramientaActual);
			}

			empleadoherraLogic_Desde_Herramienta.saveEmpleadoHerras();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfHerramienta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=HerramientaConstantesFunciones.getClassesForeignKeysOfHerramienta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfHerramienta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=HerramientaConstantesFunciones.getClassesRelationshipsOfHerramienta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

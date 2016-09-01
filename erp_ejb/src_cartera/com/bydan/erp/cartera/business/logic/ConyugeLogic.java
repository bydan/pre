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
import com.bydan.erp.cartera.util.ConyugeConstantesFunciones;
import com.bydan.erp.cartera.util.ConyugeParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ConyugeParameterGeneral;
import com.bydan.erp.cartera.business.entity.Conyuge;
import com.bydan.erp.cartera.business.logic.ConyugeLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class ConyugeLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ConyugeLogic.class);
	
	protected ConyugeDataAccess conyugeDataAccess; 	
	protected Conyuge conyuge;
	protected List<Conyuge> conyuges;
	protected Object conyugeObject;	
	protected List<Object> conyugesObject;
	
	public static ClassValidator<Conyuge> conyugeValidator = new ClassValidator<Conyuge>(Conyuge.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ConyugeLogicAdditional conyugeLogicAdditional=null;
	
	public ConyugeLogicAdditional getConyugeLogicAdditional() {
		return this.conyugeLogicAdditional;
	}
	
	public void setConyugeLogicAdditional(ConyugeLogicAdditional conyugeLogicAdditional) {
		try {
			this.conyugeLogicAdditional=conyugeLogicAdditional;
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
	
	
	
	
	public  ConyugeLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.conyugeDataAccess = new ConyugeDataAccess();
			
			this.conyuges= new ArrayList<Conyuge>();
			this.conyuge= new Conyuge();
			
			this.conyugeObject=new Object();
			this.conyugesObject=new ArrayList<Object>();
				
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
			
			this.conyugeDataAccess.setConnexionType(this.connexionType);
			this.conyugeDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ConyugeLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.conyugeDataAccess = new ConyugeDataAccess();
			this.conyuges= new ArrayList<Conyuge>();
			this.conyuge= new Conyuge();
			this.conyugeObject=new Object();
			this.conyugesObject=new ArrayList<Object>();
			
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
			
			this.conyugeDataAccess.setConnexionType(this.connexionType);
			this.conyugeDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Conyuge getConyuge() throws Exception {	
		ConyugeLogicAdditional.checkConyugeToGet(conyuge,this.datosCliente,this.arrDatoGeneral);
		ConyugeLogicAdditional.updateConyugeToGet(conyuge,this.arrDatoGeneral);
		
		return conyuge;
	}
		
	public void setConyuge(Conyuge newConyuge) {
		this.conyuge = newConyuge;
	}
	
	public ConyugeDataAccess getConyugeDataAccess() {
		return conyugeDataAccess;
	}
	
	public void setConyugeDataAccess(ConyugeDataAccess newconyugeDataAccess) {
		this.conyugeDataAccess = newconyugeDataAccess;
	}
	
	public List<Conyuge> getConyuges() throws Exception {		
		this.quitarConyugesNulos();
		
		ConyugeLogicAdditional.checkConyugeToGets(conyuges,this.datosCliente,this.arrDatoGeneral);
		
		for (Conyuge conyugeLocal: conyuges ) {
			ConyugeLogicAdditional.updateConyugeToGet(conyugeLocal,this.arrDatoGeneral);
		}
		
		return conyuges;
	}
	
	public void setConyuges(List<Conyuge> newConyuges) {
		this.conyuges = newConyuges;
	}
	
	public Object getConyugeObject() {	
		this.conyugeObject=this.conyugeDataAccess.getEntityObject();
		return this.conyugeObject;
	}
		
	public void setConyugeObject(Object newConyugeObject) {
		this.conyugeObject = newConyugeObject;
	}
	
	public List<Object> getConyugesObject() {		
		this.conyugesObject=this.conyugeDataAccess.getEntitiesObject();
		return this.conyugesObject;
	}
		
	public void setConyugesObject(List<Object> newConyugesObject) {
		this.conyugesObject = newConyugesObject;
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
		
		if(this.conyugeDataAccess!=null) {
			this.conyugeDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conyuge.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			conyugeDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			conyugeDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		conyuge = new  Conyuge();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conyuge.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			conyuge=conyugeDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.conyuge,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(this.conyuge);
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
		conyuge = new  Conyuge();
		  		  
        try {
			
			conyuge=conyugeDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.conyuge,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(this.conyuge);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		conyuge = new  Conyuge();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conyuge.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			conyuge=conyugeDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.conyuge,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(this.conyuge);
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
		conyuge = new  Conyuge();
		  		  
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
		conyuge = new  Conyuge();
		  		  
        try {
			
			conyuge=conyugeDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.conyuge,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(this.conyuge);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		conyuge = new  Conyuge();
		  		  
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
		conyuge = new  Conyuge();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conyuge.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =conyugeDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		conyuge = new  Conyuge();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=conyugeDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		conyuge = new  Conyuge();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conyuge.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =conyugeDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		conyuge = new  Conyuge();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=conyugeDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		conyuge = new  Conyuge();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conyuge.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =conyugeDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		conyuge = new  Conyuge();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=conyugeDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		conyuges = new  ArrayList<Conyuge>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conyuge.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ConyugeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conyuges=conyugeDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConyuge(conyuges);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(this.conyuges);
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
		conyuges = new  ArrayList<Conyuge>();
		  		  
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
		conyuges = new  ArrayList<Conyuge>();
		  		  
        try {			
			ConyugeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conyuges=conyugeDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarConyuge(conyuges);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(this.conyuges);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		conyuges = new  ArrayList<Conyuge>();
		  		  
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
		conyuges = new  ArrayList<Conyuge>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conyuge.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ConyugeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conyuges=conyugeDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConyuge(conyuges);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(this.conyuges);
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
		conyuges = new  ArrayList<Conyuge>();
		  		  
        try {
			ConyugeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conyuges=conyugeDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConyuge(conyuges);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(this.conyuges);
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
		conyuges = new  ArrayList<Conyuge>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conyuge.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConyugeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conyuges=conyugeDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConyuge(conyuges);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(this.conyuges);
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
		conyuges = new  ArrayList<Conyuge>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConyugeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conyuges=conyugeDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConyuge(conyuges);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(this.conyuges);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		conyuge = new  Conyuge();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conyuge.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConyugeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conyuge=conyugeDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConyuge(conyuge);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(this.conyuge);
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
		conyuge = new  Conyuge();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConyugeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conyuge=conyugeDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarConyuge(conyuge);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(this.conyuge);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		conyuges = new  ArrayList<Conyuge>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conyuge.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ConyugeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conyuges=conyugeDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConyuge(conyuges);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(this.conyuges);
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
		conyuges = new  ArrayList<Conyuge>();
		  		  
        try {
			ConyugeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conyuges=conyugeDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarConyuge(conyuges);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(this.conyuges);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosConyugesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		conyuges = new  ArrayList<Conyuge>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conyuge.class.getSimpleName()+"-getTodosConyugesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConyugeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conyuges=conyugeDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarConyuge(conyuges);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(this.conyuges);
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
	
	public  void  getTodosConyuges(String sFinalQuery,Pagination pagination)throws Exception {
		conyuges = new  ArrayList<Conyuge>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ConyugeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			conyuges=conyugeDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarConyuge(conyuges);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(this.conyuges);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarConyuge(Conyuge conyuge) throws Exception {
		Boolean estaValidado=false;
		
		if(conyuge.getIsNew() || conyuge.getIsChanged()) { 
			this.invalidValues = conyugeValidator.getInvalidValues(conyuge);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(conyuge);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarConyuge(List<Conyuge> Conyuges) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Conyuge conyugeLocal:conyuges) {				
			estaValidadoObjeto=this.validarGuardarConyuge(conyugeLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarConyuge(List<Conyuge> Conyuges) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarConyuge(conyuges)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarConyuge(Conyuge Conyuge) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarConyuge(conyuge)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Conyuge conyuge) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+conyuge.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ConyugeConstantesFunciones.getConyugeLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"conyuge","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ConyugeConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ConyugeConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveConyugeWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conyuge.class.getSimpleName()+"-saveConyugeWithConnection");connexion.begin();			
			
			ConyugeLogicAdditional.checkConyugeToSave(this.conyuge,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ConyugeLogicAdditional.updateConyugeToSave(this.conyuge,this.arrDatoGeneral);
			
			ConyugeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.conyuge,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowConyuge();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarConyuge(this.conyuge)) {
				ConyugeDataAccess.save(this.conyuge, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.conyuge,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ConyugeLogicAdditional.checkConyugeToSaveAfter(this.conyuge,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowConyuge();
			
			connexion.commit();			
			
			if(this.conyuge.getIsDeleted()) {
				this.conyuge=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveConyuge()throws Exception {	
		try {	
			
			ConyugeLogicAdditional.checkConyugeToSave(this.conyuge,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ConyugeLogicAdditional.updateConyugeToSave(this.conyuge,this.arrDatoGeneral);
			
			ConyugeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.conyuge,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarConyuge(this.conyuge)) {			
				ConyugeDataAccess.save(this.conyuge, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.conyuge,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ConyugeLogicAdditional.checkConyugeToSaveAfter(this.conyuge,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.conyuge.getIsDeleted()) {
				this.conyuge=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveConyugesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conyuge.class.getSimpleName()+"-saveConyugesWithConnection");connexion.begin();			
			
			ConyugeLogicAdditional.checkConyugeToSaves(conyuges,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowConyuges();
			
			Boolean validadoTodosConyuge=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Conyuge conyugeLocal:conyuges) {		
				if(conyugeLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ConyugeLogicAdditional.updateConyugeToSave(conyugeLocal,this.arrDatoGeneral);
	        	
				ConyugeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),conyugeLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarConyuge(conyugeLocal)) {
					ConyugeDataAccess.save(conyugeLocal, connexion);				
				} else {
					validadoTodosConyuge=false;
				}
			}
			
			if(!validadoTodosConyuge) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ConyugeLogicAdditional.checkConyugeToSavesAfter(conyuges,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowConyuges();
			
			connexion.commit();		
			
			this.quitarConyugesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveConyuges()throws Exception {				
		 try {	
			ConyugeLogicAdditional.checkConyugeToSaves(conyuges,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosConyuge=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Conyuge conyugeLocal:conyuges) {				
				if(conyugeLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ConyugeLogicAdditional.updateConyugeToSave(conyugeLocal,this.arrDatoGeneral);
	        	
				ConyugeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),conyugeLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarConyuge(conyugeLocal)) {				
					ConyugeDataAccess.save(conyugeLocal, connexion);				
				} else {
					validadoTodosConyuge=false;
				}
			}
			
			if(!validadoTodosConyuge) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ConyugeLogicAdditional.checkConyugeToSavesAfter(conyuges,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarConyugesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConyugeParameterReturnGeneral procesarAccionConyuges(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Conyuge> conyuges,ConyugeParameterReturnGeneral conyugeParameterGeneral)throws Exception {
		 try {	
			ConyugeParameterReturnGeneral conyugeReturnGeneral=new ConyugeParameterReturnGeneral();
	
			ConyugeLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,conyuges,conyugeParameterGeneral,conyugeReturnGeneral);
			
			return conyugeReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ConyugeParameterReturnGeneral procesarAccionConyugesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Conyuge> conyuges,ConyugeParameterReturnGeneral conyugeParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conyuge.class.getSimpleName()+"-procesarAccionConyugesWithConnection");connexion.begin();			
			
			ConyugeParameterReturnGeneral conyugeReturnGeneral=new ConyugeParameterReturnGeneral();
	
			ConyugeLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,conyuges,conyugeParameterGeneral,conyugeReturnGeneral);
			
			this.connexion.commit();
			
			return conyugeReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ConyugeParameterReturnGeneral procesarEventosConyuges(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Conyuge> conyuges,Conyuge conyuge,ConyugeParameterReturnGeneral conyugeParameterGeneral,Boolean isEsNuevoConyuge,ArrayList<Classe> clases)throws Exception {
		 try {	
			ConyugeParameterReturnGeneral conyugeReturnGeneral=new ConyugeParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				conyugeReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ConyugeLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,conyuges,conyuge,conyugeParameterGeneral,conyugeReturnGeneral,isEsNuevoConyuge,clases);
			
			return conyugeReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ConyugeParameterReturnGeneral procesarEventosConyugesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Conyuge> conyuges,Conyuge conyuge,ConyugeParameterReturnGeneral conyugeParameterGeneral,Boolean isEsNuevoConyuge,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conyuge.class.getSimpleName()+"-procesarEventosConyugesWithConnection");connexion.begin();			
			
			ConyugeParameterReturnGeneral conyugeReturnGeneral=new ConyugeParameterReturnGeneral();
	
			conyugeReturnGeneral.setConyuge(conyuge);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				conyugeReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ConyugeLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,conyuges,conyuge,conyugeParameterGeneral,conyugeReturnGeneral,isEsNuevoConyuge,clases);
			
			this.connexion.commit();
			
			return conyugeReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ConyugeParameterReturnGeneral procesarImportacionConyugesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ConyugeParameterReturnGeneral conyugeParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conyuge.class.getSimpleName()+"-procesarImportacionConyugesWithConnection");connexion.begin();			
			
			ConyugeParameterReturnGeneral conyugeReturnGeneral=new ConyugeParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.conyuges=new ArrayList<Conyuge>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.conyuge=new Conyuge();
				
				
				if(conColumnasBase) {this.conyuge.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.conyuge.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.conyuge.setidentificacion(arrColumnas[iColumn++]);
				this.conyuge.setapellidopaterno(arrColumnas[iColumn++]);
				this.conyuge.setapellidomaterno(arrColumnas[iColumn++]);
				this.conyuge.setprimernombre(arrColumnas[iColumn++]);
				this.conyuge.setsegundonombre(arrColumnas[iColumn++]);
			this.conyuge.setnombrecorto(arrColumnas[iColumn++]);
				this.conyuge.setesactivo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.conyuges.add(this.conyuge);
			}
			
			this.saveConyuges();
			
			this.connexion.commit();
			
			conyugeReturnGeneral.setConRetornoEstaProcesado(true);
			conyugeReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return conyugeReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarConyugesEliminados() throws Exception {				
		
		List<Conyuge> conyugesAux= new ArrayList<Conyuge>();
		
		for(Conyuge conyuge:conyuges) {
			if(!conyuge.getIsDeleted()) {
				conyugesAux.add(conyuge);
			}
		}
		
		conyuges=conyugesAux;
	}
	
	public void quitarConyugesNulos() throws Exception {				
		
		List<Conyuge> conyugesAux= new ArrayList<Conyuge>();
		
		for(Conyuge conyuge : this.conyuges) {
			if(conyuge==null) {
				conyugesAux.add(conyuge);
			}
		}
		
		//this.conyuges=conyugesAux;
		
		this.conyuges.removeAll(conyugesAux);
	}
	
	public void getSetVersionRowConyugeWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(conyuge.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((conyuge.getIsDeleted() || (conyuge.getIsChanged()&&!conyuge.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=conyugeDataAccess.getSetVersionRowConyuge(connexion,conyuge.getId());
				
				if(!conyuge.getVersionRow().equals(timestamp)) {	
					conyuge.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				conyuge.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowConyuge()throws Exception {	
		
		if(conyuge.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((conyuge.getIsDeleted() || (conyuge.getIsChanged()&&!conyuge.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=conyugeDataAccess.getSetVersionRowConyuge(connexion,conyuge.getId());
			
			try {							
				if(!conyuge.getVersionRow().equals(timestamp)) {	
					conyuge.setVersionRow(timestamp);
				}
				
				conyuge.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowConyugesWithConnection()throws Exception {	
		if(conyuges!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Conyuge conyugeAux:conyuges) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(conyugeAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(conyugeAux.getIsDeleted() || (conyugeAux.getIsChanged()&&!conyugeAux.getIsNew())) {
						
						timestamp=conyugeDataAccess.getSetVersionRowConyuge(connexion,conyugeAux.getId());
						
						if(!conyuge.getVersionRow().equals(timestamp)) {	
							conyugeAux.setVersionRow(timestamp);
						}
								
						conyugeAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowConyuges()throws Exception {	
		if(conyuges!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Conyuge conyugeAux:conyuges) {
					if(conyugeAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(conyugeAux.getIsDeleted() || (conyugeAux.getIsChanged()&&!conyugeAux.getIsNew())) {
						
						timestamp=conyugeDataAccess.getSetVersionRowConyuge(connexion,conyugeAux.getId());
						
						if(!conyugeAux.getVersionRow().equals(timestamp)) {	
							conyugeAux.setVersionRow(timestamp);
						}
						
													
						conyugeAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ConyugeParameterReturnGeneral cargarCombosLoteForeignKeyConyugeWithConnection(String finalQueryGlobalCliente,String finalQueryGlobalTipoIdentificacion) throws Exception {
		ConyugeParameterReturnGeneral  conyugeReturnGeneral =new ConyugeParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conyuge.class.getSimpleName()+"-cargarCombosLoteForeignKeyConyugeWithConnection");connexion.begin();
			
			conyugeReturnGeneral =new ConyugeParameterReturnGeneral();
			
			

			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			conyugeReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoIdentificacion> tipoidentificacionsForeignKey=new ArrayList<TipoIdentificacion>();
			TipoIdentificacionLogic tipoidentificacionLogic=new TipoIdentificacionLogic();
			tipoidentificacionLogic.setConnexion(this.connexion);
			tipoidentificacionLogic.getTipoIdentificacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIdentificacion.equals("NONE")) {
				tipoidentificacionLogic.getTodosTipoIdentificacions(finalQueryGlobalTipoIdentificacion,new Pagination());
				tipoidentificacionsForeignKey=tipoidentificacionLogic.getTipoIdentificacions();
			}

			conyugeReturnGeneral.settipoidentificacionsForeignKey(tipoidentificacionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return conyugeReturnGeneral;
	}
	
	public ConyugeParameterReturnGeneral cargarCombosLoteForeignKeyConyuge(String finalQueryGlobalCliente,String finalQueryGlobalTipoIdentificacion) throws Exception {
		ConyugeParameterReturnGeneral  conyugeReturnGeneral =new ConyugeParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			conyugeReturnGeneral =new ConyugeParameterReturnGeneral();
			
			

			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			conyugeReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoIdentificacion> tipoidentificacionsForeignKey=new ArrayList<TipoIdentificacion>();
			TipoIdentificacionLogic tipoidentificacionLogic=new TipoIdentificacionLogic();
			tipoidentificacionLogic.setConnexion(this.connexion);
			tipoidentificacionLogic.getTipoIdentificacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIdentificacion.equals("NONE")) {
				tipoidentificacionLogic.getTodosTipoIdentificacions(finalQueryGlobalTipoIdentificacion,new Pagination());
				tipoidentificacionsForeignKey=tipoidentificacionLogic.getTipoIdentificacions();
			}

			conyugeReturnGeneral.settipoidentificacionsForeignKey(tipoidentificacionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return conyugeReturnGeneral;
	}
	
	
	public void deepLoad(Conyuge conyuge,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ConyugeLogicAdditional.updateConyugeToGet(conyuge,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		conyuge.setCliente(conyugeDataAccess.getCliente(connexion,conyuge));
		conyuge.setTipoIdentificacion(conyugeDataAccess.getTipoIdentificacion(connexion,conyuge));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				conyuge.setCliente(conyugeDataAccess.getCliente(connexion,conyuge));
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				conyuge.setTipoIdentificacion(conyugeDataAccess.getTipoIdentificacion(connexion,conyuge));
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
			conyuge.setCliente(conyugeDataAccess.getCliente(connexion,conyuge));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIdentificacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conyuge.setTipoIdentificacion(conyugeDataAccess.getTipoIdentificacion(connexion,conyuge));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		conyuge.setCliente(conyugeDataAccess.getCliente(connexion,conyuge));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(conyuge.getCliente(),isDeep,deepLoadType,clases);
				
		conyuge.setTipoIdentificacion(conyugeDataAccess.getTipoIdentificacion(connexion,conyuge));
		TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
		tipoidentificacionLogic.deepLoad(conyuge.getTipoIdentificacion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				conyuge.setCliente(conyugeDataAccess.getCliente(connexion,conyuge));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(conyuge.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				conyuge.setTipoIdentificacion(conyugeDataAccess.getTipoIdentificacion(connexion,conyuge));
				TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
				tipoidentificacionLogic.deepLoad(conyuge.getTipoIdentificacion(),isDeep,deepLoadType,clases);				
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
			conyuge.setCliente(conyugeDataAccess.getCliente(connexion,conyuge));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(conyuge.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIdentificacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			conyuge.setTipoIdentificacion(conyugeDataAccess.getTipoIdentificacion(connexion,conyuge));
			TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
			tipoidentificacionLogic.deepLoad(conyuge.getTipoIdentificacion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Conyuge conyuge,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ConyugeLogicAdditional.updateConyugeToSave(conyuge,this.arrDatoGeneral);
			
ConyugeDataAccess.save(conyuge, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ClienteDataAccess.save(conyuge.getCliente(),connexion);

		TipoIdentificacionDataAccess.save(conyuge.getTipoIdentificacion(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(conyuge.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				TipoIdentificacionDataAccess.save(conyuge.getTipoIdentificacion(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ClienteDataAccess.save(conyuge.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(conyuge.getCliente(),isDeep,deepLoadType,clases);
				

		TipoIdentificacionDataAccess.save(conyuge.getTipoIdentificacion(),connexion);
		TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
		tipoidentificacionLogic.deepLoad(conyuge.getTipoIdentificacion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(conyuge.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(conyuge.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				TipoIdentificacionDataAccess.save(conyuge.getTipoIdentificacion(),connexion);
				TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
				tipoidentificacionLogic.deepSave(conyuge.getTipoIdentificacion(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(Conyuge.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(conyuge,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(conyuge);
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
			this.deepLoad(this.conyuge,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(this.conyuge);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Conyuge.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(conyuges!=null) {
				for(Conyuge conyuge:conyuges) {
					this.deepLoad(conyuge,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(conyuges);
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
			if(conyuges!=null) {
				for(Conyuge conyuge:conyuges) {
					this.deepLoad(conyuge,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(conyuges);
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
			this.getNewConnexionToDeep(Conyuge.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(conyuge,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Conyuge.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(conyuges!=null) {
				for(Conyuge conyuge:conyuges) {
					this.deepSave(conyuge,isDeep,deepLoadType,clases);
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
			if(conyuges!=null) {
				for(Conyuge conyuge:conyuges) {
					this.deepSave(conyuge,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getConyugesFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conyuge.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ConyugeConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			ConyugeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			conyuges=conyugeDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(this.conyuges);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConyugesFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ConyugeConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			ConyugeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			conyuges=conyugeDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(this.conyuges);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getConyugesFK_IdValorIdentificacionWithConnection(String sFinalQuery,Pagination pagination,Long idvaloridentificacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Conyuge.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIdentificacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIdentificacion.setParameterSelectionGeneralEqual(ParameterType.LONG,idvaloridentificacion,ConyugeConstantesFunciones.IDTIPOIDENTIFICACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIdentificacion);

			ConyugeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorIdentificacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			conyuges=conyugeDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(this.conyuges);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getConyugesFK_IdValorIdentificacion(String sFinalQuery,Pagination pagination,Long idvaloridentificacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIdentificacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIdentificacion.setParameterSelectionGeneralEqual(ParameterType.LONG,idvaloridentificacion,ConyugeConstantesFunciones.IDTIPOIDENTIFICACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIdentificacion);

			ConyugeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorIdentificacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			conyuges=conyugeDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(this.conyuges);
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
			if(ConyugeConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ConyugeDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Conyuge conyuge,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ConyugeConstantesFunciones.ISCONAUDITORIA) {
				if(conyuge.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConyugeDataAccess.TABLENAME, conyuge.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ConyugeConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ConyugeLogic.registrarAuditoriaDetallesConyuge(connexion,conyuge,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(conyuge.getIsDeleted()) {
					/*if(!conyuge.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ConyugeDataAccess.TABLENAME, conyuge.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ConyugeLogic.registrarAuditoriaDetallesConyuge(connexion,conyuge,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConyugeDataAccess.TABLENAME, conyuge.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(conyuge.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ConyugeDataAccess.TABLENAME, conyuge.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ConyugeConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ConyugeLogic.registrarAuditoriaDetallesConyuge(connexion,conyuge,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesConyuge(Connexion connexion,Conyuge conyuge)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(conyuge.getIsNew()||!conyuge.getidvaloridentificacion().equals(conyuge.getConyugeOriginal().getidvaloridentificacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(conyuge.getConyugeOriginal().getidvaloridentificacion()!=null)
				{
					strValorActual=conyuge.getConyugeOriginal().getidvaloridentificacion().toString();
				}
				if(conyuge.getidvaloridentificacion()!=null)
				{
					strValorNuevo=conyuge.getidvaloridentificacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConyugeConstantesFunciones.IDTIPOIDENTIFICACION,strValorActual,strValorNuevo);
			}	
			
			if(conyuge.getIsNew()||!conyuge.getidentificacion().equals(conyuge.getConyugeOriginal().getidentificacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(conyuge.getConyugeOriginal().getidentificacion()!=null)
				{
					strValorActual=conyuge.getConyugeOriginal().getidentificacion();
				}
				if(conyuge.getidentificacion()!=null)
				{
					strValorNuevo=conyuge.getidentificacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConyugeConstantesFunciones.IDENTIFICACION,strValorActual,strValorNuevo);
			}	
			
			if(conyuge.getIsNew()||!conyuge.getapellidopaterno().equals(conyuge.getConyugeOriginal().getapellidopaterno()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(conyuge.getConyugeOriginal().getapellidopaterno()!=null)
				{
					strValorActual=conyuge.getConyugeOriginal().getapellidopaterno();
				}
				if(conyuge.getapellidopaterno()!=null)
				{
					strValorNuevo=conyuge.getapellidopaterno() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConyugeConstantesFunciones.APELLIDOPATERNO,strValorActual,strValorNuevo);
			}	
			
			if(conyuge.getIsNew()||!conyuge.getapellidomaterno().equals(conyuge.getConyugeOriginal().getapellidomaterno()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(conyuge.getConyugeOriginal().getapellidomaterno()!=null)
				{
					strValorActual=conyuge.getConyugeOriginal().getapellidomaterno();
				}
				if(conyuge.getapellidomaterno()!=null)
				{
					strValorNuevo=conyuge.getapellidomaterno() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConyugeConstantesFunciones.APELLIDOMATERNO,strValorActual,strValorNuevo);
			}	
			
			if(conyuge.getIsNew()||!conyuge.getprimernombre().equals(conyuge.getConyugeOriginal().getprimernombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(conyuge.getConyugeOriginal().getprimernombre()!=null)
				{
					strValorActual=conyuge.getConyugeOriginal().getprimernombre();
				}
				if(conyuge.getprimernombre()!=null)
				{
					strValorNuevo=conyuge.getprimernombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConyugeConstantesFunciones.PRIMERNOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(conyuge.getIsNew()||!conyuge.getsegundonombre().equals(conyuge.getConyugeOriginal().getsegundonombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(conyuge.getConyugeOriginal().getsegundonombre()!=null)
				{
					strValorActual=conyuge.getConyugeOriginal().getsegundonombre();
				}
				if(conyuge.getsegundonombre()!=null)
				{
					strValorNuevo=conyuge.getsegundonombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConyugeConstantesFunciones.SEGUNDONOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(conyuge.getIsNew()||!conyuge.getnombrecorto().equals(conyuge.getConyugeOriginal().getnombrecorto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(conyuge.getConyugeOriginal().getnombrecorto()!=null)
				{
					strValorActual=conyuge.getConyugeOriginal().getnombrecorto();
				}
				if(conyuge.getnombrecorto()!=null)
				{
					strValorNuevo=conyuge.getnombrecorto() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConyugeConstantesFunciones.NOMBRECORTO,strValorActual,strValorNuevo);
			}	
			
			if(conyuge.getIsNew()||!conyuge.getesactivo().equals(conyuge.getConyugeOriginal().getesactivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(conyuge.getConyugeOriginal().getesactivo()!=null)
				{
					strValorActual=conyuge.getConyugeOriginal().getesactivo().toString();
				}
				if(conyuge.getesactivo()!=null)
				{
					strValorNuevo=conyuge.getesactivo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ConyugeConstantesFunciones.ESACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveConyugeRelacionesWithConnection(Conyuge conyuge) throws Exception {

		if(!conyuge.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveConyugeRelacionesBase(conyuge,true);
		}
	}

	public void saveConyugeRelaciones(Conyuge conyuge)throws Exception {

		if(!conyuge.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveConyugeRelacionesBase(conyuge,false);
		}
	}

	public void saveConyugeRelacionesBase(Conyuge conyuge,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Conyuge-saveRelacionesWithConnection");}
	

			this.setConyuge(conyuge);

				if((conyuge.getIsNew()||conyuge.getIsChanged())&&!conyuge.getIsDeleted()) {
					this.saveConyuge();
					this.saveConyugeRelacionesDetalles();

				} else if(conyuge.getIsDeleted()) {
					this.saveConyugeRelacionesDetalles();
					this.saveConyuge();
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
	
	
	private void saveConyugeRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfConyuge(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ConyugeConstantesFunciones.getClassesForeignKeysOfConyuge(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConyuge(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ConyugeConstantesFunciones.getClassesRelationshipsOfConyuge(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

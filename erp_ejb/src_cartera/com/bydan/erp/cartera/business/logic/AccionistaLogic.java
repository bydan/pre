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
import com.bydan.erp.cartera.util.AccionistaConstantesFunciones;
import com.bydan.erp.cartera.util.AccionistaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.AccionistaParameterGeneral;
import com.bydan.erp.cartera.business.entity.Accionista;
import com.bydan.erp.cartera.business.logic.AccionistaLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class AccionistaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(AccionistaLogic.class);
	
	protected AccionistaDataAccess accionistaDataAccess; 	
	protected Accionista accionista;
	protected List<Accionista> accionistas;
	protected Object accionistaObject;	
	protected List<Object> accionistasObject;
	
	public static ClassValidator<Accionista> accionistaValidator = new ClassValidator<Accionista>(Accionista.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected AccionistaLogicAdditional accionistaLogicAdditional=null;
	
	public AccionistaLogicAdditional getAccionistaLogicAdditional() {
		return this.accionistaLogicAdditional;
	}
	
	public void setAccionistaLogicAdditional(AccionistaLogicAdditional accionistaLogicAdditional) {
		try {
			this.accionistaLogicAdditional=accionistaLogicAdditional;
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
	
	
	
	
	public  AccionistaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.accionistaDataAccess = new AccionistaDataAccess();
			
			this.accionistas= new ArrayList<Accionista>();
			this.accionista= new Accionista();
			
			this.accionistaObject=new Object();
			this.accionistasObject=new ArrayList<Object>();
				
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
			
			this.accionistaDataAccess.setConnexionType(this.connexionType);
			this.accionistaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  AccionistaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.accionistaDataAccess = new AccionistaDataAccess();
			this.accionistas= new ArrayList<Accionista>();
			this.accionista= new Accionista();
			this.accionistaObject=new Object();
			this.accionistasObject=new ArrayList<Object>();
			
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
			
			this.accionistaDataAccess.setConnexionType(this.connexionType);
			this.accionistaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Accionista getAccionista() throws Exception {	
		AccionistaLogicAdditional.checkAccionistaToGet(accionista,this.datosCliente,this.arrDatoGeneral);
		AccionistaLogicAdditional.updateAccionistaToGet(accionista,this.arrDatoGeneral);
		
		return accionista;
	}
		
	public void setAccionista(Accionista newAccionista) {
		this.accionista = newAccionista;
	}
	
	public AccionistaDataAccess getAccionistaDataAccess() {
		return accionistaDataAccess;
	}
	
	public void setAccionistaDataAccess(AccionistaDataAccess newaccionistaDataAccess) {
		this.accionistaDataAccess = newaccionistaDataAccess;
	}
	
	public List<Accionista> getAccionistas() throws Exception {		
		this.quitarAccionistasNulos();
		
		AccionistaLogicAdditional.checkAccionistaToGets(accionistas,this.datosCliente,this.arrDatoGeneral);
		
		for (Accionista accionistaLocal: accionistas ) {
			AccionistaLogicAdditional.updateAccionistaToGet(accionistaLocal,this.arrDatoGeneral);
		}
		
		return accionistas;
	}
	
	public void setAccionistas(List<Accionista> newAccionistas) {
		this.accionistas = newAccionistas;
	}
	
	public Object getAccionistaObject() {	
		this.accionistaObject=this.accionistaDataAccess.getEntityObject();
		return this.accionistaObject;
	}
		
	public void setAccionistaObject(Object newAccionistaObject) {
		this.accionistaObject = newAccionistaObject;
	}
	
	public List<Object> getAccionistasObject() {		
		this.accionistasObject=this.accionistaDataAccess.getEntitiesObject();
		return this.accionistasObject;
	}
		
	public void setAccionistasObject(List<Object> newAccionistasObject) {
		this.accionistasObject = newAccionistasObject;
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
		
		if(this.accionistaDataAccess!=null) {
			this.accionistaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accionista.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			accionistaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			accionistaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		accionista = new  Accionista();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accionista.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			accionista=accionistaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.accionista,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionista);
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
		accionista = new  Accionista();
		  		  
        try {
			
			accionista=accionistaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.accionista,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionista);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		accionista = new  Accionista();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accionista.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			accionista=accionistaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.accionista,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionista);
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
		accionista = new  Accionista();
		  		  
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
		accionista = new  Accionista();
		  		  
        try {
			
			accionista=accionistaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.accionista,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionista);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		accionista = new  Accionista();
		  		  
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
		accionista = new  Accionista();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accionista.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =accionistaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		accionista = new  Accionista();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=accionistaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		accionista = new  Accionista();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accionista.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =accionistaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		accionista = new  Accionista();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=accionistaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		accionista = new  Accionista();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accionista.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =accionistaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		accionista = new  Accionista();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=accionistaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		accionistas = new  ArrayList<Accionista>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accionista.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accionistas=accionistaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAccionista(accionistas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionistas);
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
		accionistas = new  ArrayList<Accionista>();
		  		  
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
		accionistas = new  ArrayList<Accionista>();
		  		  
        try {			
			AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accionistas=accionistaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarAccionista(accionistas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionistas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		accionistas = new  ArrayList<Accionista>();
		  		  
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
		accionistas = new  ArrayList<Accionista>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accionista.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accionistas=accionistaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAccionista(accionistas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionistas);
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
		accionistas = new  ArrayList<Accionista>();
		  		  
        try {
			AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accionistas=accionistaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAccionista(accionistas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionistas);
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
		accionistas = new  ArrayList<Accionista>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accionista.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accionistas=accionistaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAccionista(accionistas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionistas);
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
		accionistas = new  ArrayList<Accionista>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accionistas=accionistaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAccionista(accionistas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionistas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		accionista = new  Accionista();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accionista.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accionista=accionistaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAccionista(accionista);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionista);
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
		accionista = new  Accionista();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accionista=accionistaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAccionista(accionista);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionista);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		accionistas = new  ArrayList<Accionista>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accionista.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accionistas=accionistaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAccionista(accionistas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionistas);
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
		accionistas = new  ArrayList<Accionista>();
		  		  
        try {
			AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accionistas=accionistaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAccionista(accionistas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionistas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosAccionistasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		accionistas = new  ArrayList<Accionista>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accionista.class.getSimpleName()+"-getTodosAccionistasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accionistas=accionistaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAccionista(accionistas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionistas);
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
	
	public  void  getTodosAccionistas(String sFinalQuery,Pagination pagination)throws Exception {
		accionistas = new  ArrayList<Accionista>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accionistas=accionistaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAccionista(accionistas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionistas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarAccionista(Accionista accionista) throws Exception {
		Boolean estaValidado=false;
		
		if(accionista.getIsNew() || accionista.getIsChanged()) { 
			this.invalidValues = accionistaValidator.getInvalidValues(accionista);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(accionista);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarAccionista(List<Accionista> Accionistas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Accionista accionistaLocal:accionistas) {				
			estaValidadoObjeto=this.validarGuardarAccionista(accionistaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarAccionista(List<Accionista> Accionistas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAccionista(accionistas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarAccionista(Accionista Accionista) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAccionista(accionista)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Accionista accionista) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+accionista.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=AccionistaConstantesFunciones.getAccionistaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"accionista","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(AccionistaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(AccionistaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveAccionistaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accionista.class.getSimpleName()+"-saveAccionistaWithConnection");connexion.begin();			
			
			AccionistaLogicAdditional.checkAccionistaToSave(this.accionista,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AccionistaLogicAdditional.updateAccionistaToSave(this.accionista,this.arrDatoGeneral);
			
			AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.accionista,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowAccionista();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAccionista(this.accionista)) {
				AccionistaDataAccess.save(this.accionista, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.accionista,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AccionistaLogicAdditional.checkAccionistaToSaveAfter(this.accionista,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAccionista();
			
			connexion.commit();			
			
			if(this.accionista.getIsDeleted()) {
				this.accionista=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveAccionista()throws Exception {	
		try {	
			
			AccionistaLogicAdditional.checkAccionistaToSave(this.accionista,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AccionistaLogicAdditional.updateAccionistaToSave(this.accionista,this.arrDatoGeneral);
			
			AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.accionista,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAccionista(this.accionista)) {			
				AccionistaDataAccess.save(this.accionista, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.accionista,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AccionistaLogicAdditional.checkAccionistaToSaveAfter(this.accionista,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.accionista.getIsDeleted()) {
				this.accionista=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveAccionistasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accionista.class.getSimpleName()+"-saveAccionistasWithConnection");connexion.begin();			
			
			AccionistaLogicAdditional.checkAccionistaToSaves(accionistas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowAccionistas();
			
			Boolean validadoTodosAccionista=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Accionista accionistaLocal:accionistas) {		
				if(accionistaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AccionistaLogicAdditional.updateAccionistaToSave(accionistaLocal,this.arrDatoGeneral);
	        	
				AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),accionistaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAccionista(accionistaLocal)) {
					AccionistaDataAccess.save(accionistaLocal, connexion);				
				} else {
					validadoTodosAccionista=false;
				}
			}
			
			if(!validadoTodosAccionista) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AccionistaLogicAdditional.checkAccionistaToSavesAfter(accionistas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAccionistas();
			
			connexion.commit();		
			
			this.quitarAccionistasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveAccionistas()throws Exception {				
		 try {	
			AccionistaLogicAdditional.checkAccionistaToSaves(accionistas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosAccionista=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Accionista accionistaLocal:accionistas) {				
				if(accionistaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AccionistaLogicAdditional.updateAccionistaToSave(accionistaLocal,this.arrDatoGeneral);
	        	
				AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),accionistaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAccionista(accionistaLocal)) {				
					AccionistaDataAccess.save(accionistaLocal, connexion);				
				} else {
					validadoTodosAccionista=false;
				}
			}
			
			if(!validadoTodosAccionista) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AccionistaLogicAdditional.checkAccionistaToSavesAfter(accionistas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarAccionistasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AccionistaParameterReturnGeneral procesarAccionAccionistas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Accionista> accionistas,AccionistaParameterReturnGeneral accionistaParameterGeneral)throws Exception {
		 try {	
			AccionistaParameterReturnGeneral accionistaReturnGeneral=new AccionistaParameterReturnGeneral();
	
			AccionistaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,accionistas,accionistaParameterGeneral,accionistaReturnGeneral);
			
			return accionistaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AccionistaParameterReturnGeneral procesarAccionAccionistasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Accionista> accionistas,AccionistaParameterReturnGeneral accionistaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accionista.class.getSimpleName()+"-procesarAccionAccionistasWithConnection");connexion.begin();			
			
			AccionistaParameterReturnGeneral accionistaReturnGeneral=new AccionistaParameterReturnGeneral();
	
			AccionistaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,accionistas,accionistaParameterGeneral,accionistaReturnGeneral);
			
			this.connexion.commit();
			
			return accionistaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AccionistaParameterReturnGeneral procesarEventosAccionistas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Accionista> accionistas,Accionista accionista,AccionistaParameterReturnGeneral accionistaParameterGeneral,Boolean isEsNuevoAccionista,ArrayList<Classe> clases)throws Exception {
		 try {	
			AccionistaParameterReturnGeneral accionistaReturnGeneral=new AccionistaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				accionistaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AccionistaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,accionistas,accionista,accionistaParameterGeneral,accionistaReturnGeneral,isEsNuevoAccionista,clases);
			
			return accionistaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public AccionistaParameterReturnGeneral procesarEventosAccionistasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Accionista> accionistas,Accionista accionista,AccionistaParameterReturnGeneral accionistaParameterGeneral,Boolean isEsNuevoAccionista,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accionista.class.getSimpleName()+"-procesarEventosAccionistasWithConnection");connexion.begin();			
			
			AccionistaParameterReturnGeneral accionistaReturnGeneral=new AccionistaParameterReturnGeneral();
	
			accionistaReturnGeneral.setAccionista(accionista);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				accionistaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AccionistaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,accionistas,accionista,accionistaParameterGeneral,accionistaReturnGeneral,isEsNuevoAccionista,clases);
			
			this.connexion.commit();
			
			return accionistaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AccionistaParameterReturnGeneral procesarImportacionAccionistasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,AccionistaParameterReturnGeneral accionistaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accionista.class.getSimpleName()+"-procesarImportacionAccionistasWithConnection");connexion.begin();			
			
			AccionistaParameterReturnGeneral accionistaReturnGeneral=new AccionistaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.accionistas=new ArrayList<Accionista>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.accionista=new Accionista();
				
				
				if(conColumnasBase) {this.accionista.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.accionista.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.accionista.setidentificacion(arrColumnas[iColumn++]);
				this.accionista.setapellidopaterno(arrColumnas[iColumn++]);
				this.accionista.setapellidomaterno(arrColumnas[iColumn++]);
				this.accionista.setprimernombre(arrColumnas[iColumn++]);
				this.accionista.setsegundonombre(arrColumnas[iColumn++]);
			this.accionista.setnombrecorto(arrColumnas[iColumn++]);
				this.accionista.setparticipacion(Integer.parseInt(arrColumnas[iColumn++]));
				this.accionista.setesactivo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.accionistas.add(this.accionista);
			}
			
			this.saveAccionistas();
			
			this.connexion.commit();
			
			accionistaReturnGeneral.setConRetornoEstaProcesado(true);
			accionistaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return accionistaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarAccionistasEliminados() throws Exception {				
		
		List<Accionista> accionistasAux= new ArrayList<Accionista>();
		
		for(Accionista accionista:accionistas) {
			if(!accionista.getIsDeleted()) {
				accionistasAux.add(accionista);
			}
		}
		
		accionistas=accionistasAux;
	}
	
	public void quitarAccionistasNulos() throws Exception {				
		
		List<Accionista> accionistasAux= new ArrayList<Accionista>();
		
		for(Accionista accionista : this.accionistas) {
			if(accionista==null) {
				accionistasAux.add(accionista);
			}
		}
		
		//this.accionistas=accionistasAux;
		
		this.accionistas.removeAll(accionistasAux);
	}
	
	public void getSetVersionRowAccionistaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(accionista.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((accionista.getIsDeleted() || (accionista.getIsChanged()&&!accionista.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=accionistaDataAccess.getSetVersionRowAccionista(connexion,accionista.getId());
				
				if(!accionista.getVersionRow().equals(timestamp)) {	
					accionista.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				accionista.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowAccionista()throws Exception {	
		
		if(accionista.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((accionista.getIsDeleted() || (accionista.getIsChanged()&&!accionista.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=accionistaDataAccess.getSetVersionRowAccionista(connexion,accionista.getId());
			
			try {							
				if(!accionista.getVersionRow().equals(timestamp)) {	
					accionista.setVersionRow(timestamp);
				}
				
				accionista.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowAccionistasWithConnection()throws Exception {	
		if(accionistas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Accionista accionistaAux:accionistas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(accionistaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(accionistaAux.getIsDeleted() || (accionistaAux.getIsChanged()&&!accionistaAux.getIsNew())) {
						
						timestamp=accionistaDataAccess.getSetVersionRowAccionista(connexion,accionistaAux.getId());
						
						if(!accionista.getVersionRow().equals(timestamp)) {	
							accionistaAux.setVersionRow(timestamp);
						}
								
						accionistaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowAccionistas()throws Exception {	
		if(accionistas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Accionista accionistaAux:accionistas) {
					if(accionistaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(accionistaAux.getIsDeleted() || (accionistaAux.getIsChanged()&&!accionistaAux.getIsNew())) {
						
						timestamp=accionistaDataAccess.getSetVersionRowAccionista(connexion,accionistaAux.getId());
						
						if(!accionistaAux.getVersionRow().equals(timestamp)) {	
							accionistaAux.setVersionRow(timestamp);
						}
						
													
						accionistaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public AccionistaParameterReturnGeneral cargarCombosLoteForeignKeyAccionistaWithConnection(String finalQueryGlobalCliente,String finalQueryGlobalTipoInversion,String finalQueryGlobalTipoIdentificacion) throws Exception {
		AccionistaParameterReturnGeneral  accionistaReturnGeneral =new AccionistaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accionista.class.getSimpleName()+"-cargarCombosLoteForeignKeyAccionistaWithConnection");connexion.begin();
			
			accionistaReturnGeneral =new AccionistaParameterReturnGeneral();
			
			

			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			accionistaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoInversion> tipoinversionsForeignKey=new ArrayList<TipoInversion>();
			TipoInversionLogic tipoinversionLogic=new TipoInversionLogic();
			tipoinversionLogic.setConnexion(this.connexion);
			tipoinversionLogic.getTipoInversionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoInversion.equals("NONE")) {
				tipoinversionLogic.getTodosTipoInversions(finalQueryGlobalTipoInversion,new Pagination());
				tipoinversionsForeignKey=tipoinversionLogic.getTipoInversions();
			}

			accionistaReturnGeneral.settipoinversionsForeignKey(tipoinversionsForeignKey);


			List<TipoIdentificacion> tipoidentificacionsForeignKey=new ArrayList<TipoIdentificacion>();
			TipoIdentificacionLogic tipoidentificacionLogic=new TipoIdentificacionLogic();
			tipoidentificacionLogic.setConnexion(this.connexion);
			tipoidentificacionLogic.getTipoIdentificacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIdentificacion.equals("NONE")) {
				tipoidentificacionLogic.getTodosTipoIdentificacions(finalQueryGlobalTipoIdentificacion,new Pagination());
				tipoidentificacionsForeignKey=tipoidentificacionLogic.getTipoIdentificacions();
			}

			accionistaReturnGeneral.settipoidentificacionsForeignKey(tipoidentificacionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return accionistaReturnGeneral;
	}
	
	public AccionistaParameterReturnGeneral cargarCombosLoteForeignKeyAccionista(String finalQueryGlobalCliente,String finalQueryGlobalTipoInversion,String finalQueryGlobalTipoIdentificacion) throws Exception {
		AccionistaParameterReturnGeneral  accionistaReturnGeneral =new AccionistaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			accionistaReturnGeneral =new AccionistaParameterReturnGeneral();
			
			

			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			accionistaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoInversion> tipoinversionsForeignKey=new ArrayList<TipoInversion>();
			TipoInversionLogic tipoinversionLogic=new TipoInversionLogic();
			tipoinversionLogic.setConnexion(this.connexion);
			tipoinversionLogic.getTipoInversionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoInversion.equals("NONE")) {
				tipoinversionLogic.getTodosTipoInversions(finalQueryGlobalTipoInversion,new Pagination());
				tipoinversionsForeignKey=tipoinversionLogic.getTipoInversions();
			}

			accionistaReturnGeneral.settipoinversionsForeignKey(tipoinversionsForeignKey);


			List<TipoIdentificacion> tipoidentificacionsForeignKey=new ArrayList<TipoIdentificacion>();
			TipoIdentificacionLogic tipoidentificacionLogic=new TipoIdentificacionLogic();
			tipoidentificacionLogic.setConnexion(this.connexion);
			tipoidentificacionLogic.getTipoIdentificacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIdentificacion.equals("NONE")) {
				tipoidentificacionLogic.getTodosTipoIdentificacions(finalQueryGlobalTipoIdentificacion,new Pagination());
				tipoidentificacionsForeignKey=tipoidentificacionLogic.getTipoIdentificacions();
			}

			accionistaReturnGeneral.settipoidentificacionsForeignKey(tipoidentificacionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return accionistaReturnGeneral;
	}
	
	
	public void deepLoad(Accionista accionista,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			AccionistaLogicAdditional.updateAccionistaToGet(accionista,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		accionista.setCliente(accionistaDataAccess.getCliente(connexion,accionista));
		accionista.setTipoInversion(accionistaDataAccess.getTipoInversion(connexion,accionista));
		accionista.setTipoIdentificacion(accionistaDataAccess.getTipoIdentificacion(connexion,accionista));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				accionista.setCliente(accionistaDataAccess.getCliente(connexion,accionista));
				continue;
			}

			if(clas.clas.equals(TipoInversion.class)) {
				accionista.setTipoInversion(accionistaDataAccess.getTipoInversion(connexion,accionista));
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				accionista.setTipoIdentificacion(accionistaDataAccess.getTipoIdentificacion(connexion,accionista));
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
			accionista.setCliente(accionistaDataAccess.getCliente(connexion,accionista));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoInversion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			accionista.setTipoInversion(accionistaDataAccess.getTipoInversion(connexion,accionista));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIdentificacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			accionista.setTipoIdentificacion(accionistaDataAccess.getTipoIdentificacion(connexion,accionista));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		accionista.setCliente(accionistaDataAccess.getCliente(connexion,accionista));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(accionista.getCliente(),isDeep,deepLoadType,clases);
				
		accionista.setTipoInversion(accionistaDataAccess.getTipoInversion(connexion,accionista));
		TipoInversionLogic tipoinversionLogic= new TipoInversionLogic(connexion);
		tipoinversionLogic.deepLoad(accionista.getTipoInversion(),isDeep,deepLoadType,clases);
				
		accionista.setTipoIdentificacion(accionistaDataAccess.getTipoIdentificacion(connexion,accionista));
		TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
		tipoidentificacionLogic.deepLoad(accionista.getTipoIdentificacion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				accionista.setCliente(accionistaDataAccess.getCliente(connexion,accionista));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(accionista.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoInversion.class)) {
				accionista.setTipoInversion(accionistaDataAccess.getTipoInversion(connexion,accionista));
				TipoInversionLogic tipoinversionLogic= new TipoInversionLogic(connexion);
				tipoinversionLogic.deepLoad(accionista.getTipoInversion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				accionista.setTipoIdentificacion(accionistaDataAccess.getTipoIdentificacion(connexion,accionista));
				TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
				tipoidentificacionLogic.deepLoad(accionista.getTipoIdentificacion(),isDeep,deepLoadType,clases);				
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
			accionista.setCliente(accionistaDataAccess.getCliente(connexion,accionista));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(accionista.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoInversion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			accionista.setTipoInversion(accionistaDataAccess.getTipoInversion(connexion,accionista));
			TipoInversionLogic tipoinversionLogic= new TipoInversionLogic(connexion);
			tipoinversionLogic.deepLoad(accionista.getTipoInversion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIdentificacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			accionista.setTipoIdentificacion(accionistaDataAccess.getTipoIdentificacion(connexion,accionista));
			TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
			tipoidentificacionLogic.deepLoad(accionista.getTipoIdentificacion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Accionista accionista,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			AccionistaLogicAdditional.updateAccionistaToSave(accionista,this.arrDatoGeneral);
			
AccionistaDataAccess.save(accionista, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ClienteDataAccess.save(accionista.getCliente(),connexion);

		TipoInversionDataAccess.save(accionista.getTipoInversion(),connexion);

		TipoIdentificacionDataAccess.save(accionista.getTipoIdentificacion(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(accionista.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoInversion.class)) {
				TipoInversionDataAccess.save(accionista.getTipoInversion(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				TipoIdentificacionDataAccess.save(accionista.getTipoIdentificacion(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ClienteDataAccess.save(accionista.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(accionista.getCliente(),isDeep,deepLoadType,clases);
				

		TipoInversionDataAccess.save(accionista.getTipoInversion(),connexion);
		TipoInversionLogic tipoinversionLogic= new TipoInversionLogic(connexion);
		tipoinversionLogic.deepLoad(accionista.getTipoInversion(),isDeep,deepLoadType,clases);
				

		TipoIdentificacionDataAccess.save(accionista.getTipoIdentificacion(),connexion);
		TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
		tipoidentificacionLogic.deepLoad(accionista.getTipoIdentificacion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(accionista.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(accionista.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoInversion.class)) {
				TipoInversionDataAccess.save(accionista.getTipoInversion(),connexion);
				TipoInversionLogic tipoinversionLogic= new TipoInversionLogic(connexion);
				tipoinversionLogic.deepSave(accionista.getTipoInversion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				TipoIdentificacionDataAccess.save(accionista.getTipoIdentificacion(),connexion);
				TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
				tipoidentificacionLogic.deepSave(accionista.getTipoIdentificacion(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(Accionista.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(accionista,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(accionista);
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
			this.deepLoad(this.accionista,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionista);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Accionista.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(accionistas!=null) {
				for(Accionista accionista:accionistas) {
					this.deepLoad(accionista,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(accionistas);
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
			if(accionistas!=null) {
				for(Accionista accionista:accionistas) {
					this.deepLoad(accionista,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(accionistas);
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
			this.getNewConnexionToDeep(Accionista.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(accionista,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Accionista.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(accionistas!=null) {
				for(Accionista accionista:accionistas) {
					this.deepSave(accionista,isDeep,deepLoadType,clases);
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
			if(accionistas!=null) {
				for(Accionista accionista:accionistas) {
					this.deepSave(accionista,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getAccionistasBusquedaPorIdClientePorNombreCortoWithConnection(String sFinalQuery,Pagination pagination,Long idcliente,String nombrecorto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accionista.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,idcliente,AccionistaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ParameterSelectionGeneral parameterSelectionGeneralNombreCorto= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombreCorto.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombrecorto+"%",AccionistaConstantesFunciones.NOMBRECORTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombreCorto);

			AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdClientePorNombreCorto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			accionistas=accionistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionistas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAccionistasBusquedaPorIdClientePorNombreCorto(String sFinalQuery,Pagination pagination,Long idcliente,String nombrecorto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,idcliente,AccionistaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ParameterSelectionGeneral parameterSelectionGeneralNombreCorto= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombreCorto.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombrecorto+"%",AccionistaConstantesFunciones.NOMBRECORTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombreCorto);

			AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdClientePorNombreCorto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			accionistas=accionistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionistas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAccionistasFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long idcliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accionista.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,idcliente,AccionistaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			accionistas=accionistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionistas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAccionistasFK_IdCliente(String sFinalQuery,Pagination pagination,Long idcliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,idcliente,AccionistaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			accionistas=accionistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionistas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAccionistasFK_IdValorClienteInversionWithConnection(String sFinalQuery,Pagination pagination,Long idvalorclienteinversion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accionista.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoInversion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoInversion.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclienteinversion,AccionistaConstantesFunciones.IDTIPOINVERSION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoInversion);

			AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorClienteInversion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			accionistas=accionistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionistas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAccionistasFK_IdValorClienteInversion(String sFinalQuery,Pagination pagination,Long idvalorclienteinversion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoInversion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoInversion.setParameterSelectionGeneralEqual(ParameterType.LONG,idvalorclienteinversion,AccionistaConstantesFunciones.IDTIPOINVERSION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoInversion);

			AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorClienteInversion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			accionistas=accionistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionistas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAccionistasFK_IdValorIdentificacionWithConnection(String sFinalQuery,Pagination pagination,Long idvaloridentificacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accionista.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIdentificacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIdentificacion.setParameterSelectionGeneralEqual(ParameterType.LONG,idvaloridentificacion,AccionistaConstantesFunciones.IDTIPOIDENTIFICACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIdentificacion);

			AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorIdentificacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			accionistas=accionistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionistas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAccionistasFK_IdValorIdentificacion(String sFinalQuery,Pagination pagination,Long idvaloridentificacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIdentificacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIdentificacion.setParameterSelectionGeneralEqual(ParameterType.LONG,idvaloridentificacion,AccionistaConstantesFunciones.IDTIPOIDENTIFICACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIdentificacion);

			AccionistaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorIdentificacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			accionistas=accionistaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(this.accionistas);
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
			if(AccionistaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,AccionistaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Accionista accionista,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(AccionistaConstantesFunciones.ISCONAUDITORIA) {
				if(accionista.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AccionistaDataAccess.TABLENAME, accionista.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AccionistaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AccionistaLogic.registrarAuditoriaDetallesAccionista(connexion,accionista,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(accionista.getIsDeleted()) {
					/*if(!accionista.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,AccionistaDataAccess.TABLENAME, accionista.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////AccionistaLogic.registrarAuditoriaDetallesAccionista(connexion,accionista,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AccionistaDataAccess.TABLENAME, accionista.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(accionista.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AccionistaDataAccess.TABLENAME, accionista.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AccionistaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AccionistaLogic.registrarAuditoriaDetallesAccionista(connexion,accionista,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesAccionista(Connexion connexion,Accionista accionista)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(accionista.getIsNew()||!accionista.getidcliente().equals(accionista.getAccionistaOriginal().getidcliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(accionista.getAccionistaOriginal().getidcliente()!=null)
				{
					strValorActual=accionista.getAccionistaOriginal().getidcliente().toString();
				}
				if(accionista.getidcliente()!=null)
				{
					strValorNuevo=accionista.getidcliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AccionistaConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(accionista.getIsNew()||!accionista.getidvalorclienteinversion().equals(accionista.getAccionistaOriginal().getidvalorclienteinversion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(accionista.getAccionistaOriginal().getidvalorclienteinversion()!=null)
				{
					strValorActual=accionista.getAccionistaOriginal().getidvalorclienteinversion().toString();
				}
				if(accionista.getidvalorclienteinversion()!=null)
				{
					strValorNuevo=accionista.getidvalorclienteinversion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AccionistaConstantesFunciones.IDTIPOINVERSION,strValorActual,strValorNuevo);
			}	
			
			if(accionista.getIsNew()||!accionista.getidvaloridentificacion().equals(accionista.getAccionistaOriginal().getidvaloridentificacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(accionista.getAccionistaOriginal().getidvaloridentificacion()!=null)
				{
					strValorActual=accionista.getAccionistaOriginal().getidvaloridentificacion().toString();
				}
				if(accionista.getidvaloridentificacion()!=null)
				{
					strValorNuevo=accionista.getidvaloridentificacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AccionistaConstantesFunciones.IDTIPOIDENTIFICACION,strValorActual,strValorNuevo);
			}	
			
			if(accionista.getIsNew()||!accionista.getidentificacion().equals(accionista.getAccionistaOriginal().getidentificacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(accionista.getAccionistaOriginal().getidentificacion()!=null)
				{
					strValorActual=accionista.getAccionistaOriginal().getidentificacion();
				}
				if(accionista.getidentificacion()!=null)
				{
					strValorNuevo=accionista.getidentificacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AccionistaConstantesFunciones.IDENTIFICACION,strValorActual,strValorNuevo);
			}	
			
			if(accionista.getIsNew()||!accionista.getapellidopaterno().equals(accionista.getAccionistaOriginal().getapellidopaterno()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(accionista.getAccionistaOriginal().getapellidopaterno()!=null)
				{
					strValorActual=accionista.getAccionistaOriginal().getapellidopaterno();
				}
				if(accionista.getapellidopaterno()!=null)
				{
					strValorNuevo=accionista.getapellidopaterno() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AccionistaConstantesFunciones.APELLIDOPATERNO,strValorActual,strValorNuevo);
			}	
			
			if(accionista.getIsNew()||!accionista.getapellidomaterno().equals(accionista.getAccionistaOriginal().getapellidomaterno()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(accionista.getAccionistaOriginal().getapellidomaterno()!=null)
				{
					strValorActual=accionista.getAccionistaOriginal().getapellidomaterno();
				}
				if(accionista.getapellidomaterno()!=null)
				{
					strValorNuevo=accionista.getapellidomaterno() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AccionistaConstantesFunciones.APELLIDOMATERNO,strValorActual,strValorNuevo);
			}	
			
			if(accionista.getIsNew()||!accionista.getprimernombre().equals(accionista.getAccionistaOriginal().getprimernombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(accionista.getAccionistaOriginal().getprimernombre()!=null)
				{
					strValorActual=accionista.getAccionistaOriginal().getprimernombre();
				}
				if(accionista.getprimernombre()!=null)
				{
					strValorNuevo=accionista.getprimernombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AccionistaConstantesFunciones.PRIMERNOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(accionista.getIsNew()||!accionista.getsegundonombre().equals(accionista.getAccionistaOriginal().getsegundonombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(accionista.getAccionistaOriginal().getsegundonombre()!=null)
				{
					strValorActual=accionista.getAccionistaOriginal().getsegundonombre();
				}
				if(accionista.getsegundonombre()!=null)
				{
					strValorNuevo=accionista.getsegundonombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AccionistaConstantesFunciones.SEGUNDONOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(accionista.getIsNew()||!accionista.getnombrecorto().equals(accionista.getAccionistaOriginal().getnombrecorto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(accionista.getAccionistaOriginal().getnombrecorto()!=null)
				{
					strValorActual=accionista.getAccionistaOriginal().getnombrecorto();
				}
				if(accionista.getnombrecorto()!=null)
				{
					strValorNuevo=accionista.getnombrecorto() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AccionistaConstantesFunciones.NOMBRECORTO,strValorActual,strValorNuevo);
			}	
			
			if(accionista.getIsNew()||!accionista.getparticipacion().equals(accionista.getAccionistaOriginal().getparticipacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(accionista.getAccionistaOriginal().getparticipacion()!=null)
				{
					strValorActual=accionista.getAccionistaOriginal().getparticipacion().toString();
				}
				if(accionista.getparticipacion()!=null)
				{
					strValorNuevo=accionista.getparticipacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AccionistaConstantesFunciones.PARTICIPACION,strValorActual,strValorNuevo);
			}	
			
			if(accionista.getIsNew()||!accionista.getesactivo().equals(accionista.getAccionistaOriginal().getesactivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(accionista.getAccionistaOriginal().getesactivo()!=null)
				{
					strValorActual=accionista.getAccionistaOriginal().getesactivo().toString();
				}
				if(accionista.getesactivo()!=null)
				{
					strValorNuevo=accionista.getesactivo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AccionistaConstantesFunciones.ESACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveAccionistaRelacionesWithConnection(Accionista accionista) throws Exception {

		if(!accionista.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAccionistaRelacionesBase(accionista,true);
		}
	}

	public void saveAccionistaRelaciones(Accionista accionista)throws Exception {

		if(!accionista.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAccionistaRelacionesBase(accionista,false);
		}
	}

	public void saveAccionistaRelacionesBase(Accionista accionista,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Accionista-saveRelacionesWithConnection");}
	

			this.setAccionista(accionista);

			if(AccionistaLogicAdditional.validarSaveRelaciones(accionista,this)) {

				AccionistaLogicAdditional.updateRelacionesToSave(accionista,this);

				if((accionista.getIsNew()||accionista.getIsChanged())&&!accionista.getIsDeleted()) {
					this.saveAccionista();
					this.saveAccionistaRelacionesDetalles();

				} else if(accionista.getIsDeleted()) {
					this.saveAccionistaRelacionesDetalles();
					this.saveAccionista();
				}

				AccionistaLogicAdditional.updateRelacionesToSaveAfter(accionista,this);

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
	
	
	private void saveAccionistaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfAccionista(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AccionistaConstantesFunciones.getClassesForeignKeysOfAccionista(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAccionista(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AccionistaConstantesFunciones.getClassesRelationshipsOfAccionista(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

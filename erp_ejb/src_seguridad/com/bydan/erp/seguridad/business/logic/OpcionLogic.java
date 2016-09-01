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
package com.bydan.erp.seguridad.business.logic;

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
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.seguridad.util.OpcionConstantesFunciones;
import com.bydan.erp.seguridad.util.OpcionParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.OpcionParameterGeneral;
import com.bydan.erp.seguridad.business.entity.Opcion;
import com.bydan.erp.seguridad.business.logic.OpcionLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class OpcionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(OpcionLogic.class);
	
	protected OpcionDataAccess opcionDataAccess; 	
	protected Opcion opcion;
	protected List<Opcion> opcions;
	protected Object opcionObject;	
	protected List<Object> opcionsObject;
	
	public static ClassValidator<Opcion> opcionValidator = new ClassValidator<Opcion>(Opcion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected OpcionLogicAdditional opcionLogicAdditional=null;
	
	public OpcionLogicAdditional getOpcionLogicAdditional() {
		return this.opcionLogicAdditional;
	}
	
	public void setOpcionLogicAdditional(OpcionLogicAdditional opcionLogicAdditional) {
		try {
			this.opcionLogicAdditional=opcionLogicAdditional;
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
	
	
	
	
	public  OpcionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.opcionDataAccess = new OpcionDataAccess();
			
			this.opcions= new ArrayList<Opcion>();
			this.opcion= new Opcion();
			
			this.opcionObject=new Object();
			this.opcionsObject=new ArrayList<Object>();
				
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
			
			this.opcionDataAccess.setConnexionType(this.connexionType);
			this.opcionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  OpcionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.opcionDataAccess = new OpcionDataAccess();
			this.opcions= new ArrayList<Opcion>();
			this.opcion= new Opcion();
			this.opcionObject=new Object();
			this.opcionsObject=new ArrayList<Object>();
			
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
			
			this.opcionDataAccess.setConnexionType(this.connexionType);
			this.opcionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Opcion getOpcion() throws Exception {	
		OpcionLogicAdditional.checkOpcionToGet(opcion,this.datosCliente,this.arrDatoGeneral);
		OpcionLogicAdditional.updateOpcionToGet(opcion,this.arrDatoGeneral);
		
		return opcion;
	}
		
	public void setOpcion(Opcion newOpcion) {
		this.opcion = newOpcion;
	}
	
	public OpcionDataAccess getOpcionDataAccess() {
		return opcionDataAccess;
	}
	
	public void setOpcionDataAccess(OpcionDataAccess newopcionDataAccess) {
		this.opcionDataAccess = newopcionDataAccess;
	}
	
	public List<Opcion> getOpcions() throws Exception {		
		this.quitarOpcionsNulos();
		
		OpcionLogicAdditional.checkOpcionToGets(opcions,this.datosCliente,this.arrDatoGeneral);
		
		for (Opcion opcionLocal: opcions ) {
			OpcionLogicAdditional.updateOpcionToGet(opcionLocal,this.arrDatoGeneral);
		}
		
		return opcions;
	}
	
	public void setOpcions(List<Opcion> newOpcions) {
		this.opcions = newOpcions;
	}
	
	public Object getOpcionObject() {	
		this.opcionObject=this.opcionDataAccess.getEntityObject();
		return this.opcionObject;
	}
		
	public void setOpcionObject(Object newOpcionObject) {
		this.opcionObject = newOpcionObject;
	}
	
	public List<Object> getOpcionsObject() {		
		this.opcionsObject=this.opcionDataAccess.getEntitiesObject();
		return this.opcionsObject;
	}
		
	public void setOpcionsObject(List<Object> newOpcionsObject) {
		this.opcionsObject = newOpcionsObject;
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
		
		if(this.opcionDataAccess!=null) {
			this.opcionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			opcionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			opcionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		opcion = new  Opcion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			opcion=opcionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.opcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcion);
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
		opcion = new  Opcion();
		  		  
        try {
			
			opcion=opcionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.opcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		opcion = new  Opcion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			opcion=opcionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.opcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcion);
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
		opcion = new  Opcion();
		  		  
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
		opcion = new  Opcion();
		  		  
        try {
			
			opcion=opcionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.opcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		opcion = new  Opcion();
		  		  
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
		opcion = new  Opcion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =opcionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		opcion = new  Opcion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=opcionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		opcion = new  Opcion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =opcionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		opcion = new  Opcion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=opcionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		opcion = new  Opcion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =opcionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		opcion = new  Opcion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=opcionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		opcions = new  ArrayList<Opcion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			opcions=opcionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarOpcion(opcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
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
		opcions = new  ArrayList<Opcion>();
		  		  
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
		opcions = new  ArrayList<Opcion>();
		  		  
        try {			
			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			opcions=opcionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarOpcion(opcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		opcions = new  ArrayList<Opcion>();
		  		  
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
		opcions = new  ArrayList<Opcion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			opcions=opcionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarOpcion(opcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
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
		opcions = new  ArrayList<Opcion>();
		  		  
        try {
			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			opcions=opcionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarOpcion(opcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
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
		opcions = new  ArrayList<Opcion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			opcions=opcionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarOpcion(opcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
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
		opcions = new  ArrayList<Opcion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			opcions=opcionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarOpcion(opcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		opcion = new  Opcion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			opcion=opcionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarOpcion(opcion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcion);
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
		opcion = new  Opcion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			opcion=opcionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarOpcion(opcion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		opcions = new  ArrayList<Opcion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			opcions=opcionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarOpcion(opcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
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
		opcions = new  ArrayList<Opcion>();
		  		  
        try {
			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			opcions=opcionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarOpcion(opcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosOpcionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		opcions = new  ArrayList<Opcion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-getTodosOpcionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			opcions=opcionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarOpcion(opcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
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
	
	public  void  getTodosOpcions(String sFinalQuery,Pagination pagination)throws Exception {
		opcions = new  ArrayList<Opcion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			opcions=opcionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarOpcion(opcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarOpcion(Opcion opcion) throws Exception {
		Boolean estaValidado=false;
		
		if(opcion.getIsNew() || opcion.getIsChanged()) { 
			this.invalidValues = opcionValidator.getInvalidValues(opcion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(opcion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarOpcion(List<Opcion> Opcions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Opcion opcionLocal:opcions) {				
			estaValidadoObjeto=this.validarGuardarOpcion(opcionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarOpcion(List<Opcion> Opcions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarOpcion(opcions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarOpcion(Opcion Opcion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarOpcion(opcion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Opcion opcion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+opcion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=OpcionConstantesFunciones.getOpcionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"opcion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(OpcionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(OpcionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveOpcionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-saveOpcionWithConnection");connexion.begin();			
			
			OpcionLogicAdditional.checkOpcionToSave(this.opcion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			OpcionLogicAdditional.updateOpcionToSave(this.opcion,this.arrDatoGeneral);
			
			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.opcion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowOpcion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarOpcion(this.opcion)) {
				OpcionDataAccess.save(this.opcion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.opcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			OpcionLogicAdditional.checkOpcionToSaveAfter(this.opcion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowOpcion();
			
			connexion.commit();			
			
			if(this.opcion.getIsDeleted()) {
				this.opcion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveOpcion()throws Exception {	
		try {	
			
			OpcionLogicAdditional.checkOpcionToSave(this.opcion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			OpcionLogicAdditional.updateOpcionToSave(this.opcion,this.arrDatoGeneral);
			
			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.opcion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarOpcion(this.opcion)) {			
				OpcionDataAccess.save(this.opcion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.opcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			OpcionLogicAdditional.checkOpcionToSaveAfter(this.opcion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.opcion.getIsDeleted()) {
				this.opcion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveOpcionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-saveOpcionsWithConnection");connexion.begin();			
			
			OpcionLogicAdditional.checkOpcionToSaves(opcions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowOpcions();
			
			Boolean validadoTodosOpcion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Opcion opcionLocal:opcions) {		
				if(opcionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				OpcionLogicAdditional.updateOpcionToSave(opcionLocal,this.arrDatoGeneral);
	        	
				OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),opcionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarOpcion(opcionLocal)) {
					OpcionDataAccess.save(opcionLocal, connexion);				
				} else {
					validadoTodosOpcion=false;
				}
			}
			
			if(!validadoTodosOpcion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			OpcionLogicAdditional.checkOpcionToSavesAfter(opcions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowOpcions();
			
			connexion.commit();		
			
			this.quitarOpcionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveOpcions()throws Exception {				
		 try {	
			OpcionLogicAdditional.checkOpcionToSaves(opcions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosOpcion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Opcion opcionLocal:opcions) {				
				if(opcionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				OpcionLogicAdditional.updateOpcionToSave(opcionLocal,this.arrDatoGeneral);
	        	
				OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),opcionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarOpcion(opcionLocal)) {				
					OpcionDataAccess.save(opcionLocal, connexion);				
				} else {
					validadoTodosOpcion=false;
				}
			}
			
			if(!validadoTodosOpcion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			OpcionLogicAdditional.checkOpcionToSavesAfter(opcions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarOpcionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public OpcionParameterReturnGeneral procesarAccionOpcions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Opcion> opcions,OpcionParameterReturnGeneral opcionParameterGeneral)throws Exception {
		 try {	
			OpcionParameterReturnGeneral opcionReturnGeneral=new OpcionParameterReturnGeneral();
	
			OpcionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,opcions,opcionParameterGeneral,opcionReturnGeneral);
			
			return opcionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public OpcionParameterReturnGeneral procesarAccionOpcionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Opcion> opcions,OpcionParameterReturnGeneral opcionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-procesarAccionOpcionsWithConnection");connexion.begin();			
			
			OpcionParameterReturnGeneral opcionReturnGeneral=new OpcionParameterReturnGeneral();
	
			OpcionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,opcions,opcionParameterGeneral,opcionReturnGeneral);
			
			this.connexion.commit();
			
			return opcionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public OpcionParameterReturnGeneral procesarEventosOpcions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Opcion> opcions,Opcion opcion,OpcionParameterReturnGeneral opcionParameterGeneral,Boolean isEsNuevoOpcion,ArrayList<Classe> clases)throws Exception {
		 try {	
			OpcionParameterReturnGeneral opcionReturnGeneral=new OpcionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				opcionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			OpcionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,opcions,opcion,opcionParameterGeneral,opcionReturnGeneral,isEsNuevoOpcion,clases);
			
			return opcionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public OpcionParameterReturnGeneral procesarEventosOpcionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Opcion> opcions,Opcion opcion,OpcionParameterReturnGeneral opcionParameterGeneral,Boolean isEsNuevoOpcion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-procesarEventosOpcionsWithConnection");connexion.begin();			
			
			OpcionParameterReturnGeneral opcionReturnGeneral=new OpcionParameterReturnGeneral();
	
			opcionReturnGeneral.setOpcion(opcion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				opcionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			OpcionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,opcions,opcion,opcionParameterGeneral,opcionReturnGeneral,isEsNuevoOpcion,clases);
			
			this.connexion.commit();
			
			return opcionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public OpcionParameterReturnGeneral procesarImportacionOpcionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,OpcionParameterReturnGeneral opcionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-procesarImportacionOpcionsWithConnection");connexion.begin();			
			
			OpcionParameterReturnGeneral opcionReturnGeneral=new OpcionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.opcions=new ArrayList<Opcion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.opcion=new Opcion();
				
				
				if(conColumnasBase) {this.opcion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.opcion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.opcion.setcodigo(arrColumnas[iColumn++]);
				this.opcion.setnombre(arrColumnas[iColumn++]);
				this.opcion.settecla(arrColumnas[iColumn++]);
				this.opcion.setposicion(Short.parseShort(arrColumnas[iColumn++]));
				this.opcion.seticon_name(arrColumnas[iColumn++]);
				this.opcion.setnombre_clase(arrColumnas[iColumn++]);
				this.opcion.setsub_modulo(arrColumnas[iColumn++]);
			this.opcion.setpaquete(arrColumnas[iColumn++]);
			this.opcion.setpaquete_original(arrColumnas[iColumn++]);
				this.opcion.setpath_auxiliar(arrColumnas[iColumn++]);
				this.opcion.setes_para_menu(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.opcion.setcon_mostrar_acciones_campo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.opcion.setes_guardar_relaciones(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.opcion.setestado(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.opcions.add(this.opcion);
			}
			
			this.saveOpcions();
			
			this.connexion.commit();
			
			opcionReturnGeneral.setConRetornoEstaProcesado(true);
			opcionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return opcionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarOpcionsEliminados() throws Exception {				
		
		List<Opcion> opcionsAux= new ArrayList<Opcion>();
		
		for(Opcion opcion:opcions) {
			if(!opcion.getIsDeleted()) {
				opcionsAux.add(opcion);
			}
		}
		
		opcions=opcionsAux;
	}
	
	public void quitarOpcionsNulos() throws Exception {				
		
		List<Opcion> opcionsAux= new ArrayList<Opcion>();
		
		for(Opcion opcion : this.opcions) {
			if(opcion==null) {
				opcionsAux.add(opcion);
			}
		}
		
		//this.opcions=opcionsAux;
		
		this.opcions.removeAll(opcionsAux);
	}
	
	public void getSetVersionRowOpcionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(opcion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((opcion.getIsDeleted() || (opcion.getIsChanged()&&!opcion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=opcionDataAccess.getSetVersionRowOpcion(connexion,opcion.getId());
				
				if(!opcion.getVersionRow().equals(timestamp)) {	
					opcion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				opcion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowOpcion()throws Exception {	
		
		if(opcion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((opcion.getIsDeleted() || (opcion.getIsChanged()&&!opcion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=opcionDataAccess.getSetVersionRowOpcion(connexion,opcion.getId());
			
			try {							
				if(!opcion.getVersionRow().equals(timestamp)) {	
					opcion.setVersionRow(timestamp);
				}
				
				opcion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowOpcionsWithConnection()throws Exception {	
		if(opcions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Opcion opcionAux:opcions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(opcionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(opcionAux.getIsDeleted() || (opcionAux.getIsChanged()&&!opcionAux.getIsNew())) {
						
						timestamp=opcionDataAccess.getSetVersionRowOpcion(connexion,opcionAux.getId());
						
						if(!opcion.getVersionRow().equals(timestamp)) {	
							opcionAux.setVersionRow(timestamp);
						}
								
						opcionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowOpcions()throws Exception {	
		if(opcions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Opcion opcionAux:opcions) {
					if(opcionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(opcionAux.getIsDeleted() || (opcionAux.getIsChanged()&&!opcionAux.getIsNew())) {
						
						timestamp=opcionDataAccess.getSetVersionRowOpcion(connexion,opcionAux.getId());
						
						if(!opcionAux.getVersionRow().equals(timestamp)) {	
							opcionAux.setVersionRow(timestamp);
						}
						
													
						opcionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public OpcionParameterReturnGeneral cargarCombosLoteForeignKeyOpcionWithConnection(String finalQueryGlobalSistema,String finalQueryGlobalModulo,String finalQueryGlobalGrupoOpcion,String finalQueryGlobalOpcion,String finalQueryGlobalTipoTeclaMascara) throws Exception {
		OpcionParameterReturnGeneral  opcionReturnGeneral =new OpcionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-cargarCombosLoteForeignKeyOpcionWithConnection");connexion.begin();
			
			opcionReturnGeneral =new OpcionParameterReturnGeneral();
			
			

			List<Sistema> sistemasForeignKey=new ArrayList<Sistema>();
			SistemaLogic sistemaLogic=new SistemaLogic();
			sistemaLogic.setConnexion(this.connexion);
			sistemaLogic.getSistemaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSistema.equals("NONE")) {
				sistemaLogic.getTodosSistemas(finalQueryGlobalSistema,new Pagination());
				sistemasForeignKey=sistemaLogic.getSistemas();
			}

			opcionReturnGeneral.setsistemasForeignKey(sistemasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			opcionReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<GrupoOpcion> grupoopcionsForeignKey=new ArrayList<GrupoOpcion>();
			GrupoOpcionLogic grupoopcionLogic=new GrupoOpcionLogic();
			grupoopcionLogic.setConnexion(this.connexion);
			grupoopcionLogic.getGrupoOpcionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGrupoOpcion.equals("NONE")) {
				grupoopcionLogic.getTodosGrupoOpcions(finalQueryGlobalGrupoOpcion,new Pagination());
				grupoopcionsForeignKey=grupoopcionLogic.getGrupoOpcions();
			}

			opcionReturnGeneral.setgrupoopcionsForeignKey(grupoopcionsForeignKey);


			List<Opcion> opcionsForeignKey=new ArrayList<Opcion>();
			OpcionLogic opcionLogic=new OpcionLogic();
			opcionLogic.setConnexion(this.connexion);
			opcionLogic.getOpcionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOpcion.equals("NONE")) {
				opcionLogic.getTodosOpcions(finalQueryGlobalOpcion,new Pagination());
				opcionsForeignKey=opcionLogic.getOpcions();
			}

			opcionReturnGeneral.setopcionsForeignKey(opcionsForeignKey);


			List<TipoTeclaMascara> tipoteclamascarasForeignKey=new ArrayList<TipoTeclaMascara>();
			TipoTeclaMascaraLogic tipoteclamascaraLogic=new TipoTeclaMascaraLogic();
			tipoteclamascaraLogic.setConnexion(this.connexion);
			tipoteclamascaraLogic.getTipoTeclaMascaraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTeclaMascara.equals("NONE")) {
				tipoteclamascaraLogic.getTodosTipoTeclaMascaras(finalQueryGlobalTipoTeclaMascara,new Pagination());
				tipoteclamascarasForeignKey=tipoteclamascaraLogic.getTipoTeclaMascaras();
			}

			opcionReturnGeneral.settipoteclamascarasForeignKey(tipoteclamascarasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return opcionReturnGeneral;
	}
	
	public OpcionParameterReturnGeneral cargarCombosLoteForeignKeyOpcion(String finalQueryGlobalSistema,String finalQueryGlobalModulo,String finalQueryGlobalGrupoOpcion,String finalQueryGlobalOpcion,String finalQueryGlobalTipoTeclaMascara) throws Exception {
		OpcionParameterReturnGeneral  opcionReturnGeneral =new OpcionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			opcionReturnGeneral =new OpcionParameterReturnGeneral();
			
			

			List<Sistema> sistemasForeignKey=new ArrayList<Sistema>();
			SistemaLogic sistemaLogic=new SistemaLogic();
			sistemaLogic.setConnexion(this.connexion);
			sistemaLogic.getSistemaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSistema.equals("NONE")) {
				sistemaLogic.getTodosSistemas(finalQueryGlobalSistema,new Pagination());
				sistemasForeignKey=sistemaLogic.getSistemas();
			}

			opcionReturnGeneral.setsistemasForeignKey(sistemasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			opcionReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<GrupoOpcion> grupoopcionsForeignKey=new ArrayList<GrupoOpcion>();
			GrupoOpcionLogic grupoopcionLogic=new GrupoOpcionLogic();
			grupoopcionLogic.setConnexion(this.connexion);
			grupoopcionLogic.getGrupoOpcionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGrupoOpcion.equals("NONE")) {
				grupoopcionLogic.getTodosGrupoOpcions(finalQueryGlobalGrupoOpcion,new Pagination());
				grupoopcionsForeignKey=grupoopcionLogic.getGrupoOpcions();
			}

			opcionReturnGeneral.setgrupoopcionsForeignKey(grupoopcionsForeignKey);


			List<Opcion> opcionsForeignKey=new ArrayList<Opcion>();
			OpcionLogic opcionLogic=new OpcionLogic();
			opcionLogic.setConnexion(this.connexion);
			opcionLogic.getOpcionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOpcion.equals("NONE")) {
				opcionLogic.getTodosOpcions(finalQueryGlobalOpcion,new Pagination());
				opcionsForeignKey=opcionLogic.getOpcions();
			}

			opcionReturnGeneral.setopcionsForeignKey(opcionsForeignKey);


			List<TipoTeclaMascara> tipoteclamascarasForeignKey=new ArrayList<TipoTeclaMascara>();
			TipoTeclaMascaraLogic tipoteclamascaraLogic=new TipoTeclaMascaraLogic();
			tipoteclamascaraLogic.setConnexion(this.connexion);
			tipoteclamascaraLogic.getTipoTeclaMascaraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTeclaMascara.equals("NONE")) {
				tipoteclamascaraLogic.getTodosTipoTeclaMascaras(finalQueryGlobalTipoTeclaMascara,new Pagination());
				tipoteclamascarasForeignKey=tipoteclamascaraLogic.getTipoTeclaMascaras();
			}

			opcionReturnGeneral.settipoteclamascarasForeignKey(tipoteclamascarasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return opcionReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyOpcionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			UsuarioOpcionLogic usuarioopcionLogic=new UsuarioOpcionLogic();
			OpcionLogic opcionLogic=new OpcionLogic();
			AccionLogic accionLogic=new AccionLogic();
			PerfilOpcionLogic perfilopcionLogic=new PerfilOpcionLogic();
			CampoLogic campoLogic=new CampoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyOpcionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(UsuarioOpcion.class));
			classes.add(new Classe(Opcion.class));
			classes.add(new Classe(Accion.class));
			classes.add(new Classe(PerfilOpcion.class));
			classes.add(new Classe(Campo.class));
											
			

			usuarioopcionLogic.setConnexion(this.getConnexion());
			usuarioopcionLogic.setDatosCliente(this.datosCliente);
			usuarioopcionLogic.setIsConRefrescarForeignKeys(true);

			opcionLogic.setConnexion(this.getConnexion());
			opcionLogic.setDatosCliente(this.datosCliente);
			opcionLogic.setIsConRefrescarForeignKeys(true);

			accionLogic.setConnexion(this.getConnexion());
			accionLogic.setDatosCliente(this.datosCliente);
			accionLogic.setIsConRefrescarForeignKeys(true);

			perfilopcionLogic.setConnexion(this.getConnexion());
			perfilopcionLogic.setDatosCliente(this.datosCliente);
			perfilopcionLogic.setIsConRefrescarForeignKeys(true);

			campoLogic.setConnexion(this.getConnexion());
			campoLogic.setDatosCliente(this.datosCliente);
			campoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Opcion opcion:this.opcions) {
				

				classes=new ArrayList<Classe>();
				classes=UsuarioOpcionConstantesFunciones.getClassesForeignKeysOfUsuarioOpcion(new ArrayList<Classe>(),DeepLoadType.NONE);

				usuarioopcionLogic.setUsuarioOpcions(opcion.usuarioopcions);
				usuarioopcionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=OpcionConstantesFunciones.getClassesForeignKeysOfOpcion(new ArrayList<Classe>(),DeepLoadType.NONE);

				opcionLogic.setOpcions(opcion.opcions);
				opcionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=AccionConstantesFunciones.getClassesForeignKeysOfAccion(new ArrayList<Classe>(),DeepLoadType.NONE);

				accionLogic.setAccions(opcion.accions);
				accionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PerfilOpcionConstantesFunciones.getClassesForeignKeysOfPerfilOpcion(new ArrayList<Classe>(),DeepLoadType.NONE);

				perfilopcionLogic.setPerfilOpcions(opcion.perfilopcions);
				perfilopcionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CampoConstantesFunciones.getClassesForeignKeysOfCampo(new ArrayList<Classe>(),DeepLoadType.NONE);

				campoLogic.setCampos(opcion.campos);
				campoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Opcion opcion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			OpcionLogicAdditional.updateOpcionToGet(opcion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		opcion.setSistema(opcionDataAccess.getSistema(connexion,opcion));
		opcion.setModulo(opcionDataAccess.getModulo(connexion,opcion));
		opcion.setGrupoOpcion(opcionDataAccess.getGrupoOpcion(connexion,opcion));
		opcion.setOpcion(opcionDataAccess.getOpcion(connexion,opcion));
		opcion.setTipoTeclaMascara(opcionDataAccess.getTipoTeclaMascara(connexion,opcion));
		opcion.setUsuarioOpcions(opcionDataAccess.getUsuarioOpcions(connexion,opcion));
		opcion.setOpcions(opcionDataAccess.getOpcions(connexion,opcion));
		opcion.setAccions(opcionDataAccess.getAccions(connexion,opcion));
		opcion.setPerfilOpcions(opcionDataAccess.getPerfilOpcions(connexion,opcion));
		opcion.setCampos(opcionDataAccess.getCampos(connexion,opcion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				opcion.setSistema(opcionDataAccess.getSistema(connexion,opcion));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				opcion.setModulo(opcionDataAccess.getModulo(connexion,opcion));
				continue;
			}

			if(clas.clas.equals(GrupoOpcion.class)) {
				opcion.setGrupoOpcion(opcionDataAccess.getGrupoOpcion(connexion,opcion));
				continue;
			}

			if(clas.clas.equals(Opcion.class)) {
				opcion.setOpcion(opcionDataAccess.getOpcion(connexion,opcion));
				continue;
			}

			if(clas.clas.equals(TipoTeclaMascara.class)) {
				opcion.setTipoTeclaMascara(opcionDataAccess.getTipoTeclaMascara(connexion,opcion));
				continue;
			}

			if(clas.clas.equals(UsuarioOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				opcion.setUsuarioOpcions(opcionDataAccess.getUsuarioOpcions(connexion,opcion));

				if(this.isConDeep) {
					UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(this.connexion);
					usuarioopcionLogic.setUsuarioOpcions(opcion.getUsuarioOpcions());
					ArrayList<Classe> classesLocal=UsuarioOpcionConstantesFunciones.getClassesForeignKeysOfUsuarioOpcion(new ArrayList<Classe>(),DeepLoadType.NONE);
					usuarioopcionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(usuarioopcionLogic.getUsuarioOpcions());
					opcion.setUsuarioOpcions(usuarioopcionLogic.getUsuarioOpcions());
				}

				continue;
			}

			if(clas.clas.equals(Opcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				opcion.setOpcions(opcionDataAccess.getOpcions(connexion,opcion));

				if(this.isConDeep) {
					OpcionLogic opcionLogic= new OpcionLogic(this.connexion);
					opcionLogic.setOpcions(opcion.getOpcions());
					ArrayList<Classe> classesLocal=OpcionConstantesFunciones.getClassesForeignKeysOfOpcion(new ArrayList<Classe>(),DeepLoadType.NONE);
					opcionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(opcionLogic.getOpcions());
					opcion.setOpcions(opcionLogic.getOpcions());
				}

				continue;
			}

			if(clas.clas.equals(Accion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				opcion.setAccions(opcionDataAccess.getAccions(connexion,opcion));

				if(this.isConDeep) {
					AccionLogic accionLogic= new AccionLogic(this.connexion);
					accionLogic.setAccions(opcion.getAccions());
					ArrayList<Classe> classesLocal=AccionConstantesFunciones.getClassesForeignKeysOfAccion(new ArrayList<Classe>(),DeepLoadType.NONE);
					accionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(accionLogic.getAccions());
					opcion.setAccions(accionLogic.getAccions());
				}

				continue;
			}

			if(clas.clas.equals(PerfilOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				opcion.setPerfilOpcions(opcionDataAccess.getPerfilOpcions(connexion,opcion));

				if(this.isConDeep) {
					PerfilOpcionLogic perfilopcionLogic= new PerfilOpcionLogic(this.connexion);
					perfilopcionLogic.setPerfilOpcions(opcion.getPerfilOpcions());
					ArrayList<Classe> classesLocal=PerfilOpcionConstantesFunciones.getClassesForeignKeysOfPerfilOpcion(new ArrayList<Classe>(),DeepLoadType.NONE);
					perfilopcionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(perfilopcionLogic.getPerfilOpcions());
					opcion.setPerfilOpcions(perfilopcionLogic.getPerfilOpcions());
				}

				continue;
			}

			if(clas.clas.equals(Campo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				opcion.setCampos(opcionDataAccess.getCampos(connexion,opcion));

				if(this.isConDeep) {
					CampoLogic campoLogic= new CampoLogic(this.connexion);
					campoLogic.setCampos(opcion.getCampos());
					ArrayList<Classe> classesLocal=CampoConstantesFunciones.getClassesForeignKeysOfCampo(new ArrayList<Classe>(),DeepLoadType.NONE);
					campoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CampoConstantesFunciones.refrescarForeignKeysDescripcionesCampo(campoLogic.getCampos());
					opcion.setCampos(campoLogic.getCampos());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			opcion.setSistema(opcionDataAccess.getSistema(connexion,opcion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			opcion.setModulo(opcionDataAccess.getModulo(connexion,opcion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoOpcion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			opcion.setGrupoOpcion(opcionDataAccess.getGrupoOpcion(connexion,opcion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Opcion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			opcion.setOpcion(opcionDataAccess.getOpcion(connexion,opcion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTeclaMascara.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			opcion.setTipoTeclaMascara(opcionDataAccess.getTipoTeclaMascara(connexion,opcion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(UsuarioOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(UsuarioOpcion.class));
			opcion.setUsuarioOpcions(opcionDataAccess.getUsuarioOpcions(connexion,opcion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Opcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Opcion.class));
			opcion.setOpcions(opcionDataAccess.getOpcions(connexion,opcion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Accion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Accion.class));
			opcion.setAccions(opcionDataAccess.getAccions(connexion,opcion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PerfilOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PerfilOpcion.class));
			opcion.setPerfilOpcions(opcionDataAccess.getPerfilOpcions(connexion,opcion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Campo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Campo.class));
			opcion.setCampos(opcionDataAccess.getCampos(connexion,opcion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		opcion.setSistema(opcionDataAccess.getSistema(connexion,opcion));
		SistemaLogic sistemaLogic= new SistemaLogic(connexion);
		sistemaLogic.deepLoad(opcion.getSistema(),isDeep,deepLoadType,clases);
				
		opcion.setModulo(opcionDataAccess.getModulo(connexion,opcion));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(opcion.getModulo(),isDeep,deepLoadType,clases);
				
		opcion.setGrupoOpcion(opcionDataAccess.getGrupoOpcion(connexion,opcion));
		GrupoOpcionLogic grupoopcionLogic= new GrupoOpcionLogic(connexion);
		grupoopcionLogic.deepLoad(opcion.getGrupoOpcion(),isDeep,deepLoadType,clases);
				
		opcion.setOpcion(opcionDataAccess.getOpcion(connexion,opcion));
		OpcionLogic opcionLogic= new OpcionLogic(connexion);
		opcionLogic.deepLoad(opcion.getOpcion(),isDeep,deepLoadType,clases);
				
		opcion.setTipoTeclaMascara(opcionDataAccess.getTipoTeclaMascara(connexion,opcion));
		TipoTeclaMascaraLogic tipoteclamascaraLogic= new TipoTeclaMascaraLogic(connexion);
		tipoteclamascaraLogic.deepLoad(opcion.getTipoTeclaMascara(),isDeep,deepLoadType,clases);
				

		opcion.setUsuarioOpcions(opcionDataAccess.getUsuarioOpcions(connexion,opcion));

		for(UsuarioOpcion usuarioopcion:opcion.getUsuarioOpcions()) {
			UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(connexion);
			usuarioopcionLogic.deepLoad(usuarioopcion,isDeep,deepLoadType,clases);
		}

		opcion.setOpcions(opcionDataAccess.getOpcions(connexion,opcion));

		for(Opcion opcionRecursivo:opcion.getOpcions()) {
			OpcionLogic opcionRecursivoLogic= new OpcionLogic(connexion);
			opcionRecursivoLogic.deepLoad(opcionRecursivo,isDeep,deepLoadType,clases);
		}

		opcion.setAccions(opcionDataAccess.getAccions(connexion,opcion));

		for(Accion accion:opcion.getAccions()) {
			AccionLogic accionLogic= new AccionLogic(connexion);
			accionLogic.deepLoad(accion,isDeep,deepLoadType,clases);
		}

		opcion.setPerfilOpcions(opcionDataAccess.getPerfilOpcions(connexion,opcion));

		for(PerfilOpcion perfilopcion:opcion.getPerfilOpcions()) {
			PerfilOpcionLogic perfilopcionLogic= new PerfilOpcionLogic(connexion);
			perfilopcionLogic.deepLoad(perfilopcion,isDeep,deepLoadType,clases);
		}

		opcion.setCampos(opcionDataAccess.getCampos(connexion,opcion));

		for(Campo campo:opcion.getCampos()) {
			CampoLogic campoLogic= new CampoLogic(connexion);
			campoLogic.deepLoad(campo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				opcion.setSistema(opcionDataAccess.getSistema(connexion,opcion));
				SistemaLogic sistemaLogic= new SistemaLogic(connexion);
				sistemaLogic.deepLoad(opcion.getSistema(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				opcion.setModulo(opcionDataAccess.getModulo(connexion,opcion));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(opcion.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GrupoOpcion.class)) {
				opcion.setGrupoOpcion(opcionDataAccess.getGrupoOpcion(connexion,opcion));
				GrupoOpcionLogic grupoopcionLogic= new GrupoOpcionLogic(connexion);
				grupoopcionLogic.deepLoad(opcion.getGrupoOpcion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Opcion.class)) {
				opcion.setOpcion(opcionDataAccess.getOpcion(connexion,opcion));
				OpcionLogic opcionLogic= new OpcionLogic(connexion);
				opcionLogic.deepLoad(opcion.getOpcion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTeclaMascara.class)) {
				opcion.setTipoTeclaMascara(opcionDataAccess.getTipoTeclaMascara(connexion,opcion));
				TipoTeclaMascaraLogic tipoteclamascaraLogic= new TipoTeclaMascaraLogic(connexion);
				tipoteclamascaraLogic.deepLoad(opcion.getTipoTeclaMascara(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(UsuarioOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				opcion.setUsuarioOpcions(opcionDataAccess.getUsuarioOpcions(connexion,opcion));

				for(UsuarioOpcion usuarioopcion:opcion.getUsuarioOpcions()) {
					UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(connexion);
					usuarioopcionLogic.deepLoad(usuarioopcion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Opcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				opcion.setOpcions(opcionDataAccess.getOpcions(connexion,opcion));

				for(Opcion opcionRecursivo:opcion.getOpcions()) {
					OpcionLogic opcionRecursivoLogic= new OpcionLogic(connexion);
					opcionRecursivoLogic.deepLoad(opcionRecursivo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Accion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				opcion.setAccions(opcionDataAccess.getAccions(connexion,opcion));

				for(Accion accion:opcion.getAccions()) {
					AccionLogic accionLogic= new AccionLogic(connexion);
					accionLogic.deepLoad(accion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PerfilOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				opcion.setPerfilOpcions(opcionDataAccess.getPerfilOpcions(connexion,opcion));

				for(PerfilOpcion perfilopcion:opcion.getPerfilOpcions()) {
					PerfilOpcionLogic perfilopcionLogic= new PerfilOpcionLogic(connexion);
					perfilopcionLogic.deepLoad(perfilopcion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Campo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				opcion.setCampos(opcionDataAccess.getCampos(connexion,opcion));

				for(Campo campo:opcion.getCampos()) {
					CampoLogic campoLogic= new CampoLogic(connexion);
					campoLogic.deepLoad(campo,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			opcion.setSistema(opcionDataAccess.getSistema(connexion,opcion));
			SistemaLogic sistemaLogic= new SistemaLogic(connexion);
			sistemaLogic.deepLoad(opcion.getSistema(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			opcion.setModulo(opcionDataAccess.getModulo(connexion,opcion));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(opcion.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoOpcion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			opcion.setGrupoOpcion(opcionDataAccess.getGrupoOpcion(connexion,opcion));
			GrupoOpcionLogic grupoopcionLogic= new GrupoOpcionLogic(connexion);
			grupoopcionLogic.deepLoad(opcion.getGrupoOpcion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Opcion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			opcion.setOpcion(opcionDataAccess.getOpcion(connexion,opcion));
			OpcionLogic opcionLogic= new OpcionLogic(connexion);
			opcionLogic.deepLoad(opcion.getOpcion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTeclaMascara.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			opcion.setTipoTeclaMascara(opcionDataAccess.getTipoTeclaMascara(connexion,opcion));
			TipoTeclaMascaraLogic tipoteclamascaraLogic= new TipoTeclaMascaraLogic(connexion);
			tipoteclamascaraLogic.deepLoad(opcion.getTipoTeclaMascara(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(UsuarioOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(UsuarioOpcion.class));
			opcion.setUsuarioOpcions(opcionDataAccess.getUsuarioOpcions(connexion,opcion));

			for(UsuarioOpcion usuarioopcion:opcion.getUsuarioOpcions()) {
				UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(connexion);
				usuarioopcionLogic.deepLoad(usuarioopcion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Opcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Opcion.class));
			opcion.setOpcions(opcionDataAccess.getOpcions(connexion,opcion));

			for(Opcion opcionRecursivo:opcion.getOpcions()) {
				OpcionLogic opcionRecursivoLogic= new OpcionLogic(connexion);
				opcionRecursivoLogic.deepLoad(opcionRecursivo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Accion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Accion.class));
			opcion.setAccions(opcionDataAccess.getAccions(connexion,opcion));

			for(Accion accion:opcion.getAccions()) {
				AccionLogic accionLogic= new AccionLogic(connexion);
				accionLogic.deepLoad(accion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PerfilOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PerfilOpcion.class));
			opcion.setPerfilOpcions(opcionDataAccess.getPerfilOpcions(connexion,opcion));

			for(PerfilOpcion perfilopcion:opcion.getPerfilOpcions()) {
				PerfilOpcionLogic perfilopcionLogic= new PerfilOpcionLogic(connexion);
				perfilopcionLogic.deepLoad(perfilopcion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Campo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Campo.class));
			opcion.setCampos(opcionDataAccess.getCampos(connexion,opcion));

			for(Campo campo:opcion.getCampos()) {
				CampoLogic campoLogic= new CampoLogic(connexion);
				campoLogic.deepLoad(campo,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Opcion opcion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			OpcionLogicAdditional.updateOpcionToSave(opcion,this.arrDatoGeneral);
			
OpcionDataAccess.save(opcion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		SistemaDataAccess.save(opcion.getSistema(),connexion);

		ModuloDataAccess.save(opcion.getModulo(),connexion);

		GrupoOpcionDataAccess.save(opcion.getGrupoOpcion(),connexion);

		OpcionDataAccess.save(opcion.getOpcion(),connexion);

		TipoTeclaMascaraDataAccess.save(opcion.getTipoTeclaMascara(),connexion);

		for(UsuarioOpcion usuarioopcion:opcion.getUsuarioOpcions()) {
			usuarioopcion.setid_opcion(opcion.getId());
			UsuarioOpcionDataAccess.save(usuarioopcion,connexion);
		}

		for(Opcion opcionRecursivo:opcion.getOpcions()) {
			opcionRecursivo.setid_opcion(opcion.getId());
			OpcionDataAccess.save(opcionRecursivo,connexion);
		}

		for(Accion accion:opcion.getAccions()) {
			accion.setid_opcion(opcion.getId());
			AccionDataAccess.save(accion,connexion);
		}

		for(PerfilOpcion perfilopcion:opcion.getPerfilOpcions()) {
			perfilopcion.setid_opcion(opcion.getId());
			PerfilOpcionDataAccess.save(perfilopcion,connexion);
		}

		for(Campo campo:opcion.getCampos()) {
			campo.setid_opcion(opcion.getId());
			CampoDataAccess.save(campo,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				SistemaDataAccess.save(opcion.getSistema(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(opcion.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(GrupoOpcion.class)) {
				GrupoOpcionDataAccess.save(opcion.getGrupoOpcion(),connexion);
				continue;
			}

			if(clas.clas.equals(Opcion.class)) {
				OpcionDataAccess.save(opcion.getOpcion(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTeclaMascara.class)) {
				TipoTeclaMascaraDataAccess.save(opcion.getTipoTeclaMascara(),connexion);
				continue;
			}


			if(clas.clas.equals(UsuarioOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(UsuarioOpcion usuarioopcion:opcion.getUsuarioOpcions()) {
					usuarioopcion.setid_opcion(opcion.getId());
					UsuarioOpcionDataAccess.save(usuarioopcion,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Opcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Opcion opcionRecursivo:opcion.getOpcions()) {
					opcionRecursivo.setid_opcion(opcion.getId());
					OpcionDataAccess.save(opcionRecursivo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Accion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Accion accion:opcion.getAccions()) {
					accion.setid_opcion(opcion.getId());
					AccionDataAccess.save(accion,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PerfilOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PerfilOpcion perfilopcion:opcion.getPerfilOpcions()) {
					perfilopcion.setid_opcion(opcion.getId());
					PerfilOpcionDataAccess.save(perfilopcion,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Campo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Campo campo:opcion.getCampos()) {
					campo.setid_opcion(opcion.getId());
					CampoDataAccess.save(campo,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		SistemaDataAccess.save(opcion.getSistema(),connexion);
		SistemaLogic sistemaLogic= new SistemaLogic(connexion);
		sistemaLogic.deepLoad(opcion.getSistema(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(opcion.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(opcion.getModulo(),isDeep,deepLoadType,clases);
				

		GrupoOpcionDataAccess.save(opcion.getGrupoOpcion(),connexion);
		GrupoOpcionLogic grupoopcionLogic= new GrupoOpcionLogic(connexion);
		grupoopcionLogic.deepLoad(opcion.getGrupoOpcion(),isDeep,deepLoadType,clases);
				

		OpcionDataAccess.save(opcion.getOpcion(),connexion);
		OpcionLogic opcionLogic= new OpcionLogic(connexion);
		opcionLogic.deepLoad(opcion.getOpcion(),isDeep,deepLoadType,clases);
				

		TipoTeclaMascaraDataAccess.save(opcion.getTipoTeclaMascara(),connexion);
		TipoTeclaMascaraLogic tipoteclamascaraLogic= new TipoTeclaMascaraLogic(connexion);
		tipoteclamascaraLogic.deepLoad(opcion.getTipoTeclaMascara(),isDeep,deepLoadType,clases);
				

		for(UsuarioOpcion usuarioopcion:opcion.getUsuarioOpcions()) {
			UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(connexion);
			usuarioopcion.setid_opcion(opcion.getId());
			UsuarioOpcionDataAccess.save(usuarioopcion,connexion);
			usuarioopcionLogic.deepSave(usuarioopcion,isDeep,deepLoadType,clases);
		}

		for(Opcion opcionRecursivo:opcion.getOpcions()) {
			OpcionLogic opcionRecursivoLogic= new OpcionLogic(connexion);
			opcionRecursivo.setid_opcion(opcion.getId());
			OpcionDataAccess.save(opcionRecursivo,connexion);
			opcionRecursivoLogic.deepSave(opcionRecursivo,isDeep,deepLoadType,clases);
		}

		for(Accion accion:opcion.getAccions()) {
			AccionLogic accionLogic= new AccionLogic(connexion);
			accion.setid_opcion(opcion.getId());
			AccionDataAccess.save(accion,connexion);
			accionLogic.deepSave(accion,isDeep,deepLoadType,clases);
		}

		for(PerfilOpcion perfilopcion:opcion.getPerfilOpcions()) {
			PerfilOpcionLogic perfilopcionLogic= new PerfilOpcionLogic(connexion);
			perfilopcion.setid_opcion(opcion.getId());
			PerfilOpcionDataAccess.save(perfilopcion,connexion);
			perfilopcionLogic.deepSave(perfilopcion,isDeep,deepLoadType,clases);
		}

		for(Campo campo:opcion.getCampos()) {
			CampoLogic campoLogic= new CampoLogic(connexion);
			campo.setid_opcion(opcion.getId());
			CampoDataAccess.save(campo,connexion);
			campoLogic.deepSave(campo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				SistemaDataAccess.save(opcion.getSistema(),connexion);
				SistemaLogic sistemaLogic= new SistemaLogic(connexion);
				sistemaLogic.deepSave(opcion.getSistema(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(opcion.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(opcion.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GrupoOpcion.class)) {
				GrupoOpcionDataAccess.save(opcion.getGrupoOpcion(),connexion);
				GrupoOpcionLogic grupoopcionLogic= new GrupoOpcionLogic(connexion);
				grupoopcionLogic.deepSave(opcion.getGrupoOpcion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Opcion.class)) {
				OpcionDataAccess.save(opcion.getOpcion(),connexion);
				OpcionLogic opcionLogic= new OpcionLogic(connexion);
				opcionLogic.deepSave(opcion.getOpcion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTeclaMascara.class)) {
				TipoTeclaMascaraDataAccess.save(opcion.getTipoTeclaMascara(),connexion);
				TipoTeclaMascaraLogic tipoteclamascaraLogic= new TipoTeclaMascaraLogic(connexion);
				tipoteclamascaraLogic.deepSave(opcion.getTipoTeclaMascara(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(UsuarioOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(UsuarioOpcion usuarioopcion:opcion.getUsuarioOpcions()) {
					UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(connexion);
					usuarioopcion.setid_opcion(opcion.getId());
					UsuarioOpcionDataAccess.save(usuarioopcion,connexion);
					usuarioopcionLogic.deepSave(usuarioopcion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Opcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Opcion opcionRecursivo:opcion.getOpcions()) {
					OpcionLogic opcionRecursivoLogic= new OpcionLogic(connexion);
					opcionRecursivo.setid_opcion(opcion.getId());
					OpcionDataAccess.save(opcionRecursivo,connexion);
					opcionRecursivoLogic.deepSave(opcionRecursivo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Accion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Accion accion:opcion.getAccions()) {
					AccionLogic accionLogic= new AccionLogic(connexion);
					accion.setid_opcion(opcion.getId());
					AccionDataAccess.save(accion,connexion);
					accionLogic.deepSave(accion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PerfilOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PerfilOpcion perfilopcion:opcion.getPerfilOpcions()) {
					PerfilOpcionLogic perfilopcionLogic= new PerfilOpcionLogic(connexion);
					perfilopcion.setid_opcion(opcion.getId());
					PerfilOpcionDataAccess.save(perfilopcion,connexion);
					perfilopcionLogic.deepSave(perfilopcion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Campo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Campo campo:opcion.getCampos()) {
					CampoLogic campoLogic= new CampoLogic(connexion);
					campo.setid_opcion(opcion.getId());
					CampoDataAccess.save(campo,connexion);
					campoLogic.deepSave(campo,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Opcion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(opcion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(opcion);
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
			this.deepLoad(this.opcion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Opcion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(opcions!=null) {
				for(Opcion opcion:opcions) {
					this.deepLoad(opcion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(opcions);
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
			if(opcions!=null) {
				for(Opcion opcion:opcions) {
					this.deepLoad(opcion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(opcions);
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
			this.getNewConnexionToDeep(Opcion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(opcion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Opcion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(opcions!=null) {
				for(Opcion opcion:opcions) {
					this.deepSave(opcion,isDeep,deepLoadType,clases);
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
			if(opcions!=null) {
				for(Opcion opcion:opcions) {
					this.deepSave(opcion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getOpcionsBusquedaPorIdModuloPorIdOpcionWithConnection(String sFinalQuery,Pagination pagination,Long id_sistema,Long id_modulo,Long id_opcion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,OpcionConstantesFunciones.IDSISTEMA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,OpcionConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralidOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_opcion,OpcionConstantesFunciones.IDOPCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOpcion);

			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdModuloPorIdOpcion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			opcions=opcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOpcionsBusquedaPorIdModuloPorIdOpcion(String sFinalQuery,Pagination pagination,Long id_sistema,Long id_modulo,Long id_opcion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,OpcionConstantesFunciones.IDSISTEMA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,OpcionConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralidOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_opcion,OpcionConstantesFunciones.IDOPCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOpcion);

			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdModuloPorIdOpcion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			opcions=opcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOpcionsBusquedaPorIdModuloPorNombreWithConnection(String sFinalQuery,Pagination pagination,Long id_sistema,Long id_modulo,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,OpcionConstantesFunciones.IDSISTEMA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,OpcionConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",OpcionConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdModuloPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			opcions=opcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOpcionsBusquedaPorIdModuloPorNombre(String sFinalQuery,Pagination pagination,Long id_sistema,Long id_modulo,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,OpcionConstantesFunciones.IDSISTEMA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,OpcionConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",OpcionConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdModuloPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			opcions=opcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOpcionsBusquedaPorIdSistemaPorModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_sistema,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,OpcionConstantesFunciones.IDSISTEMA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,OpcionConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdSistemaPorModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			opcions=opcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOpcionsBusquedaPorIdSistemaPorModulo(String sFinalQuery,Pagination pagination,Long id_sistema,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,OpcionConstantesFunciones.IDSISTEMA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,OpcionConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdSistemaPorModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			opcions=opcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOpcionsFK_IdGrupoOpcionWithConnection(String sFinalQuery,Pagination pagination,Long id_grupo_opcion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_opcion,OpcionConstantesFunciones.IDGRUPOOPCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoOpcion);

			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGrupoOpcion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			opcions=opcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOpcionsFK_IdGrupoOpcion(String sFinalQuery,Pagination pagination,Long id_grupo_opcion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_opcion,OpcionConstantesFunciones.IDGRUPOOPCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoOpcion);

			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGrupoOpcion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			opcions=opcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOpcionsFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,OpcionConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			opcions=opcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOpcionsFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,OpcionConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			opcions=opcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOpcionsFK_IdOpcionWithConnection(String sFinalQuery,Pagination pagination,Long id_opcion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_opcion,OpcionConstantesFunciones.IDOPCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOpcion);

			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOpcion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			opcions=opcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOpcionsFK_IdOpcion(String sFinalQuery,Pagination pagination,Long id_opcion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_opcion,OpcionConstantesFunciones.IDOPCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOpcion);

			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOpcion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			opcions=opcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOpcionsFK_IdSistemaWithConnection(String sFinalQuery,Pagination pagination,Long id_sistema)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,OpcionConstantesFunciones.IDSISTEMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSistema","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			opcions=opcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOpcionsFK_IdSistema(String sFinalQuery,Pagination pagination,Long id_sistema)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,OpcionConstantesFunciones.IDSISTEMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSistema","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			opcions=opcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getOpcionsFK_IdTipoTeclaMascaraWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_tecla_mascara)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Opcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTeclaMascara= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTeclaMascara.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_tecla_mascara,OpcionConstantesFunciones.IDTIPOTECLAMASCARA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTeclaMascara);

			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTeclaMascara","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			opcions=opcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getOpcionsFK_IdTipoTeclaMascara(String sFinalQuery,Pagination pagination,Long id_tipo_tecla_mascara)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTeclaMascara= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTeclaMascara.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_tecla_mascara,OpcionConstantesFunciones.IDTIPOTECLAMASCARA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTeclaMascara);

			OpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTeclaMascara","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			opcions=opcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(this.opcions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		//AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		//auditoriaLogicAdditional.setConnexion(connexion);
		//AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(OpcionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				//auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,OpcionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Opcion opcion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		//AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		//auditoriaLogicAdditional.setConnexion(connexion);
		//AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(OpcionConstantesFunciones.ISCONAUDITORIA) {
				if(opcion.getIsNew()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,OpcionDataAccess.TABLENAME, opcion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(OpcionConstantesFunciones.ISCONAUDITORIADETALLE) {
						//OpcionLogic.registrarAuditoriaDetallesOpcion(connexion,opcion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(opcion.getIsDeleted()) {
					/*if(!opcion.getIsExpired()) {
						//auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,OpcionDataAccess.TABLENAME, opcion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						//OpcionLogic.registrarAuditoriaDetallesOpcion(connexion,opcion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,OpcionDataAccess.TABLENAME, opcion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(opcion.getIsChanged()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,OpcionDataAccess.TABLENAME, opcion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(OpcionConstantesFunciones.ISCONAUDITORIADETALLE) {
						//OpcionLogic.registrarAuditoriaDetallesOpcion(connexion,opcion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesOpcion(Connexion connexion,Opcion opcion)throws Exception {		
		//AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		//auditoriaDetalleLogicAdditional.setConnexion(connexion);
		//AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(opcion.getIsNew()||!opcion.getid_sistema().equals(opcion.getOpcionOriginal().getid_sistema()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(opcion.getOpcionOriginal().getid_sistema()!=null)
				{
					strValorActual=opcion.getOpcionOriginal().getid_sistema().toString();
				}
				if(opcion.getid_sistema()!=null)
				{
					strValorNuevo=opcion.getid_sistema().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OpcionConstantesFunciones.IDSISTEMA,strValorActual,strValorNuevo);
			}	
			
			if(opcion.getIsNew()||!opcion.getid_modulo().equals(opcion.getOpcionOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(opcion.getOpcionOriginal().getid_modulo()!=null)
				{
					strValorActual=opcion.getOpcionOriginal().getid_modulo().toString();
				}
				if(opcion.getid_modulo()!=null)
				{
					strValorNuevo=opcion.getid_modulo().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OpcionConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(opcion.getIsNew()||!opcion.getid_grupo_opcion().equals(opcion.getOpcionOriginal().getid_grupo_opcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(opcion.getOpcionOriginal().getid_grupo_opcion()!=null)
				{
					strValorActual=opcion.getOpcionOriginal().getid_grupo_opcion().toString();
				}
				if(opcion.getid_grupo_opcion()!=null)
				{
					strValorNuevo=opcion.getid_grupo_opcion().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OpcionConstantesFunciones.IDGRUPOOPCION,strValorActual,strValorNuevo);
			}	
			
			if(opcion.getIsNew()||!opcion.getid_opcion().equals(opcion.getOpcionOriginal().getid_opcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(opcion.getOpcionOriginal().getid_opcion()!=null)
				{
					strValorActual=opcion.getOpcionOriginal().getid_opcion().toString();
				}
				if(opcion.getid_opcion()!=null)
				{
					strValorNuevo=opcion.getid_opcion().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OpcionConstantesFunciones.IDOPCION,strValorActual,strValorNuevo);
			}	
			
			if(opcion.getIsNew()||!opcion.getcodigo().equals(opcion.getOpcionOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(opcion.getOpcionOriginal().getcodigo()!=null)
				{
					strValorActual=opcion.getOpcionOriginal().getcodigo();
				}
				if(opcion.getcodigo()!=null)
				{
					strValorNuevo=opcion.getcodigo() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OpcionConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(opcion.getIsNew()||!opcion.getnombre().equals(opcion.getOpcionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(opcion.getOpcionOriginal().getnombre()!=null)
				{
					strValorActual=opcion.getOpcionOriginal().getnombre();
				}
				if(opcion.getnombre()!=null)
				{
					strValorNuevo=opcion.getnombre() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OpcionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(opcion.getIsNew()||!opcion.getid_tipo_tecla_mascara().equals(opcion.getOpcionOriginal().getid_tipo_tecla_mascara()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(opcion.getOpcionOriginal().getid_tipo_tecla_mascara()!=null)
				{
					strValorActual=opcion.getOpcionOriginal().getid_tipo_tecla_mascara().toString();
				}
				if(opcion.getid_tipo_tecla_mascara()!=null)
				{
					strValorNuevo=opcion.getid_tipo_tecla_mascara().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OpcionConstantesFunciones.IDTIPOTECLAMASCARA,strValorActual,strValorNuevo);
			}	
			
			if(opcion.getIsNew()||!opcion.gettecla().equals(opcion.getOpcionOriginal().gettecla()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(opcion.getOpcionOriginal().gettecla()!=null)
				{
					strValorActual=opcion.getOpcionOriginal().gettecla();
				}
				if(opcion.gettecla()!=null)
				{
					strValorNuevo=opcion.gettecla() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OpcionConstantesFunciones.TECLA,strValorActual,strValorNuevo);
			}	
			
			if(opcion.getIsNew()||!opcion.getposicion().equals(opcion.getOpcionOriginal().getposicion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(opcion.getOpcionOriginal().getposicion()!=null)
				{
					strValorActual=opcion.getOpcionOriginal().getposicion().toString();
				}
				if(opcion.getposicion()!=null)
				{
					strValorNuevo=opcion.getposicion().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OpcionConstantesFunciones.POSICION,strValorActual,strValorNuevo);
			}	
			
			if(opcion.getIsNew()||!opcion.geticon_name().equals(opcion.getOpcionOriginal().geticon_name()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(opcion.getOpcionOriginal().geticon_name()!=null)
				{
					strValorActual=opcion.getOpcionOriginal().geticon_name();
				}
				if(opcion.geticon_name()!=null)
				{
					strValorNuevo=opcion.geticon_name() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OpcionConstantesFunciones.ICONNAME,strValorActual,strValorNuevo);
			}	
			
			if(opcion.getIsNew()||!opcion.getnombre_clase().equals(opcion.getOpcionOriginal().getnombre_clase()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(opcion.getOpcionOriginal().getnombre_clase()!=null)
				{
					strValorActual=opcion.getOpcionOriginal().getnombre_clase();
				}
				if(opcion.getnombre_clase()!=null)
				{
					strValorNuevo=opcion.getnombre_clase() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OpcionConstantesFunciones.NOMBRECLASE,strValorActual,strValorNuevo);
			}	
			
			if(opcion.getIsNew()||!opcion.getsub_modulo().equals(opcion.getOpcionOriginal().getsub_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(opcion.getOpcionOriginal().getsub_modulo()!=null)
				{
					strValorActual=opcion.getOpcionOriginal().getsub_modulo();
				}
				if(opcion.getsub_modulo()!=null)
				{
					strValorNuevo=opcion.getsub_modulo() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OpcionConstantesFunciones.SUBMODULO,strValorActual,strValorNuevo);
			}	
			
			if(opcion.getIsNew()||!opcion.getpaquete().equals(opcion.getOpcionOriginal().getpaquete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(opcion.getOpcionOriginal().getpaquete()!=null)
				{
					strValorActual=opcion.getOpcionOriginal().getpaquete();
				}
				if(opcion.getpaquete()!=null)
				{
					strValorNuevo=opcion.getpaquete() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OpcionConstantesFunciones.PAQUETE,strValorActual,strValorNuevo);
			}	
			
			if(opcion.getIsNew()||!opcion.getpaquete_original().equals(opcion.getOpcionOriginal().getpaquete_original()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(opcion.getOpcionOriginal().getpaquete_original()!=null)
				{
					strValorActual=opcion.getOpcionOriginal().getpaquete_original();
				}
				if(opcion.getpaquete_original()!=null)
				{
					strValorNuevo=opcion.getpaquete_original() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OpcionConstantesFunciones.PAQUETEORIGINAL,strValorActual,strValorNuevo);
			}	
			
			if(opcion.getIsNew()||!opcion.getpath_auxiliar().equals(opcion.getOpcionOriginal().getpath_auxiliar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(opcion.getOpcionOriginal().getpath_auxiliar()!=null)
				{
					strValorActual=opcion.getOpcionOriginal().getpath_auxiliar();
				}
				if(opcion.getpath_auxiliar()!=null)
				{
					strValorNuevo=opcion.getpath_auxiliar() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OpcionConstantesFunciones.PATHAUXILIAR,strValorActual,strValorNuevo);
			}	
			
			if(opcion.getIsNew()||!opcion.getes_para_menu().equals(opcion.getOpcionOriginal().getes_para_menu()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(opcion.getOpcionOriginal().getes_para_menu()!=null)
				{
					strValorActual=opcion.getOpcionOriginal().getes_para_menu().toString();
				}
				if(opcion.getes_para_menu()!=null)
				{
					strValorNuevo=opcion.getes_para_menu().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OpcionConstantesFunciones.ESPARAMENU,strValorActual,strValorNuevo);
			}	
			
			if(opcion.getIsNew()||!opcion.getcon_mostrar_acciones_campo().equals(opcion.getOpcionOriginal().getcon_mostrar_acciones_campo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(opcion.getOpcionOriginal().getcon_mostrar_acciones_campo()!=null)
				{
					strValorActual=opcion.getOpcionOriginal().getcon_mostrar_acciones_campo().toString();
				}
				if(opcion.getcon_mostrar_acciones_campo()!=null)
				{
					strValorNuevo=opcion.getcon_mostrar_acciones_campo().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OpcionConstantesFunciones.CONMOSTRARACCIONESCAMPO,strValorActual,strValorNuevo);
			}	
			
			if(opcion.getIsNew()||!opcion.getes_guardar_relaciones().equals(opcion.getOpcionOriginal().getes_guardar_relaciones()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(opcion.getOpcionOriginal().getes_guardar_relaciones()!=null)
				{
					strValorActual=opcion.getOpcionOriginal().getes_guardar_relaciones().toString();
				}
				if(opcion.getes_guardar_relaciones()!=null)
				{
					strValorNuevo=opcion.getes_guardar_relaciones().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OpcionConstantesFunciones.ESGUARDARRELACIONES,strValorActual,strValorNuevo);
			}	
			
			if(opcion.getIsNew()||!opcion.getestado().equals(opcion.getOpcionOriginal().getestado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(opcion.getOpcionOriginal().getestado()!=null)
				{
					strValorActual=opcion.getOpcionOriginal().getestado().toString();
				}
				if(opcion.getestado()!=null)
				{
					strValorNuevo=opcion.getestado().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),OpcionConstantesFunciones.ESTADO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveOpcionRelacionesWithConnection(Opcion opcion,List<UsuarioOpcion> usuarioopcions,List<Opcion> opcions,List<Accion> accions,List<PerfilOpcion> perfilopcions,List<Campo> campos) throws Exception {

		if(!opcion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveOpcionRelacionesBase(opcion,usuarioopcions,opcions,accions,perfilopcions,campos,true);
		}
	}

	public void saveOpcionRelaciones(Opcion opcion,List<UsuarioOpcion> usuarioopcions,List<Opcion> opcions,List<Accion> accions,List<PerfilOpcion> perfilopcions,List<Campo> campos)throws Exception {

		if(!opcion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveOpcionRelacionesBase(opcion,usuarioopcions,opcions,accions,perfilopcions,campos,false);
		}
	}

	public void saveOpcionRelacionesBase(Opcion opcion,List<UsuarioOpcion> usuarioopcions,List<Opcion> opcions,List<Accion> accions,List<PerfilOpcion> perfilopcions,List<Campo> campos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Opcion-saveRelacionesWithConnection");}
	
			opcion.setUsuarioOpcions(usuarioopcions);
			opcion.setOpcions(opcions);
			opcion.setAccions(accions);
			opcion.setPerfilOpcions(perfilopcions);
			opcion.setCampos(campos);

			this.setOpcion(opcion);

			if(OpcionLogicAdditional.validarSaveRelaciones(opcion,this)) {

				OpcionLogicAdditional.updateRelacionesToSave(opcion,this);

				if((opcion.getIsNew()||opcion.getIsChanged())&&!opcion.getIsDeleted()) {
					this.saveOpcion();
					this.saveOpcionRelacionesDetalles(usuarioopcions,opcions,accions,perfilopcions,campos);

				} else if(opcion.getIsDeleted()) {
					this.saveOpcionRelacionesDetalles(usuarioopcions,opcions,accions,perfilopcions,campos);
					this.saveOpcion();
				}

				OpcionLogicAdditional.updateRelacionesToSaveAfter(opcion,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			UsuarioOpcionConstantesFunciones.InicializarGeneralEntityAuxiliaresUsuarioOpcions(usuarioopcions,true,true);
			OpcionConstantesFunciones.InicializarGeneralEntityAuxiliaresOpcions(opcions,true,true);
			AccionConstantesFunciones.InicializarGeneralEntityAuxiliaresAccions(accions,true,true);
			PerfilOpcionConstantesFunciones.InicializarGeneralEntityAuxiliaresPerfilOpcions(perfilopcions,true,true);
			CampoConstantesFunciones.InicializarGeneralEntityAuxiliaresCampos(campos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveOpcionRelacionesDetalles(List<UsuarioOpcion> usuarioopcions,List<Opcion> opcions,List<Accion> accions,List<PerfilOpcion> perfilopcions,List<Campo> campos)throws Exception {
		try {
	

			Long idOpcionActual=this.getOpcion().getId();

			UsuarioOpcionLogic usuarioopcionLogic_Desde_Opcion=new UsuarioOpcionLogic();
			usuarioopcionLogic_Desde_Opcion.setUsuarioOpcions(usuarioopcions);

			usuarioopcionLogic_Desde_Opcion.setConnexion(this.getConnexion());
			usuarioopcionLogic_Desde_Opcion.setDatosCliente(this.datosCliente);

			for(UsuarioOpcion usuarioopcion_Desde_Opcion:usuarioopcionLogic_Desde_Opcion.getUsuarioOpcions()) {
				usuarioopcion_Desde_Opcion.setid_opcion(idOpcionActual);
			}

			usuarioopcionLogic_Desde_Opcion.saveUsuarioOpcions();

			OpcionLogic opcionLogicHijos_Desde_Opcion=new OpcionLogic();
			opcionLogicHijos_Desde_Opcion.setOpcions(opcions);

			opcionLogicHijos_Desde_Opcion.setConnexion(this.getConnexion());
			opcionLogicHijos_Desde_Opcion.setDatosCliente(this.datosCliente);

			for(Opcion opcionHijos_Desde_Opcion:opcionLogicHijos_Desde_Opcion.getOpcions()) {
				opcionHijos_Desde_Opcion.setid_opcion(idOpcionActual);

				opcionLogicHijos_Desde_Opcion.setOpcion(opcionHijos_Desde_Opcion);
				opcionLogicHijos_Desde_Opcion.saveOpcion();
			}


			AccionLogic accionLogic_Desde_Opcion=new AccionLogic();
			accionLogic_Desde_Opcion.setAccions(accions);

			accionLogic_Desde_Opcion.setConnexion(this.getConnexion());
			accionLogic_Desde_Opcion.setDatosCliente(this.datosCliente);

			for(Accion accion_Desde_Opcion:accionLogic_Desde_Opcion.getAccions()) {
				accion_Desde_Opcion.setid_opcion(idOpcionActual);

				accionLogic_Desde_Opcion.setAccion(accion_Desde_Opcion);
				accionLogic_Desde_Opcion.saveAccion();

				Long idAccionActual=accion_Desde_Opcion.getId();

				PerfilAccionLogic perfilaccionLogic_Desde_Accion=new PerfilAccionLogic();

				if(accion_Desde_Opcion.getPerfilAccions()==null){
					accion_Desde_Opcion.setPerfilAccions(new ArrayList<PerfilAccion>());
				}

				perfilaccionLogic_Desde_Accion.setPerfilAccions(accion_Desde_Opcion.getPerfilAccions());

				perfilaccionLogic_Desde_Accion.setConnexion(this.getConnexion());
				perfilaccionLogic_Desde_Accion.setDatosCliente(this.datosCliente);

				for(PerfilAccion perfilaccion_Desde_Accion:perfilaccionLogic_Desde_Accion.getPerfilAccions()) {
					perfilaccion_Desde_Accion.setid_accion(idAccionActual);
				}

				perfilaccionLogic_Desde_Accion.savePerfilAccions();
			}


			PerfilOpcionLogic perfilopcionLogic_Desde_Opcion=new PerfilOpcionLogic();
			perfilopcionLogic_Desde_Opcion.setPerfilOpcions(perfilopcions);

			perfilopcionLogic_Desde_Opcion.setConnexion(this.getConnexion());
			perfilopcionLogic_Desde_Opcion.setDatosCliente(this.datosCliente);

			for(PerfilOpcion perfilopcion_Desde_Opcion:perfilopcionLogic_Desde_Opcion.getPerfilOpcions()) {
				perfilopcion_Desde_Opcion.setid_opcion(idOpcionActual);
			}

			perfilopcionLogic_Desde_Opcion.savePerfilOpcions();

			CampoLogic campoLogic_Desde_Opcion=new CampoLogic();
			campoLogic_Desde_Opcion.setCampos(campos);

			campoLogic_Desde_Opcion.setConnexion(this.getConnexion());
			campoLogic_Desde_Opcion.setDatosCliente(this.datosCliente);

			for(Campo campo_Desde_Opcion:campoLogic_Desde_Opcion.getCampos()) {
				campo_Desde_Opcion.setid_opcion(idOpcionActual);

				campoLogic_Desde_Opcion.setCampo(campo_Desde_Opcion);
				campoLogic_Desde_Opcion.saveCampo();

				Long idCampoActual=campo_Desde_Opcion.getId();

				PerfilCampoLogic perfilcampoLogic_Desde_Campo=new PerfilCampoLogic();

				if(campo_Desde_Opcion.getPerfilCampos()==null){
					campo_Desde_Opcion.setPerfilCampos(new ArrayList<PerfilCampo>());
				}

				perfilcampoLogic_Desde_Campo.setPerfilCampos(campo_Desde_Opcion.getPerfilCampos());

				perfilcampoLogic_Desde_Campo.setConnexion(this.getConnexion());
				perfilcampoLogic_Desde_Campo.setDatosCliente(this.datosCliente);

				for(PerfilCampo perfilcampo_Desde_Campo:perfilcampoLogic_Desde_Campo.getPerfilCampos()) {
					perfilcampo_Desde_Campo.setid_campo(idCampoActual);
				}

				perfilcampoLogic_Desde_Campo.savePerfilCampos();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfOpcion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=OpcionConstantesFunciones.getClassesForeignKeysOfOpcion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfOpcion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=OpcionConstantesFunciones.getClassesRelationshipsOfOpcion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

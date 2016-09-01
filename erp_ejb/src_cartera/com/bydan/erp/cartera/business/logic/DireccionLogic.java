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
import com.bydan.erp.cartera.util.DireccionConstantesFunciones;
import com.bydan.erp.cartera.util.DireccionParameterReturnGeneral;
//import com.bydan.erp.cartera.util.DireccionParameterGeneral;
import com.bydan.erp.cartera.business.entity.Direccion;
import com.bydan.erp.cartera.business.logic.DireccionLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class DireccionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DireccionLogic.class);
	
	protected DireccionDataAccess direccionDataAccess; 	
	protected Direccion direccion;
	protected List<Direccion> direccions;
	protected Object direccionObject;	
	protected List<Object> direccionsObject;
	
	public static ClassValidator<Direccion> direccionValidator = new ClassValidator<Direccion>(Direccion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DireccionLogicAdditional direccionLogicAdditional=null;
	
	public DireccionLogicAdditional getDireccionLogicAdditional() {
		return this.direccionLogicAdditional;
	}
	
	public void setDireccionLogicAdditional(DireccionLogicAdditional direccionLogicAdditional) {
		try {
			this.direccionLogicAdditional=direccionLogicAdditional;
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
	
	
	
	
	public  DireccionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.direccionDataAccess = new DireccionDataAccess();
			
			this.direccions= new ArrayList<Direccion>();
			this.direccion= new Direccion();
			
			this.direccionObject=new Object();
			this.direccionsObject=new ArrayList<Object>();
				
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
			
			this.direccionDataAccess.setConnexionType(this.connexionType);
			this.direccionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DireccionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.direccionDataAccess = new DireccionDataAccess();
			this.direccions= new ArrayList<Direccion>();
			this.direccion= new Direccion();
			this.direccionObject=new Object();
			this.direccionsObject=new ArrayList<Object>();
			
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
			
			this.direccionDataAccess.setConnexionType(this.connexionType);
			this.direccionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Direccion getDireccion() throws Exception {	
		DireccionLogicAdditional.checkDireccionToGet(direccion,this.datosCliente,this.arrDatoGeneral);
		DireccionLogicAdditional.updateDireccionToGet(direccion,this.arrDatoGeneral);
		
		return direccion;
	}
		
	public void setDireccion(Direccion newDireccion) {
		this.direccion = newDireccion;
	}
	
	public DireccionDataAccess getDireccionDataAccess() {
		return direccionDataAccess;
	}
	
	public void setDireccionDataAccess(DireccionDataAccess newdireccionDataAccess) {
		this.direccionDataAccess = newdireccionDataAccess;
	}
	
	public List<Direccion> getDireccions() throws Exception {		
		this.quitarDireccionsNulos();
		
		DireccionLogicAdditional.checkDireccionToGets(direccions,this.datosCliente,this.arrDatoGeneral);
		
		for (Direccion direccionLocal: direccions ) {
			DireccionLogicAdditional.updateDireccionToGet(direccionLocal,this.arrDatoGeneral);
		}
		
		return direccions;
	}
	
	public void setDireccions(List<Direccion> newDireccions) {
		this.direccions = newDireccions;
	}
	
	public Object getDireccionObject() {	
		this.direccionObject=this.direccionDataAccess.getEntityObject();
		return this.direccionObject;
	}
		
	public void setDireccionObject(Object newDireccionObject) {
		this.direccionObject = newDireccionObject;
	}
	
	public List<Object> getDireccionsObject() {		
		this.direccionsObject=this.direccionDataAccess.getEntitiesObject();
		return this.direccionsObject;
	}
		
	public void setDireccionsObject(List<Object> newDireccionsObject) {
		this.direccionsObject = newDireccionsObject;
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
		
		if(this.direccionDataAccess!=null) {
			this.direccionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Direccion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			direccionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			direccionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		direccion = new  Direccion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Direccion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			direccion=direccionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.direccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccion);
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
		direccion = new  Direccion();
		  		  
        try {
			
			direccion=direccionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.direccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		direccion = new  Direccion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Direccion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			direccion=direccionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.direccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccion);
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
		direccion = new  Direccion();
		  		  
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
		direccion = new  Direccion();
		  		  
        try {
			
			direccion=direccionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.direccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		direccion = new  Direccion();
		  		  
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
		direccion = new  Direccion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Direccion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =direccionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		direccion = new  Direccion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=direccionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		direccion = new  Direccion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Direccion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =direccionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		direccion = new  Direccion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=direccionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		direccion = new  Direccion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Direccion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =direccionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		direccion = new  Direccion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=direccionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		direccions = new  ArrayList<Direccion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Direccion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			direccions=direccionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDireccion(direccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccions);
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
		direccions = new  ArrayList<Direccion>();
		  		  
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
		direccions = new  ArrayList<Direccion>();
		  		  
        try {			
			DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			direccions=direccionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDireccion(direccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		direccions = new  ArrayList<Direccion>();
		  		  
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
		direccions = new  ArrayList<Direccion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Direccion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			direccions=direccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDireccion(direccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccions);
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
		direccions = new  ArrayList<Direccion>();
		  		  
        try {
			DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			direccions=direccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDireccion(direccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccions);
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
		direccions = new  ArrayList<Direccion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Direccion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			direccions=direccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDireccion(direccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccions);
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
		direccions = new  ArrayList<Direccion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			direccions=direccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDireccion(direccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		direccion = new  Direccion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Direccion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			direccion=direccionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDireccion(direccion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccion);
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
		direccion = new  Direccion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			direccion=direccionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDireccion(direccion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		direccions = new  ArrayList<Direccion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Direccion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			direccions=direccionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDireccion(direccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccions);
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
		direccions = new  ArrayList<Direccion>();
		  		  
        try {
			DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			direccions=direccionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDireccion(direccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDireccionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		direccions = new  ArrayList<Direccion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Direccion.class.getSimpleName()+"-getTodosDireccionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			direccions=direccionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDireccion(direccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccions);
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
	
	public  void  getTodosDireccions(String sFinalQuery,Pagination pagination)throws Exception {
		direccions = new  ArrayList<Direccion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			direccions=direccionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDireccion(direccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDireccion(Direccion direccion) throws Exception {
		Boolean estaValidado=false;
		
		if(direccion.getIsNew() || direccion.getIsChanged()) { 
			this.invalidValues = direccionValidator.getInvalidValues(direccion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(direccion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDireccion(List<Direccion> Direccions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Direccion direccionLocal:direccions) {				
			estaValidadoObjeto=this.validarGuardarDireccion(direccionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDireccion(List<Direccion> Direccions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDireccion(direccions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDireccion(Direccion Direccion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDireccion(direccion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Direccion direccion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+direccion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DireccionConstantesFunciones.getDireccionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"direccion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DireccionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DireccionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDireccionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Direccion.class.getSimpleName()+"-saveDireccionWithConnection");connexion.begin();			
			
			DireccionLogicAdditional.checkDireccionToSave(this.direccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DireccionLogicAdditional.updateDireccionToSave(this.direccion,this.arrDatoGeneral);
			
			DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.direccion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDireccion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDireccion(this.direccion)) {
				DireccionDataAccess.save(this.direccion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.direccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DireccionLogicAdditional.checkDireccionToSaveAfter(this.direccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDireccion();
			
			connexion.commit();			
			
			if(this.direccion.getIsDeleted()) {
				this.direccion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDireccion()throws Exception {	
		try {	
			
			DireccionLogicAdditional.checkDireccionToSave(this.direccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DireccionLogicAdditional.updateDireccionToSave(this.direccion,this.arrDatoGeneral);
			
			DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.direccion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDireccion(this.direccion)) {			
				DireccionDataAccess.save(this.direccion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.direccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DireccionLogicAdditional.checkDireccionToSaveAfter(this.direccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.direccion.getIsDeleted()) {
				this.direccion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDireccionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Direccion.class.getSimpleName()+"-saveDireccionsWithConnection");connexion.begin();			
			
			DireccionLogicAdditional.checkDireccionToSaves(direccions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDireccions();
			
			Boolean validadoTodosDireccion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Direccion direccionLocal:direccions) {		
				if(direccionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DireccionLogicAdditional.updateDireccionToSave(direccionLocal,this.arrDatoGeneral);
	        	
				DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),direccionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDireccion(direccionLocal)) {
					DireccionDataAccess.save(direccionLocal, connexion);				
				} else {
					validadoTodosDireccion=false;
				}
			}
			
			if(!validadoTodosDireccion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DireccionLogicAdditional.checkDireccionToSavesAfter(direccions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDireccions();
			
			connexion.commit();		
			
			this.quitarDireccionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDireccions()throws Exception {				
		 try {	
			DireccionLogicAdditional.checkDireccionToSaves(direccions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDireccion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Direccion direccionLocal:direccions) {				
				if(direccionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DireccionLogicAdditional.updateDireccionToSave(direccionLocal,this.arrDatoGeneral);
	        	
				DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),direccionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDireccion(direccionLocal)) {				
					DireccionDataAccess.save(direccionLocal, connexion);				
				} else {
					validadoTodosDireccion=false;
				}
			}
			
			if(!validadoTodosDireccion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DireccionLogicAdditional.checkDireccionToSavesAfter(direccions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDireccionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DireccionParameterReturnGeneral procesarAccionDireccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Direccion> direccions,DireccionParameterReturnGeneral direccionParameterGeneral)throws Exception {
		 try {	
			DireccionParameterReturnGeneral direccionReturnGeneral=new DireccionParameterReturnGeneral();
	
			DireccionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,direccions,direccionParameterGeneral,direccionReturnGeneral);
			
			return direccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DireccionParameterReturnGeneral procesarAccionDireccionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Direccion> direccions,DireccionParameterReturnGeneral direccionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Direccion.class.getSimpleName()+"-procesarAccionDireccionsWithConnection");connexion.begin();			
			
			DireccionParameterReturnGeneral direccionReturnGeneral=new DireccionParameterReturnGeneral();
	
			DireccionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,direccions,direccionParameterGeneral,direccionReturnGeneral);
			
			this.connexion.commit();
			
			return direccionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DireccionParameterReturnGeneral procesarEventosDireccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Direccion> direccions,Direccion direccion,DireccionParameterReturnGeneral direccionParameterGeneral,Boolean isEsNuevoDireccion,ArrayList<Classe> clases)throws Exception {
		 try {	
			DireccionParameterReturnGeneral direccionReturnGeneral=new DireccionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				direccionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DireccionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,direccions,direccion,direccionParameterGeneral,direccionReturnGeneral,isEsNuevoDireccion,clases);
			
			return direccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DireccionParameterReturnGeneral procesarEventosDireccionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Direccion> direccions,Direccion direccion,DireccionParameterReturnGeneral direccionParameterGeneral,Boolean isEsNuevoDireccion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Direccion.class.getSimpleName()+"-procesarEventosDireccionsWithConnection");connexion.begin();			
			
			DireccionParameterReturnGeneral direccionReturnGeneral=new DireccionParameterReturnGeneral();
	
			direccionReturnGeneral.setDireccion(direccion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				direccionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DireccionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,direccions,direccion,direccionParameterGeneral,direccionReturnGeneral,isEsNuevoDireccion,clases);
			
			this.connexion.commit();
			
			return direccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DireccionParameterReturnGeneral procesarImportacionDireccionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DireccionParameterReturnGeneral direccionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Direccion.class.getSimpleName()+"-procesarImportacionDireccionsWithConnection");connexion.begin();			
			
			DireccionParameterReturnGeneral direccionReturnGeneral=new DireccionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.direccions=new ArrayList<Direccion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.direccion=new Direccion();
				
				
				if(conColumnasBase) {this.direccion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.direccion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

			this.direccion.setsector(arrColumnas[iColumn++]);
			this.direccion.setbarrio(arrColumnas[iColumn++]);
			this.direccion.setcalles(arrColumnas[iColumn++]);
			this.direccion.setasegurada(arrColumnas[iColumn++]);
			this.direccion.setdireccion(arrColumnas[iColumn++]);
				this.direccion.setesactivo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.direccions.add(this.direccion);
			}
			
			this.saveDireccions();
			
			this.connexion.commit();
			
			direccionReturnGeneral.setConRetornoEstaProcesado(true);
			direccionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return direccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDireccionsEliminados() throws Exception {				
		
		List<Direccion> direccionsAux= new ArrayList<Direccion>();
		
		for(Direccion direccion:direccions) {
			if(!direccion.getIsDeleted()) {
				direccionsAux.add(direccion);
			}
		}
		
		direccions=direccionsAux;
	}
	
	public void quitarDireccionsNulos() throws Exception {				
		
		List<Direccion> direccionsAux= new ArrayList<Direccion>();
		
		for(Direccion direccion : this.direccions) {
			if(direccion==null) {
				direccionsAux.add(direccion);
			}
		}
		
		//this.direccions=direccionsAux;
		
		this.direccions.removeAll(direccionsAux);
	}
	
	public void getSetVersionRowDireccionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(direccion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((direccion.getIsDeleted() || (direccion.getIsChanged()&&!direccion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=direccionDataAccess.getSetVersionRowDireccion(connexion,direccion.getId());
				
				if(!direccion.getVersionRow().equals(timestamp)) {	
					direccion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				direccion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDireccion()throws Exception {	
		
		if(direccion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((direccion.getIsDeleted() || (direccion.getIsChanged()&&!direccion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=direccionDataAccess.getSetVersionRowDireccion(connexion,direccion.getId());
			
			try {							
				if(!direccion.getVersionRow().equals(timestamp)) {	
					direccion.setVersionRow(timestamp);
				}
				
				direccion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDireccionsWithConnection()throws Exception {	
		if(direccions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Direccion direccionAux:direccions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(direccionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(direccionAux.getIsDeleted() || (direccionAux.getIsChanged()&&!direccionAux.getIsNew())) {
						
						timestamp=direccionDataAccess.getSetVersionRowDireccion(connexion,direccionAux.getId());
						
						if(!direccion.getVersionRow().equals(timestamp)) {	
							direccionAux.setVersionRow(timestamp);
						}
								
						direccionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDireccions()throws Exception {	
		if(direccions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Direccion direccionAux:direccions) {
					if(direccionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(direccionAux.getIsDeleted() || (direccionAux.getIsChanged()&&!direccionAux.getIsNew())) {
						
						timestamp=direccionDataAccess.getSetVersionRowDireccion(connexion,direccionAux.getId());
						
						if(!direccionAux.getVersionRow().equals(timestamp)) {	
							direccionAux.setVersionRow(timestamp);
						}
						
													
						direccionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DireccionParameterReturnGeneral cargarCombosLoteForeignKeyDireccionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalTipoDireccion,String finalQueryGlobalTipoVivienda) throws Exception {
		DireccionParameterReturnGeneral  direccionReturnGeneral =new DireccionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Direccion.class.getSimpleName()+"-cargarCombosLoteForeignKeyDireccionWithConnection");connexion.begin();
			
			direccionReturnGeneral =new DireccionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			direccionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			direccionReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoDireccion> tipodireccionsForeignKey=new ArrayList<TipoDireccion>();
			TipoDireccionLogic tipodireccionLogic=new TipoDireccionLogic();
			tipodireccionLogic.setConnexion(this.connexion);
			tipodireccionLogic.getTipoDireccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDireccion.equals("NONE")) {
				tipodireccionLogic.getTodosTipoDireccions(finalQueryGlobalTipoDireccion,new Pagination());
				tipodireccionsForeignKey=tipodireccionLogic.getTipoDireccions();
			}

			direccionReturnGeneral.settipodireccionsForeignKey(tipodireccionsForeignKey);


			List<TipoVivienda> tipoviviendasForeignKey=new ArrayList<TipoVivienda>();
			TipoViviendaLogic tipoviviendaLogic=new TipoViviendaLogic();
			tipoviviendaLogic.setConnexion(this.connexion);
			tipoviviendaLogic.getTipoViviendaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoVivienda.equals("NONE")) {
				tipoviviendaLogic.getTodosTipoViviendas(finalQueryGlobalTipoVivienda,new Pagination());
				tipoviviendasForeignKey=tipoviviendaLogic.getTipoViviendas();
			}

			direccionReturnGeneral.settipoviviendasForeignKey(tipoviviendasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return direccionReturnGeneral;
	}
	
	public DireccionParameterReturnGeneral cargarCombosLoteForeignKeyDireccion(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalTipoDireccion,String finalQueryGlobalTipoVivienda) throws Exception {
		DireccionParameterReturnGeneral  direccionReturnGeneral =new DireccionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			direccionReturnGeneral =new DireccionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			direccionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			direccionReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoDireccion> tipodireccionsForeignKey=new ArrayList<TipoDireccion>();
			TipoDireccionLogic tipodireccionLogic=new TipoDireccionLogic();
			tipodireccionLogic.setConnexion(this.connexion);
			tipodireccionLogic.getTipoDireccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDireccion.equals("NONE")) {
				tipodireccionLogic.getTodosTipoDireccions(finalQueryGlobalTipoDireccion,new Pagination());
				tipodireccionsForeignKey=tipodireccionLogic.getTipoDireccions();
			}

			direccionReturnGeneral.settipodireccionsForeignKey(tipodireccionsForeignKey);


			List<TipoVivienda> tipoviviendasForeignKey=new ArrayList<TipoVivienda>();
			TipoViviendaLogic tipoviviendaLogic=new TipoViviendaLogic();
			tipoviviendaLogic.setConnexion(this.connexion);
			tipoviviendaLogic.getTipoViviendaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoVivienda.equals("NONE")) {
				tipoviviendaLogic.getTodosTipoViviendas(finalQueryGlobalTipoVivienda,new Pagination());
				tipoviviendasForeignKey=tipoviviendaLogic.getTipoViviendas();
			}

			direccionReturnGeneral.settipoviviendasForeignKey(tipoviviendasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return direccionReturnGeneral;
	}
	
	
	public void deepLoad(Direccion direccion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DireccionLogicAdditional.updateDireccionToGet(direccion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		direccion.setEmpresa(direccionDataAccess.getEmpresa(connexion,direccion));
		direccion.setCliente(direccionDataAccess.getCliente(connexion,direccion));
		direccion.setTipoDireccion(direccionDataAccess.getTipoDireccion(connexion,direccion));
		direccion.setTipoVivienda(direccionDataAccess.getTipoVivienda(connexion,direccion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				direccion.setEmpresa(direccionDataAccess.getEmpresa(connexion,direccion));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				direccion.setCliente(direccionDataAccess.getCliente(connexion,direccion));
				continue;
			}

			if(clas.clas.equals(TipoDireccion.class)) {
				direccion.setTipoDireccion(direccionDataAccess.getTipoDireccion(connexion,direccion));
				continue;
			}

			if(clas.clas.equals(TipoVivienda.class)) {
				direccion.setTipoVivienda(direccionDataAccess.getTipoVivienda(connexion,direccion));
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
			direccion.setEmpresa(direccionDataAccess.getEmpresa(connexion,direccion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			direccion.setCliente(direccionDataAccess.getCliente(connexion,direccion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDireccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			direccion.setTipoDireccion(direccionDataAccess.getTipoDireccion(connexion,direccion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoVivienda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			direccion.setTipoVivienda(direccionDataAccess.getTipoVivienda(connexion,direccion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		direccion.setEmpresa(direccionDataAccess.getEmpresa(connexion,direccion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(direccion.getEmpresa(),isDeep,deepLoadType,clases);
				
		direccion.setCliente(direccionDataAccess.getCliente(connexion,direccion));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(direccion.getCliente(),isDeep,deepLoadType,clases);
				
		direccion.setTipoDireccion(direccionDataAccess.getTipoDireccion(connexion,direccion));
		TipoDireccionLogic tipodireccionLogic= new TipoDireccionLogic(connexion);
		tipodireccionLogic.deepLoad(direccion.getTipoDireccion(),isDeep,deepLoadType,clases);
				
		direccion.setTipoVivienda(direccionDataAccess.getTipoVivienda(connexion,direccion));
		TipoViviendaLogic tipoviviendaLogic= new TipoViviendaLogic(connexion);
		tipoviviendaLogic.deepLoad(direccion.getTipoVivienda(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				direccion.setEmpresa(direccionDataAccess.getEmpresa(connexion,direccion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(direccion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				direccion.setCliente(direccionDataAccess.getCliente(connexion,direccion));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(direccion.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDireccion.class)) {
				direccion.setTipoDireccion(direccionDataAccess.getTipoDireccion(connexion,direccion));
				TipoDireccionLogic tipodireccionLogic= new TipoDireccionLogic(connexion);
				tipodireccionLogic.deepLoad(direccion.getTipoDireccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoVivienda.class)) {
				direccion.setTipoVivienda(direccionDataAccess.getTipoVivienda(connexion,direccion));
				TipoViviendaLogic tipoviviendaLogic= new TipoViviendaLogic(connexion);
				tipoviviendaLogic.deepLoad(direccion.getTipoVivienda(),isDeep,deepLoadType,clases);				
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
			direccion.setEmpresa(direccionDataAccess.getEmpresa(connexion,direccion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(direccion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			direccion.setCliente(direccionDataAccess.getCliente(connexion,direccion));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(direccion.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDireccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			direccion.setTipoDireccion(direccionDataAccess.getTipoDireccion(connexion,direccion));
			TipoDireccionLogic tipodireccionLogic= new TipoDireccionLogic(connexion);
			tipodireccionLogic.deepLoad(direccion.getTipoDireccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoVivienda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			direccion.setTipoVivienda(direccionDataAccess.getTipoVivienda(connexion,direccion));
			TipoViviendaLogic tipoviviendaLogic= new TipoViviendaLogic(connexion);
			tipoviviendaLogic.deepLoad(direccion.getTipoVivienda(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Direccion direccion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DireccionLogicAdditional.updateDireccionToSave(direccion,this.arrDatoGeneral);
			
DireccionDataAccess.save(direccion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(direccion.getEmpresa(),connexion);

		ClienteDataAccess.save(direccion.getCliente(),connexion);

		TipoDireccionDataAccess.save(direccion.getTipoDireccion(),connexion);

		TipoViviendaDataAccess.save(direccion.getTipoVivienda(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(direccion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(direccion.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDireccion.class)) {
				TipoDireccionDataAccess.save(direccion.getTipoDireccion(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoVivienda.class)) {
				TipoViviendaDataAccess.save(direccion.getTipoVivienda(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(direccion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(direccion.getEmpresa(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(direccion.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(direccion.getCliente(),isDeep,deepLoadType,clases);
				

		TipoDireccionDataAccess.save(direccion.getTipoDireccion(),connexion);
		TipoDireccionLogic tipodireccionLogic= new TipoDireccionLogic(connexion);
		tipodireccionLogic.deepLoad(direccion.getTipoDireccion(),isDeep,deepLoadType,clases);
				

		TipoViviendaDataAccess.save(direccion.getTipoVivienda(),connexion);
		TipoViviendaLogic tipoviviendaLogic= new TipoViviendaLogic(connexion);
		tipoviviendaLogic.deepLoad(direccion.getTipoVivienda(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(direccion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(direccion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(direccion.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(direccion.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDireccion.class)) {
				TipoDireccionDataAccess.save(direccion.getTipoDireccion(),connexion);
				TipoDireccionLogic tipodireccionLogic= new TipoDireccionLogic(connexion);
				tipodireccionLogic.deepSave(direccion.getTipoDireccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoVivienda.class)) {
				TipoViviendaDataAccess.save(direccion.getTipoVivienda(),connexion);
				TipoViviendaLogic tipoviviendaLogic= new TipoViviendaLogic(connexion);
				tipoviviendaLogic.deepSave(direccion.getTipoVivienda(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(Direccion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(direccion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(direccion);
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
			this.deepLoad(this.direccion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Direccion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(direccions!=null) {
				for(Direccion direccion:direccions) {
					this.deepLoad(direccion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(direccions);
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
			if(direccions!=null) {
				for(Direccion direccion:direccions) {
					this.deepLoad(direccion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(direccions);
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
			this.getNewConnexionToDeep(Direccion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(direccion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Direccion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(direccions!=null) {
				for(Direccion direccion:direccions) {
					this.deepSave(direccion,isDeep,deepLoadType,clases);
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
			if(direccions!=null) {
				for(Direccion direccion:direccions) {
					this.deepSave(direccion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDireccionsFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Direccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,DireccionConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			direccions=direccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDireccionsFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,DireccionConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			direccions=direccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDireccionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Direccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DireccionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			direccions=direccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDireccionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DireccionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			direccions=direccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDireccionsFK_IdValorClienteViviendaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_vivienda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Direccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoVivienda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoVivienda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_vivienda,DireccionConstantesFunciones.IDTIPOVIVIENDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoVivienda);

			DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorClienteVivienda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			direccions=direccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDireccionsFK_IdValorClienteVivienda(String sFinalQuery,Pagination pagination,Long id_tipo_vivienda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoVivienda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoVivienda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_vivienda,DireccionConstantesFunciones.IDTIPOVIVIENDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoVivienda);

			DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorClienteVivienda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			direccions=direccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDireccionsFK_IdValorDireccionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_direccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Direccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDireccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDireccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_direccion,DireccionConstantesFunciones.IDTIPODIRECCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDireccion);

			DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorDireccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			direccions=direccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDireccionsFK_IdValorDireccion(String sFinalQuery,Pagination pagination,Long id_tipo_direccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDireccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDireccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_direccion,DireccionConstantesFunciones.IDTIPODIRECCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDireccion);

			DireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdValorDireccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			direccions=direccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(this.direccions);
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
			if(DireccionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DireccionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Direccion direccion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DireccionConstantesFunciones.ISCONAUDITORIA) {
				if(direccion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DireccionDataAccess.TABLENAME, direccion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DireccionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DireccionLogic.registrarAuditoriaDetallesDireccion(connexion,direccion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(direccion.getIsDeleted()) {
					/*if(!direccion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DireccionDataAccess.TABLENAME, direccion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DireccionLogic.registrarAuditoriaDetallesDireccion(connexion,direccion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DireccionDataAccess.TABLENAME, direccion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(direccion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DireccionDataAccess.TABLENAME, direccion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DireccionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DireccionLogic.registrarAuditoriaDetallesDireccion(connexion,direccion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDireccion(Connexion connexion,Direccion direccion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(direccion.getIsNew()||!direccion.getid_empresa().equals(direccion.getDireccionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(direccion.getDireccionOriginal().getid_empresa()!=null)
				{
					strValorActual=direccion.getDireccionOriginal().getid_empresa().toString();
				}
				if(direccion.getid_empresa()!=null)
				{
					strValorNuevo=direccion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DireccionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(direccion.getIsNew()||!direccion.getid_cliente().equals(direccion.getDireccionOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(direccion.getDireccionOriginal().getid_cliente()!=null)
				{
					strValorActual=direccion.getDireccionOriginal().getid_cliente().toString();
				}
				if(direccion.getid_cliente()!=null)
				{
					strValorNuevo=direccion.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DireccionConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(direccion.getIsNew()||!direccion.getid_tipo_direccion().equals(direccion.getDireccionOriginal().getid_tipo_direccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(direccion.getDireccionOriginal().getid_tipo_direccion()!=null)
				{
					strValorActual=direccion.getDireccionOriginal().getid_tipo_direccion().toString();
				}
				if(direccion.getid_tipo_direccion()!=null)
				{
					strValorNuevo=direccion.getid_tipo_direccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DireccionConstantesFunciones.IDTIPODIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(direccion.getIsNew()||!direccion.getid_tipo_vivienda().equals(direccion.getDireccionOriginal().getid_tipo_vivienda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(direccion.getDireccionOriginal().getid_tipo_vivienda()!=null)
				{
					strValorActual=direccion.getDireccionOriginal().getid_tipo_vivienda().toString();
				}
				if(direccion.getid_tipo_vivienda()!=null)
				{
					strValorNuevo=direccion.getid_tipo_vivienda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DireccionConstantesFunciones.IDTIPOVIVIENDA,strValorActual,strValorNuevo);
			}	
			
			if(direccion.getIsNew()||!direccion.getsector().equals(direccion.getDireccionOriginal().getsector()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(direccion.getDireccionOriginal().getsector()!=null)
				{
					strValorActual=direccion.getDireccionOriginal().getsector();
				}
				if(direccion.getsector()!=null)
				{
					strValorNuevo=direccion.getsector() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DireccionConstantesFunciones.SECTOR,strValorActual,strValorNuevo);
			}	
			
			if(direccion.getIsNew()||!direccion.getbarrio().equals(direccion.getDireccionOriginal().getbarrio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(direccion.getDireccionOriginal().getbarrio()!=null)
				{
					strValorActual=direccion.getDireccionOriginal().getbarrio();
				}
				if(direccion.getbarrio()!=null)
				{
					strValorNuevo=direccion.getbarrio() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DireccionConstantesFunciones.BARRIO,strValorActual,strValorNuevo);
			}	
			
			if(direccion.getIsNew()||!direccion.getcalles().equals(direccion.getDireccionOriginal().getcalles()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(direccion.getDireccionOriginal().getcalles()!=null)
				{
					strValorActual=direccion.getDireccionOriginal().getcalles();
				}
				if(direccion.getcalles()!=null)
				{
					strValorNuevo=direccion.getcalles() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DireccionConstantesFunciones.CALLES,strValorActual,strValorNuevo);
			}	
			
			if(direccion.getIsNew()||!direccion.getasegurada().equals(direccion.getDireccionOriginal().getasegurada()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(direccion.getDireccionOriginal().getasegurada()!=null)
				{
					strValorActual=direccion.getDireccionOriginal().getasegurada();
				}
				if(direccion.getasegurada()!=null)
				{
					strValorNuevo=direccion.getasegurada() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DireccionConstantesFunciones.ASEGURADA,strValorActual,strValorNuevo);
			}	
			
			if(direccion.getIsNew()||!direccion.getdireccion().equals(direccion.getDireccionOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(direccion.getDireccionOriginal().getdireccion()!=null)
				{
					strValorActual=direccion.getDireccionOriginal().getdireccion();
				}
				if(direccion.getdireccion()!=null)
				{
					strValorNuevo=direccion.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DireccionConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(direccion.getIsNew()||!direccion.getesactivo().equals(direccion.getDireccionOriginal().getesactivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(direccion.getDireccionOriginal().getesactivo()!=null)
				{
					strValorActual=direccion.getDireccionOriginal().getesactivo().toString();
				}
				if(direccion.getesactivo()!=null)
				{
					strValorNuevo=direccion.getesactivo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DireccionConstantesFunciones.ESACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDireccionRelacionesWithConnection(Direccion direccion) throws Exception {

		if(!direccion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDireccionRelacionesBase(direccion,true);
		}
	}

	public void saveDireccionRelaciones(Direccion direccion)throws Exception {

		if(!direccion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDireccionRelacionesBase(direccion,false);
		}
	}

	public void saveDireccionRelacionesBase(Direccion direccion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Direccion-saveRelacionesWithConnection");}
	

			this.setDireccion(direccion);

			if(DireccionLogicAdditional.validarSaveRelaciones(direccion,this)) {

				DireccionLogicAdditional.updateRelacionesToSave(direccion,this);

				if((direccion.getIsNew()||direccion.getIsChanged())&&!direccion.getIsDeleted()) {
					this.saveDireccion();
					this.saveDireccionRelacionesDetalles();

				} else if(direccion.getIsDeleted()) {
					this.saveDireccionRelacionesDetalles();
					this.saveDireccion();
				}

				DireccionLogicAdditional.updateRelacionesToSaveAfter(direccion,this);

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
	
	
	private void saveDireccionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDireccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DireccionConstantesFunciones.getClassesForeignKeysOfDireccion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDireccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DireccionConstantesFunciones.getClassesRelationshipsOfDireccion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

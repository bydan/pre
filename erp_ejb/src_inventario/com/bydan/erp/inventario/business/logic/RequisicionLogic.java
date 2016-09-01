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
import com.bydan.erp.inventario.util.RequisicionConstantesFunciones;
import com.bydan.erp.inventario.util.RequisicionParameterReturnGeneral;
//import com.bydan.erp.inventario.util.RequisicionParameterGeneral;
import com.bydan.erp.inventario.business.entity.Requisicion;
import com.bydan.erp.inventario.business.logic.RequisicionLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class RequisicionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(RequisicionLogic.class);
	
	protected RequisicionDataAccess requisicionDataAccess; 	
	protected Requisicion requisicion;
	protected List<Requisicion> requisicions;
	protected Object requisicionObject;	
	protected List<Object> requisicionsObject;
	
	public static ClassValidator<Requisicion> requisicionValidator = new ClassValidator<Requisicion>(Requisicion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected RequisicionLogicAdditional requisicionLogicAdditional=null;
	
	public RequisicionLogicAdditional getRequisicionLogicAdditional() {
		return this.requisicionLogicAdditional;
	}
	
	public void setRequisicionLogicAdditional(RequisicionLogicAdditional requisicionLogicAdditional) {
		try {
			this.requisicionLogicAdditional=requisicionLogicAdditional;
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
	
	
	
	
	public  RequisicionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.requisicionDataAccess = new RequisicionDataAccess();
			
			this.requisicions= new ArrayList<Requisicion>();
			this.requisicion= new Requisicion();
			
			this.requisicionObject=new Object();
			this.requisicionsObject=new ArrayList<Object>();
				
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
			
			this.requisicionDataAccess.setConnexionType(this.connexionType);
			this.requisicionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RequisicionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.requisicionDataAccess = new RequisicionDataAccess();
			this.requisicions= new ArrayList<Requisicion>();
			this.requisicion= new Requisicion();
			this.requisicionObject=new Object();
			this.requisicionsObject=new ArrayList<Object>();
			
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
			
			this.requisicionDataAccess.setConnexionType(this.connexionType);
			this.requisicionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Requisicion getRequisicion() throws Exception {	
		RequisicionLogicAdditional.checkRequisicionToGet(requisicion,this.datosCliente,this.arrDatoGeneral);
		RequisicionLogicAdditional.updateRequisicionToGet(requisicion,this.arrDatoGeneral);
		
		return requisicion;
	}
		
	public void setRequisicion(Requisicion newRequisicion) {
		this.requisicion = newRequisicion;
	}
	
	public RequisicionDataAccess getRequisicionDataAccess() {
		return requisicionDataAccess;
	}
	
	public void setRequisicionDataAccess(RequisicionDataAccess newrequisicionDataAccess) {
		this.requisicionDataAccess = newrequisicionDataAccess;
	}
	
	public List<Requisicion> getRequisicions() throws Exception {		
		this.quitarRequisicionsNulos();
		
		RequisicionLogicAdditional.checkRequisicionToGets(requisicions,this.datosCliente,this.arrDatoGeneral);
		
		for (Requisicion requisicionLocal: requisicions ) {
			RequisicionLogicAdditional.updateRequisicionToGet(requisicionLocal,this.arrDatoGeneral);
		}
		
		return requisicions;
	}
	
	public void setRequisicions(List<Requisicion> newRequisicions) {
		this.requisicions = newRequisicions;
	}
	
	public Object getRequisicionObject() {	
		this.requisicionObject=this.requisicionDataAccess.getEntityObject();
		return this.requisicionObject;
	}
		
	public void setRequisicionObject(Object newRequisicionObject) {
		this.requisicionObject = newRequisicionObject;
	}
	
	public List<Object> getRequisicionsObject() {		
		this.requisicionsObject=this.requisicionDataAccess.getEntitiesObject();
		return this.requisicionsObject;
	}
		
	public void setRequisicionsObject(List<Object> newRequisicionsObject) {
		this.requisicionsObject = newRequisicionsObject;
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
		
		if(this.requisicionDataAccess!=null) {
			this.requisicionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			requisicionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			requisicionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		requisicion = new  Requisicion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			requisicion=requisicionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.requisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicion);
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
		requisicion = new  Requisicion();
		  		  
        try {
			
			requisicion=requisicionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.requisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		requisicion = new  Requisicion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			requisicion=requisicionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.requisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicion);
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
		requisicion = new  Requisicion();
		  		  
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
		requisicion = new  Requisicion();
		  		  
        try {
			
			requisicion=requisicionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.requisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		requisicion = new  Requisicion();
		  		  
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
		requisicion = new  Requisicion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =requisicionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		requisicion = new  Requisicion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=requisicionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		requisicion = new  Requisicion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =requisicionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		requisicion = new  Requisicion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=requisicionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		requisicion = new  Requisicion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =requisicionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		requisicion = new  Requisicion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=requisicionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		requisicions = new  ArrayList<Requisicion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicions=requisicionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRequisicion(requisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
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
		requisicions = new  ArrayList<Requisicion>();
		  		  
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
		requisicions = new  ArrayList<Requisicion>();
		  		  
        try {			
			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicions=requisicionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarRequisicion(requisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		requisicions = new  ArrayList<Requisicion>();
		  		  
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
		requisicions = new  ArrayList<Requisicion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicions=requisicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRequisicion(requisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
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
		requisicions = new  ArrayList<Requisicion>();
		  		  
        try {
			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicions=requisicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRequisicion(requisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
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
		requisicions = new  ArrayList<Requisicion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicions=requisicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRequisicion(requisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
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
		requisicions = new  ArrayList<Requisicion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicions=requisicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRequisicion(requisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		requisicion = new  Requisicion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicion=requisicionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRequisicion(requisicion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicion);
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
		requisicion = new  Requisicion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicion=requisicionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRequisicion(requisicion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		requisicions = new  ArrayList<Requisicion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicions=requisicionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRequisicion(requisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
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
		requisicions = new  ArrayList<Requisicion>();
		  		  
        try {
			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicions=requisicionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRequisicion(requisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosRequisicionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		requisicions = new  ArrayList<Requisicion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-getTodosRequisicionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicions=requisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRequisicion(requisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
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
	
	public  void  getTodosRequisicions(String sFinalQuery,Pagination pagination)throws Exception {
		requisicions = new  ArrayList<Requisicion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			requisicions=requisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRequisicion(requisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarRequisicion(Requisicion requisicion) throws Exception {
		Boolean estaValidado=false;
		
		if(requisicion.getIsNew() || requisicion.getIsChanged()) { 
			this.invalidValues = requisicionValidator.getInvalidValues(requisicion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(requisicion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarRequisicion(List<Requisicion> Requisicions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Requisicion requisicionLocal:requisicions) {				
			estaValidadoObjeto=this.validarGuardarRequisicion(requisicionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarRequisicion(List<Requisicion> Requisicions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRequisicion(requisicions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarRequisicion(Requisicion Requisicion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRequisicion(requisicion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Requisicion requisicion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+requisicion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=RequisicionConstantesFunciones.getRequisicionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"requisicion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(RequisicionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(RequisicionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveRequisicionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-saveRequisicionWithConnection");connexion.begin();			
			
			RequisicionLogicAdditional.checkRequisicionToSave(this.requisicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RequisicionLogicAdditional.updateRequisicionToSave(this.requisicion,this.arrDatoGeneral);
			
			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.requisicion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowRequisicion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRequisicion(this.requisicion)) {
				RequisicionDataAccess.save(this.requisicion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.requisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RequisicionLogicAdditional.checkRequisicionToSaveAfter(this.requisicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRequisicion();
			
			connexion.commit();			
			
			if(this.requisicion.getIsDeleted()) {
				this.requisicion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveRequisicion()throws Exception {	
		try {	
			
			RequisicionLogicAdditional.checkRequisicionToSave(this.requisicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RequisicionLogicAdditional.updateRequisicionToSave(this.requisicion,this.arrDatoGeneral);
			
			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.requisicion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRequisicion(this.requisicion)) {			
				RequisicionDataAccess.save(this.requisicion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.requisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RequisicionLogicAdditional.checkRequisicionToSaveAfter(this.requisicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.requisicion.getIsDeleted()) {
				this.requisicion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveRequisicionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-saveRequisicionsWithConnection");connexion.begin();			
			
			RequisicionLogicAdditional.checkRequisicionToSaves(requisicions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowRequisicions();
			
			Boolean validadoTodosRequisicion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Requisicion requisicionLocal:requisicions) {		
				if(requisicionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RequisicionLogicAdditional.updateRequisicionToSave(requisicionLocal,this.arrDatoGeneral);
	        	
				RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),requisicionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRequisicion(requisicionLocal)) {
					RequisicionDataAccess.save(requisicionLocal, connexion);				
				} else {
					validadoTodosRequisicion=false;
				}
			}
			
			if(!validadoTodosRequisicion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RequisicionLogicAdditional.checkRequisicionToSavesAfter(requisicions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRequisicions();
			
			connexion.commit();		
			
			this.quitarRequisicionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveRequisicions()throws Exception {				
		 try {	
			RequisicionLogicAdditional.checkRequisicionToSaves(requisicions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosRequisicion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Requisicion requisicionLocal:requisicions) {				
				if(requisicionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RequisicionLogicAdditional.updateRequisicionToSave(requisicionLocal,this.arrDatoGeneral);
	        	
				RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),requisicionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRequisicion(requisicionLocal)) {				
					RequisicionDataAccess.save(requisicionLocal, connexion);				
				} else {
					validadoTodosRequisicion=false;
				}
			}
			
			if(!validadoTodosRequisicion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RequisicionLogicAdditional.checkRequisicionToSavesAfter(requisicions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarRequisicionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RequisicionParameterReturnGeneral procesarAccionRequisicions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Requisicion> requisicions,RequisicionParameterReturnGeneral requisicionParameterGeneral)throws Exception {
		 try {	
			RequisicionParameterReturnGeneral requisicionReturnGeneral=new RequisicionParameterReturnGeneral();
	
			RequisicionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,requisicions,requisicionParameterGeneral,requisicionReturnGeneral);
			
			return requisicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RequisicionParameterReturnGeneral procesarAccionRequisicionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Requisicion> requisicions,RequisicionParameterReturnGeneral requisicionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-procesarAccionRequisicionsWithConnection");connexion.begin();			
			
			RequisicionParameterReturnGeneral requisicionReturnGeneral=new RequisicionParameterReturnGeneral();
	
			RequisicionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,requisicions,requisicionParameterGeneral,requisicionReturnGeneral);
			
			this.connexion.commit();
			
			return requisicionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RequisicionParameterReturnGeneral procesarEventosRequisicions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Requisicion> requisicions,Requisicion requisicion,RequisicionParameterReturnGeneral requisicionParameterGeneral,Boolean isEsNuevoRequisicion,ArrayList<Classe> clases)throws Exception {
		 try {	
			RequisicionParameterReturnGeneral requisicionReturnGeneral=new RequisicionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				requisicionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RequisicionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,requisicions,requisicion,requisicionParameterGeneral,requisicionReturnGeneral,isEsNuevoRequisicion,clases);
			
			return requisicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public RequisicionParameterReturnGeneral procesarEventosRequisicionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Requisicion> requisicions,Requisicion requisicion,RequisicionParameterReturnGeneral requisicionParameterGeneral,Boolean isEsNuevoRequisicion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-procesarEventosRequisicionsWithConnection");connexion.begin();			
			
			RequisicionParameterReturnGeneral requisicionReturnGeneral=new RequisicionParameterReturnGeneral();
	
			requisicionReturnGeneral.setRequisicion(requisicion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				requisicionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RequisicionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,requisicions,requisicion,requisicionParameterGeneral,requisicionReturnGeneral,isEsNuevoRequisicion,clases);
			
			this.connexion.commit();
			
			return requisicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RequisicionParameterReturnGeneral procesarImportacionRequisicionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,RequisicionParameterReturnGeneral requisicionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-procesarImportacionRequisicionsWithConnection");connexion.begin();			
			
			RequisicionParameterReturnGeneral requisicionReturnGeneral=new RequisicionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.requisicions=new ArrayList<Requisicion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.requisicion=new Requisicion();
				
				
				if(conColumnasBase) {this.requisicion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.requisicion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.requisicion.setnumero_secuencial(arrColumnas[iColumn++]);
				this.requisicion.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				//this.requisicion.sethora(arrColumnas[iColumn++]);
				this.requisicion.setdescripcion(arrColumnas[iColumn++]);
				
				this.requisicions.add(this.requisicion);
			}
			
			this.saveRequisicions();
			
			this.connexion.commit();
			
			requisicionReturnGeneral.setConRetornoEstaProcesado(true);
			requisicionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return requisicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarRequisicionsEliminados() throws Exception {				
		
		List<Requisicion> requisicionsAux= new ArrayList<Requisicion>();
		
		for(Requisicion requisicion:requisicions) {
			if(!requisicion.getIsDeleted()) {
				requisicionsAux.add(requisicion);
			}
		}
		
		requisicions=requisicionsAux;
	}
	
	public void quitarRequisicionsNulos() throws Exception {				
		
		List<Requisicion> requisicionsAux= new ArrayList<Requisicion>();
		
		for(Requisicion requisicion : this.requisicions) {
			if(requisicion==null) {
				requisicionsAux.add(requisicion);
			}
		}
		
		//this.requisicions=requisicionsAux;
		
		this.requisicions.removeAll(requisicionsAux);
	}
	
	public void getSetVersionRowRequisicionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(requisicion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((requisicion.getIsDeleted() || (requisicion.getIsChanged()&&!requisicion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=requisicionDataAccess.getSetVersionRowRequisicion(connexion,requisicion.getId());
				
				if(!requisicion.getVersionRow().equals(timestamp)) {	
					requisicion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				requisicion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowRequisicion()throws Exception {	
		
		if(requisicion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((requisicion.getIsDeleted() || (requisicion.getIsChanged()&&!requisicion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=requisicionDataAccess.getSetVersionRowRequisicion(connexion,requisicion.getId());
			
			try {							
				if(!requisicion.getVersionRow().equals(timestamp)) {	
					requisicion.setVersionRow(timestamp);
				}
				
				requisicion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowRequisicionsWithConnection()throws Exception {	
		if(requisicions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Requisicion requisicionAux:requisicions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(requisicionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(requisicionAux.getIsDeleted() || (requisicionAux.getIsChanged()&&!requisicionAux.getIsNew())) {
						
						timestamp=requisicionDataAccess.getSetVersionRowRequisicion(connexion,requisicionAux.getId());
						
						if(!requisicion.getVersionRow().equals(timestamp)) {	
							requisicionAux.setVersionRow(timestamp);
						}
								
						requisicionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowRequisicions()throws Exception {	
		if(requisicions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Requisicion requisicionAux:requisicions) {
					if(requisicionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(requisicionAux.getIsDeleted() || (requisicionAux.getIsChanged()&&!requisicionAux.getIsNew())) {
						
						timestamp=requisicionDataAccess.getSetVersionRowRequisicion(connexion,requisicionAux.getId());
						
						if(!requisicionAux.getVersionRow().equals(timestamp)) {	
							requisicionAux.setVersionRow(timestamp);
						}
						
													
						requisicionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public RequisicionParameterReturnGeneral cargarCombosLoteForeignKeyRequisicionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoRequisicion,String finalQueryGlobalEmpleado,String finalQueryGlobalEstadoRequisicion,String finalQueryGlobalFormato,String finalQueryGlobalBodegaSolicitar,String finalQueryGlobalBodegaSolicita) throws Exception {
		RequisicionParameterReturnGeneral  requisicionReturnGeneral =new RequisicionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-cargarCombosLoteForeignKeyRequisicionWithConnection");connexion.begin();
			
			requisicionReturnGeneral =new RequisicionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			requisicionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			requisicionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoRequisicion> tiporequisicionsForeignKey=new ArrayList<TipoRequisicion>();
			TipoRequisicionLogic tiporequisicionLogic=new TipoRequisicionLogic();
			tiporequisicionLogic.setConnexion(this.connexion);
			tiporequisicionLogic.getTipoRequisicionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRequisicion.equals("NONE")) {
				tiporequisicionLogic.getTodosTipoRequisicions(finalQueryGlobalTipoRequisicion,new Pagination());
				tiporequisicionsForeignKey=tiporequisicionLogic.getTipoRequisicions();
			}

			requisicionReturnGeneral.settiporequisicionsForeignKey(tiporequisicionsForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			requisicionReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<EstadoRequisicion> estadorequisicionsForeignKey=new ArrayList<EstadoRequisicion>();
			EstadoRequisicionLogic estadorequisicionLogic=new EstadoRequisicionLogic();
			estadorequisicionLogic.setConnexion(this.connexion);
			estadorequisicionLogic.getEstadoRequisicionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoRequisicion.equals("NONE")) {
				estadorequisicionLogic.getTodosEstadoRequisicions(finalQueryGlobalEstadoRequisicion,new Pagination());
				estadorequisicionsForeignKey=estadorequisicionLogic.getEstadoRequisicions();
			}

			requisicionReturnGeneral.setestadorequisicionsForeignKey(estadorequisicionsForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			requisicionReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Bodega> bodegasolicitarsForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegasolicitarLogic=new BodegaLogic();
			bodegasolicitarLogic.setConnexion(this.connexion);
			bodegasolicitarLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaSolicitar.equals("NONE")) {
				bodegasolicitarLogic.getTodosBodegas(finalQueryGlobalBodegaSolicitar,new Pagination());
				bodegasolicitarsForeignKey=bodegasolicitarLogic.getBodegas();
			}

			requisicionReturnGeneral.setbodegasolicitarsForeignKey(bodegasolicitarsForeignKey);


			List<Bodega> bodegasolicitasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegasolicitaLogic=new BodegaLogic();
			bodegasolicitaLogic.setConnexion(this.connexion);
			bodegasolicitaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaSolicita.equals("NONE")) {
				bodegasolicitaLogic.getTodosBodegas(finalQueryGlobalBodegaSolicita,new Pagination());
				bodegasolicitasForeignKey=bodegasolicitaLogic.getBodegas();
			}

			requisicionReturnGeneral.setbodegasolicitasForeignKey(bodegasolicitasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return requisicionReturnGeneral;
	}
	
	public RequisicionParameterReturnGeneral cargarCombosLoteForeignKeyRequisicion(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoRequisicion,String finalQueryGlobalEmpleado,String finalQueryGlobalEstadoRequisicion,String finalQueryGlobalFormato,String finalQueryGlobalBodegaSolicitar,String finalQueryGlobalBodegaSolicita) throws Exception {
		RequisicionParameterReturnGeneral  requisicionReturnGeneral =new RequisicionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			requisicionReturnGeneral =new RequisicionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			requisicionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			requisicionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoRequisicion> tiporequisicionsForeignKey=new ArrayList<TipoRequisicion>();
			TipoRequisicionLogic tiporequisicionLogic=new TipoRequisicionLogic();
			tiporequisicionLogic.setConnexion(this.connexion);
			tiporequisicionLogic.getTipoRequisicionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRequisicion.equals("NONE")) {
				tiporequisicionLogic.getTodosTipoRequisicions(finalQueryGlobalTipoRequisicion,new Pagination());
				tiporequisicionsForeignKey=tiporequisicionLogic.getTipoRequisicions();
			}

			requisicionReturnGeneral.settiporequisicionsForeignKey(tiporequisicionsForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			requisicionReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<EstadoRequisicion> estadorequisicionsForeignKey=new ArrayList<EstadoRequisicion>();
			EstadoRequisicionLogic estadorequisicionLogic=new EstadoRequisicionLogic();
			estadorequisicionLogic.setConnexion(this.connexion);
			estadorequisicionLogic.getEstadoRequisicionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoRequisicion.equals("NONE")) {
				estadorequisicionLogic.getTodosEstadoRequisicions(finalQueryGlobalEstadoRequisicion,new Pagination());
				estadorequisicionsForeignKey=estadorequisicionLogic.getEstadoRequisicions();
			}

			requisicionReturnGeneral.setestadorequisicionsForeignKey(estadorequisicionsForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			requisicionReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Bodega> bodegasolicitarsForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegasolicitarLogic=new BodegaLogic();
			bodegasolicitarLogic.setConnexion(this.connexion);
			bodegasolicitarLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaSolicitar.equals("NONE")) {
				bodegasolicitarLogic.getTodosBodegas(finalQueryGlobalBodegaSolicitar,new Pagination());
				bodegasolicitarsForeignKey=bodegasolicitarLogic.getBodegas();
			}

			requisicionReturnGeneral.setbodegasolicitarsForeignKey(bodegasolicitarsForeignKey);


			List<Bodega> bodegasolicitasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegasolicitaLogic=new BodegaLogic();
			bodegasolicitaLogic.setConnexion(this.connexion);
			bodegasolicitaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodegaSolicita.equals("NONE")) {
				bodegasolicitaLogic.getTodosBodegas(finalQueryGlobalBodegaSolicita,new Pagination());
				bodegasolicitasForeignKey=bodegasolicitaLogic.getBodegas();
			}

			requisicionReturnGeneral.setbodegasolicitasForeignKey(bodegasolicitasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return requisicionReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyRequisicionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleRequisicionLogic detallerequisicionLogic=new DetalleRequisicionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyRequisicionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleRequisicion.class));
											
			

			detallerequisicionLogic.setConnexion(this.getConnexion());
			detallerequisicionLogic.setDatosCliente(this.datosCliente);
			detallerequisicionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Requisicion requisicion:this.requisicions) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleRequisicionConstantesFunciones.getClassesForeignKeysOfDetalleRequisicion(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallerequisicionLogic.setDetalleRequisicions(requisicion.detallerequisicions);
				detallerequisicionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Requisicion requisicion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RequisicionLogicAdditional.updateRequisicionToGet(requisicion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		requisicion.setEmpresa(requisicionDataAccess.getEmpresa(connexion,requisicion));
		requisicion.setSucursal(requisicionDataAccess.getSucursal(connexion,requisicion));
		requisicion.setTipoRequisicion(requisicionDataAccess.getTipoRequisicion(connexion,requisicion));
		requisicion.setEmpleado(requisicionDataAccess.getEmpleado(connexion,requisicion));
		requisicion.setEstadoRequisicion(requisicionDataAccess.getEstadoRequisicion(connexion,requisicion));
		requisicion.setFormato(requisicionDataAccess.getFormato(connexion,requisicion));
		requisicion.setBodegaSolicitar(requisicionDataAccess.getBodegaSolicitar(connexion,requisicion));
		requisicion.setBodegaSolicita(requisicionDataAccess.getBodegaSolicita(connexion,requisicion));
		requisicion.setDetalleRequisicions(requisicionDataAccess.getDetalleRequisicions(connexion,requisicion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				requisicion.setEmpresa(requisicionDataAccess.getEmpresa(connexion,requisicion));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				requisicion.setSucursal(requisicionDataAccess.getSucursal(connexion,requisicion));
				continue;
			}

			if(clas.clas.equals(TipoRequisicion.class)) {
				requisicion.setTipoRequisicion(requisicionDataAccess.getTipoRequisicion(connexion,requisicion));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				requisicion.setEmpleado(requisicionDataAccess.getEmpleado(connexion,requisicion));
				continue;
			}

			if(clas.clas.equals(EstadoRequisicion.class)) {
				requisicion.setEstadoRequisicion(requisicionDataAccess.getEstadoRequisicion(connexion,requisicion));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				requisicion.setFormato(requisicionDataAccess.getFormato(connexion,requisicion));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				requisicion.setBodegaSolicitar(requisicionDataAccess.getBodegaSolicitar(connexion,requisicion));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				requisicion.setBodegaSolicita(requisicionDataAccess.getBodegaSolicita(connexion,requisicion));
				continue;
			}

			if(clas.clas.equals(DetalleRequisicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				requisicion.setDetalleRequisicions(requisicionDataAccess.getDetalleRequisicions(connexion,requisicion));

				if(this.isConDeep) {
					DetalleRequisicionLogic detallerequisicionLogic= new DetalleRequisicionLogic(this.connexion);
					detallerequisicionLogic.setDetalleRequisicions(requisicion.getDetalleRequisicions());
					ArrayList<Classe> classesLocal=DetalleRequisicionConstantesFunciones.getClassesForeignKeysOfDetalleRequisicion(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallerequisicionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRequisicion(detallerequisicionLogic.getDetalleRequisicions());
					requisicion.setDetalleRequisicions(detallerequisicionLogic.getDetalleRequisicions());
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
			requisicion.setEmpresa(requisicionDataAccess.getEmpresa(connexion,requisicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicion.setSucursal(requisicionDataAccess.getSucursal(connexion,requisicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRequisicion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicion.setTipoRequisicion(requisicionDataAccess.getTipoRequisicion(connexion,requisicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicion.setEmpleado(requisicionDataAccess.getEmpleado(connexion,requisicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoRequisicion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicion.setEstadoRequisicion(requisicionDataAccess.getEstadoRequisicion(connexion,requisicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicion.setFormato(requisicionDataAccess.getFormato(connexion,requisicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicion.setBodegaSolicitar(requisicionDataAccess.getBodegaSolicitar(connexion,requisicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicion.setBodegaSolicita(requisicionDataAccess.getBodegaSolicita(connexion,requisicion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleRequisicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleRequisicion.class));
			requisicion.setDetalleRequisicions(requisicionDataAccess.getDetalleRequisicions(connexion,requisicion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		requisicion.setEmpresa(requisicionDataAccess.getEmpresa(connexion,requisicion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(requisicion.getEmpresa(),isDeep,deepLoadType,clases);
				
		requisicion.setSucursal(requisicionDataAccess.getSucursal(connexion,requisicion));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(requisicion.getSucursal(),isDeep,deepLoadType,clases);
				
		requisicion.setTipoRequisicion(requisicionDataAccess.getTipoRequisicion(connexion,requisicion));
		TipoRequisicionLogic tiporequisicionLogic= new TipoRequisicionLogic(connexion);
		tiporequisicionLogic.deepLoad(requisicion.getTipoRequisicion(),isDeep,deepLoadType,clases);
				
		requisicion.setEmpleado(requisicionDataAccess.getEmpleado(connexion,requisicion));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(requisicion.getEmpleado(),isDeep,deepLoadType,clases);
				
		requisicion.setEstadoRequisicion(requisicionDataAccess.getEstadoRequisicion(connexion,requisicion));
		EstadoRequisicionLogic estadorequisicionLogic= new EstadoRequisicionLogic(connexion);
		estadorequisicionLogic.deepLoad(requisicion.getEstadoRequisicion(),isDeep,deepLoadType,clases);
				
		requisicion.setFormato(requisicionDataAccess.getFormato(connexion,requisicion));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(requisicion.getFormato(),isDeep,deepLoadType,clases);
				
		requisicion.setBodegaSolicitar(requisicionDataAccess.getBodegaSolicitar(connexion,requisicion));
		BodegaLogic bodegasolicitarLogic= new BodegaLogic(connexion);
		bodegasolicitarLogic.deepLoad(requisicion.getBodegaSolicitar(),isDeep,deepLoadType,clases);
				
		requisicion.setBodegaSolicita(requisicionDataAccess.getBodegaSolicita(connexion,requisicion));
		BodegaLogic bodegasolicitaLogic= new BodegaLogic(connexion);
		bodegasolicitaLogic.deepLoad(requisicion.getBodegaSolicita(),isDeep,deepLoadType,clases);
				

		requisicion.setDetalleRequisicions(requisicionDataAccess.getDetalleRequisicions(connexion,requisicion));

		for(DetalleRequisicion detallerequisicion:requisicion.getDetalleRequisicions()) {
			DetalleRequisicionLogic detallerequisicionLogic= new DetalleRequisicionLogic(connexion);
			detallerequisicionLogic.deepLoad(detallerequisicion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				requisicion.setEmpresa(requisicionDataAccess.getEmpresa(connexion,requisicion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(requisicion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				requisicion.setSucursal(requisicionDataAccess.getSucursal(connexion,requisicion));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(requisicion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRequisicion.class)) {
				requisicion.setTipoRequisicion(requisicionDataAccess.getTipoRequisicion(connexion,requisicion));
				TipoRequisicionLogic tiporequisicionLogic= new TipoRequisicionLogic(connexion);
				tiporequisicionLogic.deepLoad(requisicion.getTipoRequisicion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				requisicion.setEmpleado(requisicionDataAccess.getEmpleado(connexion,requisicion));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(requisicion.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoRequisicion.class)) {
				requisicion.setEstadoRequisicion(requisicionDataAccess.getEstadoRequisicion(connexion,requisicion));
				EstadoRequisicionLogic estadorequisicionLogic= new EstadoRequisicionLogic(connexion);
				estadorequisicionLogic.deepLoad(requisicion.getEstadoRequisicion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				requisicion.setFormato(requisicionDataAccess.getFormato(connexion,requisicion));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(requisicion.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				requisicion.setBodegaSolicitar(requisicionDataAccess.getBodegaSolicitar(connexion,requisicion));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(requisicion.getBodegaSolicitar(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				requisicion.setBodegaSolicita(requisicionDataAccess.getBodegaSolicita(connexion,requisicion));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(requisicion.getBodegaSolicita(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleRequisicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				requisicion.setDetalleRequisicions(requisicionDataAccess.getDetalleRequisicions(connexion,requisicion));

				for(DetalleRequisicion detallerequisicion:requisicion.getDetalleRequisicions()) {
					DetalleRequisicionLogic detallerequisicionLogic= new DetalleRequisicionLogic(connexion);
					detallerequisicionLogic.deepLoad(detallerequisicion,isDeep,deepLoadType,clases);
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
			requisicion.setEmpresa(requisicionDataAccess.getEmpresa(connexion,requisicion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(requisicion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicion.setSucursal(requisicionDataAccess.getSucursal(connexion,requisicion));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(requisicion.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRequisicion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicion.setTipoRequisicion(requisicionDataAccess.getTipoRequisicion(connexion,requisicion));
			TipoRequisicionLogic tiporequisicionLogic= new TipoRequisicionLogic(connexion);
			tiporequisicionLogic.deepLoad(requisicion.getTipoRequisicion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicion.setEmpleado(requisicionDataAccess.getEmpleado(connexion,requisicion));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(requisicion.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoRequisicion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicion.setEstadoRequisicion(requisicionDataAccess.getEstadoRequisicion(connexion,requisicion));
			EstadoRequisicionLogic estadorequisicionLogic= new EstadoRequisicionLogic(connexion);
			estadorequisicionLogic.deepLoad(requisicion.getEstadoRequisicion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicion.setFormato(requisicionDataAccess.getFormato(connexion,requisicion));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(requisicion.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicion.setBodegaSolicitar(requisicionDataAccess.getBodegaSolicitar(connexion,requisicion));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(requisicion.getBodegaSolicitar(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			requisicion.setBodegaSolicita(requisicionDataAccess.getBodegaSolicita(connexion,requisicion));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(requisicion.getBodegaSolicita(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleRequisicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleRequisicion.class));
			requisicion.setDetalleRequisicions(requisicionDataAccess.getDetalleRequisicions(connexion,requisicion));

			for(DetalleRequisicion detallerequisicion:requisicion.getDetalleRequisicions()) {
				DetalleRequisicionLogic detallerequisicionLogic= new DetalleRequisicionLogic(connexion);
				detallerequisicionLogic.deepLoad(detallerequisicion,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Requisicion requisicion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			RequisicionLogicAdditional.updateRequisicionToSave(requisicion,this.arrDatoGeneral);
			
RequisicionDataAccess.save(requisicion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(requisicion.getEmpresa(),connexion);

		SucursalDataAccess.save(requisicion.getSucursal(),connexion);

		TipoRequisicionDataAccess.save(requisicion.getTipoRequisicion(),connexion);

		EmpleadoDataAccess.save(requisicion.getEmpleado(),connexion);

		EstadoRequisicionDataAccess.save(requisicion.getEstadoRequisicion(),connexion);

		FormatoDataAccess.save(requisicion.getFormato(),connexion);

		BodegaDataAccess.save(requisicion.getBodegaSolicitar(),connexion);

		BodegaDataAccess.save(requisicion.getBodegaSolicita(),connexion);

		for(DetalleRequisicion detallerequisicion:requisicion.getDetalleRequisicions()) {
			detallerequisicion.setid_requisicion(requisicion.getId());
			DetalleRequisicionDataAccess.save(detallerequisicion,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(requisicion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(requisicion.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRequisicion.class)) {
				TipoRequisicionDataAccess.save(requisicion.getTipoRequisicion(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(requisicion.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoRequisicion.class)) {
				EstadoRequisicionDataAccess.save(requisicion.getEstadoRequisicion(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(requisicion.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(requisicion.getBodegaSolicitar(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(requisicion.getBodegaSolicita(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleRequisicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleRequisicion detallerequisicion:requisicion.getDetalleRequisicions()) {
					detallerequisicion.setid_requisicion(requisicion.getId());
					DetalleRequisicionDataAccess.save(detallerequisicion,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(requisicion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(requisicion.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(requisicion.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(requisicion.getSucursal(),isDeep,deepLoadType,clases);
				

		TipoRequisicionDataAccess.save(requisicion.getTipoRequisicion(),connexion);
		TipoRequisicionLogic tiporequisicionLogic= new TipoRequisicionLogic(connexion);
		tiporequisicionLogic.deepLoad(requisicion.getTipoRequisicion(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(requisicion.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(requisicion.getEmpleado(),isDeep,deepLoadType,clases);
				

		EstadoRequisicionDataAccess.save(requisicion.getEstadoRequisicion(),connexion);
		EstadoRequisicionLogic estadorequisicionLogic= new EstadoRequisicionLogic(connexion);
		estadorequisicionLogic.deepLoad(requisicion.getEstadoRequisicion(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(requisicion.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(requisicion.getFormato(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(requisicion.getBodegaSolicitar(),connexion);
		BodegaLogic bodegasolicitarLogic= new BodegaLogic(connexion);
		bodegasolicitarLogic.deepLoad(requisicion.getBodegaSolicitar(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(requisicion.getBodegaSolicita(),connexion);
		BodegaLogic bodegasolicitaLogic= new BodegaLogic(connexion);
		bodegasolicitaLogic.deepLoad(requisicion.getBodegaSolicita(),isDeep,deepLoadType,clases);
				

		for(DetalleRequisicion detallerequisicion:requisicion.getDetalleRequisicions()) {
			DetalleRequisicionLogic detallerequisicionLogic= new DetalleRequisicionLogic(connexion);
			detallerequisicion.setid_requisicion(requisicion.getId());
			DetalleRequisicionDataAccess.save(detallerequisicion,connexion);
			detallerequisicionLogic.deepSave(detallerequisicion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(requisicion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(requisicion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(requisicion.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(requisicion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRequisicion.class)) {
				TipoRequisicionDataAccess.save(requisicion.getTipoRequisicion(),connexion);
				TipoRequisicionLogic tiporequisicionLogic= new TipoRequisicionLogic(connexion);
				tiporequisicionLogic.deepSave(requisicion.getTipoRequisicion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(requisicion.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(requisicion.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoRequisicion.class)) {
				EstadoRequisicionDataAccess.save(requisicion.getEstadoRequisicion(),connexion);
				EstadoRequisicionLogic estadorequisicionLogic= new EstadoRequisicionLogic(connexion);
				estadorequisicionLogic.deepSave(requisicion.getEstadoRequisicion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(requisicion.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(requisicion.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(requisicion.getBodegaSolicitar(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(requisicion.getBodegaSolicitar(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(requisicion.getBodegaSolicita(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(requisicion.getBodegaSolicita(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleRequisicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleRequisicion detallerequisicion:requisicion.getDetalleRequisicions()) {
					DetalleRequisicionLogic detallerequisicionLogic= new DetalleRequisicionLogic(connexion);
					detallerequisicion.setid_requisicion(requisicion.getId());
					DetalleRequisicionDataAccess.save(detallerequisicion,connexion);
					detallerequisicionLogic.deepSave(detallerequisicion,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Requisicion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(requisicion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(requisicion);
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
			this.deepLoad(this.requisicion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Requisicion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(requisicions!=null) {
				for(Requisicion requisicion:requisicions) {
					this.deepLoad(requisicion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(requisicions);
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
			if(requisicions!=null) {
				for(Requisicion requisicion:requisicions) {
					this.deepLoad(requisicion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(requisicions);
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
			this.getNewConnexionToDeep(Requisicion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(requisicion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Requisicion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(requisicions!=null) {
				for(Requisicion requisicion:requisicions) {
					this.deepSave(requisicion,isDeep,deepLoadType,clases);
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
			if(requisicions!=null) {
				for(Requisicion requisicion:requisicions) {
					this.deepSave(requisicion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getRequisicionsBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String numero_secuencial)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroSecuencial= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroSecuencial.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero_secuencial+"%",RequisicionConstantesFunciones.NUMEROSECUENCIAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroSecuencial);

			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicions=requisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionsBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String numero_secuencial)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroSecuencial= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroSecuencial.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero_secuencial+"%",RequisicionConstantesFunciones.NUMEROSECUENCIAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroSecuencial);

			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicions=requisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRequisicionsFK_IdBodegaSolicitaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega_solicita)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaSolicita= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaSolicita.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_solicita,RequisicionConstantesFunciones.IDBODEGASOLICITA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaSolicita);

			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaSolicita","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicions=requisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionsFK_IdBodegaSolicita(String sFinalQuery,Pagination pagination,Long id_bodega_solicita)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaSolicita= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaSolicita.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_solicita,RequisicionConstantesFunciones.IDBODEGASOLICITA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaSolicita);

			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaSolicita","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicions=requisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRequisicionsFK_IdBodegaSolicitarWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega_solicitar)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaSolicitar= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaSolicitar.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_solicitar,RequisicionConstantesFunciones.IDBODEGASOLICITAR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaSolicitar);

			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaSolicitar","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicions=requisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionsFK_IdBodegaSolicitar(String sFinalQuery,Pagination pagination,Long id_bodega_solicitar)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodegaSolicitar= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodegaSolicitar.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega_solicitar,RequisicionConstantesFunciones.IDBODEGASOLICITAR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodegaSolicitar);

			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodegaSolicitar","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicions=requisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRequisicionsFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,RequisicionConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicions=requisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionsFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,RequisicionConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicions=requisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRequisicionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RequisicionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicions=requisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RequisicionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicions=requisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRequisicionsFK_IdEstadoRequisicionWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_requisicion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoRequisicion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoRequisicion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_requisicion,RequisicionConstantesFunciones.IDESTADOREQUISICION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoRequisicion);

			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoRequisicion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicions=requisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionsFK_IdEstadoRequisicion(String sFinalQuery,Pagination pagination,Long id_estado_requisicion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoRequisicion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoRequisicion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_requisicion,RequisicionConstantesFunciones.IDESTADOREQUISICION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoRequisicion);

			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoRequisicion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicions=requisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRequisicionsFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,RequisicionConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicions=requisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionsFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,RequisicionConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicions=requisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRequisicionsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,RequisicionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicions=requisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,RequisicionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicions=requisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRequisicionsFK_IdTipoRequisicionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_requisicion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Requisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRequisicion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRequisicion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_requisicion,RequisicionConstantesFunciones.IDTIPOREQUISICION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRequisicion);

			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRequisicion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicions=requisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRequisicionsFK_IdTipoRequisicion(String sFinalQuery,Pagination pagination,Long id_tipo_requisicion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRequisicion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRequisicion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_requisicion,RequisicionConstantesFunciones.IDTIPOREQUISICION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRequisicion);

			RequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRequisicion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			requisicions=requisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RequisicionConstantesFunciones.refrescarForeignKeysDescripcionesRequisicion(this.requisicions);
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
			if(RequisicionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,RequisicionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Requisicion requisicion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(RequisicionConstantesFunciones.ISCONAUDITORIA) {
				if(requisicion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RequisicionDataAccess.TABLENAME, requisicion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RequisicionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RequisicionLogic.registrarAuditoriaDetallesRequisicion(connexion,requisicion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(requisicion.getIsDeleted()) {
					/*if(!requisicion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,RequisicionDataAccess.TABLENAME, requisicion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////RequisicionLogic.registrarAuditoriaDetallesRequisicion(connexion,requisicion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RequisicionDataAccess.TABLENAME, requisicion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(requisicion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RequisicionDataAccess.TABLENAME, requisicion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RequisicionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RequisicionLogic.registrarAuditoriaDetallesRequisicion(connexion,requisicion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesRequisicion(Connexion connexion,Requisicion requisicion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(requisicion.getIsNew()||!requisicion.getid_empresa().equals(requisicion.getRequisicionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicion.getRequisicionOriginal().getid_empresa()!=null)
				{
					strValorActual=requisicion.getRequisicionOriginal().getid_empresa().toString();
				}
				if(requisicion.getid_empresa()!=null)
				{
					strValorNuevo=requisicion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(requisicion.getIsNew()||!requisicion.getid_sucursal().equals(requisicion.getRequisicionOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicion.getRequisicionOriginal().getid_sucursal()!=null)
				{
					strValorActual=requisicion.getRequisicionOriginal().getid_sucursal().toString();
				}
				if(requisicion.getid_sucursal()!=null)
				{
					strValorNuevo=requisicion.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(requisicion.getIsNew()||!requisicion.getnumero_secuencial().equals(requisicion.getRequisicionOriginal().getnumero_secuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicion.getRequisicionOriginal().getnumero_secuencial()!=null)
				{
					strValorActual=requisicion.getRequisicionOriginal().getnumero_secuencial();
				}
				if(requisicion.getnumero_secuencial()!=null)
				{
					strValorNuevo=requisicion.getnumero_secuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionConstantesFunciones.NUMEROSECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(requisicion.getIsNew()||!requisicion.getid_tipo_requisicion().equals(requisicion.getRequisicionOriginal().getid_tipo_requisicion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicion.getRequisicionOriginal().getid_tipo_requisicion()!=null)
				{
					strValorActual=requisicion.getRequisicionOriginal().getid_tipo_requisicion().toString();
				}
				if(requisicion.getid_tipo_requisicion()!=null)
				{
					strValorNuevo=requisicion.getid_tipo_requisicion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionConstantesFunciones.IDTIPOREQUISICION,strValorActual,strValorNuevo);
			}	
			
			if(requisicion.getIsNew()||!requisicion.getfecha().equals(requisicion.getRequisicionOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicion.getRequisicionOriginal().getfecha()!=null)
				{
					strValorActual=requisicion.getRequisicionOriginal().getfecha().toString();
				}
				if(requisicion.getfecha()!=null)
				{
					strValorNuevo=requisicion.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(requisicion.getIsNew()||!requisicion.gethora().equals(requisicion.getRequisicionOriginal().gethora()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicion.getRequisicionOriginal().gethora()!=null)
				{
					strValorActual=requisicion.getRequisicionOriginal().gethora().toString();
				}
				if(requisicion.gethora()!=null)
				{
					strValorNuevo=requisicion.gethora().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionConstantesFunciones.HORA,strValorActual,strValorNuevo);
			}	
			
			if(requisicion.getIsNew()||!requisicion.getid_empleado().equals(requisicion.getRequisicionOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicion.getRequisicionOriginal().getid_empleado()!=null)
				{
					strValorActual=requisicion.getRequisicionOriginal().getid_empleado().toString();
				}
				if(requisicion.getid_empleado()!=null)
				{
					strValorNuevo=requisicion.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(requisicion.getIsNew()||!requisicion.getid_estado_requisicion().equals(requisicion.getRequisicionOriginal().getid_estado_requisicion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicion.getRequisicionOriginal().getid_estado_requisicion()!=null)
				{
					strValorActual=requisicion.getRequisicionOriginal().getid_estado_requisicion().toString();
				}
				if(requisicion.getid_estado_requisicion()!=null)
				{
					strValorNuevo=requisicion.getid_estado_requisicion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionConstantesFunciones.IDESTADOREQUISICION,strValorActual,strValorNuevo);
			}	
			
			if(requisicion.getIsNew()||!requisicion.getid_formato().equals(requisicion.getRequisicionOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicion.getRequisicionOriginal().getid_formato()!=null)
				{
					strValorActual=requisicion.getRequisicionOriginal().getid_formato().toString();
				}
				if(requisicion.getid_formato()!=null)
				{
					strValorNuevo=requisicion.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(requisicion.getIsNew()||!requisicion.getid_bodega_solicitar().equals(requisicion.getRequisicionOriginal().getid_bodega_solicitar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicion.getRequisicionOriginal().getid_bodega_solicitar()!=null)
				{
					strValorActual=requisicion.getRequisicionOriginal().getid_bodega_solicitar().toString();
				}
				if(requisicion.getid_bodega_solicitar()!=null)
				{
					strValorNuevo=requisicion.getid_bodega_solicitar().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionConstantesFunciones.IDBODEGASOLICITAR,strValorActual,strValorNuevo);
			}	
			
			if(requisicion.getIsNew()||!requisicion.getdescripcion().equals(requisicion.getRequisicionOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicion.getRequisicionOriginal().getdescripcion()!=null)
				{
					strValorActual=requisicion.getRequisicionOriginal().getdescripcion();
				}
				if(requisicion.getdescripcion()!=null)
				{
					strValorNuevo=requisicion.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(requisicion.getIsNew()||!requisicion.getid_bodega_solicita().equals(requisicion.getRequisicionOriginal().getid_bodega_solicita()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(requisicion.getRequisicionOriginal().getid_bodega_solicita()!=null)
				{
					strValorActual=requisicion.getRequisicionOriginal().getid_bodega_solicita().toString();
				}
				if(requisicion.getid_bodega_solicita()!=null)
				{
					strValorNuevo=requisicion.getid_bodega_solicita().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RequisicionConstantesFunciones.IDBODEGASOLICITA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveRequisicionRelacionesWithConnection(Requisicion requisicion,List<DetalleRequisicion> detallerequisicions) throws Exception {

		if(!requisicion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRequisicionRelacionesBase(requisicion,detallerequisicions,true);
		}
	}

	public void saveRequisicionRelaciones(Requisicion requisicion,List<DetalleRequisicion> detallerequisicions)throws Exception {

		if(!requisicion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRequisicionRelacionesBase(requisicion,detallerequisicions,false);
		}
	}

	public void saveRequisicionRelacionesBase(Requisicion requisicion,List<DetalleRequisicion> detallerequisicions,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Requisicion-saveRelacionesWithConnection");}
	
			requisicion.setDetalleRequisicions(detallerequisicions);

			this.setRequisicion(requisicion);

			if(RequisicionLogicAdditional.validarSaveRelaciones(requisicion,this)) {

				RequisicionLogicAdditional.updateRelacionesToSave(requisicion,this);

				if((requisicion.getIsNew()||requisicion.getIsChanged())&&!requisicion.getIsDeleted()) {
					this.saveRequisicion();
					this.saveRequisicionRelacionesDetalles(detallerequisicions);

				} else if(requisicion.getIsDeleted()) {
					this.saveRequisicionRelacionesDetalles(detallerequisicions);
					this.saveRequisicion();
				}

				RequisicionLogicAdditional.updateRelacionesToSaveAfter(requisicion,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleRequisicionConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleRequisicions(detallerequisicions,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveRequisicionRelacionesDetalles(List<DetalleRequisicion> detallerequisicions)throws Exception {
		try {
	

			Long idRequisicionActual=this.getRequisicion().getId();

			DetalleRequisicionLogic detallerequisicionLogic_Desde_Requisicion=new DetalleRequisicionLogic();
			detallerequisicionLogic_Desde_Requisicion.setDetalleRequisicions(detallerequisicions);

			detallerequisicionLogic_Desde_Requisicion.setConnexion(this.getConnexion());
			detallerequisicionLogic_Desde_Requisicion.setDatosCliente(this.datosCliente);

			for(DetalleRequisicion detallerequisicion_Desde_Requisicion:detallerequisicionLogic_Desde_Requisicion.getDetalleRequisicions()) {
				detallerequisicion_Desde_Requisicion.setid_requisicion(idRequisicionActual);
			}

			detallerequisicionLogic_Desde_Requisicion.saveDetalleRequisicions();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfRequisicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RequisicionConstantesFunciones.getClassesForeignKeysOfRequisicion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRequisicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RequisicionConstantesFunciones.getClassesRelationshipsOfRequisicion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

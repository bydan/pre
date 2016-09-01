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
import com.bydan.erp.cartera.util.RecapConstantesFunciones;
import com.bydan.erp.cartera.util.RecapParameterReturnGeneral;
//import com.bydan.erp.cartera.util.RecapParameterGeneral;
import com.bydan.erp.cartera.business.entity.Recap;
import com.bydan.erp.cartera.business.logic.RecapLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class RecapLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(RecapLogic.class);
	
	protected RecapDataAccess recapDataAccess; 	
	protected Recap recap;
	protected List<Recap> recaps;
	protected Object recapObject;	
	protected List<Object> recapsObject;
	
	public static ClassValidator<Recap> recapValidator = new ClassValidator<Recap>(Recap.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected RecapLogicAdditional recapLogicAdditional=null;
	
	public RecapLogicAdditional getRecapLogicAdditional() {
		return this.recapLogicAdditional;
	}
	
	public void setRecapLogicAdditional(RecapLogicAdditional recapLogicAdditional) {
		try {
			this.recapLogicAdditional=recapLogicAdditional;
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
	
	
	
	
	public  RecapLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.recapDataAccess = new RecapDataAccess();
			
			this.recaps= new ArrayList<Recap>();
			this.recap= new Recap();
			
			this.recapObject=new Object();
			this.recapsObject=new ArrayList<Object>();
				
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
			
			this.recapDataAccess.setConnexionType(this.connexionType);
			this.recapDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RecapLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.recapDataAccess = new RecapDataAccess();
			this.recaps= new ArrayList<Recap>();
			this.recap= new Recap();
			this.recapObject=new Object();
			this.recapsObject=new ArrayList<Object>();
			
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
			
			this.recapDataAccess.setConnexionType(this.connexionType);
			this.recapDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Recap getRecap() throws Exception {	
		RecapLogicAdditional.checkRecapToGet(recap,this.datosCliente,this.arrDatoGeneral);
		RecapLogicAdditional.updateRecapToGet(recap,this.arrDatoGeneral);
		
		return recap;
	}
		
	public void setRecap(Recap newRecap) {
		this.recap = newRecap;
	}
	
	public RecapDataAccess getRecapDataAccess() {
		return recapDataAccess;
	}
	
	public void setRecapDataAccess(RecapDataAccess newrecapDataAccess) {
		this.recapDataAccess = newrecapDataAccess;
	}
	
	public List<Recap> getRecaps() throws Exception {		
		this.quitarRecapsNulos();
		
		RecapLogicAdditional.checkRecapToGets(recaps,this.datosCliente,this.arrDatoGeneral);
		
		for (Recap recapLocal: recaps ) {
			RecapLogicAdditional.updateRecapToGet(recapLocal,this.arrDatoGeneral);
		}
		
		return recaps;
	}
	
	public void setRecaps(List<Recap> newRecaps) {
		this.recaps = newRecaps;
	}
	
	public Object getRecapObject() {	
		this.recapObject=this.recapDataAccess.getEntityObject();
		return this.recapObject;
	}
		
	public void setRecapObject(Object newRecapObject) {
		this.recapObject = newRecapObject;
	}
	
	public List<Object> getRecapsObject() {		
		this.recapsObject=this.recapDataAccess.getEntitiesObject();
		return this.recapsObject;
	}
		
	public void setRecapsObject(List<Object> newRecapsObject) {
		this.recapsObject = newRecapsObject;
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
		
		if(this.recapDataAccess!=null) {
			this.recapDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Recap.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			recapDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			recapDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		recap = new  Recap();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Recap.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			recap=recapDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.recap,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recap);
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
		recap = new  Recap();
		  		  
        try {
			
			recap=recapDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.recap,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recap);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		recap = new  Recap();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Recap.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			recap=recapDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.recap,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recap);
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
		recap = new  Recap();
		  		  
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
		recap = new  Recap();
		  		  
        try {
			
			recap=recapDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.recap,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recap);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		recap = new  Recap();
		  		  
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
		recap = new  Recap();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Recap.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =recapDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		recap = new  Recap();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=recapDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		recap = new  Recap();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Recap.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =recapDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		recap = new  Recap();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=recapDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		recap = new  Recap();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Recap.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =recapDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		recap = new  Recap();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=recapDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		recaps = new  ArrayList<Recap>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Recap.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			RecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recaps=recapDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRecap(recaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recaps);
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
		recaps = new  ArrayList<Recap>();
		  		  
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
		recaps = new  ArrayList<Recap>();
		  		  
        try {			
			RecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recaps=recapDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarRecap(recaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recaps);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		recaps = new  ArrayList<Recap>();
		  		  
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
		recaps = new  ArrayList<Recap>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Recap.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			RecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recaps=recapDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRecap(recaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recaps);
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
		recaps = new  ArrayList<Recap>();
		  		  
        try {
			RecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recaps=recapDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRecap(recaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recaps);
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
		recaps = new  ArrayList<Recap>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Recap.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recaps=recapDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRecap(recaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recaps);
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
		recaps = new  ArrayList<Recap>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recaps=recapDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRecap(recaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recaps);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		recap = new  Recap();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Recap.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recap=recapDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRecap(recap);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recap);
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
		recap = new  Recap();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recap=recapDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRecap(recap);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recap);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		recaps = new  ArrayList<Recap>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Recap.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			RecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recaps=recapDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRecap(recaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recaps);
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
		recaps = new  ArrayList<Recap>();
		  		  
        try {
			RecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recaps=recapDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRecap(recaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recaps);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosRecapsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		recaps = new  ArrayList<Recap>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Recap.class.getSimpleName()+"-getTodosRecapsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recaps=recapDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRecap(recaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recaps);
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
	
	public  void  getTodosRecaps(String sFinalQuery,Pagination pagination)throws Exception {
		recaps = new  ArrayList<Recap>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			recaps=recapDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRecap(recaps);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recaps);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarRecap(Recap recap) throws Exception {
		Boolean estaValidado=false;
		
		if(recap.getIsNew() || recap.getIsChanged()) { 
			this.invalidValues = recapValidator.getInvalidValues(recap);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(recap);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarRecap(List<Recap> Recaps) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Recap recapLocal:recaps) {				
			estaValidadoObjeto=this.validarGuardarRecap(recapLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarRecap(List<Recap> Recaps) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRecap(recaps)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarRecap(Recap Recap) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRecap(recap)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Recap recap) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+recap.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=RecapConstantesFunciones.getRecapLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"recap","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(RecapConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(RecapConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveRecapWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Recap.class.getSimpleName()+"-saveRecapWithConnection");connexion.begin();			
			
			RecapLogicAdditional.checkRecapToSave(this.recap,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RecapLogicAdditional.updateRecapToSave(this.recap,this.arrDatoGeneral);
			
			RecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.recap,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowRecap();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRecap(this.recap)) {
				RecapDataAccess.save(this.recap, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.recap,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RecapLogicAdditional.checkRecapToSaveAfter(this.recap,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRecap();
			
			connexion.commit();			
			
			if(this.recap.getIsDeleted()) {
				this.recap=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveRecap()throws Exception {	
		try {	
			
			RecapLogicAdditional.checkRecapToSave(this.recap,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RecapLogicAdditional.updateRecapToSave(this.recap,this.arrDatoGeneral);
			
			RecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.recap,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRecap(this.recap)) {			
				RecapDataAccess.save(this.recap, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.recap,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RecapLogicAdditional.checkRecapToSaveAfter(this.recap,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.recap.getIsDeleted()) {
				this.recap=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveRecapsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Recap.class.getSimpleName()+"-saveRecapsWithConnection");connexion.begin();			
			
			RecapLogicAdditional.checkRecapToSaves(recaps,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowRecaps();
			
			Boolean validadoTodosRecap=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Recap recapLocal:recaps) {		
				if(recapLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RecapLogicAdditional.updateRecapToSave(recapLocal,this.arrDatoGeneral);
	        	
				RecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),recapLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRecap(recapLocal)) {
					RecapDataAccess.save(recapLocal, connexion);				
				} else {
					validadoTodosRecap=false;
				}
			}
			
			if(!validadoTodosRecap) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RecapLogicAdditional.checkRecapToSavesAfter(recaps,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRecaps();
			
			connexion.commit();		
			
			this.quitarRecapsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveRecaps()throws Exception {				
		 try {	
			RecapLogicAdditional.checkRecapToSaves(recaps,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosRecap=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Recap recapLocal:recaps) {				
				if(recapLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RecapLogicAdditional.updateRecapToSave(recapLocal,this.arrDatoGeneral);
	        	
				RecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),recapLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRecap(recapLocal)) {				
					RecapDataAccess.save(recapLocal, connexion);				
				} else {
					validadoTodosRecap=false;
				}
			}
			
			if(!validadoTodosRecap) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RecapLogicAdditional.checkRecapToSavesAfter(recaps,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarRecapsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RecapParameterReturnGeneral procesarAccionRecaps(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Recap> recaps,RecapParameterReturnGeneral recapParameterGeneral)throws Exception {
		 try {	
			RecapParameterReturnGeneral recapReturnGeneral=new RecapParameterReturnGeneral();
	
			RecapLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,recaps,recapParameterGeneral,recapReturnGeneral);
			
			return recapReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RecapParameterReturnGeneral procesarAccionRecapsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Recap> recaps,RecapParameterReturnGeneral recapParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Recap.class.getSimpleName()+"-procesarAccionRecapsWithConnection");connexion.begin();			
			
			RecapParameterReturnGeneral recapReturnGeneral=new RecapParameterReturnGeneral();
	
			RecapLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,recaps,recapParameterGeneral,recapReturnGeneral);
			
			this.connexion.commit();
			
			return recapReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RecapParameterReturnGeneral procesarEventosRecaps(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Recap> recaps,Recap recap,RecapParameterReturnGeneral recapParameterGeneral,Boolean isEsNuevoRecap,ArrayList<Classe> clases)throws Exception {
		 try {	
			RecapParameterReturnGeneral recapReturnGeneral=new RecapParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				recapReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RecapLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,recaps,recap,recapParameterGeneral,recapReturnGeneral,isEsNuevoRecap,clases);
			
			return recapReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public RecapParameterReturnGeneral procesarEventosRecapsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Recap> recaps,Recap recap,RecapParameterReturnGeneral recapParameterGeneral,Boolean isEsNuevoRecap,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Recap.class.getSimpleName()+"-procesarEventosRecapsWithConnection");connexion.begin();			
			
			RecapParameterReturnGeneral recapReturnGeneral=new RecapParameterReturnGeneral();
	
			recapReturnGeneral.setRecap(recap);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				recapReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RecapLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,recaps,recap,recapParameterGeneral,recapReturnGeneral,isEsNuevoRecap,clases);
			
			this.connexion.commit();
			
			return recapReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RecapParameterReturnGeneral procesarImportacionRecapsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,RecapParameterReturnGeneral recapParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Recap.class.getSimpleName()+"-procesarImportacionRecapsWithConnection");connexion.begin();			
			
			RecapParameterReturnGeneral recapReturnGeneral=new RecapParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.recaps=new ArrayList<Recap>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.recap=new Recap();
				
				
				if(conColumnasBase) {this.recap.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.recap.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.recap.setnumero(arrColumnas[iColumn++]);
				this.recap.setnumero_autorizacion(arrColumnas[iColumn++]);
				this.recap.setfecha_inicio(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.recap.setfecha_final(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.recap.setfecha_elaboracion(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.recap.setfecha_caducidad(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.recap.setmonto_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.recap.setsin_monto_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.recap.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.recap.setotro_impuesto(Double.parseDouble(arrColumnas[iColumn++]));
				this.recap.setvalor_propuesto(Double.parseDouble(arrColumnas[iColumn++]));
				this.recap.setsubtotal(Double.parseDouble(arrColumnas[iColumn++]));
				this.recap.setfinanciero(Double.parseDouble(arrColumnas[iColumn++]));
				this.recap.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				this.recap.setvalor_cambio(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.recaps.add(this.recap);
			}
			
			this.saveRecaps();
			
			this.connexion.commit();
			
			recapReturnGeneral.setConRetornoEstaProcesado(true);
			recapReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return recapReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarRecapsEliminados() throws Exception {				
		
		List<Recap> recapsAux= new ArrayList<Recap>();
		
		for(Recap recap:recaps) {
			if(!recap.getIsDeleted()) {
				recapsAux.add(recap);
			}
		}
		
		recaps=recapsAux;
	}
	
	public void quitarRecapsNulos() throws Exception {				
		
		List<Recap> recapsAux= new ArrayList<Recap>();
		
		for(Recap recap : this.recaps) {
			if(recap==null) {
				recapsAux.add(recap);
			}
		}
		
		//this.recaps=recapsAux;
		
		this.recaps.removeAll(recapsAux);
	}
	
	public void getSetVersionRowRecapWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(recap.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((recap.getIsDeleted() || (recap.getIsChanged()&&!recap.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=recapDataAccess.getSetVersionRowRecap(connexion,recap.getId());
				
				if(!recap.getVersionRow().equals(timestamp)) {	
					recap.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				recap.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowRecap()throws Exception {	
		
		if(recap.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((recap.getIsDeleted() || (recap.getIsChanged()&&!recap.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=recapDataAccess.getSetVersionRowRecap(connexion,recap.getId());
			
			try {							
				if(!recap.getVersionRow().equals(timestamp)) {	
					recap.setVersionRow(timestamp);
				}
				
				recap.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowRecapsWithConnection()throws Exception {	
		if(recaps!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Recap recapAux:recaps) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(recapAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(recapAux.getIsDeleted() || (recapAux.getIsChanged()&&!recapAux.getIsNew())) {
						
						timestamp=recapDataAccess.getSetVersionRowRecap(connexion,recapAux.getId());
						
						if(!recap.getVersionRow().equals(timestamp)) {	
							recapAux.setVersionRow(timestamp);
						}
								
						recapAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowRecaps()throws Exception {	
		if(recaps!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Recap recapAux:recaps) {
					if(recapAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(recapAux.getIsDeleted() || (recapAux.getIsChanged()&&!recapAux.getIsNew())) {
						
						timestamp=recapDataAccess.getSetVersionRowRecap(connexion,recapAux.getId());
						
						if(!recapAux.getVersionRow().equals(timestamp)) {	
							recapAux.setVersionRow(timestamp);
						}
						
													
						recapAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public RecapParameterReturnGeneral cargarCombosLoteForeignKeyRecapWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio) throws Exception {
		RecapParameterReturnGeneral  recapReturnGeneral =new RecapParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Recap.class.getSimpleName()+"-cargarCombosLoteForeignKeyRecapWithConnection");connexion.begin();
			
			recapReturnGeneral =new RecapParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			recapReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			recapReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			recapReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return recapReturnGeneral;
	}
	
	public RecapParameterReturnGeneral cargarCombosLoteForeignKeyRecap(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio) throws Exception {
		RecapParameterReturnGeneral  recapReturnGeneral =new RecapParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			recapReturnGeneral =new RecapParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			recapReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			recapReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			recapReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return recapReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyRecapWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleRecapLogic detallerecapLogic=new DetalleRecapLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Recap.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyRecapWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleRecap.class));
											
			

			detallerecapLogic.setConnexion(this.getConnexion());
			detallerecapLogic.setDatosCliente(this.datosCliente);
			detallerecapLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Recap recap:this.recaps) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleRecapConstantesFunciones.getClassesForeignKeysOfDetalleRecap(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallerecapLogic.setDetalleRecaps(recap.detallerecaps);
				detallerecapLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Recap recap,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RecapLogicAdditional.updateRecapToGet(recap,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		recap.setEmpresa(recapDataAccess.getEmpresa(connexion,recap));
		recap.setSucursal(recapDataAccess.getSucursal(connexion,recap));
		recap.setEjercicio(recapDataAccess.getEjercicio(connexion,recap));
		recap.setDetalleRecaps(recapDataAccess.getDetalleRecaps(connexion,recap));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				recap.setEmpresa(recapDataAccess.getEmpresa(connexion,recap));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				recap.setSucursal(recapDataAccess.getSucursal(connexion,recap));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				recap.setEjercicio(recapDataAccess.getEjercicio(connexion,recap));
				continue;
			}

			if(clas.clas.equals(DetalleRecap.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				recap.setDetalleRecaps(recapDataAccess.getDetalleRecaps(connexion,recap));

				if(this.isConDeep) {
					DetalleRecapLogic detallerecapLogic= new DetalleRecapLogic(this.connexion);
					detallerecapLogic.setDetalleRecaps(recap.getDetalleRecaps());
					ArrayList<Classe> classesLocal=DetalleRecapConstantesFunciones.getClassesForeignKeysOfDetalleRecap(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallerecapLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(detallerecapLogic.getDetalleRecaps());
					recap.setDetalleRecaps(detallerecapLogic.getDetalleRecaps());
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
			recap.setEmpresa(recapDataAccess.getEmpresa(connexion,recap));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			recap.setSucursal(recapDataAccess.getSucursal(connexion,recap));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			recap.setEjercicio(recapDataAccess.getEjercicio(connexion,recap));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleRecap.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleRecap.class));
			recap.setDetalleRecaps(recapDataAccess.getDetalleRecaps(connexion,recap));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		recap.setEmpresa(recapDataAccess.getEmpresa(connexion,recap));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(recap.getEmpresa(),isDeep,deepLoadType,clases);
				
		recap.setSucursal(recapDataAccess.getSucursal(connexion,recap));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(recap.getSucursal(),isDeep,deepLoadType,clases);
				
		recap.setEjercicio(recapDataAccess.getEjercicio(connexion,recap));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(recap.getEjercicio(),isDeep,deepLoadType,clases);
				

		recap.setDetalleRecaps(recapDataAccess.getDetalleRecaps(connexion,recap));

		for(DetalleRecap detallerecap:recap.getDetalleRecaps()) {
			DetalleRecapLogic detallerecapLogic= new DetalleRecapLogic(connexion);
			detallerecapLogic.deepLoad(detallerecap,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				recap.setEmpresa(recapDataAccess.getEmpresa(connexion,recap));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(recap.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				recap.setSucursal(recapDataAccess.getSucursal(connexion,recap));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(recap.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				recap.setEjercicio(recapDataAccess.getEjercicio(connexion,recap));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(recap.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleRecap.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				recap.setDetalleRecaps(recapDataAccess.getDetalleRecaps(connexion,recap));

				for(DetalleRecap detallerecap:recap.getDetalleRecaps()) {
					DetalleRecapLogic detallerecapLogic= new DetalleRecapLogic(connexion);
					detallerecapLogic.deepLoad(detallerecap,isDeep,deepLoadType,clases);
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
			recap.setEmpresa(recapDataAccess.getEmpresa(connexion,recap));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(recap.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			recap.setSucursal(recapDataAccess.getSucursal(connexion,recap));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(recap.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			recap.setEjercicio(recapDataAccess.getEjercicio(connexion,recap));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(recap.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleRecap.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleRecap.class));
			recap.setDetalleRecaps(recapDataAccess.getDetalleRecaps(connexion,recap));

			for(DetalleRecap detallerecap:recap.getDetalleRecaps()) {
				DetalleRecapLogic detallerecapLogic= new DetalleRecapLogic(connexion);
				detallerecapLogic.deepLoad(detallerecap,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Recap recap,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			RecapLogicAdditional.updateRecapToSave(recap,this.arrDatoGeneral);
			
RecapDataAccess.save(recap, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(recap.getEmpresa(),connexion);

		SucursalDataAccess.save(recap.getSucursal(),connexion);

		EjercicioDataAccess.save(recap.getEjercicio(),connexion);

		for(DetalleRecap detallerecap:recap.getDetalleRecaps()) {
			detallerecap.setid_recap(recap.getId());
			DetalleRecapDataAccess.save(detallerecap,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(recap.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(recap.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(recap.getEjercicio(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleRecap.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleRecap detallerecap:recap.getDetalleRecaps()) {
					detallerecap.setid_recap(recap.getId());
					DetalleRecapDataAccess.save(detallerecap,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(recap.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(recap.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(recap.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(recap.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(recap.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(recap.getEjercicio(),isDeep,deepLoadType,clases);
				

		for(DetalleRecap detallerecap:recap.getDetalleRecaps()) {
			DetalleRecapLogic detallerecapLogic= new DetalleRecapLogic(connexion);
			detallerecap.setid_recap(recap.getId());
			DetalleRecapDataAccess.save(detallerecap,connexion);
			detallerecapLogic.deepSave(detallerecap,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(recap.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(recap.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(recap.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(recap.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(recap.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(recap.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleRecap.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleRecap detallerecap:recap.getDetalleRecaps()) {
					DetalleRecapLogic detallerecapLogic= new DetalleRecapLogic(connexion);
					detallerecap.setid_recap(recap.getId());
					DetalleRecapDataAccess.save(detallerecap,connexion);
					detallerecapLogic.deepSave(detallerecap,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Recap.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(recap,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(recap);
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
			this.deepLoad(this.recap,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recap);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Recap.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(recaps!=null) {
				for(Recap recap:recaps) {
					this.deepLoad(recap,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(recaps);
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
			if(recaps!=null) {
				for(Recap recap:recaps) {
					this.deepLoad(recap,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(recaps);
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
			this.getNewConnexionToDeep(Recap.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(recap,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Recap.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(recaps!=null) {
				for(Recap recap:recaps) {
					this.deepSave(recap,isDeep,deepLoadType,clases);
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
			if(recaps!=null) {
				for(Recap recap:recaps) {
					this.deepSave(recap,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getRecapsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Recap.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,RecapConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			RecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			recaps=recapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recaps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRecapsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,RecapConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			RecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			recaps=recapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recaps);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRecapsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Recap.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RecapConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			recaps=recapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recaps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRecapsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RecapConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			recaps=recapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recaps);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRecapsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Recap.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,RecapConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			RecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			recaps=recapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recaps);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRecapsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,RecapConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			RecapLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			recaps=recapDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RecapConstantesFunciones.refrescarForeignKeysDescripcionesRecap(this.recaps);
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
			if(RecapConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,RecapDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Recap recap,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(RecapConstantesFunciones.ISCONAUDITORIA) {
				if(recap.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RecapDataAccess.TABLENAME, recap.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RecapConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RecapLogic.registrarAuditoriaDetallesRecap(connexion,recap,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(recap.getIsDeleted()) {
					/*if(!recap.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,RecapDataAccess.TABLENAME, recap.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////RecapLogic.registrarAuditoriaDetallesRecap(connexion,recap,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RecapDataAccess.TABLENAME, recap.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(recap.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RecapDataAccess.TABLENAME, recap.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RecapConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RecapLogic.registrarAuditoriaDetallesRecap(connexion,recap,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesRecap(Connexion connexion,Recap recap)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(recap.getIsNew()||!recap.getid_empresa().equals(recap.getRecapOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recap.getRecapOriginal().getid_empresa()!=null)
				{
					strValorActual=recap.getRecapOriginal().getid_empresa().toString();
				}
				if(recap.getid_empresa()!=null)
				{
					strValorNuevo=recap.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecapConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(recap.getIsNew()||!recap.getid_sucursal().equals(recap.getRecapOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recap.getRecapOriginal().getid_sucursal()!=null)
				{
					strValorActual=recap.getRecapOriginal().getid_sucursal().toString();
				}
				if(recap.getid_sucursal()!=null)
				{
					strValorNuevo=recap.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecapConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(recap.getIsNew()||!recap.getid_ejercicio().equals(recap.getRecapOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recap.getRecapOriginal().getid_ejercicio()!=null)
				{
					strValorActual=recap.getRecapOriginal().getid_ejercicio().toString();
				}
				if(recap.getid_ejercicio()!=null)
				{
					strValorNuevo=recap.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecapConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(recap.getIsNew()||!recap.getnumero().equals(recap.getRecapOriginal().getnumero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recap.getRecapOriginal().getnumero()!=null)
				{
					strValorActual=recap.getRecapOriginal().getnumero();
				}
				if(recap.getnumero()!=null)
				{
					strValorNuevo=recap.getnumero() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecapConstantesFunciones.NUMERO,strValorActual,strValorNuevo);
			}	
			
			if(recap.getIsNew()||!recap.getnumero_autorizacion().equals(recap.getRecapOriginal().getnumero_autorizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recap.getRecapOriginal().getnumero_autorizacion()!=null)
				{
					strValorActual=recap.getRecapOriginal().getnumero_autorizacion();
				}
				if(recap.getnumero_autorizacion()!=null)
				{
					strValorNuevo=recap.getnumero_autorizacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecapConstantesFunciones.NUMEROAUTORIZACION,strValorActual,strValorNuevo);
			}	
			
			if(recap.getIsNew()||!recap.getfecha_inicio().equals(recap.getRecapOriginal().getfecha_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recap.getRecapOriginal().getfecha_inicio()!=null)
				{
					strValorActual=recap.getRecapOriginal().getfecha_inicio().toString();
				}
				if(recap.getfecha_inicio()!=null)
				{
					strValorNuevo=recap.getfecha_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecapConstantesFunciones.FECHAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(recap.getIsNew()||!recap.getfecha_final().equals(recap.getRecapOriginal().getfecha_final()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recap.getRecapOriginal().getfecha_final()!=null)
				{
					strValorActual=recap.getRecapOriginal().getfecha_final().toString();
				}
				if(recap.getfecha_final()!=null)
				{
					strValorNuevo=recap.getfecha_final().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecapConstantesFunciones.FECHAFINAL,strValorActual,strValorNuevo);
			}	
			
			if(recap.getIsNew()||!recap.getfecha_elaboracion().equals(recap.getRecapOriginal().getfecha_elaboracion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recap.getRecapOriginal().getfecha_elaboracion()!=null)
				{
					strValorActual=recap.getRecapOriginal().getfecha_elaboracion().toString();
				}
				if(recap.getfecha_elaboracion()!=null)
				{
					strValorNuevo=recap.getfecha_elaboracion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecapConstantesFunciones.FECHAELABORACION,strValorActual,strValorNuevo);
			}	
			
			if(recap.getIsNew()||!recap.getfecha_caducidad().equals(recap.getRecapOriginal().getfecha_caducidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recap.getRecapOriginal().getfecha_caducidad()!=null)
				{
					strValorActual=recap.getRecapOriginal().getfecha_caducidad().toString();
				}
				if(recap.getfecha_caducidad()!=null)
				{
					strValorNuevo=recap.getfecha_caducidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecapConstantesFunciones.FECHACADUCIDAD,strValorActual,strValorNuevo);
			}	
			
			if(recap.getIsNew()||!recap.getmonto_iva().equals(recap.getRecapOriginal().getmonto_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recap.getRecapOriginal().getmonto_iva()!=null)
				{
					strValorActual=recap.getRecapOriginal().getmonto_iva().toString();
				}
				if(recap.getmonto_iva()!=null)
				{
					strValorNuevo=recap.getmonto_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecapConstantesFunciones.MONTOIVA,strValorActual,strValorNuevo);
			}	
			
			if(recap.getIsNew()||!recap.getsin_monto_iva().equals(recap.getRecapOriginal().getsin_monto_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recap.getRecapOriginal().getsin_monto_iva()!=null)
				{
					strValorActual=recap.getRecapOriginal().getsin_monto_iva().toString();
				}
				if(recap.getsin_monto_iva()!=null)
				{
					strValorNuevo=recap.getsin_monto_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecapConstantesFunciones.SINMONTOIVA,strValorActual,strValorNuevo);
			}	
			
			if(recap.getIsNew()||!recap.getiva().equals(recap.getRecapOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recap.getRecapOriginal().getiva()!=null)
				{
					strValorActual=recap.getRecapOriginal().getiva().toString();
				}
				if(recap.getiva()!=null)
				{
					strValorNuevo=recap.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecapConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(recap.getIsNew()||!recap.getotro_impuesto().equals(recap.getRecapOriginal().getotro_impuesto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recap.getRecapOriginal().getotro_impuesto()!=null)
				{
					strValorActual=recap.getRecapOriginal().getotro_impuesto().toString();
				}
				if(recap.getotro_impuesto()!=null)
				{
					strValorNuevo=recap.getotro_impuesto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecapConstantesFunciones.OTROIMPUESTO,strValorActual,strValorNuevo);
			}	
			
			if(recap.getIsNew()||!recap.getvalor_propuesto().equals(recap.getRecapOriginal().getvalor_propuesto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recap.getRecapOriginal().getvalor_propuesto()!=null)
				{
					strValorActual=recap.getRecapOriginal().getvalor_propuesto().toString();
				}
				if(recap.getvalor_propuesto()!=null)
				{
					strValorNuevo=recap.getvalor_propuesto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecapConstantesFunciones.VALORPROPUESTO,strValorActual,strValorNuevo);
			}	
			
			if(recap.getIsNew()||!recap.getsubtotal().equals(recap.getRecapOriginal().getsubtotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recap.getRecapOriginal().getsubtotal()!=null)
				{
					strValorActual=recap.getRecapOriginal().getsubtotal().toString();
				}
				if(recap.getsubtotal()!=null)
				{
					strValorNuevo=recap.getsubtotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecapConstantesFunciones.SUBTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(recap.getIsNew()||!recap.getfinanciero().equals(recap.getRecapOriginal().getfinanciero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recap.getRecapOriginal().getfinanciero()!=null)
				{
					strValorActual=recap.getRecapOriginal().getfinanciero().toString();
				}
				if(recap.getfinanciero()!=null)
				{
					strValorNuevo=recap.getfinanciero().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecapConstantesFunciones.FINANCIERO,strValorActual,strValorNuevo);
			}	
			
			if(recap.getIsNew()||!recap.gettotal().equals(recap.getRecapOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recap.getRecapOriginal().gettotal()!=null)
				{
					strValorActual=recap.getRecapOriginal().gettotal().toString();
				}
				if(recap.gettotal()!=null)
				{
					strValorNuevo=recap.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecapConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(recap.getIsNew()||!recap.getvalor_cambio().equals(recap.getRecapOriginal().getvalor_cambio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(recap.getRecapOriginal().getvalor_cambio()!=null)
				{
					strValorActual=recap.getRecapOriginal().getvalor_cambio().toString();
				}
				if(recap.getvalor_cambio()!=null)
				{
					strValorNuevo=recap.getvalor_cambio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RecapConstantesFunciones.VALORCAMBIO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveRecapRelacionesWithConnection(Recap recap,List<DetalleRecap> detallerecaps) throws Exception {

		if(!recap.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRecapRelacionesBase(recap,detallerecaps,true);
		}
	}

	public void saveRecapRelaciones(Recap recap,List<DetalleRecap> detallerecaps)throws Exception {

		if(!recap.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRecapRelacionesBase(recap,detallerecaps,false);
		}
	}

	public void saveRecapRelacionesBase(Recap recap,List<DetalleRecap> detallerecaps,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Recap-saveRelacionesWithConnection");}
	
			recap.setDetalleRecaps(detallerecaps);

			this.setRecap(recap);

			if(RecapLogicAdditional.validarSaveRelaciones(recap,this)) {

				RecapLogicAdditional.updateRelacionesToSave(recap,this);

				if((recap.getIsNew()||recap.getIsChanged())&&!recap.getIsDeleted()) {
					this.saveRecap();
					this.saveRecapRelacionesDetalles(detallerecaps);

				} else if(recap.getIsDeleted()) {
					this.saveRecapRelacionesDetalles(detallerecaps);
					this.saveRecap();
				}

				RecapLogicAdditional.updateRelacionesToSaveAfter(recap,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleRecapConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleRecaps(detallerecaps,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveRecapRelacionesDetalles(List<DetalleRecap> detallerecaps)throws Exception {
		try {
	

			Long idRecapActual=this.getRecap().getId();

			DetalleRecapLogic detallerecapLogic_Desde_Recap=new DetalleRecapLogic();
			detallerecapLogic_Desde_Recap.setDetalleRecaps(detallerecaps);

			detallerecapLogic_Desde_Recap.setConnexion(this.getConnexion());
			detallerecapLogic_Desde_Recap.setDatosCliente(this.datosCliente);

			for(DetalleRecap detallerecap_Desde_Recap:detallerecapLogic_Desde_Recap.getDetalleRecaps()) {
				detallerecap_Desde_Recap.setid_recap(idRecapActual);
			}

			detallerecapLogic_Desde_Recap.saveDetalleRecaps();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfRecap(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RecapConstantesFunciones.getClassesForeignKeysOfRecap(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRecap(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RecapConstantesFunciones.getClassesRelationshipsOfRecap(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.nomina.util.BarrioConstantesFunciones;
import com.bydan.erp.nomina.util.BarrioParameterReturnGeneral;
//import com.bydan.erp.nomina.util.BarrioParameterGeneral;
import com.bydan.erp.nomina.business.entity.Barrio;
import com.bydan.erp.nomina.business.logic.BarrioLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class BarrioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(BarrioLogic.class);
	
	protected BarrioDataAccess barrioDataAccess; 	
	protected Barrio barrio;
	protected List<Barrio> barrios;
	protected Object barrioObject;	
	protected List<Object> barriosObject;
	
	public static ClassValidator<Barrio> barrioValidator = new ClassValidator<Barrio>(Barrio.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected BarrioLogicAdditional barrioLogicAdditional=null;
	
	public BarrioLogicAdditional getBarrioLogicAdditional() {
		return this.barrioLogicAdditional;
	}
	
	public void setBarrioLogicAdditional(BarrioLogicAdditional barrioLogicAdditional) {
		try {
			this.barrioLogicAdditional=barrioLogicAdditional;
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
	
	
	
	
	public  BarrioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.barrioDataAccess = new BarrioDataAccess();
			
			this.barrios= new ArrayList<Barrio>();
			this.barrio= new Barrio();
			
			this.barrioObject=new Object();
			this.barriosObject=new ArrayList<Object>();
				
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
			
			this.barrioDataAccess.setConnexionType(this.connexionType);
			this.barrioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  BarrioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.barrioDataAccess = new BarrioDataAccess();
			this.barrios= new ArrayList<Barrio>();
			this.barrio= new Barrio();
			this.barrioObject=new Object();
			this.barriosObject=new ArrayList<Object>();
			
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
			
			this.barrioDataAccess.setConnexionType(this.connexionType);
			this.barrioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Barrio getBarrio() throws Exception {	
		BarrioLogicAdditional.checkBarrioToGet(barrio,this.datosCliente,this.arrDatoGeneral);
		BarrioLogicAdditional.updateBarrioToGet(barrio,this.arrDatoGeneral);
		
		return barrio;
	}
		
	public void setBarrio(Barrio newBarrio) {
		this.barrio = newBarrio;
	}
	
	public BarrioDataAccess getBarrioDataAccess() {
		return barrioDataAccess;
	}
	
	public void setBarrioDataAccess(BarrioDataAccess newbarrioDataAccess) {
		this.barrioDataAccess = newbarrioDataAccess;
	}
	
	public List<Barrio> getBarrios() throws Exception {		
		this.quitarBarriosNulos();
		
		BarrioLogicAdditional.checkBarrioToGets(barrios,this.datosCliente,this.arrDatoGeneral);
		
		for (Barrio barrioLocal: barrios ) {
			BarrioLogicAdditional.updateBarrioToGet(barrioLocal,this.arrDatoGeneral);
		}
		
		return barrios;
	}
	
	public void setBarrios(List<Barrio> newBarrios) {
		this.barrios = newBarrios;
	}
	
	public Object getBarrioObject() {	
		this.barrioObject=this.barrioDataAccess.getEntityObject();
		return this.barrioObject;
	}
		
	public void setBarrioObject(Object newBarrioObject) {
		this.barrioObject = newBarrioObject;
	}
	
	public List<Object> getBarriosObject() {		
		this.barriosObject=this.barrioDataAccess.getEntitiesObject();
		return this.barriosObject;
	}
		
	public void setBarriosObject(List<Object> newBarriosObject) {
		this.barriosObject = newBarriosObject;
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
		
		if(this.barrioDataAccess!=null) {
			this.barrioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Barrio.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			barrioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			barrioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		barrio = new  Barrio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Barrio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			barrio=barrioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.barrio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrio);
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
		barrio = new  Barrio();
		  		  
        try {
			
			barrio=barrioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.barrio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		barrio = new  Barrio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Barrio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			barrio=barrioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.barrio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrio);
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
		barrio = new  Barrio();
		  		  
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
		barrio = new  Barrio();
		  		  
        try {
			
			barrio=barrioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.barrio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		barrio = new  Barrio();
		  		  
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
		barrio = new  Barrio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Barrio.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =barrioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		barrio = new  Barrio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=barrioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		barrio = new  Barrio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Barrio.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =barrioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		barrio = new  Barrio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=barrioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		barrio = new  Barrio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Barrio.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =barrioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		barrio = new  Barrio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=barrioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		barrios = new  ArrayList<Barrio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Barrio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			BarrioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			barrios=barrioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBarrio(barrios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrios);
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
		barrios = new  ArrayList<Barrio>();
		  		  
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
		barrios = new  ArrayList<Barrio>();
		  		  
        try {			
			BarrioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			barrios=barrioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarBarrio(barrios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		barrios = new  ArrayList<Barrio>();
		  		  
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
		barrios = new  ArrayList<Barrio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Barrio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			BarrioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			barrios=barrioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBarrio(barrios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrios);
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
		barrios = new  ArrayList<Barrio>();
		  		  
        try {
			BarrioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			barrios=barrioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBarrio(barrios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrios);
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
		barrios = new  ArrayList<Barrio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Barrio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BarrioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			barrios=barrioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBarrio(barrios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrios);
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
		barrios = new  ArrayList<Barrio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BarrioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			barrios=barrioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBarrio(barrios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		barrio = new  Barrio();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Barrio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BarrioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			barrio=barrioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBarrio(barrio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrio);
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
		barrio = new  Barrio();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BarrioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			barrio=barrioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBarrio(barrio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		barrios = new  ArrayList<Barrio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Barrio.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			BarrioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			barrios=barrioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBarrio(barrios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrios);
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
		barrios = new  ArrayList<Barrio>();
		  		  
        try {
			BarrioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			barrios=barrioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBarrio(barrios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosBarriosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		barrios = new  ArrayList<Barrio>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Barrio.class.getSimpleName()+"-getTodosBarriosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BarrioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			barrios=barrioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarBarrio(barrios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrios);
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
	
	public  void  getTodosBarrios(String sFinalQuery,Pagination pagination)throws Exception {
		barrios = new  ArrayList<Barrio>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BarrioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			barrios=barrioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarBarrio(barrios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarBarrio(Barrio barrio) throws Exception {
		Boolean estaValidado=false;
		
		if(barrio.getIsNew() || barrio.getIsChanged()) { 
			this.invalidValues = barrioValidator.getInvalidValues(barrio);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(barrio);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarBarrio(List<Barrio> Barrios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Barrio barrioLocal:barrios) {				
			estaValidadoObjeto=this.validarGuardarBarrio(barrioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarBarrio(List<Barrio> Barrios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarBarrio(barrios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarBarrio(Barrio Barrio) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarBarrio(barrio)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Barrio barrio) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+barrio.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=BarrioConstantesFunciones.getBarrioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"barrio","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(BarrioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(BarrioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveBarrioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Barrio.class.getSimpleName()+"-saveBarrioWithConnection");connexion.begin();			
			
			BarrioLogicAdditional.checkBarrioToSave(this.barrio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			BarrioLogicAdditional.updateBarrioToSave(this.barrio,this.arrDatoGeneral);
			
			BarrioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.barrio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowBarrio();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarBarrio(this.barrio)) {
				BarrioDataAccess.save(this.barrio, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.barrio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			BarrioLogicAdditional.checkBarrioToSaveAfter(this.barrio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowBarrio();
			
			connexion.commit();			
			
			if(this.barrio.getIsDeleted()) {
				this.barrio=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveBarrio()throws Exception {	
		try {	
			
			BarrioLogicAdditional.checkBarrioToSave(this.barrio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			BarrioLogicAdditional.updateBarrioToSave(this.barrio,this.arrDatoGeneral);
			
			BarrioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.barrio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarBarrio(this.barrio)) {			
				BarrioDataAccess.save(this.barrio, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.barrio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			BarrioLogicAdditional.checkBarrioToSaveAfter(this.barrio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.barrio.getIsDeleted()) {
				this.barrio=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveBarriosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Barrio.class.getSimpleName()+"-saveBarriosWithConnection");connexion.begin();			
			
			BarrioLogicAdditional.checkBarrioToSaves(barrios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowBarrios();
			
			Boolean validadoTodosBarrio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Barrio barrioLocal:barrios) {		
				if(barrioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				BarrioLogicAdditional.updateBarrioToSave(barrioLocal,this.arrDatoGeneral);
	        	
				BarrioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),barrioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarBarrio(barrioLocal)) {
					BarrioDataAccess.save(barrioLocal, connexion);				
				} else {
					validadoTodosBarrio=false;
				}
			}
			
			if(!validadoTodosBarrio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			BarrioLogicAdditional.checkBarrioToSavesAfter(barrios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowBarrios();
			
			connexion.commit();		
			
			this.quitarBarriosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveBarrios()throws Exception {				
		 try {	
			BarrioLogicAdditional.checkBarrioToSaves(barrios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosBarrio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Barrio barrioLocal:barrios) {				
				if(barrioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				BarrioLogicAdditional.updateBarrioToSave(barrioLocal,this.arrDatoGeneral);
	        	
				BarrioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),barrioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarBarrio(barrioLocal)) {				
					BarrioDataAccess.save(barrioLocal, connexion);				
				} else {
					validadoTodosBarrio=false;
				}
			}
			
			if(!validadoTodosBarrio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			BarrioLogicAdditional.checkBarrioToSavesAfter(barrios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarBarriosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public BarrioParameterReturnGeneral procesarAccionBarrios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Barrio> barrios,BarrioParameterReturnGeneral barrioParameterGeneral)throws Exception {
		 try {	
			BarrioParameterReturnGeneral barrioReturnGeneral=new BarrioParameterReturnGeneral();
	
			BarrioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,barrios,barrioParameterGeneral,barrioReturnGeneral);
			
			return barrioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public BarrioParameterReturnGeneral procesarAccionBarriosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Barrio> barrios,BarrioParameterReturnGeneral barrioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Barrio.class.getSimpleName()+"-procesarAccionBarriosWithConnection");connexion.begin();			
			
			BarrioParameterReturnGeneral barrioReturnGeneral=new BarrioParameterReturnGeneral();
	
			BarrioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,barrios,barrioParameterGeneral,barrioReturnGeneral);
			
			this.connexion.commit();
			
			return barrioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public BarrioParameterReturnGeneral procesarEventosBarrios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Barrio> barrios,Barrio barrio,BarrioParameterReturnGeneral barrioParameterGeneral,Boolean isEsNuevoBarrio,ArrayList<Classe> clases)throws Exception {
		 try {	
			BarrioParameterReturnGeneral barrioReturnGeneral=new BarrioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				barrioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			BarrioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,barrios,barrio,barrioParameterGeneral,barrioReturnGeneral,isEsNuevoBarrio,clases);
			
			return barrioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public BarrioParameterReturnGeneral procesarEventosBarriosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Barrio> barrios,Barrio barrio,BarrioParameterReturnGeneral barrioParameterGeneral,Boolean isEsNuevoBarrio,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Barrio.class.getSimpleName()+"-procesarEventosBarriosWithConnection");connexion.begin();			
			
			BarrioParameterReturnGeneral barrioReturnGeneral=new BarrioParameterReturnGeneral();
	
			barrioReturnGeneral.setBarrio(barrio);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				barrioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			BarrioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,barrios,barrio,barrioParameterGeneral,barrioReturnGeneral,isEsNuevoBarrio,clases);
			
			this.connexion.commit();
			
			return barrioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public BarrioParameterReturnGeneral procesarImportacionBarriosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,BarrioParameterReturnGeneral barrioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Barrio.class.getSimpleName()+"-procesarImportacionBarriosWithConnection");connexion.begin();			
			
			BarrioParameterReturnGeneral barrioReturnGeneral=new BarrioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.barrios=new ArrayList<Barrio>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.barrio=new Barrio();
				
				
				if(conColumnasBase) {this.barrio.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.barrio.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.barrio.setcodigo(arrColumnas[iColumn++]);
				this.barrio.setnombre(arrColumnas[iColumn++]);
				
				this.barrios.add(this.barrio);
			}
			
			this.saveBarrios();
			
			this.connexion.commit();
			
			barrioReturnGeneral.setConRetornoEstaProcesado(true);
			barrioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return barrioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarBarriosEliminados() throws Exception {				
		
		List<Barrio> barriosAux= new ArrayList<Barrio>();
		
		for(Barrio barrio:barrios) {
			if(!barrio.getIsDeleted()) {
				barriosAux.add(barrio);
			}
		}
		
		barrios=barriosAux;
	}
	
	public void quitarBarriosNulos() throws Exception {				
		
		List<Barrio> barriosAux= new ArrayList<Barrio>();
		
		for(Barrio barrio : this.barrios) {
			if(barrio==null) {
				barriosAux.add(barrio);
			}
		}
		
		//this.barrios=barriosAux;
		
		this.barrios.removeAll(barriosAux);
	}
	
	public void getSetVersionRowBarrioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(barrio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((barrio.getIsDeleted() || (barrio.getIsChanged()&&!barrio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=barrioDataAccess.getSetVersionRowBarrio(connexion,barrio.getId());
				
				if(!barrio.getVersionRow().equals(timestamp)) {	
					barrio.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				barrio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowBarrio()throws Exception {	
		
		if(barrio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((barrio.getIsDeleted() || (barrio.getIsChanged()&&!barrio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=barrioDataAccess.getSetVersionRowBarrio(connexion,barrio.getId());
			
			try {							
				if(!barrio.getVersionRow().equals(timestamp)) {	
					barrio.setVersionRow(timestamp);
				}
				
				barrio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowBarriosWithConnection()throws Exception {	
		if(barrios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Barrio barrioAux:barrios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(barrioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(barrioAux.getIsDeleted() || (barrioAux.getIsChanged()&&!barrioAux.getIsNew())) {
						
						timestamp=barrioDataAccess.getSetVersionRowBarrio(connexion,barrioAux.getId());
						
						if(!barrio.getVersionRow().equals(timestamp)) {	
							barrioAux.setVersionRow(timestamp);
						}
								
						barrioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowBarrios()throws Exception {	
		if(barrios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Barrio barrioAux:barrios) {
					if(barrioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(barrioAux.getIsDeleted() || (barrioAux.getIsChanged()&&!barrioAux.getIsNew())) {
						
						timestamp=barrioDataAccess.getSetVersionRowBarrio(connexion,barrioAux.getId());
						
						if(!barrioAux.getVersionRow().equals(timestamp)) {	
							barrioAux.setVersionRow(timestamp);
						}
						
													
						barrioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public BarrioParameterReturnGeneral cargarCombosLoteForeignKeyBarrioWithConnection(String finalQueryGlobalProvincia,String finalQueryGlobalCanton,String finalQueryGlobalParroquia) throws Exception {
		BarrioParameterReturnGeneral  barrioReturnGeneral =new BarrioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Barrio.class.getSimpleName()+"-cargarCombosLoteForeignKeyBarrioWithConnection");connexion.begin();
			
			barrioReturnGeneral =new BarrioParameterReturnGeneral();
			
			

			List<Provincia> provinciasForeignKey=new ArrayList<Provincia>();
			ProvinciaLogic provinciaLogic=new ProvinciaLogic();
			provinciaLogic.setConnexion(this.connexion);
			provinciaLogic.getProvinciaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProvincia.equals("NONE")) {
				provinciaLogic.getTodosProvincias(finalQueryGlobalProvincia,new Pagination());
				provinciasForeignKey=provinciaLogic.getProvincias();
			}

			barrioReturnGeneral.setprovinciasForeignKey(provinciasForeignKey);


			List<Canton> cantonsForeignKey=new ArrayList<Canton>();
			CantonLogic cantonLogic=new CantonLogic();
			cantonLogic.setConnexion(this.connexion);
			cantonLogic.getCantonDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCanton.equals("NONE")) {
				cantonLogic.getTodosCantons(finalQueryGlobalCanton,new Pagination());
				cantonsForeignKey=cantonLogic.getCantons();
			}

			barrioReturnGeneral.setcantonsForeignKey(cantonsForeignKey);


			List<Parroquia> parroquiasForeignKey=new ArrayList<Parroquia>();
			ParroquiaLogic parroquiaLogic=new ParroquiaLogic();
			parroquiaLogic.setConnexion(this.connexion);
			parroquiaLogic.getParroquiaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalParroquia.equals("NONE")) {
				parroquiaLogic.getTodosParroquias(finalQueryGlobalParroquia,new Pagination());
				parroquiasForeignKey=parroquiaLogic.getParroquias();
			}

			barrioReturnGeneral.setparroquiasForeignKey(parroquiasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return barrioReturnGeneral;
	}
	
	public BarrioParameterReturnGeneral cargarCombosLoteForeignKeyBarrio(String finalQueryGlobalProvincia,String finalQueryGlobalCanton,String finalQueryGlobalParroquia) throws Exception {
		BarrioParameterReturnGeneral  barrioReturnGeneral =new BarrioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			barrioReturnGeneral =new BarrioParameterReturnGeneral();
			
			

			List<Provincia> provinciasForeignKey=new ArrayList<Provincia>();
			ProvinciaLogic provinciaLogic=new ProvinciaLogic();
			provinciaLogic.setConnexion(this.connexion);
			provinciaLogic.getProvinciaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProvincia.equals("NONE")) {
				provinciaLogic.getTodosProvincias(finalQueryGlobalProvincia,new Pagination());
				provinciasForeignKey=provinciaLogic.getProvincias();
			}

			barrioReturnGeneral.setprovinciasForeignKey(provinciasForeignKey);


			List<Canton> cantonsForeignKey=new ArrayList<Canton>();
			CantonLogic cantonLogic=new CantonLogic();
			cantonLogic.setConnexion(this.connexion);
			cantonLogic.getCantonDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCanton.equals("NONE")) {
				cantonLogic.getTodosCantons(finalQueryGlobalCanton,new Pagination());
				cantonsForeignKey=cantonLogic.getCantons();
			}

			barrioReturnGeneral.setcantonsForeignKey(cantonsForeignKey);


			List<Parroquia> parroquiasForeignKey=new ArrayList<Parroquia>();
			ParroquiaLogic parroquiaLogic=new ParroquiaLogic();
			parroquiaLogic.setConnexion(this.connexion);
			parroquiaLogic.getParroquiaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalParroquia.equals("NONE")) {
				parroquiaLogic.getTodosParroquias(finalQueryGlobalParroquia,new Pagination());
				parroquiasForeignKey=parroquiaLogic.getParroquias();
			}

			barrioReturnGeneral.setparroquiasForeignKey(parroquiasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return barrioReturnGeneral;
	}
	
	
	public void deepLoad(Barrio barrio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			BarrioLogicAdditional.updateBarrioToGet(barrio,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		barrio.setProvincia(barrioDataAccess.getProvincia(connexion,barrio));
		barrio.setCanton(barrioDataAccess.getCanton(connexion,barrio));
		barrio.setParroquia(barrioDataAccess.getParroquia(connexion,barrio));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				barrio.setProvincia(barrioDataAccess.getProvincia(connexion,barrio));
				continue;
			}

			if(clas.clas.equals(Canton.class)) {
				barrio.setCanton(barrioDataAccess.getCanton(connexion,barrio));
				continue;
			}

			if(clas.clas.equals(Parroquia.class)) {
				barrio.setParroquia(barrioDataAccess.getParroquia(connexion,barrio));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			barrio.setProvincia(barrioDataAccess.getProvincia(connexion,barrio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Canton.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			barrio.setCanton(barrioDataAccess.getCanton(connexion,barrio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Parroquia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			barrio.setParroquia(barrioDataAccess.getParroquia(connexion,barrio));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		barrio.setProvincia(barrioDataAccess.getProvincia(connexion,barrio));
		ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
		provinciaLogic.deepLoad(barrio.getProvincia(),isDeep,deepLoadType,clases);
				
		barrio.setCanton(barrioDataAccess.getCanton(connexion,barrio));
		CantonLogic cantonLogic= new CantonLogic(connexion);
		cantonLogic.deepLoad(barrio.getCanton(),isDeep,deepLoadType,clases);
				
		barrio.setParroquia(barrioDataAccess.getParroquia(connexion,barrio));
		ParroquiaLogic parroquiaLogic= new ParroquiaLogic(connexion);
		parroquiaLogic.deepLoad(barrio.getParroquia(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				barrio.setProvincia(barrioDataAccess.getProvincia(connexion,barrio));
				ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
				provinciaLogic.deepLoad(barrio.getProvincia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Canton.class)) {
				barrio.setCanton(barrioDataAccess.getCanton(connexion,barrio));
				CantonLogic cantonLogic= new CantonLogic(connexion);
				cantonLogic.deepLoad(barrio.getCanton(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Parroquia.class)) {
				barrio.setParroquia(barrioDataAccess.getParroquia(connexion,barrio));
				ParroquiaLogic parroquiaLogic= new ParroquiaLogic(connexion);
				parroquiaLogic.deepLoad(barrio.getParroquia(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			barrio.setProvincia(barrioDataAccess.getProvincia(connexion,barrio));
			ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
			provinciaLogic.deepLoad(barrio.getProvincia(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Canton.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			barrio.setCanton(barrioDataAccess.getCanton(connexion,barrio));
			CantonLogic cantonLogic= new CantonLogic(connexion);
			cantonLogic.deepLoad(barrio.getCanton(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Parroquia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			barrio.setParroquia(barrioDataAccess.getParroquia(connexion,barrio));
			ParroquiaLogic parroquiaLogic= new ParroquiaLogic(connexion);
			parroquiaLogic.deepLoad(barrio.getParroquia(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Barrio barrio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			BarrioLogicAdditional.updateBarrioToSave(barrio,this.arrDatoGeneral);
			
BarrioDataAccess.save(barrio, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ProvinciaDataAccess.save(barrio.getProvincia(),connexion);

		CantonDataAccess.save(barrio.getCanton(),connexion);

		ParroquiaDataAccess.save(barrio.getParroquia(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				ProvinciaDataAccess.save(barrio.getProvincia(),connexion);
				continue;
			}

			if(clas.clas.equals(Canton.class)) {
				CantonDataAccess.save(barrio.getCanton(),connexion);
				continue;
			}

			if(clas.clas.equals(Parroquia.class)) {
				ParroquiaDataAccess.save(barrio.getParroquia(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ProvinciaDataAccess.save(barrio.getProvincia(),connexion);
		ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
		provinciaLogic.deepLoad(barrio.getProvincia(),isDeep,deepLoadType,clases);
				

		CantonDataAccess.save(barrio.getCanton(),connexion);
		CantonLogic cantonLogic= new CantonLogic(connexion);
		cantonLogic.deepLoad(barrio.getCanton(),isDeep,deepLoadType,clases);
				

		ParroquiaDataAccess.save(barrio.getParroquia(),connexion);
		ParroquiaLogic parroquiaLogic= new ParroquiaLogic(connexion);
		parroquiaLogic.deepLoad(barrio.getParroquia(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				ProvinciaDataAccess.save(barrio.getProvincia(),connexion);
				ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
				provinciaLogic.deepSave(barrio.getProvincia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Canton.class)) {
				CantonDataAccess.save(barrio.getCanton(),connexion);
				CantonLogic cantonLogic= new CantonLogic(connexion);
				cantonLogic.deepSave(barrio.getCanton(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Parroquia.class)) {
				ParroquiaDataAccess.save(barrio.getParroquia(),connexion);
				ParroquiaLogic parroquiaLogic= new ParroquiaLogic(connexion);
				parroquiaLogic.deepSave(barrio.getParroquia(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(Barrio.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(barrio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(barrio);
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
			this.deepLoad(this.barrio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Barrio.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(barrios!=null) {
				for(Barrio barrio:barrios) {
					this.deepLoad(barrio,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(barrios);
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
			if(barrios!=null) {
				for(Barrio barrio:barrios) {
					this.deepLoad(barrio,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(barrios);
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
			this.getNewConnexionToDeep(Barrio.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(barrio,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Barrio.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(barrios!=null) {
				for(Barrio barrio:barrios) {
					this.deepSave(barrio,isDeep,deepLoadType,clases);
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
			if(barrios!=null) {
				for(Barrio barrio:barrios) {
					this.deepSave(barrio,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getBarriosFK_IdCantonWithConnection(String sFinalQuery,Pagination pagination,Long id_canton)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Barrio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCanton= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCanton.setParameterSelectionGeneralEqual(ParameterType.LONG,id_canton,BarrioConstantesFunciones.IDCANTON,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCanton);

			BarrioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCanton","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			barrios=barrioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBarriosFK_IdCanton(String sFinalQuery,Pagination pagination,Long id_canton)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCanton= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCanton.setParameterSelectionGeneralEqual(ParameterType.LONG,id_canton,BarrioConstantesFunciones.IDCANTON,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCanton);

			BarrioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCanton","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			barrios=barrioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBarriosFK_IdParroquiaWithConnection(String sFinalQuery,Pagination pagination,Long id_parroquia)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Barrio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidParroquia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidParroquia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_parroquia,BarrioConstantesFunciones.IDPARROQUIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidParroquia);

			BarrioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdParroquia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			barrios=barrioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBarriosFK_IdParroquia(String sFinalQuery,Pagination pagination,Long id_parroquia)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidParroquia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidParroquia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_parroquia,BarrioConstantesFunciones.IDPARROQUIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidParroquia);

			BarrioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdParroquia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			barrios=barrioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBarriosFK_IdProvinciaWithConnection(String sFinalQuery,Pagination pagination,Long id_provincia)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Barrio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProvincia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProvincia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_provincia,BarrioConstantesFunciones.IDPROVINCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProvincia);

			BarrioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProvincia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			barrios=barrioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBarriosFK_IdProvincia(String sFinalQuery,Pagination pagination,Long id_provincia)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProvincia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProvincia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_provincia,BarrioConstantesFunciones.IDPROVINCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProvincia);

			BarrioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProvincia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			barrios=barrioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BarrioConstantesFunciones.refrescarForeignKeysDescripcionesBarrio(this.barrios);
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
			if(BarrioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,BarrioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Barrio barrio,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(BarrioConstantesFunciones.ISCONAUDITORIA) {
				if(barrio.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BarrioDataAccess.TABLENAME, barrio.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(BarrioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////BarrioLogic.registrarAuditoriaDetallesBarrio(connexion,barrio,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(barrio.getIsDeleted()) {
					/*if(!barrio.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,BarrioDataAccess.TABLENAME, barrio.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////BarrioLogic.registrarAuditoriaDetallesBarrio(connexion,barrio,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BarrioDataAccess.TABLENAME, barrio.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(barrio.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BarrioDataAccess.TABLENAME, barrio.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(BarrioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////BarrioLogic.registrarAuditoriaDetallesBarrio(connexion,barrio,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesBarrio(Connexion connexion,Barrio barrio)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(barrio.getIsNew()||!barrio.getid_provincia().equals(barrio.getBarrioOriginal().getid_provincia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(barrio.getBarrioOriginal().getid_provincia()!=null)
				{
					strValorActual=barrio.getBarrioOriginal().getid_provincia().toString();
				}
				if(barrio.getid_provincia()!=null)
				{
					strValorNuevo=barrio.getid_provincia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BarrioConstantesFunciones.IDPROVINCIA,strValorActual,strValorNuevo);
			}	
			
			if(barrio.getIsNew()||!barrio.getid_canton().equals(barrio.getBarrioOriginal().getid_canton()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(barrio.getBarrioOriginal().getid_canton()!=null)
				{
					strValorActual=barrio.getBarrioOriginal().getid_canton().toString();
				}
				if(barrio.getid_canton()!=null)
				{
					strValorNuevo=barrio.getid_canton().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BarrioConstantesFunciones.IDCANTON,strValorActual,strValorNuevo);
			}	
			
			if(barrio.getIsNew()||!barrio.getid_parroquia().equals(barrio.getBarrioOriginal().getid_parroquia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(barrio.getBarrioOriginal().getid_parroquia()!=null)
				{
					strValorActual=barrio.getBarrioOriginal().getid_parroquia().toString();
				}
				if(barrio.getid_parroquia()!=null)
				{
					strValorNuevo=barrio.getid_parroquia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BarrioConstantesFunciones.IDPARROQUIA,strValorActual,strValorNuevo);
			}	
			
			if(barrio.getIsNew()||!barrio.getcodigo().equals(barrio.getBarrioOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(barrio.getBarrioOriginal().getcodigo()!=null)
				{
					strValorActual=barrio.getBarrioOriginal().getcodigo();
				}
				if(barrio.getcodigo()!=null)
				{
					strValorNuevo=barrio.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BarrioConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(barrio.getIsNew()||!barrio.getnombre().equals(barrio.getBarrioOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(barrio.getBarrioOriginal().getnombre()!=null)
				{
					strValorActual=barrio.getBarrioOriginal().getnombre();
				}
				if(barrio.getnombre()!=null)
				{
					strValorNuevo=barrio.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BarrioConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveBarrioRelacionesWithConnection(Barrio barrio) throws Exception {

		if(!barrio.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveBarrioRelacionesBase(barrio,true);
		}
	}

	public void saveBarrioRelaciones(Barrio barrio)throws Exception {

		if(!barrio.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveBarrioRelacionesBase(barrio,false);
		}
	}

	public void saveBarrioRelacionesBase(Barrio barrio,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Barrio-saveRelacionesWithConnection");}
	

			this.setBarrio(barrio);

			if(BarrioLogicAdditional.validarSaveRelaciones(barrio,this)) {

				BarrioLogicAdditional.updateRelacionesToSave(barrio,this);

				if((barrio.getIsNew()||barrio.getIsChanged())&&!barrio.getIsDeleted()) {
					this.saveBarrio();
					this.saveBarrioRelacionesDetalles();

				} else if(barrio.getIsDeleted()) {
					this.saveBarrioRelacionesDetalles();
					this.saveBarrio();
				}

				BarrioLogicAdditional.updateRelacionesToSaveAfter(barrio,this);

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
	
	
	private void saveBarrioRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfBarrio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=BarrioConstantesFunciones.getClassesForeignKeysOfBarrio(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBarrio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=BarrioConstantesFunciones.getClassesRelationshipsOfBarrio(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

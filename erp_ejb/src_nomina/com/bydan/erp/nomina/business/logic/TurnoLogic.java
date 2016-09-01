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
import com.bydan.erp.nomina.util.TurnoConstantesFunciones;
import com.bydan.erp.nomina.util.TurnoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TurnoParameterGeneral;
import com.bydan.erp.nomina.business.entity.Turno;
import com.bydan.erp.nomina.business.logic.TurnoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TurnoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TurnoLogic.class);
	
	protected TurnoDataAccess turnoDataAccess; 	
	protected Turno turno;
	protected List<Turno> turnos;
	protected Object turnoObject;	
	protected List<Object> turnosObject;
	
	public static ClassValidator<Turno> turnoValidator = new ClassValidator<Turno>(Turno.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TurnoLogicAdditional turnoLogicAdditional=null;
	
	public TurnoLogicAdditional getTurnoLogicAdditional() {
		return this.turnoLogicAdditional;
	}
	
	public void setTurnoLogicAdditional(TurnoLogicAdditional turnoLogicAdditional) {
		try {
			this.turnoLogicAdditional=turnoLogicAdditional;
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
	
	
	
	
	public  TurnoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.turnoDataAccess = new TurnoDataAccess();
			
			this.turnos= new ArrayList<Turno>();
			this.turno= new Turno();
			
			this.turnoObject=new Object();
			this.turnosObject=new ArrayList<Object>();
				
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
			
			this.turnoDataAccess.setConnexionType(this.connexionType);
			this.turnoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TurnoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.turnoDataAccess = new TurnoDataAccess();
			this.turnos= new ArrayList<Turno>();
			this.turno= new Turno();
			this.turnoObject=new Object();
			this.turnosObject=new ArrayList<Object>();
			
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
			
			this.turnoDataAccess.setConnexionType(this.connexionType);
			this.turnoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Turno getTurno() throws Exception {	
		TurnoLogicAdditional.checkTurnoToGet(turno,this.datosCliente,this.arrDatoGeneral);
		TurnoLogicAdditional.updateTurnoToGet(turno,this.arrDatoGeneral);
		
		return turno;
	}
		
	public void setTurno(Turno newTurno) {
		this.turno = newTurno;
	}
	
	public TurnoDataAccess getTurnoDataAccess() {
		return turnoDataAccess;
	}
	
	public void setTurnoDataAccess(TurnoDataAccess newturnoDataAccess) {
		this.turnoDataAccess = newturnoDataAccess;
	}
	
	public List<Turno> getTurnos() throws Exception {		
		this.quitarTurnosNulos();
		
		TurnoLogicAdditional.checkTurnoToGets(turnos,this.datosCliente,this.arrDatoGeneral);
		
		for (Turno turnoLocal: turnos ) {
			TurnoLogicAdditional.updateTurnoToGet(turnoLocal,this.arrDatoGeneral);
		}
		
		return turnos;
	}
	
	public void setTurnos(List<Turno> newTurnos) {
		this.turnos = newTurnos;
	}
	
	public Object getTurnoObject() {	
		this.turnoObject=this.turnoDataAccess.getEntityObject();
		return this.turnoObject;
	}
		
	public void setTurnoObject(Object newTurnoObject) {
		this.turnoObject = newTurnoObject;
	}
	
	public List<Object> getTurnosObject() {		
		this.turnosObject=this.turnoDataAccess.getEntitiesObject();
		return this.turnosObject;
	}
		
	public void setTurnosObject(List<Object> newTurnosObject) {
		this.turnosObject = newTurnosObject;
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
		
		if(this.turnoDataAccess!=null) {
			this.turnoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Turno.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			turnoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			turnoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		turno = new  Turno();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Turno.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			turno=turnoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.turno,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TurnoConstantesFunciones.refrescarForeignKeysDescripcionesTurno(this.turno);
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
		turno = new  Turno();
		  		  
        try {
			
			turno=turnoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.turno,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TurnoConstantesFunciones.refrescarForeignKeysDescripcionesTurno(this.turno);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		turno = new  Turno();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Turno.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			turno=turnoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.turno,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TurnoConstantesFunciones.refrescarForeignKeysDescripcionesTurno(this.turno);
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
		turno = new  Turno();
		  		  
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
		turno = new  Turno();
		  		  
        try {
			
			turno=turnoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.turno,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TurnoConstantesFunciones.refrescarForeignKeysDescripcionesTurno(this.turno);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		turno = new  Turno();
		  		  
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
		turno = new  Turno();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Turno.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =turnoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		turno = new  Turno();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=turnoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		turno = new  Turno();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Turno.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =turnoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		turno = new  Turno();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=turnoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		turno = new  Turno();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Turno.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =turnoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		turno = new  Turno();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=turnoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		turnos = new  ArrayList<Turno>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Turno.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turnos=turnoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTurno(turnos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoConstantesFunciones.refrescarForeignKeysDescripcionesTurno(this.turnos);
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
		turnos = new  ArrayList<Turno>();
		  		  
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
		turnos = new  ArrayList<Turno>();
		  		  
        try {			
			TurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turnos=turnoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTurno(turnos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoConstantesFunciones.refrescarForeignKeysDescripcionesTurno(this.turnos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		turnos = new  ArrayList<Turno>();
		  		  
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
		turnos = new  ArrayList<Turno>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Turno.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turnos=turnoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTurno(turnos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoConstantesFunciones.refrescarForeignKeysDescripcionesTurno(this.turnos);
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
		turnos = new  ArrayList<Turno>();
		  		  
        try {
			TurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turnos=turnoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTurno(turnos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoConstantesFunciones.refrescarForeignKeysDescripcionesTurno(this.turnos);
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
		turnos = new  ArrayList<Turno>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Turno.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turnos=turnoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTurno(turnos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoConstantesFunciones.refrescarForeignKeysDescripcionesTurno(this.turnos);
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
		turnos = new  ArrayList<Turno>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turnos=turnoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTurno(turnos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoConstantesFunciones.refrescarForeignKeysDescripcionesTurno(this.turnos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		turno = new  Turno();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Turno.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turno=turnoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTurno(turno);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoConstantesFunciones.refrescarForeignKeysDescripcionesTurno(this.turno);
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
		turno = new  Turno();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turno=turnoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTurno(turno);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoConstantesFunciones.refrescarForeignKeysDescripcionesTurno(this.turno);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		turnos = new  ArrayList<Turno>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Turno.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turnos=turnoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTurno(turnos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoConstantesFunciones.refrescarForeignKeysDescripcionesTurno(this.turnos);
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
		turnos = new  ArrayList<Turno>();
		  		  
        try {
			TurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turnos=turnoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTurno(turnos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoConstantesFunciones.refrescarForeignKeysDescripcionesTurno(this.turnos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTurnosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		turnos = new  ArrayList<Turno>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Turno.class.getSimpleName()+"-getTodosTurnosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turnos=turnoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTurno(turnos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoConstantesFunciones.refrescarForeignKeysDescripcionesTurno(this.turnos);
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
	
	public  void  getTodosTurnos(String sFinalQuery,Pagination pagination)throws Exception {
		turnos = new  ArrayList<Turno>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			turnos=turnoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTurno(turnos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TurnoConstantesFunciones.refrescarForeignKeysDescripcionesTurno(this.turnos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTurno(Turno turno) throws Exception {
		Boolean estaValidado=false;
		
		if(turno.getIsNew() || turno.getIsChanged()) { 
			this.invalidValues = turnoValidator.getInvalidValues(turno);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(turno);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTurno(List<Turno> Turnos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Turno turnoLocal:turnos) {				
			estaValidadoObjeto=this.validarGuardarTurno(turnoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTurno(List<Turno> Turnos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTurno(turnos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTurno(Turno Turno) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTurno(turno)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Turno turno) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+turno.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TurnoConstantesFunciones.getTurnoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"turno","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TurnoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TurnoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTurnoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Turno.class.getSimpleName()+"-saveTurnoWithConnection");connexion.begin();			
			
			TurnoLogicAdditional.checkTurnoToSave(this.turno,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TurnoLogicAdditional.updateTurnoToSave(this.turno,this.arrDatoGeneral);
			
			TurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.turno,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTurno();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTurno(this.turno)) {
				TurnoDataAccess.save(this.turno, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.turno,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TurnoLogicAdditional.checkTurnoToSaveAfter(this.turno,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTurno();
			
			connexion.commit();			
			
			if(this.turno.getIsDeleted()) {
				this.turno=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTurno()throws Exception {	
		try {	
			
			TurnoLogicAdditional.checkTurnoToSave(this.turno,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TurnoLogicAdditional.updateTurnoToSave(this.turno,this.arrDatoGeneral);
			
			TurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.turno,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTurno(this.turno)) {			
				TurnoDataAccess.save(this.turno, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.turno,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TurnoLogicAdditional.checkTurnoToSaveAfter(this.turno,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.turno.getIsDeleted()) {
				this.turno=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTurnosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Turno.class.getSimpleName()+"-saveTurnosWithConnection");connexion.begin();			
			
			TurnoLogicAdditional.checkTurnoToSaves(turnos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTurnos();
			
			Boolean validadoTodosTurno=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Turno turnoLocal:turnos) {		
				if(turnoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TurnoLogicAdditional.updateTurnoToSave(turnoLocal,this.arrDatoGeneral);
	        	
				TurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),turnoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTurno(turnoLocal)) {
					TurnoDataAccess.save(turnoLocal, connexion);				
				} else {
					validadoTodosTurno=false;
				}
			}
			
			if(!validadoTodosTurno) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TurnoLogicAdditional.checkTurnoToSavesAfter(turnos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTurnos();
			
			connexion.commit();		
			
			this.quitarTurnosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTurnos()throws Exception {				
		 try {	
			TurnoLogicAdditional.checkTurnoToSaves(turnos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTurno=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Turno turnoLocal:turnos) {				
				if(turnoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TurnoLogicAdditional.updateTurnoToSave(turnoLocal,this.arrDatoGeneral);
	        	
				TurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),turnoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTurno(turnoLocal)) {				
					TurnoDataAccess.save(turnoLocal, connexion);				
				} else {
					validadoTodosTurno=false;
				}
			}
			
			if(!validadoTodosTurno) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TurnoLogicAdditional.checkTurnoToSavesAfter(turnos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTurnosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TurnoParameterReturnGeneral procesarAccionTurnos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Turno> turnos,TurnoParameterReturnGeneral turnoParameterGeneral)throws Exception {
		 try {	
			TurnoParameterReturnGeneral turnoReturnGeneral=new TurnoParameterReturnGeneral();
	
			TurnoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,turnos,turnoParameterGeneral,turnoReturnGeneral);
			
			return turnoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TurnoParameterReturnGeneral procesarAccionTurnosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Turno> turnos,TurnoParameterReturnGeneral turnoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Turno.class.getSimpleName()+"-procesarAccionTurnosWithConnection");connexion.begin();			
			
			TurnoParameterReturnGeneral turnoReturnGeneral=new TurnoParameterReturnGeneral();
	
			TurnoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,turnos,turnoParameterGeneral,turnoReturnGeneral);
			
			this.connexion.commit();
			
			return turnoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TurnoParameterReturnGeneral procesarEventosTurnos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Turno> turnos,Turno turno,TurnoParameterReturnGeneral turnoParameterGeneral,Boolean isEsNuevoTurno,ArrayList<Classe> clases)throws Exception {
		 try {	
			TurnoParameterReturnGeneral turnoReturnGeneral=new TurnoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				turnoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TurnoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,turnos,turno,turnoParameterGeneral,turnoReturnGeneral,isEsNuevoTurno,clases);
			
			return turnoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TurnoParameterReturnGeneral procesarEventosTurnosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Turno> turnos,Turno turno,TurnoParameterReturnGeneral turnoParameterGeneral,Boolean isEsNuevoTurno,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Turno.class.getSimpleName()+"-procesarEventosTurnosWithConnection");connexion.begin();			
			
			TurnoParameterReturnGeneral turnoReturnGeneral=new TurnoParameterReturnGeneral();
	
			turnoReturnGeneral.setTurno(turno);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				turnoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TurnoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,turnos,turno,turnoParameterGeneral,turnoReturnGeneral,isEsNuevoTurno,clases);
			
			this.connexion.commit();
			
			return turnoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TurnoParameterReturnGeneral procesarImportacionTurnosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TurnoParameterReturnGeneral turnoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Turno.class.getSimpleName()+"-procesarImportacionTurnosWithConnection");connexion.begin();			
			
			TurnoParameterReturnGeneral turnoReturnGeneral=new TurnoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.turnos=new ArrayList<Turno>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.turno=new Turno();
				
				
				if(conColumnasBase) {this.turno.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.turno.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				//this.turno.sethora_entrada(arrColumnas[iColumn++]);
				//this.turno.sethora_salida(arrColumnas[iColumn++]);
				//this.turno.sethora_ingreso_receso(arrColumnas[iColumn++]);
				//this.turno.sethora_salida_receso(arrColumnas[iColumn++]);
				//this.turno.sethora_durante_receso(arrColumnas[iColumn++]);
				//this.turno.sethora_ingreso_almuerzo(arrColumnas[iColumn++]);
				//this.turno.sethora_salida_almuerzo(arrColumnas[iColumn++]);
				//this.turno.sethora_durante_almuerzo(arrColumnas[iColumn++]);
				//this.turno.sethora_ingreso25(arrColumnas[iColumn++]);
				//this.turno.sethora_salida25(arrColumnas[iColumn++]);
				//this.turno.sethora_ingreso50(arrColumnas[iColumn++]);
				//this.turno.sethora_salida50(arrColumnas[iColumn++]);
				//this.turno.sethora_ingreso100(arrColumnas[iColumn++]);
				//this.turno.sethora_salida100(arrColumnas[iColumn++]);
				//this.turno.sethora_ingreso200(arrColumnas[iColumn++]);
				//this.turno.sethora_salida200(arrColumnas[iColumn++]);
				
				this.turnos.add(this.turno);
			}
			
			this.saveTurnos();
			
			this.connexion.commit();
			
			turnoReturnGeneral.setConRetornoEstaProcesado(true);
			turnoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return turnoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTurnosEliminados() throws Exception {				
		
		List<Turno> turnosAux= new ArrayList<Turno>();
		
		for(Turno turno:turnos) {
			if(!turno.getIsDeleted()) {
				turnosAux.add(turno);
			}
		}
		
		turnos=turnosAux;
	}
	
	public void quitarTurnosNulos() throws Exception {				
		
		List<Turno> turnosAux= new ArrayList<Turno>();
		
		for(Turno turno : this.turnos) {
			if(turno==null) {
				turnosAux.add(turno);
			}
		}
		
		//this.turnos=turnosAux;
		
		this.turnos.removeAll(turnosAux);
	}
	
	public void getSetVersionRowTurnoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(turno.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((turno.getIsDeleted() || (turno.getIsChanged()&&!turno.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=turnoDataAccess.getSetVersionRowTurno(connexion,turno.getId());
				
				if(!turno.getVersionRow().equals(timestamp)) {	
					turno.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				turno.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTurno()throws Exception {	
		
		if(turno.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((turno.getIsDeleted() || (turno.getIsChanged()&&!turno.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=turnoDataAccess.getSetVersionRowTurno(connexion,turno.getId());
			
			try {							
				if(!turno.getVersionRow().equals(timestamp)) {	
					turno.setVersionRow(timestamp);
				}
				
				turno.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTurnosWithConnection()throws Exception {	
		if(turnos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Turno turnoAux:turnos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(turnoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(turnoAux.getIsDeleted() || (turnoAux.getIsChanged()&&!turnoAux.getIsNew())) {
						
						timestamp=turnoDataAccess.getSetVersionRowTurno(connexion,turnoAux.getId());
						
						if(!turno.getVersionRow().equals(timestamp)) {	
							turnoAux.setVersionRow(timestamp);
						}
								
						turnoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTurnos()throws Exception {	
		if(turnos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Turno turnoAux:turnos) {
					if(turnoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(turnoAux.getIsDeleted() || (turnoAux.getIsChanged()&&!turnoAux.getIsNew())) {
						
						timestamp=turnoDataAccess.getSetVersionRowTurno(connexion,turnoAux.getId());
						
						if(!turnoAux.getVersionRow().equals(timestamp)) {	
							turnoAux.setVersionRow(timestamp);
						}
						
													
						turnoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TurnoParameterReturnGeneral cargarCombosLoteForeignKeyTurnoWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TurnoParameterReturnGeneral  turnoReturnGeneral =new TurnoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Turno.class.getSimpleName()+"-cargarCombosLoteForeignKeyTurnoWithConnection");connexion.begin();
			
			turnoReturnGeneral =new TurnoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			turnoReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return turnoReturnGeneral;
	}
	
	public TurnoParameterReturnGeneral cargarCombosLoteForeignKeyTurno(String finalQueryGlobalEmpresa) throws Exception {
		TurnoParameterReturnGeneral  turnoReturnGeneral =new TurnoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			turnoReturnGeneral =new TurnoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			turnoReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return turnoReturnGeneral;
	}
	
	
	public void deepLoad(Turno turno,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TurnoLogicAdditional.updateTurnoToGet(turno,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		turno.setEmpresa(turnoDataAccess.getEmpresa(connexion,turno));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				turno.setEmpresa(turnoDataAccess.getEmpresa(connexion,turno));
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
			turno.setEmpresa(turnoDataAccess.getEmpresa(connexion,turno));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		turno.setEmpresa(turnoDataAccess.getEmpresa(connexion,turno));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(turno.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				turno.setEmpresa(turnoDataAccess.getEmpresa(connexion,turno));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(turno.getEmpresa(),isDeep,deepLoadType,clases);				
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
			turno.setEmpresa(turnoDataAccess.getEmpresa(connexion,turno));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(turno.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Turno turno,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TurnoLogicAdditional.updateTurnoToSave(turno,this.arrDatoGeneral);
			
TurnoDataAccess.save(turno, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(turno.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(turno.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(turno.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(turno.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(turno.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(turno.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(Turno.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(turno,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TurnoConstantesFunciones.refrescarForeignKeysDescripcionesTurno(turno);
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
			this.deepLoad(this.turno,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TurnoConstantesFunciones.refrescarForeignKeysDescripcionesTurno(this.turno);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Turno.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(turnos!=null) {
				for(Turno turno:turnos) {
					this.deepLoad(turno,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TurnoConstantesFunciones.refrescarForeignKeysDescripcionesTurno(turnos);
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
			if(turnos!=null) {
				for(Turno turno:turnos) {
					this.deepLoad(turno,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TurnoConstantesFunciones.refrescarForeignKeysDescripcionesTurno(turnos);
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
			this.getNewConnexionToDeep(Turno.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(turno,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Turno.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(turnos!=null) {
				for(Turno turno:turnos) {
					this.deepSave(turno,isDeep,deepLoadType,clases);
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
			if(turnos!=null) {
				for(Turno turno:turnos) {
					this.deepSave(turno,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTurnosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Turno.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TurnoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			turnos=turnoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TurnoConstantesFunciones.refrescarForeignKeysDescripcionesTurno(this.turnos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTurnosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TurnoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			turnos=turnoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TurnoConstantesFunciones.refrescarForeignKeysDescripcionesTurno(this.turnos);
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
			if(TurnoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TurnoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Turno turno,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TurnoConstantesFunciones.ISCONAUDITORIA) {
				if(turno.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TurnoDataAccess.TABLENAME, turno.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TurnoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TurnoLogic.registrarAuditoriaDetallesTurno(connexion,turno,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(turno.getIsDeleted()) {
					/*if(!turno.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TurnoDataAccess.TABLENAME, turno.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TurnoLogic.registrarAuditoriaDetallesTurno(connexion,turno,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TurnoDataAccess.TABLENAME, turno.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(turno.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TurnoDataAccess.TABLENAME, turno.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TurnoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TurnoLogic.registrarAuditoriaDetallesTurno(connexion,turno,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTurno(Connexion connexion,Turno turno)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(turno.getIsNew()||!turno.getid_empresa().equals(turno.getTurnoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turno.getTurnoOriginal().getid_empresa()!=null)
				{
					strValorActual=turno.getTurnoOriginal().getid_empresa().toString();
				}
				if(turno.getid_empresa()!=null)
				{
					strValorNuevo=turno.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(turno.getIsNew()||!turno.gethora_entrada().equals(turno.getTurnoOriginal().gethora_entrada()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turno.getTurnoOriginal().gethora_entrada()!=null)
				{
					strValorActual=turno.getTurnoOriginal().gethora_entrada().toString();
				}
				if(turno.gethora_entrada()!=null)
				{
					strValorNuevo=turno.gethora_entrada().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoConstantesFunciones.HORAENTRADA,strValorActual,strValorNuevo);
			}	
			
			if(turno.getIsNew()||!turno.gethora_salida().equals(turno.getTurnoOriginal().gethora_salida()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turno.getTurnoOriginal().gethora_salida()!=null)
				{
					strValorActual=turno.getTurnoOriginal().gethora_salida().toString();
				}
				if(turno.gethora_salida()!=null)
				{
					strValorNuevo=turno.gethora_salida().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoConstantesFunciones.HORASALIDA,strValorActual,strValorNuevo);
			}	
			
			if(turno.getIsNew()||!turno.gethora_ingreso_receso().equals(turno.getTurnoOriginal().gethora_ingreso_receso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turno.getTurnoOriginal().gethora_ingreso_receso()!=null)
				{
					strValorActual=turno.getTurnoOriginal().gethora_ingreso_receso().toString();
				}
				if(turno.gethora_ingreso_receso()!=null)
				{
					strValorNuevo=turno.gethora_ingreso_receso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoConstantesFunciones.HORAINGRESORECESO,strValorActual,strValorNuevo);
			}	
			
			if(turno.getIsNew()||!turno.gethora_salida_receso().equals(turno.getTurnoOriginal().gethora_salida_receso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turno.getTurnoOriginal().gethora_salida_receso()!=null)
				{
					strValorActual=turno.getTurnoOriginal().gethora_salida_receso().toString();
				}
				if(turno.gethora_salida_receso()!=null)
				{
					strValorNuevo=turno.gethora_salida_receso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoConstantesFunciones.HORASALIDARECESO,strValorActual,strValorNuevo);
			}	
			
			if(turno.getIsNew()||!turno.gethora_durante_receso().equals(turno.getTurnoOriginal().gethora_durante_receso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turno.getTurnoOriginal().gethora_durante_receso()!=null)
				{
					strValorActual=turno.getTurnoOriginal().gethora_durante_receso().toString();
				}
				if(turno.gethora_durante_receso()!=null)
				{
					strValorNuevo=turno.gethora_durante_receso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoConstantesFunciones.HORADURANTERECESO,strValorActual,strValorNuevo);
			}	
			
			if(turno.getIsNew()||!turno.gethora_ingreso_almuerzo().equals(turno.getTurnoOriginal().gethora_ingreso_almuerzo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turno.getTurnoOriginal().gethora_ingreso_almuerzo()!=null)
				{
					strValorActual=turno.getTurnoOriginal().gethora_ingreso_almuerzo().toString();
				}
				if(turno.gethora_ingreso_almuerzo()!=null)
				{
					strValorNuevo=turno.gethora_ingreso_almuerzo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoConstantesFunciones.HORAINGRESOALMUERZO,strValorActual,strValorNuevo);
			}	
			
			if(turno.getIsNew()||!turno.gethora_salida_almuerzo().equals(turno.getTurnoOriginal().gethora_salida_almuerzo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turno.getTurnoOriginal().gethora_salida_almuerzo()!=null)
				{
					strValorActual=turno.getTurnoOriginal().gethora_salida_almuerzo().toString();
				}
				if(turno.gethora_salida_almuerzo()!=null)
				{
					strValorNuevo=turno.gethora_salida_almuerzo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoConstantesFunciones.HORASALIDAALMUERZO,strValorActual,strValorNuevo);
			}	
			
			if(turno.getIsNew()||!turno.gethora_durante_almuerzo().equals(turno.getTurnoOriginal().gethora_durante_almuerzo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turno.getTurnoOriginal().gethora_durante_almuerzo()!=null)
				{
					strValorActual=turno.getTurnoOriginal().gethora_durante_almuerzo().toString();
				}
				if(turno.gethora_durante_almuerzo()!=null)
				{
					strValorNuevo=turno.gethora_durante_almuerzo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoConstantesFunciones.HORADURANTEALMUERZO,strValorActual,strValorNuevo);
			}	
			
			if(turno.getIsNew()||!turno.gethora_ingreso25().equals(turno.getTurnoOriginal().gethora_ingreso25()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turno.getTurnoOriginal().gethora_ingreso25()!=null)
				{
					strValorActual=turno.getTurnoOriginal().gethora_ingreso25().toString();
				}
				if(turno.gethora_ingreso25()!=null)
				{
					strValorNuevo=turno.gethora_ingreso25().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoConstantesFunciones.HORAINGRESO25,strValorActual,strValorNuevo);
			}	
			
			if(turno.getIsNew()||!turno.gethora_salida25().equals(turno.getTurnoOriginal().gethora_salida25()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turno.getTurnoOriginal().gethora_salida25()!=null)
				{
					strValorActual=turno.getTurnoOriginal().gethora_salida25().toString();
				}
				if(turno.gethora_salida25()!=null)
				{
					strValorNuevo=turno.gethora_salida25().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoConstantesFunciones.HORASALIDA25,strValorActual,strValorNuevo);
			}	
			
			if(turno.getIsNew()||!turno.gethora_ingreso50().equals(turno.getTurnoOriginal().gethora_ingreso50()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turno.getTurnoOriginal().gethora_ingreso50()!=null)
				{
					strValorActual=turno.getTurnoOriginal().gethora_ingreso50().toString();
				}
				if(turno.gethora_ingreso50()!=null)
				{
					strValorNuevo=turno.gethora_ingreso50().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoConstantesFunciones.HORAINGRESO50,strValorActual,strValorNuevo);
			}	
			
			if(turno.getIsNew()||!turno.gethora_salida50().equals(turno.getTurnoOriginal().gethora_salida50()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turno.getTurnoOriginal().gethora_salida50()!=null)
				{
					strValorActual=turno.getTurnoOriginal().gethora_salida50().toString();
				}
				if(turno.gethora_salida50()!=null)
				{
					strValorNuevo=turno.gethora_salida50().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoConstantesFunciones.HORASALIDA50,strValorActual,strValorNuevo);
			}	
			
			if(turno.getIsNew()||!turno.gethora_ingreso100().equals(turno.getTurnoOriginal().gethora_ingreso100()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turno.getTurnoOriginal().gethora_ingreso100()!=null)
				{
					strValorActual=turno.getTurnoOriginal().gethora_ingreso100().toString();
				}
				if(turno.gethora_ingreso100()!=null)
				{
					strValorNuevo=turno.gethora_ingreso100().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoConstantesFunciones.HORAINGRESO100,strValorActual,strValorNuevo);
			}	
			
			if(turno.getIsNew()||!turno.gethora_salida100().equals(turno.getTurnoOriginal().gethora_salida100()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turno.getTurnoOriginal().gethora_salida100()!=null)
				{
					strValorActual=turno.getTurnoOriginal().gethora_salida100().toString();
				}
				if(turno.gethora_salida100()!=null)
				{
					strValorNuevo=turno.gethora_salida100().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoConstantesFunciones.HORASALIDA100,strValorActual,strValorNuevo);
			}	
			
			if(turno.getIsNew()||!turno.gethora_ingreso200().equals(turno.getTurnoOriginal().gethora_ingreso200()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turno.getTurnoOriginal().gethora_ingreso200()!=null)
				{
					strValorActual=turno.getTurnoOriginal().gethora_ingreso200().toString();
				}
				if(turno.gethora_ingreso200()!=null)
				{
					strValorNuevo=turno.gethora_ingreso200().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoConstantesFunciones.HORAINGRESO200,strValorActual,strValorNuevo);
			}	
			
			if(turno.getIsNew()||!turno.gethora_salida200().equals(turno.getTurnoOriginal().gethora_salida200()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(turno.getTurnoOriginal().gethora_salida200()!=null)
				{
					strValorActual=turno.getTurnoOriginal().gethora_salida200().toString();
				}
				if(turno.gethora_salida200()!=null)
				{
					strValorNuevo=turno.gethora_salida200().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TurnoConstantesFunciones.HORASALIDA200,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTurnoRelacionesWithConnection(Turno turno) throws Exception {

		if(!turno.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTurnoRelacionesBase(turno,true);
		}
	}

	public void saveTurnoRelaciones(Turno turno)throws Exception {

		if(!turno.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTurnoRelacionesBase(turno,false);
		}
	}

	public void saveTurnoRelacionesBase(Turno turno,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Turno-saveRelacionesWithConnection");}
	

			this.setTurno(turno);

			if(TurnoLogicAdditional.validarSaveRelaciones(turno,this)) {

				TurnoLogicAdditional.updateRelacionesToSave(turno,this);

				if((turno.getIsNew()||turno.getIsChanged())&&!turno.getIsDeleted()) {
					this.saveTurno();
					this.saveTurnoRelacionesDetalles();

				} else if(turno.getIsDeleted()) {
					this.saveTurnoRelacionesDetalles();
					this.saveTurno();
				}

				TurnoLogicAdditional.updateRelacionesToSaveAfter(turno,this);

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
	
	
	private void saveTurnoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTurno(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TurnoConstantesFunciones.getClassesForeignKeysOfTurno(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTurno(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TurnoConstantesFunciones.getClassesRelationshipsOfTurno(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

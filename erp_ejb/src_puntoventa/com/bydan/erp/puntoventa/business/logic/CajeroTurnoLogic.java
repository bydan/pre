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
package com.bydan.erp.puntoventa.business.logic;

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
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.puntoventa.util.CajeroTurnoConstantesFunciones;
import com.bydan.erp.puntoventa.util.CajeroTurnoParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.CajeroTurnoParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.CajeroTurno;
import com.bydan.erp.puntoventa.business.logic.CajeroTurnoLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;








@SuppressWarnings("unused")
public class CajeroTurnoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CajeroTurnoLogic.class);
	
	protected CajeroTurnoDataAccess cajeroturnoDataAccess; 	
	protected CajeroTurno cajeroturno;
	protected List<CajeroTurno> cajeroturnos;
	protected Object cajeroturnoObject;	
	protected List<Object> cajeroturnosObject;
	
	public static ClassValidator<CajeroTurno> cajeroturnoValidator = new ClassValidator<CajeroTurno>(CajeroTurno.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CajeroTurnoLogicAdditional cajeroturnoLogicAdditional=null;
	
	public CajeroTurnoLogicAdditional getCajeroTurnoLogicAdditional() {
		return this.cajeroturnoLogicAdditional;
	}
	
	public void setCajeroTurnoLogicAdditional(CajeroTurnoLogicAdditional cajeroturnoLogicAdditional) {
		try {
			this.cajeroturnoLogicAdditional=cajeroturnoLogicAdditional;
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
	
	
	
	
	public  CajeroTurnoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cajeroturnoDataAccess = new CajeroTurnoDataAccess();
			
			this.cajeroturnos= new ArrayList<CajeroTurno>();
			this.cajeroturno= new CajeroTurno();
			
			this.cajeroturnoObject=new Object();
			this.cajeroturnosObject=new ArrayList<Object>();
				
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
			
			this.cajeroturnoDataAccess.setConnexionType(this.connexionType);
			this.cajeroturnoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CajeroTurnoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cajeroturnoDataAccess = new CajeroTurnoDataAccess();
			this.cajeroturnos= new ArrayList<CajeroTurno>();
			this.cajeroturno= new CajeroTurno();
			this.cajeroturnoObject=new Object();
			this.cajeroturnosObject=new ArrayList<Object>();
			
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
			
			this.cajeroturnoDataAccess.setConnexionType(this.connexionType);
			this.cajeroturnoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CajeroTurno getCajeroTurno() throws Exception {	
		CajeroTurnoLogicAdditional.checkCajeroTurnoToGet(cajeroturno,this.datosCliente,this.arrDatoGeneral);
		CajeroTurnoLogicAdditional.updateCajeroTurnoToGet(cajeroturno,this.arrDatoGeneral);
		
		return cajeroturno;
	}
		
	public void setCajeroTurno(CajeroTurno newCajeroTurno) {
		this.cajeroturno = newCajeroTurno;
	}
	
	public CajeroTurnoDataAccess getCajeroTurnoDataAccess() {
		return cajeroturnoDataAccess;
	}
	
	public void setCajeroTurnoDataAccess(CajeroTurnoDataAccess newcajeroturnoDataAccess) {
		this.cajeroturnoDataAccess = newcajeroturnoDataAccess;
	}
	
	public List<CajeroTurno> getCajeroTurnos() throws Exception {		
		this.quitarCajeroTurnosNulos();
		
		CajeroTurnoLogicAdditional.checkCajeroTurnoToGets(cajeroturnos,this.datosCliente,this.arrDatoGeneral);
		
		for (CajeroTurno cajeroturnoLocal: cajeroturnos ) {
			CajeroTurnoLogicAdditional.updateCajeroTurnoToGet(cajeroturnoLocal,this.arrDatoGeneral);
		}
		
		return cajeroturnos;
	}
	
	public void setCajeroTurnos(List<CajeroTurno> newCajeroTurnos) {
		this.cajeroturnos = newCajeroTurnos;
	}
	
	public Object getCajeroTurnoObject() {	
		this.cajeroturnoObject=this.cajeroturnoDataAccess.getEntityObject();
		return this.cajeroturnoObject;
	}
		
	public void setCajeroTurnoObject(Object newCajeroTurnoObject) {
		this.cajeroturnoObject = newCajeroTurnoObject;
	}
	
	public List<Object> getCajeroTurnosObject() {		
		this.cajeroturnosObject=this.cajeroturnoDataAccess.getEntitiesObject();
		return this.cajeroturnosObject;
	}
		
	public void setCajeroTurnosObject(List<Object> newCajeroTurnosObject) {
		this.cajeroturnosObject = newCajeroTurnosObject;
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
		
		if(this.cajeroturnoDataAccess!=null) {
			this.cajeroturnoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cajeroturnoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cajeroturnoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cajeroturno = new  CajeroTurno();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cajeroturno=cajeroturnoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajeroturno,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturno);
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
		cajeroturno = new  CajeroTurno();
		  		  
        try {
			
			cajeroturno=cajeroturnoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajeroturno,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturno);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cajeroturno = new  CajeroTurno();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cajeroturno=cajeroturnoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajeroturno,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturno);
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
		cajeroturno = new  CajeroTurno();
		  		  
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
		cajeroturno = new  CajeroTurno();
		  		  
        try {
			
			cajeroturno=cajeroturnoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajeroturno,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturno);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cajeroturno = new  CajeroTurno();
		  		  
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
		cajeroturno = new  CajeroTurno();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cajeroturnoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cajeroturno = new  CajeroTurno();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cajeroturnoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cajeroturno = new  CajeroTurno();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cajeroturnoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cajeroturno = new  CajeroTurno();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cajeroturnoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cajeroturno = new  CajeroTurno();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cajeroturnoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cajeroturno = new  CajeroTurno();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cajeroturnoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cajeroturnos = new  ArrayList<CajeroTurno>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajeroTurno(cajeroturnos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
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
		cajeroturnos = new  ArrayList<CajeroTurno>();
		  		  
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
		cajeroturnos = new  ArrayList<CajeroTurno>();
		  		  
        try {			
			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCajeroTurno(cajeroturnos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cajeroturnos = new  ArrayList<CajeroTurno>();
		  		  
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
		cajeroturnos = new  ArrayList<CajeroTurno>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajeroTurno(cajeroturnos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
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
		cajeroturnos = new  ArrayList<CajeroTurno>();
		  		  
        try {
			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajeroTurno(cajeroturnos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
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
		cajeroturnos = new  ArrayList<CajeroTurno>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajeroTurno(cajeroturnos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
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
		cajeroturnos = new  ArrayList<CajeroTurno>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajeroTurno(cajeroturnos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cajeroturno = new  CajeroTurno();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajeroturno=cajeroturnoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajeroTurno(cajeroturno);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturno);
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
		cajeroturno = new  CajeroTurno();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajeroturno=cajeroturnoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajeroTurno(cajeroturno);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturno);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cajeroturnos = new  ArrayList<CajeroTurno>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajeroturnos=cajeroturnoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajeroTurno(cajeroturnos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
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
		cajeroturnos = new  ArrayList<CajeroTurno>();
		  		  
        try {
			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajeroturnos=cajeroturnoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajeroTurno(cajeroturnos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCajeroTurnosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cajeroturnos = new  ArrayList<CajeroTurno>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-getTodosCajeroTurnosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCajeroTurno(cajeroturnos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
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
	
	public  void  getTodosCajeroTurnos(String sFinalQuery,Pagination pagination)throws Exception {
		cajeroturnos = new  ArrayList<CajeroTurno>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCajeroTurno(cajeroturnos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCajeroTurno(CajeroTurno cajeroturno) throws Exception {
		Boolean estaValidado=false;
		
		if(cajeroturno.getIsNew() || cajeroturno.getIsChanged()) { 
			this.invalidValues = cajeroturnoValidator.getInvalidValues(cajeroturno);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cajeroturno);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCajeroTurno(List<CajeroTurno> CajeroTurnos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CajeroTurno cajeroturnoLocal:cajeroturnos) {				
			estaValidadoObjeto=this.validarGuardarCajeroTurno(cajeroturnoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCajeroTurno(List<CajeroTurno> CajeroTurnos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCajeroTurno(cajeroturnos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCajeroTurno(CajeroTurno CajeroTurno) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCajeroTurno(cajeroturno)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CajeroTurno cajeroturno) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cajeroturno.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CajeroTurnoConstantesFunciones.getCajeroTurnoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cajeroturno","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CajeroTurnoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CajeroTurnoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCajeroTurnoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-saveCajeroTurnoWithConnection");connexion.begin();			
			
			CajeroTurnoLogicAdditional.checkCajeroTurnoToSave(this.cajeroturno,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CajeroTurnoLogicAdditional.updateCajeroTurnoToSave(this.cajeroturno,this.arrDatoGeneral);
			
			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cajeroturno,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCajeroTurno();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCajeroTurno(this.cajeroturno)) {
				CajeroTurnoDataAccess.save(this.cajeroturno, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cajeroturno,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CajeroTurnoLogicAdditional.checkCajeroTurnoToSaveAfter(this.cajeroturno,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCajeroTurno();
			
			connexion.commit();			
			
			if(this.cajeroturno.getIsDeleted()) {
				this.cajeroturno=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCajeroTurno()throws Exception {	
		try {	
			
			CajeroTurnoLogicAdditional.checkCajeroTurnoToSave(this.cajeroturno,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CajeroTurnoLogicAdditional.updateCajeroTurnoToSave(this.cajeroturno,this.arrDatoGeneral);
			
			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cajeroturno,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCajeroTurno(this.cajeroturno)) {			
				CajeroTurnoDataAccess.save(this.cajeroturno, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cajeroturno,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CajeroTurnoLogicAdditional.checkCajeroTurnoToSaveAfter(this.cajeroturno,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cajeroturno.getIsDeleted()) {
				this.cajeroturno=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCajeroTurnosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-saveCajeroTurnosWithConnection");connexion.begin();			
			
			CajeroTurnoLogicAdditional.checkCajeroTurnoToSaves(cajeroturnos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCajeroTurnos();
			
			Boolean validadoTodosCajeroTurno=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CajeroTurno cajeroturnoLocal:cajeroturnos) {		
				if(cajeroturnoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CajeroTurnoLogicAdditional.updateCajeroTurnoToSave(cajeroturnoLocal,this.arrDatoGeneral);
	        	
				CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cajeroturnoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCajeroTurno(cajeroturnoLocal)) {
					CajeroTurnoDataAccess.save(cajeroturnoLocal, connexion);				
				} else {
					validadoTodosCajeroTurno=false;
				}
			}
			
			if(!validadoTodosCajeroTurno) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CajeroTurnoLogicAdditional.checkCajeroTurnoToSavesAfter(cajeroturnos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCajeroTurnos();
			
			connexion.commit();		
			
			this.quitarCajeroTurnosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCajeroTurnos()throws Exception {				
		 try {	
			CajeroTurnoLogicAdditional.checkCajeroTurnoToSaves(cajeroturnos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCajeroTurno=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CajeroTurno cajeroturnoLocal:cajeroturnos) {				
				if(cajeroturnoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CajeroTurnoLogicAdditional.updateCajeroTurnoToSave(cajeroturnoLocal,this.arrDatoGeneral);
	        	
				CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cajeroturnoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCajeroTurno(cajeroturnoLocal)) {				
					CajeroTurnoDataAccess.save(cajeroturnoLocal, connexion);				
				} else {
					validadoTodosCajeroTurno=false;
				}
			}
			
			if(!validadoTodosCajeroTurno) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CajeroTurnoLogicAdditional.checkCajeroTurnoToSavesAfter(cajeroturnos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCajeroTurnosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CajeroTurnoParameterReturnGeneral procesarAccionCajeroTurnos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CajeroTurno> cajeroturnos,CajeroTurnoParameterReturnGeneral cajeroturnoParameterGeneral)throws Exception {
		 try {	
			CajeroTurnoParameterReturnGeneral cajeroturnoReturnGeneral=new CajeroTurnoParameterReturnGeneral();
	
			CajeroTurnoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cajeroturnos,cajeroturnoParameterGeneral,cajeroturnoReturnGeneral);
			
			return cajeroturnoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CajeroTurnoParameterReturnGeneral procesarAccionCajeroTurnosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CajeroTurno> cajeroturnos,CajeroTurnoParameterReturnGeneral cajeroturnoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-procesarAccionCajeroTurnosWithConnection");connexion.begin();			
			
			CajeroTurnoParameterReturnGeneral cajeroturnoReturnGeneral=new CajeroTurnoParameterReturnGeneral();
	
			CajeroTurnoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cajeroturnos,cajeroturnoParameterGeneral,cajeroturnoReturnGeneral);
			
			this.connexion.commit();
			
			return cajeroturnoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CajeroTurnoParameterReturnGeneral procesarEventosCajeroTurnos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CajeroTurno> cajeroturnos,CajeroTurno cajeroturno,CajeroTurnoParameterReturnGeneral cajeroturnoParameterGeneral,Boolean isEsNuevoCajeroTurno,ArrayList<Classe> clases)throws Exception {
		 try {	
			CajeroTurnoParameterReturnGeneral cajeroturnoReturnGeneral=new CajeroTurnoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cajeroturnoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CajeroTurnoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cajeroturnos,cajeroturno,cajeroturnoParameterGeneral,cajeroturnoReturnGeneral,isEsNuevoCajeroTurno,clases);
			
			return cajeroturnoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CajeroTurnoParameterReturnGeneral procesarEventosCajeroTurnosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CajeroTurno> cajeroturnos,CajeroTurno cajeroturno,CajeroTurnoParameterReturnGeneral cajeroturnoParameterGeneral,Boolean isEsNuevoCajeroTurno,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-procesarEventosCajeroTurnosWithConnection");connexion.begin();			
			
			CajeroTurnoParameterReturnGeneral cajeroturnoReturnGeneral=new CajeroTurnoParameterReturnGeneral();
	
			cajeroturnoReturnGeneral.setCajeroTurno(cajeroturno);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cajeroturnoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CajeroTurnoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cajeroturnos,cajeroturno,cajeroturnoParameterGeneral,cajeroturnoReturnGeneral,isEsNuevoCajeroTurno,clases);
			
			this.connexion.commit();
			
			return cajeroturnoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CajeroTurnoParameterReturnGeneral procesarImportacionCajeroTurnosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CajeroTurnoParameterReturnGeneral cajeroturnoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-procesarImportacionCajeroTurnosWithConnection");connexion.begin();			
			
			CajeroTurnoParameterReturnGeneral cajeroturnoReturnGeneral=new CajeroTurnoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cajeroturnos=new ArrayList<CajeroTurno>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cajeroturno=new CajeroTurno();
				
				
				if(conColumnasBase) {this.cajeroturno.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cajeroturno.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				//this.cajeroturno.sethora_inicio(arrColumnas[iColumn++]);
				//this.cajeroturno.sethora_fin(arrColumnas[iColumn++]);
				//this.cajeroturno.sethora_servicio(arrColumnas[iColumn++]);
				
				this.cajeroturnos.add(this.cajeroturno);
			}
			
			this.saveCajeroTurnos();
			
			this.connexion.commit();
			
			cajeroturnoReturnGeneral.setConRetornoEstaProcesado(true);
			cajeroturnoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cajeroturnoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCajeroTurnosEliminados() throws Exception {				
		
		List<CajeroTurno> cajeroturnosAux= new ArrayList<CajeroTurno>();
		
		for(CajeroTurno cajeroturno:cajeroturnos) {
			if(!cajeroturno.getIsDeleted()) {
				cajeroturnosAux.add(cajeroturno);
			}
		}
		
		cajeroturnos=cajeroturnosAux;
	}
	
	public void quitarCajeroTurnosNulos() throws Exception {				
		
		List<CajeroTurno> cajeroturnosAux= new ArrayList<CajeroTurno>();
		
		for(CajeroTurno cajeroturno : this.cajeroturnos) {
			if(cajeroturno==null) {
				cajeroturnosAux.add(cajeroturno);
			}
		}
		
		//this.cajeroturnos=cajeroturnosAux;
		
		this.cajeroturnos.removeAll(cajeroturnosAux);
	}
	
	public void getSetVersionRowCajeroTurnoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cajeroturno.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cajeroturno.getIsDeleted() || (cajeroturno.getIsChanged()&&!cajeroturno.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cajeroturnoDataAccess.getSetVersionRowCajeroTurno(connexion,cajeroturno.getId());
				
				if(!cajeroturno.getVersionRow().equals(timestamp)) {	
					cajeroturno.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cajeroturno.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCajeroTurno()throws Exception {	
		
		if(cajeroturno.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cajeroturno.getIsDeleted() || (cajeroturno.getIsChanged()&&!cajeroturno.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cajeroturnoDataAccess.getSetVersionRowCajeroTurno(connexion,cajeroturno.getId());
			
			try {							
				if(!cajeroturno.getVersionRow().equals(timestamp)) {	
					cajeroturno.setVersionRow(timestamp);
				}
				
				cajeroturno.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCajeroTurnosWithConnection()throws Exception {	
		if(cajeroturnos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CajeroTurno cajeroturnoAux:cajeroturnos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cajeroturnoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cajeroturnoAux.getIsDeleted() || (cajeroturnoAux.getIsChanged()&&!cajeroturnoAux.getIsNew())) {
						
						timestamp=cajeroturnoDataAccess.getSetVersionRowCajeroTurno(connexion,cajeroturnoAux.getId());
						
						if(!cajeroturno.getVersionRow().equals(timestamp)) {	
							cajeroturnoAux.setVersionRow(timestamp);
						}
								
						cajeroturnoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCajeroTurnos()throws Exception {	
		if(cajeroturnos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CajeroTurno cajeroturnoAux:cajeroturnos) {
					if(cajeroturnoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cajeroturnoAux.getIsDeleted() || (cajeroturnoAux.getIsChanged()&&!cajeroturnoAux.getIsNew())) {
						
						timestamp=cajeroturnoDataAccess.getSetVersionRowCajeroTurno(connexion,cajeroturnoAux.getId());
						
						if(!cajeroturnoAux.getVersionRow().equals(timestamp)) {	
							cajeroturnoAux.setVersionRow(timestamp);
						}
						
													
						cajeroturnoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CajeroTurnoParameterReturnGeneral cargarCombosLoteForeignKeyCajeroTurnoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalVendedor,String finalQueryGlobalCaja,String finalQueryGlobalMesa,String finalQueryGlobalTurnoPunVen) throws Exception {
		CajeroTurnoParameterReturnGeneral  cajeroturnoReturnGeneral =new CajeroTurnoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-cargarCombosLoteForeignKeyCajeroTurnoWithConnection");connexion.begin();
			
			cajeroturnoReturnGeneral =new CajeroTurnoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cajeroturnoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			cajeroturnoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			cajeroturnoReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			cajeroturnoReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Caja> cajasForeignKey=new ArrayList<Caja>();
			CajaLogic cajaLogic=new CajaLogic();
			cajaLogic.setConnexion(this.connexion);
			cajaLogic.getCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCaja.equals("NONE")) {
				cajaLogic.getTodosCajas(finalQueryGlobalCaja,new Pagination());
				cajasForeignKey=cajaLogic.getCajas();
			}

			cajeroturnoReturnGeneral.setcajasForeignKey(cajasForeignKey);


			List<Mesa> mesasForeignKey=new ArrayList<Mesa>();
			MesaLogic mesaLogic=new MesaLogic();
			mesaLogic.setConnexion(this.connexion);
			mesaLogic.getMesaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMesa.equals("NONE")) {
				mesaLogic.getTodosMesas(finalQueryGlobalMesa,new Pagination());
				mesasForeignKey=mesaLogic.getMesas();
			}

			cajeroturnoReturnGeneral.setmesasForeignKey(mesasForeignKey);


			List<TurnoPunVen> turnopunvensForeignKey=new ArrayList<TurnoPunVen>();
			TurnoPunVenLogic turnopunvenLogic=new TurnoPunVenLogic();
			turnopunvenLogic.setConnexion(this.connexion);
			turnopunvenLogic.getTurnoPunVenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTurnoPunVen.equals("NONE")) {
				turnopunvenLogic.getTodosTurnoPunVens(finalQueryGlobalTurnoPunVen,new Pagination());
				turnopunvensForeignKey=turnopunvenLogic.getTurnoPunVens();
			}

			cajeroturnoReturnGeneral.setturnopunvensForeignKey(turnopunvensForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cajeroturnoReturnGeneral;
	}
	
	public CajeroTurnoParameterReturnGeneral cargarCombosLoteForeignKeyCajeroTurno(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario,String finalQueryGlobalVendedor,String finalQueryGlobalCaja,String finalQueryGlobalMesa,String finalQueryGlobalTurnoPunVen) throws Exception {
		CajeroTurnoParameterReturnGeneral  cajeroturnoReturnGeneral =new CajeroTurnoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cajeroturnoReturnGeneral =new CajeroTurnoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cajeroturnoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			cajeroturnoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			cajeroturnoReturnGeneral.setusuariosForeignKey(usuariosForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			cajeroturnoReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<Caja> cajasForeignKey=new ArrayList<Caja>();
			CajaLogic cajaLogic=new CajaLogic();
			cajaLogic.setConnexion(this.connexion);
			cajaLogic.getCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCaja.equals("NONE")) {
				cajaLogic.getTodosCajas(finalQueryGlobalCaja,new Pagination());
				cajasForeignKey=cajaLogic.getCajas();
			}

			cajeroturnoReturnGeneral.setcajasForeignKey(cajasForeignKey);


			List<Mesa> mesasForeignKey=new ArrayList<Mesa>();
			MesaLogic mesaLogic=new MesaLogic();
			mesaLogic.setConnexion(this.connexion);
			mesaLogic.getMesaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMesa.equals("NONE")) {
				mesaLogic.getTodosMesas(finalQueryGlobalMesa,new Pagination());
				mesasForeignKey=mesaLogic.getMesas();
			}

			cajeroturnoReturnGeneral.setmesasForeignKey(mesasForeignKey);


			List<TurnoPunVen> turnopunvensForeignKey=new ArrayList<TurnoPunVen>();
			TurnoPunVenLogic turnopunvenLogic=new TurnoPunVenLogic();
			turnopunvenLogic.setConnexion(this.connexion);
			turnopunvenLogic.getTurnoPunVenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTurnoPunVen.equals("NONE")) {
				turnopunvenLogic.getTodosTurnoPunVens(finalQueryGlobalTurnoPunVen,new Pagination());
				turnopunvensForeignKey=turnopunvenLogic.getTurnoPunVens();
			}

			cajeroturnoReturnGeneral.setturnopunvensForeignKey(turnopunvensForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cajeroturnoReturnGeneral;
	}
	
	
	public void deepLoad(CajeroTurno cajeroturno,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CajeroTurnoLogicAdditional.updateCajeroTurnoToGet(cajeroturno,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cajeroturno.setEmpresa(cajeroturnoDataAccess.getEmpresa(connexion,cajeroturno));
		cajeroturno.setSucursal(cajeroturnoDataAccess.getSucursal(connexion,cajeroturno));
		cajeroturno.setUsuario(cajeroturnoDataAccess.getUsuario(connexion,cajeroturno));
		cajeroturno.setVendedor(cajeroturnoDataAccess.getVendedor(connexion,cajeroturno));
		cajeroturno.setCaja(cajeroturnoDataAccess.getCaja(connexion,cajeroturno));
		cajeroturno.setMesa(cajeroturnoDataAccess.getMesa(connexion,cajeroturno));
		cajeroturno.setTurnoPunVen(cajeroturnoDataAccess.getTurnoPunVen(connexion,cajeroturno));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cajeroturno.setEmpresa(cajeroturnoDataAccess.getEmpresa(connexion,cajeroturno));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				cajeroturno.setSucursal(cajeroturnoDataAccess.getSucursal(connexion,cajeroturno));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				cajeroturno.setUsuario(cajeroturnoDataAccess.getUsuario(connexion,cajeroturno));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				cajeroturno.setVendedor(cajeroturnoDataAccess.getVendedor(connexion,cajeroturno));
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				cajeroturno.setCaja(cajeroturnoDataAccess.getCaja(connexion,cajeroturno));
				continue;
			}

			if(clas.clas.equals(Mesa.class)) {
				cajeroturno.setMesa(cajeroturnoDataAccess.getMesa(connexion,cajeroturno));
				continue;
			}

			if(clas.clas.equals(TurnoPunVen.class)) {
				cajeroturno.setTurnoPunVen(cajeroturnoDataAccess.getTurnoPunVen(connexion,cajeroturno));
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
			cajeroturno.setEmpresa(cajeroturnoDataAccess.getEmpresa(connexion,cajeroturno));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajeroturno.setSucursal(cajeroturnoDataAccess.getSucursal(connexion,cajeroturno));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajeroturno.setUsuario(cajeroturnoDataAccess.getUsuario(connexion,cajeroturno));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajeroturno.setVendedor(cajeroturnoDataAccess.getVendedor(connexion,cajeroturno));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajeroturno.setCaja(cajeroturnoDataAccess.getCaja(connexion,cajeroturno));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mesa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajeroturno.setMesa(cajeroturnoDataAccess.getMesa(connexion,cajeroturno));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TurnoPunVen.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajeroturno.setTurnoPunVen(cajeroturnoDataAccess.getTurnoPunVen(connexion,cajeroturno));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cajeroturno.setEmpresa(cajeroturnoDataAccess.getEmpresa(connexion,cajeroturno));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cajeroturno.getEmpresa(),isDeep,deepLoadType,clases);
				
		cajeroturno.setSucursal(cajeroturnoDataAccess.getSucursal(connexion,cajeroturno));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cajeroturno.getSucursal(),isDeep,deepLoadType,clases);
				
		cajeroturno.setUsuario(cajeroturnoDataAccess.getUsuario(connexion,cajeroturno));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(cajeroturno.getUsuario(),isDeep,deepLoadType,clases);
				
		cajeroturno.setVendedor(cajeroturnoDataAccess.getVendedor(connexion,cajeroturno));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(cajeroturno.getVendedor(),isDeep,deepLoadType,clases);
				
		cajeroturno.setCaja(cajeroturnoDataAccess.getCaja(connexion,cajeroturno));
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(cajeroturno.getCaja(),isDeep,deepLoadType,clases);
				
		cajeroturno.setMesa(cajeroturnoDataAccess.getMesa(connexion,cajeroturno));
		MesaLogic mesaLogic= new MesaLogic(connexion);
		mesaLogic.deepLoad(cajeroturno.getMesa(),isDeep,deepLoadType,clases);
				
		cajeroturno.setTurnoPunVen(cajeroturnoDataAccess.getTurnoPunVen(connexion,cajeroturno));
		TurnoPunVenLogic turnopunvenLogic= new TurnoPunVenLogic(connexion);
		turnopunvenLogic.deepLoad(cajeroturno.getTurnoPunVen(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cajeroturno.setEmpresa(cajeroturnoDataAccess.getEmpresa(connexion,cajeroturno));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cajeroturno.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				cajeroturno.setSucursal(cajeroturnoDataAccess.getSucursal(connexion,cajeroturno));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(cajeroturno.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				cajeroturno.setUsuario(cajeroturnoDataAccess.getUsuario(connexion,cajeroturno));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(cajeroturno.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				cajeroturno.setVendedor(cajeroturnoDataAccess.getVendedor(connexion,cajeroturno));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(cajeroturno.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				cajeroturno.setCaja(cajeroturnoDataAccess.getCaja(connexion,cajeroturno));
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepLoad(cajeroturno.getCaja(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mesa.class)) {
				cajeroturno.setMesa(cajeroturnoDataAccess.getMesa(connexion,cajeroturno));
				MesaLogic mesaLogic= new MesaLogic(connexion);
				mesaLogic.deepLoad(cajeroturno.getMesa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TurnoPunVen.class)) {
				cajeroturno.setTurnoPunVen(cajeroturnoDataAccess.getTurnoPunVen(connexion,cajeroturno));
				TurnoPunVenLogic turnopunvenLogic= new TurnoPunVenLogic(connexion);
				turnopunvenLogic.deepLoad(cajeroturno.getTurnoPunVen(),isDeep,deepLoadType,clases);				
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
			cajeroturno.setEmpresa(cajeroturnoDataAccess.getEmpresa(connexion,cajeroturno));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cajeroturno.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajeroturno.setSucursal(cajeroturnoDataAccess.getSucursal(connexion,cajeroturno));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(cajeroturno.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajeroturno.setUsuario(cajeroturnoDataAccess.getUsuario(connexion,cajeroturno));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(cajeroturno.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajeroturno.setVendedor(cajeroturnoDataAccess.getVendedor(connexion,cajeroturno));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(cajeroturno.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajeroturno.setCaja(cajeroturnoDataAccess.getCaja(connexion,cajeroturno));
			CajaLogic cajaLogic= new CajaLogic(connexion);
			cajaLogic.deepLoad(cajeroturno.getCaja(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mesa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajeroturno.setMesa(cajeroturnoDataAccess.getMesa(connexion,cajeroturno));
			MesaLogic mesaLogic= new MesaLogic(connexion);
			mesaLogic.deepLoad(cajeroturno.getMesa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TurnoPunVen.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajeroturno.setTurnoPunVen(cajeroturnoDataAccess.getTurnoPunVen(connexion,cajeroturno));
			TurnoPunVenLogic turnopunvenLogic= new TurnoPunVenLogic(connexion);
			turnopunvenLogic.deepLoad(cajeroturno.getTurnoPunVen(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CajeroTurno cajeroturno,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CajeroTurnoLogicAdditional.updateCajeroTurnoToSave(cajeroturno,this.arrDatoGeneral);
			
CajeroTurnoDataAccess.save(cajeroturno, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cajeroturno.getEmpresa(),connexion);

		SucursalDataAccess.save(cajeroturno.getSucursal(),connexion);

		UsuarioDataAccess.save(cajeroturno.getUsuario(),connexion);

		VendedorDataAccess.save(cajeroturno.getVendedor(),connexion);

		CajaDataAccess.save(cajeroturno.getCaja(),connexion);

		MesaDataAccess.save(cajeroturno.getMesa(),connexion);

		TurnoPunVenDataAccess.save(cajeroturno.getTurnoPunVen(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cajeroturno.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(cajeroturno.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(cajeroturno.getUsuario(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(cajeroturno.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				CajaDataAccess.save(cajeroturno.getCaja(),connexion);
				continue;
			}

			if(clas.clas.equals(Mesa.class)) {
				MesaDataAccess.save(cajeroturno.getMesa(),connexion);
				continue;
			}

			if(clas.clas.equals(TurnoPunVen.class)) {
				TurnoPunVenDataAccess.save(cajeroturno.getTurnoPunVen(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cajeroturno.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cajeroturno.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(cajeroturno.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cajeroturno.getSucursal(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(cajeroturno.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(cajeroturno.getUsuario(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(cajeroturno.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(cajeroturno.getVendedor(),isDeep,deepLoadType,clases);
				

		CajaDataAccess.save(cajeroturno.getCaja(),connexion);
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(cajeroturno.getCaja(),isDeep,deepLoadType,clases);
				

		MesaDataAccess.save(cajeroturno.getMesa(),connexion);
		MesaLogic mesaLogic= new MesaLogic(connexion);
		mesaLogic.deepLoad(cajeroturno.getMesa(),isDeep,deepLoadType,clases);
				

		TurnoPunVenDataAccess.save(cajeroturno.getTurnoPunVen(),connexion);
		TurnoPunVenLogic turnopunvenLogic= new TurnoPunVenLogic(connexion);
		turnopunvenLogic.deepLoad(cajeroturno.getTurnoPunVen(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cajeroturno.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(cajeroturno.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(cajeroturno.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(cajeroturno.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(cajeroturno.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(cajeroturno.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(cajeroturno.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(cajeroturno.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				CajaDataAccess.save(cajeroturno.getCaja(),connexion);
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepSave(cajeroturno.getCaja(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mesa.class)) {
				MesaDataAccess.save(cajeroturno.getMesa(),connexion);
				MesaLogic mesaLogic= new MesaLogic(connexion);
				mesaLogic.deepSave(cajeroturno.getMesa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TurnoPunVen.class)) {
				TurnoPunVenDataAccess.save(cajeroturno.getTurnoPunVen(),connexion);
				TurnoPunVenLogic turnopunvenLogic= new TurnoPunVenLogic(connexion);
				turnopunvenLogic.deepSave(cajeroturno.getTurnoPunVen(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(CajeroTurno.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cajeroturno,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(cajeroturno);
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
			this.deepLoad(this.cajeroturno,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturno);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CajeroTurno.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cajeroturnos!=null) {
				for(CajeroTurno cajeroturno:cajeroturnos) {
					this.deepLoad(cajeroturno,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(cajeroturnos);
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
			if(cajeroturnos!=null) {
				for(CajeroTurno cajeroturno:cajeroturnos) {
					this.deepLoad(cajeroturno,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(cajeroturnos);
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
			this.getNewConnexionToDeep(CajeroTurno.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cajeroturno,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CajeroTurno.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cajeroturnos!=null) {
				for(CajeroTurno cajeroturno:cajeroturnos) {
					this.deepSave(cajeroturno,isDeep,deepLoadType,clases);
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
			if(cajeroturnos!=null) {
				for(CajeroTurno cajeroturno:cajeroturnos) {
					this.deepSave(cajeroturno,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCajeroTurnosFK_IdCajaWithConnection(String sFinalQuery,Pagination pagination,Long id_caja)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_caja,CajeroTurnoConstantesFunciones.IDCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCaja);

			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajeroTurnosFK_IdCaja(String sFinalQuery,Pagination pagination,Long id_caja)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_caja,CajeroTurnoConstantesFunciones.IDCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCaja);

			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajeroTurnosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CajeroTurnoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajeroTurnosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CajeroTurnoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajeroTurnosFK_IdMesaWithConnection(String sFinalQuery,Pagination pagination,Long id_mesa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMesa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMesa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mesa,CajeroTurnoConstantesFunciones.IDMESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMesa);

			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMesa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajeroTurnosFK_IdMesa(String sFinalQuery,Pagination pagination,Long id_mesa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMesa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMesa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mesa,CajeroTurnoConstantesFunciones.IDMESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMesa);

			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMesa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajeroTurnosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CajeroTurnoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajeroTurnosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CajeroTurnoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajeroTurnosFK_IdTurnoPunVenWithConnection(String sFinalQuery,Pagination pagination,Long id_turno_pun_ven)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTurnoPunVen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTurnoPunVen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_turno_pun_ven,CajeroTurnoConstantesFunciones.IDTURNOPUNVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTurnoPunVen);

			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTurnoPunVen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajeroTurnosFK_IdTurnoPunVen(String sFinalQuery,Pagination pagination,Long id_turno_pun_ven)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTurnoPunVen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTurnoPunVen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_turno_pun_ven,CajeroTurnoConstantesFunciones.IDTURNOPUNVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTurnoPunVen);

			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTurnoPunVen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajeroTurnosFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,CajeroTurnoConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajeroTurnosFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,CajeroTurnoConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajeroTurnosFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajeroTurno.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,CajeroTurnoConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajeroTurnosFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,CajeroTurnoConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			CajeroTurnoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajeroTurnoConstantesFunciones.refrescarForeignKeysDescripcionesCajeroTurno(this.cajeroturnos);
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
			if(CajeroTurnoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CajeroTurnoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CajeroTurno cajeroturno,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CajeroTurnoConstantesFunciones.ISCONAUDITORIA) {
				if(cajeroturno.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CajeroTurnoDataAccess.TABLENAME, cajeroturno.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CajeroTurnoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CajeroTurnoLogic.registrarAuditoriaDetallesCajeroTurno(connexion,cajeroturno,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cajeroturno.getIsDeleted()) {
					/*if(!cajeroturno.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CajeroTurnoDataAccess.TABLENAME, cajeroturno.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CajeroTurnoLogic.registrarAuditoriaDetallesCajeroTurno(connexion,cajeroturno,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CajeroTurnoDataAccess.TABLENAME, cajeroturno.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cajeroturno.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CajeroTurnoDataAccess.TABLENAME, cajeroturno.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CajeroTurnoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CajeroTurnoLogic.registrarAuditoriaDetallesCajeroTurno(connexion,cajeroturno,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCajeroTurno(Connexion connexion,CajeroTurno cajeroturno)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cajeroturno.getIsNew()||!cajeroturno.getid_empresa().equals(cajeroturno.getCajeroTurnoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajeroturno.getCajeroTurnoOriginal().getid_empresa()!=null)
				{
					strValorActual=cajeroturno.getCajeroTurnoOriginal().getid_empresa().toString();
				}
				if(cajeroturno.getid_empresa()!=null)
				{
					strValorNuevo=cajeroturno.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajeroTurnoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(cajeroturno.getIsNew()||!cajeroturno.getid_sucursal().equals(cajeroturno.getCajeroTurnoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajeroturno.getCajeroTurnoOriginal().getid_sucursal()!=null)
				{
					strValorActual=cajeroturno.getCajeroTurnoOriginal().getid_sucursal().toString();
				}
				if(cajeroturno.getid_sucursal()!=null)
				{
					strValorNuevo=cajeroturno.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajeroTurnoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(cajeroturno.getIsNew()||!cajeroturno.getid_usuario().equals(cajeroturno.getCajeroTurnoOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajeroturno.getCajeroTurnoOriginal().getid_usuario()!=null)
				{
					strValorActual=cajeroturno.getCajeroTurnoOriginal().getid_usuario().toString();
				}
				if(cajeroturno.getid_usuario()!=null)
				{
					strValorNuevo=cajeroturno.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajeroTurnoConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(cajeroturno.getIsNew()||!cajeroturno.getid_vendedor().equals(cajeroturno.getCajeroTurnoOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajeroturno.getCajeroTurnoOriginal().getid_vendedor()!=null)
				{
					strValorActual=cajeroturno.getCajeroTurnoOriginal().getid_vendedor().toString();
				}
				if(cajeroturno.getid_vendedor()!=null)
				{
					strValorNuevo=cajeroturno.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajeroTurnoConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(cajeroturno.getIsNew()||!cajeroturno.getid_caja().equals(cajeroturno.getCajeroTurnoOriginal().getid_caja()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajeroturno.getCajeroTurnoOriginal().getid_caja()!=null)
				{
					strValorActual=cajeroturno.getCajeroTurnoOriginal().getid_caja().toString();
				}
				if(cajeroturno.getid_caja()!=null)
				{
					strValorNuevo=cajeroturno.getid_caja().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajeroTurnoConstantesFunciones.IDCAJA,strValorActual,strValorNuevo);
			}	
			
			if(cajeroturno.getIsNew()||!cajeroturno.getid_mesa().equals(cajeroturno.getCajeroTurnoOriginal().getid_mesa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajeroturno.getCajeroTurnoOriginal().getid_mesa()!=null)
				{
					strValorActual=cajeroturno.getCajeroTurnoOriginal().getid_mesa().toString();
				}
				if(cajeroturno.getid_mesa()!=null)
				{
					strValorNuevo=cajeroturno.getid_mesa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajeroTurnoConstantesFunciones.IDMESA,strValorActual,strValorNuevo);
			}	
			
			if(cajeroturno.getIsNew()||!cajeroturno.getid_turno_pun_ven().equals(cajeroturno.getCajeroTurnoOriginal().getid_turno_pun_ven()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajeroturno.getCajeroTurnoOriginal().getid_turno_pun_ven()!=null)
				{
					strValorActual=cajeroturno.getCajeroTurnoOriginal().getid_turno_pun_ven().toString();
				}
				if(cajeroturno.getid_turno_pun_ven()!=null)
				{
					strValorNuevo=cajeroturno.getid_turno_pun_ven().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajeroTurnoConstantesFunciones.IDTURNOPUNVEN,strValorActual,strValorNuevo);
			}	
			
			if(cajeroturno.getIsNew()||!cajeroturno.gethora_inicio().equals(cajeroturno.getCajeroTurnoOriginal().gethora_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajeroturno.getCajeroTurnoOriginal().gethora_inicio()!=null)
				{
					strValorActual=cajeroturno.getCajeroTurnoOriginal().gethora_inicio().toString();
				}
				if(cajeroturno.gethora_inicio()!=null)
				{
					strValorNuevo=cajeroturno.gethora_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajeroTurnoConstantesFunciones.HORAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(cajeroturno.getIsNew()||!cajeroturno.gethora_fin().equals(cajeroturno.getCajeroTurnoOriginal().gethora_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajeroturno.getCajeroTurnoOriginal().gethora_fin()!=null)
				{
					strValorActual=cajeroturno.getCajeroTurnoOriginal().gethora_fin().toString();
				}
				if(cajeroturno.gethora_fin()!=null)
				{
					strValorNuevo=cajeroturno.gethora_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajeroTurnoConstantesFunciones.HORAFIN,strValorActual,strValorNuevo);
			}	
			
			if(cajeroturno.getIsNew()||!cajeroturno.gethora_servicio().equals(cajeroturno.getCajeroTurnoOriginal().gethora_servicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajeroturno.getCajeroTurnoOriginal().gethora_servicio()!=null)
				{
					strValorActual=cajeroturno.getCajeroTurnoOriginal().gethora_servicio().toString();
				}
				if(cajeroturno.gethora_servicio()!=null)
				{
					strValorNuevo=cajeroturno.gethora_servicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajeroTurnoConstantesFunciones.HORASERVICIO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCajeroTurnoRelacionesWithConnection(CajeroTurno cajeroturno) throws Exception {

		if(!cajeroturno.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCajeroTurnoRelacionesBase(cajeroturno,true);
		}
	}

	public void saveCajeroTurnoRelaciones(CajeroTurno cajeroturno)throws Exception {

		if(!cajeroturno.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCajeroTurnoRelacionesBase(cajeroturno,false);
		}
	}

	public void saveCajeroTurnoRelacionesBase(CajeroTurno cajeroturno,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CajeroTurno-saveRelacionesWithConnection");}
	

			this.setCajeroTurno(cajeroturno);

			if(CajeroTurnoLogicAdditional.validarSaveRelaciones(cajeroturno,this)) {

				CajeroTurnoLogicAdditional.updateRelacionesToSave(cajeroturno,this);

				if((cajeroturno.getIsNew()||cajeroturno.getIsChanged())&&!cajeroturno.getIsDeleted()) {
					this.saveCajeroTurno();
					this.saveCajeroTurnoRelacionesDetalles();

				} else if(cajeroturno.getIsDeleted()) {
					this.saveCajeroTurnoRelacionesDetalles();
					this.saveCajeroTurno();
				}

				CajeroTurnoLogicAdditional.updateRelacionesToSaveAfter(cajeroturno,this);

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
	
	
	private void saveCajeroTurnoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCajeroTurno(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CajeroTurnoConstantesFunciones.getClassesForeignKeysOfCajeroTurno(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajeroTurno(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CajeroTurnoConstantesFunciones.getClassesRelationshipsOfCajeroTurno(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

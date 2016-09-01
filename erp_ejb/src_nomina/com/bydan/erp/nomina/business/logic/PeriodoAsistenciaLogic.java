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
import com.bydan.erp.nomina.util.PeriodoAsistenciaConstantesFunciones;
import com.bydan.erp.nomina.util.PeriodoAsistenciaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.PeriodoAsistenciaParameterGeneral;
import com.bydan.erp.nomina.business.entity.PeriodoAsistencia;
import com.bydan.erp.nomina.business.logic.PeriodoAsistenciaLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

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
public class PeriodoAsistenciaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PeriodoAsistenciaLogic.class);
	
	protected PeriodoAsistenciaDataAccess periodoasistenciaDataAccess; 	
	protected PeriodoAsistencia periodoasistencia;
	protected List<PeriodoAsistencia> periodoasistencias;
	protected Object periodoasistenciaObject;	
	protected List<Object> periodoasistenciasObject;
	
	public static ClassValidator<PeriodoAsistencia> periodoasistenciaValidator = new ClassValidator<PeriodoAsistencia>(PeriodoAsistencia.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PeriodoAsistenciaLogicAdditional periodoasistenciaLogicAdditional=null;
	
	public PeriodoAsistenciaLogicAdditional getPeriodoAsistenciaLogicAdditional() {
		return this.periodoasistenciaLogicAdditional;
	}
	
	public void setPeriodoAsistenciaLogicAdditional(PeriodoAsistenciaLogicAdditional periodoasistenciaLogicAdditional) {
		try {
			this.periodoasistenciaLogicAdditional=periodoasistenciaLogicAdditional;
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
	
	
	
	
	public  PeriodoAsistenciaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.periodoasistenciaDataAccess = new PeriodoAsistenciaDataAccess();
			
			this.periodoasistencias= new ArrayList<PeriodoAsistencia>();
			this.periodoasistencia= new PeriodoAsistencia();
			
			this.periodoasistenciaObject=new Object();
			this.periodoasistenciasObject=new ArrayList<Object>();
				
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
			
			this.periodoasistenciaDataAccess.setConnexionType(this.connexionType);
			this.periodoasistenciaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PeriodoAsistenciaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.periodoasistenciaDataAccess = new PeriodoAsistenciaDataAccess();
			this.periodoasistencias= new ArrayList<PeriodoAsistencia>();
			this.periodoasistencia= new PeriodoAsistencia();
			this.periodoasistenciaObject=new Object();
			this.periodoasistenciasObject=new ArrayList<Object>();
			
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
			
			this.periodoasistenciaDataAccess.setConnexionType(this.connexionType);
			this.periodoasistenciaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PeriodoAsistencia getPeriodoAsistencia() throws Exception {	
		PeriodoAsistenciaLogicAdditional.checkPeriodoAsistenciaToGet(periodoasistencia,this.datosCliente,this.arrDatoGeneral);
		PeriodoAsistenciaLogicAdditional.updatePeriodoAsistenciaToGet(periodoasistencia,this.arrDatoGeneral);
		
		return periodoasistencia;
	}
		
	public void setPeriodoAsistencia(PeriodoAsistencia newPeriodoAsistencia) {
		this.periodoasistencia = newPeriodoAsistencia;
	}
	
	public PeriodoAsistenciaDataAccess getPeriodoAsistenciaDataAccess() {
		return periodoasistenciaDataAccess;
	}
	
	public void setPeriodoAsistenciaDataAccess(PeriodoAsistenciaDataAccess newperiodoasistenciaDataAccess) {
		this.periodoasistenciaDataAccess = newperiodoasistenciaDataAccess;
	}
	
	public List<PeriodoAsistencia> getPeriodoAsistencias() throws Exception {		
		this.quitarPeriodoAsistenciasNulos();
		
		PeriodoAsistenciaLogicAdditional.checkPeriodoAsistenciaToGets(periodoasistencias,this.datosCliente,this.arrDatoGeneral);
		
		for (PeriodoAsistencia periodoasistenciaLocal: periodoasistencias ) {
			PeriodoAsistenciaLogicAdditional.updatePeriodoAsistenciaToGet(periodoasistenciaLocal,this.arrDatoGeneral);
		}
		
		return periodoasistencias;
	}
	
	public void setPeriodoAsistencias(List<PeriodoAsistencia> newPeriodoAsistencias) {
		this.periodoasistencias = newPeriodoAsistencias;
	}
	
	public Object getPeriodoAsistenciaObject() {	
		this.periodoasistenciaObject=this.periodoasistenciaDataAccess.getEntityObject();
		return this.periodoasistenciaObject;
	}
		
	public void setPeriodoAsistenciaObject(Object newPeriodoAsistenciaObject) {
		this.periodoasistenciaObject = newPeriodoAsistenciaObject;
	}
	
	public List<Object> getPeriodoAsistenciasObject() {		
		this.periodoasistenciasObject=this.periodoasistenciaDataAccess.getEntitiesObject();
		return this.periodoasistenciasObject;
	}
		
	public void setPeriodoAsistenciasObject(List<Object> newPeriodoAsistenciasObject) {
		this.periodoasistenciasObject = newPeriodoAsistenciasObject;
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
		
		if(this.periodoasistenciaDataAccess!=null) {
			this.periodoasistenciaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoAsistencia.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			periodoasistenciaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			periodoasistenciaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		periodoasistencia = new  PeriodoAsistencia();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoAsistencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			periodoasistencia=periodoasistenciaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.periodoasistencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencia);
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
		periodoasistencia = new  PeriodoAsistencia();
		  		  
        try {
			
			periodoasistencia=periodoasistenciaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.periodoasistencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		periodoasistencia = new  PeriodoAsistencia();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoAsistencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			periodoasistencia=periodoasistenciaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.periodoasistencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencia);
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
		periodoasistencia = new  PeriodoAsistencia();
		  		  
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
		periodoasistencia = new  PeriodoAsistencia();
		  		  
        try {
			
			periodoasistencia=periodoasistenciaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.periodoasistencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		periodoasistencia = new  PeriodoAsistencia();
		  		  
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
		periodoasistencia = new  PeriodoAsistencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoAsistencia.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =periodoasistenciaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		periodoasistencia = new  PeriodoAsistencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=periodoasistenciaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		periodoasistencia = new  PeriodoAsistencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoAsistencia.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =periodoasistenciaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		periodoasistencia = new  PeriodoAsistencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=periodoasistenciaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		periodoasistencia = new  PeriodoAsistencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoAsistencia.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =periodoasistenciaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		periodoasistencia = new  PeriodoAsistencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=periodoasistenciaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		periodoasistencias = new  ArrayList<PeriodoAsistencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoAsistencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PeriodoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoasistencias=periodoasistenciaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPeriodoAsistencia(periodoasistencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencias);
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
		periodoasistencias = new  ArrayList<PeriodoAsistencia>();
		  		  
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
		periodoasistencias = new  ArrayList<PeriodoAsistencia>();
		  		  
        try {			
			PeriodoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoasistencias=periodoasistenciaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPeriodoAsistencia(periodoasistencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		periodoasistencias = new  ArrayList<PeriodoAsistencia>();
		  		  
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
		periodoasistencias = new  ArrayList<PeriodoAsistencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoAsistencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PeriodoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoasistencias=periodoasistenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPeriodoAsistencia(periodoasistencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencias);
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
		periodoasistencias = new  ArrayList<PeriodoAsistencia>();
		  		  
        try {
			PeriodoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoasistencias=periodoasistenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPeriodoAsistencia(periodoasistencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencias);
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
		periodoasistencias = new  ArrayList<PeriodoAsistencia>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoAsistencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PeriodoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoasistencias=periodoasistenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPeriodoAsistencia(periodoasistencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencias);
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
		periodoasistencias = new  ArrayList<PeriodoAsistencia>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PeriodoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoasistencias=periodoasistenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPeriodoAsistencia(periodoasistencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		periodoasistencia = new  PeriodoAsistencia();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoAsistencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PeriodoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoasistencia=periodoasistenciaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPeriodoAsistencia(periodoasistencia);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencia);
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
		periodoasistencia = new  PeriodoAsistencia();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PeriodoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoasistencia=periodoasistenciaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPeriodoAsistencia(periodoasistencia);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		periodoasistencias = new  ArrayList<PeriodoAsistencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoAsistencia.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PeriodoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoasistencias=periodoasistenciaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPeriodoAsistencia(periodoasistencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencias);
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
		periodoasistencias = new  ArrayList<PeriodoAsistencia>();
		  		  
        try {
			PeriodoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoasistencias=periodoasistenciaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPeriodoAsistencia(periodoasistencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPeriodoAsistenciasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		periodoasistencias = new  ArrayList<PeriodoAsistencia>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoAsistencia.class.getSimpleName()+"-getTodosPeriodoAsistenciasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PeriodoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoasistencias=periodoasistenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPeriodoAsistencia(periodoasistencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencias);
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
	
	public  void  getTodosPeriodoAsistencias(String sFinalQuery,Pagination pagination)throws Exception {
		periodoasistencias = new  ArrayList<PeriodoAsistencia>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PeriodoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoasistencias=periodoasistenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPeriodoAsistencia(periodoasistencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPeriodoAsistencia(PeriodoAsistencia periodoasistencia) throws Exception {
		Boolean estaValidado=false;
		
		if(periodoasistencia.getIsNew() || periodoasistencia.getIsChanged()) { 
			this.invalidValues = periodoasistenciaValidator.getInvalidValues(periodoasistencia);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(periodoasistencia);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPeriodoAsistencia(List<PeriodoAsistencia> PeriodoAsistencias) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PeriodoAsistencia periodoasistenciaLocal:periodoasistencias) {				
			estaValidadoObjeto=this.validarGuardarPeriodoAsistencia(periodoasistenciaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPeriodoAsistencia(List<PeriodoAsistencia> PeriodoAsistencias) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPeriodoAsistencia(periodoasistencias)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPeriodoAsistencia(PeriodoAsistencia PeriodoAsistencia) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPeriodoAsistencia(periodoasistencia)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PeriodoAsistencia periodoasistencia) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+periodoasistencia.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PeriodoAsistenciaConstantesFunciones.getPeriodoAsistenciaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"periodoasistencia","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PeriodoAsistenciaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PeriodoAsistenciaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePeriodoAsistenciaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoAsistencia.class.getSimpleName()+"-savePeriodoAsistenciaWithConnection");connexion.begin();			
			
			PeriodoAsistenciaLogicAdditional.checkPeriodoAsistenciaToSave(this.periodoasistencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PeriodoAsistenciaLogicAdditional.updatePeriodoAsistenciaToSave(this.periodoasistencia,this.arrDatoGeneral);
			
			PeriodoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.periodoasistencia,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPeriodoAsistencia();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPeriodoAsistencia(this.periodoasistencia)) {
				PeriodoAsistenciaDataAccess.save(this.periodoasistencia, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.periodoasistencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PeriodoAsistenciaLogicAdditional.checkPeriodoAsistenciaToSaveAfter(this.periodoasistencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPeriodoAsistencia();
			
			connexion.commit();			
			
			if(this.periodoasistencia.getIsDeleted()) {
				this.periodoasistencia=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePeriodoAsistencia()throws Exception {	
		try {	
			
			PeriodoAsistenciaLogicAdditional.checkPeriodoAsistenciaToSave(this.periodoasistencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PeriodoAsistenciaLogicAdditional.updatePeriodoAsistenciaToSave(this.periodoasistencia,this.arrDatoGeneral);
			
			PeriodoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.periodoasistencia,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPeriodoAsistencia(this.periodoasistencia)) {			
				PeriodoAsistenciaDataAccess.save(this.periodoasistencia, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.periodoasistencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PeriodoAsistenciaLogicAdditional.checkPeriodoAsistenciaToSaveAfter(this.periodoasistencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.periodoasistencia.getIsDeleted()) {
				this.periodoasistencia=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePeriodoAsistenciasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoAsistencia.class.getSimpleName()+"-savePeriodoAsistenciasWithConnection");connexion.begin();			
			
			PeriodoAsistenciaLogicAdditional.checkPeriodoAsistenciaToSaves(periodoasistencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPeriodoAsistencias();
			
			Boolean validadoTodosPeriodoAsistencia=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PeriodoAsistencia periodoasistenciaLocal:periodoasistencias) {		
				if(periodoasistenciaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PeriodoAsistenciaLogicAdditional.updatePeriodoAsistenciaToSave(periodoasistenciaLocal,this.arrDatoGeneral);
	        	
				PeriodoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),periodoasistenciaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPeriodoAsistencia(periodoasistenciaLocal)) {
					PeriodoAsistenciaDataAccess.save(periodoasistenciaLocal, connexion);				
				} else {
					validadoTodosPeriodoAsistencia=false;
				}
			}
			
			if(!validadoTodosPeriodoAsistencia) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PeriodoAsistenciaLogicAdditional.checkPeriodoAsistenciaToSavesAfter(periodoasistencias,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPeriodoAsistencias();
			
			connexion.commit();		
			
			this.quitarPeriodoAsistenciasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePeriodoAsistencias()throws Exception {				
		 try {	
			PeriodoAsistenciaLogicAdditional.checkPeriodoAsistenciaToSaves(periodoasistencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPeriodoAsistencia=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PeriodoAsistencia periodoasistenciaLocal:periodoasistencias) {				
				if(periodoasistenciaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PeriodoAsistenciaLogicAdditional.updatePeriodoAsistenciaToSave(periodoasistenciaLocal,this.arrDatoGeneral);
	        	
				PeriodoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),periodoasistenciaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPeriodoAsistencia(periodoasistenciaLocal)) {				
					PeriodoAsistenciaDataAccess.save(periodoasistenciaLocal, connexion);				
				} else {
					validadoTodosPeriodoAsistencia=false;
				}
			}
			
			if(!validadoTodosPeriodoAsistencia) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PeriodoAsistenciaLogicAdditional.checkPeriodoAsistenciaToSavesAfter(periodoasistencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPeriodoAsistenciasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PeriodoAsistenciaParameterReturnGeneral procesarAccionPeriodoAsistencias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PeriodoAsistencia> periodoasistencias,PeriodoAsistenciaParameterReturnGeneral periodoasistenciaParameterGeneral)throws Exception {
		 try {	
			PeriodoAsistenciaParameterReturnGeneral periodoasistenciaReturnGeneral=new PeriodoAsistenciaParameterReturnGeneral();
	
			PeriodoAsistenciaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,periodoasistencias,periodoasistenciaParameterGeneral,periodoasistenciaReturnGeneral);
			
			return periodoasistenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PeriodoAsistenciaParameterReturnGeneral procesarAccionPeriodoAsistenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PeriodoAsistencia> periodoasistencias,PeriodoAsistenciaParameterReturnGeneral periodoasistenciaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoAsistencia.class.getSimpleName()+"-procesarAccionPeriodoAsistenciasWithConnection");connexion.begin();			
			
			PeriodoAsistenciaParameterReturnGeneral periodoasistenciaReturnGeneral=new PeriodoAsistenciaParameterReturnGeneral();
	
			PeriodoAsistenciaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,periodoasistencias,periodoasistenciaParameterGeneral,periodoasistenciaReturnGeneral);
			
			this.connexion.commit();
			
			return periodoasistenciaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PeriodoAsistenciaParameterReturnGeneral procesarEventosPeriodoAsistencias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PeriodoAsistencia> periodoasistencias,PeriodoAsistencia periodoasistencia,PeriodoAsistenciaParameterReturnGeneral periodoasistenciaParameterGeneral,Boolean isEsNuevoPeriodoAsistencia,ArrayList<Classe> clases)throws Exception {
		 try {	
			PeriodoAsistenciaParameterReturnGeneral periodoasistenciaReturnGeneral=new PeriodoAsistenciaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				periodoasistenciaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PeriodoAsistenciaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,periodoasistencias,periodoasistencia,periodoasistenciaParameterGeneral,periodoasistenciaReturnGeneral,isEsNuevoPeriodoAsistencia,clases);
			
			return periodoasistenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PeriodoAsistenciaParameterReturnGeneral procesarEventosPeriodoAsistenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PeriodoAsistencia> periodoasistencias,PeriodoAsistencia periodoasistencia,PeriodoAsistenciaParameterReturnGeneral periodoasistenciaParameterGeneral,Boolean isEsNuevoPeriodoAsistencia,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoAsistencia.class.getSimpleName()+"-procesarEventosPeriodoAsistenciasWithConnection");connexion.begin();			
			
			PeriodoAsistenciaParameterReturnGeneral periodoasistenciaReturnGeneral=new PeriodoAsistenciaParameterReturnGeneral();
	
			periodoasistenciaReturnGeneral.setPeriodoAsistencia(periodoasistencia);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				periodoasistenciaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PeriodoAsistenciaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,periodoasistencias,periodoasistencia,periodoasistenciaParameterGeneral,periodoasistenciaReturnGeneral,isEsNuevoPeriodoAsistencia,clases);
			
			this.connexion.commit();
			
			return periodoasistenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PeriodoAsistenciaParameterReturnGeneral procesarImportacionPeriodoAsistenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PeriodoAsistenciaParameterReturnGeneral periodoasistenciaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoAsistencia.class.getSimpleName()+"-procesarImportacionPeriodoAsistenciasWithConnection");connexion.begin();			
			
			PeriodoAsistenciaParameterReturnGeneral periodoasistenciaReturnGeneral=new PeriodoAsistenciaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.periodoasistencias=new ArrayList<PeriodoAsistencia>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.periodoasistencia=new PeriodoAsistencia();
				
				
				if(conColumnasBase) {this.periodoasistencia.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.periodoasistencia.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.periodoasistencia.setfecha_inicio(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.periodoasistencia.setfecha_fin(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				
				this.periodoasistencias.add(this.periodoasistencia);
			}
			
			this.savePeriodoAsistencias();
			
			this.connexion.commit();
			
			periodoasistenciaReturnGeneral.setConRetornoEstaProcesado(true);
			periodoasistenciaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return periodoasistenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPeriodoAsistenciasEliminados() throws Exception {				
		
		List<PeriodoAsistencia> periodoasistenciasAux= new ArrayList<PeriodoAsistencia>();
		
		for(PeriodoAsistencia periodoasistencia:periodoasistencias) {
			if(!periodoasistencia.getIsDeleted()) {
				periodoasistenciasAux.add(periodoasistencia);
			}
		}
		
		periodoasistencias=periodoasistenciasAux;
	}
	
	public void quitarPeriodoAsistenciasNulos() throws Exception {				
		
		List<PeriodoAsistencia> periodoasistenciasAux= new ArrayList<PeriodoAsistencia>();
		
		for(PeriodoAsistencia periodoasistencia : this.periodoasistencias) {
			if(periodoasistencia==null) {
				periodoasistenciasAux.add(periodoasistencia);
			}
		}
		
		//this.periodoasistencias=periodoasistenciasAux;
		
		this.periodoasistencias.removeAll(periodoasistenciasAux);
	}
	
	public void getSetVersionRowPeriodoAsistenciaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(periodoasistencia.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((periodoasistencia.getIsDeleted() || (periodoasistencia.getIsChanged()&&!periodoasistencia.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=periodoasistenciaDataAccess.getSetVersionRowPeriodoAsistencia(connexion,periodoasistencia.getId());
				
				if(!periodoasistencia.getVersionRow().equals(timestamp)) {	
					periodoasistencia.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				periodoasistencia.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPeriodoAsistencia()throws Exception {	
		
		if(periodoasistencia.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((periodoasistencia.getIsDeleted() || (periodoasistencia.getIsChanged()&&!periodoasistencia.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=periodoasistenciaDataAccess.getSetVersionRowPeriodoAsistencia(connexion,periodoasistencia.getId());
			
			try {							
				if(!periodoasistencia.getVersionRow().equals(timestamp)) {	
					periodoasistencia.setVersionRow(timestamp);
				}
				
				periodoasistencia.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPeriodoAsistenciasWithConnection()throws Exception {	
		if(periodoasistencias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PeriodoAsistencia periodoasistenciaAux:periodoasistencias) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(periodoasistenciaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(periodoasistenciaAux.getIsDeleted() || (periodoasistenciaAux.getIsChanged()&&!periodoasistenciaAux.getIsNew())) {
						
						timestamp=periodoasistenciaDataAccess.getSetVersionRowPeriodoAsistencia(connexion,periodoasistenciaAux.getId());
						
						if(!periodoasistencia.getVersionRow().equals(timestamp)) {	
							periodoasistenciaAux.setVersionRow(timestamp);
						}
								
						periodoasistenciaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPeriodoAsistencias()throws Exception {	
		if(periodoasistencias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PeriodoAsistencia periodoasistenciaAux:periodoasistencias) {
					if(periodoasistenciaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(periodoasistenciaAux.getIsDeleted() || (periodoasistenciaAux.getIsChanged()&&!periodoasistenciaAux.getIsNew())) {
						
						timestamp=periodoasistenciaDataAccess.getSetVersionRowPeriodoAsistencia(connexion,periodoasistenciaAux.getId());
						
						if(!periodoasistenciaAux.getVersionRow().equals(timestamp)) {	
							periodoasistenciaAux.setVersionRow(timestamp);
						}
						
													
						periodoasistenciaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PeriodoAsistenciaParameterReturnGeneral cargarCombosLoteForeignKeyPeriodoAsistenciaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo) throws Exception {
		PeriodoAsistenciaParameterReturnGeneral  periodoasistenciaReturnGeneral =new PeriodoAsistenciaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoAsistencia.class.getSimpleName()+"-cargarCombosLoteForeignKeyPeriodoAsistenciaWithConnection");connexion.begin();
			
			periodoasistenciaReturnGeneral =new PeriodoAsistenciaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			periodoasistenciaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			periodoasistenciaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			periodoasistenciaReturnGeneral.setperiodosForeignKey(periodosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return periodoasistenciaReturnGeneral;
	}
	
	public PeriodoAsistenciaParameterReturnGeneral cargarCombosLoteForeignKeyPeriodoAsistencia(String finalQueryGlobalEmpresa,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo) throws Exception {
		PeriodoAsistenciaParameterReturnGeneral  periodoasistenciaReturnGeneral =new PeriodoAsistenciaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			periodoasistenciaReturnGeneral =new PeriodoAsistenciaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			periodoasistenciaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			periodoasistenciaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			periodoasistenciaReturnGeneral.setperiodosForeignKey(periodosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return periodoasistenciaReturnGeneral;
	}
	
	
	public void deepLoad(PeriodoAsistencia periodoasistencia,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PeriodoAsistenciaLogicAdditional.updatePeriodoAsistenciaToGet(periodoasistencia,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		periodoasistencia.setEmpresa(periodoasistenciaDataAccess.getEmpresa(connexion,periodoasistencia));
		periodoasistencia.setEjercicio(periodoasistenciaDataAccess.getEjercicio(connexion,periodoasistencia));
		periodoasistencia.setPeriodo(periodoasistenciaDataAccess.getPeriodo(connexion,periodoasistencia));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				periodoasistencia.setEmpresa(periodoasistenciaDataAccess.getEmpresa(connexion,periodoasistencia));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				periodoasistencia.setEjercicio(periodoasistenciaDataAccess.getEjercicio(connexion,periodoasistencia));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				periodoasistencia.setPeriodo(periodoasistenciaDataAccess.getPeriodo(connexion,periodoasistencia));
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
			periodoasistencia.setEmpresa(periodoasistenciaDataAccess.getEmpresa(connexion,periodoasistencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			periodoasistencia.setEjercicio(periodoasistenciaDataAccess.getEjercicio(connexion,periodoasistencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			periodoasistencia.setPeriodo(periodoasistenciaDataAccess.getPeriodo(connexion,periodoasistencia));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		periodoasistencia.setEmpresa(periodoasistenciaDataAccess.getEmpresa(connexion,periodoasistencia));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(periodoasistencia.getEmpresa(),isDeep,deepLoadType,clases);
				
		periodoasistencia.setEjercicio(periodoasistenciaDataAccess.getEjercicio(connexion,periodoasistencia));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(periodoasistencia.getEjercicio(),isDeep,deepLoadType,clases);
				
		periodoasistencia.setPeriodo(periodoasistenciaDataAccess.getPeriodo(connexion,periodoasistencia));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(periodoasistencia.getPeriodo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				periodoasistencia.setEmpresa(periodoasistenciaDataAccess.getEmpresa(connexion,periodoasistencia));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(periodoasistencia.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				periodoasistencia.setEjercicio(periodoasistenciaDataAccess.getEjercicio(connexion,periodoasistencia));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(periodoasistencia.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				periodoasistencia.setPeriodo(periodoasistenciaDataAccess.getPeriodo(connexion,periodoasistencia));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(periodoasistencia.getPeriodo(),isDeep,deepLoadType,clases);				
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
			periodoasistencia.setEmpresa(periodoasistenciaDataAccess.getEmpresa(connexion,periodoasistencia));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(periodoasistencia.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			periodoasistencia.setEjercicio(periodoasistenciaDataAccess.getEjercicio(connexion,periodoasistencia));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(periodoasistencia.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			periodoasistencia.setPeriodo(periodoasistenciaDataAccess.getPeriodo(connexion,periodoasistencia));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(periodoasistencia.getPeriodo(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PeriodoAsistencia periodoasistencia,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PeriodoAsistenciaLogicAdditional.updatePeriodoAsistenciaToSave(periodoasistencia,this.arrDatoGeneral);
			
PeriodoAsistenciaDataAccess.save(periodoasistencia, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(periodoasistencia.getEmpresa(),connexion);

		EjercicioDataAccess.save(periodoasistencia.getEjercicio(),connexion);

		PeriodoDataAccess.save(periodoasistencia.getPeriodo(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(periodoasistencia.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(periodoasistencia.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(periodoasistencia.getPeriodo(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(periodoasistencia.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(periodoasistencia.getEmpresa(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(periodoasistencia.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(periodoasistencia.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(periodoasistencia.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(periodoasistencia.getPeriodo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(periodoasistencia.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(periodoasistencia.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(periodoasistencia.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(periodoasistencia.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(periodoasistencia.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(periodoasistencia.getPeriodo(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(PeriodoAsistencia.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(periodoasistencia,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(periodoasistencia);
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
			this.deepLoad(this.periodoasistencia,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PeriodoAsistencia.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(periodoasistencias!=null) {
				for(PeriodoAsistencia periodoasistencia:periodoasistencias) {
					this.deepLoad(periodoasistencia,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(periodoasistencias);
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
			if(periodoasistencias!=null) {
				for(PeriodoAsistencia periodoasistencia:periodoasistencias) {
					this.deepLoad(periodoasistencia,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(periodoasistencias);
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
			this.getNewConnexionToDeep(PeriodoAsistencia.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(periodoasistencia,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PeriodoAsistencia.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(periodoasistencias!=null) {
				for(PeriodoAsistencia periodoasistencia:periodoasistencias) {
					this.deepSave(periodoasistencia,isDeep,deepLoadType,clases);
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
			if(periodoasistencias!=null) {
				for(PeriodoAsistencia periodoasistencia:periodoasistencias) {
					this.deepSave(periodoasistencia,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPeriodoAsistenciasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoAsistencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PeriodoAsistenciaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PeriodoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			periodoasistencias=periodoasistenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPeriodoAsistenciasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PeriodoAsistenciaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PeriodoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			periodoasistencias=periodoasistenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPeriodoAsistenciasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoAsistencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PeriodoAsistenciaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PeriodoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			periodoasistencias=periodoasistenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPeriodoAsistenciasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PeriodoAsistenciaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PeriodoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			periodoasistencias=periodoasistenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPeriodoAsistenciasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoAsistencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PeriodoAsistenciaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PeriodoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			periodoasistencias=periodoasistenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPeriodoAsistenciasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PeriodoAsistenciaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PeriodoAsistenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			periodoasistencias=periodoasistenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PeriodoAsistenciaConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoAsistencia(this.periodoasistencias);
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
			if(PeriodoAsistenciaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PeriodoAsistenciaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PeriodoAsistencia periodoasistencia,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PeriodoAsistenciaConstantesFunciones.ISCONAUDITORIA) {
				if(periodoasistencia.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PeriodoAsistenciaDataAccess.TABLENAME, periodoasistencia.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PeriodoAsistenciaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PeriodoAsistenciaLogic.registrarAuditoriaDetallesPeriodoAsistencia(connexion,periodoasistencia,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(periodoasistencia.getIsDeleted()) {
					/*if(!periodoasistencia.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PeriodoAsistenciaDataAccess.TABLENAME, periodoasistencia.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PeriodoAsistenciaLogic.registrarAuditoriaDetallesPeriodoAsistencia(connexion,periodoasistencia,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PeriodoAsistenciaDataAccess.TABLENAME, periodoasistencia.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(periodoasistencia.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PeriodoAsistenciaDataAccess.TABLENAME, periodoasistencia.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PeriodoAsistenciaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PeriodoAsistenciaLogic.registrarAuditoriaDetallesPeriodoAsistencia(connexion,periodoasistencia,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPeriodoAsistencia(Connexion connexion,PeriodoAsistencia periodoasistencia)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(periodoasistencia.getIsNew()||!periodoasistencia.getid_empresa().equals(periodoasistencia.getPeriodoAsistenciaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(periodoasistencia.getPeriodoAsistenciaOriginal().getid_empresa()!=null)
				{
					strValorActual=periodoasistencia.getPeriodoAsistenciaOriginal().getid_empresa().toString();
				}
				if(periodoasistencia.getid_empresa()!=null)
				{
					strValorNuevo=periodoasistencia.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PeriodoAsistenciaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(periodoasistencia.getIsNew()||!periodoasistencia.getid_ejercicio().equals(periodoasistencia.getPeriodoAsistenciaOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(periodoasistencia.getPeriodoAsistenciaOriginal().getid_ejercicio()!=null)
				{
					strValorActual=periodoasistencia.getPeriodoAsistenciaOriginal().getid_ejercicio().toString();
				}
				if(periodoasistencia.getid_ejercicio()!=null)
				{
					strValorNuevo=periodoasistencia.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PeriodoAsistenciaConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(periodoasistencia.getIsNew()||!periodoasistencia.getid_periodo().equals(periodoasistencia.getPeriodoAsistenciaOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(periodoasistencia.getPeriodoAsistenciaOriginal().getid_periodo()!=null)
				{
					strValorActual=periodoasistencia.getPeriodoAsistenciaOriginal().getid_periodo().toString();
				}
				if(periodoasistencia.getid_periodo()!=null)
				{
					strValorNuevo=periodoasistencia.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PeriodoAsistenciaConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(periodoasistencia.getIsNew()||!periodoasistencia.getfecha_inicio().equals(periodoasistencia.getPeriodoAsistenciaOriginal().getfecha_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(periodoasistencia.getPeriodoAsistenciaOriginal().getfecha_inicio()!=null)
				{
					strValorActual=periodoasistencia.getPeriodoAsistenciaOriginal().getfecha_inicio().toString();
				}
				if(periodoasistencia.getfecha_inicio()!=null)
				{
					strValorNuevo=periodoasistencia.getfecha_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PeriodoAsistenciaConstantesFunciones.FECHAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(periodoasistencia.getIsNew()||!periodoasistencia.getfecha_fin().equals(periodoasistencia.getPeriodoAsistenciaOriginal().getfecha_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(periodoasistencia.getPeriodoAsistenciaOriginal().getfecha_fin()!=null)
				{
					strValorActual=periodoasistencia.getPeriodoAsistenciaOriginal().getfecha_fin().toString();
				}
				if(periodoasistencia.getfecha_fin()!=null)
				{
					strValorNuevo=periodoasistencia.getfecha_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PeriodoAsistenciaConstantesFunciones.FECHAFIN,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePeriodoAsistenciaRelacionesWithConnection(PeriodoAsistencia periodoasistencia) throws Exception {

		if(!periodoasistencia.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePeriodoAsistenciaRelacionesBase(periodoasistencia,true);
		}
	}

	public void savePeriodoAsistenciaRelaciones(PeriodoAsistencia periodoasistencia)throws Exception {

		if(!periodoasistencia.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePeriodoAsistenciaRelacionesBase(periodoasistencia,false);
		}
	}

	public void savePeriodoAsistenciaRelacionesBase(PeriodoAsistencia periodoasistencia,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PeriodoAsistencia-saveRelacionesWithConnection");}
	

			this.setPeriodoAsistencia(periodoasistencia);

			if(PeriodoAsistenciaLogicAdditional.validarSaveRelaciones(periodoasistencia,this)) {

				PeriodoAsistenciaLogicAdditional.updateRelacionesToSave(periodoasistencia,this);

				if((periodoasistencia.getIsNew()||periodoasistencia.getIsChanged())&&!periodoasistencia.getIsDeleted()) {
					this.savePeriodoAsistencia();
					this.savePeriodoAsistenciaRelacionesDetalles();

				} else if(periodoasistencia.getIsDeleted()) {
					this.savePeriodoAsistenciaRelacionesDetalles();
					this.savePeriodoAsistencia();
				}

				PeriodoAsistenciaLogicAdditional.updateRelacionesToSaveAfter(periodoasistencia,this);

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
	
	
	private void savePeriodoAsistenciaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPeriodoAsistencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PeriodoAsistenciaConstantesFunciones.getClassesForeignKeysOfPeriodoAsistencia(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPeriodoAsistencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PeriodoAsistenciaConstantesFunciones.getClassesRelationshipsOfPeriodoAsistencia(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

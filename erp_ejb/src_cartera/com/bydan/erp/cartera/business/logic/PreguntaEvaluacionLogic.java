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
import com.bydan.erp.cartera.util.PreguntaEvaluacionConstantesFunciones;
import com.bydan.erp.cartera.util.PreguntaEvaluacionParameterReturnGeneral;
//import com.bydan.erp.cartera.util.PreguntaEvaluacionParameterGeneral;
import com.bydan.erp.cartera.business.entity.PreguntaEvaluacion;
import com.bydan.erp.cartera.business.logic.PreguntaEvaluacionLogicAdditional;
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
public class PreguntaEvaluacionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PreguntaEvaluacionLogic.class);
	
	protected PreguntaEvaluacionDataAccess preguntaevaluacionDataAccess; 	
	protected PreguntaEvaluacion preguntaevaluacion;
	protected List<PreguntaEvaluacion> preguntaevaluacions;
	protected Object preguntaevaluacionObject;	
	protected List<Object> preguntaevaluacionsObject;
	
	public static ClassValidator<PreguntaEvaluacion> preguntaevaluacionValidator = new ClassValidator<PreguntaEvaluacion>(PreguntaEvaluacion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PreguntaEvaluacionLogicAdditional preguntaevaluacionLogicAdditional=null;
	
	public PreguntaEvaluacionLogicAdditional getPreguntaEvaluacionLogicAdditional() {
		return this.preguntaevaluacionLogicAdditional;
	}
	
	public void setPreguntaEvaluacionLogicAdditional(PreguntaEvaluacionLogicAdditional preguntaevaluacionLogicAdditional) {
		try {
			this.preguntaevaluacionLogicAdditional=preguntaevaluacionLogicAdditional;
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
	
	
	
	
	public  PreguntaEvaluacionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.preguntaevaluacionDataAccess = new PreguntaEvaluacionDataAccess();
			
			this.preguntaevaluacions= new ArrayList<PreguntaEvaluacion>();
			this.preguntaevaluacion= new PreguntaEvaluacion();
			
			this.preguntaevaluacionObject=new Object();
			this.preguntaevaluacionsObject=new ArrayList<Object>();
				
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
			
			this.preguntaevaluacionDataAccess.setConnexionType(this.connexionType);
			this.preguntaevaluacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PreguntaEvaluacionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.preguntaevaluacionDataAccess = new PreguntaEvaluacionDataAccess();
			this.preguntaevaluacions= new ArrayList<PreguntaEvaluacion>();
			this.preguntaevaluacion= new PreguntaEvaluacion();
			this.preguntaevaluacionObject=new Object();
			this.preguntaevaluacionsObject=new ArrayList<Object>();
			
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
			
			this.preguntaevaluacionDataAccess.setConnexionType(this.connexionType);
			this.preguntaevaluacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PreguntaEvaluacion getPreguntaEvaluacion() throws Exception {	
		PreguntaEvaluacionLogicAdditional.checkPreguntaEvaluacionToGet(preguntaevaluacion,this.datosCliente,this.arrDatoGeneral);
		PreguntaEvaluacionLogicAdditional.updatePreguntaEvaluacionToGet(preguntaevaluacion,this.arrDatoGeneral);
		
		return preguntaevaluacion;
	}
		
	public void setPreguntaEvaluacion(PreguntaEvaluacion newPreguntaEvaluacion) {
		this.preguntaevaluacion = newPreguntaEvaluacion;
	}
	
	public PreguntaEvaluacionDataAccess getPreguntaEvaluacionDataAccess() {
		return preguntaevaluacionDataAccess;
	}
	
	public void setPreguntaEvaluacionDataAccess(PreguntaEvaluacionDataAccess newpreguntaevaluacionDataAccess) {
		this.preguntaevaluacionDataAccess = newpreguntaevaluacionDataAccess;
	}
	
	public List<PreguntaEvaluacion> getPreguntaEvaluacions() throws Exception {		
		this.quitarPreguntaEvaluacionsNulos();
		
		PreguntaEvaluacionLogicAdditional.checkPreguntaEvaluacionToGets(preguntaevaluacions,this.datosCliente,this.arrDatoGeneral);
		
		for (PreguntaEvaluacion preguntaevaluacionLocal: preguntaevaluacions ) {
			PreguntaEvaluacionLogicAdditional.updatePreguntaEvaluacionToGet(preguntaevaluacionLocal,this.arrDatoGeneral);
		}
		
		return preguntaevaluacions;
	}
	
	public void setPreguntaEvaluacions(List<PreguntaEvaluacion> newPreguntaEvaluacions) {
		this.preguntaevaluacions = newPreguntaEvaluacions;
	}
	
	public Object getPreguntaEvaluacionObject() {	
		this.preguntaevaluacionObject=this.preguntaevaluacionDataAccess.getEntityObject();
		return this.preguntaevaluacionObject;
	}
		
	public void setPreguntaEvaluacionObject(Object newPreguntaEvaluacionObject) {
		this.preguntaevaluacionObject = newPreguntaEvaluacionObject;
	}
	
	public List<Object> getPreguntaEvaluacionsObject() {		
		this.preguntaevaluacionsObject=this.preguntaevaluacionDataAccess.getEntitiesObject();
		return this.preguntaevaluacionsObject;
	}
		
	public void setPreguntaEvaluacionsObject(List<Object> newPreguntaEvaluacionsObject) {
		this.preguntaevaluacionsObject = newPreguntaEvaluacionsObject;
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
		
		if(this.preguntaevaluacionDataAccess!=null) {
			this.preguntaevaluacionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			preguntaevaluacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			preguntaevaluacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		preguntaevaluacion = new  PreguntaEvaluacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			preguntaevaluacion=preguntaevaluacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.preguntaevaluacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacion);
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
		preguntaevaluacion = new  PreguntaEvaluacion();
		  		  
        try {
			
			preguntaevaluacion=preguntaevaluacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.preguntaevaluacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		preguntaevaluacion = new  PreguntaEvaluacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			preguntaevaluacion=preguntaevaluacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.preguntaevaluacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacion);
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
		preguntaevaluacion = new  PreguntaEvaluacion();
		  		  
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
		preguntaevaluacion = new  PreguntaEvaluacion();
		  		  
        try {
			
			preguntaevaluacion=preguntaevaluacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.preguntaevaluacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		preguntaevaluacion = new  PreguntaEvaluacion();
		  		  
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
		preguntaevaluacion = new  PreguntaEvaluacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =preguntaevaluacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		preguntaevaluacion = new  PreguntaEvaluacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=preguntaevaluacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		preguntaevaluacion = new  PreguntaEvaluacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =preguntaevaluacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		preguntaevaluacion = new  PreguntaEvaluacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=preguntaevaluacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		preguntaevaluacion = new  PreguntaEvaluacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =preguntaevaluacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		preguntaevaluacion = new  PreguntaEvaluacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=preguntaevaluacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		preguntaevaluacions = new  ArrayList<PreguntaEvaluacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPreguntaEvaluacion(preguntaevaluacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
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
		preguntaevaluacions = new  ArrayList<PreguntaEvaluacion>();
		  		  
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
		preguntaevaluacions = new  ArrayList<PreguntaEvaluacion>();
		  		  
        try {			
			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPreguntaEvaluacion(preguntaevaluacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		preguntaevaluacions = new  ArrayList<PreguntaEvaluacion>();
		  		  
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
		preguntaevaluacions = new  ArrayList<PreguntaEvaluacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPreguntaEvaluacion(preguntaevaluacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
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
		preguntaevaluacions = new  ArrayList<PreguntaEvaluacion>();
		  		  
        try {
			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPreguntaEvaluacion(preguntaevaluacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
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
		preguntaevaluacions = new  ArrayList<PreguntaEvaluacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPreguntaEvaluacion(preguntaevaluacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
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
		preguntaevaluacions = new  ArrayList<PreguntaEvaluacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPreguntaEvaluacion(preguntaevaluacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		preguntaevaluacion = new  PreguntaEvaluacion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaevaluacion=preguntaevaluacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPreguntaEvaluacion(preguntaevaluacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacion);
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
		preguntaevaluacion = new  PreguntaEvaluacion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaevaluacion=preguntaevaluacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPreguntaEvaluacion(preguntaevaluacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		preguntaevaluacions = new  ArrayList<PreguntaEvaluacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaevaluacions=preguntaevaluacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPreguntaEvaluacion(preguntaevaluacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
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
		preguntaevaluacions = new  ArrayList<PreguntaEvaluacion>();
		  		  
        try {
			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaevaluacions=preguntaevaluacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPreguntaEvaluacion(preguntaevaluacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPreguntaEvaluacionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		preguntaevaluacions = new  ArrayList<PreguntaEvaluacion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-getTodosPreguntaEvaluacionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPreguntaEvaluacion(preguntaevaluacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
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
	
	public  void  getTodosPreguntaEvaluacions(String sFinalQuery,Pagination pagination)throws Exception {
		preguntaevaluacions = new  ArrayList<PreguntaEvaluacion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPreguntaEvaluacion(preguntaevaluacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPreguntaEvaluacion(PreguntaEvaluacion preguntaevaluacion) throws Exception {
		Boolean estaValidado=false;
		
		if(preguntaevaluacion.getIsNew() || preguntaevaluacion.getIsChanged()) { 
			this.invalidValues = preguntaevaluacionValidator.getInvalidValues(preguntaevaluacion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(preguntaevaluacion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPreguntaEvaluacion(List<PreguntaEvaluacion> PreguntaEvaluacions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PreguntaEvaluacion preguntaevaluacionLocal:preguntaevaluacions) {				
			estaValidadoObjeto=this.validarGuardarPreguntaEvaluacion(preguntaevaluacionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPreguntaEvaluacion(List<PreguntaEvaluacion> PreguntaEvaluacions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPreguntaEvaluacion(preguntaevaluacions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPreguntaEvaluacion(PreguntaEvaluacion PreguntaEvaluacion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPreguntaEvaluacion(preguntaevaluacion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PreguntaEvaluacion preguntaevaluacion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+preguntaevaluacion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PreguntaEvaluacionConstantesFunciones.getPreguntaEvaluacionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"preguntaevaluacion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PreguntaEvaluacionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PreguntaEvaluacionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePreguntaEvaluacionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-savePreguntaEvaluacionWithConnection");connexion.begin();			
			
			PreguntaEvaluacionLogicAdditional.checkPreguntaEvaluacionToSave(this.preguntaevaluacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PreguntaEvaluacionLogicAdditional.updatePreguntaEvaluacionToSave(this.preguntaevaluacion,this.arrDatoGeneral);
			
			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.preguntaevaluacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPreguntaEvaluacion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPreguntaEvaluacion(this.preguntaevaluacion)) {
				PreguntaEvaluacionDataAccess.save(this.preguntaevaluacion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.preguntaevaluacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PreguntaEvaluacionLogicAdditional.checkPreguntaEvaluacionToSaveAfter(this.preguntaevaluacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPreguntaEvaluacion();
			
			connexion.commit();			
			
			if(this.preguntaevaluacion.getIsDeleted()) {
				this.preguntaevaluacion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePreguntaEvaluacion()throws Exception {	
		try {	
			
			PreguntaEvaluacionLogicAdditional.checkPreguntaEvaluacionToSave(this.preguntaevaluacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PreguntaEvaluacionLogicAdditional.updatePreguntaEvaluacionToSave(this.preguntaevaluacion,this.arrDatoGeneral);
			
			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.preguntaevaluacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPreguntaEvaluacion(this.preguntaevaluacion)) {			
				PreguntaEvaluacionDataAccess.save(this.preguntaevaluacion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.preguntaevaluacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PreguntaEvaluacionLogicAdditional.checkPreguntaEvaluacionToSaveAfter(this.preguntaevaluacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.preguntaevaluacion.getIsDeleted()) {
				this.preguntaevaluacion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePreguntaEvaluacionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-savePreguntaEvaluacionsWithConnection");connexion.begin();			
			
			PreguntaEvaluacionLogicAdditional.checkPreguntaEvaluacionToSaves(preguntaevaluacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPreguntaEvaluacions();
			
			Boolean validadoTodosPreguntaEvaluacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PreguntaEvaluacion preguntaevaluacionLocal:preguntaevaluacions) {		
				if(preguntaevaluacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PreguntaEvaluacionLogicAdditional.updatePreguntaEvaluacionToSave(preguntaevaluacionLocal,this.arrDatoGeneral);
	        	
				PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),preguntaevaluacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPreguntaEvaluacion(preguntaevaluacionLocal)) {
					PreguntaEvaluacionDataAccess.save(preguntaevaluacionLocal, connexion);				
				} else {
					validadoTodosPreguntaEvaluacion=false;
				}
			}
			
			if(!validadoTodosPreguntaEvaluacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PreguntaEvaluacionLogicAdditional.checkPreguntaEvaluacionToSavesAfter(preguntaevaluacions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPreguntaEvaluacions();
			
			connexion.commit();		
			
			this.quitarPreguntaEvaluacionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePreguntaEvaluacions()throws Exception {				
		 try {	
			PreguntaEvaluacionLogicAdditional.checkPreguntaEvaluacionToSaves(preguntaevaluacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPreguntaEvaluacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PreguntaEvaluacion preguntaevaluacionLocal:preguntaevaluacions) {				
				if(preguntaevaluacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PreguntaEvaluacionLogicAdditional.updatePreguntaEvaluacionToSave(preguntaevaluacionLocal,this.arrDatoGeneral);
	        	
				PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),preguntaevaluacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPreguntaEvaluacion(preguntaevaluacionLocal)) {				
					PreguntaEvaluacionDataAccess.save(preguntaevaluacionLocal, connexion);				
				} else {
					validadoTodosPreguntaEvaluacion=false;
				}
			}
			
			if(!validadoTodosPreguntaEvaluacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PreguntaEvaluacionLogicAdditional.checkPreguntaEvaluacionToSavesAfter(preguntaevaluacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPreguntaEvaluacionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PreguntaEvaluacionParameterReturnGeneral procesarAccionPreguntaEvaluacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PreguntaEvaluacion> preguntaevaluacions,PreguntaEvaluacionParameterReturnGeneral preguntaevaluacionParameterGeneral)throws Exception {
		 try {	
			PreguntaEvaluacionParameterReturnGeneral preguntaevaluacionReturnGeneral=new PreguntaEvaluacionParameterReturnGeneral();
	
			PreguntaEvaluacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,preguntaevaluacions,preguntaevaluacionParameterGeneral,preguntaevaluacionReturnGeneral);
			
			return preguntaevaluacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PreguntaEvaluacionParameterReturnGeneral procesarAccionPreguntaEvaluacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PreguntaEvaluacion> preguntaevaluacions,PreguntaEvaluacionParameterReturnGeneral preguntaevaluacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-procesarAccionPreguntaEvaluacionsWithConnection");connexion.begin();			
			
			PreguntaEvaluacionParameterReturnGeneral preguntaevaluacionReturnGeneral=new PreguntaEvaluacionParameterReturnGeneral();
	
			PreguntaEvaluacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,preguntaevaluacions,preguntaevaluacionParameterGeneral,preguntaevaluacionReturnGeneral);
			
			this.connexion.commit();
			
			return preguntaevaluacionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PreguntaEvaluacionParameterReturnGeneral procesarEventosPreguntaEvaluacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PreguntaEvaluacion> preguntaevaluacions,PreguntaEvaluacion preguntaevaluacion,PreguntaEvaluacionParameterReturnGeneral preguntaevaluacionParameterGeneral,Boolean isEsNuevoPreguntaEvaluacion,ArrayList<Classe> clases)throws Exception {
		 try {	
			PreguntaEvaluacionParameterReturnGeneral preguntaevaluacionReturnGeneral=new PreguntaEvaluacionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				preguntaevaluacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PreguntaEvaluacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,preguntaevaluacions,preguntaevaluacion,preguntaevaluacionParameterGeneral,preguntaevaluacionReturnGeneral,isEsNuevoPreguntaEvaluacion,clases);
			
			return preguntaevaluacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PreguntaEvaluacionParameterReturnGeneral procesarEventosPreguntaEvaluacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PreguntaEvaluacion> preguntaevaluacions,PreguntaEvaluacion preguntaevaluacion,PreguntaEvaluacionParameterReturnGeneral preguntaevaluacionParameterGeneral,Boolean isEsNuevoPreguntaEvaluacion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-procesarEventosPreguntaEvaluacionsWithConnection");connexion.begin();			
			
			PreguntaEvaluacionParameterReturnGeneral preguntaevaluacionReturnGeneral=new PreguntaEvaluacionParameterReturnGeneral();
	
			preguntaevaluacionReturnGeneral.setPreguntaEvaluacion(preguntaevaluacion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				preguntaevaluacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PreguntaEvaluacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,preguntaevaluacions,preguntaevaluacion,preguntaevaluacionParameterGeneral,preguntaevaluacionReturnGeneral,isEsNuevoPreguntaEvaluacion,clases);
			
			this.connexion.commit();
			
			return preguntaevaluacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PreguntaEvaluacionParameterReturnGeneral procesarImportacionPreguntaEvaluacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PreguntaEvaluacionParameterReturnGeneral preguntaevaluacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-procesarImportacionPreguntaEvaluacionsWithConnection");connexion.begin();			
			
			PreguntaEvaluacionParameterReturnGeneral preguntaevaluacionReturnGeneral=new PreguntaEvaluacionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.preguntaevaluacions=new ArrayList<PreguntaEvaluacion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.preguntaevaluacion=new PreguntaEvaluacion();
				
				
				if(conColumnasBase) {this.preguntaevaluacion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.preguntaevaluacion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.preguntaevaluacion.setpregunta(arrColumnas[iColumn++]);
				this.preguntaevaluacion.setcalificacion(Double.parseDouble(arrColumnas[iColumn++]));
				this.preguntaevaluacion.setorden(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.preguntaevaluacions.add(this.preguntaevaluacion);
			}
			
			this.savePreguntaEvaluacions();
			
			this.connexion.commit();
			
			preguntaevaluacionReturnGeneral.setConRetornoEstaProcesado(true);
			preguntaevaluacionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return preguntaevaluacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPreguntaEvaluacionsEliminados() throws Exception {				
		
		List<PreguntaEvaluacion> preguntaevaluacionsAux= new ArrayList<PreguntaEvaluacion>();
		
		for(PreguntaEvaluacion preguntaevaluacion:preguntaevaluacions) {
			if(!preguntaevaluacion.getIsDeleted()) {
				preguntaevaluacionsAux.add(preguntaevaluacion);
			}
		}
		
		preguntaevaluacions=preguntaevaluacionsAux;
	}
	
	public void quitarPreguntaEvaluacionsNulos() throws Exception {				
		
		List<PreguntaEvaluacion> preguntaevaluacionsAux= new ArrayList<PreguntaEvaluacion>();
		
		for(PreguntaEvaluacion preguntaevaluacion : this.preguntaevaluacions) {
			if(preguntaevaluacion==null) {
				preguntaevaluacionsAux.add(preguntaevaluacion);
			}
		}
		
		//this.preguntaevaluacions=preguntaevaluacionsAux;
		
		this.preguntaevaluacions.removeAll(preguntaevaluacionsAux);
	}
	
	public void getSetVersionRowPreguntaEvaluacionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(preguntaevaluacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((preguntaevaluacion.getIsDeleted() || (preguntaevaluacion.getIsChanged()&&!preguntaevaluacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=preguntaevaluacionDataAccess.getSetVersionRowPreguntaEvaluacion(connexion,preguntaevaluacion.getId());
				
				if(!preguntaevaluacion.getVersionRow().equals(timestamp)) {	
					preguntaevaluacion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				preguntaevaluacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPreguntaEvaluacion()throws Exception {	
		
		if(preguntaevaluacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((preguntaevaluacion.getIsDeleted() || (preguntaevaluacion.getIsChanged()&&!preguntaevaluacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=preguntaevaluacionDataAccess.getSetVersionRowPreguntaEvaluacion(connexion,preguntaevaluacion.getId());
			
			try {							
				if(!preguntaevaluacion.getVersionRow().equals(timestamp)) {	
					preguntaevaluacion.setVersionRow(timestamp);
				}
				
				preguntaevaluacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPreguntaEvaluacionsWithConnection()throws Exception {	
		if(preguntaevaluacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PreguntaEvaluacion preguntaevaluacionAux:preguntaevaluacions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(preguntaevaluacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(preguntaevaluacionAux.getIsDeleted() || (preguntaevaluacionAux.getIsChanged()&&!preguntaevaluacionAux.getIsNew())) {
						
						timestamp=preguntaevaluacionDataAccess.getSetVersionRowPreguntaEvaluacion(connexion,preguntaevaluacionAux.getId());
						
						if(!preguntaevaluacion.getVersionRow().equals(timestamp)) {	
							preguntaevaluacionAux.setVersionRow(timestamp);
						}
								
						preguntaevaluacionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPreguntaEvaluacions()throws Exception {	
		if(preguntaevaluacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PreguntaEvaluacion preguntaevaluacionAux:preguntaevaluacions) {
					if(preguntaevaluacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(preguntaevaluacionAux.getIsDeleted() || (preguntaevaluacionAux.getIsChanged()&&!preguntaevaluacionAux.getIsNew())) {
						
						timestamp=preguntaevaluacionDataAccess.getSetVersionRowPreguntaEvaluacion(connexion,preguntaevaluacionAux.getId());
						
						if(!preguntaevaluacionAux.getVersionRow().equals(timestamp)) {	
							preguntaevaluacionAux.setVersionRow(timestamp);
						}
						
													
						preguntaevaluacionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PreguntaEvaluacionParameterReturnGeneral cargarCombosLoteForeignKeyPreguntaEvaluacionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		PreguntaEvaluacionParameterReturnGeneral  preguntaevaluacionReturnGeneral =new PreguntaEvaluacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-cargarCombosLoteForeignKeyPreguntaEvaluacionWithConnection");connexion.begin();
			
			preguntaevaluacionReturnGeneral =new PreguntaEvaluacionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			preguntaevaluacionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			preguntaevaluacionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			preguntaevaluacionReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			preguntaevaluacionReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			preguntaevaluacionReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			preguntaevaluacionReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return preguntaevaluacionReturnGeneral;
	}
	
	public PreguntaEvaluacionParameterReturnGeneral cargarCombosLoteForeignKeyPreguntaEvaluacion(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		PreguntaEvaluacionParameterReturnGeneral  preguntaevaluacionReturnGeneral =new PreguntaEvaluacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			preguntaevaluacionReturnGeneral =new PreguntaEvaluacionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			preguntaevaluacionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			preguntaevaluacionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			preguntaevaluacionReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			preguntaevaluacionReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			preguntaevaluacionReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			preguntaevaluacionReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return preguntaevaluacionReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyPreguntaEvaluacionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic=new DetalleEvaluacionProveedorLogic();
			SubPreguntaEvaluacionLogic subpreguntaevaluacionLogic=new SubPreguntaEvaluacionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyPreguntaEvaluacionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleEvaluacionProveedor.class));
			classes.add(new Classe(SubPreguntaEvaluacion.class));
											
			

			detalleevaluacionproveedorLogic.setConnexion(this.getConnexion());
			detalleevaluacionproveedorLogic.setDatosCliente(this.datosCliente);
			detalleevaluacionproveedorLogic.setIsConRefrescarForeignKeys(true);

			subpreguntaevaluacionLogic.setConnexion(this.getConnexion());
			subpreguntaevaluacionLogic.setDatosCliente(this.datosCliente);
			subpreguntaevaluacionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(PreguntaEvaluacion preguntaevaluacion:this.preguntaevaluacions) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleEvaluacionProveedorConstantesFunciones.getClassesForeignKeysOfDetalleEvaluacionProveedor(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleevaluacionproveedorLogic.setDetalleEvaluacionProveedors(preguntaevaluacion.detalleevaluacionproveedors);
				detalleevaluacionproveedorLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=SubPreguntaEvaluacionConstantesFunciones.getClassesForeignKeysOfSubPreguntaEvaluacion(new ArrayList<Classe>(),DeepLoadType.NONE);

				subpreguntaevaluacionLogic.setSubPreguntaEvaluacions(preguntaevaluacion.subpreguntaevaluacions);
				subpreguntaevaluacionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(PreguntaEvaluacion preguntaevaluacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PreguntaEvaluacionLogicAdditional.updatePreguntaEvaluacionToGet(preguntaevaluacion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		preguntaevaluacion.setEmpresa(preguntaevaluacionDataAccess.getEmpresa(connexion,preguntaevaluacion));
		preguntaevaluacion.setSucursal(preguntaevaluacionDataAccess.getSucursal(connexion,preguntaevaluacion));
		preguntaevaluacion.setEjercicio(preguntaevaluacionDataAccess.getEjercicio(connexion,preguntaevaluacion));
		preguntaevaluacion.setPeriodo(preguntaevaluacionDataAccess.getPeriodo(connexion,preguntaevaluacion));
		preguntaevaluacion.setAnio(preguntaevaluacionDataAccess.getAnio(connexion,preguntaevaluacion));
		preguntaevaluacion.setMes(preguntaevaluacionDataAccess.getMes(connexion,preguntaevaluacion));
		preguntaevaluacion.setDetalleEvaluacionProveedors(preguntaevaluacionDataAccess.getDetalleEvaluacionProveedors(connexion,preguntaevaluacion));
		preguntaevaluacion.setSubPreguntaEvaluacions(preguntaevaluacionDataAccess.getSubPreguntaEvaluacions(connexion,preguntaevaluacion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				preguntaevaluacion.setEmpresa(preguntaevaluacionDataAccess.getEmpresa(connexion,preguntaevaluacion));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				preguntaevaluacion.setSucursal(preguntaevaluacionDataAccess.getSucursal(connexion,preguntaevaluacion));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				preguntaevaluacion.setEjercicio(preguntaevaluacionDataAccess.getEjercicio(connexion,preguntaevaluacion));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				preguntaevaluacion.setPeriodo(preguntaevaluacionDataAccess.getPeriodo(connexion,preguntaevaluacion));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				preguntaevaluacion.setAnio(preguntaevaluacionDataAccess.getAnio(connexion,preguntaevaluacion));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				preguntaevaluacion.setMes(preguntaevaluacionDataAccess.getMes(connexion,preguntaevaluacion));
				continue;
			}

			if(clas.clas.equals(DetalleEvaluacionProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				preguntaevaluacion.setDetalleEvaluacionProveedors(preguntaevaluacionDataAccess.getDetalleEvaluacionProveedors(connexion,preguntaevaluacion));

				if(this.isConDeep) {
					DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic= new DetalleEvaluacionProveedorLogic(this.connexion);
					detalleevaluacionproveedorLogic.setDetalleEvaluacionProveedors(preguntaevaluacion.getDetalleEvaluacionProveedors());
					ArrayList<Classe> classesLocal=DetalleEvaluacionProveedorConstantesFunciones.getClassesForeignKeysOfDetalleEvaluacionProveedor(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleevaluacionproveedorLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(detalleevaluacionproveedorLogic.getDetalleEvaluacionProveedors());
					preguntaevaluacion.setDetalleEvaluacionProveedors(detalleevaluacionproveedorLogic.getDetalleEvaluacionProveedors());
				}

				continue;
			}

			if(clas.clas.equals(SubPreguntaEvaluacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				preguntaevaluacion.setSubPreguntaEvaluacions(preguntaevaluacionDataAccess.getSubPreguntaEvaluacions(connexion,preguntaevaluacion));

				if(this.isConDeep) {
					SubPreguntaEvaluacionLogic subpreguntaevaluacionLogic= new SubPreguntaEvaluacionLogic(this.connexion);
					subpreguntaevaluacionLogic.setSubPreguntaEvaluacions(preguntaevaluacion.getSubPreguntaEvaluacions());
					ArrayList<Classe> classesLocal=SubPreguntaEvaluacionConstantesFunciones.getClassesForeignKeysOfSubPreguntaEvaluacion(new ArrayList<Classe>(),DeepLoadType.NONE);
					subpreguntaevaluacionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(subpreguntaevaluacionLogic.getSubPreguntaEvaluacions());
					preguntaevaluacion.setSubPreguntaEvaluacions(subpreguntaevaluacionLogic.getSubPreguntaEvaluacions());
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
			preguntaevaluacion.setEmpresa(preguntaevaluacionDataAccess.getEmpresa(connexion,preguntaevaluacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			preguntaevaluacion.setSucursal(preguntaevaluacionDataAccess.getSucursal(connexion,preguntaevaluacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			preguntaevaluacion.setEjercicio(preguntaevaluacionDataAccess.getEjercicio(connexion,preguntaevaluacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			preguntaevaluacion.setPeriodo(preguntaevaluacionDataAccess.getPeriodo(connexion,preguntaevaluacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			preguntaevaluacion.setAnio(preguntaevaluacionDataAccess.getAnio(connexion,preguntaevaluacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			preguntaevaluacion.setMes(preguntaevaluacionDataAccess.getMes(connexion,preguntaevaluacion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleEvaluacionProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleEvaluacionProveedor.class));
			preguntaevaluacion.setDetalleEvaluacionProveedors(preguntaevaluacionDataAccess.getDetalleEvaluacionProveedors(connexion,preguntaevaluacion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubPreguntaEvaluacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SubPreguntaEvaluacion.class));
			preguntaevaluacion.setSubPreguntaEvaluacions(preguntaevaluacionDataAccess.getSubPreguntaEvaluacions(connexion,preguntaevaluacion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		preguntaevaluacion.setEmpresa(preguntaevaluacionDataAccess.getEmpresa(connexion,preguntaevaluacion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(preguntaevaluacion.getEmpresa(),isDeep,deepLoadType,clases);
				
		preguntaevaluacion.setSucursal(preguntaevaluacionDataAccess.getSucursal(connexion,preguntaevaluacion));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(preguntaevaluacion.getSucursal(),isDeep,deepLoadType,clases);
				
		preguntaevaluacion.setEjercicio(preguntaevaluacionDataAccess.getEjercicio(connexion,preguntaevaluacion));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(preguntaevaluacion.getEjercicio(),isDeep,deepLoadType,clases);
				
		preguntaevaluacion.setPeriodo(preguntaevaluacionDataAccess.getPeriodo(connexion,preguntaevaluacion));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(preguntaevaluacion.getPeriodo(),isDeep,deepLoadType,clases);
				
		preguntaevaluacion.setAnio(preguntaevaluacionDataAccess.getAnio(connexion,preguntaevaluacion));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(preguntaevaluacion.getAnio(),isDeep,deepLoadType,clases);
				
		preguntaevaluacion.setMes(preguntaevaluacionDataAccess.getMes(connexion,preguntaevaluacion));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(preguntaevaluacion.getMes(),isDeep,deepLoadType,clases);
				

		preguntaevaluacion.setDetalleEvaluacionProveedors(preguntaevaluacionDataAccess.getDetalleEvaluacionProveedors(connexion,preguntaevaluacion));

		for(DetalleEvaluacionProveedor detalleevaluacionproveedor:preguntaevaluacion.getDetalleEvaluacionProveedors()) {
			DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic= new DetalleEvaluacionProveedorLogic(connexion);
			detalleevaluacionproveedorLogic.deepLoad(detalleevaluacionproveedor,isDeep,deepLoadType,clases);
		}

		preguntaevaluacion.setSubPreguntaEvaluacions(preguntaevaluacionDataAccess.getSubPreguntaEvaluacions(connexion,preguntaevaluacion));

		for(SubPreguntaEvaluacion subpreguntaevaluacion:preguntaevaluacion.getSubPreguntaEvaluacions()) {
			SubPreguntaEvaluacionLogic subpreguntaevaluacionLogic= new SubPreguntaEvaluacionLogic(connexion);
			subpreguntaevaluacionLogic.deepLoad(subpreguntaevaluacion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				preguntaevaluacion.setEmpresa(preguntaevaluacionDataAccess.getEmpresa(connexion,preguntaevaluacion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(preguntaevaluacion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				preguntaevaluacion.setSucursal(preguntaevaluacionDataAccess.getSucursal(connexion,preguntaevaluacion));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(preguntaevaluacion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				preguntaevaluacion.setEjercicio(preguntaevaluacionDataAccess.getEjercicio(connexion,preguntaevaluacion));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(preguntaevaluacion.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				preguntaevaluacion.setPeriodo(preguntaevaluacionDataAccess.getPeriodo(connexion,preguntaevaluacion));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(preguntaevaluacion.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				preguntaevaluacion.setAnio(preguntaevaluacionDataAccess.getAnio(connexion,preguntaevaluacion));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(preguntaevaluacion.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				preguntaevaluacion.setMes(preguntaevaluacionDataAccess.getMes(connexion,preguntaevaluacion));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(preguntaevaluacion.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleEvaluacionProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				preguntaevaluacion.setDetalleEvaluacionProveedors(preguntaevaluacionDataAccess.getDetalleEvaluacionProveedors(connexion,preguntaevaluacion));

				for(DetalleEvaluacionProveedor detalleevaluacionproveedor:preguntaevaluacion.getDetalleEvaluacionProveedors()) {
					DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic= new DetalleEvaluacionProveedorLogic(connexion);
					detalleevaluacionproveedorLogic.deepLoad(detalleevaluacionproveedor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SubPreguntaEvaluacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				preguntaevaluacion.setSubPreguntaEvaluacions(preguntaevaluacionDataAccess.getSubPreguntaEvaluacions(connexion,preguntaevaluacion));

				for(SubPreguntaEvaluacion subpreguntaevaluacion:preguntaevaluacion.getSubPreguntaEvaluacions()) {
					SubPreguntaEvaluacionLogic subpreguntaevaluacionLogic= new SubPreguntaEvaluacionLogic(connexion);
					subpreguntaevaluacionLogic.deepLoad(subpreguntaevaluacion,isDeep,deepLoadType,clases);
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
			preguntaevaluacion.setEmpresa(preguntaevaluacionDataAccess.getEmpresa(connexion,preguntaevaluacion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(preguntaevaluacion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			preguntaevaluacion.setSucursal(preguntaevaluacionDataAccess.getSucursal(connexion,preguntaevaluacion));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(preguntaevaluacion.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			preguntaevaluacion.setEjercicio(preguntaevaluacionDataAccess.getEjercicio(connexion,preguntaevaluacion));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(preguntaevaluacion.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			preguntaevaluacion.setPeriodo(preguntaevaluacionDataAccess.getPeriodo(connexion,preguntaevaluacion));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(preguntaevaluacion.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			preguntaevaluacion.setAnio(preguntaevaluacionDataAccess.getAnio(connexion,preguntaevaluacion));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(preguntaevaluacion.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			preguntaevaluacion.setMes(preguntaevaluacionDataAccess.getMes(connexion,preguntaevaluacion));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(preguntaevaluacion.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleEvaluacionProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleEvaluacionProveedor.class));
			preguntaevaluacion.setDetalleEvaluacionProveedors(preguntaevaluacionDataAccess.getDetalleEvaluacionProveedors(connexion,preguntaevaluacion));

			for(DetalleEvaluacionProveedor detalleevaluacionproveedor:preguntaevaluacion.getDetalleEvaluacionProveedors()) {
				DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic= new DetalleEvaluacionProveedorLogic(connexion);
				detalleevaluacionproveedorLogic.deepLoad(detalleevaluacionproveedor,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubPreguntaEvaluacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SubPreguntaEvaluacion.class));
			preguntaevaluacion.setSubPreguntaEvaluacions(preguntaevaluacionDataAccess.getSubPreguntaEvaluacions(connexion,preguntaevaluacion));

			for(SubPreguntaEvaluacion subpreguntaevaluacion:preguntaevaluacion.getSubPreguntaEvaluacions()) {
				SubPreguntaEvaluacionLogic subpreguntaevaluacionLogic= new SubPreguntaEvaluacionLogic(connexion);
				subpreguntaevaluacionLogic.deepLoad(subpreguntaevaluacion,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PreguntaEvaluacion preguntaevaluacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PreguntaEvaluacionLogicAdditional.updatePreguntaEvaluacionToSave(preguntaevaluacion,this.arrDatoGeneral);
			
PreguntaEvaluacionDataAccess.save(preguntaevaluacion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(preguntaevaluacion.getEmpresa(),connexion);

		SucursalDataAccess.save(preguntaevaluacion.getSucursal(),connexion);

		EjercicioDataAccess.save(preguntaevaluacion.getEjercicio(),connexion);

		PeriodoDataAccess.save(preguntaevaluacion.getPeriodo(),connexion);

		AnioDataAccess.save(preguntaevaluacion.getAnio(),connexion);

		MesDataAccess.save(preguntaevaluacion.getMes(),connexion);

		for(DetalleEvaluacionProveedor detalleevaluacionproveedor:preguntaevaluacion.getDetalleEvaluacionProveedors()) {
			detalleevaluacionproveedor.setid_pregunta_evaluacion(preguntaevaluacion.getId());
			DetalleEvaluacionProveedorDataAccess.save(detalleevaluacionproveedor,connexion);
		}

		for(SubPreguntaEvaluacion subpreguntaevaluacion:preguntaevaluacion.getSubPreguntaEvaluacions()) {
			subpreguntaevaluacion.setid_pregunta_evaluacion(preguntaevaluacion.getId());
			SubPreguntaEvaluacionDataAccess.save(subpreguntaevaluacion,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(preguntaevaluacion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(preguntaevaluacion.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(preguntaevaluacion.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(preguntaevaluacion.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(preguntaevaluacion.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(preguntaevaluacion.getMes(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleEvaluacionProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleEvaluacionProveedor detalleevaluacionproveedor:preguntaevaluacion.getDetalleEvaluacionProveedors()) {
					detalleevaluacionproveedor.setid_pregunta_evaluacion(preguntaevaluacion.getId());
					DetalleEvaluacionProveedorDataAccess.save(detalleevaluacionproveedor,connexion);
				}
				continue;
			}

			if(clas.clas.equals(SubPreguntaEvaluacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SubPreguntaEvaluacion subpreguntaevaluacion:preguntaevaluacion.getSubPreguntaEvaluacions()) {
					subpreguntaevaluacion.setid_pregunta_evaluacion(preguntaevaluacion.getId());
					SubPreguntaEvaluacionDataAccess.save(subpreguntaevaluacion,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(preguntaevaluacion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(preguntaevaluacion.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(preguntaevaluacion.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(preguntaevaluacion.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(preguntaevaluacion.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(preguntaevaluacion.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(preguntaevaluacion.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(preguntaevaluacion.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(preguntaevaluacion.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(preguntaevaluacion.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(preguntaevaluacion.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(preguntaevaluacion.getMes(),isDeep,deepLoadType,clases);
				

		for(DetalleEvaluacionProveedor detalleevaluacionproveedor:preguntaevaluacion.getDetalleEvaluacionProveedors()) {
			DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic= new DetalleEvaluacionProveedorLogic(connexion);
			detalleevaluacionproveedor.setid_pregunta_evaluacion(preguntaevaluacion.getId());
			DetalleEvaluacionProveedorDataAccess.save(detalleevaluacionproveedor,connexion);
			detalleevaluacionproveedorLogic.deepSave(detalleevaluacionproveedor,isDeep,deepLoadType,clases);
		}

		for(SubPreguntaEvaluacion subpreguntaevaluacion:preguntaevaluacion.getSubPreguntaEvaluacions()) {
			SubPreguntaEvaluacionLogic subpreguntaevaluacionLogic= new SubPreguntaEvaluacionLogic(connexion);
			subpreguntaevaluacion.setid_pregunta_evaluacion(preguntaevaluacion.getId());
			SubPreguntaEvaluacionDataAccess.save(subpreguntaevaluacion,connexion);
			subpreguntaevaluacionLogic.deepSave(subpreguntaevaluacion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(preguntaevaluacion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(preguntaevaluacion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(preguntaevaluacion.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(preguntaevaluacion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(preguntaevaluacion.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(preguntaevaluacion.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(preguntaevaluacion.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(preguntaevaluacion.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(preguntaevaluacion.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(preguntaevaluacion.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(preguntaevaluacion.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(preguntaevaluacion.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleEvaluacionProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleEvaluacionProveedor detalleevaluacionproveedor:preguntaevaluacion.getDetalleEvaluacionProveedors()) {
					DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic= new DetalleEvaluacionProveedorLogic(connexion);
					detalleevaluacionproveedor.setid_pregunta_evaluacion(preguntaevaluacion.getId());
					DetalleEvaluacionProveedorDataAccess.save(detalleevaluacionproveedor,connexion);
					detalleevaluacionproveedorLogic.deepSave(detalleevaluacionproveedor,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SubPreguntaEvaluacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SubPreguntaEvaluacion subpreguntaevaluacion:preguntaevaluacion.getSubPreguntaEvaluacions()) {
					SubPreguntaEvaluacionLogic subpreguntaevaluacionLogic= new SubPreguntaEvaluacionLogic(connexion);
					subpreguntaevaluacion.setid_pregunta_evaluacion(preguntaevaluacion.getId());
					SubPreguntaEvaluacionDataAccess.save(subpreguntaevaluacion,connexion);
					subpreguntaevaluacionLogic.deepSave(subpreguntaevaluacion,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(PreguntaEvaluacion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(preguntaevaluacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(preguntaevaluacion);
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
			this.deepLoad(this.preguntaevaluacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PreguntaEvaluacion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(preguntaevaluacions!=null) {
				for(PreguntaEvaluacion preguntaevaluacion:preguntaevaluacions) {
					this.deepLoad(preguntaevaluacion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(preguntaevaluacions);
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
			if(preguntaevaluacions!=null) {
				for(PreguntaEvaluacion preguntaevaluacion:preguntaevaluacions) {
					this.deepLoad(preguntaevaluacion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(preguntaevaluacions);
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
			this.getNewConnexionToDeep(PreguntaEvaluacion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(preguntaevaluacion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PreguntaEvaluacion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(preguntaevaluacions!=null) {
				for(PreguntaEvaluacion preguntaevaluacion:preguntaevaluacions) {
					this.deepSave(preguntaevaluacion,isDeep,deepLoadType,clases);
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
			if(preguntaevaluacions!=null) {
				for(PreguntaEvaluacion preguntaevaluacion:preguntaevaluacions) {
					this.deepSave(preguntaevaluacion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPreguntaEvaluacionsBusquedaPorIdEjercicioPorIdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PreguntaEvaluacionConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PreguntaEvaluacionConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdEjercicioPorIdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreguntaEvaluacionsBusquedaPorIdEjercicioPorIdPeriodo(String sFinalQuery,Pagination pagination,Long id_ejercicio,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PreguntaEvaluacionConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PreguntaEvaluacionConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdEjercicioPorIdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreguntaEvaluacionsBusquedaPorPreguntaWithConnection(String sFinalQuery,Pagination pagination,String pregunta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralPregunta= new ParameterSelectionGeneral();
			parameterSelectionGeneralPregunta.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+pregunta+"%",PreguntaEvaluacionConstantesFunciones.PREGUNTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralPregunta);

			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorPregunta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreguntaEvaluacionsBusquedaPorPregunta(String sFinalQuery,Pagination pagination,String pregunta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralPregunta= new ParameterSelectionGeneral();
			parameterSelectionGeneralPregunta.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+pregunta+"%",PreguntaEvaluacionConstantesFunciones.PREGUNTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralPregunta);

			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorPregunta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreguntaEvaluacionsFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,PreguntaEvaluacionConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreguntaEvaluacionsFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,PreguntaEvaluacionConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreguntaEvaluacionsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PreguntaEvaluacionConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreguntaEvaluacionsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PreguntaEvaluacionConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreguntaEvaluacionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PreguntaEvaluacionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreguntaEvaluacionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PreguntaEvaluacionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreguntaEvaluacionsFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PreguntaEvaluacionConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreguntaEvaluacionsFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PreguntaEvaluacionConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreguntaEvaluacionsFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PreguntaEvaluacionConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreguntaEvaluacionsFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PreguntaEvaluacionConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreguntaEvaluacionsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEvaluacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PreguntaEvaluacionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreguntaEvaluacionsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PreguntaEvaluacionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaevaluacions=preguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEvaluacion(this.preguntaevaluacions);
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
			if(PreguntaEvaluacionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PreguntaEvaluacionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PreguntaEvaluacion preguntaevaluacion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PreguntaEvaluacionConstantesFunciones.ISCONAUDITORIA) {
				if(preguntaevaluacion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PreguntaEvaluacionDataAccess.TABLENAME, preguntaevaluacion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PreguntaEvaluacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PreguntaEvaluacionLogic.registrarAuditoriaDetallesPreguntaEvaluacion(connexion,preguntaevaluacion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(preguntaevaluacion.getIsDeleted()) {
					/*if(!preguntaevaluacion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PreguntaEvaluacionDataAccess.TABLENAME, preguntaevaluacion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PreguntaEvaluacionLogic.registrarAuditoriaDetallesPreguntaEvaluacion(connexion,preguntaevaluacion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PreguntaEvaluacionDataAccess.TABLENAME, preguntaevaluacion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(preguntaevaluacion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PreguntaEvaluacionDataAccess.TABLENAME, preguntaevaluacion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PreguntaEvaluacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PreguntaEvaluacionLogic.registrarAuditoriaDetallesPreguntaEvaluacion(connexion,preguntaevaluacion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPreguntaEvaluacion(Connexion connexion,PreguntaEvaluacion preguntaevaluacion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(preguntaevaluacion.getIsNew()||!preguntaevaluacion.getid_empresa().equals(preguntaevaluacion.getPreguntaEvaluacionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntaevaluacion.getPreguntaEvaluacionOriginal().getid_empresa()!=null)
				{
					strValorActual=preguntaevaluacion.getPreguntaEvaluacionOriginal().getid_empresa().toString();
				}
				if(preguntaevaluacion.getid_empresa()!=null)
				{
					strValorNuevo=preguntaevaluacion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaEvaluacionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(preguntaevaluacion.getIsNew()||!preguntaevaluacion.getid_sucursal().equals(preguntaevaluacion.getPreguntaEvaluacionOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntaevaluacion.getPreguntaEvaluacionOriginal().getid_sucursal()!=null)
				{
					strValorActual=preguntaevaluacion.getPreguntaEvaluacionOriginal().getid_sucursal().toString();
				}
				if(preguntaevaluacion.getid_sucursal()!=null)
				{
					strValorNuevo=preguntaevaluacion.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaEvaluacionConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(preguntaevaluacion.getIsNew()||!preguntaevaluacion.getid_ejercicio().equals(preguntaevaluacion.getPreguntaEvaluacionOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntaevaluacion.getPreguntaEvaluacionOriginal().getid_ejercicio()!=null)
				{
					strValorActual=preguntaevaluacion.getPreguntaEvaluacionOriginal().getid_ejercicio().toString();
				}
				if(preguntaevaluacion.getid_ejercicio()!=null)
				{
					strValorNuevo=preguntaevaluacion.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaEvaluacionConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(preguntaevaluacion.getIsNew()||!preguntaevaluacion.getid_periodo().equals(preguntaevaluacion.getPreguntaEvaluacionOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntaevaluacion.getPreguntaEvaluacionOriginal().getid_periodo()!=null)
				{
					strValorActual=preguntaevaluacion.getPreguntaEvaluacionOriginal().getid_periodo().toString();
				}
				if(preguntaevaluacion.getid_periodo()!=null)
				{
					strValorNuevo=preguntaevaluacion.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaEvaluacionConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(preguntaevaluacion.getIsNew()||!preguntaevaluacion.getpregunta().equals(preguntaevaluacion.getPreguntaEvaluacionOriginal().getpregunta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntaevaluacion.getPreguntaEvaluacionOriginal().getpregunta()!=null)
				{
					strValorActual=preguntaevaluacion.getPreguntaEvaluacionOriginal().getpregunta();
				}
				if(preguntaevaluacion.getpregunta()!=null)
				{
					strValorNuevo=preguntaevaluacion.getpregunta() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaEvaluacionConstantesFunciones.PREGUNTA,strValorActual,strValorNuevo);
			}	
			
			if(preguntaevaluacion.getIsNew()||!preguntaevaluacion.getcalificacion().equals(preguntaevaluacion.getPreguntaEvaluacionOriginal().getcalificacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntaevaluacion.getPreguntaEvaluacionOriginal().getcalificacion()!=null)
				{
					strValorActual=preguntaevaluacion.getPreguntaEvaluacionOriginal().getcalificacion().toString();
				}
				if(preguntaevaluacion.getcalificacion()!=null)
				{
					strValorNuevo=preguntaevaluacion.getcalificacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaEvaluacionConstantesFunciones.CALIFICACION,strValorActual,strValorNuevo);
			}	
			
			if(preguntaevaluacion.getIsNew()||!preguntaevaluacion.getorden().equals(preguntaevaluacion.getPreguntaEvaluacionOriginal().getorden()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntaevaluacion.getPreguntaEvaluacionOriginal().getorden()!=null)
				{
					strValorActual=preguntaevaluacion.getPreguntaEvaluacionOriginal().getorden().toString();
				}
				if(preguntaevaluacion.getorden()!=null)
				{
					strValorNuevo=preguntaevaluacion.getorden().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaEvaluacionConstantesFunciones.ORDEN,strValorActual,strValorNuevo);
			}	
			
			if(preguntaevaluacion.getIsNew()||!preguntaevaluacion.getid_anio().equals(preguntaevaluacion.getPreguntaEvaluacionOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntaevaluacion.getPreguntaEvaluacionOriginal().getid_anio()!=null)
				{
					strValorActual=preguntaevaluacion.getPreguntaEvaluacionOriginal().getid_anio().toString();
				}
				if(preguntaevaluacion.getid_anio()!=null)
				{
					strValorNuevo=preguntaevaluacion.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaEvaluacionConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(preguntaevaluacion.getIsNew()||!preguntaevaluacion.getid_mes().equals(preguntaevaluacion.getPreguntaEvaluacionOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntaevaluacion.getPreguntaEvaluacionOriginal().getid_mes()!=null)
				{
					strValorActual=preguntaevaluacion.getPreguntaEvaluacionOriginal().getid_mes().toString();
				}
				if(preguntaevaluacion.getid_mes()!=null)
				{
					strValorNuevo=preguntaevaluacion.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaEvaluacionConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePreguntaEvaluacionRelacionesWithConnection(PreguntaEvaluacion preguntaevaluacion,List<DetalleEvaluacionProveedor> detalleevaluacionproveedors,List<SubPreguntaEvaluacion> subpreguntaevaluacions) throws Exception {

		if(!preguntaevaluacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePreguntaEvaluacionRelacionesBase(preguntaevaluacion,detalleevaluacionproveedors,subpreguntaevaluacions,true);
		}
	}

	public void savePreguntaEvaluacionRelaciones(PreguntaEvaluacion preguntaevaluacion,List<DetalleEvaluacionProveedor> detalleevaluacionproveedors,List<SubPreguntaEvaluacion> subpreguntaevaluacions)throws Exception {

		if(!preguntaevaluacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePreguntaEvaluacionRelacionesBase(preguntaevaluacion,detalleevaluacionproveedors,subpreguntaevaluacions,false);
		}
	}

	public void savePreguntaEvaluacionRelacionesBase(PreguntaEvaluacion preguntaevaluacion,List<DetalleEvaluacionProveedor> detalleevaluacionproveedors,List<SubPreguntaEvaluacion> subpreguntaevaluacions,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PreguntaEvaluacion-saveRelacionesWithConnection");}
	
			preguntaevaluacion.setDetalleEvaluacionProveedors(detalleevaluacionproveedors);
			preguntaevaluacion.setSubPreguntaEvaluacions(subpreguntaevaluacions);

			this.setPreguntaEvaluacion(preguntaevaluacion);

			if(PreguntaEvaluacionLogicAdditional.validarSaveRelaciones(preguntaevaluacion,this)) {

				PreguntaEvaluacionLogicAdditional.updateRelacionesToSave(preguntaevaluacion,this);

				if((preguntaevaluacion.getIsNew()||preguntaevaluacion.getIsChanged())&&!preguntaevaluacion.getIsDeleted()) {
					this.savePreguntaEvaluacion();
					this.savePreguntaEvaluacionRelacionesDetalles(detalleevaluacionproveedors,subpreguntaevaluacions);

				} else if(preguntaevaluacion.getIsDeleted()) {
					this.savePreguntaEvaluacionRelacionesDetalles(detalleevaluacionproveedors,subpreguntaevaluacions);
					this.savePreguntaEvaluacion();
				}

				PreguntaEvaluacionLogicAdditional.updateRelacionesToSaveAfter(preguntaevaluacion,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleEvaluacionProveedorConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleEvaluacionProveedors(detalleevaluacionproveedors,true,true);
			SubPreguntaEvaluacionConstantesFunciones.InicializarGeneralEntityAuxiliaresSubPreguntaEvaluacions(subpreguntaevaluacions,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void savePreguntaEvaluacionRelacionesDetalles(List<DetalleEvaluacionProveedor> detalleevaluacionproveedors,List<SubPreguntaEvaluacion> subpreguntaevaluacions)throws Exception {
		try {
	

			Long idPreguntaEvaluacionActual=this.getPreguntaEvaluacion().getId();

			DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic_Desde_PreguntaEvaluacion=new DetalleEvaluacionProveedorLogic();
			detalleevaluacionproveedorLogic_Desde_PreguntaEvaluacion.setDetalleEvaluacionProveedors(detalleevaluacionproveedors);

			detalleevaluacionproveedorLogic_Desde_PreguntaEvaluacion.setConnexion(this.getConnexion());
			detalleevaluacionproveedorLogic_Desde_PreguntaEvaluacion.setDatosCliente(this.datosCliente);

			for(DetalleEvaluacionProveedor detalleevaluacionproveedor_Desde_PreguntaEvaluacion:detalleevaluacionproveedorLogic_Desde_PreguntaEvaluacion.getDetalleEvaluacionProveedors()) {
				detalleevaluacionproveedor_Desde_PreguntaEvaluacion.setid_pregunta_evaluacion(idPreguntaEvaluacionActual);
			}

			detalleevaluacionproveedorLogic_Desde_PreguntaEvaluacion.saveDetalleEvaluacionProveedors();

			SubPreguntaEvaluacionLogic subpreguntaevaluacionLogic_Desde_PreguntaEvaluacion=new SubPreguntaEvaluacionLogic();
			subpreguntaevaluacionLogic_Desde_PreguntaEvaluacion.setSubPreguntaEvaluacions(subpreguntaevaluacions);

			subpreguntaevaluacionLogic_Desde_PreguntaEvaluacion.setConnexion(this.getConnexion());
			subpreguntaevaluacionLogic_Desde_PreguntaEvaluacion.setDatosCliente(this.datosCliente);

			for(SubPreguntaEvaluacion subpreguntaevaluacion_Desde_PreguntaEvaluacion:subpreguntaevaluacionLogic_Desde_PreguntaEvaluacion.getSubPreguntaEvaluacions()) {
				subpreguntaevaluacion_Desde_PreguntaEvaluacion.setid_pregunta_evaluacion(idPreguntaEvaluacionActual);

				subpreguntaevaluacionLogic_Desde_PreguntaEvaluacion.setSubPreguntaEvaluacion(subpreguntaevaluacion_Desde_PreguntaEvaluacion);
				subpreguntaevaluacionLogic_Desde_PreguntaEvaluacion.saveSubPreguntaEvaluacion();

				Long idSubPreguntaEvaluacionActual=subpreguntaevaluacion_Desde_PreguntaEvaluacion.getId();

				DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic_Desde_SubPreguntaEvaluacion=new DetalleEvaluacionProveedorLogic();

				if(subpreguntaevaluacion_Desde_PreguntaEvaluacion.getDetalleEvaluacionProveedors()==null){
					subpreguntaevaluacion_Desde_PreguntaEvaluacion.setDetalleEvaluacionProveedors(new ArrayList<DetalleEvaluacionProveedor>());
				}

				detalleevaluacionproveedorLogic_Desde_SubPreguntaEvaluacion.setDetalleEvaluacionProveedors(subpreguntaevaluacion_Desde_PreguntaEvaluacion.getDetalleEvaluacionProveedors());

				detalleevaluacionproveedorLogic_Desde_SubPreguntaEvaluacion.setConnexion(this.getConnexion());
				detalleevaluacionproveedorLogic_Desde_SubPreguntaEvaluacion.setDatosCliente(this.datosCliente);

				for(DetalleEvaluacionProveedor detalleevaluacionproveedor_Desde_SubPreguntaEvaluacion:detalleevaluacionproveedorLogic_Desde_SubPreguntaEvaluacion.getDetalleEvaluacionProveedors()) {
					detalleevaluacionproveedor_Desde_SubPreguntaEvaluacion.setid_sub_pregunta_evaluacion(idSubPreguntaEvaluacionActual);
				}

				detalleevaluacionproveedorLogic_Desde_SubPreguntaEvaluacion.saveDetalleEvaluacionProveedors();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPreguntaEvaluacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PreguntaEvaluacionConstantesFunciones.getClassesForeignKeysOfPreguntaEvaluacion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPreguntaEvaluacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PreguntaEvaluacionConstantesFunciones.getClassesRelationshipsOfPreguntaEvaluacion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

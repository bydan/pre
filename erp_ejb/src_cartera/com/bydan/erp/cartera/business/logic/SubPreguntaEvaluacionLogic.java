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
import com.bydan.erp.cartera.util.SubPreguntaEvaluacionConstantesFunciones;
import com.bydan.erp.cartera.util.SubPreguntaEvaluacionParameterReturnGeneral;
//import com.bydan.erp.cartera.util.SubPreguntaEvaluacionParameterGeneral;
import com.bydan.erp.cartera.business.entity.SubPreguntaEvaluacion;
import com.bydan.erp.cartera.business.logic.SubPreguntaEvaluacionLogicAdditional;
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
public class SubPreguntaEvaluacionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(SubPreguntaEvaluacionLogic.class);
	
	protected SubPreguntaEvaluacionDataAccess subpreguntaevaluacionDataAccess; 	
	protected SubPreguntaEvaluacion subpreguntaevaluacion;
	protected List<SubPreguntaEvaluacion> subpreguntaevaluacions;
	protected Object subpreguntaevaluacionObject;	
	protected List<Object> subpreguntaevaluacionsObject;
	
	public static ClassValidator<SubPreguntaEvaluacion> subpreguntaevaluacionValidator = new ClassValidator<SubPreguntaEvaluacion>(SubPreguntaEvaluacion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected SubPreguntaEvaluacionLogicAdditional subpreguntaevaluacionLogicAdditional=null;
	
	public SubPreguntaEvaluacionLogicAdditional getSubPreguntaEvaluacionLogicAdditional() {
		return this.subpreguntaevaluacionLogicAdditional;
	}
	
	public void setSubPreguntaEvaluacionLogicAdditional(SubPreguntaEvaluacionLogicAdditional subpreguntaevaluacionLogicAdditional) {
		try {
			this.subpreguntaevaluacionLogicAdditional=subpreguntaevaluacionLogicAdditional;
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
	
	
	
	
	public  SubPreguntaEvaluacionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.subpreguntaevaluacionDataAccess = new SubPreguntaEvaluacionDataAccess();
			
			this.subpreguntaevaluacions= new ArrayList<SubPreguntaEvaluacion>();
			this.subpreguntaevaluacion= new SubPreguntaEvaluacion();
			
			this.subpreguntaevaluacionObject=new Object();
			this.subpreguntaevaluacionsObject=new ArrayList<Object>();
				
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
			
			this.subpreguntaevaluacionDataAccess.setConnexionType(this.connexionType);
			this.subpreguntaevaluacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SubPreguntaEvaluacionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.subpreguntaevaluacionDataAccess = new SubPreguntaEvaluacionDataAccess();
			this.subpreguntaevaluacions= new ArrayList<SubPreguntaEvaluacion>();
			this.subpreguntaevaluacion= new SubPreguntaEvaluacion();
			this.subpreguntaevaluacionObject=new Object();
			this.subpreguntaevaluacionsObject=new ArrayList<Object>();
			
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
			
			this.subpreguntaevaluacionDataAccess.setConnexionType(this.connexionType);
			this.subpreguntaevaluacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public SubPreguntaEvaluacion getSubPreguntaEvaluacion() throws Exception {	
		SubPreguntaEvaluacionLogicAdditional.checkSubPreguntaEvaluacionToGet(subpreguntaevaluacion,this.datosCliente,this.arrDatoGeneral);
		SubPreguntaEvaluacionLogicAdditional.updateSubPreguntaEvaluacionToGet(subpreguntaevaluacion,this.arrDatoGeneral);
		
		return subpreguntaevaluacion;
	}
		
	public void setSubPreguntaEvaluacion(SubPreguntaEvaluacion newSubPreguntaEvaluacion) {
		this.subpreguntaevaluacion = newSubPreguntaEvaluacion;
	}
	
	public SubPreguntaEvaluacionDataAccess getSubPreguntaEvaluacionDataAccess() {
		return subpreguntaevaluacionDataAccess;
	}
	
	public void setSubPreguntaEvaluacionDataAccess(SubPreguntaEvaluacionDataAccess newsubpreguntaevaluacionDataAccess) {
		this.subpreguntaevaluacionDataAccess = newsubpreguntaevaluacionDataAccess;
	}
	
	public List<SubPreguntaEvaluacion> getSubPreguntaEvaluacions() throws Exception {		
		this.quitarSubPreguntaEvaluacionsNulos();
		
		SubPreguntaEvaluacionLogicAdditional.checkSubPreguntaEvaluacionToGets(subpreguntaevaluacions,this.datosCliente,this.arrDatoGeneral);
		
		for (SubPreguntaEvaluacion subpreguntaevaluacionLocal: subpreguntaevaluacions ) {
			SubPreguntaEvaluacionLogicAdditional.updateSubPreguntaEvaluacionToGet(subpreguntaevaluacionLocal,this.arrDatoGeneral);
		}
		
		return subpreguntaevaluacions;
	}
	
	public void setSubPreguntaEvaluacions(List<SubPreguntaEvaluacion> newSubPreguntaEvaluacions) {
		this.subpreguntaevaluacions = newSubPreguntaEvaluacions;
	}
	
	public Object getSubPreguntaEvaluacionObject() {	
		this.subpreguntaevaluacionObject=this.subpreguntaevaluacionDataAccess.getEntityObject();
		return this.subpreguntaevaluacionObject;
	}
		
	public void setSubPreguntaEvaluacionObject(Object newSubPreguntaEvaluacionObject) {
		this.subpreguntaevaluacionObject = newSubPreguntaEvaluacionObject;
	}
	
	public List<Object> getSubPreguntaEvaluacionsObject() {		
		this.subpreguntaevaluacionsObject=this.subpreguntaevaluacionDataAccess.getEntitiesObject();
		return this.subpreguntaevaluacionsObject;
	}
		
	public void setSubPreguntaEvaluacionsObject(List<Object> newSubPreguntaEvaluacionsObject) {
		this.subpreguntaevaluacionsObject = newSubPreguntaEvaluacionsObject;
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
		
		if(this.subpreguntaevaluacionDataAccess!=null) {
			this.subpreguntaevaluacionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			subpreguntaevaluacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			subpreguntaevaluacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		subpreguntaevaluacion = new  SubPreguntaEvaluacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			subpreguntaevaluacion=subpreguntaevaluacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.subpreguntaevaluacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacion);
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
		subpreguntaevaluacion = new  SubPreguntaEvaluacion();
		  		  
        try {
			
			subpreguntaevaluacion=subpreguntaevaluacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.subpreguntaevaluacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		subpreguntaevaluacion = new  SubPreguntaEvaluacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			subpreguntaevaluacion=subpreguntaevaluacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.subpreguntaevaluacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacion);
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
		subpreguntaevaluacion = new  SubPreguntaEvaluacion();
		  		  
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
		subpreguntaevaluacion = new  SubPreguntaEvaluacion();
		  		  
        try {
			
			subpreguntaevaluacion=subpreguntaevaluacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.subpreguntaevaluacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		subpreguntaevaluacion = new  SubPreguntaEvaluacion();
		  		  
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
		subpreguntaevaluacion = new  SubPreguntaEvaluacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =subpreguntaevaluacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		subpreguntaevaluacion = new  SubPreguntaEvaluacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=subpreguntaevaluacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		subpreguntaevaluacion = new  SubPreguntaEvaluacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =subpreguntaevaluacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		subpreguntaevaluacion = new  SubPreguntaEvaluacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=subpreguntaevaluacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		subpreguntaevaluacion = new  SubPreguntaEvaluacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =subpreguntaevaluacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		subpreguntaevaluacion = new  SubPreguntaEvaluacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=subpreguntaevaluacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		subpreguntaevaluacions = new  ArrayList<SubPreguntaEvaluacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subpreguntaevaluacions=subpreguntaevaluacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubPreguntaEvaluacion(subpreguntaevaluacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacions);
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
		subpreguntaevaluacions = new  ArrayList<SubPreguntaEvaluacion>();
		  		  
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
		subpreguntaevaluacions = new  ArrayList<SubPreguntaEvaluacion>();
		  		  
        try {			
			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subpreguntaevaluacions=subpreguntaevaluacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarSubPreguntaEvaluacion(subpreguntaevaluacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		subpreguntaevaluacions = new  ArrayList<SubPreguntaEvaluacion>();
		  		  
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
		subpreguntaevaluacions = new  ArrayList<SubPreguntaEvaluacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subpreguntaevaluacions=subpreguntaevaluacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubPreguntaEvaluacion(subpreguntaevaluacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacions);
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
		subpreguntaevaluacions = new  ArrayList<SubPreguntaEvaluacion>();
		  		  
        try {
			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subpreguntaevaluacions=subpreguntaevaluacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubPreguntaEvaluacion(subpreguntaevaluacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacions);
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
		subpreguntaevaluacions = new  ArrayList<SubPreguntaEvaluacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subpreguntaevaluacions=subpreguntaevaluacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSubPreguntaEvaluacion(subpreguntaevaluacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacions);
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
		subpreguntaevaluacions = new  ArrayList<SubPreguntaEvaluacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subpreguntaevaluacions=subpreguntaevaluacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSubPreguntaEvaluacion(subpreguntaevaluacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		subpreguntaevaluacion = new  SubPreguntaEvaluacion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subpreguntaevaluacion=subpreguntaevaluacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSubPreguntaEvaluacion(subpreguntaevaluacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacion);
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
		subpreguntaevaluacion = new  SubPreguntaEvaluacion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subpreguntaevaluacion=subpreguntaevaluacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSubPreguntaEvaluacion(subpreguntaevaluacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		subpreguntaevaluacions = new  ArrayList<SubPreguntaEvaluacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subpreguntaevaluacions=subpreguntaevaluacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubPreguntaEvaluacion(subpreguntaevaluacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacions);
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
		subpreguntaevaluacions = new  ArrayList<SubPreguntaEvaluacion>();
		  		  
        try {
			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subpreguntaevaluacions=subpreguntaevaluacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSubPreguntaEvaluacion(subpreguntaevaluacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosSubPreguntaEvaluacionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		subpreguntaevaluacions = new  ArrayList<SubPreguntaEvaluacion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-getTodosSubPreguntaEvaluacionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subpreguntaevaluacions=subpreguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSubPreguntaEvaluacion(subpreguntaevaluacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacions);
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
	
	public  void  getTodosSubPreguntaEvaluacions(String sFinalQuery,Pagination pagination)throws Exception {
		subpreguntaevaluacions = new  ArrayList<SubPreguntaEvaluacion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			subpreguntaevaluacions=subpreguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSubPreguntaEvaluacion(subpreguntaevaluacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarSubPreguntaEvaluacion(SubPreguntaEvaluacion subpreguntaevaluacion) throws Exception {
		Boolean estaValidado=false;
		
		if(subpreguntaevaluacion.getIsNew() || subpreguntaevaluacion.getIsChanged()) { 
			this.invalidValues = subpreguntaevaluacionValidator.getInvalidValues(subpreguntaevaluacion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(subpreguntaevaluacion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarSubPreguntaEvaluacion(List<SubPreguntaEvaluacion> SubPreguntaEvaluacions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(SubPreguntaEvaluacion subpreguntaevaluacionLocal:subpreguntaevaluacions) {				
			estaValidadoObjeto=this.validarGuardarSubPreguntaEvaluacion(subpreguntaevaluacionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarSubPreguntaEvaluacion(List<SubPreguntaEvaluacion> SubPreguntaEvaluacions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSubPreguntaEvaluacion(subpreguntaevaluacions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarSubPreguntaEvaluacion(SubPreguntaEvaluacion SubPreguntaEvaluacion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSubPreguntaEvaluacion(subpreguntaevaluacion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(SubPreguntaEvaluacion subpreguntaevaluacion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+subpreguntaevaluacion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=SubPreguntaEvaluacionConstantesFunciones.getSubPreguntaEvaluacionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"subpreguntaevaluacion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(SubPreguntaEvaluacionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(SubPreguntaEvaluacionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveSubPreguntaEvaluacionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-saveSubPreguntaEvaluacionWithConnection");connexion.begin();			
			
			SubPreguntaEvaluacionLogicAdditional.checkSubPreguntaEvaluacionToSave(this.subpreguntaevaluacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SubPreguntaEvaluacionLogicAdditional.updateSubPreguntaEvaluacionToSave(this.subpreguntaevaluacion,this.arrDatoGeneral);
			
			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.subpreguntaevaluacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowSubPreguntaEvaluacion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSubPreguntaEvaluacion(this.subpreguntaevaluacion)) {
				SubPreguntaEvaluacionDataAccess.save(this.subpreguntaevaluacion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.subpreguntaevaluacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SubPreguntaEvaluacionLogicAdditional.checkSubPreguntaEvaluacionToSaveAfter(this.subpreguntaevaluacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSubPreguntaEvaluacion();
			
			connexion.commit();			
			
			if(this.subpreguntaevaluacion.getIsDeleted()) {
				this.subpreguntaevaluacion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveSubPreguntaEvaluacion()throws Exception {	
		try {	
			
			SubPreguntaEvaluacionLogicAdditional.checkSubPreguntaEvaluacionToSave(this.subpreguntaevaluacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SubPreguntaEvaluacionLogicAdditional.updateSubPreguntaEvaluacionToSave(this.subpreguntaevaluacion,this.arrDatoGeneral);
			
			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.subpreguntaevaluacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSubPreguntaEvaluacion(this.subpreguntaevaluacion)) {			
				SubPreguntaEvaluacionDataAccess.save(this.subpreguntaevaluacion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.subpreguntaevaluacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SubPreguntaEvaluacionLogicAdditional.checkSubPreguntaEvaluacionToSaveAfter(this.subpreguntaevaluacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.subpreguntaevaluacion.getIsDeleted()) {
				this.subpreguntaevaluacion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveSubPreguntaEvaluacionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-saveSubPreguntaEvaluacionsWithConnection");connexion.begin();			
			
			SubPreguntaEvaluacionLogicAdditional.checkSubPreguntaEvaluacionToSaves(subpreguntaevaluacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowSubPreguntaEvaluacions();
			
			Boolean validadoTodosSubPreguntaEvaluacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SubPreguntaEvaluacion subpreguntaevaluacionLocal:subpreguntaevaluacions) {		
				if(subpreguntaevaluacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SubPreguntaEvaluacionLogicAdditional.updateSubPreguntaEvaluacionToSave(subpreguntaevaluacionLocal,this.arrDatoGeneral);
	        	
				SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),subpreguntaevaluacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSubPreguntaEvaluacion(subpreguntaevaluacionLocal)) {
					SubPreguntaEvaluacionDataAccess.save(subpreguntaevaluacionLocal, connexion);				
				} else {
					validadoTodosSubPreguntaEvaluacion=false;
				}
			}
			
			if(!validadoTodosSubPreguntaEvaluacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SubPreguntaEvaluacionLogicAdditional.checkSubPreguntaEvaluacionToSavesAfter(subpreguntaevaluacions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSubPreguntaEvaluacions();
			
			connexion.commit();		
			
			this.quitarSubPreguntaEvaluacionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveSubPreguntaEvaluacions()throws Exception {				
		 try {	
			SubPreguntaEvaluacionLogicAdditional.checkSubPreguntaEvaluacionToSaves(subpreguntaevaluacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosSubPreguntaEvaluacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(SubPreguntaEvaluacion subpreguntaevaluacionLocal:subpreguntaevaluacions) {				
				if(subpreguntaevaluacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SubPreguntaEvaluacionLogicAdditional.updateSubPreguntaEvaluacionToSave(subpreguntaevaluacionLocal,this.arrDatoGeneral);
	        	
				SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),subpreguntaevaluacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSubPreguntaEvaluacion(subpreguntaevaluacionLocal)) {				
					SubPreguntaEvaluacionDataAccess.save(subpreguntaevaluacionLocal, connexion);				
				} else {
					validadoTodosSubPreguntaEvaluacion=false;
				}
			}
			
			if(!validadoTodosSubPreguntaEvaluacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SubPreguntaEvaluacionLogicAdditional.checkSubPreguntaEvaluacionToSavesAfter(subpreguntaevaluacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarSubPreguntaEvaluacionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SubPreguntaEvaluacionParameterReturnGeneral procesarAccionSubPreguntaEvaluacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SubPreguntaEvaluacion> subpreguntaevaluacions,SubPreguntaEvaluacionParameterReturnGeneral subpreguntaevaluacionParameterGeneral)throws Exception {
		 try {	
			SubPreguntaEvaluacionParameterReturnGeneral subpreguntaevaluacionReturnGeneral=new SubPreguntaEvaluacionParameterReturnGeneral();
	
			SubPreguntaEvaluacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,subpreguntaevaluacions,subpreguntaevaluacionParameterGeneral,subpreguntaevaluacionReturnGeneral);
			
			return subpreguntaevaluacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SubPreguntaEvaluacionParameterReturnGeneral procesarAccionSubPreguntaEvaluacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<SubPreguntaEvaluacion> subpreguntaevaluacions,SubPreguntaEvaluacionParameterReturnGeneral subpreguntaevaluacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-procesarAccionSubPreguntaEvaluacionsWithConnection");connexion.begin();			
			
			SubPreguntaEvaluacionParameterReturnGeneral subpreguntaevaluacionReturnGeneral=new SubPreguntaEvaluacionParameterReturnGeneral();
	
			SubPreguntaEvaluacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,subpreguntaevaluacions,subpreguntaevaluacionParameterGeneral,subpreguntaevaluacionReturnGeneral);
			
			this.connexion.commit();
			
			return subpreguntaevaluacionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SubPreguntaEvaluacionParameterReturnGeneral procesarEventosSubPreguntaEvaluacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SubPreguntaEvaluacion> subpreguntaevaluacions,SubPreguntaEvaluacion subpreguntaevaluacion,SubPreguntaEvaluacionParameterReturnGeneral subpreguntaevaluacionParameterGeneral,Boolean isEsNuevoSubPreguntaEvaluacion,ArrayList<Classe> clases)throws Exception {
		 try {	
			SubPreguntaEvaluacionParameterReturnGeneral subpreguntaevaluacionReturnGeneral=new SubPreguntaEvaluacionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				subpreguntaevaluacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SubPreguntaEvaluacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,subpreguntaevaluacions,subpreguntaevaluacion,subpreguntaevaluacionParameterGeneral,subpreguntaevaluacionReturnGeneral,isEsNuevoSubPreguntaEvaluacion,clases);
			
			return subpreguntaevaluacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public SubPreguntaEvaluacionParameterReturnGeneral procesarEventosSubPreguntaEvaluacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<SubPreguntaEvaluacion> subpreguntaevaluacions,SubPreguntaEvaluacion subpreguntaevaluacion,SubPreguntaEvaluacionParameterReturnGeneral subpreguntaevaluacionParameterGeneral,Boolean isEsNuevoSubPreguntaEvaluacion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-procesarEventosSubPreguntaEvaluacionsWithConnection");connexion.begin();			
			
			SubPreguntaEvaluacionParameterReturnGeneral subpreguntaevaluacionReturnGeneral=new SubPreguntaEvaluacionParameterReturnGeneral();
	
			subpreguntaevaluacionReturnGeneral.setSubPreguntaEvaluacion(subpreguntaevaluacion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				subpreguntaevaluacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SubPreguntaEvaluacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,subpreguntaevaluacions,subpreguntaevaluacion,subpreguntaevaluacionParameterGeneral,subpreguntaevaluacionReturnGeneral,isEsNuevoSubPreguntaEvaluacion,clases);
			
			this.connexion.commit();
			
			return subpreguntaevaluacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SubPreguntaEvaluacionParameterReturnGeneral procesarImportacionSubPreguntaEvaluacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,SubPreguntaEvaluacionParameterReturnGeneral subpreguntaevaluacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-procesarImportacionSubPreguntaEvaluacionsWithConnection");connexion.begin();			
			
			SubPreguntaEvaluacionParameterReturnGeneral subpreguntaevaluacionReturnGeneral=new SubPreguntaEvaluacionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.subpreguntaevaluacions=new ArrayList<SubPreguntaEvaluacion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.subpreguntaevaluacion=new SubPreguntaEvaluacion();
				
				
				if(conColumnasBase) {this.subpreguntaevaluacion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.subpreguntaevaluacion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.subpreguntaevaluacion.setorden(Integer.parseInt(arrColumnas[iColumn++]));
				this.subpreguntaevaluacion.setpregunta(arrColumnas[iColumn++]);
				this.subpreguntaevaluacion.setporcentaje_si(Double.parseDouble(arrColumnas[iColumn++]));
				this.subpreguntaevaluacion.setcon_factura(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.subpreguntaevaluacion.setcon_orden_compra(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.subpreguntaevaluacion.setcon_completo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.subpreguntaevaluacion.setcon_a_tiempo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.subpreguntaevaluacions.add(this.subpreguntaevaluacion);
			}
			
			this.saveSubPreguntaEvaluacions();
			
			this.connexion.commit();
			
			subpreguntaevaluacionReturnGeneral.setConRetornoEstaProcesado(true);
			subpreguntaevaluacionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return subpreguntaevaluacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarSubPreguntaEvaluacionsEliminados() throws Exception {				
		
		List<SubPreguntaEvaluacion> subpreguntaevaluacionsAux= new ArrayList<SubPreguntaEvaluacion>();
		
		for(SubPreguntaEvaluacion subpreguntaevaluacion:subpreguntaevaluacions) {
			if(!subpreguntaevaluacion.getIsDeleted()) {
				subpreguntaevaluacionsAux.add(subpreguntaevaluacion);
			}
		}
		
		subpreguntaevaluacions=subpreguntaevaluacionsAux;
	}
	
	public void quitarSubPreguntaEvaluacionsNulos() throws Exception {				
		
		List<SubPreguntaEvaluacion> subpreguntaevaluacionsAux= new ArrayList<SubPreguntaEvaluacion>();
		
		for(SubPreguntaEvaluacion subpreguntaevaluacion : this.subpreguntaevaluacions) {
			if(subpreguntaevaluacion==null) {
				subpreguntaevaluacionsAux.add(subpreguntaevaluacion);
			}
		}
		
		//this.subpreguntaevaluacions=subpreguntaevaluacionsAux;
		
		this.subpreguntaevaluacions.removeAll(subpreguntaevaluacionsAux);
	}
	
	public void getSetVersionRowSubPreguntaEvaluacionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(subpreguntaevaluacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((subpreguntaevaluacion.getIsDeleted() || (subpreguntaevaluacion.getIsChanged()&&!subpreguntaevaluacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=subpreguntaevaluacionDataAccess.getSetVersionRowSubPreguntaEvaluacion(connexion,subpreguntaevaluacion.getId());
				
				if(!subpreguntaevaluacion.getVersionRow().equals(timestamp)) {	
					subpreguntaevaluacion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				subpreguntaevaluacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowSubPreguntaEvaluacion()throws Exception {	
		
		if(subpreguntaevaluacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((subpreguntaevaluacion.getIsDeleted() || (subpreguntaevaluacion.getIsChanged()&&!subpreguntaevaluacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=subpreguntaevaluacionDataAccess.getSetVersionRowSubPreguntaEvaluacion(connexion,subpreguntaevaluacion.getId());
			
			try {							
				if(!subpreguntaevaluacion.getVersionRow().equals(timestamp)) {	
					subpreguntaevaluacion.setVersionRow(timestamp);
				}
				
				subpreguntaevaluacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowSubPreguntaEvaluacionsWithConnection()throws Exception {	
		if(subpreguntaevaluacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(SubPreguntaEvaluacion subpreguntaevaluacionAux:subpreguntaevaluacions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(subpreguntaevaluacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(subpreguntaevaluacionAux.getIsDeleted() || (subpreguntaevaluacionAux.getIsChanged()&&!subpreguntaevaluacionAux.getIsNew())) {
						
						timestamp=subpreguntaevaluacionDataAccess.getSetVersionRowSubPreguntaEvaluacion(connexion,subpreguntaevaluacionAux.getId());
						
						if(!subpreguntaevaluacion.getVersionRow().equals(timestamp)) {	
							subpreguntaevaluacionAux.setVersionRow(timestamp);
						}
								
						subpreguntaevaluacionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowSubPreguntaEvaluacions()throws Exception {	
		if(subpreguntaevaluacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(SubPreguntaEvaluacion subpreguntaevaluacionAux:subpreguntaevaluacions) {
					if(subpreguntaevaluacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(subpreguntaevaluacionAux.getIsDeleted() || (subpreguntaevaluacionAux.getIsChanged()&&!subpreguntaevaluacionAux.getIsNew())) {
						
						timestamp=subpreguntaevaluacionDataAccess.getSetVersionRowSubPreguntaEvaluacion(connexion,subpreguntaevaluacionAux.getId());
						
						if(!subpreguntaevaluacionAux.getVersionRow().equals(timestamp)) {	
							subpreguntaevaluacionAux.setVersionRow(timestamp);
						}
						
													
						subpreguntaevaluacionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public SubPreguntaEvaluacionParameterReturnGeneral cargarCombosLoteForeignKeySubPreguntaEvaluacionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalPreguntaEvaluacion,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo) throws Exception {
		SubPreguntaEvaluacionParameterReturnGeneral  subpreguntaevaluacionReturnGeneral =new SubPreguntaEvaluacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-cargarCombosLoteForeignKeySubPreguntaEvaluacionWithConnection");connexion.begin();
			
			subpreguntaevaluacionReturnGeneral =new SubPreguntaEvaluacionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			subpreguntaevaluacionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			subpreguntaevaluacionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<PreguntaEvaluacion> preguntaevaluacionsForeignKey=new ArrayList<PreguntaEvaluacion>();
			PreguntaEvaluacionLogic preguntaevaluacionLogic=new PreguntaEvaluacionLogic();
			preguntaevaluacionLogic.setConnexion(this.connexion);
			preguntaevaluacionLogic.getPreguntaEvaluacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPreguntaEvaluacion.equals("NONE")) {
				preguntaevaluacionLogic.getTodosPreguntaEvaluacions(finalQueryGlobalPreguntaEvaluacion,new Pagination());
				preguntaevaluacionsForeignKey=preguntaevaluacionLogic.getPreguntaEvaluacions();
			}

			subpreguntaevaluacionReturnGeneral.setpreguntaevaluacionsForeignKey(preguntaevaluacionsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			subpreguntaevaluacionReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			subpreguntaevaluacionReturnGeneral.setperiodosForeignKey(periodosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return subpreguntaevaluacionReturnGeneral;
	}
	
	public SubPreguntaEvaluacionParameterReturnGeneral cargarCombosLoteForeignKeySubPreguntaEvaluacion(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalPreguntaEvaluacion,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo) throws Exception {
		SubPreguntaEvaluacionParameterReturnGeneral  subpreguntaevaluacionReturnGeneral =new SubPreguntaEvaluacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			subpreguntaevaluacionReturnGeneral =new SubPreguntaEvaluacionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			subpreguntaevaluacionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			subpreguntaevaluacionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<PreguntaEvaluacion> preguntaevaluacionsForeignKey=new ArrayList<PreguntaEvaluacion>();
			PreguntaEvaluacionLogic preguntaevaluacionLogic=new PreguntaEvaluacionLogic();
			preguntaevaluacionLogic.setConnexion(this.connexion);
			preguntaevaluacionLogic.getPreguntaEvaluacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPreguntaEvaluacion.equals("NONE")) {
				preguntaevaluacionLogic.getTodosPreguntaEvaluacions(finalQueryGlobalPreguntaEvaluacion,new Pagination());
				preguntaevaluacionsForeignKey=preguntaevaluacionLogic.getPreguntaEvaluacions();
			}

			subpreguntaevaluacionReturnGeneral.setpreguntaevaluacionsForeignKey(preguntaevaluacionsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			subpreguntaevaluacionReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			subpreguntaevaluacionReturnGeneral.setperiodosForeignKey(periodosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return subpreguntaevaluacionReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeySubPreguntaEvaluacionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic=new DetalleEvaluacionProveedorLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeySubPreguntaEvaluacionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleEvaluacionProveedor.class));
											
			

			detalleevaluacionproveedorLogic.setConnexion(this.getConnexion());
			detalleevaluacionproveedorLogic.setDatosCliente(this.datosCliente);
			detalleevaluacionproveedorLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(SubPreguntaEvaluacion subpreguntaevaluacion:this.subpreguntaevaluacions) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleEvaluacionProveedorConstantesFunciones.getClassesForeignKeysOfDetalleEvaluacionProveedor(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleevaluacionproveedorLogic.setDetalleEvaluacionProveedors(subpreguntaevaluacion.detalleevaluacionproveedors);
				detalleevaluacionproveedorLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(SubPreguntaEvaluacion subpreguntaevaluacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SubPreguntaEvaluacionLogicAdditional.updateSubPreguntaEvaluacionToGet(subpreguntaevaluacion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		subpreguntaevaluacion.setEmpresa(subpreguntaevaluacionDataAccess.getEmpresa(connexion,subpreguntaevaluacion));
		subpreguntaevaluacion.setSucursal(subpreguntaevaluacionDataAccess.getSucursal(connexion,subpreguntaevaluacion));
		subpreguntaevaluacion.setPreguntaEvaluacion(subpreguntaevaluacionDataAccess.getPreguntaEvaluacion(connexion,subpreguntaevaluacion));
		subpreguntaevaluacion.setEjercicio(subpreguntaevaluacionDataAccess.getEjercicio(connexion,subpreguntaevaluacion));
		subpreguntaevaluacion.setPeriodo(subpreguntaevaluacionDataAccess.getPeriodo(connexion,subpreguntaevaluacion));
		subpreguntaevaluacion.setDetalleEvaluacionProveedors(subpreguntaevaluacionDataAccess.getDetalleEvaluacionProveedors(connexion,subpreguntaevaluacion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				subpreguntaevaluacion.setEmpresa(subpreguntaevaluacionDataAccess.getEmpresa(connexion,subpreguntaevaluacion));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				subpreguntaevaluacion.setSucursal(subpreguntaevaluacionDataAccess.getSucursal(connexion,subpreguntaevaluacion));
				continue;
			}

			if(clas.clas.equals(PreguntaEvaluacion.class)) {
				subpreguntaevaluacion.setPreguntaEvaluacion(subpreguntaevaluacionDataAccess.getPreguntaEvaluacion(connexion,subpreguntaevaluacion));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				subpreguntaevaluacion.setEjercicio(subpreguntaevaluacionDataAccess.getEjercicio(connexion,subpreguntaevaluacion));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				subpreguntaevaluacion.setPeriodo(subpreguntaevaluacionDataAccess.getPeriodo(connexion,subpreguntaevaluacion));
				continue;
			}

			if(clas.clas.equals(DetalleEvaluacionProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				subpreguntaevaluacion.setDetalleEvaluacionProveedors(subpreguntaevaluacionDataAccess.getDetalleEvaluacionProveedors(connexion,subpreguntaevaluacion));

				if(this.isConDeep) {
					DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic= new DetalleEvaluacionProveedorLogic(this.connexion);
					detalleevaluacionproveedorLogic.setDetalleEvaluacionProveedors(subpreguntaevaluacion.getDetalleEvaluacionProveedors());
					ArrayList<Classe> classesLocal=DetalleEvaluacionProveedorConstantesFunciones.getClassesForeignKeysOfDetalleEvaluacionProveedor(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleevaluacionproveedorLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleEvaluacionProveedorConstantesFunciones.refrescarForeignKeysDescripcionesDetalleEvaluacionProveedor(detalleevaluacionproveedorLogic.getDetalleEvaluacionProveedors());
					subpreguntaevaluacion.setDetalleEvaluacionProveedors(detalleevaluacionproveedorLogic.getDetalleEvaluacionProveedors());
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
			subpreguntaevaluacion.setEmpresa(subpreguntaevaluacionDataAccess.getEmpresa(connexion,subpreguntaevaluacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subpreguntaevaluacion.setSucursal(subpreguntaevaluacionDataAccess.getSucursal(connexion,subpreguntaevaluacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PreguntaEvaluacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subpreguntaevaluacion.setPreguntaEvaluacion(subpreguntaevaluacionDataAccess.getPreguntaEvaluacion(connexion,subpreguntaevaluacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subpreguntaevaluacion.setEjercicio(subpreguntaevaluacionDataAccess.getEjercicio(connexion,subpreguntaevaluacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subpreguntaevaluacion.setPeriodo(subpreguntaevaluacionDataAccess.getPeriodo(connexion,subpreguntaevaluacion));
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
			subpreguntaevaluacion.setDetalleEvaluacionProveedors(subpreguntaevaluacionDataAccess.getDetalleEvaluacionProveedors(connexion,subpreguntaevaluacion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		subpreguntaevaluacion.setEmpresa(subpreguntaevaluacionDataAccess.getEmpresa(connexion,subpreguntaevaluacion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(subpreguntaevaluacion.getEmpresa(),isDeep,deepLoadType,clases);
				
		subpreguntaevaluacion.setSucursal(subpreguntaevaluacionDataAccess.getSucursal(connexion,subpreguntaevaluacion));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(subpreguntaevaluacion.getSucursal(),isDeep,deepLoadType,clases);
				
		subpreguntaevaluacion.setPreguntaEvaluacion(subpreguntaevaluacionDataAccess.getPreguntaEvaluacion(connexion,subpreguntaevaluacion));
		PreguntaEvaluacionLogic preguntaevaluacionLogic= new PreguntaEvaluacionLogic(connexion);
		preguntaevaluacionLogic.deepLoad(subpreguntaevaluacion.getPreguntaEvaluacion(),isDeep,deepLoadType,clases);
				
		subpreguntaevaluacion.setEjercicio(subpreguntaevaluacionDataAccess.getEjercicio(connexion,subpreguntaevaluacion));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(subpreguntaevaluacion.getEjercicio(),isDeep,deepLoadType,clases);
				
		subpreguntaevaluacion.setPeriodo(subpreguntaevaluacionDataAccess.getPeriodo(connexion,subpreguntaevaluacion));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(subpreguntaevaluacion.getPeriodo(),isDeep,deepLoadType,clases);
				

		subpreguntaevaluacion.setDetalleEvaluacionProveedors(subpreguntaevaluacionDataAccess.getDetalleEvaluacionProveedors(connexion,subpreguntaevaluacion));

		for(DetalleEvaluacionProveedor detalleevaluacionproveedor:subpreguntaevaluacion.getDetalleEvaluacionProveedors()) {
			DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic= new DetalleEvaluacionProveedorLogic(connexion);
			detalleevaluacionproveedorLogic.deepLoad(detalleevaluacionproveedor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				subpreguntaevaluacion.setEmpresa(subpreguntaevaluacionDataAccess.getEmpresa(connexion,subpreguntaevaluacion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(subpreguntaevaluacion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				subpreguntaevaluacion.setSucursal(subpreguntaevaluacionDataAccess.getSucursal(connexion,subpreguntaevaluacion));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(subpreguntaevaluacion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PreguntaEvaluacion.class)) {
				subpreguntaevaluacion.setPreguntaEvaluacion(subpreguntaevaluacionDataAccess.getPreguntaEvaluacion(connexion,subpreguntaevaluacion));
				PreguntaEvaluacionLogic preguntaevaluacionLogic= new PreguntaEvaluacionLogic(connexion);
				preguntaevaluacionLogic.deepLoad(subpreguntaevaluacion.getPreguntaEvaluacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				subpreguntaevaluacion.setEjercicio(subpreguntaevaluacionDataAccess.getEjercicio(connexion,subpreguntaevaluacion));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(subpreguntaevaluacion.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				subpreguntaevaluacion.setPeriodo(subpreguntaevaluacionDataAccess.getPeriodo(connexion,subpreguntaevaluacion));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(subpreguntaevaluacion.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleEvaluacionProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				subpreguntaevaluacion.setDetalleEvaluacionProveedors(subpreguntaevaluacionDataAccess.getDetalleEvaluacionProveedors(connexion,subpreguntaevaluacion));

				for(DetalleEvaluacionProveedor detalleevaluacionproveedor:subpreguntaevaluacion.getDetalleEvaluacionProveedors()) {
					DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic= new DetalleEvaluacionProveedorLogic(connexion);
					detalleevaluacionproveedorLogic.deepLoad(detalleevaluacionproveedor,isDeep,deepLoadType,clases);
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
			subpreguntaevaluacion.setEmpresa(subpreguntaevaluacionDataAccess.getEmpresa(connexion,subpreguntaevaluacion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(subpreguntaevaluacion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subpreguntaevaluacion.setSucursal(subpreguntaevaluacionDataAccess.getSucursal(connexion,subpreguntaevaluacion));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(subpreguntaevaluacion.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PreguntaEvaluacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subpreguntaevaluacion.setPreguntaEvaluacion(subpreguntaevaluacionDataAccess.getPreguntaEvaluacion(connexion,subpreguntaevaluacion));
			PreguntaEvaluacionLogic preguntaevaluacionLogic= new PreguntaEvaluacionLogic(connexion);
			preguntaevaluacionLogic.deepLoad(subpreguntaevaluacion.getPreguntaEvaluacion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subpreguntaevaluacion.setEjercicio(subpreguntaevaluacionDataAccess.getEjercicio(connexion,subpreguntaevaluacion));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(subpreguntaevaluacion.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			subpreguntaevaluacion.setPeriodo(subpreguntaevaluacionDataAccess.getPeriodo(connexion,subpreguntaevaluacion));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(subpreguntaevaluacion.getPeriodo(),isDeep,deepLoadType,clases);
				
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
			subpreguntaevaluacion.setDetalleEvaluacionProveedors(subpreguntaevaluacionDataAccess.getDetalleEvaluacionProveedors(connexion,subpreguntaevaluacion));

			for(DetalleEvaluacionProveedor detalleevaluacionproveedor:subpreguntaevaluacion.getDetalleEvaluacionProveedors()) {
				DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic= new DetalleEvaluacionProveedorLogic(connexion);
				detalleevaluacionproveedorLogic.deepLoad(detalleevaluacionproveedor,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(SubPreguntaEvaluacion subpreguntaevaluacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			SubPreguntaEvaluacionLogicAdditional.updateSubPreguntaEvaluacionToSave(subpreguntaevaluacion,this.arrDatoGeneral);
			
SubPreguntaEvaluacionDataAccess.save(subpreguntaevaluacion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(subpreguntaevaluacion.getEmpresa(),connexion);

		SucursalDataAccess.save(subpreguntaevaluacion.getSucursal(),connexion);

		PreguntaEvaluacionDataAccess.save(subpreguntaevaluacion.getPreguntaEvaluacion(),connexion);

		EjercicioDataAccess.save(subpreguntaevaluacion.getEjercicio(),connexion);

		PeriodoDataAccess.save(subpreguntaevaluacion.getPeriodo(),connexion);

		for(DetalleEvaluacionProveedor detalleevaluacionproveedor:subpreguntaevaluacion.getDetalleEvaluacionProveedors()) {
			detalleevaluacionproveedor.setid_sub_pregunta_evaluacion(subpreguntaevaluacion.getId());
			DetalleEvaluacionProveedorDataAccess.save(detalleevaluacionproveedor,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(subpreguntaevaluacion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(subpreguntaevaluacion.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(PreguntaEvaluacion.class)) {
				PreguntaEvaluacionDataAccess.save(subpreguntaevaluacion.getPreguntaEvaluacion(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(subpreguntaevaluacion.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(subpreguntaevaluacion.getPeriodo(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleEvaluacionProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleEvaluacionProveedor detalleevaluacionproveedor:subpreguntaevaluacion.getDetalleEvaluacionProveedors()) {
					detalleevaluacionproveedor.setid_sub_pregunta_evaluacion(subpreguntaevaluacion.getId());
					DetalleEvaluacionProveedorDataAccess.save(detalleevaluacionproveedor,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(subpreguntaevaluacion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(subpreguntaevaluacion.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(subpreguntaevaluacion.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(subpreguntaevaluacion.getSucursal(),isDeep,deepLoadType,clases);
				

		PreguntaEvaluacionDataAccess.save(subpreguntaevaluacion.getPreguntaEvaluacion(),connexion);
		PreguntaEvaluacionLogic preguntaevaluacionLogic= new PreguntaEvaluacionLogic(connexion);
		preguntaevaluacionLogic.deepLoad(subpreguntaevaluacion.getPreguntaEvaluacion(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(subpreguntaevaluacion.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(subpreguntaevaluacion.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(subpreguntaevaluacion.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(subpreguntaevaluacion.getPeriodo(),isDeep,deepLoadType,clases);
				

		for(DetalleEvaluacionProveedor detalleevaluacionproveedor:subpreguntaevaluacion.getDetalleEvaluacionProveedors()) {
			DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic= new DetalleEvaluacionProveedorLogic(connexion);
			detalleevaluacionproveedor.setid_sub_pregunta_evaluacion(subpreguntaevaluacion.getId());
			DetalleEvaluacionProveedorDataAccess.save(detalleevaluacionproveedor,connexion);
			detalleevaluacionproveedorLogic.deepSave(detalleevaluacionproveedor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(subpreguntaevaluacion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(subpreguntaevaluacion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(subpreguntaevaluacion.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(subpreguntaevaluacion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PreguntaEvaluacion.class)) {
				PreguntaEvaluacionDataAccess.save(subpreguntaevaluacion.getPreguntaEvaluacion(),connexion);
				PreguntaEvaluacionLogic preguntaevaluacionLogic= new PreguntaEvaluacionLogic(connexion);
				preguntaevaluacionLogic.deepSave(subpreguntaevaluacion.getPreguntaEvaluacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(subpreguntaevaluacion.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(subpreguntaevaluacion.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(subpreguntaevaluacion.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(subpreguntaevaluacion.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleEvaluacionProveedor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleEvaluacionProveedor detalleevaluacionproveedor:subpreguntaevaluacion.getDetalleEvaluacionProveedors()) {
					DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic= new DetalleEvaluacionProveedorLogic(connexion);
					detalleevaluacionproveedor.setid_sub_pregunta_evaluacion(subpreguntaevaluacion.getId());
					DetalleEvaluacionProveedorDataAccess.save(detalleevaluacionproveedor,connexion);
					detalleevaluacionproveedorLogic.deepSave(detalleevaluacionproveedor,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(SubPreguntaEvaluacion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(subpreguntaevaluacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(subpreguntaevaluacion);
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
			this.deepLoad(this.subpreguntaevaluacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(SubPreguntaEvaluacion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(subpreguntaevaluacions!=null) {
				for(SubPreguntaEvaluacion subpreguntaevaluacion:subpreguntaevaluacions) {
					this.deepLoad(subpreguntaevaluacion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(subpreguntaevaluacions);
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
			if(subpreguntaevaluacions!=null) {
				for(SubPreguntaEvaluacion subpreguntaevaluacion:subpreguntaevaluacions) {
					this.deepLoad(subpreguntaevaluacion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(subpreguntaevaluacions);
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
			this.getNewConnexionToDeep(SubPreguntaEvaluacion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(subpreguntaevaluacion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(SubPreguntaEvaluacion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(subpreguntaevaluacions!=null) {
				for(SubPreguntaEvaluacion subpreguntaevaluacion:subpreguntaevaluacions) {
					this.deepSave(subpreguntaevaluacion,isDeep,deepLoadType,clases);
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
			if(subpreguntaevaluacions!=null) {
				for(SubPreguntaEvaluacion subpreguntaevaluacion:subpreguntaevaluacions) {
					this.deepSave(subpreguntaevaluacion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getSubPreguntaEvaluacionsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,SubPreguntaEvaluacionConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subpreguntaevaluacions=subpreguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubPreguntaEvaluacionsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,SubPreguntaEvaluacionConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subpreguntaevaluacions=subpreguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubPreguntaEvaluacionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SubPreguntaEvaluacionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subpreguntaevaluacions=subpreguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubPreguntaEvaluacionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,SubPreguntaEvaluacionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subpreguntaevaluacions=subpreguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubPreguntaEvaluacionsFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,SubPreguntaEvaluacionConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subpreguntaevaluacions=subpreguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubPreguntaEvaluacionsFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,SubPreguntaEvaluacionConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subpreguntaevaluacions=subpreguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubPreguntaEvaluacionsFK_IdPreguntaEvaluacionWithConnection(String sFinalQuery,Pagination pagination,Long id_pregunta_evaluacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPreguntaEvaluacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPreguntaEvaluacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pregunta_evaluacion,SubPreguntaEvaluacionConstantesFunciones.IDPREGUNTAEVALUACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPreguntaEvaluacion);

			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPreguntaEvaluacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subpreguntaevaluacions=subpreguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubPreguntaEvaluacionsFK_IdPreguntaEvaluacion(String sFinalQuery,Pagination pagination,Long id_pregunta_evaluacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPreguntaEvaluacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPreguntaEvaluacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pregunta_evaluacion,SubPreguntaEvaluacionConstantesFunciones.IDPREGUNTAEVALUACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPreguntaEvaluacion);

			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPreguntaEvaluacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subpreguntaevaluacions=subpreguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSubPreguntaEvaluacionsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,SubPreguntaEvaluacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,SubPreguntaEvaluacionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subpreguntaevaluacions=subpreguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSubPreguntaEvaluacionsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,SubPreguntaEvaluacionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			SubPreguntaEvaluacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			subpreguntaevaluacions=subpreguntaevaluacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SubPreguntaEvaluacionConstantesFunciones.refrescarForeignKeysDescripcionesSubPreguntaEvaluacion(this.subpreguntaevaluacions);
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
			if(SubPreguntaEvaluacionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,SubPreguntaEvaluacionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,SubPreguntaEvaluacion subpreguntaevaluacion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(SubPreguntaEvaluacionConstantesFunciones.ISCONAUDITORIA) {
				if(subpreguntaevaluacion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SubPreguntaEvaluacionDataAccess.TABLENAME, subpreguntaevaluacion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SubPreguntaEvaluacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SubPreguntaEvaluacionLogic.registrarAuditoriaDetallesSubPreguntaEvaluacion(connexion,subpreguntaevaluacion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(subpreguntaevaluacion.getIsDeleted()) {
					/*if(!subpreguntaevaluacion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,SubPreguntaEvaluacionDataAccess.TABLENAME, subpreguntaevaluacion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////SubPreguntaEvaluacionLogic.registrarAuditoriaDetallesSubPreguntaEvaluacion(connexion,subpreguntaevaluacion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SubPreguntaEvaluacionDataAccess.TABLENAME, subpreguntaevaluacion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(subpreguntaevaluacion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SubPreguntaEvaluacionDataAccess.TABLENAME, subpreguntaevaluacion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SubPreguntaEvaluacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////SubPreguntaEvaluacionLogic.registrarAuditoriaDetallesSubPreguntaEvaluacion(connexion,subpreguntaevaluacion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesSubPreguntaEvaluacion(Connexion connexion,SubPreguntaEvaluacion subpreguntaevaluacion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(subpreguntaevaluacion.getIsNew()||!subpreguntaevaluacion.getid_empresa().equals(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getid_empresa()!=null)
				{
					strValorActual=subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getid_empresa().toString();
				}
				if(subpreguntaevaluacion.getid_empresa()!=null)
				{
					strValorNuevo=subpreguntaevaluacion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubPreguntaEvaluacionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(subpreguntaevaluacion.getIsNew()||!subpreguntaevaluacion.getid_sucursal().equals(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getid_sucursal()!=null)
				{
					strValorActual=subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getid_sucursal().toString();
				}
				if(subpreguntaevaluacion.getid_sucursal()!=null)
				{
					strValorNuevo=subpreguntaevaluacion.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubPreguntaEvaluacionConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(subpreguntaevaluacion.getIsNew()||!subpreguntaevaluacion.getid_pregunta_evaluacion().equals(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getid_pregunta_evaluacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getid_pregunta_evaluacion()!=null)
				{
					strValorActual=subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getid_pregunta_evaluacion().toString();
				}
				if(subpreguntaevaluacion.getid_pregunta_evaluacion()!=null)
				{
					strValorNuevo=subpreguntaevaluacion.getid_pregunta_evaluacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubPreguntaEvaluacionConstantesFunciones.IDPREGUNTAEVALUACION,strValorActual,strValorNuevo);
			}	
			
			if(subpreguntaevaluacion.getIsNew()||!subpreguntaevaluacion.getid_ejercicio().equals(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getid_ejercicio()!=null)
				{
					strValorActual=subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getid_ejercicio().toString();
				}
				if(subpreguntaevaluacion.getid_ejercicio()!=null)
				{
					strValorNuevo=subpreguntaevaluacion.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubPreguntaEvaluacionConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(subpreguntaevaluacion.getIsNew()||!subpreguntaevaluacion.getid_periodo().equals(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getid_periodo()!=null)
				{
					strValorActual=subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getid_periodo().toString();
				}
				if(subpreguntaevaluacion.getid_periodo()!=null)
				{
					strValorNuevo=subpreguntaevaluacion.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubPreguntaEvaluacionConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(subpreguntaevaluacion.getIsNew()||!subpreguntaevaluacion.getorden().equals(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getorden()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getorden()!=null)
				{
					strValorActual=subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getorden().toString();
				}
				if(subpreguntaevaluacion.getorden()!=null)
				{
					strValorNuevo=subpreguntaevaluacion.getorden().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubPreguntaEvaluacionConstantesFunciones.ORDEN,strValorActual,strValorNuevo);
			}	
			
			if(subpreguntaevaluacion.getIsNew()||!subpreguntaevaluacion.getpregunta().equals(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getpregunta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getpregunta()!=null)
				{
					strValorActual=subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getpregunta();
				}
				if(subpreguntaevaluacion.getpregunta()!=null)
				{
					strValorNuevo=subpreguntaevaluacion.getpregunta() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubPreguntaEvaluacionConstantesFunciones.PREGUNTA,strValorActual,strValorNuevo);
			}	
			
			if(subpreguntaevaluacion.getIsNew()||!subpreguntaevaluacion.getporcentaje_si().equals(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getporcentaje_si()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getporcentaje_si()!=null)
				{
					strValorActual=subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getporcentaje_si().toString();
				}
				if(subpreguntaevaluacion.getporcentaje_si()!=null)
				{
					strValorNuevo=subpreguntaevaluacion.getporcentaje_si().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubPreguntaEvaluacionConstantesFunciones.PORCENTAJESI,strValorActual,strValorNuevo);
			}	
			
			if(subpreguntaevaluacion.getIsNew()||!subpreguntaevaluacion.getcon_factura().equals(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getcon_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getcon_factura()!=null)
				{
					strValorActual=subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getcon_factura().toString();
				}
				if(subpreguntaevaluacion.getcon_factura()!=null)
				{
					strValorNuevo=subpreguntaevaluacion.getcon_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubPreguntaEvaluacionConstantesFunciones.CONFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(subpreguntaevaluacion.getIsNew()||!subpreguntaevaluacion.getcon_orden_compra().equals(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getcon_orden_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getcon_orden_compra()!=null)
				{
					strValorActual=subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getcon_orden_compra().toString();
				}
				if(subpreguntaevaluacion.getcon_orden_compra()!=null)
				{
					strValorNuevo=subpreguntaevaluacion.getcon_orden_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubPreguntaEvaluacionConstantesFunciones.CONORDENCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(subpreguntaevaluacion.getIsNew()||!subpreguntaevaluacion.getcon_completo().equals(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getcon_completo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getcon_completo()!=null)
				{
					strValorActual=subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getcon_completo().toString();
				}
				if(subpreguntaevaluacion.getcon_completo()!=null)
				{
					strValorNuevo=subpreguntaevaluacion.getcon_completo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubPreguntaEvaluacionConstantesFunciones.CONCOMPLETO,strValorActual,strValorNuevo);
			}	
			
			if(subpreguntaevaluacion.getIsNew()||!subpreguntaevaluacion.getcon_a_tiempo().equals(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getcon_a_tiempo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getcon_a_tiempo()!=null)
				{
					strValorActual=subpreguntaevaluacion.getSubPreguntaEvaluacionOriginal().getcon_a_tiempo().toString();
				}
				if(subpreguntaevaluacion.getcon_a_tiempo()!=null)
				{
					strValorNuevo=subpreguntaevaluacion.getcon_a_tiempo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SubPreguntaEvaluacionConstantesFunciones.CONATIEMPO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveSubPreguntaEvaluacionRelacionesWithConnection(SubPreguntaEvaluacion subpreguntaevaluacion,List<DetalleEvaluacionProveedor> detalleevaluacionproveedors) throws Exception {

		if(!subpreguntaevaluacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSubPreguntaEvaluacionRelacionesBase(subpreguntaevaluacion,detalleevaluacionproveedors,true);
		}
	}

	public void saveSubPreguntaEvaluacionRelaciones(SubPreguntaEvaluacion subpreguntaevaluacion,List<DetalleEvaluacionProveedor> detalleevaluacionproveedors)throws Exception {

		if(!subpreguntaevaluacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSubPreguntaEvaluacionRelacionesBase(subpreguntaevaluacion,detalleevaluacionproveedors,false);
		}
	}

	public void saveSubPreguntaEvaluacionRelacionesBase(SubPreguntaEvaluacion subpreguntaevaluacion,List<DetalleEvaluacionProveedor> detalleevaluacionproveedors,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("SubPreguntaEvaluacion-saveRelacionesWithConnection");}
	
			subpreguntaevaluacion.setDetalleEvaluacionProveedors(detalleevaluacionproveedors);

			this.setSubPreguntaEvaluacion(subpreguntaevaluacion);

			if(SubPreguntaEvaluacionLogicAdditional.validarSaveRelaciones(subpreguntaevaluacion,this)) {

				SubPreguntaEvaluacionLogicAdditional.updateRelacionesToSave(subpreguntaevaluacion,this);

				if((subpreguntaevaluacion.getIsNew()||subpreguntaevaluacion.getIsChanged())&&!subpreguntaevaluacion.getIsDeleted()) {
					this.saveSubPreguntaEvaluacion();
					this.saveSubPreguntaEvaluacionRelacionesDetalles(detalleevaluacionproveedors);

				} else if(subpreguntaevaluacion.getIsDeleted()) {
					this.saveSubPreguntaEvaluacionRelacionesDetalles(detalleevaluacionproveedors);
					this.saveSubPreguntaEvaluacion();
				}

				SubPreguntaEvaluacionLogicAdditional.updateRelacionesToSaveAfter(subpreguntaevaluacion,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleEvaluacionProveedorConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleEvaluacionProveedors(detalleevaluacionproveedors,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveSubPreguntaEvaluacionRelacionesDetalles(List<DetalleEvaluacionProveedor> detalleevaluacionproveedors)throws Exception {
		try {
	

			Long idSubPreguntaEvaluacionActual=this.getSubPreguntaEvaluacion().getId();

			DetalleEvaluacionProveedorLogic detalleevaluacionproveedorLogic_Desde_SubPreguntaEvaluacion=new DetalleEvaluacionProveedorLogic();
			detalleevaluacionproveedorLogic_Desde_SubPreguntaEvaluacion.setDetalleEvaluacionProveedors(detalleevaluacionproveedors);

			detalleevaluacionproveedorLogic_Desde_SubPreguntaEvaluacion.setConnexion(this.getConnexion());
			detalleevaluacionproveedorLogic_Desde_SubPreguntaEvaluacion.setDatosCliente(this.datosCliente);

			for(DetalleEvaluacionProveedor detalleevaluacionproveedor_Desde_SubPreguntaEvaluacion:detalleevaluacionproveedorLogic_Desde_SubPreguntaEvaluacion.getDetalleEvaluacionProveedors()) {
				detalleevaluacionproveedor_Desde_SubPreguntaEvaluacion.setid_sub_pregunta_evaluacion(idSubPreguntaEvaluacionActual);
			}

			detalleevaluacionproveedorLogic_Desde_SubPreguntaEvaluacion.saveDetalleEvaluacionProveedors();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfSubPreguntaEvaluacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SubPreguntaEvaluacionConstantesFunciones.getClassesForeignKeysOfSubPreguntaEvaluacion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSubPreguntaEvaluacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SubPreguntaEvaluacionConstantesFunciones.getClassesRelationshipsOfSubPreguntaEvaluacion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

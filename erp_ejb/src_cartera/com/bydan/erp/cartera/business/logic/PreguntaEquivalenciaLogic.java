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
import com.bydan.erp.cartera.util.PreguntaEquivalenciaConstantesFunciones;
import com.bydan.erp.cartera.util.PreguntaEquivalenciaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.PreguntaEquivalenciaParameterGeneral;
import com.bydan.erp.cartera.business.entity.PreguntaEquivalencia;
import com.bydan.erp.cartera.business.logic.PreguntaEquivalenciaLogicAdditional;
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
public class PreguntaEquivalenciaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PreguntaEquivalenciaLogic.class);
	
	protected PreguntaEquivalenciaDataAccess preguntaequivalenciaDataAccess; 	
	protected PreguntaEquivalencia preguntaequivalencia;
	protected List<PreguntaEquivalencia> preguntaequivalencias;
	protected Object preguntaequivalenciaObject;	
	protected List<Object> preguntaequivalenciasObject;
	
	public static ClassValidator<PreguntaEquivalencia> preguntaequivalenciaValidator = new ClassValidator<PreguntaEquivalencia>(PreguntaEquivalencia.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PreguntaEquivalenciaLogicAdditional preguntaequivalenciaLogicAdditional=null;
	
	public PreguntaEquivalenciaLogicAdditional getPreguntaEquivalenciaLogicAdditional() {
		return this.preguntaequivalenciaLogicAdditional;
	}
	
	public void setPreguntaEquivalenciaLogicAdditional(PreguntaEquivalenciaLogicAdditional preguntaequivalenciaLogicAdditional) {
		try {
			this.preguntaequivalenciaLogicAdditional=preguntaequivalenciaLogicAdditional;
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
	
	
	
	
	public  PreguntaEquivalenciaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.preguntaequivalenciaDataAccess = new PreguntaEquivalenciaDataAccess();
			
			this.preguntaequivalencias= new ArrayList<PreguntaEquivalencia>();
			this.preguntaequivalencia= new PreguntaEquivalencia();
			
			this.preguntaequivalenciaObject=new Object();
			this.preguntaequivalenciasObject=new ArrayList<Object>();
				
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
			
			this.preguntaequivalenciaDataAccess.setConnexionType(this.connexionType);
			this.preguntaequivalenciaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PreguntaEquivalenciaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.preguntaequivalenciaDataAccess = new PreguntaEquivalenciaDataAccess();
			this.preguntaequivalencias= new ArrayList<PreguntaEquivalencia>();
			this.preguntaequivalencia= new PreguntaEquivalencia();
			this.preguntaequivalenciaObject=new Object();
			this.preguntaequivalenciasObject=new ArrayList<Object>();
			
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
			
			this.preguntaequivalenciaDataAccess.setConnexionType(this.connexionType);
			this.preguntaequivalenciaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PreguntaEquivalencia getPreguntaEquivalencia() throws Exception {	
		PreguntaEquivalenciaLogicAdditional.checkPreguntaEquivalenciaToGet(preguntaequivalencia,this.datosCliente,this.arrDatoGeneral);
		PreguntaEquivalenciaLogicAdditional.updatePreguntaEquivalenciaToGet(preguntaequivalencia,this.arrDatoGeneral);
		
		return preguntaequivalencia;
	}
		
	public void setPreguntaEquivalencia(PreguntaEquivalencia newPreguntaEquivalencia) {
		this.preguntaequivalencia = newPreguntaEquivalencia;
	}
	
	public PreguntaEquivalenciaDataAccess getPreguntaEquivalenciaDataAccess() {
		return preguntaequivalenciaDataAccess;
	}
	
	public void setPreguntaEquivalenciaDataAccess(PreguntaEquivalenciaDataAccess newpreguntaequivalenciaDataAccess) {
		this.preguntaequivalenciaDataAccess = newpreguntaequivalenciaDataAccess;
	}
	
	public List<PreguntaEquivalencia> getPreguntaEquivalencias() throws Exception {		
		this.quitarPreguntaEquivalenciasNulos();
		
		PreguntaEquivalenciaLogicAdditional.checkPreguntaEquivalenciaToGets(preguntaequivalencias,this.datosCliente,this.arrDatoGeneral);
		
		for (PreguntaEquivalencia preguntaequivalenciaLocal: preguntaequivalencias ) {
			PreguntaEquivalenciaLogicAdditional.updatePreguntaEquivalenciaToGet(preguntaequivalenciaLocal,this.arrDatoGeneral);
		}
		
		return preguntaequivalencias;
	}
	
	public void setPreguntaEquivalencias(List<PreguntaEquivalencia> newPreguntaEquivalencias) {
		this.preguntaequivalencias = newPreguntaEquivalencias;
	}
	
	public Object getPreguntaEquivalenciaObject() {	
		this.preguntaequivalenciaObject=this.preguntaequivalenciaDataAccess.getEntityObject();
		return this.preguntaequivalenciaObject;
	}
		
	public void setPreguntaEquivalenciaObject(Object newPreguntaEquivalenciaObject) {
		this.preguntaequivalenciaObject = newPreguntaEquivalenciaObject;
	}
	
	public List<Object> getPreguntaEquivalenciasObject() {		
		this.preguntaequivalenciasObject=this.preguntaequivalenciaDataAccess.getEntitiesObject();
		return this.preguntaequivalenciasObject;
	}
		
	public void setPreguntaEquivalenciasObject(List<Object> newPreguntaEquivalenciasObject) {
		this.preguntaequivalenciasObject = newPreguntaEquivalenciasObject;
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
		
		if(this.preguntaequivalenciaDataAccess!=null) {
			this.preguntaequivalenciaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			preguntaequivalenciaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			preguntaequivalenciaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		preguntaequivalencia = new  PreguntaEquivalencia();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			preguntaequivalencia=preguntaequivalenciaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.preguntaequivalencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencia);
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
		preguntaequivalencia = new  PreguntaEquivalencia();
		  		  
        try {
			
			preguntaequivalencia=preguntaequivalenciaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.preguntaequivalencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		preguntaequivalencia = new  PreguntaEquivalencia();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			preguntaequivalencia=preguntaequivalenciaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.preguntaequivalencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencia);
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
		preguntaequivalencia = new  PreguntaEquivalencia();
		  		  
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
		preguntaequivalencia = new  PreguntaEquivalencia();
		  		  
        try {
			
			preguntaequivalencia=preguntaequivalenciaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.preguntaequivalencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		preguntaequivalencia = new  PreguntaEquivalencia();
		  		  
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
		preguntaequivalencia = new  PreguntaEquivalencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =preguntaequivalenciaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		preguntaequivalencia = new  PreguntaEquivalencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=preguntaequivalenciaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		preguntaequivalencia = new  PreguntaEquivalencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =preguntaequivalenciaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		preguntaequivalencia = new  PreguntaEquivalencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=preguntaequivalenciaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		preguntaequivalencia = new  PreguntaEquivalencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =preguntaequivalenciaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		preguntaequivalencia = new  PreguntaEquivalencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=preguntaequivalenciaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		preguntaequivalencias = new  ArrayList<PreguntaEquivalencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPreguntaEquivalencia(preguntaequivalencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
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
		preguntaequivalencias = new  ArrayList<PreguntaEquivalencia>();
		  		  
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
		preguntaequivalencias = new  ArrayList<PreguntaEquivalencia>();
		  		  
        try {			
			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPreguntaEquivalencia(preguntaequivalencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		preguntaequivalencias = new  ArrayList<PreguntaEquivalencia>();
		  		  
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
		preguntaequivalencias = new  ArrayList<PreguntaEquivalencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPreguntaEquivalencia(preguntaequivalencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
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
		preguntaequivalencias = new  ArrayList<PreguntaEquivalencia>();
		  		  
        try {
			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPreguntaEquivalencia(preguntaequivalencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
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
		preguntaequivalencias = new  ArrayList<PreguntaEquivalencia>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPreguntaEquivalencia(preguntaequivalencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
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
		preguntaequivalencias = new  ArrayList<PreguntaEquivalencia>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPreguntaEquivalencia(preguntaequivalencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		preguntaequivalencia = new  PreguntaEquivalencia();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaequivalencia=preguntaequivalenciaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPreguntaEquivalencia(preguntaequivalencia);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencia);
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
		preguntaequivalencia = new  PreguntaEquivalencia();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaequivalencia=preguntaequivalenciaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPreguntaEquivalencia(preguntaequivalencia);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		preguntaequivalencias = new  ArrayList<PreguntaEquivalencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPreguntaEquivalencia(preguntaequivalencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
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
		preguntaequivalencias = new  ArrayList<PreguntaEquivalencia>();
		  		  
        try {
			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPreguntaEquivalencia(preguntaequivalencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPreguntaEquivalenciasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		preguntaequivalencias = new  ArrayList<PreguntaEquivalencia>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-getTodosPreguntaEquivalenciasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPreguntaEquivalencia(preguntaequivalencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
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
	
	public  void  getTodosPreguntaEquivalencias(String sFinalQuery,Pagination pagination)throws Exception {
		preguntaequivalencias = new  ArrayList<PreguntaEquivalencia>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPreguntaEquivalencia(preguntaequivalencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPreguntaEquivalencia(PreguntaEquivalencia preguntaequivalencia) throws Exception {
		Boolean estaValidado=false;
		
		if(preguntaequivalencia.getIsNew() || preguntaequivalencia.getIsChanged()) { 
			this.invalidValues = preguntaequivalenciaValidator.getInvalidValues(preguntaequivalencia);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(preguntaequivalencia);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPreguntaEquivalencia(List<PreguntaEquivalencia> PreguntaEquivalencias) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PreguntaEquivalencia preguntaequivalenciaLocal:preguntaequivalencias) {				
			estaValidadoObjeto=this.validarGuardarPreguntaEquivalencia(preguntaequivalenciaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPreguntaEquivalencia(List<PreguntaEquivalencia> PreguntaEquivalencias) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPreguntaEquivalencia(preguntaequivalencias)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPreguntaEquivalencia(PreguntaEquivalencia PreguntaEquivalencia) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPreguntaEquivalencia(preguntaequivalencia)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PreguntaEquivalencia preguntaequivalencia) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+preguntaequivalencia.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PreguntaEquivalenciaConstantesFunciones.getPreguntaEquivalenciaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"preguntaequivalencia","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PreguntaEquivalenciaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PreguntaEquivalenciaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePreguntaEquivalenciaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-savePreguntaEquivalenciaWithConnection");connexion.begin();			
			
			PreguntaEquivalenciaLogicAdditional.checkPreguntaEquivalenciaToSave(this.preguntaequivalencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PreguntaEquivalenciaLogicAdditional.updatePreguntaEquivalenciaToSave(this.preguntaequivalencia,this.arrDatoGeneral);
			
			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.preguntaequivalencia,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPreguntaEquivalencia();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPreguntaEquivalencia(this.preguntaequivalencia)) {
				PreguntaEquivalenciaDataAccess.save(this.preguntaequivalencia, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.preguntaequivalencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PreguntaEquivalenciaLogicAdditional.checkPreguntaEquivalenciaToSaveAfter(this.preguntaequivalencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPreguntaEquivalencia();
			
			connexion.commit();			
			
			if(this.preguntaequivalencia.getIsDeleted()) {
				this.preguntaequivalencia=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePreguntaEquivalencia()throws Exception {	
		try {	
			
			PreguntaEquivalenciaLogicAdditional.checkPreguntaEquivalenciaToSave(this.preguntaequivalencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PreguntaEquivalenciaLogicAdditional.updatePreguntaEquivalenciaToSave(this.preguntaequivalencia,this.arrDatoGeneral);
			
			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.preguntaequivalencia,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPreguntaEquivalencia(this.preguntaequivalencia)) {			
				PreguntaEquivalenciaDataAccess.save(this.preguntaequivalencia, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.preguntaequivalencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PreguntaEquivalenciaLogicAdditional.checkPreguntaEquivalenciaToSaveAfter(this.preguntaequivalencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.preguntaequivalencia.getIsDeleted()) {
				this.preguntaequivalencia=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePreguntaEquivalenciasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-savePreguntaEquivalenciasWithConnection");connexion.begin();			
			
			PreguntaEquivalenciaLogicAdditional.checkPreguntaEquivalenciaToSaves(preguntaequivalencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPreguntaEquivalencias();
			
			Boolean validadoTodosPreguntaEquivalencia=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PreguntaEquivalencia preguntaequivalenciaLocal:preguntaequivalencias) {		
				if(preguntaequivalenciaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PreguntaEquivalenciaLogicAdditional.updatePreguntaEquivalenciaToSave(preguntaequivalenciaLocal,this.arrDatoGeneral);
	        	
				PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),preguntaequivalenciaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPreguntaEquivalencia(preguntaequivalenciaLocal)) {
					PreguntaEquivalenciaDataAccess.save(preguntaequivalenciaLocal, connexion);				
				} else {
					validadoTodosPreguntaEquivalencia=false;
				}
			}
			
			if(!validadoTodosPreguntaEquivalencia) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PreguntaEquivalenciaLogicAdditional.checkPreguntaEquivalenciaToSavesAfter(preguntaequivalencias,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPreguntaEquivalencias();
			
			connexion.commit();		
			
			this.quitarPreguntaEquivalenciasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePreguntaEquivalencias()throws Exception {				
		 try {	
			PreguntaEquivalenciaLogicAdditional.checkPreguntaEquivalenciaToSaves(preguntaequivalencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPreguntaEquivalencia=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PreguntaEquivalencia preguntaequivalenciaLocal:preguntaequivalencias) {				
				if(preguntaequivalenciaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PreguntaEquivalenciaLogicAdditional.updatePreguntaEquivalenciaToSave(preguntaequivalenciaLocal,this.arrDatoGeneral);
	        	
				PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),preguntaequivalenciaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPreguntaEquivalencia(preguntaequivalenciaLocal)) {				
					PreguntaEquivalenciaDataAccess.save(preguntaequivalenciaLocal, connexion);				
				} else {
					validadoTodosPreguntaEquivalencia=false;
				}
			}
			
			if(!validadoTodosPreguntaEquivalencia) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PreguntaEquivalenciaLogicAdditional.checkPreguntaEquivalenciaToSavesAfter(preguntaequivalencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPreguntaEquivalenciasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PreguntaEquivalenciaParameterReturnGeneral procesarAccionPreguntaEquivalencias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PreguntaEquivalencia> preguntaequivalencias,PreguntaEquivalenciaParameterReturnGeneral preguntaequivalenciaParameterGeneral)throws Exception {
		 try {	
			PreguntaEquivalenciaParameterReturnGeneral preguntaequivalenciaReturnGeneral=new PreguntaEquivalenciaParameterReturnGeneral();
	
			PreguntaEquivalenciaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,preguntaequivalencias,preguntaequivalenciaParameterGeneral,preguntaequivalenciaReturnGeneral);
			
			return preguntaequivalenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PreguntaEquivalenciaParameterReturnGeneral procesarAccionPreguntaEquivalenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PreguntaEquivalencia> preguntaequivalencias,PreguntaEquivalenciaParameterReturnGeneral preguntaequivalenciaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-procesarAccionPreguntaEquivalenciasWithConnection");connexion.begin();			
			
			PreguntaEquivalenciaParameterReturnGeneral preguntaequivalenciaReturnGeneral=new PreguntaEquivalenciaParameterReturnGeneral();
	
			PreguntaEquivalenciaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,preguntaequivalencias,preguntaequivalenciaParameterGeneral,preguntaequivalenciaReturnGeneral);
			
			this.connexion.commit();
			
			return preguntaequivalenciaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PreguntaEquivalenciaParameterReturnGeneral procesarEventosPreguntaEquivalencias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PreguntaEquivalencia> preguntaequivalencias,PreguntaEquivalencia preguntaequivalencia,PreguntaEquivalenciaParameterReturnGeneral preguntaequivalenciaParameterGeneral,Boolean isEsNuevoPreguntaEquivalencia,ArrayList<Classe> clases)throws Exception {
		 try {	
			PreguntaEquivalenciaParameterReturnGeneral preguntaequivalenciaReturnGeneral=new PreguntaEquivalenciaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				preguntaequivalenciaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PreguntaEquivalenciaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,preguntaequivalencias,preguntaequivalencia,preguntaequivalenciaParameterGeneral,preguntaequivalenciaReturnGeneral,isEsNuevoPreguntaEquivalencia,clases);
			
			return preguntaequivalenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PreguntaEquivalenciaParameterReturnGeneral procesarEventosPreguntaEquivalenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PreguntaEquivalencia> preguntaequivalencias,PreguntaEquivalencia preguntaequivalencia,PreguntaEquivalenciaParameterReturnGeneral preguntaequivalenciaParameterGeneral,Boolean isEsNuevoPreguntaEquivalencia,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-procesarEventosPreguntaEquivalenciasWithConnection");connexion.begin();			
			
			PreguntaEquivalenciaParameterReturnGeneral preguntaequivalenciaReturnGeneral=new PreguntaEquivalenciaParameterReturnGeneral();
	
			preguntaequivalenciaReturnGeneral.setPreguntaEquivalencia(preguntaequivalencia);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				preguntaequivalenciaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PreguntaEquivalenciaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,preguntaequivalencias,preguntaequivalencia,preguntaequivalenciaParameterGeneral,preguntaequivalenciaReturnGeneral,isEsNuevoPreguntaEquivalencia,clases);
			
			this.connexion.commit();
			
			return preguntaequivalenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PreguntaEquivalenciaParameterReturnGeneral procesarImportacionPreguntaEquivalenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PreguntaEquivalenciaParameterReturnGeneral preguntaequivalenciaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-procesarImportacionPreguntaEquivalenciasWithConnection");connexion.begin();			
			
			PreguntaEquivalenciaParameterReturnGeneral preguntaequivalenciaReturnGeneral=new PreguntaEquivalenciaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.preguntaequivalencias=new ArrayList<PreguntaEquivalencia>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.preguntaequivalencia=new PreguntaEquivalencia();
				
				
				if(conColumnasBase) {this.preguntaequivalencia.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.preguntaequivalencia.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.preguntaequivalencia.setdescripcion(arrColumnas[iColumn++]);
				this.preguntaequivalencia.setdesde(Double.parseDouble(arrColumnas[iColumn++]));
				this.preguntaequivalencia.sethasta(Double.parseDouble(arrColumnas[iColumn++]));
				this.preguntaequivalencia.setorden(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.preguntaequivalencias.add(this.preguntaequivalencia);
			}
			
			this.savePreguntaEquivalencias();
			
			this.connexion.commit();
			
			preguntaequivalenciaReturnGeneral.setConRetornoEstaProcesado(true);
			preguntaequivalenciaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return preguntaequivalenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPreguntaEquivalenciasEliminados() throws Exception {				
		
		List<PreguntaEquivalencia> preguntaequivalenciasAux= new ArrayList<PreguntaEquivalencia>();
		
		for(PreguntaEquivalencia preguntaequivalencia:preguntaequivalencias) {
			if(!preguntaequivalencia.getIsDeleted()) {
				preguntaequivalenciasAux.add(preguntaequivalencia);
			}
		}
		
		preguntaequivalencias=preguntaequivalenciasAux;
	}
	
	public void quitarPreguntaEquivalenciasNulos() throws Exception {				
		
		List<PreguntaEquivalencia> preguntaequivalenciasAux= new ArrayList<PreguntaEquivalencia>();
		
		for(PreguntaEquivalencia preguntaequivalencia : this.preguntaequivalencias) {
			if(preguntaequivalencia==null) {
				preguntaequivalenciasAux.add(preguntaequivalencia);
			}
		}
		
		//this.preguntaequivalencias=preguntaequivalenciasAux;
		
		this.preguntaequivalencias.removeAll(preguntaequivalenciasAux);
	}
	
	public void getSetVersionRowPreguntaEquivalenciaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(preguntaequivalencia.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((preguntaequivalencia.getIsDeleted() || (preguntaequivalencia.getIsChanged()&&!preguntaequivalencia.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=preguntaequivalenciaDataAccess.getSetVersionRowPreguntaEquivalencia(connexion,preguntaequivalencia.getId());
				
				if(!preguntaequivalencia.getVersionRow().equals(timestamp)) {	
					preguntaequivalencia.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				preguntaequivalencia.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPreguntaEquivalencia()throws Exception {	
		
		if(preguntaequivalencia.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((preguntaequivalencia.getIsDeleted() || (preguntaequivalencia.getIsChanged()&&!preguntaequivalencia.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=preguntaequivalenciaDataAccess.getSetVersionRowPreguntaEquivalencia(connexion,preguntaequivalencia.getId());
			
			try {							
				if(!preguntaequivalencia.getVersionRow().equals(timestamp)) {	
					preguntaequivalencia.setVersionRow(timestamp);
				}
				
				preguntaequivalencia.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPreguntaEquivalenciasWithConnection()throws Exception {	
		if(preguntaequivalencias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PreguntaEquivalencia preguntaequivalenciaAux:preguntaequivalencias) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(preguntaequivalenciaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(preguntaequivalenciaAux.getIsDeleted() || (preguntaequivalenciaAux.getIsChanged()&&!preguntaequivalenciaAux.getIsNew())) {
						
						timestamp=preguntaequivalenciaDataAccess.getSetVersionRowPreguntaEquivalencia(connexion,preguntaequivalenciaAux.getId());
						
						if(!preguntaequivalencia.getVersionRow().equals(timestamp)) {	
							preguntaequivalenciaAux.setVersionRow(timestamp);
						}
								
						preguntaequivalenciaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPreguntaEquivalencias()throws Exception {	
		if(preguntaequivalencias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PreguntaEquivalencia preguntaequivalenciaAux:preguntaequivalencias) {
					if(preguntaequivalenciaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(preguntaequivalenciaAux.getIsDeleted() || (preguntaequivalenciaAux.getIsChanged()&&!preguntaequivalenciaAux.getIsNew())) {
						
						timestamp=preguntaequivalenciaDataAccess.getSetVersionRowPreguntaEquivalencia(connexion,preguntaequivalenciaAux.getId());
						
						if(!preguntaequivalenciaAux.getVersionRow().equals(timestamp)) {	
							preguntaequivalenciaAux.setVersionRow(timestamp);
						}
						
													
						preguntaequivalenciaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PreguntaEquivalenciaParameterReturnGeneral cargarCombosLoteForeignKeyPreguntaEquivalenciaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		PreguntaEquivalenciaParameterReturnGeneral  preguntaequivalenciaReturnGeneral =new PreguntaEquivalenciaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-cargarCombosLoteForeignKeyPreguntaEquivalenciaWithConnection");connexion.begin();
			
			preguntaequivalenciaReturnGeneral =new PreguntaEquivalenciaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			preguntaequivalenciaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			preguntaequivalenciaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			preguntaequivalenciaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			preguntaequivalenciaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			preguntaequivalenciaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			preguntaequivalenciaReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return preguntaequivalenciaReturnGeneral;
	}
	
	public PreguntaEquivalenciaParameterReturnGeneral cargarCombosLoteForeignKeyPreguntaEquivalencia(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		PreguntaEquivalenciaParameterReturnGeneral  preguntaequivalenciaReturnGeneral =new PreguntaEquivalenciaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			preguntaequivalenciaReturnGeneral =new PreguntaEquivalenciaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			preguntaequivalenciaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			preguntaequivalenciaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			preguntaequivalenciaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			preguntaequivalenciaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			preguntaequivalenciaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			preguntaequivalenciaReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return preguntaequivalenciaReturnGeneral;
	}
	
	
	public void deepLoad(PreguntaEquivalencia preguntaequivalencia,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PreguntaEquivalenciaLogicAdditional.updatePreguntaEquivalenciaToGet(preguntaequivalencia,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		preguntaequivalencia.setEmpresa(preguntaequivalenciaDataAccess.getEmpresa(connexion,preguntaequivalencia));
		preguntaequivalencia.setSucursal(preguntaequivalenciaDataAccess.getSucursal(connexion,preguntaequivalencia));
		preguntaequivalencia.setEjercicio(preguntaequivalenciaDataAccess.getEjercicio(connexion,preguntaequivalencia));
		preguntaequivalencia.setPeriodo(preguntaequivalenciaDataAccess.getPeriodo(connexion,preguntaequivalencia));
		preguntaequivalencia.setAnio(preguntaequivalenciaDataAccess.getAnio(connexion,preguntaequivalencia));
		preguntaequivalencia.setMes(preguntaequivalenciaDataAccess.getMes(connexion,preguntaequivalencia));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				preguntaequivalencia.setEmpresa(preguntaequivalenciaDataAccess.getEmpresa(connexion,preguntaequivalencia));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				preguntaequivalencia.setSucursal(preguntaequivalenciaDataAccess.getSucursal(connexion,preguntaequivalencia));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				preguntaequivalencia.setEjercicio(preguntaequivalenciaDataAccess.getEjercicio(connexion,preguntaequivalencia));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				preguntaequivalencia.setPeriodo(preguntaequivalenciaDataAccess.getPeriodo(connexion,preguntaequivalencia));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				preguntaequivalencia.setAnio(preguntaequivalenciaDataAccess.getAnio(connexion,preguntaequivalencia));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				preguntaequivalencia.setMes(preguntaequivalenciaDataAccess.getMes(connexion,preguntaequivalencia));
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
			preguntaequivalencia.setEmpresa(preguntaequivalenciaDataAccess.getEmpresa(connexion,preguntaequivalencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			preguntaequivalencia.setSucursal(preguntaequivalenciaDataAccess.getSucursal(connexion,preguntaequivalencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			preguntaequivalencia.setEjercicio(preguntaequivalenciaDataAccess.getEjercicio(connexion,preguntaequivalencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			preguntaequivalencia.setPeriodo(preguntaequivalenciaDataAccess.getPeriodo(connexion,preguntaequivalencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			preguntaequivalencia.setAnio(preguntaequivalenciaDataAccess.getAnio(connexion,preguntaequivalencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			preguntaequivalencia.setMes(preguntaequivalenciaDataAccess.getMes(connexion,preguntaequivalencia));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		preguntaequivalencia.setEmpresa(preguntaequivalenciaDataAccess.getEmpresa(connexion,preguntaequivalencia));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(preguntaequivalencia.getEmpresa(),isDeep,deepLoadType,clases);
				
		preguntaequivalencia.setSucursal(preguntaequivalenciaDataAccess.getSucursal(connexion,preguntaequivalencia));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(preguntaequivalencia.getSucursal(),isDeep,deepLoadType,clases);
				
		preguntaequivalencia.setEjercicio(preguntaequivalenciaDataAccess.getEjercicio(connexion,preguntaequivalencia));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(preguntaequivalencia.getEjercicio(),isDeep,deepLoadType,clases);
				
		preguntaequivalencia.setPeriodo(preguntaequivalenciaDataAccess.getPeriodo(connexion,preguntaequivalencia));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(preguntaequivalencia.getPeriodo(),isDeep,deepLoadType,clases);
				
		preguntaequivalencia.setAnio(preguntaequivalenciaDataAccess.getAnio(connexion,preguntaequivalencia));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(preguntaequivalencia.getAnio(),isDeep,deepLoadType,clases);
				
		preguntaequivalencia.setMes(preguntaequivalenciaDataAccess.getMes(connexion,preguntaequivalencia));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(preguntaequivalencia.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				preguntaequivalencia.setEmpresa(preguntaequivalenciaDataAccess.getEmpresa(connexion,preguntaequivalencia));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(preguntaequivalencia.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				preguntaequivalencia.setSucursal(preguntaequivalenciaDataAccess.getSucursal(connexion,preguntaequivalencia));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(preguntaequivalencia.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				preguntaequivalencia.setEjercicio(preguntaequivalenciaDataAccess.getEjercicio(connexion,preguntaequivalencia));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(preguntaequivalencia.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				preguntaequivalencia.setPeriodo(preguntaequivalenciaDataAccess.getPeriodo(connexion,preguntaequivalencia));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(preguntaequivalencia.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				preguntaequivalencia.setAnio(preguntaequivalenciaDataAccess.getAnio(connexion,preguntaequivalencia));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(preguntaequivalencia.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				preguntaequivalencia.setMes(preguntaequivalenciaDataAccess.getMes(connexion,preguntaequivalencia));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(preguntaequivalencia.getMes(),isDeep,deepLoadType,clases);				
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
			preguntaequivalencia.setEmpresa(preguntaequivalenciaDataAccess.getEmpresa(connexion,preguntaequivalencia));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(preguntaequivalencia.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			preguntaequivalencia.setSucursal(preguntaequivalenciaDataAccess.getSucursal(connexion,preguntaequivalencia));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(preguntaequivalencia.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			preguntaequivalencia.setEjercicio(preguntaequivalenciaDataAccess.getEjercicio(connexion,preguntaequivalencia));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(preguntaequivalencia.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			preguntaequivalencia.setPeriodo(preguntaequivalenciaDataAccess.getPeriodo(connexion,preguntaequivalencia));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(preguntaequivalencia.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			preguntaequivalencia.setAnio(preguntaequivalenciaDataAccess.getAnio(connexion,preguntaequivalencia));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(preguntaequivalencia.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			preguntaequivalencia.setMes(preguntaequivalenciaDataAccess.getMes(connexion,preguntaequivalencia));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(preguntaequivalencia.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PreguntaEquivalencia preguntaequivalencia,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PreguntaEquivalenciaLogicAdditional.updatePreguntaEquivalenciaToSave(preguntaequivalencia,this.arrDatoGeneral);
			
PreguntaEquivalenciaDataAccess.save(preguntaequivalencia, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(preguntaequivalencia.getEmpresa(),connexion);

		SucursalDataAccess.save(preguntaequivalencia.getSucursal(),connexion);

		EjercicioDataAccess.save(preguntaequivalencia.getEjercicio(),connexion);

		PeriodoDataAccess.save(preguntaequivalencia.getPeriodo(),connexion);

		AnioDataAccess.save(preguntaequivalencia.getAnio(),connexion);

		MesDataAccess.save(preguntaequivalencia.getMes(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(preguntaequivalencia.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(preguntaequivalencia.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(preguntaequivalencia.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(preguntaequivalencia.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(preguntaequivalencia.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(preguntaequivalencia.getMes(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(preguntaequivalencia.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(preguntaequivalencia.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(preguntaequivalencia.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(preguntaequivalencia.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(preguntaequivalencia.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(preguntaequivalencia.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(preguntaequivalencia.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(preguntaequivalencia.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(preguntaequivalencia.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(preguntaequivalencia.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(preguntaequivalencia.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(preguntaequivalencia.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(preguntaequivalencia.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(preguntaequivalencia.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(preguntaequivalencia.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(preguntaequivalencia.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(preguntaequivalencia.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(preguntaequivalencia.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(preguntaequivalencia.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(preguntaequivalencia.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(preguntaequivalencia.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(preguntaequivalencia.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(preguntaequivalencia.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(preguntaequivalencia.getMes(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(PreguntaEquivalencia.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(preguntaequivalencia,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(preguntaequivalencia);
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
			this.deepLoad(this.preguntaequivalencia,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PreguntaEquivalencia.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(preguntaequivalencias!=null) {
				for(PreguntaEquivalencia preguntaequivalencia:preguntaequivalencias) {
					this.deepLoad(preguntaequivalencia,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(preguntaequivalencias);
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
			if(preguntaequivalencias!=null) {
				for(PreguntaEquivalencia preguntaequivalencia:preguntaequivalencias) {
					this.deepLoad(preguntaequivalencia,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(preguntaequivalencias);
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
			this.getNewConnexionToDeep(PreguntaEquivalencia.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(preguntaequivalencia,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PreguntaEquivalencia.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(preguntaequivalencias!=null) {
				for(PreguntaEquivalencia preguntaequivalencia:preguntaequivalencias) {
					this.deepSave(preguntaequivalencia,isDeep,deepLoadType,clases);
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
			if(preguntaequivalencias!=null) {
				for(PreguntaEquivalencia preguntaequivalencia:preguntaequivalencias) {
					this.deepSave(preguntaequivalencia,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPreguntaEquivalenciasBusquedaPorIdEjercicioPorIdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PreguntaEquivalenciaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PreguntaEquivalenciaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdEjercicioPorIdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreguntaEquivalenciasBusquedaPorIdEjercicioPorIdPeriodo(String sFinalQuery,Pagination pagination,Long id_ejercicio,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PreguntaEquivalenciaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PreguntaEquivalenciaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdEjercicioPorIdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreguntaEquivalenciasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,PreguntaEquivalenciaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreguntaEquivalenciasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,PreguntaEquivalenciaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreguntaEquivalenciasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PreguntaEquivalenciaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreguntaEquivalenciasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PreguntaEquivalenciaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreguntaEquivalenciasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PreguntaEquivalenciaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreguntaEquivalenciasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PreguntaEquivalenciaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreguntaEquivalenciasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PreguntaEquivalenciaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreguntaEquivalenciasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PreguntaEquivalenciaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreguntaEquivalenciasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PreguntaEquivalenciaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreguntaEquivalenciasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,PreguntaEquivalenciaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPreguntaEquivalenciasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PreguntaEquivalencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PreguntaEquivalenciaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPreguntaEquivalenciasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PreguntaEquivalenciaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PreguntaEquivalenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			preguntaequivalencias=preguntaequivalenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PreguntaEquivalenciaConstantesFunciones.refrescarForeignKeysDescripcionesPreguntaEquivalencia(this.preguntaequivalencias);
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
			if(PreguntaEquivalenciaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PreguntaEquivalenciaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PreguntaEquivalencia preguntaequivalencia,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PreguntaEquivalenciaConstantesFunciones.ISCONAUDITORIA) {
				if(preguntaequivalencia.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PreguntaEquivalenciaDataAccess.TABLENAME, preguntaequivalencia.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PreguntaEquivalenciaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PreguntaEquivalenciaLogic.registrarAuditoriaDetallesPreguntaEquivalencia(connexion,preguntaequivalencia,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(preguntaequivalencia.getIsDeleted()) {
					/*if(!preguntaequivalencia.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PreguntaEquivalenciaDataAccess.TABLENAME, preguntaequivalencia.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PreguntaEquivalenciaLogic.registrarAuditoriaDetallesPreguntaEquivalencia(connexion,preguntaequivalencia,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PreguntaEquivalenciaDataAccess.TABLENAME, preguntaequivalencia.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(preguntaequivalencia.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PreguntaEquivalenciaDataAccess.TABLENAME, preguntaequivalencia.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PreguntaEquivalenciaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PreguntaEquivalenciaLogic.registrarAuditoriaDetallesPreguntaEquivalencia(connexion,preguntaequivalencia,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPreguntaEquivalencia(Connexion connexion,PreguntaEquivalencia preguntaequivalencia)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(preguntaequivalencia.getIsNew()||!preguntaequivalencia.getid_empresa().equals(preguntaequivalencia.getPreguntaEquivalenciaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntaequivalencia.getPreguntaEquivalenciaOriginal().getid_empresa()!=null)
				{
					strValorActual=preguntaequivalencia.getPreguntaEquivalenciaOriginal().getid_empresa().toString();
				}
				if(preguntaequivalencia.getid_empresa()!=null)
				{
					strValorNuevo=preguntaequivalencia.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaEquivalenciaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(preguntaequivalencia.getIsNew()||!preguntaequivalencia.getid_sucursal().equals(preguntaequivalencia.getPreguntaEquivalenciaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntaequivalencia.getPreguntaEquivalenciaOriginal().getid_sucursal()!=null)
				{
					strValorActual=preguntaequivalencia.getPreguntaEquivalenciaOriginal().getid_sucursal().toString();
				}
				if(preguntaequivalencia.getid_sucursal()!=null)
				{
					strValorNuevo=preguntaequivalencia.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaEquivalenciaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(preguntaequivalencia.getIsNew()||!preguntaequivalencia.getid_ejercicio().equals(preguntaequivalencia.getPreguntaEquivalenciaOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntaequivalencia.getPreguntaEquivalenciaOriginal().getid_ejercicio()!=null)
				{
					strValorActual=preguntaequivalencia.getPreguntaEquivalenciaOriginal().getid_ejercicio().toString();
				}
				if(preguntaequivalencia.getid_ejercicio()!=null)
				{
					strValorNuevo=preguntaequivalencia.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaEquivalenciaConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(preguntaequivalencia.getIsNew()||!preguntaequivalencia.getid_periodo().equals(preguntaequivalencia.getPreguntaEquivalenciaOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntaequivalencia.getPreguntaEquivalenciaOriginal().getid_periodo()!=null)
				{
					strValorActual=preguntaequivalencia.getPreguntaEquivalenciaOriginal().getid_periodo().toString();
				}
				if(preguntaequivalencia.getid_periodo()!=null)
				{
					strValorNuevo=preguntaequivalencia.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaEquivalenciaConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(preguntaequivalencia.getIsNew()||!preguntaequivalencia.getdescripcion().equals(preguntaequivalencia.getPreguntaEquivalenciaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntaequivalencia.getPreguntaEquivalenciaOriginal().getdescripcion()!=null)
				{
					strValorActual=preguntaequivalencia.getPreguntaEquivalenciaOriginal().getdescripcion();
				}
				if(preguntaequivalencia.getdescripcion()!=null)
				{
					strValorNuevo=preguntaequivalencia.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaEquivalenciaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(preguntaequivalencia.getIsNew()||!preguntaequivalencia.getdesde().equals(preguntaequivalencia.getPreguntaEquivalenciaOriginal().getdesde()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntaequivalencia.getPreguntaEquivalenciaOriginal().getdesde()!=null)
				{
					strValorActual=preguntaequivalencia.getPreguntaEquivalenciaOriginal().getdesde().toString();
				}
				if(preguntaequivalencia.getdesde()!=null)
				{
					strValorNuevo=preguntaequivalencia.getdesde().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaEquivalenciaConstantesFunciones.DESDE,strValorActual,strValorNuevo);
			}	
			
			if(preguntaequivalencia.getIsNew()||!preguntaequivalencia.gethasta().equals(preguntaequivalencia.getPreguntaEquivalenciaOriginal().gethasta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntaequivalencia.getPreguntaEquivalenciaOriginal().gethasta()!=null)
				{
					strValorActual=preguntaequivalencia.getPreguntaEquivalenciaOriginal().gethasta().toString();
				}
				if(preguntaequivalencia.gethasta()!=null)
				{
					strValorNuevo=preguntaequivalencia.gethasta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaEquivalenciaConstantesFunciones.HASTA,strValorActual,strValorNuevo);
			}	
			
			if(preguntaequivalencia.getIsNew()||!preguntaequivalencia.getorden().equals(preguntaequivalencia.getPreguntaEquivalenciaOriginal().getorden()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntaequivalencia.getPreguntaEquivalenciaOriginal().getorden()!=null)
				{
					strValorActual=preguntaequivalencia.getPreguntaEquivalenciaOriginal().getorden().toString();
				}
				if(preguntaequivalencia.getorden()!=null)
				{
					strValorNuevo=preguntaequivalencia.getorden().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaEquivalenciaConstantesFunciones.ORDEN,strValorActual,strValorNuevo);
			}	
			
			if(preguntaequivalencia.getIsNew()||!preguntaequivalencia.getid_anio().equals(preguntaequivalencia.getPreguntaEquivalenciaOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntaequivalencia.getPreguntaEquivalenciaOriginal().getid_anio()!=null)
				{
					strValorActual=preguntaequivalencia.getPreguntaEquivalenciaOriginal().getid_anio().toString();
				}
				if(preguntaequivalencia.getid_anio()!=null)
				{
					strValorNuevo=preguntaequivalencia.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaEquivalenciaConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(preguntaequivalencia.getIsNew()||!preguntaequivalencia.getid_mes().equals(preguntaequivalencia.getPreguntaEquivalenciaOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(preguntaequivalencia.getPreguntaEquivalenciaOriginal().getid_mes()!=null)
				{
					strValorActual=preguntaequivalencia.getPreguntaEquivalenciaOriginal().getid_mes().toString();
				}
				if(preguntaequivalencia.getid_mes()!=null)
				{
					strValorNuevo=preguntaequivalencia.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PreguntaEquivalenciaConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePreguntaEquivalenciaRelacionesWithConnection(PreguntaEquivalencia preguntaequivalencia) throws Exception {

		if(!preguntaequivalencia.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePreguntaEquivalenciaRelacionesBase(preguntaequivalencia,true);
		}
	}

	public void savePreguntaEquivalenciaRelaciones(PreguntaEquivalencia preguntaequivalencia)throws Exception {

		if(!preguntaequivalencia.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePreguntaEquivalenciaRelacionesBase(preguntaequivalencia,false);
		}
	}

	public void savePreguntaEquivalenciaRelacionesBase(PreguntaEquivalencia preguntaequivalencia,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PreguntaEquivalencia-saveRelacionesWithConnection");}
	

			this.setPreguntaEquivalencia(preguntaequivalencia);

			if(PreguntaEquivalenciaLogicAdditional.validarSaveRelaciones(preguntaequivalencia,this)) {

				PreguntaEquivalenciaLogicAdditional.updateRelacionesToSave(preguntaequivalencia,this);

				if((preguntaequivalencia.getIsNew()||preguntaequivalencia.getIsChanged())&&!preguntaequivalencia.getIsDeleted()) {
					this.savePreguntaEquivalencia();
					this.savePreguntaEquivalenciaRelacionesDetalles();

				} else if(preguntaequivalencia.getIsDeleted()) {
					this.savePreguntaEquivalenciaRelacionesDetalles();
					this.savePreguntaEquivalencia();
				}

				PreguntaEquivalenciaLogicAdditional.updateRelacionesToSaveAfter(preguntaequivalencia,this);

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
	
	
	private void savePreguntaEquivalenciaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPreguntaEquivalencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PreguntaEquivalenciaConstantesFunciones.getClassesForeignKeysOfPreguntaEquivalencia(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPreguntaEquivalencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PreguntaEquivalenciaConstantesFunciones.getClassesRelationshipsOfPreguntaEquivalencia(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

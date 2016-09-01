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
import com.bydan.erp.nomina.util.BonoEficienciaConstantesFunciones;
import com.bydan.erp.nomina.util.BonoEficienciaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.BonoEficienciaParameterGeneral;
import com.bydan.erp.nomina.business.entity.BonoEficiencia;
import com.bydan.erp.nomina.business.logic.BonoEficienciaLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class BonoEficienciaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(BonoEficienciaLogic.class);
	
	protected BonoEficienciaDataAccess bonoeficienciaDataAccess; 	
	protected BonoEficiencia bonoeficiencia;
	protected List<BonoEficiencia> bonoeficiencias;
	protected Object bonoeficienciaObject;	
	protected List<Object> bonoeficienciasObject;
	
	public static ClassValidator<BonoEficiencia> bonoeficienciaValidator = new ClassValidator<BonoEficiencia>(BonoEficiencia.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected BonoEficienciaLogicAdditional bonoeficienciaLogicAdditional=null;
	
	public BonoEficienciaLogicAdditional getBonoEficienciaLogicAdditional() {
		return this.bonoeficienciaLogicAdditional;
	}
	
	public void setBonoEficienciaLogicAdditional(BonoEficienciaLogicAdditional bonoeficienciaLogicAdditional) {
		try {
			this.bonoeficienciaLogicAdditional=bonoeficienciaLogicAdditional;
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
	
	
	
	
	public  BonoEficienciaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.bonoeficienciaDataAccess = new BonoEficienciaDataAccess();
			
			this.bonoeficiencias= new ArrayList<BonoEficiencia>();
			this.bonoeficiencia= new BonoEficiencia();
			
			this.bonoeficienciaObject=new Object();
			this.bonoeficienciasObject=new ArrayList<Object>();
				
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
			
			this.bonoeficienciaDataAccess.setConnexionType(this.connexionType);
			this.bonoeficienciaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  BonoEficienciaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.bonoeficienciaDataAccess = new BonoEficienciaDataAccess();
			this.bonoeficiencias= new ArrayList<BonoEficiencia>();
			this.bonoeficiencia= new BonoEficiencia();
			this.bonoeficienciaObject=new Object();
			this.bonoeficienciasObject=new ArrayList<Object>();
			
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
			
			this.bonoeficienciaDataAccess.setConnexionType(this.connexionType);
			this.bonoeficienciaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public BonoEficiencia getBonoEficiencia() throws Exception {	
		BonoEficienciaLogicAdditional.checkBonoEficienciaToGet(bonoeficiencia,this.datosCliente,this.arrDatoGeneral);
		BonoEficienciaLogicAdditional.updateBonoEficienciaToGet(bonoeficiencia,this.arrDatoGeneral);
		
		return bonoeficiencia;
	}
		
	public void setBonoEficiencia(BonoEficiencia newBonoEficiencia) {
		this.bonoeficiencia = newBonoEficiencia;
	}
	
	public BonoEficienciaDataAccess getBonoEficienciaDataAccess() {
		return bonoeficienciaDataAccess;
	}
	
	public void setBonoEficienciaDataAccess(BonoEficienciaDataAccess newbonoeficienciaDataAccess) {
		this.bonoeficienciaDataAccess = newbonoeficienciaDataAccess;
	}
	
	public List<BonoEficiencia> getBonoEficiencias() throws Exception {		
		this.quitarBonoEficienciasNulos();
		
		BonoEficienciaLogicAdditional.checkBonoEficienciaToGets(bonoeficiencias,this.datosCliente,this.arrDatoGeneral);
		
		for (BonoEficiencia bonoeficienciaLocal: bonoeficiencias ) {
			BonoEficienciaLogicAdditional.updateBonoEficienciaToGet(bonoeficienciaLocal,this.arrDatoGeneral);
		}
		
		return bonoeficiencias;
	}
	
	public void setBonoEficiencias(List<BonoEficiencia> newBonoEficiencias) {
		this.bonoeficiencias = newBonoEficiencias;
	}
	
	public Object getBonoEficienciaObject() {	
		this.bonoeficienciaObject=this.bonoeficienciaDataAccess.getEntityObject();
		return this.bonoeficienciaObject;
	}
		
	public void setBonoEficienciaObject(Object newBonoEficienciaObject) {
		this.bonoeficienciaObject = newBonoEficienciaObject;
	}
	
	public List<Object> getBonoEficienciasObject() {		
		this.bonoeficienciasObject=this.bonoeficienciaDataAccess.getEntitiesObject();
		return this.bonoeficienciasObject;
	}
		
	public void setBonoEficienciasObject(List<Object> newBonoEficienciasObject) {
		this.bonoeficienciasObject = newBonoEficienciasObject;
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
		
		if(this.bonoeficienciaDataAccess!=null) {
			this.bonoeficienciaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BonoEficiencia.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			bonoeficienciaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			bonoeficienciaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		bonoeficiencia = new  BonoEficiencia();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BonoEficiencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			bonoeficiencia=bonoeficienciaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bonoeficiencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BonoEficienciaConstantesFunciones.refrescarForeignKeysDescripcionesBonoEficiencia(this.bonoeficiencia);
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
		bonoeficiencia = new  BonoEficiencia();
		  		  
        try {
			
			bonoeficiencia=bonoeficienciaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bonoeficiencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BonoEficienciaConstantesFunciones.refrescarForeignKeysDescripcionesBonoEficiencia(this.bonoeficiencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		bonoeficiencia = new  BonoEficiencia();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BonoEficiencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			bonoeficiencia=bonoeficienciaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bonoeficiencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BonoEficienciaConstantesFunciones.refrescarForeignKeysDescripcionesBonoEficiencia(this.bonoeficiencia);
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
		bonoeficiencia = new  BonoEficiencia();
		  		  
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
		bonoeficiencia = new  BonoEficiencia();
		  		  
        try {
			
			bonoeficiencia=bonoeficienciaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bonoeficiencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BonoEficienciaConstantesFunciones.refrescarForeignKeysDescripcionesBonoEficiencia(this.bonoeficiencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		bonoeficiencia = new  BonoEficiencia();
		  		  
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
		bonoeficiencia = new  BonoEficiencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BonoEficiencia.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =bonoeficienciaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		bonoeficiencia = new  BonoEficiencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=bonoeficienciaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		bonoeficiencia = new  BonoEficiencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BonoEficiencia.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =bonoeficienciaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		bonoeficiencia = new  BonoEficiencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=bonoeficienciaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		bonoeficiencia = new  BonoEficiencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BonoEficiencia.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =bonoeficienciaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		bonoeficiencia = new  BonoEficiencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=bonoeficienciaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		bonoeficiencias = new  ArrayList<BonoEficiencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BonoEficiencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			BonoEficienciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bonoeficiencias=bonoeficienciaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBonoEficiencia(bonoeficiencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BonoEficienciaConstantesFunciones.refrescarForeignKeysDescripcionesBonoEficiencia(this.bonoeficiencias);
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
		bonoeficiencias = new  ArrayList<BonoEficiencia>();
		  		  
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
		bonoeficiencias = new  ArrayList<BonoEficiencia>();
		  		  
        try {			
			BonoEficienciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bonoeficiencias=bonoeficienciaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarBonoEficiencia(bonoeficiencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BonoEficienciaConstantesFunciones.refrescarForeignKeysDescripcionesBonoEficiencia(this.bonoeficiencias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		bonoeficiencias = new  ArrayList<BonoEficiencia>();
		  		  
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
		bonoeficiencias = new  ArrayList<BonoEficiencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BonoEficiencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			BonoEficienciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bonoeficiencias=bonoeficienciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBonoEficiencia(bonoeficiencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BonoEficienciaConstantesFunciones.refrescarForeignKeysDescripcionesBonoEficiencia(this.bonoeficiencias);
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
		bonoeficiencias = new  ArrayList<BonoEficiencia>();
		  		  
        try {
			BonoEficienciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bonoeficiencias=bonoeficienciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBonoEficiencia(bonoeficiencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BonoEficienciaConstantesFunciones.refrescarForeignKeysDescripcionesBonoEficiencia(this.bonoeficiencias);
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
		bonoeficiencias = new  ArrayList<BonoEficiencia>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BonoEficiencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BonoEficienciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bonoeficiencias=bonoeficienciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBonoEficiencia(bonoeficiencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BonoEficienciaConstantesFunciones.refrescarForeignKeysDescripcionesBonoEficiencia(this.bonoeficiencias);
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
		bonoeficiencias = new  ArrayList<BonoEficiencia>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BonoEficienciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bonoeficiencias=bonoeficienciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBonoEficiencia(bonoeficiencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BonoEficienciaConstantesFunciones.refrescarForeignKeysDescripcionesBonoEficiencia(this.bonoeficiencias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		bonoeficiencia = new  BonoEficiencia();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BonoEficiencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BonoEficienciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bonoeficiencia=bonoeficienciaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBonoEficiencia(bonoeficiencia);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BonoEficienciaConstantesFunciones.refrescarForeignKeysDescripcionesBonoEficiencia(this.bonoeficiencia);
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
		bonoeficiencia = new  BonoEficiencia();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BonoEficienciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bonoeficiencia=bonoeficienciaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBonoEficiencia(bonoeficiencia);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BonoEficienciaConstantesFunciones.refrescarForeignKeysDescripcionesBonoEficiencia(this.bonoeficiencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		bonoeficiencias = new  ArrayList<BonoEficiencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BonoEficiencia.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			BonoEficienciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bonoeficiencias=bonoeficienciaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBonoEficiencia(bonoeficiencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BonoEficienciaConstantesFunciones.refrescarForeignKeysDescripcionesBonoEficiencia(this.bonoeficiencias);
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
		bonoeficiencias = new  ArrayList<BonoEficiencia>();
		  		  
        try {
			BonoEficienciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bonoeficiencias=bonoeficienciaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBonoEficiencia(bonoeficiencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BonoEficienciaConstantesFunciones.refrescarForeignKeysDescripcionesBonoEficiencia(this.bonoeficiencias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosBonoEficienciasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		bonoeficiencias = new  ArrayList<BonoEficiencia>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BonoEficiencia.class.getSimpleName()+"-getTodosBonoEficienciasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BonoEficienciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bonoeficiencias=bonoeficienciaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarBonoEficiencia(bonoeficiencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BonoEficienciaConstantesFunciones.refrescarForeignKeysDescripcionesBonoEficiencia(this.bonoeficiencias);
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
	
	public  void  getTodosBonoEficiencias(String sFinalQuery,Pagination pagination)throws Exception {
		bonoeficiencias = new  ArrayList<BonoEficiencia>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BonoEficienciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bonoeficiencias=bonoeficienciaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarBonoEficiencia(bonoeficiencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BonoEficienciaConstantesFunciones.refrescarForeignKeysDescripcionesBonoEficiencia(this.bonoeficiencias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarBonoEficiencia(BonoEficiencia bonoeficiencia) throws Exception {
		Boolean estaValidado=false;
		
		if(bonoeficiencia.getIsNew() || bonoeficiencia.getIsChanged()) { 
			this.invalidValues = bonoeficienciaValidator.getInvalidValues(bonoeficiencia);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(bonoeficiencia);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarBonoEficiencia(List<BonoEficiencia> BonoEficiencias) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(BonoEficiencia bonoeficienciaLocal:bonoeficiencias) {				
			estaValidadoObjeto=this.validarGuardarBonoEficiencia(bonoeficienciaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarBonoEficiencia(List<BonoEficiencia> BonoEficiencias) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarBonoEficiencia(bonoeficiencias)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarBonoEficiencia(BonoEficiencia BonoEficiencia) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarBonoEficiencia(bonoeficiencia)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(BonoEficiencia bonoeficiencia) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+bonoeficiencia.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=BonoEficienciaConstantesFunciones.getBonoEficienciaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"bonoeficiencia","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(BonoEficienciaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(BonoEficienciaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveBonoEficienciaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BonoEficiencia.class.getSimpleName()+"-saveBonoEficienciaWithConnection");connexion.begin();			
			
			BonoEficienciaLogicAdditional.checkBonoEficienciaToSave(this.bonoeficiencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			BonoEficienciaLogicAdditional.updateBonoEficienciaToSave(this.bonoeficiencia,this.arrDatoGeneral);
			
			BonoEficienciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.bonoeficiencia,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowBonoEficiencia();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarBonoEficiencia(this.bonoeficiencia)) {
				BonoEficienciaDataAccess.save(this.bonoeficiencia, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.bonoeficiencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			BonoEficienciaLogicAdditional.checkBonoEficienciaToSaveAfter(this.bonoeficiencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowBonoEficiencia();
			
			connexion.commit();			
			
			if(this.bonoeficiencia.getIsDeleted()) {
				this.bonoeficiencia=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveBonoEficiencia()throws Exception {	
		try {	
			
			BonoEficienciaLogicAdditional.checkBonoEficienciaToSave(this.bonoeficiencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			BonoEficienciaLogicAdditional.updateBonoEficienciaToSave(this.bonoeficiencia,this.arrDatoGeneral);
			
			BonoEficienciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.bonoeficiencia,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarBonoEficiencia(this.bonoeficiencia)) {			
				BonoEficienciaDataAccess.save(this.bonoeficiencia, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.bonoeficiencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			BonoEficienciaLogicAdditional.checkBonoEficienciaToSaveAfter(this.bonoeficiencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.bonoeficiencia.getIsDeleted()) {
				this.bonoeficiencia=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveBonoEficienciasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BonoEficiencia.class.getSimpleName()+"-saveBonoEficienciasWithConnection");connexion.begin();			
			
			BonoEficienciaLogicAdditional.checkBonoEficienciaToSaves(bonoeficiencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowBonoEficiencias();
			
			Boolean validadoTodosBonoEficiencia=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(BonoEficiencia bonoeficienciaLocal:bonoeficiencias) {		
				if(bonoeficienciaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				BonoEficienciaLogicAdditional.updateBonoEficienciaToSave(bonoeficienciaLocal,this.arrDatoGeneral);
	        	
				BonoEficienciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),bonoeficienciaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarBonoEficiencia(bonoeficienciaLocal)) {
					BonoEficienciaDataAccess.save(bonoeficienciaLocal, connexion);				
				} else {
					validadoTodosBonoEficiencia=false;
				}
			}
			
			if(!validadoTodosBonoEficiencia) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			BonoEficienciaLogicAdditional.checkBonoEficienciaToSavesAfter(bonoeficiencias,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowBonoEficiencias();
			
			connexion.commit();		
			
			this.quitarBonoEficienciasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveBonoEficiencias()throws Exception {				
		 try {	
			BonoEficienciaLogicAdditional.checkBonoEficienciaToSaves(bonoeficiencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosBonoEficiencia=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(BonoEficiencia bonoeficienciaLocal:bonoeficiencias) {				
				if(bonoeficienciaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				BonoEficienciaLogicAdditional.updateBonoEficienciaToSave(bonoeficienciaLocal,this.arrDatoGeneral);
	        	
				BonoEficienciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),bonoeficienciaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarBonoEficiencia(bonoeficienciaLocal)) {				
					BonoEficienciaDataAccess.save(bonoeficienciaLocal, connexion);				
				} else {
					validadoTodosBonoEficiencia=false;
				}
			}
			
			if(!validadoTodosBonoEficiencia) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			BonoEficienciaLogicAdditional.checkBonoEficienciaToSavesAfter(bonoeficiencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarBonoEficienciasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public BonoEficienciaParameterReturnGeneral procesarAccionBonoEficiencias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<BonoEficiencia> bonoeficiencias,BonoEficienciaParameterReturnGeneral bonoeficienciaParameterGeneral)throws Exception {
		 try {	
			BonoEficienciaParameterReturnGeneral bonoeficienciaReturnGeneral=new BonoEficienciaParameterReturnGeneral();
	
			BonoEficienciaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,bonoeficiencias,bonoeficienciaParameterGeneral,bonoeficienciaReturnGeneral);
			
			return bonoeficienciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public BonoEficienciaParameterReturnGeneral procesarAccionBonoEficienciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<BonoEficiencia> bonoeficiencias,BonoEficienciaParameterReturnGeneral bonoeficienciaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BonoEficiencia.class.getSimpleName()+"-procesarAccionBonoEficienciasWithConnection");connexion.begin();			
			
			BonoEficienciaParameterReturnGeneral bonoeficienciaReturnGeneral=new BonoEficienciaParameterReturnGeneral();
	
			BonoEficienciaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,bonoeficiencias,bonoeficienciaParameterGeneral,bonoeficienciaReturnGeneral);
			
			this.connexion.commit();
			
			return bonoeficienciaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public BonoEficienciaParameterReturnGeneral procesarEventosBonoEficiencias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<BonoEficiencia> bonoeficiencias,BonoEficiencia bonoeficiencia,BonoEficienciaParameterReturnGeneral bonoeficienciaParameterGeneral,Boolean isEsNuevoBonoEficiencia,ArrayList<Classe> clases)throws Exception {
		 try {	
			BonoEficienciaParameterReturnGeneral bonoeficienciaReturnGeneral=new BonoEficienciaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				bonoeficienciaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			BonoEficienciaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,bonoeficiencias,bonoeficiencia,bonoeficienciaParameterGeneral,bonoeficienciaReturnGeneral,isEsNuevoBonoEficiencia,clases);
			
			return bonoeficienciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public BonoEficienciaParameterReturnGeneral procesarEventosBonoEficienciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<BonoEficiencia> bonoeficiencias,BonoEficiencia bonoeficiencia,BonoEficienciaParameterReturnGeneral bonoeficienciaParameterGeneral,Boolean isEsNuevoBonoEficiencia,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BonoEficiencia.class.getSimpleName()+"-procesarEventosBonoEficienciasWithConnection");connexion.begin();			
			
			BonoEficienciaParameterReturnGeneral bonoeficienciaReturnGeneral=new BonoEficienciaParameterReturnGeneral();
	
			bonoeficienciaReturnGeneral.setBonoEficiencia(bonoeficiencia);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				bonoeficienciaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			BonoEficienciaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,bonoeficiencias,bonoeficiencia,bonoeficienciaParameterGeneral,bonoeficienciaReturnGeneral,isEsNuevoBonoEficiencia,clases);
			
			this.connexion.commit();
			
			return bonoeficienciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public BonoEficienciaParameterReturnGeneral procesarImportacionBonoEficienciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,BonoEficienciaParameterReturnGeneral bonoeficienciaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BonoEficiencia.class.getSimpleName()+"-procesarImportacionBonoEficienciasWithConnection");connexion.begin();			
			
			BonoEficienciaParameterReturnGeneral bonoeficienciaReturnGeneral=new BonoEficienciaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.bonoeficiencias=new ArrayList<BonoEficiencia>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.bonoeficiencia=new BonoEficiencia();
				
				
				if(conColumnasBase) {this.bonoeficiencia.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.bonoeficiencia.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.bonoeficiencia.setdias(Integer.parseInt(arrColumnas[iColumn++]));
				this.bonoeficiencia.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.bonoeficiencias.add(this.bonoeficiencia);
			}
			
			this.saveBonoEficiencias();
			
			this.connexion.commit();
			
			bonoeficienciaReturnGeneral.setConRetornoEstaProcesado(true);
			bonoeficienciaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return bonoeficienciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarBonoEficienciasEliminados() throws Exception {				
		
		List<BonoEficiencia> bonoeficienciasAux= new ArrayList<BonoEficiencia>();
		
		for(BonoEficiencia bonoeficiencia:bonoeficiencias) {
			if(!bonoeficiencia.getIsDeleted()) {
				bonoeficienciasAux.add(bonoeficiencia);
			}
		}
		
		bonoeficiencias=bonoeficienciasAux;
	}
	
	public void quitarBonoEficienciasNulos() throws Exception {				
		
		List<BonoEficiencia> bonoeficienciasAux= new ArrayList<BonoEficiencia>();
		
		for(BonoEficiencia bonoeficiencia : this.bonoeficiencias) {
			if(bonoeficiencia==null) {
				bonoeficienciasAux.add(bonoeficiencia);
			}
		}
		
		//this.bonoeficiencias=bonoeficienciasAux;
		
		this.bonoeficiencias.removeAll(bonoeficienciasAux);
	}
	
	public void getSetVersionRowBonoEficienciaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(bonoeficiencia.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((bonoeficiencia.getIsDeleted() || (bonoeficiencia.getIsChanged()&&!bonoeficiencia.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=bonoeficienciaDataAccess.getSetVersionRowBonoEficiencia(connexion,bonoeficiencia.getId());
				
				if(!bonoeficiencia.getVersionRow().equals(timestamp)) {	
					bonoeficiencia.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				bonoeficiencia.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowBonoEficiencia()throws Exception {	
		
		if(bonoeficiencia.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((bonoeficiencia.getIsDeleted() || (bonoeficiencia.getIsChanged()&&!bonoeficiencia.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=bonoeficienciaDataAccess.getSetVersionRowBonoEficiencia(connexion,bonoeficiencia.getId());
			
			try {							
				if(!bonoeficiencia.getVersionRow().equals(timestamp)) {	
					bonoeficiencia.setVersionRow(timestamp);
				}
				
				bonoeficiencia.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowBonoEficienciasWithConnection()throws Exception {	
		if(bonoeficiencias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(BonoEficiencia bonoeficienciaAux:bonoeficiencias) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(bonoeficienciaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(bonoeficienciaAux.getIsDeleted() || (bonoeficienciaAux.getIsChanged()&&!bonoeficienciaAux.getIsNew())) {
						
						timestamp=bonoeficienciaDataAccess.getSetVersionRowBonoEficiencia(connexion,bonoeficienciaAux.getId());
						
						if(!bonoeficiencia.getVersionRow().equals(timestamp)) {	
							bonoeficienciaAux.setVersionRow(timestamp);
						}
								
						bonoeficienciaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowBonoEficiencias()throws Exception {	
		if(bonoeficiencias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(BonoEficiencia bonoeficienciaAux:bonoeficiencias) {
					if(bonoeficienciaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(bonoeficienciaAux.getIsDeleted() || (bonoeficienciaAux.getIsChanged()&&!bonoeficienciaAux.getIsNew())) {
						
						timestamp=bonoeficienciaDataAccess.getSetVersionRowBonoEficiencia(connexion,bonoeficienciaAux.getId());
						
						if(!bonoeficienciaAux.getVersionRow().equals(timestamp)) {	
							bonoeficienciaAux.setVersionRow(timestamp);
						}
						
													
						bonoeficienciaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public BonoEficienciaParameterReturnGeneral cargarCombosLoteForeignKeyBonoEficienciaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		BonoEficienciaParameterReturnGeneral  bonoeficienciaReturnGeneral =new BonoEficienciaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BonoEficiencia.class.getSimpleName()+"-cargarCombosLoteForeignKeyBonoEficienciaWithConnection");connexion.begin();
			
			bonoeficienciaReturnGeneral =new BonoEficienciaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			bonoeficienciaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return bonoeficienciaReturnGeneral;
	}
	
	public BonoEficienciaParameterReturnGeneral cargarCombosLoteForeignKeyBonoEficiencia(String finalQueryGlobalEmpresa) throws Exception {
		BonoEficienciaParameterReturnGeneral  bonoeficienciaReturnGeneral =new BonoEficienciaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			bonoeficienciaReturnGeneral =new BonoEficienciaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			bonoeficienciaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return bonoeficienciaReturnGeneral;
	}
	
	
	public void deepLoad(BonoEficiencia bonoeficiencia,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			BonoEficienciaLogicAdditional.updateBonoEficienciaToGet(bonoeficiencia,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		bonoeficiencia.setEmpresa(bonoeficienciaDataAccess.getEmpresa(connexion,bonoeficiencia));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				bonoeficiencia.setEmpresa(bonoeficienciaDataAccess.getEmpresa(connexion,bonoeficiencia));
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
			bonoeficiencia.setEmpresa(bonoeficienciaDataAccess.getEmpresa(connexion,bonoeficiencia));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		bonoeficiencia.setEmpresa(bonoeficienciaDataAccess.getEmpresa(connexion,bonoeficiencia));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(bonoeficiencia.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				bonoeficiencia.setEmpresa(bonoeficienciaDataAccess.getEmpresa(connexion,bonoeficiencia));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(bonoeficiencia.getEmpresa(),isDeep,deepLoadType,clases);				
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
			bonoeficiencia.setEmpresa(bonoeficienciaDataAccess.getEmpresa(connexion,bonoeficiencia));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(bonoeficiencia.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(BonoEficiencia bonoeficiencia,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			BonoEficienciaLogicAdditional.updateBonoEficienciaToSave(bonoeficiencia,this.arrDatoGeneral);
			
BonoEficienciaDataAccess.save(bonoeficiencia, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(bonoeficiencia.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(bonoeficiencia.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(bonoeficiencia.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(bonoeficiencia.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(bonoeficiencia.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(bonoeficiencia.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(BonoEficiencia.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(bonoeficiencia,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				BonoEficienciaConstantesFunciones.refrescarForeignKeysDescripcionesBonoEficiencia(bonoeficiencia);
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
			this.deepLoad(this.bonoeficiencia,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				BonoEficienciaConstantesFunciones.refrescarForeignKeysDescripcionesBonoEficiencia(this.bonoeficiencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(BonoEficiencia.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(bonoeficiencias!=null) {
				for(BonoEficiencia bonoeficiencia:bonoeficiencias) {
					this.deepLoad(bonoeficiencia,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					BonoEficienciaConstantesFunciones.refrescarForeignKeysDescripcionesBonoEficiencia(bonoeficiencias);
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
			if(bonoeficiencias!=null) {
				for(BonoEficiencia bonoeficiencia:bonoeficiencias) {
					this.deepLoad(bonoeficiencia,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					BonoEficienciaConstantesFunciones.refrescarForeignKeysDescripcionesBonoEficiencia(bonoeficiencias);
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
			this.getNewConnexionToDeep(BonoEficiencia.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(bonoeficiencia,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(BonoEficiencia.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(bonoeficiencias!=null) {
				for(BonoEficiencia bonoeficiencia:bonoeficiencias) {
					this.deepSave(bonoeficiencia,isDeep,deepLoadType,clases);
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
			if(bonoeficiencias!=null) {
				for(BonoEficiencia bonoeficiencia:bonoeficiencias) {
					this.deepSave(bonoeficiencia,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getBonoEficienciasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BonoEficiencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,BonoEficienciaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			BonoEficienciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bonoeficiencias=bonoeficienciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BonoEficienciaConstantesFunciones.refrescarForeignKeysDescripcionesBonoEficiencia(this.bonoeficiencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBonoEficienciasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,BonoEficienciaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			BonoEficienciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bonoeficiencias=bonoeficienciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BonoEficienciaConstantesFunciones.refrescarForeignKeysDescripcionesBonoEficiencia(this.bonoeficiencias);
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
			if(BonoEficienciaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,BonoEficienciaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,BonoEficiencia bonoeficiencia,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(BonoEficienciaConstantesFunciones.ISCONAUDITORIA) {
				if(bonoeficiencia.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BonoEficienciaDataAccess.TABLENAME, bonoeficiencia.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(BonoEficienciaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////BonoEficienciaLogic.registrarAuditoriaDetallesBonoEficiencia(connexion,bonoeficiencia,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(bonoeficiencia.getIsDeleted()) {
					/*if(!bonoeficiencia.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,BonoEficienciaDataAccess.TABLENAME, bonoeficiencia.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////BonoEficienciaLogic.registrarAuditoriaDetallesBonoEficiencia(connexion,bonoeficiencia,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BonoEficienciaDataAccess.TABLENAME, bonoeficiencia.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(bonoeficiencia.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BonoEficienciaDataAccess.TABLENAME, bonoeficiencia.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(BonoEficienciaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////BonoEficienciaLogic.registrarAuditoriaDetallesBonoEficiencia(connexion,bonoeficiencia,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesBonoEficiencia(Connexion connexion,BonoEficiencia bonoeficiencia)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(bonoeficiencia.getIsNew()||!bonoeficiencia.getid_empresa().equals(bonoeficiencia.getBonoEficienciaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bonoeficiencia.getBonoEficienciaOriginal().getid_empresa()!=null)
				{
					strValorActual=bonoeficiencia.getBonoEficienciaOriginal().getid_empresa().toString();
				}
				if(bonoeficiencia.getid_empresa()!=null)
				{
					strValorNuevo=bonoeficiencia.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BonoEficienciaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(bonoeficiencia.getIsNew()||!bonoeficiencia.getdias().equals(bonoeficiencia.getBonoEficienciaOriginal().getdias()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bonoeficiencia.getBonoEficienciaOriginal().getdias()!=null)
				{
					strValorActual=bonoeficiencia.getBonoEficienciaOriginal().getdias().toString();
				}
				if(bonoeficiencia.getdias()!=null)
				{
					strValorNuevo=bonoeficiencia.getdias().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BonoEficienciaConstantesFunciones.DIAS,strValorActual,strValorNuevo);
			}	
			
			if(bonoeficiencia.getIsNew()||!bonoeficiencia.getvalor().equals(bonoeficiencia.getBonoEficienciaOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bonoeficiencia.getBonoEficienciaOriginal().getvalor()!=null)
				{
					strValorActual=bonoeficiencia.getBonoEficienciaOriginal().getvalor().toString();
				}
				if(bonoeficiencia.getvalor()!=null)
				{
					strValorNuevo=bonoeficiencia.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BonoEficienciaConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveBonoEficienciaRelacionesWithConnection(BonoEficiencia bonoeficiencia) throws Exception {

		if(!bonoeficiencia.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveBonoEficienciaRelacionesBase(bonoeficiencia,true);
		}
	}

	public void saveBonoEficienciaRelaciones(BonoEficiencia bonoeficiencia)throws Exception {

		if(!bonoeficiencia.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveBonoEficienciaRelacionesBase(bonoeficiencia,false);
		}
	}

	public void saveBonoEficienciaRelacionesBase(BonoEficiencia bonoeficiencia,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("BonoEficiencia-saveRelacionesWithConnection");}
	

			this.setBonoEficiencia(bonoeficiencia);

			if(BonoEficienciaLogicAdditional.validarSaveRelaciones(bonoeficiencia,this)) {

				BonoEficienciaLogicAdditional.updateRelacionesToSave(bonoeficiencia,this);

				if((bonoeficiencia.getIsNew()||bonoeficiencia.getIsChanged())&&!bonoeficiencia.getIsDeleted()) {
					this.saveBonoEficiencia();
					this.saveBonoEficienciaRelacionesDetalles();

				} else if(bonoeficiencia.getIsDeleted()) {
					this.saveBonoEficienciaRelacionesDetalles();
					this.saveBonoEficiencia();
				}

				BonoEficienciaLogicAdditional.updateRelacionesToSaveAfter(bonoeficiencia,this);

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
	
	
	private void saveBonoEficienciaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfBonoEficiencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=BonoEficienciaConstantesFunciones.getClassesForeignKeysOfBonoEficiencia(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBonoEficiencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=BonoEficienciaConstantesFunciones.getClassesRelationshipsOfBonoEficiencia(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

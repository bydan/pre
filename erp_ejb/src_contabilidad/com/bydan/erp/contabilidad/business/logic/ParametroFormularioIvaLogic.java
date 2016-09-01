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
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.ParametroFormularioIvaConstantesFunciones;
import com.bydan.erp.contabilidad.util.ParametroFormularioIvaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.ParametroFormularioIvaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.ParametroFormularioIva;
import com.bydan.erp.contabilidad.business.logic.ParametroFormularioIvaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroFormularioIvaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroFormularioIvaLogic.class);
	
	protected ParametroFormularioIvaDataAccess parametroformularioivaDataAccess; 	
	protected ParametroFormularioIva parametroformularioiva;
	protected List<ParametroFormularioIva> parametroformularioivas;
	protected Object parametroformularioivaObject;	
	protected List<Object> parametroformularioivasObject;
	
	public static ClassValidator<ParametroFormularioIva> parametroformularioivaValidator = new ClassValidator<ParametroFormularioIva>(ParametroFormularioIva.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroFormularioIvaLogicAdditional parametroformularioivaLogicAdditional=null;
	
	public ParametroFormularioIvaLogicAdditional getParametroFormularioIvaLogicAdditional() {
		return this.parametroformularioivaLogicAdditional;
	}
	
	public void setParametroFormularioIvaLogicAdditional(ParametroFormularioIvaLogicAdditional parametroformularioivaLogicAdditional) {
		try {
			this.parametroformularioivaLogicAdditional=parametroformularioivaLogicAdditional;
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
	
	
	
	
	public  ParametroFormularioIvaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametroformularioivaDataAccess = new ParametroFormularioIvaDataAccess();
			
			this.parametroformularioivas= new ArrayList<ParametroFormularioIva>();
			this.parametroformularioiva= new ParametroFormularioIva();
			
			this.parametroformularioivaObject=new Object();
			this.parametroformularioivasObject=new ArrayList<Object>();
				
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
			
			this.parametroformularioivaDataAccess.setConnexionType(this.connexionType);
			this.parametroformularioivaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroFormularioIvaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametroformularioivaDataAccess = new ParametroFormularioIvaDataAccess();
			this.parametroformularioivas= new ArrayList<ParametroFormularioIva>();
			this.parametroformularioiva= new ParametroFormularioIva();
			this.parametroformularioivaObject=new Object();
			this.parametroformularioivasObject=new ArrayList<Object>();
			
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
			
			this.parametroformularioivaDataAccess.setConnexionType(this.connexionType);
			this.parametroformularioivaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroFormularioIva getParametroFormularioIva() throws Exception {	
		ParametroFormularioIvaLogicAdditional.checkParametroFormularioIvaToGet(parametroformularioiva,this.datosCliente,this.arrDatoGeneral);
		ParametroFormularioIvaLogicAdditional.updateParametroFormularioIvaToGet(parametroformularioiva,this.arrDatoGeneral);
		
		return parametroformularioiva;
	}
		
	public void setParametroFormularioIva(ParametroFormularioIva newParametroFormularioIva) {
		this.parametroformularioiva = newParametroFormularioIva;
	}
	
	public ParametroFormularioIvaDataAccess getParametroFormularioIvaDataAccess() {
		return parametroformularioivaDataAccess;
	}
	
	public void setParametroFormularioIvaDataAccess(ParametroFormularioIvaDataAccess newparametroformularioivaDataAccess) {
		this.parametroformularioivaDataAccess = newparametroformularioivaDataAccess;
	}
	
	public List<ParametroFormularioIva> getParametroFormularioIvas() throws Exception {		
		this.quitarParametroFormularioIvasNulos();
		
		ParametroFormularioIvaLogicAdditional.checkParametroFormularioIvaToGets(parametroformularioivas,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroFormularioIva parametroformularioivaLocal: parametroformularioivas ) {
			ParametroFormularioIvaLogicAdditional.updateParametroFormularioIvaToGet(parametroformularioivaLocal,this.arrDatoGeneral);
		}
		
		return parametroformularioivas;
	}
	
	public void setParametroFormularioIvas(List<ParametroFormularioIva> newParametroFormularioIvas) {
		this.parametroformularioivas = newParametroFormularioIvas;
	}
	
	public Object getParametroFormularioIvaObject() {	
		this.parametroformularioivaObject=this.parametroformularioivaDataAccess.getEntityObject();
		return this.parametroformularioivaObject;
	}
		
	public void setParametroFormularioIvaObject(Object newParametroFormularioIvaObject) {
		this.parametroformularioivaObject = newParametroFormularioIvaObject;
	}
	
	public List<Object> getParametroFormularioIvasObject() {		
		this.parametroformularioivasObject=this.parametroformularioivaDataAccess.getEntitiesObject();
		return this.parametroformularioivasObject;
	}
		
	public void setParametroFormularioIvasObject(List<Object> newParametroFormularioIvasObject) {
		this.parametroformularioivasObject = newParametroFormularioIvasObject;
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
		
		if(this.parametroformularioivaDataAccess!=null) {
			this.parametroformularioivaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametroformularioivaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametroformularioivaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametroformularioiva = new  ParametroFormularioIva();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametroformularioiva=parametroformularioivaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioiva);
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
		parametroformularioiva = new  ParametroFormularioIva();
		  		  
        try {
			
			parametroformularioiva=parametroformularioivaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametroformularioiva = new  ParametroFormularioIva();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametroformularioiva=parametroformularioivaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioiva);
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
		parametroformularioiva = new  ParametroFormularioIva();
		  		  
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
		parametroformularioiva = new  ParametroFormularioIva();
		  		  
        try {
			
			parametroformularioiva=parametroformularioivaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametroformularioiva = new  ParametroFormularioIva();
		  		  
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
		parametroformularioiva = new  ParametroFormularioIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametroformularioivaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroformularioiva = new  ParametroFormularioIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametroformularioivaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametroformularioiva = new  ParametroFormularioIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametroformularioivaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroformularioiva = new  ParametroFormularioIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametroformularioivaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametroformularioiva = new  ParametroFormularioIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametroformularioivaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroformularioiva = new  ParametroFormularioIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametroformularioivaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametroformularioivas = new  ArrayList<ParametroFormularioIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFormularioIva(parametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
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
		parametroformularioivas = new  ArrayList<ParametroFormularioIva>();
		  		  
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
		parametroformularioivas = new  ArrayList<ParametroFormularioIva>();
		  		  
        try {			
			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroFormularioIva(parametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametroformularioivas = new  ArrayList<ParametroFormularioIva>();
		  		  
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
		parametroformularioivas = new  ArrayList<ParametroFormularioIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFormularioIva(parametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
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
		parametroformularioivas = new  ArrayList<ParametroFormularioIva>();
		  		  
        try {
			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFormularioIva(parametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
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
		parametroformularioivas = new  ArrayList<ParametroFormularioIva>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFormularioIva(parametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
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
		parametroformularioivas = new  ArrayList<ParametroFormularioIva>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFormularioIva(parametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametroformularioiva = new  ParametroFormularioIva();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroformularioiva=parametroformularioivaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFormularioIva(parametroformularioiva);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioiva);
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
		parametroformularioiva = new  ParametroFormularioIva();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroformularioiva=parametroformularioivaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFormularioIva(parametroformularioiva);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametroformularioivas = new  ArrayList<ParametroFormularioIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroformularioivas=parametroformularioivaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFormularioIva(parametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
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
		parametroformularioivas = new  ArrayList<ParametroFormularioIva>();
		  		  
        try {
			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroformularioivas=parametroformularioivaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFormularioIva(parametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroFormularioIvasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametroformularioivas = new  ArrayList<ParametroFormularioIva>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-getTodosParametroFormularioIvasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroFormularioIva(parametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
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
	
	public  void  getTodosParametroFormularioIvas(String sFinalQuery,Pagination pagination)throws Exception {
		parametroformularioivas = new  ArrayList<ParametroFormularioIva>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroFormularioIva(parametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroFormularioIva(ParametroFormularioIva parametroformularioiva) throws Exception {
		Boolean estaValidado=false;
		
		if(parametroformularioiva.getIsNew() || parametroformularioiva.getIsChanged()) { 
			this.invalidValues = parametroformularioivaValidator.getInvalidValues(parametroformularioiva);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametroformularioiva);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroFormularioIva(List<ParametroFormularioIva> ParametroFormularioIvas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroFormularioIva parametroformularioivaLocal:parametroformularioivas) {				
			estaValidadoObjeto=this.validarGuardarParametroFormularioIva(parametroformularioivaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroFormularioIva(List<ParametroFormularioIva> ParametroFormularioIvas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroFormularioIva(parametroformularioivas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroFormularioIva(ParametroFormularioIva ParametroFormularioIva) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroFormularioIva(parametroformularioiva)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroFormularioIva parametroformularioiva) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametroformularioiva.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroFormularioIvaConstantesFunciones.getParametroFormularioIvaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametroformularioiva","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroFormularioIvaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroFormularioIvaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroFormularioIvaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-saveParametroFormularioIvaWithConnection");connexion.begin();			
			
			ParametroFormularioIvaLogicAdditional.checkParametroFormularioIvaToSave(this.parametroformularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroFormularioIvaLogicAdditional.updateParametroFormularioIvaToSave(this.parametroformularioiva,this.arrDatoGeneral);
			
			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametroformularioiva,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroFormularioIva();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroFormularioIva(this.parametroformularioiva)) {
				ParametroFormularioIvaDataAccess.save(this.parametroformularioiva, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroFormularioIvaLogicAdditional.checkParametroFormularioIvaToSaveAfter(this.parametroformularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroFormularioIva();
			
			connexion.commit();			
			
			if(this.parametroformularioiva.getIsDeleted()) {
				this.parametroformularioiva=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroFormularioIva()throws Exception {	
		try {	
			
			ParametroFormularioIvaLogicAdditional.checkParametroFormularioIvaToSave(this.parametroformularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroFormularioIvaLogicAdditional.updateParametroFormularioIvaToSave(this.parametroformularioiva,this.arrDatoGeneral);
			
			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametroformularioiva,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroFormularioIva(this.parametroformularioiva)) {			
				ParametroFormularioIvaDataAccess.save(this.parametroformularioiva, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroFormularioIvaLogicAdditional.checkParametroFormularioIvaToSaveAfter(this.parametroformularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametroformularioiva.getIsDeleted()) {
				this.parametroformularioiva=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroFormularioIvasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-saveParametroFormularioIvasWithConnection");connexion.begin();			
			
			ParametroFormularioIvaLogicAdditional.checkParametroFormularioIvaToSaves(parametroformularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroFormularioIvas();
			
			Boolean validadoTodosParametroFormularioIva=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroFormularioIva parametroformularioivaLocal:parametroformularioivas) {		
				if(parametroformularioivaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroFormularioIvaLogicAdditional.updateParametroFormularioIvaToSave(parametroformularioivaLocal,this.arrDatoGeneral);
	        	
				ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametroformularioivaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroFormularioIva(parametroformularioivaLocal)) {
					ParametroFormularioIvaDataAccess.save(parametroformularioivaLocal, connexion);				
				} else {
					validadoTodosParametroFormularioIva=false;
				}
			}
			
			if(!validadoTodosParametroFormularioIva) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroFormularioIvaLogicAdditional.checkParametroFormularioIvaToSavesAfter(parametroformularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroFormularioIvas();
			
			connexion.commit();		
			
			this.quitarParametroFormularioIvasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroFormularioIvas()throws Exception {				
		 try {	
			ParametroFormularioIvaLogicAdditional.checkParametroFormularioIvaToSaves(parametroformularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroFormularioIva=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroFormularioIva parametroformularioivaLocal:parametroformularioivas) {				
				if(parametroformularioivaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroFormularioIvaLogicAdditional.updateParametroFormularioIvaToSave(parametroformularioivaLocal,this.arrDatoGeneral);
	        	
				ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametroformularioivaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroFormularioIva(parametroformularioivaLocal)) {				
					ParametroFormularioIvaDataAccess.save(parametroformularioivaLocal, connexion);				
				} else {
					validadoTodosParametroFormularioIva=false;
				}
			}
			
			if(!validadoTodosParametroFormularioIva) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroFormularioIvaLogicAdditional.checkParametroFormularioIvaToSavesAfter(parametroformularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroFormularioIvasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroFormularioIvaParameterReturnGeneral procesarAccionParametroFormularioIvas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroFormularioIva> parametroformularioivas,ParametroFormularioIvaParameterReturnGeneral parametroformularioivaParameterGeneral)throws Exception {
		 try {	
			ParametroFormularioIvaParameterReturnGeneral parametroformularioivaReturnGeneral=new ParametroFormularioIvaParameterReturnGeneral();
	
			ParametroFormularioIvaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametroformularioivas,parametroformularioivaParameterGeneral,parametroformularioivaReturnGeneral);
			
			return parametroformularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroFormularioIvaParameterReturnGeneral procesarAccionParametroFormularioIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroFormularioIva> parametroformularioivas,ParametroFormularioIvaParameterReturnGeneral parametroformularioivaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-procesarAccionParametroFormularioIvasWithConnection");connexion.begin();			
			
			ParametroFormularioIvaParameterReturnGeneral parametroformularioivaReturnGeneral=new ParametroFormularioIvaParameterReturnGeneral();
	
			ParametroFormularioIvaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametroformularioivas,parametroformularioivaParameterGeneral,parametroformularioivaReturnGeneral);
			
			this.connexion.commit();
			
			return parametroformularioivaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroFormularioIvaParameterReturnGeneral procesarEventosParametroFormularioIvas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroFormularioIva> parametroformularioivas,ParametroFormularioIva parametroformularioiva,ParametroFormularioIvaParameterReturnGeneral parametroformularioivaParameterGeneral,Boolean isEsNuevoParametroFormularioIva,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroFormularioIvaParameterReturnGeneral parametroformularioivaReturnGeneral=new ParametroFormularioIvaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametroformularioivaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroFormularioIvaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametroformularioivas,parametroformularioiva,parametroformularioivaParameterGeneral,parametroformularioivaReturnGeneral,isEsNuevoParametroFormularioIva,clases);
			
			return parametroformularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroFormularioIvaParameterReturnGeneral procesarEventosParametroFormularioIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroFormularioIva> parametroformularioivas,ParametroFormularioIva parametroformularioiva,ParametroFormularioIvaParameterReturnGeneral parametroformularioivaParameterGeneral,Boolean isEsNuevoParametroFormularioIva,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-procesarEventosParametroFormularioIvasWithConnection");connexion.begin();			
			
			ParametroFormularioIvaParameterReturnGeneral parametroformularioivaReturnGeneral=new ParametroFormularioIvaParameterReturnGeneral();
	
			parametroformularioivaReturnGeneral.setParametroFormularioIva(parametroformularioiva);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametroformularioivaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroFormularioIvaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametroformularioivas,parametroformularioiva,parametroformularioivaParameterGeneral,parametroformularioivaReturnGeneral,isEsNuevoParametroFormularioIva,clases);
			
			this.connexion.commit();
			
			return parametroformularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroFormularioIvaParameterReturnGeneral procesarImportacionParametroFormularioIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroFormularioIvaParameterReturnGeneral parametroformularioivaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-procesarImportacionParametroFormularioIvasWithConnection");connexion.begin();			
			
			ParametroFormularioIvaParameterReturnGeneral parametroformularioivaReturnGeneral=new ParametroFormularioIvaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametroformularioivas=new ArrayList<ParametroFormularioIva>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametroformularioiva=new ParametroFormularioIva();
				
				
				if(conColumnasBase) {this.parametroformularioiva.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametroformularioiva.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.parametroformularioiva.setgrupo(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametroformularioiva.setgrupo2(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametroformularioiva.setcodigo_sri(arrColumnas[iColumn++]);
				this.parametroformularioiva.setnombre(arrColumnas[iColumn++]);
				this.parametroformularioiva.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.parametroformularioiva.setcon_total(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.parametroformularioivas.add(this.parametroformularioiva);
			}
			
			this.saveParametroFormularioIvas();
			
			this.connexion.commit();
			
			parametroformularioivaReturnGeneral.setConRetornoEstaProcesado(true);
			parametroformularioivaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametroformularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroFormularioIvasEliminados() throws Exception {				
		
		List<ParametroFormularioIva> parametroformularioivasAux= new ArrayList<ParametroFormularioIva>();
		
		for(ParametroFormularioIva parametroformularioiva:parametroformularioivas) {
			if(!parametroformularioiva.getIsDeleted()) {
				parametroformularioivasAux.add(parametroformularioiva);
			}
		}
		
		parametroformularioivas=parametroformularioivasAux;
	}
	
	public void quitarParametroFormularioIvasNulos() throws Exception {				
		
		List<ParametroFormularioIva> parametroformularioivasAux= new ArrayList<ParametroFormularioIva>();
		
		for(ParametroFormularioIva parametroformularioiva : this.parametroformularioivas) {
			if(parametroformularioiva==null) {
				parametroformularioivasAux.add(parametroformularioiva);
			}
		}
		
		//this.parametroformularioivas=parametroformularioivasAux;
		
		this.parametroformularioivas.removeAll(parametroformularioivasAux);
	}
	
	public void getSetVersionRowParametroFormularioIvaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametroformularioiva.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametroformularioiva.getIsDeleted() || (parametroformularioiva.getIsChanged()&&!parametroformularioiva.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametroformularioivaDataAccess.getSetVersionRowParametroFormularioIva(connexion,parametroformularioiva.getId());
				
				if(!parametroformularioiva.getVersionRow().equals(timestamp)) {	
					parametroformularioiva.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametroformularioiva.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroFormularioIva()throws Exception {	
		
		if(parametroformularioiva.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametroformularioiva.getIsDeleted() || (parametroformularioiva.getIsChanged()&&!parametroformularioiva.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametroformularioivaDataAccess.getSetVersionRowParametroFormularioIva(connexion,parametroformularioiva.getId());
			
			try {							
				if(!parametroformularioiva.getVersionRow().equals(timestamp)) {	
					parametroformularioiva.setVersionRow(timestamp);
				}
				
				parametroformularioiva.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroFormularioIvasWithConnection()throws Exception {	
		if(parametroformularioivas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroFormularioIva parametroformularioivaAux:parametroformularioivas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametroformularioivaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametroformularioivaAux.getIsDeleted() || (parametroformularioivaAux.getIsChanged()&&!parametroformularioivaAux.getIsNew())) {
						
						timestamp=parametroformularioivaDataAccess.getSetVersionRowParametroFormularioIva(connexion,parametroformularioivaAux.getId());
						
						if(!parametroformularioiva.getVersionRow().equals(timestamp)) {	
							parametroformularioivaAux.setVersionRow(timestamp);
						}
								
						parametroformularioivaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroFormularioIvas()throws Exception {	
		if(parametroformularioivas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroFormularioIva parametroformularioivaAux:parametroformularioivas) {
					if(parametroformularioivaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametroformularioivaAux.getIsDeleted() || (parametroformularioivaAux.getIsChanged()&&!parametroformularioivaAux.getIsNew())) {
						
						timestamp=parametroformularioivaDataAccess.getSetVersionRowParametroFormularioIva(connexion,parametroformularioivaAux.getId());
						
						if(!parametroformularioivaAux.getVersionRow().equals(timestamp)) {	
							parametroformularioivaAux.setVersionRow(timestamp);
						}
						
													
						parametroformularioivaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroFormularioIvaParameterReturnGeneral cargarCombosLoteForeignKeyParametroFormularioIvaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoParametroFormularioIva,String finalQueryGlobalGrupoParametroFormularioIva,String finalQueryGlobalSubGrupoParametroFormularioIva,String finalQueryGlobalCuentaContable1,String finalQueryGlobalCuentaContable2,String finalQueryGlobalCuentaContable3,String finalQueryGlobalCuentaContable4,String finalQueryGlobalCuentaContable5) throws Exception {
		ParametroFormularioIvaParameterReturnGeneral  parametroformularioivaReturnGeneral =new ParametroFormularioIvaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroFormularioIvaWithConnection");connexion.begin();
			
			parametroformularioivaReturnGeneral =new ParametroFormularioIvaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametroformularioivaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoParametroFormularioIva> tipoparametroformularioivasForeignKey=new ArrayList<TipoParametroFormularioIva>();
			TipoParametroFormularioIvaLogic tipoparametroformularioivaLogic=new TipoParametroFormularioIvaLogic();
			tipoparametroformularioivaLogic.setConnexion(this.connexion);
			tipoparametroformularioivaLogic.getTipoParametroFormularioIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoParametroFormularioIva.equals("NONE")) {
				tipoparametroformularioivaLogic.getTodosTipoParametroFormularioIvas(finalQueryGlobalTipoParametroFormularioIva,new Pagination());
				tipoparametroformularioivasForeignKey=tipoparametroformularioivaLogic.getTipoParametroFormularioIvas();
			}

			parametroformularioivaReturnGeneral.settipoparametroformularioivasForeignKey(tipoparametroformularioivasForeignKey);


			List<GrupoParametroFormularioIva> grupoparametroformularioivasForeignKey=new ArrayList<GrupoParametroFormularioIva>();
			GrupoParametroFormularioIvaLogic grupoparametroformularioivaLogic=new GrupoParametroFormularioIvaLogic();
			grupoparametroformularioivaLogic.setConnexion(this.connexion);
			grupoparametroformularioivaLogic.getGrupoParametroFormularioIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGrupoParametroFormularioIva.equals("NONE")) {
				grupoparametroformularioivaLogic.getTodosGrupoParametroFormularioIvas(finalQueryGlobalGrupoParametroFormularioIva,new Pagination());
				grupoparametroformularioivasForeignKey=grupoparametroformularioivaLogic.getGrupoParametroFormularioIvas();
			}

			parametroformularioivaReturnGeneral.setgrupoparametroformularioivasForeignKey(grupoparametroformularioivasForeignKey);


			List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivasForeignKey=new ArrayList<SubGrupoParametroFormularioIva>();
			SubGrupoParametroFormularioIvaLogic subgrupoparametroformularioivaLogic=new SubGrupoParametroFormularioIvaLogic();
			subgrupoparametroformularioivaLogic.setConnexion(this.connexion);
			subgrupoparametroformularioivaLogic.getSubGrupoParametroFormularioIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSubGrupoParametroFormularioIva.equals("NONE")) {
				subgrupoparametroformularioivaLogic.getTodosSubGrupoParametroFormularioIvas(finalQueryGlobalSubGrupoParametroFormularioIva,new Pagination());
				subgrupoparametroformularioivasForeignKey=subgrupoparametroformularioivaLogic.getSubGrupoParametroFormularioIvas();
			}

			parametroformularioivaReturnGeneral.setsubgrupoparametroformularioivasForeignKey(subgrupoparametroformularioivasForeignKey);


			List<CuentaContable> cuentacontable1sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontable1Logic=new CuentaContableLogic();
			cuentacontable1Logic.setConnexion(this.connexion);
			cuentacontable1Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable1.equals("NONE")) {
				cuentacontable1Logic.getTodosCuentaContables(finalQueryGlobalCuentaContable1,new Pagination());
				cuentacontable1sForeignKey=cuentacontable1Logic.getCuentaContables();
			}

			parametroformularioivaReturnGeneral.setcuentacontable1sForeignKey(cuentacontable1sForeignKey);


			List<CuentaContable> cuentacontable2sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontable2Logic=new CuentaContableLogic();
			cuentacontable2Logic.setConnexion(this.connexion);
			cuentacontable2Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable2.equals("NONE")) {
				cuentacontable2Logic.getTodosCuentaContables(finalQueryGlobalCuentaContable2,new Pagination());
				cuentacontable2sForeignKey=cuentacontable2Logic.getCuentaContables();
			}

			parametroformularioivaReturnGeneral.setcuentacontable2sForeignKey(cuentacontable2sForeignKey);


			List<CuentaContable> cuentacontable3sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontable3Logic=new CuentaContableLogic();
			cuentacontable3Logic.setConnexion(this.connexion);
			cuentacontable3Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable3.equals("NONE")) {
				cuentacontable3Logic.getTodosCuentaContables(finalQueryGlobalCuentaContable3,new Pagination());
				cuentacontable3sForeignKey=cuentacontable3Logic.getCuentaContables();
			}

			parametroformularioivaReturnGeneral.setcuentacontable3sForeignKey(cuentacontable3sForeignKey);


			List<CuentaContable> cuentacontable4sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontable4Logic=new CuentaContableLogic();
			cuentacontable4Logic.setConnexion(this.connexion);
			cuentacontable4Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable4.equals("NONE")) {
				cuentacontable4Logic.getTodosCuentaContables(finalQueryGlobalCuentaContable4,new Pagination());
				cuentacontable4sForeignKey=cuentacontable4Logic.getCuentaContables();
			}

			parametroformularioivaReturnGeneral.setcuentacontable4sForeignKey(cuentacontable4sForeignKey);


			List<CuentaContable> cuentacontable5sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontable5Logic=new CuentaContableLogic();
			cuentacontable5Logic.setConnexion(this.connexion);
			cuentacontable5Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable5.equals("NONE")) {
				cuentacontable5Logic.getTodosCuentaContables(finalQueryGlobalCuentaContable5,new Pagination());
				cuentacontable5sForeignKey=cuentacontable5Logic.getCuentaContables();
			}

			parametroformularioivaReturnGeneral.setcuentacontable5sForeignKey(cuentacontable5sForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametroformularioivaReturnGeneral;
	}
	
	public ParametroFormularioIvaParameterReturnGeneral cargarCombosLoteForeignKeyParametroFormularioIva(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoParametroFormularioIva,String finalQueryGlobalGrupoParametroFormularioIva,String finalQueryGlobalSubGrupoParametroFormularioIva,String finalQueryGlobalCuentaContable1,String finalQueryGlobalCuentaContable2,String finalQueryGlobalCuentaContable3,String finalQueryGlobalCuentaContable4,String finalQueryGlobalCuentaContable5) throws Exception {
		ParametroFormularioIvaParameterReturnGeneral  parametroformularioivaReturnGeneral =new ParametroFormularioIvaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametroformularioivaReturnGeneral =new ParametroFormularioIvaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametroformularioivaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoParametroFormularioIva> tipoparametroformularioivasForeignKey=new ArrayList<TipoParametroFormularioIva>();
			TipoParametroFormularioIvaLogic tipoparametroformularioivaLogic=new TipoParametroFormularioIvaLogic();
			tipoparametroformularioivaLogic.setConnexion(this.connexion);
			tipoparametroformularioivaLogic.getTipoParametroFormularioIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoParametroFormularioIva.equals("NONE")) {
				tipoparametroformularioivaLogic.getTodosTipoParametroFormularioIvas(finalQueryGlobalTipoParametroFormularioIva,new Pagination());
				tipoparametroformularioivasForeignKey=tipoparametroformularioivaLogic.getTipoParametroFormularioIvas();
			}

			parametroformularioivaReturnGeneral.settipoparametroformularioivasForeignKey(tipoparametroformularioivasForeignKey);


			List<GrupoParametroFormularioIva> grupoparametroformularioivasForeignKey=new ArrayList<GrupoParametroFormularioIva>();
			GrupoParametroFormularioIvaLogic grupoparametroformularioivaLogic=new GrupoParametroFormularioIvaLogic();
			grupoparametroformularioivaLogic.setConnexion(this.connexion);
			grupoparametroformularioivaLogic.getGrupoParametroFormularioIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGrupoParametroFormularioIva.equals("NONE")) {
				grupoparametroformularioivaLogic.getTodosGrupoParametroFormularioIvas(finalQueryGlobalGrupoParametroFormularioIva,new Pagination());
				grupoparametroformularioivasForeignKey=grupoparametroformularioivaLogic.getGrupoParametroFormularioIvas();
			}

			parametroformularioivaReturnGeneral.setgrupoparametroformularioivasForeignKey(grupoparametroformularioivasForeignKey);


			List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivasForeignKey=new ArrayList<SubGrupoParametroFormularioIva>();
			SubGrupoParametroFormularioIvaLogic subgrupoparametroformularioivaLogic=new SubGrupoParametroFormularioIvaLogic();
			subgrupoparametroformularioivaLogic.setConnexion(this.connexion);
			subgrupoparametroformularioivaLogic.getSubGrupoParametroFormularioIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSubGrupoParametroFormularioIva.equals("NONE")) {
				subgrupoparametroformularioivaLogic.getTodosSubGrupoParametroFormularioIvas(finalQueryGlobalSubGrupoParametroFormularioIva,new Pagination());
				subgrupoparametroformularioivasForeignKey=subgrupoparametroformularioivaLogic.getSubGrupoParametroFormularioIvas();
			}

			parametroformularioivaReturnGeneral.setsubgrupoparametroformularioivasForeignKey(subgrupoparametroformularioivasForeignKey);


			List<CuentaContable> cuentacontable1sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontable1Logic=new CuentaContableLogic();
			cuentacontable1Logic.setConnexion(this.connexion);
			cuentacontable1Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable1.equals("NONE")) {
				cuentacontable1Logic.getTodosCuentaContables(finalQueryGlobalCuentaContable1,new Pagination());
				cuentacontable1sForeignKey=cuentacontable1Logic.getCuentaContables();
			}

			parametroformularioivaReturnGeneral.setcuentacontable1sForeignKey(cuentacontable1sForeignKey);


			List<CuentaContable> cuentacontable2sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontable2Logic=new CuentaContableLogic();
			cuentacontable2Logic.setConnexion(this.connexion);
			cuentacontable2Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable2.equals("NONE")) {
				cuentacontable2Logic.getTodosCuentaContables(finalQueryGlobalCuentaContable2,new Pagination());
				cuentacontable2sForeignKey=cuentacontable2Logic.getCuentaContables();
			}

			parametroformularioivaReturnGeneral.setcuentacontable2sForeignKey(cuentacontable2sForeignKey);


			List<CuentaContable> cuentacontable3sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontable3Logic=new CuentaContableLogic();
			cuentacontable3Logic.setConnexion(this.connexion);
			cuentacontable3Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable3.equals("NONE")) {
				cuentacontable3Logic.getTodosCuentaContables(finalQueryGlobalCuentaContable3,new Pagination());
				cuentacontable3sForeignKey=cuentacontable3Logic.getCuentaContables();
			}

			parametroformularioivaReturnGeneral.setcuentacontable3sForeignKey(cuentacontable3sForeignKey);


			List<CuentaContable> cuentacontable4sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontable4Logic=new CuentaContableLogic();
			cuentacontable4Logic.setConnexion(this.connexion);
			cuentacontable4Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable4.equals("NONE")) {
				cuentacontable4Logic.getTodosCuentaContables(finalQueryGlobalCuentaContable4,new Pagination());
				cuentacontable4sForeignKey=cuentacontable4Logic.getCuentaContables();
			}

			parametroformularioivaReturnGeneral.setcuentacontable4sForeignKey(cuentacontable4sForeignKey);


			List<CuentaContable> cuentacontable5sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontable5Logic=new CuentaContableLogic();
			cuentacontable5Logic.setConnexion(this.connexion);
			cuentacontable5Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable5.equals("NONE")) {
				cuentacontable5Logic.getTodosCuentaContables(finalQueryGlobalCuentaContable5,new Pagination());
				cuentacontable5sForeignKey=cuentacontable5Logic.getCuentaContables();
			}

			parametroformularioivaReturnGeneral.setcuentacontable5sForeignKey(cuentacontable5sForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametroformularioivaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyParametroFormularioIvaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			FormularioRentaLogic formulariorentaLogic=new FormularioRentaLogic();
			FormularioIvaLogic formularioivaLogic=new FormularioIvaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyParametroFormularioIvaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(FormularioRenta.class));
			classes.add(new Classe(FormularioIva.class));
											
			

			formulariorentaLogic.setConnexion(this.getConnexion());
			formulariorentaLogic.setDatosCliente(this.datosCliente);
			formulariorentaLogic.setIsConRefrescarForeignKeys(true);

			formularioivaLogic.setConnexion(this.getConnexion());
			formularioivaLogic.setDatosCliente(this.datosCliente);
			formularioivaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(ParametroFormularioIva parametroformularioiva:this.parametroformularioivas) {
				

				classes=new ArrayList<Classe>();
				classes=FormularioRentaConstantesFunciones.getClassesForeignKeysOfFormularioRenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				formulariorentaLogic.setFormularioRentas(parametroformularioiva.formulariorentas);
				formulariorentaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=FormularioIvaConstantesFunciones.getClassesForeignKeysOfFormularioIva(new ArrayList<Classe>(),DeepLoadType.NONE);

				formularioivaLogic.setFormularioIvas(parametroformularioiva.formularioivas);
				formularioivaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(ParametroFormularioIva parametroformularioiva,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroFormularioIvaLogicAdditional.updateParametroFormularioIvaToGet(parametroformularioiva,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametroformularioiva.setEmpresa(parametroformularioivaDataAccess.getEmpresa(connexion,parametroformularioiva));
		parametroformularioiva.setTipoParametroFormularioIva(parametroformularioivaDataAccess.getTipoParametroFormularioIva(connexion,parametroformularioiva));
		parametroformularioiva.setGrupoParametroFormularioIva(parametroformularioivaDataAccess.getGrupoParametroFormularioIva(connexion,parametroformularioiva));
		parametroformularioiva.setSubGrupoParametroFormularioIva(parametroformularioivaDataAccess.getSubGrupoParametroFormularioIva(connexion,parametroformularioiva));
		parametroformularioiva.setCuentaContable1(parametroformularioivaDataAccess.getCuentaContable1(connexion,parametroformularioiva));
		parametroformularioiva.setCuentaContable2(parametroformularioivaDataAccess.getCuentaContable2(connexion,parametroformularioiva));
		parametroformularioiva.setCuentaContable3(parametroformularioivaDataAccess.getCuentaContable3(connexion,parametroformularioiva));
		parametroformularioiva.setCuentaContable4(parametroformularioivaDataAccess.getCuentaContable4(connexion,parametroformularioiva));
		parametroformularioiva.setCuentaContable5(parametroformularioivaDataAccess.getCuentaContable5(connexion,parametroformularioiva));
		parametroformularioiva.setFormularioRentas(parametroformularioivaDataAccess.getFormularioRentas(connexion,parametroformularioiva));
		parametroformularioiva.setFormularioIvas(parametroformularioivaDataAccess.getFormularioIvas(connexion,parametroformularioiva));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametroformularioiva.setEmpresa(parametroformularioivaDataAccess.getEmpresa(connexion,parametroformularioiva));
				continue;
			}

			if(clas.clas.equals(TipoParametroFormularioIva.class)) {
				parametroformularioiva.setTipoParametroFormularioIva(parametroformularioivaDataAccess.getTipoParametroFormularioIva(connexion,parametroformularioiva));
				continue;
			}

			if(clas.clas.equals(GrupoParametroFormularioIva.class)) {
				parametroformularioiva.setGrupoParametroFormularioIva(parametroformularioivaDataAccess.getGrupoParametroFormularioIva(connexion,parametroformularioiva));
				continue;
			}

			if(clas.clas.equals(SubGrupoParametroFormularioIva.class)) {
				parametroformularioiva.setSubGrupoParametroFormularioIva(parametroformularioivaDataAccess.getSubGrupoParametroFormularioIva(connexion,parametroformularioiva));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroformularioiva.setCuentaContable1(parametroformularioivaDataAccess.getCuentaContable1(connexion,parametroformularioiva));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroformularioiva.setCuentaContable2(parametroformularioivaDataAccess.getCuentaContable2(connexion,parametroformularioiva));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroformularioiva.setCuentaContable3(parametroformularioivaDataAccess.getCuentaContable3(connexion,parametroformularioiva));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroformularioiva.setCuentaContable4(parametroformularioivaDataAccess.getCuentaContable4(connexion,parametroformularioiva));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroformularioiva.setCuentaContable5(parametroformularioivaDataAccess.getCuentaContable5(connexion,parametroformularioiva));
				continue;
			}

			if(clas.clas.equals(FormularioRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				parametroformularioiva.setFormularioRentas(parametroformularioivaDataAccess.getFormularioRentas(connexion,parametroformularioiva));

				if(this.isConDeep) {
					FormularioRentaLogic formulariorentaLogic= new FormularioRentaLogic(this.connexion);
					formulariorentaLogic.setFormularioRentas(parametroformularioiva.getFormularioRentas());
					ArrayList<Classe> classesLocal=FormularioRentaConstantesFunciones.getClassesForeignKeysOfFormularioRenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					formulariorentaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(formulariorentaLogic.getFormularioRentas());
					parametroformularioiva.setFormularioRentas(formulariorentaLogic.getFormularioRentas());
				}

				continue;
			}

			if(clas.clas.equals(FormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				parametroformularioiva.setFormularioIvas(parametroformularioivaDataAccess.getFormularioIvas(connexion,parametroformularioiva));

				if(this.isConDeep) {
					FormularioIvaLogic formularioivaLogic= new FormularioIvaLogic(this.connexion);
					formularioivaLogic.setFormularioIvas(parametroformularioiva.getFormularioIvas());
					ArrayList<Classe> classesLocal=FormularioIvaConstantesFunciones.getClassesForeignKeysOfFormularioIva(new ArrayList<Classe>(),DeepLoadType.NONE);
					formularioivaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(formularioivaLogic.getFormularioIvas());
					parametroformularioiva.setFormularioIvas(formularioivaLogic.getFormularioIvas());
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
			parametroformularioiva.setEmpresa(parametroformularioivaDataAccess.getEmpresa(connexion,parametroformularioiva));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoParametroFormularioIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroformularioiva.setTipoParametroFormularioIva(parametroformularioivaDataAccess.getTipoParametroFormularioIva(connexion,parametroformularioiva));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoParametroFormularioIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroformularioiva.setGrupoParametroFormularioIva(parametroformularioivaDataAccess.getGrupoParametroFormularioIva(connexion,parametroformularioiva));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubGrupoParametroFormularioIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroformularioiva.setSubGrupoParametroFormularioIva(parametroformularioivaDataAccess.getSubGrupoParametroFormularioIva(connexion,parametroformularioiva));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroformularioiva.setCuentaContable1(parametroformularioivaDataAccess.getCuentaContable1(connexion,parametroformularioiva));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroformularioiva.setCuentaContable2(parametroformularioivaDataAccess.getCuentaContable2(connexion,parametroformularioiva));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroformularioiva.setCuentaContable3(parametroformularioivaDataAccess.getCuentaContable3(connexion,parametroformularioiva));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroformularioiva.setCuentaContable4(parametroformularioivaDataAccess.getCuentaContable4(connexion,parametroformularioiva));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroformularioiva.setCuentaContable5(parametroformularioivaDataAccess.getCuentaContable5(connexion,parametroformularioiva));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormularioRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormularioRenta.class));
			parametroformularioiva.setFormularioRentas(parametroformularioivaDataAccess.getFormularioRentas(connexion,parametroformularioiva));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormularioIva.class));
			parametroformularioiva.setFormularioIvas(parametroformularioivaDataAccess.getFormularioIvas(connexion,parametroformularioiva));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametroformularioiva.setEmpresa(parametroformularioivaDataAccess.getEmpresa(connexion,parametroformularioiva));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametroformularioiva.getEmpresa(),isDeep,deepLoadType,clases);
				
		parametroformularioiva.setTipoParametroFormularioIva(parametroformularioivaDataAccess.getTipoParametroFormularioIva(connexion,parametroformularioiva));
		TipoParametroFormularioIvaLogic tipoparametroformularioivaLogic= new TipoParametroFormularioIvaLogic(connexion);
		tipoparametroformularioivaLogic.deepLoad(parametroformularioiva.getTipoParametroFormularioIva(),isDeep,deepLoadType,clases);
				
		parametroformularioiva.setGrupoParametroFormularioIva(parametroformularioivaDataAccess.getGrupoParametroFormularioIva(connexion,parametroformularioiva));
		GrupoParametroFormularioIvaLogic grupoparametroformularioivaLogic= new GrupoParametroFormularioIvaLogic(connexion);
		grupoparametroformularioivaLogic.deepLoad(parametroformularioiva.getGrupoParametroFormularioIva(),isDeep,deepLoadType,clases);
				
		parametroformularioiva.setSubGrupoParametroFormularioIva(parametroformularioivaDataAccess.getSubGrupoParametroFormularioIva(connexion,parametroformularioiva));
		SubGrupoParametroFormularioIvaLogic subgrupoparametroformularioivaLogic= new SubGrupoParametroFormularioIvaLogic(connexion);
		subgrupoparametroformularioivaLogic.deepLoad(parametroformularioiva.getSubGrupoParametroFormularioIva(),isDeep,deepLoadType,clases);
				
		parametroformularioiva.setCuentaContable1(parametroformularioivaDataAccess.getCuentaContable1(connexion,parametroformularioiva));
		CuentaContableLogic cuentacontable1Logic= new CuentaContableLogic(connexion);
		cuentacontable1Logic.deepLoad(parametroformularioiva.getCuentaContable1(),isDeep,deepLoadType,clases);
				
		parametroformularioiva.setCuentaContable2(parametroformularioivaDataAccess.getCuentaContable2(connexion,parametroformularioiva));
		CuentaContableLogic cuentacontable2Logic= new CuentaContableLogic(connexion);
		cuentacontable2Logic.deepLoad(parametroformularioiva.getCuentaContable2(),isDeep,deepLoadType,clases);
				
		parametroformularioiva.setCuentaContable3(parametroformularioivaDataAccess.getCuentaContable3(connexion,parametroformularioiva));
		CuentaContableLogic cuentacontable3Logic= new CuentaContableLogic(connexion);
		cuentacontable3Logic.deepLoad(parametroformularioiva.getCuentaContable3(),isDeep,deepLoadType,clases);
				
		parametroformularioiva.setCuentaContable4(parametroformularioivaDataAccess.getCuentaContable4(connexion,parametroformularioiva));
		CuentaContableLogic cuentacontable4Logic= new CuentaContableLogic(connexion);
		cuentacontable4Logic.deepLoad(parametroformularioiva.getCuentaContable4(),isDeep,deepLoadType,clases);
				
		parametroformularioiva.setCuentaContable5(parametroformularioivaDataAccess.getCuentaContable5(connexion,parametroformularioiva));
		CuentaContableLogic cuentacontable5Logic= new CuentaContableLogic(connexion);
		cuentacontable5Logic.deepLoad(parametroformularioiva.getCuentaContable5(),isDeep,deepLoadType,clases);
				

		parametroformularioiva.setFormularioRentas(parametroformularioivaDataAccess.getFormularioRentas(connexion,parametroformularioiva));

		for(FormularioRenta formulariorenta:parametroformularioiva.getFormularioRentas()) {
			FormularioRentaLogic formulariorentaLogic= new FormularioRentaLogic(connexion);
			formulariorentaLogic.deepLoad(formulariorenta,isDeep,deepLoadType,clases);
		}

		parametroformularioiva.setFormularioIvas(parametroformularioivaDataAccess.getFormularioIvas(connexion,parametroformularioiva));

		for(FormularioIva formularioiva:parametroformularioiva.getFormularioIvas()) {
			FormularioIvaLogic formularioivaLogic= new FormularioIvaLogic(connexion);
			formularioivaLogic.deepLoad(formularioiva,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametroformularioiva.setEmpresa(parametroformularioivaDataAccess.getEmpresa(connexion,parametroformularioiva));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametroformularioiva.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoParametroFormularioIva.class)) {
				parametroformularioiva.setTipoParametroFormularioIva(parametroformularioivaDataAccess.getTipoParametroFormularioIva(connexion,parametroformularioiva));
				TipoParametroFormularioIvaLogic tipoparametroformularioivaLogic= new TipoParametroFormularioIvaLogic(connexion);
				tipoparametroformularioivaLogic.deepLoad(parametroformularioiva.getTipoParametroFormularioIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GrupoParametroFormularioIva.class)) {
				parametroformularioiva.setGrupoParametroFormularioIva(parametroformularioivaDataAccess.getGrupoParametroFormularioIva(connexion,parametroformularioiva));
				GrupoParametroFormularioIvaLogic grupoparametroformularioivaLogic= new GrupoParametroFormularioIvaLogic(connexion);
				grupoparametroformularioivaLogic.deepLoad(parametroformularioiva.getGrupoParametroFormularioIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SubGrupoParametroFormularioIva.class)) {
				parametroformularioiva.setSubGrupoParametroFormularioIva(parametroformularioivaDataAccess.getSubGrupoParametroFormularioIva(connexion,parametroformularioiva));
				SubGrupoParametroFormularioIvaLogic subgrupoparametroformularioivaLogic= new SubGrupoParametroFormularioIvaLogic(connexion);
				subgrupoparametroformularioivaLogic.deepLoad(parametroformularioiva.getSubGrupoParametroFormularioIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroformularioiva.setCuentaContable1(parametroformularioivaDataAccess.getCuentaContable1(connexion,parametroformularioiva));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametroformularioiva.getCuentaContable1(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroformularioiva.setCuentaContable2(parametroformularioivaDataAccess.getCuentaContable2(connexion,parametroformularioiva));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametroformularioiva.getCuentaContable2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroformularioiva.setCuentaContable3(parametroformularioivaDataAccess.getCuentaContable3(connexion,parametroformularioiva));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametroformularioiva.getCuentaContable3(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroformularioiva.setCuentaContable4(parametroformularioivaDataAccess.getCuentaContable4(connexion,parametroformularioiva));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametroformularioiva.getCuentaContable4(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroformularioiva.setCuentaContable5(parametroformularioivaDataAccess.getCuentaContable5(connexion,parametroformularioiva));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametroformularioiva.getCuentaContable5(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormularioRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				parametroformularioiva.setFormularioRentas(parametroformularioivaDataAccess.getFormularioRentas(connexion,parametroformularioiva));

				for(FormularioRenta formulariorenta:parametroformularioiva.getFormularioRentas()) {
					FormularioRentaLogic formulariorentaLogic= new FormularioRentaLogic(connexion);
					formulariorentaLogic.deepLoad(formulariorenta,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				parametroformularioiva.setFormularioIvas(parametroformularioivaDataAccess.getFormularioIvas(connexion,parametroformularioiva));

				for(FormularioIva formularioiva:parametroformularioiva.getFormularioIvas()) {
					FormularioIvaLogic formularioivaLogic= new FormularioIvaLogic(connexion);
					formularioivaLogic.deepLoad(formularioiva,isDeep,deepLoadType,clases);
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
			parametroformularioiva.setEmpresa(parametroformularioivaDataAccess.getEmpresa(connexion,parametroformularioiva));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametroformularioiva.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoParametroFormularioIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroformularioiva.setTipoParametroFormularioIva(parametroformularioivaDataAccess.getTipoParametroFormularioIva(connexion,parametroformularioiva));
			TipoParametroFormularioIvaLogic tipoparametroformularioivaLogic= new TipoParametroFormularioIvaLogic(connexion);
			tipoparametroformularioivaLogic.deepLoad(parametroformularioiva.getTipoParametroFormularioIva(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoParametroFormularioIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroformularioiva.setGrupoParametroFormularioIva(parametroformularioivaDataAccess.getGrupoParametroFormularioIva(connexion,parametroformularioiva));
			GrupoParametroFormularioIvaLogic grupoparametroformularioivaLogic= new GrupoParametroFormularioIvaLogic(connexion);
			grupoparametroformularioivaLogic.deepLoad(parametroformularioiva.getGrupoParametroFormularioIva(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(SubGrupoParametroFormularioIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroformularioiva.setSubGrupoParametroFormularioIva(parametroformularioivaDataAccess.getSubGrupoParametroFormularioIva(connexion,parametroformularioiva));
			SubGrupoParametroFormularioIvaLogic subgrupoparametroformularioivaLogic= new SubGrupoParametroFormularioIvaLogic(connexion);
			subgrupoparametroformularioivaLogic.deepLoad(parametroformularioiva.getSubGrupoParametroFormularioIva(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroformularioiva.setCuentaContable1(parametroformularioivaDataAccess.getCuentaContable1(connexion,parametroformularioiva));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametroformularioiva.getCuentaContable1(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroformularioiva.setCuentaContable2(parametroformularioivaDataAccess.getCuentaContable2(connexion,parametroformularioiva));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametroformularioiva.getCuentaContable2(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroformularioiva.setCuentaContable3(parametroformularioivaDataAccess.getCuentaContable3(connexion,parametroformularioiva));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametroformularioiva.getCuentaContable3(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroformularioiva.setCuentaContable4(parametroformularioivaDataAccess.getCuentaContable4(connexion,parametroformularioiva));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametroformularioiva.getCuentaContable4(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroformularioiva.setCuentaContable5(parametroformularioivaDataAccess.getCuentaContable5(connexion,parametroformularioiva));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametroformularioiva.getCuentaContable5(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormularioRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormularioRenta.class));
			parametroformularioiva.setFormularioRentas(parametroformularioivaDataAccess.getFormularioRentas(connexion,parametroformularioiva));

			for(FormularioRenta formulariorenta:parametroformularioiva.getFormularioRentas()) {
				FormularioRentaLogic formulariorentaLogic= new FormularioRentaLogic(connexion);
				formulariorentaLogic.deepLoad(formulariorenta,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormularioIva.class));
			parametroformularioiva.setFormularioIvas(parametroformularioivaDataAccess.getFormularioIvas(connexion,parametroformularioiva));

			for(FormularioIva formularioiva:parametroformularioiva.getFormularioIvas()) {
				FormularioIvaLogic formularioivaLogic= new FormularioIvaLogic(connexion);
				formularioivaLogic.deepLoad(formularioiva,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroFormularioIva parametroformularioiva,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroFormularioIvaLogicAdditional.updateParametroFormularioIvaToSave(parametroformularioiva,this.arrDatoGeneral);
			
ParametroFormularioIvaDataAccess.save(parametroformularioiva, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametroformularioiva.getEmpresa(),connexion);

		TipoParametroFormularioIvaDataAccess.save(parametroformularioiva.getTipoParametroFormularioIva(),connexion);

		GrupoParametroFormularioIvaDataAccess.save(parametroformularioiva.getGrupoParametroFormularioIva(),connexion);

		SubGrupoParametroFormularioIvaDataAccess.save(parametroformularioiva.getSubGrupoParametroFormularioIva(),connexion);

		CuentaContableDataAccess.save(parametroformularioiva.getCuentaContable1(),connexion);

		CuentaContableDataAccess.save(parametroformularioiva.getCuentaContable2(),connexion);

		CuentaContableDataAccess.save(parametroformularioiva.getCuentaContable3(),connexion);

		CuentaContableDataAccess.save(parametroformularioiva.getCuentaContable4(),connexion);

		CuentaContableDataAccess.save(parametroformularioiva.getCuentaContable5(),connexion);

		for(FormularioRenta formulariorenta:parametroformularioiva.getFormularioRentas()) {
			formulariorenta.setid_parametro_formulario_iva(parametroformularioiva.getId());
			FormularioRentaDataAccess.save(formulariorenta,connexion);
		}

		for(FormularioIva formularioiva:parametroformularioiva.getFormularioIvas()) {
			formularioiva.setid_parametro_formulario_iva(parametroformularioiva.getId());
			FormularioIvaDataAccess.save(formularioiva,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametroformularioiva.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoParametroFormularioIva.class)) {
				TipoParametroFormularioIvaDataAccess.save(parametroformularioiva.getTipoParametroFormularioIva(),connexion);
				continue;
			}

			if(clas.clas.equals(GrupoParametroFormularioIva.class)) {
				GrupoParametroFormularioIvaDataAccess.save(parametroformularioiva.getGrupoParametroFormularioIva(),connexion);
				continue;
			}

			if(clas.clas.equals(SubGrupoParametroFormularioIva.class)) {
				SubGrupoParametroFormularioIvaDataAccess.save(parametroformularioiva.getSubGrupoParametroFormularioIva(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroformularioiva.getCuentaContable1(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroformularioiva.getCuentaContable2(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroformularioiva.getCuentaContable3(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroformularioiva.getCuentaContable4(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroformularioiva.getCuentaContable5(),connexion);
				continue;
			}


			if(clas.clas.equals(FormularioRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormularioRenta formulariorenta:parametroformularioiva.getFormularioRentas()) {
					formulariorenta.setid_parametro_formulario_iva(parametroformularioiva.getId());
					FormularioRentaDataAccess.save(formulariorenta,connexion);
				}
				continue;
			}

			if(clas.clas.equals(FormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormularioIva formularioiva:parametroformularioiva.getFormularioIvas()) {
					formularioiva.setid_parametro_formulario_iva(parametroformularioiva.getId());
					FormularioIvaDataAccess.save(formularioiva,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametroformularioiva.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametroformularioiva.getEmpresa(),isDeep,deepLoadType,clases);
				

		TipoParametroFormularioIvaDataAccess.save(parametroformularioiva.getTipoParametroFormularioIva(),connexion);
		TipoParametroFormularioIvaLogic tipoparametroformularioivaLogic= new TipoParametroFormularioIvaLogic(connexion);
		tipoparametroformularioivaLogic.deepLoad(parametroformularioiva.getTipoParametroFormularioIva(),isDeep,deepLoadType,clases);
				

		GrupoParametroFormularioIvaDataAccess.save(parametroformularioiva.getGrupoParametroFormularioIva(),connexion);
		GrupoParametroFormularioIvaLogic grupoparametroformularioivaLogic= new GrupoParametroFormularioIvaLogic(connexion);
		grupoparametroformularioivaLogic.deepLoad(parametroformularioiva.getGrupoParametroFormularioIva(),isDeep,deepLoadType,clases);
				

		SubGrupoParametroFormularioIvaDataAccess.save(parametroformularioiva.getSubGrupoParametroFormularioIva(),connexion);
		SubGrupoParametroFormularioIvaLogic subgrupoparametroformularioivaLogic= new SubGrupoParametroFormularioIvaLogic(connexion);
		subgrupoparametroformularioivaLogic.deepLoad(parametroformularioiva.getSubGrupoParametroFormularioIva(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametroformularioiva.getCuentaContable1(),connexion);
		CuentaContableLogic cuentacontable1Logic= new CuentaContableLogic(connexion);
		cuentacontable1Logic.deepLoad(parametroformularioiva.getCuentaContable1(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametroformularioiva.getCuentaContable2(),connexion);
		CuentaContableLogic cuentacontable2Logic= new CuentaContableLogic(connexion);
		cuentacontable2Logic.deepLoad(parametroformularioiva.getCuentaContable2(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametroformularioiva.getCuentaContable3(),connexion);
		CuentaContableLogic cuentacontable3Logic= new CuentaContableLogic(connexion);
		cuentacontable3Logic.deepLoad(parametroformularioiva.getCuentaContable3(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametroformularioiva.getCuentaContable4(),connexion);
		CuentaContableLogic cuentacontable4Logic= new CuentaContableLogic(connexion);
		cuentacontable4Logic.deepLoad(parametroformularioiva.getCuentaContable4(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametroformularioiva.getCuentaContable5(),connexion);
		CuentaContableLogic cuentacontable5Logic= new CuentaContableLogic(connexion);
		cuentacontable5Logic.deepLoad(parametroformularioiva.getCuentaContable5(),isDeep,deepLoadType,clases);
				

		for(FormularioRenta formulariorenta:parametroformularioiva.getFormularioRentas()) {
			FormularioRentaLogic formulariorentaLogic= new FormularioRentaLogic(connexion);
			formulariorenta.setid_parametro_formulario_iva(parametroformularioiva.getId());
			FormularioRentaDataAccess.save(formulariorenta,connexion);
			formulariorentaLogic.deepSave(formulariorenta,isDeep,deepLoadType,clases);
		}

		for(FormularioIva formularioiva:parametroformularioiva.getFormularioIvas()) {
			FormularioIvaLogic formularioivaLogic= new FormularioIvaLogic(connexion);
			formularioiva.setid_parametro_formulario_iva(parametroformularioiva.getId());
			FormularioIvaDataAccess.save(formularioiva,connexion);
			formularioivaLogic.deepSave(formularioiva,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametroformularioiva.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametroformularioiva.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoParametroFormularioIva.class)) {
				TipoParametroFormularioIvaDataAccess.save(parametroformularioiva.getTipoParametroFormularioIva(),connexion);
				TipoParametroFormularioIvaLogic tipoparametroformularioivaLogic= new TipoParametroFormularioIvaLogic(connexion);
				tipoparametroformularioivaLogic.deepSave(parametroformularioiva.getTipoParametroFormularioIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GrupoParametroFormularioIva.class)) {
				GrupoParametroFormularioIvaDataAccess.save(parametroformularioiva.getGrupoParametroFormularioIva(),connexion);
				GrupoParametroFormularioIvaLogic grupoparametroformularioivaLogic= new GrupoParametroFormularioIvaLogic(connexion);
				grupoparametroformularioivaLogic.deepSave(parametroformularioiva.getGrupoParametroFormularioIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(SubGrupoParametroFormularioIva.class)) {
				SubGrupoParametroFormularioIvaDataAccess.save(parametroformularioiva.getSubGrupoParametroFormularioIva(),connexion);
				SubGrupoParametroFormularioIvaLogic subgrupoparametroformularioivaLogic= new SubGrupoParametroFormularioIvaLogic(connexion);
				subgrupoparametroformularioivaLogic.deepSave(parametroformularioiva.getSubGrupoParametroFormularioIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroformularioiva.getCuentaContable1(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametroformularioiva.getCuentaContable1(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroformularioiva.getCuentaContable2(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametroformularioiva.getCuentaContable2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroformularioiva.getCuentaContable3(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametroformularioiva.getCuentaContable3(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroformularioiva.getCuentaContable4(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametroformularioiva.getCuentaContable4(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroformularioiva.getCuentaContable5(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametroformularioiva.getCuentaContable5(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(FormularioRenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormularioRenta formulariorenta:parametroformularioiva.getFormularioRentas()) {
					FormularioRentaLogic formulariorentaLogic= new FormularioRentaLogic(connexion);
					formulariorenta.setid_parametro_formulario_iva(parametroformularioiva.getId());
					FormularioRentaDataAccess.save(formulariorenta,connexion);
					formulariorentaLogic.deepSave(formulariorenta,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(FormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormularioIva formularioiva:parametroformularioiva.getFormularioIvas()) {
					FormularioIvaLogic formularioivaLogic= new FormularioIvaLogic(connexion);
					formularioiva.setid_parametro_formulario_iva(parametroformularioiva.getId());
					FormularioIvaDataAccess.save(formularioiva,connexion);
					formularioivaLogic.deepSave(formularioiva,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(ParametroFormularioIva.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametroformularioiva,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(parametroformularioiva);
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
			this.deepLoad(this.parametroformularioiva,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroFormularioIva.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametroformularioivas!=null) {
				for(ParametroFormularioIva parametroformularioiva:parametroformularioivas) {
					this.deepLoad(parametroformularioiva,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(parametroformularioivas);
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
			if(parametroformularioivas!=null) {
				for(ParametroFormularioIva parametroformularioiva:parametroformularioivas) {
					this.deepLoad(parametroformularioiva,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(parametroformularioivas);
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
			this.getNewConnexionToDeep(ParametroFormularioIva.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametroformularioiva,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroFormularioIva.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametroformularioivas!=null) {
				for(ParametroFormularioIva parametroformularioiva:parametroformularioivas) {
					this.deepSave(parametroformularioiva,isDeep,deepLoadType,clases);
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
			if(parametroformularioivas!=null) {
				for(ParametroFormularioIva parametroformularioiva:parametroformularioivas) {
					this.deepSave(parametroformularioiva,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroFormularioIvasFK_IdCuentaContable1WithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable1)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable1= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable1.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable1,ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE1,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable1);

			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable1","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFormularioIvasFK_IdCuentaContable1(String sFinalQuery,Pagination pagination,Long id_cuenta_contable1)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable1= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable1.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable1,ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE1,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable1);

			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable1","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFormularioIvasFK_IdCuentaContable2WithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable2)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable2,ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable2);

			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFormularioIvasFK_IdCuentaContable2(String sFinalQuery,Pagination pagination,Long id_cuenta_contable2)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable2,ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable2);

			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFormularioIvasFK_IdCuentaContable3WithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable3)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable3= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable3.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable3,ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE3,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable3);

			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable3","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFormularioIvasFK_IdCuentaContable3(String sFinalQuery,Pagination pagination,Long id_cuenta_contable3)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable3= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable3.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable3,ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE3,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable3);

			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable3","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFormularioIvasFK_IdCuentaContable4WithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable4)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable4= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable4.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable4,ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE4,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable4);

			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable4","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFormularioIvasFK_IdCuentaContable4(String sFinalQuery,Pagination pagination,Long id_cuenta_contable4)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable4= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable4.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable4,ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE4,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable4);

			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable4","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFormularioIvasFK_IdCuentaContable5WithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable5)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable5= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable5.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable5,ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE5,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable5);

			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable5","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFormularioIvasFK_IdCuentaContable5(String sFinalQuery,Pagination pagination,Long id_cuenta_contable5)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable5= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable5.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable5,ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE5,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable5);

			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable5","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFormularioIvasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroFormularioIvaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFormularioIvasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroFormularioIvaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFormularioIvasFK_IdGrupoParametroFormularioIvaWithConnection(String sFinalQuery,Pagination pagination,Long id_grupo_parametro_formulario_iva)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoParametroFormularioIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoParametroFormularioIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_parametro_formulario_iva,ParametroFormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoParametroFormularioIva);

			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGrupoParametroFormularioIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFormularioIvasFK_IdGrupoParametroFormularioIva(String sFinalQuery,Pagination pagination,Long id_grupo_parametro_formulario_iva)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoParametroFormularioIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoParametroFormularioIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_parametro_formulario_iva,ParametroFormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoParametroFormularioIva);

			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGrupoParametroFormularioIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFormularioIvasFK_IdSubGrupoParametroFormularioIvaWithConnection(String sFinalQuery,Pagination pagination,Long id_sub_grupo_parametro_formulario_iva)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSubGrupoParametroFormularioIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSubGrupoParametroFormularioIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sub_grupo_parametro_formulario_iva,ParametroFormularioIvaConstantesFunciones.IDSUBGRUPOPARAMETROFORMULARIOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSubGrupoParametroFormularioIva);

			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSubGrupoParametroFormularioIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFormularioIvasFK_IdSubGrupoParametroFormularioIva(String sFinalQuery,Pagination pagination,Long id_sub_grupo_parametro_formulario_iva)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSubGrupoParametroFormularioIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSubGrupoParametroFormularioIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sub_grupo_parametro_formulario_iva,ParametroFormularioIvaConstantesFunciones.IDSUBGRUPOPARAMETROFORMULARIOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSubGrupoParametroFormularioIva);

			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSubGrupoParametroFormularioIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroFormularioIvasFK_IdTipoParametroFormularioIvaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_parametro_formulario_iva)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoParametroFormularioIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoParametroFormularioIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_parametro_formulario_iva,ParametroFormularioIvaConstantesFunciones.IDTIPOPARAMETROFORMULARIOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoParametroFormularioIva);

			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoParametroFormularioIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroFormularioIvasFK_IdTipoParametroFormularioIva(String sFinalQuery,Pagination pagination,Long id_tipo_parametro_formulario_iva)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoParametroFormularioIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoParametroFormularioIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_parametro_formulario_iva,ParametroFormularioIvaConstantesFunciones.IDTIPOPARAMETROFORMULARIOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoParametroFormularioIva);

			ParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoParametroFormularioIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroformularioivas=parametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(this.parametroformularioivas);
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
			if(ParametroFormularioIvaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFormularioIvaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroFormularioIva parametroformularioiva,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroFormularioIvaConstantesFunciones.ISCONAUDITORIA) {
				if(parametroformularioiva.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFormularioIvaDataAccess.TABLENAME, parametroformularioiva.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroFormularioIvaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroFormularioIvaLogic.registrarAuditoriaDetallesParametroFormularioIva(connexion,parametroformularioiva,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametroformularioiva.getIsDeleted()) {
					/*if(!parametroformularioiva.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroFormularioIvaDataAccess.TABLENAME, parametroformularioiva.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroFormularioIvaLogic.registrarAuditoriaDetallesParametroFormularioIva(connexion,parametroformularioiva,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFormularioIvaDataAccess.TABLENAME, parametroformularioiva.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametroformularioiva.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFormularioIvaDataAccess.TABLENAME, parametroformularioiva.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroFormularioIvaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroFormularioIvaLogic.registrarAuditoriaDetallesParametroFormularioIva(connexion,parametroformularioiva,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroFormularioIva(Connexion connexion,ParametroFormularioIva parametroformularioiva)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametroformularioiva.getIsNew()||!parametroformularioiva.getid_empresa().equals(parametroformularioiva.getParametroFormularioIvaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroformularioiva.getParametroFormularioIvaOriginal().getid_empresa()!=null)
				{
					strValorActual=parametroformularioiva.getParametroFormularioIvaOriginal().getid_empresa().toString();
				}
				if(parametroformularioiva.getid_empresa()!=null)
				{
					strValorNuevo=parametroformularioiva.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFormularioIvaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametroformularioiva.getIsNew()||!parametroformularioiva.getid_tipo_parametro_formulario_iva().equals(parametroformularioiva.getParametroFormularioIvaOriginal().getid_tipo_parametro_formulario_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroformularioiva.getParametroFormularioIvaOriginal().getid_tipo_parametro_formulario_iva()!=null)
				{
					strValorActual=parametroformularioiva.getParametroFormularioIvaOriginal().getid_tipo_parametro_formulario_iva().toString();
				}
				if(parametroformularioiva.getid_tipo_parametro_formulario_iva()!=null)
				{
					strValorNuevo=parametroformularioiva.getid_tipo_parametro_formulario_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFormularioIvaConstantesFunciones.IDTIPOPARAMETROFORMULARIOIVA,strValorActual,strValorNuevo);
			}	
			
			if(parametroformularioiva.getIsNew()||!parametroformularioiva.getid_grupo_parametro_formulario_iva().equals(parametroformularioiva.getParametroFormularioIvaOriginal().getid_grupo_parametro_formulario_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroformularioiva.getParametroFormularioIvaOriginal().getid_grupo_parametro_formulario_iva()!=null)
				{
					strValorActual=parametroformularioiva.getParametroFormularioIvaOriginal().getid_grupo_parametro_formulario_iva().toString();
				}
				if(parametroformularioiva.getid_grupo_parametro_formulario_iva()!=null)
				{
					strValorNuevo=parametroformularioiva.getid_grupo_parametro_formulario_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA,strValorActual,strValorNuevo);
			}	
			
			if(parametroformularioiva.getIsNew()||!parametroformularioiva.getid_sub_grupo_parametro_formulario_iva().equals(parametroformularioiva.getParametroFormularioIvaOriginal().getid_sub_grupo_parametro_formulario_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroformularioiva.getParametroFormularioIvaOriginal().getid_sub_grupo_parametro_formulario_iva()!=null)
				{
					strValorActual=parametroformularioiva.getParametroFormularioIvaOriginal().getid_sub_grupo_parametro_formulario_iva().toString();
				}
				if(parametroformularioiva.getid_sub_grupo_parametro_formulario_iva()!=null)
				{
					strValorNuevo=parametroformularioiva.getid_sub_grupo_parametro_formulario_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFormularioIvaConstantesFunciones.IDSUBGRUPOPARAMETROFORMULARIOIVA,strValorActual,strValorNuevo);
			}	
			
			if(parametroformularioiva.getIsNew()||!parametroformularioiva.getgrupo().equals(parametroformularioiva.getParametroFormularioIvaOriginal().getgrupo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroformularioiva.getParametroFormularioIvaOriginal().getgrupo()!=null)
				{
					strValorActual=parametroformularioiva.getParametroFormularioIvaOriginal().getgrupo().toString();
				}
				if(parametroformularioiva.getgrupo()!=null)
				{
					strValorNuevo=parametroformularioiva.getgrupo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFormularioIvaConstantesFunciones.GRUPO,strValorActual,strValorNuevo);
			}	
			
			if(parametroformularioiva.getIsNew()||!parametroformularioiva.getgrupo2().equals(parametroformularioiva.getParametroFormularioIvaOriginal().getgrupo2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroformularioiva.getParametroFormularioIvaOriginal().getgrupo2()!=null)
				{
					strValorActual=parametroformularioiva.getParametroFormularioIvaOriginal().getgrupo2().toString();
				}
				if(parametroformularioiva.getgrupo2()!=null)
				{
					strValorNuevo=parametroformularioiva.getgrupo2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFormularioIvaConstantesFunciones.GRUPO2,strValorActual,strValorNuevo);
			}	
			
			if(parametroformularioiva.getIsNew()||!parametroformularioiva.getcodigo_sri().equals(parametroformularioiva.getParametroFormularioIvaOriginal().getcodigo_sri()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroformularioiva.getParametroFormularioIvaOriginal().getcodigo_sri()!=null)
				{
					strValorActual=parametroformularioiva.getParametroFormularioIvaOriginal().getcodigo_sri();
				}
				if(parametroformularioiva.getcodigo_sri()!=null)
				{
					strValorNuevo=parametroformularioiva.getcodigo_sri() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFormularioIvaConstantesFunciones.CODIGOSRI,strValorActual,strValorNuevo);
			}	
			
			if(parametroformularioiva.getIsNew()||!parametroformularioiva.getnombre().equals(parametroformularioiva.getParametroFormularioIvaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroformularioiva.getParametroFormularioIvaOriginal().getnombre()!=null)
				{
					strValorActual=parametroformularioiva.getParametroFormularioIvaOriginal().getnombre();
				}
				if(parametroformularioiva.getnombre()!=null)
				{
					strValorNuevo=parametroformularioiva.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFormularioIvaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(parametroformularioiva.getIsNew()||!parametroformularioiva.getporcentaje().equals(parametroformularioiva.getParametroFormularioIvaOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroformularioiva.getParametroFormularioIvaOriginal().getporcentaje()!=null)
				{
					strValorActual=parametroformularioiva.getParametroFormularioIvaOriginal().getporcentaje().toString();
				}
				if(parametroformularioiva.getporcentaje()!=null)
				{
					strValorNuevo=parametroformularioiva.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFormularioIvaConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(parametroformularioiva.getIsNew()||!parametroformularioiva.getcon_total().equals(parametroformularioiva.getParametroFormularioIvaOriginal().getcon_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroformularioiva.getParametroFormularioIvaOriginal().getcon_total()!=null)
				{
					strValorActual=parametroformularioiva.getParametroFormularioIvaOriginal().getcon_total().toString();
				}
				if(parametroformularioiva.getcon_total()!=null)
				{
					strValorNuevo=parametroformularioiva.getcon_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFormularioIvaConstantesFunciones.CONTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(parametroformularioiva.getIsNew()||!parametroformularioiva.getid_cuenta_contable1().equals(parametroformularioiva.getParametroFormularioIvaOriginal().getid_cuenta_contable1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroformularioiva.getParametroFormularioIvaOriginal().getid_cuenta_contable1()!=null)
				{
					strValorActual=parametroformularioiva.getParametroFormularioIvaOriginal().getid_cuenta_contable1().toString();
				}
				if(parametroformularioiva.getid_cuenta_contable1()!=null)
				{
					strValorNuevo=parametroformularioiva.getid_cuenta_contable1().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE1,strValorActual,strValorNuevo);
			}	
			
			if(parametroformularioiva.getIsNew()||!parametroformularioiva.getid_cuenta_contable2().equals(parametroformularioiva.getParametroFormularioIvaOriginal().getid_cuenta_contable2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroformularioiva.getParametroFormularioIvaOriginal().getid_cuenta_contable2()!=null)
				{
					strValorActual=parametroformularioiva.getParametroFormularioIvaOriginal().getid_cuenta_contable2().toString();
				}
				if(parametroformularioiva.getid_cuenta_contable2()!=null)
				{
					strValorNuevo=parametroformularioiva.getid_cuenta_contable2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE2,strValorActual,strValorNuevo);
			}	
			
			if(parametroformularioiva.getIsNew()||!parametroformularioiva.getid_cuenta_contable3().equals(parametroformularioiva.getParametroFormularioIvaOriginal().getid_cuenta_contable3()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroformularioiva.getParametroFormularioIvaOriginal().getid_cuenta_contable3()!=null)
				{
					strValorActual=parametroformularioiva.getParametroFormularioIvaOriginal().getid_cuenta_contable3().toString();
				}
				if(parametroformularioiva.getid_cuenta_contable3()!=null)
				{
					strValorNuevo=parametroformularioiva.getid_cuenta_contable3().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE3,strValorActual,strValorNuevo);
			}	
			
			if(parametroformularioiva.getIsNew()||!parametroformularioiva.getid_cuenta_contable4().equals(parametroformularioiva.getParametroFormularioIvaOriginal().getid_cuenta_contable4()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroformularioiva.getParametroFormularioIvaOriginal().getid_cuenta_contable4()!=null)
				{
					strValorActual=parametroformularioiva.getParametroFormularioIvaOriginal().getid_cuenta_contable4().toString();
				}
				if(parametroformularioiva.getid_cuenta_contable4()!=null)
				{
					strValorNuevo=parametroformularioiva.getid_cuenta_contable4().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE4,strValorActual,strValorNuevo);
			}	
			
			if(parametroformularioiva.getIsNew()||!parametroformularioiva.getid_cuenta_contable5().equals(parametroformularioiva.getParametroFormularioIvaOriginal().getid_cuenta_contable5()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroformularioiva.getParametroFormularioIvaOriginal().getid_cuenta_contable5()!=null)
				{
					strValorActual=parametroformularioiva.getParametroFormularioIvaOriginal().getid_cuenta_contable5().toString();
				}
				if(parametroformularioiva.getid_cuenta_contable5()!=null)
				{
					strValorNuevo=parametroformularioiva.getid_cuenta_contable5().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFormularioIvaConstantesFunciones.IDCUENTACONTABLE5,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroFormularioIvaRelacionesWithConnection(ParametroFormularioIva parametroformularioiva,List<FormularioRenta> formulariorentas,List<FormularioIva> formularioivas) throws Exception {

		if(!parametroformularioiva.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroFormularioIvaRelacionesBase(parametroformularioiva,formulariorentas,formularioivas,true);
		}
	}

	public void saveParametroFormularioIvaRelaciones(ParametroFormularioIva parametroformularioiva,List<FormularioRenta> formulariorentas,List<FormularioIva> formularioivas)throws Exception {

		if(!parametroformularioiva.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroFormularioIvaRelacionesBase(parametroformularioiva,formulariorentas,formularioivas,false);
		}
	}

	public void saveParametroFormularioIvaRelacionesBase(ParametroFormularioIva parametroformularioiva,List<FormularioRenta> formulariorentas,List<FormularioIva> formularioivas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroFormularioIva-saveRelacionesWithConnection");}
	
			parametroformularioiva.setFormularioRentas(formulariorentas);
			parametroformularioiva.setFormularioIvas(formularioivas);

			this.setParametroFormularioIva(parametroformularioiva);

			if(ParametroFormularioIvaLogicAdditional.validarSaveRelaciones(parametroformularioiva,this)) {

				ParametroFormularioIvaLogicAdditional.updateRelacionesToSave(parametroformularioiva,this);

				if((parametroformularioiva.getIsNew()||parametroformularioiva.getIsChanged())&&!parametroformularioiva.getIsDeleted()) {
					this.saveParametroFormularioIva();
					this.saveParametroFormularioIvaRelacionesDetalles(formulariorentas,formularioivas);

				} else if(parametroformularioiva.getIsDeleted()) {
					this.saveParametroFormularioIvaRelacionesDetalles(formulariorentas,formularioivas);
					this.saveParametroFormularioIva();
				}

				ParametroFormularioIvaLogicAdditional.updateRelacionesToSaveAfter(parametroformularioiva,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			FormularioRentaConstantesFunciones.InicializarGeneralEntityAuxiliaresFormularioRentas(formulariorentas,true,true);
			FormularioIvaConstantesFunciones.InicializarGeneralEntityAuxiliaresFormularioIvas(formularioivas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveParametroFormularioIvaRelacionesDetalles(List<FormularioRenta> formulariorentas,List<FormularioIva> formularioivas)throws Exception {
		try {
	

			Long idParametroFormularioIvaActual=this.getParametroFormularioIva().getId();

			FormularioRentaLogic formulariorentaLogic_Desde_ParametroFormularioIva=new FormularioRentaLogic();
			formulariorentaLogic_Desde_ParametroFormularioIva.setFormularioRentas(formulariorentas);

			formulariorentaLogic_Desde_ParametroFormularioIva.setConnexion(this.getConnexion());
			formulariorentaLogic_Desde_ParametroFormularioIva.setDatosCliente(this.datosCliente);

			for(FormularioRenta formulariorenta_Desde_ParametroFormularioIva:formulariorentaLogic_Desde_ParametroFormularioIva.getFormularioRentas()) {
				formulariorenta_Desde_ParametroFormularioIva.setid_parametro_formulario_iva(idParametroFormularioIvaActual);
			}

			formulariorentaLogic_Desde_ParametroFormularioIva.saveFormularioRentas();

			FormularioIvaLogic formularioivaLogic_Desde_ParametroFormularioIva=new FormularioIvaLogic();
			formularioivaLogic_Desde_ParametroFormularioIva.setFormularioIvas(formularioivas);

			formularioivaLogic_Desde_ParametroFormularioIva.setConnexion(this.getConnexion());
			formularioivaLogic_Desde_ParametroFormularioIva.setDatosCliente(this.datosCliente);

			for(FormularioIva formularioiva_Desde_ParametroFormularioIva:formularioivaLogic_Desde_ParametroFormularioIva.getFormularioIvas()) {
				formularioiva_Desde_ParametroFormularioIva.setid_parametro_formulario_iva(idParametroFormularioIvaActual);
			}

			formularioivaLogic_Desde_ParametroFormularioIva.saveFormularioIvas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroFormularioIvaConstantesFunciones.getClassesForeignKeysOfParametroFormularioIva(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroFormularioIvaConstantesFunciones.getClassesRelationshipsOfParametroFormularioIva(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

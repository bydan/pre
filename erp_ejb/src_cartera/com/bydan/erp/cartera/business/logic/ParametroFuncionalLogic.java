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
import com.bydan.erp.cartera.util.ParametroFuncionalConstantesFunciones;
import com.bydan.erp.cartera.util.ParametroFuncionalParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ParametroFuncionalParameterGeneral;
import com.bydan.erp.cartera.business.entity.ParametroFuncional;
import com.bydan.erp.cartera.business.logic.ParametroFuncionalLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class ParametroFuncionalLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroFuncionalLogic.class);
	
	protected ParametroFuncionalDataAccess parametrofuncionalDataAccess; 	
	protected ParametroFuncional parametrofuncional;
	protected List<ParametroFuncional> parametrofuncionals;
	protected Object parametrofuncionalObject;	
	protected List<Object> parametrofuncionalsObject;
	
	public static ClassValidator<ParametroFuncional> parametrofuncionalValidator = new ClassValidator<ParametroFuncional>(ParametroFuncional.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroFuncionalLogicAdditional parametrofuncionalLogicAdditional=null;
	
	public ParametroFuncionalLogicAdditional getParametroFuncionalLogicAdditional() {
		return this.parametrofuncionalLogicAdditional;
	}
	
	public void setParametroFuncionalLogicAdditional(ParametroFuncionalLogicAdditional parametrofuncionalLogicAdditional) {
		try {
			this.parametrofuncionalLogicAdditional=parametrofuncionalLogicAdditional;
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
	
	
	
	
	public  ParametroFuncionalLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametrofuncionalDataAccess = new ParametroFuncionalDataAccess();
			
			this.parametrofuncionals= new ArrayList<ParametroFuncional>();
			this.parametrofuncional= new ParametroFuncional();
			
			this.parametrofuncionalObject=new Object();
			this.parametrofuncionalsObject=new ArrayList<Object>();
				
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
			
			this.parametrofuncionalDataAccess.setConnexionType(this.connexionType);
			this.parametrofuncionalDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroFuncionalLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametrofuncionalDataAccess = new ParametroFuncionalDataAccess();
			this.parametrofuncionals= new ArrayList<ParametroFuncional>();
			this.parametrofuncional= new ParametroFuncional();
			this.parametrofuncionalObject=new Object();
			this.parametrofuncionalsObject=new ArrayList<Object>();
			
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
			
			this.parametrofuncionalDataAccess.setConnexionType(this.connexionType);
			this.parametrofuncionalDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroFuncional getParametroFuncional() throws Exception {	
		ParametroFuncionalLogicAdditional.checkParametroFuncionalToGet(parametrofuncional,this.datosCliente,this.arrDatoGeneral);
		ParametroFuncionalLogicAdditional.updateParametroFuncionalToGet(parametrofuncional,this.arrDatoGeneral);
		
		return parametrofuncional;
	}
		
	public void setParametroFuncional(ParametroFuncional newParametroFuncional) {
		this.parametrofuncional = newParametroFuncional;
	}
	
	public ParametroFuncionalDataAccess getParametroFuncionalDataAccess() {
		return parametrofuncionalDataAccess;
	}
	
	public void setParametroFuncionalDataAccess(ParametroFuncionalDataAccess newparametrofuncionalDataAccess) {
		this.parametrofuncionalDataAccess = newparametrofuncionalDataAccess;
	}
	
	public List<ParametroFuncional> getParametroFuncionals() throws Exception {		
		this.quitarParametroFuncionalsNulos();
		
		ParametroFuncionalLogicAdditional.checkParametroFuncionalToGets(parametrofuncionals,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroFuncional parametrofuncionalLocal: parametrofuncionals ) {
			ParametroFuncionalLogicAdditional.updateParametroFuncionalToGet(parametrofuncionalLocal,this.arrDatoGeneral);
		}
		
		return parametrofuncionals;
	}
	
	public void setParametroFuncionals(List<ParametroFuncional> newParametroFuncionals) {
		this.parametrofuncionals = newParametroFuncionals;
	}
	
	public Object getParametroFuncionalObject() {	
		this.parametrofuncionalObject=this.parametrofuncionalDataAccess.getEntityObject();
		return this.parametrofuncionalObject;
	}
		
	public void setParametroFuncionalObject(Object newParametroFuncionalObject) {
		this.parametrofuncionalObject = newParametroFuncionalObject;
	}
	
	public List<Object> getParametroFuncionalsObject() {		
		this.parametrofuncionalsObject=this.parametrofuncionalDataAccess.getEntitiesObject();
		return this.parametrofuncionalsObject;
	}
		
	public void setParametroFuncionalsObject(List<Object> newParametroFuncionalsObject) {
		this.parametrofuncionalsObject = newParametroFuncionalsObject;
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
		
		if(this.parametrofuncionalDataAccess!=null) {
			this.parametrofuncionalDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFuncional.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametrofuncionalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametrofuncionalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametrofuncional = new  ParametroFuncional();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFuncional.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrofuncional=parametrofuncionalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofuncional,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFuncionalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFuncional(this.parametrofuncional);
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
		parametrofuncional = new  ParametroFuncional();
		  		  
        try {
			
			parametrofuncional=parametrofuncionalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofuncional,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFuncionalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFuncional(this.parametrofuncional);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametrofuncional = new  ParametroFuncional();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFuncional.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrofuncional=parametrofuncionalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofuncional,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFuncionalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFuncional(this.parametrofuncional);
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
		parametrofuncional = new  ParametroFuncional();
		  		  
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
		parametrofuncional = new  ParametroFuncional();
		  		  
        try {
			
			parametrofuncional=parametrofuncionalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrofuncional,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroFuncionalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFuncional(this.parametrofuncional);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametrofuncional = new  ParametroFuncional();
		  		  
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
		parametrofuncional = new  ParametroFuncional();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFuncional.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametrofuncionalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrofuncional = new  ParametroFuncional();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametrofuncionalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrofuncional = new  ParametroFuncional();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFuncional.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametrofuncionalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrofuncional = new  ParametroFuncional();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametrofuncionalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrofuncional = new  ParametroFuncional();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFuncional.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametrofuncionalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrofuncional = new  ParametroFuncional();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametrofuncionalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrofuncionals = new  ArrayList<ParametroFuncional>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFuncional.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroFuncionalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofuncionals=parametrofuncionalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFuncional(parametrofuncionals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFuncionalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFuncional(this.parametrofuncionals);
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
		parametrofuncionals = new  ArrayList<ParametroFuncional>();
		  		  
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
		parametrofuncionals = new  ArrayList<ParametroFuncional>();
		  		  
        try {			
			ParametroFuncionalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofuncionals=parametrofuncionalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroFuncional(parametrofuncionals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFuncionalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFuncional(this.parametrofuncionals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametrofuncionals = new  ArrayList<ParametroFuncional>();
		  		  
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
		parametrofuncionals = new  ArrayList<ParametroFuncional>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFuncional.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroFuncionalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofuncionals=parametrofuncionalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFuncional(parametrofuncionals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFuncionalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFuncional(this.parametrofuncionals);
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
		parametrofuncionals = new  ArrayList<ParametroFuncional>();
		  		  
        try {
			ParametroFuncionalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofuncionals=parametrofuncionalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFuncional(parametrofuncionals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFuncionalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFuncional(this.parametrofuncionals);
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
		parametrofuncionals = new  ArrayList<ParametroFuncional>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFuncional.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFuncionalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofuncionals=parametrofuncionalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFuncional(parametrofuncionals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFuncionalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFuncional(this.parametrofuncionals);
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
		parametrofuncionals = new  ArrayList<ParametroFuncional>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFuncionalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofuncionals=parametrofuncionalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFuncional(parametrofuncionals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFuncionalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFuncional(this.parametrofuncionals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametrofuncional = new  ParametroFuncional();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFuncional.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFuncionalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofuncional=parametrofuncionalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFuncional(parametrofuncional);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFuncionalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFuncional(this.parametrofuncional);
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
		parametrofuncional = new  ParametroFuncional();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFuncionalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofuncional=parametrofuncionalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroFuncional(parametrofuncional);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFuncionalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFuncional(this.parametrofuncional);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrofuncionals = new  ArrayList<ParametroFuncional>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFuncional.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroFuncionalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofuncionals=parametrofuncionalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFuncional(parametrofuncionals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFuncionalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFuncional(this.parametrofuncionals);
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
		parametrofuncionals = new  ArrayList<ParametroFuncional>();
		  		  
        try {
			ParametroFuncionalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofuncionals=parametrofuncionalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroFuncional(parametrofuncionals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFuncionalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFuncional(this.parametrofuncionals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroFuncionalsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametrofuncionals = new  ArrayList<ParametroFuncional>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFuncional.class.getSimpleName()+"-getTodosParametroFuncionalsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFuncionalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofuncionals=parametrofuncionalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroFuncional(parametrofuncionals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFuncionalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFuncional(this.parametrofuncionals);
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
	
	public  void  getTodosParametroFuncionals(String sFinalQuery,Pagination pagination)throws Exception {
		parametrofuncionals = new  ArrayList<ParametroFuncional>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroFuncionalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrofuncionals=parametrofuncionalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroFuncional(parametrofuncionals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroFuncionalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFuncional(this.parametrofuncionals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroFuncional(ParametroFuncional parametrofuncional) throws Exception {
		Boolean estaValidado=false;
		
		if(parametrofuncional.getIsNew() || parametrofuncional.getIsChanged()) { 
			this.invalidValues = parametrofuncionalValidator.getInvalidValues(parametrofuncional);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametrofuncional);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroFuncional(List<ParametroFuncional> ParametroFuncionals) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroFuncional parametrofuncionalLocal:parametrofuncionals) {				
			estaValidadoObjeto=this.validarGuardarParametroFuncional(parametrofuncionalLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroFuncional(List<ParametroFuncional> ParametroFuncionals) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroFuncional(parametrofuncionals)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroFuncional(ParametroFuncional ParametroFuncional) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroFuncional(parametrofuncional)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroFuncional parametrofuncional) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametrofuncional.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroFuncionalConstantesFunciones.getParametroFuncionalLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametrofuncional","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroFuncionalConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroFuncionalConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroFuncionalWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFuncional.class.getSimpleName()+"-saveParametroFuncionalWithConnection");connexion.begin();			
			
			ParametroFuncionalLogicAdditional.checkParametroFuncionalToSave(this.parametrofuncional,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroFuncionalLogicAdditional.updateParametroFuncionalToSave(this.parametrofuncional,this.arrDatoGeneral);
			
			ParametroFuncionalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrofuncional,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroFuncional();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroFuncional(this.parametrofuncional)) {
				ParametroFuncionalDataAccess.save(this.parametrofuncional, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametrofuncional,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroFuncionalLogicAdditional.checkParametroFuncionalToSaveAfter(this.parametrofuncional,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroFuncional();
			
			connexion.commit();			
			
			if(this.parametrofuncional.getIsDeleted()) {
				this.parametrofuncional=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroFuncional()throws Exception {	
		try {	
			
			ParametroFuncionalLogicAdditional.checkParametroFuncionalToSave(this.parametrofuncional,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroFuncionalLogicAdditional.updateParametroFuncionalToSave(this.parametrofuncional,this.arrDatoGeneral);
			
			ParametroFuncionalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrofuncional,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroFuncional(this.parametrofuncional)) {			
				ParametroFuncionalDataAccess.save(this.parametrofuncional, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametrofuncional,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroFuncionalLogicAdditional.checkParametroFuncionalToSaveAfter(this.parametrofuncional,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametrofuncional.getIsDeleted()) {
				this.parametrofuncional=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroFuncionalsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFuncional.class.getSimpleName()+"-saveParametroFuncionalsWithConnection");connexion.begin();			
			
			ParametroFuncionalLogicAdditional.checkParametroFuncionalToSaves(parametrofuncionals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroFuncionals();
			
			Boolean validadoTodosParametroFuncional=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroFuncional parametrofuncionalLocal:parametrofuncionals) {		
				if(parametrofuncionalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroFuncionalLogicAdditional.updateParametroFuncionalToSave(parametrofuncionalLocal,this.arrDatoGeneral);
	        	
				ParametroFuncionalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrofuncionalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroFuncional(parametrofuncionalLocal)) {
					ParametroFuncionalDataAccess.save(parametrofuncionalLocal, connexion);				
				} else {
					validadoTodosParametroFuncional=false;
				}
			}
			
			if(!validadoTodosParametroFuncional) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroFuncionalLogicAdditional.checkParametroFuncionalToSavesAfter(parametrofuncionals,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroFuncionals();
			
			connexion.commit();		
			
			this.quitarParametroFuncionalsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroFuncionals()throws Exception {				
		 try {	
			ParametroFuncionalLogicAdditional.checkParametroFuncionalToSaves(parametrofuncionals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroFuncional=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroFuncional parametrofuncionalLocal:parametrofuncionals) {				
				if(parametrofuncionalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroFuncionalLogicAdditional.updateParametroFuncionalToSave(parametrofuncionalLocal,this.arrDatoGeneral);
	        	
				ParametroFuncionalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrofuncionalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroFuncional(parametrofuncionalLocal)) {				
					ParametroFuncionalDataAccess.save(parametrofuncionalLocal, connexion);				
				} else {
					validadoTodosParametroFuncional=false;
				}
			}
			
			if(!validadoTodosParametroFuncional) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroFuncionalLogicAdditional.checkParametroFuncionalToSavesAfter(parametrofuncionals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroFuncionalsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroFuncionalParameterReturnGeneral procesarAccionParametroFuncionals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroFuncional> parametrofuncionals,ParametroFuncionalParameterReturnGeneral parametrofuncionalParameterGeneral)throws Exception {
		 try {	
			ParametroFuncionalParameterReturnGeneral parametrofuncionalReturnGeneral=new ParametroFuncionalParameterReturnGeneral();
	
			ParametroFuncionalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrofuncionals,parametrofuncionalParameterGeneral,parametrofuncionalReturnGeneral);
			
			return parametrofuncionalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroFuncionalParameterReturnGeneral procesarAccionParametroFuncionalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroFuncional> parametrofuncionals,ParametroFuncionalParameterReturnGeneral parametrofuncionalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFuncional.class.getSimpleName()+"-procesarAccionParametroFuncionalsWithConnection");connexion.begin();			
			
			ParametroFuncionalParameterReturnGeneral parametrofuncionalReturnGeneral=new ParametroFuncionalParameterReturnGeneral();
	
			ParametroFuncionalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrofuncionals,parametrofuncionalParameterGeneral,parametrofuncionalReturnGeneral);
			
			this.connexion.commit();
			
			return parametrofuncionalReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroFuncionalParameterReturnGeneral procesarEventosParametroFuncionals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroFuncional> parametrofuncionals,ParametroFuncional parametrofuncional,ParametroFuncionalParameterReturnGeneral parametrofuncionalParameterGeneral,Boolean isEsNuevoParametroFuncional,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroFuncionalParameterReturnGeneral parametrofuncionalReturnGeneral=new ParametroFuncionalParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrofuncionalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroFuncionalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrofuncionals,parametrofuncional,parametrofuncionalParameterGeneral,parametrofuncionalReturnGeneral,isEsNuevoParametroFuncional,clases);
			
			return parametrofuncionalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroFuncionalParameterReturnGeneral procesarEventosParametroFuncionalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroFuncional> parametrofuncionals,ParametroFuncional parametrofuncional,ParametroFuncionalParameterReturnGeneral parametrofuncionalParameterGeneral,Boolean isEsNuevoParametroFuncional,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFuncional.class.getSimpleName()+"-procesarEventosParametroFuncionalsWithConnection");connexion.begin();			
			
			ParametroFuncionalParameterReturnGeneral parametrofuncionalReturnGeneral=new ParametroFuncionalParameterReturnGeneral();
	
			parametrofuncionalReturnGeneral.setParametroFuncional(parametrofuncional);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrofuncionalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroFuncionalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrofuncionals,parametrofuncional,parametrofuncionalParameterGeneral,parametrofuncionalReturnGeneral,isEsNuevoParametroFuncional,clases);
			
			this.connexion.commit();
			
			return parametrofuncionalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroFuncionalParameterReturnGeneral procesarImportacionParametroFuncionalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroFuncionalParameterReturnGeneral parametrofuncionalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroFuncional.class.getSimpleName()+"-procesarImportacionParametroFuncionalsWithConnection");connexion.begin();			
			
			ParametroFuncionalParameterReturnGeneral parametrofuncionalReturnGeneral=new ParametroFuncionalParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametrofuncionals=new ArrayList<ParametroFuncional>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametrofuncional=new ParametroFuncional();
				
				
				if(conColumnasBase) {this.parametrofuncional.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametrofuncional.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.parametrofuncional.setcon_copia_clientes(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofuncional.setcon_copia_proveedor(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrofuncional.setcon_proveedor_cliente(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.parametrofuncionals.add(this.parametrofuncional);
			}
			
			this.saveParametroFuncionals();
			
			this.connexion.commit();
			
			parametrofuncionalReturnGeneral.setConRetornoEstaProcesado(true);
			parametrofuncionalReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametrofuncionalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroFuncionalsEliminados() throws Exception {				
		
		List<ParametroFuncional> parametrofuncionalsAux= new ArrayList<ParametroFuncional>();
		
		for(ParametroFuncional parametrofuncional:parametrofuncionals) {
			if(!parametrofuncional.getIsDeleted()) {
				parametrofuncionalsAux.add(parametrofuncional);
			}
		}
		
		parametrofuncionals=parametrofuncionalsAux;
	}
	
	public void quitarParametroFuncionalsNulos() throws Exception {				
		
		List<ParametroFuncional> parametrofuncionalsAux= new ArrayList<ParametroFuncional>();
		
		for(ParametroFuncional parametrofuncional : this.parametrofuncionals) {
			if(parametrofuncional==null) {
				parametrofuncionalsAux.add(parametrofuncional);
			}
		}
		
		//this.parametrofuncionals=parametrofuncionalsAux;
		
		this.parametrofuncionals.removeAll(parametrofuncionalsAux);
	}
	
	public void getSetVersionRowParametroFuncionalWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametrofuncional.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametrofuncional.getIsDeleted() || (parametrofuncional.getIsChanged()&&!parametrofuncional.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametrofuncionalDataAccess.getSetVersionRowParametroFuncional(connexion,parametrofuncional.getId());
				
				if(!parametrofuncional.getVersionRow().equals(timestamp)) {	
					parametrofuncional.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametrofuncional.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroFuncional()throws Exception {	
		
		if(parametrofuncional.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametrofuncional.getIsDeleted() || (parametrofuncional.getIsChanged()&&!parametrofuncional.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametrofuncionalDataAccess.getSetVersionRowParametroFuncional(connexion,parametrofuncional.getId());
			
			try {							
				if(!parametrofuncional.getVersionRow().equals(timestamp)) {	
					parametrofuncional.setVersionRow(timestamp);
				}
				
				parametrofuncional.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroFuncionalsWithConnection()throws Exception {	
		if(parametrofuncionals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroFuncional parametrofuncionalAux:parametrofuncionals) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametrofuncionalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrofuncionalAux.getIsDeleted() || (parametrofuncionalAux.getIsChanged()&&!parametrofuncionalAux.getIsNew())) {
						
						timestamp=parametrofuncionalDataAccess.getSetVersionRowParametroFuncional(connexion,parametrofuncionalAux.getId());
						
						if(!parametrofuncional.getVersionRow().equals(timestamp)) {	
							parametrofuncionalAux.setVersionRow(timestamp);
						}
								
						parametrofuncionalAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroFuncionals()throws Exception {	
		if(parametrofuncionals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroFuncional parametrofuncionalAux:parametrofuncionals) {
					if(parametrofuncionalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrofuncionalAux.getIsDeleted() || (parametrofuncionalAux.getIsChanged()&&!parametrofuncionalAux.getIsNew())) {
						
						timestamp=parametrofuncionalDataAccess.getSetVersionRowParametroFuncional(connexion,parametrofuncionalAux.getId());
						
						if(!parametrofuncionalAux.getVersionRow().equals(timestamp)) {	
							parametrofuncionalAux.setVersionRow(timestamp);
						}
						
													
						parametrofuncionalAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(ParametroFuncional parametrofuncional,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		
		
		try {
			ParametroFuncionalLogicAdditional.updateParametroFuncionalToGet(parametrofuncional,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroFuncional parametrofuncional,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
				
		try {
			ParametroFuncionalLogicAdditional.updateParametroFuncionalToSave(parametrofuncional,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroFuncional.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametrofuncional,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroFuncionalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFuncional(parametrofuncional);
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
			this.deepLoad(this.parametrofuncional,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroFuncionalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFuncional(this.parametrofuncional);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroFuncional.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametrofuncionals!=null) {
				for(ParametroFuncional parametrofuncional:parametrofuncionals) {
					this.deepLoad(parametrofuncional,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroFuncionalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFuncional(parametrofuncionals);
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
			if(parametrofuncionals!=null) {
				for(ParametroFuncional parametrofuncional:parametrofuncionals) {
					this.deepLoad(parametrofuncional,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroFuncionalConstantesFunciones.refrescarForeignKeysDescripcionesParametroFuncional(parametrofuncionals);
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
			this.getNewConnexionToDeep(ParametroFuncional.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametrofuncional,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroFuncional.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametrofuncionals!=null) {
				for(ParametroFuncional parametrofuncional:parametrofuncionals) {
					this.deepSave(parametrofuncional,isDeep,deepLoadType,clases);
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
			if(parametrofuncionals!=null) {
				for(ParametroFuncional parametrofuncional:parametrofuncionals) {
					this.deepSave(parametrofuncional,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroFuncionalConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFuncionalDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroFuncional parametrofuncional,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroFuncionalConstantesFunciones.ISCONAUDITORIA) {
				if(parametrofuncional.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFuncionalDataAccess.TABLENAME, parametrofuncional.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroFuncionalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroFuncionalLogic.registrarAuditoriaDetallesParametroFuncional(connexion,parametrofuncional,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametrofuncional.getIsDeleted()) {
					/*if(!parametrofuncional.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroFuncionalDataAccess.TABLENAME, parametrofuncional.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroFuncionalLogic.registrarAuditoriaDetallesParametroFuncional(connexion,parametrofuncional,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFuncionalDataAccess.TABLENAME, parametrofuncional.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametrofuncional.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroFuncionalDataAccess.TABLENAME, parametrofuncional.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroFuncionalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroFuncionalLogic.registrarAuditoriaDetallesParametroFuncional(connexion,parametrofuncional,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroFuncional(Connexion connexion,ParametroFuncional parametrofuncional)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametrofuncional.getIsNew()||!parametrofuncional.getcon_copia_clientes().equals(parametrofuncional.getParametroFuncionalOriginal().getcon_copia_clientes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofuncional.getParametroFuncionalOriginal().getcon_copia_clientes()!=null)
				{
					strValorActual=parametrofuncional.getParametroFuncionalOriginal().getcon_copia_clientes().toString();
				}
				if(parametrofuncional.getcon_copia_clientes()!=null)
				{
					strValorNuevo=parametrofuncional.getcon_copia_clientes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFuncionalConstantesFunciones.CONCOPIACLIENTES,strValorActual,strValorNuevo);
			}	
			
			if(parametrofuncional.getIsNew()||!parametrofuncional.getcon_copia_proveedor().equals(parametrofuncional.getParametroFuncionalOriginal().getcon_copia_proveedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofuncional.getParametroFuncionalOriginal().getcon_copia_proveedor()!=null)
				{
					strValorActual=parametrofuncional.getParametroFuncionalOriginal().getcon_copia_proveedor().toString();
				}
				if(parametrofuncional.getcon_copia_proveedor()!=null)
				{
					strValorNuevo=parametrofuncional.getcon_copia_proveedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFuncionalConstantesFunciones.CONCOPIAPROVEEDOR,strValorActual,strValorNuevo);
			}	
			
			if(parametrofuncional.getIsNew()||!parametrofuncional.getcon_proveedor_cliente().equals(parametrofuncional.getParametroFuncionalOriginal().getcon_proveedor_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrofuncional.getParametroFuncionalOriginal().getcon_proveedor_cliente()!=null)
				{
					strValorActual=parametrofuncional.getParametroFuncionalOriginal().getcon_proveedor_cliente().toString();
				}
				if(parametrofuncional.getcon_proveedor_cliente()!=null)
				{
					strValorNuevo=parametrofuncional.getcon_proveedor_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroFuncionalConstantesFunciones.CONPROVEEDORCLIENTE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroFuncionalRelacionesWithConnection(ParametroFuncional parametrofuncional) throws Exception {

		if(!parametrofuncional.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroFuncionalRelacionesBase(parametrofuncional,true);
		}
	}

	public void saveParametroFuncionalRelaciones(ParametroFuncional parametrofuncional)throws Exception {

		if(!parametrofuncional.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroFuncionalRelacionesBase(parametrofuncional,false);
		}
	}

	public void saveParametroFuncionalRelacionesBase(ParametroFuncional parametrofuncional,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroFuncional-saveRelacionesWithConnection");}
	

			this.setParametroFuncional(parametrofuncional);

			if(ParametroFuncionalLogicAdditional.validarSaveRelaciones(parametrofuncional,this)) {

				ParametroFuncionalLogicAdditional.updateRelacionesToSave(parametrofuncional,this);

				if((parametrofuncional.getIsNew()||parametrofuncional.getIsChanged())&&!parametrofuncional.getIsDeleted()) {
					this.saveParametroFuncional();
					this.saveParametroFuncionalRelacionesDetalles();

				} else if(parametrofuncional.getIsDeleted()) {
					this.saveParametroFuncionalRelacionesDetalles();
					this.saveParametroFuncional();
				}

				ParametroFuncionalLogicAdditional.updateRelacionesToSaveAfter(parametrofuncional,this);

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
	
	
	private void saveParametroFuncionalRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroFuncional(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroFuncionalConstantesFunciones.getClassesForeignKeysOfParametroFuncional(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroFuncional(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroFuncionalConstantesFunciones.getClassesRelationshipsOfParametroFuncional(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

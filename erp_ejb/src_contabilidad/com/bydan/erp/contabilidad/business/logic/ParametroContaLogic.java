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
import com.bydan.erp.contabilidad.util.ParametroContaConstantesFunciones;
import com.bydan.erp.contabilidad.util.ParametroContaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.ParametroContaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.ParametroConta;
import com.bydan.erp.contabilidad.business.logic.ParametroContaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroContaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroContaLogic.class);
	
	protected ParametroContaDataAccess parametrocontaDataAccess; 	
	protected ParametroConta parametroconta;
	protected List<ParametroConta> parametrocontas;
	protected Object parametrocontaObject;	
	protected List<Object> parametrocontasObject;
	
	public static ClassValidator<ParametroConta> parametrocontaValidator = new ClassValidator<ParametroConta>(ParametroConta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroContaLogicAdditional parametrocontaLogicAdditional=null;
	
	public ParametroContaLogicAdditional getParametroContaLogicAdditional() {
		return this.parametrocontaLogicAdditional;
	}
	
	public void setParametroContaLogicAdditional(ParametroContaLogicAdditional parametrocontaLogicAdditional) {
		try {
			this.parametrocontaLogicAdditional=parametrocontaLogicAdditional;
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
	
	
	
	
	public  ParametroContaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametrocontaDataAccess = new ParametroContaDataAccess();
			
			this.parametrocontas= new ArrayList<ParametroConta>();
			this.parametroconta= new ParametroConta();
			
			this.parametrocontaObject=new Object();
			this.parametrocontasObject=new ArrayList<Object>();
				
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
			
			this.parametrocontaDataAccess.setConnexionType(this.connexionType);
			this.parametrocontaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroContaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametrocontaDataAccess = new ParametroContaDataAccess();
			this.parametrocontas= new ArrayList<ParametroConta>();
			this.parametroconta= new ParametroConta();
			this.parametrocontaObject=new Object();
			this.parametrocontasObject=new ArrayList<Object>();
			
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
			
			this.parametrocontaDataAccess.setConnexionType(this.connexionType);
			this.parametrocontaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroConta getParametroConta() throws Exception {	
		ParametroContaLogicAdditional.checkParametroContaToGet(parametroconta,this.datosCliente,this.arrDatoGeneral);
		ParametroContaLogicAdditional.updateParametroContaToGet(parametroconta,this.arrDatoGeneral);
		
		return parametroconta;
	}
		
	public void setParametroConta(ParametroConta newParametroConta) {
		this.parametroconta = newParametroConta;
	}
	
	public ParametroContaDataAccess getParametroContaDataAccess() {
		return parametrocontaDataAccess;
	}
	
	public void setParametroContaDataAccess(ParametroContaDataAccess newparametrocontaDataAccess) {
		this.parametrocontaDataAccess = newparametrocontaDataAccess;
	}
	
	public List<ParametroConta> getParametroContas() throws Exception {		
		this.quitarParametroContasNulos();
		
		ParametroContaLogicAdditional.checkParametroContaToGets(parametrocontas,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroConta parametrocontaLocal: parametrocontas ) {
			ParametroContaLogicAdditional.updateParametroContaToGet(parametrocontaLocal,this.arrDatoGeneral);
		}
		
		return parametrocontas;
	}
	
	public void setParametroContas(List<ParametroConta> newParametroContas) {
		this.parametrocontas = newParametroContas;
	}
	
	public Object getParametroContaObject() {	
		this.parametrocontaObject=this.parametrocontaDataAccess.getEntityObject();
		return this.parametrocontaObject;
	}
		
	public void setParametroContaObject(Object newParametroContaObject) {
		this.parametrocontaObject = newParametroContaObject;
	}
	
	public List<Object> getParametroContasObject() {		
		this.parametrocontasObject=this.parametrocontaDataAccess.getEntitiesObject();
		return this.parametrocontasObject;
	}
		
	public void setParametroContasObject(List<Object> newParametroContasObject) {
		this.parametrocontasObject = newParametroContasObject;
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
		
		if(this.parametrocontaDataAccess!=null) {
			this.parametrocontaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametrocontaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametrocontaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametroconta = new  ParametroConta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametroconta=parametrocontaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroconta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametroconta);
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
		parametroconta = new  ParametroConta();
		  		  
        try {
			
			parametroconta=parametrocontaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroconta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametroconta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametroconta = new  ParametroConta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametroconta=parametrocontaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroconta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametroconta);
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
		parametroconta = new  ParametroConta();
		  		  
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
		parametroconta = new  ParametroConta();
		  		  
        try {
			
			parametroconta=parametrocontaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroconta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametroconta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametroconta = new  ParametroConta();
		  		  
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
		parametroconta = new  ParametroConta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametrocontaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroconta = new  ParametroConta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametrocontaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametroconta = new  ParametroConta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametrocontaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroconta = new  ParametroConta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametrocontaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametroconta = new  ParametroConta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametrocontaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroconta = new  ParametroConta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametrocontaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrocontas = new  ArrayList<ParametroConta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontas=parametrocontaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroConta(parametrocontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
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
		parametrocontas = new  ArrayList<ParametroConta>();
		  		  
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
		parametrocontas = new  ArrayList<ParametroConta>();
		  		  
        try {			
			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontas=parametrocontaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroConta(parametrocontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametrocontas = new  ArrayList<ParametroConta>();
		  		  
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
		parametrocontas = new  ArrayList<ParametroConta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontas=parametrocontaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroConta(parametrocontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
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
		parametrocontas = new  ArrayList<ParametroConta>();
		  		  
        try {
			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontas=parametrocontaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroConta(parametrocontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
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
		parametrocontas = new  ArrayList<ParametroConta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontas=parametrocontaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroConta(parametrocontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
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
		parametrocontas = new  ArrayList<ParametroConta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontas=parametrocontaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroConta(parametrocontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametroconta = new  ParametroConta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroconta=parametrocontaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroConta(parametroconta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametroconta);
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
		parametroconta = new  ParametroConta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroconta=parametrocontaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroConta(parametroconta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametroconta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrocontas = new  ArrayList<ParametroConta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontas=parametrocontaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroConta(parametrocontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
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
		parametrocontas = new  ArrayList<ParametroConta>();
		  		  
        try {
			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontas=parametrocontaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroConta(parametrocontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroContasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametrocontas = new  ArrayList<ParametroConta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getTodosParametroContasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroConta(parametrocontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
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
	
	public  void  getTodosParametroContas(String sFinalQuery,Pagination pagination)throws Exception {
		parametrocontas = new  ArrayList<ParametroConta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroConta(parametrocontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroConta(ParametroConta parametroconta) throws Exception {
		Boolean estaValidado=false;
		
		if(parametroconta.getIsNew() || parametroconta.getIsChanged()) { 
			this.invalidValues = parametrocontaValidator.getInvalidValues(parametroconta);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametroconta);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroConta(List<ParametroConta> ParametroContas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroConta parametrocontaLocal:parametrocontas) {				
			estaValidadoObjeto=this.validarGuardarParametroConta(parametrocontaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroConta(List<ParametroConta> ParametroContas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroConta(parametrocontas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroConta(ParametroConta ParametroConta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroConta(parametroconta)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroConta parametroconta) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametroconta.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroContaConstantesFunciones.getParametroContaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametroconta","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroContaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroContaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroContaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-saveParametroContaWithConnection");connexion.begin();			
			
			ParametroContaLogicAdditional.checkParametroContaToSave(this.parametroconta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroContaLogicAdditional.updateParametroContaToSave(this.parametroconta,this.arrDatoGeneral);
			
			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametroconta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroConta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroConta(this.parametroconta)) {
				ParametroContaDataAccess.save(this.parametroconta, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametroconta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroContaLogicAdditional.checkParametroContaToSaveAfter(this.parametroconta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroConta();
			
			connexion.commit();			
			
			if(this.parametroconta.getIsDeleted()) {
				this.parametroconta=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroConta()throws Exception {	
		try {	
			
			ParametroContaLogicAdditional.checkParametroContaToSave(this.parametroconta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroContaLogicAdditional.updateParametroContaToSave(this.parametroconta,this.arrDatoGeneral);
			
			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametroconta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroConta(this.parametroconta)) {			
				ParametroContaDataAccess.save(this.parametroconta, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametroconta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroContaLogicAdditional.checkParametroContaToSaveAfter(this.parametroconta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametroconta.getIsDeleted()) {
				this.parametroconta=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroContasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-saveParametroContasWithConnection");connexion.begin();			
			
			ParametroContaLogicAdditional.checkParametroContaToSaves(parametrocontas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroContas();
			
			Boolean validadoTodosParametroConta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroConta parametrocontaLocal:parametrocontas) {		
				if(parametrocontaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroContaLogicAdditional.updateParametroContaToSave(parametrocontaLocal,this.arrDatoGeneral);
	        	
				ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrocontaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroConta(parametrocontaLocal)) {
					ParametroContaDataAccess.save(parametrocontaLocal, connexion);				
				} else {
					validadoTodosParametroConta=false;
				}
			}
			
			if(!validadoTodosParametroConta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroContaLogicAdditional.checkParametroContaToSavesAfter(parametrocontas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroContas();
			
			connexion.commit();		
			
			this.quitarParametroContasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroContas()throws Exception {				
		 try {	
			ParametroContaLogicAdditional.checkParametroContaToSaves(parametrocontas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroConta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroConta parametrocontaLocal:parametrocontas) {				
				if(parametrocontaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroContaLogicAdditional.updateParametroContaToSave(parametrocontaLocal,this.arrDatoGeneral);
	        	
				ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrocontaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroConta(parametrocontaLocal)) {				
					ParametroContaDataAccess.save(parametrocontaLocal, connexion);				
				} else {
					validadoTodosParametroConta=false;
				}
			}
			
			if(!validadoTodosParametroConta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroContaLogicAdditional.checkParametroContaToSavesAfter(parametrocontas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroContasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroContaParameterReturnGeneral procesarAccionParametroContas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroConta> parametrocontas,ParametroContaParameterReturnGeneral parametrocontaParameterGeneral)throws Exception {
		 try {	
			ParametroContaParameterReturnGeneral parametrocontaReturnGeneral=new ParametroContaParameterReturnGeneral();
	
			ParametroContaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrocontas,parametrocontaParameterGeneral,parametrocontaReturnGeneral);
			
			return parametrocontaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroContaParameterReturnGeneral procesarAccionParametroContasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroConta> parametrocontas,ParametroContaParameterReturnGeneral parametrocontaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-procesarAccionParametroContasWithConnection");connexion.begin();			
			
			ParametroContaParameterReturnGeneral parametrocontaReturnGeneral=new ParametroContaParameterReturnGeneral();
	
			ParametroContaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrocontas,parametrocontaParameterGeneral,parametrocontaReturnGeneral);
			
			this.connexion.commit();
			
			return parametrocontaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroContaParameterReturnGeneral procesarEventosParametroContas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroConta> parametrocontas,ParametroConta parametroconta,ParametroContaParameterReturnGeneral parametrocontaParameterGeneral,Boolean isEsNuevoParametroConta,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroContaParameterReturnGeneral parametrocontaReturnGeneral=new ParametroContaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrocontaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroContaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrocontas,parametroconta,parametrocontaParameterGeneral,parametrocontaReturnGeneral,isEsNuevoParametroConta,clases);
			
			return parametrocontaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroContaParameterReturnGeneral procesarEventosParametroContasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroConta> parametrocontas,ParametroConta parametroconta,ParametroContaParameterReturnGeneral parametrocontaParameterGeneral,Boolean isEsNuevoParametroConta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-procesarEventosParametroContasWithConnection");connexion.begin();			
			
			ParametroContaParameterReturnGeneral parametrocontaReturnGeneral=new ParametroContaParameterReturnGeneral();
	
			parametrocontaReturnGeneral.setParametroConta(parametroconta);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrocontaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroContaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrocontas,parametroconta,parametrocontaParameterGeneral,parametrocontaReturnGeneral,isEsNuevoParametroConta,clases);
			
			this.connexion.commit();
			
			return parametrocontaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroContaParameterReturnGeneral procesarImportacionParametroContasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroContaParameterReturnGeneral parametrocontaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-procesarImportacionParametroContasWithConnection");connexion.begin();			
			
			ParametroContaParameterReturnGeneral parametrocontaReturnGeneral=new ParametroContaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametrocontas=new ArrayList<ParametroConta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametroconta=new ParametroConta();
				
				
				if(conColumnasBase) {this.parametroconta.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametroconta.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.parametroconta.setcon_mascara(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroconta.setnumero_nivel(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametroconta.setes_presupuesto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroconta.setes_lote(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroconta.setcon_secuencial_automatico(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroconta.setcon_cuentas_niff(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroconta.setcon_centro_costo_mascara(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroconta.setcon_centro_costo_nueva_estructura(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroconta.setcentro_costo_numero_nivel(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.parametrocontas.add(this.parametroconta);
			}
			
			this.saveParametroContas();
			
			this.connexion.commit();
			
			parametrocontaReturnGeneral.setConRetornoEstaProcesado(true);
			parametrocontaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametrocontaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroContasEliminados() throws Exception {				
		
		List<ParametroConta> parametrocontasAux= new ArrayList<ParametroConta>();
		
		for(ParametroConta parametroconta:parametrocontas) {
			if(!parametroconta.getIsDeleted()) {
				parametrocontasAux.add(parametroconta);
			}
		}
		
		parametrocontas=parametrocontasAux;
	}
	
	public void quitarParametroContasNulos() throws Exception {				
		
		List<ParametroConta> parametrocontasAux= new ArrayList<ParametroConta>();
		
		for(ParametroConta parametroconta : this.parametrocontas) {
			if(parametroconta==null) {
				parametrocontasAux.add(parametroconta);
			}
		}
		
		//this.parametrocontas=parametrocontasAux;
		
		this.parametrocontas.removeAll(parametrocontasAux);
	}
	
	public void getSetVersionRowParametroContaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametroconta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametroconta.getIsDeleted() || (parametroconta.getIsChanged()&&!parametroconta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametrocontaDataAccess.getSetVersionRowParametroConta(connexion,parametroconta.getId());
				
				if(!parametroconta.getVersionRow().equals(timestamp)) {	
					parametroconta.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametroconta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroConta()throws Exception {	
		
		if(parametroconta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametroconta.getIsDeleted() || (parametroconta.getIsChanged()&&!parametroconta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametrocontaDataAccess.getSetVersionRowParametroConta(connexion,parametroconta.getId());
			
			try {							
				if(!parametroconta.getVersionRow().equals(timestamp)) {	
					parametroconta.setVersionRow(timestamp);
				}
				
				parametroconta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroContasWithConnection()throws Exception {	
		if(parametrocontas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroConta parametrocontaAux:parametrocontas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametrocontaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrocontaAux.getIsDeleted() || (parametrocontaAux.getIsChanged()&&!parametrocontaAux.getIsNew())) {
						
						timestamp=parametrocontaDataAccess.getSetVersionRowParametroConta(connexion,parametrocontaAux.getId());
						
						if(!parametroconta.getVersionRow().equals(timestamp)) {	
							parametrocontaAux.setVersionRow(timestamp);
						}
								
						parametrocontaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroContas()throws Exception {	
		if(parametrocontas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroConta parametrocontaAux:parametrocontas) {
					if(parametrocontaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrocontaAux.getIsDeleted() || (parametrocontaAux.getIsChanged()&&!parametrocontaAux.getIsNew())) {
						
						timestamp=parametrocontaDataAccess.getSetVersionRowParametroConta(connexion,parametrocontaAux.getId());
						
						if(!parametrocontaAux.getVersionRow().equals(timestamp)) {	
							parametrocontaAux.setVersionRow(timestamp);
						}
						
													
						parametrocontaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroContaParameterReturnGeneral cargarCombosLoteForeignKeyParametroContaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalMoneda,String finalQueryGlobalMonedaExtranjera,String finalQueryGlobalCuentaContableActivo,String finalQueryGlobalCuentaContablePasivo,String finalQueryGlobalCuentaContablePatrimonio,String finalQueryGlobalCuentaContableIngreso,String finalQueryGlobalCuentaContableEgreso,String finalQueryGlobalCuentaContableResumen,String finalQueryGlobalCuentaContableDeudor,String finalQueryGlobalCuentaContableAcreedor,String finalQueryGlobalCuentaContableIngreso1,String finalQueryGlobalCuentaContableIngreso2,String finalQueryGlobalCuentaContableIngreso3,String finalQueryGlobalCuentaContableEgreso1,String finalQueryGlobalCuentaContableEgreso2,String finalQueryGlobalCuentaContableEgreso3) throws Exception {
		ParametroContaParameterReturnGeneral  parametrocontaReturnGeneral =new ParametroContaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroContaWithConnection");connexion.begin();
			
			parametrocontaReturnGeneral =new ParametroContaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrocontaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			parametrocontaReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Moneda> monedaextranjerasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaextranjeraLogic=new MonedaLogic();
			monedaextranjeraLogic.setConnexion(this.connexion);
			monedaextranjeraLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMonedaExtranjera.equals("NONE")) {
				monedaextranjeraLogic.getTodosMonedas(finalQueryGlobalMonedaExtranjera,new Pagination());
				monedaextranjerasForeignKey=monedaextranjeraLogic.getMonedas();
			}

			parametrocontaReturnGeneral.setmonedaextranjerasForeignKey(monedaextranjerasForeignKey);


			List<CuentaContable> cuentacontableactivosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableactivoLogic=new CuentaContableLogic();
			cuentacontableactivoLogic.setConnexion(this.connexion);
			cuentacontableactivoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableActivo.equals("NONE")) {
				cuentacontableactivoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableActivo,new Pagination());
				cuentacontableactivosForeignKey=cuentacontableactivoLogic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontableactivosForeignKey(cuentacontableactivosForeignKey);


			List<CuentaContable> cuentacontablepasivosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablepasivoLogic=new CuentaContableLogic();
			cuentacontablepasivoLogic.setConnexion(this.connexion);
			cuentacontablepasivoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContablePasivo.equals("NONE")) {
				cuentacontablepasivoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContablePasivo,new Pagination());
				cuentacontablepasivosForeignKey=cuentacontablepasivoLogic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontablepasivosForeignKey(cuentacontablepasivosForeignKey);


			List<CuentaContable> cuentacontablepatrimoniosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablepatrimonioLogic=new CuentaContableLogic();
			cuentacontablepatrimonioLogic.setConnexion(this.connexion);
			cuentacontablepatrimonioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContablePatrimonio.equals("NONE")) {
				cuentacontablepatrimonioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContablePatrimonio,new Pagination());
				cuentacontablepatrimoniosForeignKey=cuentacontablepatrimonioLogic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontablepatrimoniosForeignKey(cuentacontablepatrimoniosForeignKey);


			List<CuentaContable> cuentacontableingresosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableingresoLogic=new CuentaContableLogic();
			cuentacontableingresoLogic.setConnexion(this.connexion);
			cuentacontableingresoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIngreso.equals("NONE")) {
				cuentacontableingresoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableIngreso,new Pagination());
				cuentacontableingresosForeignKey=cuentacontableingresoLogic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontableingresosForeignKey(cuentacontableingresosForeignKey);


			List<CuentaContable> cuentacontableegresosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableegresoLogic=new CuentaContableLogic();
			cuentacontableegresoLogic.setConnexion(this.connexion);
			cuentacontableegresoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableEgreso.equals("NONE")) {
				cuentacontableegresoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableEgreso,new Pagination());
				cuentacontableegresosForeignKey=cuentacontableegresoLogic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontableegresosForeignKey(cuentacontableegresosForeignKey);


			List<CuentaContable> cuentacontableresumensForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableresumenLogic=new CuentaContableLogic();
			cuentacontableresumenLogic.setConnexion(this.connexion);
			cuentacontableresumenLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableResumen.equals("NONE")) {
				cuentacontableresumenLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableResumen,new Pagination());
				cuentacontableresumensForeignKey=cuentacontableresumenLogic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontableresumensForeignKey(cuentacontableresumensForeignKey);


			List<CuentaContable> cuentacontabledeudorsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledeudorLogic=new CuentaContableLogic();
			cuentacontabledeudorLogic.setConnexion(this.connexion);
			cuentacontabledeudorLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDeudor.equals("NONE")) {
				cuentacontabledeudorLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDeudor,new Pagination());
				cuentacontabledeudorsForeignKey=cuentacontabledeudorLogic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontabledeudorsForeignKey(cuentacontabledeudorsForeignKey);


			List<CuentaContable> cuentacontableacreedorsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableacreedorLogic=new CuentaContableLogic();
			cuentacontableacreedorLogic.setConnexion(this.connexion);
			cuentacontableacreedorLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableAcreedor.equals("NONE")) {
				cuentacontableacreedorLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableAcreedor,new Pagination());
				cuentacontableacreedorsForeignKey=cuentacontableacreedorLogic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontableacreedorsForeignKey(cuentacontableacreedorsForeignKey);


			List<CuentaContable> cuentacontableingreso1sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableingreso1Logic=new CuentaContableLogic();
			cuentacontableingreso1Logic.setConnexion(this.connexion);
			cuentacontableingreso1Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIngreso1.equals("NONE")) {
				cuentacontableingreso1Logic.getTodosCuentaContables(finalQueryGlobalCuentaContableIngreso1,new Pagination());
				cuentacontableingreso1sForeignKey=cuentacontableingreso1Logic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontableingreso1sForeignKey(cuentacontableingreso1sForeignKey);


			List<CuentaContable> cuentacontableingreso2sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableingreso2Logic=new CuentaContableLogic();
			cuentacontableingreso2Logic.setConnexion(this.connexion);
			cuentacontableingreso2Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIngreso2.equals("NONE")) {
				cuentacontableingreso2Logic.getTodosCuentaContables(finalQueryGlobalCuentaContableIngreso2,new Pagination());
				cuentacontableingreso2sForeignKey=cuentacontableingreso2Logic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontableingreso2sForeignKey(cuentacontableingreso2sForeignKey);


			List<CuentaContable> cuentacontableingreso3sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableingreso3Logic=new CuentaContableLogic();
			cuentacontableingreso3Logic.setConnexion(this.connexion);
			cuentacontableingreso3Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIngreso3.equals("NONE")) {
				cuentacontableingreso3Logic.getTodosCuentaContables(finalQueryGlobalCuentaContableIngreso3,new Pagination());
				cuentacontableingreso3sForeignKey=cuentacontableingreso3Logic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontableingreso3sForeignKey(cuentacontableingreso3sForeignKey);


			List<CuentaContable> cuentacontableegreso1sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableegreso1Logic=new CuentaContableLogic();
			cuentacontableegreso1Logic.setConnexion(this.connexion);
			cuentacontableegreso1Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableEgreso1.equals("NONE")) {
				cuentacontableegreso1Logic.getTodosCuentaContables(finalQueryGlobalCuentaContableEgreso1,new Pagination());
				cuentacontableegreso1sForeignKey=cuentacontableegreso1Logic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontableegreso1sForeignKey(cuentacontableegreso1sForeignKey);


			List<CuentaContable> cuentacontableegreso2sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableegreso2Logic=new CuentaContableLogic();
			cuentacontableegreso2Logic.setConnexion(this.connexion);
			cuentacontableegreso2Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableEgreso2.equals("NONE")) {
				cuentacontableegreso2Logic.getTodosCuentaContables(finalQueryGlobalCuentaContableEgreso2,new Pagination());
				cuentacontableegreso2sForeignKey=cuentacontableegreso2Logic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontableegreso2sForeignKey(cuentacontableegreso2sForeignKey);


			List<CuentaContable> cuentacontableegreso3sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableegreso3Logic=new CuentaContableLogic();
			cuentacontableegreso3Logic.setConnexion(this.connexion);
			cuentacontableegreso3Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableEgreso3.equals("NONE")) {
				cuentacontableegreso3Logic.getTodosCuentaContables(finalQueryGlobalCuentaContableEgreso3,new Pagination());
				cuentacontableegreso3sForeignKey=cuentacontableegreso3Logic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontableegreso3sForeignKey(cuentacontableegreso3sForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametrocontaReturnGeneral;
	}
	
	public ParametroContaParameterReturnGeneral cargarCombosLoteForeignKeyParametroConta(String finalQueryGlobalEmpresa,String finalQueryGlobalMoneda,String finalQueryGlobalMonedaExtranjera,String finalQueryGlobalCuentaContableActivo,String finalQueryGlobalCuentaContablePasivo,String finalQueryGlobalCuentaContablePatrimonio,String finalQueryGlobalCuentaContableIngreso,String finalQueryGlobalCuentaContableEgreso,String finalQueryGlobalCuentaContableResumen,String finalQueryGlobalCuentaContableDeudor,String finalQueryGlobalCuentaContableAcreedor,String finalQueryGlobalCuentaContableIngreso1,String finalQueryGlobalCuentaContableIngreso2,String finalQueryGlobalCuentaContableIngreso3,String finalQueryGlobalCuentaContableEgreso1,String finalQueryGlobalCuentaContableEgreso2,String finalQueryGlobalCuentaContableEgreso3) throws Exception {
		ParametroContaParameterReturnGeneral  parametrocontaReturnGeneral =new ParametroContaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametrocontaReturnGeneral =new ParametroContaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrocontaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			parametrocontaReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Moneda> monedaextranjerasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaextranjeraLogic=new MonedaLogic();
			monedaextranjeraLogic.setConnexion(this.connexion);
			monedaextranjeraLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMonedaExtranjera.equals("NONE")) {
				monedaextranjeraLogic.getTodosMonedas(finalQueryGlobalMonedaExtranjera,new Pagination());
				monedaextranjerasForeignKey=monedaextranjeraLogic.getMonedas();
			}

			parametrocontaReturnGeneral.setmonedaextranjerasForeignKey(monedaextranjerasForeignKey);


			List<CuentaContable> cuentacontableactivosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableactivoLogic=new CuentaContableLogic();
			cuentacontableactivoLogic.setConnexion(this.connexion);
			cuentacontableactivoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableActivo.equals("NONE")) {
				cuentacontableactivoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableActivo,new Pagination());
				cuentacontableactivosForeignKey=cuentacontableactivoLogic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontableactivosForeignKey(cuentacontableactivosForeignKey);


			List<CuentaContable> cuentacontablepasivosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablepasivoLogic=new CuentaContableLogic();
			cuentacontablepasivoLogic.setConnexion(this.connexion);
			cuentacontablepasivoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContablePasivo.equals("NONE")) {
				cuentacontablepasivoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContablePasivo,new Pagination());
				cuentacontablepasivosForeignKey=cuentacontablepasivoLogic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontablepasivosForeignKey(cuentacontablepasivosForeignKey);


			List<CuentaContable> cuentacontablepatrimoniosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablepatrimonioLogic=new CuentaContableLogic();
			cuentacontablepatrimonioLogic.setConnexion(this.connexion);
			cuentacontablepatrimonioLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContablePatrimonio.equals("NONE")) {
				cuentacontablepatrimonioLogic.getTodosCuentaContables(finalQueryGlobalCuentaContablePatrimonio,new Pagination());
				cuentacontablepatrimoniosForeignKey=cuentacontablepatrimonioLogic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontablepatrimoniosForeignKey(cuentacontablepatrimoniosForeignKey);


			List<CuentaContable> cuentacontableingresosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableingresoLogic=new CuentaContableLogic();
			cuentacontableingresoLogic.setConnexion(this.connexion);
			cuentacontableingresoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIngreso.equals("NONE")) {
				cuentacontableingresoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableIngreso,new Pagination());
				cuentacontableingresosForeignKey=cuentacontableingresoLogic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontableingresosForeignKey(cuentacontableingresosForeignKey);


			List<CuentaContable> cuentacontableegresosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableegresoLogic=new CuentaContableLogic();
			cuentacontableegresoLogic.setConnexion(this.connexion);
			cuentacontableegresoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableEgreso.equals("NONE")) {
				cuentacontableegresoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableEgreso,new Pagination());
				cuentacontableegresosForeignKey=cuentacontableegresoLogic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontableegresosForeignKey(cuentacontableegresosForeignKey);


			List<CuentaContable> cuentacontableresumensForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableresumenLogic=new CuentaContableLogic();
			cuentacontableresumenLogic.setConnexion(this.connexion);
			cuentacontableresumenLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableResumen.equals("NONE")) {
				cuentacontableresumenLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableResumen,new Pagination());
				cuentacontableresumensForeignKey=cuentacontableresumenLogic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontableresumensForeignKey(cuentacontableresumensForeignKey);


			List<CuentaContable> cuentacontabledeudorsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledeudorLogic=new CuentaContableLogic();
			cuentacontabledeudorLogic.setConnexion(this.connexion);
			cuentacontabledeudorLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDeudor.equals("NONE")) {
				cuentacontabledeudorLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDeudor,new Pagination());
				cuentacontabledeudorsForeignKey=cuentacontabledeudorLogic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontabledeudorsForeignKey(cuentacontabledeudorsForeignKey);


			List<CuentaContable> cuentacontableacreedorsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableacreedorLogic=new CuentaContableLogic();
			cuentacontableacreedorLogic.setConnexion(this.connexion);
			cuentacontableacreedorLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableAcreedor.equals("NONE")) {
				cuentacontableacreedorLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableAcreedor,new Pagination());
				cuentacontableacreedorsForeignKey=cuentacontableacreedorLogic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontableacreedorsForeignKey(cuentacontableacreedorsForeignKey);


			List<CuentaContable> cuentacontableingreso1sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableingreso1Logic=new CuentaContableLogic();
			cuentacontableingreso1Logic.setConnexion(this.connexion);
			cuentacontableingreso1Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIngreso1.equals("NONE")) {
				cuentacontableingreso1Logic.getTodosCuentaContables(finalQueryGlobalCuentaContableIngreso1,new Pagination());
				cuentacontableingreso1sForeignKey=cuentacontableingreso1Logic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontableingreso1sForeignKey(cuentacontableingreso1sForeignKey);


			List<CuentaContable> cuentacontableingreso2sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableingreso2Logic=new CuentaContableLogic();
			cuentacontableingreso2Logic.setConnexion(this.connexion);
			cuentacontableingreso2Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIngreso2.equals("NONE")) {
				cuentacontableingreso2Logic.getTodosCuentaContables(finalQueryGlobalCuentaContableIngreso2,new Pagination());
				cuentacontableingreso2sForeignKey=cuentacontableingreso2Logic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontableingreso2sForeignKey(cuentacontableingreso2sForeignKey);


			List<CuentaContable> cuentacontableingreso3sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableingreso3Logic=new CuentaContableLogic();
			cuentacontableingreso3Logic.setConnexion(this.connexion);
			cuentacontableingreso3Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableIngreso3.equals("NONE")) {
				cuentacontableingreso3Logic.getTodosCuentaContables(finalQueryGlobalCuentaContableIngreso3,new Pagination());
				cuentacontableingreso3sForeignKey=cuentacontableingreso3Logic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontableingreso3sForeignKey(cuentacontableingreso3sForeignKey);


			List<CuentaContable> cuentacontableegreso1sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableegreso1Logic=new CuentaContableLogic();
			cuentacontableegreso1Logic.setConnexion(this.connexion);
			cuentacontableegreso1Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableEgreso1.equals("NONE")) {
				cuentacontableegreso1Logic.getTodosCuentaContables(finalQueryGlobalCuentaContableEgreso1,new Pagination());
				cuentacontableegreso1sForeignKey=cuentacontableegreso1Logic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontableegreso1sForeignKey(cuentacontableegreso1sForeignKey);


			List<CuentaContable> cuentacontableegreso2sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableegreso2Logic=new CuentaContableLogic();
			cuentacontableegreso2Logic.setConnexion(this.connexion);
			cuentacontableegreso2Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableEgreso2.equals("NONE")) {
				cuentacontableegreso2Logic.getTodosCuentaContables(finalQueryGlobalCuentaContableEgreso2,new Pagination());
				cuentacontableegreso2sForeignKey=cuentacontableegreso2Logic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontableegreso2sForeignKey(cuentacontableegreso2sForeignKey);


			List<CuentaContable> cuentacontableegreso3sForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableegreso3Logic=new CuentaContableLogic();
			cuentacontableegreso3Logic.setConnexion(this.connexion);
			cuentacontableegreso3Logic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableEgreso3.equals("NONE")) {
				cuentacontableegreso3Logic.getTodosCuentaContables(finalQueryGlobalCuentaContableEgreso3,new Pagination());
				cuentacontableegreso3sForeignKey=cuentacontableegreso3Logic.getCuentaContables();
			}

			parametrocontaReturnGeneral.setcuentacontableegreso3sForeignKey(cuentacontableegreso3sForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametrocontaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyParametroContaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ParametroContaDetalleLogic parametrocontadetalleLogic=new ParametroContaDetalleLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyParametroContaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ParametroContaDetalle.class));
											
			

			parametrocontadetalleLogic.setConnexion(this.getConnexion());
			parametrocontadetalleLogic.setDatosCliente(this.datosCliente);
			parametrocontadetalleLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(ParametroConta parametroconta:this.parametrocontas) {
				

				classes=new ArrayList<Classe>();
				classes=ParametroContaDetalleConstantesFunciones.getClassesForeignKeysOfParametroContaDetalle(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametrocontadetalleLogic.setParametroContaDetalles(parametroconta.parametrocontadetalles);
				parametrocontadetalleLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(ParametroConta parametroconta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroContaLogicAdditional.updateParametroContaToGet(parametroconta,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametroconta.setEmpresa(parametrocontaDataAccess.getEmpresa(connexion,parametroconta));
		parametroconta.setMoneda(parametrocontaDataAccess.getMoneda(connexion,parametroconta));
		parametroconta.setMonedaExtranjera(parametrocontaDataAccess.getMonedaExtranjera(connexion,parametroconta));
		parametroconta.setCuentaContableActivo(parametrocontaDataAccess.getCuentaContableActivo(connexion,parametroconta));
		parametroconta.setCuentaContablePasivo(parametrocontaDataAccess.getCuentaContablePasivo(connexion,parametroconta));
		parametroconta.setCuentaContablePatrimonio(parametrocontaDataAccess.getCuentaContablePatrimonio(connexion,parametroconta));
		parametroconta.setCuentaContableIngreso(parametrocontaDataAccess.getCuentaContableIngreso(connexion,parametroconta));
		parametroconta.setCuentaContableEgreso(parametrocontaDataAccess.getCuentaContableEgreso(connexion,parametroconta));
		parametroconta.setCuentaContableResumen(parametrocontaDataAccess.getCuentaContableResumen(connexion,parametroconta));
		parametroconta.setCuentaContableDeudor(parametrocontaDataAccess.getCuentaContableDeudor(connexion,parametroconta));
		parametroconta.setCuentaContableAcreedor(parametrocontaDataAccess.getCuentaContableAcreedor(connexion,parametroconta));
		parametroconta.setCuentaContableIngreso1(parametrocontaDataAccess.getCuentaContableIngreso1(connexion,parametroconta));
		parametroconta.setCuentaContableIngreso2(parametrocontaDataAccess.getCuentaContableIngreso2(connexion,parametroconta));
		parametroconta.setCuentaContableIngreso3(parametrocontaDataAccess.getCuentaContableIngreso3(connexion,parametroconta));
		parametroconta.setCuentaContableEgreso1(parametrocontaDataAccess.getCuentaContableEgreso1(connexion,parametroconta));
		parametroconta.setCuentaContableEgreso2(parametrocontaDataAccess.getCuentaContableEgreso2(connexion,parametroconta));
		parametroconta.setCuentaContableEgreso3(parametrocontaDataAccess.getCuentaContableEgreso3(connexion,parametroconta));
		parametroconta.setParametroContaDetalles(parametrocontaDataAccess.getParametroContaDetalles(connexion,parametroconta));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametroconta.setEmpresa(parametrocontaDataAccess.getEmpresa(connexion,parametroconta));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				parametroconta.setMoneda(parametrocontaDataAccess.getMoneda(connexion,parametroconta));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				parametroconta.setMonedaExtranjera(parametrocontaDataAccess.getMonedaExtranjera(connexion,parametroconta));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableActivo(parametrocontaDataAccess.getCuentaContableActivo(connexion,parametroconta));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContablePasivo(parametrocontaDataAccess.getCuentaContablePasivo(connexion,parametroconta));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContablePatrimonio(parametrocontaDataAccess.getCuentaContablePatrimonio(connexion,parametroconta));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableIngreso(parametrocontaDataAccess.getCuentaContableIngreso(connexion,parametroconta));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableEgreso(parametrocontaDataAccess.getCuentaContableEgreso(connexion,parametroconta));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableResumen(parametrocontaDataAccess.getCuentaContableResumen(connexion,parametroconta));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableDeudor(parametrocontaDataAccess.getCuentaContableDeudor(connexion,parametroconta));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableAcreedor(parametrocontaDataAccess.getCuentaContableAcreedor(connexion,parametroconta));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableIngreso1(parametrocontaDataAccess.getCuentaContableIngreso1(connexion,parametroconta));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableIngreso2(parametrocontaDataAccess.getCuentaContableIngreso2(connexion,parametroconta));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableIngreso3(parametrocontaDataAccess.getCuentaContableIngreso3(connexion,parametroconta));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableEgreso1(parametrocontaDataAccess.getCuentaContableEgreso1(connexion,parametroconta));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableEgreso2(parametrocontaDataAccess.getCuentaContableEgreso2(connexion,parametroconta));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableEgreso3(parametrocontaDataAccess.getCuentaContableEgreso3(connexion,parametroconta));
				continue;
			}

			if(clas.clas.equals(ParametroContaDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				parametroconta.setParametroContaDetalles(parametrocontaDataAccess.getParametroContaDetalles(connexion,parametroconta));

				if(this.isConDeep) {
					ParametroContaDetalleLogic parametrocontadetalleLogic= new ParametroContaDetalleLogic(this.connexion);
					parametrocontadetalleLogic.setParametroContaDetalles(parametroconta.getParametroContaDetalles());
					ArrayList<Classe> classesLocal=ParametroContaDetalleConstantesFunciones.getClassesForeignKeysOfParametroContaDetalle(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametrocontadetalleLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(parametrocontadetalleLogic.getParametroContaDetalles());
					parametroconta.setParametroContaDetalles(parametrocontadetalleLogic.getParametroContaDetalles());
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
			parametroconta.setEmpresa(parametrocontaDataAccess.getEmpresa(connexion,parametroconta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setMoneda(parametrocontaDataAccess.getMoneda(connexion,parametroconta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setMonedaExtranjera(parametrocontaDataAccess.getMonedaExtranjera(connexion,parametroconta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableActivo(parametrocontaDataAccess.getCuentaContableActivo(connexion,parametroconta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContablePasivo(parametrocontaDataAccess.getCuentaContablePasivo(connexion,parametroconta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContablePatrimonio(parametrocontaDataAccess.getCuentaContablePatrimonio(connexion,parametroconta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableIngreso(parametrocontaDataAccess.getCuentaContableIngreso(connexion,parametroconta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableEgreso(parametrocontaDataAccess.getCuentaContableEgreso(connexion,parametroconta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableResumen(parametrocontaDataAccess.getCuentaContableResumen(connexion,parametroconta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableDeudor(parametrocontaDataAccess.getCuentaContableDeudor(connexion,parametroconta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableAcreedor(parametrocontaDataAccess.getCuentaContableAcreedor(connexion,parametroconta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableIngreso1(parametrocontaDataAccess.getCuentaContableIngreso1(connexion,parametroconta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableIngreso2(parametrocontaDataAccess.getCuentaContableIngreso2(connexion,parametroconta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableIngreso3(parametrocontaDataAccess.getCuentaContableIngreso3(connexion,parametroconta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableEgreso1(parametrocontaDataAccess.getCuentaContableEgreso1(connexion,parametroconta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableEgreso2(parametrocontaDataAccess.getCuentaContableEgreso2(connexion,parametroconta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableEgreso3(parametrocontaDataAccess.getCuentaContableEgreso3(connexion,parametroconta));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroContaDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroContaDetalle.class));
			parametroconta.setParametroContaDetalles(parametrocontaDataAccess.getParametroContaDetalles(connexion,parametroconta));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametroconta.setEmpresa(parametrocontaDataAccess.getEmpresa(connexion,parametroconta));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametroconta.getEmpresa(),isDeep,deepLoadType,clases);
				
		parametroconta.setMoneda(parametrocontaDataAccess.getMoneda(connexion,parametroconta));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(parametroconta.getMoneda(),isDeep,deepLoadType,clases);
				
		parametroconta.setMonedaExtranjera(parametrocontaDataAccess.getMonedaExtranjera(connexion,parametroconta));
		MonedaLogic monedaextranjeraLogic= new MonedaLogic(connexion);
		monedaextranjeraLogic.deepLoad(parametroconta.getMonedaExtranjera(),isDeep,deepLoadType,clases);
				
		parametroconta.setCuentaContableActivo(parametrocontaDataAccess.getCuentaContableActivo(connexion,parametroconta));
		CuentaContableLogic cuentacontableactivoLogic= new CuentaContableLogic(connexion);
		cuentacontableactivoLogic.deepLoad(parametroconta.getCuentaContableActivo(),isDeep,deepLoadType,clases);
				
		parametroconta.setCuentaContablePasivo(parametrocontaDataAccess.getCuentaContablePasivo(connexion,parametroconta));
		CuentaContableLogic cuentacontablepasivoLogic= new CuentaContableLogic(connexion);
		cuentacontablepasivoLogic.deepLoad(parametroconta.getCuentaContablePasivo(),isDeep,deepLoadType,clases);
				
		parametroconta.setCuentaContablePatrimonio(parametrocontaDataAccess.getCuentaContablePatrimonio(connexion,parametroconta));
		CuentaContableLogic cuentacontablepatrimonioLogic= new CuentaContableLogic(connexion);
		cuentacontablepatrimonioLogic.deepLoad(parametroconta.getCuentaContablePatrimonio(),isDeep,deepLoadType,clases);
				
		parametroconta.setCuentaContableIngreso(parametrocontaDataAccess.getCuentaContableIngreso(connexion,parametroconta));
		CuentaContableLogic cuentacontableingresoLogic= new CuentaContableLogic(connexion);
		cuentacontableingresoLogic.deepLoad(parametroconta.getCuentaContableIngreso(),isDeep,deepLoadType,clases);
				
		parametroconta.setCuentaContableEgreso(parametrocontaDataAccess.getCuentaContableEgreso(connexion,parametroconta));
		CuentaContableLogic cuentacontableegresoLogic= new CuentaContableLogic(connexion);
		cuentacontableegresoLogic.deepLoad(parametroconta.getCuentaContableEgreso(),isDeep,deepLoadType,clases);
				
		parametroconta.setCuentaContableResumen(parametrocontaDataAccess.getCuentaContableResumen(connexion,parametroconta));
		CuentaContableLogic cuentacontableresumenLogic= new CuentaContableLogic(connexion);
		cuentacontableresumenLogic.deepLoad(parametroconta.getCuentaContableResumen(),isDeep,deepLoadType,clases);
				
		parametroconta.setCuentaContableDeudor(parametrocontaDataAccess.getCuentaContableDeudor(connexion,parametroconta));
		CuentaContableLogic cuentacontabledeudorLogic= new CuentaContableLogic(connexion);
		cuentacontabledeudorLogic.deepLoad(parametroconta.getCuentaContableDeudor(),isDeep,deepLoadType,clases);
				
		parametroconta.setCuentaContableAcreedor(parametrocontaDataAccess.getCuentaContableAcreedor(connexion,parametroconta));
		CuentaContableLogic cuentacontableacreedorLogic= new CuentaContableLogic(connexion);
		cuentacontableacreedorLogic.deepLoad(parametroconta.getCuentaContableAcreedor(),isDeep,deepLoadType,clases);
				
		parametroconta.setCuentaContableIngreso1(parametrocontaDataAccess.getCuentaContableIngreso1(connexion,parametroconta));
		CuentaContableLogic cuentacontableingreso1Logic= new CuentaContableLogic(connexion);
		cuentacontableingreso1Logic.deepLoad(parametroconta.getCuentaContableIngreso1(),isDeep,deepLoadType,clases);
				
		parametroconta.setCuentaContableIngreso2(parametrocontaDataAccess.getCuentaContableIngreso2(connexion,parametroconta));
		CuentaContableLogic cuentacontableingreso2Logic= new CuentaContableLogic(connexion);
		cuentacontableingreso2Logic.deepLoad(parametroconta.getCuentaContableIngreso2(),isDeep,deepLoadType,clases);
				
		parametroconta.setCuentaContableIngreso3(parametrocontaDataAccess.getCuentaContableIngreso3(connexion,parametroconta));
		CuentaContableLogic cuentacontableingreso3Logic= new CuentaContableLogic(connexion);
		cuentacontableingreso3Logic.deepLoad(parametroconta.getCuentaContableIngreso3(),isDeep,deepLoadType,clases);
				
		parametroconta.setCuentaContableEgreso1(parametrocontaDataAccess.getCuentaContableEgreso1(connexion,parametroconta));
		CuentaContableLogic cuentacontableegreso1Logic= new CuentaContableLogic(connexion);
		cuentacontableegreso1Logic.deepLoad(parametroconta.getCuentaContableEgreso1(),isDeep,deepLoadType,clases);
				
		parametroconta.setCuentaContableEgreso2(parametrocontaDataAccess.getCuentaContableEgreso2(connexion,parametroconta));
		CuentaContableLogic cuentacontableegreso2Logic= new CuentaContableLogic(connexion);
		cuentacontableegreso2Logic.deepLoad(parametroconta.getCuentaContableEgreso2(),isDeep,deepLoadType,clases);
				
		parametroconta.setCuentaContableEgreso3(parametrocontaDataAccess.getCuentaContableEgreso3(connexion,parametroconta));
		CuentaContableLogic cuentacontableegreso3Logic= new CuentaContableLogic(connexion);
		cuentacontableegreso3Logic.deepLoad(parametroconta.getCuentaContableEgreso3(),isDeep,deepLoadType,clases);
				

		parametroconta.setParametroContaDetalles(parametrocontaDataAccess.getParametroContaDetalles(connexion,parametroconta));

		for(ParametroContaDetalle parametrocontadetalle:parametroconta.getParametroContaDetalles()) {
			ParametroContaDetalleLogic parametrocontadetalleLogic= new ParametroContaDetalleLogic(connexion);
			parametrocontadetalleLogic.deepLoad(parametrocontadetalle,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametroconta.setEmpresa(parametrocontaDataAccess.getEmpresa(connexion,parametroconta));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametroconta.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				parametroconta.setMoneda(parametrocontaDataAccess.getMoneda(connexion,parametroconta));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(parametroconta.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				parametroconta.setMonedaExtranjera(parametrocontaDataAccess.getMonedaExtranjera(connexion,parametroconta));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(parametroconta.getMonedaExtranjera(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableActivo(parametrocontaDataAccess.getCuentaContableActivo(connexion,parametroconta));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametroconta.getCuentaContableActivo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContablePasivo(parametrocontaDataAccess.getCuentaContablePasivo(connexion,parametroconta));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametroconta.getCuentaContablePasivo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContablePatrimonio(parametrocontaDataAccess.getCuentaContablePatrimonio(connexion,parametroconta));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametroconta.getCuentaContablePatrimonio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableIngreso(parametrocontaDataAccess.getCuentaContableIngreso(connexion,parametroconta));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametroconta.getCuentaContableIngreso(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableEgreso(parametrocontaDataAccess.getCuentaContableEgreso(connexion,parametroconta));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametroconta.getCuentaContableEgreso(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableResumen(parametrocontaDataAccess.getCuentaContableResumen(connexion,parametroconta));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametroconta.getCuentaContableResumen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableDeudor(parametrocontaDataAccess.getCuentaContableDeudor(connexion,parametroconta));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametroconta.getCuentaContableDeudor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableAcreedor(parametrocontaDataAccess.getCuentaContableAcreedor(connexion,parametroconta));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametroconta.getCuentaContableAcreedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableIngreso1(parametrocontaDataAccess.getCuentaContableIngreso1(connexion,parametroconta));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametroconta.getCuentaContableIngreso1(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableIngreso2(parametrocontaDataAccess.getCuentaContableIngreso2(connexion,parametroconta));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametroconta.getCuentaContableIngreso2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableIngreso3(parametrocontaDataAccess.getCuentaContableIngreso3(connexion,parametroconta));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametroconta.getCuentaContableIngreso3(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableEgreso1(parametrocontaDataAccess.getCuentaContableEgreso1(connexion,parametroconta));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametroconta.getCuentaContableEgreso1(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableEgreso2(parametrocontaDataAccess.getCuentaContableEgreso2(connexion,parametroconta));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametroconta.getCuentaContableEgreso2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				parametroconta.setCuentaContableEgreso3(parametrocontaDataAccess.getCuentaContableEgreso3(connexion,parametroconta));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(parametroconta.getCuentaContableEgreso3(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ParametroContaDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				parametroconta.setParametroContaDetalles(parametrocontaDataAccess.getParametroContaDetalles(connexion,parametroconta));

				for(ParametroContaDetalle parametrocontadetalle:parametroconta.getParametroContaDetalles()) {
					ParametroContaDetalleLogic parametrocontadetalleLogic= new ParametroContaDetalleLogic(connexion);
					parametrocontadetalleLogic.deepLoad(parametrocontadetalle,isDeep,deepLoadType,clases);
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
			parametroconta.setEmpresa(parametrocontaDataAccess.getEmpresa(connexion,parametroconta));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametroconta.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setMoneda(parametrocontaDataAccess.getMoneda(connexion,parametroconta));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(parametroconta.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setMonedaExtranjera(parametrocontaDataAccess.getMonedaExtranjera(connexion,parametroconta));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(parametroconta.getMonedaExtranjera(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableActivo(parametrocontaDataAccess.getCuentaContableActivo(connexion,parametroconta));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametroconta.getCuentaContableActivo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContablePasivo(parametrocontaDataAccess.getCuentaContablePasivo(connexion,parametroconta));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametroconta.getCuentaContablePasivo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContablePatrimonio(parametrocontaDataAccess.getCuentaContablePatrimonio(connexion,parametroconta));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametroconta.getCuentaContablePatrimonio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableIngreso(parametrocontaDataAccess.getCuentaContableIngreso(connexion,parametroconta));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametroconta.getCuentaContableIngreso(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableEgreso(parametrocontaDataAccess.getCuentaContableEgreso(connexion,parametroconta));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametroconta.getCuentaContableEgreso(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableResumen(parametrocontaDataAccess.getCuentaContableResumen(connexion,parametroconta));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametroconta.getCuentaContableResumen(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableDeudor(parametrocontaDataAccess.getCuentaContableDeudor(connexion,parametroconta));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametroconta.getCuentaContableDeudor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableAcreedor(parametrocontaDataAccess.getCuentaContableAcreedor(connexion,parametroconta));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametroconta.getCuentaContableAcreedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableIngreso1(parametrocontaDataAccess.getCuentaContableIngreso1(connexion,parametroconta));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametroconta.getCuentaContableIngreso1(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableIngreso2(parametrocontaDataAccess.getCuentaContableIngreso2(connexion,parametroconta));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametroconta.getCuentaContableIngreso2(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableIngreso3(parametrocontaDataAccess.getCuentaContableIngreso3(connexion,parametroconta));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametroconta.getCuentaContableIngreso3(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableEgreso1(parametrocontaDataAccess.getCuentaContableEgreso1(connexion,parametroconta));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametroconta.getCuentaContableEgreso1(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableEgreso2(parametrocontaDataAccess.getCuentaContableEgreso2(connexion,parametroconta));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametroconta.getCuentaContableEgreso2(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroconta.setCuentaContableEgreso3(parametrocontaDataAccess.getCuentaContableEgreso3(connexion,parametroconta));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(parametroconta.getCuentaContableEgreso3(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroContaDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroContaDetalle.class));
			parametroconta.setParametroContaDetalles(parametrocontaDataAccess.getParametroContaDetalles(connexion,parametroconta));

			for(ParametroContaDetalle parametrocontadetalle:parametroconta.getParametroContaDetalles()) {
				ParametroContaDetalleLogic parametrocontadetalleLogic= new ParametroContaDetalleLogic(connexion);
				parametrocontadetalleLogic.deepLoad(parametrocontadetalle,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroConta parametroconta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroContaLogicAdditional.updateParametroContaToSave(parametroconta,this.arrDatoGeneral);
			
ParametroContaDataAccess.save(parametroconta, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametroconta.getEmpresa(),connexion);

		MonedaDataAccess.save(parametroconta.getMoneda(),connexion);

		MonedaDataAccess.save(parametroconta.getMonedaExtranjera(),connexion);

		CuentaContableDataAccess.save(parametroconta.getCuentaContableActivo(),connexion);

		CuentaContableDataAccess.save(parametroconta.getCuentaContablePasivo(),connexion);

		CuentaContableDataAccess.save(parametroconta.getCuentaContablePatrimonio(),connexion);

		CuentaContableDataAccess.save(parametroconta.getCuentaContableIngreso(),connexion);

		CuentaContableDataAccess.save(parametroconta.getCuentaContableEgreso(),connexion);

		CuentaContableDataAccess.save(parametroconta.getCuentaContableResumen(),connexion);

		CuentaContableDataAccess.save(parametroconta.getCuentaContableDeudor(),connexion);

		CuentaContableDataAccess.save(parametroconta.getCuentaContableAcreedor(),connexion);

		CuentaContableDataAccess.save(parametroconta.getCuentaContableIngreso1(),connexion);

		CuentaContableDataAccess.save(parametroconta.getCuentaContableIngreso2(),connexion);

		CuentaContableDataAccess.save(parametroconta.getCuentaContableIngreso3(),connexion);

		CuentaContableDataAccess.save(parametroconta.getCuentaContableEgreso1(),connexion);

		CuentaContableDataAccess.save(parametroconta.getCuentaContableEgreso2(),connexion);

		CuentaContableDataAccess.save(parametroconta.getCuentaContableEgreso3(),connexion);

		for(ParametroContaDetalle parametrocontadetalle:parametroconta.getParametroContaDetalles()) {
			parametrocontadetalle.setid_parametro_conta(parametroconta.getId());
			ParametroContaDetalleDataAccess.save(parametrocontadetalle,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametroconta.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(parametroconta.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(parametroconta.getMonedaExtranjera(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableActivo(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContablePasivo(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContablePatrimonio(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableIngreso(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableEgreso(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableResumen(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableDeudor(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableAcreedor(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableIngreso1(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableIngreso2(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableIngreso3(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableEgreso1(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableEgreso2(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableEgreso3(),connexion);
				continue;
			}


			if(clas.clas.equals(ParametroContaDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroContaDetalle parametrocontadetalle:parametroconta.getParametroContaDetalles()) {
					parametrocontadetalle.setid_parametro_conta(parametroconta.getId());
					ParametroContaDetalleDataAccess.save(parametrocontadetalle,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametroconta.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametroconta.getEmpresa(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(parametroconta.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(parametroconta.getMoneda(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(parametroconta.getMonedaExtranjera(),connexion);
		MonedaLogic monedaextranjeraLogic= new MonedaLogic(connexion);
		monedaextranjeraLogic.deepLoad(parametroconta.getMonedaExtranjera(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametroconta.getCuentaContableActivo(),connexion);
		CuentaContableLogic cuentacontableactivoLogic= new CuentaContableLogic(connexion);
		cuentacontableactivoLogic.deepLoad(parametroconta.getCuentaContableActivo(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametroconta.getCuentaContablePasivo(),connexion);
		CuentaContableLogic cuentacontablepasivoLogic= new CuentaContableLogic(connexion);
		cuentacontablepasivoLogic.deepLoad(parametroconta.getCuentaContablePasivo(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametroconta.getCuentaContablePatrimonio(),connexion);
		CuentaContableLogic cuentacontablepatrimonioLogic= new CuentaContableLogic(connexion);
		cuentacontablepatrimonioLogic.deepLoad(parametroconta.getCuentaContablePatrimonio(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametroconta.getCuentaContableIngreso(),connexion);
		CuentaContableLogic cuentacontableingresoLogic= new CuentaContableLogic(connexion);
		cuentacontableingresoLogic.deepLoad(parametroconta.getCuentaContableIngreso(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametroconta.getCuentaContableEgreso(),connexion);
		CuentaContableLogic cuentacontableegresoLogic= new CuentaContableLogic(connexion);
		cuentacontableegresoLogic.deepLoad(parametroconta.getCuentaContableEgreso(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametroconta.getCuentaContableResumen(),connexion);
		CuentaContableLogic cuentacontableresumenLogic= new CuentaContableLogic(connexion);
		cuentacontableresumenLogic.deepLoad(parametroconta.getCuentaContableResumen(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametroconta.getCuentaContableDeudor(),connexion);
		CuentaContableLogic cuentacontabledeudorLogic= new CuentaContableLogic(connexion);
		cuentacontabledeudorLogic.deepLoad(parametroconta.getCuentaContableDeudor(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametroconta.getCuentaContableAcreedor(),connexion);
		CuentaContableLogic cuentacontableacreedorLogic= new CuentaContableLogic(connexion);
		cuentacontableacreedorLogic.deepLoad(parametroconta.getCuentaContableAcreedor(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametroconta.getCuentaContableIngreso1(),connexion);
		CuentaContableLogic cuentacontableingreso1Logic= new CuentaContableLogic(connexion);
		cuentacontableingreso1Logic.deepLoad(parametroconta.getCuentaContableIngreso1(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametroconta.getCuentaContableIngreso2(),connexion);
		CuentaContableLogic cuentacontableingreso2Logic= new CuentaContableLogic(connexion);
		cuentacontableingreso2Logic.deepLoad(parametroconta.getCuentaContableIngreso2(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametroconta.getCuentaContableIngreso3(),connexion);
		CuentaContableLogic cuentacontableingreso3Logic= new CuentaContableLogic(connexion);
		cuentacontableingreso3Logic.deepLoad(parametroconta.getCuentaContableIngreso3(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametroconta.getCuentaContableEgreso1(),connexion);
		CuentaContableLogic cuentacontableegreso1Logic= new CuentaContableLogic(connexion);
		cuentacontableegreso1Logic.deepLoad(parametroconta.getCuentaContableEgreso1(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametroconta.getCuentaContableEgreso2(),connexion);
		CuentaContableLogic cuentacontableegreso2Logic= new CuentaContableLogic(connexion);
		cuentacontableegreso2Logic.deepLoad(parametroconta.getCuentaContableEgreso2(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(parametroconta.getCuentaContableEgreso3(),connexion);
		CuentaContableLogic cuentacontableegreso3Logic= new CuentaContableLogic(connexion);
		cuentacontableegreso3Logic.deepLoad(parametroconta.getCuentaContableEgreso3(),isDeep,deepLoadType,clases);
				

		for(ParametroContaDetalle parametrocontadetalle:parametroconta.getParametroContaDetalles()) {
			ParametroContaDetalleLogic parametrocontadetalleLogic= new ParametroContaDetalleLogic(connexion);
			parametrocontadetalle.setid_parametro_conta(parametroconta.getId());
			ParametroContaDetalleDataAccess.save(parametrocontadetalle,connexion);
			parametrocontadetalleLogic.deepSave(parametrocontadetalle,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametroconta.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametroconta.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(parametroconta.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(parametroconta.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(parametroconta.getMonedaExtranjera(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(parametroconta.getMonedaExtranjera(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableActivo(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametroconta.getCuentaContableActivo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContablePasivo(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametroconta.getCuentaContablePasivo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContablePatrimonio(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametroconta.getCuentaContablePatrimonio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableIngreso(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametroconta.getCuentaContableIngreso(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableEgreso(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametroconta.getCuentaContableEgreso(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableResumen(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametroconta.getCuentaContableResumen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableDeudor(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametroconta.getCuentaContableDeudor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableAcreedor(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametroconta.getCuentaContableAcreedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableIngreso1(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametroconta.getCuentaContableIngreso1(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableIngreso2(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametroconta.getCuentaContableIngreso2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableIngreso3(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametroconta.getCuentaContableIngreso3(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableEgreso1(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametroconta.getCuentaContableEgreso1(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableEgreso2(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametroconta.getCuentaContableEgreso2(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(parametroconta.getCuentaContableEgreso3(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(parametroconta.getCuentaContableEgreso3(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(ParametroContaDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroContaDetalle parametrocontadetalle:parametroconta.getParametroContaDetalles()) {
					ParametroContaDetalleLogic parametrocontadetalleLogic= new ParametroContaDetalleLogic(connexion);
					parametrocontadetalle.setid_parametro_conta(parametroconta.getId());
					ParametroContaDetalleDataAccess.save(parametrocontadetalle,connexion);
					parametrocontadetalleLogic.deepSave(parametrocontadetalle,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(ParametroConta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametroconta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(parametroconta);
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
			this.deepLoad(this.parametroconta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametroconta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroConta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametrocontas!=null) {
				for(ParametroConta parametroconta:parametrocontas) {
					this.deepLoad(parametroconta,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(parametrocontas);
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
			if(parametrocontas!=null) {
				for(ParametroConta parametroconta:parametrocontas) {
					this.deepLoad(parametroconta,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(parametrocontas);
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
			this.getNewConnexionToDeep(ParametroConta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametroconta,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroConta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametrocontas!=null) {
				for(ParametroConta parametroconta:parametrocontas) {
					this.deepSave(parametroconta,isDeep,deepLoadType,clases);
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
			if(parametrocontas!=null) {
				for(ParametroConta parametroconta:parametrocontas) {
					this.deepSave(parametroconta,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroContasFK_IdCuentaContableAcreedorWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_acreedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableAcreedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableAcreedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_acreedor,ParametroContaConstantesFunciones.IDCUENTACONTABLEACREEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableAcreedor);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableAcreedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContasFK_IdCuentaContableAcreedor(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_acreedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableAcreedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableAcreedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_acreedor,ParametroContaConstantesFunciones.IDCUENTACONTABLEACREEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableAcreedor);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableAcreedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContasFK_IdCuentaContableActivoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_activo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableActivo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableActivo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_activo,ParametroContaConstantesFunciones.IDCUENTACONTABLEACTIVO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableActivo);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableActivo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContasFK_IdCuentaContableActivo(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_activo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableActivo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableActivo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_activo,ParametroContaConstantesFunciones.IDCUENTACONTABLEACTIVO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableActivo);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableActivo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContasFK_IdCuentaContableDeudorWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_deudor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDeudor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDeudor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_deudor,ParametroContaConstantesFunciones.IDCUENTACONTABLEDEUDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDeudor);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDeudor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContasFK_IdCuentaContableDeudor(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_deudor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDeudor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDeudor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_deudor,ParametroContaConstantesFunciones.IDCUENTACONTABLEDEUDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDeudor);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDeudor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContasFK_IdCuentaContableEgresoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_egreso)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableEgreso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableEgreso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_egreso,ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableEgreso);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableEgreso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContasFK_IdCuentaContableEgreso(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_egreso)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableEgreso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableEgreso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_egreso,ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableEgreso);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableEgreso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContasFK_IdCuentaContableEgreso1WithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_egreso1)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableEgreso1= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableEgreso1.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_egreso1,ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO1,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableEgreso1);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableEgreso1","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContasFK_IdCuentaContableEgreso1(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_egreso1)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableEgreso1= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableEgreso1.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_egreso1,ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO1,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableEgreso1);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableEgreso1","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContasFK_IdCuentaContableEgreso2WithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_egreso2)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableEgreso2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableEgreso2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_egreso2,ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableEgreso2);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableEgreso2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContasFK_IdCuentaContableEgreso2(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_egreso2)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableEgreso2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableEgreso2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_egreso2,ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableEgreso2);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableEgreso2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContasFK_IdCuentaContableEgreso3WithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_egreso3)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableEgreso3= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableEgreso3.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_egreso3,ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO3,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableEgreso3);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableEgreso3","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContasFK_IdCuentaContableEgreso3(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_egreso3)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableEgreso3= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableEgreso3.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_egreso3,ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO3,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableEgreso3);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableEgreso3","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContasFK_IdCuentaContableIngresoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_ingreso)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIngreso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIngreso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_ingreso,ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIngreso);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIngreso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContasFK_IdCuentaContableIngreso(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_ingreso)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIngreso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIngreso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_ingreso,ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIngreso);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIngreso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContasFK_IdCuentaContableIngreso1WithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_ingreso1)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIngreso1= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIngreso1.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_ingreso1,ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO1,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIngreso1);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIngreso1","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContasFK_IdCuentaContableIngreso1(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_ingreso1)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIngreso1= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIngreso1.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_ingreso1,ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO1,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIngreso1);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIngreso1","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContasFK_IdCuentaContableIngreso2WithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_ingreso2)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIngreso2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIngreso2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_ingreso2,ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIngreso2);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIngreso2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContasFK_IdCuentaContableIngreso2(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_ingreso2)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIngreso2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIngreso2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_ingreso2,ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIngreso2);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIngreso2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContasFK_IdCuentaContableIngreso3WithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_ingreso3)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIngreso3= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIngreso3.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_ingreso3,ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO3,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIngreso3);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIngreso3","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContasFK_IdCuentaContableIngreso3(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_ingreso3)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableIngreso3= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableIngreso3.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_ingreso3,ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO3,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableIngreso3);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableIngreso3","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContasFK_IdCuentaContablePasivoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_pasivo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContablePasivo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContablePasivo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_pasivo,ParametroContaConstantesFunciones.IDCUENTACONTABLEPASIVO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContablePasivo);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContablePasivo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContasFK_IdCuentaContablePasivo(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_pasivo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContablePasivo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContablePasivo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_pasivo,ParametroContaConstantesFunciones.IDCUENTACONTABLEPASIVO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContablePasivo);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContablePasivo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContasFK_IdCuentaContablePatrimonioWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_patrimonio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContablePatrimonio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContablePatrimonio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_patrimonio,ParametroContaConstantesFunciones.IDCUENTACONTABLEPATRIMONIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContablePatrimonio);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContablePatrimonio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContasFK_IdCuentaContablePatrimonio(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_patrimonio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContablePatrimonio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContablePatrimonio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_patrimonio,ParametroContaConstantesFunciones.IDCUENTACONTABLEPATRIMONIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContablePatrimonio);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContablePatrimonio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContasFK_IdCuentaContableResumenWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_resumen)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableResumen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableResumen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_resumen,ParametroContaConstantesFunciones.IDCUENTACONTABLERESUMEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableResumen);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableResumen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContasFK_IdCuentaContableResumen(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_resumen)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableResumen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableResumen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_resumen,ParametroContaConstantesFunciones.IDCUENTACONTABLERESUMEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableResumen);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableResumen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroContaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroContaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContasFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,ParametroContaConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContasFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,ParametroContaConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroContasFK_IdMonedaExtranjeraWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda_extranjera)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroConta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMonedaExtranjera= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMonedaExtranjera.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda_extranjera,ParametroContaConstantesFunciones.IDMONEDAEXTRANJERA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMonedaExtranjera);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMonedaExtranjera","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroContasFK_IdMonedaExtranjera(String sFinalQuery,Pagination pagination,Long id_moneda_extranjera)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMonedaExtranjera= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMonedaExtranjera.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda_extranjera,ParametroContaConstantesFunciones.IDMONEDAEXTRANJERA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMonedaExtranjera);

			ParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMonedaExtranjera","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrocontas=parametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesParametroConta(this.parametrocontas);
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
			if(ParametroContaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroContaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroConta parametroconta,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroContaConstantesFunciones.ISCONAUDITORIA) {
				if(parametroconta.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroContaDataAccess.TABLENAME, parametroconta.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroContaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroContaLogic.registrarAuditoriaDetallesParametroConta(connexion,parametroconta,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametroconta.getIsDeleted()) {
					/*if(!parametroconta.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroContaDataAccess.TABLENAME, parametroconta.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroContaLogic.registrarAuditoriaDetallesParametroConta(connexion,parametroconta,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroContaDataAccess.TABLENAME, parametroconta.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametroconta.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroContaDataAccess.TABLENAME, parametroconta.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroContaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroContaLogic.registrarAuditoriaDetallesParametroConta(connexion,parametroconta,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroConta(Connexion connexion,ParametroConta parametroconta)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametroconta.getIsNew()||!parametroconta.getid_empresa().equals(parametroconta.getParametroContaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getid_empresa()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getid_empresa().toString();
				}
				if(parametroconta.getid_empresa()!=null)
				{
					strValorNuevo=parametroconta.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getid_moneda().equals(parametroconta.getParametroContaOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getid_moneda()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getid_moneda().toString();
				}
				if(parametroconta.getid_moneda()!=null)
				{
					strValorNuevo=parametroconta.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getid_moneda_extranjera().equals(parametroconta.getParametroContaOriginal().getid_moneda_extranjera()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getid_moneda_extranjera()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getid_moneda_extranjera().toString();
				}
				if(parametroconta.getid_moneda_extranjera()!=null)
				{
					strValorNuevo=parametroconta.getid_moneda_extranjera().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.IDMONEDAEXTRANJERA,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getcon_mascara().equals(parametroconta.getParametroContaOriginal().getcon_mascara()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getcon_mascara()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getcon_mascara().toString();
				}
				if(parametroconta.getcon_mascara()!=null)
				{
					strValorNuevo=parametroconta.getcon_mascara().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.CONMASCARA,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getnumero_nivel().equals(parametroconta.getParametroContaOriginal().getnumero_nivel()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getnumero_nivel()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getnumero_nivel().toString();
				}
				if(parametroconta.getnumero_nivel()!=null)
				{
					strValorNuevo=parametroconta.getnumero_nivel().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.NUMERONIVEL,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getes_presupuesto().equals(parametroconta.getParametroContaOriginal().getes_presupuesto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getes_presupuesto()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getes_presupuesto().toString();
				}
				if(parametroconta.getes_presupuesto()!=null)
				{
					strValorNuevo=parametroconta.getes_presupuesto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.ESPRESUPUESTO,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getes_lote().equals(parametroconta.getParametroContaOriginal().getes_lote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getes_lote()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getes_lote().toString();
				}
				if(parametroconta.getes_lote()!=null)
				{
					strValorNuevo=parametroconta.getes_lote().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.ESLOTE,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getcon_secuencial_automatico().equals(parametroconta.getParametroContaOriginal().getcon_secuencial_automatico()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getcon_secuencial_automatico()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getcon_secuencial_automatico().toString();
				}
				if(parametroconta.getcon_secuencial_automatico()!=null)
				{
					strValorNuevo=parametroconta.getcon_secuencial_automatico().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.CONSECUENCIALAUTOMATICO,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getcon_cuentas_niff().equals(parametroconta.getParametroContaOriginal().getcon_cuentas_niff()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getcon_cuentas_niff()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getcon_cuentas_niff().toString();
				}
				if(parametroconta.getcon_cuentas_niff()!=null)
				{
					strValorNuevo=parametroconta.getcon_cuentas_niff().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.CONCUENTASNIFF,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getcon_centro_costo_mascara().equals(parametroconta.getParametroContaOriginal().getcon_centro_costo_mascara()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getcon_centro_costo_mascara()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getcon_centro_costo_mascara().toString();
				}
				if(parametroconta.getcon_centro_costo_mascara()!=null)
				{
					strValorNuevo=parametroconta.getcon_centro_costo_mascara().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.CONCENTROCOSTOMASCARA,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getcon_centro_costo_nueva_estructura().equals(parametroconta.getParametroContaOriginal().getcon_centro_costo_nueva_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getcon_centro_costo_nueva_estructura()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getcon_centro_costo_nueva_estructura().toString();
				}
				if(parametroconta.getcon_centro_costo_nueva_estructura()!=null)
				{
					strValorNuevo=parametroconta.getcon_centro_costo_nueva_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.CONCENTROCOSTONUEVAESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getcentro_costo_numero_nivel().equals(parametroconta.getParametroContaOriginal().getcentro_costo_numero_nivel()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getcentro_costo_numero_nivel()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getcentro_costo_numero_nivel().toString();
				}
				if(parametroconta.getcentro_costo_numero_nivel()!=null)
				{
					strValorNuevo=parametroconta.getcentro_costo_numero_nivel().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.CENTROCOSTONUMERONIVEL,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getid_cuenta_contable_activo().equals(parametroconta.getParametroContaOriginal().getid_cuenta_contable_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getid_cuenta_contable_activo()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getid_cuenta_contable_activo().toString();
				}
				if(parametroconta.getid_cuenta_contable_activo()!=null)
				{
					strValorNuevo=parametroconta.getid_cuenta_contable_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.IDCUENTACONTABLEACTIVO,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getid_cuenta_contable_pasivo().equals(parametroconta.getParametroContaOriginal().getid_cuenta_contable_pasivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getid_cuenta_contable_pasivo()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getid_cuenta_contable_pasivo().toString();
				}
				if(parametroconta.getid_cuenta_contable_pasivo()!=null)
				{
					strValorNuevo=parametroconta.getid_cuenta_contable_pasivo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.IDCUENTACONTABLEPASIVO,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getid_cuenta_contable_patrimonio().equals(parametroconta.getParametroContaOriginal().getid_cuenta_contable_patrimonio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getid_cuenta_contable_patrimonio()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getid_cuenta_contable_patrimonio().toString();
				}
				if(parametroconta.getid_cuenta_contable_patrimonio()!=null)
				{
					strValorNuevo=parametroconta.getid_cuenta_contable_patrimonio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.IDCUENTACONTABLEPATRIMONIO,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getid_cuenta_contable_ingreso().equals(parametroconta.getParametroContaOriginal().getid_cuenta_contable_ingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getid_cuenta_contable_ingreso()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getid_cuenta_contable_ingreso().toString();
				}
				if(parametroconta.getid_cuenta_contable_ingreso()!=null)
				{
					strValorNuevo=parametroconta.getid_cuenta_contable_ingreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getid_cuenta_contable_egreso().equals(parametroconta.getParametroContaOriginal().getid_cuenta_contable_egreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getid_cuenta_contable_egreso()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getid_cuenta_contable_egreso().toString();
				}
				if(parametroconta.getid_cuenta_contable_egreso()!=null)
				{
					strValorNuevo=parametroconta.getid_cuenta_contable_egreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getid_cuenta_contable_resumen().equals(parametroconta.getParametroContaOriginal().getid_cuenta_contable_resumen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getid_cuenta_contable_resumen()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getid_cuenta_contable_resumen().toString();
				}
				if(parametroconta.getid_cuenta_contable_resumen()!=null)
				{
					strValorNuevo=parametroconta.getid_cuenta_contable_resumen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.IDCUENTACONTABLERESUMEN,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getid_cuenta_contable_deudor().equals(parametroconta.getParametroContaOriginal().getid_cuenta_contable_deudor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getid_cuenta_contable_deudor()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getid_cuenta_contable_deudor().toString();
				}
				if(parametroconta.getid_cuenta_contable_deudor()!=null)
				{
					strValorNuevo=parametroconta.getid_cuenta_contable_deudor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.IDCUENTACONTABLEDEUDOR,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getid_cuenta_contable_acreedor().equals(parametroconta.getParametroContaOriginal().getid_cuenta_contable_acreedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getid_cuenta_contable_acreedor()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getid_cuenta_contable_acreedor().toString();
				}
				if(parametroconta.getid_cuenta_contable_acreedor()!=null)
				{
					strValorNuevo=parametroconta.getid_cuenta_contable_acreedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.IDCUENTACONTABLEACREEDOR,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getid_cuenta_contable_ingreso1().equals(parametroconta.getParametroContaOriginal().getid_cuenta_contable_ingreso1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getid_cuenta_contable_ingreso1()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getid_cuenta_contable_ingreso1().toString();
				}
				if(parametroconta.getid_cuenta_contable_ingreso1()!=null)
				{
					strValorNuevo=parametroconta.getid_cuenta_contable_ingreso1().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO1,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getid_cuenta_contable_ingreso2().equals(parametroconta.getParametroContaOriginal().getid_cuenta_contable_ingreso2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getid_cuenta_contable_ingreso2()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getid_cuenta_contable_ingreso2().toString();
				}
				if(parametroconta.getid_cuenta_contable_ingreso2()!=null)
				{
					strValorNuevo=parametroconta.getid_cuenta_contable_ingreso2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO2,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getid_cuenta_contable_ingreso3().equals(parametroconta.getParametroContaOriginal().getid_cuenta_contable_ingreso3()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getid_cuenta_contable_ingreso3()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getid_cuenta_contable_ingreso3().toString();
				}
				if(parametroconta.getid_cuenta_contable_ingreso3()!=null)
				{
					strValorNuevo=parametroconta.getid_cuenta_contable_ingreso3().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.IDCUENTACONTABLEINGRESO3,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getid_cuenta_contable_egreso1().equals(parametroconta.getParametroContaOriginal().getid_cuenta_contable_egreso1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getid_cuenta_contable_egreso1()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getid_cuenta_contable_egreso1().toString();
				}
				if(parametroconta.getid_cuenta_contable_egreso1()!=null)
				{
					strValorNuevo=parametroconta.getid_cuenta_contable_egreso1().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO1,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getid_cuenta_contable_egreso2().equals(parametroconta.getParametroContaOriginal().getid_cuenta_contable_egreso2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getid_cuenta_contable_egreso2()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getid_cuenta_contable_egreso2().toString();
				}
				if(parametroconta.getid_cuenta_contable_egreso2()!=null)
				{
					strValorNuevo=parametroconta.getid_cuenta_contable_egreso2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO2,strValorActual,strValorNuevo);
			}	
			
			if(parametroconta.getIsNew()||!parametroconta.getid_cuenta_contable_egreso3().equals(parametroconta.getParametroContaOriginal().getid_cuenta_contable_egreso3()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroconta.getParametroContaOriginal().getid_cuenta_contable_egreso3()!=null)
				{
					strValorActual=parametroconta.getParametroContaOriginal().getid_cuenta_contable_egreso3().toString();
				}
				if(parametroconta.getid_cuenta_contable_egreso3()!=null)
				{
					strValorNuevo=parametroconta.getid_cuenta_contable_egreso3().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroContaConstantesFunciones.IDCUENTACONTABLEEGRESO3,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroContaRelacionesWithConnection(ParametroConta parametroconta,List<ParametroContaDetalle> parametrocontadetalles) throws Exception {

		if(!parametroconta.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroContaRelacionesBase(parametroconta,parametrocontadetalles,true);
		}
	}

	public void saveParametroContaRelaciones(ParametroConta parametroconta,List<ParametroContaDetalle> parametrocontadetalles)throws Exception {

		if(!parametroconta.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroContaRelacionesBase(parametroconta,parametrocontadetalles,false);
		}
	}

	public void saveParametroContaRelacionesBase(ParametroConta parametroconta,List<ParametroContaDetalle> parametrocontadetalles,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroConta-saveRelacionesWithConnection");}
	
			parametroconta.setParametroContaDetalles(parametrocontadetalles);

			this.setParametroConta(parametroconta);

			if(ParametroContaLogicAdditional.validarSaveRelaciones(parametroconta,this)) {

				ParametroContaLogicAdditional.updateRelacionesToSave(parametroconta,this);

				if((parametroconta.getIsNew()||parametroconta.getIsChanged())&&!parametroconta.getIsDeleted()) {
					this.saveParametroConta();
					this.saveParametroContaRelacionesDetalles(parametrocontadetalles);

				} else if(parametroconta.getIsDeleted()) {
					this.saveParametroContaRelacionesDetalles(parametrocontadetalles);
					this.saveParametroConta();
				}

				ParametroContaLogicAdditional.updateRelacionesToSaveAfter(parametroconta,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ParametroContaDetalleConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroContaDetalles(parametrocontadetalles,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveParametroContaRelacionesDetalles(List<ParametroContaDetalle> parametrocontadetalles)throws Exception {
		try {
	

			Long idParametroContaActual=this.getParametroConta().getId();

			ParametroContaDetalleLogic parametrocontadetalleLogic_Desde_ParametroConta=new ParametroContaDetalleLogic();
			parametrocontadetalleLogic_Desde_ParametroConta.setParametroContaDetalles(parametrocontadetalles);

			parametrocontadetalleLogic_Desde_ParametroConta.setConnexion(this.getConnexion());
			parametrocontadetalleLogic_Desde_ParametroConta.setDatosCliente(this.datosCliente);

			for(ParametroContaDetalle parametrocontadetalle_Desde_ParametroConta:parametrocontadetalleLogic_Desde_ParametroConta.getParametroContaDetalles()) {
				parametrocontadetalle_Desde_ParametroConta.setid_parametro_conta(idParametroContaActual);
			}

			parametrocontadetalleLogic_Desde_ParametroConta.saveParametroContaDetalles();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroConta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroContaConstantesFunciones.getClassesForeignKeysOfParametroConta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroConta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroContaConstantesFunciones.getClassesRelationshipsOfParametroConta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

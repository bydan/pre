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
package com.bydan.erp.facturacion.business.logic;

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
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.facturacion.util.ParametroGeneralConstantesFunciones;
import com.bydan.erp.facturacion.util.ParametroGeneralParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.ParametroGeneralParameterGeneral;
import com.bydan.erp.facturacion.business.entity.ParametroGeneral;
import com.bydan.erp.facturacion.business.logic.ParametroGeneralLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroGeneralLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroGeneralLogic.class);
	
	protected ParametroGeneralDataAccess parametrogeneralDataAccess; 	
	protected ParametroGeneral parametrogeneral;
	protected List<ParametroGeneral> parametrogenerals;
	protected Object parametrogeneralObject;	
	protected List<Object> parametrogeneralsObject;
	
	public static ClassValidator<ParametroGeneral> parametrogeneralValidator = new ClassValidator<ParametroGeneral>(ParametroGeneral.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroGeneralLogicAdditional parametrogeneralLogicAdditional=null;
	
	public ParametroGeneralLogicAdditional getParametroGeneralLogicAdditional() {
		return this.parametrogeneralLogicAdditional;
	}
	
	public void setParametroGeneralLogicAdditional(ParametroGeneralLogicAdditional parametrogeneralLogicAdditional) {
		try {
			this.parametrogeneralLogicAdditional=parametrogeneralLogicAdditional;
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
	
	
	
	
	public  ParametroGeneralLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametrogeneralDataAccess = new ParametroGeneralDataAccess();
			
			this.parametrogenerals= new ArrayList<ParametroGeneral>();
			this.parametrogeneral= new ParametroGeneral();
			
			this.parametrogeneralObject=new Object();
			this.parametrogeneralsObject=new ArrayList<Object>();
				
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
			
			this.parametrogeneralDataAccess.setConnexionType(this.connexionType);
			this.parametrogeneralDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroGeneralLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametrogeneralDataAccess = new ParametroGeneralDataAccess();
			this.parametrogenerals= new ArrayList<ParametroGeneral>();
			this.parametrogeneral= new ParametroGeneral();
			this.parametrogeneralObject=new Object();
			this.parametrogeneralsObject=new ArrayList<Object>();
			
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
			
			this.parametrogeneralDataAccess.setConnexionType(this.connexionType);
			this.parametrogeneralDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroGeneral getParametroGeneral() throws Exception {	
		ParametroGeneralLogicAdditional.checkParametroGeneralToGet(parametrogeneral,this.datosCliente,this.arrDatoGeneral);
		ParametroGeneralLogicAdditional.updateParametroGeneralToGet(parametrogeneral,this.arrDatoGeneral);
		
		return parametrogeneral;
	}
		
	public void setParametroGeneral(ParametroGeneral newParametroGeneral) {
		this.parametrogeneral = newParametroGeneral;
	}
	
	public ParametroGeneralDataAccess getParametroGeneralDataAccess() {
		return parametrogeneralDataAccess;
	}
	
	public void setParametroGeneralDataAccess(ParametroGeneralDataAccess newparametrogeneralDataAccess) {
		this.parametrogeneralDataAccess = newparametrogeneralDataAccess;
	}
	
	public List<ParametroGeneral> getParametroGenerals() throws Exception {		
		this.quitarParametroGeneralsNulos();
		
		ParametroGeneralLogicAdditional.checkParametroGeneralToGets(parametrogenerals,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroGeneral parametrogeneralLocal: parametrogenerals ) {
			ParametroGeneralLogicAdditional.updateParametroGeneralToGet(parametrogeneralLocal,this.arrDatoGeneral);
		}
		
		return parametrogenerals;
	}
	
	public void setParametroGenerals(List<ParametroGeneral> newParametroGenerals) {
		this.parametrogenerals = newParametroGenerals;
	}
	
	public Object getParametroGeneralObject() {	
		this.parametrogeneralObject=this.parametrogeneralDataAccess.getEntityObject();
		return this.parametrogeneralObject;
	}
		
	public void setParametroGeneralObject(Object newParametroGeneralObject) {
		this.parametrogeneralObject = newParametroGeneralObject;
	}
	
	public List<Object> getParametroGeneralsObject() {		
		this.parametrogeneralsObject=this.parametrogeneralDataAccess.getEntitiesObject();
		return this.parametrogeneralsObject;
	}
		
	public void setParametroGeneralsObject(List<Object> newParametroGeneralsObject) {
		this.parametrogeneralsObject = newParametroGeneralsObject;
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
		
		if(this.parametrogeneralDataAccess!=null) {
			this.parametrogeneralDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneral.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametrogeneralDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametrogeneralDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametrogeneral = new  ParametroGeneral();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneral.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrogeneral=parametrogeneralDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrogeneral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogeneral);
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
		parametrogeneral = new  ParametroGeneral();
		  		  
        try {
			
			parametrogeneral=parametrogeneralDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrogeneral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogeneral);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametrogeneral = new  ParametroGeneral();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneral.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrogeneral=parametrogeneralDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrogeneral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogeneral);
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
		parametrogeneral = new  ParametroGeneral();
		  		  
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
		parametrogeneral = new  ParametroGeneral();
		  		  
        try {
			
			parametrogeneral=parametrogeneralDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrogeneral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogeneral);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametrogeneral = new  ParametroGeneral();
		  		  
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
		parametrogeneral = new  ParametroGeneral();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneral.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametrogeneralDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrogeneral = new  ParametroGeneral();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametrogeneralDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrogeneral = new  ParametroGeneral();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneral.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametrogeneralDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrogeneral = new  ParametroGeneral();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametrogeneralDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrogeneral = new  ParametroGeneral();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneral.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametrogeneralDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrogeneral = new  ParametroGeneral();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametrogeneralDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrogenerals = new  ArrayList<ParametroGeneral>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneral.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogenerals=parametrogeneralDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGeneral(parametrogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogenerals);
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
		parametrogenerals = new  ArrayList<ParametroGeneral>();
		  		  
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
		parametrogenerals = new  ArrayList<ParametroGeneral>();
		  		  
        try {			
			ParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogenerals=parametrogeneralDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroGeneral(parametrogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogenerals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametrogenerals = new  ArrayList<ParametroGeneral>();
		  		  
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
		parametrogenerals = new  ArrayList<ParametroGeneral>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneral.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogenerals=parametrogeneralDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGeneral(parametrogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogenerals);
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
		parametrogenerals = new  ArrayList<ParametroGeneral>();
		  		  
        try {
			ParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogenerals=parametrogeneralDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGeneral(parametrogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogenerals);
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
		parametrogenerals = new  ArrayList<ParametroGeneral>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneral.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogenerals=parametrogeneralDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroGeneral(parametrogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogenerals);
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
		parametrogenerals = new  ArrayList<ParametroGeneral>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogenerals=parametrogeneralDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroGeneral(parametrogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogenerals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametrogeneral = new  ParametroGeneral();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneral.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneral=parametrogeneralDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroGeneral(parametrogeneral);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogeneral);
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
		parametrogeneral = new  ParametroGeneral();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogeneral=parametrogeneralDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroGeneral(parametrogeneral);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogeneral);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrogenerals = new  ArrayList<ParametroGeneral>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneral.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogenerals=parametrogeneralDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGeneral(parametrogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogenerals);
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
		parametrogenerals = new  ArrayList<ParametroGeneral>();
		  		  
        try {
			ParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogenerals=parametrogeneralDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroGeneral(parametrogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogenerals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroGeneralsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametrogenerals = new  ArrayList<ParametroGeneral>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneral.class.getSimpleName()+"-getTodosParametroGeneralsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogenerals=parametrogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroGeneral(parametrogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogenerals);
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
	
	public  void  getTodosParametroGenerals(String sFinalQuery,Pagination pagination)throws Exception {
		parametrogenerals = new  ArrayList<ParametroGeneral>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrogenerals=parametrogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroGeneral(parametrogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogenerals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroGeneral(ParametroGeneral parametrogeneral) throws Exception {
		Boolean estaValidado=false;
		
		if(parametrogeneral.getIsNew() || parametrogeneral.getIsChanged()) { 
			this.invalidValues = parametrogeneralValidator.getInvalidValues(parametrogeneral);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametrogeneral);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroGeneral(List<ParametroGeneral> ParametroGenerals) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroGeneral parametrogeneralLocal:parametrogenerals) {				
			estaValidadoObjeto=this.validarGuardarParametroGeneral(parametrogeneralLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroGeneral(List<ParametroGeneral> ParametroGenerals) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroGeneral(parametrogenerals)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroGeneral(ParametroGeneral ParametroGeneral) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroGeneral(parametrogeneral)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroGeneral parametrogeneral) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametrogeneral.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroGeneralConstantesFunciones.getParametroGeneralLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametrogeneral","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroGeneralConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroGeneralConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroGeneralWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneral.class.getSimpleName()+"-saveParametroGeneralWithConnection");connexion.begin();			
			
			ParametroGeneralLogicAdditional.checkParametroGeneralToSave(this.parametrogeneral,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroGeneralLogicAdditional.updateParametroGeneralToSave(this.parametrogeneral,this.arrDatoGeneral);
			
			ParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrogeneral,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroGeneral();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroGeneral(this.parametrogeneral)) {
				ParametroGeneralDataAccess.save(this.parametrogeneral, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametrogeneral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroGeneralLogicAdditional.checkParametroGeneralToSaveAfter(this.parametrogeneral,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroGeneral();
			
			connexion.commit();			
			
			if(this.parametrogeneral.getIsDeleted()) {
				this.parametrogeneral=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroGeneral()throws Exception {	
		try {	
			
			ParametroGeneralLogicAdditional.checkParametroGeneralToSave(this.parametrogeneral,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroGeneralLogicAdditional.updateParametroGeneralToSave(this.parametrogeneral,this.arrDatoGeneral);
			
			ParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrogeneral,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroGeneral(this.parametrogeneral)) {			
				ParametroGeneralDataAccess.save(this.parametrogeneral, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametrogeneral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroGeneralLogicAdditional.checkParametroGeneralToSaveAfter(this.parametrogeneral,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametrogeneral.getIsDeleted()) {
				this.parametrogeneral=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroGeneralsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneral.class.getSimpleName()+"-saveParametroGeneralsWithConnection");connexion.begin();			
			
			ParametroGeneralLogicAdditional.checkParametroGeneralToSaves(parametrogenerals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroGenerals();
			
			Boolean validadoTodosParametroGeneral=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroGeneral parametrogeneralLocal:parametrogenerals) {		
				if(parametrogeneralLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroGeneralLogicAdditional.updateParametroGeneralToSave(parametrogeneralLocal,this.arrDatoGeneral);
	        	
				ParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrogeneralLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroGeneral(parametrogeneralLocal)) {
					ParametroGeneralDataAccess.save(parametrogeneralLocal, connexion);				
				} else {
					validadoTodosParametroGeneral=false;
				}
			}
			
			if(!validadoTodosParametroGeneral) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroGeneralLogicAdditional.checkParametroGeneralToSavesAfter(parametrogenerals,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroGenerals();
			
			connexion.commit();		
			
			this.quitarParametroGeneralsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroGenerals()throws Exception {				
		 try {	
			ParametroGeneralLogicAdditional.checkParametroGeneralToSaves(parametrogenerals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroGeneral=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroGeneral parametrogeneralLocal:parametrogenerals) {				
				if(parametrogeneralLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroGeneralLogicAdditional.updateParametroGeneralToSave(parametrogeneralLocal,this.arrDatoGeneral);
	        	
				ParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrogeneralLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroGeneral(parametrogeneralLocal)) {				
					ParametroGeneralDataAccess.save(parametrogeneralLocal, connexion);				
				} else {
					validadoTodosParametroGeneral=false;
				}
			}
			
			if(!validadoTodosParametroGeneral) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroGeneralLogicAdditional.checkParametroGeneralToSavesAfter(parametrogenerals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroGeneralsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroGeneralParameterReturnGeneral procesarAccionParametroGenerals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroGeneral> parametrogenerals,ParametroGeneralParameterReturnGeneral parametrogeneralParameterGeneral)throws Exception {
		 try {	
			ParametroGeneralParameterReturnGeneral parametrogeneralReturnGeneral=new ParametroGeneralParameterReturnGeneral();
	
			ParametroGeneralLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrogenerals,parametrogeneralParameterGeneral,parametrogeneralReturnGeneral);
			
			return parametrogeneralReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroGeneralParameterReturnGeneral procesarAccionParametroGeneralsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroGeneral> parametrogenerals,ParametroGeneralParameterReturnGeneral parametrogeneralParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneral.class.getSimpleName()+"-procesarAccionParametroGeneralsWithConnection");connexion.begin();			
			
			ParametroGeneralParameterReturnGeneral parametrogeneralReturnGeneral=new ParametroGeneralParameterReturnGeneral();
	
			ParametroGeneralLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrogenerals,parametrogeneralParameterGeneral,parametrogeneralReturnGeneral);
			
			this.connexion.commit();
			
			return parametrogeneralReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroGeneralParameterReturnGeneral procesarEventosParametroGenerals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroGeneral> parametrogenerals,ParametroGeneral parametrogeneral,ParametroGeneralParameterReturnGeneral parametrogeneralParameterGeneral,Boolean isEsNuevoParametroGeneral,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroGeneralParameterReturnGeneral parametrogeneralReturnGeneral=new ParametroGeneralParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrogeneralReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroGeneralLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrogenerals,parametrogeneral,parametrogeneralParameterGeneral,parametrogeneralReturnGeneral,isEsNuevoParametroGeneral,clases);
			
			return parametrogeneralReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroGeneralParameterReturnGeneral procesarEventosParametroGeneralsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroGeneral> parametrogenerals,ParametroGeneral parametrogeneral,ParametroGeneralParameterReturnGeneral parametrogeneralParameterGeneral,Boolean isEsNuevoParametroGeneral,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneral.class.getSimpleName()+"-procesarEventosParametroGeneralsWithConnection");connexion.begin();			
			
			ParametroGeneralParameterReturnGeneral parametrogeneralReturnGeneral=new ParametroGeneralParameterReturnGeneral();
	
			parametrogeneralReturnGeneral.setParametroGeneral(parametrogeneral);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrogeneralReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroGeneralLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrogenerals,parametrogeneral,parametrogeneralParameterGeneral,parametrogeneralReturnGeneral,isEsNuevoParametroGeneral,clases);
			
			this.connexion.commit();
			
			return parametrogeneralReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroGeneralParameterReturnGeneral procesarImportacionParametroGeneralsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroGeneralParameterReturnGeneral parametrogeneralParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneral.class.getSimpleName()+"-procesarImportacionParametroGeneralsWithConnection");connexion.begin();			
			
			ParametroGeneralParameterReturnGeneral parametrogeneralReturnGeneral=new ParametroGeneralParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametrogenerals=new ArrayList<ParametroGeneral>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametrogeneral=new ParametroGeneral();
				
				
				if(conColumnasBase) {this.parametrogeneral.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametrogeneral.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.parametrogeneral.setnumero_secuencial(arrColumnas[iColumn++]);
				this.parametrogeneral.setnumero_autor(arrColumnas[iColumn++]);
				this.parametrogeneral.setfecha_inicio(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.parametrogeneral.setfecha_fin(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.parametrogeneral.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.parametrogenerals.add(this.parametrogeneral);
			}
			
			this.saveParametroGenerals();
			
			this.connexion.commit();
			
			parametrogeneralReturnGeneral.setConRetornoEstaProcesado(true);
			parametrogeneralReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametrogeneralReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroGeneralsEliminados() throws Exception {				
		
		List<ParametroGeneral> parametrogeneralsAux= new ArrayList<ParametroGeneral>();
		
		for(ParametroGeneral parametrogeneral:parametrogenerals) {
			if(!parametrogeneral.getIsDeleted()) {
				parametrogeneralsAux.add(parametrogeneral);
			}
		}
		
		parametrogenerals=parametrogeneralsAux;
	}
	
	public void quitarParametroGeneralsNulos() throws Exception {				
		
		List<ParametroGeneral> parametrogeneralsAux= new ArrayList<ParametroGeneral>();
		
		for(ParametroGeneral parametrogeneral : this.parametrogenerals) {
			if(parametrogeneral==null) {
				parametrogeneralsAux.add(parametrogeneral);
			}
		}
		
		//this.parametrogenerals=parametrogeneralsAux;
		
		this.parametrogenerals.removeAll(parametrogeneralsAux);
	}
	
	public void getSetVersionRowParametroGeneralWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametrogeneral.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametrogeneral.getIsDeleted() || (parametrogeneral.getIsChanged()&&!parametrogeneral.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametrogeneralDataAccess.getSetVersionRowParametroGeneral(connexion,parametrogeneral.getId());
				
				if(!parametrogeneral.getVersionRow().equals(timestamp)) {	
					parametrogeneral.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametrogeneral.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroGeneral()throws Exception {	
		
		if(parametrogeneral.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametrogeneral.getIsDeleted() || (parametrogeneral.getIsChanged()&&!parametrogeneral.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametrogeneralDataAccess.getSetVersionRowParametroGeneral(connexion,parametrogeneral.getId());
			
			try {							
				if(!parametrogeneral.getVersionRow().equals(timestamp)) {	
					parametrogeneral.setVersionRow(timestamp);
				}
				
				parametrogeneral.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroGeneralsWithConnection()throws Exception {	
		if(parametrogenerals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroGeneral parametrogeneralAux:parametrogenerals) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametrogeneralAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrogeneralAux.getIsDeleted() || (parametrogeneralAux.getIsChanged()&&!parametrogeneralAux.getIsNew())) {
						
						timestamp=parametrogeneralDataAccess.getSetVersionRowParametroGeneral(connexion,parametrogeneralAux.getId());
						
						if(!parametrogeneral.getVersionRow().equals(timestamp)) {	
							parametrogeneralAux.setVersionRow(timestamp);
						}
								
						parametrogeneralAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroGenerals()throws Exception {	
		if(parametrogenerals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroGeneral parametrogeneralAux:parametrogenerals) {
					if(parametrogeneralAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrogeneralAux.getIsDeleted() || (parametrogeneralAux.getIsChanged()&&!parametrogeneralAux.getIsNew())) {
						
						timestamp=parametrogeneralDataAccess.getSetVersionRowParametroGeneral(connexion,parametrogeneralAux.getId());
						
						if(!parametrogeneralAux.getVersionRow().equals(timestamp)) {	
							parametrogeneralAux.setVersionRow(timestamp);
						}
						
													
						parametrogeneralAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroGeneralParameterReturnGeneral cargarCombosLoteForeignKeyParametroGeneralWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoDocumentoGeneral) throws Exception {
		ParametroGeneralParameterReturnGeneral  parametrogeneralReturnGeneral =new ParametroGeneralParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneral.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroGeneralWithConnection");connexion.begin();
			
			parametrogeneralReturnGeneral =new ParametroGeneralParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrogeneralReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrogeneralReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoDocumentoGeneral> tipodocumentogeneralsForeignKey=new ArrayList<TipoDocumentoGeneral>();
			TipoDocumentoGeneralLogic tipodocumentogeneralLogic=new TipoDocumentoGeneralLogic();
			tipodocumentogeneralLogic.setConnexion(this.connexion);
			tipodocumentogeneralLogic.getTipoDocumentoGeneralDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumentoGeneral.equals("NONE")) {
				tipodocumentogeneralLogic.getTodosTipoDocumentoGenerals(finalQueryGlobalTipoDocumentoGeneral,new Pagination());
				tipodocumentogeneralsForeignKey=tipodocumentogeneralLogic.getTipoDocumentoGenerals();
			}

			parametrogeneralReturnGeneral.settipodocumentogeneralsForeignKey(tipodocumentogeneralsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametrogeneralReturnGeneral;
	}
	
	public ParametroGeneralParameterReturnGeneral cargarCombosLoteForeignKeyParametroGeneral(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoDocumentoGeneral) throws Exception {
		ParametroGeneralParameterReturnGeneral  parametrogeneralReturnGeneral =new ParametroGeneralParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametrogeneralReturnGeneral =new ParametroGeneralParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrogeneralReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrogeneralReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoDocumentoGeneral> tipodocumentogeneralsForeignKey=new ArrayList<TipoDocumentoGeneral>();
			TipoDocumentoGeneralLogic tipodocumentogeneralLogic=new TipoDocumentoGeneralLogic();
			tipodocumentogeneralLogic.setConnexion(this.connexion);
			tipodocumentogeneralLogic.getTipoDocumentoGeneralDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumentoGeneral.equals("NONE")) {
				tipodocumentogeneralLogic.getTodosTipoDocumentoGenerals(finalQueryGlobalTipoDocumentoGeneral,new Pagination());
				tipodocumentogeneralsForeignKey=tipodocumentogeneralLogic.getTipoDocumentoGenerals();
			}

			parametrogeneralReturnGeneral.settipodocumentogeneralsForeignKey(tipodocumentogeneralsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametrogeneralReturnGeneral;
	}
	
	
	public void deepLoad(ParametroGeneral parametrogeneral,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroGeneralLogicAdditional.updateParametroGeneralToGet(parametrogeneral,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrogeneral.setEmpresa(parametrogeneralDataAccess.getEmpresa(connexion,parametrogeneral));
		parametrogeneral.setSucursal(parametrogeneralDataAccess.getSucursal(connexion,parametrogeneral));
		parametrogeneral.setTipoDocumentoGeneral(parametrogeneralDataAccess.getTipoDocumentoGeneral(connexion,parametrogeneral));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrogeneral.setEmpresa(parametrogeneralDataAccess.getEmpresa(connexion,parametrogeneral));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrogeneral.setSucursal(parametrogeneralDataAccess.getSucursal(connexion,parametrogeneral));
				continue;
			}

			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				parametrogeneral.setTipoDocumentoGeneral(parametrogeneralDataAccess.getTipoDocumentoGeneral(connexion,parametrogeneral));
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
			parametrogeneral.setEmpresa(parametrogeneralDataAccess.getEmpresa(connexion,parametrogeneral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneral.setSucursal(parametrogeneralDataAccess.getSucursal(connexion,parametrogeneral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneral.setTipoDocumentoGeneral(parametrogeneralDataAccess.getTipoDocumentoGeneral(connexion,parametrogeneral));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrogeneral.setEmpresa(parametrogeneralDataAccess.getEmpresa(connexion,parametrogeneral));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrogeneral.getEmpresa(),isDeep,deepLoadType,clases);
				
		parametrogeneral.setSucursal(parametrogeneralDataAccess.getSucursal(connexion,parametrogeneral));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrogeneral.getSucursal(),isDeep,deepLoadType,clases);
				
		parametrogeneral.setTipoDocumentoGeneral(parametrogeneralDataAccess.getTipoDocumentoGeneral(connexion,parametrogeneral));
		TipoDocumentoGeneralLogic tipodocumentogeneralLogic= new TipoDocumentoGeneralLogic(connexion);
		tipodocumentogeneralLogic.deepLoad(parametrogeneral.getTipoDocumentoGeneral(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrogeneral.setEmpresa(parametrogeneralDataAccess.getEmpresa(connexion,parametrogeneral));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametrogeneral.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrogeneral.setSucursal(parametrogeneralDataAccess.getSucursal(connexion,parametrogeneral));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(parametrogeneral.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				parametrogeneral.setTipoDocumentoGeneral(parametrogeneralDataAccess.getTipoDocumentoGeneral(connexion,parametrogeneral));
				TipoDocumentoGeneralLogic tipodocumentogeneralLogic= new TipoDocumentoGeneralLogic(connexion);
				tipodocumentogeneralLogic.deepLoad(parametrogeneral.getTipoDocumentoGeneral(),isDeep,deepLoadType,clases);				
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
			parametrogeneral.setEmpresa(parametrogeneralDataAccess.getEmpresa(connexion,parametrogeneral));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametrogeneral.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneral.setSucursal(parametrogeneralDataAccess.getSucursal(connexion,parametrogeneral));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(parametrogeneral.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrogeneral.setTipoDocumentoGeneral(parametrogeneralDataAccess.getTipoDocumentoGeneral(connexion,parametrogeneral));
			TipoDocumentoGeneralLogic tipodocumentogeneralLogic= new TipoDocumentoGeneralLogic(connexion);
			tipodocumentogeneralLogic.deepLoad(parametrogeneral.getTipoDocumentoGeneral(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroGeneral parametrogeneral,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroGeneralLogicAdditional.updateParametroGeneralToSave(parametrogeneral,this.arrDatoGeneral);
			
ParametroGeneralDataAccess.save(parametrogeneral, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrogeneral.getEmpresa(),connexion);

		SucursalDataAccess.save(parametrogeneral.getSucursal(),connexion);

		TipoDocumentoGeneralDataAccess.save(parametrogeneral.getTipoDocumentoGeneral(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrogeneral.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrogeneral.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				TipoDocumentoGeneralDataAccess.save(parametrogeneral.getTipoDocumentoGeneral(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrogeneral.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrogeneral.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(parametrogeneral.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrogeneral.getSucursal(),isDeep,deepLoadType,clases);
				

		TipoDocumentoGeneralDataAccess.save(parametrogeneral.getTipoDocumentoGeneral(),connexion);
		TipoDocumentoGeneralLogic tipodocumentogeneralLogic= new TipoDocumentoGeneralLogic(connexion);
		tipodocumentogeneralLogic.deepLoad(parametrogeneral.getTipoDocumentoGeneral(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrogeneral.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametrogeneral.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrogeneral.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(parametrogeneral.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumentoGeneral.class)) {
				TipoDocumentoGeneralDataAccess.save(parametrogeneral.getTipoDocumentoGeneral(),connexion);
				TipoDocumentoGeneralLogic tipodocumentogeneralLogic= new TipoDocumentoGeneralLogic(connexion);
				tipodocumentogeneralLogic.deepSave(parametrogeneral.getTipoDocumentoGeneral(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParametroGeneral.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametrogeneral,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(parametrogeneral);
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
			this.deepLoad(this.parametrogeneral,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogeneral);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroGeneral.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametrogenerals!=null) {
				for(ParametroGeneral parametrogeneral:parametrogenerals) {
					this.deepLoad(parametrogeneral,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(parametrogenerals);
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
			if(parametrogenerals!=null) {
				for(ParametroGeneral parametrogeneral:parametrogenerals) {
					this.deepLoad(parametrogeneral,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(parametrogenerals);
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
			this.getNewConnexionToDeep(ParametroGeneral.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametrogeneral,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroGeneral.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametrogenerals!=null) {
				for(ParametroGeneral parametrogeneral:parametrogenerals) {
					this.deepSave(parametrogeneral,isDeep,deepLoadType,clases);
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
			if(parametrogenerals!=null) {
				for(ParametroGeneral parametrogeneral:parametrogenerals) {
					this.deepSave(parametrogeneral,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroGeneralsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneral.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroGeneralConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenerals=parametrogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogenerals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGeneralsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroGeneralConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenerals=parametrogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogenerals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGeneralsFK_IdSucursalEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneral.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroGeneralConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursalEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenerals=parametrogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogenerals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGeneralsFK_IdSucursalEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroGeneralConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursalEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenerals=parametrogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogenerals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroGeneralsFK_IdTipoDocumentoGeneralWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_documento_general)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroGeneral.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoGeneral= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoGeneral.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_general,ParametroGeneralConstantesFunciones.IDTIPODOCUMENTOGENERAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoGeneral);

			ParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumentoGeneral","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenerals=parametrogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogenerals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroGeneralsFK_IdTipoDocumentoGeneral(String sFinalQuery,Pagination pagination,Long id_tipo_documento_general)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumentoGeneral= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumentoGeneral.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento_general,ParametroGeneralConstantesFunciones.IDTIPODOCUMENTOGENERAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumentoGeneral);

			ParametroGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumentoGeneral","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrogenerals=parametrogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroGeneralConstantesFunciones.refrescarForeignKeysDescripcionesParametroGeneral(this.parametrogenerals);
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
			if(ParametroGeneralConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroGeneralDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroGeneral parametrogeneral,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroGeneralConstantesFunciones.ISCONAUDITORIA) {
				if(parametrogeneral.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroGeneralDataAccess.TABLENAME, parametrogeneral.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroGeneralConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroGeneralLogic.registrarAuditoriaDetallesParametroGeneral(connexion,parametrogeneral,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametrogeneral.getIsDeleted()) {
					/*if(!parametrogeneral.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroGeneralDataAccess.TABLENAME, parametrogeneral.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroGeneralLogic.registrarAuditoriaDetallesParametroGeneral(connexion,parametrogeneral,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroGeneralDataAccess.TABLENAME, parametrogeneral.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametrogeneral.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroGeneralDataAccess.TABLENAME, parametrogeneral.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroGeneralConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroGeneralLogic.registrarAuditoriaDetallesParametroGeneral(connexion,parametrogeneral,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroGeneral(Connexion connexion,ParametroGeneral parametrogeneral)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametrogeneral.getIsNew()||!parametrogeneral.getid_empresa().equals(parametrogeneral.getParametroGeneralOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneral.getParametroGeneralOriginal().getid_empresa()!=null)
				{
					strValorActual=parametrogeneral.getParametroGeneralOriginal().getid_empresa().toString();
				}
				if(parametrogeneral.getid_empresa()!=null)
				{
					strValorNuevo=parametrogeneral.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneral.getIsNew()||!parametrogeneral.getid_sucursal().equals(parametrogeneral.getParametroGeneralOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneral.getParametroGeneralOriginal().getid_sucursal()!=null)
				{
					strValorActual=parametrogeneral.getParametroGeneralOriginal().getid_sucursal().toString();
				}
				if(parametrogeneral.getid_sucursal()!=null)
				{
					strValorNuevo=parametrogeneral.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneral.getIsNew()||!parametrogeneral.getid_tipo_documento_general().equals(parametrogeneral.getParametroGeneralOriginal().getid_tipo_documento_general()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneral.getParametroGeneralOriginal().getid_tipo_documento_general()!=null)
				{
					strValorActual=parametrogeneral.getParametroGeneralOriginal().getid_tipo_documento_general().toString();
				}
				if(parametrogeneral.getid_tipo_documento_general()!=null)
				{
					strValorNuevo=parametrogeneral.getid_tipo_documento_general().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralConstantesFunciones.IDTIPODOCUMENTOGENERAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneral.getIsNew()||!parametrogeneral.getnumero_secuencial().equals(parametrogeneral.getParametroGeneralOriginal().getnumero_secuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneral.getParametroGeneralOriginal().getnumero_secuencial()!=null)
				{
					strValorActual=parametrogeneral.getParametroGeneralOriginal().getnumero_secuencial();
				}
				if(parametrogeneral.getnumero_secuencial()!=null)
				{
					strValorNuevo=parametrogeneral.getnumero_secuencial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralConstantesFunciones.NUMEROSECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneral.getIsNew()||!parametrogeneral.getnumero_autor().equals(parametrogeneral.getParametroGeneralOriginal().getnumero_autor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneral.getParametroGeneralOriginal().getnumero_autor()!=null)
				{
					strValorActual=parametrogeneral.getParametroGeneralOriginal().getnumero_autor();
				}
				if(parametrogeneral.getnumero_autor()!=null)
				{
					strValorNuevo=parametrogeneral.getnumero_autor() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralConstantesFunciones.NUMEROAUTOR,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneral.getIsNew()||!parametrogeneral.getfecha_inicio().equals(parametrogeneral.getParametroGeneralOriginal().getfecha_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneral.getParametroGeneralOriginal().getfecha_inicio()!=null)
				{
					strValorActual=parametrogeneral.getParametroGeneralOriginal().getfecha_inicio().toString();
				}
				if(parametrogeneral.getfecha_inicio()!=null)
				{
					strValorNuevo=parametrogeneral.getfecha_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralConstantesFunciones.FECHAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneral.getIsNew()||!parametrogeneral.getfecha_fin().equals(parametrogeneral.getParametroGeneralOriginal().getfecha_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneral.getParametroGeneralOriginal().getfecha_fin()!=null)
				{
					strValorActual=parametrogeneral.getParametroGeneralOriginal().getfecha_fin().toString();
				}
				if(parametrogeneral.getfecha_fin()!=null)
				{
					strValorNuevo=parametrogeneral.getfecha_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralConstantesFunciones.FECHAFIN,strValorActual,strValorNuevo);
			}	
			
			if(parametrogeneral.getIsNew()||!parametrogeneral.getesta_activo().equals(parametrogeneral.getParametroGeneralOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrogeneral.getParametroGeneralOriginal().getesta_activo()!=null)
				{
					strValorActual=parametrogeneral.getParametroGeneralOriginal().getesta_activo().toString();
				}
				if(parametrogeneral.getesta_activo()!=null)
				{
					strValorNuevo=parametrogeneral.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroGeneralConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroGeneralRelacionesWithConnection(ParametroGeneral parametrogeneral) throws Exception {

		if(!parametrogeneral.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroGeneralRelacionesBase(parametrogeneral,true);
		}
	}

	public void saveParametroGeneralRelaciones(ParametroGeneral parametrogeneral)throws Exception {

		if(!parametrogeneral.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroGeneralRelacionesBase(parametrogeneral,false);
		}
	}

	public void saveParametroGeneralRelacionesBase(ParametroGeneral parametrogeneral,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroGeneral-saveRelacionesWithConnection");}
	

			this.setParametroGeneral(parametrogeneral);

			if(ParametroGeneralLogicAdditional.validarSaveRelaciones(parametrogeneral,this)) {

				ParametroGeneralLogicAdditional.updateRelacionesToSave(parametrogeneral,this);

				if((parametrogeneral.getIsNew()||parametrogeneral.getIsChanged())&&!parametrogeneral.getIsDeleted()) {
					this.saveParametroGeneral();
					this.saveParametroGeneralRelacionesDetalles();

				} else if(parametrogeneral.getIsDeleted()) {
					this.saveParametroGeneralRelacionesDetalles();
					this.saveParametroGeneral();
				}

				ParametroGeneralLogicAdditional.updateRelacionesToSaveAfter(parametrogeneral,this);

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
	
	
	private void saveParametroGeneralRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroGeneralConstantesFunciones.getClassesForeignKeysOfParametroGeneral(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroGeneralConstantesFunciones.getClassesRelationshipsOfParametroGeneral(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

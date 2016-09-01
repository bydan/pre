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
import com.bydan.erp.contabilidad.util.PresuTransferenciaConstantesFunciones;
import com.bydan.erp.contabilidad.util.PresuTransferenciaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.PresuTransferenciaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.PresuTransferencia;
import com.bydan.erp.contabilidad.business.logic.PresuTransferenciaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.nomina.util.*;


import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class PresuTransferenciaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PresuTransferenciaLogic.class);
	
	protected PresuTransferenciaDataAccess presutransferenciaDataAccess; 	
	protected PresuTransferencia presutransferencia;
	protected List<PresuTransferencia> presutransferencias;
	protected Object presutransferenciaObject;	
	protected List<Object> presutransferenciasObject;
	
	public static ClassValidator<PresuTransferencia> presutransferenciaValidator = new ClassValidator<PresuTransferencia>(PresuTransferencia.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PresuTransferenciaLogicAdditional presutransferenciaLogicAdditional=null;
	
	public PresuTransferenciaLogicAdditional getPresuTransferenciaLogicAdditional() {
		return this.presutransferenciaLogicAdditional;
	}
	
	public void setPresuTransferenciaLogicAdditional(PresuTransferenciaLogicAdditional presutransferenciaLogicAdditional) {
		try {
			this.presutransferenciaLogicAdditional=presutransferenciaLogicAdditional;
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
	
	
	
	
	public  PresuTransferenciaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.presutransferenciaDataAccess = new PresuTransferenciaDataAccess();
			
			this.presutransferencias= new ArrayList<PresuTransferencia>();
			this.presutransferencia= new PresuTransferencia();
			
			this.presutransferenciaObject=new Object();
			this.presutransferenciasObject=new ArrayList<Object>();
				
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
			
			this.presutransferenciaDataAccess.setConnexionType(this.connexionType);
			this.presutransferenciaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PresuTransferenciaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.presutransferenciaDataAccess = new PresuTransferenciaDataAccess();
			this.presutransferencias= new ArrayList<PresuTransferencia>();
			this.presutransferencia= new PresuTransferencia();
			this.presutransferenciaObject=new Object();
			this.presutransferenciasObject=new ArrayList<Object>();
			
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
			
			this.presutransferenciaDataAccess.setConnexionType(this.connexionType);
			this.presutransferenciaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PresuTransferencia getPresuTransferencia() throws Exception {	
		PresuTransferenciaLogicAdditional.checkPresuTransferenciaToGet(presutransferencia,this.datosCliente,this.arrDatoGeneral);
		PresuTransferenciaLogicAdditional.updatePresuTransferenciaToGet(presutransferencia,this.arrDatoGeneral);
		
		return presutransferencia;
	}
		
	public void setPresuTransferencia(PresuTransferencia newPresuTransferencia) {
		this.presutransferencia = newPresuTransferencia;
	}
	
	public PresuTransferenciaDataAccess getPresuTransferenciaDataAccess() {
		return presutransferenciaDataAccess;
	}
	
	public void setPresuTransferenciaDataAccess(PresuTransferenciaDataAccess newpresutransferenciaDataAccess) {
		this.presutransferenciaDataAccess = newpresutransferenciaDataAccess;
	}
	
	public List<PresuTransferencia> getPresuTransferencias() throws Exception {		
		this.quitarPresuTransferenciasNulos();
		
		PresuTransferenciaLogicAdditional.checkPresuTransferenciaToGets(presutransferencias,this.datosCliente,this.arrDatoGeneral);
		
		for (PresuTransferencia presutransferenciaLocal: presutransferencias ) {
			PresuTransferenciaLogicAdditional.updatePresuTransferenciaToGet(presutransferenciaLocal,this.arrDatoGeneral);
		}
		
		return presutransferencias;
	}
	
	public void setPresuTransferencias(List<PresuTransferencia> newPresuTransferencias) {
		this.presutransferencias = newPresuTransferencias;
	}
	
	public Object getPresuTransferenciaObject() {	
		this.presutransferenciaObject=this.presutransferenciaDataAccess.getEntityObject();
		return this.presutransferenciaObject;
	}
		
	public void setPresuTransferenciaObject(Object newPresuTransferenciaObject) {
		this.presutransferenciaObject = newPresuTransferenciaObject;
	}
	
	public List<Object> getPresuTransferenciasObject() {		
		this.presutransferenciasObject=this.presutransferenciaDataAccess.getEntitiesObject();
		return this.presutransferenciasObject;
	}
		
	public void setPresuTransferenciasObject(List<Object> newPresuTransferenciasObject) {
		this.presutransferenciasObject = newPresuTransferenciasObject;
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
		
		if(this.presutransferenciaDataAccess!=null) {
			this.presutransferenciaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTransferencia.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			presutransferenciaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			presutransferenciaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		presutransferencia = new  PresuTransferencia();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTransferencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presutransferencia=presutransferenciaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presutransferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencia);
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
		presutransferencia = new  PresuTransferencia();
		  		  
        try {
			
			presutransferencia=presutransferenciaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presutransferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		presutransferencia = new  PresuTransferencia();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTransferencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presutransferencia=presutransferenciaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presutransferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencia);
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
		presutransferencia = new  PresuTransferencia();
		  		  
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
		presutransferencia = new  PresuTransferencia();
		  		  
        try {
			
			presutransferencia=presutransferenciaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presutransferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		presutransferencia = new  PresuTransferencia();
		  		  
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
		presutransferencia = new  PresuTransferencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTransferencia.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =presutransferenciaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presutransferencia = new  PresuTransferencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=presutransferenciaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presutransferencia = new  PresuTransferencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTransferencia.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =presutransferenciaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presutransferencia = new  PresuTransferencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=presutransferenciaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presutransferencia = new  PresuTransferencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTransferencia.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =presutransferenciaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presutransferencia = new  PresuTransferencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=presutransferenciaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presutransferencias = new  ArrayList<PresuTransferencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTransferencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutransferencias=presutransferenciaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuTransferencia(presutransferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencias);
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
		presutransferencias = new  ArrayList<PresuTransferencia>();
		  		  
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
		presutransferencias = new  ArrayList<PresuTransferencia>();
		  		  
        try {			
			PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutransferencias=presutransferenciaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPresuTransferencia(presutransferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		presutransferencias = new  ArrayList<PresuTransferencia>();
		  		  
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
		presutransferencias = new  ArrayList<PresuTransferencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTransferencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutransferencias=presutransferenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuTransferencia(presutransferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencias);
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
		presutransferencias = new  ArrayList<PresuTransferencia>();
		  		  
        try {
			PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutransferencias=presutransferenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuTransferencia(presutransferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencias);
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
		presutransferencias = new  ArrayList<PresuTransferencia>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTransferencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutransferencias=presutransferenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuTransferencia(presutransferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencias);
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
		presutransferencias = new  ArrayList<PresuTransferencia>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutransferencias=presutransferenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuTransferencia(presutransferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		presutransferencia = new  PresuTransferencia();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTransferencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutransferencia=presutransferenciaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuTransferencia(presutransferencia);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencia);
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
		presutransferencia = new  PresuTransferencia();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutransferencia=presutransferenciaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuTransferencia(presutransferencia);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presutransferencias = new  ArrayList<PresuTransferencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTransferencia.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutransferencias=presutransferenciaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuTransferencia(presutransferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencias);
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
		presutransferencias = new  ArrayList<PresuTransferencia>();
		  		  
        try {
			PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutransferencias=presutransferenciaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuTransferencia(presutransferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPresuTransferenciasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		presutransferencias = new  ArrayList<PresuTransferencia>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTransferencia.class.getSimpleName()+"-getTodosPresuTransferenciasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutransferencias=presutransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresuTransferencia(presutransferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencias);
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
	
	public  void  getTodosPresuTransferencias(String sFinalQuery,Pagination pagination)throws Exception {
		presutransferencias = new  ArrayList<PresuTransferencia>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutransferencias=presutransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresuTransferencia(presutransferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPresuTransferencia(PresuTransferencia presutransferencia) throws Exception {
		Boolean estaValidado=false;
		
		if(presutransferencia.getIsNew() || presutransferencia.getIsChanged()) { 
			this.invalidValues = presutransferenciaValidator.getInvalidValues(presutransferencia);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(presutransferencia);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPresuTransferencia(List<PresuTransferencia> PresuTransferencias) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PresuTransferencia presutransferenciaLocal:presutransferencias) {				
			estaValidadoObjeto=this.validarGuardarPresuTransferencia(presutransferenciaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPresuTransferencia(List<PresuTransferencia> PresuTransferencias) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresuTransferencia(presutransferencias)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPresuTransferencia(PresuTransferencia PresuTransferencia) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresuTransferencia(presutransferencia)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PresuTransferencia presutransferencia) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+presutransferencia.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PresuTransferenciaConstantesFunciones.getPresuTransferenciaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"presutransferencia","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PresuTransferenciaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PresuTransferenciaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePresuTransferenciaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTransferencia.class.getSimpleName()+"-savePresuTransferenciaWithConnection");connexion.begin();			
			
			PresuTransferenciaLogicAdditional.checkPresuTransferenciaToSave(this.presutransferencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresuTransferenciaLogicAdditional.updatePresuTransferenciaToSave(this.presutransferencia,this.arrDatoGeneral);
			
			PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presutransferencia,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPresuTransferencia();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresuTransferencia(this.presutransferencia)) {
				PresuTransferenciaDataAccess.save(this.presutransferencia, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.presutransferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresuTransferenciaLogicAdditional.checkPresuTransferenciaToSaveAfter(this.presutransferencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresuTransferencia();
			
			connexion.commit();			
			
			if(this.presutransferencia.getIsDeleted()) {
				this.presutransferencia=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePresuTransferencia()throws Exception {	
		try {	
			
			PresuTransferenciaLogicAdditional.checkPresuTransferenciaToSave(this.presutransferencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresuTransferenciaLogicAdditional.updatePresuTransferenciaToSave(this.presutransferencia,this.arrDatoGeneral);
			
			PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presutransferencia,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresuTransferencia(this.presutransferencia)) {			
				PresuTransferenciaDataAccess.save(this.presutransferencia, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.presutransferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresuTransferenciaLogicAdditional.checkPresuTransferenciaToSaveAfter(this.presutransferencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.presutransferencia.getIsDeleted()) {
				this.presutransferencia=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePresuTransferenciasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTransferencia.class.getSimpleName()+"-savePresuTransferenciasWithConnection");connexion.begin();			
			
			PresuTransferenciaLogicAdditional.checkPresuTransferenciaToSaves(presutransferencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPresuTransferencias();
			
			Boolean validadoTodosPresuTransferencia=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresuTransferencia presutransferenciaLocal:presutransferencias) {		
				if(presutransferenciaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresuTransferenciaLogicAdditional.updatePresuTransferenciaToSave(presutransferenciaLocal,this.arrDatoGeneral);
	        	
				PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presutransferenciaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresuTransferencia(presutransferenciaLocal)) {
					PresuTransferenciaDataAccess.save(presutransferenciaLocal, connexion);				
				} else {
					validadoTodosPresuTransferencia=false;
				}
			}
			
			if(!validadoTodosPresuTransferencia) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresuTransferenciaLogicAdditional.checkPresuTransferenciaToSavesAfter(presutransferencias,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresuTransferencias();
			
			connexion.commit();		
			
			this.quitarPresuTransferenciasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePresuTransferencias()throws Exception {				
		 try {	
			PresuTransferenciaLogicAdditional.checkPresuTransferenciaToSaves(presutransferencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPresuTransferencia=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresuTransferencia presutransferenciaLocal:presutransferencias) {				
				if(presutransferenciaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresuTransferenciaLogicAdditional.updatePresuTransferenciaToSave(presutransferenciaLocal,this.arrDatoGeneral);
	        	
				PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presutransferenciaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresuTransferencia(presutransferenciaLocal)) {				
					PresuTransferenciaDataAccess.save(presutransferenciaLocal, connexion);				
				} else {
					validadoTodosPresuTransferencia=false;
				}
			}
			
			if(!validadoTodosPresuTransferencia) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresuTransferenciaLogicAdditional.checkPresuTransferenciaToSavesAfter(presutransferencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPresuTransferenciasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresuTransferenciaParameterReturnGeneral procesarAccionPresuTransferencias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresuTransferencia> presutransferencias,PresuTransferenciaParameterReturnGeneral presutransferenciaParameterGeneral)throws Exception {
		 try {	
			PresuTransferenciaParameterReturnGeneral presutransferenciaReturnGeneral=new PresuTransferenciaParameterReturnGeneral();
	
			PresuTransferenciaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presutransferencias,presutransferenciaParameterGeneral,presutransferenciaReturnGeneral);
			
			return presutransferenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresuTransferenciaParameterReturnGeneral procesarAccionPresuTransferenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresuTransferencia> presutransferencias,PresuTransferenciaParameterReturnGeneral presutransferenciaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTransferencia.class.getSimpleName()+"-procesarAccionPresuTransferenciasWithConnection");connexion.begin();			
			
			PresuTransferenciaParameterReturnGeneral presutransferenciaReturnGeneral=new PresuTransferenciaParameterReturnGeneral();
	
			PresuTransferenciaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presutransferencias,presutransferenciaParameterGeneral,presutransferenciaReturnGeneral);
			
			this.connexion.commit();
			
			return presutransferenciaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresuTransferenciaParameterReturnGeneral procesarEventosPresuTransferencias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresuTransferencia> presutransferencias,PresuTransferencia presutransferencia,PresuTransferenciaParameterReturnGeneral presutransferenciaParameterGeneral,Boolean isEsNuevoPresuTransferencia,ArrayList<Classe> clases)throws Exception {
		 try {	
			PresuTransferenciaParameterReturnGeneral presutransferenciaReturnGeneral=new PresuTransferenciaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presutransferenciaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresuTransferenciaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presutransferencias,presutransferencia,presutransferenciaParameterGeneral,presutransferenciaReturnGeneral,isEsNuevoPresuTransferencia,clases);
			
			return presutransferenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PresuTransferenciaParameterReturnGeneral procesarEventosPresuTransferenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresuTransferencia> presutransferencias,PresuTransferencia presutransferencia,PresuTransferenciaParameterReturnGeneral presutransferenciaParameterGeneral,Boolean isEsNuevoPresuTransferencia,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTransferencia.class.getSimpleName()+"-procesarEventosPresuTransferenciasWithConnection");connexion.begin();			
			
			PresuTransferenciaParameterReturnGeneral presutransferenciaReturnGeneral=new PresuTransferenciaParameterReturnGeneral();
	
			presutransferenciaReturnGeneral.setPresuTransferencia(presutransferencia);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presutransferenciaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresuTransferenciaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presutransferencias,presutransferencia,presutransferenciaParameterGeneral,presutransferenciaReturnGeneral,isEsNuevoPresuTransferencia,clases);
			
			this.connexion.commit();
			
			return presutransferenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresuTransferenciaParameterReturnGeneral procesarImportacionPresuTransferenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PresuTransferenciaParameterReturnGeneral presutransferenciaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTransferencia.class.getSimpleName()+"-procesarImportacionPresuTransferenciasWithConnection");connexion.begin();			
			
			PresuTransferenciaParameterReturnGeneral presutransferenciaReturnGeneral=new PresuTransferenciaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.presutransferencias=new ArrayList<PresuTransferencia>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.presutransferencia=new PresuTransferencia();
				
				
				if(conColumnasBase) {this.presutransferencia.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.presutransferencia.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.presutransferencia.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.presutransferencia.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
			this.presutransferencia.setdescripcion(arrColumnas[iColumn++]);
				
				this.presutransferencias.add(this.presutransferencia);
			}
			
			this.savePresuTransferencias();
			
			this.connexion.commit();
			
			presutransferenciaReturnGeneral.setConRetornoEstaProcesado(true);
			presutransferenciaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return presutransferenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPresuTransferenciasEliminados() throws Exception {				
		
		List<PresuTransferencia> presutransferenciasAux= new ArrayList<PresuTransferencia>();
		
		for(PresuTransferencia presutransferencia:presutransferencias) {
			if(!presutransferencia.getIsDeleted()) {
				presutransferenciasAux.add(presutransferencia);
			}
		}
		
		presutransferencias=presutransferenciasAux;
	}
	
	public void quitarPresuTransferenciasNulos() throws Exception {				
		
		List<PresuTransferencia> presutransferenciasAux= new ArrayList<PresuTransferencia>();
		
		for(PresuTransferencia presutransferencia : this.presutransferencias) {
			if(presutransferencia==null) {
				presutransferenciasAux.add(presutransferencia);
			}
		}
		
		//this.presutransferencias=presutransferenciasAux;
		
		this.presutransferencias.removeAll(presutransferenciasAux);
	}
	
	public void getSetVersionRowPresuTransferenciaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(presutransferencia.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((presutransferencia.getIsDeleted() || (presutransferencia.getIsChanged()&&!presutransferencia.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=presutransferenciaDataAccess.getSetVersionRowPresuTransferencia(connexion,presutransferencia.getId());
				
				if(!presutransferencia.getVersionRow().equals(timestamp)) {	
					presutransferencia.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				presutransferencia.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPresuTransferencia()throws Exception {	
		
		if(presutransferencia.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((presutransferencia.getIsDeleted() || (presutransferencia.getIsChanged()&&!presutransferencia.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=presutransferenciaDataAccess.getSetVersionRowPresuTransferencia(connexion,presutransferencia.getId());
			
			try {							
				if(!presutransferencia.getVersionRow().equals(timestamp)) {	
					presutransferencia.setVersionRow(timestamp);
				}
				
				presutransferencia.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPresuTransferenciasWithConnection()throws Exception {	
		if(presutransferencias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PresuTransferencia presutransferenciaAux:presutransferencias) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(presutransferenciaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presutransferenciaAux.getIsDeleted() || (presutransferenciaAux.getIsChanged()&&!presutransferenciaAux.getIsNew())) {
						
						timestamp=presutransferenciaDataAccess.getSetVersionRowPresuTransferencia(connexion,presutransferenciaAux.getId());
						
						if(!presutransferencia.getVersionRow().equals(timestamp)) {	
							presutransferenciaAux.setVersionRow(timestamp);
						}
								
						presutransferenciaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPresuTransferencias()throws Exception {	
		if(presutransferencias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PresuTransferencia presutransferenciaAux:presutransferencias) {
					if(presutransferenciaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presutransferenciaAux.getIsDeleted() || (presutransferenciaAux.getIsChanged()&&!presutransferenciaAux.getIsNew())) {
						
						timestamp=presutransferenciaDataAccess.getSetVersionRowPresuTransferencia(connexion,presutransferenciaAux.getId());
						
						if(!presutransferenciaAux.getVersionRow().equals(timestamp)) {	
							presutransferenciaAux.setVersionRow(timestamp);
						}
						
													
						presutransferenciaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PresuTransferenciaParameterReturnGeneral cargarCombosLoteForeignKeyPresuTransferenciaWithConnection(String finalQueryGlobalPresuProyecto,String finalQueryGlobalCuentaContable,String finalQueryGlobalCuentaContableDestino,String finalQueryGlobalEmpleado) throws Exception {
		PresuTransferenciaParameterReturnGeneral  presutransferenciaReturnGeneral =new PresuTransferenciaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTransferencia.class.getSimpleName()+"-cargarCombosLoteForeignKeyPresuTransferenciaWithConnection");connexion.begin();
			
			presutransferenciaReturnGeneral =new PresuTransferenciaParameterReturnGeneral();
			
			

			List<PresuProyecto> presuproyectosForeignKey=new ArrayList<PresuProyecto>();
			PresuProyectoLogic presuproyectoLogic=new PresuProyectoLogic();
			presuproyectoLogic.setConnexion(this.connexion);
			presuproyectoLogic.getPresuProyectoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPresuProyecto.equals("NONE")) {
				presuproyectoLogic.getTodosPresuProyectos(finalQueryGlobalPresuProyecto,new Pagination());
				presuproyectosForeignKey=presuproyectoLogic.getPresuProyectos();
			}

			presutransferenciaReturnGeneral.setpresuproyectosForeignKey(presuproyectosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			presutransferenciaReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<CuentaContable> cuentacontabledestinosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledestinoLogic=new CuentaContableLogic();
			cuentacontabledestinoLogic.setConnexion(this.connexion);
			cuentacontabledestinoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDestino.equals("NONE")) {
				cuentacontabledestinoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDestino,new Pagination());
				cuentacontabledestinosForeignKey=cuentacontabledestinoLogic.getCuentaContables();
			}

			presutransferenciaReturnGeneral.setcuentacontabledestinosForeignKey(cuentacontabledestinosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			presutransferenciaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return presutransferenciaReturnGeneral;
	}
	
	public PresuTransferenciaParameterReturnGeneral cargarCombosLoteForeignKeyPresuTransferencia(String finalQueryGlobalPresuProyecto,String finalQueryGlobalCuentaContable,String finalQueryGlobalCuentaContableDestino,String finalQueryGlobalEmpleado) throws Exception {
		PresuTransferenciaParameterReturnGeneral  presutransferenciaReturnGeneral =new PresuTransferenciaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			presutransferenciaReturnGeneral =new PresuTransferenciaParameterReturnGeneral();
			
			

			List<PresuProyecto> presuproyectosForeignKey=new ArrayList<PresuProyecto>();
			PresuProyectoLogic presuproyectoLogic=new PresuProyectoLogic();
			presuproyectoLogic.setConnexion(this.connexion);
			presuproyectoLogic.getPresuProyectoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPresuProyecto.equals("NONE")) {
				presuproyectoLogic.getTodosPresuProyectos(finalQueryGlobalPresuProyecto,new Pagination());
				presuproyectosForeignKey=presuproyectoLogic.getPresuProyectos();
			}

			presutransferenciaReturnGeneral.setpresuproyectosForeignKey(presuproyectosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			presutransferenciaReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<CuentaContable> cuentacontabledestinosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledestinoLogic=new CuentaContableLogic();
			cuentacontabledestinoLogic.setConnexion(this.connexion);
			cuentacontabledestinoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDestino.equals("NONE")) {
				cuentacontabledestinoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDestino,new Pagination());
				cuentacontabledestinosForeignKey=cuentacontabledestinoLogic.getCuentaContables();
			}

			presutransferenciaReturnGeneral.setcuentacontabledestinosForeignKey(cuentacontabledestinosForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			presutransferenciaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return presutransferenciaReturnGeneral;
	}
	
	
	public void deepLoad(PresuTransferencia presutransferencia,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PresuTransferenciaLogicAdditional.updatePresuTransferenciaToGet(presutransferencia,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presutransferencia.setPresuProyecto(presutransferenciaDataAccess.getPresuProyecto(connexion,presutransferencia));
		presutransferencia.setCuentaContable(presutransferenciaDataAccess.getCuentaContable(connexion,presutransferencia));
		presutransferencia.setCuentaContableDestino(presutransferenciaDataAccess.getCuentaContableDestino(connexion,presutransferencia));
		presutransferencia.setEmpleado(presutransferenciaDataAccess.getEmpleado(connexion,presutransferencia));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuProyecto.class)) {
				presutransferencia.setPresuProyecto(presutransferenciaDataAccess.getPresuProyecto(connexion,presutransferencia));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				presutransferencia.setCuentaContable(presutransferenciaDataAccess.getCuentaContable(connexion,presutransferencia));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				presutransferencia.setCuentaContableDestino(presutransferenciaDataAccess.getCuentaContableDestino(connexion,presutransferencia));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				presutransferencia.setEmpleado(presutransferenciaDataAccess.getEmpleado(connexion,presutransferencia));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuProyecto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presutransferencia.setPresuProyecto(presutransferenciaDataAccess.getPresuProyecto(connexion,presutransferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presutransferencia.setCuentaContable(presutransferenciaDataAccess.getCuentaContable(connexion,presutransferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presutransferencia.setCuentaContableDestino(presutransferenciaDataAccess.getCuentaContableDestino(connexion,presutransferencia));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presutransferencia.setEmpleado(presutransferenciaDataAccess.getEmpleado(connexion,presutransferencia));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presutransferencia.setPresuProyecto(presutransferenciaDataAccess.getPresuProyecto(connexion,presutransferencia));
		PresuProyectoLogic presuproyectoLogic= new PresuProyectoLogic(connexion);
		presuproyectoLogic.deepLoad(presutransferencia.getPresuProyecto(),isDeep,deepLoadType,clases);
				
		presutransferencia.setCuentaContable(presutransferenciaDataAccess.getCuentaContable(connexion,presutransferencia));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(presutransferencia.getCuentaContable(),isDeep,deepLoadType,clases);
				
		presutransferencia.setCuentaContableDestino(presutransferenciaDataAccess.getCuentaContableDestino(connexion,presutransferencia));
		CuentaContableLogic cuentacontabledestinoLogic= new CuentaContableLogic(connexion);
		cuentacontabledestinoLogic.deepLoad(presutransferencia.getCuentaContableDestino(),isDeep,deepLoadType,clases);
				
		presutransferencia.setEmpleado(presutransferenciaDataAccess.getEmpleado(connexion,presutransferencia));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(presutransferencia.getEmpleado(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuProyecto.class)) {
				presutransferencia.setPresuProyecto(presutransferenciaDataAccess.getPresuProyecto(connexion,presutransferencia));
				PresuProyectoLogic presuproyectoLogic= new PresuProyectoLogic(connexion);
				presuproyectoLogic.deepLoad(presutransferencia.getPresuProyecto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				presutransferencia.setCuentaContable(presutransferenciaDataAccess.getCuentaContable(connexion,presutransferencia));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(presutransferencia.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				presutransferencia.setCuentaContableDestino(presutransferenciaDataAccess.getCuentaContableDestino(connexion,presutransferencia));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(presutransferencia.getCuentaContableDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				presutransferencia.setEmpleado(presutransferenciaDataAccess.getEmpleado(connexion,presutransferencia));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(presutransferencia.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PresuProyecto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presutransferencia.setPresuProyecto(presutransferenciaDataAccess.getPresuProyecto(connexion,presutransferencia));
			PresuProyectoLogic presuproyectoLogic= new PresuProyectoLogic(connexion);
			presuproyectoLogic.deepLoad(presutransferencia.getPresuProyecto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presutransferencia.setCuentaContable(presutransferenciaDataAccess.getCuentaContable(connexion,presutransferencia));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(presutransferencia.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presutransferencia.setCuentaContableDestino(presutransferenciaDataAccess.getCuentaContableDestino(connexion,presutransferencia));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(presutransferencia.getCuentaContableDestino(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presutransferencia.setEmpleado(presutransferenciaDataAccess.getEmpleado(connexion,presutransferencia));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(presutransferencia.getEmpleado(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PresuTransferencia presutransferencia,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PresuTransferenciaLogicAdditional.updatePresuTransferenciaToSave(presutransferencia,this.arrDatoGeneral);
			
PresuTransferenciaDataAccess.save(presutransferencia, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PresuProyectoDataAccess.save(presutransferencia.getPresuProyecto(),connexion);

		CuentaContableDataAccess.save(presutransferencia.getCuentaContable(),connexion);

		CuentaContableDataAccess.save(presutransferencia.getCuentaContableDestino(),connexion);

		EmpleadoDataAccess.save(presutransferencia.getEmpleado(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuProyecto.class)) {
				PresuProyectoDataAccess.save(presutransferencia.getPresuProyecto(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(presutransferencia.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(presutransferencia.getCuentaContableDestino(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(presutransferencia.getEmpleado(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PresuProyectoDataAccess.save(presutransferencia.getPresuProyecto(),connexion);
		PresuProyectoLogic presuproyectoLogic= new PresuProyectoLogic(connexion);
		presuproyectoLogic.deepLoad(presutransferencia.getPresuProyecto(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(presutransferencia.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(presutransferencia.getCuentaContable(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(presutransferencia.getCuentaContableDestino(),connexion);
		CuentaContableLogic cuentacontabledestinoLogic= new CuentaContableLogic(connexion);
		cuentacontabledestinoLogic.deepLoad(presutransferencia.getCuentaContableDestino(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(presutransferencia.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(presutransferencia.getEmpleado(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuProyecto.class)) {
				PresuProyectoDataAccess.save(presutransferencia.getPresuProyecto(),connexion);
				PresuProyectoLogic presuproyectoLogic= new PresuProyectoLogic(connexion);
				presuproyectoLogic.deepSave(presutransferencia.getPresuProyecto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(presutransferencia.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(presutransferencia.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(presutransferencia.getCuentaContableDestino(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(presutransferencia.getCuentaContableDestino(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(presutransferencia.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(presutransferencia.getEmpleado(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(PresuTransferencia.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(presutransferencia,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(presutransferencia);
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
			this.deepLoad(this.presutransferencia,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PresuTransferencia.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(presutransferencias!=null) {
				for(PresuTransferencia presutransferencia:presutransferencias) {
					this.deepLoad(presutransferencia,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(presutransferencias);
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
			if(presutransferencias!=null) {
				for(PresuTransferencia presutransferencia:presutransferencias) {
					this.deepLoad(presutransferencia,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(presutransferencias);
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
			this.getNewConnexionToDeep(PresuTransferencia.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(presutransferencia,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PresuTransferencia.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(presutransferencias!=null) {
				for(PresuTransferencia presutransferencia:presutransferencias) {
					this.deepSave(presutransferencia,isDeep,deepLoadType,clases);
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
			if(presutransferencias!=null) {
				for(PresuTransferencia presutransferencia:presutransferencias) {
					this.deepSave(presutransferencia,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPresuTransferenciasFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTransferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,PresuTransferenciaConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presutransferencias=presutransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuTransferenciasFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,PresuTransferenciaConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presutransferencias=presutransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresuTransferenciasFK_IdCuentaContableDestinoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_destino)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTransferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_destino,PresuTransferenciaConstantesFunciones.IDCUENTACONTABLEDESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDestino);

			PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presutransferencias=presutransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuTransferenciasFK_IdCuentaContableDestino(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_destino)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDestino= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDestino.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_destino,PresuTransferenciaConstantesFunciones.IDCUENTACONTABLEDESTINO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDestino);

			PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDestino","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presutransferencias=presutransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresuTransferenciasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTransferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,PresuTransferenciaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presutransferencias=presutransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuTransferenciasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,PresuTransferenciaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presutransferencias=presutransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresuTransferenciasFK_IdPresuProyectoWithConnection(String sFinalQuery,Pagination pagination,Long id_presu_proyecto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTransferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPresuProyecto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPresuProyecto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_presu_proyecto,PresuTransferenciaConstantesFunciones.IDPRESUPROYECTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPresuProyecto);

			PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPresuProyecto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presutransferencias=presutransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuTransferenciasFK_IdPresuProyecto(String sFinalQuery,Pagination pagination,Long id_presu_proyecto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPresuProyecto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPresuProyecto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_presu_proyecto,PresuTransferenciaConstantesFunciones.IDPRESUPROYECTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPresuProyecto);

			PresuTransferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPresuProyecto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presutransferencias=presutransferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(this.presutransferencias);
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
			if(PresuTransferenciaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuTransferenciaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PresuTransferencia presutransferencia,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PresuTransferenciaConstantesFunciones.ISCONAUDITORIA) {
				if(presutransferencia.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuTransferenciaDataAccess.TABLENAME, presutransferencia.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresuTransferenciaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresuTransferenciaLogic.registrarAuditoriaDetallesPresuTransferencia(connexion,presutransferencia,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(presutransferencia.getIsDeleted()) {
					/*if(!presutransferencia.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PresuTransferenciaDataAccess.TABLENAME, presutransferencia.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PresuTransferenciaLogic.registrarAuditoriaDetallesPresuTransferencia(connexion,presutransferencia,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuTransferenciaDataAccess.TABLENAME, presutransferencia.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(presutransferencia.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuTransferenciaDataAccess.TABLENAME, presutransferencia.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresuTransferenciaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresuTransferenciaLogic.registrarAuditoriaDetallesPresuTransferencia(connexion,presutransferencia,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPresuTransferencia(Connexion connexion,PresuTransferencia presutransferencia)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(presutransferencia.getIsNew()||!presutransferencia.getid_presu_proyecto().equals(presutransferencia.getPresuTransferenciaOriginal().getid_presu_proyecto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presutransferencia.getPresuTransferenciaOriginal().getid_presu_proyecto()!=null)
				{
					strValorActual=presutransferencia.getPresuTransferenciaOriginal().getid_presu_proyecto().toString();
				}
				if(presutransferencia.getid_presu_proyecto()!=null)
				{
					strValorNuevo=presutransferencia.getid_presu_proyecto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuTransferenciaConstantesFunciones.IDPRESUPROYECTO,strValorActual,strValorNuevo);
			}	
			
			if(presutransferencia.getIsNew()||!presutransferencia.getid_cuenta_contable().equals(presutransferencia.getPresuTransferenciaOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presutransferencia.getPresuTransferenciaOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=presutransferencia.getPresuTransferenciaOriginal().getid_cuenta_contable().toString();
				}
				if(presutransferencia.getid_cuenta_contable()!=null)
				{
					strValorNuevo=presutransferencia.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuTransferenciaConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(presutransferencia.getIsNew()||!presutransferencia.getid_cuenta_contable_destino().equals(presutransferencia.getPresuTransferenciaOriginal().getid_cuenta_contable_destino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presutransferencia.getPresuTransferenciaOriginal().getid_cuenta_contable_destino()!=null)
				{
					strValorActual=presutransferencia.getPresuTransferenciaOriginal().getid_cuenta_contable_destino().toString();
				}
				if(presutransferencia.getid_cuenta_contable_destino()!=null)
				{
					strValorNuevo=presutransferencia.getid_cuenta_contable_destino().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuTransferenciaConstantesFunciones.IDCUENTACONTABLEDESTINO,strValorActual,strValorNuevo);
			}	
			
			if(presutransferencia.getIsNew()||!presutransferencia.getid_empleado().equals(presutransferencia.getPresuTransferenciaOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presutransferencia.getPresuTransferenciaOriginal().getid_empleado()!=null)
				{
					strValorActual=presutransferencia.getPresuTransferenciaOriginal().getid_empleado().toString();
				}
				if(presutransferencia.getid_empleado()!=null)
				{
					strValorNuevo=presutransferencia.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuTransferenciaConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(presutransferencia.getIsNew()||!presutransferencia.getfecha().equals(presutransferencia.getPresuTransferenciaOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presutransferencia.getPresuTransferenciaOriginal().getfecha()!=null)
				{
					strValorActual=presutransferencia.getPresuTransferenciaOriginal().getfecha().toString();
				}
				if(presutransferencia.getfecha()!=null)
				{
					strValorNuevo=presutransferencia.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuTransferenciaConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(presutransferencia.getIsNew()||!presutransferencia.getvalor().equals(presutransferencia.getPresuTransferenciaOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presutransferencia.getPresuTransferenciaOriginal().getvalor()!=null)
				{
					strValorActual=presutransferencia.getPresuTransferenciaOriginal().getvalor().toString();
				}
				if(presutransferencia.getvalor()!=null)
				{
					strValorNuevo=presutransferencia.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuTransferenciaConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(presutransferencia.getIsNew()||!presutransferencia.getdescripcion().equals(presutransferencia.getPresuTransferenciaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presutransferencia.getPresuTransferenciaOriginal().getdescripcion()!=null)
				{
					strValorActual=presutransferencia.getPresuTransferenciaOriginal().getdescripcion();
				}
				if(presutransferencia.getdescripcion()!=null)
				{
					strValorNuevo=presutransferencia.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuTransferenciaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePresuTransferenciaRelacionesWithConnection(PresuTransferencia presutransferencia) throws Exception {

		if(!presutransferencia.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresuTransferenciaRelacionesBase(presutransferencia,true);
		}
	}

	public void savePresuTransferenciaRelaciones(PresuTransferencia presutransferencia)throws Exception {

		if(!presutransferencia.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresuTransferenciaRelacionesBase(presutransferencia,false);
		}
	}

	public void savePresuTransferenciaRelacionesBase(PresuTransferencia presutransferencia,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PresuTransferencia-saveRelacionesWithConnection");}
	

			this.setPresuTransferencia(presutransferencia);

			if(PresuTransferenciaLogicAdditional.validarSaveRelaciones(presutransferencia,this)) {

				PresuTransferenciaLogicAdditional.updateRelacionesToSave(presutransferencia,this);

				if((presutransferencia.getIsNew()||presutransferencia.getIsChanged())&&!presutransferencia.getIsDeleted()) {
					this.savePresuTransferencia();
					this.savePresuTransferenciaRelacionesDetalles();

				} else if(presutransferencia.getIsDeleted()) {
					this.savePresuTransferenciaRelacionesDetalles();
					this.savePresuTransferencia();
				}

				PresuTransferenciaLogicAdditional.updateRelacionesToSaveAfter(presutransferencia,this);

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
	
	
	private void savePresuTransferenciaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPresuTransferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresuTransferenciaConstantesFunciones.getClassesForeignKeysOfPresuTransferencia(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresuTransferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresuTransferenciaConstantesFunciones.getClassesRelationshipsOfPresuTransferencia(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

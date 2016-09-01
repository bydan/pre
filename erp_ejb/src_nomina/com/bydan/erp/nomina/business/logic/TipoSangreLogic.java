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
import com.bydan.erp.nomina.util.TipoSangreConstantesFunciones;
import com.bydan.erp.nomina.util.TipoSangreParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoSangreParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoSangre;
import com.bydan.erp.nomina.business.logic.TipoSangreLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoSangreLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoSangreLogic.class);
	
	protected TipoSangreDataAccess tiposangreDataAccess; 	
	protected TipoSangre tiposangre;
	protected List<TipoSangre> tiposangres;
	protected Object tiposangreObject;	
	protected List<Object> tiposangresObject;
	
	public static ClassValidator<TipoSangre> tiposangreValidator = new ClassValidator<TipoSangre>(TipoSangre.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoSangreLogicAdditional tiposangreLogicAdditional=null;
	
	public TipoSangreLogicAdditional getTipoSangreLogicAdditional() {
		return this.tiposangreLogicAdditional;
	}
	
	public void setTipoSangreLogicAdditional(TipoSangreLogicAdditional tiposangreLogicAdditional) {
		try {
			this.tiposangreLogicAdditional=tiposangreLogicAdditional;
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
	
	
	
	
	public  TipoSangreLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tiposangreDataAccess = new TipoSangreDataAccess();
			
			this.tiposangres= new ArrayList<TipoSangre>();
			this.tiposangre= new TipoSangre();
			
			this.tiposangreObject=new Object();
			this.tiposangresObject=new ArrayList<Object>();
				
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
			
			this.tiposangreDataAccess.setConnexionType(this.connexionType);
			this.tiposangreDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoSangreLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tiposangreDataAccess = new TipoSangreDataAccess();
			this.tiposangres= new ArrayList<TipoSangre>();
			this.tiposangre= new TipoSangre();
			this.tiposangreObject=new Object();
			this.tiposangresObject=new ArrayList<Object>();
			
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
			
			this.tiposangreDataAccess.setConnexionType(this.connexionType);
			this.tiposangreDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoSangre getTipoSangre() throws Exception {	
		TipoSangreLogicAdditional.checkTipoSangreToGet(tiposangre,this.datosCliente,this.arrDatoGeneral);
		TipoSangreLogicAdditional.updateTipoSangreToGet(tiposangre,this.arrDatoGeneral);
		
		return tiposangre;
	}
		
	public void setTipoSangre(TipoSangre newTipoSangre) {
		this.tiposangre = newTipoSangre;
	}
	
	public TipoSangreDataAccess getTipoSangreDataAccess() {
		return tiposangreDataAccess;
	}
	
	public void setTipoSangreDataAccess(TipoSangreDataAccess newtiposangreDataAccess) {
		this.tiposangreDataAccess = newtiposangreDataAccess;
	}
	
	public List<TipoSangre> getTipoSangres() throws Exception {		
		this.quitarTipoSangresNulos();
		
		TipoSangreLogicAdditional.checkTipoSangreToGets(tiposangres,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoSangre tiposangreLocal: tiposangres ) {
			TipoSangreLogicAdditional.updateTipoSangreToGet(tiposangreLocal,this.arrDatoGeneral);
		}
		
		return tiposangres;
	}
	
	public void setTipoSangres(List<TipoSangre> newTipoSangres) {
		this.tiposangres = newTipoSangres;
	}
	
	public Object getTipoSangreObject() {	
		this.tiposangreObject=this.tiposangreDataAccess.getEntityObject();
		return this.tiposangreObject;
	}
		
	public void setTipoSangreObject(Object newTipoSangreObject) {
		this.tiposangreObject = newTipoSangreObject;
	}
	
	public List<Object> getTipoSangresObject() {		
		this.tiposangresObject=this.tiposangreDataAccess.getEntitiesObject();
		return this.tiposangresObject;
	}
		
	public void setTipoSangresObject(List<Object> newTipoSangresObject) {
		this.tiposangresObject = newTipoSangresObject;
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
		
		if(this.tiposangreDataAccess!=null) {
			this.tiposangreDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSangre.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tiposangreDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tiposangreDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tiposangre = new  TipoSangre();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSangre.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiposangre=tiposangreDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiposangre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoSangreConstantesFunciones.refrescarForeignKeysDescripcionesTipoSangre(this.tiposangre);
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
		tiposangre = new  TipoSangre();
		  		  
        try {
			
			tiposangre=tiposangreDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiposangre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoSangreConstantesFunciones.refrescarForeignKeysDescripcionesTipoSangre(this.tiposangre);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tiposangre = new  TipoSangre();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSangre.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiposangre=tiposangreDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiposangre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoSangreConstantesFunciones.refrescarForeignKeysDescripcionesTipoSangre(this.tiposangre);
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
		tiposangre = new  TipoSangre();
		  		  
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
		tiposangre = new  TipoSangre();
		  		  
        try {
			
			tiposangre=tiposangreDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiposangre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoSangreConstantesFunciones.refrescarForeignKeysDescripcionesTipoSangre(this.tiposangre);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tiposangre = new  TipoSangre();
		  		  
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
		tiposangre = new  TipoSangre();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSangre.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tiposangreDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiposangre = new  TipoSangre();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tiposangreDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiposangre = new  TipoSangre();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSangre.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tiposangreDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiposangre = new  TipoSangre();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tiposangreDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiposangre = new  TipoSangre();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSangre.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tiposangreDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiposangre = new  TipoSangre();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tiposangreDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiposangres = new  ArrayList<TipoSangre>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSangre.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoSangreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposangres=tiposangreDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoSangre(tiposangres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSangreConstantesFunciones.refrescarForeignKeysDescripcionesTipoSangre(this.tiposangres);
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
		tiposangres = new  ArrayList<TipoSangre>();
		  		  
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
		tiposangres = new  ArrayList<TipoSangre>();
		  		  
        try {			
			TipoSangreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposangres=tiposangreDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoSangre(tiposangres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSangreConstantesFunciones.refrescarForeignKeysDescripcionesTipoSangre(this.tiposangres);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tiposangres = new  ArrayList<TipoSangre>();
		  		  
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
		tiposangres = new  ArrayList<TipoSangre>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSangre.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoSangreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposangres=tiposangreDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoSangre(tiposangres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSangreConstantesFunciones.refrescarForeignKeysDescripcionesTipoSangre(this.tiposangres);
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
		tiposangres = new  ArrayList<TipoSangre>();
		  		  
        try {
			TipoSangreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposangres=tiposangreDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoSangre(tiposangres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSangreConstantesFunciones.refrescarForeignKeysDescripcionesTipoSangre(this.tiposangres);
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
		tiposangres = new  ArrayList<TipoSangre>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSangre.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoSangreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposangres=tiposangreDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoSangre(tiposangres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSangreConstantesFunciones.refrescarForeignKeysDescripcionesTipoSangre(this.tiposangres);
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
		tiposangres = new  ArrayList<TipoSangre>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoSangreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposangres=tiposangreDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoSangre(tiposangres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSangreConstantesFunciones.refrescarForeignKeysDescripcionesTipoSangre(this.tiposangres);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tiposangre = new  TipoSangre();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSangre.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoSangreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposangre=tiposangreDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoSangre(tiposangre);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSangreConstantesFunciones.refrescarForeignKeysDescripcionesTipoSangre(this.tiposangre);
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
		tiposangre = new  TipoSangre();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoSangreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposangre=tiposangreDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoSangre(tiposangre);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSangreConstantesFunciones.refrescarForeignKeysDescripcionesTipoSangre(this.tiposangre);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiposangres = new  ArrayList<TipoSangre>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSangre.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoSangreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposangres=tiposangreDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoSangre(tiposangres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSangreConstantesFunciones.refrescarForeignKeysDescripcionesTipoSangre(this.tiposangres);
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
		tiposangres = new  ArrayList<TipoSangre>();
		  		  
        try {
			TipoSangreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposangres=tiposangreDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoSangre(tiposangres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSangreConstantesFunciones.refrescarForeignKeysDescripcionesTipoSangre(this.tiposangres);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoSangresWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tiposangres = new  ArrayList<TipoSangre>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSangre.class.getSimpleName()+"-getTodosTipoSangresWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoSangreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposangres=tiposangreDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoSangre(tiposangres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSangreConstantesFunciones.refrescarForeignKeysDescripcionesTipoSangre(this.tiposangres);
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
	
	public  void  getTodosTipoSangres(String sFinalQuery,Pagination pagination)throws Exception {
		tiposangres = new  ArrayList<TipoSangre>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoSangreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposangres=tiposangreDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoSangre(tiposangres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSangreConstantesFunciones.refrescarForeignKeysDescripcionesTipoSangre(this.tiposangres);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoSangre(TipoSangre tiposangre) throws Exception {
		Boolean estaValidado=false;
		
		if(tiposangre.getIsNew() || tiposangre.getIsChanged()) { 
			this.invalidValues = tiposangreValidator.getInvalidValues(tiposangre);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tiposangre);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoSangre(List<TipoSangre> TipoSangres) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoSangre tiposangreLocal:tiposangres) {				
			estaValidadoObjeto=this.validarGuardarTipoSangre(tiposangreLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoSangre(List<TipoSangre> TipoSangres) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoSangre(tiposangres)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoSangre(TipoSangre TipoSangre) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoSangre(tiposangre)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoSangre tiposangre) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tiposangre.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoSangreConstantesFunciones.getTipoSangreLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tiposangre","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoSangreConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoSangreConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoSangreWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSangre.class.getSimpleName()+"-saveTipoSangreWithConnection");connexion.begin();			
			
			TipoSangreLogicAdditional.checkTipoSangreToSave(this.tiposangre,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoSangreLogicAdditional.updateTipoSangreToSave(this.tiposangre,this.arrDatoGeneral);
			
			TipoSangreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiposangre,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoSangre();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoSangre(this.tiposangre)) {
				TipoSangreDataAccess.save(this.tiposangre, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tiposangre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoSangreLogicAdditional.checkTipoSangreToSaveAfter(this.tiposangre,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoSangre();
			
			connexion.commit();			
			
			if(this.tiposangre.getIsDeleted()) {
				this.tiposangre=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoSangre()throws Exception {	
		try {	
			
			TipoSangreLogicAdditional.checkTipoSangreToSave(this.tiposangre,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoSangreLogicAdditional.updateTipoSangreToSave(this.tiposangre,this.arrDatoGeneral);
			
			TipoSangreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiposangre,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoSangre(this.tiposangre)) {			
				TipoSangreDataAccess.save(this.tiposangre, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tiposangre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoSangreLogicAdditional.checkTipoSangreToSaveAfter(this.tiposangre,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tiposangre.getIsDeleted()) {
				this.tiposangre=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoSangresWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSangre.class.getSimpleName()+"-saveTipoSangresWithConnection");connexion.begin();			
			
			TipoSangreLogicAdditional.checkTipoSangreToSaves(tiposangres,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoSangres();
			
			Boolean validadoTodosTipoSangre=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoSangre tiposangreLocal:tiposangres) {		
				if(tiposangreLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoSangreLogicAdditional.updateTipoSangreToSave(tiposangreLocal,this.arrDatoGeneral);
	        	
				TipoSangreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiposangreLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoSangre(tiposangreLocal)) {
					TipoSangreDataAccess.save(tiposangreLocal, connexion);				
				} else {
					validadoTodosTipoSangre=false;
				}
			}
			
			if(!validadoTodosTipoSangre) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoSangreLogicAdditional.checkTipoSangreToSavesAfter(tiposangres,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoSangres();
			
			connexion.commit();		
			
			this.quitarTipoSangresEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoSangres()throws Exception {				
		 try {	
			TipoSangreLogicAdditional.checkTipoSangreToSaves(tiposangres,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoSangre=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoSangre tiposangreLocal:tiposangres) {				
				if(tiposangreLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoSangreLogicAdditional.updateTipoSangreToSave(tiposangreLocal,this.arrDatoGeneral);
	        	
				TipoSangreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiposangreLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoSangre(tiposangreLocal)) {				
					TipoSangreDataAccess.save(tiposangreLocal, connexion);				
				} else {
					validadoTodosTipoSangre=false;
				}
			}
			
			if(!validadoTodosTipoSangre) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoSangreLogicAdditional.checkTipoSangreToSavesAfter(tiposangres,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoSangresEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoSangreParameterReturnGeneral procesarAccionTipoSangres(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoSangre> tiposangres,TipoSangreParameterReturnGeneral tiposangreParameterGeneral)throws Exception {
		 try {	
			TipoSangreParameterReturnGeneral tiposangreReturnGeneral=new TipoSangreParameterReturnGeneral();
	
			TipoSangreLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiposangres,tiposangreParameterGeneral,tiposangreReturnGeneral);
			
			return tiposangreReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoSangreParameterReturnGeneral procesarAccionTipoSangresWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoSangre> tiposangres,TipoSangreParameterReturnGeneral tiposangreParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSangre.class.getSimpleName()+"-procesarAccionTipoSangresWithConnection");connexion.begin();			
			
			TipoSangreParameterReturnGeneral tiposangreReturnGeneral=new TipoSangreParameterReturnGeneral();
	
			TipoSangreLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiposangres,tiposangreParameterGeneral,tiposangreReturnGeneral);
			
			this.connexion.commit();
			
			return tiposangreReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoSangreParameterReturnGeneral procesarEventosTipoSangres(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoSangre> tiposangres,TipoSangre tiposangre,TipoSangreParameterReturnGeneral tiposangreParameterGeneral,Boolean isEsNuevoTipoSangre,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoSangreParameterReturnGeneral tiposangreReturnGeneral=new TipoSangreParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiposangreReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoSangreLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiposangres,tiposangre,tiposangreParameterGeneral,tiposangreReturnGeneral,isEsNuevoTipoSangre,clases);
			
			return tiposangreReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoSangreParameterReturnGeneral procesarEventosTipoSangresWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoSangre> tiposangres,TipoSangre tiposangre,TipoSangreParameterReturnGeneral tiposangreParameterGeneral,Boolean isEsNuevoTipoSangre,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSangre.class.getSimpleName()+"-procesarEventosTipoSangresWithConnection");connexion.begin();			
			
			TipoSangreParameterReturnGeneral tiposangreReturnGeneral=new TipoSangreParameterReturnGeneral();
	
			tiposangreReturnGeneral.setTipoSangre(tiposangre);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiposangreReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoSangreLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiposangres,tiposangre,tiposangreParameterGeneral,tiposangreReturnGeneral,isEsNuevoTipoSangre,clases);
			
			this.connexion.commit();
			
			return tiposangreReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoSangreParameterReturnGeneral procesarImportacionTipoSangresWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoSangreParameterReturnGeneral tiposangreParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSangre.class.getSimpleName()+"-procesarImportacionTipoSangresWithConnection");connexion.begin();			
			
			TipoSangreParameterReturnGeneral tiposangreReturnGeneral=new TipoSangreParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tiposangres=new ArrayList<TipoSangre>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tiposangre=new TipoSangre();
				
				
				if(conColumnasBase) {this.tiposangre.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tiposangre.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tiposangre.setcodigo(arrColumnas[iColumn++]);
				this.tiposangre.setnombre(arrColumnas[iColumn++]);
				
				this.tiposangres.add(this.tiposangre);
			}
			
			this.saveTipoSangres();
			
			this.connexion.commit();
			
			tiposangreReturnGeneral.setConRetornoEstaProcesado(true);
			tiposangreReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tiposangreReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoSangresEliminados() throws Exception {				
		
		List<TipoSangre> tiposangresAux= new ArrayList<TipoSangre>();
		
		for(TipoSangre tiposangre:tiposangres) {
			if(!tiposangre.getIsDeleted()) {
				tiposangresAux.add(tiposangre);
			}
		}
		
		tiposangres=tiposangresAux;
	}
	
	public void quitarTipoSangresNulos() throws Exception {				
		
		List<TipoSangre> tiposangresAux= new ArrayList<TipoSangre>();
		
		for(TipoSangre tiposangre : this.tiposangres) {
			if(tiposangre==null) {
				tiposangresAux.add(tiposangre);
			}
		}
		
		//this.tiposangres=tiposangresAux;
		
		this.tiposangres.removeAll(tiposangresAux);
	}
	
	public void getSetVersionRowTipoSangreWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tiposangre.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tiposangre.getIsDeleted() || (tiposangre.getIsChanged()&&!tiposangre.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tiposangreDataAccess.getSetVersionRowTipoSangre(connexion,tiposangre.getId());
				
				if(!tiposangre.getVersionRow().equals(timestamp)) {	
					tiposangre.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tiposangre.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoSangre()throws Exception {	
		
		if(tiposangre.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tiposangre.getIsDeleted() || (tiposangre.getIsChanged()&&!tiposangre.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tiposangreDataAccess.getSetVersionRowTipoSangre(connexion,tiposangre.getId());
			
			try {							
				if(!tiposangre.getVersionRow().equals(timestamp)) {	
					tiposangre.setVersionRow(timestamp);
				}
				
				tiposangre.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoSangresWithConnection()throws Exception {	
		if(tiposangres!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoSangre tiposangreAux:tiposangres) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tiposangreAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiposangreAux.getIsDeleted() || (tiposangreAux.getIsChanged()&&!tiposangreAux.getIsNew())) {
						
						timestamp=tiposangreDataAccess.getSetVersionRowTipoSangre(connexion,tiposangreAux.getId());
						
						if(!tiposangre.getVersionRow().equals(timestamp)) {	
							tiposangreAux.setVersionRow(timestamp);
						}
								
						tiposangreAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoSangres()throws Exception {	
		if(tiposangres!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoSangre tiposangreAux:tiposangres) {
					if(tiposangreAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiposangreAux.getIsDeleted() || (tiposangreAux.getIsChanged()&&!tiposangreAux.getIsNew())) {
						
						timestamp=tiposangreDataAccess.getSetVersionRowTipoSangre(connexion,tiposangreAux.getId());
						
						if(!tiposangreAux.getVersionRow().equals(timestamp)) {	
							tiposangreAux.setVersionRow(timestamp);
						}
						
													
						tiposangreAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoSangreParameterReturnGeneral cargarCombosLoteForeignKeyTipoSangreWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoSangreParameterReturnGeneral  tiposangreReturnGeneral =new TipoSangreParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSangre.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoSangreWithConnection");connexion.begin();
			
			tiposangreReturnGeneral =new TipoSangreParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tiposangreReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tiposangreReturnGeneral;
	}
	
	public TipoSangreParameterReturnGeneral cargarCombosLoteForeignKeyTipoSangre(String finalQueryGlobalEmpresa) throws Exception {
		TipoSangreParameterReturnGeneral  tiposangreReturnGeneral =new TipoSangreParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tiposangreReturnGeneral =new TipoSangreParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tiposangreReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tiposangreReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoSangreWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic=new DatoGeneralEmpleadoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSangre.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoSangreWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DatoGeneralEmpleado.class));
											
			

			datogeneralempleadoLogic.setConnexion(this.getConnexion());
			datogeneralempleadoLogic.setDatosCliente(this.datosCliente);
			datogeneralempleadoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoSangre tiposangre:this.tiposangres) {
				

				classes=new ArrayList<Classe>();
				classes=DatoGeneralEmpleadoConstantesFunciones.getClassesForeignKeysOfDatoGeneralEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				datogeneralempleadoLogic.setDatoGeneralEmpleados(tiposangre.datogeneralempleados);
				datogeneralempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoSangre tiposangre,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoSangreLogicAdditional.updateTipoSangreToGet(tiposangre,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiposangre.setEmpresa(tiposangreDataAccess.getEmpresa(connexion,tiposangre));
		tiposangre.setDatoGeneralEmpleados(tiposangreDataAccess.getDatoGeneralEmpleados(connexion,tiposangre));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tiposangre.setEmpresa(tiposangreDataAccess.getEmpresa(connexion,tiposangre));
				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiposangre.setDatoGeneralEmpleados(tiposangreDataAccess.getDatoGeneralEmpleados(connexion,tiposangre));

				if(this.isConDeep) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(this.connexion);
					datogeneralempleadoLogic.setDatoGeneralEmpleados(tiposangre.getDatoGeneralEmpleados());
					ArrayList<Classe> classesLocal=DatoGeneralEmpleadoConstantesFunciones.getClassesForeignKeysOfDatoGeneralEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					datogeneralempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(datogeneralempleadoLogic.getDatoGeneralEmpleados());
					tiposangre.setDatoGeneralEmpleados(datogeneralempleadoLogic.getDatoGeneralEmpleados());
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
			tiposangre.setEmpresa(tiposangreDataAccess.getEmpresa(connexion,tiposangre));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DatoGeneralEmpleado.class));
			tiposangre.setDatoGeneralEmpleados(tiposangreDataAccess.getDatoGeneralEmpleados(connexion,tiposangre));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiposangre.setEmpresa(tiposangreDataAccess.getEmpresa(connexion,tiposangre));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tiposangre.getEmpresa(),isDeep,deepLoadType,clases);
				

		tiposangre.setDatoGeneralEmpleados(tiposangreDataAccess.getDatoGeneralEmpleados(connexion,tiposangre));

		for(DatoGeneralEmpleado datogeneralempleado:tiposangre.getDatoGeneralEmpleados()) {
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
			datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tiposangre.setEmpresa(tiposangreDataAccess.getEmpresa(connexion,tiposangre));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tiposangre.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiposangre.setDatoGeneralEmpleados(tiposangreDataAccess.getDatoGeneralEmpleados(connexion,tiposangre));

				for(DatoGeneralEmpleado datogeneralempleado:tiposangre.getDatoGeneralEmpleados()) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
					datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
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
			tiposangre.setEmpresa(tiposangreDataAccess.getEmpresa(connexion,tiposangre));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tiposangre.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DatoGeneralEmpleado.class));
			tiposangre.setDatoGeneralEmpleados(tiposangreDataAccess.getDatoGeneralEmpleados(connexion,tiposangre));

			for(DatoGeneralEmpleado datogeneralempleado:tiposangre.getDatoGeneralEmpleados()) {
				DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
				datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoSangre tiposangre,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoSangreLogicAdditional.updateTipoSangreToSave(tiposangre,this.arrDatoGeneral);
			
TipoSangreDataAccess.save(tiposangre, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tiposangre.getEmpresa(),connexion);

		for(DatoGeneralEmpleado datogeneralempleado:tiposangre.getDatoGeneralEmpleados()) {
			datogeneralempleado.setid_tipo_sangre(tiposangre.getId());
			DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tiposangre.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DatoGeneralEmpleado datogeneralempleado:tiposangre.getDatoGeneralEmpleados()) {
					datogeneralempleado.setid_tipo_sangre(tiposangre.getId());
					DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tiposangre.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tiposangre.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(DatoGeneralEmpleado datogeneralempleado:tiposangre.getDatoGeneralEmpleados()) {
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
			datogeneralempleado.setid_tipo_sangre(tiposangre.getId());
			DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
			datogeneralempleadoLogic.deepSave(datogeneralempleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tiposangre.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tiposangre.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DatoGeneralEmpleado datogeneralempleado:tiposangre.getDatoGeneralEmpleados()) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
					datogeneralempleado.setid_tipo_sangre(tiposangre.getId());
					DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
					datogeneralempleadoLogic.deepSave(datogeneralempleado,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoSangre.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tiposangre,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoSangreConstantesFunciones.refrescarForeignKeysDescripcionesTipoSangre(tiposangre);
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
			this.deepLoad(this.tiposangre,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoSangreConstantesFunciones.refrescarForeignKeysDescripcionesTipoSangre(this.tiposangre);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoSangre.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tiposangres!=null) {
				for(TipoSangre tiposangre:tiposangres) {
					this.deepLoad(tiposangre,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoSangreConstantesFunciones.refrescarForeignKeysDescripcionesTipoSangre(tiposangres);
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
			if(tiposangres!=null) {
				for(TipoSangre tiposangre:tiposangres) {
					this.deepLoad(tiposangre,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoSangreConstantesFunciones.refrescarForeignKeysDescripcionesTipoSangre(tiposangres);
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
			this.getNewConnexionToDeep(TipoSangre.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tiposangre,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoSangre.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tiposangres!=null) {
				for(TipoSangre tiposangre:tiposangres) {
					this.deepSave(tiposangre,isDeep,deepLoadType,clases);
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
			if(tiposangres!=null) {
				for(TipoSangre tiposangre:tiposangres) {
					this.deepSave(tiposangre,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoSangresFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSangre.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoSangreConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoSangreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiposangres=tiposangreDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoSangreConstantesFunciones.refrescarForeignKeysDescripcionesTipoSangre(this.tiposangres);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoSangresFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoSangreConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoSangreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiposangres=tiposangreDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoSangreConstantesFunciones.refrescarForeignKeysDescripcionesTipoSangre(this.tiposangres);
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
			if(TipoSangreConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoSangreDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoSangre tiposangre,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoSangreConstantesFunciones.ISCONAUDITORIA) {
				if(tiposangre.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoSangreDataAccess.TABLENAME, tiposangre.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoSangreConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoSangreLogic.registrarAuditoriaDetallesTipoSangre(connexion,tiposangre,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tiposangre.getIsDeleted()) {
					/*if(!tiposangre.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoSangreDataAccess.TABLENAME, tiposangre.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoSangreLogic.registrarAuditoriaDetallesTipoSangre(connexion,tiposangre,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoSangreDataAccess.TABLENAME, tiposangre.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tiposangre.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoSangreDataAccess.TABLENAME, tiposangre.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoSangreConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoSangreLogic.registrarAuditoriaDetallesTipoSangre(connexion,tiposangre,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoSangre(Connexion connexion,TipoSangre tiposangre)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tiposangre.getIsNew()||!tiposangre.getid_empresa().equals(tiposangre.getTipoSangreOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiposangre.getTipoSangreOriginal().getid_empresa()!=null)
				{
					strValorActual=tiposangre.getTipoSangreOriginal().getid_empresa().toString();
				}
				if(tiposangre.getid_empresa()!=null)
				{
					strValorNuevo=tiposangre.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoSangreConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tiposangre.getIsNew()||!tiposangre.getcodigo().equals(tiposangre.getTipoSangreOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiposangre.getTipoSangreOriginal().getcodigo()!=null)
				{
					strValorActual=tiposangre.getTipoSangreOriginal().getcodigo();
				}
				if(tiposangre.getcodigo()!=null)
				{
					strValorNuevo=tiposangre.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoSangreConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tiposangre.getIsNew()||!tiposangre.getnombre().equals(tiposangre.getTipoSangreOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiposangre.getTipoSangreOriginal().getnombre()!=null)
				{
					strValorActual=tiposangre.getTipoSangreOriginal().getnombre();
				}
				if(tiposangre.getnombre()!=null)
				{
					strValorNuevo=tiposangre.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoSangreConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoSangreRelacionesWithConnection(TipoSangre tiposangre,List<DatoGeneralEmpleado> datogeneralempleados) throws Exception {

		if(!tiposangre.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoSangreRelacionesBase(tiposangre,datogeneralempleados,true);
		}
	}

	public void saveTipoSangreRelaciones(TipoSangre tiposangre,List<DatoGeneralEmpleado> datogeneralempleados)throws Exception {

		if(!tiposangre.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoSangreRelacionesBase(tiposangre,datogeneralempleados,false);
		}
	}

	public void saveTipoSangreRelacionesBase(TipoSangre tiposangre,List<DatoGeneralEmpleado> datogeneralempleados,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoSangre-saveRelacionesWithConnection");}
	
			tiposangre.setDatoGeneralEmpleados(datogeneralempleados);

			this.setTipoSangre(tiposangre);

			if(TipoSangreLogicAdditional.validarSaveRelaciones(tiposangre,this)) {

				TipoSangreLogicAdditional.updateRelacionesToSave(tiposangre,this);

				if((tiposangre.getIsNew()||tiposangre.getIsChanged())&&!tiposangre.getIsDeleted()) {
					this.saveTipoSangre();
					this.saveTipoSangreRelacionesDetalles(datogeneralempleados);

				} else if(tiposangre.getIsDeleted()) {
					this.saveTipoSangreRelacionesDetalles(datogeneralempleados);
					this.saveTipoSangre();
				}

				TipoSangreLogicAdditional.updateRelacionesToSaveAfter(tiposangre,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DatoGeneralEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresDatoGeneralEmpleados(datogeneralempleados,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoSangreRelacionesDetalles(List<DatoGeneralEmpleado> datogeneralempleados)throws Exception {
		try {
	

			Long idTipoSangreActual=this.getTipoSangre().getId();

			DatoGeneralEmpleadoLogic datogeneralempleadoLogic_Desde_TipoSangre=new DatoGeneralEmpleadoLogic();
			datogeneralempleadoLogic_Desde_TipoSangre.setDatoGeneralEmpleados(datogeneralempleados);

			datogeneralempleadoLogic_Desde_TipoSangre.setConnexion(this.getConnexion());
			datogeneralempleadoLogic_Desde_TipoSangre.setDatosCliente(this.datosCliente);

			for(DatoGeneralEmpleado datogeneralempleado_Desde_TipoSangre:datogeneralempleadoLogic_Desde_TipoSangre.getDatoGeneralEmpleados()) {
				datogeneralempleado_Desde_TipoSangre.setid_tipo_sangre(idTipoSangreActual);
			}

			datogeneralempleadoLogic_Desde_TipoSangre.saveDatoGeneralEmpleados();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoSangre(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoSangreConstantesFunciones.getClassesForeignKeysOfTipoSangre(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoSangre(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoSangreConstantesFunciones.getClassesRelationshipsOfTipoSangre(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

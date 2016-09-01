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
import com.bydan.erp.contabilidad.util.TipoIntervaloConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoIntervaloParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoIntervaloParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.TipoIntervalo;
//import com.bydan.erp.contabilidad.business.logic.TipoIntervaloLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoIntervaloLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoIntervaloLogic.class);
	
	protected TipoIntervaloDataAccess tipointervaloDataAccess; 	
	protected TipoIntervalo tipointervalo;
	protected List<TipoIntervalo> tipointervalos;
	protected Object tipointervaloObject;	
	protected List<Object> tipointervalosObject;
	
	public static ClassValidator<TipoIntervalo> tipointervaloValidator = new ClassValidator<TipoIntervalo>(TipoIntervalo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
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
	
	
	
	
	public  TipoIntervaloLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipointervaloDataAccess = new TipoIntervaloDataAccess();
			
			this.tipointervalos= new ArrayList<TipoIntervalo>();
			this.tipointervalo= new TipoIntervalo();
			
			this.tipointervaloObject=new Object();
			this.tipointervalosObject=new ArrayList<Object>();
				
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
			
			this.tipointervaloDataAccess.setConnexionType(this.connexionType);
			this.tipointervaloDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoIntervaloLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipointervaloDataAccess = new TipoIntervaloDataAccess();
			this.tipointervalos= new ArrayList<TipoIntervalo>();
			this.tipointervalo= new TipoIntervalo();
			this.tipointervaloObject=new Object();
			this.tipointervalosObject=new ArrayList<Object>();
			
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
			
			this.tipointervaloDataAccess.setConnexionType(this.connexionType);
			this.tipointervaloDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoIntervalo getTipoIntervalo() throws Exception {	
		//TipoIntervaloLogicAdditional.checkTipoIntervaloToGet(tipointervalo,this.datosCliente,this.arrDatoGeneral);
		//TipoIntervaloLogicAdditional.updateTipoIntervaloToGet(tipointervalo,this.arrDatoGeneral);
		
		return tipointervalo;
	}
		
	public void setTipoIntervalo(TipoIntervalo newTipoIntervalo) {
		this.tipointervalo = newTipoIntervalo;
	}
	
	public TipoIntervaloDataAccess getTipoIntervaloDataAccess() {
		return tipointervaloDataAccess;
	}
	
	public void setTipoIntervaloDataAccess(TipoIntervaloDataAccess newtipointervaloDataAccess) {
		this.tipointervaloDataAccess = newtipointervaloDataAccess;
	}
	
	public List<TipoIntervalo> getTipoIntervalos() throws Exception {		
		this.quitarTipoIntervalosNulos();
		
		//TipoIntervaloLogicAdditional.checkTipoIntervaloToGets(tipointervalos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoIntervalo tipointervaloLocal: tipointervalos ) {
			//TipoIntervaloLogicAdditional.updateTipoIntervaloToGet(tipointervaloLocal,this.arrDatoGeneral);
		}
		
		return tipointervalos;
	}
	
	public void setTipoIntervalos(List<TipoIntervalo> newTipoIntervalos) {
		this.tipointervalos = newTipoIntervalos;
	}
	
	public Object getTipoIntervaloObject() {	
		this.tipointervaloObject=this.tipointervaloDataAccess.getEntityObject();
		return this.tipointervaloObject;
	}
		
	public void setTipoIntervaloObject(Object newTipoIntervaloObject) {
		this.tipointervaloObject = newTipoIntervaloObject;
	}
	
	public List<Object> getTipoIntervalosObject() {		
		this.tipointervalosObject=this.tipointervaloDataAccess.getEntitiesObject();
		return this.tipointervalosObject;
	}
		
	public void setTipoIntervalosObject(List<Object> newTipoIntervalosObject) {
		this.tipointervalosObject = newTipoIntervalosObject;
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
		
		if(this.tipointervaloDataAccess!=null) {
			this.tipointervaloDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIntervalo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipointervaloDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipointervaloDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipointervalo = new  TipoIntervalo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIntervalo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipointervalo=tipointervaloDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipointervalo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoIntervaloConstantesFunciones.refrescarForeignKeysDescripcionesTipoIntervalo(this.tipointervalo);
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
		tipointervalo = new  TipoIntervalo();
		  		  
        try {
			
			tipointervalo=tipointervaloDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipointervalo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoIntervaloConstantesFunciones.refrescarForeignKeysDescripcionesTipoIntervalo(this.tipointervalo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipointervalo = new  TipoIntervalo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIntervalo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipointervalo=tipointervaloDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipointervalo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoIntervaloConstantesFunciones.refrescarForeignKeysDescripcionesTipoIntervalo(this.tipointervalo);
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
		tipointervalo = new  TipoIntervalo();
		  		  
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
		tipointervalo = new  TipoIntervalo();
		  		  
        try {
			
			tipointervalo=tipointervaloDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipointervalo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoIntervaloConstantesFunciones.refrescarForeignKeysDescripcionesTipoIntervalo(this.tipointervalo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipointervalo = new  TipoIntervalo();
		  		  
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
		tipointervalo = new  TipoIntervalo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIntervalo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipointervaloDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipointervalo = new  TipoIntervalo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipointervaloDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipointervalo = new  TipoIntervalo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIntervalo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipointervaloDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipointervalo = new  TipoIntervalo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipointervaloDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipointervalo = new  TipoIntervalo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIntervalo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipointervaloDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipointervalo = new  TipoIntervalo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipointervaloDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipointervalos = new  ArrayList<TipoIntervalo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIntervalo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoIntervaloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipointervalos=tipointervaloDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoIntervalo(tipointervalos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIntervaloConstantesFunciones.refrescarForeignKeysDescripcionesTipoIntervalo(this.tipointervalos);
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
		tipointervalos = new  ArrayList<TipoIntervalo>();
		  		  
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
		tipointervalos = new  ArrayList<TipoIntervalo>();
		  		  
        try {			
			TipoIntervaloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipointervalos=tipointervaloDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoIntervalo(tipointervalos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIntervaloConstantesFunciones.refrescarForeignKeysDescripcionesTipoIntervalo(this.tipointervalos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipointervalos = new  ArrayList<TipoIntervalo>();
		  		  
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
		tipointervalos = new  ArrayList<TipoIntervalo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIntervalo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoIntervaloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipointervalos=tipointervaloDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoIntervalo(tipointervalos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIntervaloConstantesFunciones.refrescarForeignKeysDescripcionesTipoIntervalo(this.tipointervalos);
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
		tipointervalos = new  ArrayList<TipoIntervalo>();
		  		  
        try {
			TipoIntervaloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipointervalos=tipointervaloDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoIntervalo(tipointervalos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIntervaloConstantesFunciones.refrescarForeignKeysDescripcionesTipoIntervalo(this.tipointervalos);
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
		tipointervalos = new  ArrayList<TipoIntervalo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIntervalo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIntervaloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipointervalos=tipointervaloDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoIntervalo(tipointervalos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIntervaloConstantesFunciones.refrescarForeignKeysDescripcionesTipoIntervalo(this.tipointervalos);
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
		tipointervalos = new  ArrayList<TipoIntervalo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIntervaloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipointervalos=tipointervaloDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoIntervalo(tipointervalos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIntervaloConstantesFunciones.refrescarForeignKeysDescripcionesTipoIntervalo(this.tipointervalos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipointervalo = new  TipoIntervalo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIntervalo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIntervaloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipointervalo=tipointervaloDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoIntervalo(tipointervalo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIntervaloConstantesFunciones.refrescarForeignKeysDescripcionesTipoIntervalo(this.tipointervalo);
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
		tipointervalo = new  TipoIntervalo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIntervaloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipointervalo=tipointervaloDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoIntervalo(tipointervalo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIntervaloConstantesFunciones.refrescarForeignKeysDescripcionesTipoIntervalo(this.tipointervalo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoIntervalosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipointervalos = new  ArrayList<TipoIntervalo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIntervalo.class.getSimpleName()+"-getTodosTipoIntervalosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIntervaloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipointervalos=tipointervaloDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoIntervalo(tipointervalos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIntervaloConstantesFunciones.refrescarForeignKeysDescripcionesTipoIntervalo(this.tipointervalos);
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
	
	public  void  getTodosTipoIntervalos(String sFinalQuery,Pagination pagination)throws Exception {
		tipointervalos = new  ArrayList<TipoIntervalo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIntervaloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipointervalos=tipointervaloDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoIntervalo(tipointervalos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIntervaloConstantesFunciones.refrescarForeignKeysDescripcionesTipoIntervalo(this.tipointervalos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoIntervalo(TipoIntervalo tipointervalo) throws Exception {
		Boolean estaValidado=false;
		
		if(tipointervalo.getIsNew() || tipointervalo.getIsChanged()) { 
			this.invalidValues = tipointervaloValidator.getInvalidValues(tipointervalo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipointervalo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoIntervalo(List<TipoIntervalo> TipoIntervalos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoIntervalo tipointervaloLocal:tipointervalos) {				
			estaValidadoObjeto=this.validarGuardarTipoIntervalo(tipointervaloLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoIntervalo(List<TipoIntervalo> TipoIntervalos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoIntervalo(tipointervalos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoIntervalo(TipoIntervalo TipoIntervalo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoIntervalo(tipointervalo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoIntervalo tipointervalo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipointervalo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoIntervaloConstantesFunciones.getTipoIntervaloLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipointervalo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoIntervaloConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoIntervaloConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoIntervaloWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIntervalo.class.getSimpleName()+"-saveTipoIntervaloWithConnection");connexion.begin();			
			
			//TipoIntervaloLogicAdditional.checkTipoIntervaloToSave(this.tipointervalo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoIntervaloLogicAdditional.updateTipoIntervaloToSave(this.tipointervalo,this.arrDatoGeneral);
			
			TipoIntervaloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipointervalo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoIntervalo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoIntervalo(this.tipointervalo)) {
				TipoIntervaloDataAccess.save(this.tipointervalo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipointervalo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoIntervaloLogicAdditional.checkTipoIntervaloToSaveAfter(this.tipointervalo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoIntervalo();
			
			connexion.commit();			
			
			if(this.tipointervalo.getIsDeleted()) {
				this.tipointervalo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoIntervalo()throws Exception {	
		try {	
			
			//TipoIntervaloLogicAdditional.checkTipoIntervaloToSave(this.tipointervalo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoIntervaloLogicAdditional.updateTipoIntervaloToSave(this.tipointervalo,this.arrDatoGeneral);
			
			TipoIntervaloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipointervalo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoIntervalo(this.tipointervalo)) {			
				TipoIntervaloDataAccess.save(this.tipointervalo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipointervalo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoIntervaloLogicAdditional.checkTipoIntervaloToSaveAfter(this.tipointervalo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipointervalo.getIsDeleted()) {
				this.tipointervalo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoIntervalosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIntervalo.class.getSimpleName()+"-saveTipoIntervalosWithConnection");connexion.begin();			
			
			//TipoIntervaloLogicAdditional.checkTipoIntervaloToSaves(tipointervalos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoIntervalos();
			
			Boolean validadoTodosTipoIntervalo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoIntervalo tipointervaloLocal:tipointervalos) {		
				if(tipointervaloLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoIntervaloLogicAdditional.updateTipoIntervaloToSave(tipointervaloLocal,this.arrDatoGeneral);
	        	
				TipoIntervaloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipointervaloLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoIntervalo(tipointervaloLocal)) {
					TipoIntervaloDataAccess.save(tipointervaloLocal, connexion);				
				} else {
					validadoTodosTipoIntervalo=false;
				}
			}
			
			if(!validadoTodosTipoIntervalo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoIntervaloLogicAdditional.checkTipoIntervaloToSavesAfter(tipointervalos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoIntervalos();
			
			connexion.commit();		
			
			this.quitarTipoIntervalosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoIntervalos()throws Exception {				
		 try {	
			//TipoIntervaloLogicAdditional.checkTipoIntervaloToSaves(tipointervalos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoIntervalo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoIntervalo tipointervaloLocal:tipointervalos) {				
				if(tipointervaloLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoIntervaloLogicAdditional.updateTipoIntervaloToSave(tipointervaloLocal,this.arrDatoGeneral);
	        	
				TipoIntervaloLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipointervaloLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoIntervalo(tipointervaloLocal)) {				
					TipoIntervaloDataAccess.save(tipointervaloLocal, connexion);				
				} else {
					validadoTodosTipoIntervalo=false;
				}
			}
			
			if(!validadoTodosTipoIntervalo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoIntervaloLogicAdditional.checkTipoIntervaloToSavesAfter(tipointervalos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoIntervalosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoIntervaloParameterReturnGeneral procesarAccionTipoIntervalos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoIntervalo> tipointervalos,TipoIntervaloParameterReturnGeneral tipointervaloParameterGeneral)throws Exception {
		 try {	
			TipoIntervaloParameterReturnGeneral tipointervaloReturnGeneral=new TipoIntervaloParameterReturnGeneral();
	
			
			return tipointervaloReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoIntervaloParameterReturnGeneral procesarAccionTipoIntervalosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoIntervalo> tipointervalos,TipoIntervaloParameterReturnGeneral tipointervaloParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIntervalo.class.getSimpleName()+"-procesarAccionTipoIntervalosWithConnection");connexion.begin();			
			
			TipoIntervaloParameterReturnGeneral tipointervaloReturnGeneral=new TipoIntervaloParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipointervaloReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoIntervaloParameterReturnGeneral procesarEventosTipoIntervalos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoIntervalo> tipointervalos,TipoIntervalo tipointervalo,TipoIntervaloParameterReturnGeneral tipointervaloParameterGeneral,Boolean isEsNuevoTipoIntervalo,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoIntervaloParameterReturnGeneral tipointervaloReturnGeneral=new TipoIntervaloParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipointervaloReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipointervaloReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoIntervaloParameterReturnGeneral procesarEventosTipoIntervalosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoIntervalo> tipointervalos,TipoIntervalo tipointervalo,TipoIntervaloParameterReturnGeneral tipointervaloParameterGeneral,Boolean isEsNuevoTipoIntervalo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIntervalo.class.getSimpleName()+"-procesarEventosTipoIntervalosWithConnection");connexion.begin();			
			
			TipoIntervaloParameterReturnGeneral tipointervaloReturnGeneral=new TipoIntervaloParameterReturnGeneral();
	
			tipointervaloReturnGeneral.setTipoIntervalo(tipointervalo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipointervaloReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipointervaloReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoIntervaloParameterReturnGeneral procesarImportacionTipoIntervalosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoIntervaloParameterReturnGeneral tipointervaloParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIntervalo.class.getSimpleName()+"-procesarImportacionTipoIntervalosWithConnection");connexion.begin();			
			
			TipoIntervaloParameterReturnGeneral tipointervaloReturnGeneral=new TipoIntervaloParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipointervalos=new ArrayList<TipoIntervalo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipointervalo=new TipoIntervalo();
				
				
				if(conColumnasBase) {this.tipointervalo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipointervalo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipointervalo.setnombre(arrColumnas[iColumn++]);
				
				this.tipointervalos.add(this.tipointervalo);
			}
			
			this.saveTipoIntervalos();
			
			this.connexion.commit();
			
			tipointervaloReturnGeneral.setConRetornoEstaProcesado(true);
			tipointervaloReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipointervaloReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoIntervalosEliminados() throws Exception {				
		
		List<TipoIntervalo> tipointervalosAux= new ArrayList<TipoIntervalo>();
		
		for(TipoIntervalo tipointervalo:tipointervalos) {
			if(!tipointervalo.getIsDeleted()) {
				tipointervalosAux.add(tipointervalo);
			}
		}
		
		tipointervalos=tipointervalosAux;
	}
	
	public void quitarTipoIntervalosNulos() throws Exception {				
		
		List<TipoIntervalo> tipointervalosAux= new ArrayList<TipoIntervalo>();
		
		for(TipoIntervalo tipointervalo : this.tipointervalos) {
			if(tipointervalo==null) {
				tipointervalosAux.add(tipointervalo);
			}
		}
		
		//this.tipointervalos=tipointervalosAux;
		
		this.tipointervalos.removeAll(tipointervalosAux);
	}
	
	public void getSetVersionRowTipoIntervaloWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipointervalo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipointervalo.getIsDeleted() || (tipointervalo.getIsChanged()&&!tipointervalo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipointervaloDataAccess.getSetVersionRowTipoIntervalo(connexion,tipointervalo.getId());
				
				if(!tipointervalo.getVersionRow().equals(timestamp)) {	
					tipointervalo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipointervalo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoIntervalo()throws Exception {	
		
		if(tipointervalo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipointervalo.getIsDeleted() || (tipointervalo.getIsChanged()&&!tipointervalo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipointervaloDataAccess.getSetVersionRowTipoIntervalo(connexion,tipointervalo.getId());
			
			try {							
				if(!tipointervalo.getVersionRow().equals(timestamp)) {	
					tipointervalo.setVersionRow(timestamp);
				}
				
				tipointervalo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoIntervalosWithConnection()throws Exception {	
		if(tipointervalos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoIntervalo tipointervaloAux:tipointervalos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipointervaloAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipointervaloAux.getIsDeleted() || (tipointervaloAux.getIsChanged()&&!tipointervaloAux.getIsNew())) {
						
						timestamp=tipointervaloDataAccess.getSetVersionRowTipoIntervalo(connexion,tipointervaloAux.getId());
						
						if(!tipointervalo.getVersionRow().equals(timestamp)) {	
							tipointervaloAux.setVersionRow(timestamp);
						}
								
						tipointervaloAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoIntervalos()throws Exception {	
		if(tipointervalos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoIntervalo tipointervaloAux:tipointervalos) {
					if(tipointervaloAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipointervaloAux.getIsDeleted() || (tipointervaloAux.getIsChanged()&&!tipointervaloAux.getIsNew())) {
						
						timestamp=tipointervaloDataAccess.getSetVersionRowTipoIntervalo(connexion,tipointervaloAux.getId());
						
						if(!tipointervaloAux.getVersionRow().equals(timestamp)) {	
							tipointervaloAux.setVersionRow(timestamp);
						}
						
													
						tipointervaloAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoIntervaloWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ParametroContabilidadDefectoLogic parametrocontabilidaddefectoLogic=new ParametroContabilidadDefectoLogic();
			TablaAmortiDetalleLogic tablaamortidetalleLogic=new TablaAmortiDetalleLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIntervalo.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoIntervaloWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ParametroContabilidadDefecto.class));
			classes.add(new Classe(TablaAmortiDetalle.class));
											
			

			parametrocontabilidaddefectoLogic.setConnexion(this.getConnexion());
			parametrocontabilidaddefectoLogic.setDatosCliente(this.datosCliente);
			parametrocontabilidaddefectoLogic.setIsConRefrescarForeignKeys(true);

			tablaamortidetalleLogic.setConnexion(this.getConnexion());
			tablaamortidetalleLogic.setDatosCliente(this.datosCliente);
			tablaamortidetalleLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoIntervalo tipointervalo:this.tipointervalos) {
				

				classes=new ArrayList<Classe>();
				classes=ParametroContabilidadDefectoConstantesFunciones.getClassesForeignKeysOfParametroContabilidadDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametrocontabilidaddefectoLogic.setParametroContabilidadDefectos(tipointervalo.parametrocontabilidaddefectos);
				parametrocontabilidaddefectoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=TablaAmortiDetalleConstantesFunciones.getClassesForeignKeysOfTablaAmortiDetalle(new ArrayList<Classe>(),DeepLoadType.NONE);

				tablaamortidetalleLogic.setTablaAmortiDetalles(tipointervalo.tablaamortidetalles);
				tablaamortidetalleLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoIntervalo tipointervalo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoIntervaloLogicAdditional.updateTipoIntervaloToGet(tipointervalo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipointervalo.setParametroContabilidadDefectos(tipointervaloDataAccess.getParametroContabilidadDefectos(connexion,tipointervalo));
		tipointervalo.setTablaAmortiDetalles(tipointervaloDataAccess.getTablaAmortiDetalles(connexion,tipointervalo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroContabilidadDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipointervalo.setParametroContabilidadDefectos(tipointervaloDataAccess.getParametroContabilidadDefectos(connexion,tipointervalo));

				if(this.isConDeep) {
					ParametroContabilidadDefectoLogic parametrocontabilidaddefectoLogic= new ParametroContabilidadDefectoLogic(this.connexion);
					parametrocontabilidaddefectoLogic.setParametroContabilidadDefectos(tipointervalo.getParametroContabilidadDefectos());
					ArrayList<Classe> classesLocal=ParametroContabilidadDefectoConstantesFunciones.getClassesForeignKeysOfParametroContabilidadDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametrocontabilidaddefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroContabilidadDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroContabilidadDefecto(parametrocontabilidaddefectoLogic.getParametroContabilidadDefectos());
					tipointervalo.setParametroContabilidadDefectos(parametrocontabilidaddefectoLogic.getParametroContabilidadDefectos());
				}

				continue;
			}

			if(clas.clas.equals(TablaAmortiDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipointervalo.setTablaAmortiDetalles(tipointervaloDataAccess.getTablaAmortiDetalles(connexion,tipointervalo));

				if(this.isConDeep) {
					TablaAmortiDetalleLogic tablaamortidetalleLogic= new TablaAmortiDetalleLogic(this.connexion);
					tablaamortidetalleLogic.setTablaAmortiDetalles(tipointervalo.getTablaAmortiDetalles());
					ArrayList<Classe> classesLocal=TablaAmortiDetalleConstantesFunciones.getClassesForeignKeysOfTablaAmortiDetalle(new ArrayList<Classe>(),DeepLoadType.NONE);
					tablaamortidetalleLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TablaAmortiDetalleConstantesFunciones.refrescarForeignKeysDescripcionesTablaAmortiDetalle(tablaamortidetalleLogic.getTablaAmortiDetalles());
					tipointervalo.setTablaAmortiDetalles(tablaamortidetalleLogic.getTablaAmortiDetalles());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroContabilidadDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroContabilidadDefecto.class));
			tipointervalo.setParametroContabilidadDefectos(tipointervaloDataAccess.getParametroContabilidadDefectos(connexion,tipointervalo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TablaAmortiDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TablaAmortiDetalle.class));
			tipointervalo.setTablaAmortiDetalles(tipointervaloDataAccess.getTablaAmortiDetalles(connexion,tipointervalo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipointervalo.setParametroContabilidadDefectos(tipointervaloDataAccess.getParametroContabilidadDefectos(connexion,tipointervalo));

		for(ParametroContabilidadDefecto parametrocontabilidaddefecto:tipointervalo.getParametroContabilidadDefectos()) {
			ParametroContabilidadDefectoLogic parametrocontabilidaddefectoLogic= new ParametroContabilidadDefectoLogic(connexion);
			parametrocontabilidaddefectoLogic.deepLoad(parametrocontabilidaddefecto,isDeep,deepLoadType,clases);
		}

		tipointervalo.setTablaAmortiDetalles(tipointervaloDataAccess.getTablaAmortiDetalles(connexion,tipointervalo));

		for(TablaAmortiDetalle tablaamortidetalle:tipointervalo.getTablaAmortiDetalles()) {
			TablaAmortiDetalleLogic tablaamortidetalleLogic= new TablaAmortiDetalleLogic(connexion);
			tablaamortidetalleLogic.deepLoad(tablaamortidetalle,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroContabilidadDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipointervalo.setParametroContabilidadDefectos(tipointervaloDataAccess.getParametroContabilidadDefectos(connexion,tipointervalo));

				for(ParametroContabilidadDefecto parametrocontabilidaddefecto:tipointervalo.getParametroContabilidadDefectos()) {
					ParametroContabilidadDefectoLogic parametrocontabilidaddefectoLogic= new ParametroContabilidadDefectoLogic(connexion);
					parametrocontabilidaddefectoLogic.deepLoad(parametrocontabilidaddefecto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TablaAmortiDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipointervalo.setTablaAmortiDetalles(tipointervaloDataAccess.getTablaAmortiDetalles(connexion,tipointervalo));

				for(TablaAmortiDetalle tablaamortidetalle:tipointervalo.getTablaAmortiDetalles()) {
					TablaAmortiDetalleLogic tablaamortidetalleLogic= new TablaAmortiDetalleLogic(connexion);
					tablaamortidetalleLogic.deepLoad(tablaamortidetalle,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroContabilidadDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroContabilidadDefecto.class));
			tipointervalo.setParametroContabilidadDefectos(tipointervaloDataAccess.getParametroContabilidadDefectos(connexion,tipointervalo));

			for(ParametroContabilidadDefecto parametrocontabilidaddefecto:tipointervalo.getParametroContabilidadDefectos()) {
				ParametroContabilidadDefectoLogic parametrocontabilidaddefectoLogic= new ParametroContabilidadDefectoLogic(connexion);
				parametrocontabilidaddefectoLogic.deepLoad(parametrocontabilidaddefecto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TablaAmortiDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TablaAmortiDetalle.class));
			tipointervalo.setTablaAmortiDetalles(tipointervaloDataAccess.getTablaAmortiDetalles(connexion,tipointervalo));

			for(TablaAmortiDetalle tablaamortidetalle:tipointervalo.getTablaAmortiDetalles()) {
				TablaAmortiDetalleLogic tablaamortidetalleLogic= new TablaAmortiDetalleLogic(connexion);
				tablaamortidetalleLogic.deepLoad(tablaamortidetalle,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoIntervalo tipointervalo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoIntervalo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipointervalo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoIntervaloConstantesFunciones.refrescarForeignKeysDescripcionesTipoIntervalo(tipointervalo);
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
			this.deepLoad(this.tipointervalo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoIntervaloConstantesFunciones.refrescarForeignKeysDescripcionesTipoIntervalo(this.tipointervalo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoIntervalo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipointervalos!=null) {
				for(TipoIntervalo tipointervalo:tipointervalos) {
					this.deepLoad(tipointervalo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoIntervaloConstantesFunciones.refrescarForeignKeysDescripcionesTipoIntervalo(tipointervalos);
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
			if(tipointervalos!=null) {
				for(TipoIntervalo tipointervalo:tipointervalos) {
					this.deepLoad(tipointervalo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoIntervaloConstantesFunciones.refrescarForeignKeysDescripcionesTipoIntervalo(tipointervalos);
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
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoIntervaloPorNombreWithConnection(String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIntervalo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoIntervaloConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipointervalo=tipointervaloDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipointervalo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoIntervaloConstantesFunciones.refrescarForeignKeysDescripcionesTipoIntervalo(this.tipointervalo);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoIntervaloPorNombre(String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoIntervaloConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipointervalo=tipointervaloDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipointervalo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoIntervaloConstantesFunciones.refrescarForeignKeysDescripcionesTipoIntervalo(this.tipointervalo);
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
			if(TipoIntervaloConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoIntervaloDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoIntervalo tipointervalo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoIntervaloConstantesFunciones.ISCONAUDITORIA) {
				if(tipointervalo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoIntervaloDataAccess.TABLENAME, tipointervalo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoIntervaloConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoIntervaloLogic.registrarAuditoriaDetallesTipoIntervalo(connexion,tipointervalo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipointervalo.getIsDeleted()) {
					/*if(!tipointervalo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoIntervaloDataAccess.TABLENAME, tipointervalo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoIntervaloLogic.registrarAuditoriaDetallesTipoIntervalo(connexion,tipointervalo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoIntervaloDataAccess.TABLENAME, tipointervalo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipointervalo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoIntervaloDataAccess.TABLENAME, tipointervalo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoIntervaloConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoIntervaloLogic.registrarAuditoriaDetallesTipoIntervalo(connexion,tipointervalo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoIntervalo(Connexion connexion,TipoIntervalo tipointervalo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipointervalo.getIsNew()||!tipointervalo.getnombre().equals(tipointervalo.getTipoIntervaloOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipointervalo.getTipoIntervaloOriginal().getnombre()!=null)
				{
					strValorActual=tipointervalo.getTipoIntervaloOriginal().getnombre();
				}
				if(tipointervalo.getnombre()!=null)
				{
					strValorNuevo=tipointervalo.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoIntervaloConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoIntervalo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoIntervaloConstantesFunciones.getClassesForeignKeysOfTipoIntervalo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoIntervalo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoIntervaloConstantesFunciones.getClassesRelationshipsOfTipoIntervalo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

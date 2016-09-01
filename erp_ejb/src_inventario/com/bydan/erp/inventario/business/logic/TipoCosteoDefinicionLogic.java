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
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.util.TipoCosteoDefinicionConstantesFunciones;
import com.bydan.erp.inventario.util.TipoCosteoDefinicionParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoCosteoDefinicionParameterGeneral;
import com.bydan.erp.inventario.business.entity.TipoCosteoDefinicion;
//import com.bydan.erp.inventario.business.logic.TipoCosteoDefinicionLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoCosteoDefinicionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoCosteoDefinicionLogic.class);
	
	protected TipoCosteoDefinicionDataAccess tipocosteodefinicionDataAccess; 	
	protected TipoCosteoDefinicion tipocosteodefinicion;
	protected List<TipoCosteoDefinicion> tipocosteodefinicions;
	protected Object tipocosteodefinicionObject;	
	protected List<Object> tipocosteodefinicionsObject;
	
	public static ClassValidator<TipoCosteoDefinicion> tipocosteodefinicionValidator = new ClassValidator<TipoCosteoDefinicion>(TipoCosteoDefinicion.class);	
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
	
	
	
	
	public  TipoCosteoDefinicionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipocosteodefinicionDataAccess = new TipoCosteoDefinicionDataAccess();
			
			this.tipocosteodefinicions= new ArrayList<TipoCosteoDefinicion>();
			this.tipocosteodefinicion= new TipoCosteoDefinicion();
			
			this.tipocosteodefinicionObject=new Object();
			this.tipocosteodefinicionsObject=new ArrayList<Object>();
				
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
			
			this.tipocosteodefinicionDataAccess.setConnexionType(this.connexionType);
			this.tipocosteodefinicionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoCosteoDefinicionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipocosteodefinicionDataAccess = new TipoCosteoDefinicionDataAccess();
			this.tipocosteodefinicions= new ArrayList<TipoCosteoDefinicion>();
			this.tipocosteodefinicion= new TipoCosteoDefinicion();
			this.tipocosteodefinicionObject=new Object();
			this.tipocosteodefinicionsObject=new ArrayList<Object>();
			
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
			
			this.tipocosteodefinicionDataAccess.setConnexionType(this.connexionType);
			this.tipocosteodefinicionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoCosteoDefinicion getTipoCosteoDefinicion() throws Exception {	
		//TipoCosteoDefinicionLogicAdditional.checkTipoCosteoDefinicionToGet(tipocosteodefinicion,this.datosCliente,this.arrDatoGeneral);
		//TipoCosteoDefinicionLogicAdditional.updateTipoCosteoDefinicionToGet(tipocosteodefinicion,this.arrDatoGeneral);
		
		return tipocosteodefinicion;
	}
		
	public void setTipoCosteoDefinicion(TipoCosteoDefinicion newTipoCosteoDefinicion) {
		this.tipocosteodefinicion = newTipoCosteoDefinicion;
	}
	
	public TipoCosteoDefinicionDataAccess getTipoCosteoDefinicionDataAccess() {
		return tipocosteodefinicionDataAccess;
	}
	
	public void setTipoCosteoDefinicionDataAccess(TipoCosteoDefinicionDataAccess newtipocosteodefinicionDataAccess) {
		this.tipocosteodefinicionDataAccess = newtipocosteodefinicionDataAccess;
	}
	
	public List<TipoCosteoDefinicion> getTipoCosteoDefinicions() throws Exception {		
		this.quitarTipoCosteoDefinicionsNulos();
		
		//TipoCosteoDefinicionLogicAdditional.checkTipoCosteoDefinicionToGets(tipocosteodefinicions,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoCosteoDefinicion tipocosteodefinicionLocal: tipocosteodefinicions ) {
			//TipoCosteoDefinicionLogicAdditional.updateTipoCosteoDefinicionToGet(tipocosteodefinicionLocal,this.arrDatoGeneral);
		}
		
		return tipocosteodefinicions;
	}
	
	public void setTipoCosteoDefinicions(List<TipoCosteoDefinicion> newTipoCosteoDefinicions) {
		this.tipocosteodefinicions = newTipoCosteoDefinicions;
	}
	
	public Object getTipoCosteoDefinicionObject() {	
		this.tipocosteodefinicionObject=this.tipocosteodefinicionDataAccess.getEntityObject();
		return this.tipocosteodefinicionObject;
	}
		
	public void setTipoCosteoDefinicionObject(Object newTipoCosteoDefinicionObject) {
		this.tipocosteodefinicionObject = newTipoCosteoDefinicionObject;
	}
	
	public List<Object> getTipoCosteoDefinicionsObject() {		
		this.tipocosteodefinicionsObject=this.tipocosteodefinicionDataAccess.getEntitiesObject();
		return this.tipocosteodefinicionsObject;
	}
		
	public void setTipoCosteoDefinicionsObject(List<Object> newTipoCosteoDefinicionsObject) {
		this.tipocosteodefinicionsObject = newTipoCosteoDefinicionsObject;
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
		
		if(this.tipocosteodefinicionDataAccess!=null) {
			this.tipocosteodefinicionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCosteoDefinicion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipocosteodefinicionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipocosteodefinicionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipocosteodefinicion = new  TipoCosteoDefinicion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCosteoDefinicion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocosteodefinicion=tipocosteodefinicionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocosteodefinicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCosteoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCosteoDefinicion(this.tipocosteodefinicion);
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
		tipocosteodefinicion = new  TipoCosteoDefinicion();
		  		  
        try {
			
			tipocosteodefinicion=tipocosteodefinicionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocosteodefinicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCosteoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCosteoDefinicion(this.tipocosteodefinicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipocosteodefinicion = new  TipoCosteoDefinicion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCosteoDefinicion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocosteodefinicion=tipocosteodefinicionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocosteodefinicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCosteoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCosteoDefinicion(this.tipocosteodefinicion);
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
		tipocosteodefinicion = new  TipoCosteoDefinicion();
		  		  
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
		tipocosteodefinicion = new  TipoCosteoDefinicion();
		  		  
        try {
			
			tipocosteodefinicion=tipocosteodefinicionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocosteodefinicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCosteoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCosteoDefinicion(this.tipocosteodefinicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipocosteodefinicion = new  TipoCosteoDefinicion();
		  		  
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
		tipocosteodefinicion = new  TipoCosteoDefinicion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCosteoDefinicion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipocosteodefinicionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocosteodefinicion = new  TipoCosteoDefinicion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipocosteodefinicionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocosteodefinicion = new  TipoCosteoDefinicion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCosteoDefinicion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipocosteodefinicionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocosteodefinicion = new  TipoCosteoDefinicion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipocosteodefinicionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocosteodefinicion = new  TipoCosteoDefinicion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCosteoDefinicion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipocosteodefinicionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocosteodefinicion = new  TipoCosteoDefinicion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipocosteodefinicionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocosteodefinicions = new  ArrayList<TipoCosteoDefinicion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCosteoDefinicion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoCosteoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocosteodefinicions=tipocosteodefinicionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCosteoDefinicion(tipocosteodefinicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCosteoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCosteoDefinicion(this.tipocosteodefinicions);
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
		tipocosteodefinicions = new  ArrayList<TipoCosteoDefinicion>();
		  		  
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
		tipocosteodefinicions = new  ArrayList<TipoCosteoDefinicion>();
		  		  
        try {			
			TipoCosteoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocosteodefinicions=tipocosteodefinicionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoCosteoDefinicion(tipocosteodefinicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCosteoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCosteoDefinicion(this.tipocosteodefinicions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipocosteodefinicions = new  ArrayList<TipoCosteoDefinicion>();
		  		  
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
		tipocosteodefinicions = new  ArrayList<TipoCosteoDefinicion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCosteoDefinicion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoCosteoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocosteodefinicions=tipocosteodefinicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCosteoDefinicion(tipocosteodefinicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCosteoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCosteoDefinicion(this.tipocosteodefinicions);
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
		tipocosteodefinicions = new  ArrayList<TipoCosteoDefinicion>();
		  		  
        try {
			TipoCosteoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocosteodefinicions=tipocosteodefinicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCosteoDefinicion(tipocosteodefinicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCosteoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCosteoDefinicion(this.tipocosteodefinicions);
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
		tipocosteodefinicions = new  ArrayList<TipoCosteoDefinicion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCosteoDefinicion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCosteoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocosteodefinicions=tipocosteodefinicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCosteoDefinicion(tipocosteodefinicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCosteoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCosteoDefinicion(this.tipocosteodefinicions);
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
		tipocosteodefinicions = new  ArrayList<TipoCosteoDefinicion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCosteoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocosteodefinicions=tipocosteodefinicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCosteoDefinicion(tipocosteodefinicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCosteoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCosteoDefinicion(this.tipocosteodefinicions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipocosteodefinicion = new  TipoCosteoDefinicion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCosteoDefinicion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCosteoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocosteodefinicion=tipocosteodefinicionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCosteoDefinicion(tipocosteodefinicion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCosteoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCosteoDefinicion(this.tipocosteodefinicion);
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
		tipocosteodefinicion = new  TipoCosteoDefinicion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCosteoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocosteodefinicion=tipocosteodefinicionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCosteoDefinicion(tipocosteodefinicion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCosteoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCosteoDefinicion(this.tipocosteodefinicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoCosteoDefinicionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipocosteodefinicions = new  ArrayList<TipoCosteoDefinicion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCosteoDefinicion.class.getSimpleName()+"-getTodosTipoCosteoDefinicionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCosteoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocosteodefinicions=tipocosteodefinicionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCosteoDefinicion(tipocosteodefinicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCosteoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCosteoDefinicion(this.tipocosteodefinicions);
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
	
	public  void  getTodosTipoCosteoDefinicions(String sFinalQuery,Pagination pagination)throws Exception {
		tipocosteodefinicions = new  ArrayList<TipoCosteoDefinicion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCosteoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocosteodefinicions=tipocosteodefinicionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCosteoDefinicion(tipocosteodefinicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCosteoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCosteoDefinicion(this.tipocosteodefinicions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoCosteoDefinicion(TipoCosteoDefinicion tipocosteodefinicion) throws Exception {
		Boolean estaValidado=false;
		
		if(tipocosteodefinicion.getIsNew() || tipocosteodefinicion.getIsChanged()) { 
			this.invalidValues = tipocosteodefinicionValidator.getInvalidValues(tipocosteodefinicion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipocosteodefinicion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoCosteoDefinicion(List<TipoCosteoDefinicion> TipoCosteoDefinicions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoCosteoDefinicion tipocosteodefinicionLocal:tipocosteodefinicions) {				
			estaValidadoObjeto=this.validarGuardarTipoCosteoDefinicion(tipocosteodefinicionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoCosteoDefinicion(List<TipoCosteoDefinicion> TipoCosteoDefinicions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCosteoDefinicion(tipocosteodefinicions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoCosteoDefinicion(TipoCosteoDefinicion TipoCosteoDefinicion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCosteoDefinicion(tipocosteodefinicion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoCosteoDefinicion tipocosteodefinicion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipocosteodefinicion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoCosteoDefinicionConstantesFunciones.getTipoCosteoDefinicionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipocosteodefinicion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoCosteoDefinicionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoCosteoDefinicionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoCosteoDefinicionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCosteoDefinicion.class.getSimpleName()+"-saveTipoCosteoDefinicionWithConnection");connexion.begin();			
			
			//TipoCosteoDefinicionLogicAdditional.checkTipoCosteoDefinicionToSave(this.tipocosteodefinicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoCosteoDefinicionLogicAdditional.updateTipoCosteoDefinicionToSave(this.tipocosteodefinicion,this.arrDatoGeneral);
			
			TipoCosteoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocosteodefinicion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoCosteoDefinicion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCosteoDefinicion(this.tipocosteodefinicion)) {
				TipoCosteoDefinicionDataAccess.save(this.tipocosteodefinicion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipocosteodefinicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoCosteoDefinicionLogicAdditional.checkTipoCosteoDefinicionToSaveAfter(this.tipocosteodefinicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCosteoDefinicion();
			
			connexion.commit();			
			
			if(this.tipocosteodefinicion.getIsDeleted()) {
				this.tipocosteodefinicion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoCosteoDefinicion()throws Exception {	
		try {	
			
			//TipoCosteoDefinicionLogicAdditional.checkTipoCosteoDefinicionToSave(this.tipocosteodefinicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoCosteoDefinicionLogicAdditional.updateTipoCosteoDefinicionToSave(this.tipocosteodefinicion,this.arrDatoGeneral);
			
			TipoCosteoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocosteodefinicion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCosteoDefinicion(this.tipocosteodefinicion)) {			
				TipoCosteoDefinicionDataAccess.save(this.tipocosteodefinicion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipocosteodefinicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoCosteoDefinicionLogicAdditional.checkTipoCosteoDefinicionToSaveAfter(this.tipocosteodefinicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipocosteodefinicion.getIsDeleted()) {
				this.tipocosteodefinicion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoCosteoDefinicionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCosteoDefinicion.class.getSimpleName()+"-saveTipoCosteoDefinicionsWithConnection");connexion.begin();			
			
			//TipoCosteoDefinicionLogicAdditional.checkTipoCosteoDefinicionToSaves(tipocosteodefinicions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoCosteoDefinicions();
			
			Boolean validadoTodosTipoCosteoDefinicion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCosteoDefinicion tipocosteodefinicionLocal:tipocosteodefinicions) {		
				if(tipocosteodefinicionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoCosteoDefinicionLogicAdditional.updateTipoCosteoDefinicionToSave(tipocosteodefinicionLocal,this.arrDatoGeneral);
	        	
				TipoCosteoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocosteodefinicionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCosteoDefinicion(tipocosteodefinicionLocal)) {
					TipoCosteoDefinicionDataAccess.save(tipocosteodefinicionLocal, connexion);				
				} else {
					validadoTodosTipoCosteoDefinicion=false;
				}
			}
			
			if(!validadoTodosTipoCosteoDefinicion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoCosteoDefinicionLogicAdditional.checkTipoCosteoDefinicionToSavesAfter(tipocosteodefinicions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCosteoDefinicions();
			
			connexion.commit();		
			
			this.quitarTipoCosteoDefinicionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoCosteoDefinicions()throws Exception {				
		 try {	
			//TipoCosteoDefinicionLogicAdditional.checkTipoCosteoDefinicionToSaves(tipocosteodefinicions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoCosteoDefinicion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCosteoDefinicion tipocosteodefinicionLocal:tipocosteodefinicions) {				
				if(tipocosteodefinicionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoCosteoDefinicionLogicAdditional.updateTipoCosteoDefinicionToSave(tipocosteodefinicionLocal,this.arrDatoGeneral);
	        	
				TipoCosteoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocosteodefinicionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCosteoDefinicion(tipocosteodefinicionLocal)) {				
					TipoCosteoDefinicionDataAccess.save(tipocosteodefinicionLocal, connexion);				
				} else {
					validadoTodosTipoCosteoDefinicion=false;
				}
			}
			
			if(!validadoTodosTipoCosteoDefinicion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoCosteoDefinicionLogicAdditional.checkTipoCosteoDefinicionToSavesAfter(tipocosteodefinicions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoCosteoDefinicionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCosteoDefinicionParameterReturnGeneral procesarAccionTipoCosteoDefinicions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCosteoDefinicion> tipocosteodefinicions,TipoCosteoDefinicionParameterReturnGeneral tipocosteodefinicionParameterGeneral)throws Exception {
		 try {	
			TipoCosteoDefinicionParameterReturnGeneral tipocosteodefinicionReturnGeneral=new TipoCosteoDefinicionParameterReturnGeneral();
	
			
			return tipocosteodefinicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCosteoDefinicionParameterReturnGeneral procesarAccionTipoCosteoDefinicionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCosteoDefinicion> tipocosteodefinicions,TipoCosteoDefinicionParameterReturnGeneral tipocosteodefinicionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCosteoDefinicion.class.getSimpleName()+"-procesarAccionTipoCosteoDefinicionsWithConnection");connexion.begin();			
			
			TipoCosteoDefinicionParameterReturnGeneral tipocosteodefinicionReturnGeneral=new TipoCosteoDefinicionParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipocosteodefinicionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCosteoDefinicionParameterReturnGeneral procesarEventosTipoCosteoDefinicions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCosteoDefinicion> tipocosteodefinicions,TipoCosteoDefinicion tipocosteodefinicion,TipoCosteoDefinicionParameterReturnGeneral tipocosteodefinicionParameterGeneral,Boolean isEsNuevoTipoCosteoDefinicion,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoCosteoDefinicionParameterReturnGeneral tipocosteodefinicionReturnGeneral=new TipoCosteoDefinicionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocosteodefinicionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipocosteodefinicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoCosteoDefinicionParameterReturnGeneral procesarEventosTipoCosteoDefinicionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCosteoDefinicion> tipocosteodefinicions,TipoCosteoDefinicion tipocosteodefinicion,TipoCosteoDefinicionParameterReturnGeneral tipocosteodefinicionParameterGeneral,Boolean isEsNuevoTipoCosteoDefinicion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCosteoDefinicion.class.getSimpleName()+"-procesarEventosTipoCosteoDefinicionsWithConnection");connexion.begin();			
			
			TipoCosteoDefinicionParameterReturnGeneral tipocosteodefinicionReturnGeneral=new TipoCosteoDefinicionParameterReturnGeneral();
	
			tipocosteodefinicionReturnGeneral.setTipoCosteoDefinicion(tipocosteodefinicion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocosteodefinicionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipocosteodefinicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCosteoDefinicionParameterReturnGeneral procesarImportacionTipoCosteoDefinicionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoCosteoDefinicionParameterReturnGeneral tipocosteodefinicionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCosteoDefinicion.class.getSimpleName()+"-procesarImportacionTipoCosteoDefinicionsWithConnection");connexion.begin();			
			
			TipoCosteoDefinicionParameterReturnGeneral tipocosteodefinicionReturnGeneral=new TipoCosteoDefinicionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipocosteodefinicions=new ArrayList<TipoCosteoDefinicion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipocosteodefinicion=new TipoCosteoDefinicion();
				
				
				if(conColumnasBase) {this.tipocosteodefinicion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipocosteodefinicion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipocosteodefinicion.setcodigo(arrColumnas[iColumn++]);
				this.tipocosteodefinicion.setnombre(arrColumnas[iColumn++]);
				
				this.tipocosteodefinicions.add(this.tipocosteodefinicion);
			}
			
			this.saveTipoCosteoDefinicions();
			
			this.connexion.commit();
			
			tipocosteodefinicionReturnGeneral.setConRetornoEstaProcesado(true);
			tipocosteodefinicionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipocosteodefinicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoCosteoDefinicionsEliminados() throws Exception {				
		
		List<TipoCosteoDefinicion> tipocosteodefinicionsAux= new ArrayList<TipoCosteoDefinicion>();
		
		for(TipoCosteoDefinicion tipocosteodefinicion:tipocosteodefinicions) {
			if(!tipocosteodefinicion.getIsDeleted()) {
				tipocosteodefinicionsAux.add(tipocosteodefinicion);
			}
		}
		
		tipocosteodefinicions=tipocosteodefinicionsAux;
	}
	
	public void quitarTipoCosteoDefinicionsNulos() throws Exception {				
		
		List<TipoCosteoDefinicion> tipocosteodefinicionsAux= new ArrayList<TipoCosteoDefinicion>();
		
		for(TipoCosteoDefinicion tipocosteodefinicion : this.tipocosteodefinicions) {
			if(tipocosteodefinicion==null) {
				tipocosteodefinicionsAux.add(tipocosteodefinicion);
			}
		}
		
		//this.tipocosteodefinicions=tipocosteodefinicionsAux;
		
		this.tipocosteodefinicions.removeAll(tipocosteodefinicionsAux);
	}
	
	public void getSetVersionRowTipoCosteoDefinicionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipocosteodefinicion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipocosteodefinicion.getIsDeleted() || (tipocosteodefinicion.getIsChanged()&&!tipocosteodefinicion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipocosteodefinicionDataAccess.getSetVersionRowTipoCosteoDefinicion(connexion,tipocosteodefinicion.getId());
				
				if(!tipocosteodefinicion.getVersionRow().equals(timestamp)) {	
					tipocosteodefinicion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipocosteodefinicion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoCosteoDefinicion()throws Exception {	
		
		if(tipocosteodefinicion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipocosteodefinicion.getIsDeleted() || (tipocosteodefinicion.getIsChanged()&&!tipocosteodefinicion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipocosteodefinicionDataAccess.getSetVersionRowTipoCosteoDefinicion(connexion,tipocosteodefinicion.getId());
			
			try {							
				if(!tipocosteodefinicion.getVersionRow().equals(timestamp)) {	
					tipocosteodefinicion.setVersionRow(timestamp);
				}
				
				tipocosteodefinicion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoCosteoDefinicionsWithConnection()throws Exception {	
		if(tipocosteodefinicions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoCosteoDefinicion tipocosteodefinicionAux:tipocosteodefinicions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipocosteodefinicionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocosteodefinicionAux.getIsDeleted() || (tipocosteodefinicionAux.getIsChanged()&&!tipocosteodefinicionAux.getIsNew())) {
						
						timestamp=tipocosteodefinicionDataAccess.getSetVersionRowTipoCosteoDefinicion(connexion,tipocosteodefinicionAux.getId());
						
						if(!tipocosteodefinicion.getVersionRow().equals(timestamp)) {	
							tipocosteodefinicionAux.setVersionRow(timestamp);
						}
								
						tipocosteodefinicionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoCosteoDefinicions()throws Exception {	
		if(tipocosteodefinicions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoCosteoDefinicion tipocosteodefinicionAux:tipocosteodefinicions) {
					if(tipocosteodefinicionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocosteodefinicionAux.getIsDeleted() || (tipocosteodefinicionAux.getIsChanged()&&!tipocosteodefinicionAux.getIsNew())) {
						
						timestamp=tipocosteodefinicionDataAccess.getSetVersionRowTipoCosteoDefinicion(connexion,tipocosteodefinicionAux.getId());
						
						if(!tipocosteodefinicionAux.getVersionRow().equals(timestamp)) {	
							tipocosteodefinicionAux.setVersionRow(timestamp);
						}
						
													
						tipocosteodefinicionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoCosteoDefinicionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DefinicionLogic definicionLogic=new DefinicionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCosteoDefinicion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoCosteoDefinicionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Definicion.class));
											
			

			definicionLogic.setConnexion(this.getConnexion());
			definicionLogic.setDatosCliente(this.datosCliente);
			definicionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoCosteoDefinicion tipocosteodefinicion:this.tipocosteodefinicions) {
				

				classes=new ArrayList<Classe>();
				classes=DefinicionConstantesFunciones.getClassesForeignKeysOfDefinicion(new ArrayList<Classe>(),DeepLoadType.NONE);

				definicionLogic.setDefinicions(tipocosteodefinicion.definicions);
				definicionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoCosteoDefinicion tipocosteodefinicion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoCosteoDefinicionLogicAdditional.updateTipoCosteoDefinicionToGet(tipocosteodefinicion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocosteodefinicion.setDefinicions(tipocosteodefinicionDataAccess.getDefinicions(connexion,tipocosteodefinicion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocosteodefinicion.setDefinicions(tipocosteodefinicionDataAccess.getDefinicions(connexion,tipocosteodefinicion));

				if(this.isConDeep) {
					DefinicionLogic definicionLogic= new DefinicionLogic(this.connexion);
					definicionLogic.setDefinicions(tipocosteodefinicion.getDefinicions());
					ArrayList<Classe> classesLocal=DefinicionConstantesFunciones.getClassesForeignKeysOfDefinicion(new ArrayList<Classe>(),DeepLoadType.NONE);
					definicionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(definicionLogic.getDefinicions());
					tipocosteodefinicion.setDefinicions(definicionLogic.getDefinicions());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Definicion.class));
			tipocosteodefinicion.setDefinicions(tipocosteodefinicionDataAccess.getDefinicions(connexion,tipocosteodefinicion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipocosteodefinicion.setDefinicions(tipocosteodefinicionDataAccess.getDefinicions(connexion,tipocosteodefinicion));

		for(Definicion definicion:tipocosteodefinicion.getDefinicions()) {
			DefinicionLogic definicionLogic= new DefinicionLogic(connexion);
			definicionLogic.deepLoad(definicion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocosteodefinicion.setDefinicions(tipocosteodefinicionDataAccess.getDefinicions(connexion,tipocosteodefinicion));

				for(Definicion definicion:tipocosteodefinicion.getDefinicions()) {
					DefinicionLogic definicionLogic= new DefinicionLogic(connexion);
					definicionLogic.deepLoad(definicion,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Definicion.class));
			tipocosteodefinicion.setDefinicions(tipocosteodefinicionDataAccess.getDefinicions(connexion,tipocosteodefinicion));

			for(Definicion definicion:tipocosteodefinicion.getDefinicions()) {
				DefinicionLogic definicionLogic= new DefinicionLogic(connexion);
				definicionLogic.deepLoad(definicion,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoCosteoDefinicion tipocosteodefinicion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoCosteoDefinicion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipocosteodefinicion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCosteoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCosteoDefinicion(tipocosteodefinicion);
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
			this.deepLoad(this.tipocosteodefinicion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCosteoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCosteoDefinicion(this.tipocosteodefinicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoCosteoDefinicion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipocosteodefinicions!=null) {
				for(TipoCosteoDefinicion tipocosteodefinicion:tipocosteodefinicions) {
					this.deepLoad(tipocosteodefinicion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoCosteoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCosteoDefinicion(tipocosteodefinicions);
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
			if(tipocosteodefinicions!=null) {
				for(TipoCosteoDefinicion tipocosteodefinicion:tipocosteodefinicions) {
					this.deepLoad(tipocosteodefinicion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoCosteoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCosteoDefinicion(tipocosteodefinicions);
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
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoCosteoDefinicionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCosteoDefinicionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoCosteoDefinicion tipocosteodefinicion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoCosteoDefinicionConstantesFunciones.ISCONAUDITORIA) {
				if(tipocosteodefinicion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCosteoDefinicionDataAccess.TABLENAME, tipocosteodefinicion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCosteoDefinicionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCosteoDefinicionLogic.registrarAuditoriaDetallesTipoCosteoDefinicion(connexion,tipocosteodefinicion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipocosteodefinicion.getIsDeleted()) {
					/*if(!tipocosteodefinicion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoCosteoDefinicionDataAccess.TABLENAME, tipocosteodefinicion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoCosteoDefinicionLogic.registrarAuditoriaDetallesTipoCosteoDefinicion(connexion,tipocosteodefinicion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCosteoDefinicionDataAccess.TABLENAME, tipocosteodefinicion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipocosteodefinicion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCosteoDefinicionDataAccess.TABLENAME, tipocosteodefinicion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCosteoDefinicionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCosteoDefinicionLogic.registrarAuditoriaDetallesTipoCosteoDefinicion(connexion,tipocosteodefinicion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoCosteoDefinicion(Connexion connexion,TipoCosteoDefinicion tipocosteodefinicion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipocosteodefinicion.getIsNew()||!tipocosteodefinicion.getcodigo().equals(tipocosteodefinicion.getTipoCosteoDefinicionOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocosteodefinicion.getTipoCosteoDefinicionOriginal().getcodigo()!=null)
				{
					strValorActual=tipocosteodefinicion.getTipoCosteoDefinicionOriginal().getcodigo();
				}
				if(tipocosteodefinicion.getcodigo()!=null)
				{
					strValorNuevo=tipocosteodefinicion.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCosteoDefinicionConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipocosteodefinicion.getIsNew()||!tipocosteodefinicion.getnombre().equals(tipocosteodefinicion.getTipoCosteoDefinicionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocosteodefinicion.getTipoCosteoDefinicionOriginal().getnombre()!=null)
				{
					strValorActual=tipocosteodefinicion.getTipoCosteoDefinicionOriginal().getnombre();
				}
				if(tipocosteodefinicion.getnombre()!=null)
				{
					strValorNuevo=tipocosteodefinicion.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCosteoDefinicionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCosteoDefinicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCosteoDefinicionConstantesFunciones.getClassesForeignKeysOfTipoCosteoDefinicion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCosteoDefinicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCosteoDefinicionConstantesFunciones.getClassesRelationshipsOfTipoCosteoDefinicion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

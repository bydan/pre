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
import com.bydan.erp.inventario.util.TipoCostoDefinicionConstantesFunciones;
import com.bydan.erp.inventario.util.TipoCostoDefinicionParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoCostoDefinicionParameterGeneral;
import com.bydan.erp.inventario.business.entity.TipoCostoDefinicion;
//import com.bydan.erp.inventario.business.logic.TipoCostoDefinicionLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoCostoDefinicionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoCostoDefinicionLogic.class);
	
	protected TipoCostoDefinicionDataAccess tipocostodefinicionDataAccess; 	
	protected TipoCostoDefinicion tipocostodefinicion;
	protected List<TipoCostoDefinicion> tipocostodefinicions;
	protected Object tipocostodefinicionObject;	
	protected List<Object> tipocostodefinicionsObject;
	
	public static ClassValidator<TipoCostoDefinicion> tipocostodefinicionValidator = new ClassValidator<TipoCostoDefinicion>(TipoCostoDefinicion.class);	
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
	
	
	
	
	public  TipoCostoDefinicionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipocostodefinicionDataAccess = new TipoCostoDefinicionDataAccess();
			
			this.tipocostodefinicions= new ArrayList<TipoCostoDefinicion>();
			this.tipocostodefinicion= new TipoCostoDefinicion();
			
			this.tipocostodefinicionObject=new Object();
			this.tipocostodefinicionsObject=new ArrayList<Object>();
				
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
			
			this.tipocostodefinicionDataAccess.setConnexionType(this.connexionType);
			this.tipocostodefinicionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoCostoDefinicionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipocostodefinicionDataAccess = new TipoCostoDefinicionDataAccess();
			this.tipocostodefinicions= new ArrayList<TipoCostoDefinicion>();
			this.tipocostodefinicion= new TipoCostoDefinicion();
			this.tipocostodefinicionObject=new Object();
			this.tipocostodefinicionsObject=new ArrayList<Object>();
			
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
			
			this.tipocostodefinicionDataAccess.setConnexionType(this.connexionType);
			this.tipocostodefinicionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoCostoDefinicion getTipoCostoDefinicion() throws Exception {	
		//TipoCostoDefinicionLogicAdditional.checkTipoCostoDefinicionToGet(tipocostodefinicion,this.datosCliente,this.arrDatoGeneral);
		//TipoCostoDefinicionLogicAdditional.updateTipoCostoDefinicionToGet(tipocostodefinicion,this.arrDatoGeneral);
		
		return tipocostodefinicion;
	}
		
	public void setTipoCostoDefinicion(TipoCostoDefinicion newTipoCostoDefinicion) {
		this.tipocostodefinicion = newTipoCostoDefinicion;
	}
	
	public TipoCostoDefinicionDataAccess getTipoCostoDefinicionDataAccess() {
		return tipocostodefinicionDataAccess;
	}
	
	public void setTipoCostoDefinicionDataAccess(TipoCostoDefinicionDataAccess newtipocostodefinicionDataAccess) {
		this.tipocostodefinicionDataAccess = newtipocostodefinicionDataAccess;
	}
	
	public List<TipoCostoDefinicion> getTipoCostoDefinicions() throws Exception {		
		this.quitarTipoCostoDefinicionsNulos();
		
		//TipoCostoDefinicionLogicAdditional.checkTipoCostoDefinicionToGets(tipocostodefinicions,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoCostoDefinicion tipocostodefinicionLocal: tipocostodefinicions ) {
			//TipoCostoDefinicionLogicAdditional.updateTipoCostoDefinicionToGet(tipocostodefinicionLocal,this.arrDatoGeneral);
		}
		
		return tipocostodefinicions;
	}
	
	public void setTipoCostoDefinicions(List<TipoCostoDefinicion> newTipoCostoDefinicions) {
		this.tipocostodefinicions = newTipoCostoDefinicions;
	}
	
	public Object getTipoCostoDefinicionObject() {	
		this.tipocostodefinicionObject=this.tipocostodefinicionDataAccess.getEntityObject();
		return this.tipocostodefinicionObject;
	}
		
	public void setTipoCostoDefinicionObject(Object newTipoCostoDefinicionObject) {
		this.tipocostodefinicionObject = newTipoCostoDefinicionObject;
	}
	
	public List<Object> getTipoCostoDefinicionsObject() {		
		this.tipocostodefinicionsObject=this.tipocostodefinicionDataAccess.getEntitiesObject();
		return this.tipocostodefinicionsObject;
	}
		
	public void setTipoCostoDefinicionsObject(List<Object> newTipoCostoDefinicionsObject) {
		this.tipocostodefinicionsObject = newTipoCostoDefinicionsObject;
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
		
		if(this.tipocostodefinicionDataAccess!=null) {
			this.tipocostodefinicionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoDefinicion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipocostodefinicionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipocostodefinicionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipocostodefinicion = new  TipoCostoDefinicion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoDefinicion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocostodefinicion=tipocostodefinicionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocostodefinicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCostoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoDefinicion(this.tipocostodefinicion);
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
		tipocostodefinicion = new  TipoCostoDefinicion();
		  		  
        try {
			
			tipocostodefinicion=tipocostodefinicionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocostodefinicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCostoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoDefinicion(this.tipocostodefinicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipocostodefinicion = new  TipoCostoDefinicion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoDefinicion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocostodefinicion=tipocostodefinicionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocostodefinicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCostoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoDefinicion(this.tipocostodefinicion);
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
		tipocostodefinicion = new  TipoCostoDefinicion();
		  		  
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
		tipocostodefinicion = new  TipoCostoDefinicion();
		  		  
        try {
			
			tipocostodefinicion=tipocostodefinicionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocostodefinicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCostoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoDefinicion(this.tipocostodefinicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipocostodefinicion = new  TipoCostoDefinicion();
		  		  
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
		tipocostodefinicion = new  TipoCostoDefinicion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoDefinicion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipocostodefinicionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocostodefinicion = new  TipoCostoDefinicion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipocostodefinicionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocostodefinicion = new  TipoCostoDefinicion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoDefinicion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipocostodefinicionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocostodefinicion = new  TipoCostoDefinicion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipocostodefinicionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocostodefinicion = new  TipoCostoDefinicion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoDefinicion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipocostodefinicionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocostodefinicion = new  TipoCostoDefinicion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipocostodefinicionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocostodefinicions = new  ArrayList<TipoCostoDefinicion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoDefinicion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoCostoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocostodefinicions=tipocostodefinicionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCostoDefinicion(tipocostodefinicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCostoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoDefinicion(this.tipocostodefinicions);
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
		tipocostodefinicions = new  ArrayList<TipoCostoDefinicion>();
		  		  
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
		tipocostodefinicions = new  ArrayList<TipoCostoDefinicion>();
		  		  
        try {			
			TipoCostoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocostodefinicions=tipocostodefinicionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoCostoDefinicion(tipocostodefinicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCostoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoDefinicion(this.tipocostodefinicions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipocostodefinicions = new  ArrayList<TipoCostoDefinicion>();
		  		  
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
		tipocostodefinicions = new  ArrayList<TipoCostoDefinicion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoDefinicion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoCostoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocostodefinicions=tipocostodefinicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCostoDefinicion(tipocostodefinicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCostoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoDefinicion(this.tipocostodefinicions);
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
		tipocostodefinicions = new  ArrayList<TipoCostoDefinicion>();
		  		  
        try {
			TipoCostoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocostodefinicions=tipocostodefinicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCostoDefinicion(tipocostodefinicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCostoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoDefinicion(this.tipocostodefinicions);
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
		tipocostodefinicions = new  ArrayList<TipoCostoDefinicion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoDefinicion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCostoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocostodefinicions=tipocostodefinicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCostoDefinicion(tipocostodefinicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCostoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoDefinicion(this.tipocostodefinicions);
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
		tipocostodefinicions = new  ArrayList<TipoCostoDefinicion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCostoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocostodefinicions=tipocostodefinicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCostoDefinicion(tipocostodefinicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCostoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoDefinicion(this.tipocostodefinicions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipocostodefinicion = new  TipoCostoDefinicion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoDefinicion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCostoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocostodefinicion=tipocostodefinicionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCostoDefinicion(tipocostodefinicion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCostoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoDefinicion(this.tipocostodefinicion);
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
		tipocostodefinicion = new  TipoCostoDefinicion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCostoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocostodefinicion=tipocostodefinicionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCostoDefinicion(tipocostodefinicion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCostoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoDefinicion(this.tipocostodefinicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoCostoDefinicionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipocostodefinicions = new  ArrayList<TipoCostoDefinicion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoDefinicion.class.getSimpleName()+"-getTodosTipoCostoDefinicionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCostoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocostodefinicions=tipocostodefinicionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCostoDefinicion(tipocostodefinicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCostoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoDefinicion(this.tipocostodefinicions);
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
	
	public  void  getTodosTipoCostoDefinicions(String sFinalQuery,Pagination pagination)throws Exception {
		tipocostodefinicions = new  ArrayList<TipoCostoDefinicion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCostoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocostodefinicions=tipocostodefinicionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCostoDefinicion(tipocostodefinicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCostoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoDefinicion(this.tipocostodefinicions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoCostoDefinicion(TipoCostoDefinicion tipocostodefinicion) throws Exception {
		Boolean estaValidado=false;
		
		if(tipocostodefinicion.getIsNew() || tipocostodefinicion.getIsChanged()) { 
			this.invalidValues = tipocostodefinicionValidator.getInvalidValues(tipocostodefinicion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipocostodefinicion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoCostoDefinicion(List<TipoCostoDefinicion> TipoCostoDefinicions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoCostoDefinicion tipocostodefinicionLocal:tipocostodefinicions) {				
			estaValidadoObjeto=this.validarGuardarTipoCostoDefinicion(tipocostodefinicionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoCostoDefinicion(List<TipoCostoDefinicion> TipoCostoDefinicions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCostoDefinicion(tipocostodefinicions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoCostoDefinicion(TipoCostoDefinicion TipoCostoDefinicion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCostoDefinicion(tipocostodefinicion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoCostoDefinicion tipocostodefinicion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipocostodefinicion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoCostoDefinicionConstantesFunciones.getTipoCostoDefinicionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipocostodefinicion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoCostoDefinicionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoCostoDefinicionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoCostoDefinicionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoDefinicion.class.getSimpleName()+"-saveTipoCostoDefinicionWithConnection");connexion.begin();			
			
			//TipoCostoDefinicionLogicAdditional.checkTipoCostoDefinicionToSave(this.tipocostodefinicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoCostoDefinicionLogicAdditional.updateTipoCostoDefinicionToSave(this.tipocostodefinicion,this.arrDatoGeneral);
			
			TipoCostoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocostodefinicion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoCostoDefinicion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCostoDefinicion(this.tipocostodefinicion)) {
				TipoCostoDefinicionDataAccess.save(this.tipocostodefinicion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipocostodefinicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoCostoDefinicionLogicAdditional.checkTipoCostoDefinicionToSaveAfter(this.tipocostodefinicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCostoDefinicion();
			
			connexion.commit();			
			
			if(this.tipocostodefinicion.getIsDeleted()) {
				this.tipocostodefinicion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoCostoDefinicion()throws Exception {	
		try {	
			
			//TipoCostoDefinicionLogicAdditional.checkTipoCostoDefinicionToSave(this.tipocostodefinicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoCostoDefinicionLogicAdditional.updateTipoCostoDefinicionToSave(this.tipocostodefinicion,this.arrDatoGeneral);
			
			TipoCostoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocostodefinicion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCostoDefinicion(this.tipocostodefinicion)) {			
				TipoCostoDefinicionDataAccess.save(this.tipocostodefinicion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipocostodefinicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoCostoDefinicionLogicAdditional.checkTipoCostoDefinicionToSaveAfter(this.tipocostodefinicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipocostodefinicion.getIsDeleted()) {
				this.tipocostodefinicion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoCostoDefinicionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoDefinicion.class.getSimpleName()+"-saveTipoCostoDefinicionsWithConnection");connexion.begin();			
			
			//TipoCostoDefinicionLogicAdditional.checkTipoCostoDefinicionToSaves(tipocostodefinicions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoCostoDefinicions();
			
			Boolean validadoTodosTipoCostoDefinicion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCostoDefinicion tipocostodefinicionLocal:tipocostodefinicions) {		
				if(tipocostodefinicionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoCostoDefinicionLogicAdditional.updateTipoCostoDefinicionToSave(tipocostodefinicionLocal,this.arrDatoGeneral);
	        	
				TipoCostoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocostodefinicionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCostoDefinicion(tipocostodefinicionLocal)) {
					TipoCostoDefinicionDataAccess.save(tipocostodefinicionLocal, connexion);				
				} else {
					validadoTodosTipoCostoDefinicion=false;
				}
			}
			
			if(!validadoTodosTipoCostoDefinicion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoCostoDefinicionLogicAdditional.checkTipoCostoDefinicionToSavesAfter(tipocostodefinicions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCostoDefinicions();
			
			connexion.commit();		
			
			this.quitarTipoCostoDefinicionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoCostoDefinicions()throws Exception {				
		 try {	
			//TipoCostoDefinicionLogicAdditional.checkTipoCostoDefinicionToSaves(tipocostodefinicions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoCostoDefinicion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCostoDefinicion tipocostodefinicionLocal:tipocostodefinicions) {				
				if(tipocostodefinicionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoCostoDefinicionLogicAdditional.updateTipoCostoDefinicionToSave(tipocostodefinicionLocal,this.arrDatoGeneral);
	        	
				TipoCostoDefinicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocostodefinicionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCostoDefinicion(tipocostodefinicionLocal)) {				
					TipoCostoDefinicionDataAccess.save(tipocostodefinicionLocal, connexion);				
				} else {
					validadoTodosTipoCostoDefinicion=false;
				}
			}
			
			if(!validadoTodosTipoCostoDefinicion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoCostoDefinicionLogicAdditional.checkTipoCostoDefinicionToSavesAfter(tipocostodefinicions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoCostoDefinicionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCostoDefinicionParameterReturnGeneral procesarAccionTipoCostoDefinicions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCostoDefinicion> tipocostodefinicions,TipoCostoDefinicionParameterReturnGeneral tipocostodefinicionParameterGeneral)throws Exception {
		 try {	
			TipoCostoDefinicionParameterReturnGeneral tipocostodefinicionReturnGeneral=new TipoCostoDefinicionParameterReturnGeneral();
	
			
			return tipocostodefinicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCostoDefinicionParameterReturnGeneral procesarAccionTipoCostoDefinicionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCostoDefinicion> tipocostodefinicions,TipoCostoDefinicionParameterReturnGeneral tipocostodefinicionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoDefinicion.class.getSimpleName()+"-procesarAccionTipoCostoDefinicionsWithConnection");connexion.begin();			
			
			TipoCostoDefinicionParameterReturnGeneral tipocostodefinicionReturnGeneral=new TipoCostoDefinicionParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipocostodefinicionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCostoDefinicionParameterReturnGeneral procesarEventosTipoCostoDefinicions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCostoDefinicion> tipocostodefinicions,TipoCostoDefinicion tipocostodefinicion,TipoCostoDefinicionParameterReturnGeneral tipocostodefinicionParameterGeneral,Boolean isEsNuevoTipoCostoDefinicion,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoCostoDefinicionParameterReturnGeneral tipocostodefinicionReturnGeneral=new TipoCostoDefinicionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocostodefinicionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipocostodefinicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoCostoDefinicionParameterReturnGeneral procesarEventosTipoCostoDefinicionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCostoDefinicion> tipocostodefinicions,TipoCostoDefinicion tipocostodefinicion,TipoCostoDefinicionParameterReturnGeneral tipocostodefinicionParameterGeneral,Boolean isEsNuevoTipoCostoDefinicion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoDefinicion.class.getSimpleName()+"-procesarEventosTipoCostoDefinicionsWithConnection");connexion.begin();			
			
			TipoCostoDefinicionParameterReturnGeneral tipocostodefinicionReturnGeneral=new TipoCostoDefinicionParameterReturnGeneral();
	
			tipocostodefinicionReturnGeneral.setTipoCostoDefinicion(tipocostodefinicion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocostodefinicionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipocostodefinicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCostoDefinicionParameterReturnGeneral procesarImportacionTipoCostoDefinicionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoCostoDefinicionParameterReturnGeneral tipocostodefinicionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoDefinicion.class.getSimpleName()+"-procesarImportacionTipoCostoDefinicionsWithConnection");connexion.begin();			
			
			TipoCostoDefinicionParameterReturnGeneral tipocostodefinicionReturnGeneral=new TipoCostoDefinicionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipocostodefinicions=new ArrayList<TipoCostoDefinicion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipocostodefinicion=new TipoCostoDefinicion();
				
				
				if(conColumnasBase) {this.tipocostodefinicion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipocostodefinicion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipocostodefinicion.setcodigo(arrColumnas[iColumn++]);
				this.tipocostodefinicion.setnombre(arrColumnas[iColumn++]);
				
				this.tipocostodefinicions.add(this.tipocostodefinicion);
			}
			
			this.saveTipoCostoDefinicions();
			
			this.connexion.commit();
			
			tipocostodefinicionReturnGeneral.setConRetornoEstaProcesado(true);
			tipocostodefinicionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipocostodefinicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoCostoDefinicionsEliminados() throws Exception {				
		
		List<TipoCostoDefinicion> tipocostodefinicionsAux= new ArrayList<TipoCostoDefinicion>();
		
		for(TipoCostoDefinicion tipocostodefinicion:tipocostodefinicions) {
			if(!tipocostodefinicion.getIsDeleted()) {
				tipocostodefinicionsAux.add(tipocostodefinicion);
			}
		}
		
		tipocostodefinicions=tipocostodefinicionsAux;
	}
	
	public void quitarTipoCostoDefinicionsNulos() throws Exception {				
		
		List<TipoCostoDefinicion> tipocostodefinicionsAux= new ArrayList<TipoCostoDefinicion>();
		
		for(TipoCostoDefinicion tipocostodefinicion : this.tipocostodefinicions) {
			if(tipocostodefinicion==null) {
				tipocostodefinicionsAux.add(tipocostodefinicion);
			}
		}
		
		//this.tipocostodefinicions=tipocostodefinicionsAux;
		
		this.tipocostodefinicions.removeAll(tipocostodefinicionsAux);
	}
	
	public void getSetVersionRowTipoCostoDefinicionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipocostodefinicion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipocostodefinicion.getIsDeleted() || (tipocostodefinicion.getIsChanged()&&!tipocostodefinicion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipocostodefinicionDataAccess.getSetVersionRowTipoCostoDefinicion(connexion,tipocostodefinicion.getId());
				
				if(!tipocostodefinicion.getVersionRow().equals(timestamp)) {	
					tipocostodefinicion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipocostodefinicion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoCostoDefinicion()throws Exception {	
		
		if(tipocostodefinicion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipocostodefinicion.getIsDeleted() || (tipocostodefinicion.getIsChanged()&&!tipocostodefinicion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipocostodefinicionDataAccess.getSetVersionRowTipoCostoDefinicion(connexion,tipocostodefinicion.getId());
			
			try {							
				if(!tipocostodefinicion.getVersionRow().equals(timestamp)) {	
					tipocostodefinicion.setVersionRow(timestamp);
				}
				
				tipocostodefinicion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoCostoDefinicionsWithConnection()throws Exception {	
		if(tipocostodefinicions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoCostoDefinicion tipocostodefinicionAux:tipocostodefinicions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipocostodefinicionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocostodefinicionAux.getIsDeleted() || (tipocostodefinicionAux.getIsChanged()&&!tipocostodefinicionAux.getIsNew())) {
						
						timestamp=tipocostodefinicionDataAccess.getSetVersionRowTipoCostoDefinicion(connexion,tipocostodefinicionAux.getId());
						
						if(!tipocostodefinicion.getVersionRow().equals(timestamp)) {	
							tipocostodefinicionAux.setVersionRow(timestamp);
						}
								
						tipocostodefinicionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoCostoDefinicions()throws Exception {	
		if(tipocostodefinicions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoCostoDefinicion tipocostodefinicionAux:tipocostodefinicions) {
					if(tipocostodefinicionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocostodefinicionAux.getIsDeleted() || (tipocostodefinicionAux.getIsChanged()&&!tipocostodefinicionAux.getIsNew())) {
						
						timestamp=tipocostodefinicionDataAccess.getSetVersionRowTipoCostoDefinicion(connexion,tipocostodefinicionAux.getId());
						
						if(!tipocostodefinicionAux.getVersionRow().equals(timestamp)) {	
							tipocostodefinicionAux.setVersionRow(timestamp);
						}
						
													
						tipocostodefinicionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoCostoDefinicionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DefinicionLogic definicionLogic=new DefinicionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCostoDefinicion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoCostoDefinicionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Definicion.class));
											
			

			definicionLogic.setConnexion(this.getConnexion());
			definicionLogic.setDatosCliente(this.datosCliente);
			definicionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoCostoDefinicion tipocostodefinicion:this.tipocostodefinicions) {
				

				classes=new ArrayList<Classe>();
				classes=DefinicionConstantesFunciones.getClassesForeignKeysOfDefinicion(new ArrayList<Classe>(),DeepLoadType.NONE);

				definicionLogic.setDefinicions(tipocostodefinicion.definicions);
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
	
	public void deepLoad(TipoCostoDefinicion tipocostodefinicion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoCostoDefinicionLogicAdditional.updateTipoCostoDefinicionToGet(tipocostodefinicion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocostodefinicion.setDefinicions(tipocostodefinicionDataAccess.getDefinicions(connexion,tipocostodefinicion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocostodefinicion.setDefinicions(tipocostodefinicionDataAccess.getDefinicions(connexion,tipocostodefinicion));

				if(this.isConDeep) {
					DefinicionLogic definicionLogic= new DefinicionLogic(this.connexion);
					definicionLogic.setDefinicions(tipocostodefinicion.getDefinicions());
					ArrayList<Classe> classesLocal=DefinicionConstantesFunciones.getClassesForeignKeysOfDefinicion(new ArrayList<Classe>(),DeepLoadType.NONE);
					definicionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(definicionLogic.getDefinicions());
					tipocostodefinicion.setDefinicions(definicionLogic.getDefinicions());
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
			tipocostodefinicion.setDefinicions(tipocostodefinicionDataAccess.getDefinicions(connexion,tipocostodefinicion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipocostodefinicion.setDefinicions(tipocostodefinicionDataAccess.getDefinicions(connexion,tipocostodefinicion));

		for(Definicion definicion:tipocostodefinicion.getDefinicions()) {
			DefinicionLogic definicionLogic= new DefinicionLogic(connexion);
			definicionLogic.deepLoad(definicion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocostodefinicion.setDefinicions(tipocostodefinicionDataAccess.getDefinicions(connexion,tipocostodefinicion));

				for(Definicion definicion:tipocostodefinicion.getDefinicions()) {
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
			tipocostodefinicion.setDefinicions(tipocostodefinicionDataAccess.getDefinicions(connexion,tipocostodefinicion));

			for(Definicion definicion:tipocostodefinicion.getDefinicions()) {
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
	
	public void deepSave(TipoCostoDefinicion tipocostodefinicion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoCostoDefinicion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipocostodefinicion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCostoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoDefinicion(tipocostodefinicion);
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
			this.deepLoad(this.tipocostodefinicion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCostoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoDefinicion(this.tipocostodefinicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoCostoDefinicion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipocostodefinicions!=null) {
				for(TipoCostoDefinicion tipocostodefinicion:tipocostodefinicions) {
					this.deepLoad(tipocostodefinicion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoCostoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoDefinicion(tipocostodefinicions);
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
			if(tipocostodefinicions!=null) {
				for(TipoCostoDefinicion tipocostodefinicion:tipocostodefinicions) {
					this.deepLoad(tipocostodefinicion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoCostoDefinicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCostoDefinicion(tipocostodefinicions);
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
			if(TipoCostoDefinicionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCostoDefinicionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoCostoDefinicion tipocostodefinicion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoCostoDefinicionConstantesFunciones.ISCONAUDITORIA) {
				if(tipocostodefinicion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCostoDefinicionDataAccess.TABLENAME, tipocostodefinicion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCostoDefinicionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCostoDefinicionLogic.registrarAuditoriaDetallesTipoCostoDefinicion(connexion,tipocostodefinicion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipocostodefinicion.getIsDeleted()) {
					/*if(!tipocostodefinicion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoCostoDefinicionDataAccess.TABLENAME, tipocostodefinicion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoCostoDefinicionLogic.registrarAuditoriaDetallesTipoCostoDefinicion(connexion,tipocostodefinicion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCostoDefinicionDataAccess.TABLENAME, tipocostodefinicion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipocostodefinicion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCostoDefinicionDataAccess.TABLENAME, tipocostodefinicion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCostoDefinicionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCostoDefinicionLogic.registrarAuditoriaDetallesTipoCostoDefinicion(connexion,tipocostodefinicion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoCostoDefinicion(Connexion connexion,TipoCostoDefinicion tipocostodefinicion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipocostodefinicion.getIsNew()||!tipocostodefinicion.getcodigo().equals(tipocostodefinicion.getTipoCostoDefinicionOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocostodefinicion.getTipoCostoDefinicionOriginal().getcodigo()!=null)
				{
					strValorActual=tipocostodefinicion.getTipoCostoDefinicionOriginal().getcodigo();
				}
				if(tipocostodefinicion.getcodigo()!=null)
				{
					strValorNuevo=tipocostodefinicion.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCostoDefinicionConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipocostodefinicion.getIsNew()||!tipocostodefinicion.getnombre().equals(tipocostodefinicion.getTipoCostoDefinicionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocostodefinicion.getTipoCostoDefinicionOriginal().getnombre()!=null)
				{
					strValorActual=tipocostodefinicion.getTipoCostoDefinicionOriginal().getnombre();
				}
				if(tipocostodefinicion.getnombre()!=null)
				{
					strValorNuevo=tipocostodefinicion.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCostoDefinicionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCostoDefinicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCostoDefinicionConstantesFunciones.getClassesForeignKeysOfTipoCostoDefinicion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCostoDefinicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCostoDefinicionConstantesFunciones.getClassesRelationshipsOfTipoCostoDefinicion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

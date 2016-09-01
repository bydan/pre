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
import com.bydan.erp.inventario.util.TipoIvaItemConstantesFunciones;
import com.bydan.erp.inventario.util.TipoIvaItemParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoIvaItemParameterGeneral;
import com.bydan.erp.inventario.business.entity.TipoIvaItem;
//import com.bydan.erp.inventario.business.logic.TipoIvaItemLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoIvaItemLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoIvaItemLogic.class);
	
	protected TipoIvaItemDataAccess tipoivaitemDataAccess; 	
	protected TipoIvaItem tipoivaitem;
	protected List<TipoIvaItem> tipoivaitems;
	protected Object tipoivaitemObject;	
	protected List<Object> tipoivaitemsObject;
	
	public static ClassValidator<TipoIvaItem> tipoivaitemValidator = new ClassValidator<TipoIvaItem>(TipoIvaItem.class);	
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
	
	
	
	
	public  TipoIvaItemLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoivaitemDataAccess = new TipoIvaItemDataAccess();
			
			this.tipoivaitems= new ArrayList<TipoIvaItem>();
			this.tipoivaitem= new TipoIvaItem();
			
			this.tipoivaitemObject=new Object();
			this.tipoivaitemsObject=new ArrayList<Object>();
				
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
			
			this.tipoivaitemDataAccess.setConnexionType(this.connexionType);
			this.tipoivaitemDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoIvaItemLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoivaitemDataAccess = new TipoIvaItemDataAccess();
			this.tipoivaitems= new ArrayList<TipoIvaItem>();
			this.tipoivaitem= new TipoIvaItem();
			this.tipoivaitemObject=new Object();
			this.tipoivaitemsObject=new ArrayList<Object>();
			
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
			
			this.tipoivaitemDataAccess.setConnexionType(this.connexionType);
			this.tipoivaitemDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoIvaItem getTipoIvaItem() throws Exception {	
		//TipoIvaItemLogicAdditional.checkTipoIvaItemToGet(tipoivaitem,this.datosCliente,this.arrDatoGeneral);
		//TipoIvaItemLogicAdditional.updateTipoIvaItemToGet(tipoivaitem,this.arrDatoGeneral);
		
		return tipoivaitem;
	}
		
	public void setTipoIvaItem(TipoIvaItem newTipoIvaItem) {
		this.tipoivaitem = newTipoIvaItem;
	}
	
	public TipoIvaItemDataAccess getTipoIvaItemDataAccess() {
		return tipoivaitemDataAccess;
	}
	
	public void setTipoIvaItemDataAccess(TipoIvaItemDataAccess newtipoivaitemDataAccess) {
		this.tipoivaitemDataAccess = newtipoivaitemDataAccess;
	}
	
	public List<TipoIvaItem> getTipoIvaItems() throws Exception {		
		this.quitarTipoIvaItemsNulos();
		
		//TipoIvaItemLogicAdditional.checkTipoIvaItemToGets(tipoivaitems,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoIvaItem tipoivaitemLocal: tipoivaitems ) {
			//TipoIvaItemLogicAdditional.updateTipoIvaItemToGet(tipoivaitemLocal,this.arrDatoGeneral);
		}
		
		return tipoivaitems;
	}
	
	public void setTipoIvaItems(List<TipoIvaItem> newTipoIvaItems) {
		this.tipoivaitems = newTipoIvaItems;
	}
	
	public Object getTipoIvaItemObject() {	
		this.tipoivaitemObject=this.tipoivaitemDataAccess.getEntityObject();
		return this.tipoivaitemObject;
	}
		
	public void setTipoIvaItemObject(Object newTipoIvaItemObject) {
		this.tipoivaitemObject = newTipoIvaItemObject;
	}
	
	public List<Object> getTipoIvaItemsObject() {		
		this.tipoivaitemsObject=this.tipoivaitemDataAccess.getEntitiesObject();
		return this.tipoivaitemsObject;
	}
		
	public void setTipoIvaItemsObject(List<Object> newTipoIvaItemsObject) {
		this.tipoivaitemsObject = newTipoIvaItemsObject;
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
		
		if(this.tipoivaitemDataAccess!=null) {
			this.tipoivaitemDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIvaItem.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoivaitemDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoivaitemDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoivaitem = new  TipoIvaItem();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIvaItem.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoivaitem=tipoivaitemDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoivaitem,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoIvaItemConstantesFunciones.refrescarForeignKeysDescripcionesTipoIvaItem(this.tipoivaitem);
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
		tipoivaitem = new  TipoIvaItem();
		  		  
        try {
			
			tipoivaitem=tipoivaitemDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoivaitem,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoIvaItemConstantesFunciones.refrescarForeignKeysDescripcionesTipoIvaItem(this.tipoivaitem);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoivaitem = new  TipoIvaItem();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIvaItem.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoivaitem=tipoivaitemDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoivaitem,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoIvaItemConstantesFunciones.refrescarForeignKeysDescripcionesTipoIvaItem(this.tipoivaitem);
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
		tipoivaitem = new  TipoIvaItem();
		  		  
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
		tipoivaitem = new  TipoIvaItem();
		  		  
        try {
			
			tipoivaitem=tipoivaitemDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoivaitem,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoIvaItemConstantesFunciones.refrescarForeignKeysDescripcionesTipoIvaItem(this.tipoivaitem);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoivaitem = new  TipoIvaItem();
		  		  
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
		tipoivaitem = new  TipoIvaItem();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIvaItem.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoivaitemDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoivaitem = new  TipoIvaItem();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoivaitemDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoivaitem = new  TipoIvaItem();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIvaItem.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoivaitemDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoivaitem = new  TipoIvaItem();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoivaitemDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoivaitem = new  TipoIvaItem();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIvaItem.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoivaitemDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoivaitem = new  TipoIvaItem();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoivaitemDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoivaitems = new  ArrayList<TipoIvaItem>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIvaItem.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoIvaItemLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoivaitems=tipoivaitemDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoIvaItem(tipoivaitems);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIvaItemConstantesFunciones.refrescarForeignKeysDescripcionesTipoIvaItem(this.tipoivaitems);
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
		tipoivaitems = new  ArrayList<TipoIvaItem>();
		  		  
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
		tipoivaitems = new  ArrayList<TipoIvaItem>();
		  		  
        try {			
			TipoIvaItemLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoivaitems=tipoivaitemDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoIvaItem(tipoivaitems);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIvaItemConstantesFunciones.refrescarForeignKeysDescripcionesTipoIvaItem(this.tipoivaitems);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoivaitems = new  ArrayList<TipoIvaItem>();
		  		  
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
		tipoivaitems = new  ArrayList<TipoIvaItem>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIvaItem.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoIvaItemLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoivaitems=tipoivaitemDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoIvaItem(tipoivaitems);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIvaItemConstantesFunciones.refrescarForeignKeysDescripcionesTipoIvaItem(this.tipoivaitems);
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
		tipoivaitems = new  ArrayList<TipoIvaItem>();
		  		  
        try {
			TipoIvaItemLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoivaitems=tipoivaitemDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoIvaItem(tipoivaitems);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIvaItemConstantesFunciones.refrescarForeignKeysDescripcionesTipoIvaItem(this.tipoivaitems);
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
		tipoivaitems = new  ArrayList<TipoIvaItem>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIvaItem.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIvaItemLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoivaitems=tipoivaitemDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoIvaItem(tipoivaitems);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIvaItemConstantesFunciones.refrescarForeignKeysDescripcionesTipoIvaItem(this.tipoivaitems);
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
		tipoivaitems = new  ArrayList<TipoIvaItem>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIvaItemLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoivaitems=tipoivaitemDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoIvaItem(tipoivaitems);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIvaItemConstantesFunciones.refrescarForeignKeysDescripcionesTipoIvaItem(this.tipoivaitems);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoivaitem = new  TipoIvaItem();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIvaItem.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIvaItemLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoivaitem=tipoivaitemDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoIvaItem(tipoivaitem);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIvaItemConstantesFunciones.refrescarForeignKeysDescripcionesTipoIvaItem(this.tipoivaitem);
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
		tipoivaitem = new  TipoIvaItem();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIvaItemLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoivaitem=tipoivaitemDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoIvaItem(tipoivaitem);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIvaItemConstantesFunciones.refrescarForeignKeysDescripcionesTipoIvaItem(this.tipoivaitem);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoIvaItemsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoivaitems = new  ArrayList<TipoIvaItem>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIvaItem.class.getSimpleName()+"-getTodosTipoIvaItemsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIvaItemLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoivaitems=tipoivaitemDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoIvaItem(tipoivaitems);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIvaItemConstantesFunciones.refrescarForeignKeysDescripcionesTipoIvaItem(this.tipoivaitems);
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
	
	public  void  getTodosTipoIvaItems(String sFinalQuery,Pagination pagination)throws Exception {
		tipoivaitems = new  ArrayList<TipoIvaItem>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIvaItemLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoivaitems=tipoivaitemDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoIvaItem(tipoivaitems);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIvaItemConstantesFunciones.refrescarForeignKeysDescripcionesTipoIvaItem(this.tipoivaitems);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoIvaItem(TipoIvaItem tipoivaitem) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoivaitem.getIsNew() || tipoivaitem.getIsChanged()) { 
			this.invalidValues = tipoivaitemValidator.getInvalidValues(tipoivaitem);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoivaitem);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoIvaItem(List<TipoIvaItem> TipoIvaItems) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoIvaItem tipoivaitemLocal:tipoivaitems) {				
			estaValidadoObjeto=this.validarGuardarTipoIvaItem(tipoivaitemLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoIvaItem(List<TipoIvaItem> TipoIvaItems) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoIvaItem(tipoivaitems)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoIvaItem(TipoIvaItem TipoIvaItem) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoIvaItem(tipoivaitem)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoIvaItem tipoivaitem) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoivaitem.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoIvaItemConstantesFunciones.getTipoIvaItemLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoivaitem","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoIvaItemConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoIvaItemConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoIvaItemWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIvaItem.class.getSimpleName()+"-saveTipoIvaItemWithConnection");connexion.begin();			
			
			//TipoIvaItemLogicAdditional.checkTipoIvaItemToSave(this.tipoivaitem,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoIvaItemLogicAdditional.updateTipoIvaItemToSave(this.tipoivaitem,this.arrDatoGeneral);
			
			TipoIvaItemLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoivaitem,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoIvaItem();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoIvaItem(this.tipoivaitem)) {
				TipoIvaItemDataAccess.save(this.tipoivaitem, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoivaitem,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoIvaItemLogicAdditional.checkTipoIvaItemToSaveAfter(this.tipoivaitem,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoIvaItem();
			
			connexion.commit();			
			
			if(this.tipoivaitem.getIsDeleted()) {
				this.tipoivaitem=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoIvaItem()throws Exception {	
		try {	
			
			//TipoIvaItemLogicAdditional.checkTipoIvaItemToSave(this.tipoivaitem,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoIvaItemLogicAdditional.updateTipoIvaItemToSave(this.tipoivaitem,this.arrDatoGeneral);
			
			TipoIvaItemLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoivaitem,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoIvaItem(this.tipoivaitem)) {			
				TipoIvaItemDataAccess.save(this.tipoivaitem, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoivaitem,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoIvaItemLogicAdditional.checkTipoIvaItemToSaveAfter(this.tipoivaitem,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoivaitem.getIsDeleted()) {
				this.tipoivaitem=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoIvaItemsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIvaItem.class.getSimpleName()+"-saveTipoIvaItemsWithConnection");connexion.begin();			
			
			//TipoIvaItemLogicAdditional.checkTipoIvaItemToSaves(tipoivaitems,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoIvaItems();
			
			Boolean validadoTodosTipoIvaItem=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoIvaItem tipoivaitemLocal:tipoivaitems) {		
				if(tipoivaitemLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoIvaItemLogicAdditional.updateTipoIvaItemToSave(tipoivaitemLocal,this.arrDatoGeneral);
	        	
				TipoIvaItemLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoivaitemLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoIvaItem(tipoivaitemLocal)) {
					TipoIvaItemDataAccess.save(tipoivaitemLocal, connexion);				
				} else {
					validadoTodosTipoIvaItem=false;
				}
			}
			
			if(!validadoTodosTipoIvaItem) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoIvaItemLogicAdditional.checkTipoIvaItemToSavesAfter(tipoivaitems,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoIvaItems();
			
			connexion.commit();		
			
			this.quitarTipoIvaItemsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoIvaItems()throws Exception {				
		 try {	
			//TipoIvaItemLogicAdditional.checkTipoIvaItemToSaves(tipoivaitems,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoIvaItem=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoIvaItem tipoivaitemLocal:tipoivaitems) {				
				if(tipoivaitemLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoIvaItemLogicAdditional.updateTipoIvaItemToSave(tipoivaitemLocal,this.arrDatoGeneral);
	        	
				TipoIvaItemLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoivaitemLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoIvaItem(tipoivaitemLocal)) {				
					TipoIvaItemDataAccess.save(tipoivaitemLocal, connexion);				
				} else {
					validadoTodosTipoIvaItem=false;
				}
			}
			
			if(!validadoTodosTipoIvaItem) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoIvaItemLogicAdditional.checkTipoIvaItemToSavesAfter(tipoivaitems,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoIvaItemsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoIvaItemParameterReturnGeneral procesarAccionTipoIvaItems(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoIvaItem> tipoivaitems,TipoIvaItemParameterReturnGeneral tipoivaitemParameterGeneral)throws Exception {
		 try {	
			TipoIvaItemParameterReturnGeneral tipoivaitemReturnGeneral=new TipoIvaItemParameterReturnGeneral();
	
			
			return tipoivaitemReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoIvaItemParameterReturnGeneral procesarAccionTipoIvaItemsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoIvaItem> tipoivaitems,TipoIvaItemParameterReturnGeneral tipoivaitemParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIvaItem.class.getSimpleName()+"-procesarAccionTipoIvaItemsWithConnection");connexion.begin();			
			
			TipoIvaItemParameterReturnGeneral tipoivaitemReturnGeneral=new TipoIvaItemParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipoivaitemReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoIvaItemParameterReturnGeneral procesarEventosTipoIvaItems(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoIvaItem> tipoivaitems,TipoIvaItem tipoivaitem,TipoIvaItemParameterReturnGeneral tipoivaitemParameterGeneral,Boolean isEsNuevoTipoIvaItem,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoIvaItemParameterReturnGeneral tipoivaitemReturnGeneral=new TipoIvaItemParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoivaitemReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipoivaitemReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoIvaItemParameterReturnGeneral procesarEventosTipoIvaItemsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoIvaItem> tipoivaitems,TipoIvaItem tipoivaitem,TipoIvaItemParameterReturnGeneral tipoivaitemParameterGeneral,Boolean isEsNuevoTipoIvaItem,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIvaItem.class.getSimpleName()+"-procesarEventosTipoIvaItemsWithConnection");connexion.begin();			
			
			TipoIvaItemParameterReturnGeneral tipoivaitemReturnGeneral=new TipoIvaItemParameterReturnGeneral();
	
			tipoivaitemReturnGeneral.setTipoIvaItem(tipoivaitem);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoivaitemReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipoivaitemReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoIvaItemParameterReturnGeneral procesarImportacionTipoIvaItemsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoIvaItemParameterReturnGeneral tipoivaitemParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIvaItem.class.getSimpleName()+"-procesarImportacionTipoIvaItemsWithConnection");connexion.begin();			
			
			TipoIvaItemParameterReturnGeneral tipoivaitemReturnGeneral=new TipoIvaItemParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoivaitems=new ArrayList<TipoIvaItem>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoivaitem=new TipoIvaItem();
				
				
				if(conColumnasBase) {this.tipoivaitem.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoivaitem.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoivaitem.setcodigo(arrColumnas[iColumn++]);
				this.tipoivaitem.setnombre(arrColumnas[iColumn++]);
				
				this.tipoivaitems.add(this.tipoivaitem);
			}
			
			this.saveTipoIvaItems();
			
			this.connexion.commit();
			
			tipoivaitemReturnGeneral.setConRetornoEstaProcesado(true);
			tipoivaitemReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoivaitemReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoIvaItemsEliminados() throws Exception {				
		
		List<TipoIvaItem> tipoivaitemsAux= new ArrayList<TipoIvaItem>();
		
		for(TipoIvaItem tipoivaitem:tipoivaitems) {
			if(!tipoivaitem.getIsDeleted()) {
				tipoivaitemsAux.add(tipoivaitem);
			}
		}
		
		tipoivaitems=tipoivaitemsAux;
	}
	
	public void quitarTipoIvaItemsNulos() throws Exception {				
		
		List<TipoIvaItem> tipoivaitemsAux= new ArrayList<TipoIvaItem>();
		
		for(TipoIvaItem tipoivaitem : this.tipoivaitems) {
			if(tipoivaitem==null) {
				tipoivaitemsAux.add(tipoivaitem);
			}
		}
		
		//this.tipoivaitems=tipoivaitemsAux;
		
		this.tipoivaitems.removeAll(tipoivaitemsAux);
	}
	
	public void getSetVersionRowTipoIvaItemWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoivaitem.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoivaitem.getIsDeleted() || (tipoivaitem.getIsChanged()&&!tipoivaitem.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoivaitemDataAccess.getSetVersionRowTipoIvaItem(connexion,tipoivaitem.getId());
				
				if(!tipoivaitem.getVersionRow().equals(timestamp)) {	
					tipoivaitem.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoivaitem.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoIvaItem()throws Exception {	
		
		if(tipoivaitem.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoivaitem.getIsDeleted() || (tipoivaitem.getIsChanged()&&!tipoivaitem.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoivaitemDataAccess.getSetVersionRowTipoIvaItem(connexion,tipoivaitem.getId());
			
			try {							
				if(!tipoivaitem.getVersionRow().equals(timestamp)) {	
					tipoivaitem.setVersionRow(timestamp);
				}
				
				tipoivaitem.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoIvaItemsWithConnection()throws Exception {	
		if(tipoivaitems!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoIvaItem tipoivaitemAux:tipoivaitems) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoivaitemAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoivaitemAux.getIsDeleted() || (tipoivaitemAux.getIsChanged()&&!tipoivaitemAux.getIsNew())) {
						
						timestamp=tipoivaitemDataAccess.getSetVersionRowTipoIvaItem(connexion,tipoivaitemAux.getId());
						
						if(!tipoivaitem.getVersionRow().equals(timestamp)) {	
							tipoivaitemAux.setVersionRow(timestamp);
						}
								
						tipoivaitemAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoIvaItems()throws Exception {	
		if(tipoivaitems!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoIvaItem tipoivaitemAux:tipoivaitems) {
					if(tipoivaitemAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoivaitemAux.getIsDeleted() || (tipoivaitemAux.getIsChanged()&&!tipoivaitemAux.getIsNew())) {
						
						timestamp=tipoivaitemDataAccess.getSetVersionRowTipoIvaItem(connexion,tipoivaitemAux.getId());
						
						if(!tipoivaitemAux.getVersionRow().equals(timestamp)) {	
							tipoivaitemAux.setVersionRow(timestamp);
						}
						
													
						tipoivaitemAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoIvaItemWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DefinicionLogic definicionLogic=new DefinicionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIvaItem.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoIvaItemWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Definicion.class));
											
			

			definicionLogic.setConnexion(this.getConnexion());
			definicionLogic.setDatosCliente(this.datosCliente);
			definicionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoIvaItem tipoivaitem:this.tipoivaitems) {
				

				classes=new ArrayList<Classe>();
				classes=DefinicionConstantesFunciones.getClassesForeignKeysOfDefinicion(new ArrayList<Classe>(),DeepLoadType.NONE);

				definicionLogic.setDefinicions(tipoivaitem.definicions);
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
	
	public void deepLoad(TipoIvaItem tipoivaitem,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoIvaItemLogicAdditional.updateTipoIvaItemToGet(tipoivaitem,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoivaitem.setDefinicions(tipoivaitemDataAccess.getDefinicions(connexion,tipoivaitem));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoivaitem.setDefinicions(tipoivaitemDataAccess.getDefinicions(connexion,tipoivaitem));

				if(this.isConDeep) {
					DefinicionLogic definicionLogic= new DefinicionLogic(this.connexion);
					definicionLogic.setDefinicions(tipoivaitem.getDefinicions());
					ArrayList<Classe> classesLocal=DefinicionConstantesFunciones.getClassesForeignKeysOfDefinicion(new ArrayList<Classe>(),DeepLoadType.NONE);
					definicionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DefinicionConstantesFunciones.refrescarForeignKeysDescripcionesDefinicion(definicionLogic.getDefinicions());
					tipoivaitem.setDefinicions(definicionLogic.getDefinicions());
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
			tipoivaitem.setDefinicions(tipoivaitemDataAccess.getDefinicions(connexion,tipoivaitem));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipoivaitem.setDefinicions(tipoivaitemDataAccess.getDefinicions(connexion,tipoivaitem));

		for(Definicion definicion:tipoivaitem.getDefinicions()) {
			DefinicionLogic definicionLogic= new DefinicionLogic(connexion);
			definicionLogic.deepLoad(definicion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Definicion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoivaitem.setDefinicions(tipoivaitemDataAccess.getDefinicions(connexion,tipoivaitem));

				for(Definicion definicion:tipoivaitem.getDefinicions()) {
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
			tipoivaitem.setDefinicions(tipoivaitemDataAccess.getDefinicions(connexion,tipoivaitem));

			for(Definicion definicion:tipoivaitem.getDefinicions()) {
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
	
	public void deepSave(TipoIvaItem tipoivaitem,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoIvaItem.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoivaitem,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoIvaItemConstantesFunciones.refrescarForeignKeysDescripcionesTipoIvaItem(tipoivaitem);
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
			this.deepLoad(this.tipoivaitem,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoIvaItemConstantesFunciones.refrescarForeignKeysDescripcionesTipoIvaItem(this.tipoivaitem);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoIvaItem.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoivaitems!=null) {
				for(TipoIvaItem tipoivaitem:tipoivaitems) {
					this.deepLoad(tipoivaitem,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoIvaItemConstantesFunciones.refrescarForeignKeysDescripcionesTipoIvaItem(tipoivaitems);
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
			if(tipoivaitems!=null) {
				for(TipoIvaItem tipoivaitem:tipoivaitems) {
					this.deepLoad(tipoivaitem,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoIvaItemConstantesFunciones.refrescarForeignKeysDescripcionesTipoIvaItem(tipoivaitems);
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
			if(TipoIvaItemConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoIvaItemDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoIvaItem tipoivaitem,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoIvaItemConstantesFunciones.ISCONAUDITORIA) {
				if(tipoivaitem.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoIvaItemDataAccess.TABLENAME, tipoivaitem.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoIvaItemConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoIvaItemLogic.registrarAuditoriaDetallesTipoIvaItem(connexion,tipoivaitem,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoivaitem.getIsDeleted()) {
					/*if(!tipoivaitem.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoIvaItemDataAccess.TABLENAME, tipoivaitem.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoIvaItemLogic.registrarAuditoriaDetallesTipoIvaItem(connexion,tipoivaitem,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoIvaItemDataAccess.TABLENAME, tipoivaitem.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoivaitem.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoIvaItemDataAccess.TABLENAME, tipoivaitem.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoIvaItemConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoIvaItemLogic.registrarAuditoriaDetallesTipoIvaItem(connexion,tipoivaitem,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoIvaItem(Connexion connexion,TipoIvaItem tipoivaitem)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoivaitem.getIsNew()||!tipoivaitem.getcodigo().equals(tipoivaitem.getTipoIvaItemOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoivaitem.getTipoIvaItemOriginal().getcodigo()!=null)
				{
					strValorActual=tipoivaitem.getTipoIvaItemOriginal().getcodigo();
				}
				if(tipoivaitem.getcodigo()!=null)
				{
					strValorNuevo=tipoivaitem.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoIvaItemConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoivaitem.getIsNew()||!tipoivaitem.getnombre().equals(tipoivaitem.getTipoIvaItemOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoivaitem.getTipoIvaItemOriginal().getnombre()!=null)
				{
					strValorActual=tipoivaitem.getTipoIvaItemOriginal().getnombre();
				}
				if(tipoivaitem.getnombre()!=null)
				{
					strValorNuevo=tipoivaitem.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoIvaItemConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoIvaItem(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoIvaItemConstantesFunciones.getClassesForeignKeysOfTipoIvaItem(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoIvaItem(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoIvaItemConstantesFunciones.getClassesRelationshipsOfTipoIvaItem(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

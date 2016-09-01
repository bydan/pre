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
package com.bydan.erp.produccion.business.logic;

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
import com.bydan.erp.produccion.util.*;
import com.bydan.erp.produccion.util.TipoGastoProduConstantesFunciones;
import com.bydan.erp.produccion.util.TipoGastoProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.TipoGastoProduParameterGeneral;
import com.bydan.erp.produccion.business.entity.TipoGastoProdu;
//import com.bydan.erp.produccion.business.logic.TipoGastoProduLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoGastoProduLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoGastoProduLogic.class);
	
	protected TipoGastoProduDataAccess tipogastoproduDataAccess; 	
	protected TipoGastoProdu tipogastoprodu;
	protected List<TipoGastoProdu> tipogastoprodus;
	protected Object tipogastoproduObject;	
	protected List<Object> tipogastoprodusObject;
	
	public static ClassValidator<TipoGastoProdu> tipogastoproduValidator = new ClassValidator<TipoGastoProdu>(TipoGastoProdu.class);	
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
	
	
	
	
	public  TipoGastoProduLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipogastoproduDataAccess = new TipoGastoProduDataAccess();
			
			this.tipogastoprodus= new ArrayList<TipoGastoProdu>();
			this.tipogastoprodu= new TipoGastoProdu();
			
			this.tipogastoproduObject=new Object();
			this.tipogastoprodusObject=new ArrayList<Object>();
				
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
			
			this.tipogastoproduDataAccess.setConnexionType(this.connexionType);
			this.tipogastoproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoGastoProduLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipogastoproduDataAccess = new TipoGastoProduDataAccess();
			this.tipogastoprodus= new ArrayList<TipoGastoProdu>();
			this.tipogastoprodu= new TipoGastoProdu();
			this.tipogastoproduObject=new Object();
			this.tipogastoprodusObject=new ArrayList<Object>();
			
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
			
			this.tipogastoproduDataAccess.setConnexionType(this.connexionType);
			this.tipogastoproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoGastoProdu getTipoGastoProdu() throws Exception {	
		//TipoGastoProduLogicAdditional.checkTipoGastoProduToGet(tipogastoprodu,this.datosCliente,this.arrDatoGeneral);
		//TipoGastoProduLogicAdditional.updateTipoGastoProduToGet(tipogastoprodu,this.arrDatoGeneral);
		
		return tipogastoprodu;
	}
		
	public void setTipoGastoProdu(TipoGastoProdu newTipoGastoProdu) {
		this.tipogastoprodu = newTipoGastoProdu;
	}
	
	public TipoGastoProduDataAccess getTipoGastoProduDataAccess() {
		return tipogastoproduDataAccess;
	}
	
	public void setTipoGastoProduDataAccess(TipoGastoProduDataAccess newtipogastoproduDataAccess) {
		this.tipogastoproduDataAccess = newtipogastoproduDataAccess;
	}
	
	public List<TipoGastoProdu> getTipoGastoProdus() throws Exception {		
		this.quitarTipoGastoProdusNulos();
		
		//TipoGastoProduLogicAdditional.checkTipoGastoProduToGets(tipogastoprodus,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoGastoProdu tipogastoproduLocal: tipogastoprodus ) {
			//TipoGastoProduLogicAdditional.updateTipoGastoProduToGet(tipogastoproduLocal,this.arrDatoGeneral);
		}
		
		return tipogastoprodus;
	}
	
	public void setTipoGastoProdus(List<TipoGastoProdu> newTipoGastoProdus) {
		this.tipogastoprodus = newTipoGastoProdus;
	}
	
	public Object getTipoGastoProduObject() {	
		this.tipogastoproduObject=this.tipogastoproduDataAccess.getEntityObject();
		return this.tipogastoproduObject;
	}
		
	public void setTipoGastoProduObject(Object newTipoGastoProduObject) {
		this.tipogastoproduObject = newTipoGastoProduObject;
	}
	
	public List<Object> getTipoGastoProdusObject() {		
		this.tipogastoprodusObject=this.tipogastoproduDataAccess.getEntitiesObject();
		return this.tipogastoprodusObject;
	}
		
	public void setTipoGastoProdusObject(List<Object> newTipoGastoProdusObject) {
		this.tipogastoprodusObject = newTipoGastoProdusObject;
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
		
		if(this.tipogastoproduDataAccess!=null) {
			this.tipogastoproduDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProdu.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipogastoproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipogastoproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipogastoprodu = new  TipoGastoProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipogastoprodu=tipogastoproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogastoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGastoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProdu(this.tipogastoprodu);
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
		tipogastoprodu = new  TipoGastoProdu();
		  		  
        try {
			
			tipogastoprodu=tipogastoproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogastoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGastoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProdu(this.tipogastoprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipogastoprodu = new  TipoGastoProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipogastoprodu=tipogastoproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogastoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGastoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProdu(this.tipogastoprodu);
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
		tipogastoprodu = new  TipoGastoProdu();
		  		  
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
		tipogastoprodu = new  TipoGastoProdu();
		  		  
        try {
			
			tipogastoprodu=tipogastoproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogastoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGastoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProdu(this.tipogastoprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipogastoprodu = new  TipoGastoProdu();
		  		  
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
		tipogastoprodu = new  TipoGastoProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProdu.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipogastoproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogastoprodu = new  TipoGastoProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipogastoproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipogastoprodu = new  TipoGastoProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProdu.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipogastoproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogastoprodu = new  TipoGastoProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipogastoproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipogastoprodu = new  TipoGastoProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProdu.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipogastoproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogastoprodu = new  TipoGastoProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipogastoproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipogastoprodus = new  ArrayList<TipoGastoProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoGastoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoprodus=tipogastoproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGastoProdu(tipogastoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProdu(this.tipogastoprodus);
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
		tipogastoprodus = new  ArrayList<TipoGastoProdu>();
		  		  
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
		tipogastoprodus = new  ArrayList<TipoGastoProdu>();
		  		  
        try {			
			TipoGastoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoprodus=tipogastoproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoGastoProdu(tipogastoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProdu(this.tipogastoprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipogastoprodus = new  ArrayList<TipoGastoProdu>();
		  		  
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
		tipogastoprodus = new  ArrayList<TipoGastoProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoGastoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoprodus=tipogastoproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGastoProdu(tipogastoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProdu(this.tipogastoprodus);
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
		tipogastoprodus = new  ArrayList<TipoGastoProdu>();
		  		  
        try {
			TipoGastoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoprodus=tipogastoproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGastoProdu(tipogastoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProdu(this.tipogastoprodus);
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
		tipogastoprodus = new  ArrayList<TipoGastoProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGastoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoprodus=tipogastoproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGastoProdu(tipogastoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProdu(this.tipogastoprodus);
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
		tipogastoprodus = new  ArrayList<TipoGastoProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGastoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoprodus=tipogastoproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGastoProdu(tipogastoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProdu(this.tipogastoprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipogastoprodu = new  TipoGastoProdu();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGastoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoprodu=tipogastoproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGastoProdu(tipogastoprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProdu(this.tipogastoprodu);
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
		tipogastoprodu = new  TipoGastoProdu();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGastoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoprodu=tipogastoproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGastoProdu(tipogastoprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProdu(this.tipogastoprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoGastoProdusWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipogastoprodus = new  ArrayList<TipoGastoProdu>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProdu.class.getSimpleName()+"-getTodosTipoGastoProdusWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGastoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoprodus=tipogastoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoGastoProdu(tipogastoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProdu(this.tipogastoprodus);
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
	
	public  void  getTodosTipoGastoProdus(String sFinalQuery,Pagination pagination)throws Exception {
		tipogastoprodus = new  ArrayList<TipoGastoProdu>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGastoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogastoprodus=tipogastoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoGastoProdu(tipogastoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGastoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProdu(this.tipogastoprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoGastoProdu(TipoGastoProdu tipogastoprodu) throws Exception {
		Boolean estaValidado=false;
		
		if(tipogastoprodu.getIsNew() || tipogastoprodu.getIsChanged()) { 
			this.invalidValues = tipogastoproduValidator.getInvalidValues(tipogastoprodu);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipogastoprodu);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoGastoProdu(List<TipoGastoProdu> TipoGastoProdus) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoGastoProdu tipogastoproduLocal:tipogastoprodus) {				
			estaValidadoObjeto=this.validarGuardarTipoGastoProdu(tipogastoproduLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoGastoProdu(List<TipoGastoProdu> TipoGastoProdus) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoGastoProdu(tipogastoprodus)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoGastoProdu(TipoGastoProdu TipoGastoProdu) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoGastoProdu(tipogastoprodu)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoGastoProdu tipogastoprodu) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipogastoprodu.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoGastoProduConstantesFunciones.getTipoGastoProduLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipogastoprodu","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoGastoProduConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoGastoProduConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoGastoProduWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProdu.class.getSimpleName()+"-saveTipoGastoProduWithConnection");connexion.begin();			
			
			//TipoGastoProduLogicAdditional.checkTipoGastoProduToSave(this.tipogastoprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoGastoProduLogicAdditional.updateTipoGastoProduToSave(this.tipogastoprodu,this.arrDatoGeneral);
			
			TipoGastoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipogastoprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoGastoProdu();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoGastoProdu(this.tipogastoprodu)) {
				TipoGastoProduDataAccess.save(this.tipogastoprodu, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipogastoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoGastoProduLogicAdditional.checkTipoGastoProduToSaveAfter(this.tipogastoprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoGastoProdu();
			
			connexion.commit();			
			
			if(this.tipogastoprodu.getIsDeleted()) {
				this.tipogastoprodu=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoGastoProdu()throws Exception {	
		try {	
			
			//TipoGastoProduLogicAdditional.checkTipoGastoProduToSave(this.tipogastoprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoGastoProduLogicAdditional.updateTipoGastoProduToSave(this.tipogastoprodu,this.arrDatoGeneral);
			
			TipoGastoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipogastoprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoGastoProdu(this.tipogastoprodu)) {			
				TipoGastoProduDataAccess.save(this.tipogastoprodu, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipogastoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoGastoProduLogicAdditional.checkTipoGastoProduToSaveAfter(this.tipogastoprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipogastoprodu.getIsDeleted()) {
				this.tipogastoprodu=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoGastoProdusWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProdu.class.getSimpleName()+"-saveTipoGastoProdusWithConnection");connexion.begin();			
			
			//TipoGastoProduLogicAdditional.checkTipoGastoProduToSaves(tipogastoprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoGastoProdus();
			
			Boolean validadoTodosTipoGastoProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoGastoProdu tipogastoproduLocal:tipogastoprodus) {		
				if(tipogastoproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoGastoProduLogicAdditional.updateTipoGastoProduToSave(tipogastoproduLocal,this.arrDatoGeneral);
	        	
				TipoGastoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipogastoproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoGastoProdu(tipogastoproduLocal)) {
					TipoGastoProduDataAccess.save(tipogastoproduLocal, connexion);				
				} else {
					validadoTodosTipoGastoProdu=false;
				}
			}
			
			if(!validadoTodosTipoGastoProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoGastoProduLogicAdditional.checkTipoGastoProduToSavesAfter(tipogastoprodus,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoGastoProdus();
			
			connexion.commit();		
			
			this.quitarTipoGastoProdusEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoGastoProdus()throws Exception {				
		 try {	
			//TipoGastoProduLogicAdditional.checkTipoGastoProduToSaves(tipogastoprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoGastoProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoGastoProdu tipogastoproduLocal:tipogastoprodus) {				
				if(tipogastoproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoGastoProduLogicAdditional.updateTipoGastoProduToSave(tipogastoproduLocal,this.arrDatoGeneral);
	        	
				TipoGastoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipogastoproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoGastoProdu(tipogastoproduLocal)) {				
					TipoGastoProduDataAccess.save(tipogastoproduLocal, connexion);				
				} else {
					validadoTodosTipoGastoProdu=false;
				}
			}
			
			if(!validadoTodosTipoGastoProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoGastoProduLogicAdditional.checkTipoGastoProduToSavesAfter(tipogastoprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoGastoProdusEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoGastoProduParameterReturnGeneral procesarAccionTipoGastoProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoGastoProdu> tipogastoprodus,TipoGastoProduParameterReturnGeneral tipogastoproduParameterGeneral)throws Exception {
		 try {	
			TipoGastoProduParameterReturnGeneral tipogastoproduReturnGeneral=new TipoGastoProduParameterReturnGeneral();
	
			
			return tipogastoproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoGastoProduParameterReturnGeneral procesarAccionTipoGastoProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoGastoProdu> tipogastoprodus,TipoGastoProduParameterReturnGeneral tipogastoproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProdu.class.getSimpleName()+"-procesarAccionTipoGastoProdusWithConnection");connexion.begin();			
			
			TipoGastoProduParameterReturnGeneral tipogastoproduReturnGeneral=new TipoGastoProduParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipogastoproduReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoGastoProduParameterReturnGeneral procesarEventosTipoGastoProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoGastoProdu> tipogastoprodus,TipoGastoProdu tipogastoprodu,TipoGastoProduParameterReturnGeneral tipogastoproduParameterGeneral,Boolean isEsNuevoTipoGastoProdu,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoGastoProduParameterReturnGeneral tipogastoproduReturnGeneral=new TipoGastoProduParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipogastoproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipogastoproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoGastoProduParameterReturnGeneral procesarEventosTipoGastoProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoGastoProdu> tipogastoprodus,TipoGastoProdu tipogastoprodu,TipoGastoProduParameterReturnGeneral tipogastoproduParameterGeneral,Boolean isEsNuevoTipoGastoProdu,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProdu.class.getSimpleName()+"-procesarEventosTipoGastoProdusWithConnection");connexion.begin();			
			
			TipoGastoProduParameterReturnGeneral tipogastoproduReturnGeneral=new TipoGastoProduParameterReturnGeneral();
	
			tipogastoproduReturnGeneral.setTipoGastoProdu(tipogastoprodu);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipogastoproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipogastoproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoGastoProduParameterReturnGeneral procesarImportacionTipoGastoProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoGastoProduParameterReturnGeneral tipogastoproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProdu.class.getSimpleName()+"-procesarImportacionTipoGastoProdusWithConnection");connexion.begin();			
			
			TipoGastoProduParameterReturnGeneral tipogastoproduReturnGeneral=new TipoGastoProduParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipogastoprodus=new ArrayList<TipoGastoProdu>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipogastoprodu=new TipoGastoProdu();
				
				
				if(conColumnasBase) {this.tipogastoprodu.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipogastoprodu.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipogastoprodu.setnombre(arrColumnas[iColumn++]);
				this.tipogastoprodu.setdescripcion(arrColumnas[iColumn++]);
				
				this.tipogastoprodus.add(this.tipogastoprodu);
			}
			
			this.saveTipoGastoProdus();
			
			this.connexion.commit();
			
			tipogastoproduReturnGeneral.setConRetornoEstaProcesado(true);
			tipogastoproduReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipogastoproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoGastoProdusEliminados() throws Exception {				
		
		List<TipoGastoProdu> tipogastoprodusAux= new ArrayList<TipoGastoProdu>();
		
		for(TipoGastoProdu tipogastoprodu:tipogastoprodus) {
			if(!tipogastoprodu.getIsDeleted()) {
				tipogastoprodusAux.add(tipogastoprodu);
			}
		}
		
		tipogastoprodus=tipogastoprodusAux;
	}
	
	public void quitarTipoGastoProdusNulos() throws Exception {				
		
		List<TipoGastoProdu> tipogastoprodusAux= new ArrayList<TipoGastoProdu>();
		
		for(TipoGastoProdu tipogastoprodu : this.tipogastoprodus) {
			if(tipogastoprodu==null) {
				tipogastoprodusAux.add(tipogastoprodu);
			}
		}
		
		//this.tipogastoprodus=tipogastoprodusAux;
		
		this.tipogastoprodus.removeAll(tipogastoprodusAux);
	}
	
	public void getSetVersionRowTipoGastoProduWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipogastoprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipogastoprodu.getIsDeleted() || (tipogastoprodu.getIsChanged()&&!tipogastoprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipogastoproduDataAccess.getSetVersionRowTipoGastoProdu(connexion,tipogastoprodu.getId());
				
				if(!tipogastoprodu.getVersionRow().equals(timestamp)) {	
					tipogastoprodu.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipogastoprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoGastoProdu()throws Exception {	
		
		if(tipogastoprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipogastoprodu.getIsDeleted() || (tipogastoprodu.getIsChanged()&&!tipogastoprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipogastoproduDataAccess.getSetVersionRowTipoGastoProdu(connexion,tipogastoprodu.getId());
			
			try {							
				if(!tipogastoprodu.getVersionRow().equals(timestamp)) {	
					tipogastoprodu.setVersionRow(timestamp);
				}
				
				tipogastoprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoGastoProdusWithConnection()throws Exception {	
		if(tipogastoprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoGastoProdu tipogastoproduAux:tipogastoprodus) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipogastoproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipogastoproduAux.getIsDeleted() || (tipogastoproduAux.getIsChanged()&&!tipogastoproduAux.getIsNew())) {
						
						timestamp=tipogastoproduDataAccess.getSetVersionRowTipoGastoProdu(connexion,tipogastoproduAux.getId());
						
						if(!tipogastoprodu.getVersionRow().equals(timestamp)) {	
							tipogastoproduAux.setVersionRow(timestamp);
						}
								
						tipogastoproduAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoGastoProdus()throws Exception {	
		if(tipogastoprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoGastoProdu tipogastoproduAux:tipogastoprodus) {
					if(tipogastoproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipogastoproduAux.getIsDeleted() || (tipogastoproduAux.getIsChanged()&&!tipogastoproduAux.getIsNew())) {
						
						timestamp=tipogastoproduDataAccess.getSetVersionRowTipoGastoProdu(connexion,tipogastoproduAux.getId());
						
						if(!tipogastoproduAux.getVersionRow().equals(timestamp)) {	
							tipogastoproduAux.setVersionRow(timestamp);
						}
						
													
						tipogastoproduAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoGastoProduParameterReturnGeneral cargarCombosLoteForeignKeyTipoGastoProduWithConnection(String finalQueryGlobalPais) throws Exception {
		TipoGastoProduParameterReturnGeneral  tipogastoproduReturnGeneral =new TipoGastoProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProdu.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoGastoProduWithConnection");connexion.begin();
			
			tipogastoproduReturnGeneral =new TipoGastoProduParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			tipogastoproduReturnGeneral.setpaissForeignKey(paissForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipogastoproduReturnGeneral;
	}
	
	public TipoGastoProduParameterReturnGeneral cargarCombosLoteForeignKeyTipoGastoProdu(String finalQueryGlobalPais) throws Exception {
		TipoGastoProduParameterReturnGeneral  tipogastoproduReturnGeneral =new TipoGastoProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipogastoproduReturnGeneral =new TipoGastoProduParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			tipogastoproduReturnGeneral.setpaissForeignKey(paissForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipogastoproduReturnGeneral;
	}
	
	
	public void deepLoad(TipoGastoProdu tipogastoprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoGastoProduLogicAdditional.updateTipoGastoProduToGet(tipogastoprodu,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipogastoprodu.setPais(tipogastoproduDataAccess.getPais(connexion,tipogastoprodu));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				tipogastoprodu.setPais(tipogastoproduDataAccess.getPais(connexion,tipogastoprodu));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipogastoprodu.setPais(tipogastoproduDataAccess.getPais(connexion,tipogastoprodu));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipogastoprodu.setPais(tipogastoproduDataAccess.getPais(connexion,tipogastoprodu));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(tipogastoprodu.getPais(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				tipogastoprodu.setPais(tipogastoproduDataAccess.getPais(connexion,tipogastoprodu));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(tipogastoprodu.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipogastoprodu.setPais(tipogastoproduDataAccess.getPais(connexion,tipogastoprodu));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(tipogastoprodu.getPais(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoGastoProdu tipogastoprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoGastoProdu.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipogastoprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoGastoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProdu(tipogastoprodu);
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
			this.deepLoad(this.tipogastoprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoGastoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProdu(this.tipogastoprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoGastoProdu.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipogastoprodus!=null) {
				for(TipoGastoProdu tipogastoprodu:tipogastoprodus) {
					this.deepLoad(tipogastoprodu,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoGastoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProdu(tipogastoprodus);
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
			if(tipogastoprodus!=null) {
				for(TipoGastoProdu tipogastoprodu:tipogastoprodus) {
					this.deepLoad(tipogastoprodu,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoGastoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProdu(tipogastoprodus);
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
	
	
	public void getTipoGastoProdusFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGastoProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,TipoGastoProduConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			TipoGastoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoprodus=tipogastoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProdu(this.tipogastoprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGastoProdusFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,TipoGastoProduConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			TipoGastoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogastoprodus=tipogastoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGastoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoGastoProdu(this.tipogastoprodus);
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
			if(TipoGastoProduConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGastoProduDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoGastoProdu tipogastoprodu,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoGastoProduConstantesFunciones.ISCONAUDITORIA) {
				if(tipogastoprodu.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGastoProduDataAccess.TABLENAME, tipogastoprodu.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoGastoProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoGastoProduLogic.registrarAuditoriaDetallesTipoGastoProdu(connexion,tipogastoprodu,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipogastoprodu.getIsDeleted()) {
					/*if(!tipogastoprodu.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoGastoProduDataAccess.TABLENAME, tipogastoprodu.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoGastoProduLogic.registrarAuditoriaDetallesTipoGastoProdu(connexion,tipogastoprodu,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGastoProduDataAccess.TABLENAME, tipogastoprodu.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipogastoprodu.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGastoProduDataAccess.TABLENAME, tipogastoprodu.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoGastoProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoGastoProduLogic.registrarAuditoriaDetallesTipoGastoProdu(connexion,tipogastoprodu,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoGastoProdu(Connexion connexion,TipoGastoProdu tipogastoprodu)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipogastoprodu.getIsNew()||!tipogastoprodu.getid_pais().equals(tipogastoprodu.getTipoGastoProduOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogastoprodu.getTipoGastoProduOriginal().getid_pais()!=null)
				{
					strValorActual=tipogastoprodu.getTipoGastoProduOriginal().getid_pais().toString();
				}
				if(tipogastoprodu.getid_pais()!=null)
				{
					strValorNuevo=tipogastoprodu.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGastoProduConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(tipogastoprodu.getIsNew()||!tipogastoprodu.getnombre().equals(tipogastoprodu.getTipoGastoProduOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogastoprodu.getTipoGastoProduOriginal().getnombre()!=null)
				{
					strValorActual=tipogastoprodu.getTipoGastoProduOriginal().getnombre();
				}
				if(tipogastoprodu.getnombre()!=null)
				{
					strValorNuevo=tipogastoprodu.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGastoProduConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipogastoprodu.getIsNew()||!tipogastoprodu.getdescripcion().equals(tipogastoprodu.getTipoGastoProduOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogastoprodu.getTipoGastoProduOriginal().getdescripcion()!=null)
				{
					strValorActual=tipogastoprodu.getTipoGastoProduOriginal().getdescripcion();
				}
				if(tipogastoprodu.getdescripcion()!=null)
				{
					strValorNuevo=tipogastoprodu.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGastoProduConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoGastoProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoGastoProduConstantesFunciones.getClassesForeignKeysOfTipoGastoProdu(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGastoProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoGastoProduConstantesFunciones.getClassesRelationshipsOfTipoGastoProdu(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

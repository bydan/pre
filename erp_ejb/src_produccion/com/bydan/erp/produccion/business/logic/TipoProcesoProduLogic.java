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
import com.bydan.erp.produccion.util.TipoProcesoProduConstantesFunciones;
import com.bydan.erp.produccion.util.TipoProcesoProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.TipoProcesoProduParameterGeneral;
import com.bydan.erp.produccion.business.entity.TipoProcesoProdu;
//import com.bydan.erp.produccion.business.logic.TipoProcesoProduLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoProcesoProduLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoProcesoProduLogic.class);
	
	protected TipoProcesoProduDataAccess tipoprocesoproduDataAccess; 	
	protected TipoProcesoProdu tipoprocesoprodu;
	protected List<TipoProcesoProdu> tipoprocesoprodus;
	protected Object tipoprocesoproduObject;	
	protected List<Object> tipoprocesoprodusObject;
	
	public static ClassValidator<TipoProcesoProdu> tipoprocesoproduValidator = new ClassValidator<TipoProcesoProdu>(TipoProcesoProdu.class);	
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
	
	
	
	
	public  TipoProcesoProduLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoprocesoproduDataAccess = new TipoProcesoProduDataAccess();
			
			this.tipoprocesoprodus= new ArrayList<TipoProcesoProdu>();
			this.tipoprocesoprodu= new TipoProcesoProdu();
			
			this.tipoprocesoproduObject=new Object();
			this.tipoprocesoprodusObject=new ArrayList<Object>();
				
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
			
			this.tipoprocesoproduDataAccess.setConnexionType(this.connexionType);
			this.tipoprocesoproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoProcesoProduLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoprocesoproduDataAccess = new TipoProcesoProduDataAccess();
			this.tipoprocesoprodus= new ArrayList<TipoProcesoProdu>();
			this.tipoprocesoprodu= new TipoProcesoProdu();
			this.tipoprocesoproduObject=new Object();
			this.tipoprocesoprodusObject=new ArrayList<Object>();
			
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
			
			this.tipoprocesoproduDataAccess.setConnexionType(this.connexionType);
			this.tipoprocesoproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoProcesoProdu getTipoProcesoProdu() throws Exception {	
		//TipoProcesoProduLogicAdditional.checkTipoProcesoProduToGet(tipoprocesoprodu,this.datosCliente,this.arrDatoGeneral);
		//TipoProcesoProduLogicAdditional.updateTipoProcesoProduToGet(tipoprocesoprodu,this.arrDatoGeneral);
		
		return tipoprocesoprodu;
	}
		
	public void setTipoProcesoProdu(TipoProcesoProdu newTipoProcesoProdu) {
		this.tipoprocesoprodu = newTipoProcesoProdu;
	}
	
	public TipoProcesoProduDataAccess getTipoProcesoProduDataAccess() {
		return tipoprocesoproduDataAccess;
	}
	
	public void setTipoProcesoProduDataAccess(TipoProcesoProduDataAccess newtipoprocesoproduDataAccess) {
		this.tipoprocesoproduDataAccess = newtipoprocesoproduDataAccess;
	}
	
	public List<TipoProcesoProdu> getTipoProcesoProdus() throws Exception {		
		this.quitarTipoProcesoProdusNulos();
		
		//TipoProcesoProduLogicAdditional.checkTipoProcesoProduToGets(tipoprocesoprodus,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoProcesoProdu tipoprocesoproduLocal: tipoprocesoprodus ) {
			//TipoProcesoProduLogicAdditional.updateTipoProcesoProduToGet(tipoprocesoproduLocal,this.arrDatoGeneral);
		}
		
		return tipoprocesoprodus;
	}
	
	public void setTipoProcesoProdus(List<TipoProcesoProdu> newTipoProcesoProdus) {
		this.tipoprocesoprodus = newTipoProcesoProdus;
	}
	
	public Object getTipoProcesoProduObject() {	
		this.tipoprocesoproduObject=this.tipoprocesoproduDataAccess.getEntityObject();
		return this.tipoprocesoproduObject;
	}
		
	public void setTipoProcesoProduObject(Object newTipoProcesoProduObject) {
		this.tipoprocesoproduObject = newTipoProcesoProduObject;
	}
	
	public List<Object> getTipoProcesoProdusObject() {		
		this.tipoprocesoprodusObject=this.tipoprocesoproduDataAccess.getEntitiesObject();
		return this.tipoprocesoprodusObject;
	}
		
	public void setTipoProcesoProdusObject(List<Object> newTipoProcesoProdusObject) {
		this.tipoprocesoprodusObject = newTipoProcesoProdusObject;
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
		
		if(this.tipoprocesoproduDataAccess!=null) {
			this.tipoprocesoproduDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoProdu.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoprocesoproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoprocesoproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoprocesoprodu = new  TipoProcesoProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoprocesoprodu=tipoprocesoproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprocesoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProcesoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoProdu(this.tipoprocesoprodu);
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
		tipoprocesoprodu = new  TipoProcesoProdu();
		  		  
        try {
			
			tipoprocesoprodu=tipoprocesoproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprocesoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProcesoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoProdu(this.tipoprocesoprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoprocesoprodu = new  TipoProcesoProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoprocesoprodu=tipoprocesoproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprocesoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProcesoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoProdu(this.tipoprocesoprodu);
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
		tipoprocesoprodu = new  TipoProcesoProdu();
		  		  
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
		tipoprocesoprodu = new  TipoProcesoProdu();
		  		  
        try {
			
			tipoprocesoprodu=tipoprocesoproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprocesoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProcesoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoProdu(this.tipoprocesoprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoprocesoprodu = new  TipoProcesoProdu();
		  		  
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
		tipoprocesoprodu = new  TipoProcesoProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoProdu.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoprocesoproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprocesoprodu = new  TipoProcesoProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoprocesoproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoprocesoprodu = new  TipoProcesoProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoProdu.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoprocesoproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprocesoprodu = new  TipoProcesoProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoprocesoproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoprocesoprodu = new  TipoProcesoProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoProdu.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoprocesoproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprocesoprodu = new  TipoProcesoProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoprocesoproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoprocesoprodus = new  ArrayList<TipoProcesoProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoProcesoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesoprodus=tipoprocesoproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProcesoProdu(tipoprocesoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoProdu(this.tipoprocesoprodus);
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
		tipoprocesoprodus = new  ArrayList<TipoProcesoProdu>();
		  		  
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
		tipoprocesoprodus = new  ArrayList<TipoProcesoProdu>();
		  		  
        try {			
			TipoProcesoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesoprodus=tipoprocesoproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoProcesoProdu(tipoprocesoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoProdu(this.tipoprocesoprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoprocesoprodus = new  ArrayList<TipoProcesoProdu>();
		  		  
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
		tipoprocesoprodus = new  ArrayList<TipoProcesoProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoProcesoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesoprodus=tipoprocesoproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProcesoProdu(tipoprocesoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoProdu(this.tipoprocesoprodus);
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
		tipoprocesoprodus = new  ArrayList<TipoProcesoProdu>();
		  		  
        try {
			TipoProcesoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesoprodus=tipoprocesoproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProcesoProdu(tipoprocesoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoProdu(this.tipoprocesoprodus);
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
		tipoprocesoprodus = new  ArrayList<TipoProcesoProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProcesoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesoprodus=tipoprocesoproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProcesoProdu(tipoprocesoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoProdu(this.tipoprocesoprodus);
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
		tipoprocesoprodus = new  ArrayList<TipoProcesoProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProcesoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesoprodus=tipoprocesoproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProcesoProdu(tipoprocesoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoProdu(this.tipoprocesoprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoprocesoprodu = new  TipoProcesoProdu();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProcesoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesoprodu=tipoprocesoproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProcesoProdu(tipoprocesoprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoProdu(this.tipoprocesoprodu);
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
		tipoprocesoprodu = new  TipoProcesoProdu();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProcesoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesoprodu=tipoprocesoproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProcesoProdu(tipoprocesoprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoProdu(this.tipoprocesoprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoProcesoProdusWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoprocesoprodus = new  ArrayList<TipoProcesoProdu>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoProdu.class.getSimpleName()+"-getTodosTipoProcesoProdusWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProcesoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesoprodus=tipoprocesoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoProcesoProdu(tipoprocesoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoProdu(this.tipoprocesoprodus);
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
	
	public  void  getTodosTipoProcesoProdus(String sFinalQuery,Pagination pagination)throws Exception {
		tipoprocesoprodus = new  ArrayList<TipoProcesoProdu>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProcesoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesoprodus=tipoprocesoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoProcesoProdu(tipoprocesoprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoProdu(this.tipoprocesoprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoProcesoProdu(TipoProcesoProdu tipoprocesoprodu) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoprocesoprodu.getIsNew() || tipoprocesoprodu.getIsChanged()) { 
			this.invalidValues = tipoprocesoproduValidator.getInvalidValues(tipoprocesoprodu);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoprocesoprodu);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoProcesoProdu(List<TipoProcesoProdu> TipoProcesoProdus) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoProcesoProdu tipoprocesoproduLocal:tipoprocesoprodus) {				
			estaValidadoObjeto=this.validarGuardarTipoProcesoProdu(tipoprocesoproduLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoProcesoProdu(List<TipoProcesoProdu> TipoProcesoProdus) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoProcesoProdu(tipoprocesoprodus)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoProcesoProdu(TipoProcesoProdu TipoProcesoProdu) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoProcesoProdu(tipoprocesoprodu)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoProcesoProdu tipoprocesoprodu) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoprocesoprodu.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoProcesoProduConstantesFunciones.getTipoProcesoProduLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoprocesoprodu","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoProcesoProduConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoProcesoProduConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoProcesoProduWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoProdu.class.getSimpleName()+"-saveTipoProcesoProduWithConnection");connexion.begin();			
			
			//TipoProcesoProduLogicAdditional.checkTipoProcesoProduToSave(this.tipoprocesoprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoProcesoProduLogicAdditional.updateTipoProcesoProduToSave(this.tipoprocesoprodu,this.arrDatoGeneral);
			
			TipoProcesoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoprocesoprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoProcesoProdu();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoProcesoProdu(this.tipoprocesoprodu)) {
				TipoProcesoProduDataAccess.save(this.tipoprocesoprodu, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoprocesoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoProcesoProduLogicAdditional.checkTipoProcesoProduToSaveAfter(this.tipoprocesoprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoProcesoProdu();
			
			connexion.commit();			
			
			if(this.tipoprocesoprodu.getIsDeleted()) {
				this.tipoprocesoprodu=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoProcesoProdu()throws Exception {	
		try {	
			
			//TipoProcesoProduLogicAdditional.checkTipoProcesoProduToSave(this.tipoprocesoprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoProcesoProduLogicAdditional.updateTipoProcesoProduToSave(this.tipoprocesoprodu,this.arrDatoGeneral);
			
			TipoProcesoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoprocesoprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoProcesoProdu(this.tipoprocesoprodu)) {			
				TipoProcesoProduDataAccess.save(this.tipoprocesoprodu, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoprocesoprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoProcesoProduLogicAdditional.checkTipoProcesoProduToSaveAfter(this.tipoprocesoprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoprocesoprodu.getIsDeleted()) {
				this.tipoprocesoprodu=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoProcesoProdusWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoProdu.class.getSimpleName()+"-saveTipoProcesoProdusWithConnection");connexion.begin();			
			
			//TipoProcesoProduLogicAdditional.checkTipoProcesoProduToSaves(tipoprocesoprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoProcesoProdus();
			
			Boolean validadoTodosTipoProcesoProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoProcesoProdu tipoprocesoproduLocal:tipoprocesoprodus) {		
				if(tipoprocesoproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoProcesoProduLogicAdditional.updateTipoProcesoProduToSave(tipoprocesoproduLocal,this.arrDatoGeneral);
	        	
				TipoProcesoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoprocesoproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoProcesoProdu(tipoprocesoproduLocal)) {
					TipoProcesoProduDataAccess.save(tipoprocesoproduLocal, connexion);				
				} else {
					validadoTodosTipoProcesoProdu=false;
				}
			}
			
			if(!validadoTodosTipoProcesoProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoProcesoProduLogicAdditional.checkTipoProcesoProduToSavesAfter(tipoprocesoprodus,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoProcesoProdus();
			
			connexion.commit();		
			
			this.quitarTipoProcesoProdusEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoProcesoProdus()throws Exception {				
		 try {	
			//TipoProcesoProduLogicAdditional.checkTipoProcesoProduToSaves(tipoprocesoprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoProcesoProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoProcesoProdu tipoprocesoproduLocal:tipoprocesoprodus) {				
				if(tipoprocesoproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoProcesoProduLogicAdditional.updateTipoProcesoProduToSave(tipoprocesoproduLocal,this.arrDatoGeneral);
	        	
				TipoProcesoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoprocesoproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoProcesoProdu(tipoprocesoproduLocal)) {				
					TipoProcesoProduDataAccess.save(tipoprocesoproduLocal, connexion);				
				} else {
					validadoTodosTipoProcesoProdu=false;
				}
			}
			
			if(!validadoTodosTipoProcesoProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoProcesoProduLogicAdditional.checkTipoProcesoProduToSavesAfter(tipoprocesoprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoProcesoProdusEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoProcesoProduParameterReturnGeneral procesarAccionTipoProcesoProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoProcesoProdu> tipoprocesoprodus,TipoProcesoProduParameterReturnGeneral tipoprocesoproduParameterGeneral)throws Exception {
		 try {	
			TipoProcesoProduParameterReturnGeneral tipoprocesoproduReturnGeneral=new TipoProcesoProduParameterReturnGeneral();
	
			
			return tipoprocesoproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoProcesoProduParameterReturnGeneral procesarAccionTipoProcesoProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoProcesoProdu> tipoprocesoprodus,TipoProcesoProduParameterReturnGeneral tipoprocesoproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoProdu.class.getSimpleName()+"-procesarAccionTipoProcesoProdusWithConnection");connexion.begin();			
			
			TipoProcesoProduParameterReturnGeneral tipoprocesoproduReturnGeneral=new TipoProcesoProduParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipoprocesoproduReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoProcesoProduParameterReturnGeneral procesarEventosTipoProcesoProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoProcesoProdu> tipoprocesoprodus,TipoProcesoProdu tipoprocesoprodu,TipoProcesoProduParameterReturnGeneral tipoprocesoproduParameterGeneral,Boolean isEsNuevoTipoProcesoProdu,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoProcesoProduParameterReturnGeneral tipoprocesoproduReturnGeneral=new TipoProcesoProduParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoprocesoproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipoprocesoproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoProcesoProduParameterReturnGeneral procesarEventosTipoProcesoProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoProcesoProdu> tipoprocesoprodus,TipoProcesoProdu tipoprocesoprodu,TipoProcesoProduParameterReturnGeneral tipoprocesoproduParameterGeneral,Boolean isEsNuevoTipoProcesoProdu,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoProdu.class.getSimpleName()+"-procesarEventosTipoProcesoProdusWithConnection");connexion.begin();			
			
			TipoProcesoProduParameterReturnGeneral tipoprocesoproduReturnGeneral=new TipoProcesoProduParameterReturnGeneral();
	
			tipoprocesoproduReturnGeneral.setTipoProcesoProdu(tipoprocesoprodu);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoprocesoproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipoprocesoproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoProcesoProduParameterReturnGeneral procesarImportacionTipoProcesoProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoProcesoProduParameterReturnGeneral tipoprocesoproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoProdu.class.getSimpleName()+"-procesarImportacionTipoProcesoProdusWithConnection");connexion.begin();			
			
			TipoProcesoProduParameterReturnGeneral tipoprocesoproduReturnGeneral=new TipoProcesoProduParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoprocesoprodus=new ArrayList<TipoProcesoProdu>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoprocesoprodu=new TipoProcesoProdu();
				
				
				if(conColumnasBase) {this.tipoprocesoprodu.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoprocesoprodu.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoprocesoprodu.setnombre(arrColumnas[iColumn++]);
				this.tipoprocesoprodu.setdescripcion(arrColumnas[iColumn++]);
				
				this.tipoprocesoprodus.add(this.tipoprocesoprodu);
			}
			
			this.saveTipoProcesoProdus();
			
			this.connexion.commit();
			
			tipoprocesoproduReturnGeneral.setConRetornoEstaProcesado(true);
			tipoprocesoproduReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoprocesoproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoProcesoProdusEliminados() throws Exception {				
		
		List<TipoProcesoProdu> tipoprocesoprodusAux= new ArrayList<TipoProcesoProdu>();
		
		for(TipoProcesoProdu tipoprocesoprodu:tipoprocesoprodus) {
			if(!tipoprocesoprodu.getIsDeleted()) {
				tipoprocesoprodusAux.add(tipoprocesoprodu);
			}
		}
		
		tipoprocesoprodus=tipoprocesoprodusAux;
	}
	
	public void quitarTipoProcesoProdusNulos() throws Exception {				
		
		List<TipoProcesoProdu> tipoprocesoprodusAux= new ArrayList<TipoProcesoProdu>();
		
		for(TipoProcesoProdu tipoprocesoprodu : this.tipoprocesoprodus) {
			if(tipoprocesoprodu==null) {
				tipoprocesoprodusAux.add(tipoprocesoprodu);
			}
		}
		
		//this.tipoprocesoprodus=tipoprocesoprodusAux;
		
		this.tipoprocesoprodus.removeAll(tipoprocesoprodusAux);
	}
	
	public void getSetVersionRowTipoProcesoProduWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoprocesoprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoprocesoprodu.getIsDeleted() || (tipoprocesoprodu.getIsChanged()&&!tipoprocesoprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoprocesoproduDataAccess.getSetVersionRowTipoProcesoProdu(connexion,tipoprocesoprodu.getId());
				
				if(!tipoprocesoprodu.getVersionRow().equals(timestamp)) {	
					tipoprocesoprodu.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoprocesoprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoProcesoProdu()throws Exception {	
		
		if(tipoprocesoprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoprocesoprodu.getIsDeleted() || (tipoprocesoprodu.getIsChanged()&&!tipoprocesoprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoprocesoproduDataAccess.getSetVersionRowTipoProcesoProdu(connexion,tipoprocesoprodu.getId());
			
			try {							
				if(!tipoprocesoprodu.getVersionRow().equals(timestamp)) {	
					tipoprocesoprodu.setVersionRow(timestamp);
				}
				
				tipoprocesoprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoProcesoProdusWithConnection()throws Exception {	
		if(tipoprocesoprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoProcesoProdu tipoprocesoproduAux:tipoprocesoprodus) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoprocesoproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoprocesoproduAux.getIsDeleted() || (tipoprocesoproduAux.getIsChanged()&&!tipoprocesoproduAux.getIsNew())) {
						
						timestamp=tipoprocesoproduDataAccess.getSetVersionRowTipoProcesoProdu(connexion,tipoprocesoproduAux.getId());
						
						if(!tipoprocesoprodu.getVersionRow().equals(timestamp)) {	
							tipoprocesoproduAux.setVersionRow(timestamp);
						}
								
						tipoprocesoproduAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoProcesoProdus()throws Exception {	
		if(tipoprocesoprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoProcesoProdu tipoprocesoproduAux:tipoprocesoprodus) {
					if(tipoprocesoproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoprocesoproduAux.getIsDeleted() || (tipoprocesoproduAux.getIsChanged()&&!tipoprocesoproduAux.getIsNew())) {
						
						timestamp=tipoprocesoproduDataAccess.getSetVersionRowTipoProcesoProdu(connexion,tipoprocesoproduAux.getId());
						
						if(!tipoprocesoproduAux.getVersionRow().equals(timestamp)) {	
							tipoprocesoproduAux.setVersionRow(timestamp);
						}
						
													
						tipoprocesoproduAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoProcesoProduParameterReturnGeneral cargarCombosLoteForeignKeyTipoProcesoProduWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoProcesoProduParameterReturnGeneral  tipoprocesoproduReturnGeneral =new TipoProcesoProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoProdu.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoProcesoProduWithConnection");connexion.begin();
			
			tipoprocesoproduReturnGeneral =new TipoProcesoProduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoprocesoproduReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoprocesoproduReturnGeneral;
	}
	
	public TipoProcesoProduParameterReturnGeneral cargarCombosLoteForeignKeyTipoProcesoProdu(String finalQueryGlobalEmpresa) throws Exception {
		TipoProcesoProduParameterReturnGeneral  tipoprocesoproduReturnGeneral =new TipoProcesoProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoprocesoproduReturnGeneral =new TipoProcesoProduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoprocesoproduReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoprocesoproduReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoProcesoProduWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PedidoDetaProduLogic pedidodetaproduLogic=new PedidoDetaProduLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoProdu.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoProcesoProduWithConnection");connexion.begin();
			
			
			classes.add(new Classe(PedidoDetaProdu.class));
											
			

			pedidodetaproduLogic.setConnexion(this.getConnexion());
			pedidodetaproduLogic.setDatosCliente(this.datosCliente);
			pedidodetaproduLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoProcesoProdu tipoprocesoprodu:this.tipoprocesoprodus) {
				

				classes=new ArrayList<Classe>();
				classes=PedidoDetaProduConstantesFunciones.getClassesForeignKeysOfPedidoDetaProdu(new ArrayList<Classe>(),DeepLoadType.NONE);

				pedidodetaproduLogic.setPedidoDetaProdus(tipoprocesoprodu.pedidodetaprodus);
				pedidodetaproduLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoProcesoProdu tipoprocesoprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoProcesoProduLogicAdditional.updateTipoProcesoProduToGet(tipoprocesoprodu,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoprocesoprodu.setEmpresa(tipoprocesoproduDataAccess.getEmpresa(connexion,tipoprocesoprodu));
		tipoprocesoprodu.setPedidoDetaProdus(tipoprocesoproduDataAccess.getPedidoDetaProdus(connexion,tipoprocesoprodu));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoprocesoprodu.setEmpresa(tipoprocesoproduDataAccess.getEmpresa(connexion,tipoprocesoprodu));
				continue;
			}

			if(clas.clas.equals(PedidoDetaProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprocesoprodu.setPedidoDetaProdus(tipoprocesoproduDataAccess.getPedidoDetaProdus(connexion,tipoprocesoprodu));

				if(this.isConDeep) {
					PedidoDetaProduLogic pedidodetaproduLogic= new PedidoDetaProduLogic(this.connexion);
					pedidodetaproduLogic.setPedidoDetaProdus(tipoprocesoprodu.getPedidoDetaProdus());
					ArrayList<Classe> classesLocal=PedidoDetaProduConstantesFunciones.getClassesForeignKeysOfPedidoDetaProdu(new ArrayList<Classe>(),DeepLoadType.NONE);
					pedidodetaproduLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PedidoDetaProduConstantesFunciones.refrescarForeignKeysDescripcionesPedidoDetaProdu(pedidodetaproduLogic.getPedidoDetaProdus());
					tipoprocesoprodu.setPedidoDetaProdus(pedidodetaproduLogic.getPedidoDetaProdus());
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
			tipoprocesoprodu.setEmpresa(tipoprocesoproduDataAccess.getEmpresa(connexion,tipoprocesoprodu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoDetaProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoDetaProdu.class));
			tipoprocesoprodu.setPedidoDetaProdus(tipoprocesoproduDataAccess.getPedidoDetaProdus(connexion,tipoprocesoprodu));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoprocesoprodu.setEmpresa(tipoprocesoproduDataAccess.getEmpresa(connexion,tipoprocesoprodu));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoprocesoprodu.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipoprocesoprodu.setPedidoDetaProdus(tipoprocesoproduDataAccess.getPedidoDetaProdus(connexion,tipoprocesoprodu));

		for(PedidoDetaProdu pedidodetaprodu:tipoprocesoprodu.getPedidoDetaProdus()) {
			PedidoDetaProduLogic pedidodetaproduLogic= new PedidoDetaProduLogic(connexion);
			pedidodetaproduLogic.deepLoad(pedidodetaprodu,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoprocesoprodu.setEmpresa(tipoprocesoproduDataAccess.getEmpresa(connexion,tipoprocesoprodu));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoprocesoprodu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PedidoDetaProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprocesoprodu.setPedidoDetaProdus(tipoprocesoproduDataAccess.getPedidoDetaProdus(connexion,tipoprocesoprodu));

				for(PedidoDetaProdu pedidodetaprodu:tipoprocesoprodu.getPedidoDetaProdus()) {
					PedidoDetaProduLogic pedidodetaproduLogic= new PedidoDetaProduLogic(connexion);
					pedidodetaproduLogic.deepLoad(pedidodetaprodu,isDeep,deepLoadType,clases);
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
			tipoprocesoprodu.setEmpresa(tipoprocesoproduDataAccess.getEmpresa(connexion,tipoprocesoprodu));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoprocesoprodu.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PedidoDetaProdu.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PedidoDetaProdu.class));
			tipoprocesoprodu.setPedidoDetaProdus(tipoprocesoproduDataAccess.getPedidoDetaProdus(connexion,tipoprocesoprodu));

			for(PedidoDetaProdu pedidodetaprodu:tipoprocesoprodu.getPedidoDetaProdus()) {
				PedidoDetaProduLogic pedidodetaproduLogic= new PedidoDetaProduLogic(connexion);
				pedidodetaproduLogic.deepLoad(pedidodetaprodu,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoProcesoProdu tipoprocesoprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoProcesoProdu.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoprocesoprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoProcesoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoProdu(tipoprocesoprodu);
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
			this.deepLoad(this.tipoprocesoprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoProcesoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoProdu(this.tipoprocesoprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoProcesoProdu.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoprocesoprodus!=null) {
				for(TipoProcesoProdu tipoprocesoprodu:tipoprocesoprodus) {
					this.deepLoad(tipoprocesoprodu,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoProcesoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoProdu(tipoprocesoprodus);
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
			if(tipoprocesoprodus!=null) {
				for(TipoProcesoProdu tipoprocesoprodu:tipoprocesoprodus) {
					this.deepLoad(tipoprocesoprodu,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoProcesoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoProdu(tipoprocesoprodus);
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
	
	
	public void getTipoProcesoProdusFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoProcesoProduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoProcesoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprocesoprodus=tipoprocesoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoProcesoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoProdu(this.tipoprocesoprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoProcesoProdusFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoProcesoProduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoProcesoProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprocesoprodus=tipoprocesoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoProcesoProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoProdu(this.tipoprocesoprodus);
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
			if(TipoProcesoProduConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProcesoProduDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoProcesoProdu tipoprocesoprodu,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoProcesoProduConstantesFunciones.ISCONAUDITORIA) {
				if(tipoprocesoprodu.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProcesoProduDataAccess.TABLENAME, tipoprocesoprodu.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoProcesoProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoProcesoProduLogic.registrarAuditoriaDetallesTipoProcesoProdu(connexion,tipoprocesoprodu,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoprocesoprodu.getIsDeleted()) {
					/*if(!tipoprocesoprodu.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoProcesoProduDataAccess.TABLENAME, tipoprocesoprodu.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoProcesoProduLogic.registrarAuditoriaDetallesTipoProcesoProdu(connexion,tipoprocesoprodu,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProcesoProduDataAccess.TABLENAME, tipoprocesoprodu.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoprocesoprodu.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProcesoProduDataAccess.TABLENAME, tipoprocesoprodu.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoProcesoProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoProcesoProduLogic.registrarAuditoriaDetallesTipoProcesoProdu(connexion,tipoprocesoprodu,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoProcesoProdu(Connexion connexion,TipoProcesoProdu tipoprocesoprodu)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoprocesoprodu.getIsNew()||!tipoprocesoprodu.getid_empresa().equals(tipoprocesoprodu.getTipoProcesoProduOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprocesoprodu.getTipoProcesoProduOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoprocesoprodu.getTipoProcesoProduOriginal().getid_empresa().toString();
				}
				if(tipoprocesoprodu.getid_empresa()!=null)
				{
					strValorNuevo=tipoprocesoprodu.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProcesoProduConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoprocesoprodu.getIsNew()||!tipoprocesoprodu.getnombre().equals(tipoprocesoprodu.getTipoProcesoProduOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprocesoprodu.getTipoProcesoProduOriginal().getnombre()!=null)
				{
					strValorActual=tipoprocesoprodu.getTipoProcesoProduOriginal().getnombre();
				}
				if(tipoprocesoprodu.getnombre()!=null)
				{
					strValorNuevo=tipoprocesoprodu.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProcesoProduConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipoprocesoprodu.getIsNew()||!tipoprocesoprodu.getdescripcion().equals(tipoprocesoprodu.getTipoProcesoProduOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprocesoprodu.getTipoProcesoProduOriginal().getdescripcion()!=null)
				{
					strValorActual=tipoprocesoprodu.getTipoProcesoProduOriginal().getdescripcion();
				}
				if(tipoprocesoprodu.getdescripcion()!=null)
				{
					strValorNuevo=tipoprocesoprodu.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProcesoProduConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoProcesoProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoProcesoProduConstantesFunciones.getClassesForeignKeysOfTipoProcesoProdu(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProcesoProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoProcesoProduConstantesFunciones.getClassesRelationshipsOfTipoProcesoProdu(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

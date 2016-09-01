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
import com.bydan.erp.produccion.util.TipoProcesoEmpresaProduConstantesFunciones;
import com.bydan.erp.produccion.util.TipoProcesoEmpresaProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.TipoProcesoEmpresaProduParameterGeneral;
import com.bydan.erp.produccion.business.entity.TipoProcesoEmpresaProdu;
import com.bydan.erp.produccion.business.logic.TipoProcesoEmpresaProduLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoProcesoEmpresaProduLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoProcesoEmpresaProduLogic.class);
	
	protected TipoProcesoEmpresaProduDataAccess tipoprocesoempresaproduDataAccess; 	
	protected TipoProcesoEmpresaProdu tipoprocesoempresaprodu;
	protected List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodus;
	protected Object tipoprocesoempresaproduObject;	
	protected List<Object> tipoprocesoempresaprodusObject;
	
	public static ClassValidator<TipoProcesoEmpresaProdu> tipoprocesoempresaproduValidator = new ClassValidator<TipoProcesoEmpresaProdu>(TipoProcesoEmpresaProdu.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoProcesoEmpresaProduLogicAdditional tipoprocesoempresaproduLogicAdditional=null;
	
	public TipoProcesoEmpresaProduLogicAdditional getTipoProcesoEmpresaProduLogicAdditional() {
		return this.tipoprocesoempresaproduLogicAdditional;
	}
	
	public void setTipoProcesoEmpresaProduLogicAdditional(TipoProcesoEmpresaProduLogicAdditional tipoprocesoempresaproduLogicAdditional) {
		try {
			this.tipoprocesoempresaproduLogicAdditional=tipoprocesoempresaproduLogicAdditional;
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
	
	
	
	
	public  TipoProcesoEmpresaProduLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoprocesoempresaproduDataAccess = new TipoProcesoEmpresaProduDataAccess();
			
			this.tipoprocesoempresaprodus= new ArrayList<TipoProcesoEmpresaProdu>();
			this.tipoprocesoempresaprodu= new TipoProcesoEmpresaProdu();
			
			this.tipoprocesoempresaproduObject=new Object();
			this.tipoprocesoempresaprodusObject=new ArrayList<Object>();
				
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
			
			this.tipoprocesoempresaproduDataAccess.setConnexionType(this.connexionType);
			this.tipoprocesoempresaproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoProcesoEmpresaProduLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoprocesoempresaproduDataAccess = new TipoProcesoEmpresaProduDataAccess();
			this.tipoprocesoempresaprodus= new ArrayList<TipoProcesoEmpresaProdu>();
			this.tipoprocesoempresaprodu= new TipoProcesoEmpresaProdu();
			this.tipoprocesoempresaproduObject=new Object();
			this.tipoprocesoempresaprodusObject=new ArrayList<Object>();
			
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
			
			this.tipoprocesoempresaproduDataAccess.setConnexionType(this.connexionType);
			this.tipoprocesoempresaproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoProcesoEmpresaProdu getTipoProcesoEmpresaProdu() throws Exception {	
		TipoProcesoEmpresaProduLogicAdditional.checkTipoProcesoEmpresaProduToGet(tipoprocesoempresaprodu,this.datosCliente,this.arrDatoGeneral);
		TipoProcesoEmpresaProduLogicAdditional.updateTipoProcesoEmpresaProduToGet(tipoprocesoempresaprodu,this.arrDatoGeneral);
		
		return tipoprocesoempresaprodu;
	}
		
	public void setTipoProcesoEmpresaProdu(TipoProcesoEmpresaProdu newTipoProcesoEmpresaProdu) {
		this.tipoprocesoempresaprodu = newTipoProcesoEmpresaProdu;
	}
	
	public TipoProcesoEmpresaProduDataAccess getTipoProcesoEmpresaProduDataAccess() {
		return tipoprocesoempresaproduDataAccess;
	}
	
	public void setTipoProcesoEmpresaProduDataAccess(TipoProcesoEmpresaProduDataAccess newtipoprocesoempresaproduDataAccess) {
		this.tipoprocesoempresaproduDataAccess = newtipoprocesoempresaproduDataAccess;
	}
	
	public List<TipoProcesoEmpresaProdu> getTipoProcesoEmpresaProdus() throws Exception {		
		this.quitarTipoProcesoEmpresaProdusNulos();
		
		TipoProcesoEmpresaProduLogicAdditional.checkTipoProcesoEmpresaProduToGets(tipoprocesoempresaprodus,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoProcesoEmpresaProdu tipoprocesoempresaproduLocal: tipoprocesoempresaprodus ) {
			TipoProcesoEmpresaProduLogicAdditional.updateTipoProcesoEmpresaProduToGet(tipoprocesoempresaproduLocal,this.arrDatoGeneral);
		}
		
		return tipoprocesoempresaprodus;
	}
	
	public void setTipoProcesoEmpresaProdus(List<TipoProcesoEmpresaProdu> newTipoProcesoEmpresaProdus) {
		this.tipoprocesoempresaprodus = newTipoProcesoEmpresaProdus;
	}
	
	public Object getTipoProcesoEmpresaProduObject() {	
		this.tipoprocesoempresaproduObject=this.tipoprocesoempresaproduDataAccess.getEntityObject();
		return this.tipoprocesoempresaproduObject;
	}
		
	public void setTipoProcesoEmpresaProduObject(Object newTipoProcesoEmpresaProduObject) {
		this.tipoprocesoempresaproduObject = newTipoProcesoEmpresaProduObject;
	}
	
	public List<Object> getTipoProcesoEmpresaProdusObject() {		
		this.tipoprocesoempresaprodusObject=this.tipoprocesoempresaproduDataAccess.getEntitiesObject();
		return this.tipoprocesoempresaprodusObject;
	}
		
	public void setTipoProcesoEmpresaProdusObject(List<Object> newTipoProcesoEmpresaProdusObject) {
		this.tipoprocesoempresaprodusObject = newTipoProcesoEmpresaProdusObject;
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
		
		if(this.tipoprocesoempresaproduDataAccess!=null) {
			this.tipoprocesoempresaproduDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoEmpresaProdu.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoprocesoempresaproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoprocesoempresaproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoprocesoempresaprodu = new  TipoProcesoEmpresaProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoEmpresaProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoprocesoempresaprodu=tipoprocesoempresaproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprocesoempresaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProcesoEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(this.tipoprocesoempresaprodu);
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
		tipoprocesoempresaprodu = new  TipoProcesoEmpresaProdu();
		  		  
        try {
			
			tipoprocesoempresaprodu=tipoprocesoempresaproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprocesoempresaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProcesoEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(this.tipoprocesoempresaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoprocesoempresaprodu = new  TipoProcesoEmpresaProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoEmpresaProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoprocesoempresaprodu=tipoprocesoempresaproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprocesoempresaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProcesoEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(this.tipoprocesoempresaprodu);
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
		tipoprocesoempresaprodu = new  TipoProcesoEmpresaProdu();
		  		  
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
		tipoprocesoempresaprodu = new  TipoProcesoEmpresaProdu();
		  		  
        try {
			
			tipoprocesoempresaprodu=tipoprocesoempresaproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprocesoempresaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProcesoEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(this.tipoprocesoempresaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoprocesoempresaprodu = new  TipoProcesoEmpresaProdu();
		  		  
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
		tipoprocesoempresaprodu = new  TipoProcesoEmpresaProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoEmpresaProdu.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoprocesoempresaproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprocesoempresaprodu = new  TipoProcesoEmpresaProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoprocesoempresaproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoprocesoempresaprodu = new  TipoProcesoEmpresaProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoEmpresaProdu.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoprocesoempresaproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprocesoempresaprodu = new  TipoProcesoEmpresaProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoprocesoempresaproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoprocesoempresaprodu = new  TipoProcesoEmpresaProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoEmpresaProdu.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoprocesoempresaproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprocesoempresaprodu = new  TipoProcesoEmpresaProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoprocesoempresaproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoprocesoempresaprodus = new  ArrayList<TipoProcesoEmpresaProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoEmpresaProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoProcesoEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesoempresaprodus=tipoprocesoempresaproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProcesoEmpresaProdu(tipoprocesoempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(this.tipoprocesoempresaprodus);
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
		tipoprocesoempresaprodus = new  ArrayList<TipoProcesoEmpresaProdu>();
		  		  
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
		tipoprocesoempresaprodus = new  ArrayList<TipoProcesoEmpresaProdu>();
		  		  
        try {			
			TipoProcesoEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesoempresaprodus=tipoprocesoempresaproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoProcesoEmpresaProdu(tipoprocesoempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(this.tipoprocesoempresaprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoprocesoempresaprodus = new  ArrayList<TipoProcesoEmpresaProdu>();
		  		  
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
		tipoprocesoempresaprodus = new  ArrayList<TipoProcesoEmpresaProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoEmpresaProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoProcesoEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesoempresaprodus=tipoprocesoempresaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProcesoEmpresaProdu(tipoprocesoempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(this.tipoprocesoempresaprodus);
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
		tipoprocesoempresaprodus = new  ArrayList<TipoProcesoEmpresaProdu>();
		  		  
        try {
			TipoProcesoEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesoempresaprodus=tipoprocesoempresaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProcesoEmpresaProdu(tipoprocesoempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(this.tipoprocesoempresaprodus);
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
		tipoprocesoempresaprodus = new  ArrayList<TipoProcesoEmpresaProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoEmpresaProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProcesoEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesoempresaprodus=tipoprocesoempresaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProcesoEmpresaProdu(tipoprocesoempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(this.tipoprocesoempresaprodus);
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
		tipoprocesoempresaprodus = new  ArrayList<TipoProcesoEmpresaProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProcesoEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesoempresaprodus=tipoprocesoempresaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProcesoEmpresaProdu(tipoprocesoempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(this.tipoprocesoempresaprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoprocesoempresaprodu = new  TipoProcesoEmpresaProdu();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoEmpresaProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProcesoEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesoempresaprodu=tipoprocesoempresaproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProcesoEmpresaProdu(tipoprocesoempresaprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(this.tipoprocesoempresaprodu);
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
		tipoprocesoempresaprodu = new  TipoProcesoEmpresaProdu();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProcesoEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesoempresaprodu=tipoprocesoempresaproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProcesoEmpresaProdu(tipoprocesoempresaprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(this.tipoprocesoempresaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoprocesoempresaprodus = new  ArrayList<TipoProcesoEmpresaProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoEmpresaProdu.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoProcesoEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesoempresaprodus=tipoprocesoempresaproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProcesoEmpresaProdu(tipoprocesoempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(this.tipoprocesoempresaprodus);
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
		tipoprocesoempresaprodus = new  ArrayList<TipoProcesoEmpresaProdu>();
		  		  
        try {
			TipoProcesoEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesoempresaprodus=tipoprocesoempresaproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProcesoEmpresaProdu(tipoprocesoempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(this.tipoprocesoempresaprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoProcesoEmpresaProdusWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoprocesoempresaprodus = new  ArrayList<TipoProcesoEmpresaProdu>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoEmpresaProdu.class.getSimpleName()+"-getTodosTipoProcesoEmpresaProdusWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProcesoEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesoempresaprodus=tipoprocesoempresaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoProcesoEmpresaProdu(tipoprocesoempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(this.tipoprocesoempresaprodus);
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
	
	public  void  getTodosTipoProcesoEmpresaProdus(String sFinalQuery,Pagination pagination)throws Exception {
		tipoprocesoempresaprodus = new  ArrayList<TipoProcesoEmpresaProdu>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProcesoEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesoempresaprodus=tipoprocesoempresaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoProcesoEmpresaProdu(tipoprocesoempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(this.tipoprocesoempresaprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoProcesoEmpresaProdu(TipoProcesoEmpresaProdu tipoprocesoempresaprodu) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoprocesoempresaprodu.getIsNew() || tipoprocesoempresaprodu.getIsChanged()) { 
			this.invalidValues = tipoprocesoempresaproduValidator.getInvalidValues(tipoprocesoempresaprodu);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoprocesoempresaprodu);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoProcesoEmpresaProdu(List<TipoProcesoEmpresaProdu> TipoProcesoEmpresaProdus) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoProcesoEmpresaProdu tipoprocesoempresaproduLocal:tipoprocesoempresaprodus) {				
			estaValidadoObjeto=this.validarGuardarTipoProcesoEmpresaProdu(tipoprocesoempresaproduLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoProcesoEmpresaProdu(List<TipoProcesoEmpresaProdu> TipoProcesoEmpresaProdus) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoProcesoEmpresaProdu(tipoprocesoempresaprodus)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoProcesoEmpresaProdu(TipoProcesoEmpresaProdu TipoProcesoEmpresaProdu) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoProcesoEmpresaProdu(tipoprocesoempresaprodu)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoProcesoEmpresaProdu tipoprocesoempresaprodu) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoprocesoempresaprodu.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoProcesoEmpresaProduConstantesFunciones.getTipoProcesoEmpresaProduLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoprocesoempresaprodu","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoProcesoEmpresaProduConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoProcesoEmpresaProduConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoProcesoEmpresaProduWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoEmpresaProdu.class.getSimpleName()+"-saveTipoProcesoEmpresaProduWithConnection");connexion.begin();			
			
			TipoProcesoEmpresaProduLogicAdditional.checkTipoProcesoEmpresaProduToSave(this.tipoprocesoempresaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoProcesoEmpresaProduLogicAdditional.updateTipoProcesoEmpresaProduToSave(this.tipoprocesoempresaprodu,this.arrDatoGeneral);
			
			TipoProcesoEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoprocesoempresaprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoProcesoEmpresaProdu();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoProcesoEmpresaProdu(this.tipoprocesoempresaprodu)) {
				TipoProcesoEmpresaProduDataAccess.save(this.tipoprocesoempresaprodu, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoprocesoempresaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoProcesoEmpresaProduLogicAdditional.checkTipoProcesoEmpresaProduToSaveAfter(this.tipoprocesoempresaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoProcesoEmpresaProdu();
			
			connexion.commit();			
			
			if(this.tipoprocesoempresaprodu.getIsDeleted()) {
				this.tipoprocesoempresaprodu=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoProcesoEmpresaProdu()throws Exception {	
		try {	
			
			TipoProcesoEmpresaProduLogicAdditional.checkTipoProcesoEmpresaProduToSave(this.tipoprocesoempresaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoProcesoEmpresaProduLogicAdditional.updateTipoProcesoEmpresaProduToSave(this.tipoprocesoempresaprodu,this.arrDatoGeneral);
			
			TipoProcesoEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoprocesoempresaprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoProcesoEmpresaProdu(this.tipoprocesoempresaprodu)) {			
				TipoProcesoEmpresaProduDataAccess.save(this.tipoprocesoempresaprodu, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoprocesoempresaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoProcesoEmpresaProduLogicAdditional.checkTipoProcesoEmpresaProduToSaveAfter(this.tipoprocesoempresaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoprocesoempresaprodu.getIsDeleted()) {
				this.tipoprocesoempresaprodu=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoProcesoEmpresaProdusWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoEmpresaProdu.class.getSimpleName()+"-saveTipoProcesoEmpresaProdusWithConnection");connexion.begin();			
			
			TipoProcesoEmpresaProduLogicAdditional.checkTipoProcesoEmpresaProduToSaves(tipoprocesoempresaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoProcesoEmpresaProdus();
			
			Boolean validadoTodosTipoProcesoEmpresaProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoProcesoEmpresaProdu tipoprocesoempresaproduLocal:tipoprocesoempresaprodus) {		
				if(tipoprocesoempresaproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoProcesoEmpresaProduLogicAdditional.updateTipoProcesoEmpresaProduToSave(tipoprocesoempresaproduLocal,this.arrDatoGeneral);
	        	
				TipoProcesoEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoprocesoempresaproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoProcesoEmpresaProdu(tipoprocesoempresaproduLocal)) {
					TipoProcesoEmpresaProduDataAccess.save(tipoprocesoempresaproduLocal, connexion);				
				} else {
					validadoTodosTipoProcesoEmpresaProdu=false;
				}
			}
			
			if(!validadoTodosTipoProcesoEmpresaProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoProcesoEmpresaProduLogicAdditional.checkTipoProcesoEmpresaProduToSavesAfter(tipoprocesoempresaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoProcesoEmpresaProdus();
			
			connexion.commit();		
			
			this.quitarTipoProcesoEmpresaProdusEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoProcesoEmpresaProdus()throws Exception {				
		 try {	
			TipoProcesoEmpresaProduLogicAdditional.checkTipoProcesoEmpresaProduToSaves(tipoprocesoempresaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoProcesoEmpresaProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoProcesoEmpresaProdu tipoprocesoempresaproduLocal:tipoprocesoempresaprodus) {				
				if(tipoprocesoempresaproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoProcesoEmpresaProduLogicAdditional.updateTipoProcesoEmpresaProduToSave(tipoprocesoempresaproduLocal,this.arrDatoGeneral);
	        	
				TipoProcesoEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoprocesoempresaproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoProcesoEmpresaProdu(tipoprocesoempresaproduLocal)) {				
					TipoProcesoEmpresaProduDataAccess.save(tipoprocesoempresaproduLocal, connexion);				
				} else {
					validadoTodosTipoProcesoEmpresaProdu=false;
				}
			}
			
			if(!validadoTodosTipoProcesoEmpresaProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoProcesoEmpresaProduLogicAdditional.checkTipoProcesoEmpresaProduToSavesAfter(tipoprocesoempresaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoProcesoEmpresaProdusEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoProcesoEmpresaProduParameterReturnGeneral procesarAccionTipoProcesoEmpresaProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodus,TipoProcesoEmpresaProduParameterReturnGeneral tipoprocesoempresaproduParameterGeneral)throws Exception {
		 try {	
			TipoProcesoEmpresaProduParameterReturnGeneral tipoprocesoempresaproduReturnGeneral=new TipoProcesoEmpresaProduParameterReturnGeneral();
	
			TipoProcesoEmpresaProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoprocesoempresaprodus,tipoprocesoempresaproduParameterGeneral,tipoprocesoempresaproduReturnGeneral);
			
			return tipoprocesoempresaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoProcesoEmpresaProduParameterReturnGeneral procesarAccionTipoProcesoEmpresaProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodus,TipoProcesoEmpresaProduParameterReturnGeneral tipoprocesoempresaproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoEmpresaProdu.class.getSimpleName()+"-procesarAccionTipoProcesoEmpresaProdusWithConnection");connexion.begin();			
			
			TipoProcesoEmpresaProduParameterReturnGeneral tipoprocesoempresaproduReturnGeneral=new TipoProcesoEmpresaProduParameterReturnGeneral();
	
			TipoProcesoEmpresaProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoprocesoempresaprodus,tipoprocesoempresaproduParameterGeneral,tipoprocesoempresaproduReturnGeneral);
			
			this.connexion.commit();
			
			return tipoprocesoempresaproduReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoProcesoEmpresaProduParameterReturnGeneral procesarEventosTipoProcesoEmpresaProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodus,TipoProcesoEmpresaProdu tipoprocesoempresaprodu,TipoProcesoEmpresaProduParameterReturnGeneral tipoprocesoempresaproduParameterGeneral,Boolean isEsNuevoTipoProcesoEmpresaProdu,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoProcesoEmpresaProduParameterReturnGeneral tipoprocesoempresaproduReturnGeneral=new TipoProcesoEmpresaProduParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoprocesoempresaproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoProcesoEmpresaProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoprocesoempresaprodus,tipoprocesoempresaprodu,tipoprocesoempresaproduParameterGeneral,tipoprocesoempresaproduReturnGeneral,isEsNuevoTipoProcesoEmpresaProdu,clases);
			
			return tipoprocesoempresaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoProcesoEmpresaProduParameterReturnGeneral procesarEventosTipoProcesoEmpresaProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodus,TipoProcesoEmpresaProdu tipoprocesoempresaprodu,TipoProcesoEmpresaProduParameterReturnGeneral tipoprocesoempresaproduParameterGeneral,Boolean isEsNuevoTipoProcesoEmpresaProdu,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoEmpresaProdu.class.getSimpleName()+"-procesarEventosTipoProcesoEmpresaProdusWithConnection");connexion.begin();			
			
			TipoProcesoEmpresaProduParameterReturnGeneral tipoprocesoempresaproduReturnGeneral=new TipoProcesoEmpresaProduParameterReturnGeneral();
	
			tipoprocesoempresaproduReturnGeneral.setTipoProcesoEmpresaProdu(tipoprocesoempresaprodu);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoprocesoempresaproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoProcesoEmpresaProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoprocesoempresaprodus,tipoprocesoempresaprodu,tipoprocesoempresaproduParameterGeneral,tipoprocesoempresaproduReturnGeneral,isEsNuevoTipoProcesoEmpresaProdu,clases);
			
			this.connexion.commit();
			
			return tipoprocesoempresaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoProcesoEmpresaProduParameterReturnGeneral procesarImportacionTipoProcesoEmpresaProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoProcesoEmpresaProduParameterReturnGeneral tipoprocesoempresaproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoEmpresaProdu.class.getSimpleName()+"-procesarImportacionTipoProcesoEmpresaProdusWithConnection");connexion.begin();			
			
			TipoProcesoEmpresaProduParameterReturnGeneral tipoprocesoempresaproduReturnGeneral=new TipoProcesoEmpresaProduParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoprocesoempresaprodus=new ArrayList<TipoProcesoEmpresaProdu>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoprocesoempresaprodu=new TipoProcesoEmpresaProdu();
				
				
				if(conColumnasBase) {this.tipoprocesoempresaprodu.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoprocesoempresaprodu.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoprocesoempresaprodu.setnombre(arrColumnas[iColumn++]);
				this.tipoprocesoempresaprodu.setdescripcion(arrColumnas[iColumn++]);
				
				this.tipoprocesoempresaprodus.add(this.tipoprocesoempresaprodu);
			}
			
			this.saveTipoProcesoEmpresaProdus();
			
			this.connexion.commit();
			
			tipoprocesoempresaproduReturnGeneral.setConRetornoEstaProcesado(true);
			tipoprocesoempresaproduReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoprocesoempresaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoProcesoEmpresaProdusEliminados() throws Exception {				
		
		List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodusAux= new ArrayList<TipoProcesoEmpresaProdu>();
		
		for(TipoProcesoEmpresaProdu tipoprocesoempresaprodu:tipoprocesoempresaprodus) {
			if(!tipoprocesoempresaprodu.getIsDeleted()) {
				tipoprocesoempresaprodusAux.add(tipoprocesoempresaprodu);
			}
		}
		
		tipoprocesoempresaprodus=tipoprocesoempresaprodusAux;
	}
	
	public void quitarTipoProcesoEmpresaProdusNulos() throws Exception {				
		
		List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodusAux= new ArrayList<TipoProcesoEmpresaProdu>();
		
		for(TipoProcesoEmpresaProdu tipoprocesoempresaprodu : this.tipoprocesoempresaprodus) {
			if(tipoprocesoempresaprodu==null) {
				tipoprocesoempresaprodusAux.add(tipoprocesoempresaprodu);
			}
		}
		
		//this.tipoprocesoempresaprodus=tipoprocesoempresaprodusAux;
		
		this.tipoprocesoempresaprodus.removeAll(tipoprocesoempresaprodusAux);
	}
	
	public void getSetVersionRowTipoProcesoEmpresaProduWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoprocesoempresaprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoprocesoempresaprodu.getIsDeleted() || (tipoprocesoempresaprodu.getIsChanged()&&!tipoprocesoempresaprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoprocesoempresaproduDataAccess.getSetVersionRowTipoProcesoEmpresaProdu(connexion,tipoprocesoempresaprodu.getId());
				
				if(!tipoprocesoempresaprodu.getVersionRow().equals(timestamp)) {	
					tipoprocesoempresaprodu.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoprocesoempresaprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoProcesoEmpresaProdu()throws Exception {	
		
		if(tipoprocesoempresaprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoprocesoempresaprodu.getIsDeleted() || (tipoprocesoempresaprodu.getIsChanged()&&!tipoprocesoempresaprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoprocesoempresaproduDataAccess.getSetVersionRowTipoProcesoEmpresaProdu(connexion,tipoprocesoempresaprodu.getId());
			
			try {							
				if(!tipoprocesoempresaprodu.getVersionRow().equals(timestamp)) {	
					tipoprocesoempresaprodu.setVersionRow(timestamp);
				}
				
				tipoprocesoempresaprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoProcesoEmpresaProdusWithConnection()throws Exception {	
		if(tipoprocesoempresaprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoProcesoEmpresaProdu tipoprocesoempresaproduAux:tipoprocesoempresaprodus) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoprocesoempresaproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoprocesoempresaproduAux.getIsDeleted() || (tipoprocesoempresaproduAux.getIsChanged()&&!tipoprocesoempresaproduAux.getIsNew())) {
						
						timestamp=tipoprocesoempresaproduDataAccess.getSetVersionRowTipoProcesoEmpresaProdu(connexion,tipoprocesoempresaproduAux.getId());
						
						if(!tipoprocesoempresaprodu.getVersionRow().equals(timestamp)) {	
							tipoprocesoempresaproduAux.setVersionRow(timestamp);
						}
								
						tipoprocesoempresaproduAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoProcesoEmpresaProdus()throws Exception {	
		if(tipoprocesoempresaprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoProcesoEmpresaProdu tipoprocesoempresaproduAux:tipoprocesoempresaprodus) {
					if(tipoprocesoempresaproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoprocesoempresaproduAux.getIsDeleted() || (tipoprocesoempresaproduAux.getIsChanged()&&!tipoprocesoempresaproduAux.getIsNew())) {
						
						timestamp=tipoprocesoempresaproduDataAccess.getSetVersionRowTipoProcesoEmpresaProdu(connexion,tipoprocesoempresaproduAux.getId());
						
						if(!tipoprocesoempresaproduAux.getVersionRow().equals(timestamp)) {	
							tipoprocesoempresaproduAux.setVersionRow(timestamp);
						}
						
													
						tipoprocesoempresaproduAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoProcesoEmpresaProduParameterReturnGeneral cargarCombosLoteForeignKeyTipoProcesoEmpresaProduWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoProcesoEmpresaProduParameterReturnGeneral  tipoprocesoempresaproduReturnGeneral =new TipoProcesoEmpresaProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoEmpresaProdu.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoProcesoEmpresaProduWithConnection");connexion.begin();
			
			tipoprocesoempresaproduReturnGeneral =new TipoProcesoEmpresaProduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoprocesoempresaproduReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoprocesoempresaproduReturnGeneral;
	}
	
	public TipoProcesoEmpresaProduParameterReturnGeneral cargarCombosLoteForeignKeyTipoProcesoEmpresaProdu(String finalQueryGlobalEmpresa) throws Exception {
		TipoProcesoEmpresaProduParameterReturnGeneral  tipoprocesoempresaproduReturnGeneral =new TipoProcesoEmpresaProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoprocesoempresaproduReturnGeneral =new TipoProcesoEmpresaProduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoprocesoempresaproduReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoprocesoempresaproduReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoProcesoEmpresaProduWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ProductoProduManoLogic productoprodumanoLogic=new ProductoProduManoLogic();
			ProductoOrdenDetaProduManoLogic productoordendetaprodumanoLogic=new ProductoOrdenDetaProduManoLogic();
			ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic=new ProductoOrdenDetaProduMaquinaLogic();
			ProductoProduMaquinaLogic productoprodumaquinaLogic=new ProductoProduMaquinaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoEmpresaProdu.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoProcesoEmpresaProduWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ProductoProduMano.class));
			classes.add(new Classe(ProductoOrdenDetaProduMano.class));
			classes.add(new Classe(ProductoOrdenDetaProduMaquina.class));
			classes.add(new Classe(ProductoProduMaquina.class));
											
			

			productoprodumanoLogic.setConnexion(this.getConnexion());
			productoprodumanoLogic.setDatosCliente(this.datosCliente);
			productoprodumanoLogic.setIsConRefrescarForeignKeys(true);

			productoordendetaprodumanoLogic.setConnexion(this.getConnexion());
			productoordendetaprodumanoLogic.setDatosCliente(this.datosCliente);
			productoordendetaprodumanoLogic.setIsConRefrescarForeignKeys(true);

			productoordendetaprodumaquinaLogic.setConnexion(this.getConnexion());
			productoordendetaprodumaquinaLogic.setDatosCliente(this.datosCliente);
			productoordendetaprodumaquinaLogic.setIsConRefrescarForeignKeys(true);

			productoprodumaquinaLogic.setConnexion(this.getConnexion());
			productoprodumaquinaLogic.setDatosCliente(this.datosCliente);
			productoprodumaquinaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoProcesoEmpresaProdu tipoprocesoempresaprodu:this.tipoprocesoempresaprodus) {
				

				classes=new ArrayList<Classe>();
				classes=ProductoProduManoConstantesFunciones.getClassesForeignKeysOfProductoProduMano(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoprodumanoLogic.setProductoProduManos(tipoprocesoempresaprodu.productoprodumanos);
				productoprodumanoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoOrdenDetaProduManoConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProduMano(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoordendetaprodumanoLogic.setProductoOrdenDetaProduManos(tipoprocesoempresaprodu.productoordendetaprodumanos);
				productoordendetaprodumanoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoOrdenDetaProduMaquinaConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProduMaquina(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoordendetaprodumaquinaLogic.setProductoOrdenDetaProduMaquinas(tipoprocesoempresaprodu.productoordendetaprodumaquinas);
				productoordendetaprodumaquinaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoProduMaquinaConstantesFunciones.getClassesForeignKeysOfProductoProduMaquina(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoprodumaquinaLogic.setProductoProduMaquinas(tipoprocesoempresaprodu.productoprodumaquinas);
				productoprodumaquinaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoProcesoEmpresaProdu tipoprocesoempresaprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoProcesoEmpresaProduLogicAdditional.updateTipoProcesoEmpresaProduToGet(tipoprocesoempresaprodu,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoprocesoempresaprodu.setEmpresa(tipoprocesoempresaproduDataAccess.getEmpresa(connexion,tipoprocesoempresaprodu));
		tipoprocesoempresaprodu.setProductoProduManos(tipoprocesoempresaproduDataAccess.getProductoProduManos(connexion,tipoprocesoempresaprodu));
		tipoprocesoempresaprodu.setProductoOrdenDetaProduManos(tipoprocesoempresaproduDataAccess.getProductoOrdenDetaProduManos(connexion,tipoprocesoempresaprodu));
		tipoprocesoempresaprodu.setProductoOrdenDetaProduMaquinas(tipoprocesoempresaproduDataAccess.getProductoOrdenDetaProduMaquinas(connexion,tipoprocesoempresaprodu));
		tipoprocesoempresaprodu.setProductoProduMaquinas(tipoprocesoempresaproduDataAccess.getProductoProduMaquinas(connexion,tipoprocesoempresaprodu));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoprocesoempresaprodu.setEmpresa(tipoprocesoempresaproduDataAccess.getEmpresa(connexion,tipoprocesoempresaprodu));
				continue;
			}

			if(clas.clas.equals(ProductoProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprocesoempresaprodu.setProductoProduManos(tipoprocesoempresaproduDataAccess.getProductoProduManos(connexion,tipoprocesoempresaprodu));

				if(this.isConDeep) {
					ProductoProduManoLogic productoprodumanoLogic= new ProductoProduManoLogic(this.connexion);
					productoprodumanoLogic.setProductoProduManos(tipoprocesoempresaprodu.getProductoProduManos());
					ArrayList<Classe> classesLocal=ProductoProduManoConstantesFunciones.getClassesForeignKeysOfProductoProduMano(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoprodumanoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMano(productoprodumanoLogic.getProductoProduManos());
					tipoprocesoempresaprodu.setProductoProduManos(productoprodumanoLogic.getProductoProduManos());
				}

				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprocesoempresaprodu.setProductoOrdenDetaProduManos(tipoprocesoempresaproduDataAccess.getProductoOrdenDetaProduManos(connexion,tipoprocesoempresaprodu));

				if(this.isConDeep) {
					ProductoOrdenDetaProduManoLogic productoordendetaprodumanoLogic= new ProductoOrdenDetaProduManoLogic(this.connexion);
					productoordendetaprodumanoLogic.setProductoOrdenDetaProduManos(tipoprocesoempresaprodu.getProductoOrdenDetaProduManos());
					ArrayList<Classe> classesLocal=ProductoOrdenDetaProduManoConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProduMano(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoordendetaprodumanoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoOrdenDetaProduManoConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMano(productoordendetaprodumanoLogic.getProductoOrdenDetaProduManos());
					tipoprocesoempresaprodu.setProductoOrdenDetaProduManos(productoordendetaprodumanoLogic.getProductoOrdenDetaProduManos());
				}

				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprocesoempresaprodu.setProductoOrdenDetaProduMaquinas(tipoprocesoempresaproduDataAccess.getProductoOrdenDetaProduMaquinas(connexion,tipoprocesoempresaprodu));

				if(this.isConDeep) {
					ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(this.connexion);
					productoordendetaprodumaquinaLogic.setProductoOrdenDetaProduMaquinas(tipoprocesoempresaprodu.getProductoOrdenDetaProduMaquinas());
					ArrayList<Classe> classesLocal=ProductoOrdenDetaProduMaquinaConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProduMaquina(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoordendetaprodumaquinaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(productoordendetaprodumaquinaLogic.getProductoOrdenDetaProduMaquinas());
					tipoprocesoempresaprodu.setProductoOrdenDetaProduMaquinas(productoordendetaprodumaquinaLogic.getProductoOrdenDetaProduMaquinas());
				}

				continue;
			}

			if(clas.clas.equals(ProductoProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprocesoempresaprodu.setProductoProduMaquinas(tipoprocesoempresaproduDataAccess.getProductoProduMaquinas(connexion,tipoprocesoempresaprodu));

				if(this.isConDeep) {
					ProductoProduMaquinaLogic productoprodumaquinaLogic= new ProductoProduMaquinaLogic(this.connexion);
					productoprodumaquinaLogic.setProductoProduMaquinas(tipoprocesoempresaprodu.getProductoProduMaquinas());
					ArrayList<Classe> classesLocal=ProductoProduMaquinaConstantesFunciones.getClassesForeignKeysOfProductoProduMaquina(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoprodumaquinaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(productoprodumaquinaLogic.getProductoProduMaquinas());
					tipoprocesoempresaprodu.setProductoProduMaquinas(productoprodumaquinaLogic.getProductoProduMaquinas());
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
			tipoprocesoempresaprodu.setEmpresa(tipoprocesoempresaproduDataAccess.getEmpresa(connexion,tipoprocesoempresaprodu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoProduMano.class));
			tipoprocesoempresaprodu.setProductoProduManos(tipoprocesoempresaproduDataAccess.getProductoProduManos(connexion,tipoprocesoempresaprodu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoOrdenDetaProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoOrdenDetaProduMano.class));
			tipoprocesoempresaprodu.setProductoOrdenDetaProduManos(tipoprocesoempresaproduDataAccess.getProductoOrdenDetaProduManos(connexion,tipoprocesoempresaprodu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoOrdenDetaProduMaquina.class));
			tipoprocesoempresaprodu.setProductoOrdenDetaProduMaquinas(tipoprocesoempresaproduDataAccess.getProductoOrdenDetaProduMaquinas(connexion,tipoprocesoempresaprodu));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoProduMaquina.class));
			tipoprocesoempresaprodu.setProductoProduMaquinas(tipoprocesoempresaproduDataAccess.getProductoProduMaquinas(connexion,tipoprocesoempresaprodu));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoprocesoempresaprodu.setEmpresa(tipoprocesoempresaproduDataAccess.getEmpresa(connexion,tipoprocesoempresaprodu));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoprocesoempresaprodu.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipoprocesoempresaprodu.setProductoProduManos(tipoprocesoempresaproduDataAccess.getProductoProduManos(connexion,tipoprocesoempresaprodu));

		for(ProductoProduMano productoprodumano:tipoprocesoempresaprodu.getProductoProduManos()) {
			ProductoProduManoLogic productoprodumanoLogic= new ProductoProduManoLogic(connexion);
			productoprodumanoLogic.deepLoad(productoprodumano,isDeep,deepLoadType,clases);
		}

		tipoprocesoempresaprodu.setProductoOrdenDetaProduManos(tipoprocesoempresaproduDataAccess.getProductoOrdenDetaProduManos(connexion,tipoprocesoempresaprodu));

		for(ProductoOrdenDetaProduMano productoordendetaprodumano:tipoprocesoempresaprodu.getProductoOrdenDetaProduManos()) {
			ProductoOrdenDetaProduManoLogic productoordendetaprodumanoLogic= new ProductoOrdenDetaProduManoLogic(connexion);
			productoordendetaprodumanoLogic.deepLoad(productoordendetaprodumano,isDeep,deepLoadType,clases);
		}

		tipoprocesoempresaprodu.setProductoOrdenDetaProduMaquinas(tipoprocesoempresaproduDataAccess.getProductoOrdenDetaProduMaquinas(connexion,tipoprocesoempresaprodu));

		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:tipoprocesoempresaprodu.getProductoOrdenDetaProduMaquinas()) {
			ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(connexion);
			productoordendetaprodumaquinaLogic.deepLoad(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
		}

		tipoprocesoempresaprodu.setProductoProduMaquinas(tipoprocesoempresaproduDataAccess.getProductoProduMaquinas(connexion,tipoprocesoempresaprodu));

		for(ProductoProduMaquina productoprodumaquina:tipoprocesoempresaprodu.getProductoProduMaquinas()) {
			ProductoProduMaquinaLogic productoprodumaquinaLogic= new ProductoProduMaquinaLogic(connexion);
			productoprodumaquinaLogic.deepLoad(productoprodumaquina,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoprocesoempresaprodu.setEmpresa(tipoprocesoempresaproduDataAccess.getEmpresa(connexion,tipoprocesoempresaprodu));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoprocesoempresaprodu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ProductoProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprocesoempresaprodu.setProductoProduManos(tipoprocesoempresaproduDataAccess.getProductoProduManos(connexion,tipoprocesoempresaprodu));

				for(ProductoProduMano productoprodumano:tipoprocesoempresaprodu.getProductoProduManos()) {
					ProductoProduManoLogic productoprodumanoLogic= new ProductoProduManoLogic(connexion);
					productoprodumanoLogic.deepLoad(productoprodumano,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprocesoempresaprodu.setProductoOrdenDetaProduManos(tipoprocesoempresaproduDataAccess.getProductoOrdenDetaProduManos(connexion,tipoprocesoempresaprodu));

				for(ProductoOrdenDetaProduMano productoordendetaprodumano:tipoprocesoempresaprodu.getProductoOrdenDetaProduManos()) {
					ProductoOrdenDetaProduManoLogic productoordendetaprodumanoLogic= new ProductoOrdenDetaProduManoLogic(connexion);
					productoordendetaprodumanoLogic.deepLoad(productoordendetaprodumano,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprocesoempresaprodu.setProductoOrdenDetaProduMaquinas(tipoprocesoempresaproduDataAccess.getProductoOrdenDetaProduMaquinas(connexion,tipoprocesoempresaprodu));

				for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:tipoprocesoempresaprodu.getProductoOrdenDetaProduMaquinas()) {
					ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(connexion);
					productoordendetaprodumaquinaLogic.deepLoad(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprocesoempresaprodu.setProductoProduMaquinas(tipoprocesoempresaproduDataAccess.getProductoProduMaquinas(connexion,tipoprocesoempresaprodu));

				for(ProductoProduMaquina productoprodumaquina:tipoprocesoempresaprodu.getProductoProduMaquinas()) {
					ProductoProduMaquinaLogic productoprodumaquinaLogic= new ProductoProduMaquinaLogic(connexion);
					productoprodumaquinaLogic.deepLoad(productoprodumaquina,isDeep,deepLoadType,clases);
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
			tipoprocesoempresaprodu.setEmpresa(tipoprocesoempresaproduDataAccess.getEmpresa(connexion,tipoprocesoempresaprodu));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoprocesoempresaprodu.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoProduMano.class));
			tipoprocesoempresaprodu.setProductoProduManos(tipoprocesoempresaproduDataAccess.getProductoProduManos(connexion,tipoprocesoempresaprodu));

			for(ProductoProduMano productoprodumano:tipoprocesoempresaprodu.getProductoProduManos()) {
				ProductoProduManoLogic productoprodumanoLogic= new ProductoProduManoLogic(connexion);
				productoprodumanoLogic.deepLoad(productoprodumano,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoOrdenDetaProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoOrdenDetaProduMano.class));
			tipoprocesoempresaprodu.setProductoOrdenDetaProduManos(tipoprocesoempresaproduDataAccess.getProductoOrdenDetaProduManos(connexion,tipoprocesoempresaprodu));

			for(ProductoOrdenDetaProduMano productoordendetaprodumano:tipoprocesoempresaprodu.getProductoOrdenDetaProduManos()) {
				ProductoOrdenDetaProduManoLogic productoordendetaprodumanoLogic= new ProductoOrdenDetaProduManoLogic(connexion);
				productoordendetaprodumanoLogic.deepLoad(productoordendetaprodumano,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoOrdenDetaProduMaquina.class));
			tipoprocesoempresaprodu.setProductoOrdenDetaProduMaquinas(tipoprocesoempresaproduDataAccess.getProductoOrdenDetaProduMaquinas(connexion,tipoprocesoempresaprodu));

			for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:tipoprocesoempresaprodu.getProductoOrdenDetaProduMaquinas()) {
				ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(connexion);
				productoordendetaprodumaquinaLogic.deepLoad(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProductoProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProductoProduMaquina.class));
			tipoprocesoempresaprodu.setProductoProduMaquinas(tipoprocesoempresaproduDataAccess.getProductoProduMaquinas(connexion,tipoprocesoempresaprodu));

			for(ProductoProduMaquina productoprodumaquina:tipoprocesoempresaprodu.getProductoProduMaquinas()) {
				ProductoProduMaquinaLogic productoprodumaquinaLogic= new ProductoProduMaquinaLogic(connexion);
				productoprodumaquinaLogic.deepLoad(productoprodumaquina,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoProcesoEmpresaProdu tipoprocesoempresaprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoProcesoEmpresaProduLogicAdditional.updateTipoProcesoEmpresaProduToSave(tipoprocesoempresaprodu,this.arrDatoGeneral);
			
TipoProcesoEmpresaProduDataAccess.save(tipoprocesoempresaprodu, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoprocesoempresaprodu.getEmpresa(),connexion);

		for(ProductoProduMano productoprodumano:tipoprocesoempresaprodu.getProductoProduManos()) {
			productoprodumano.setid_tipo_proceso_empresa_produ(tipoprocesoempresaprodu.getId());
			ProductoProduManoDataAccess.save(productoprodumano,connexion);
		}

		for(ProductoOrdenDetaProduMano productoordendetaprodumano:tipoprocesoempresaprodu.getProductoOrdenDetaProduManos()) {
			productoordendetaprodumano.setid_tipo_proceso_empresa_produ(tipoprocesoempresaprodu.getId());
			ProductoOrdenDetaProduManoDataAccess.save(productoordendetaprodumano,connexion);
		}

		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:tipoprocesoempresaprodu.getProductoOrdenDetaProduMaquinas()) {
			productoordendetaprodumaquina.setid_tipo_proceso_empresa_produ(tipoprocesoempresaprodu.getId());
			ProductoOrdenDetaProduMaquinaDataAccess.save(productoordendetaprodumaquina,connexion);
		}

		for(ProductoProduMaquina productoprodumaquina:tipoprocesoempresaprodu.getProductoProduMaquinas()) {
			productoprodumaquina.setid_tipo_proceso_empresa_produ(tipoprocesoempresaprodu.getId());
			ProductoProduMaquinaDataAccess.save(productoprodumaquina,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoprocesoempresaprodu.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(ProductoProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoProduMano productoprodumano:tipoprocesoempresaprodu.getProductoProduManos()) {
					productoprodumano.setid_tipo_proceso_empresa_produ(tipoprocesoempresaprodu.getId());
					ProductoProduManoDataAccess.save(productoprodumano,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoOrdenDetaProduMano productoordendetaprodumano:tipoprocesoempresaprodu.getProductoOrdenDetaProduManos()) {
					productoordendetaprodumano.setid_tipo_proceso_empresa_produ(tipoprocesoempresaprodu.getId());
					ProductoOrdenDetaProduManoDataAccess.save(productoordendetaprodumano,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:tipoprocesoempresaprodu.getProductoOrdenDetaProduMaquinas()) {
					productoordendetaprodumaquina.setid_tipo_proceso_empresa_produ(tipoprocesoempresaprodu.getId());
					ProductoOrdenDetaProduMaquinaDataAccess.save(productoordendetaprodumaquina,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProductoProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoProduMaquina productoprodumaquina:tipoprocesoempresaprodu.getProductoProduMaquinas()) {
					productoprodumaquina.setid_tipo_proceso_empresa_produ(tipoprocesoempresaprodu.getId());
					ProductoProduMaquinaDataAccess.save(productoprodumaquina,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoprocesoempresaprodu.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoprocesoempresaprodu.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(ProductoProduMano productoprodumano:tipoprocesoempresaprodu.getProductoProduManos()) {
			ProductoProduManoLogic productoprodumanoLogic= new ProductoProduManoLogic(connexion);
			productoprodumano.setid_tipo_proceso_empresa_produ(tipoprocesoempresaprodu.getId());
			ProductoProduManoDataAccess.save(productoprodumano,connexion);
			productoprodumanoLogic.deepSave(productoprodumano,isDeep,deepLoadType,clases);
		}

		for(ProductoOrdenDetaProduMano productoordendetaprodumano:tipoprocesoempresaprodu.getProductoOrdenDetaProduManos()) {
			ProductoOrdenDetaProduManoLogic productoordendetaprodumanoLogic= new ProductoOrdenDetaProduManoLogic(connexion);
			productoordendetaprodumano.setid_tipo_proceso_empresa_produ(tipoprocesoempresaprodu.getId());
			ProductoOrdenDetaProduManoDataAccess.save(productoordendetaprodumano,connexion);
			productoordendetaprodumanoLogic.deepSave(productoordendetaprodumano,isDeep,deepLoadType,clases);
		}

		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:tipoprocesoempresaprodu.getProductoOrdenDetaProduMaquinas()) {
			ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(connexion);
			productoordendetaprodumaquina.setid_tipo_proceso_empresa_produ(tipoprocesoempresaprodu.getId());
			ProductoOrdenDetaProduMaquinaDataAccess.save(productoordendetaprodumaquina,connexion);
			productoordendetaprodumaquinaLogic.deepSave(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
		}

		for(ProductoProduMaquina productoprodumaquina:tipoprocesoempresaprodu.getProductoProduMaquinas()) {
			ProductoProduMaquinaLogic productoprodumaquinaLogic= new ProductoProduMaquinaLogic(connexion);
			productoprodumaquina.setid_tipo_proceso_empresa_produ(tipoprocesoempresaprodu.getId());
			ProductoProduMaquinaDataAccess.save(productoprodumaquina,connexion);
			productoprodumaquinaLogic.deepSave(productoprodumaquina,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoprocesoempresaprodu.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipoprocesoempresaprodu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(ProductoProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoProduMano productoprodumano:tipoprocesoempresaprodu.getProductoProduManos()) {
					ProductoProduManoLogic productoprodumanoLogic= new ProductoProduManoLogic(connexion);
					productoprodumano.setid_tipo_proceso_empresa_produ(tipoprocesoempresaprodu.getId());
					ProductoProduManoDataAccess.save(productoprodumano,connexion);
					productoprodumanoLogic.deepSave(productoprodumano,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMano.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoOrdenDetaProduMano productoordendetaprodumano:tipoprocesoempresaprodu.getProductoOrdenDetaProduManos()) {
					ProductoOrdenDetaProduManoLogic productoordendetaprodumanoLogic= new ProductoOrdenDetaProduManoLogic(connexion);
					productoordendetaprodumano.setid_tipo_proceso_empresa_produ(tipoprocesoempresaprodu.getId());
					ProductoOrdenDetaProduManoDataAccess.save(productoordendetaprodumano,connexion);
					productoordendetaprodumanoLogic.deepSave(productoordendetaprodumano,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:tipoprocesoempresaprodu.getProductoOrdenDetaProduMaquinas()) {
					ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(connexion);
					productoordendetaprodumaquina.setid_tipo_proceso_empresa_produ(tipoprocesoempresaprodu.getId());
					ProductoOrdenDetaProduMaquinaDataAccess.save(productoordendetaprodumaquina,connexion);
					productoordendetaprodumaquinaLogic.deepSave(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoProduMaquina productoprodumaquina:tipoprocesoempresaprodu.getProductoProduMaquinas()) {
					ProductoProduMaquinaLogic productoprodumaquinaLogic= new ProductoProduMaquinaLogic(connexion);
					productoprodumaquina.setid_tipo_proceso_empresa_produ(tipoprocesoempresaprodu.getId());
					ProductoProduMaquinaDataAccess.save(productoprodumaquina,connexion);
					productoprodumaquinaLogic.deepSave(productoprodumaquina,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoProcesoEmpresaProdu.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoprocesoempresaprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoProcesoEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(tipoprocesoempresaprodu);
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
			this.deepLoad(this.tipoprocesoempresaprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoProcesoEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(this.tipoprocesoempresaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoProcesoEmpresaProdu.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoprocesoempresaprodus!=null) {
				for(TipoProcesoEmpresaProdu tipoprocesoempresaprodu:tipoprocesoempresaprodus) {
					this.deepLoad(tipoprocesoempresaprodu,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoProcesoEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(tipoprocesoempresaprodus);
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
			if(tipoprocesoempresaprodus!=null) {
				for(TipoProcesoEmpresaProdu tipoprocesoempresaprodu:tipoprocesoempresaprodus) {
					this.deepLoad(tipoprocesoempresaprodu,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoProcesoEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(tipoprocesoempresaprodus);
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
			this.getNewConnexionToDeep(TipoProcesoEmpresaProdu.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoprocesoempresaprodu,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoProcesoEmpresaProdu.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoprocesoempresaprodus!=null) {
				for(TipoProcesoEmpresaProdu tipoprocesoempresaprodu:tipoprocesoempresaprodus) {
					this.deepSave(tipoprocesoempresaprodu,isDeep,deepLoadType,clases);
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
			if(tipoprocesoempresaprodus!=null) {
				for(TipoProcesoEmpresaProdu tipoprocesoempresaprodu:tipoprocesoempresaprodus) {
					this.deepSave(tipoprocesoempresaprodu,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoProcesoEmpresaProdusFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoEmpresaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoProcesoEmpresaProduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoProcesoEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprocesoempresaprodus=tipoprocesoempresaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoProcesoEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(this.tipoprocesoempresaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoProcesoEmpresaProdusFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoProcesoEmpresaProduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoProcesoEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoprocesoempresaprodus=tipoprocesoempresaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoProcesoEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoEmpresaProdu(this.tipoprocesoempresaprodus);
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
			if(TipoProcesoEmpresaProduConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProcesoEmpresaProduDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoProcesoEmpresaProdu tipoprocesoempresaprodu,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoProcesoEmpresaProduConstantesFunciones.ISCONAUDITORIA) {
				if(tipoprocesoempresaprodu.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProcesoEmpresaProduDataAccess.TABLENAME, tipoprocesoempresaprodu.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoProcesoEmpresaProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoProcesoEmpresaProduLogic.registrarAuditoriaDetallesTipoProcesoEmpresaProdu(connexion,tipoprocesoempresaprodu,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoprocesoempresaprodu.getIsDeleted()) {
					/*if(!tipoprocesoempresaprodu.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoProcesoEmpresaProduDataAccess.TABLENAME, tipoprocesoempresaprodu.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoProcesoEmpresaProduLogic.registrarAuditoriaDetallesTipoProcesoEmpresaProdu(connexion,tipoprocesoempresaprodu,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProcesoEmpresaProduDataAccess.TABLENAME, tipoprocesoempresaprodu.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoprocesoempresaprodu.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProcesoEmpresaProduDataAccess.TABLENAME, tipoprocesoempresaprodu.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoProcesoEmpresaProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoProcesoEmpresaProduLogic.registrarAuditoriaDetallesTipoProcesoEmpresaProdu(connexion,tipoprocesoempresaprodu,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoProcesoEmpresaProdu(Connexion connexion,TipoProcesoEmpresaProdu tipoprocesoempresaprodu)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoprocesoempresaprodu.getIsNew()||!tipoprocesoempresaprodu.getid_empresa().equals(tipoprocesoempresaprodu.getTipoProcesoEmpresaProduOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprocesoempresaprodu.getTipoProcesoEmpresaProduOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoprocesoempresaprodu.getTipoProcesoEmpresaProduOriginal().getid_empresa().toString();
				}
				if(tipoprocesoempresaprodu.getid_empresa()!=null)
				{
					strValorNuevo=tipoprocesoempresaprodu.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProcesoEmpresaProduConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoprocesoempresaprodu.getIsNew()||!tipoprocesoempresaprodu.getnombre().equals(tipoprocesoempresaprodu.getTipoProcesoEmpresaProduOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprocesoempresaprodu.getTipoProcesoEmpresaProduOriginal().getnombre()!=null)
				{
					strValorActual=tipoprocesoempresaprodu.getTipoProcesoEmpresaProduOriginal().getnombre();
				}
				if(tipoprocesoempresaprodu.getnombre()!=null)
				{
					strValorNuevo=tipoprocesoempresaprodu.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProcesoEmpresaProduConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipoprocesoempresaprodu.getIsNew()||!tipoprocesoempresaprodu.getdescripcion().equals(tipoprocesoempresaprodu.getTipoProcesoEmpresaProduOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprocesoempresaprodu.getTipoProcesoEmpresaProduOriginal().getdescripcion()!=null)
				{
					strValorActual=tipoprocesoempresaprodu.getTipoProcesoEmpresaProduOriginal().getdescripcion();
				}
				if(tipoprocesoempresaprodu.getdescripcion()!=null)
				{
					strValorNuevo=tipoprocesoempresaprodu.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProcesoEmpresaProduConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoProcesoEmpresaProduRelacionesWithConnection(TipoProcesoEmpresaProdu tipoprocesoempresaprodu,List<ProductoProduMano> productoprodumanos,List<ProductoOrdenDetaProduMano> productoordendetaprodumanos,List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,List<ProductoProduMaquina> productoprodumaquinas) throws Exception {

		if(!tipoprocesoempresaprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoProcesoEmpresaProduRelacionesBase(tipoprocesoempresaprodu,productoprodumanos,productoordendetaprodumanos,productoordendetaprodumaquinas,productoprodumaquinas,true);
		}
	}

	public void saveTipoProcesoEmpresaProduRelaciones(TipoProcesoEmpresaProdu tipoprocesoempresaprodu,List<ProductoProduMano> productoprodumanos,List<ProductoOrdenDetaProduMano> productoordendetaprodumanos,List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,List<ProductoProduMaquina> productoprodumaquinas)throws Exception {

		if(!tipoprocesoempresaprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoProcesoEmpresaProduRelacionesBase(tipoprocesoempresaprodu,productoprodumanos,productoordendetaprodumanos,productoordendetaprodumaquinas,productoprodumaquinas,false);
		}
	}

	public void saveTipoProcesoEmpresaProduRelacionesBase(TipoProcesoEmpresaProdu tipoprocesoempresaprodu,List<ProductoProduMano> productoprodumanos,List<ProductoOrdenDetaProduMano> productoordendetaprodumanos,List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,List<ProductoProduMaquina> productoprodumaquinas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoProcesoEmpresaProdu-saveRelacionesWithConnection");}
	
			tipoprocesoempresaprodu.setProductoProduManos(productoprodumanos);
			tipoprocesoempresaprodu.setProductoOrdenDetaProduManos(productoordendetaprodumanos);
			tipoprocesoempresaprodu.setProductoOrdenDetaProduMaquinas(productoordendetaprodumaquinas);
			tipoprocesoempresaprodu.setProductoProduMaquinas(productoprodumaquinas);

			this.setTipoProcesoEmpresaProdu(tipoprocesoempresaprodu);

			if(TipoProcesoEmpresaProduLogicAdditional.validarSaveRelaciones(tipoprocesoempresaprodu,this)) {

				TipoProcesoEmpresaProduLogicAdditional.updateRelacionesToSave(tipoprocesoempresaprodu,this);

				if((tipoprocesoempresaprodu.getIsNew()||tipoprocesoempresaprodu.getIsChanged())&&!tipoprocesoempresaprodu.getIsDeleted()) {
					this.saveTipoProcesoEmpresaProdu();
					this.saveTipoProcesoEmpresaProduRelacionesDetalles(productoprodumanos,productoordendetaprodumanos,productoordendetaprodumaquinas,productoprodumaquinas);

				} else if(tipoprocesoempresaprodu.getIsDeleted()) {
					this.saveTipoProcesoEmpresaProduRelacionesDetalles(productoprodumanos,productoordendetaprodumanos,productoordendetaprodumaquinas,productoprodumaquinas);
					this.saveTipoProcesoEmpresaProdu();
				}

				TipoProcesoEmpresaProduLogicAdditional.updateRelacionesToSaveAfter(tipoprocesoempresaprodu,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ProductoProduManoConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoProduManos(productoprodumanos,true,true);
			ProductoOrdenDetaProduManoConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoOrdenDetaProduManos(productoordendetaprodumanos,true,true);
			ProductoOrdenDetaProduMaquinaConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoOrdenDetaProduMaquinas(productoordendetaprodumaquinas,true,true);
			ProductoProduMaquinaConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoProduMaquinas(productoprodumaquinas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoProcesoEmpresaProduRelacionesDetalles(List<ProductoProduMano> productoprodumanos,List<ProductoOrdenDetaProduMano> productoordendetaprodumanos,List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,List<ProductoProduMaquina> productoprodumaquinas)throws Exception {
		try {
	

			Long idTipoProcesoEmpresaProduActual=this.getTipoProcesoEmpresaProdu().getId();

			ProductoProduManoLogic productoprodumanoLogic_Desde_TipoProcesoEmpresaProdu=new ProductoProduManoLogic();
			productoprodumanoLogic_Desde_TipoProcesoEmpresaProdu.setProductoProduManos(productoprodumanos);

			productoprodumanoLogic_Desde_TipoProcesoEmpresaProdu.setConnexion(this.getConnexion());
			productoprodumanoLogic_Desde_TipoProcesoEmpresaProdu.setDatosCliente(this.datosCliente);

			for(ProductoProduMano productoprodumano_Desde_TipoProcesoEmpresaProdu:productoprodumanoLogic_Desde_TipoProcesoEmpresaProdu.getProductoProduManos()) {
				productoprodumano_Desde_TipoProcesoEmpresaProdu.setid_tipo_proceso_empresa_produ(idTipoProcesoEmpresaProduActual);
			}

			productoprodumanoLogic_Desde_TipoProcesoEmpresaProdu.saveProductoProduManos();

			ProductoOrdenDetaProduManoLogic productoordendetaprodumanoLogic_Desde_TipoProcesoEmpresaProdu=new ProductoOrdenDetaProduManoLogic();
			productoordendetaprodumanoLogic_Desde_TipoProcesoEmpresaProdu.setProductoOrdenDetaProduManos(productoordendetaprodumanos);

			productoordendetaprodumanoLogic_Desde_TipoProcesoEmpresaProdu.setConnexion(this.getConnexion());
			productoordendetaprodumanoLogic_Desde_TipoProcesoEmpresaProdu.setDatosCliente(this.datosCliente);

			for(ProductoOrdenDetaProduMano productoordendetaprodumano_Desde_TipoProcesoEmpresaProdu:productoordendetaprodumanoLogic_Desde_TipoProcesoEmpresaProdu.getProductoOrdenDetaProduManos()) {
				productoordendetaprodumano_Desde_TipoProcesoEmpresaProdu.setid_tipo_proceso_empresa_produ(idTipoProcesoEmpresaProduActual);
			}

			productoordendetaprodumanoLogic_Desde_TipoProcesoEmpresaProdu.saveProductoOrdenDetaProduManos();

			ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic_Desde_TipoProcesoEmpresaProdu=new ProductoOrdenDetaProduMaquinaLogic();
			productoordendetaprodumaquinaLogic_Desde_TipoProcesoEmpresaProdu.setProductoOrdenDetaProduMaquinas(productoordendetaprodumaquinas);

			productoordendetaprodumaquinaLogic_Desde_TipoProcesoEmpresaProdu.setConnexion(this.getConnexion());
			productoordendetaprodumaquinaLogic_Desde_TipoProcesoEmpresaProdu.setDatosCliente(this.datosCliente);

			for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina_Desde_TipoProcesoEmpresaProdu:productoordendetaprodumaquinaLogic_Desde_TipoProcesoEmpresaProdu.getProductoOrdenDetaProduMaquinas()) {
				productoordendetaprodumaquina_Desde_TipoProcesoEmpresaProdu.setid_tipo_proceso_empresa_produ(idTipoProcesoEmpresaProduActual);
			}

			productoordendetaprodumaquinaLogic_Desde_TipoProcesoEmpresaProdu.saveProductoOrdenDetaProduMaquinas();

			ProductoProduMaquinaLogic productoprodumaquinaLogic_Desde_TipoProcesoEmpresaProdu=new ProductoProduMaquinaLogic();
			productoprodumaquinaLogic_Desde_TipoProcesoEmpresaProdu.setProductoProduMaquinas(productoprodumaquinas);

			productoprodumaquinaLogic_Desde_TipoProcesoEmpresaProdu.setConnexion(this.getConnexion());
			productoprodumaquinaLogic_Desde_TipoProcesoEmpresaProdu.setDatosCliente(this.datosCliente);

			for(ProductoProduMaquina productoprodumaquina_Desde_TipoProcesoEmpresaProdu:productoprodumaquinaLogic_Desde_TipoProcesoEmpresaProdu.getProductoProduMaquinas()) {
				productoprodumaquina_Desde_TipoProcesoEmpresaProdu.setid_tipo_proceso_empresa_produ(idTipoProcesoEmpresaProduActual);
			}

			productoprodumaquinaLogic_Desde_TipoProcesoEmpresaProdu.saveProductoProduMaquinas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoProcesoEmpresaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoProcesoEmpresaProduConstantesFunciones.getClassesForeignKeysOfTipoProcesoEmpresaProdu(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProcesoEmpresaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoProcesoEmpresaProduConstantesFunciones.getClassesRelationshipsOfTipoProcesoEmpresaProdu(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

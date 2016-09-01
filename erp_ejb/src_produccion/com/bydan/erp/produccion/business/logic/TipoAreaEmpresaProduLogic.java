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
import com.bydan.erp.produccion.util.TipoAreaEmpresaProduConstantesFunciones;
import com.bydan.erp.produccion.util.TipoAreaEmpresaProduParameterReturnGeneral;
//import com.bydan.erp.produccion.util.TipoAreaEmpresaProduParameterGeneral;
import com.bydan.erp.produccion.business.entity.TipoAreaEmpresaProdu;
import com.bydan.erp.produccion.business.logic.TipoAreaEmpresaProduLogicAdditional;
import com.bydan.erp.produccion.business.dataaccess.*;
import com.bydan.erp.produccion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoAreaEmpresaProduLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoAreaEmpresaProduLogic.class);
	
	protected TipoAreaEmpresaProduDataAccess tipoareaempresaproduDataAccess; 	
	protected TipoAreaEmpresaProdu tipoareaempresaprodu;
	protected List<TipoAreaEmpresaProdu> tipoareaempresaprodus;
	protected Object tipoareaempresaproduObject;	
	protected List<Object> tipoareaempresaprodusObject;
	
	public static ClassValidator<TipoAreaEmpresaProdu> tipoareaempresaproduValidator = new ClassValidator<TipoAreaEmpresaProdu>(TipoAreaEmpresaProdu.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoAreaEmpresaProduLogicAdditional tipoareaempresaproduLogicAdditional=null;
	
	public TipoAreaEmpresaProduLogicAdditional getTipoAreaEmpresaProduLogicAdditional() {
		return this.tipoareaempresaproduLogicAdditional;
	}
	
	public void setTipoAreaEmpresaProduLogicAdditional(TipoAreaEmpresaProduLogicAdditional tipoareaempresaproduLogicAdditional) {
		try {
			this.tipoareaempresaproduLogicAdditional=tipoareaempresaproduLogicAdditional;
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
	
	
	
	
	public  TipoAreaEmpresaProduLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoareaempresaproduDataAccess = new TipoAreaEmpresaProduDataAccess();
			
			this.tipoareaempresaprodus= new ArrayList<TipoAreaEmpresaProdu>();
			this.tipoareaempresaprodu= new TipoAreaEmpresaProdu();
			
			this.tipoareaempresaproduObject=new Object();
			this.tipoareaempresaprodusObject=new ArrayList<Object>();
				
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
			
			this.tipoareaempresaproduDataAccess.setConnexionType(this.connexionType);
			this.tipoareaempresaproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoAreaEmpresaProduLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoareaempresaproduDataAccess = new TipoAreaEmpresaProduDataAccess();
			this.tipoareaempresaprodus= new ArrayList<TipoAreaEmpresaProdu>();
			this.tipoareaempresaprodu= new TipoAreaEmpresaProdu();
			this.tipoareaempresaproduObject=new Object();
			this.tipoareaempresaprodusObject=new ArrayList<Object>();
			
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
			
			this.tipoareaempresaproduDataAccess.setConnexionType(this.connexionType);
			this.tipoareaempresaproduDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoAreaEmpresaProdu getTipoAreaEmpresaProdu() throws Exception {	
		TipoAreaEmpresaProduLogicAdditional.checkTipoAreaEmpresaProduToGet(tipoareaempresaprodu,this.datosCliente,this.arrDatoGeneral);
		TipoAreaEmpresaProduLogicAdditional.updateTipoAreaEmpresaProduToGet(tipoareaempresaprodu,this.arrDatoGeneral);
		
		return tipoareaempresaprodu;
	}
		
	public void setTipoAreaEmpresaProdu(TipoAreaEmpresaProdu newTipoAreaEmpresaProdu) {
		this.tipoareaempresaprodu = newTipoAreaEmpresaProdu;
	}
	
	public TipoAreaEmpresaProduDataAccess getTipoAreaEmpresaProduDataAccess() {
		return tipoareaempresaproduDataAccess;
	}
	
	public void setTipoAreaEmpresaProduDataAccess(TipoAreaEmpresaProduDataAccess newtipoareaempresaproduDataAccess) {
		this.tipoareaempresaproduDataAccess = newtipoareaempresaproduDataAccess;
	}
	
	public List<TipoAreaEmpresaProdu> getTipoAreaEmpresaProdus() throws Exception {		
		this.quitarTipoAreaEmpresaProdusNulos();
		
		TipoAreaEmpresaProduLogicAdditional.checkTipoAreaEmpresaProduToGets(tipoareaempresaprodus,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoAreaEmpresaProdu tipoareaempresaproduLocal: tipoareaempresaprodus ) {
			TipoAreaEmpresaProduLogicAdditional.updateTipoAreaEmpresaProduToGet(tipoareaempresaproduLocal,this.arrDatoGeneral);
		}
		
		return tipoareaempresaprodus;
	}
	
	public void setTipoAreaEmpresaProdus(List<TipoAreaEmpresaProdu> newTipoAreaEmpresaProdus) {
		this.tipoareaempresaprodus = newTipoAreaEmpresaProdus;
	}
	
	public Object getTipoAreaEmpresaProduObject() {	
		this.tipoareaempresaproduObject=this.tipoareaempresaproduDataAccess.getEntityObject();
		return this.tipoareaempresaproduObject;
	}
		
	public void setTipoAreaEmpresaProduObject(Object newTipoAreaEmpresaProduObject) {
		this.tipoareaempresaproduObject = newTipoAreaEmpresaProduObject;
	}
	
	public List<Object> getTipoAreaEmpresaProdusObject() {		
		this.tipoareaempresaprodusObject=this.tipoareaempresaproduDataAccess.getEntitiesObject();
		return this.tipoareaempresaprodusObject;
	}
		
	public void setTipoAreaEmpresaProdusObject(List<Object> newTipoAreaEmpresaProdusObject) {
		this.tipoareaempresaprodusObject = newTipoAreaEmpresaProdusObject;
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
		
		if(this.tipoareaempresaproduDataAccess!=null) {
			this.tipoareaempresaproduDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaEmpresaProdu.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoareaempresaproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoareaempresaproduDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoareaempresaprodu = new  TipoAreaEmpresaProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaEmpresaProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoareaempresaprodu=tipoareaempresaproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoareaempresaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoAreaEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(this.tipoareaempresaprodu);
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
		tipoareaempresaprodu = new  TipoAreaEmpresaProdu();
		  		  
        try {
			
			tipoareaempresaprodu=tipoareaempresaproduDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoareaempresaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoAreaEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(this.tipoareaempresaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoareaempresaprodu = new  TipoAreaEmpresaProdu();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaEmpresaProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoareaempresaprodu=tipoareaempresaproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoareaempresaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoAreaEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(this.tipoareaempresaprodu);
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
		tipoareaempresaprodu = new  TipoAreaEmpresaProdu();
		  		  
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
		tipoareaempresaprodu = new  TipoAreaEmpresaProdu();
		  		  
        try {
			
			tipoareaempresaprodu=tipoareaempresaproduDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoareaempresaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoAreaEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(this.tipoareaempresaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoareaempresaprodu = new  TipoAreaEmpresaProdu();
		  		  
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
		tipoareaempresaprodu = new  TipoAreaEmpresaProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaEmpresaProdu.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoareaempresaproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoareaempresaprodu = new  TipoAreaEmpresaProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoareaempresaproduDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoareaempresaprodu = new  TipoAreaEmpresaProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaEmpresaProdu.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoareaempresaproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoareaempresaprodu = new  TipoAreaEmpresaProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoareaempresaproduDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoareaempresaprodu = new  TipoAreaEmpresaProdu();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaEmpresaProdu.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoareaempresaproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoareaempresaprodu = new  TipoAreaEmpresaProdu();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoareaempresaproduDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoareaempresaprodus = new  ArrayList<TipoAreaEmpresaProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaEmpresaProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoAreaEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoareaempresaprodus=tipoareaempresaproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAreaEmpresaProdu(tipoareaempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(this.tipoareaempresaprodus);
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
		tipoareaempresaprodus = new  ArrayList<TipoAreaEmpresaProdu>();
		  		  
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
		tipoareaempresaprodus = new  ArrayList<TipoAreaEmpresaProdu>();
		  		  
        try {			
			TipoAreaEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoareaempresaprodus=tipoareaempresaproduDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoAreaEmpresaProdu(tipoareaempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(this.tipoareaempresaprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoareaempresaprodus = new  ArrayList<TipoAreaEmpresaProdu>();
		  		  
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
		tipoareaempresaprodus = new  ArrayList<TipoAreaEmpresaProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaEmpresaProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoAreaEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoareaempresaprodus=tipoareaempresaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAreaEmpresaProdu(tipoareaempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(this.tipoareaempresaprodus);
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
		tipoareaempresaprodus = new  ArrayList<TipoAreaEmpresaProdu>();
		  		  
        try {
			TipoAreaEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoareaempresaprodus=tipoareaempresaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAreaEmpresaProdu(tipoareaempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(this.tipoareaempresaprodus);
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
		tipoareaempresaprodus = new  ArrayList<TipoAreaEmpresaProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaEmpresaProdu.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAreaEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoareaempresaprodus=tipoareaempresaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoAreaEmpresaProdu(tipoareaempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(this.tipoareaempresaprodus);
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
		tipoareaempresaprodus = new  ArrayList<TipoAreaEmpresaProdu>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAreaEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoareaempresaprodus=tipoareaempresaproduDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoAreaEmpresaProdu(tipoareaempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(this.tipoareaempresaprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoareaempresaprodu = new  TipoAreaEmpresaProdu();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaEmpresaProdu.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAreaEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoareaempresaprodu=tipoareaempresaproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoAreaEmpresaProdu(tipoareaempresaprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(this.tipoareaempresaprodu);
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
		tipoareaempresaprodu = new  TipoAreaEmpresaProdu();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAreaEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoareaempresaprodu=tipoareaempresaproduDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoAreaEmpresaProdu(tipoareaempresaprodu);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(this.tipoareaempresaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoareaempresaprodus = new  ArrayList<TipoAreaEmpresaProdu>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaEmpresaProdu.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoAreaEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoareaempresaprodus=tipoareaempresaproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAreaEmpresaProdu(tipoareaempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(this.tipoareaempresaprodus);
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
		tipoareaempresaprodus = new  ArrayList<TipoAreaEmpresaProdu>();
		  		  
        try {
			TipoAreaEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoareaempresaprodus=tipoareaempresaproduDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoAreaEmpresaProdu(tipoareaempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(this.tipoareaempresaprodus);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoAreaEmpresaProdusWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoareaempresaprodus = new  ArrayList<TipoAreaEmpresaProdu>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaEmpresaProdu.class.getSimpleName()+"-getTodosTipoAreaEmpresaProdusWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAreaEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoareaempresaprodus=tipoareaempresaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoAreaEmpresaProdu(tipoareaempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(this.tipoareaempresaprodus);
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
	
	public  void  getTodosTipoAreaEmpresaProdus(String sFinalQuery,Pagination pagination)throws Exception {
		tipoareaempresaprodus = new  ArrayList<TipoAreaEmpresaProdu>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoAreaEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoareaempresaprodus=tipoareaempresaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoAreaEmpresaProdu(tipoareaempresaprodus);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoAreaEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(this.tipoareaempresaprodus);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoAreaEmpresaProdu(TipoAreaEmpresaProdu tipoareaempresaprodu) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoareaempresaprodu.getIsNew() || tipoareaempresaprodu.getIsChanged()) { 
			this.invalidValues = tipoareaempresaproduValidator.getInvalidValues(tipoareaempresaprodu);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoareaempresaprodu);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoAreaEmpresaProdu(List<TipoAreaEmpresaProdu> TipoAreaEmpresaProdus) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoAreaEmpresaProdu tipoareaempresaproduLocal:tipoareaempresaprodus) {				
			estaValidadoObjeto=this.validarGuardarTipoAreaEmpresaProdu(tipoareaempresaproduLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoAreaEmpresaProdu(List<TipoAreaEmpresaProdu> TipoAreaEmpresaProdus) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoAreaEmpresaProdu(tipoareaempresaprodus)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoAreaEmpresaProdu(TipoAreaEmpresaProdu TipoAreaEmpresaProdu) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoAreaEmpresaProdu(tipoareaempresaprodu)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoAreaEmpresaProdu tipoareaempresaprodu) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoareaempresaprodu.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoAreaEmpresaProduConstantesFunciones.getTipoAreaEmpresaProduLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoareaempresaprodu","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoAreaEmpresaProduConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoAreaEmpresaProduConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoAreaEmpresaProduWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaEmpresaProdu.class.getSimpleName()+"-saveTipoAreaEmpresaProduWithConnection");connexion.begin();			
			
			TipoAreaEmpresaProduLogicAdditional.checkTipoAreaEmpresaProduToSave(this.tipoareaempresaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoAreaEmpresaProduLogicAdditional.updateTipoAreaEmpresaProduToSave(this.tipoareaempresaprodu,this.arrDatoGeneral);
			
			TipoAreaEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoareaempresaprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoAreaEmpresaProdu();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoAreaEmpresaProdu(this.tipoareaempresaprodu)) {
				TipoAreaEmpresaProduDataAccess.save(this.tipoareaempresaprodu, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoareaempresaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoAreaEmpresaProduLogicAdditional.checkTipoAreaEmpresaProduToSaveAfter(this.tipoareaempresaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoAreaEmpresaProdu();
			
			connexion.commit();			
			
			if(this.tipoareaempresaprodu.getIsDeleted()) {
				this.tipoareaempresaprodu=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoAreaEmpresaProdu()throws Exception {	
		try {	
			
			TipoAreaEmpresaProduLogicAdditional.checkTipoAreaEmpresaProduToSave(this.tipoareaempresaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoAreaEmpresaProduLogicAdditional.updateTipoAreaEmpresaProduToSave(this.tipoareaempresaprodu,this.arrDatoGeneral);
			
			TipoAreaEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoareaempresaprodu,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoAreaEmpresaProdu(this.tipoareaempresaprodu)) {			
				TipoAreaEmpresaProduDataAccess.save(this.tipoareaempresaprodu, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoareaempresaprodu,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoAreaEmpresaProduLogicAdditional.checkTipoAreaEmpresaProduToSaveAfter(this.tipoareaempresaprodu,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoareaempresaprodu.getIsDeleted()) {
				this.tipoareaempresaprodu=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoAreaEmpresaProdusWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaEmpresaProdu.class.getSimpleName()+"-saveTipoAreaEmpresaProdusWithConnection");connexion.begin();			
			
			TipoAreaEmpresaProduLogicAdditional.checkTipoAreaEmpresaProduToSaves(tipoareaempresaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoAreaEmpresaProdus();
			
			Boolean validadoTodosTipoAreaEmpresaProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoAreaEmpresaProdu tipoareaempresaproduLocal:tipoareaempresaprodus) {		
				if(tipoareaempresaproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoAreaEmpresaProduLogicAdditional.updateTipoAreaEmpresaProduToSave(tipoareaempresaproduLocal,this.arrDatoGeneral);
	        	
				TipoAreaEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoareaempresaproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoAreaEmpresaProdu(tipoareaempresaproduLocal)) {
					TipoAreaEmpresaProduDataAccess.save(tipoareaempresaproduLocal, connexion);				
				} else {
					validadoTodosTipoAreaEmpresaProdu=false;
				}
			}
			
			if(!validadoTodosTipoAreaEmpresaProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoAreaEmpresaProduLogicAdditional.checkTipoAreaEmpresaProduToSavesAfter(tipoareaempresaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoAreaEmpresaProdus();
			
			connexion.commit();		
			
			this.quitarTipoAreaEmpresaProdusEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoAreaEmpresaProdus()throws Exception {				
		 try {	
			TipoAreaEmpresaProduLogicAdditional.checkTipoAreaEmpresaProduToSaves(tipoareaempresaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoAreaEmpresaProdu=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoAreaEmpresaProdu tipoareaempresaproduLocal:tipoareaempresaprodus) {				
				if(tipoareaempresaproduLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoAreaEmpresaProduLogicAdditional.updateTipoAreaEmpresaProduToSave(tipoareaempresaproduLocal,this.arrDatoGeneral);
	        	
				TipoAreaEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoareaempresaproduLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoAreaEmpresaProdu(tipoareaempresaproduLocal)) {				
					TipoAreaEmpresaProduDataAccess.save(tipoareaempresaproduLocal, connexion);				
				} else {
					validadoTodosTipoAreaEmpresaProdu=false;
				}
			}
			
			if(!validadoTodosTipoAreaEmpresaProdu) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoAreaEmpresaProduLogicAdditional.checkTipoAreaEmpresaProduToSavesAfter(tipoareaempresaprodus,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoAreaEmpresaProdusEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoAreaEmpresaProduParameterReturnGeneral procesarAccionTipoAreaEmpresaProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoAreaEmpresaProdu> tipoareaempresaprodus,TipoAreaEmpresaProduParameterReturnGeneral tipoareaempresaproduParameterGeneral)throws Exception {
		 try {	
			TipoAreaEmpresaProduParameterReturnGeneral tipoareaempresaproduReturnGeneral=new TipoAreaEmpresaProduParameterReturnGeneral();
	
			TipoAreaEmpresaProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoareaempresaprodus,tipoareaempresaproduParameterGeneral,tipoareaempresaproduReturnGeneral);
			
			return tipoareaempresaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoAreaEmpresaProduParameterReturnGeneral procesarAccionTipoAreaEmpresaProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoAreaEmpresaProdu> tipoareaempresaprodus,TipoAreaEmpresaProduParameterReturnGeneral tipoareaempresaproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaEmpresaProdu.class.getSimpleName()+"-procesarAccionTipoAreaEmpresaProdusWithConnection");connexion.begin();			
			
			TipoAreaEmpresaProduParameterReturnGeneral tipoareaempresaproduReturnGeneral=new TipoAreaEmpresaProduParameterReturnGeneral();
	
			TipoAreaEmpresaProduLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoareaempresaprodus,tipoareaempresaproduParameterGeneral,tipoareaempresaproduReturnGeneral);
			
			this.connexion.commit();
			
			return tipoareaempresaproduReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoAreaEmpresaProduParameterReturnGeneral procesarEventosTipoAreaEmpresaProdus(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoAreaEmpresaProdu> tipoareaempresaprodus,TipoAreaEmpresaProdu tipoareaempresaprodu,TipoAreaEmpresaProduParameterReturnGeneral tipoareaempresaproduParameterGeneral,Boolean isEsNuevoTipoAreaEmpresaProdu,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoAreaEmpresaProduParameterReturnGeneral tipoareaempresaproduReturnGeneral=new TipoAreaEmpresaProduParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoareaempresaproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoAreaEmpresaProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoareaempresaprodus,tipoareaempresaprodu,tipoareaempresaproduParameterGeneral,tipoareaempresaproduReturnGeneral,isEsNuevoTipoAreaEmpresaProdu,clases);
			
			return tipoareaempresaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoAreaEmpresaProduParameterReturnGeneral procesarEventosTipoAreaEmpresaProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoAreaEmpresaProdu> tipoareaempresaprodus,TipoAreaEmpresaProdu tipoareaempresaprodu,TipoAreaEmpresaProduParameterReturnGeneral tipoareaempresaproduParameterGeneral,Boolean isEsNuevoTipoAreaEmpresaProdu,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaEmpresaProdu.class.getSimpleName()+"-procesarEventosTipoAreaEmpresaProdusWithConnection");connexion.begin();			
			
			TipoAreaEmpresaProduParameterReturnGeneral tipoareaempresaproduReturnGeneral=new TipoAreaEmpresaProduParameterReturnGeneral();
	
			tipoareaempresaproduReturnGeneral.setTipoAreaEmpresaProdu(tipoareaempresaprodu);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoareaempresaproduReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoAreaEmpresaProduLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoareaempresaprodus,tipoareaempresaprodu,tipoareaempresaproduParameterGeneral,tipoareaempresaproduReturnGeneral,isEsNuevoTipoAreaEmpresaProdu,clases);
			
			this.connexion.commit();
			
			return tipoareaempresaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoAreaEmpresaProduParameterReturnGeneral procesarImportacionTipoAreaEmpresaProdusWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoAreaEmpresaProduParameterReturnGeneral tipoareaempresaproduParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaEmpresaProdu.class.getSimpleName()+"-procesarImportacionTipoAreaEmpresaProdusWithConnection");connexion.begin();			
			
			TipoAreaEmpresaProduParameterReturnGeneral tipoareaempresaproduReturnGeneral=new TipoAreaEmpresaProduParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoareaempresaprodus=new ArrayList<TipoAreaEmpresaProdu>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoareaempresaprodu=new TipoAreaEmpresaProdu();
				
				
				if(conColumnasBase) {this.tipoareaempresaprodu.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoareaempresaprodu.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoareaempresaprodu.setnombre(arrColumnas[iColumn++]);
				this.tipoareaempresaprodu.setdescripcion(arrColumnas[iColumn++]);
				
				this.tipoareaempresaprodus.add(this.tipoareaempresaprodu);
			}
			
			this.saveTipoAreaEmpresaProdus();
			
			this.connexion.commit();
			
			tipoareaempresaproduReturnGeneral.setConRetornoEstaProcesado(true);
			tipoareaempresaproduReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoareaempresaproduReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoAreaEmpresaProdusEliminados() throws Exception {				
		
		List<TipoAreaEmpresaProdu> tipoareaempresaprodusAux= new ArrayList<TipoAreaEmpresaProdu>();
		
		for(TipoAreaEmpresaProdu tipoareaempresaprodu:tipoareaempresaprodus) {
			if(!tipoareaempresaprodu.getIsDeleted()) {
				tipoareaempresaprodusAux.add(tipoareaempresaprodu);
			}
		}
		
		tipoareaempresaprodus=tipoareaempresaprodusAux;
	}
	
	public void quitarTipoAreaEmpresaProdusNulos() throws Exception {				
		
		List<TipoAreaEmpresaProdu> tipoareaempresaprodusAux= new ArrayList<TipoAreaEmpresaProdu>();
		
		for(TipoAreaEmpresaProdu tipoareaempresaprodu : this.tipoareaempresaprodus) {
			if(tipoareaempresaprodu==null) {
				tipoareaempresaprodusAux.add(tipoareaempresaprodu);
			}
		}
		
		//this.tipoareaempresaprodus=tipoareaempresaprodusAux;
		
		this.tipoareaempresaprodus.removeAll(tipoareaempresaprodusAux);
	}
	
	public void getSetVersionRowTipoAreaEmpresaProduWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoareaempresaprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoareaempresaprodu.getIsDeleted() || (tipoareaempresaprodu.getIsChanged()&&!tipoareaempresaprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoareaempresaproduDataAccess.getSetVersionRowTipoAreaEmpresaProdu(connexion,tipoareaempresaprodu.getId());
				
				if(!tipoareaempresaprodu.getVersionRow().equals(timestamp)) {	
					tipoareaempresaprodu.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoareaempresaprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoAreaEmpresaProdu()throws Exception {	
		
		if(tipoareaempresaprodu.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoareaempresaprodu.getIsDeleted() || (tipoareaempresaprodu.getIsChanged()&&!tipoareaempresaprodu.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoareaempresaproduDataAccess.getSetVersionRowTipoAreaEmpresaProdu(connexion,tipoareaempresaprodu.getId());
			
			try {							
				if(!tipoareaempresaprodu.getVersionRow().equals(timestamp)) {	
					tipoareaempresaprodu.setVersionRow(timestamp);
				}
				
				tipoareaempresaprodu.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoAreaEmpresaProdusWithConnection()throws Exception {	
		if(tipoareaempresaprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoAreaEmpresaProdu tipoareaempresaproduAux:tipoareaempresaprodus) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoareaempresaproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoareaempresaproduAux.getIsDeleted() || (tipoareaempresaproduAux.getIsChanged()&&!tipoareaempresaproduAux.getIsNew())) {
						
						timestamp=tipoareaempresaproduDataAccess.getSetVersionRowTipoAreaEmpresaProdu(connexion,tipoareaempresaproduAux.getId());
						
						if(!tipoareaempresaprodu.getVersionRow().equals(timestamp)) {	
							tipoareaempresaproduAux.setVersionRow(timestamp);
						}
								
						tipoareaempresaproduAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoAreaEmpresaProdus()throws Exception {	
		if(tipoareaempresaprodus!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoAreaEmpresaProdu tipoareaempresaproduAux:tipoareaempresaprodus) {
					if(tipoareaempresaproduAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoareaempresaproduAux.getIsDeleted() || (tipoareaempresaproduAux.getIsChanged()&&!tipoareaempresaproduAux.getIsNew())) {
						
						timestamp=tipoareaempresaproduDataAccess.getSetVersionRowTipoAreaEmpresaProdu(connexion,tipoareaempresaproduAux.getId());
						
						if(!tipoareaempresaproduAux.getVersionRow().equals(timestamp)) {	
							tipoareaempresaproduAux.setVersionRow(timestamp);
						}
						
													
						tipoareaempresaproduAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoAreaEmpresaProduParameterReturnGeneral cargarCombosLoteForeignKeyTipoAreaEmpresaProduWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoAreaEmpresaProduParameterReturnGeneral  tipoareaempresaproduReturnGeneral =new TipoAreaEmpresaProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaEmpresaProdu.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoAreaEmpresaProduWithConnection");connexion.begin();
			
			tipoareaempresaproduReturnGeneral =new TipoAreaEmpresaProduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoareaempresaproduReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoareaempresaproduReturnGeneral;
	}
	
	public TipoAreaEmpresaProduParameterReturnGeneral cargarCombosLoteForeignKeyTipoAreaEmpresaProdu(String finalQueryGlobalEmpresa) throws Exception {
		TipoAreaEmpresaProduParameterReturnGeneral  tipoareaempresaproduReturnGeneral =new TipoAreaEmpresaProduParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoareaempresaproduReturnGeneral =new TipoAreaEmpresaProduParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoareaempresaproduReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoareaempresaproduReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoAreaEmpresaProduWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic=new ProductoOrdenDetaProduMaquinaLogic();
			ProductoProduMaquinaLogic productoprodumaquinaLogic=new ProductoProduMaquinaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaEmpresaProdu.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoAreaEmpresaProduWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ProductoOrdenDetaProduMaquina.class));
			classes.add(new Classe(ProductoProduMaquina.class));
											
			

			productoordendetaprodumaquinaLogic.setConnexion(this.getConnexion());
			productoordendetaprodumaquinaLogic.setDatosCliente(this.datosCliente);
			productoordendetaprodumaquinaLogic.setIsConRefrescarForeignKeys(true);

			productoprodumaquinaLogic.setConnexion(this.getConnexion());
			productoprodumaquinaLogic.setDatosCliente(this.datosCliente);
			productoprodumaquinaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoAreaEmpresaProdu tipoareaempresaprodu:this.tipoareaempresaprodus) {
				

				classes=new ArrayList<Classe>();
				classes=ProductoOrdenDetaProduMaquinaConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProduMaquina(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoordendetaprodumaquinaLogic.setProductoOrdenDetaProduMaquinas(tipoareaempresaprodu.productoordendetaprodumaquinas);
				productoordendetaprodumaquinaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProductoProduMaquinaConstantesFunciones.getClassesForeignKeysOfProductoProduMaquina(new ArrayList<Classe>(),DeepLoadType.NONE);

				productoprodumaquinaLogic.setProductoProduMaquinas(tipoareaempresaprodu.productoprodumaquinas);
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
	
	public void deepLoad(TipoAreaEmpresaProdu tipoareaempresaprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoAreaEmpresaProduLogicAdditional.updateTipoAreaEmpresaProduToGet(tipoareaempresaprodu,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoareaempresaprodu.setEmpresa(tipoareaempresaproduDataAccess.getEmpresa(connexion,tipoareaempresaprodu));
		tipoareaempresaprodu.setProductoOrdenDetaProduMaquinas(tipoareaempresaproduDataAccess.getProductoOrdenDetaProduMaquinas(connexion,tipoareaempresaprodu));
		tipoareaempresaprodu.setProductoProduMaquinas(tipoareaempresaproduDataAccess.getProductoProduMaquinas(connexion,tipoareaempresaprodu));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoareaempresaprodu.setEmpresa(tipoareaempresaproduDataAccess.getEmpresa(connexion,tipoareaempresaprodu));
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoareaempresaprodu.setProductoOrdenDetaProduMaquinas(tipoareaempresaproduDataAccess.getProductoOrdenDetaProduMaquinas(connexion,tipoareaempresaprodu));

				if(this.isConDeep) {
					ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(this.connexion);
					productoordendetaprodumaquinaLogic.setProductoOrdenDetaProduMaquinas(tipoareaempresaprodu.getProductoOrdenDetaProduMaquinas());
					ArrayList<Classe> classesLocal=ProductoOrdenDetaProduMaquinaConstantesFunciones.getClassesForeignKeysOfProductoOrdenDetaProduMaquina(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoordendetaprodumaquinaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoOrdenDetaProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoOrdenDetaProduMaquina(productoordendetaprodumaquinaLogic.getProductoOrdenDetaProduMaquinas());
					tipoareaempresaprodu.setProductoOrdenDetaProduMaquinas(productoordendetaprodumaquinaLogic.getProductoOrdenDetaProduMaquinas());
				}

				continue;
			}

			if(clas.clas.equals(ProductoProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoareaempresaprodu.setProductoProduMaquinas(tipoareaempresaproduDataAccess.getProductoProduMaquinas(connexion,tipoareaempresaprodu));

				if(this.isConDeep) {
					ProductoProduMaquinaLogic productoprodumaquinaLogic= new ProductoProduMaquinaLogic(this.connexion);
					productoprodumaquinaLogic.setProductoProduMaquinas(tipoareaempresaprodu.getProductoProduMaquinas());
					ArrayList<Classe> classesLocal=ProductoProduMaquinaConstantesFunciones.getClassesForeignKeysOfProductoProduMaquina(new ArrayList<Classe>(),DeepLoadType.NONE);
					productoprodumaquinaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProductoProduMaquinaConstantesFunciones.refrescarForeignKeysDescripcionesProductoProduMaquina(productoprodumaquinaLogic.getProductoProduMaquinas());
					tipoareaempresaprodu.setProductoProduMaquinas(productoprodumaquinaLogic.getProductoProduMaquinas());
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
			tipoareaempresaprodu.setEmpresa(tipoareaempresaproduDataAccess.getEmpresa(connexion,tipoareaempresaprodu));
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
			tipoareaempresaprodu.setProductoOrdenDetaProduMaquinas(tipoareaempresaproduDataAccess.getProductoOrdenDetaProduMaquinas(connexion,tipoareaempresaprodu));
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
			tipoareaempresaprodu.setProductoProduMaquinas(tipoareaempresaproduDataAccess.getProductoProduMaquinas(connexion,tipoareaempresaprodu));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoareaempresaprodu.setEmpresa(tipoareaempresaproduDataAccess.getEmpresa(connexion,tipoareaempresaprodu));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoareaempresaprodu.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipoareaempresaprodu.setProductoOrdenDetaProduMaquinas(tipoareaempresaproduDataAccess.getProductoOrdenDetaProduMaquinas(connexion,tipoareaempresaprodu));

		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:tipoareaempresaprodu.getProductoOrdenDetaProduMaquinas()) {
			ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(connexion);
			productoordendetaprodumaquinaLogic.deepLoad(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
		}

		tipoareaempresaprodu.setProductoProduMaquinas(tipoareaempresaproduDataAccess.getProductoProduMaquinas(connexion,tipoareaempresaprodu));

		for(ProductoProduMaquina productoprodumaquina:tipoareaempresaprodu.getProductoProduMaquinas()) {
			ProductoProduMaquinaLogic productoprodumaquinaLogic= new ProductoProduMaquinaLogic(connexion);
			productoprodumaquinaLogic.deepLoad(productoprodumaquina,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoareaempresaprodu.setEmpresa(tipoareaempresaproduDataAccess.getEmpresa(connexion,tipoareaempresaprodu));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoareaempresaprodu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoareaempresaprodu.setProductoOrdenDetaProduMaquinas(tipoareaempresaproduDataAccess.getProductoOrdenDetaProduMaquinas(connexion,tipoareaempresaprodu));

				for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:tipoareaempresaprodu.getProductoOrdenDetaProduMaquinas()) {
					ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(connexion);
					productoordendetaprodumaquinaLogic.deepLoad(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoareaempresaprodu.setProductoProduMaquinas(tipoareaempresaproduDataAccess.getProductoProduMaquinas(connexion,tipoareaempresaprodu));

				for(ProductoProduMaquina productoprodumaquina:tipoareaempresaprodu.getProductoProduMaquinas()) {
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
			tipoareaempresaprodu.setEmpresa(tipoareaempresaproduDataAccess.getEmpresa(connexion,tipoareaempresaprodu));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoareaempresaprodu.getEmpresa(),isDeep,deepLoadType,clases);
				
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
			tipoareaempresaprodu.setProductoOrdenDetaProduMaquinas(tipoareaempresaproduDataAccess.getProductoOrdenDetaProduMaquinas(connexion,tipoareaempresaprodu));

			for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:tipoareaempresaprodu.getProductoOrdenDetaProduMaquinas()) {
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
			tipoareaempresaprodu.setProductoProduMaquinas(tipoareaempresaproduDataAccess.getProductoProduMaquinas(connexion,tipoareaempresaprodu));

			for(ProductoProduMaquina productoprodumaquina:tipoareaempresaprodu.getProductoProduMaquinas()) {
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
	
	public void deepSave(TipoAreaEmpresaProdu tipoareaempresaprodu,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoAreaEmpresaProduLogicAdditional.updateTipoAreaEmpresaProduToSave(tipoareaempresaprodu,this.arrDatoGeneral);
			
TipoAreaEmpresaProduDataAccess.save(tipoareaempresaprodu, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoareaempresaprodu.getEmpresa(),connexion);

		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:tipoareaempresaprodu.getProductoOrdenDetaProduMaquinas()) {
			productoordendetaprodumaquina.setid_tipo_area_empresa_produ(tipoareaempresaprodu.getId());
			ProductoOrdenDetaProduMaquinaDataAccess.save(productoordendetaprodumaquina,connexion);
		}

		for(ProductoProduMaquina productoprodumaquina:tipoareaempresaprodu.getProductoProduMaquinas()) {
			productoprodumaquina.setid_tipo_area_empresa_produ(tipoareaempresaprodu.getId());
			ProductoProduMaquinaDataAccess.save(productoprodumaquina,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoareaempresaprodu.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:tipoareaempresaprodu.getProductoOrdenDetaProduMaquinas()) {
					productoordendetaprodumaquina.setid_tipo_area_empresa_produ(tipoareaempresaprodu.getId());
					ProductoOrdenDetaProduMaquinaDataAccess.save(productoordendetaprodumaquina,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProductoProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoProduMaquina productoprodumaquina:tipoareaempresaprodu.getProductoProduMaquinas()) {
					productoprodumaquina.setid_tipo_area_empresa_produ(tipoareaempresaprodu.getId());
					ProductoProduMaquinaDataAccess.save(productoprodumaquina,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoareaempresaprodu.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoareaempresaprodu.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:tipoareaempresaprodu.getProductoOrdenDetaProduMaquinas()) {
			ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(connexion);
			productoordendetaprodumaquina.setid_tipo_area_empresa_produ(tipoareaempresaprodu.getId());
			ProductoOrdenDetaProduMaquinaDataAccess.save(productoordendetaprodumaquina,connexion);
			productoordendetaprodumaquinaLogic.deepSave(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
		}

		for(ProductoProduMaquina productoprodumaquina:tipoareaempresaprodu.getProductoProduMaquinas()) {
			ProductoProduMaquinaLogic productoprodumaquinaLogic= new ProductoProduMaquinaLogic(connexion);
			productoprodumaquina.setid_tipo_area_empresa_produ(tipoareaempresaprodu.getId());
			ProductoProduMaquinaDataAccess.save(productoprodumaquina,connexion);
			productoprodumaquinaLogic.deepSave(productoprodumaquina,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoareaempresaprodu.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipoareaempresaprodu.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(ProductoOrdenDetaProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina:tipoareaempresaprodu.getProductoOrdenDetaProduMaquinas()) {
					ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic= new ProductoOrdenDetaProduMaquinaLogic(connexion);
					productoordendetaprodumaquina.setid_tipo_area_empresa_produ(tipoareaempresaprodu.getId());
					ProductoOrdenDetaProduMaquinaDataAccess.save(productoordendetaprodumaquina,connexion);
					productoordendetaprodumaquinaLogic.deepSave(productoordendetaprodumaquina,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProductoProduMaquina.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProductoProduMaquina productoprodumaquina:tipoareaempresaprodu.getProductoProduMaquinas()) {
					ProductoProduMaquinaLogic productoprodumaquinaLogic= new ProductoProduMaquinaLogic(connexion);
					productoprodumaquina.setid_tipo_area_empresa_produ(tipoareaempresaprodu.getId());
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
			this.getNewConnexionToDeep(TipoAreaEmpresaProdu.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoareaempresaprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoAreaEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(tipoareaempresaprodu);
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
			this.deepLoad(this.tipoareaempresaprodu,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoAreaEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(this.tipoareaempresaprodu);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoAreaEmpresaProdu.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoareaempresaprodus!=null) {
				for(TipoAreaEmpresaProdu tipoareaempresaprodu:tipoareaempresaprodus) {
					this.deepLoad(tipoareaempresaprodu,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoAreaEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(tipoareaempresaprodus);
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
			if(tipoareaempresaprodus!=null) {
				for(TipoAreaEmpresaProdu tipoareaempresaprodu:tipoareaempresaprodus) {
					this.deepLoad(tipoareaempresaprodu,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoAreaEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(tipoareaempresaprodus);
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
			this.getNewConnexionToDeep(TipoAreaEmpresaProdu.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoareaempresaprodu,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoAreaEmpresaProdu.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoareaempresaprodus!=null) {
				for(TipoAreaEmpresaProdu tipoareaempresaprodu:tipoareaempresaprodus) {
					this.deepSave(tipoareaempresaprodu,isDeep,deepLoadType,clases);
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
			if(tipoareaempresaprodus!=null) {
				for(TipoAreaEmpresaProdu tipoareaempresaprodu:tipoareaempresaprodus) {
					this.deepSave(tipoareaempresaprodu,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoAreaEmpresaProdusFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoAreaEmpresaProdu.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoAreaEmpresaProduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoAreaEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoareaempresaprodus=tipoareaempresaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoAreaEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(this.tipoareaempresaprodus);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoAreaEmpresaProdusFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoAreaEmpresaProduConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoAreaEmpresaProduLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoareaempresaprodus=tipoareaempresaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoAreaEmpresaProduConstantesFunciones.refrescarForeignKeysDescripcionesTipoAreaEmpresaProdu(this.tipoareaempresaprodus);
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
			if(TipoAreaEmpresaProduConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoAreaEmpresaProduDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoAreaEmpresaProdu tipoareaempresaprodu,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoAreaEmpresaProduConstantesFunciones.ISCONAUDITORIA) {
				if(tipoareaempresaprodu.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoAreaEmpresaProduDataAccess.TABLENAME, tipoareaempresaprodu.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoAreaEmpresaProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoAreaEmpresaProduLogic.registrarAuditoriaDetallesTipoAreaEmpresaProdu(connexion,tipoareaempresaprodu,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoareaempresaprodu.getIsDeleted()) {
					/*if(!tipoareaempresaprodu.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoAreaEmpresaProduDataAccess.TABLENAME, tipoareaempresaprodu.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoAreaEmpresaProduLogic.registrarAuditoriaDetallesTipoAreaEmpresaProdu(connexion,tipoareaempresaprodu,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoAreaEmpresaProduDataAccess.TABLENAME, tipoareaempresaprodu.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoareaempresaprodu.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoAreaEmpresaProduDataAccess.TABLENAME, tipoareaempresaprodu.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoAreaEmpresaProduConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoAreaEmpresaProduLogic.registrarAuditoriaDetallesTipoAreaEmpresaProdu(connexion,tipoareaempresaprodu,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoAreaEmpresaProdu(Connexion connexion,TipoAreaEmpresaProdu tipoareaempresaprodu)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoareaempresaprodu.getIsNew()||!tipoareaempresaprodu.getid_empresa().equals(tipoareaempresaprodu.getTipoAreaEmpresaProduOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoareaempresaprodu.getTipoAreaEmpresaProduOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoareaempresaprodu.getTipoAreaEmpresaProduOriginal().getid_empresa().toString();
				}
				if(tipoareaempresaprodu.getid_empresa()!=null)
				{
					strValorNuevo=tipoareaempresaprodu.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoAreaEmpresaProduConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoareaempresaprodu.getIsNew()||!tipoareaempresaprodu.getnombre().equals(tipoareaempresaprodu.getTipoAreaEmpresaProduOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoareaempresaprodu.getTipoAreaEmpresaProduOriginal().getnombre()!=null)
				{
					strValorActual=tipoareaempresaprodu.getTipoAreaEmpresaProduOriginal().getnombre();
				}
				if(tipoareaempresaprodu.getnombre()!=null)
				{
					strValorNuevo=tipoareaempresaprodu.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoAreaEmpresaProduConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipoareaempresaprodu.getIsNew()||!tipoareaempresaprodu.getdescripcion().equals(tipoareaempresaprodu.getTipoAreaEmpresaProduOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoareaempresaprodu.getTipoAreaEmpresaProduOriginal().getdescripcion()!=null)
				{
					strValorActual=tipoareaempresaprodu.getTipoAreaEmpresaProduOriginal().getdescripcion();
				}
				if(tipoareaempresaprodu.getdescripcion()!=null)
				{
					strValorNuevo=tipoareaempresaprodu.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoAreaEmpresaProduConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoAreaEmpresaProduRelacionesWithConnection(TipoAreaEmpresaProdu tipoareaempresaprodu,List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,List<ProductoProduMaquina> productoprodumaquinas) throws Exception {

		if(!tipoareaempresaprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoAreaEmpresaProduRelacionesBase(tipoareaempresaprodu,productoordendetaprodumaquinas,productoprodumaquinas,true);
		}
	}

	public void saveTipoAreaEmpresaProduRelaciones(TipoAreaEmpresaProdu tipoareaempresaprodu,List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,List<ProductoProduMaquina> productoprodumaquinas)throws Exception {

		if(!tipoareaempresaprodu.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoAreaEmpresaProduRelacionesBase(tipoareaempresaprodu,productoordendetaprodumaquinas,productoprodumaquinas,false);
		}
	}

	public void saveTipoAreaEmpresaProduRelacionesBase(TipoAreaEmpresaProdu tipoareaempresaprodu,List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,List<ProductoProduMaquina> productoprodumaquinas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoAreaEmpresaProdu-saveRelacionesWithConnection");}
	
			tipoareaempresaprodu.setProductoOrdenDetaProduMaquinas(productoordendetaprodumaquinas);
			tipoareaempresaprodu.setProductoProduMaquinas(productoprodumaquinas);

			this.setTipoAreaEmpresaProdu(tipoareaempresaprodu);

			if(TipoAreaEmpresaProduLogicAdditional.validarSaveRelaciones(tipoareaempresaprodu,this)) {

				TipoAreaEmpresaProduLogicAdditional.updateRelacionesToSave(tipoareaempresaprodu,this);

				if((tipoareaempresaprodu.getIsNew()||tipoareaempresaprodu.getIsChanged())&&!tipoareaempresaprodu.getIsDeleted()) {
					this.saveTipoAreaEmpresaProdu();
					this.saveTipoAreaEmpresaProduRelacionesDetalles(productoordendetaprodumaquinas,productoprodumaquinas);

				} else if(tipoareaempresaprodu.getIsDeleted()) {
					this.saveTipoAreaEmpresaProduRelacionesDetalles(productoordendetaprodumaquinas,productoprodumaquinas);
					this.saveTipoAreaEmpresaProdu();
				}

				TipoAreaEmpresaProduLogicAdditional.updateRelacionesToSaveAfter(tipoareaempresaprodu,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ProductoOrdenDetaProduMaquinaConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoOrdenDetaProduMaquinas(productoordendetaprodumaquinas,true,true);
			ProductoProduMaquinaConstantesFunciones.InicializarGeneralEntityAuxiliaresProductoProduMaquinas(productoprodumaquinas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoAreaEmpresaProduRelacionesDetalles(List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas,List<ProductoProduMaquina> productoprodumaquinas)throws Exception {
		try {
	

			Long idTipoAreaEmpresaProduActual=this.getTipoAreaEmpresaProdu().getId();

			ProductoOrdenDetaProduMaquinaLogic productoordendetaprodumaquinaLogic_Desde_TipoAreaEmpresaProdu=new ProductoOrdenDetaProduMaquinaLogic();
			productoordendetaprodumaquinaLogic_Desde_TipoAreaEmpresaProdu.setProductoOrdenDetaProduMaquinas(productoordendetaprodumaquinas);

			productoordendetaprodumaquinaLogic_Desde_TipoAreaEmpresaProdu.setConnexion(this.getConnexion());
			productoordendetaprodumaquinaLogic_Desde_TipoAreaEmpresaProdu.setDatosCliente(this.datosCliente);

			for(ProductoOrdenDetaProduMaquina productoordendetaprodumaquina_Desde_TipoAreaEmpresaProdu:productoordendetaprodumaquinaLogic_Desde_TipoAreaEmpresaProdu.getProductoOrdenDetaProduMaquinas()) {
				productoordendetaprodumaquina_Desde_TipoAreaEmpresaProdu.setid_tipo_area_empresa_produ(idTipoAreaEmpresaProduActual);
			}

			productoordendetaprodumaquinaLogic_Desde_TipoAreaEmpresaProdu.saveProductoOrdenDetaProduMaquinas();

			ProductoProduMaquinaLogic productoprodumaquinaLogic_Desde_TipoAreaEmpresaProdu=new ProductoProduMaquinaLogic();
			productoprodumaquinaLogic_Desde_TipoAreaEmpresaProdu.setProductoProduMaquinas(productoprodumaquinas);

			productoprodumaquinaLogic_Desde_TipoAreaEmpresaProdu.setConnexion(this.getConnexion());
			productoprodumaquinaLogic_Desde_TipoAreaEmpresaProdu.setDatosCliente(this.datosCliente);

			for(ProductoProduMaquina productoprodumaquina_Desde_TipoAreaEmpresaProdu:productoprodumaquinaLogic_Desde_TipoAreaEmpresaProdu.getProductoProduMaquinas()) {
				productoprodumaquina_Desde_TipoAreaEmpresaProdu.setid_tipo_area_empresa_produ(idTipoAreaEmpresaProduActual);
			}

			productoprodumaquinaLogic_Desde_TipoAreaEmpresaProdu.saveProductoProduMaquinas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoAreaEmpresaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoAreaEmpresaProduConstantesFunciones.getClassesForeignKeysOfTipoAreaEmpresaProdu(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoAreaEmpresaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoAreaEmpresaProduConstantesFunciones.getClassesRelationshipsOfTipoAreaEmpresaProdu(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

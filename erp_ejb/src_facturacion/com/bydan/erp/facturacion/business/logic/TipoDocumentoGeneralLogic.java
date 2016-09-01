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
package com.bydan.erp.facturacion.business.logic;

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
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.facturacion.util.TipoDocumentoGeneralConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoDocumentoGeneralParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoDocumentoGeneralParameterGeneral;
import com.bydan.erp.facturacion.business.entity.TipoDocumentoGeneral;
import com.bydan.erp.facturacion.business.logic.TipoDocumentoGeneralLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoDocumentoGeneralLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoDocumentoGeneralLogic.class);
	
	protected TipoDocumentoGeneralDataAccess tipodocumentogeneralDataAccess; 	
	protected TipoDocumentoGeneral tipodocumentogeneral;
	protected List<TipoDocumentoGeneral> tipodocumentogenerals;
	protected Object tipodocumentogeneralObject;	
	protected List<Object> tipodocumentogeneralsObject;
	
	public static ClassValidator<TipoDocumentoGeneral> tipodocumentogeneralValidator = new ClassValidator<TipoDocumentoGeneral>(TipoDocumentoGeneral.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoDocumentoGeneralLogicAdditional tipodocumentogeneralLogicAdditional=null;
	
	public TipoDocumentoGeneralLogicAdditional getTipoDocumentoGeneralLogicAdditional() {
		return this.tipodocumentogeneralLogicAdditional;
	}
	
	public void setTipoDocumentoGeneralLogicAdditional(TipoDocumentoGeneralLogicAdditional tipodocumentogeneralLogicAdditional) {
		try {
			this.tipodocumentogeneralLogicAdditional=tipodocumentogeneralLogicAdditional;
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
	
	
	
	
	public  TipoDocumentoGeneralLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipodocumentogeneralDataAccess = new TipoDocumentoGeneralDataAccess();
			
			this.tipodocumentogenerals= new ArrayList<TipoDocumentoGeneral>();
			this.tipodocumentogeneral= new TipoDocumentoGeneral();
			
			this.tipodocumentogeneralObject=new Object();
			this.tipodocumentogeneralsObject=new ArrayList<Object>();
				
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
			
			this.tipodocumentogeneralDataAccess.setConnexionType(this.connexionType);
			this.tipodocumentogeneralDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoDocumentoGeneralLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipodocumentogeneralDataAccess = new TipoDocumentoGeneralDataAccess();
			this.tipodocumentogenerals= new ArrayList<TipoDocumentoGeneral>();
			this.tipodocumentogeneral= new TipoDocumentoGeneral();
			this.tipodocumentogeneralObject=new Object();
			this.tipodocumentogeneralsObject=new ArrayList<Object>();
			
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
			
			this.tipodocumentogeneralDataAccess.setConnexionType(this.connexionType);
			this.tipodocumentogeneralDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoDocumentoGeneral getTipoDocumentoGeneral() throws Exception {	
		TipoDocumentoGeneralLogicAdditional.checkTipoDocumentoGeneralToGet(tipodocumentogeneral,this.datosCliente,this.arrDatoGeneral);
		TipoDocumentoGeneralLogicAdditional.updateTipoDocumentoGeneralToGet(tipodocumentogeneral,this.arrDatoGeneral);
		
		return tipodocumentogeneral;
	}
		
	public void setTipoDocumentoGeneral(TipoDocumentoGeneral newTipoDocumentoGeneral) {
		this.tipodocumentogeneral = newTipoDocumentoGeneral;
	}
	
	public TipoDocumentoGeneralDataAccess getTipoDocumentoGeneralDataAccess() {
		return tipodocumentogeneralDataAccess;
	}
	
	public void setTipoDocumentoGeneralDataAccess(TipoDocumentoGeneralDataAccess newtipodocumentogeneralDataAccess) {
		this.tipodocumentogeneralDataAccess = newtipodocumentogeneralDataAccess;
	}
	
	public List<TipoDocumentoGeneral> getTipoDocumentoGenerals() throws Exception {		
		this.quitarTipoDocumentoGeneralsNulos();
		
		TipoDocumentoGeneralLogicAdditional.checkTipoDocumentoGeneralToGets(tipodocumentogenerals,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoDocumentoGeneral tipodocumentogeneralLocal: tipodocumentogenerals ) {
			TipoDocumentoGeneralLogicAdditional.updateTipoDocumentoGeneralToGet(tipodocumentogeneralLocal,this.arrDatoGeneral);
		}
		
		return tipodocumentogenerals;
	}
	
	public void setTipoDocumentoGenerals(List<TipoDocumentoGeneral> newTipoDocumentoGenerals) {
		this.tipodocumentogenerals = newTipoDocumentoGenerals;
	}
	
	public Object getTipoDocumentoGeneralObject() {	
		this.tipodocumentogeneralObject=this.tipodocumentogeneralDataAccess.getEntityObject();
		return this.tipodocumentogeneralObject;
	}
		
	public void setTipoDocumentoGeneralObject(Object newTipoDocumentoGeneralObject) {
		this.tipodocumentogeneralObject = newTipoDocumentoGeneralObject;
	}
	
	public List<Object> getTipoDocumentoGeneralsObject() {		
		this.tipodocumentogeneralsObject=this.tipodocumentogeneralDataAccess.getEntitiesObject();
		return this.tipodocumentogeneralsObject;
	}
		
	public void setTipoDocumentoGeneralsObject(List<Object> newTipoDocumentoGeneralsObject) {
		this.tipodocumentogeneralsObject = newTipoDocumentoGeneralsObject;
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
		
		if(this.tipodocumentogeneralDataAccess!=null) {
			this.tipodocumentogeneralDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoGeneral.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipodocumentogeneralDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipodocumentogeneralDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipodocumentogeneral = new  TipoDocumentoGeneral();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoGeneral.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipodocumentogeneral=tipodocumentogeneralDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodocumentogeneral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogeneral);
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
		tipodocumentogeneral = new  TipoDocumentoGeneral();
		  		  
        try {
			
			tipodocumentogeneral=tipodocumentogeneralDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodocumentogeneral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogeneral);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipodocumentogeneral = new  TipoDocumentoGeneral();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoGeneral.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipodocumentogeneral=tipodocumentogeneralDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodocumentogeneral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogeneral);
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
		tipodocumentogeneral = new  TipoDocumentoGeneral();
		  		  
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
		tipodocumentogeneral = new  TipoDocumentoGeneral();
		  		  
        try {
			
			tipodocumentogeneral=tipodocumentogeneralDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodocumentogeneral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogeneral);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipodocumentogeneral = new  TipoDocumentoGeneral();
		  		  
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
		tipodocumentogeneral = new  TipoDocumentoGeneral();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoGeneral.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipodocumentogeneralDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodocumentogeneral = new  TipoDocumentoGeneral();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipodocumentogeneralDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipodocumentogeneral = new  TipoDocumentoGeneral();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoGeneral.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipodocumentogeneralDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodocumentogeneral = new  TipoDocumentoGeneral();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipodocumentogeneralDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipodocumentogeneral = new  TipoDocumentoGeneral();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoGeneral.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipodocumentogeneralDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodocumentogeneral = new  TipoDocumentoGeneral();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipodocumentogeneralDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipodocumentogenerals = new  ArrayList<TipoDocumentoGeneral>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoGeneral.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoDocumentoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentogenerals=tipodocumentogeneralDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDocumentoGeneral(tipodocumentogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogenerals);
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
		tipodocumentogenerals = new  ArrayList<TipoDocumentoGeneral>();
		  		  
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
		tipodocumentogenerals = new  ArrayList<TipoDocumentoGeneral>();
		  		  
        try {			
			TipoDocumentoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentogenerals=tipodocumentogeneralDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoDocumentoGeneral(tipodocumentogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogenerals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipodocumentogenerals = new  ArrayList<TipoDocumentoGeneral>();
		  		  
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
		tipodocumentogenerals = new  ArrayList<TipoDocumentoGeneral>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoGeneral.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoDocumentoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentogenerals=tipodocumentogeneralDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDocumentoGeneral(tipodocumentogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogenerals);
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
		tipodocumentogenerals = new  ArrayList<TipoDocumentoGeneral>();
		  		  
        try {
			TipoDocumentoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentogenerals=tipodocumentogeneralDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDocumentoGeneral(tipodocumentogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogenerals);
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
		tipodocumentogenerals = new  ArrayList<TipoDocumentoGeneral>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoGeneral.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDocumentoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentogenerals=tipodocumentogeneralDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDocumentoGeneral(tipodocumentogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogenerals);
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
		tipodocumentogenerals = new  ArrayList<TipoDocumentoGeneral>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDocumentoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentogenerals=tipodocumentogeneralDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDocumentoGeneral(tipodocumentogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogenerals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipodocumentogeneral = new  TipoDocumentoGeneral();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoGeneral.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDocumentoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentogeneral=tipodocumentogeneralDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDocumentoGeneral(tipodocumentogeneral);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogeneral);
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
		tipodocumentogeneral = new  TipoDocumentoGeneral();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDocumentoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentogeneral=tipodocumentogeneralDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDocumentoGeneral(tipodocumentogeneral);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogeneral);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipodocumentogenerals = new  ArrayList<TipoDocumentoGeneral>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoGeneral.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoDocumentoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentogenerals=tipodocumentogeneralDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDocumentoGeneral(tipodocumentogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogenerals);
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
		tipodocumentogenerals = new  ArrayList<TipoDocumentoGeneral>();
		  		  
        try {
			TipoDocumentoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentogenerals=tipodocumentogeneralDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDocumentoGeneral(tipodocumentogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogenerals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoDocumentoGeneralsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipodocumentogenerals = new  ArrayList<TipoDocumentoGeneral>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoGeneral.class.getSimpleName()+"-getTodosTipoDocumentoGeneralsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDocumentoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentogenerals=tipodocumentogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoDocumentoGeneral(tipodocumentogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogenerals);
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
	
	public  void  getTodosTipoDocumentoGenerals(String sFinalQuery,Pagination pagination)throws Exception {
		tipodocumentogenerals = new  ArrayList<TipoDocumentoGeneral>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDocumentoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentogenerals=tipodocumentogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoDocumentoGeneral(tipodocumentogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogenerals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoDocumentoGeneral(TipoDocumentoGeneral tipodocumentogeneral) throws Exception {
		Boolean estaValidado=false;
		
		if(tipodocumentogeneral.getIsNew() || tipodocumentogeneral.getIsChanged()) { 
			this.invalidValues = tipodocumentogeneralValidator.getInvalidValues(tipodocumentogeneral);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipodocumentogeneral);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoDocumentoGeneral(List<TipoDocumentoGeneral> TipoDocumentoGenerals) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoDocumentoGeneral tipodocumentogeneralLocal:tipodocumentogenerals) {				
			estaValidadoObjeto=this.validarGuardarTipoDocumentoGeneral(tipodocumentogeneralLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoDocumentoGeneral(List<TipoDocumentoGeneral> TipoDocumentoGenerals) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoDocumentoGeneral(tipodocumentogenerals)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoDocumentoGeneral(TipoDocumentoGeneral TipoDocumentoGeneral) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoDocumentoGeneral(tipodocumentogeneral)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoDocumentoGeneral tipodocumentogeneral) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipodocumentogeneral.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoDocumentoGeneralConstantesFunciones.getTipoDocumentoGeneralLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipodocumentogeneral","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoDocumentoGeneralConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoDocumentoGeneralConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoDocumentoGeneralWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoGeneral.class.getSimpleName()+"-saveTipoDocumentoGeneralWithConnection");connexion.begin();			
			
			TipoDocumentoGeneralLogicAdditional.checkTipoDocumentoGeneralToSave(this.tipodocumentogeneral,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoDocumentoGeneralLogicAdditional.updateTipoDocumentoGeneralToSave(this.tipodocumentogeneral,this.arrDatoGeneral);
			
			TipoDocumentoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipodocumentogeneral,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoDocumentoGeneral();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoDocumentoGeneral(this.tipodocumentogeneral)) {
				TipoDocumentoGeneralDataAccess.save(this.tipodocumentogeneral, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipodocumentogeneral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoDocumentoGeneralLogicAdditional.checkTipoDocumentoGeneralToSaveAfter(this.tipodocumentogeneral,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoDocumentoGeneral();
			
			connexion.commit();			
			
			if(this.tipodocumentogeneral.getIsDeleted()) {
				this.tipodocumentogeneral=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoDocumentoGeneral()throws Exception {	
		try {	
			
			TipoDocumentoGeneralLogicAdditional.checkTipoDocumentoGeneralToSave(this.tipodocumentogeneral,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoDocumentoGeneralLogicAdditional.updateTipoDocumentoGeneralToSave(this.tipodocumentogeneral,this.arrDatoGeneral);
			
			TipoDocumentoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipodocumentogeneral,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoDocumentoGeneral(this.tipodocumentogeneral)) {			
				TipoDocumentoGeneralDataAccess.save(this.tipodocumentogeneral, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipodocumentogeneral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoDocumentoGeneralLogicAdditional.checkTipoDocumentoGeneralToSaveAfter(this.tipodocumentogeneral,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipodocumentogeneral.getIsDeleted()) {
				this.tipodocumentogeneral=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoDocumentoGeneralsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoGeneral.class.getSimpleName()+"-saveTipoDocumentoGeneralsWithConnection");connexion.begin();			
			
			TipoDocumentoGeneralLogicAdditional.checkTipoDocumentoGeneralToSaves(tipodocumentogenerals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoDocumentoGenerals();
			
			Boolean validadoTodosTipoDocumentoGeneral=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoDocumentoGeneral tipodocumentogeneralLocal:tipodocumentogenerals) {		
				if(tipodocumentogeneralLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoDocumentoGeneralLogicAdditional.updateTipoDocumentoGeneralToSave(tipodocumentogeneralLocal,this.arrDatoGeneral);
	        	
				TipoDocumentoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipodocumentogeneralLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoDocumentoGeneral(tipodocumentogeneralLocal)) {
					TipoDocumentoGeneralDataAccess.save(tipodocumentogeneralLocal, connexion);				
				} else {
					validadoTodosTipoDocumentoGeneral=false;
				}
			}
			
			if(!validadoTodosTipoDocumentoGeneral) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoDocumentoGeneralLogicAdditional.checkTipoDocumentoGeneralToSavesAfter(tipodocumentogenerals,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoDocumentoGenerals();
			
			connexion.commit();		
			
			this.quitarTipoDocumentoGeneralsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoDocumentoGenerals()throws Exception {				
		 try {	
			TipoDocumentoGeneralLogicAdditional.checkTipoDocumentoGeneralToSaves(tipodocumentogenerals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoDocumentoGeneral=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoDocumentoGeneral tipodocumentogeneralLocal:tipodocumentogenerals) {				
				if(tipodocumentogeneralLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoDocumentoGeneralLogicAdditional.updateTipoDocumentoGeneralToSave(tipodocumentogeneralLocal,this.arrDatoGeneral);
	        	
				TipoDocumentoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipodocumentogeneralLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoDocumentoGeneral(tipodocumentogeneralLocal)) {				
					TipoDocumentoGeneralDataAccess.save(tipodocumentogeneralLocal, connexion);				
				} else {
					validadoTodosTipoDocumentoGeneral=false;
				}
			}
			
			if(!validadoTodosTipoDocumentoGeneral) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoDocumentoGeneralLogicAdditional.checkTipoDocumentoGeneralToSavesAfter(tipodocumentogenerals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoDocumentoGeneralsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoDocumentoGeneralParameterReturnGeneral procesarAccionTipoDocumentoGenerals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoDocumentoGeneral> tipodocumentogenerals,TipoDocumentoGeneralParameterReturnGeneral tipodocumentogeneralParameterGeneral)throws Exception {
		 try {	
			TipoDocumentoGeneralParameterReturnGeneral tipodocumentogeneralReturnGeneral=new TipoDocumentoGeneralParameterReturnGeneral();
	
			TipoDocumentoGeneralLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipodocumentogenerals,tipodocumentogeneralParameterGeneral,tipodocumentogeneralReturnGeneral);
			
			return tipodocumentogeneralReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoDocumentoGeneralParameterReturnGeneral procesarAccionTipoDocumentoGeneralsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoDocumentoGeneral> tipodocumentogenerals,TipoDocumentoGeneralParameterReturnGeneral tipodocumentogeneralParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoGeneral.class.getSimpleName()+"-procesarAccionTipoDocumentoGeneralsWithConnection");connexion.begin();			
			
			TipoDocumentoGeneralParameterReturnGeneral tipodocumentogeneralReturnGeneral=new TipoDocumentoGeneralParameterReturnGeneral();
	
			TipoDocumentoGeneralLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipodocumentogenerals,tipodocumentogeneralParameterGeneral,tipodocumentogeneralReturnGeneral);
			
			this.connexion.commit();
			
			return tipodocumentogeneralReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoDocumentoGeneralParameterReturnGeneral procesarEventosTipoDocumentoGenerals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoDocumentoGeneral> tipodocumentogenerals,TipoDocumentoGeneral tipodocumentogeneral,TipoDocumentoGeneralParameterReturnGeneral tipodocumentogeneralParameterGeneral,Boolean isEsNuevoTipoDocumentoGeneral,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoDocumentoGeneralParameterReturnGeneral tipodocumentogeneralReturnGeneral=new TipoDocumentoGeneralParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipodocumentogeneralReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoDocumentoGeneralLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipodocumentogenerals,tipodocumentogeneral,tipodocumentogeneralParameterGeneral,tipodocumentogeneralReturnGeneral,isEsNuevoTipoDocumentoGeneral,clases);
			
			return tipodocumentogeneralReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoDocumentoGeneralParameterReturnGeneral procesarEventosTipoDocumentoGeneralsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoDocumentoGeneral> tipodocumentogenerals,TipoDocumentoGeneral tipodocumentogeneral,TipoDocumentoGeneralParameterReturnGeneral tipodocumentogeneralParameterGeneral,Boolean isEsNuevoTipoDocumentoGeneral,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoGeneral.class.getSimpleName()+"-procesarEventosTipoDocumentoGeneralsWithConnection");connexion.begin();			
			
			TipoDocumentoGeneralParameterReturnGeneral tipodocumentogeneralReturnGeneral=new TipoDocumentoGeneralParameterReturnGeneral();
	
			tipodocumentogeneralReturnGeneral.setTipoDocumentoGeneral(tipodocumentogeneral);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipodocumentogeneralReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoDocumentoGeneralLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipodocumentogenerals,tipodocumentogeneral,tipodocumentogeneralParameterGeneral,tipodocumentogeneralReturnGeneral,isEsNuevoTipoDocumentoGeneral,clases);
			
			this.connexion.commit();
			
			return tipodocumentogeneralReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoDocumentoGeneralParameterReturnGeneral procesarImportacionTipoDocumentoGeneralsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoDocumentoGeneralParameterReturnGeneral tipodocumentogeneralParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoGeneral.class.getSimpleName()+"-procesarImportacionTipoDocumentoGeneralsWithConnection");connexion.begin();			
			
			TipoDocumentoGeneralParameterReturnGeneral tipodocumentogeneralReturnGeneral=new TipoDocumentoGeneralParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipodocumentogenerals=new ArrayList<TipoDocumentoGeneral>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipodocumentogeneral=new TipoDocumentoGeneral();
				
				
				if(conColumnasBase) {this.tipodocumentogeneral.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipodocumentogeneral.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipodocumentogeneral.setcodigo(arrColumnas[iColumn++]);
				this.tipodocumentogeneral.setnombre(arrColumnas[iColumn++]);
				
				this.tipodocumentogenerals.add(this.tipodocumentogeneral);
			}
			
			this.saveTipoDocumentoGenerals();
			
			this.connexion.commit();
			
			tipodocumentogeneralReturnGeneral.setConRetornoEstaProcesado(true);
			tipodocumentogeneralReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipodocumentogeneralReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoDocumentoGeneralsEliminados() throws Exception {				
		
		List<TipoDocumentoGeneral> tipodocumentogeneralsAux= new ArrayList<TipoDocumentoGeneral>();
		
		for(TipoDocumentoGeneral tipodocumentogeneral:tipodocumentogenerals) {
			if(!tipodocumentogeneral.getIsDeleted()) {
				tipodocumentogeneralsAux.add(tipodocumentogeneral);
			}
		}
		
		tipodocumentogenerals=tipodocumentogeneralsAux;
	}
	
	public void quitarTipoDocumentoGeneralsNulos() throws Exception {				
		
		List<TipoDocumentoGeneral> tipodocumentogeneralsAux= new ArrayList<TipoDocumentoGeneral>();
		
		for(TipoDocumentoGeneral tipodocumentogeneral : this.tipodocumentogenerals) {
			if(tipodocumentogeneral==null) {
				tipodocumentogeneralsAux.add(tipodocumentogeneral);
			}
		}
		
		//this.tipodocumentogenerals=tipodocumentogeneralsAux;
		
		this.tipodocumentogenerals.removeAll(tipodocumentogeneralsAux);
	}
	
	public void getSetVersionRowTipoDocumentoGeneralWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipodocumentogeneral.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipodocumentogeneral.getIsDeleted() || (tipodocumentogeneral.getIsChanged()&&!tipodocumentogeneral.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipodocumentogeneralDataAccess.getSetVersionRowTipoDocumentoGeneral(connexion,tipodocumentogeneral.getId());
				
				if(!tipodocumentogeneral.getVersionRow().equals(timestamp)) {	
					tipodocumentogeneral.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipodocumentogeneral.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoDocumentoGeneral()throws Exception {	
		
		if(tipodocumentogeneral.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipodocumentogeneral.getIsDeleted() || (tipodocumentogeneral.getIsChanged()&&!tipodocumentogeneral.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipodocumentogeneralDataAccess.getSetVersionRowTipoDocumentoGeneral(connexion,tipodocumentogeneral.getId());
			
			try {							
				if(!tipodocumentogeneral.getVersionRow().equals(timestamp)) {	
					tipodocumentogeneral.setVersionRow(timestamp);
				}
				
				tipodocumentogeneral.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoDocumentoGeneralsWithConnection()throws Exception {	
		if(tipodocumentogenerals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoDocumentoGeneral tipodocumentogeneralAux:tipodocumentogenerals) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipodocumentogeneralAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipodocumentogeneralAux.getIsDeleted() || (tipodocumentogeneralAux.getIsChanged()&&!tipodocumentogeneralAux.getIsNew())) {
						
						timestamp=tipodocumentogeneralDataAccess.getSetVersionRowTipoDocumentoGeneral(connexion,tipodocumentogeneralAux.getId());
						
						if(!tipodocumentogeneral.getVersionRow().equals(timestamp)) {	
							tipodocumentogeneralAux.setVersionRow(timestamp);
						}
								
						tipodocumentogeneralAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoDocumentoGenerals()throws Exception {	
		if(tipodocumentogenerals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoDocumentoGeneral tipodocumentogeneralAux:tipodocumentogenerals) {
					if(tipodocumentogeneralAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipodocumentogeneralAux.getIsDeleted() || (tipodocumentogeneralAux.getIsChanged()&&!tipodocumentogeneralAux.getIsNew())) {
						
						timestamp=tipodocumentogeneralDataAccess.getSetVersionRowTipoDocumentoGeneral(connexion,tipodocumentogeneralAux.getId());
						
						if(!tipodocumentogeneralAux.getVersionRow().equals(timestamp)) {	
							tipodocumentogeneralAux.setVersionRow(timestamp);
						}
						
													
						tipodocumentogeneralAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(TipoDocumentoGeneral tipodocumentogeneral,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoDocumentoGeneralLogicAdditional.updateTipoDocumentoGeneralToGet(tipodocumentogeneral,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoDocumentoGeneral tipodocumentogeneral,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoDocumentoGeneralLogicAdditional.updateTipoDocumentoGeneralToSave(tipodocumentogeneral,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoDocumentoGeneral.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipodocumentogeneral,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(tipodocumentogeneral);
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
			this.deepLoad(this.tipodocumentogeneral,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogeneral);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoDocumentoGeneral.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipodocumentogenerals!=null) {
				for(TipoDocumentoGeneral tipodocumentogeneral:tipodocumentogenerals) {
					this.deepLoad(tipodocumentogeneral,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(tipodocumentogenerals);
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
			if(tipodocumentogenerals!=null) {
				for(TipoDocumentoGeneral tipodocumentogeneral:tipodocumentogenerals) {
					this.deepLoad(tipodocumentogeneral,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(tipodocumentogenerals);
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
			this.getNewConnexionToDeep(TipoDocumentoGeneral.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipodocumentogeneral,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoDocumentoGeneral.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipodocumentogenerals!=null) {
				for(TipoDocumentoGeneral tipodocumentogeneral:tipodocumentogenerals) {
					this.deepSave(tipodocumentogeneral,isDeep,deepLoadType,clases);
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
			if(tipodocumentogenerals!=null) {
				for(TipoDocumentoGeneral tipodocumentogeneral:tipodocumentogenerals) {
					this.deepSave(tipodocumentogeneral,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoDocumentoGeneralsBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoGeneral.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoDocumentoGeneralConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoDocumentoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodocumentogenerals=tipodocumentogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogenerals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDocumentoGeneralsBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoDocumentoGeneralConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoDocumentoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodocumentogenerals=tipodocumentogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogenerals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoDocumentoGeneralsBusquedaPorIdWithConnection(String sFinalQuery,Pagination pagination,Long id)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoGeneral.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TipoDocumentoGeneralConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			TipoDocumentoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorId","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodocumentogenerals=tipodocumentogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogenerals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDocumentoGeneralsBusquedaPorId(String sFinalQuery,Pagination pagination,Long id)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralid= new ParameterSelectionGeneral();
			parameterSelectionGeneralid.setParameterSelectionGeneralEqual(ParameterType.LONG,id,TipoDocumentoGeneralConstantesFunciones.ID,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralid);

			TipoDocumentoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorId","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodocumentogenerals=tipodocumentogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogenerals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoDocumentoGeneralsBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoGeneral.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoDocumentoGeneralConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoDocumentoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodocumentogenerals=tipodocumentogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogenerals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDocumentoGeneralsBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoDocumentoGeneralConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoDocumentoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodocumentogenerals=tipodocumentogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDocumentoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoGeneral(this.tipodocumentogenerals);
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
			if(TipoDocumentoGeneralConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDocumentoGeneralDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoDocumentoGeneral tipodocumentogeneral,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoDocumentoGeneralConstantesFunciones.ISCONAUDITORIA) {
				if(tipodocumentogeneral.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDocumentoGeneralDataAccess.TABLENAME, tipodocumentogeneral.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoDocumentoGeneralConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoDocumentoGeneralLogic.registrarAuditoriaDetallesTipoDocumentoGeneral(connexion,tipodocumentogeneral,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipodocumentogeneral.getIsDeleted()) {
					/*if(!tipodocumentogeneral.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoDocumentoGeneralDataAccess.TABLENAME, tipodocumentogeneral.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoDocumentoGeneralLogic.registrarAuditoriaDetallesTipoDocumentoGeneral(connexion,tipodocumentogeneral,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDocumentoGeneralDataAccess.TABLENAME, tipodocumentogeneral.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipodocumentogeneral.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDocumentoGeneralDataAccess.TABLENAME, tipodocumentogeneral.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoDocumentoGeneralConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoDocumentoGeneralLogic.registrarAuditoriaDetallesTipoDocumentoGeneral(connexion,tipodocumentogeneral,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoDocumentoGeneral(Connexion connexion,TipoDocumentoGeneral tipodocumentogeneral)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipodocumentogeneral.getIsNew()||!tipodocumentogeneral.getcodigo().equals(tipodocumentogeneral.getTipoDocumentoGeneralOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodocumentogeneral.getTipoDocumentoGeneralOriginal().getcodigo()!=null)
				{
					strValorActual=tipodocumentogeneral.getTipoDocumentoGeneralOriginal().getcodigo();
				}
				if(tipodocumentogeneral.getcodigo()!=null)
				{
					strValorNuevo=tipodocumentogeneral.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDocumentoGeneralConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipodocumentogeneral.getIsNew()||!tipodocumentogeneral.getnombre().equals(tipodocumentogeneral.getTipoDocumentoGeneralOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodocumentogeneral.getTipoDocumentoGeneralOriginal().getnombre()!=null)
				{
					strValorActual=tipodocumentogeneral.getTipoDocumentoGeneralOriginal().getnombre();
				}
				if(tipodocumentogeneral.getnombre()!=null)
				{
					strValorNuevo=tipodocumentogeneral.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDocumentoGeneralConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoDocumentoGeneralRelacionesWithConnection(TipoDocumentoGeneral tipodocumentogeneral) throws Exception {

		if(!tipodocumentogeneral.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoDocumentoGeneralRelacionesBase(tipodocumentogeneral,true);
		}
	}

	public void saveTipoDocumentoGeneralRelaciones(TipoDocumentoGeneral tipodocumentogeneral)throws Exception {

		if(!tipodocumentogeneral.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoDocumentoGeneralRelacionesBase(tipodocumentogeneral,false);
		}
	}

	public void saveTipoDocumentoGeneralRelacionesBase(TipoDocumentoGeneral tipodocumentogeneral,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoDocumentoGeneral-saveRelacionesWithConnection");}
	

			this.setTipoDocumentoGeneral(tipodocumentogeneral);

				if((tipodocumentogeneral.getIsNew()||tipodocumentogeneral.getIsChanged())&&!tipodocumentogeneral.getIsDeleted()) {
					this.saveTipoDocumentoGeneral();
					this.saveTipoDocumentoGeneralRelacionesDetalles();

				} else if(tipodocumentogeneral.getIsDeleted()) {
					this.saveTipoDocumentoGeneralRelacionesDetalles();
					this.saveTipoDocumentoGeneral();
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
	
	
	private void saveTipoDocumentoGeneralRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDocumentoGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoDocumentoGeneralConstantesFunciones.getClassesForeignKeysOfTipoDocumentoGeneral(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDocumentoGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoDocumentoGeneralConstantesFunciones.getClassesRelationshipsOfTipoDocumentoGeneral(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

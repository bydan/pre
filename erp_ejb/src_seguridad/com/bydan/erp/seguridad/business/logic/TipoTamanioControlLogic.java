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
package com.bydan.erp.seguridad.business.logic;

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
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.seguridad.util.TipoTamanioControlConstantesFunciones;
import com.bydan.erp.seguridad.util.TipoTamanioControlParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.TipoTamanioControlParameterGeneral;
import com.bydan.erp.seguridad.business.entity.TipoTamanioControl;
//import com.bydan.erp.seguridad.business.logic.TipoTamanioControlLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoTamanioControlLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoTamanioControlLogic.class);
	
	protected TipoTamanioControlDataAccess tipotamaniocontrolDataAccess; 	
	protected TipoTamanioControl tipotamaniocontrol;
	protected List<TipoTamanioControl> tipotamaniocontrols;
	protected Object tipotamaniocontrolObject;	
	protected List<Object> tipotamaniocontrolsObject;
	
	public static ClassValidator<TipoTamanioControl> tipotamaniocontrolValidator = new ClassValidator<TipoTamanioControl>(TipoTamanioControl.class);	
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
	
	
	
	
	public  TipoTamanioControlLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipotamaniocontrolDataAccess = new TipoTamanioControlDataAccess();
			
			this.tipotamaniocontrols= new ArrayList<TipoTamanioControl>();
			this.tipotamaniocontrol= new TipoTamanioControl();
			
			this.tipotamaniocontrolObject=new Object();
			this.tipotamaniocontrolsObject=new ArrayList<Object>();
				
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
			
			this.tipotamaniocontrolDataAccess.setConnexionType(this.connexionType);
			this.tipotamaniocontrolDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoTamanioControlLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipotamaniocontrolDataAccess = new TipoTamanioControlDataAccess();
			this.tipotamaniocontrols= new ArrayList<TipoTamanioControl>();
			this.tipotamaniocontrol= new TipoTamanioControl();
			this.tipotamaniocontrolObject=new Object();
			this.tipotamaniocontrolsObject=new ArrayList<Object>();
			
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
			
			this.tipotamaniocontrolDataAccess.setConnexionType(this.connexionType);
			this.tipotamaniocontrolDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoTamanioControl getTipoTamanioControl() throws Exception {	
		//TipoTamanioControlLogicAdditional.checkTipoTamanioControlToGet(tipotamaniocontrol,this.datosCliente,this.arrDatoGeneral);
		//TipoTamanioControlLogicAdditional.updateTipoTamanioControlToGet(tipotamaniocontrol,this.arrDatoGeneral);
		
		return tipotamaniocontrol;
	}
		
	public void setTipoTamanioControl(TipoTamanioControl newTipoTamanioControl) {
		this.tipotamaniocontrol = newTipoTamanioControl;
	}
	
	public TipoTamanioControlDataAccess getTipoTamanioControlDataAccess() {
		return tipotamaniocontrolDataAccess;
	}
	
	public void setTipoTamanioControlDataAccess(TipoTamanioControlDataAccess newtipotamaniocontrolDataAccess) {
		this.tipotamaniocontrolDataAccess = newtipotamaniocontrolDataAccess;
	}
	
	public List<TipoTamanioControl> getTipoTamanioControls() throws Exception {		
		this.quitarTipoTamanioControlsNulos();
		
		//TipoTamanioControlLogicAdditional.checkTipoTamanioControlToGets(tipotamaniocontrols,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoTamanioControl tipotamaniocontrolLocal: tipotamaniocontrols ) {
			//TipoTamanioControlLogicAdditional.updateTipoTamanioControlToGet(tipotamaniocontrolLocal,this.arrDatoGeneral);
		}
		
		return tipotamaniocontrols;
	}
	
	public void setTipoTamanioControls(List<TipoTamanioControl> newTipoTamanioControls) {
		this.tipotamaniocontrols = newTipoTamanioControls;
	}
	
	public Object getTipoTamanioControlObject() {	
		this.tipotamaniocontrolObject=this.tipotamaniocontrolDataAccess.getEntityObject();
		return this.tipotamaniocontrolObject;
	}
		
	public void setTipoTamanioControlObject(Object newTipoTamanioControlObject) {
		this.tipotamaniocontrolObject = newTipoTamanioControlObject;
	}
	
	public List<Object> getTipoTamanioControlsObject() {		
		this.tipotamaniocontrolsObject=this.tipotamaniocontrolDataAccess.getEntitiesObject();
		return this.tipotamaniocontrolsObject;
	}
		
	public void setTipoTamanioControlsObject(List<Object> newTipoTamanioControlsObject) {
		this.tipotamaniocontrolsObject = newTipoTamanioControlsObject;
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
		
		if(this.tipotamaniocontrolDataAccess!=null) {
			this.tipotamaniocontrolDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTamanioControl.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipotamaniocontrolDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipotamaniocontrolDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipotamaniocontrol = new  TipoTamanioControl();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTamanioControl.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipotamaniocontrol=tipotamaniocontrolDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipotamaniocontrol,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTamanioControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoTamanioControl(this.tipotamaniocontrol);
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
		tipotamaniocontrol = new  TipoTamanioControl();
		  		  
        try {
			
			tipotamaniocontrol=tipotamaniocontrolDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipotamaniocontrol,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTamanioControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoTamanioControl(this.tipotamaniocontrol);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipotamaniocontrol = new  TipoTamanioControl();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTamanioControl.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipotamaniocontrol=tipotamaniocontrolDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipotamaniocontrol,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTamanioControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoTamanioControl(this.tipotamaniocontrol);
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
		tipotamaniocontrol = new  TipoTamanioControl();
		  		  
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
		tipotamaniocontrol = new  TipoTamanioControl();
		  		  
        try {
			
			tipotamaniocontrol=tipotamaniocontrolDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipotamaniocontrol,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoTamanioControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoTamanioControl(this.tipotamaniocontrol);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipotamaniocontrol = new  TipoTamanioControl();
		  		  
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
		tipotamaniocontrol = new  TipoTamanioControl();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTamanioControl.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipotamaniocontrolDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipotamaniocontrol = new  TipoTamanioControl();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipotamaniocontrolDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipotamaniocontrol = new  TipoTamanioControl();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTamanioControl.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipotamaniocontrolDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipotamaniocontrol = new  TipoTamanioControl();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipotamaniocontrolDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipotamaniocontrol = new  TipoTamanioControl();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTamanioControl.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipotamaniocontrolDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipotamaniocontrol = new  TipoTamanioControl();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipotamaniocontrolDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipotamaniocontrols = new  ArrayList<TipoTamanioControl>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTamanioControl.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoTamanioControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotamaniocontrols=tipotamaniocontrolDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTamanioControl(tipotamaniocontrols);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTamanioControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoTamanioControl(this.tipotamaniocontrols);
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
		tipotamaniocontrols = new  ArrayList<TipoTamanioControl>();
		  		  
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
		tipotamaniocontrols = new  ArrayList<TipoTamanioControl>();
		  		  
        try {			
			TipoTamanioControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotamaniocontrols=tipotamaniocontrolDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoTamanioControl(tipotamaniocontrols);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTamanioControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoTamanioControl(this.tipotamaniocontrols);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipotamaniocontrols = new  ArrayList<TipoTamanioControl>();
		  		  
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
		tipotamaniocontrols = new  ArrayList<TipoTamanioControl>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTamanioControl.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoTamanioControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotamaniocontrols=tipotamaniocontrolDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTamanioControl(tipotamaniocontrols);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTamanioControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoTamanioControl(this.tipotamaniocontrols);
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
		tipotamaniocontrols = new  ArrayList<TipoTamanioControl>();
		  		  
        try {
			TipoTamanioControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotamaniocontrols=tipotamaniocontrolDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoTamanioControl(tipotamaniocontrols);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTamanioControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoTamanioControl(this.tipotamaniocontrols);
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
		tipotamaniocontrols = new  ArrayList<TipoTamanioControl>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTamanioControl.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTamanioControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotamaniocontrols=tipotamaniocontrolDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTamanioControl(tipotamaniocontrols);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTamanioControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoTamanioControl(this.tipotamaniocontrols);
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
		tipotamaniocontrols = new  ArrayList<TipoTamanioControl>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTamanioControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotamaniocontrols=tipotamaniocontrolDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTamanioControl(tipotamaniocontrols);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTamanioControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoTamanioControl(this.tipotamaniocontrols);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipotamaniocontrol = new  TipoTamanioControl();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTamanioControl.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTamanioControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotamaniocontrol=tipotamaniocontrolDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTamanioControl(tipotamaniocontrol);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTamanioControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoTamanioControl(this.tipotamaniocontrol);
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
		tipotamaniocontrol = new  TipoTamanioControl();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTamanioControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotamaniocontrol=tipotamaniocontrolDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoTamanioControl(tipotamaniocontrol);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTamanioControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoTamanioControl(this.tipotamaniocontrol);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoTamanioControlsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipotamaniocontrols = new  ArrayList<TipoTamanioControl>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTamanioControl.class.getSimpleName()+"-getTodosTipoTamanioControlsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTamanioControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotamaniocontrols=tipotamaniocontrolDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoTamanioControl(tipotamaniocontrols);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTamanioControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoTamanioControl(this.tipotamaniocontrols);
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
	
	public  void  getTodosTipoTamanioControls(String sFinalQuery,Pagination pagination)throws Exception {
		tipotamaniocontrols = new  ArrayList<TipoTamanioControl>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoTamanioControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipotamaniocontrols=tipotamaniocontrolDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoTamanioControl(tipotamaniocontrols);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoTamanioControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoTamanioControl(this.tipotamaniocontrols);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoTamanioControl(TipoTamanioControl tipotamaniocontrol) throws Exception {
		Boolean estaValidado=false;
		
		if(tipotamaniocontrol.getIsNew() || tipotamaniocontrol.getIsChanged()) { 
			this.invalidValues = tipotamaniocontrolValidator.getInvalidValues(tipotamaniocontrol);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipotamaniocontrol);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoTamanioControl(List<TipoTamanioControl> TipoTamanioControls) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoTamanioControl tipotamaniocontrolLocal:tipotamaniocontrols) {				
			estaValidadoObjeto=this.validarGuardarTipoTamanioControl(tipotamaniocontrolLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoTamanioControl(List<TipoTamanioControl> TipoTamanioControls) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoTamanioControl(tipotamaniocontrols)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoTamanioControl(TipoTamanioControl TipoTamanioControl) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoTamanioControl(tipotamaniocontrol)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoTamanioControl tipotamaniocontrol) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipotamaniocontrol.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoTamanioControlConstantesFunciones.getTipoTamanioControlLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipotamaniocontrol","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoTamanioControlConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoTamanioControlConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoTamanioControlWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTamanioControl.class.getSimpleName()+"-saveTipoTamanioControlWithConnection");connexion.begin();			
			
			//TipoTamanioControlLogicAdditional.checkTipoTamanioControlToSave(this.tipotamaniocontrol,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoTamanioControlLogicAdditional.updateTipoTamanioControlToSave(this.tipotamaniocontrol,this.arrDatoGeneral);
			
			TipoTamanioControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipotamaniocontrol,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoTamanioControl();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoTamanioControl(this.tipotamaniocontrol)) {
				TipoTamanioControlDataAccess.save(this.tipotamaniocontrol, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipotamaniocontrol,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoTamanioControlLogicAdditional.checkTipoTamanioControlToSaveAfter(this.tipotamaniocontrol,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoTamanioControl();
			
			connexion.commit();			
			
			if(this.tipotamaniocontrol.getIsDeleted()) {
				this.tipotamaniocontrol=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoTamanioControl()throws Exception {	
		try {	
			
			//TipoTamanioControlLogicAdditional.checkTipoTamanioControlToSave(this.tipotamaniocontrol,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoTamanioControlLogicAdditional.updateTipoTamanioControlToSave(this.tipotamaniocontrol,this.arrDatoGeneral);
			
			TipoTamanioControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipotamaniocontrol,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoTamanioControl(this.tipotamaniocontrol)) {			
				TipoTamanioControlDataAccess.save(this.tipotamaniocontrol, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipotamaniocontrol,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoTamanioControlLogicAdditional.checkTipoTamanioControlToSaveAfter(this.tipotamaniocontrol,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipotamaniocontrol.getIsDeleted()) {
				this.tipotamaniocontrol=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoTamanioControlsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTamanioControl.class.getSimpleName()+"-saveTipoTamanioControlsWithConnection");connexion.begin();			
			
			//TipoTamanioControlLogicAdditional.checkTipoTamanioControlToSaves(tipotamaniocontrols,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoTamanioControls();
			
			Boolean validadoTodosTipoTamanioControl=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoTamanioControl tipotamaniocontrolLocal:tipotamaniocontrols) {		
				if(tipotamaniocontrolLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoTamanioControlLogicAdditional.updateTipoTamanioControlToSave(tipotamaniocontrolLocal,this.arrDatoGeneral);
	        	
				TipoTamanioControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipotamaniocontrolLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoTamanioControl(tipotamaniocontrolLocal)) {
					TipoTamanioControlDataAccess.save(tipotamaniocontrolLocal, connexion);				
				} else {
					validadoTodosTipoTamanioControl=false;
				}
			}
			
			if(!validadoTodosTipoTamanioControl) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoTamanioControlLogicAdditional.checkTipoTamanioControlToSavesAfter(tipotamaniocontrols,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoTamanioControls();
			
			connexion.commit();		
			
			this.quitarTipoTamanioControlsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoTamanioControls()throws Exception {				
		 try {	
			//TipoTamanioControlLogicAdditional.checkTipoTamanioControlToSaves(tipotamaniocontrols,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoTamanioControl=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoTamanioControl tipotamaniocontrolLocal:tipotamaniocontrols) {				
				if(tipotamaniocontrolLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoTamanioControlLogicAdditional.updateTipoTamanioControlToSave(tipotamaniocontrolLocal,this.arrDatoGeneral);
	        	
				TipoTamanioControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipotamaniocontrolLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoTamanioControl(tipotamaniocontrolLocal)) {				
					TipoTamanioControlDataAccess.save(tipotamaniocontrolLocal, connexion);				
				} else {
					validadoTodosTipoTamanioControl=false;
				}
			}
			
			if(!validadoTodosTipoTamanioControl) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoTamanioControlLogicAdditional.checkTipoTamanioControlToSavesAfter(tipotamaniocontrols,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoTamanioControlsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoTamanioControlParameterReturnGeneral procesarAccionTipoTamanioControls(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoTamanioControl> tipotamaniocontrols,TipoTamanioControlParameterReturnGeneral tipotamaniocontrolParameterGeneral)throws Exception {
		 try {	
			TipoTamanioControlParameterReturnGeneral tipotamaniocontrolReturnGeneral=new TipoTamanioControlParameterReturnGeneral();
	
			
			return tipotamaniocontrolReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoTamanioControlParameterReturnGeneral procesarAccionTipoTamanioControlsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoTamanioControl> tipotamaniocontrols,TipoTamanioControlParameterReturnGeneral tipotamaniocontrolParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTamanioControl.class.getSimpleName()+"-procesarAccionTipoTamanioControlsWithConnection");connexion.begin();			
			
			TipoTamanioControlParameterReturnGeneral tipotamaniocontrolReturnGeneral=new TipoTamanioControlParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipotamaniocontrolReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoTamanioControlParameterReturnGeneral procesarEventosTipoTamanioControls(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoTamanioControl> tipotamaniocontrols,TipoTamanioControl tipotamaniocontrol,TipoTamanioControlParameterReturnGeneral tipotamaniocontrolParameterGeneral,Boolean isEsNuevoTipoTamanioControl,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoTamanioControlParameterReturnGeneral tipotamaniocontrolReturnGeneral=new TipoTamanioControlParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipotamaniocontrolReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipotamaniocontrolReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoTamanioControlParameterReturnGeneral procesarEventosTipoTamanioControlsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoTamanioControl> tipotamaniocontrols,TipoTamanioControl tipotamaniocontrol,TipoTamanioControlParameterReturnGeneral tipotamaniocontrolParameterGeneral,Boolean isEsNuevoTipoTamanioControl,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTamanioControl.class.getSimpleName()+"-procesarEventosTipoTamanioControlsWithConnection");connexion.begin();			
			
			TipoTamanioControlParameterReturnGeneral tipotamaniocontrolReturnGeneral=new TipoTamanioControlParameterReturnGeneral();
	
			tipotamaniocontrolReturnGeneral.setTipoTamanioControl(tipotamaniocontrol);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipotamaniocontrolReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipotamaniocontrolReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoTamanioControlParameterReturnGeneral procesarImportacionTipoTamanioControlsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoTamanioControlParameterReturnGeneral tipotamaniocontrolParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoTamanioControl.class.getSimpleName()+"-procesarImportacionTipoTamanioControlsWithConnection");connexion.begin();			
			
			TipoTamanioControlParameterReturnGeneral tipotamaniocontrolReturnGeneral=new TipoTamanioControlParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipotamaniocontrols=new ArrayList<TipoTamanioControl>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipotamaniocontrol=new TipoTamanioControl();
				
				
				if(conColumnasBase) {this.tipotamaniocontrol.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipotamaniocontrol.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipotamaniocontrol.setcodigo(arrColumnas[iColumn++]);
				this.tipotamaniocontrol.setnombre(arrColumnas[iColumn++]);
				this.tipotamaniocontrol.setdescripcion(arrColumnas[iColumn++]);
				
				this.tipotamaniocontrols.add(this.tipotamaniocontrol);
			}
			
			this.saveTipoTamanioControls();
			
			this.connexion.commit();
			
			tipotamaniocontrolReturnGeneral.setConRetornoEstaProcesado(true);
			tipotamaniocontrolReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipotamaniocontrolReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoTamanioControlsEliminados() throws Exception {				
		
		List<TipoTamanioControl> tipotamaniocontrolsAux= new ArrayList<TipoTamanioControl>();
		
		for(TipoTamanioControl tipotamaniocontrol:tipotamaniocontrols) {
			if(!tipotamaniocontrol.getIsDeleted()) {
				tipotamaniocontrolsAux.add(tipotamaniocontrol);
			}
		}
		
		tipotamaniocontrols=tipotamaniocontrolsAux;
	}
	
	public void quitarTipoTamanioControlsNulos() throws Exception {				
		
		List<TipoTamanioControl> tipotamaniocontrolsAux= new ArrayList<TipoTamanioControl>();
		
		for(TipoTamanioControl tipotamaniocontrol : this.tipotamaniocontrols) {
			if(tipotamaniocontrol==null) {
				tipotamaniocontrolsAux.add(tipotamaniocontrol);
			}
		}
		
		//this.tipotamaniocontrols=tipotamaniocontrolsAux;
		
		this.tipotamaniocontrols.removeAll(tipotamaniocontrolsAux);
	}
	
	public void getSetVersionRowTipoTamanioControlWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipotamaniocontrol.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipotamaniocontrol.getIsDeleted() || (tipotamaniocontrol.getIsChanged()&&!tipotamaniocontrol.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipotamaniocontrolDataAccess.getSetVersionRowTipoTamanioControl(connexion,tipotamaniocontrol.getId());
				
				if(!tipotamaniocontrol.getVersionRow().equals(timestamp)) {	
					tipotamaniocontrol.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipotamaniocontrol.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoTamanioControl()throws Exception {	
		
		if(tipotamaniocontrol.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipotamaniocontrol.getIsDeleted() || (tipotamaniocontrol.getIsChanged()&&!tipotamaniocontrol.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipotamaniocontrolDataAccess.getSetVersionRowTipoTamanioControl(connexion,tipotamaniocontrol.getId());
			
			try {							
				if(!tipotamaniocontrol.getVersionRow().equals(timestamp)) {	
					tipotamaniocontrol.setVersionRow(timestamp);
				}
				
				tipotamaniocontrol.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoTamanioControlsWithConnection()throws Exception {	
		if(tipotamaniocontrols!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoTamanioControl tipotamaniocontrolAux:tipotamaniocontrols) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipotamaniocontrolAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipotamaniocontrolAux.getIsDeleted() || (tipotamaniocontrolAux.getIsChanged()&&!tipotamaniocontrolAux.getIsNew())) {
						
						timestamp=tipotamaniocontrolDataAccess.getSetVersionRowTipoTamanioControl(connexion,tipotamaniocontrolAux.getId());
						
						if(!tipotamaniocontrol.getVersionRow().equals(timestamp)) {	
							tipotamaniocontrolAux.setVersionRow(timestamp);
						}
								
						tipotamaniocontrolAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoTamanioControls()throws Exception {	
		if(tipotamaniocontrols!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoTamanioControl tipotamaniocontrolAux:tipotamaniocontrols) {
					if(tipotamaniocontrolAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipotamaniocontrolAux.getIsDeleted() || (tipotamaniocontrolAux.getIsChanged()&&!tipotamaniocontrolAux.getIsNew())) {
						
						timestamp=tipotamaniocontrolDataAccess.getSetVersionRowTipoTamanioControl(connexion,tipotamaniocontrolAux.getId());
						
						if(!tipotamaniocontrolAux.getVersionRow().equals(timestamp)) {	
							tipotamaniocontrolAux.setVersionRow(timestamp);
						}
						
													
						tipotamaniocontrolAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(TipoTamanioControl tipotamaniocontrol,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoTamanioControlLogicAdditional.updateTipoTamanioControlToGet(tipotamaniocontrol,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoTamanioControl tipotamaniocontrol,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoTamanioControl.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipotamaniocontrol,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoTamanioControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoTamanioControl(tipotamaniocontrol);
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
			this.deepLoad(this.tipotamaniocontrol,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoTamanioControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoTamanioControl(this.tipotamaniocontrol);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoTamanioControl.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipotamaniocontrols!=null) {
				for(TipoTamanioControl tipotamaniocontrol:tipotamaniocontrols) {
					this.deepLoad(tipotamaniocontrol,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoTamanioControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoTamanioControl(tipotamaniocontrols);
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
			if(tipotamaniocontrols!=null) {
				for(TipoTamanioControl tipotamaniocontrol:tipotamaniocontrols) {
					this.deepLoad(tipotamaniocontrol,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoTamanioControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoTamanioControl(tipotamaniocontrols);
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
			if(TipoTamanioControlConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTamanioControlDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoTamanioControl tipotamaniocontrol,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoTamanioControlConstantesFunciones.ISCONAUDITORIA) {
				if(tipotamaniocontrol.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTamanioControlDataAccess.TABLENAME, tipotamaniocontrol.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoTamanioControlConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoTamanioControlLogic.registrarAuditoriaDetallesTipoTamanioControl(connexion,tipotamaniocontrol,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipotamaniocontrol.getIsDeleted()) {
					/*if(!tipotamaniocontrol.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoTamanioControlDataAccess.TABLENAME, tipotamaniocontrol.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoTamanioControlLogic.registrarAuditoriaDetallesTipoTamanioControl(connexion,tipotamaniocontrol,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTamanioControlDataAccess.TABLENAME, tipotamaniocontrol.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipotamaniocontrol.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoTamanioControlDataAccess.TABLENAME, tipotamaniocontrol.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoTamanioControlConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoTamanioControlLogic.registrarAuditoriaDetallesTipoTamanioControl(connexion,tipotamaniocontrol,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoTamanioControl(Connexion connexion,TipoTamanioControl tipotamaniocontrol)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipotamaniocontrol.getIsNew()||!tipotamaniocontrol.getcodigo().equals(tipotamaniocontrol.getTipoTamanioControlOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipotamaniocontrol.getTipoTamanioControlOriginal().getcodigo()!=null)
				{
					strValorActual=tipotamaniocontrol.getTipoTamanioControlOriginal().getcodigo();
				}
				if(tipotamaniocontrol.getcodigo()!=null)
				{
					strValorNuevo=tipotamaniocontrol.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoTamanioControlConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipotamaniocontrol.getIsNew()||!tipotamaniocontrol.getnombre().equals(tipotamaniocontrol.getTipoTamanioControlOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipotamaniocontrol.getTipoTamanioControlOriginal().getnombre()!=null)
				{
					strValorActual=tipotamaniocontrol.getTipoTamanioControlOriginal().getnombre();
				}
				if(tipotamaniocontrol.getnombre()!=null)
				{
					strValorNuevo=tipotamaniocontrol.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoTamanioControlConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipotamaniocontrol.getIsNew()||!tipotamaniocontrol.getdescripcion().equals(tipotamaniocontrol.getTipoTamanioControlOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipotamaniocontrol.getTipoTamanioControlOriginal().getdescripcion()!=null)
				{
					strValorActual=tipotamaniocontrol.getTipoTamanioControlOriginal().getdescripcion();
				}
				if(tipotamaniocontrol.getdescripcion()!=null)
				{
					strValorNuevo=tipotamaniocontrol.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoTamanioControlConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoTamanioControl(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoTamanioControlConstantesFunciones.getClassesForeignKeysOfTipoTamanioControl(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoTamanioControl(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoTamanioControlConstantesFunciones.getClassesRelationshipsOfTipoTamanioControl(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

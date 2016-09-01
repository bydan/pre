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
import com.bydan.erp.seguridad.util.TipoFondoControlConstantesFunciones;
import com.bydan.erp.seguridad.util.TipoFondoControlParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.TipoFondoControlParameterGeneral;
import com.bydan.erp.seguridad.business.entity.TipoFondoControl;
//import com.bydan.erp.seguridad.business.logic.TipoFondoControlLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoFondoControlLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoFondoControlLogic.class);
	
	protected TipoFondoControlDataAccess tipofondocontrolDataAccess; 	
	protected TipoFondoControl tipofondocontrol;
	protected List<TipoFondoControl> tipofondocontrols;
	protected Object tipofondocontrolObject;	
	protected List<Object> tipofondocontrolsObject;
	
	public static ClassValidator<TipoFondoControl> tipofondocontrolValidator = new ClassValidator<TipoFondoControl>(TipoFondoControl.class);	
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
	
	
	
	
	public  TipoFondoControlLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipofondocontrolDataAccess = new TipoFondoControlDataAccess();
			
			this.tipofondocontrols= new ArrayList<TipoFondoControl>();
			this.tipofondocontrol= new TipoFondoControl();
			
			this.tipofondocontrolObject=new Object();
			this.tipofondocontrolsObject=new ArrayList<Object>();
				
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
			
			this.tipofondocontrolDataAccess.setConnexionType(this.connexionType);
			this.tipofondocontrolDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoFondoControlLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipofondocontrolDataAccess = new TipoFondoControlDataAccess();
			this.tipofondocontrols= new ArrayList<TipoFondoControl>();
			this.tipofondocontrol= new TipoFondoControl();
			this.tipofondocontrolObject=new Object();
			this.tipofondocontrolsObject=new ArrayList<Object>();
			
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
			
			this.tipofondocontrolDataAccess.setConnexionType(this.connexionType);
			this.tipofondocontrolDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoFondoControl getTipoFondoControl() throws Exception {	
		//TipoFondoControlLogicAdditional.checkTipoFondoControlToGet(tipofondocontrol,this.datosCliente,this.arrDatoGeneral);
		//TipoFondoControlLogicAdditional.updateTipoFondoControlToGet(tipofondocontrol,this.arrDatoGeneral);
		
		return tipofondocontrol;
	}
		
	public void setTipoFondoControl(TipoFondoControl newTipoFondoControl) {
		this.tipofondocontrol = newTipoFondoControl;
	}
	
	public TipoFondoControlDataAccess getTipoFondoControlDataAccess() {
		return tipofondocontrolDataAccess;
	}
	
	public void setTipoFondoControlDataAccess(TipoFondoControlDataAccess newtipofondocontrolDataAccess) {
		this.tipofondocontrolDataAccess = newtipofondocontrolDataAccess;
	}
	
	public List<TipoFondoControl> getTipoFondoControls() throws Exception {		
		this.quitarTipoFondoControlsNulos();
		
		//TipoFondoControlLogicAdditional.checkTipoFondoControlToGets(tipofondocontrols,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoFondoControl tipofondocontrolLocal: tipofondocontrols ) {
			//TipoFondoControlLogicAdditional.updateTipoFondoControlToGet(tipofondocontrolLocal,this.arrDatoGeneral);
		}
		
		return tipofondocontrols;
	}
	
	public void setTipoFondoControls(List<TipoFondoControl> newTipoFondoControls) {
		this.tipofondocontrols = newTipoFondoControls;
	}
	
	public Object getTipoFondoControlObject() {	
		this.tipofondocontrolObject=this.tipofondocontrolDataAccess.getEntityObject();
		return this.tipofondocontrolObject;
	}
		
	public void setTipoFondoControlObject(Object newTipoFondoControlObject) {
		this.tipofondocontrolObject = newTipoFondoControlObject;
	}
	
	public List<Object> getTipoFondoControlsObject() {		
		this.tipofondocontrolsObject=this.tipofondocontrolDataAccess.getEntitiesObject();
		return this.tipofondocontrolsObject;
	}
		
	public void setTipoFondoControlsObject(List<Object> newTipoFondoControlsObject) {
		this.tipofondocontrolsObject = newTipoFondoControlsObject;
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
		
		if(this.tipofondocontrolDataAccess!=null) {
			this.tipofondocontrolDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFondoControl.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipofondocontrolDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipofondocontrolDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipofondocontrol = new  TipoFondoControl();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFondoControl.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipofondocontrol=tipofondocontrolDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipofondocontrol,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoFondoControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoFondoControl(this.tipofondocontrol);
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
		tipofondocontrol = new  TipoFondoControl();
		  		  
        try {
			
			tipofondocontrol=tipofondocontrolDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipofondocontrol,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoFondoControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoFondoControl(this.tipofondocontrol);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipofondocontrol = new  TipoFondoControl();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFondoControl.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipofondocontrol=tipofondocontrolDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipofondocontrol,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoFondoControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoFondoControl(this.tipofondocontrol);
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
		tipofondocontrol = new  TipoFondoControl();
		  		  
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
		tipofondocontrol = new  TipoFondoControl();
		  		  
        try {
			
			tipofondocontrol=tipofondocontrolDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipofondocontrol,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoFondoControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoFondoControl(this.tipofondocontrol);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipofondocontrol = new  TipoFondoControl();
		  		  
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
		tipofondocontrol = new  TipoFondoControl();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFondoControl.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipofondocontrolDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipofondocontrol = new  TipoFondoControl();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipofondocontrolDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipofondocontrol = new  TipoFondoControl();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFondoControl.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipofondocontrolDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipofondocontrol = new  TipoFondoControl();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipofondocontrolDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipofondocontrol = new  TipoFondoControl();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFondoControl.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipofondocontrolDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipofondocontrol = new  TipoFondoControl();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipofondocontrolDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipofondocontrols = new  ArrayList<TipoFondoControl>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFondoControl.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoFondoControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipofondocontrols=tipofondocontrolDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoFondoControl(tipofondocontrols);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFondoControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoFondoControl(this.tipofondocontrols);
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
		tipofondocontrols = new  ArrayList<TipoFondoControl>();
		  		  
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
		tipofondocontrols = new  ArrayList<TipoFondoControl>();
		  		  
        try {			
			TipoFondoControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipofondocontrols=tipofondocontrolDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoFondoControl(tipofondocontrols);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFondoControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoFondoControl(this.tipofondocontrols);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipofondocontrols = new  ArrayList<TipoFondoControl>();
		  		  
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
		tipofondocontrols = new  ArrayList<TipoFondoControl>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFondoControl.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoFondoControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipofondocontrols=tipofondocontrolDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoFondoControl(tipofondocontrols);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFondoControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoFondoControl(this.tipofondocontrols);
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
		tipofondocontrols = new  ArrayList<TipoFondoControl>();
		  		  
        try {
			TipoFondoControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipofondocontrols=tipofondocontrolDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoFondoControl(tipofondocontrols);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFondoControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoFondoControl(this.tipofondocontrols);
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
		tipofondocontrols = new  ArrayList<TipoFondoControl>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFondoControl.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFondoControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipofondocontrols=tipofondocontrolDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoFondoControl(tipofondocontrols);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFondoControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoFondoControl(this.tipofondocontrols);
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
		tipofondocontrols = new  ArrayList<TipoFondoControl>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFondoControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipofondocontrols=tipofondocontrolDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoFondoControl(tipofondocontrols);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFondoControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoFondoControl(this.tipofondocontrols);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipofondocontrol = new  TipoFondoControl();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFondoControl.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFondoControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipofondocontrol=tipofondocontrolDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoFondoControl(tipofondocontrol);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFondoControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoFondoControl(this.tipofondocontrol);
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
		tipofondocontrol = new  TipoFondoControl();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFondoControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipofondocontrol=tipofondocontrolDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoFondoControl(tipofondocontrol);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFondoControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoFondoControl(this.tipofondocontrol);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoFondoControlsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipofondocontrols = new  ArrayList<TipoFondoControl>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFondoControl.class.getSimpleName()+"-getTodosTipoFondoControlsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFondoControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipofondocontrols=tipofondocontrolDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoFondoControl(tipofondocontrols);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFondoControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoFondoControl(this.tipofondocontrols);
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
	
	public  void  getTodosTipoFondoControls(String sFinalQuery,Pagination pagination)throws Exception {
		tipofondocontrols = new  ArrayList<TipoFondoControl>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFondoControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipofondocontrols=tipofondocontrolDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoFondoControl(tipofondocontrols);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFondoControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoFondoControl(this.tipofondocontrols);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoFondoControl(TipoFondoControl tipofondocontrol) throws Exception {
		Boolean estaValidado=false;
		
		if(tipofondocontrol.getIsNew() || tipofondocontrol.getIsChanged()) { 
			this.invalidValues = tipofondocontrolValidator.getInvalidValues(tipofondocontrol);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipofondocontrol);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoFondoControl(List<TipoFondoControl> TipoFondoControls) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoFondoControl tipofondocontrolLocal:tipofondocontrols) {				
			estaValidadoObjeto=this.validarGuardarTipoFondoControl(tipofondocontrolLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoFondoControl(List<TipoFondoControl> TipoFondoControls) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoFondoControl(tipofondocontrols)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoFondoControl(TipoFondoControl TipoFondoControl) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoFondoControl(tipofondocontrol)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoFondoControl tipofondocontrol) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipofondocontrol.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoFondoControlConstantesFunciones.getTipoFondoControlLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipofondocontrol","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoFondoControlConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoFondoControlConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoFondoControlWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFondoControl.class.getSimpleName()+"-saveTipoFondoControlWithConnection");connexion.begin();			
			
			//TipoFondoControlLogicAdditional.checkTipoFondoControlToSave(this.tipofondocontrol,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoFondoControlLogicAdditional.updateTipoFondoControlToSave(this.tipofondocontrol,this.arrDatoGeneral);
			
			TipoFondoControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipofondocontrol,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoFondoControl();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoFondoControl(this.tipofondocontrol)) {
				TipoFondoControlDataAccess.save(this.tipofondocontrol, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipofondocontrol,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoFondoControlLogicAdditional.checkTipoFondoControlToSaveAfter(this.tipofondocontrol,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoFondoControl();
			
			connexion.commit();			
			
			if(this.tipofondocontrol.getIsDeleted()) {
				this.tipofondocontrol=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoFondoControl()throws Exception {	
		try {	
			
			//TipoFondoControlLogicAdditional.checkTipoFondoControlToSave(this.tipofondocontrol,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoFondoControlLogicAdditional.updateTipoFondoControlToSave(this.tipofondocontrol,this.arrDatoGeneral);
			
			TipoFondoControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipofondocontrol,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoFondoControl(this.tipofondocontrol)) {			
				TipoFondoControlDataAccess.save(this.tipofondocontrol, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipofondocontrol,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoFondoControlLogicAdditional.checkTipoFondoControlToSaveAfter(this.tipofondocontrol,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipofondocontrol.getIsDeleted()) {
				this.tipofondocontrol=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoFondoControlsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFondoControl.class.getSimpleName()+"-saveTipoFondoControlsWithConnection");connexion.begin();			
			
			//TipoFondoControlLogicAdditional.checkTipoFondoControlToSaves(tipofondocontrols,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoFondoControls();
			
			Boolean validadoTodosTipoFondoControl=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoFondoControl tipofondocontrolLocal:tipofondocontrols) {		
				if(tipofondocontrolLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoFondoControlLogicAdditional.updateTipoFondoControlToSave(tipofondocontrolLocal,this.arrDatoGeneral);
	        	
				TipoFondoControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipofondocontrolLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoFondoControl(tipofondocontrolLocal)) {
					TipoFondoControlDataAccess.save(tipofondocontrolLocal, connexion);				
				} else {
					validadoTodosTipoFondoControl=false;
				}
			}
			
			if(!validadoTodosTipoFondoControl) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoFondoControlLogicAdditional.checkTipoFondoControlToSavesAfter(tipofondocontrols,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoFondoControls();
			
			connexion.commit();		
			
			this.quitarTipoFondoControlsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoFondoControls()throws Exception {				
		 try {	
			//TipoFondoControlLogicAdditional.checkTipoFondoControlToSaves(tipofondocontrols,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoFondoControl=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoFondoControl tipofondocontrolLocal:tipofondocontrols) {				
				if(tipofondocontrolLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoFondoControlLogicAdditional.updateTipoFondoControlToSave(tipofondocontrolLocal,this.arrDatoGeneral);
	        	
				TipoFondoControlLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipofondocontrolLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoFondoControl(tipofondocontrolLocal)) {				
					TipoFondoControlDataAccess.save(tipofondocontrolLocal, connexion);				
				} else {
					validadoTodosTipoFondoControl=false;
				}
			}
			
			if(!validadoTodosTipoFondoControl) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoFondoControlLogicAdditional.checkTipoFondoControlToSavesAfter(tipofondocontrols,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoFondoControlsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoFondoControlParameterReturnGeneral procesarAccionTipoFondoControls(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoFondoControl> tipofondocontrols,TipoFondoControlParameterReturnGeneral tipofondocontrolParameterGeneral)throws Exception {
		 try {	
			TipoFondoControlParameterReturnGeneral tipofondocontrolReturnGeneral=new TipoFondoControlParameterReturnGeneral();
	
			
			return tipofondocontrolReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoFondoControlParameterReturnGeneral procesarAccionTipoFondoControlsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoFondoControl> tipofondocontrols,TipoFondoControlParameterReturnGeneral tipofondocontrolParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFondoControl.class.getSimpleName()+"-procesarAccionTipoFondoControlsWithConnection");connexion.begin();			
			
			TipoFondoControlParameterReturnGeneral tipofondocontrolReturnGeneral=new TipoFondoControlParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipofondocontrolReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoFondoControlParameterReturnGeneral procesarEventosTipoFondoControls(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoFondoControl> tipofondocontrols,TipoFondoControl tipofondocontrol,TipoFondoControlParameterReturnGeneral tipofondocontrolParameterGeneral,Boolean isEsNuevoTipoFondoControl,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoFondoControlParameterReturnGeneral tipofondocontrolReturnGeneral=new TipoFondoControlParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipofondocontrolReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipofondocontrolReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoFondoControlParameterReturnGeneral procesarEventosTipoFondoControlsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoFondoControl> tipofondocontrols,TipoFondoControl tipofondocontrol,TipoFondoControlParameterReturnGeneral tipofondocontrolParameterGeneral,Boolean isEsNuevoTipoFondoControl,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFondoControl.class.getSimpleName()+"-procesarEventosTipoFondoControlsWithConnection");connexion.begin();			
			
			TipoFondoControlParameterReturnGeneral tipofondocontrolReturnGeneral=new TipoFondoControlParameterReturnGeneral();
	
			tipofondocontrolReturnGeneral.setTipoFondoControl(tipofondocontrol);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipofondocontrolReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipofondocontrolReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoFondoControlParameterReturnGeneral procesarImportacionTipoFondoControlsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoFondoControlParameterReturnGeneral tipofondocontrolParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFondoControl.class.getSimpleName()+"-procesarImportacionTipoFondoControlsWithConnection");connexion.begin();			
			
			TipoFondoControlParameterReturnGeneral tipofondocontrolReturnGeneral=new TipoFondoControlParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipofondocontrols=new ArrayList<TipoFondoControl>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipofondocontrol=new TipoFondoControl();
				
				
				if(conColumnasBase) {this.tipofondocontrol.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipofondocontrol.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipofondocontrol.setcodigo(arrColumnas[iColumn++]);
				this.tipofondocontrol.setnombre(arrColumnas[iColumn++]);
				
				this.tipofondocontrols.add(this.tipofondocontrol);
			}
			
			this.saveTipoFondoControls();
			
			this.connexion.commit();
			
			tipofondocontrolReturnGeneral.setConRetornoEstaProcesado(true);
			tipofondocontrolReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipofondocontrolReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoFondoControlsEliminados() throws Exception {				
		
		List<TipoFondoControl> tipofondocontrolsAux= new ArrayList<TipoFondoControl>();
		
		for(TipoFondoControl tipofondocontrol:tipofondocontrols) {
			if(!tipofondocontrol.getIsDeleted()) {
				tipofondocontrolsAux.add(tipofondocontrol);
			}
		}
		
		tipofondocontrols=tipofondocontrolsAux;
	}
	
	public void quitarTipoFondoControlsNulos() throws Exception {				
		
		List<TipoFondoControl> tipofondocontrolsAux= new ArrayList<TipoFondoControl>();
		
		for(TipoFondoControl tipofondocontrol : this.tipofondocontrols) {
			if(tipofondocontrol==null) {
				tipofondocontrolsAux.add(tipofondocontrol);
			}
		}
		
		//this.tipofondocontrols=tipofondocontrolsAux;
		
		this.tipofondocontrols.removeAll(tipofondocontrolsAux);
	}
	
	public void getSetVersionRowTipoFondoControlWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipofondocontrol.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipofondocontrol.getIsDeleted() || (tipofondocontrol.getIsChanged()&&!tipofondocontrol.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipofondocontrolDataAccess.getSetVersionRowTipoFondoControl(connexion,tipofondocontrol.getId());
				
				if(!tipofondocontrol.getVersionRow().equals(timestamp)) {	
					tipofondocontrol.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipofondocontrol.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoFondoControl()throws Exception {	
		
		if(tipofondocontrol.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipofondocontrol.getIsDeleted() || (tipofondocontrol.getIsChanged()&&!tipofondocontrol.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipofondocontrolDataAccess.getSetVersionRowTipoFondoControl(connexion,tipofondocontrol.getId());
			
			try {							
				if(!tipofondocontrol.getVersionRow().equals(timestamp)) {	
					tipofondocontrol.setVersionRow(timestamp);
				}
				
				tipofondocontrol.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoFondoControlsWithConnection()throws Exception {	
		if(tipofondocontrols!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoFondoControl tipofondocontrolAux:tipofondocontrols) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipofondocontrolAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipofondocontrolAux.getIsDeleted() || (tipofondocontrolAux.getIsChanged()&&!tipofondocontrolAux.getIsNew())) {
						
						timestamp=tipofondocontrolDataAccess.getSetVersionRowTipoFondoControl(connexion,tipofondocontrolAux.getId());
						
						if(!tipofondocontrol.getVersionRow().equals(timestamp)) {	
							tipofondocontrolAux.setVersionRow(timestamp);
						}
								
						tipofondocontrolAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoFondoControls()throws Exception {	
		if(tipofondocontrols!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoFondoControl tipofondocontrolAux:tipofondocontrols) {
					if(tipofondocontrolAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipofondocontrolAux.getIsDeleted() || (tipofondocontrolAux.getIsChanged()&&!tipofondocontrolAux.getIsNew())) {
						
						timestamp=tipofondocontrolDataAccess.getSetVersionRowTipoFondoControl(connexion,tipofondocontrolAux.getId());
						
						if(!tipofondocontrolAux.getVersionRow().equals(timestamp)) {	
							tipofondocontrolAux.setVersionRow(timestamp);
						}
						
													
						tipofondocontrolAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(TipoFondoControl tipofondocontrol,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoFondoControlLogicAdditional.updateTipoFondoControlToGet(tipofondocontrol,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoFondoControl tipofondocontrol,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoFondoControl.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipofondocontrol,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoFondoControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoFondoControl(tipofondocontrol);
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
			this.deepLoad(this.tipofondocontrol,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoFondoControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoFondoControl(this.tipofondocontrol);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoFondoControl.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipofondocontrols!=null) {
				for(TipoFondoControl tipofondocontrol:tipofondocontrols) {
					this.deepLoad(tipofondocontrol,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoFondoControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoFondoControl(tipofondocontrols);
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
			if(tipofondocontrols!=null) {
				for(TipoFondoControl tipofondocontrol:tipofondocontrols) {
					this.deepLoad(tipofondocontrol,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoFondoControlConstantesFunciones.refrescarForeignKeysDescripcionesTipoFondoControl(tipofondocontrols);
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
			if(TipoFondoControlConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoFondoControlDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoFondoControl tipofondocontrol,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoFondoControlConstantesFunciones.ISCONAUDITORIA) {
				if(tipofondocontrol.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoFondoControlDataAccess.TABLENAME, tipofondocontrol.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoFondoControlConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoFondoControlLogic.registrarAuditoriaDetallesTipoFondoControl(connexion,tipofondocontrol,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipofondocontrol.getIsDeleted()) {
					/*if(!tipofondocontrol.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoFondoControlDataAccess.TABLENAME, tipofondocontrol.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoFondoControlLogic.registrarAuditoriaDetallesTipoFondoControl(connexion,tipofondocontrol,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoFondoControlDataAccess.TABLENAME, tipofondocontrol.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipofondocontrol.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoFondoControlDataAccess.TABLENAME, tipofondocontrol.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoFondoControlConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoFondoControlLogic.registrarAuditoriaDetallesTipoFondoControl(connexion,tipofondocontrol,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoFondoControl(Connexion connexion,TipoFondoControl tipofondocontrol)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipofondocontrol.getIsNew()||!tipofondocontrol.getcodigo().equals(tipofondocontrol.getTipoFondoControlOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipofondocontrol.getTipoFondoControlOriginal().getcodigo()!=null)
				{
					strValorActual=tipofondocontrol.getTipoFondoControlOriginal().getcodigo();
				}
				if(tipofondocontrol.getcodigo()!=null)
				{
					strValorNuevo=tipofondocontrol.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoFondoControlConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipofondocontrol.getIsNew()||!tipofondocontrol.getnombre().equals(tipofondocontrol.getTipoFondoControlOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipofondocontrol.getTipoFondoControlOriginal().getnombre()!=null)
				{
					strValorActual=tipofondocontrol.getTipoFondoControlOriginal().getnombre();
				}
				if(tipofondocontrol.getnombre()!=null)
				{
					strValorNuevo=tipofondocontrol.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoFondoControlConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoFondoControl(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoFondoControlConstantesFunciones.getClassesForeignKeysOfTipoFondoControl(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFondoControl(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoFondoControlConstantesFunciones.getClassesRelationshipsOfTipoFondoControl(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

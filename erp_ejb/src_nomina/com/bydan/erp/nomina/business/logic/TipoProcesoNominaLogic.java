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
package com.bydan.erp.nomina.business.logic;

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
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.util.TipoProcesoNominaConstantesFunciones;
import com.bydan.erp.nomina.util.TipoProcesoNominaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoProcesoNominaParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoProcesoNomina;
//import com.bydan.erp.nomina.business.logic.TipoProcesoNominaLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoProcesoNominaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoProcesoNominaLogic.class);
	
	protected TipoProcesoNominaDataAccess tipoprocesonominaDataAccess; 	
	protected TipoProcesoNomina tipoprocesonomina;
	protected List<TipoProcesoNomina> tipoprocesonominas;
	protected Object tipoprocesonominaObject;	
	protected List<Object> tipoprocesonominasObject;
	
	public static ClassValidator<TipoProcesoNomina> tipoprocesonominaValidator = new ClassValidator<TipoProcesoNomina>(TipoProcesoNomina.class);	
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
	
	
	
	
	public  TipoProcesoNominaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoprocesonominaDataAccess = new TipoProcesoNominaDataAccess();
			
			this.tipoprocesonominas= new ArrayList<TipoProcesoNomina>();
			this.tipoprocesonomina= new TipoProcesoNomina();
			
			this.tipoprocesonominaObject=new Object();
			this.tipoprocesonominasObject=new ArrayList<Object>();
				
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
			
			this.tipoprocesonominaDataAccess.setConnexionType(this.connexionType);
			this.tipoprocesonominaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoProcesoNominaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoprocesonominaDataAccess = new TipoProcesoNominaDataAccess();
			this.tipoprocesonominas= new ArrayList<TipoProcesoNomina>();
			this.tipoprocesonomina= new TipoProcesoNomina();
			this.tipoprocesonominaObject=new Object();
			this.tipoprocesonominasObject=new ArrayList<Object>();
			
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
			
			this.tipoprocesonominaDataAccess.setConnexionType(this.connexionType);
			this.tipoprocesonominaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoProcesoNomina getTipoProcesoNomina() throws Exception {	
		//TipoProcesoNominaLogicAdditional.checkTipoProcesoNominaToGet(tipoprocesonomina,this.datosCliente,this.arrDatoGeneral);
		//TipoProcesoNominaLogicAdditional.updateTipoProcesoNominaToGet(tipoprocesonomina,this.arrDatoGeneral);
		
		return tipoprocesonomina;
	}
		
	public void setTipoProcesoNomina(TipoProcesoNomina newTipoProcesoNomina) {
		this.tipoprocesonomina = newTipoProcesoNomina;
	}
	
	public TipoProcesoNominaDataAccess getTipoProcesoNominaDataAccess() {
		return tipoprocesonominaDataAccess;
	}
	
	public void setTipoProcesoNominaDataAccess(TipoProcesoNominaDataAccess newtipoprocesonominaDataAccess) {
		this.tipoprocesonominaDataAccess = newtipoprocesonominaDataAccess;
	}
	
	public List<TipoProcesoNomina> getTipoProcesoNominas() throws Exception {		
		this.quitarTipoProcesoNominasNulos();
		
		//TipoProcesoNominaLogicAdditional.checkTipoProcesoNominaToGets(tipoprocesonominas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoProcesoNomina tipoprocesonominaLocal: tipoprocesonominas ) {
			//TipoProcesoNominaLogicAdditional.updateTipoProcesoNominaToGet(tipoprocesonominaLocal,this.arrDatoGeneral);
		}
		
		return tipoprocesonominas;
	}
	
	public void setTipoProcesoNominas(List<TipoProcesoNomina> newTipoProcesoNominas) {
		this.tipoprocesonominas = newTipoProcesoNominas;
	}
	
	public Object getTipoProcesoNominaObject() {	
		this.tipoprocesonominaObject=this.tipoprocesonominaDataAccess.getEntityObject();
		return this.tipoprocesonominaObject;
	}
		
	public void setTipoProcesoNominaObject(Object newTipoProcesoNominaObject) {
		this.tipoprocesonominaObject = newTipoProcesoNominaObject;
	}
	
	public List<Object> getTipoProcesoNominasObject() {		
		this.tipoprocesonominasObject=this.tipoprocesonominaDataAccess.getEntitiesObject();
		return this.tipoprocesonominasObject;
	}
		
	public void setTipoProcesoNominasObject(List<Object> newTipoProcesoNominasObject) {
		this.tipoprocesonominasObject = newTipoProcesoNominasObject;
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
		
		if(this.tipoprocesonominaDataAccess!=null) {
			this.tipoprocesonominaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoNomina.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoprocesonominaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoprocesonominaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoprocesonomina = new  TipoProcesoNomina();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoNomina.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoprocesonomina=tipoprocesonominaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprocesonomina,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProcesoNominaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoNomina(this.tipoprocesonomina);
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
		tipoprocesonomina = new  TipoProcesoNomina();
		  		  
        try {
			
			tipoprocesonomina=tipoprocesonominaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprocesonomina,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProcesoNominaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoNomina(this.tipoprocesonomina);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoprocesonomina = new  TipoProcesoNomina();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoNomina.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoprocesonomina=tipoprocesonominaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprocesonomina,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProcesoNominaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoNomina(this.tipoprocesonomina);
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
		tipoprocesonomina = new  TipoProcesoNomina();
		  		  
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
		tipoprocesonomina = new  TipoProcesoNomina();
		  		  
        try {
			
			tipoprocesonomina=tipoprocesonominaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprocesonomina,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProcesoNominaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoNomina(this.tipoprocesonomina);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoprocesonomina = new  TipoProcesoNomina();
		  		  
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
		tipoprocesonomina = new  TipoProcesoNomina();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoNomina.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoprocesonominaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprocesonomina = new  TipoProcesoNomina();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoprocesonominaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoprocesonomina = new  TipoProcesoNomina();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoNomina.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoprocesonominaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprocesonomina = new  TipoProcesoNomina();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoprocesonominaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoprocesonomina = new  TipoProcesoNomina();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoNomina.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoprocesonominaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprocesonomina = new  TipoProcesoNomina();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoprocesonominaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoprocesonominas = new  ArrayList<TipoProcesoNomina>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoNomina.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoProcesoNominaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesonominas=tipoprocesonominaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProcesoNomina(tipoprocesonominas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoNominaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoNomina(this.tipoprocesonominas);
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
		tipoprocesonominas = new  ArrayList<TipoProcesoNomina>();
		  		  
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
		tipoprocesonominas = new  ArrayList<TipoProcesoNomina>();
		  		  
        try {			
			TipoProcesoNominaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesonominas=tipoprocesonominaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoProcesoNomina(tipoprocesonominas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoNominaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoNomina(this.tipoprocesonominas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoprocesonominas = new  ArrayList<TipoProcesoNomina>();
		  		  
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
		tipoprocesonominas = new  ArrayList<TipoProcesoNomina>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoNomina.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoProcesoNominaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesonominas=tipoprocesonominaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProcesoNomina(tipoprocesonominas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoNominaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoNomina(this.tipoprocesonominas);
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
		tipoprocesonominas = new  ArrayList<TipoProcesoNomina>();
		  		  
        try {
			TipoProcesoNominaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesonominas=tipoprocesonominaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProcesoNomina(tipoprocesonominas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoNominaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoNomina(this.tipoprocesonominas);
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
		tipoprocesonominas = new  ArrayList<TipoProcesoNomina>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoNomina.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProcesoNominaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesonominas=tipoprocesonominaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProcesoNomina(tipoprocesonominas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoNominaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoNomina(this.tipoprocesonominas);
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
		tipoprocesonominas = new  ArrayList<TipoProcesoNomina>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProcesoNominaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesonominas=tipoprocesonominaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProcesoNomina(tipoprocesonominas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoNominaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoNomina(this.tipoprocesonominas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoprocesonomina = new  TipoProcesoNomina();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoNomina.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProcesoNominaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesonomina=tipoprocesonominaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProcesoNomina(tipoprocesonomina);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoNominaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoNomina(this.tipoprocesonomina);
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
		tipoprocesonomina = new  TipoProcesoNomina();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProcesoNominaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesonomina=tipoprocesonominaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProcesoNomina(tipoprocesonomina);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoNominaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoNomina(this.tipoprocesonomina);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoProcesoNominasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoprocesonominas = new  ArrayList<TipoProcesoNomina>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoNomina.class.getSimpleName()+"-getTodosTipoProcesoNominasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProcesoNominaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesonominas=tipoprocesonominaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoProcesoNomina(tipoprocesonominas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoNominaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoNomina(this.tipoprocesonominas);
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
	
	public  void  getTodosTipoProcesoNominas(String sFinalQuery,Pagination pagination)throws Exception {
		tipoprocesonominas = new  ArrayList<TipoProcesoNomina>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProcesoNominaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprocesonominas=tipoprocesonominaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoProcesoNomina(tipoprocesonominas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProcesoNominaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoNomina(this.tipoprocesonominas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoProcesoNomina(TipoProcesoNomina tipoprocesonomina) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoprocesonomina.getIsNew() || tipoprocesonomina.getIsChanged()) { 
			this.invalidValues = tipoprocesonominaValidator.getInvalidValues(tipoprocesonomina);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoprocesonomina);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoProcesoNomina(List<TipoProcesoNomina> TipoProcesoNominas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoProcesoNomina tipoprocesonominaLocal:tipoprocesonominas) {				
			estaValidadoObjeto=this.validarGuardarTipoProcesoNomina(tipoprocesonominaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoProcesoNomina(List<TipoProcesoNomina> TipoProcesoNominas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoProcesoNomina(tipoprocesonominas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoProcesoNomina(TipoProcesoNomina TipoProcesoNomina) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoProcesoNomina(tipoprocesonomina)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoProcesoNomina tipoprocesonomina) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoprocesonomina.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoProcesoNominaConstantesFunciones.getTipoProcesoNominaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoprocesonomina","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoProcesoNominaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoProcesoNominaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoProcesoNominaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoNomina.class.getSimpleName()+"-saveTipoProcesoNominaWithConnection");connexion.begin();			
			
			//TipoProcesoNominaLogicAdditional.checkTipoProcesoNominaToSave(this.tipoprocesonomina,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoProcesoNominaLogicAdditional.updateTipoProcesoNominaToSave(this.tipoprocesonomina,this.arrDatoGeneral);
			
			TipoProcesoNominaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoprocesonomina,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoProcesoNomina();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoProcesoNomina(this.tipoprocesonomina)) {
				TipoProcesoNominaDataAccess.save(this.tipoprocesonomina, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoprocesonomina,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoProcesoNominaLogicAdditional.checkTipoProcesoNominaToSaveAfter(this.tipoprocesonomina,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoProcesoNomina();
			
			connexion.commit();			
			
			if(this.tipoprocesonomina.getIsDeleted()) {
				this.tipoprocesonomina=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoProcesoNomina()throws Exception {	
		try {	
			
			//TipoProcesoNominaLogicAdditional.checkTipoProcesoNominaToSave(this.tipoprocesonomina,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoProcesoNominaLogicAdditional.updateTipoProcesoNominaToSave(this.tipoprocesonomina,this.arrDatoGeneral);
			
			TipoProcesoNominaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoprocesonomina,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoProcesoNomina(this.tipoprocesonomina)) {			
				TipoProcesoNominaDataAccess.save(this.tipoprocesonomina, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoprocesonomina,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoProcesoNominaLogicAdditional.checkTipoProcesoNominaToSaveAfter(this.tipoprocesonomina,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoprocesonomina.getIsDeleted()) {
				this.tipoprocesonomina=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoProcesoNominasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoNomina.class.getSimpleName()+"-saveTipoProcesoNominasWithConnection");connexion.begin();			
			
			//TipoProcesoNominaLogicAdditional.checkTipoProcesoNominaToSaves(tipoprocesonominas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoProcesoNominas();
			
			Boolean validadoTodosTipoProcesoNomina=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoProcesoNomina tipoprocesonominaLocal:tipoprocesonominas) {		
				if(tipoprocesonominaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoProcesoNominaLogicAdditional.updateTipoProcesoNominaToSave(tipoprocesonominaLocal,this.arrDatoGeneral);
	        	
				TipoProcesoNominaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoprocesonominaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoProcesoNomina(tipoprocesonominaLocal)) {
					TipoProcesoNominaDataAccess.save(tipoprocesonominaLocal, connexion);				
				} else {
					validadoTodosTipoProcesoNomina=false;
				}
			}
			
			if(!validadoTodosTipoProcesoNomina) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoProcesoNominaLogicAdditional.checkTipoProcesoNominaToSavesAfter(tipoprocesonominas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoProcesoNominas();
			
			connexion.commit();		
			
			this.quitarTipoProcesoNominasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoProcesoNominas()throws Exception {				
		 try {	
			//TipoProcesoNominaLogicAdditional.checkTipoProcesoNominaToSaves(tipoprocesonominas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoProcesoNomina=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoProcesoNomina tipoprocesonominaLocal:tipoprocesonominas) {				
				if(tipoprocesonominaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoProcesoNominaLogicAdditional.updateTipoProcesoNominaToSave(tipoprocesonominaLocal,this.arrDatoGeneral);
	        	
				TipoProcesoNominaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoprocesonominaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoProcesoNomina(tipoprocesonominaLocal)) {				
					TipoProcesoNominaDataAccess.save(tipoprocesonominaLocal, connexion);				
				} else {
					validadoTodosTipoProcesoNomina=false;
				}
			}
			
			if(!validadoTodosTipoProcesoNomina) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoProcesoNominaLogicAdditional.checkTipoProcesoNominaToSavesAfter(tipoprocesonominas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoProcesoNominasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoProcesoNominaParameterReturnGeneral procesarAccionTipoProcesoNominas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoProcesoNomina> tipoprocesonominas,TipoProcesoNominaParameterReturnGeneral tipoprocesonominaParameterGeneral)throws Exception {
		 try {	
			TipoProcesoNominaParameterReturnGeneral tipoprocesonominaReturnGeneral=new TipoProcesoNominaParameterReturnGeneral();
	
			
			return tipoprocesonominaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoProcesoNominaParameterReturnGeneral procesarAccionTipoProcesoNominasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoProcesoNomina> tipoprocesonominas,TipoProcesoNominaParameterReturnGeneral tipoprocesonominaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoNomina.class.getSimpleName()+"-procesarAccionTipoProcesoNominasWithConnection");connexion.begin();			
			
			TipoProcesoNominaParameterReturnGeneral tipoprocesonominaReturnGeneral=new TipoProcesoNominaParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipoprocesonominaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoProcesoNominaParameterReturnGeneral procesarEventosTipoProcesoNominas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoProcesoNomina> tipoprocesonominas,TipoProcesoNomina tipoprocesonomina,TipoProcesoNominaParameterReturnGeneral tipoprocesonominaParameterGeneral,Boolean isEsNuevoTipoProcesoNomina,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoProcesoNominaParameterReturnGeneral tipoprocesonominaReturnGeneral=new TipoProcesoNominaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoprocesonominaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipoprocesonominaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoProcesoNominaParameterReturnGeneral procesarEventosTipoProcesoNominasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoProcesoNomina> tipoprocesonominas,TipoProcesoNomina tipoprocesonomina,TipoProcesoNominaParameterReturnGeneral tipoprocesonominaParameterGeneral,Boolean isEsNuevoTipoProcesoNomina,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoNomina.class.getSimpleName()+"-procesarEventosTipoProcesoNominasWithConnection");connexion.begin();			
			
			TipoProcesoNominaParameterReturnGeneral tipoprocesonominaReturnGeneral=new TipoProcesoNominaParameterReturnGeneral();
	
			tipoprocesonominaReturnGeneral.setTipoProcesoNomina(tipoprocesonomina);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoprocesonominaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipoprocesonominaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoProcesoNominaParameterReturnGeneral procesarImportacionTipoProcesoNominasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoProcesoNominaParameterReturnGeneral tipoprocesonominaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProcesoNomina.class.getSimpleName()+"-procesarImportacionTipoProcesoNominasWithConnection");connexion.begin();			
			
			TipoProcesoNominaParameterReturnGeneral tipoprocesonominaReturnGeneral=new TipoProcesoNominaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoprocesonominas=new ArrayList<TipoProcesoNomina>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoprocesonomina=new TipoProcesoNomina();
				
				
				if(conColumnasBase) {this.tipoprocesonomina.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoprocesonomina.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoprocesonomina.setcodigo(arrColumnas[iColumn++]);
				this.tipoprocesonomina.setnombre(arrColumnas[iColumn++]);
				
				this.tipoprocesonominas.add(this.tipoprocesonomina);
			}
			
			this.saveTipoProcesoNominas();
			
			this.connexion.commit();
			
			tipoprocesonominaReturnGeneral.setConRetornoEstaProcesado(true);
			tipoprocesonominaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoprocesonominaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoProcesoNominasEliminados() throws Exception {				
		
		List<TipoProcesoNomina> tipoprocesonominasAux= new ArrayList<TipoProcesoNomina>();
		
		for(TipoProcesoNomina tipoprocesonomina:tipoprocesonominas) {
			if(!tipoprocesonomina.getIsDeleted()) {
				tipoprocesonominasAux.add(tipoprocesonomina);
			}
		}
		
		tipoprocesonominas=tipoprocesonominasAux;
	}
	
	public void quitarTipoProcesoNominasNulos() throws Exception {				
		
		List<TipoProcesoNomina> tipoprocesonominasAux= new ArrayList<TipoProcesoNomina>();
		
		for(TipoProcesoNomina tipoprocesonomina : this.tipoprocesonominas) {
			if(tipoprocesonomina==null) {
				tipoprocesonominasAux.add(tipoprocesonomina);
			}
		}
		
		//this.tipoprocesonominas=tipoprocesonominasAux;
		
		this.tipoprocesonominas.removeAll(tipoprocesonominasAux);
	}
	
	public void getSetVersionRowTipoProcesoNominaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoprocesonomina.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoprocesonomina.getIsDeleted() || (tipoprocesonomina.getIsChanged()&&!tipoprocesonomina.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoprocesonominaDataAccess.getSetVersionRowTipoProcesoNomina(connexion,tipoprocesonomina.getId());
				
				if(!tipoprocesonomina.getVersionRow().equals(timestamp)) {	
					tipoprocesonomina.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoprocesonomina.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoProcesoNomina()throws Exception {	
		
		if(tipoprocesonomina.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoprocesonomina.getIsDeleted() || (tipoprocesonomina.getIsChanged()&&!tipoprocesonomina.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoprocesonominaDataAccess.getSetVersionRowTipoProcesoNomina(connexion,tipoprocesonomina.getId());
			
			try {							
				if(!tipoprocesonomina.getVersionRow().equals(timestamp)) {	
					tipoprocesonomina.setVersionRow(timestamp);
				}
				
				tipoprocesonomina.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoProcesoNominasWithConnection()throws Exception {	
		if(tipoprocesonominas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoProcesoNomina tipoprocesonominaAux:tipoprocesonominas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoprocesonominaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoprocesonominaAux.getIsDeleted() || (tipoprocesonominaAux.getIsChanged()&&!tipoprocesonominaAux.getIsNew())) {
						
						timestamp=tipoprocesonominaDataAccess.getSetVersionRowTipoProcesoNomina(connexion,tipoprocesonominaAux.getId());
						
						if(!tipoprocesonomina.getVersionRow().equals(timestamp)) {	
							tipoprocesonominaAux.setVersionRow(timestamp);
						}
								
						tipoprocesonominaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoProcesoNominas()throws Exception {	
		if(tipoprocesonominas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoProcesoNomina tipoprocesonominaAux:tipoprocesonominas) {
					if(tipoprocesonominaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoprocesonominaAux.getIsDeleted() || (tipoprocesonominaAux.getIsChanged()&&!tipoprocesonominaAux.getIsNew())) {
						
						timestamp=tipoprocesonominaDataAccess.getSetVersionRowTipoProcesoNomina(connexion,tipoprocesonominaAux.getId());
						
						if(!tipoprocesonominaAux.getVersionRow().equals(timestamp)) {	
							tipoprocesonominaAux.setVersionRow(timestamp);
						}
						
													
						tipoprocesonominaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(TipoProcesoNomina tipoprocesonomina,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		
		
		try {
			//TipoProcesoNominaLogicAdditional.updateTipoProcesoNominaToGet(tipoprocesonomina,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoProcesoNomina tipoprocesonomina,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
				
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoProcesoNomina.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoprocesonomina,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoProcesoNominaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoNomina(tipoprocesonomina);
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
			this.deepLoad(this.tipoprocesonomina,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoProcesoNominaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoNomina(this.tipoprocesonomina);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoProcesoNomina.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoprocesonominas!=null) {
				for(TipoProcesoNomina tipoprocesonomina:tipoprocesonominas) {
					this.deepLoad(tipoprocesonomina,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoProcesoNominaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoNomina(tipoprocesonominas);
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
			if(tipoprocesonominas!=null) {
				for(TipoProcesoNomina tipoprocesonomina:tipoprocesonominas) {
					this.deepLoad(tipoprocesonomina,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoProcesoNominaConstantesFunciones.refrescarForeignKeysDescripcionesTipoProcesoNomina(tipoprocesonominas);
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
			if(TipoProcesoNominaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProcesoNominaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoProcesoNomina tipoprocesonomina,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoProcesoNominaConstantesFunciones.ISCONAUDITORIA) {
				if(tipoprocesonomina.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProcesoNominaDataAccess.TABLENAME, tipoprocesonomina.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoProcesoNominaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoProcesoNominaLogic.registrarAuditoriaDetallesTipoProcesoNomina(connexion,tipoprocesonomina,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoprocesonomina.getIsDeleted()) {
					/*if(!tipoprocesonomina.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoProcesoNominaDataAccess.TABLENAME, tipoprocesonomina.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoProcesoNominaLogic.registrarAuditoriaDetallesTipoProcesoNomina(connexion,tipoprocesonomina,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProcesoNominaDataAccess.TABLENAME, tipoprocesonomina.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoprocesonomina.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProcesoNominaDataAccess.TABLENAME, tipoprocesonomina.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoProcesoNominaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoProcesoNominaLogic.registrarAuditoriaDetallesTipoProcesoNomina(connexion,tipoprocesonomina,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoProcesoNomina(Connexion connexion,TipoProcesoNomina tipoprocesonomina)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoprocesonomina.getIsNew()||!tipoprocesonomina.getcodigo().equals(tipoprocesonomina.getTipoProcesoNominaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprocesonomina.getTipoProcesoNominaOriginal().getcodigo()!=null)
				{
					strValorActual=tipoprocesonomina.getTipoProcesoNominaOriginal().getcodigo();
				}
				if(tipoprocesonomina.getcodigo()!=null)
				{
					strValorNuevo=tipoprocesonomina.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProcesoNominaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoprocesonomina.getIsNew()||!tipoprocesonomina.getnombre().equals(tipoprocesonomina.getTipoProcesoNominaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprocesonomina.getTipoProcesoNominaOriginal().getnombre()!=null)
				{
					strValorActual=tipoprocesonomina.getTipoProcesoNominaOriginal().getnombre();
				}
				if(tipoprocesonomina.getnombre()!=null)
				{
					strValorNuevo=tipoprocesonomina.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProcesoNominaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoProcesoNomina(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoProcesoNominaConstantesFunciones.getClassesForeignKeysOfTipoProcesoNomina(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProcesoNomina(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoProcesoNominaConstantesFunciones.getClassesRelationshipsOfTipoProcesoNomina(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

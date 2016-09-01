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
package com.bydan.erp.sris.business.logic;

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
import com.bydan.erp.sris.util.*;
import com.bydan.erp.sris.util.TipoSalarioNetoConstantesFunciones;
import com.bydan.erp.sris.util.TipoSalarioNetoParameterReturnGeneral;
//import com.bydan.erp.sris.util.TipoSalarioNetoParameterGeneral;
import com.bydan.erp.sris.business.entity.TipoSalarioNeto;
import com.bydan.erp.sris.business.logic.TipoSalarioNetoLogicAdditional;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.sris.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoSalarioNetoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoSalarioNetoLogic.class);
	
	protected TipoSalarioNetoDataAccess tiposalarionetoDataAccess; 	
	protected TipoSalarioNeto tiposalarioneto;
	protected List<TipoSalarioNeto> tiposalarionetos;
	protected Object tiposalarionetoObject;	
	protected List<Object> tiposalarionetosObject;
	
	public static ClassValidator<TipoSalarioNeto> tiposalarionetoValidator = new ClassValidator<TipoSalarioNeto>(TipoSalarioNeto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoSalarioNetoLogicAdditional tiposalarionetoLogicAdditional=null;
	
	public TipoSalarioNetoLogicAdditional getTipoSalarioNetoLogicAdditional() {
		return this.tiposalarionetoLogicAdditional;
	}
	
	public void setTipoSalarioNetoLogicAdditional(TipoSalarioNetoLogicAdditional tiposalarionetoLogicAdditional) {
		try {
			this.tiposalarionetoLogicAdditional=tiposalarionetoLogicAdditional;
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
	
	
	
	
	public  TipoSalarioNetoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tiposalarionetoDataAccess = new TipoSalarioNetoDataAccess();
			
			this.tiposalarionetos= new ArrayList<TipoSalarioNeto>();
			this.tiposalarioneto= new TipoSalarioNeto();
			
			this.tiposalarionetoObject=new Object();
			this.tiposalarionetosObject=new ArrayList<Object>();
				
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
			
			this.tiposalarionetoDataAccess.setConnexionType(this.connexionType);
			this.tiposalarionetoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoSalarioNetoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tiposalarionetoDataAccess = new TipoSalarioNetoDataAccess();
			this.tiposalarionetos= new ArrayList<TipoSalarioNeto>();
			this.tiposalarioneto= new TipoSalarioNeto();
			this.tiposalarionetoObject=new Object();
			this.tiposalarionetosObject=new ArrayList<Object>();
			
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
			
			this.tiposalarionetoDataAccess.setConnexionType(this.connexionType);
			this.tiposalarionetoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoSalarioNeto getTipoSalarioNeto() throws Exception {	
		TipoSalarioNetoLogicAdditional.checkTipoSalarioNetoToGet(tiposalarioneto,this.datosCliente,this.arrDatoGeneral);
		TipoSalarioNetoLogicAdditional.updateTipoSalarioNetoToGet(tiposalarioneto,this.arrDatoGeneral);
		
		return tiposalarioneto;
	}
		
	public void setTipoSalarioNeto(TipoSalarioNeto newTipoSalarioNeto) {
		this.tiposalarioneto = newTipoSalarioNeto;
	}
	
	public TipoSalarioNetoDataAccess getTipoSalarioNetoDataAccess() {
		return tiposalarionetoDataAccess;
	}
	
	public void setTipoSalarioNetoDataAccess(TipoSalarioNetoDataAccess newtiposalarionetoDataAccess) {
		this.tiposalarionetoDataAccess = newtiposalarionetoDataAccess;
	}
	
	public List<TipoSalarioNeto> getTipoSalarioNetos() throws Exception {		
		this.quitarTipoSalarioNetosNulos();
		
		TipoSalarioNetoLogicAdditional.checkTipoSalarioNetoToGets(tiposalarionetos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoSalarioNeto tiposalarionetoLocal: tiposalarionetos ) {
			TipoSalarioNetoLogicAdditional.updateTipoSalarioNetoToGet(tiposalarionetoLocal,this.arrDatoGeneral);
		}
		
		return tiposalarionetos;
	}
	
	public void setTipoSalarioNetos(List<TipoSalarioNeto> newTipoSalarioNetos) {
		this.tiposalarionetos = newTipoSalarioNetos;
	}
	
	public Object getTipoSalarioNetoObject() {	
		this.tiposalarionetoObject=this.tiposalarionetoDataAccess.getEntityObject();
		return this.tiposalarionetoObject;
	}
		
	public void setTipoSalarioNetoObject(Object newTipoSalarioNetoObject) {
		this.tiposalarionetoObject = newTipoSalarioNetoObject;
	}
	
	public List<Object> getTipoSalarioNetosObject() {		
		this.tiposalarionetosObject=this.tiposalarionetoDataAccess.getEntitiesObject();
		return this.tiposalarionetosObject;
	}
		
	public void setTipoSalarioNetosObject(List<Object> newTipoSalarioNetosObject) {
		this.tiposalarionetosObject = newTipoSalarioNetosObject;
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
		
		if(this.tiposalarionetoDataAccess!=null) {
			this.tiposalarionetoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSalarioNeto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tiposalarionetoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tiposalarionetoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tiposalarioneto = new  TipoSalarioNeto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSalarioNeto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiposalarioneto=tiposalarionetoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiposalarioneto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoSalarioNetoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSalarioNeto(this.tiposalarioneto);
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
		tiposalarioneto = new  TipoSalarioNeto();
		  		  
        try {
			
			tiposalarioneto=tiposalarionetoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiposalarioneto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoSalarioNetoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSalarioNeto(this.tiposalarioneto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tiposalarioneto = new  TipoSalarioNeto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSalarioNeto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiposalarioneto=tiposalarionetoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiposalarioneto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoSalarioNetoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSalarioNeto(this.tiposalarioneto);
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
		tiposalarioneto = new  TipoSalarioNeto();
		  		  
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
		tiposalarioneto = new  TipoSalarioNeto();
		  		  
        try {
			
			tiposalarioneto=tiposalarionetoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiposalarioneto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoSalarioNetoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSalarioNeto(this.tiposalarioneto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tiposalarioneto = new  TipoSalarioNeto();
		  		  
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
		tiposalarioneto = new  TipoSalarioNeto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSalarioNeto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tiposalarionetoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiposalarioneto = new  TipoSalarioNeto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tiposalarionetoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiposalarioneto = new  TipoSalarioNeto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSalarioNeto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tiposalarionetoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiposalarioneto = new  TipoSalarioNeto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tiposalarionetoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiposalarioneto = new  TipoSalarioNeto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSalarioNeto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tiposalarionetoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiposalarioneto = new  TipoSalarioNeto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tiposalarionetoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiposalarionetos = new  ArrayList<TipoSalarioNeto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSalarioNeto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoSalarioNetoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposalarionetos=tiposalarionetoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoSalarioNeto(tiposalarionetos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSalarioNetoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSalarioNeto(this.tiposalarionetos);
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
		tiposalarionetos = new  ArrayList<TipoSalarioNeto>();
		  		  
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
		tiposalarionetos = new  ArrayList<TipoSalarioNeto>();
		  		  
        try {			
			TipoSalarioNetoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposalarionetos=tiposalarionetoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoSalarioNeto(tiposalarionetos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSalarioNetoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSalarioNeto(this.tiposalarionetos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tiposalarionetos = new  ArrayList<TipoSalarioNeto>();
		  		  
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
		tiposalarionetos = new  ArrayList<TipoSalarioNeto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSalarioNeto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoSalarioNetoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposalarionetos=tiposalarionetoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoSalarioNeto(tiposalarionetos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSalarioNetoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSalarioNeto(this.tiposalarionetos);
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
		tiposalarionetos = new  ArrayList<TipoSalarioNeto>();
		  		  
        try {
			TipoSalarioNetoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposalarionetos=tiposalarionetoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoSalarioNeto(tiposalarionetos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSalarioNetoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSalarioNeto(this.tiposalarionetos);
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
		tiposalarionetos = new  ArrayList<TipoSalarioNeto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSalarioNeto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoSalarioNetoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposalarionetos=tiposalarionetoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoSalarioNeto(tiposalarionetos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSalarioNetoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSalarioNeto(this.tiposalarionetos);
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
		tiposalarionetos = new  ArrayList<TipoSalarioNeto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoSalarioNetoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposalarionetos=tiposalarionetoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoSalarioNeto(tiposalarionetos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSalarioNetoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSalarioNeto(this.tiposalarionetos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tiposalarioneto = new  TipoSalarioNeto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSalarioNeto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoSalarioNetoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposalarioneto=tiposalarionetoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoSalarioNeto(tiposalarioneto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSalarioNetoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSalarioNeto(this.tiposalarioneto);
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
		tiposalarioneto = new  TipoSalarioNeto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoSalarioNetoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposalarioneto=tiposalarionetoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoSalarioNeto(tiposalarioneto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSalarioNetoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSalarioNeto(this.tiposalarioneto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoSalarioNetosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tiposalarionetos = new  ArrayList<TipoSalarioNeto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSalarioNeto.class.getSimpleName()+"-getTodosTipoSalarioNetosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoSalarioNetoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposalarionetos=tiposalarionetoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoSalarioNeto(tiposalarionetos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSalarioNetoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSalarioNeto(this.tiposalarionetos);
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
	
	public  void  getTodosTipoSalarioNetos(String sFinalQuery,Pagination pagination)throws Exception {
		tiposalarionetos = new  ArrayList<TipoSalarioNeto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoSalarioNetoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiposalarionetos=tiposalarionetoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoSalarioNeto(tiposalarionetos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoSalarioNetoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSalarioNeto(this.tiposalarionetos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoSalarioNeto(TipoSalarioNeto tiposalarioneto) throws Exception {
		Boolean estaValidado=false;
		
		if(tiposalarioneto.getIsNew() || tiposalarioneto.getIsChanged()) { 
			this.invalidValues = tiposalarionetoValidator.getInvalidValues(tiposalarioneto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tiposalarioneto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoSalarioNeto(List<TipoSalarioNeto> TipoSalarioNetos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoSalarioNeto tiposalarionetoLocal:tiposalarionetos) {				
			estaValidadoObjeto=this.validarGuardarTipoSalarioNeto(tiposalarionetoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoSalarioNeto(List<TipoSalarioNeto> TipoSalarioNetos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoSalarioNeto(tiposalarionetos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoSalarioNeto(TipoSalarioNeto TipoSalarioNeto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoSalarioNeto(tiposalarioneto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoSalarioNeto tiposalarioneto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tiposalarioneto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoSalarioNetoConstantesFunciones.getTipoSalarioNetoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tiposalarioneto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoSalarioNetoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoSalarioNetoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoSalarioNetoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSalarioNeto.class.getSimpleName()+"-saveTipoSalarioNetoWithConnection");connexion.begin();			
			
			TipoSalarioNetoLogicAdditional.checkTipoSalarioNetoToSave(this.tiposalarioneto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoSalarioNetoLogicAdditional.updateTipoSalarioNetoToSave(this.tiposalarioneto,this.arrDatoGeneral);
			
			TipoSalarioNetoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiposalarioneto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoSalarioNeto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoSalarioNeto(this.tiposalarioneto)) {
				TipoSalarioNetoDataAccess.save(this.tiposalarioneto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tiposalarioneto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoSalarioNetoLogicAdditional.checkTipoSalarioNetoToSaveAfter(this.tiposalarioneto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoSalarioNeto();
			
			connexion.commit();			
			
			if(this.tiposalarioneto.getIsDeleted()) {
				this.tiposalarioneto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoSalarioNeto()throws Exception {	
		try {	
			
			TipoSalarioNetoLogicAdditional.checkTipoSalarioNetoToSave(this.tiposalarioneto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoSalarioNetoLogicAdditional.updateTipoSalarioNetoToSave(this.tiposalarioneto,this.arrDatoGeneral);
			
			TipoSalarioNetoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiposalarioneto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoSalarioNeto(this.tiposalarioneto)) {			
				TipoSalarioNetoDataAccess.save(this.tiposalarioneto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tiposalarioneto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoSalarioNetoLogicAdditional.checkTipoSalarioNetoToSaveAfter(this.tiposalarioneto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tiposalarioneto.getIsDeleted()) {
				this.tiposalarioneto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoSalarioNetosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSalarioNeto.class.getSimpleName()+"-saveTipoSalarioNetosWithConnection");connexion.begin();			
			
			TipoSalarioNetoLogicAdditional.checkTipoSalarioNetoToSaves(tiposalarionetos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoSalarioNetos();
			
			Boolean validadoTodosTipoSalarioNeto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoSalarioNeto tiposalarionetoLocal:tiposalarionetos) {		
				if(tiposalarionetoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoSalarioNetoLogicAdditional.updateTipoSalarioNetoToSave(tiposalarionetoLocal,this.arrDatoGeneral);
	        	
				TipoSalarioNetoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiposalarionetoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoSalarioNeto(tiposalarionetoLocal)) {
					TipoSalarioNetoDataAccess.save(tiposalarionetoLocal, connexion);				
				} else {
					validadoTodosTipoSalarioNeto=false;
				}
			}
			
			if(!validadoTodosTipoSalarioNeto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoSalarioNetoLogicAdditional.checkTipoSalarioNetoToSavesAfter(tiposalarionetos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoSalarioNetos();
			
			connexion.commit();		
			
			this.quitarTipoSalarioNetosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoSalarioNetos()throws Exception {				
		 try {	
			TipoSalarioNetoLogicAdditional.checkTipoSalarioNetoToSaves(tiposalarionetos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoSalarioNeto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoSalarioNeto tiposalarionetoLocal:tiposalarionetos) {				
				if(tiposalarionetoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoSalarioNetoLogicAdditional.updateTipoSalarioNetoToSave(tiposalarionetoLocal,this.arrDatoGeneral);
	        	
				TipoSalarioNetoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiposalarionetoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoSalarioNeto(tiposalarionetoLocal)) {				
					TipoSalarioNetoDataAccess.save(tiposalarionetoLocal, connexion);				
				} else {
					validadoTodosTipoSalarioNeto=false;
				}
			}
			
			if(!validadoTodosTipoSalarioNeto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoSalarioNetoLogicAdditional.checkTipoSalarioNetoToSavesAfter(tiposalarionetos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoSalarioNetosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoSalarioNetoParameterReturnGeneral procesarAccionTipoSalarioNetos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoSalarioNeto> tiposalarionetos,TipoSalarioNetoParameterReturnGeneral tiposalarionetoParameterGeneral)throws Exception {
		 try {	
			TipoSalarioNetoParameterReturnGeneral tiposalarionetoReturnGeneral=new TipoSalarioNetoParameterReturnGeneral();
	
			TipoSalarioNetoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiposalarionetos,tiposalarionetoParameterGeneral,tiposalarionetoReturnGeneral);
			
			return tiposalarionetoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoSalarioNetoParameterReturnGeneral procesarAccionTipoSalarioNetosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoSalarioNeto> tiposalarionetos,TipoSalarioNetoParameterReturnGeneral tiposalarionetoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSalarioNeto.class.getSimpleName()+"-procesarAccionTipoSalarioNetosWithConnection");connexion.begin();			
			
			TipoSalarioNetoParameterReturnGeneral tiposalarionetoReturnGeneral=new TipoSalarioNetoParameterReturnGeneral();
	
			TipoSalarioNetoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiposalarionetos,tiposalarionetoParameterGeneral,tiposalarionetoReturnGeneral);
			
			this.connexion.commit();
			
			return tiposalarionetoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoSalarioNetoParameterReturnGeneral procesarEventosTipoSalarioNetos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoSalarioNeto> tiposalarionetos,TipoSalarioNeto tiposalarioneto,TipoSalarioNetoParameterReturnGeneral tiposalarionetoParameterGeneral,Boolean isEsNuevoTipoSalarioNeto,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoSalarioNetoParameterReturnGeneral tiposalarionetoReturnGeneral=new TipoSalarioNetoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiposalarionetoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoSalarioNetoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiposalarionetos,tiposalarioneto,tiposalarionetoParameterGeneral,tiposalarionetoReturnGeneral,isEsNuevoTipoSalarioNeto,clases);
			
			return tiposalarionetoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoSalarioNetoParameterReturnGeneral procesarEventosTipoSalarioNetosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoSalarioNeto> tiposalarionetos,TipoSalarioNeto tiposalarioneto,TipoSalarioNetoParameterReturnGeneral tiposalarionetoParameterGeneral,Boolean isEsNuevoTipoSalarioNeto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSalarioNeto.class.getSimpleName()+"-procesarEventosTipoSalarioNetosWithConnection");connexion.begin();			
			
			TipoSalarioNetoParameterReturnGeneral tiposalarionetoReturnGeneral=new TipoSalarioNetoParameterReturnGeneral();
	
			tiposalarionetoReturnGeneral.setTipoSalarioNeto(tiposalarioneto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiposalarionetoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoSalarioNetoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiposalarionetos,tiposalarioneto,tiposalarionetoParameterGeneral,tiposalarionetoReturnGeneral,isEsNuevoTipoSalarioNeto,clases);
			
			this.connexion.commit();
			
			return tiposalarionetoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoSalarioNetoParameterReturnGeneral procesarImportacionTipoSalarioNetosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoSalarioNetoParameterReturnGeneral tiposalarionetoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoSalarioNeto.class.getSimpleName()+"-procesarImportacionTipoSalarioNetosWithConnection");connexion.begin();			
			
			TipoSalarioNetoParameterReturnGeneral tiposalarionetoReturnGeneral=new TipoSalarioNetoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tiposalarionetos=new ArrayList<TipoSalarioNeto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tiposalarioneto=new TipoSalarioNeto();
				
				
				if(conColumnasBase) {this.tiposalarioneto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tiposalarioneto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tiposalarioneto.setnombre(arrColumnas[iColumn++]);
			this.tiposalarioneto.setdescripcion(arrColumnas[iColumn++]);
				
				this.tiposalarionetos.add(this.tiposalarioneto);
			}
			
			this.saveTipoSalarioNetos();
			
			this.connexion.commit();
			
			tiposalarionetoReturnGeneral.setConRetornoEstaProcesado(true);
			tiposalarionetoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tiposalarionetoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoSalarioNetosEliminados() throws Exception {				
		
		List<TipoSalarioNeto> tiposalarionetosAux= new ArrayList<TipoSalarioNeto>();
		
		for(TipoSalarioNeto tiposalarioneto:tiposalarionetos) {
			if(!tiposalarioneto.getIsDeleted()) {
				tiposalarionetosAux.add(tiposalarioneto);
			}
		}
		
		tiposalarionetos=tiposalarionetosAux;
	}
	
	public void quitarTipoSalarioNetosNulos() throws Exception {				
		
		List<TipoSalarioNeto> tiposalarionetosAux= new ArrayList<TipoSalarioNeto>();
		
		for(TipoSalarioNeto tiposalarioneto : this.tiposalarionetos) {
			if(tiposalarioneto==null) {
				tiposalarionetosAux.add(tiposalarioneto);
			}
		}
		
		//this.tiposalarionetos=tiposalarionetosAux;
		
		this.tiposalarionetos.removeAll(tiposalarionetosAux);
	}
	
	public void getSetVersionRowTipoSalarioNetoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tiposalarioneto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tiposalarioneto.getIsDeleted() || (tiposalarioneto.getIsChanged()&&!tiposalarioneto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tiposalarionetoDataAccess.getSetVersionRowTipoSalarioNeto(connexion,tiposalarioneto.getId());
				
				if(!tiposalarioneto.getVersionRow().equals(timestamp)) {	
					tiposalarioneto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tiposalarioneto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoSalarioNeto()throws Exception {	
		
		if(tiposalarioneto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tiposalarioneto.getIsDeleted() || (tiposalarioneto.getIsChanged()&&!tiposalarioneto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tiposalarionetoDataAccess.getSetVersionRowTipoSalarioNeto(connexion,tiposalarioneto.getId());
			
			try {							
				if(!tiposalarioneto.getVersionRow().equals(timestamp)) {	
					tiposalarioneto.setVersionRow(timestamp);
				}
				
				tiposalarioneto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoSalarioNetosWithConnection()throws Exception {	
		if(tiposalarionetos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoSalarioNeto tiposalarionetoAux:tiposalarionetos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tiposalarionetoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiposalarionetoAux.getIsDeleted() || (tiposalarionetoAux.getIsChanged()&&!tiposalarionetoAux.getIsNew())) {
						
						timestamp=tiposalarionetoDataAccess.getSetVersionRowTipoSalarioNeto(connexion,tiposalarionetoAux.getId());
						
						if(!tiposalarioneto.getVersionRow().equals(timestamp)) {	
							tiposalarionetoAux.setVersionRow(timestamp);
						}
								
						tiposalarionetoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoSalarioNetos()throws Exception {	
		if(tiposalarionetos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoSalarioNeto tiposalarionetoAux:tiposalarionetos) {
					if(tiposalarionetoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiposalarionetoAux.getIsDeleted() || (tiposalarionetoAux.getIsChanged()&&!tiposalarionetoAux.getIsNew())) {
						
						timestamp=tiposalarionetoDataAccess.getSetVersionRowTipoSalarioNeto(connexion,tiposalarionetoAux.getId());
						
						if(!tiposalarionetoAux.getVersionRow().equals(timestamp)) {	
							tiposalarionetoAux.setVersionRow(timestamp);
						}
						
													
						tiposalarionetoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(TipoSalarioNeto tiposalarioneto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		
		
		try {
			TipoSalarioNetoLogicAdditional.updateTipoSalarioNetoToGet(tiposalarioneto,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoSalarioNeto tiposalarioneto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
				
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoSalarioNeto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tiposalarioneto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoSalarioNetoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSalarioNeto(tiposalarioneto);
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
			this.deepLoad(this.tiposalarioneto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoSalarioNetoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSalarioNeto(this.tiposalarioneto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoSalarioNeto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tiposalarionetos!=null) {
				for(TipoSalarioNeto tiposalarioneto:tiposalarionetos) {
					this.deepLoad(tiposalarioneto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoSalarioNetoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSalarioNeto(tiposalarionetos);
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
			if(tiposalarionetos!=null) {
				for(TipoSalarioNeto tiposalarioneto:tiposalarionetos) {
					this.deepLoad(tiposalarioneto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoSalarioNetoConstantesFunciones.refrescarForeignKeysDescripcionesTipoSalarioNeto(tiposalarionetos);
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
			if(TipoSalarioNetoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoSalarioNetoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoSalarioNeto tiposalarioneto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoSalarioNetoConstantesFunciones.ISCONAUDITORIA) {
				if(tiposalarioneto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoSalarioNetoDataAccess.TABLENAME, tiposalarioneto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoSalarioNetoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoSalarioNetoLogic.registrarAuditoriaDetallesTipoSalarioNeto(connexion,tiposalarioneto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tiposalarioneto.getIsDeleted()) {
					/*if(!tiposalarioneto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoSalarioNetoDataAccess.TABLENAME, tiposalarioneto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoSalarioNetoLogic.registrarAuditoriaDetallesTipoSalarioNeto(connexion,tiposalarioneto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoSalarioNetoDataAccess.TABLENAME, tiposalarioneto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tiposalarioneto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoSalarioNetoDataAccess.TABLENAME, tiposalarioneto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoSalarioNetoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoSalarioNetoLogic.registrarAuditoriaDetallesTipoSalarioNeto(connexion,tiposalarioneto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoSalarioNeto(Connexion connexion,TipoSalarioNeto tiposalarioneto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tiposalarioneto.getIsNew()||!tiposalarioneto.getnombre().equals(tiposalarioneto.getTipoSalarioNetoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiposalarioneto.getTipoSalarioNetoOriginal().getnombre()!=null)
				{
					strValorActual=tiposalarioneto.getTipoSalarioNetoOriginal().getnombre();
				}
				if(tiposalarioneto.getnombre()!=null)
				{
					strValorNuevo=tiposalarioneto.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoSalarioNetoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tiposalarioneto.getIsNew()||!tiposalarioneto.getdescripcion().equals(tiposalarioneto.getTipoSalarioNetoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiposalarioneto.getTipoSalarioNetoOriginal().getdescripcion()!=null)
				{
					strValorActual=tiposalarioneto.getTipoSalarioNetoOriginal().getdescripcion();
				}
				if(tiposalarioneto.getdescripcion()!=null)
				{
					strValorNuevo=tiposalarioneto.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoSalarioNetoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoSalarioNeto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoSalarioNetoConstantesFunciones.getClassesForeignKeysOfTipoSalarioNeto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoSalarioNeto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoSalarioNetoConstantesFunciones.getClassesRelationshipsOfTipoSalarioNeto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

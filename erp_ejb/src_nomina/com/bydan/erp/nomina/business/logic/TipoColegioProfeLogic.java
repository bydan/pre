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
import com.bydan.erp.nomina.util.TipoColegioProfeConstantesFunciones;
import com.bydan.erp.nomina.util.TipoColegioProfeParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoColegioProfeParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoColegioProfe;
import com.bydan.erp.nomina.business.logic.TipoColegioProfeLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoColegioProfeLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoColegioProfeLogic.class);
	
	protected TipoColegioProfeDataAccess tipocolegioprofeDataAccess; 	
	protected TipoColegioProfe tipocolegioprofe;
	protected List<TipoColegioProfe> tipocolegioprofes;
	protected Object tipocolegioprofeObject;	
	protected List<Object> tipocolegioprofesObject;
	
	public static ClassValidator<TipoColegioProfe> tipocolegioprofeValidator = new ClassValidator<TipoColegioProfe>(TipoColegioProfe.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoColegioProfeLogicAdditional tipocolegioprofeLogicAdditional=null;
	
	public TipoColegioProfeLogicAdditional getTipoColegioProfeLogicAdditional() {
		return this.tipocolegioprofeLogicAdditional;
	}
	
	public void setTipoColegioProfeLogicAdditional(TipoColegioProfeLogicAdditional tipocolegioprofeLogicAdditional) {
		try {
			this.tipocolegioprofeLogicAdditional=tipocolegioprofeLogicAdditional;
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
	
	
	
	
	public  TipoColegioProfeLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipocolegioprofeDataAccess = new TipoColegioProfeDataAccess();
			
			this.tipocolegioprofes= new ArrayList<TipoColegioProfe>();
			this.tipocolegioprofe= new TipoColegioProfe();
			
			this.tipocolegioprofeObject=new Object();
			this.tipocolegioprofesObject=new ArrayList<Object>();
				
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
			
			this.tipocolegioprofeDataAccess.setConnexionType(this.connexionType);
			this.tipocolegioprofeDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoColegioProfeLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipocolegioprofeDataAccess = new TipoColegioProfeDataAccess();
			this.tipocolegioprofes= new ArrayList<TipoColegioProfe>();
			this.tipocolegioprofe= new TipoColegioProfe();
			this.tipocolegioprofeObject=new Object();
			this.tipocolegioprofesObject=new ArrayList<Object>();
			
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
			
			this.tipocolegioprofeDataAccess.setConnexionType(this.connexionType);
			this.tipocolegioprofeDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoColegioProfe getTipoColegioProfe() throws Exception {	
		TipoColegioProfeLogicAdditional.checkTipoColegioProfeToGet(tipocolegioprofe,this.datosCliente,this.arrDatoGeneral);
		TipoColegioProfeLogicAdditional.updateTipoColegioProfeToGet(tipocolegioprofe,this.arrDatoGeneral);
		
		return tipocolegioprofe;
	}
		
	public void setTipoColegioProfe(TipoColegioProfe newTipoColegioProfe) {
		this.tipocolegioprofe = newTipoColegioProfe;
	}
	
	public TipoColegioProfeDataAccess getTipoColegioProfeDataAccess() {
		return tipocolegioprofeDataAccess;
	}
	
	public void setTipoColegioProfeDataAccess(TipoColegioProfeDataAccess newtipocolegioprofeDataAccess) {
		this.tipocolegioprofeDataAccess = newtipocolegioprofeDataAccess;
	}
	
	public List<TipoColegioProfe> getTipoColegioProfes() throws Exception {		
		this.quitarTipoColegioProfesNulos();
		
		TipoColegioProfeLogicAdditional.checkTipoColegioProfeToGets(tipocolegioprofes,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoColegioProfe tipocolegioprofeLocal: tipocolegioprofes ) {
			TipoColegioProfeLogicAdditional.updateTipoColegioProfeToGet(tipocolegioprofeLocal,this.arrDatoGeneral);
		}
		
		return tipocolegioprofes;
	}
	
	public void setTipoColegioProfes(List<TipoColegioProfe> newTipoColegioProfes) {
		this.tipocolegioprofes = newTipoColegioProfes;
	}
	
	public Object getTipoColegioProfeObject() {	
		this.tipocolegioprofeObject=this.tipocolegioprofeDataAccess.getEntityObject();
		return this.tipocolegioprofeObject;
	}
		
	public void setTipoColegioProfeObject(Object newTipoColegioProfeObject) {
		this.tipocolegioprofeObject = newTipoColegioProfeObject;
	}
	
	public List<Object> getTipoColegioProfesObject() {		
		this.tipocolegioprofesObject=this.tipocolegioprofeDataAccess.getEntitiesObject();
		return this.tipocolegioprofesObject;
	}
		
	public void setTipoColegioProfesObject(List<Object> newTipoColegioProfesObject) {
		this.tipocolegioprofesObject = newTipoColegioProfesObject;
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
		
		if(this.tipocolegioprofeDataAccess!=null) {
			this.tipocolegioprofeDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoColegioProfe.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipocolegioprofeDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipocolegioprofeDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipocolegioprofe = new  TipoColegioProfe();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoColegioProfe.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocolegioprofe=tipocolegioprofeDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocolegioprofe,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoColegioProfeConstantesFunciones.refrescarForeignKeysDescripcionesTipoColegioProfe(this.tipocolegioprofe);
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
		tipocolegioprofe = new  TipoColegioProfe();
		  		  
        try {
			
			tipocolegioprofe=tipocolegioprofeDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocolegioprofe,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoColegioProfeConstantesFunciones.refrescarForeignKeysDescripcionesTipoColegioProfe(this.tipocolegioprofe);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipocolegioprofe = new  TipoColegioProfe();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoColegioProfe.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocolegioprofe=tipocolegioprofeDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocolegioprofe,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoColegioProfeConstantesFunciones.refrescarForeignKeysDescripcionesTipoColegioProfe(this.tipocolegioprofe);
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
		tipocolegioprofe = new  TipoColegioProfe();
		  		  
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
		tipocolegioprofe = new  TipoColegioProfe();
		  		  
        try {
			
			tipocolegioprofe=tipocolegioprofeDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocolegioprofe,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoColegioProfeConstantesFunciones.refrescarForeignKeysDescripcionesTipoColegioProfe(this.tipocolegioprofe);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipocolegioprofe = new  TipoColegioProfe();
		  		  
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
		tipocolegioprofe = new  TipoColegioProfe();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoColegioProfe.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipocolegioprofeDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocolegioprofe = new  TipoColegioProfe();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipocolegioprofeDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocolegioprofe = new  TipoColegioProfe();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoColegioProfe.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipocolegioprofeDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocolegioprofe = new  TipoColegioProfe();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipocolegioprofeDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocolegioprofe = new  TipoColegioProfe();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoColegioProfe.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipocolegioprofeDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocolegioprofe = new  TipoColegioProfe();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipocolegioprofeDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocolegioprofes = new  ArrayList<TipoColegioProfe>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoColegioProfe.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoColegioProfeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocolegioprofes=tipocolegioprofeDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoColegioProfe(tipocolegioprofes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoColegioProfeConstantesFunciones.refrescarForeignKeysDescripcionesTipoColegioProfe(this.tipocolegioprofes);
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
		tipocolegioprofes = new  ArrayList<TipoColegioProfe>();
		  		  
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
		tipocolegioprofes = new  ArrayList<TipoColegioProfe>();
		  		  
        try {			
			TipoColegioProfeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocolegioprofes=tipocolegioprofeDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoColegioProfe(tipocolegioprofes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoColegioProfeConstantesFunciones.refrescarForeignKeysDescripcionesTipoColegioProfe(this.tipocolegioprofes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipocolegioprofes = new  ArrayList<TipoColegioProfe>();
		  		  
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
		tipocolegioprofes = new  ArrayList<TipoColegioProfe>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoColegioProfe.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoColegioProfeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocolegioprofes=tipocolegioprofeDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoColegioProfe(tipocolegioprofes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoColegioProfeConstantesFunciones.refrescarForeignKeysDescripcionesTipoColegioProfe(this.tipocolegioprofes);
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
		tipocolegioprofes = new  ArrayList<TipoColegioProfe>();
		  		  
        try {
			TipoColegioProfeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocolegioprofes=tipocolegioprofeDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoColegioProfe(tipocolegioprofes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoColegioProfeConstantesFunciones.refrescarForeignKeysDescripcionesTipoColegioProfe(this.tipocolegioprofes);
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
		tipocolegioprofes = new  ArrayList<TipoColegioProfe>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoColegioProfe.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoColegioProfeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocolegioprofes=tipocolegioprofeDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoColegioProfe(tipocolegioprofes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoColegioProfeConstantesFunciones.refrescarForeignKeysDescripcionesTipoColegioProfe(this.tipocolegioprofes);
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
		tipocolegioprofes = new  ArrayList<TipoColegioProfe>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoColegioProfeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocolegioprofes=tipocolegioprofeDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoColegioProfe(tipocolegioprofes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoColegioProfeConstantesFunciones.refrescarForeignKeysDescripcionesTipoColegioProfe(this.tipocolegioprofes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipocolegioprofe = new  TipoColegioProfe();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoColegioProfe.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoColegioProfeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocolegioprofe=tipocolegioprofeDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoColegioProfe(tipocolegioprofe);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoColegioProfeConstantesFunciones.refrescarForeignKeysDescripcionesTipoColegioProfe(this.tipocolegioprofe);
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
		tipocolegioprofe = new  TipoColegioProfe();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoColegioProfeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocolegioprofe=tipocolegioprofeDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoColegioProfe(tipocolegioprofe);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoColegioProfeConstantesFunciones.refrescarForeignKeysDescripcionesTipoColegioProfe(this.tipocolegioprofe);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocolegioprofes = new  ArrayList<TipoColegioProfe>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoColegioProfe.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoColegioProfeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocolegioprofes=tipocolegioprofeDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoColegioProfe(tipocolegioprofes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoColegioProfeConstantesFunciones.refrescarForeignKeysDescripcionesTipoColegioProfe(this.tipocolegioprofes);
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
		tipocolegioprofes = new  ArrayList<TipoColegioProfe>();
		  		  
        try {
			TipoColegioProfeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocolegioprofes=tipocolegioprofeDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoColegioProfe(tipocolegioprofes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoColegioProfeConstantesFunciones.refrescarForeignKeysDescripcionesTipoColegioProfe(this.tipocolegioprofes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoColegioProfesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipocolegioprofes = new  ArrayList<TipoColegioProfe>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoColegioProfe.class.getSimpleName()+"-getTodosTipoColegioProfesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoColegioProfeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocolegioprofes=tipocolegioprofeDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoColegioProfe(tipocolegioprofes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoColegioProfeConstantesFunciones.refrescarForeignKeysDescripcionesTipoColegioProfe(this.tipocolegioprofes);
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
	
	public  void  getTodosTipoColegioProfes(String sFinalQuery,Pagination pagination)throws Exception {
		tipocolegioprofes = new  ArrayList<TipoColegioProfe>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoColegioProfeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocolegioprofes=tipocolegioprofeDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoColegioProfe(tipocolegioprofes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoColegioProfeConstantesFunciones.refrescarForeignKeysDescripcionesTipoColegioProfe(this.tipocolegioprofes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoColegioProfe(TipoColegioProfe tipocolegioprofe) throws Exception {
		Boolean estaValidado=false;
		
		if(tipocolegioprofe.getIsNew() || tipocolegioprofe.getIsChanged()) { 
			this.invalidValues = tipocolegioprofeValidator.getInvalidValues(tipocolegioprofe);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipocolegioprofe);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoColegioProfe(List<TipoColegioProfe> TipoColegioProfes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoColegioProfe tipocolegioprofeLocal:tipocolegioprofes) {				
			estaValidadoObjeto=this.validarGuardarTipoColegioProfe(tipocolegioprofeLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoColegioProfe(List<TipoColegioProfe> TipoColegioProfes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoColegioProfe(tipocolegioprofes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoColegioProfe(TipoColegioProfe TipoColegioProfe) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoColegioProfe(tipocolegioprofe)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoColegioProfe tipocolegioprofe) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipocolegioprofe.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoColegioProfeConstantesFunciones.getTipoColegioProfeLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipocolegioprofe","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoColegioProfeConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoColegioProfeConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoColegioProfeWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoColegioProfe.class.getSimpleName()+"-saveTipoColegioProfeWithConnection");connexion.begin();			
			
			TipoColegioProfeLogicAdditional.checkTipoColegioProfeToSave(this.tipocolegioprofe,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoColegioProfeLogicAdditional.updateTipoColegioProfeToSave(this.tipocolegioprofe,this.arrDatoGeneral);
			
			TipoColegioProfeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocolegioprofe,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoColegioProfe();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoColegioProfe(this.tipocolegioprofe)) {
				TipoColegioProfeDataAccess.save(this.tipocolegioprofe, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipocolegioprofe,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoColegioProfeLogicAdditional.checkTipoColegioProfeToSaveAfter(this.tipocolegioprofe,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoColegioProfe();
			
			connexion.commit();			
			
			if(this.tipocolegioprofe.getIsDeleted()) {
				this.tipocolegioprofe=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoColegioProfe()throws Exception {	
		try {	
			
			TipoColegioProfeLogicAdditional.checkTipoColegioProfeToSave(this.tipocolegioprofe,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoColegioProfeLogicAdditional.updateTipoColegioProfeToSave(this.tipocolegioprofe,this.arrDatoGeneral);
			
			TipoColegioProfeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocolegioprofe,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoColegioProfe(this.tipocolegioprofe)) {			
				TipoColegioProfeDataAccess.save(this.tipocolegioprofe, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipocolegioprofe,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoColegioProfeLogicAdditional.checkTipoColegioProfeToSaveAfter(this.tipocolegioprofe,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipocolegioprofe.getIsDeleted()) {
				this.tipocolegioprofe=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoColegioProfesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoColegioProfe.class.getSimpleName()+"-saveTipoColegioProfesWithConnection");connexion.begin();			
			
			TipoColegioProfeLogicAdditional.checkTipoColegioProfeToSaves(tipocolegioprofes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoColegioProfes();
			
			Boolean validadoTodosTipoColegioProfe=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoColegioProfe tipocolegioprofeLocal:tipocolegioprofes) {		
				if(tipocolegioprofeLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoColegioProfeLogicAdditional.updateTipoColegioProfeToSave(tipocolegioprofeLocal,this.arrDatoGeneral);
	        	
				TipoColegioProfeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocolegioprofeLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoColegioProfe(tipocolegioprofeLocal)) {
					TipoColegioProfeDataAccess.save(tipocolegioprofeLocal, connexion);				
				} else {
					validadoTodosTipoColegioProfe=false;
				}
			}
			
			if(!validadoTodosTipoColegioProfe) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoColegioProfeLogicAdditional.checkTipoColegioProfeToSavesAfter(tipocolegioprofes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoColegioProfes();
			
			connexion.commit();		
			
			this.quitarTipoColegioProfesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoColegioProfes()throws Exception {				
		 try {	
			TipoColegioProfeLogicAdditional.checkTipoColegioProfeToSaves(tipocolegioprofes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoColegioProfe=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoColegioProfe tipocolegioprofeLocal:tipocolegioprofes) {				
				if(tipocolegioprofeLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoColegioProfeLogicAdditional.updateTipoColegioProfeToSave(tipocolegioprofeLocal,this.arrDatoGeneral);
	        	
				TipoColegioProfeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocolegioprofeLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoColegioProfe(tipocolegioprofeLocal)) {				
					TipoColegioProfeDataAccess.save(tipocolegioprofeLocal, connexion);				
				} else {
					validadoTodosTipoColegioProfe=false;
				}
			}
			
			if(!validadoTodosTipoColegioProfe) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoColegioProfeLogicAdditional.checkTipoColegioProfeToSavesAfter(tipocolegioprofes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoColegioProfesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoColegioProfeParameterReturnGeneral procesarAccionTipoColegioProfes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoColegioProfe> tipocolegioprofes,TipoColegioProfeParameterReturnGeneral tipocolegioprofeParameterGeneral)throws Exception {
		 try {	
			TipoColegioProfeParameterReturnGeneral tipocolegioprofeReturnGeneral=new TipoColegioProfeParameterReturnGeneral();
	
			TipoColegioProfeLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipocolegioprofes,tipocolegioprofeParameterGeneral,tipocolegioprofeReturnGeneral);
			
			return tipocolegioprofeReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoColegioProfeParameterReturnGeneral procesarAccionTipoColegioProfesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoColegioProfe> tipocolegioprofes,TipoColegioProfeParameterReturnGeneral tipocolegioprofeParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoColegioProfe.class.getSimpleName()+"-procesarAccionTipoColegioProfesWithConnection");connexion.begin();			
			
			TipoColegioProfeParameterReturnGeneral tipocolegioprofeReturnGeneral=new TipoColegioProfeParameterReturnGeneral();
	
			TipoColegioProfeLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipocolegioprofes,tipocolegioprofeParameterGeneral,tipocolegioprofeReturnGeneral);
			
			this.connexion.commit();
			
			return tipocolegioprofeReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoColegioProfeParameterReturnGeneral procesarEventosTipoColegioProfes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoColegioProfe> tipocolegioprofes,TipoColegioProfe tipocolegioprofe,TipoColegioProfeParameterReturnGeneral tipocolegioprofeParameterGeneral,Boolean isEsNuevoTipoColegioProfe,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoColegioProfeParameterReturnGeneral tipocolegioprofeReturnGeneral=new TipoColegioProfeParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocolegioprofeReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoColegioProfeLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipocolegioprofes,tipocolegioprofe,tipocolegioprofeParameterGeneral,tipocolegioprofeReturnGeneral,isEsNuevoTipoColegioProfe,clases);
			
			return tipocolegioprofeReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoColegioProfeParameterReturnGeneral procesarEventosTipoColegioProfesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoColegioProfe> tipocolegioprofes,TipoColegioProfe tipocolegioprofe,TipoColegioProfeParameterReturnGeneral tipocolegioprofeParameterGeneral,Boolean isEsNuevoTipoColegioProfe,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoColegioProfe.class.getSimpleName()+"-procesarEventosTipoColegioProfesWithConnection");connexion.begin();			
			
			TipoColegioProfeParameterReturnGeneral tipocolegioprofeReturnGeneral=new TipoColegioProfeParameterReturnGeneral();
	
			tipocolegioprofeReturnGeneral.setTipoColegioProfe(tipocolegioprofe);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocolegioprofeReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoColegioProfeLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipocolegioprofes,tipocolegioprofe,tipocolegioprofeParameterGeneral,tipocolegioprofeReturnGeneral,isEsNuevoTipoColegioProfe,clases);
			
			this.connexion.commit();
			
			return tipocolegioprofeReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoColegioProfeParameterReturnGeneral procesarImportacionTipoColegioProfesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoColegioProfeParameterReturnGeneral tipocolegioprofeParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoColegioProfe.class.getSimpleName()+"-procesarImportacionTipoColegioProfesWithConnection");connexion.begin();			
			
			TipoColegioProfeParameterReturnGeneral tipocolegioprofeReturnGeneral=new TipoColegioProfeParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipocolegioprofes=new ArrayList<TipoColegioProfe>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipocolegioprofe=new TipoColegioProfe();
				
				
				if(conColumnasBase) {this.tipocolegioprofe.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipocolegioprofe.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipocolegioprofe.setcodigo(arrColumnas[iColumn++]);
				this.tipocolegioprofe.setnombre(arrColumnas[iColumn++]);
				
				this.tipocolegioprofes.add(this.tipocolegioprofe);
			}
			
			this.saveTipoColegioProfes();
			
			this.connexion.commit();
			
			tipocolegioprofeReturnGeneral.setConRetornoEstaProcesado(true);
			tipocolegioprofeReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipocolegioprofeReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoColegioProfesEliminados() throws Exception {				
		
		List<TipoColegioProfe> tipocolegioprofesAux= new ArrayList<TipoColegioProfe>();
		
		for(TipoColegioProfe tipocolegioprofe:tipocolegioprofes) {
			if(!tipocolegioprofe.getIsDeleted()) {
				tipocolegioprofesAux.add(tipocolegioprofe);
			}
		}
		
		tipocolegioprofes=tipocolegioprofesAux;
	}
	
	public void quitarTipoColegioProfesNulos() throws Exception {				
		
		List<TipoColegioProfe> tipocolegioprofesAux= new ArrayList<TipoColegioProfe>();
		
		for(TipoColegioProfe tipocolegioprofe : this.tipocolegioprofes) {
			if(tipocolegioprofe==null) {
				tipocolegioprofesAux.add(tipocolegioprofe);
			}
		}
		
		//this.tipocolegioprofes=tipocolegioprofesAux;
		
		this.tipocolegioprofes.removeAll(tipocolegioprofesAux);
	}
	
	public void getSetVersionRowTipoColegioProfeWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipocolegioprofe.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipocolegioprofe.getIsDeleted() || (tipocolegioprofe.getIsChanged()&&!tipocolegioprofe.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipocolegioprofeDataAccess.getSetVersionRowTipoColegioProfe(connexion,tipocolegioprofe.getId());
				
				if(!tipocolegioprofe.getVersionRow().equals(timestamp)) {	
					tipocolegioprofe.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipocolegioprofe.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoColegioProfe()throws Exception {	
		
		if(tipocolegioprofe.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipocolegioprofe.getIsDeleted() || (tipocolegioprofe.getIsChanged()&&!tipocolegioprofe.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipocolegioprofeDataAccess.getSetVersionRowTipoColegioProfe(connexion,tipocolegioprofe.getId());
			
			try {							
				if(!tipocolegioprofe.getVersionRow().equals(timestamp)) {	
					tipocolegioprofe.setVersionRow(timestamp);
				}
				
				tipocolegioprofe.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoColegioProfesWithConnection()throws Exception {	
		if(tipocolegioprofes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoColegioProfe tipocolegioprofeAux:tipocolegioprofes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipocolegioprofeAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocolegioprofeAux.getIsDeleted() || (tipocolegioprofeAux.getIsChanged()&&!tipocolegioprofeAux.getIsNew())) {
						
						timestamp=tipocolegioprofeDataAccess.getSetVersionRowTipoColegioProfe(connexion,tipocolegioprofeAux.getId());
						
						if(!tipocolegioprofe.getVersionRow().equals(timestamp)) {	
							tipocolegioprofeAux.setVersionRow(timestamp);
						}
								
						tipocolegioprofeAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoColegioProfes()throws Exception {	
		if(tipocolegioprofes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoColegioProfe tipocolegioprofeAux:tipocolegioprofes) {
					if(tipocolegioprofeAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocolegioprofeAux.getIsDeleted() || (tipocolegioprofeAux.getIsChanged()&&!tipocolegioprofeAux.getIsNew())) {
						
						timestamp=tipocolegioprofeDataAccess.getSetVersionRowTipoColegioProfe(connexion,tipocolegioprofeAux.getId());
						
						if(!tipocolegioprofeAux.getVersionRow().equals(timestamp)) {	
							tipocolegioprofeAux.setVersionRow(timestamp);
						}
						
													
						tipocolegioprofeAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoColegioProfeParameterReturnGeneral cargarCombosLoteForeignKeyTipoColegioProfeWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoColegioProfeParameterReturnGeneral  tipocolegioprofeReturnGeneral =new TipoColegioProfeParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoColegioProfe.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoColegioProfeWithConnection");connexion.begin();
			
			tipocolegioprofeReturnGeneral =new TipoColegioProfeParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipocolegioprofeReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipocolegioprofeReturnGeneral;
	}
	
	public TipoColegioProfeParameterReturnGeneral cargarCombosLoteForeignKeyTipoColegioProfe(String finalQueryGlobalEmpresa) throws Exception {
		TipoColegioProfeParameterReturnGeneral  tipocolegioprofeReturnGeneral =new TipoColegioProfeParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipocolegioprofeReturnGeneral =new TipoColegioProfeParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipocolegioprofeReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipocolegioprofeReturnGeneral;
	}
	
	
	public void deepLoad(TipoColegioProfe tipocolegioprofe,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoColegioProfeLogicAdditional.updateTipoColegioProfeToGet(tipocolegioprofe,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocolegioprofe.setEmpresa(tipocolegioprofeDataAccess.getEmpresa(connexion,tipocolegioprofe));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipocolegioprofe.setEmpresa(tipocolegioprofeDataAccess.getEmpresa(connexion,tipocolegioprofe));
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
			tipocolegioprofe.setEmpresa(tipocolegioprofeDataAccess.getEmpresa(connexion,tipocolegioprofe));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocolegioprofe.setEmpresa(tipocolegioprofeDataAccess.getEmpresa(connexion,tipocolegioprofe));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipocolegioprofe.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipocolegioprofe.setEmpresa(tipocolegioprofeDataAccess.getEmpresa(connexion,tipocolegioprofe));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipocolegioprofe.getEmpresa(),isDeep,deepLoadType,clases);				
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
			tipocolegioprofe.setEmpresa(tipocolegioprofeDataAccess.getEmpresa(connexion,tipocolegioprofe));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipocolegioprofe.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoColegioProfe tipocolegioprofe,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoColegioProfeLogicAdditional.updateTipoColegioProfeToSave(tipocolegioprofe,this.arrDatoGeneral);
			
TipoColegioProfeDataAccess.save(tipocolegioprofe, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipocolegioprofe.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipocolegioprofe.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipocolegioprofe.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipocolegioprofe.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipocolegioprofe.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipocolegioprofe.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TipoColegioProfe.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipocolegioprofe,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoColegioProfeConstantesFunciones.refrescarForeignKeysDescripcionesTipoColegioProfe(tipocolegioprofe);
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
			this.deepLoad(this.tipocolegioprofe,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoColegioProfeConstantesFunciones.refrescarForeignKeysDescripcionesTipoColegioProfe(this.tipocolegioprofe);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoColegioProfe.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipocolegioprofes!=null) {
				for(TipoColegioProfe tipocolegioprofe:tipocolegioprofes) {
					this.deepLoad(tipocolegioprofe,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoColegioProfeConstantesFunciones.refrescarForeignKeysDescripcionesTipoColegioProfe(tipocolegioprofes);
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
			if(tipocolegioprofes!=null) {
				for(TipoColegioProfe tipocolegioprofe:tipocolegioprofes) {
					this.deepLoad(tipocolegioprofe,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoColegioProfeConstantesFunciones.refrescarForeignKeysDescripcionesTipoColegioProfe(tipocolegioprofes);
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
			this.getNewConnexionToDeep(TipoColegioProfe.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipocolegioprofe,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoColegioProfe.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipocolegioprofes!=null) {
				for(TipoColegioProfe tipocolegioprofe:tipocolegioprofes) {
					this.deepSave(tipocolegioprofe,isDeep,deepLoadType,clases);
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
			if(tipocolegioprofes!=null) {
				for(TipoColegioProfe tipocolegioprofe:tipocolegioprofes) {
					this.deepSave(tipocolegioprofe,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoColegioProfesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoColegioProfe.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoColegioProfeConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoColegioProfeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocolegioprofes=tipocolegioprofeDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoColegioProfeConstantesFunciones.refrescarForeignKeysDescripcionesTipoColegioProfe(this.tipocolegioprofes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoColegioProfesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoColegioProfeConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoColegioProfeLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocolegioprofes=tipocolegioprofeDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoColegioProfeConstantesFunciones.refrescarForeignKeysDescripcionesTipoColegioProfe(this.tipocolegioprofes);
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
			if(TipoColegioProfeConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoColegioProfeDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoColegioProfe tipocolegioprofe,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoColegioProfeConstantesFunciones.ISCONAUDITORIA) {
				if(tipocolegioprofe.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoColegioProfeDataAccess.TABLENAME, tipocolegioprofe.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoColegioProfeConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoColegioProfeLogic.registrarAuditoriaDetallesTipoColegioProfe(connexion,tipocolegioprofe,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipocolegioprofe.getIsDeleted()) {
					/*if(!tipocolegioprofe.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoColegioProfeDataAccess.TABLENAME, tipocolegioprofe.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoColegioProfeLogic.registrarAuditoriaDetallesTipoColegioProfe(connexion,tipocolegioprofe,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoColegioProfeDataAccess.TABLENAME, tipocolegioprofe.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipocolegioprofe.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoColegioProfeDataAccess.TABLENAME, tipocolegioprofe.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoColegioProfeConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoColegioProfeLogic.registrarAuditoriaDetallesTipoColegioProfe(connexion,tipocolegioprofe,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoColegioProfe(Connexion connexion,TipoColegioProfe tipocolegioprofe)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipocolegioprofe.getIsNew()||!tipocolegioprofe.getid_empresa().equals(tipocolegioprofe.getTipoColegioProfeOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocolegioprofe.getTipoColegioProfeOriginal().getid_empresa()!=null)
				{
					strValorActual=tipocolegioprofe.getTipoColegioProfeOriginal().getid_empresa().toString();
				}
				if(tipocolegioprofe.getid_empresa()!=null)
				{
					strValorNuevo=tipocolegioprofe.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoColegioProfeConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipocolegioprofe.getIsNew()||!tipocolegioprofe.getcodigo().equals(tipocolegioprofe.getTipoColegioProfeOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocolegioprofe.getTipoColegioProfeOriginal().getcodigo()!=null)
				{
					strValorActual=tipocolegioprofe.getTipoColegioProfeOriginal().getcodigo();
				}
				if(tipocolegioprofe.getcodigo()!=null)
				{
					strValorNuevo=tipocolegioprofe.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoColegioProfeConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipocolegioprofe.getIsNew()||!tipocolegioprofe.getnombre().equals(tipocolegioprofe.getTipoColegioProfeOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocolegioprofe.getTipoColegioProfeOriginal().getnombre()!=null)
				{
					strValorActual=tipocolegioprofe.getTipoColegioProfeOriginal().getnombre();
				}
				if(tipocolegioprofe.getnombre()!=null)
				{
					strValorNuevo=tipocolegioprofe.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoColegioProfeConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoColegioProfeRelacionesWithConnection(TipoColegioProfe tipocolegioprofe) throws Exception {

		if(!tipocolegioprofe.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoColegioProfeRelacionesBase(tipocolegioprofe,true);
		}
	}

	public void saveTipoColegioProfeRelaciones(TipoColegioProfe tipocolegioprofe)throws Exception {

		if(!tipocolegioprofe.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoColegioProfeRelacionesBase(tipocolegioprofe,false);
		}
	}

	public void saveTipoColegioProfeRelacionesBase(TipoColegioProfe tipocolegioprofe,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoColegioProfe-saveRelacionesWithConnection");}
	

			this.setTipoColegioProfe(tipocolegioprofe);

			if(TipoColegioProfeLogicAdditional.validarSaveRelaciones(tipocolegioprofe,this)) {

				TipoColegioProfeLogicAdditional.updateRelacionesToSave(tipocolegioprofe,this);

				if((tipocolegioprofe.getIsNew()||tipocolegioprofe.getIsChanged())&&!tipocolegioprofe.getIsDeleted()) {
					this.saveTipoColegioProfe();
					this.saveTipoColegioProfeRelacionesDetalles();

				} else if(tipocolegioprofe.getIsDeleted()) {
					this.saveTipoColegioProfeRelacionesDetalles();
					this.saveTipoColegioProfe();
				}

				TipoColegioProfeLogicAdditional.updateRelacionesToSaveAfter(tipocolegioprofe,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
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
	
	
	private void saveTipoColegioProfeRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoColegioProfe(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoColegioProfeConstantesFunciones.getClassesForeignKeysOfTipoColegioProfe(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoColegioProfe(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoColegioProfeConstantesFunciones.getClassesRelationshipsOfTipoColegioProfe(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.nomina.util.TipoVariableNomiConstantesFunciones;
import com.bydan.erp.nomina.util.TipoVariableNomiParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoVariableNomiParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoVariableNomi;
import com.bydan.erp.nomina.business.logic.TipoVariableNomiLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoVariableNomiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoVariableNomiLogic.class);
	
	protected TipoVariableNomiDataAccess tipovariablenomiDataAccess; 	
	protected TipoVariableNomi tipovariablenomi;
	protected List<TipoVariableNomi> tipovariablenomis;
	protected Object tipovariablenomiObject;	
	protected List<Object> tipovariablenomisObject;
	
	public static ClassValidator<TipoVariableNomi> tipovariablenomiValidator = new ClassValidator<TipoVariableNomi>(TipoVariableNomi.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoVariableNomiLogicAdditional tipovariablenomiLogicAdditional=null;
	
	public TipoVariableNomiLogicAdditional getTipoVariableNomiLogicAdditional() {
		return this.tipovariablenomiLogicAdditional;
	}
	
	public void setTipoVariableNomiLogicAdditional(TipoVariableNomiLogicAdditional tipovariablenomiLogicAdditional) {
		try {
			this.tipovariablenomiLogicAdditional=tipovariablenomiLogicAdditional;
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
	
	
	
	
	public  TipoVariableNomiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipovariablenomiDataAccess = new TipoVariableNomiDataAccess();
			
			this.tipovariablenomis= new ArrayList<TipoVariableNomi>();
			this.tipovariablenomi= new TipoVariableNomi();
			
			this.tipovariablenomiObject=new Object();
			this.tipovariablenomisObject=new ArrayList<Object>();
				
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
			
			this.tipovariablenomiDataAccess.setConnexionType(this.connexionType);
			this.tipovariablenomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoVariableNomiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipovariablenomiDataAccess = new TipoVariableNomiDataAccess();
			this.tipovariablenomis= new ArrayList<TipoVariableNomi>();
			this.tipovariablenomi= new TipoVariableNomi();
			this.tipovariablenomiObject=new Object();
			this.tipovariablenomisObject=new ArrayList<Object>();
			
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
			
			this.tipovariablenomiDataAccess.setConnexionType(this.connexionType);
			this.tipovariablenomiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoVariableNomi getTipoVariableNomi() throws Exception {	
		TipoVariableNomiLogicAdditional.checkTipoVariableNomiToGet(tipovariablenomi,this.datosCliente,this.arrDatoGeneral);
		TipoVariableNomiLogicAdditional.updateTipoVariableNomiToGet(tipovariablenomi,this.arrDatoGeneral);
		
		return tipovariablenomi;
	}
		
	public void setTipoVariableNomi(TipoVariableNomi newTipoVariableNomi) {
		this.tipovariablenomi = newTipoVariableNomi;
	}
	
	public TipoVariableNomiDataAccess getTipoVariableNomiDataAccess() {
		return tipovariablenomiDataAccess;
	}
	
	public void setTipoVariableNomiDataAccess(TipoVariableNomiDataAccess newtipovariablenomiDataAccess) {
		this.tipovariablenomiDataAccess = newtipovariablenomiDataAccess;
	}
	
	public List<TipoVariableNomi> getTipoVariableNomis() throws Exception {		
		this.quitarTipoVariableNomisNulos();
		
		TipoVariableNomiLogicAdditional.checkTipoVariableNomiToGets(tipovariablenomis,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoVariableNomi tipovariablenomiLocal: tipovariablenomis ) {
			TipoVariableNomiLogicAdditional.updateTipoVariableNomiToGet(tipovariablenomiLocal,this.arrDatoGeneral);
		}
		
		return tipovariablenomis;
	}
	
	public void setTipoVariableNomis(List<TipoVariableNomi> newTipoVariableNomis) {
		this.tipovariablenomis = newTipoVariableNomis;
	}
	
	public Object getTipoVariableNomiObject() {	
		this.tipovariablenomiObject=this.tipovariablenomiDataAccess.getEntityObject();
		return this.tipovariablenomiObject;
	}
		
	public void setTipoVariableNomiObject(Object newTipoVariableNomiObject) {
		this.tipovariablenomiObject = newTipoVariableNomiObject;
	}
	
	public List<Object> getTipoVariableNomisObject() {		
		this.tipovariablenomisObject=this.tipovariablenomiDataAccess.getEntitiesObject();
		return this.tipovariablenomisObject;
	}
		
	public void setTipoVariableNomisObject(List<Object> newTipoVariableNomisObject) {
		this.tipovariablenomisObject = newTipoVariableNomisObject;
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
		
		if(this.tipovariablenomiDataAccess!=null) {
			this.tipovariablenomiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVariableNomi.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipovariablenomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipovariablenomiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipovariablenomi = new  TipoVariableNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVariableNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipovariablenomi=tipovariablenomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipovariablenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoVariableNomi(this.tipovariablenomi);
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
		tipovariablenomi = new  TipoVariableNomi();
		  		  
        try {
			
			tipovariablenomi=tipovariablenomiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipovariablenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoVariableNomi(this.tipovariablenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipovariablenomi = new  TipoVariableNomi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVariableNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipovariablenomi=tipovariablenomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipovariablenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoVariableNomi(this.tipovariablenomi);
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
		tipovariablenomi = new  TipoVariableNomi();
		  		  
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
		tipovariablenomi = new  TipoVariableNomi();
		  		  
        try {
			
			tipovariablenomi=tipovariablenomiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipovariablenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoVariableNomi(this.tipovariablenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipovariablenomi = new  TipoVariableNomi();
		  		  
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
		tipovariablenomi = new  TipoVariableNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVariableNomi.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipovariablenomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipovariablenomi = new  TipoVariableNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipovariablenomiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipovariablenomi = new  TipoVariableNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVariableNomi.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipovariablenomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipovariablenomi = new  TipoVariableNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipovariablenomiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipovariablenomi = new  TipoVariableNomi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVariableNomi.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipovariablenomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipovariablenomi = new  TipoVariableNomi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipovariablenomiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipovariablenomis = new  ArrayList<TipoVariableNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVariableNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovariablenomis=tipovariablenomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoVariableNomi(tipovariablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoVariableNomi(this.tipovariablenomis);
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
		tipovariablenomis = new  ArrayList<TipoVariableNomi>();
		  		  
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
		tipovariablenomis = new  ArrayList<TipoVariableNomi>();
		  		  
        try {			
			TipoVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovariablenomis=tipovariablenomiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoVariableNomi(tipovariablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoVariableNomi(this.tipovariablenomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipovariablenomis = new  ArrayList<TipoVariableNomi>();
		  		  
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
		tipovariablenomis = new  ArrayList<TipoVariableNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVariableNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovariablenomis=tipovariablenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoVariableNomi(tipovariablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoVariableNomi(this.tipovariablenomis);
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
		tipovariablenomis = new  ArrayList<TipoVariableNomi>();
		  		  
        try {
			TipoVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovariablenomis=tipovariablenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoVariableNomi(tipovariablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoVariableNomi(this.tipovariablenomis);
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
		tipovariablenomis = new  ArrayList<TipoVariableNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVariableNomi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovariablenomis=tipovariablenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoVariableNomi(tipovariablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoVariableNomi(this.tipovariablenomis);
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
		tipovariablenomis = new  ArrayList<TipoVariableNomi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovariablenomis=tipovariablenomiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoVariableNomi(tipovariablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoVariableNomi(this.tipovariablenomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipovariablenomi = new  TipoVariableNomi();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVariableNomi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovariablenomi=tipovariablenomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoVariableNomi(tipovariablenomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoVariableNomi(this.tipovariablenomi);
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
		tipovariablenomi = new  TipoVariableNomi();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovariablenomi=tipovariablenomiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoVariableNomi(tipovariablenomi);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoVariableNomi(this.tipovariablenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipovariablenomis = new  ArrayList<TipoVariableNomi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVariableNomi.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovariablenomis=tipovariablenomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoVariableNomi(tipovariablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoVariableNomi(this.tipovariablenomis);
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
		tipovariablenomis = new  ArrayList<TipoVariableNomi>();
		  		  
        try {
			TipoVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovariablenomis=tipovariablenomiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoVariableNomi(tipovariablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoVariableNomi(this.tipovariablenomis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoVariableNomisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipovariablenomis = new  ArrayList<TipoVariableNomi>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVariableNomi.class.getSimpleName()+"-getTodosTipoVariableNomisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovariablenomis=tipovariablenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoVariableNomi(tipovariablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoVariableNomi(this.tipovariablenomis);
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
	
	public  void  getTodosTipoVariableNomis(String sFinalQuery,Pagination pagination)throws Exception {
		tipovariablenomis = new  ArrayList<TipoVariableNomi>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipovariablenomis=tipovariablenomiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoVariableNomi(tipovariablenomis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoVariableNomi(this.tipovariablenomis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoVariableNomi(TipoVariableNomi tipovariablenomi) throws Exception {
		Boolean estaValidado=false;
		
		if(tipovariablenomi.getIsNew() || tipovariablenomi.getIsChanged()) { 
			this.invalidValues = tipovariablenomiValidator.getInvalidValues(tipovariablenomi);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipovariablenomi);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoVariableNomi(List<TipoVariableNomi> TipoVariableNomis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoVariableNomi tipovariablenomiLocal:tipovariablenomis) {				
			estaValidadoObjeto=this.validarGuardarTipoVariableNomi(tipovariablenomiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoVariableNomi(List<TipoVariableNomi> TipoVariableNomis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoVariableNomi(tipovariablenomis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoVariableNomi(TipoVariableNomi TipoVariableNomi) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoVariableNomi(tipovariablenomi)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoVariableNomi tipovariablenomi) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipovariablenomi.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoVariableNomiConstantesFunciones.getTipoVariableNomiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipovariablenomi","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoVariableNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoVariableNomiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoVariableNomiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVariableNomi.class.getSimpleName()+"-saveTipoVariableNomiWithConnection");connexion.begin();			
			
			TipoVariableNomiLogicAdditional.checkTipoVariableNomiToSave(this.tipovariablenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoVariableNomiLogicAdditional.updateTipoVariableNomiToSave(this.tipovariablenomi,this.arrDatoGeneral);
			
			TipoVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipovariablenomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoVariableNomi();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoVariableNomi(this.tipovariablenomi)) {
				TipoVariableNomiDataAccess.save(this.tipovariablenomi, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipovariablenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoVariableNomiLogicAdditional.checkTipoVariableNomiToSaveAfter(this.tipovariablenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoVariableNomi();
			
			connexion.commit();			
			
			if(this.tipovariablenomi.getIsDeleted()) {
				this.tipovariablenomi=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoVariableNomi()throws Exception {	
		try {	
			
			TipoVariableNomiLogicAdditional.checkTipoVariableNomiToSave(this.tipovariablenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoVariableNomiLogicAdditional.updateTipoVariableNomiToSave(this.tipovariablenomi,this.arrDatoGeneral);
			
			TipoVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipovariablenomi,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoVariableNomi(this.tipovariablenomi)) {			
				TipoVariableNomiDataAccess.save(this.tipovariablenomi, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipovariablenomi,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoVariableNomiLogicAdditional.checkTipoVariableNomiToSaveAfter(this.tipovariablenomi,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipovariablenomi.getIsDeleted()) {
				this.tipovariablenomi=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoVariableNomisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVariableNomi.class.getSimpleName()+"-saveTipoVariableNomisWithConnection");connexion.begin();			
			
			TipoVariableNomiLogicAdditional.checkTipoVariableNomiToSaves(tipovariablenomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoVariableNomis();
			
			Boolean validadoTodosTipoVariableNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoVariableNomi tipovariablenomiLocal:tipovariablenomis) {		
				if(tipovariablenomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoVariableNomiLogicAdditional.updateTipoVariableNomiToSave(tipovariablenomiLocal,this.arrDatoGeneral);
	        	
				TipoVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipovariablenomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoVariableNomi(tipovariablenomiLocal)) {
					TipoVariableNomiDataAccess.save(tipovariablenomiLocal, connexion);				
				} else {
					validadoTodosTipoVariableNomi=false;
				}
			}
			
			if(!validadoTodosTipoVariableNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoVariableNomiLogicAdditional.checkTipoVariableNomiToSavesAfter(tipovariablenomis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoVariableNomis();
			
			connexion.commit();		
			
			this.quitarTipoVariableNomisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoVariableNomis()throws Exception {				
		 try {	
			TipoVariableNomiLogicAdditional.checkTipoVariableNomiToSaves(tipovariablenomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoVariableNomi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoVariableNomi tipovariablenomiLocal:tipovariablenomis) {				
				if(tipovariablenomiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoVariableNomiLogicAdditional.updateTipoVariableNomiToSave(tipovariablenomiLocal,this.arrDatoGeneral);
	        	
				TipoVariableNomiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipovariablenomiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoVariableNomi(tipovariablenomiLocal)) {				
					TipoVariableNomiDataAccess.save(tipovariablenomiLocal, connexion);				
				} else {
					validadoTodosTipoVariableNomi=false;
				}
			}
			
			if(!validadoTodosTipoVariableNomi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoVariableNomiLogicAdditional.checkTipoVariableNomiToSavesAfter(tipovariablenomis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoVariableNomisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoVariableNomiParameterReturnGeneral procesarAccionTipoVariableNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoVariableNomi> tipovariablenomis,TipoVariableNomiParameterReturnGeneral tipovariablenomiParameterGeneral)throws Exception {
		 try {	
			TipoVariableNomiParameterReturnGeneral tipovariablenomiReturnGeneral=new TipoVariableNomiParameterReturnGeneral();
	
			TipoVariableNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipovariablenomis,tipovariablenomiParameterGeneral,tipovariablenomiReturnGeneral);
			
			return tipovariablenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoVariableNomiParameterReturnGeneral procesarAccionTipoVariableNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoVariableNomi> tipovariablenomis,TipoVariableNomiParameterReturnGeneral tipovariablenomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVariableNomi.class.getSimpleName()+"-procesarAccionTipoVariableNomisWithConnection");connexion.begin();			
			
			TipoVariableNomiParameterReturnGeneral tipovariablenomiReturnGeneral=new TipoVariableNomiParameterReturnGeneral();
	
			TipoVariableNomiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipovariablenomis,tipovariablenomiParameterGeneral,tipovariablenomiReturnGeneral);
			
			this.connexion.commit();
			
			return tipovariablenomiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoVariableNomiParameterReturnGeneral procesarEventosTipoVariableNomis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoVariableNomi> tipovariablenomis,TipoVariableNomi tipovariablenomi,TipoVariableNomiParameterReturnGeneral tipovariablenomiParameterGeneral,Boolean isEsNuevoTipoVariableNomi,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoVariableNomiParameterReturnGeneral tipovariablenomiReturnGeneral=new TipoVariableNomiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipovariablenomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoVariableNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipovariablenomis,tipovariablenomi,tipovariablenomiParameterGeneral,tipovariablenomiReturnGeneral,isEsNuevoTipoVariableNomi,clases);
			
			return tipovariablenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoVariableNomiParameterReturnGeneral procesarEventosTipoVariableNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoVariableNomi> tipovariablenomis,TipoVariableNomi tipovariablenomi,TipoVariableNomiParameterReturnGeneral tipovariablenomiParameterGeneral,Boolean isEsNuevoTipoVariableNomi,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVariableNomi.class.getSimpleName()+"-procesarEventosTipoVariableNomisWithConnection");connexion.begin();			
			
			TipoVariableNomiParameterReturnGeneral tipovariablenomiReturnGeneral=new TipoVariableNomiParameterReturnGeneral();
	
			tipovariablenomiReturnGeneral.setTipoVariableNomi(tipovariablenomi);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipovariablenomiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoVariableNomiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipovariablenomis,tipovariablenomi,tipovariablenomiParameterGeneral,tipovariablenomiReturnGeneral,isEsNuevoTipoVariableNomi,clases);
			
			this.connexion.commit();
			
			return tipovariablenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoVariableNomiParameterReturnGeneral procesarImportacionTipoVariableNomisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoVariableNomiParameterReturnGeneral tipovariablenomiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVariableNomi.class.getSimpleName()+"-procesarImportacionTipoVariableNomisWithConnection");connexion.begin();			
			
			TipoVariableNomiParameterReturnGeneral tipovariablenomiReturnGeneral=new TipoVariableNomiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipovariablenomis=new ArrayList<TipoVariableNomi>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipovariablenomi=new TipoVariableNomi();
				
				
				if(conColumnasBase) {this.tipovariablenomi.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipovariablenomi.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipovariablenomi.setcodigo(arrColumnas[iColumn++]);
				this.tipovariablenomi.setnombre(arrColumnas[iColumn++]);
				
				this.tipovariablenomis.add(this.tipovariablenomi);
			}
			
			this.saveTipoVariableNomis();
			
			this.connexion.commit();
			
			tipovariablenomiReturnGeneral.setConRetornoEstaProcesado(true);
			tipovariablenomiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipovariablenomiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoVariableNomisEliminados() throws Exception {				
		
		List<TipoVariableNomi> tipovariablenomisAux= new ArrayList<TipoVariableNomi>();
		
		for(TipoVariableNomi tipovariablenomi:tipovariablenomis) {
			if(!tipovariablenomi.getIsDeleted()) {
				tipovariablenomisAux.add(tipovariablenomi);
			}
		}
		
		tipovariablenomis=tipovariablenomisAux;
	}
	
	public void quitarTipoVariableNomisNulos() throws Exception {				
		
		List<TipoVariableNomi> tipovariablenomisAux= new ArrayList<TipoVariableNomi>();
		
		for(TipoVariableNomi tipovariablenomi : this.tipovariablenomis) {
			if(tipovariablenomi==null) {
				tipovariablenomisAux.add(tipovariablenomi);
			}
		}
		
		//this.tipovariablenomis=tipovariablenomisAux;
		
		this.tipovariablenomis.removeAll(tipovariablenomisAux);
	}
	
	public void getSetVersionRowTipoVariableNomiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipovariablenomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipovariablenomi.getIsDeleted() || (tipovariablenomi.getIsChanged()&&!tipovariablenomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipovariablenomiDataAccess.getSetVersionRowTipoVariableNomi(connexion,tipovariablenomi.getId());
				
				if(!tipovariablenomi.getVersionRow().equals(timestamp)) {	
					tipovariablenomi.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipovariablenomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoVariableNomi()throws Exception {	
		
		if(tipovariablenomi.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipovariablenomi.getIsDeleted() || (tipovariablenomi.getIsChanged()&&!tipovariablenomi.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipovariablenomiDataAccess.getSetVersionRowTipoVariableNomi(connexion,tipovariablenomi.getId());
			
			try {							
				if(!tipovariablenomi.getVersionRow().equals(timestamp)) {	
					tipovariablenomi.setVersionRow(timestamp);
				}
				
				tipovariablenomi.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoVariableNomisWithConnection()throws Exception {	
		if(tipovariablenomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoVariableNomi tipovariablenomiAux:tipovariablenomis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipovariablenomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipovariablenomiAux.getIsDeleted() || (tipovariablenomiAux.getIsChanged()&&!tipovariablenomiAux.getIsNew())) {
						
						timestamp=tipovariablenomiDataAccess.getSetVersionRowTipoVariableNomi(connexion,tipovariablenomiAux.getId());
						
						if(!tipovariablenomi.getVersionRow().equals(timestamp)) {	
							tipovariablenomiAux.setVersionRow(timestamp);
						}
								
						tipovariablenomiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoVariableNomis()throws Exception {	
		if(tipovariablenomis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoVariableNomi tipovariablenomiAux:tipovariablenomis) {
					if(tipovariablenomiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipovariablenomiAux.getIsDeleted() || (tipovariablenomiAux.getIsChanged()&&!tipovariablenomiAux.getIsNew())) {
						
						timestamp=tipovariablenomiDataAccess.getSetVersionRowTipoVariableNomi(connexion,tipovariablenomiAux.getId());
						
						if(!tipovariablenomiAux.getVersionRow().equals(timestamp)) {	
							tipovariablenomiAux.setVersionRow(timestamp);
						}
						
													
						tipovariablenomiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoVariableNomiWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			VariableNomiLogic variablenomiLogic=new VariableNomiLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoVariableNomi.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoVariableNomiWithConnection");connexion.begin();
			
			
			classes.add(new Classe(VariableNomi.class));
											
			

			variablenomiLogic.setConnexion(this.getConnexion());
			variablenomiLogic.setDatosCliente(this.datosCliente);
			variablenomiLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoVariableNomi tipovariablenomi:this.tipovariablenomis) {
				

				classes=new ArrayList<Classe>();
				classes=VariableNomiConstantesFunciones.getClassesForeignKeysOfVariableNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				variablenomiLogic.setVariableNomis(tipovariablenomi.variablenomis);
				variablenomiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoVariableNomi tipovariablenomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoVariableNomiLogicAdditional.updateTipoVariableNomiToGet(tipovariablenomi,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipovariablenomi.setVariableNomis(tipovariablenomiDataAccess.getVariableNomis(connexion,tipovariablenomi));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(VariableNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipovariablenomi.setVariableNomis(tipovariablenomiDataAccess.getVariableNomis(connexion,tipovariablenomi));

				if(this.isConDeep) {
					VariableNomiLogic variablenomiLogic= new VariableNomiLogic(this.connexion);
					variablenomiLogic.setVariableNomis(tipovariablenomi.getVariableNomis());
					ArrayList<Classe> classesLocal=VariableNomiConstantesFunciones.getClassesForeignKeysOfVariableNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					variablenomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					VariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesVariableNomi(variablenomiLogic.getVariableNomis());
					tipovariablenomi.setVariableNomis(variablenomiLogic.getVariableNomis());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(VariableNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(VariableNomi.class));
			tipovariablenomi.setVariableNomis(tipovariablenomiDataAccess.getVariableNomis(connexion,tipovariablenomi));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipovariablenomi.setVariableNomis(tipovariablenomiDataAccess.getVariableNomis(connexion,tipovariablenomi));

		for(VariableNomi variablenomi:tipovariablenomi.getVariableNomis()) {
			VariableNomiLogic variablenomiLogic= new VariableNomiLogic(connexion);
			variablenomiLogic.deepLoad(variablenomi,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(VariableNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipovariablenomi.setVariableNomis(tipovariablenomiDataAccess.getVariableNomis(connexion,tipovariablenomi));

				for(VariableNomi variablenomi:tipovariablenomi.getVariableNomis()) {
					VariableNomiLogic variablenomiLogic= new VariableNomiLogic(connexion);
					variablenomiLogic.deepLoad(variablenomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(VariableNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(VariableNomi.class));
			tipovariablenomi.setVariableNomis(tipovariablenomiDataAccess.getVariableNomis(connexion,tipovariablenomi));

			for(VariableNomi variablenomi:tipovariablenomi.getVariableNomis()) {
				VariableNomiLogic variablenomiLogic= new VariableNomiLogic(connexion);
				variablenomiLogic.deepLoad(variablenomi,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoVariableNomi tipovariablenomi,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoVariableNomiLogicAdditional.updateTipoVariableNomiToSave(tipovariablenomi,this.arrDatoGeneral);
			
TipoVariableNomiDataAccess.save(tipovariablenomi, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(VariableNomi variablenomi:tipovariablenomi.getVariableNomis()) {
			variablenomi.setid_tipo_variable_nomi(tipovariablenomi.getId());
			VariableNomiDataAccess.save(variablenomi,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(VariableNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(VariableNomi variablenomi:tipovariablenomi.getVariableNomis()) {
					variablenomi.setid_tipo_variable_nomi(tipovariablenomi.getId());
					VariableNomiDataAccess.save(variablenomi,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(VariableNomi variablenomi:tipovariablenomi.getVariableNomis()) {
			VariableNomiLogic variablenomiLogic= new VariableNomiLogic(connexion);
			variablenomi.setid_tipo_variable_nomi(tipovariablenomi.getId());
			VariableNomiDataAccess.save(variablenomi,connexion);
			variablenomiLogic.deepSave(variablenomi,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(VariableNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(VariableNomi variablenomi:tipovariablenomi.getVariableNomis()) {
					VariableNomiLogic variablenomiLogic= new VariableNomiLogic(connexion);
					variablenomi.setid_tipo_variable_nomi(tipovariablenomi.getId());
					VariableNomiDataAccess.save(variablenomi,connexion);
					variablenomiLogic.deepSave(variablenomi,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoVariableNomi.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipovariablenomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoVariableNomi(tipovariablenomi);
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
			this.deepLoad(this.tipovariablenomi,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoVariableNomi(this.tipovariablenomi);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoVariableNomi.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipovariablenomis!=null) {
				for(TipoVariableNomi tipovariablenomi:tipovariablenomis) {
					this.deepLoad(tipovariablenomi,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoVariableNomi(tipovariablenomis);
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
			if(tipovariablenomis!=null) {
				for(TipoVariableNomi tipovariablenomi:tipovariablenomis) {
					this.deepLoad(tipovariablenomi,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoVariableNomiConstantesFunciones.refrescarForeignKeysDescripcionesTipoVariableNomi(tipovariablenomis);
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
			this.getNewConnexionToDeep(TipoVariableNomi.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipovariablenomi,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoVariableNomi.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipovariablenomis!=null) {
				for(TipoVariableNomi tipovariablenomi:tipovariablenomis) {
					this.deepSave(tipovariablenomi,isDeep,deepLoadType,clases);
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
			if(tipovariablenomis!=null) {
				for(TipoVariableNomi tipovariablenomi:tipovariablenomis) {
					this.deepSave(tipovariablenomi,isDeep,deepLoadType,clases);
				}		
			}
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
			if(TipoVariableNomiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoVariableNomiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoVariableNomi tipovariablenomi,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoVariableNomiConstantesFunciones.ISCONAUDITORIA) {
				if(tipovariablenomi.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoVariableNomiDataAccess.TABLENAME, tipovariablenomi.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoVariableNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoVariableNomiLogic.registrarAuditoriaDetallesTipoVariableNomi(connexion,tipovariablenomi,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipovariablenomi.getIsDeleted()) {
					/*if(!tipovariablenomi.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoVariableNomiDataAccess.TABLENAME, tipovariablenomi.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoVariableNomiLogic.registrarAuditoriaDetallesTipoVariableNomi(connexion,tipovariablenomi,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoVariableNomiDataAccess.TABLENAME, tipovariablenomi.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipovariablenomi.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoVariableNomiDataAccess.TABLENAME, tipovariablenomi.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoVariableNomiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoVariableNomiLogic.registrarAuditoriaDetallesTipoVariableNomi(connexion,tipovariablenomi,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoVariableNomi(Connexion connexion,TipoVariableNomi tipovariablenomi)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipovariablenomi.getIsNew()||!tipovariablenomi.getcodigo().equals(tipovariablenomi.getTipoVariableNomiOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipovariablenomi.getTipoVariableNomiOriginal().getcodigo()!=null)
				{
					strValorActual=tipovariablenomi.getTipoVariableNomiOriginal().getcodigo();
				}
				if(tipovariablenomi.getcodigo()!=null)
				{
					strValorNuevo=tipovariablenomi.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoVariableNomiConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipovariablenomi.getIsNew()||!tipovariablenomi.getnombre().equals(tipovariablenomi.getTipoVariableNomiOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipovariablenomi.getTipoVariableNomiOriginal().getnombre()!=null)
				{
					strValorActual=tipovariablenomi.getTipoVariableNomiOriginal().getnombre();
				}
				if(tipovariablenomi.getnombre()!=null)
				{
					strValorNuevo=tipovariablenomi.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoVariableNomiConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoVariableNomiRelacionesWithConnection(TipoVariableNomi tipovariablenomi,List<VariableNomi> variablenomis) throws Exception {

		if(!tipovariablenomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoVariableNomiRelacionesBase(tipovariablenomi,variablenomis,true);
		}
	}

	public void saveTipoVariableNomiRelaciones(TipoVariableNomi tipovariablenomi,List<VariableNomi> variablenomis)throws Exception {

		if(!tipovariablenomi.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoVariableNomiRelacionesBase(tipovariablenomi,variablenomis,false);
		}
	}

	public void saveTipoVariableNomiRelacionesBase(TipoVariableNomi tipovariablenomi,List<VariableNomi> variablenomis,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoVariableNomi-saveRelacionesWithConnection");}
	
			tipovariablenomi.setVariableNomis(variablenomis);

			this.setTipoVariableNomi(tipovariablenomi);

				if((tipovariablenomi.getIsNew()||tipovariablenomi.getIsChanged())&&!tipovariablenomi.getIsDeleted()) {
					this.saveTipoVariableNomi();
					this.saveTipoVariableNomiRelacionesDetalles(variablenomis);

				} else if(tipovariablenomi.getIsDeleted()) {
					this.saveTipoVariableNomiRelacionesDetalles(variablenomis);
					this.saveTipoVariableNomi();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			VariableNomiConstantesFunciones.InicializarGeneralEntityAuxiliaresVariableNomis(variablenomis,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoVariableNomiRelacionesDetalles(List<VariableNomi> variablenomis)throws Exception {
		try {
	

			Long idTipoVariableNomiActual=this.getTipoVariableNomi().getId();

			VariableNomiLogic variablenomiLogic_Desde_TipoVariableNomi=new VariableNomiLogic();
			variablenomiLogic_Desde_TipoVariableNomi.setVariableNomis(variablenomis);

			variablenomiLogic_Desde_TipoVariableNomi.setConnexion(this.getConnexion());
			variablenomiLogic_Desde_TipoVariableNomi.setDatosCliente(this.datosCliente);

			for(VariableNomi variablenomi_Desde_TipoVariableNomi:variablenomiLogic_Desde_TipoVariableNomi.getVariableNomis()) {
				variablenomi_Desde_TipoVariableNomi.setid_tipo_variable_nomi(idTipoVariableNomiActual);
			}

			variablenomiLogic_Desde_TipoVariableNomi.saveVariableNomis();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoVariableNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoVariableNomiConstantesFunciones.getClassesForeignKeysOfTipoVariableNomi(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoVariableNomi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoVariableNomiConstantesFunciones.getClassesRelationshipsOfTipoVariableNomi(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

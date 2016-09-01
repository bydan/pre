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
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.TipoFlujoEfectivoConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoFlujoEfectivoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoFlujoEfectivoParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.TipoFlujoEfectivo;
import com.bydan.erp.contabilidad.business.logic.TipoFlujoEfectivoLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoFlujoEfectivoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoFlujoEfectivoLogic.class);
	
	protected TipoFlujoEfectivoDataAccess tipoflujoefectivoDataAccess; 	
	protected TipoFlujoEfectivo tipoflujoefectivo;
	protected List<TipoFlujoEfectivo> tipoflujoefectivos;
	protected Object tipoflujoefectivoObject;	
	protected List<Object> tipoflujoefectivosObject;
	
	public static ClassValidator<TipoFlujoEfectivo> tipoflujoefectivoValidator = new ClassValidator<TipoFlujoEfectivo>(TipoFlujoEfectivo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoFlujoEfectivoLogicAdditional tipoflujoefectivoLogicAdditional=null;
	
	public TipoFlujoEfectivoLogicAdditional getTipoFlujoEfectivoLogicAdditional() {
		return this.tipoflujoefectivoLogicAdditional;
	}
	
	public void setTipoFlujoEfectivoLogicAdditional(TipoFlujoEfectivoLogicAdditional tipoflujoefectivoLogicAdditional) {
		try {
			this.tipoflujoefectivoLogicAdditional=tipoflujoefectivoLogicAdditional;
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
	
	
	
	
	public  TipoFlujoEfectivoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoflujoefectivoDataAccess = new TipoFlujoEfectivoDataAccess();
			
			this.tipoflujoefectivos= new ArrayList<TipoFlujoEfectivo>();
			this.tipoflujoefectivo= new TipoFlujoEfectivo();
			
			this.tipoflujoefectivoObject=new Object();
			this.tipoflujoefectivosObject=new ArrayList<Object>();
				
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
			
			this.tipoflujoefectivoDataAccess.setConnexionType(this.connexionType);
			this.tipoflujoefectivoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoFlujoEfectivoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoflujoefectivoDataAccess = new TipoFlujoEfectivoDataAccess();
			this.tipoflujoefectivos= new ArrayList<TipoFlujoEfectivo>();
			this.tipoflujoefectivo= new TipoFlujoEfectivo();
			this.tipoflujoefectivoObject=new Object();
			this.tipoflujoefectivosObject=new ArrayList<Object>();
			
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
			
			this.tipoflujoefectivoDataAccess.setConnexionType(this.connexionType);
			this.tipoflujoefectivoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoFlujoEfectivo getTipoFlujoEfectivo() throws Exception {	
		TipoFlujoEfectivoLogicAdditional.checkTipoFlujoEfectivoToGet(tipoflujoefectivo,this.datosCliente,this.arrDatoGeneral);
		TipoFlujoEfectivoLogicAdditional.updateTipoFlujoEfectivoToGet(tipoflujoefectivo,this.arrDatoGeneral);
		
		return tipoflujoefectivo;
	}
		
	public void setTipoFlujoEfectivo(TipoFlujoEfectivo newTipoFlujoEfectivo) {
		this.tipoflujoefectivo = newTipoFlujoEfectivo;
	}
	
	public TipoFlujoEfectivoDataAccess getTipoFlujoEfectivoDataAccess() {
		return tipoflujoefectivoDataAccess;
	}
	
	public void setTipoFlujoEfectivoDataAccess(TipoFlujoEfectivoDataAccess newtipoflujoefectivoDataAccess) {
		this.tipoflujoefectivoDataAccess = newtipoflujoefectivoDataAccess;
	}
	
	public List<TipoFlujoEfectivo> getTipoFlujoEfectivos() throws Exception {		
		this.quitarTipoFlujoEfectivosNulos();
		
		TipoFlujoEfectivoLogicAdditional.checkTipoFlujoEfectivoToGets(tipoflujoefectivos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoFlujoEfectivo tipoflujoefectivoLocal: tipoflujoefectivos ) {
			TipoFlujoEfectivoLogicAdditional.updateTipoFlujoEfectivoToGet(tipoflujoefectivoLocal,this.arrDatoGeneral);
		}
		
		return tipoflujoefectivos;
	}
	
	public void setTipoFlujoEfectivos(List<TipoFlujoEfectivo> newTipoFlujoEfectivos) {
		this.tipoflujoefectivos = newTipoFlujoEfectivos;
	}
	
	public Object getTipoFlujoEfectivoObject() {	
		this.tipoflujoefectivoObject=this.tipoflujoefectivoDataAccess.getEntityObject();
		return this.tipoflujoefectivoObject;
	}
		
	public void setTipoFlujoEfectivoObject(Object newTipoFlujoEfectivoObject) {
		this.tipoflujoefectivoObject = newTipoFlujoEfectivoObject;
	}
	
	public List<Object> getTipoFlujoEfectivosObject() {		
		this.tipoflujoefectivosObject=this.tipoflujoefectivoDataAccess.getEntitiesObject();
		return this.tipoflujoefectivosObject;
	}
		
	public void setTipoFlujoEfectivosObject(List<Object> newTipoFlujoEfectivosObject) {
		this.tipoflujoefectivosObject = newTipoFlujoEfectivosObject;
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
		
		if(this.tipoflujoefectivoDataAccess!=null) {
			this.tipoflujoefectivoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFlujoEfectivo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoflujoefectivoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoflujoefectivoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoflujoefectivo = new  TipoFlujoEfectivo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFlujoEfectivo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoflujoefectivo=tipoflujoefectivoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoflujoefectivo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivo);
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
		tipoflujoefectivo = new  TipoFlujoEfectivo();
		  		  
        try {
			
			tipoflujoefectivo=tipoflujoefectivoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoflujoefectivo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoflujoefectivo = new  TipoFlujoEfectivo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFlujoEfectivo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoflujoefectivo=tipoflujoefectivoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoflujoefectivo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivo);
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
		tipoflujoefectivo = new  TipoFlujoEfectivo();
		  		  
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
		tipoflujoefectivo = new  TipoFlujoEfectivo();
		  		  
        try {
			
			tipoflujoefectivo=tipoflujoefectivoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoflujoefectivo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoflujoefectivo = new  TipoFlujoEfectivo();
		  		  
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
		tipoflujoefectivo = new  TipoFlujoEfectivo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFlujoEfectivo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoflujoefectivoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoflujoefectivo = new  TipoFlujoEfectivo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoflujoefectivoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoflujoefectivo = new  TipoFlujoEfectivo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFlujoEfectivo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoflujoefectivoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoflujoefectivo = new  TipoFlujoEfectivo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoflujoefectivoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoflujoefectivo = new  TipoFlujoEfectivo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFlujoEfectivo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoflujoefectivoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoflujoefectivo = new  TipoFlujoEfectivo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoflujoefectivoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoflujoefectivos = new  ArrayList<TipoFlujoEfectivo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFlujoEfectivo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoFlujoEfectivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoflujoefectivos=tipoflujoefectivoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoFlujoEfectivo(tipoflujoefectivos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivos);
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
		tipoflujoefectivos = new  ArrayList<TipoFlujoEfectivo>();
		  		  
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
		tipoflujoefectivos = new  ArrayList<TipoFlujoEfectivo>();
		  		  
        try {			
			TipoFlujoEfectivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoflujoefectivos=tipoflujoefectivoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoFlujoEfectivo(tipoflujoefectivos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoflujoefectivos = new  ArrayList<TipoFlujoEfectivo>();
		  		  
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
		tipoflujoefectivos = new  ArrayList<TipoFlujoEfectivo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFlujoEfectivo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoFlujoEfectivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoflujoefectivos=tipoflujoefectivoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoFlujoEfectivo(tipoflujoefectivos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivos);
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
		tipoflujoefectivos = new  ArrayList<TipoFlujoEfectivo>();
		  		  
        try {
			TipoFlujoEfectivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoflujoefectivos=tipoflujoefectivoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoFlujoEfectivo(tipoflujoefectivos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivos);
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
		tipoflujoefectivos = new  ArrayList<TipoFlujoEfectivo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFlujoEfectivo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFlujoEfectivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoflujoefectivos=tipoflujoefectivoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoFlujoEfectivo(tipoflujoefectivos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivos);
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
		tipoflujoefectivos = new  ArrayList<TipoFlujoEfectivo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFlujoEfectivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoflujoefectivos=tipoflujoefectivoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoFlujoEfectivo(tipoflujoefectivos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoflujoefectivo = new  TipoFlujoEfectivo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFlujoEfectivo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFlujoEfectivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoflujoefectivo=tipoflujoefectivoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoFlujoEfectivo(tipoflujoefectivo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivo);
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
		tipoflujoefectivo = new  TipoFlujoEfectivo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFlujoEfectivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoflujoefectivo=tipoflujoefectivoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoFlujoEfectivo(tipoflujoefectivo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoflujoefectivos = new  ArrayList<TipoFlujoEfectivo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFlujoEfectivo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoFlujoEfectivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoflujoefectivos=tipoflujoefectivoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoFlujoEfectivo(tipoflujoefectivos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivos);
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
		tipoflujoefectivos = new  ArrayList<TipoFlujoEfectivo>();
		  		  
        try {
			TipoFlujoEfectivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoflujoefectivos=tipoflujoefectivoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoFlujoEfectivo(tipoflujoefectivos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoFlujoEfectivosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoflujoefectivos = new  ArrayList<TipoFlujoEfectivo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFlujoEfectivo.class.getSimpleName()+"-getTodosTipoFlujoEfectivosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFlujoEfectivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoflujoefectivos=tipoflujoefectivoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoFlujoEfectivo(tipoflujoefectivos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivos);
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
	
	public  void  getTodosTipoFlujoEfectivos(String sFinalQuery,Pagination pagination)throws Exception {
		tipoflujoefectivos = new  ArrayList<TipoFlujoEfectivo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFlujoEfectivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoflujoefectivos=tipoflujoefectivoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoFlujoEfectivo(tipoflujoefectivos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoFlujoEfectivo(TipoFlujoEfectivo tipoflujoefectivo) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoflujoefectivo.getIsNew() || tipoflujoefectivo.getIsChanged()) { 
			this.invalidValues = tipoflujoefectivoValidator.getInvalidValues(tipoflujoefectivo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoflujoefectivo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoFlujoEfectivo(List<TipoFlujoEfectivo> TipoFlujoEfectivos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoFlujoEfectivo tipoflujoefectivoLocal:tipoflujoefectivos) {				
			estaValidadoObjeto=this.validarGuardarTipoFlujoEfectivo(tipoflujoefectivoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoFlujoEfectivo(List<TipoFlujoEfectivo> TipoFlujoEfectivos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoFlujoEfectivo(tipoflujoefectivos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoFlujoEfectivo(TipoFlujoEfectivo TipoFlujoEfectivo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoFlujoEfectivo(tipoflujoefectivo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoFlujoEfectivo tipoflujoefectivo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoflujoefectivo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoFlujoEfectivoConstantesFunciones.getTipoFlujoEfectivoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoflujoefectivo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoFlujoEfectivoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoFlujoEfectivoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoFlujoEfectivoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFlujoEfectivo.class.getSimpleName()+"-saveTipoFlujoEfectivoWithConnection");connexion.begin();			
			
			TipoFlujoEfectivoLogicAdditional.checkTipoFlujoEfectivoToSave(this.tipoflujoefectivo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoFlujoEfectivoLogicAdditional.updateTipoFlujoEfectivoToSave(this.tipoflujoefectivo,this.arrDatoGeneral);
			
			TipoFlujoEfectivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoflujoefectivo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoFlujoEfectivo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoFlujoEfectivo(this.tipoflujoefectivo)) {
				TipoFlujoEfectivoDataAccess.save(this.tipoflujoefectivo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoflujoefectivo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoFlujoEfectivoLogicAdditional.checkTipoFlujoEfectivoToSaveAfter(this.tipoflujoefectivo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoFlujoEfectivo();
			
			connexion.commit();			
			
			if(this.tipoflujoefectivo.getIsDeleted()) {
				this.tipoflujoefectivo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoFlujoEfectivo()throws Exception {	
		try {	
			
			TipoFlujoEfectivoLogicAdditional.checkTipoFlujoEfectivoToSave(this.tipoflujoefectivo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoFlujoEfectivoLogicAdditional.updateTipoFlujoEfectivoToSave(this.tipoflujoefectivo,this.arrDatoGeneral);
			
			TipoFlujoEfectivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoflujoefectivo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoFlujoEfectivo(this.tipoflujoefectivo)) {			
				TipoFlujoEfectivoDataAccess.save(this.tipoflujoefectivo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoflujoefectivo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoFlujoEfectivoLogicAdditional.checkTipoFlujoEfectivoToSaveAfter(this.tipoflujoefectivo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoflujoefectivo.getIsDeleted()) {
				this.tipoflujoefectivo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoFlujoEfectivosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFlujoEfectivo.class.getSimpleName()+"-saveTipoFlujoEfectivosWithConnection");connexion.begin();			
			
			TipoFlujoEfectivoLogicAdditional.checkTipoFlujoEfectivoToSaves(tipoflujoefectivos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoFlujoEfectivos();
			
			Boolean validadoTodosTipoFlujoEfectivo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoFlujoEfectivo tipoflujoefectivoLocal:tipoflujoefectivos) {		
				if(tipoflujoefectivoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoFlujoEfectivoLogicAdditional.updateTipoFlujoEfectivoToSave(tipoflujoefectivoLocal,this.arrDatoGeneral);
	        	
				TipoFlujoEfectivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoflujoefectivoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoFlujoEfectivo(tipoflujoefectivoLocal)) {
					TipoFlujoEfectivoDataAccess.save(tipoflujoefectivoLocal, connexion);				
				} else {
					validadoTodosTipoFlujoEfectivo=false;
				}
			}
			
			if(!validadoTodosTipoFlujoEfectivo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoFlujoEfectivoLogicAdditional.checkTipoFlujoEfectivoToSavesAfter(tipoflujoefectivos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoFlujoEfectivos();
			
			connexion.commit();		
			
			this.quitarTipoFlujoEfectivosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoFlujoEfectivos()throws Exception {				
		 try {	
			TipoFlujoEfectivoLogicAdditional.checkTipoFlujoEfectivoToSaves(tipoflujoefectivos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoFlujoEfectivo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoFlujoEfectivo tipoflujoefectivoLocal:tipoflujoefectivos) {				
				if(tipoflujoefectivoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoFlujoEfectivoLogicAdditional.updateTipoFlujoEfectivoToSave(tipoflujoefectivoLocal,this.arrDatoGeneral);
	        	
				TipoFlujoEfectivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoflujoefectivoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoFlujoEfectivo(tipoflujoefectivoLocal)) {				
					TipoFlujoEfectivoDataAccess.save(tipoflujoefectivoLocal, connexion);				
				} else {
					validadoTodosTipoFlujoEfectivo=false;
				}
			}
			
			if(!validadoTodosTipoFlujoEfectivo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoFlujoEfectivoLogicAdditional.checkTipoFlujoEfectivoToSavesAfter(tipoflujoefectivos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoFlujoEfectivosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoFlujoEfectivoParameterReturnGeneral procesarAccionTipoFlujoEfectivos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoFlujoEfectivo> tipoflujoefectivos,TipoFlujoEfectivoParameterReturnGeneral tipoflujoefectivoParameterGeneral)throws Exception {
		 try {	
			TipoFlujoEfectivoParameterReturnGeneral tipoflujoefectivoReturnGeneral=new TipoFlujoEfectivoParameterReturnGeneral();
	
			TipoFlujoEfectivoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoflujoefectivos,tipoflujoefectivoParameterGeneral,tipoflujoefectivoReturnGeneral);
			
			return tipoflujoefectivoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoFlujoEfectivoParameterReturnGeneral procesarAccionTipoFlujoEfectivosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoFlujoEfectivo> tipoflujoefectivos,TipoFlujoEfectivoParameterReturnGeneral tipoflujoefectivoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFlujoEfectivo.class.getSimpleName()+"-procesarAccionTipoFlujoEfectivosWithConnection");connexion.begin();			
			
			TipoFlujoEfectivoParameterReturnGeneral tipoflujoefectivoReturnGeneral=new TipoFlujoEfectivoParameterReturnGeneral();
	
			TipoFlujoEfectivoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoflujoefectivos,tipoflujoefectivoParameterGeneral,tipoflujoefectivoReturnGeneral);
			
			this.connexion.commit();
			
			return tipoflujoefectivoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoFlujoEfectivoParameterReturnGeneral procesarEventosTipoFlujoEfectivos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoFlujoEfectivo> tipoflujoefectivos,TipoFlujoEfectivo tipoflujoefectivo,TipoFlujoEfectivoParameterReturnGeneral tipoflujoefectivoParameterGeneral,Boolean isEsNuevoTipoFlujoEfectivo,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoFlujoEfectivoParameterReturnGeneral tipoflujoefectivoReturnGeneral=new TipoFlujoEfectivoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoflujoefectivoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoFlujoEfectivoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoflujoefectivos,tipoflujoefectivo,tipoflujoefectivoParameterGeneral,tipoflujoefectivoReturnGeneral,isEsNuevoTipoFlujoEfectivo,clases);
			
			return tipoflujoefectivoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoFlujoEfectivoParameterReturnGeneral procesarEventosTipoFlujoEfectivosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoFlujoEfectivo> tipoflujoefectivos,TipoFlujoEfectivo tipoflujoefectivo,TipoFlujoEfectivoParameterReturnGeneral tipoflujoefectivoParameterGeneral,Boolean isEsNuevoTipoFlujoEfectivo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFlujoEfectivo.class.getSimpleName()+"-procesarEventosTipoFlujoEfectivosWithConnection");connexion.begin();			
			
			TipoFlujoEfectivoParameterReturnGeneral tipoflujoefectivoReturnGeneral=new TipoFlujoEfectivoParameterReturnGeneral();
	
			tipoflujoefectivoReturnGeneral.setTipoFlujoEfectivo(tipoflujoefectivo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoflujoefectivoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoFlujoEfectivoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoflujoefectivos,tipoflujoefectivo,tipoflujoefectivoParameterGeneral,tipoflujoefectivoReturnGeneral,isEsNuevoTipoFlujoEfectivo,clases);
			
			this.connexion.commit();
			
			return tipoflujoefectivoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoFlujoEfectivoParameterReturnGeneral procesarImportacionTipoFlujoEfectivosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoFlujoEfectivoParameterReturnGeneral tipoflujoefectivoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFlujoEfectivo.class.getSimpleName()+"-procesarImportacionTipoFlujoEfectivosWithConnection");connexion.begin();			
			
			TipoFlujoEfectivoParameterReturnGeneral tipoflujoefectivoReturnGeneral=new TipoFlujoEfectivoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoflujoefectivos=new ArrayList<TipoFlujoEfectivo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoflujoefectivo=new TipoFlujoEfectivo();
				
				
				if(conColumnasBase) {this.tipoflujoefectivo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoflujoefectivo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoflujoefectivo.setnombre(arrColumnas[iColumn++]);
				
				this.tipoflujoefectivos.add(this.tipoflujoefectivo);
			}
			
			this.saveTipoFlujoEfectivos();
			
			this.connexion.commit();
			
			tipoflujoefectivoReturnGeneral.setConRetornoEstaProcesado(true);
			tipoflujoefectivoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoflujoefectivoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoFlujoEfectivosEliminados() throws Exception {				
		
		List<TipoFlujoEfectivo> tipoflujoefectivosAux= new ArrayList<TipoFlujoEfectivo>();
		
		for(TipoFlujoEfectivo tipoflujoefectivo:tipoflujoefectivos) {
			if(!tipoflujoefectivo.getIsDeleted()) {
				tipoflujoefectivosAux.add(tipoflujoefectivo);
			}
		}
		
		tipoflujoefectivos=tipoflujoefectivosAux;
	}
	
	public void quitarTipoFlujoEfectivosNulos() throws Exception {				
		
		List<TipoFlujoEfectivo> tipoflujoefectivosAux= new ArrayList<TipoFlujoEfectivo>();
		
		for(TipoFlujoEfectivo tipoflujoefectivo : this.tipoflujoefectivos) {
			if(tipoflujoefectivo==null) {
				tipoflujoefectivosAux.add(tipoflujoefectivo);
			}
		}
		
		//this.tipoflujoefectivos=tipoflujoefectivosAux;
		
		this.tipoflujoefectivos.removeAll(tipoflujoefectivosAux);
	}
	
	public void getSetVersionRowTipoFlujoEfectivoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoflujoefectivo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoflujoefectivo.getIsDeleted() || (tipoflujoefectivo.getIsChanged()&&!tipoflujoefectivo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoflujoefectivoDataAccess.getSetVersionRowTipoFlujoEfectivo(connexion,tipoflujoefectivo.getId());
				
				if(!tipoflujoefectivo.getVersionRow().equals(timestamp)) {	
					tipoflujoefectivo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoflujoefectivo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoFlujoEfectivo()throws Exception {	
		
		if(tipoflujoefectivo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoflujoefectivo.getIsDeleted() || (tipoflujoefectivo.getIsChanged()&&!tipoflujoefectivo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoflujoefectivoDataAccess.getSetVersionRowTipoFlujoEfectivo(connexion,tipoflujoefectivo.getId());
			
			try {							
				if(!tipoflujoefectivo.getVersionRow().equals(timestamp)) {	
					tipoflujoefectivo.setVersionRow(timestamp);
				}
				
				tipoflujoefectivo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoFlujoEfectivosWithConnection()throws Exception {	
		if(tipoflujoefectivos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoFlujoEfectivo tipoflujoefectivoAux:tipoflujoefectivos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoflujoefectivoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoflujoefectivoAux.getIsDeleted() || (tipoflujoefectivoAux.getIsChanged()&&!tipoflujoefectivoAux.getIsNew())) {
						
						timestamp=tipoflujoefectivoDataAccess.getSetVersionRowTipoFlujoEfectivo(connexion,tipoflujoefectivoAux.getId());
						
						if(!tipoflujoefectivo.getVersionRow().equals(timestamp)) {	
							tipoflujoefectivoAux.setVersionRow(timestamp);
						}
								
						tipoflujoefectivoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoFlujoEfectivos()throws Exception {	
		if(tipoflujoefectivos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoFlujoEfectivo tipoflujoefectivoAux:tipoflujoefectivos) {
					if(tipoflujoefectivoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoflujoefectivoAux.getIsDeleted() || (tipoflujoefectivoAux.getIsChanged()&&!tipoflujoefectivoAux.getIsNew())) {
						
						timestamp=tipoflujoefectivoDataAccess.getSetVersionRowTipoFlujoEfectivo(connexion,tipoflujoefectivoAux.getId());
						
						if(!tipoflujoefectivoAux.getVersionRow().equals(timestamp)) {	
							tipoflujoefectivoAux.setVersionRow(timestamp);
						}
						
													
						tipoflujoefectivoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoFlujoEfectivoParameterReturnGeneral cargarCombosLoteForeignKeyTipoFlujoEfectivoWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoFlujoEfectivoParameterReturnGeneral  tipoflujoefectivoReturnGeneral =new TipoFlujoEfectivoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFlujoEfectivo.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoFlujoEfectivoWithConnection");connexion.begin();
			
			tipoflujoefectivoReturnGeneral =new TipoFlujoEfectivoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoflujoefectivoReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoflujoefectivoReturnGeneral;
	}
	
	public TipoFlujoEfectivoParameterReturnGeneral cargarCombosLoteForeignKeyTipoFlujoEfectivo(String finalQueryGlobalEmpresa) throws Exception {
		TipoFlujoEfectivoParameterReturnGeneral  tipoflujoefectivoReturnGeneral =new TipoFlujoEfectivoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoflujoefectivoReturnGeneral =new TipoFlujoEfectivoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoflujoefectivoReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoflujoefectivoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoFlujoEfectivoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFlujoEfectivo.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoFlujoEfectivoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(CuentaContable.class));
											
			

			cuentacontableLogic.setConnexion(this.getConnexion());
			cuentacontableLogic.setDatosCliente(this.datosCliente);
			cuentacontableLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoFlujoEfectivo tipoflujoefectivo:this.tipoflujoefectivos) {
				

				classes=new ArrayList<Classe>();
				classes=CuentaContableConstantesFunciones.getClassesForeignKeysOfCuentaContable(new ArrayList<Classe>(),DeepLoadType.NONE);

				cuentacontableLogic.setCuentaContables(tipoflujoefectivo.cuentacontables);
				cuentacontableLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoFlujoEfectivo tipoflujoefectivo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoFlujoEfectivoLogicAdditional.updateTipoFlujoEfectivoToGet(tipoflujoefectivo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoflujoefectivo.setEmpresa(tipoflujoefectivoDataAccess.getEmpresa(connexion,tipoflujoefectivo));
		tipoflujoefectivo.setCuentaContables(tipoflujoefectivoDataAccess.getCuentaContables(connexion,tipoflujoefectivo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoflujoefectivo.setEmpresa(tipoflujoefectivoDataAccess.getEmpresa(connexion,tipoflujoefectivo));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoflujoefectivo.setCuentaContables(tipoflujoefectivoDataAccess.getCuentaContables(connexion,tipoflujoefectivo));

				if(this.isConDeep) {
					CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(this.connexion);
					cuentacontableLogic.setCuentaContables(tipoflujoefectivo.getCuentaContables());
					ArrayList<Classe> classesLocal=CuentaContableConstantesFunciones.getClassesForeignKeysOfCuentaContable(new ArrayList<Classe>(),DeepLoadType.NONE);
					cuentacontableLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(cuentacontableLogic.getCuentaContables());
					tipoflujoefectivo.setCuentaContables(cuentacontableLogic.getCuentaContables());
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
			tipoflujoefectivo.setEmpresa(tipoflujoefectivoDataAccess.getEmpresa(connexion,tipoflujoefectivo));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CuentaContable.class));
			tipoflujoefectivo.setCuentaContables(tipoflujoefectivoDataAccess.getCuentaContables(connexion,tipoflujoefectivo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoflujoefectivo.setEmpresa(tipoflujoefectivoDataAccess.getEmpresa(connexion,tipoflujoefectivo));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoflujoefectivo.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipoflujoefectivo.setCuentaContables(tipoflujoefectivoDataAccess.getCuentaContables(connexion,tipoflujoefectivo));

		for(CuentaContable cuentacontable:tipoflujoefectivo.getCuentaContables()) {
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentacontable,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoflujoefectivo.setEmpresa(tipoflujoefectivoDataAccess.getEmpresa(connexion,tipoflujoefectivo));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoflujoefectivo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoflujoefectivo.setCuentaContables(tipoflujoefectivoDataAccess.getCuentaContables(connexion,tipoflujoefectivo));

				for(CuentaContable cuentacontable:tipoflujoefectivo.getCuentaContables()) {
					CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
					cuentacontableLogic.deepLoad(cuentacontable,isDeep,deepLoadType,clases);
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
			tipoflujoefectivo.setEmpresa(tipoflujoefectivoDataAccess.getEmpresa(connexion,tipoflujoefectivo));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoflujoefectivo.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CuentaContable.class));
			tipoflujoefectivo.setCuentaContables(tipoflujoefectivoDataAccess.getCuentaContables(connexion,tipoflujoefectivo));

			for(CuentaContable cuentacontable:tipoflujoefectivo.getCuentaContables()) {
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentacontable,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoFlujoEfectivo tipoflujoefectivo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoFlujoEfectivoLogicAdditional.updateTipoFlujoEfectivoToSave(tipoflujoefectivo,this.arrDatoGeneral);
			
TipoFlujoEfectivoDataAccess.save(tipoflujoefectivo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoflujoefectivo.getEmpresa(),connexion);

		for(CuentaContable cuentacontable:tipoflujoefectivo.getCuentaContables()) {
			cuentacontable.setid_tipo_flujo_efectivo(tipoflujoefectivo.getId());
			CuentaContableDataAccess.save(cuentacontable,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoflujoefectivo.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(CuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CuentaContable cuentacontable:tipoflujoefectivo.getCuentaContables()) {
					cuentacontable.setid_tipo_flujo_efectivo(tipoflujoefectivo.getId());
					CuentaContableDataAccess.save(cuentacontable,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoflujoefectivo.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoflujoefectivo.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(CuentaContable cuentacontable:tipoflujoefectivo.getCuentaContables()) {
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontable.setid_tipo_flujo_efectivo(tipoflujoefectivo.getId());
			CuentaContableDataAccess.save(cuentacontable,connexion);
			cuentacontableLogic.deepSave(cuentacontable,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoflujoefectivo.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipoflujoefectivo.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(CuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CuentaContable cuentacontable:tipoflujoefectivo.getCuentaContables()) {
					CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
					cuentacontable.setid_tipo_flujo_efectivo(tipoflujoefectivo.getId());
					CuentaContableDataAccess.save(cuentacontable,connexion);
					cuentacontableLogic.deepSave(cuentacontable,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoFlujoEfectivo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoflujoefectivo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(tipoflujoefectivo);
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
			this.deepLoad(this.tipoflujoefectivo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoFlujoEfectivo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoflujoefectivos!=null) {
				for(TipoFlujoEfectivo tipoflujoefectivo:tipoflujoefectivos) {
					this.deepLoad(tipoflujoefectivo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(tipoflujoefectivos);
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
			if(tipoflujoefectivos!=null) {
				for(TipoFlujoEfectivo tipoflujoefectivo:tipoflujoefectivos) {
					this.deepLoad(tipoflujoefectivo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(tipoflujoefectivos);
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
			this.getNewConnexionToDeep(TipoFlujoEfectivo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoflujoefectivo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoFlujoEfectivo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoflujoefectivos!=null) {
				for(TipoFlujoEfectivo tipoflujoefectivo:tipoflujoefectivos) {
					this.deepSave(tipoflujoefectivo,isDeep,deepLoadType,clases);
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
			if(tipoflujoefectivos!=null) {
				for(TipoFlujoEfectivo tipoflujoefectivo:tipoflujoefectivos) {
					this.deepSave(tipoflujoefectivo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoFlujoEfectivosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFlujoEfectivo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoFlujoEfectivoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoFlujoEfectivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoflujoefectivos=tipoflujoefectivoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoFlujoEfectivosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoFlujoEfectivoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoFlujoEfectivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoflujoefectivos=tipoflujoefectivoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoFlujoEfectivosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFlujoEfectivo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoFlujoEfectivoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoFlujoEfectivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoflujoefectivos=tipoflujoefectivoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoFlujoEfectivosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoFlujoEfectivoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoFlujoEfectivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoflujoefectivos=tipoflujoefectivoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoFlujoEfectivoPorNombreWithConnection(String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFlujoEfectivo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoFlujoEfectivoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipoflujoefectivo=tipoflujoefectivoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipoflujoefectivo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivo);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoFlujoEfectivoPorNombre(String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoFlujoEfectivoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipoflujoefectivo=tipoflujoefectivoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipoflujoefectivo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoFlujoEfectivoConstantesFunciones.refrescarForeignKeysDescripcionesTipoFlujoEfectivo(this.tipoflujoefectivo);
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
			if(TipoFlujoEfectivoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoFlujoEfectivoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoFlujoEfectivo tipoflujoefectivo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoFlujoEfectivoConstantesFunciones.ISCONAUDITORIA) {
				if(tipoflujoefectivo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoFlujoEfectivoDataAccess.TABLENAME, tipoflujoefectivo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoFlujoEfectivoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoFlujoEfectivoLogic.registrarAuditoriaDetallesTipoFlujoEfectivo(connexion,tipoflujoefectivo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoflujoefectivo.getIsDeleted()) {
					/*if(!tipoflujoefectivo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoFlujoEfectivoDataAccess.TABLENAME, tipoflujoefectivo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoFlujoEfectivoLogic.registrarAuditoriaDetallesTipoFlujoEfectivo(connexion,tipoflujoefectivo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoFlujoEfectivoDataAccess.TABLENAME, tipoflujoefectivo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoflujoefectivo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoFlujoEfectivoDataAccess.TABLENAME, tipoflujoefectivo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoFlujoEfectivoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoFlujoEfectivoLogic.registrarAuditoriaDetallesTipoFlujoEfectivo(connexion,tipoflujoefectivo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoFlujoEfectivo(Connexion connexion,TipoFlujoEfectivo tipoflujoefectivo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoflujoefectivo.getIsNew()||!tipoflujoefectivo.getid_empresa().equals(tipoflujoefectivo.getTipoFlujoEfectivoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoflujoefectivo.getTipoFlujoEfectivoOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoflujoefectivo.getTipoFlujoEfectivoOriginal().getid_empresa().toString();
				}
				if(tipoflujoefectivo.getid_empresa()!=null)
				{
					strValorNuevo=tipoflujoefectivo.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoFlujoEfectivoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoflujoefectivo.getIsNew()||!tipoflujoefectivo.getnombre().equals(tipoflujoefectivo.getTipoFlujoEfectivoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoflujoefectivo.getTipoFlujoEfectivoOriginal().getnombre()!=null)
				{
					strValorActual=tipoflujoefectivo.getTipoFlujoEfectivoOriginal().getnombre();
				}
				if(tipoflujoefectivo.getnombre()!=null)
				{
					strValorNuevo=tipoflujoefectivo.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoFlujoEfectivoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoFlujoEfectivoRelacionesWithConnection(TipoFlujoEfectivo tipoflujoefectivo,List<CuentaContable> cuentacontables) throws Exception {

		if(!tipoflujoefectivo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoFlujoEfectivoRelacionesBase(tipoflujoefectivo,cuentacontables,true);
		}
	}

	public void saveTipoFlujoEfectivoRelaciones(TipoFlujoEfectivo tipoflujoefectivo,List<CuentaContable> cuentacontables)throws Exception {

		if(!tipoflujoefectivo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoFlujoEfectivoRelacionesBase(tipoflujoefectivo,cuentacontables,false);
		}
	}

	public void saveTipoFlujoEfectivoRelacionesBase(TipoFlujoEfectivo tipoflujoefectivo,List<CuentaContable> cuentacontables,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoFlujoEfectivo-saveRelacionesWithConnection");}
	
			tipoflujoefectivo.setCuentaContables(cuentacontables);

			this.setTipoFlujoEfectivo(tipoflujoefectivo);

			if(TipoFlujoEfectivoLogicAdditional.validarSaveRelaciones(tipoflujoefectivo,this)) {

				TipoFlujoEfectivoLogicAdditional.updateRelacionesToSave(tipoflujoefectivo,this);

				if((tipoflujoefectivo.getIsNew()||tipoflujoefectivo.getIsChanged())&&!tipoflujoefectivo.getIsDeleted()) {
					this.saveTipoFlujoEfectivo();
					this.saveTipoFlujoEfectivoRelacionesDetalles(cuentacontables);

				} else if(tipoflujoefectivo.getIsDeleted()) {
					this.saveTipoFlujoEfectivoRelacionesDetalles(cuentacontables);
					this.saveTipoFlujoEfectivo();
				}

				TipoFlujoEfectivoLogicAdditional.updateRelacionesToSaveAfter(tipoflujoefectivo,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			CuentaContableConstantesFunciones.InicializarGeneralEntityAuxiliaresCuentaContables(cuentacontables,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoFlujoEfectivoRelacionesDetalles(List<CuentaContable> cuentacontables)throws Exception {
		try {
	

			Long idTipoFlujoEfectivoActual=this.getTipoFlujoEfectivo().getId();

			CuentaContableLogic cuentacontableLogic_Desde_TipoFlujoEfectivo=new CuentaContableLogic();
			cuentacontableLogic_Desde_TipoFlujoEfectivo.setCuentaContables(cuentacontables);

			cuentacontableLogic_Desde_TipoFlujoEfectivo.setConnexion(this.getConnexion());
			cuentacontableLogic_Desde_TipoFlujoEfectivo.setDatosCliente(this.datosCliente);

			for(CuentaContable cuentacontable_Desde_TipoFlujoEfectivo:cuentacontableLogic_Desde_TipoFlujoEfectivo.getCuentaContables()) {
				cuentacontable_Desde_TipoFlujoEfectivo.setid_tipo_flujo_efectivo(idTipoFlujoEfectivoActual);
			}

			cuentacontableLogic_Desde_TipoFlujoEfectivo.saveCuentaContables();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoFlujoEfectivo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoFlujoEfectivoConstantesFunciones.getClassesForeignKeysOfTipoFlujoEfectivo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFlujoEfectivo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoFlujoEfectivoConstantesFunciones.getClassesRelationshipsOfTipoFlujoEfectivo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

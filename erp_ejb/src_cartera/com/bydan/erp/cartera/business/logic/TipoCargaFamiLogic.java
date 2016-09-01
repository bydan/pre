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
package com.bydan.erp.cartera.business.logic;

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
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.cartera.util.TipoCargaFamiConstantesFunciones;
import com.bydan.erp.cartera.util.TipoCargaFamiParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoCargaFamiParameterGeneral;
import com.bydan.erp.cartera.business.entity.TipoCargaFami;
import com.bydan.erp.cartera.business.logic.TipoCargaFamiLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.nomina.util.*;


import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoCargaFamiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoCargaFamiLogic.class);
	
	protected TipoCargaFamiDataAccess tipocargafamiDataAccess; 	
	protected TipoCargaFami tipocargafami;
	protected List<TipoCargaFami> tipocargafamis;
	protected Object tipocargafamiObject;	
	protected List<Object> tipocargafamisObject;
	
	public static ClassValidator<TipoCargaFami> tipocargafamiValidator = new ClassValidator<TipoCargaFami>(TipoCargaFami.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoCargaFamiLogicAdditional tipocargafamiLogicAdditional=null;
	
	public TipoCargaFamiLogicAdditional getTipoCargaFamiLogicAdditional() {
		return this.tipocargafamiLogicAdditional;
	}
	
	public void setTipoCargaFamiLogicAdditional(TipoCargaFamiLogicAdditional tipocargafamiLogicAdditional) {
		try {
			this.tipocargafamiLogicAdditional=tipocargafamiLogicAdditional;
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
	
	
	
	
	public  TipoCargaFamiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipocargafamiDataAccess = new TipoCargaFamiDataAccess();
			
			this.tipocargafamis= new ArrayList<TipoCargaFami>();
			this.tipocargafami= new TipoCargaFami();
			
			this.tipocargafamiObject=new Object();
			this.tipocargafamisObject=new ArrayList<Object>();
				
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
			
			this.tipocargafamiDataAccess.setConnexionType(this.connexionType);
			this.tipocargafamiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoCargaFamiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipocargafamiDataAccess = new TipoCargaFamiDataAccess();
			this.tipocargafamis= new ArrayList<TipoCargaFami>();
			this.tipocargafami= new TipoCargaFami();
			this.tipocargafamiObject=new Object();
			this.tipocargafamisObject=new ArrayList<Object>();
			
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
			
			this.tipocargafamiDataAccess.setConnexionType(this.connexionType);
			this.tipocargafamiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoCargaFami getTipoCargaFami() throws Exception {	
		TipoCargaFamiLogicAdditional.checkTipoCargaFamiToGet(tipocargafami,this.datosCliente,this.arrDatoGeneral);
		TipoCargaFamiLogicAdditional.updateTipoCargaFamiToGet(tipocargafami,this.arrDatoGeneral);
		
		return tipocargafami;
	}
		
	public void setTipoCargaFami(TipoCargaFami newTipoCargaFami) {
		this.tipocargafami = newTipoCargaFami;
	}
	
	public TipoCargaFamiDataAccess getTipoCargaFamiDataAccess() {
		return tipocargafamiDataAccess;
	}
	
	public void setTipoCargaFamiDataAccess(TipoCargaFamiDataAccess newtipocargafamiDataAccess) {
		this.tipocargafamiDataAccess = newtipocargafamiDataAccess;
	}
	
	public List<TipoCargaFami> getTipoCargaFamis() throws Exception {		
		this.quitarTipoCargaFamisNulos();
		
		TipoCargaFamiLogicAdditional.checkTipoCargaFamiToGets(tipocargafamis,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoCargaFami tipocargafamiLocal: tipocargafamis ) {
			TipoCargaFamiLogicAdditional.updateTipoCargaFamiToGet(tipocargafamiLocal,this.arrDatoGeneral);
		}
		
		return tipocargafamis;
	}
	
	public void setTipoCargaFamis(List<TipoCargaFami> newTipoCargaFamis) {
		this.tipocargafamis = newTipoCargaFamis;
	}
	
	public Object getTipoCargaFamiObject() {	
		this.tipocargafamiObject=this.tipocargafamiDataAccess.getEntityObject();
		return this.tipocargafamiObject;
	}
		
	public void setTipoCargaFamiObject(Object newTipoCargaFamiObject) {
		this.tipocargafamiObject = newTipoCargaFamiObject;
	}
	
	public List<Object> getTipoCargaFamisObject() {		
		this.tipocargafamisObject=this.tipocargafamiDataAccess.getEntitiesObject();
		return this.tipocargafamisObject;
	}
		
	public void setTipoCargaFamisObject(List<Object> newTipoCargaFamisObject) {
		this.tipocargafamisObject = newTipoCargaFamisObject;
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
		
		if(this.tipocargafamiDataAccess!=null) {
			this.tipocargafamiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCargaFami.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipocargafamiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipocargafamiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipocargafami = new  TipoCargaFami();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCargaFami.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocargafami=tipocargafamiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocargafami,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCargaFamiConstantesFunciones.refrescarForeignKeysDescripcionesTipoCargaFami(this.tipocargafami);
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
		tipocargafami = new  TipoCargaFami();
		  		  
        try {
			
			tipocargafami=tipocargafamiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocargafami,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCargaFamiConstantesFunciones.refrescarForeignKeysDescripcionesTipoCargaFami(this.tipocargafami);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipocargafami = new  TipoCargaFami();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCargaFami.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocargafami=tipocargafamiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocargafami,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCargaFamiConstantesFunciones.refrescarForeignKeysDescripcionesTipoCargaFami(this.tipocargafami);
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
		tipocargafami = new  TipoCargaFami();
		  		  
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
		tipocargafami = new  TipoCargaFami();
		  		  
        try {
			
			tipocargafami=tipocargafamiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocargafami,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCargaFamiConstantesFunciones.refrescarForeignKeysDescripcionesTipoCargaFami(this.tipocargafami);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipocargafami = new  TipoCargaFami();
		  		  
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
		tipocargafami = new  TipoCargaFami();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCargaFami.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipocargafamiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocargafami = new  TipoCargaFami();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipocargafamiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocargafami = new  TipoCargaFami();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCargaFami.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipocargafamiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocargafami = new  TipoCargaFami();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipocargafamiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocargafami = new  TipoCargaFami();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCargaFami.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipocargafamiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocargafami = new  TipoCargaFami();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipocargafamiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocargafamis = new  ArrayList<TipoCargaFami>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCargaFami.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoCargaFamiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocargafamis=tipocargafamiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCargaFami(tipocargafamis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCargaFamiConstantesFunciones.refrescarForeignKeysDescripcionesTipoCargaFami(this.tipocargafamis);
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
		tipocargafamis = new  ArrayList<TipoCargaFami>();
		  		  
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
		tipocargafamis = new  ArrayList<TipoCargaFami>();
		  		  
        try {			
			TipoCargaFamiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocargafamis=tipocargafamiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoCargaFami(tipocargafamis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCargaFamiConstantesFunciones.refrescarForeignKeysDescripcionesTipoCargaFami(this.tipocargafamis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipocargafamis = new  ArrayList<TipoCargaFami>();
		  		  
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
		tipocargafamis = new  ArrayList<TipoCargaFami>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCargaFami.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoCargaFamiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocargafamis=tipocargafamiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCargaFami(tipocargafamis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCargaFamiConstantesFunciones.refrescarForeignKeysDescripcionesTipoCargaFami(this.tipocargafamis);
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
		tipocargafamis = new  ArrayList<TipoCargaFami>();
		  		  
        try {
			TipoCargaFamiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocargafamis=tipocargafamiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCargaFami(tipocargafamis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCargaFamiConstantesFunciones.refrescarForeignKeysDescripcionesTipoCargaFami(this.tipocargafamis);
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
		tipocargafamis = new  ArrayList<TipoCargaFami>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCargaFami.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCargaFamiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocargafamis=tipocargafamiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCargaFami(tipocargafamis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCargaFamiConstantesFunciones.refrescarForeignKeysDescripcionesTipoCargaFami(this.tipocargafamis);
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
		tipocargafamis = new  ArrayList<TipoCargaFami>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCargaFamiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocargafamis=tipocargafamiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCargaFami(tipocargafamis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCargaFamiConstantesFunciones.refrescarForeignKeysDescripcionesTipoCargaFami(this.tipocargafamis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipocargafami = new  TipoCargaFami();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCargaFami.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCargaFamiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocargafami=tipocargafamiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCargaFami(tipocargafami);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCargaFamiConstantesFunciones.refrescarForeignKeysDescripcionesTipoCargaFami(this.tipocargafami);
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
		tipocargafami = new  TipoCargaFami();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCargaFamiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocargafami=tipocargafamiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCargaFami(tipocargafami);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCargaFamiConstantesFunciones.refrescarForeignKeysDescripcionesTipoCargaFami(this.tipocargafami);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocargafamis = new  ArrayList<TipoCargaFami>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCargaFami.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoCargaFamiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocargafamis=tipocargafamiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCargaFami(tipocargafamis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCargaFamiConstantesFunciones.refrescarForeignKeysDescripcionesTipoCargaFami(this.tipocargafamis);
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
		tipocargafamis = new  ArrayList<TipoCargaFami>();
		  		  
        try {
			TipoCargaFamiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocargafamis=tipocargafamiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCargaFami(tipocargafamis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCargaFamiConstantesFunciones.refrescarForeignKeysDescripcionesTipoCargaFami(this.tipocargafamis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoCargaFamisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipocargafamis = new  ArrayList<TipoCargaFami>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCargaFami.class.getSimpleName()+"-getTodosTipoCargaFamisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCargaFamiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocargafamis=tipocargafamiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCargaFami(tipocargafamis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCargaFamiConstantesFunciones.refrescarForeignKeysDescripcionesTipoCargaFami(this.tipocargafamis);
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
	
	public  void  getTodosTipoCargaFamis(String sFinalQuery,Pagination pagination)throws Exception {
		tipocargafamis = new  ArrayList<TipoCargaFami>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCargaFamiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocargafamis=tipocargafamiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCargaFami(tipocargafamis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCargaFamiConstantesFunciones.refrescarForeignKeysDescripcionesTipoCargaFami(this.tipocargafamis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoCargaFami(TipoCargaFami tipocargafami) throws Exception {
		Boolean estaValidado=false;
		
		if(tipocargafami.getIsNew() || tipocargafami.getIsChanged()) { 
			this.invalidValues = tipocargafamiValidator.getInvalidValues(tipocargafami);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipocargafami);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoCargaFami(List<TipoCargaFami> TipoCargaFamis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoCargaFami tipocargafamiLocal:tipocargafamis) {				
			estaValidadoObjeto=this.validarGuardarTipoCargaFami(tipocargafamiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoCargaFami(List<TipoCargaFami> TipoCargaFamis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCargaFami(tipocargafamis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoCargaFami(TipoCargaFami TipoCargaFami) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCargaFami(tipocargafami)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoCargaFami tipocargafami) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipocargafami.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoCargaFamiConstantesFunciones.getTipoCargaFamiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipocargafami","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoCargaFamiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoCargaFamiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoCargaFamiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCargaFami.class.getSimpleName()+"-saveTipoCargaFamiWithConnection");connexion.begin();			
			
			TipoCargaFamiLogicAdditional.checkTipoCargaFamiToSave(this.tipocargafami,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoCargaFamiLogicAdditional.updateTipoCargaFamiToSave(this.tipocargafami,this.arrDatoGeneral);
			
			TipoCargaFamiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocargafami,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoCargaFami();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCargaFami(this.tipocargafami)) {
				TipoCargaFamiDataAccess.save(this.tipocargafami, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipocargafami,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoCargaFamiLogicAdditional.checkTipoCargaFamiToSaveAfter(this.tipocargafami,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCargaFami();
			
			connexion.commit();			
			
			if(this.tipocargafami.getIsDeleted()) {
				this.tipocargafami=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoCargaFami()throws Exception {	
		try {	
			
			TipoCargaFamiLogicAdditional.checkTipoCargaFamiToSave(this.tipocargafami,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoCargaFamiLogicAdditional.updateTipoCargaFamiToSave(this.tipocargafami,this.arrDatoGeneral);
			
			TipoCargaFamiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocargafami,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCargaFami(this.tipocargafami)) {			
				TipoCargaFamiDataAccess.save(this.tipocargafami, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipocargafami,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoCargaFamiLogicAdditional.checkTipoCargaFamiToSaveAfter(this.tipocargafami,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipocargafami.getIsDeleted()) {
				this.tipocargafami=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoCargaFamisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCargaFami.class.getSimpleName()+"-saveTipoCargaFamisWithConnection");connexion.begin();			
			
			TipoCargaFamiLogicAdditional.checkTipoCargaFamiToSaves(tipocargafamis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoCargaFamis();
			
			Boolean validadoTodosTipoCargaFami=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCargaFami tipocargafamiLocal:tipocargafamis) {		
				if(tipocargafamiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoCargaFamiLogicAdditional.updateTipoCargaFamiToSave(tipocargafamiLocal,this.arrDatoGeneral);
	        	
				TipoCargaFamiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocargafamiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCargaFami(tipocargafamiLocal)) {
					TipoCargaFamiDataAccess.save(tipocargafamiLocal, connexion);				
				} else {
					validadoTodosTipoCargaFami=false;
				}
			}
			
			if(!validadoTodosTipoCargaFami) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoCargaFamiLogicAdditional.checkTipoCargaFamiToSavesAfter(tipocargafamis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCargaFamis();
			
			connexion.commit();		
			
			this.quitarTipoCargaFamisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoCargaFamis()throws Exception {				
		 try {	
			TipoCargaFamiLogicAdditional.checkTipoCargaFamiToSaves(tipocargafamis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoCargaFami=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCargaFami tipocargafamiLocal:tipocargafamis) {				
				if(tipocargafamiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoCargaFamiLogicAdditional.updateTipoCargaFamiToSave(tipocargafamiLocal,this.arrDatoGeneral);
	        	
				TipoCargaFamiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocargafamiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCargaFami(tipocargafamiLocal)) {				
					TipoCargaFamiDataAccess.save(tipocargafamiLocal, connexion);				
				} else {
					validadoTodosTipoCargaFami=false;
				}
			}
			
			if(!validadoTodosTipoCargaFami) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoCargaFamiLogicAdditional.checkTipoCargaFamiToSavesAfter(tipocargafamis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoCargaFamisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCargaFamiParameterReturnGeneral procesarAccionTipoCargaFamis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCargaFami> tipocargafamis,TipoCargaFamiParameterReturnGeneral tipocargafamiParameterGeneral)throws Exception {
		 try {	
			TipoCargaFamiParameterReturnGeneral tipocargafamiReturnGeneral=new TipoCargaFamiParameterReturnGeneral();
	
			TipoCargaFamiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipocargafamis,tipocargafamiParameterGeneral,tipocargafamiReturnGeneral);
			
			return tipocargafamiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCargaFamiParameterReturnGeneral procesarAccionTipoCargaFamisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCargaFami> tipocargafamis,TipoCargaFamiParameterReturnGeneral tipocargafamiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCargaFami.class.getSimpleName()+"-procesarAccionTipoCargaFamisWithConnection");connexion.begin();			
			
			TipoCargaFamiParameterReturnGeneral tipocargafamiReturnGeneral=new TipoCargaFamiParameterReturnGeneral();
	
			TipoCargaFamiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipocargafamis,tipocargafamiParameterGeneral,tipocargafamiReturnGeneral);
			
			this.connexion.commit();
			
			return tipocargafamiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCargaFamiParameterReturnGeneral procesarEventosTipoCargaFamis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCargaFami> tipocargafamis,TipoCargaFami tipocargafami,TipoCargaFamiParameterReturnGeneral tipocargafamiParameterGeneral,Boolean isEsNuevoTipoCargaFami,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoCargaFamiParameterReturnGeneral tipocargafamiReturnGeneral=new TipoCargaFamiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocargafamiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoCargaFamiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipocargafamis,tipocargafami,tipocargafamiParameterGeneral,tipocargafamiReturnGeneral,isEsNuevoTipoCargaFami,clases);
			
			return tipocargafamiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoCargaFamiParameterReturnGeneral procesarEventosTipoCargaFamisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCargaFami> tipocargafamis,TipoCargaFami tipocargafami,TipoCargaFamiParameterReturnGeneral tipocargafamiParameterGeneral,Boolean isEsNuevoTipoCargaFami,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCargaFami.class.getSimpleName()+"-procesarEventosTipoCargaFamisWithConnection");connexion.begin();			
			
			TipoCargaFamiParameterReturnGeneral tipocargafamiReturnGeneral=new TipoCargaFamiParameterReturnGeneral();
	
			tipocargafamiReturnGeneral.setTipoCargaFami(tipocargafami);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocargafamiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoCargaFamiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipocargafamis,tipocargafami,tipocargafamiParameterGeneral,tipocargafamiReturnGeneral,isEsNuevoTipoCargaFami,clases);
			
			this.connexion.commit();
			
			return tipocargafamiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCargaFamiParameterReturnGeneral procesarImportacionTipoCargaFamisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoCargaFamiParameterReturnGeneral tipocargafamiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCargaFami.class.getSimpleName()+"-procesarImportacionTipoCargaFamisWithConnection");connexion.begin();			
			
			TipoCargaFamiParameterReturnGeneral tipocargafamiReturnGeneral=new TipoCargaFamiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipocargafamis=new ArrayList<TipoCargaFami>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipocargafami=new TipoCargaFami();
				
				
				if(conColumnasBase) {this.tipocargafami.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipocargafami.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipocargafami.setcodigo(arrColumnas[iColumn++]);
				this.tipocargafami.setnombre(arrColumnas[iColumn++]);
				
				this.tipocargafamis.add(this.tipocargafami);
			}
			
			this.saveTipoCargaFamis();
			
			this.connexion.commit();
			
			tipocargafamiReturnGeneral.setConRetornoEstaProcesado(true);
			tipocargafamiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipocargafamiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoCargaFamisEliminados() throws Exception {				
		
		List<TipoCargaFami> tipocargafamisAux= new ArrayList<TipoCargaFami>();
		
		for(TipoCargaFami tipocargafami:tipocargafamis) {
			if(!tipocargafami.getIsDeleted()) {
				tipocargafamisAux.add(tipocargafami);
			}
		}
		
		tipocargafamis=tipocargafamisAux;
	}
	
	public void quitarTipoCargaFamisNulos() throws Exception {				
		
		List<TipoCargaFami> tipocargafamisAux= new ArrayList<TipoCargaFami>();
		
		for(TipoCargaFami tipocargafami : this.tipocargafamis) {
			if(tipocargafami==null) {
				tipocargafamisAux.add(tipocargafami);
			}
		}
		
		//this.tipocargafamis=tipocargafamisAux;
		
		this.tipocargafamis.removeAll(tipocargafamisAux);
	}
	
	public void getSetVersionRowTipoCargaFamiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipocargafami.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipocargafami.getIsDeleted() || (tipocargafami.getIsChanged()&&!tipocargafami.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipocargafamiDataAccess.getSetVersionRowTipoCargaFami(connexion,tipocargafami.getId());
				
				if(!tipocargafami.getVersionRow().equals(timestamp)) {	
					tipocargafami.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipocargafami.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoCargaFami()throws Exception {	
		
		if(tipocargafami.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipocargafami.getIsDeleted() || (tipocargafami.getIsChanged()&&!tipocargafami.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipocargafamiDataAccess.getSetVersionRowTipoCargaFami(connexion,tipocargafami.getId());
			
			try {							
				if(!tipocargafami.getVersionRow().equals(timestamp)) {	
					tipocargafami.setVersionRow(timestamp);
				}
				
				tipocargafami.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoCargaFamisWithConnection()throws Exception {	
		if(tipocargafamis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoCargaFami tipocargafamiAux:tipocargafamis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipocargafamiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocargafamiAux.getIsDeleted() || (tipocargafamiAux.getIsChanged()&&!tipocargafamiAux.getIsNew())) {
						
						timestamp=tipocargafamiDataAccess.getSetVersionRowTipoCargaFami(connexion,tipocargafamiAux.getId());
						
						if(!tipocargafami.getVersionRow().equals(timestamp)) {	
							tipocargafamiAux.setVersionRow(timestamp);
						}
								
						tipocargafamiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoCargaFamis()throws Exception {	
		if(tipocargafamis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoCargaFami tipocargafamiAux:tipocargafamis) {
					if(tipocargafamiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocargafamiAux.getIsDeleted() || (tipocargafamiAux.getIsChanged()&&!tipocargafamiAux.getIsNew())) {
						
						timestamp=tipocargafamiDataAccess.getSetVersionRowTipoCargaFami(connexion,tipocargafamiAux.getId());
						
						if(!tipocargafamiAux.getVersionRow().equals(timestamp)) {	
							tipocargafamiAux.setVersionRow(timestamp);
						}
						
													
						tipocargafamiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoCargaFamiWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			CargaFamiliar_NMLogic cargafamiliar_nmLogic=new CargaFamiliar_NMLogic();
			CargaFamiliarLogic cargafamiliarLogic=new CargaFamiliarLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCargaFami.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoCargaFamiWithConnection");connexion.begin();
			
			
			classes.add(new Classe(CargaFamiliar_NM.class));
			classes.add(new Classe(CargaFamiliar.class));
											
			

			cargafamiliar_nmLogic.setConnexion(this.getConnexion());
			cargafamiliar_nmLogic.setDatosCliente(this.datosCliente);
			cargafamiliar_nmLogic.setIsConRefrescarForeignKeys(true);

			cargafamiliarLogic.setConnexion(this.getConnexion());
			cargafamiliarLogic.setDatosCliente(this.datosCliente);
			cargafamiliarLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoCargaFami tipocargafami:this.tipocargafamis) {
				

				classes=new ArrayList<Classe>();
				classes=CargaFamiliar_NMConstantesFunciones.getClassesForeignKeysOfCargaFamiliar_NM(new ArrayList<Classe>(),DeepLoadType.NONE);

				cargafamiliar_nmLogic.setCargaFamiliar_NMs(tipocargafami.cargafamiliar_nms);
				cargafamiliar_nmLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CargaFamiliarConstantesFunciones.getClassesForeignKeysOfCargaFamiliar(new ArrayList<Classe>(),DeepLoadType.NONE);

				cargafamiliarLogic.setCargaFamiliars(tipocargafami.cargafamiliars);
				cargafamiliarLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoCargaFami tipocargafami,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoCargaFamiLogicAdditional.updateTipoCargaFamiToGet(tipocargafami,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocargafami.setCargaFamiliar_NMs(tipocargafamiDataAccess.getCargaFamiliar_NMs(connexion,tipocargafami));
		tipocargafami.setCargaFamiliars(tipocargafamiDataAccess.getCargaFamiliars(connexion,tipocargafami));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CargaFamiliar_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocargafami.setCargaFamiliar_NMs(tipocargafamiDataAccess.getCargaFamiliar_NMs(connexion,tipocargafami));

				if(this.isConDeep) {
					CargaFamiliar_NMLogic cargafamiliar_nmLogic= new CargaFamiliar_NMLogic(this.connexion);
					cargafamiliar_nmLogic.setCargaFamiliar_NMs(tipocargafami.getCargaFamiliar_NMs());
					ArrayList<Classe> classesLocal=CargaFamiliar_NMConstantesFunciones.getClassesForeignKeysOfCargaFamiliar_NM(new ArrayList<Classe>(),DeepLoadType.NONE);
					cargafamiliar_nmLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(cargafamiliar_nmLogic.getCargaFamiliar_NMs());
					tipocargafami.setCargaFamiliar_NMs(cargafamiliar_nmLogic.getCargaFamiliar_NMs());
				}

				continue;
			}

			if(clas.clas.equals(CargaFamiliar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocargafami.setCargaFamiliars(tipocargafamiDataAccess.getCargaFamiliars(connexion,tipocargafami));

				if(this.isConDeep) {
					CargaFamiliarLogic cargafamiliarLogic= new CargaFamiliarLogic(this.connexion);
					cargafamiliarLogic.setCargaFamiliars(tipocargafami.getCargaFamiliars());
					ArrayList<Classe> classesLocal=CargaFamiliarConstantesFunciones.getClassesForeignKeysOfCargaFamiliar(new ArrayList<Classe>(),DeepLoadType.NONE);
					cargafamiliarLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(cargafamiliarLogic.getCargaFamiliars());
					tipocargafami.setCargaFamiliars(cargafamiliarLogic.getCargaFamiliars());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CargaFamiliar_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CargaFamiliar_NM.class));
			tipocargafami.setCargaFamiliar_NMs(tipocargafamiDataAccess.getCargaFamiliar_NMs(connexion,tipocargafami));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CargaFamiliar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CargaFamiliar.class));
			tipocargafami.setCargaFamiliars(tipocargafamiDataAccess.getCargaFamiliars(connexion,tipocargafami));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipocargafami.setCargaFamiliar_NMs(tipocargafamiDataAccess.getCargaFamiliar_NMs(connexion,tipocargafami));

		for(CargaFamiliar_NM cargafamiliar_nm:tipocargafami.getCargaFamiliar_NMs()) {
			CargaFamiliar_NMLogic cargafamiliar_nmLogic= new CargaFamiliar_NMLogic(connexion);
			cargafamiliar_nmLogic.deepLoad(cargafamiliar_nm,isDeep,deepLoadType,clases);
		}

		tipocargafami.setCargaFamiliars(tipocargafamiDataAccess.getCargaFamiliars(connexion,tipocargafami));

		for(CargaFamiliar cargafamiliar:tipocargafami.getCargaFamiliars()) {
			CargaFamiliarLogic cargafamiliarLogic= new CargaFamiliarLogic(connexion);
			cargafamiliarLogic.deepLoad(cargafamiliar,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CargaFamiliar_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocargafami.setCargaFamiliar_NMs(tipocargafamiDataAccess.getCargaFamiliar_NMs(connexion,tipocargafami));

				for(CargaFamiliar_NM cargafamiliar_nm:tipocargafami.getCargaFamiliar_NMs()) {
					CargaFamiliar_NMLogic cargafamiliar_nmLogic= new CargaFamiliar_NMLogic(connexion);
					cargafamiliar_nmLogic.deepLoad(cargafamiliar_nm,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CargaFamiliar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocargafami.setCargaFamiliars(tipocargafamiDataAccess.getCargaFamiliars(connexion,tipocargafami));

				for(CargaFamiliar cargafamiliar:tipocargafami.getCargaFamiliars()) {
					CargaFamiliarLogic cargafamiliarLogic= new CargaFamiliarLogic(connexion);
					cargafamiliarLogic.deepLoad(cargafamiliar,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CargaFamiliar_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CargaFamiliar_NM.class));
			tipocargafami.setCargaFamiliar_NMs(tipocargafamiDataAccess.getCargaFamiliar_NMs(connexion,tipocargafami));

			for(CargaFamiliar_NM cargafamiliar_nm:tipocargafami.getCargaFamiliar_NMs()) {
				CargaFamiliar_NMLogic cargafamiliar_nmLogic= new CargaFamiliar_NMLogic(connexion);
				cargafamiliar_nmLogic.deepLoad(cargafamiliar_nm,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CargaFamiliar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CargaFamiliar.class));
			tipocargafami.setCargaFamiliars(tipocargafamiDataAccess.getCargaFamiliars(connexion,tipocargafami));

			for(CargaFamiliar cargafamiliar:tipocargafami.getCargaFamiliars()) {
				CargaFamiliarLogic cargafamiliarLogic= new CargaFamiliarLogic(connexion);
				cargafamiliarLogic.deepLoad(cargafamiliar,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoCargaFami tipocargafami,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoCargaFamiLogicAdditional.updateTipoCargaFamiToSave(tipocargafami,this.arrDatoGeneral);
			
TipoCargaFamiDataAccess.save(tipocargafami, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(CargaFamiliar_NM cargafamiliar_nm:tipocargafami.getCargaFamiliar_NMs()) {
			cargafamiliar_nm.setid_tipo_carga_fami(tipocargafami.getId());
			CargaFamiliar_NMDataAccess.save(cargafamiliar_nm,connexion);
		}

		for(CargaFamiliar cargafamiliar:tipocargafami.getCargaFamiliars()) {
			cargafamiliar.setid_tipo_carga_fami(tipocargafami.getId());
			CargaFamiliarDataAccess.save(cargafamiliar,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(CargaFamiliar_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CargaFamiliar_NM cargafamiliar_nm:tipocargafami.getCargaFamiliar_NMs()) {
					cargafamiliar_nm.setid_tipo_carga_fami(tipocargafami.getId());
					CargaFamiliar_NMDataAccess.save(cargafamiliar_nm,connexion);
				}
				continue;
			}

			if(clas.clas.equals(CargaFamiliar.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CargaFamiliar cargafamiliar:tipocargafami.getCargaFamiliars()) {
					cargafamiliar.setid_tipo_carga_fami(tipocargafami.getId());
					CargaFamiliarDataAccess.save(cargafamiliar,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(CargaFamiliar_NM cargafamiliar_nm:tipocargafami.getCargaFamiliar_NMs()) {
			CargaFamiliar_NMLogic cargafamiliar_nmLogic= new CargaFamiliar_NMLogic(connexion);
			cargafamiliar_nm.setid_tipo_carga_fami(tipocargafami.getId());
			CargaFamiliar_NMDataAccess.save(cargafamiliar_nm,connexion);
			cargafamiliar_nmLogic.deepSave(cargafamiliar_nm,isDeep,deepLoadType,clases);
		}

		for(CargaFamiliar cargafamiliar:tipocargafami.getCargaFamiliars()) {
			CargaFamiliarLogic cargafamiliarLogic= new CargaFamiliarLogic(connexion);
			cargafamiliar.setid_tipo_carga_fami(tipocargafami.getId());
			CargaFamiliarDataAccess.save(cargafamiliar,connexion);
			cargafamiliarLogic.deepSave(cargafamiliar,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(CargaFamiliar_NM.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CargaFamiliar_NM cargafamiliar_nm:tipocargafami.getCargaFamiliar_NMs()) {
					CargaFamiliar_NMLogic cargafamiliar_nmLogic= new CargaFamiliar_NMLogic(connexion);
					cargafamiliar_nm.setid_tipo_carga_fami(tipocargafami.getId());
					CargaFamiliar_NMDataAccess.save(cargafamiliar_nm,connexion);
					cargafamiliar_nmLogic.deepSave(cargafamiliar_nm,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CargaFamiliar.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CargaFamiliar cargafamiliar:tipocargafami.getCargaFamiliars()) {
					CargaFamiliarLogic cargafamiliarLogic= new CargaFamiliarLogic(connexion);
					cargafamiliar.setid_tipo_carga_fami(tipocargafami.getId());
					CargaFamiliarDataAccess.save(cargafamiliar,connexion);
					cargafamiliarLogic.deepSave(cargafamiliar,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoCargaFami.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipocargafami,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCargaFamiConstantesFunciones.refrescarForeignKeysDescripcionesTipoCargaFami(tipocargafami);
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
			this.deepLoad(this.tipocargafami,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCargaFamiConstantesFunciones.refrescarForeignKeysDescripcionesTipoCargaFami(this.tipocargafami);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoCargaFami.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipocargafamis!=null) {
				for(TipoCargaFami tipocargafami:tipocargafamis) {
					this.deepLoad(tipocargafami,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoCargaFamiConstantesFunciones.refrescarForeignKeysDescripcionesTipoCargaFami(tipocargafamis);
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
			if(tipocargafamis!=null) {
				for(TipoCargaFami tipocargafami:tipocargafamis) {
					this.deepLoad(tipocargafami,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoCargaFamiConstantesFunciones.refrescarForeignKeysDescripcionesTipoCargaFami(tipocargafamis);
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
			this.getNewConnexionToDeep(TipoCargaFami.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipocargafami,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoCargaFami.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipocargafamis!=null) {
				for(TipoCargaFami tipocargafami:tipocargafamis) {
					this.deepSave(tipocargafami,isDeep,deepLoadType,clases);
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
			if(tipocargafamis!=null) {
				for(TipoCargaFami tipocargafami:tipocargafamis) {
					this.deepSave(tipocargafami,isDeep,deepLoadType,clases);
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
			if(TipoCargaFamiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCargaFamiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoCargaFami tipocargafami,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoCargaFamiConstantesFunciones.ISCONAUDITORIA) {
				if(tipocargafami.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCargaFamiDataAccess.TABLENAME, tipocargafami.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCargaFamiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCargaFamiLogic.registrarAuditoriaDetallesTipoCargaFami(connexion,tipocargafami,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipocargafami.getIsDeleted()) {
					/*if(!tipocargafami.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoCargaFamiDataAccess.TABLENAME, tipocargafami.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoCargaFamiLogic.registrarAuditoriaDetallesTipoCargaFami(connexion,tipocargafami,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCargaFamiDataAccess.TABLENAME, tipocargafami.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipocargafami.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCargaFamiDataAccess.TABLENAME, tipocargafami.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCargaFamiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCargaFamiLogic.registrarAuditoriaDetallesTipoCargaFami(connexion,tipocargafami,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoCargaFami(Connexion connexion,TipoCargaFami tipocargafami)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipocargafami.getIsNew()||!tipocargafami.getcodigo().equals(tipocargafami.getTipoCargaFamiOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocargafami.getTipoCargaFamiOriginal().getcodigo()!=null)
				{
					strValorActual=tipocargafami.getTipoCargaFamiOriginal().getcodigo();
				}
				if(tipocargafami.getcodigo()!=null)
				{
					strValorNuevo=tipocargafami.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCargaFamiConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipocargafami.getIsNew()||!tipocargafami.getnombre().equals(tipocargafami.getTipoCargaFamiOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocargafami.getTipoCargaFamiOriginal().getnombre()!=null)
				{
					strValorActual=tipocargafami.getTipoCargaFamiOriginal().getnombre();
				}
				if(tipocargafami.getnombre()!=null)
				{
					strValorNuevo=tipocargafami.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCargaFamiConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoCargaFamiRelacionesWithConnection(TipoCargaFami tipocargafami,List<CargaFamiliar_NM> cargafamiliar_nms,List<CargaFamiliar> cargafamiliars) throws Exception {

		if(!tipocargafami.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoCargaFamiRelacionesBase(tipocargafami,cargafamiliar_nms,cargafamiliars,true);
		}
	}

	public void saveTipoCargaFamiRelaciones(TipoCargaFami tipocargafami,List<CargaFamiliar_NM> cargafamiliar_nms,List<CargaFamiliar> cargafamiliars)throws Exception {

		if(!tipocargafami.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoCargaFamiRelacionesBase(tipocargafami,cargafamiliar_nms,cargafamiliars,false);
		}
	}

	public void saveTipoCargaFamiRelacionesBase(TipoCargaFami tipocargafami,List<CargaFamiliar_NM> cargafamiliar_nms,List<CargaFamiliar> cargafamiliars,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoCargaFami-saveRelacionesWithConnection");}
	
			tipocargafami.setCargaFamiliar_NMs(cargafamiliar_nms);
			tipocargafami.setCargaFamiliars(cargafamiliars);

			this.setTipoCargaFami(tipocargafami);

				if((tipocargafami.getIsNew()||tipocargafami.getIsChanged())&&!tipocargafami.getIsDeleted()) {
					this.saveTipoCargaFami();
					this.saveTipoCargaFamiRelacionesDetalles(cargafamiliar_nms,cargafamiliars);

				} else if(tipocargafami.getIsDeleted()) {
					this.saveTipoCargaFamiRelacionesDetalles(cargafamiliar_nms,cargafamiliars);
					this.saveTipoCargaFami();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			CargaFamiliar_NMConstantesFunciones.InicializarGeneralEntityAuxiliaresCargaFamiliar_NMs(cargafamiliar_nms,true,true);
			CargaFamiliarConstantesFunciones.InicializarGeneralEntityAuxiliaresCargaFamiliars(cargafamiliars,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoCargaFamiRelacionesDetalles(List<CargaFamiliar_NM> cargafamiliar_nms,List<CargaFamiliar> cargafamiliars)throws Exception {
		try {
	

			Long idTipoCargaFamiActual=this.getTipoCargaFami().getId();

			CargaFamiliar_NMLogic cargafamiliar_nmLogic_Desde_TipoCargaFami=new CargaFamiliar_NMLogic();
			cargafamiliar_nmLogic_Desde_TipoCargaFami.setCargaFamiliar_NMs(cargafamiliar_nms);

			cargafamiliar_nmLogic_Desde_TipoCargaFami.setConnexion(this.getConnexion());
			cargafamiliar_nmLogic_Desde_TipoCargaFami.setDatosCliente(this.datosCliente);

			for(CargaFamiliar_NM cargafamiliar_nm_Desde_TipoCargaFami:cargafamiliar_nmLogic_Desde_TipoCargaFami.getCargaFamiliar_NMs()) {
				cargafamiliar_nm_Desde_TipoCargaFami.setid_tipo_carga_fami(idTipoCargaFamiActual);
			}

			cargafamiliar_nmLogic_Desde_TipoCargaFami.saveCargaFamiliar_NMs();

			CargaFamiliarLogic cargafamiliarLogic_Desde_TipoCargaFami=new CargaFamiliarLogic();
			cargafamiliarLogic_Desde_TipoCargaFami.setCargaFamiliars(cargafamiliars);

			cargafamiliarLogic_Desde_TipoCargaFami.setConnexion(this.getConnexion());
			cargafamiliarLogic_Desde_TipoCargaFami.setDatosCliente(this.datosCliente);

			for(CargaFamiliar cargafamiliar_Desde_TipoCargaFami:cargafamiliarLogic_Desde_TipoCargaFami.getCargaFamiliars()) {
				cargafamiliar_Desde_TipoCargaFami.setid_tipo_carga_fami(idTipoCargaFamiActual);
			}

			cargafamiliarLogic_Desde_TipoCargaFami.saveCargaFamiliars();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCargaFami(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCargaFamiConstantesFunciones.getClassesForeignKeysOfTipoCargaFami(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCargaFami(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCargaFamiConstantesFunciones.getClassesRelationshipsOfTipoCargaFami(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
package com.bydan.erp.tesoreria.business.logic;

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
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.tesoreria.util.TipoCuentaBancoGeneralConstantesFunciones;
import com.bydan.erp.tesoreria.util.TipoCuentaBancoGeneralParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TipoCuentaBancoGeneralParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.TipoCuentaBancoGeneral;
import com.bydan.erp.tesoreria.business.logic.TipoCuentaBancoGeneralLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoCuentaBancoGeneralLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoCuentaBancoGeneralLogic.class);
	
	protected TipoCuentaBancoGeneralDataAccess tipocuentabancogeneralDataAccess; 	
	protected TipoCuentaBancoGeneral tipocuentabancogeneral;
	protected List<TipoCuentaBancoGeneral> tipocuentabancogenerals;
	protected Object tipocuentabancogeneralObject;	
	protected List<Object> tipocuentabancogeneralsObject;
	
	public static ClassValidator<TipoCuentaBancoGeneral> tipocuentabancogeneralValidator = new ClassValidator<TipoCuentaBancoGeneral>(TipoCuentaBancoGeneral.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoCuentaBancoGeneralLogicAdditional tipocuentabancogeneralLogicAdditional=null;
	
	public TipoCuentaBancoGeneralLogicAdditional getTipoCuentaBancoGeneralLogicAdditional() {
		return this.tipocuentabancogeneralLogicAdditional;
	}
	
	public void setTipoCuentaBancoGeneralLogicAdditional(TipoCuentaBancoGeneralLogicAdditional tipocuentabancogeneralLogicAdditional) {
		try {
			this.tipocuentabancogeneralLogicAdditional=tipocuentabancogeneralLogicAdditional;
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
	
	
	
	
	public  TipoCuentaBancoGeneralLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipocuentabancogeneralDataAccess = new TipoCuentaBancoGeneralDataAccess();
			
			this.tipocuentabancogenerals= new ArrayList<TipoCuentaBancoGeneral>();
			this.tipocuentabancogeneral= new TipoCuentaBancoGeneral();
			
			this.tipocuentabancogeneralObject=new Object();
			this.tipocuentabancogeneralsObject=new ArrayList<Object>();
				
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
			
			this.tipocuentabancogeneralDataAccess.setConnexionType(this.connexionType);
			this.tipocuentabancogeneralDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoCuentaBancoGeneralLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipocuentabancogeneralDataAccess = new TipoCuentaBancoGeneralDataAccess();
			this.tipocuentabancogenerals= new ArrayList<TipoCuentaBancoGeneral>();
			this.tipocuentabancogeneral= new TipoCuentaBancoGeneral();
			this.tipocuentabancogeneralObject=new Object();
			this.tipocuentabancogeneralsObject=new ArrayList<Object>();
			
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
			
			this.tipocuentabancogeneralDataAccess.setConnexionType(this.connexionType);
			this.tipocuentabancogeneralDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoCuentaBancoGeneral getTipoCuentaBancoGeneral() throws Exception {	
		TipoCuentaBancoGeneralLogicAdditional.checkTipoCuentaBancoGeneralToGet(tipocuentabancogeneral,this.datosCliente,this.arrDatoGeneral);
		TipoCuentaBancoGeneralLogicAdditional.updateTipoCuentaBancoGeneralToGet(tipocuentabancogeneral,this.arrDatoGeneral);
		
		return tipocuentabancogeneral;
	}
		
	public void setTipoCuentaBancoGeneral(TipoCuentaBancoGeneral newTipoCuentaBancoGeneral) {
		this.tipocuentabancogeneral = newTipoCuentaBancoGeneral;
	}
	
	public TipoCuentaBancoGeneralDataAccess getTipoCuentaBancoGeneralDataAccess() {
		return tipocuentabancogeneralDataAccess;
	}
	
	public void setTipoCuentaBancoGeneralDataAccess(TipoCuentaBancoGeneralDataAccess newtipocuentabancogeneralDataAccess) {
		this.tipocuentabancogeneralDataAccess = newtipocuentabancogeneralDataAccess;
	}
	
	public List<TipoCuentaBancoGeneral> getTipoCuentaBancoGenerals() throws Exception {		
		this.quitarTipoCuentaBancoGeneralsNulos();
		
		TipoCuentaBancoGeneralLogicAdditional.checkTipoCuentaBancoGeneralToGets(tipocuentabancogenerals,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoCuentaBancoGeneral tipocuentabancogeneralLocal: tipocuentabancogenerals ) {
			TipoCuentaBancoGeneralLogicAdditional.updateTipoCuentaBancoGeneralToGet(tipocuentabancogeneralLocal,this.arrDatoGeneral);
		}
		
		return tipocuentabancogenerals;
	}
	
	public void setTipoCuentaBancoGenerals(List<TipoCuentaBancoGeneral> newTipoCuentaBancoGenerals) {
		this.tipocuentabancogenerals = newTipoCuentaBancoGenerals;
	}
	
	public Object getTipoCuentaBancoGeneralObject() {	
		this.tipocuentabancogeneralObject=this.tipocuentabancogeneralDataAccess.getEntityObject();
		return this.tipocuentabancogeneralObject;
	}
		
	public void setTipoCuentaBancoGeneralObject(Object newTipoCuentaBancoGeneralObject) {
		this.tipocuentabancogeneralObject = newTipoCuentaBancoGeneralObject;
	}
	
	public List<Object> getTipoCuentaBancoGeneralsObject() {		
		this.tipocuentabancogeneralsObject=this.tipocuentabancogeneralDataAccess.getEntitiesObject();
		return this.tipocuentabancogeneralsObject;
	}
		
	public void setTipoCuentaBancoGeneralsObject(List<Object> newTipoCuentaBancoGeneralsObject) {
		this.tipocuentabancogeneralsObject = newTipoCuentaBancoGeneralsObject;
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
		
		if(this.tipocuentabancogeneralDataAccess!=null) {
			this.tipocuentabancogeneralDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGeneral.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipocuentabancogeneralDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipocuentabancogeneralDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipocuentabancogeneral = new  TipoCuentaBancoGeneral();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGeneral.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocuentabancogeneral=tipocuentabancogeneralDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocuentabancogeneral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogeneral);
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
		tipocuentabancogeneral = new  TipoCuentaBancoGeneral();
		  		  
        try {
			
			tipocuentabancogeneral=tipocuentabancogeneralDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocuentabancogeneral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogeneral);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipocuentabancogeneral = new  TipoCuentaBancoGeneral();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGeneral.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocuentabancogeneral=tipocuentabancogeneralDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocuentabancogeneral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogeneral);
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
		tipocuentabancogeneral = new  TipoCuentaBancoGeneral();
		  		  
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
		tipocuentabancogeneral = new  TipoCuentaBancoGeneral();
		  		  
        try {
			
			tipocuentabancogeneral=tipocuentabancogeneralDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocuentabancogeneral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogeneral);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipocuentabancogeneral = new  TipoCuentaBancoGeneral();
		  		  
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
		tipocuentabancogeneral = new  TipoCuentaBancoGeneral();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGeneral.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipocuentabancogeneralDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocuentabancogeneral = new  TipoCuentaBancoGeneral();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipocuentabancogeneralDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocuentabancogeneral = new  TipoCuentaBancoGeneral();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGeneral.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipocuentabancogeneralDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocuentabancogeneral = new  TipoCuentaBancoGeneral();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipocuentabancogeneralDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocuentabancogeneral = new  TipoCuentaBancoGeneral();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGeneral.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipocuentabancogeneralDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocuentabancogeneral = new  TipoCuentaBancoGeneral();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipocuentabancogeneralDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocuentabancogenerals = new  ArrayList<TipoCuentaBancoGeneral>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGeneral.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoCuentaBancoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancogenerals=tipocuentabancogeneralDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuentaBancoGeneral(tipocuentabancogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogenerals);
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
		tipocuentabancogenerals = new  ArrayList<TipoCuentaBancoGeneral>();
		  		  
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
		tipocuentabancogenerals = new  ArrayList<TipoCuentaBancoGeneral>();
		  		  
        try {			
			TipoCuentaBancoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancogenerals=tipocuentabancogeneralDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoCuentaBancoGeneral(tipocuentabancogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogenerals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipocuentabancogenerals = new  ArrayList<TipoCuentaBancoGeneral>();
		  		  
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
		tipocuentabancogenerals = new  ArrayList<TipoCuentaBancoGeneral>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGeneral.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoCuentaBancoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancogenerals=tipocuentabancogeneralDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuentaBancoGeneral(tipocuentabancogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogenerals);
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
		tipocuentabancogenerals = new  ArrayList<TipoCuentaBancoGeneral>();
		  		  
        try {
			TipoCuentaBancoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancogenerals=tipocuentabancogeneralDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuentaBancoGeneral(tipocuentabancogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogenerals);
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
		tipocuentabancogenerals = new  ArrayList<TipoCuentaBancoGeneral>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGeneral.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaBancoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancogenerals=tipocuentabancogeneralDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCuentaBancoGeneral(tipocuentabancogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogenerals);
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
		tipocuentabancogenerals = new  ArrayList<TipoCuentaBancoGeneral>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaBancoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancogenerals=tipocuentabancogeneralDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCuentaBancoGeneral(tipocuentabancogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogenerals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipocuentabancogeneral = new  TipoCuentaBancoGeneral();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGeneral.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaBancoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancogeneral=tipocuentabancogeneralDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCuentaBancoGeneral(tipocuentabancogeneral);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogeneral);
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
		tipocuentabancogeneral = new  TipoCuentaBancoGeneral();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaBancoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancogeneral=tipocuentabancogeneralDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCuentaBancoGeneral(tipocuentabancogeneral);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogeneral);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocuentabancogenerals = new  ArrayList<TipoCuentaBancoGeneral>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGeneral.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoCuentaBancoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancogenerals=tipocuentabancogeneralDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuentaBancoGeneral(tipocuentabancogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogenerals);
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
		tipocuentabancogenerals = new  ArrayList<TipoCuentaBancoGeneral>();
		  		  
        try {
			TipoCuentaBancoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancogenerals=tipocuentabancogeneralDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuentaBancoGeneral(tipocuentabancogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogenerals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoCuentaBancoGeneralsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipocuentabancogenerals = new  ArrayList<TipoCuentaBancoGeneral>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGeneral.class.getSimpleName()+"-getTodosTipoCuentaBancoGeneralsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaBancoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancogenerals=tipocuentabancogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCuentaBancoGeneral(tipocuentabancogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogenerals);
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
	
	public  void  getTodosTipoCuentaBancoGenerals(String sFinalQuery,Pagination pagination)throws Exception {
		tipocuentabancogenerals = new  ArrayList<TipoCuentaBancoGeneral>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaBancoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancogenerals=tipocuentabancogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCuentaBancoGeneral(tipocuentabancogenerals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogenerals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoCuentaBancoGeneral(TipoCuentaBancoGeneral tipocuentabancogeneral) throws Exception {
		Boolean estaValidado=false;
		
		if(tipocuentabancogeneral.getIsNew() || tipocuentabancogeneral.getIsChanged()) { 
			this.invalidValues = tipocuentabancogeneralValidator.getInvalidValues(tipocuentabancogeneral);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipocuentabancogeneral);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoCuentaBancoGeneral(List<TipoCuentaBancoGeneral> TipoCuentaBancoGenerals) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoCuentaBancoGeneral tipocuentabancogeneralLocal:tipocuentabancogenerals) {				
			estaValidadoObjeto=this.validarGuardarTipoCuentaBancoGeneral(tipocuentabancogeneralLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoCuentaBancoGeneral(List<TipoCuentaBancoGeneral> TipoCuentaBancoGenerals) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCuentaBancoGeneral(tipocuentabancogenerals)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoCuentaBancoGeneral(TipoCuentaBancoGeneral TipoCuentaBancoGeneral) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCuentaBancoGeneral(tipocuentabancogeneral)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoCuentaBancoGeneral tipocuentabancogeneral) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipocuentabancogeneral.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoCuentaBancoGeneralConstantesFunciones.getTipoCuentaBancoGeneralLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipocuentabancogeneral","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoCuentaBancoGeneralConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoCuentaBancoGeneralConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoCuentaBancoGeneralWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGeneral.class.getSimpleName()+"-saveTipoCuentaBancoGeneralWithConnection");connexion.begin();			
			
			TipoCuentaBancoGeneralLogicAdditional.checkTipoCuentaBancoGeneralToSave(this.tipocuentabancogeneral,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoCuentaBancoGeneralLogicAdditional.updateTipoCuentaBancoGeneralToSave(this.tipocuentabancogeneral,this.arrDatoGeneral);
			
			TipoCuentaBancoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocuentabancogeneral,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoCuentaBancoGeneral();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCuentaBancoGeneral(this.tipocuentabancogeneral)) {
				TipoCuentaBancoGeneralDataAccess.save(this.tipocuentabancogeneral, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipocuentabancogeneral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoCuentaBancoGeneralLogicAdditional.checkTipoCuentaBancoGeneralToSaveAfter(this.tipocuentabancogeneral,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCuentaBancoGeneral();
			
			connexion.commit();			
			
			if(this.tipocuentabancogeneral.getIsDeleted()) {
				this.tipocuentabancogeneral=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoCuentaBancoGeneral()throws Exception {	
		try {	
			
			TipoCuentaBancoGeneralLogicAdditional.checkTipoCuentaBancoGeneralToSave(this.tipocuentabancogeneral,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoCuentaBancoGeneralLogicAdditional.updateTipoCuentaBancoGeneralToSave(this.tipocuentabancogeneral,this.arrDatoGeneral);
			
			TipoCuentaBancoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocuentabancogeneral,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCuentaBancoGeneral(this.tipocuentabancogeneral)) {			
				TipoCuentaBancoGeneralDataAccess.save(this.tipocuentabancogeneral, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipocuentabancogeneral,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoCuentaBancoGeneralLogicAdditional.checkTipoCuentaBancoGeneralToSaveAfter(this.tipocuentabancogeneral,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipocuentabancogeneral.getIsDeleted()) {
				this.tipocuentabancogeneral=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoCuentaBancoGeneralsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGeneral.class.getSimpleName()+"-saveTipoCuentaBancoGeneralsWithConnection");connexion.begin();			
			
			TipoCuentaBancoGeneralLogicAdditional.checkTipoCuentaBancoGeneralToSaves(tipocuentabancogenerals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoCuentaBancoGenerals();
			
			Boolean validadoTodosTipoCuentaBancoGeneral=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCuentaBancoGeneral tipocuentabancogeneralLocal:tipocuentabancogenerals) {		
				if(tipocuentabancogeneralLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoCuentaBancoGeneralLogicAdditional.updateTipoCuentaBancoGeneralToSave(tipocuentabancogeneralLocal,this.arrDatoGeneral);
	        	
				TipoCuentaBancoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocuentabancogeneralLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCuentaBancoGeneral(tipocuentabancogeneralLocal)) {
					TipoCuentaBancoGeneralDataAccess.save(tipocuentabancogeneralLocal, connexion);				
				} else {
					validadoTodosTipoCuentaBancoGeneral=false;
				}
			}
			
			if(!validadoTodosTipoCuentaBancoGeneral) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoCuentaBancoGeneralLogicAdditional.checkTipoCuentaBancoGeneralToSavesAfter(tipocuentabancogenerals,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCuentaBancoGenerals();
			
			connexion.commit();		
			
			this.quitarTipoCuentaBancoGeneralsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoCuentaBancoGenerals()throws Exception {				
		 try {	
			TipoCuentaBancoGeneralLogicAdditional.checkTipoCuentaBancoGeneralToSaves(tipocuentabancogenerals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoCuentaBancoGeneral=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCuentaBancoGeneral tipocuentabancogeneralLocal:tipocuentabancogenerals) {				
				if(tipocuentabancogeneralLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoCuentaBancoGeneralLogicAdditional.updateTipoCuentaBancoGeneralToSave(tipocuentabancogeneralLocal,this.arrDatoGeneral);
	        	
				TipoCuentaBancoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocuentabancogeneralLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCuentaBancoGeneral(tipocuentabancogeneralLocal)) {				
					TipoCuentaBancoGeneralDataAccess.save(tipocuentabancogeneralLocal, connexion);				
				} else {
					validadoTodosTipoCuentaBancoGeneral=false;
				}
			}
			
			if(!validadoTodosTipoCuentaBancoGeneral) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoCuentaBancoGeneralLogicAdditional.checkTipoCuentaBancoGeneralToSavesAfter(tipocuentabancogenerals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoCuentaBancoGeneralsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCuentaBancoGeneralParameterReturnGeneral procesarAccionTipoCuentaBancoGenerals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCuentaBancoGeneral> tipocuentabancogenerals,TipoCuentaBancoGeneralParameterReturnGeneral tipocuentabancogeneralParameterGeneral)throws Exception {
		 try {	
			TipoCuentaBancoGeneralParameterReturnGeneral tipocuentabancogeneralReturnGeneral=new TipoCuentaBancoGeneralParameterReturnGeneral();
	
			TipoCuentaBancoGeneralLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipocuentabancogenerals,tipocuentabancogeneralParameterGeneral,tipocuentabancogeneralReturnGeneral);
			
			return tipocuentabancogeneralReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCuentaBancoGeneralParameterReturnGeneral procesarAccionTipoCuentaBancoGeneralsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCuentaBancoGeneral> tipocuentabancogenerals,TipoCuentaBancoGeneralParameterReturnGeneral tipocuentabancogeneralParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGeneral.class.getSimpleName()+"-procesarAccionTipoCuentaBancoGeneralsWithConnection");connexion.begin();			
			
			TipoCuentaBancoGeneralParameterReturnGeneral tipocuentabancogeneralReturnGeneral=new TipoCuentaBancoGeneralParameterReturnGeneral();
	
			TipoCuentaBancoGeneralLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipocuentabancogenerals,tipocuentabancogeneralParameterGeneral,tipocuentabancogeneralReturnGeneral);
			
			this.connexion.commit();
			
			return tipocuentabancogeneralReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCuentaBancoGeneralParameterReturnGeneral procesarEventosTipoCuentaBancoGenerals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCuentaBancoGeneral> tipocuentabancogenerals,TipoCuentaBancoGeneral tipocuentabancogeneral,TipoCuentaBancoGeneralParameterReturnGeneral tipocuentabancogeneralParameterGeneral,Boolean isEsNuevoTipoCuentaBancoGeneral,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoCuentaBancoGeneralParameterReturnGeneral tipocuentabancogeneralReturnGeneral=new TipoCuentaBancoGeneralParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocuentabancogeneralReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoCuentaBancoGeneralLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipocuentabancogenerals,tipocuentabancogeneral,tipocuentabancogeneralParameterGeneral,tipocuentabancogeneralReturnGeneral,isEsNuevoTipoCuentaBancoGeneral,clases);
			
			return tipocuentabancogeneralReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoCuentaBancoGeneralParameterReturnGeneral procesarEventosTipoCuentaBancoGeneralsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCuentaBancoGeneral> tipocuentabancogenerals,TipoCuentaBancoGeneral tipocuentabancogeneral,TipoCuentaBancoGeneralParameterReturnGeneral tipocuentabancogeneralParameterGeneral,Boolean isEsNuevoTipoCuentaBancoGeneral,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGeneral.class.getSimpleName()+"-procesarEventosTipoCuentaBancoGeneralsWithConnection");connexion.begin();			
			
			TipoCuentaBancoGeneralParameterReturnGeneral tipocuentabancogeneralReturnGeneral=new TipoCuentaBancoGeneralParameterReturnGeneral();
	
			tipocuentabancogeneralReturnGeneral.setTipoCuentaBancoGeneral(tipocuentabancogeneral);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocuentabancogeneralReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoCuentaBancoGeneralLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipocuentabancogenerals,tipocuentabancogeneral,tipocuentabancogeneralParameterGeneral,tipocuentabancogeneralReturnGeneral,isEsNuevoTipoCuentaBancoGeneral,clases);
			
			this.connexion.commit();
			
			return tipocuentabancogeneralReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCuentaBancoGeneralParameterReturnGeneral procesarImportacionTipoCuentaBancoGeneralsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoCuentaBancoGeneralParameterReturnGeneral tipocuentabancogeneralParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGeneral.class.getSimpleName()+"-procesarImportacionTipoCuentaBancoGeneralsWithConnection");connexion.begin();			
			
			TipoCuentaBancoGeneralParameterReturnGeneral tipocuentabancogeneralReturnGeneral=new TipoCuentaBancoGeneralParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipocuentabancogenerals=new ArrayList<TipoCuentaBancoGeneral>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipocuentabancogeneral=new TipoCuentaBancoGeneral();
				
				
				if(conColumnasBase) {this.tipocuentabancogeneral.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipocuentabancogeneral.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipocuentabancogeneral.setcodigo(arrColumnas[iColumn++]);
				
				this.tipocuentabancogenerals.add(this.tipocuentabancogeneral);
			}
			
			this.saveTipoCuentaBancoGenerals();
			
			this.connexion.commit();
			
			tipocuentabancogeneralReturnGeneral.setConRetornoEstaProcesado(true);
			tipocuentabancogeneralReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipocuentabancogeneralReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoCuentaBancoGeneralsEliminados() throws Exception {				
		
		List<TipoCuentaBancoGeneral> tipocuentabancogeneralsAux= new ArrayList<TipoCuentaBancoGeneral>();
		
		for(TipoCuentaBancoGeneral tipocuentabancogeneral:tipocuentabancogenerals) {
			if(!tipocuentabancogeneral.getIsDeleted()) {
				tipocuentabancogeneralsAux.add(tipocuentabancogeneral);
			}
		}
		
		tipocuentabancogenerals=tipocuentabancogeneralsAux;
	}
	
	public void quitarTipoCuentaBancoGeneralsNulos() throws Exception {				
		
		List<TipoCuentaBancoGeneral> tipocuentabancogeneralsAux= new ArrayList<TipoCuentaBancoGeneral>();
		
		for(TipoCuentaBancoGeneral tipocuentabancogeneral : this.tipocuentabancogenerals) {
			if(tipocuentabancogeneral==null) {
				tipocuentabancogeneralsAux.add(tipocuentabancogeneral);
			}
		}
		
		//this.tipocuentabancogenerals=tipocuentabancogeneralsAux;
		
		this.tipocuentabancogenerals.removeAll(tipocuentabancogeneralsAux);
	}
	
	public void getSetVersionRowTipoCuentaBancoGeneralWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipocuentabancogeneral.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipocuentabancogeneral.getIsDeleted() || (tipocuentabancogeneral.getIsChanged()&&!tipocuentabancogeneral.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipocuentabancogeneralDataAccess.getSetVersionRowTipoCuentaBancoGeneral(connexion,tipocuentabancogeneral.getId());
				
				if(!tipocuentabancogeneral.getVersionRow().equals(timestamp)) {	
					tipocuentabancogeneral.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipocuentabancogeneral.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoCuentaBancoGeneral()throws Exception {	
		
		if(tipocuentabancogeneral.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipocuentabancogeneral.getIsDeleted() || (tipocuentabancogeneral.getIsChanged()&&!tipocuentabancogeneral.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipocuentabancogeneralDataAccess.getSetVersionRowTipoCuentaBancoGeneral(connexion,tipocuentabancogeneral.getId());
			
			try {							
				if(!tipocuentabancogeneral.getVersionRow().equals(timestamp)) {	
					tipocuentabancogeneral.setVersionRow(timestamp);
				}
				
				tipocuentabancogeneral.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoCuentaBancoGeneralsWithConnection()throws Exception {	
		if(tipocuentabancogenerals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoCuentaBancoGeneral tipocuentabancogeneralAux:tipocuentabancogenerals) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipocuentabancogeneralAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocuentabancogeneralAux.getIsDeleted() || (tipocuentabancogeneralAux.getIsChanged()&&!tipocuentabancogeneralAux.getIsNew())) {
						
						timestamp=tipocuentabancogeneralDataAccess.getSetVersionRowTipoCuentaBancoGeneral(connexion,tipocuentabancogeneralAux.getId());
						
						if(!tipocuentabancogeneral.getVersionRow().equals(timestamp)) {	
							tipocuentabancogeneralAux.setVersionRow(timestamp);
						}
								
						tipocuentabancogeneralAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoCuentaBancoGenerals()throws Exception {	
		if(tipocuentabancogenerals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoCuentaBancoGeneral tipocuentabancogeneralAux:tipocuentabancogenerals) {
					if(tipocuentabancogeneralAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocuentabancogeneralAux.getIsDeleted() || (tipocuentabancogeneralAux.getIsChanged()&&!tipocuentabancogeneralAux.getIsNew())) {
						
						timestamp=tipocuentabancogeneralDataAccess.getSetVersionRowTipoCuentaBancoGeneral(connexion,tipocuentabancogeneralAux.getId());
						
						if(!tipocuentabancogeneralAux.getVersionRow().equals(timestamp)) {	
							tipocuentabancogeneralAux.setVersionRow(timestamp);
						}
						
													
						tipocuentabancogeneralAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoCuentaBancoGeneralParameterReturnGeneral cargarCombosLoteForeignKeyTipoCuentaBancoGeneralWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalBanco,String finalQueryGlobalTipoCuentaBanco) throws Exception {
		TipoCuentaBancoGeneralParameterReturnGeneral  tipocuentabancogeneralReturnGeneral =new TipoCuentaBancoGeneralParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGeneral.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoCuentaBancoGeneralWithConnection");connexion.begin();
			
			tipocuentabancogeneralReturnGeneral =new TipoCuentaBancoGeneralParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipocuentabancogeneralReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			tipocuentabancogeneralReturnGeneral.setbancosForeignKey(bancosForeignKey);


			List<TipoCuentaBanco> tipocuentabancosForeignKey=new ArrayList<TipoCuentaBanco>();
			TipoCuentaBancoLogic tipocuentabancoLogic=new TipoCuentaBancoLogic();
			tipocuentabancoLogic.setConnexion(this.connexion);
			tipocuentabancoLogic.getTipoCuentaBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCuentaBanco.equals("NONE")) {
				tipocuentabancoLogic.getTodosTipoCuentaBancos(finalQueryGlobalTipoCuentaBanco,new Pagination());
				tipocuentabancosForeignKey=tipocuentabancoLogic.getTipoCuentaBancos();
			}

			tipocuentabancogeneralReturnGeneral.settipocuentabancosForeignKey(tipocuentabancosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipocuentabancogeneralReturnGeneral;
	}
	
	public TipoCuentaBancoGeneralParameterReturnGeneral cargarCombosLoteForeignKeyTipoCuentaBancoGeneral(String finalQueryGlobalEmpresa,String finalQueryGlobalBanco,String finalQueryGlobalTipoCuentaBanco) throws Exception {
		TipoCuentaBancoGeneralParameterReturnGeneral  tipocuentabancogeneralReturnGeneral =new TipoCuentaBancoGeneralParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipocuentabancogeneralReturnGeneral =new TipoCuentaBancoGeneralParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipocuentabancogeneralReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			tipocuentabancogeneralReturnGeneral.setbancosForeignKey(bancosForeignKey);


			List<TipoCuentaBanco> tipocuentabancosForeignKey=new ArrayList<TipoCuentaBanco>();
			TipoCuentaBancoLogic tipocuentabancoLogic=new TipoCuentaBancoLogic();
			tipocuentabancoLogic.setConnexion(this.connexion);
			tipocuentabancoLogic.getTipoCuentaBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCuentaBanco.equals("NONE")) {
				tipocuentabancoLogic.getTodosTipoCuentaBancos(finalQueryGlobalTipoCuentaBanco,new Pagination());
				tipocuentabancosForeignKey=tipocuentabancoLogic.getTipoCuentaBancos();
			}

			tipocuentabancogeneralReturnGeneral.settipocuentabancosForeignKey(tipocuentabancosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipocuentabancogeneralReturnGeneral;
	}
	
	
	public void deepLoad(TipoCuentaBancoGeneral tipocuentabancogeneral,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoCuentaBancoGeneralLogicAdditional.updateTipoCuentaBancoGeneralToGet(tipocuentabancogeneral,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocuentabancogeneral.setEmpresa(tipocuentabancogeneralDataAccess.getEmpresa(connexion,tipocuentabancogeneral));
		tipocuentabancogeneral.setBanco(tipocuentabancogeneralDataAccess.getBanco(connexion,tipocuentabancogeneral));
		tipocuentabancogeneral.setTipoCuentaBanco(tipocuentabancogeneralDataAccess.getTipoCuentaBanco(connexion,tipocuentabancogeneral));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipocuentabancogeneral.setEmpresa(tipocuentabancogeneralDataAccess.getEmpresa(connexion,tipocuentabancogeneral));
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				tipocuentabancogeneral.setBanco(tipocuentabancogeneralDataAccess.getBanco(connexion,tipocuentabancogeneral));
				continue;
			}

			if(clas.clas.equals(TipoCuentaBanco.class)) {
				tipocuentabancogeneral.setTipoCuentaBanco(tipocuentabancogeneralDataAccess.getTipoCuentaBanco(connexion,tipocuentabancogeneral));
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
			tipocuentabancogeneral.setEmpresa(tipocuentabancogeneralDataAccess.getEmpresa(connexion,tipocuentabancogeneral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipocuentabancogeneral.setBanco(tipocuentabancogeneralDataAccess.getBanco(connexion,tipocuentabancogeneral));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuentaBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipocuentabancogeneral.setTipoCuentaBanco(tipocuentabancogeneralDataAccess.getTipoCuentaBanco(connexion,tipocuentabancogeneral));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocuentabancogeneral.setEmpresa(tipocuentabancogeneralDataAccess.getEmpresa(connexion,tipocuentabancogeneral));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipocuentabancogeneral.getEmpresa(),isDeep,deepLoadType,clases);
				
		tipocuentabancogeneral.setBanco(tipocuentabancogeneralDataAccess.getBanco(connexion,tipocuentabancogeneral));
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(tipocuentabancogeneral.getBanco(),isDeep,deepLoadType,clases);
				
		tipocuentabancogeneral.setTipoCuentaBanco(tipocuentabancogeneralDataAccess.getTipoCuentaBanco(connexion,tipocuentabancogeneral));
		TipoCuentaBancoLogic tipocuentabancoLogic= new TipoCuentaBancoLogic(connexion);
		tipocuentabancoLogic.deepLoad(tipocuentabancogeneral.getTipoCuentaBanco(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipocuentabancogeneral.setEmpresa(tipocuentabancogeneralDataAccess.getEmpresa(connexion,tipocuentabancogeneral));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipocuentabancogeneral.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				tipocuentabancogeneral.setBanco(tipocuentabancogeneralDataAccess.getBanco(connexion,tipocuentabancogeneral));
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepLoad(tipocuentabancogeneral.getBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCuentaBanco.class)) {
				tipocuentabancogeneral.setTipoCuentaBanco(tipocuentabancogeneralDataAccess.getTipoCuentaBanco(connexion,tipocuentabancogeneral));
				TipoCuentaBancoLogic tipocuentabancoLogic= new TipoCuentaBancoLogic(connexion);
				tipocuentabancoLogic.deepLoad(tipocuentabancogeneral.getTipoCuentaBanco(),isDeep,deepLoadType,clases);				
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
			tipocuentabancogeneral.setEmpresa(tipocuentabancogeneralDataAccess.getEmpresa(connexion,tipocuentabancogeneral));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipocuentabancogeneral.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipocuentabancogeneral.setBanco(tipocuentabancogeneralDataAccess.getBanco(connexion,tipocuentabancogeneral));
			BancoLogic bancoLogic= new BancoLogic(connexion);
			bancoLogic.deepLoad(tipocuentabancogeneral.getBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuentaBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipocuentabancogeneral.setTipoCuentaBanco(tipocuentabancogeneralDataAccess.getTipoCuentaBanco(connexion,tipocuentabancogeneral));
			TipoCuentaBancoLogic tipocuentabancoLogic= new TipoCuentaBancoLogic(connexion);
			tipocuentabancoLogic.deepLoad(tipocuentabancogeneral.getTipoCuentaBanco(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoCuentaBancoGeneral tipocuentabancogeneral,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoCuentaBancoGeneralLogicAdditional.updateTipoCuentaBancoGeneralToSave(tipocuentabancogeneral,this.arrDatoGeneral);
			
TipoCuentaBancoGeneralDataAccess.save(tipocuentabancogeneral, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipocuentabancogeneral.getEmpresa(),connexion);

		BancoDataAccess.save(tipocuentabancogeneral.getBanco(),connexion);

		TipoCuentaBancoDataAccess.save(tipocuentabancogeneral.getTipoCuentaBanco(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipocuentabancogeneral.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(tipocuentabancogeneral.getBanco(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCuentaBanco.class)) {
				TipoCuentaBancoDataAccess.save(tipocuentabancogeneral.getTipoCuentaBanco(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipocuentabancogeneral.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipocuentabancogeneral.getEmpresa(),isDeep,deepLoadType,clases);
				

		BancoDataAccess.save(tipocuentabancogeneral.getBanco(),connexion);
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(tipocuentabancogeneral.getBanco(),isDeep,deepLoadType,clases);
				

		TipoCuentaBancoDataAccess.save(tipocuentabancogeneral.getTipoCuentaBanco(),connexion);
		TipoCuentaBancoLogic tipocuentabancoLogic= new TipoCuentaBancoLogic(connexion);
		tipocuentabancoLogic.deepLoad(tipocuentabancogeneral.getTipoCuentaBanco(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipocuentabancogeneral.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipocuentabancogeneral.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(tipocuentabancogeneral.getBanco(),connexion);
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepSave(tipocuentabancogeneral.getBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCuentaBanco.class)) {
				TipoCuentaBancoDataAccess.save(tipocuentabancogeneral.getTipoCuentaBanco(),connexion);
				TipoCuentaBancoLogic tipocuentabancoLogic= new TipoCuentaBancoLogic(connexion);
				tipocuentabancoLogic.deepSave(tipocuentabancogeneral.getTipoCuentaBanco(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TipoCuentaBancoGeneral.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipocuentabancogeneral,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(tipocuentabancogeneral);
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
			this.deepLoad(this.tipocuentabancogeneral,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogeneral);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoCuentaBancoGeneral.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipocuentabancogenerals!=null) {
				for(TipoCuentaBancoGeneral tipocuentabancogeneral:tipocuentabancogenerals) {
					this.deepLoad(tipocuentabancogeneral,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(tipocuentabancogenerals);
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
			if(tipocuentabancogenerals!=null) {
				for(TipoCuentaBancoGeneral tipocuentabancogeneral:tipocuentabancogenerals) {
					this.deepLoad(tipocuentabancogeneral,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(tipocuentabancogenerals);
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
			this.getNewConnexionToDeep(TipoCuentaBancoGeneral.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipocuentabancogeneral,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoCuentaBancoGeneral.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipocuentabancogenerals!=null) {
				for(TipoCuentaBancoGeneral tipocuentabancogeneral:tipocuentabancogenerals) {
					this.deepSave(tipocuentabancogeneral,isDeep,deepLoadType,clases);
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
			if(tipocuentabancogenerals!=null) {
				for(TipoCuentaBancoGeneral tipocuentabancogeneral:tipocuentabancogenerals) {
					this.deepSave(tipocuentabancogeneral,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoCuentaBancoGeneralsFK_IdBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGeneral.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,TipoCuentaBancoGeneralConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			TipoCuentaBancoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocuentabancogenerals=tipocuentabancogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogenerals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoCuentaBancoGeneralsFK_IdBanco(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,TipoCuentaBancoGeneralConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			TipoCuentaBancoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocuentabancogenerals=tipocuentabancogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogenerals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoCuentaBancoGeneralsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGeneral.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoCuentaBancoGeneralConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoCuentaBancoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocuentabancogenerals=tipocuentabancogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogenerals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoCuentaBancoGeneralsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoCuentaBancoGeneralConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoCuentaBancoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocuentabancogenerals=tipocuentabancogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogenerals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoCuentaBancoGeneralsFK_IdTipoCuentaBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cuenta_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGeneral.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCuentaBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCuentaBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cuenta_banco,TipoCuentaBancoGeneralConstantesFunciones.IDTIPOCUENTABANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCuentaBanco);

			TipoCuentaBancoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCuentaBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocuentabancogenerals=tipocuentabancogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogenerals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoCuentaBancoGeneralsFK_IdTipoCuentaBanco(String sFinalQuery,Pagination pagination,Long id_tipo_cuenta_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCuentaBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCuentaBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cuenta_banco,TipoCuentaBancoGeneralConstantesFunciones.IDTIPOCUENTABANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCuentaBanco);

			TipoCuentaBancoGeneralLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCuentaBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocuentabancogenerals=tipocuentabancogeneralDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(this.tipocuentabancogenerals);
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
			if(TipoCuentaBancoGeneralConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCuentaBancoGeneralDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoCuentaBancoGeneral tipocuentabancogeneral,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoCuentaBancoGeneralConstantesFunciones.ISCONAUDITORIA) {
				if(tipocuentabancogeneral.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCuentaBancoGeneralDataAccess.TABLENAME, tipocuentabancogeneral.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCuentaBancoGeneralConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCuentaBancoGeneralLogic.registrarAuditoriaDetallesTipoCuentaBancoGeneral(connexion,tipocuentabancogeneral,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipocuentabancogeneral.getIsDeleted()) {
					/*if(!tipocuentabancogeneral.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoCuentaBancoGeneralDataAccess.TABLENAME, tipocuentabancogeneral.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoCuentaBancoGeneralLogic.registrarAuditoriaDetallesTipoCuentaBancoGeneral(connexion,tipocuentabancogeneral,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCuentaBancoGeneralDataAccess.TABLENAME, tipocuentabancogeneral.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipocuentabancogeneral.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCuentaBancoGeneralDataAccess.TABLENAME, tipocuentabancogeneral.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCuentaBancoGeneralConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCuentaBancoGeneralLogic.registrarAuditoriaDetallesTipoCuentaBancoGeneral(connexion,tipocuentabancogeneral,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoCuentaBancoGeneral(Connexion connexion,TipoCuentaBancoGeneral tipocuentabancogeneral)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipocuentabancogeneral.getIsNew()||!tipocuentabancogeneral.getid_empresa().equals(tipocuentabancogeneral.getTipoCuentaBancoGeneralOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocuentabancogeneral.getTipoCuentaBancoGeneralOriginal().getid_empresa()!=null)
				{
					strValorActual=tipocuentabancogeneral.getTipoCuentaBancoGeneralOriginal().getid_empresa().toString();
				}
				if(tipocuentabancogeneral.getid_empresa()!=null)
				{
					strValorNuevo=tipocuentabancogeneral.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCuentaBancoGeneralConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipocuentabancogeneral.getIsNew()||!tipocuentabancogeneral.getid_banco().equals(tipocuentabancogeneral.getTipoCuentaBancoGeneralOriginal().getid_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocuentabancogeneral.getTipoCuentaBancoGeneralOriginal().getid_banco()!=null)
				{
					strValorActual=tipocuentabancogeneral.getTipoCuentaBancoGeneralOriginal().getid_banco().toString();
				}
				if(tipocuentabancogeneral.getid_banco()!=null)
				{
					strValorNuevo=tipocuentabancogeneral.getid_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCuentaBancoGeneralConstantesFunciones.IDBANCO,strValorActual,strValorNuevo);
			}	
			
			if(tipocuentabancogeneral.getIsNew()||!tipocuentabancogeneral.getid_tipo_cuenta_banco().equals(tipocuentabancogeneral.getTipoCuentaBancoGeneralOriginal().getid_tipo_cuenta_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocuentabancogeneral.getTipoCuentaBancoGeneralOriginal().getid_tipo_cuenta_banco()!=null)
				{
					strValorActual=tipocuentabancogeneral.getTipoCuentaBancoGeneralOriginal().getid_tipo_cuenta_banco().toString();
				}
				if(tipocuentabancogeneral.getid_tipo_cuenta_banco()!=null)
				{
					strValorNuevo=tipocuentabancogeneral.getid_tipo_cuenta_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCuentaBancoGeneralConstantesFunciones.IDTIPOCUENTABANCO,strValorActual,strValorNuevo);
			}	
			
			if(tipocuentabancogeneral.getIsNew()||!tipocuentabancogeneral.getcodigo().equals(tipocuentabancogeneral.getTipoCuentaBancoGeneralOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocuentabancogeneral.getTipoCuentaBancoGeneralOriginal().getcodigo()!=null)
				{
					strValorActual=tipocuentabancogeneral.getTipoCuentaBancoGeneralOriginal().getcodigo();
				}
				if(tipocuentabancogeneral.getcodigo()!=null)
				{
					strValorNuevo=tipocuentabancogeneral.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCuentaBancoGeneralConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoCuentaBancoGeneralRelacionesWithConnection(TipoCuentaBancoGeneral tipocuentabancogeneral) throws Exception {

		if(!tipocuentabancogeneral.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoCuentaBancoGeneralRelacionesBase(tipocuentabancogeneral,true);
		}
	}

	public void saveTipoCuentaBancoGeneralRelaciones(TipoCuentaBancoGeneral tipocuentabancogeneral)throws Exception {

		if(!tipocuentabancogeneral.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoCuentaBancoGeneralRelacionesBase(tipocuentabancogeneral,false);
		}
	}

	public void saveTipoCuentaBancoGeneralRelacionesBase(TipoCuentaBancoGeneral tipocuentabancogeneral,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoCuentaBancoGeneral-saveRelacionesWithConnection");}
	

			this.setTipoCuentaBancoGeneral(tipocuentabancogeneral);

			if(TipoCuentaBancoGeneralLogicAdditional.validarSaveRelaciones(tipocuentabancogeneral,this)) {

				TipoCuentaBancoGeneralLogicAdditional.updateRelacionesToSave(tipocuentabancogeneral,this);

				if((tipocuentabancogeneral.getIsNew()||tipocuentabancogeneral.getIsChanged())&&!tipocuentabancogeneral.getIsDeleted()) {
					this.saveTipoCuentaBancoGeneral();
					this.saveTipoCuentaBancoGeneralRelacionesDetalles();

				} else if(tipocuentabancogeneral.getIsDeleted()) {
					this.saveTipoCuentaBancoGeneralRelacionesDetalles();
					this.saveTipoCuentaBancoGeneral();
				}

				TipoCuentaBancoGeneralLogicAdditional.updateRelacionesToSaveAfter(tipocuentabancogeneral,this);

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
	
	
	private void saveTipoCuentaBancoGeneralRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCuentaBancoGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCuentaBancoGeneralConstantesFunciones.getClassesForeignKeysOfTipoCuentaBancoGeneral(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCuentaBancoGeneral(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCuentaBancoGeneralConstantesFunciones.getClassesRelationshipsOfTipoCuentaBancoGeneral(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

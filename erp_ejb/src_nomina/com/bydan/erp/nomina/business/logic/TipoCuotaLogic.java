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
import com.bydan.erp.nomina.util.TipoCuotaConstantesFunciones;
import com.bydan.erp.nomina.util.TipoCuotaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoCuotaParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoCuota;
import com.bydan.erp.nomina.business.logic.TipoCuotaLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoCuotaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoCuotaLogic.class);
	
	protected TipoCuotaDataAccess tipocuotaDataAccess; 	
	protected TipoCuota tipocuota;
	protected List<TipoCuota> tipocuotas;
	protected Object tipocuotaObject;	
	protected List<Object> tipocuotasObject;
	
	public static ClassValidator<TipoCuota> tipocuotaValidator = new ClassValidator<TipoCuota>(TipoCuota.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoCuotaLogicAdditional tipocuotaLogicAdditional=null;
	
	public TipoCuotaLogicAdditional getTipoCuotaLogicAdditional() {
		return this.tipocuotaLogicAdditional;
	}
	
	public void setTipoCuotaLogicAdditional(TipoCuotaLogicAdditional tipocuotaLogicAdditional) {
		try {
			this.tipocuotaLogicAdditional=tipocuotaLogicAdditional;
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
	
	
	
	
	public  TipoCuotaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipocuotaDataAccess = new TipoCuotaDataAccess();
			
			this.tipocuotas= new ArrayList<TipoCuota>();
			this.tipocuota= new TipoCuota();
			
			this.tipocuotaObject=new Object();
			this.tipocuotasObject=new ArrayList<Object>();
				
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
			
			this.tipocuotaDataAccess.setConnexionType(this.connexionType);
			this.tipocuotaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoCuotaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipocuotaDataAccess = new TipoCuotaDataAccess();
			this.tipocuotas= new ArrayList<TipoCuota>();
			this.tipocuota= new TipoCuota();
			this.tipocuotaObject=new Object();
			this.tipocuotasObject=new ArrayList<Object>();
			
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
			
			this.tipocuotaDataAccess.setConnexionType(this.connexionType);
			this.tipocuotaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoCuota getTipoCuota() throws Exception {	
		TipoCuotaLogicAdditional.checkTipoCuotaToGet(tipocuota,this.datosCliente,this.arrDatoGeneral);
		TipoCuotaLogicAdditional.updateTipoCuotaToGet(tipocuota,this.arrDatoGeneral);
		
		return tipocuota;
	}
		
	public void setTipoCuota(TipoCuota newTipoCuota) {
		this.tipocuota = newTipoCuota;
	}
	
	public TipoCuotaDataAccess getTipoCuotaDataAccess() {
		return tipocuotaDataAccess;
	}
	
	public void setTipoCuotaDataAccess(TipoCuotaDataAccess newtipocuotaDataAccess) {
		this.tipocuotaDataAccess = newtipocuotaDataAccess;
	}
	
	public List<TipoCuota> getTipoCuotas() throws Exception {		
		this.quitarTipoCuotasNulos();
		
		TipoCuotaLogicAdditional.checkTipoCuotaToGets(tipocuotas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoCuota tipocuotaLocal: tipocuotas ) {
			TipoCuotaLogicAdditional.updateTipoCuotaToGet(tipocuotaLocal,this.arrDatoGeneral);
		}
		
		return tipocuotas;
	}
	
	public void setTipoCuotas(List<TipoCuota> newTipoCuotas) {
		this.tipocuotas = newTipoCuotas;
	}
	
	public Object getTipoCuotaObject() {	
		this.tipocuotaObject=this.tipocuotaDataAccess.getEntityObject();
		return this.tipocuotaObject;
	}
		
	public void setTipoCuotaObject(Object newTipoCuotaObject) {
		this.tipocuotaObject = newTipoCuotaObject;
	}
	
	public List<Object> getTipoCuotasObject() {		
		this.tipocuotasObject=this.tipocuotaDataAccess.getEntitiesObject();
		return this.tipocuotasObject;
	}
		
	public void setTipoCuotasObject(List<Object> newTipoCuotasObject) {
		this.tipocuotasObject = newTipoCuotasObject;
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
		
		if(this.tipocuotaDataAccess!=null) {
			this.tipocuotaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuota.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipocuotaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipocuotaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipocuota = new  TipoCuota();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuota.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocuota=tipocuotaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocuota,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuota(this.tipocuota);
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
		tipocuota = new  TipoCuota();
		  		  
        try {
			
			tipocuota=tipocuotaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocuota,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuota(this.tipocuota);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipocuota = new  TipoCuota();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuota.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocuota=tipocuotaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocuota,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuota(this.tipocuota);
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
		tipocuota = new  TipoCuota();
		  		  
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
		tipocuota = new  TipoCuota();
		  		  
        try {
			
			tipocuota=tipocuotaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocuota,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuota(this.tipocuota);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipocuota = new  TipoCuota();
		  		  
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
		tipocuota = new  TipoCuota();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuota.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipocuotaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocuota = new  TipoCuota();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipocuotaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocuota = new  TipoCuota();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuota.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipocuotaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocuota = new  TipoCuota();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipocuotaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocuota = new  TipoCuota();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuota.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipocuotaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocuota = new  TipoCuota();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipocuotaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocuotas = new  ArrayList<TipoCuota>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuota.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuotas=tipocuotaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuota(tipocuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuota(this.tipocuotas);
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
		tipocuotas = new  ArrayList<TipoCuota>();
		  		  
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
		tipocuotas = new  ArrayList<TipoCuota>();
		  		  
        try {			
			TipoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuotas=tipocuotaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoCuota(tipocuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuota(this.tipocuotas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipocuotas = new  ArrayList<TipoCuota>();
		  		  
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
		tipocuotas = new  ArrayList<TipoCuota>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuota.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuotas=tipocuotaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuota(tipocuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuota(this.tipocuotas);
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
		tipocuotas = new  ArrayList<TipoCuota>();
		  		  
        try {
			TipoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuotas=tipocuotaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuota(tipocuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuota(this.tipocuotas);
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
		tipocuotas = new  ArrayList<TipoCuota>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuota.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuotas=tipocuotaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCuota(tipocuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuota(this.tipocuotas);
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
		tipocuotas = new  ArrayList<TipoCuota>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuotas=tipocuotaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCuota(tipocuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuota(this.tipocuotas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipocuota = new  TipoCuota();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuota.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuota=tipocuotaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCuota(tipocuota);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuota(this.tipocuota);
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
		tipocuota = new  TipoCuota();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuota=tipocuotaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCuota(tipocuota);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuota(this.tipocuota);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocuotas = new  ArrayList<TipoCuota>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuota.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuotas=tipocuotaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuota(tipocuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuota(this.tipocuotas);
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
		tipocuotas = new  ArrayList<TipoCuota>();
		  		  
        try {
			TipoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuotas=tipocuotaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuota(tipocuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuota(this.tipocuotas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoCuotasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipocuotas = new  ArrayList<TipoCuota>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuota.class.getSimpleName()+"-getTodosTipoCuotasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuotas=tipocuotaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCuota(tipocuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuota(this.tipocuotas);
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
	
	public  void  getTodosTipoCuotas(String sFinalQuery,Pagination pagination)throws Exception {
		tipocuotas = new  ArrayList<TipoCuota>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuotas=tipocuotaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCuota(tipocuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuota(this.tipocuotas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoCuota(TipoCuota tipocuota) throws Exception {
		Boolean estaValidado=false;
		
		if(tipocuota.getIsNew() || tipocuota.getIsChanged()) { 
			this.invalidValues = tipocuotaValidator.getInvalidValues(tipocuota);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipocuota);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoCuota(List<TipoCuota> TipoCuotas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoCuota tipocuotaLocal:tipocuotas) {				
			estaValidadoObjeto=this.validarGuardarTipoCuota(tipocuotaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoCuota(List<TipoCuota> TipoCuotas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCuota(tipocuotas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoCuota(TipoCuota TipoCuota) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCuota(tipocuota)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoCuota tipocuota) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipocuota.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoCuotaConstantesFunciones.getTipoCuotaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipocuota","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoCuotaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoCuotaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoCuotaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuota.class.getSimpleName()+"-saveTipoCuotaWithConnection");connexion.begin();			
			
			TipoCuotaLogicAdditional.checkTipoCuotaToSave(this.tipocuota,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoCuotaLogicAdditional.updateTipoCuotaToSave(this.tipocuota,this.arrDatoGeneral);
			
			TipoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocuota,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoCuota();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCuota(this.tipocuota)) {
				TipoCuotaDataAccess.save(this.tipocuota, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipocuota,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoCuotaLogicAdditional.checkTipoCuotaToSaveAfter(this.tipocuota,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCuota();
			
			connexion.commit();			
			
			if(this.tipocuota.getIsDeleted()) {
				this.tipocuota=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoCuota()throws Exception {	
		try {	
			
			TipoCuotaLogicAdditional.checkTipoCuotaToSave(this.tipocuota,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoCuotaLogicAdditional.updateTipoCuotaToSave(this.tipocuota,this.arrDatoGeneral);
			
			TipoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocuota,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCuota(this.tipocuota)) {			
				TipoCuotaDataAccess.save(this.tipocuota, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipocuota,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoCuotaLogicAdditional.checkTipoCuotaToSaveAfter(this.tipocuota,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipocuota.getIsDeleted()) {
				this.tipocuota=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoCuotasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuota.class.getSimpleName()+"-saveTipoCuotasWithConnection");connexion.begin();			
			
			TipoCuotaLogicAdditional.checkTipoCuotaToSaves(tipocuotas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoCuotas();
			
			Boolean validadoTodosTipoCuota=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCuota tipocuotaLocal:tipocuotas) {		
				if(tipocuotaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoCuotaLogicAdditional.updateTipoCuotaToSave(tipocuotaLocal,this.arrDatoGeneral);
	        	
				TipoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocuotaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCuota(tipocuotaLocal)) {
					TipoCuotaDataAccess.save(tipocuotaLocal, connexion);				
				} else {
					validadoTodosTipoCuota=false;
				}
			}
			
			if(!validadoTodosTipoCuota) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoCuotaLogicAdditional.checkTipoCuotaToSavesAfter(tipocuotas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCuotas();
			
			connexion.commit();		
			
			this.quitarTipoCuotasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoCuotas()throws Exception {				
		 try {	
			TipoCuotaLogicAdditional.checkTipoCuotaToSaves(tipocuotas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoCuota=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCuota tipocuotaLocal:tipocuotas) {				
				if(tipocuotaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoCuotaLogicAdditional.updateTipoCuotaToSave(tipocuotaLocal,this.arrDatoGeneral);
	        	
				TipoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocuotaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCuota(tipocuotaLocal)) {				
					TipoCuotaDataAccess.save(tipocuotaLocal, connexion);				
				} else {
					validadoTodosTipoCuota=false;
				}
			}
			
			if(!validadoTodosTipoCuota) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoCuotaLogicAdditional.checkTipoCuotaToSavesAfter(tipocuotas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoCuotasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCuotaParameterReturnGeneral procesarAccionTipoCuotas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCuota> tipocuotas,TipoCuotaParameterReturnGeneral tipocuotaParameterGeneral)throws Exception {
		 try {	
			TipoCuotaParameterReturnGeneral tipocuotaReturnGeneral=new TipoCuotaParameterReturnGeneral();
	
			TipoCuotaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipocuotas,tipocuotaParameterGeneral,tipocuotaReturnGeneral);
			
			return tipocuotaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCuotaParameterReturnGeneral procesarAccionTipoCuotasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCuota> tipocuotas,TipoCuotaParameterReturnGeneral tipocuotaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuota.class.getSimpleName()+"-procesarAccionTipoCuotasWithConnection");connexion.begin();			
			
			TipoCuotaParameterReturnGeneral tipocuotaReturnGeneral=new TipoCuotaParameterReturnGeneral();
	
			TipoCuotaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipocuotas,tipocuotaParameterGeneral,tipocuotaReturnGeneral);
			
			this.connexion.commit();
			
			return tipocuotaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCuotaParameterReturnGeneral procesarEventosTipoCuotas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCuota> tipocuotas,TipoCuota tipocuota,TipoCuotaParameterReturnGeneral tipocuotaParameterGeneral,Boolean isEsNuevoTipoCuota,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoCuotaParameterReturnGeneral tipocuotaReturnGeneral=new TipoCuotaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocuotaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoCuotaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipocuotas,tipocuota,tipocuotaParameterGeneral,tipocuotaReturnGeneral,isEsNuevoTipoCuota,clases);
			
			return tipocuotaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoCuotaParameterReturnGeneral procesarEventosTipoCuotasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCuota> tipocuotas,TipoCuota tipocuota,TipoCuotaParameterReturnGeneral tipocuotaParameterGeneral,Boolean isEsNuevoTipoCuota,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuota.class.getSimpleName()+"-procesarEventosTipoCuotasWithConnection");connexion.begin();			
			
			TipoCuotaParameterReturnGeneral tipocuotaReturnGeneral=new TipoCuotaParameterReturnGeneral();
	
			tipocuotaReturnGeneral.setTipoCuota(tipocuota);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocuotaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoCuotaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipocuotas,tipocuota,tipocuotaParameterGeneral,tipocuotaReturnGeneral,isEsNuevoTipoCuota,clases);
			
			this.connexion.commit();
			
			return tipocuotaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCuotaParameterReturnGeneral procesarImportacionTipoCuotasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoCuotaParameterReturnGeneral tipocuotaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuota.class.getSimpleName()+"-procesarImportacionTipoCuotasWithConnection");connexion.begin();			
			
			TipoCuotaParameterReturnGeneral tipocuotaReturnGeneral=new TipoCuotaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipocuotas=new ArrayList<TipoCuota>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipocuota=new TipoCuota();
				
				
				if(conColumnasBase) {this.tipocuota.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipocuota.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipocuota.setcodigo(arrColumnas[iColumn++]);
				this.tipocuota.setnombre(arrColumnas[iColumn++]);
				this.tipocuota.setes_prove(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.tipocuotas.add(this.tipocuota);
			}
			
			this.saveTipoCuotas();
			
			this.connexion.commit();
			
			tipocuotaReturnGeneral.setConRetornoEstaProcesado(true);
			tipocuotaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipocuotaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoCuotasEliminados() throws Exception {				
		
		List<TipoCuota> tipocuotasAux= new ArrayList<TipoCuota>();
		
		for(TipoCuota tipocuota:tipocuotas) {
			if(!tipocuota.getIsDeleted()) {
				tipocuotasAux.add(tipocuota);
			}
		}
		
		tipocuotas=tipocuotasAux;
	}
	
	public void quitarTipoCuotasNulos() throws Exception {				
		
		List<TipoCuota> tipocuotasAux= new ArrayList<TipoCuota>();
		
		for(TipoCuota tipocuota : this.tipocuotas) {
			if(tipocuota==null) {
				tipocuotasAux.add(tipocuota);
			}
		}
		
		//this.tipocuotas=tipocuotasAux;
		
		this.tipocuotas.removeAll(tipocuotasAux);
	}
	
	public void getSetVersionRowTipoCuotaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipocuota.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipocuota.getIsDeleted() || (tipocuota.getIsChanged()&&!tipocuota.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipocuotaDataAccess.getSetVersionRowTipoCuota(connexion,tipocuota.getId());
				
				if(!tipocuota.getVersionRow().equals(timestamp)) {	
					tipocuota.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipocuota.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoCuota()throws Exception {	
		
		if(tipocuota.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipocuota.getIsDeleted() || (tipocuota.getIsChanged()&&!tipocuota.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipocuotaDataAccess.getSetVersionRowTipoCuota(connexion,tipocuota.getId());
			
			try {							
				if(!tipocuota.getVersionRow().equals(timestamp)) {	
					tipocuota.setVersionRow(timestamp);
				}
				
				tipocuota.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoCuotasWithConnection()throws Exception {	
		if(tipocuotas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoCuota tipocuotaAux:tipocuotas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipocuotaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocuotaAux.getIsDeleted() || (tipocuotaAux.getIsChanged()&&!tipocuotaAux.getIsNew())) {
						
						timestamp=tipocuotaDataAccess.getSetVersionRowTipoCuota(connexion,tipocuotaAux.getId());
						
						if(!tipocuota.getVersionRow().equals(timestamp)) {	
							tipocuotaAux.setVersionRow(timestamp);
						}
								
						tipocuotaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoCuotas()throws Exception {	
		if(tipocuotas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoCuota tipocuotaAux:tipocuotas) {
					if(tipocuotaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocuotaAux.getIsDeleted() || (tipocuotaAux.getIsChanged()&&!tipocuotaAux.getIsNew())) {
						
						timestamp=tipocuotaDataAccess.getSetVersionRowTipoCuota(connexion,tipocuotaAux.getId());
						
						if(!tipocuotaAux.getVersionRow().equals(timestamp)) {	
							tipocuotaAux.setVersionRow(timestamp);
						}
						
													
						tipocuotaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoCuotaParameterReturnGeneral cargarCombosLoteForeignKeyTipoCuotaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoCuotaParameterReturnGeneral  tipocuotaReturnGeneral =new TipoCuotaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuota.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoCuotaWithConnection");connexion.begin();
			
			tipocuotaReturnGeneral =new TipoCuotaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipocuotaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipocuotaReturnGeneral;
	}
	
	public TipoCuotaParameterReturnGeneral cargarCombosLoteForeignKeyTipoCuota(String finalQueryGlobalEmpresa) throws Exception {
		TipoCuotaParameterReturnGeneral  tipocuotaReturnGeneral =new TipoCuotaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipocuotaReturnGeneral =new TipoCuotaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipocuotaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipocuotaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoCuotaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PrestamoLogic prestamoLogic=new PrestamoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuota.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoCuotaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Prestamo.class));
											
			

			prestamoLogic.setConnexion(this.getConnexion());
			prestamoLogic.setDatosCliente(this.datosCliente);
			prestamoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoCuota tipocuota:this.tipocuotas) {
				

				classes=new ArrayList<Classe>();
				classes=PrestamoConstantesFunciones.getClassesForeignKeysOfPrestamo(new ArrayList<Classe>(),DeepLoadType.NONE);

				prestamoLogic.setPrestamos(tipocuota.prestamos);
				prestamoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoCuota tipocuota,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoCuotaLogicAdditional.updateTipoCuotaToGet(tipocuota,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocuota.setEmpresa(tipocuotaDataAccess.getEmpresa(connexion,tipocuota));
		tipocuota.setPrestamos(tipocuotaDataAccess.getPrestamos(connexion,tipocuota));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipocuota.setEmpresa(tipocuotaDataAccess.getEmpresa(connexion,tipocuota));
				continue;
			}

			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocuota.setPrestamos(tipocuotaDataAccess.getPrestamos(connexion,tipocuota));

				if(this.isConDeep) {
					PrestamoLogic prestamoLogic= new PrestamoLogic(this.connexion);
					prestamoLogic.setPrestamos(tipocuota.getPrestamos());
					ArrayList<Classe> classesLocal=PrestamoConstantesFunciones.getClassesForeignKeysOfPrestamo(new ArrayList<Classe>(),DeepLoadType.NONE);
					prestamoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PrestamoConstantesFunciones.refrescarForeignKeysDescripcionesPrestamo(prestamoLogic.getPrestamos());
					tipocuota.setPrestamos(prestamoLogic.getPrestamos());
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
			tipocuota.setEmpresa(tipocuotaDataAccess.getEmpresa(connexion,tipocuota));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Prestamo.class));
			tipocuota.setPrestamos(tipocuotaDataAccess.getPrestamos(connexion,tipocuota));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocuota.setEmpresa(tipocuotaDataAccess.getEmpresa(connexion,tipocuota));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipocuota.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipocuota.setPrestamos(tipocuotaDataAccess.getPrestamos(connexion,tipocuota));

		for(Prestamo prestamo:tipocuota.getPrestamos()) {
			PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
			prestamoLogic.deepLoad(prestamo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipocuota.setEmpresa(tipocuotaDataAccess.getEmpresa(connexion,tipocuota));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipocuota.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocuota.setPrestamos(tipocuotaDataAccess.getPrestamos(connexion,tipocuota));

				for(Prestamo prestamo:tipocuota.getPrestamos()) {
					PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
					prestamoLogic.deepLoad(prestamo,isDeep,deepLoadType,clases);
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
			tipocuota.setEmpresa(tipocuotaDataAccess.getEmpresa(connexion,tipocuota));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipocuota.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Prestamo.class));
			tipocuota.setPrestamos(tipocuotaDataAccess.getPrestamos(connexion,tipocuota));

			for(Prestamo prestamo:tipocuota.getPrestamos()) {
				PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
				prestamoLogic.deepLoad(prestamo,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoCuota tipocuota,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoCuotaLogicAdditional.updateTipoCuotaToSave(tipocuota,this.arrDatoGeneral);
			
TipoCuotaDataAccess.save(tipocuota, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipocuota.getEmpresa(),connexion);

		for(Prestamo prestamo:tipocuota.getPrestamos()) {
			prestamo.setid_tipo_cuota(tipocuota.getId());
			PrestamoDataAccess.save(prestamo,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipocuota.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Prestamo prestamo:tipocuota.getPrestamos()) {
					prestamo.setid_tipo_cuota(tipocuota.getId());
					PrestamoDataAccess.save(prestamo,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipocuota.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipocuota.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(Prestamo prestamo:tipocuota.getPrestamos()) {
			PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
			prestamo.setid_tipo_cuota(tipocuota.getId());
			PrestamoDataAccess.save(prestamo,connexion);
			prestamoLogic.deepSave(prestamo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipocuota.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipocuota.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Prestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Prestamo prestamo:tipocuota.getPrestamos()) {
					PrestamoLogic prestamoLogic= new PrestamoLogic(connexion);
					prestamo.setid_tipo_cuota(tipocuota.getId());
					PrestamoDataAccess.save(prestamo,connexion);
					prestamoLogic.deepSave(prestamo,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoCuota.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipocuota,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuota(tipocuota);
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
			this.deepLoad(this.tipocuota,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuota(this.tipocuota);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoCuota.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipocuotas!=null) {
				for(TipoCuota tipocuota:tipocuotas) {
					this.deepLoad(tipocuota,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuota(tipocuotas);
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
			if(tipocuotas!=null) {
				for(TipoCuota tipocuota:tipocuotas) {
					this.deepLoad(tipocuota,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuota(tipocuotas);
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
			this.getNewConnexionToDeep(TipoCuota.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipocuota,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoCuota.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipocuotas!=null) {
				for(TipoCuota tipocuota:tipocuotas) {
					this.deepSave(tipocuota,isDeep,deepLoadType,clases);
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
			if(tipocuotas!=null) {
				for(TipoCuota tipocuota:tipocuotas) {
					this.deepSave(tipocuota,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoCuotasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuota.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoCuotaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocuotas=tipocuotaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuota(this.tipocuotas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoCuotasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoCuotaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocuotas=tipocuotaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuota(this.tipocuotas);
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
			if(TipoCuotaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCuotaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoCuota tipocuota,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoCuotaConstantesFunciones.ISCONAUDITORIA) {
				if(tipocuota.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCuotaDataAccess.TABLENAME, tipocuota.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCuotaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCuotaLogic.registrarAuditoriaDetallesTipoCuota(connexion,tipocuota,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipocuota.getIsDeleted()) {
					/*if(!tipocuota.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoCuotaDataAccess.TABLENAME, tipocuota.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoCuotaLogic.registrarAuditoriaDetallesTipoCuota(connexion,tipocuota,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCuotaDataAccess.TABLENAME, tipocuota.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipocuota.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCuotaDataAccess.TABLENAME, tipocuota.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCuotaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCuotaLogic.registrarAuditoriaDetallesTipoCuota(connexion,tipocuota,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoCuota(Connexion connexion,TipoCuota tipocuota)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipocuota.getIsNew()||!tipocuota.getid_empresa().equals(tipocuota.getTipoCuotaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocuota.getTipoCuotaOriginal().getid_empresa()!=null)
				{
					strValorActual=tipocuota.getTipoCuotaOriginal().getid_empresa().toString();
				}
				if(tipocuota.getid_empresa()!=null)
				{
					strValorNuevo=tipocuota.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCuotaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipocuota.getIsNew()||!tipocuota.getcodigo().equals(tipocuota.getTipoCuotaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocuota.getTipoCuotaOriginal().getcodigo()!=null)
				{
					strValorActual=tipocuota.getTipoCuotaOriginal().getcodigo();
				}
				if(tipocuota.getcodigo()!=null)
				{
					strValorNuevo=tipocuota.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCuotaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipocuota.getIsNew()||!tipocuota.getnombre().equals(tipocuota.getTipoCuotaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocuota.getTipoCuotaOriginal().getnombre()!=null)
				{
					strValorActual=tipocuota.getTipoCuotaOriginal().getnombre();
				}
				if(tipocuota.getnombre()!=null)
				{
					strValorNuevo=tipocuota.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCuotaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipocuota.getIsNew()||!tipocuota.getes_prove().equals(tipocuota.getTipoCuotaOriginal().getes_prove()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocuota.getTipoCuotaOriginal().getes_prove()!=null)
				{
					strValorActual=tipocuota.getTipoCuotaOriginal().getes_prove().toString();
				}
				if(tipocuota.getes_prove()!=null)
				{
					strValorNuevo=tipocuota.getes_prove().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCuotaConstantesFunciones.ESPROVE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoCuotaRelacionesWithConnection(TipoCuota tipocuota,List<Prestamo> prestamos) throws Exception {

		if(!tipocuota.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoCuotaRelacionesBase(tipocuota,prestamos,true);
		}
	}

	public void saveTipoCuotaRelaciones(TipoCuota tipocuota,List<Prestamo> prestamos)throws Exception {

		if(!tipocuota.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoCuotaRelacionesBase(tipocuota,prestamos,false);
		}
	}

	public void saveTipoCuotaRelacionesBase(TipoCuota tipocuota,List<Prestamo> prestamos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoCuota-saveRelacionesWithConnection");}
	
			tipocuota.setPrestamos(prestamos);

			this.setTipoCuota(tipocuota);

			if(TipoCuotaLogicAdditional.validarSaveRelaciones(tipocuota,this)) {

				TipoCuotaLogicAdditional.updateRelacionesToSave(tipocuota,this);

				if((tipocuota.getIsNew()||tipocuota.getIsChanged())&&!tipocuota.getIsDeleted()) {
					this.saveTipoCuota();
					this.saveTipoCuotaRelacionesDetalles(prestamos);

				} else if(tipocuota.getIsDeleted()) {
					this.saveTipoCuotaRelacionesDetalles(prestamos);
					this.saveTipoCuota();
				}

				TipoCuotaLogicAdditional.updateRelacionesToSaveAfter(tipocuota,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			PrestamoConstantesFunciones.InicializarGeneralEntityAuxiliaresPrestamos(prestamos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoCuotaRelacionesDetalles(List<Prestamo> prestamos)throws Exception {
		try {
	

			Long idTipoCuotaActual=this.getTipoCuota().getId();

			PrestamoLogic prestamoLogic_Desde_TipoCuota=new PrestamoLogic();
			prestamoLogic_Desde_TipoCuota.setPrestamos(prestamos);

			prestamoLogic_Desde_TipoCuota.setConnexion(this.getConnexion());
			prestamoLogic_Desde_TipoCuota.setDatosCliente(this.datosCliente);

			for(Prestamo prestamo_Desde_TipoCuota:prestamoLogic_Desde_TipoCuota.getPrestamos()) {
				prestamo_Desde_TipoCuota.setid_tipo_cuota(idTipoCuotaActual);

				prestamoLogic_Desde_TipoCuota.setPrestamo(prestamo_Desde_TipoCuota);
				prestamoLogic_Desde_TipoCuota.savePrestamo();

				Long idPrestamoActual=prestamo_Desde_TipoCuota.getId();

				AbonoPrestamoLogic abonoprestamoLogic_Desde_Prestamo=new AbonoPrestamoLogic();

				if(prestamo_Desde_TipoCuota.getAbonoPrestamos()==null){
					prestamo_Desde_TipoCuota.setAbonoPrestamos(new ArrayList<AbonoPrestamo>());
				}

				abonoprestamoLogic_Desde_Prestamo.setAbonoPrestamos(prestamo_Desde_TipoCuota.getAbonoPrestamos());

				abonoprestamoLogic_Desde_Prestamo.setConnexion(this.getConnexion());
				abonoprestamoLogic_Desde_Prestamo.setDatosCliente(this.datosCliente);

				for(AbonoPrestamo abonoprestamo_Desde_Prestamo:abonoprestamoLogic_Desde_Prestamo.getAbonoPrestamos()) {
					abonoprestamo_Desde_Prestamo.setid_prestamo(idPrestamoActual);
				}

				abonoprestamoLogic_Desde_Prestamo.saveAbonoPrestamos();

				CuotaLogic cuotaLogic_Desde_Prestamo=new CuotaLogic();

				if(prestamo_Desde_TipoCuota.getCuotas()==null){
					prestamo_Desde_TipoCuota.setCuotas(new ArrayList<Cuota>());
				}

				cuotaLogic_Desde_Prestamo.setCuotas(prestamo_Desde_TipoCuota.getCuotas());

				cuotaLogic_Desde_Prestamo.setConnexion(this.getConnexion());
				cuotaLogic_Desde_Prestamo.setDatosCliente(this.datosCliente);

				for(Cuota cuota_Desde_Prestamo:cuotaLogic_Desde_Prestamo.getCuotas()) {
					cuota_Desde_Prestamo.setid_prestamo(idPrestamoActual);
				}

				cuotaLogic_Desde_Prestamo.saveCuotas();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCuota(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCuotaConstantesFunciones.getClassesForeignKeysOfTipoCuota(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCuota(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCuotaConstantesFunciones.getClassesRelationshipsOfTipoCuota(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.nomina.util.TipoPago_NMConstantesFunciones;
import com.bydan.erp.nomina.util.TipoPago_NMParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoPago_NMParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoPago_NM;
import com.bydan.erp.nomina.business.logic.TipoPago_NMLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoPago_NMLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoPago_NMLogic.class);
	
	protected TipoPago_NMDataAccess tipopago_nmDataAccess; 	
	protected TipoPago_NM tipopago_nm;
	protected List<TipoPago_NM> tipopago_nms;
	protected Object tipopago_nmObject;	
	protected List<Object> tipopago_nmsObject;
	
	public static ClassValidator<TipoPago_NM> tipopago_nmValidator = new ClassValidator<TipoPago_NM>(TipoPago_NM.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoPago_NMLogicAdditional tipopago_nmLogicAdditional=null;
	
	public TipoPago_NMLogicAdditional getTipoPago_NMLogicAdditional() {
		return this.tipopago_nmLogicAdditional;
	}
	
	public void setTipoPago_NMLogicAdditional(TipoPago_NMLogicAdditional tipopago_nmLogicAdditional) {
		try {
			this.tipopago_nmLogicAdditional=tipopago_nmLogicAdditional;
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
	
	
	
	
	public  TipoPago_NMLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipopago_nmDataAccess = new TipoPago_NMDataAccess();
			
			this.tipopago_nms= new ArrayList<TipoPago_NM>();
			this.tipopago_nm= new TipoPago_NM();
			
			this.tipopago_nmObject=new Object();
			this.tipopago_nmsObject=new ArrayList<Object>();
				
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
			
			this.tipopago_nmDataAccess.setConnexionType(this.connexionType);
			this.tipopago_nmDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoPago_NMLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipopago_nmDataAccess = new TipoPago_NMDataAccess();
			this.tipopago_nms= new ArrayList<TipoPago_NM>();
			this.tipopago_nm= new TipoPago_NM();
			this.tipopago_nmObject=new Object();
			this.tipopago_nmsObject=new ArrayList<Object>();
			
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
			
			this.tipopago_nmDataAccess.setConnexionType(this.connexionType);
			this.tipopago_nmDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoPago_NM getTipoPago_NM() throws Exception {	
		TipoPago_NMLogicAdditional.checkTipoPago_NMToGet(tipopago_nm,this.datosCliente,this.arrDatoGeneral);
		TipoPago_NMLogicAdditional.updateTipoPago_NMToGet(tipopago_nm,this.arrDatoGeneral);
		
		return tipopago_nm;
	}
		
	public void setTipoPago_NM(TipoPago_NM newTipoPago_NM) {
		this.tipopago_nm = newTipoPago_NM;
	}
	
	public TipoPago_NMDataAccess getTipoPago_NMDataAccess() {
		return tipopago_nmDataAccess;
	}
	
	public void setTipoPago_NMDataAccess(TipoPago_NMDataAccess newtipopago_nmDataAccess) {
		this.tipopago_nmDataAccess = newtipopago_nmDataAccess;
	}
	
	public List<TipoPago_NM> getTipoPago_NMs() throws Exception {		
		this.quitarTipoPago_NMsNulos();
		
		TipoPago_NMLogicAdditional.checkTipoPago_NMToGets(tipopago_nms,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoPago_NM tipopago_nmLocal: tipopago_nms ) {
			TipoPago_NMLogicAdditional.updateTipoPago_NMToGet(tipopago_nmLocal,this.arrDatoGeneral);
		}
		
		return tipopago_nms;
	}
	
	public void setTipoPago_NMs(List<TipoPago_NM> newTipoPago_NMs) {
		this.tipopago_nms = newTipoPago_NMs;
	}
	
	public Object getTipoPago_NMObject() {	
		this.tipopago_nmObject=this.tipopago_nmDataAccess.getEntityObject();
		return this.tipopago_nmObject;
	}
		
	public void setTipoPago_NMObject(Object newTipoPago_NMObject) {
		this.tipopago_nmObject = newTipoPago_NMObject;
	}
	
	public List<Object> getTipoPago_NMsObject() {		
		this.tipopago_nmsObject=this.tipopago_nmDataAccess.getEntitiesObject();
		return this.tipopago_nmsObject;
	}
		
	public void setTipoPago_NMsObject(List<Object> newTipoPago_NMsObject) {
		this.tipopago_nmsObject = newTipoPago_NMsObject;
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
		
		if(this.tipopago_nmDataAccess!=null) {
			this.tipopago_nmDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPago_NM.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipopago_nmDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipopago_nmDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipopago_nm = new  TipoPago_NM();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPago_NM.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipopago_nm=tipopago_nmDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipopago_nm,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPago_NMConstantesFunciones.refrescarForeignKeysDescripcionesTipoPago_NM(this.tipopago_nm);
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
		tipopago_nm = new  TipoPago_NM();
		  		  
        try {
			
			tipopago_nm=tipopago_nmDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipopago_nm,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPago_NMConstantesFunciones.refrescarForeignKeysDescripcionesTipoPago_NM(this.tipopago_nm);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipopago_nm = new  TipoPago_NM();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPago_NM.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipopago_nm=tipopago_nmDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipopago_nm,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPago_NMConstantesFunciones.refrescarForeignKeysDescripcionesTipoPago_NM(this.tipopago_nm);
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
		tipopago_nm = new  TipoPago_NM();
		  		  
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
		tipopago_nm = new  TipoPago_NM();
		  		  
        try {
			
			tipopago_nm=tipopago_nmDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipopago_nm,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoPago_NMConstantesFunciones.refrescarForeignKeysDescripcionesTipoPago_NM(this.tipopago_nm);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipopago_nm = new  TipoPago_NM();
		  		  
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
		tipopago_nm = new  TipoPago_NM();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPago_NM.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipopago_nmDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipopago_nm = new  TipoPago_NM();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipopago_nmDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipopago_nm = new  TipoPago_NM();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPago_NM.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipopago_nmDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipopago_nm = new  TipoPago_NM();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipopago_nmDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipopago_nm = new  TipoPago_NM();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPago_NM.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipopago_nmDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipopago_nm = new  TipoPago_NM();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipopago_nmDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipopago_nms = new  ArrayList<TipoPago_NM>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPago_NM.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoPago_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipopago_nms=tipopago_nmDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPago_NM(tipopago_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPago_NMConstantesFunciones.refrescarForeignKeysDescripcionesTipoPago_NM(this.tipopago_nms);
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
		tipopago_nms = new  ArrayList<TipoPago_NM>();
		  		  
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
		tipopago_nms = new  ArrayList<TipoPago_NM>();
		  		  
        try {			
			TipoPago_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipopago_nms=tipopago_nmDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoPago_NM(tipopago_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPago_NMConstantesFunciones.refrescarForeignKeysDescripcionesTipoPago_NM(this.tipopago_nms);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipopago_nms = new  ArrayList<TipoPago_NM>();
		  		  
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
		tipopago_nms = new  ArrayList<TipoPago_NM>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPago_NM.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoPago_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipopago_nms=tipopago_nmDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPago_NM(tipopago_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPago_NMConstantesFunciones.refrescarForeignKeysDescripcionesTipoPago_NM(this.tipopago_nms);
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
		tipopago_nms = new  ArrayList<TipoPago_NM>();
		  		  
        try {
			TipoPago_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipopago_nms=tipopago_nmDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPago_NM(tipopago_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPago_NMConstantesFunciones.refrescarForeignKeysDescripcionesTipoPago_NM(this.tipopago_nms);
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
		tipopago_nms = new  ArrayList<TipoPago_NM>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPago_NM.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPago_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipopago_nms=tipopago_nmDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPago_NM(tipopago_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPago_NMConstantesFunciones.refrescarForeignKeysDescripcionesTipoPago_NM(this.tipopago_nms);
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
		tipopago_nms = new  ArrayList<TipoPago_NM>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPago_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipopago_nms=tipopago_nmDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPago_NM(tipopago_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPago_NMConstantesFunciones.refrescarForeignKeysDescripcionesTipoPago_NM(this.tipopago_nms);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipopago_nm = new  TipoPago_NM();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPago_NM.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPago_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipopago_nm=tipopago_nmDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPago_NM(tipopago_nm);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPago_NMConstantesFunciones.refrescarForeignKeysDescripcionesTipoPago_NM(this.tipopago_nm);
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
		tipopago_nm = new  TipoPago_NM();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPago_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipopago_nm=tipopago_nmDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoPago_NM(tipopago_nm);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPago_NMConstantesFunciones.refrescarForeignKeysDescripcionesTipoPago_NM(this.tipopago_nm);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipopago_nms = new  ArrayList<TipoPago_NM>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPago_NM.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoPago_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipopago_nms=tipopago_nmDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPago_NM(tipopago_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPago_NMConstantesFunciones.refrescarForeignKeysDescripcionesTipoPago_NM(this.tipopago_nms);
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
		tipopago_nms = new  ArrayList<TipoPago_NM>();
		  		  
        try {
			TipoPago_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipopago_nms=tipopago_nmDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoPago_NM(tipopago_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPago_NMConstantesFunciones.refrescarForeignKeysDescripcionesTipoPago_NM(this.tipopago_nms);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoPago_NMsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipopago_nms = new  ArrayList<TipoPago_NM>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPago_NM.class.getSimpleName()+"-getTodosTipoPago_NMsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPago_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipopago_nms=tipopago_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoPago_NM(tipopago_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPago_NMConstantesFunciones.refrescarForeignKeysDescripcionesTipoPago_NM(this.tipopago_nms);
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
	
	public  void  getTodosTipoPago_NMs(String sFinalQuery,Pagination pagination)throws Exception {
		tipopago_nms = new  ArrayList<TipoPago_NM>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoPago_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipopago_nms=tipopago_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoPago_NM(tipopago_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoPago_NMConstantesFunciones.refrescarForeignKeysDescripcionesTipoPago_NM(this.tipopago_nms);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoPago_NM(TipoPago_NM tipopago_nm) throws Exception {
		Boolean estaValidado=false;
		
		if(tipopago_nm.getIsNew() || tipopago_nm.getIsChanged()) { 
			this.invalidValues = tipopago_nmValidator.getInvalidValues(tipopago_nm);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipopago_nm);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoPago_NM(List<TipoPago_NM> TipoPago_NMs) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoPago_NM tipopago_nmLocal:tipopago_nms) {				
			estaValidadoObjeto=this.validarGuardarTipoPago_NM(tipopago_nmLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoPago_NM(List<TipoPago_NM> TipoPago_NMs) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoPago_NM(tipopago_nms)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoPago_NM(TipoPago_NM TipoPago_NM) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoPago_NM(tipopago_nm)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoPago_NM tipopago_nm) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipopago_nm.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoPago_NMConstantesFunciones.getTipoPago_NMLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipopago_nm","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoPago_NMConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoPago_NMConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoPago_NMWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPago_NM.class.getSimpleName()+"-saveTipoPago_NMWithConnection");connexion.begin();			
			
			TipoPago_NMLogicAdditional.checkTipoPago_NMToSave(this.tipopago_nm,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoPago_NMLogicAdditional.updateTipoPago_NMToSave(this.tipopago_nm,this.arrDatoGeneral);
			
			TipoPago_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipopago_nm,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoPago_NM();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoPago_NM(this.tipopago_nm)) {
				TipoPago_NMDataAccess.save(this.tipopago_nm, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipopago_nm,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoPago_NMLogicAdditional.checkTipoPago_NMToSaveAfter(this.tipopago_nm,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoPago_NM();
			
			connexion.commit();			
			
			if(this.tipopago_nm.getIsDeleted()) {
				this.tipopago_nm=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoPago_NM()throws Exception {	
		try {	
			
			TipoPago_NMLogicAdditional.checkTipoPago_NMToSave(this.tipopago_nm,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoPago_NMLogicAdditional.updateTipoPago_NMToSave(this.tipopago_nm,this.arrDatoGeneral);
			
			TipoPago_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipopago_nm,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoPago_NM(this.tipopago_nm)) {			
				TipoPago_NMDataAccess.save(this.tipopago_nm, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipopago_nm,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoPago_NMLogicAdditional.checkTipoPago_NMToSaveAfter(this.tipopago_nm,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipopago_nm.getIsDeleted()) {
				this.tipopago_nm=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoPago_NMsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPago_NM.class.getSimpleName()+"-saveTipoPago_NMsWithConnection");connexion.begin();			
			
			TipoPago_NMLogicAdditional.checkTipoPago_NMToSaves(tipopago_nms,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoPago_NMs();
			
			Boolean validadoTodosTipoPago_NM=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoPago_NM tipopago_nmLocal:tipopago_nms) {		
				if(tipopago_nmLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoPago_NMLogicAdditional.updateTipoPago_NMToSave(tipopago_nmLocal,this.arrDatoGeneral);
	        	
				TipoPago_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipopago_nmLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoPago_NM(tipopago_nmLocal)) {
					TipoPago_NMDataAccess.save(tipopago_nmLocal, connexion);				
				} else {
					validadoTodosTipoPago_NM=false;
				}
			}
			
			if(!validadoTodosTipoPago_NM) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoPago_NMLogicAdditional.checkTipoPago_NMToSavesAfter(tipopago_nms,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoPago_NMs();
			
			connexion.commit();		
			
			this.quitarTipoPago_NMsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoPago_NMs()throws Exception {				
		 try {	
			TipoPago_NMLogicAdditional.checkTipoPago_NMToSaves(tipopago_nms,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoPago_NM=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoPago_NM tipopago_nmLocal:tipopago_nms) {				
				if(tipopago_nmLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoPago_NMLogicAdditional.updateTipoPago_NMToSave(tipopago_nmLocal,this.arrDatoGeneral);
	        	
				TipoPago_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipopago_nmLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoPago_NM(tipopago_nmLocal)) {				
					TipoPago_NMDataAccess.save(tipopago_nmLocal, connexion);				
				} else {
					validadoTodosTipoPago_NM=false;
				}
			}
			
			if(!validadoTodosTipoPago_NM) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoPago_NMLogicAdditional.checkTipoPago_NMToSavesAfter(tipopago_nms,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoPago_NMsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoPago_NMParameterReturnGeneral procesarAccionTipoPago_NMs(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoPago_NM> tipopago_nms,TipoPago_NMParameterReturnGeneral tipopago_nmParameterGeneral)throws Exception {
		 try {	
			TipoPago_NMParameterReturnGeneral tipopago_nmReturnGeneral=new TipoPago_NMParameterReturnGeneral();
	
			TipoPago_NMLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipopago_nms,tipopago_nmParameterGeneral,tipopago_nmReturnGeneral);
			
			return tipopago_nmReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoPago_NMParameterReturnGeneral procesarAccionTipoPago_NMsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoPago_NM> tipopago_nms,TipoPago_NMParameterReturnGeneral tipopago_nmParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPago_NM.class.getSimpleName()+"-procesarAccionTipoPago_NMsWithConnection");connexion.begin();			
			
			TipoPago_NMParameterReturnGeneral tipopago_nmReturnGeneral=new TipoPago_NMParameterReturnGeneral();
	
			TipoPago_NMLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipopago_nms,tipopago_nmParameterGeneral,tipopago_nmReturnGeneral);
			
			this.connexion.commit();
			
			return tipopago_nmReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoPago_NMParameterReturnGeneral procesarEventosTipoPago_NMs(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoPago_NM> tipopago_nms,TipoPago_NM tipopago_nm,TipoPago_NMParameterReturnGeneral tipopago_nmParameterGeneral,Boolean isEsNuevoTipoPago_NM,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoPago_NMParameterReturnGeneral tipopago_nmReturnGeneral=new TipoPago_NMParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipopago_nmReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoPago_NMLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipopago_nms,tipopago_nm,tipopago_nmParameterGeneral,tipopago_nmReturnGeneral,isEsNuevoTipoPago_NM,clases);
			
			return tipopago_nmReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoPago_NMParameterReturnGeneral procesarEventosTipoPago_NMsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoPago_NM> tipopago_nms,TipoPago_NM tipopago_nm,TipoPago_NMParameterReturnGeneral tipopago_nmParameterGeneral,Boolean isEsNuevoTipoPago_NM,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPago_NM.class.getSimpleName()+"-procesarEventosTipoPago_NMsWithConnection");connexion.begin();			
			
			TipoPago_NMParameterReturnGeneral tipopago_nmReturnGeneral=new TipoPago_NMParameterReturnGeneral();
	
			tipopago_nmReturnGeneral.setTipoPago_NM(tipopago_nm);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipopago_nmReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoPago_NMLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipopago_nms,tipopago_nm,tipopago_nmParameterGeneral,tipopago_nmReturnGeneral,isEsNuevoTipoPago_NM,clases);
			
			this.connexion.commit();
			
			return tipopago_nmReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoPago_NMParameterReturnGeneral procesarImportacionTipoPago_NMsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoPago_NMParameterReturnGeneral tipopago_nmParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPago_NM.class.getSimpleName()+"-procesarImportacionTipoPago_NMsWithConnection");connexion.begin();			
			
			TipoPago_NMParameterReturnGeneral tipopago_nmReturnGeneral=new TipoPago_NMParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipopago_nms=new ArrayList<TipoPago_NM>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipopago_nm=new TipoPago_NM();
				
				
				if(conColumnasBase) {this.tipopago_nm.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipopago_nm.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipopago_nm.setcodigo(arrColumnas[iColumn++]);
				this.tipopago_nm.setnombre(arrColumnas[iColumn++]);
				
				this.tipopago_nms.add(this.tipopago_nm);
			}
			
			this.saveTipoPago_NMs();
			
			this.connexion.commit();
			
			tipopago_nmReturnGeneral.setConRetornoEstaProcesado(true);
			tipopago_nmReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipopago_nmReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoPago_NMsEliminados() throws Exception {				
		
		List<TipoPago_NM> tipopago_nmsAux= new ArrayList<TipoPago_NM>();
		
		for(TipoPago_NM tipopago_nm:tipopago_nms) {
			if(!tipopago_nm.getIsDeleted()) {
				tipopago_nmsAux.add(tipopago_nm);
			}
		}
		
		tipopago_nms=tipopago_nmsAux;
	}
	
	public void quitarTipoPago_NMsNulos() throws Exception {				
		
		List<TipoPago_NM> tipopago_nmsAux= new ArrayList<TipoPago_NM>();
		
		for(TipoPago_NM tipopago_nm : this.tipopago_nms) {
			if(tipopago_nm==null) {
				tipopago_nmsAux.add(tipopago_nm);
			}
		}
		
		//this.tipopago_nms=tipopago_nmsAux;
		
		this.tipopago_nms.removeAll(tipopago_nmsAux);
	}
	
	public void getSetVersionRowTipoPago_NMWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipopago_nm.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipopago_nm.getIsDeleted() || (tipopago_nm.getIsChanged()&&!tipopago_nm.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipopago_nmDataAccess.getSetVersionRowTipoPago_NM(connexion,tipopago_nm.getId());
				
				if(!tipopago_nm.getVersionRow().equals(timestamp)) {	
					tipopago_nm.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipopago_nm.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoPago_NM()throws Exception {	
		
		if(tipopago_nm.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipopago_nm.getIsDeleted() || (tipopago_nm.getIsChanged()&&!tipopago_nm.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipopago_nmDataAccess.getSetVersionRowTipoPago_NM(connexion,tipopago_nm.getId());
			
			try {							
				if(!tipopago_nm.getVersionRow().equals(timestamp)) {	
					tipopago_nm.setVersionRow(timestamp);
				}
				
				tipopago_nm.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoPago_NMsWithConnection()throws Exception {	
		if(tipopago_nms!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoPago_NM tipopago_nmAux:tipopago_nms) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipopago_nmAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipopago_nmAux.getIsDeleted() || (tipopago_nmAux.getIsChanged()&&!tipopago_nmAux.getIsNew())) {
						
						timestamp=tipopago_nmDataAccess.getSetVersionRowTipoPago_NM(connexion,tipopago_nmAux.getId());
						
						if(!tipopago_nm.getVersionRow().equals(timestamp)) {	
							tipopago_nmAux.setVersionRow(timestamp);
						}
								
						tipopago_nmAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoPago_NMs()throws Exception {	
		if(tipopago_nms!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoPago_NM tipopago_nmAux:tipopago_nms) {
					if(tipopago_nmAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipopago_nmAux.getIsDeleted() || (tipopago_nmAux.getIsChanged()&&!tipopago_nmAux.getIsNew())) {
						
						timestamp=tipopago_nmDataAccess.getSetVersionRowTipoPago_NM(connexion,tipopago_nmAux.getId());
						
						if(!tipopago_nmAux.getVersionRow().equals(timestamp)) {	
							tipopago_nmAux.setVersionRow(timestamp);
						}
						
													
						tipopago_nmAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoPago_NMParameterReturnGeneral cargarCombosLoteForeignKeyTipoPago_NMWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoPago_NMParameterReturnGeneral  tipopago_nmReturnGeneral =new TipoPago_NMParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPago_NM.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoPago_NMWithConnection");connexion.begin();
			
			tipopago_nmReturnGeneral =new TipoPago_NMParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipopago_nmReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipopago_nmReturnGeneral;
	}
	
	public TipoPago_NMParameterReturnGeneral cargarCombosLoteForeignKeyTipoPago_NM(String finalQueryGlobalEmpresa) throws Exception {
		TipoPago_NMParameterReturnGeneral  tipopago_nmReturnGeneral =new TipoPago_NMParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipopago_nmReturnGeneral =new TipoPago_NMParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipopago_nmReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipopago_nmReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoPago_NMWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			CargoLogic cargoLogic=new CargoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPago_NM.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoPago_NMWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Estructura.class));
			classes.add(new Classe(Cargo.class));
											
			

			estructuraLogic.setConnexion(this.getConnexion());
			estructuraLogic.setDatosCliente(this.datosCliente);
			estructuraLogic.setIsConRefrescarForeignKeys(true);

			cargoLogic.setConnexion(this.getConnexion());
			cargoLogic.setDatosCliente(this.datosCliente);
			cargoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoPago_NM tipopago_nm:this.tipopago_nms) {
				

				classes=new ArrayList<Classe>();
				classes=EstructuraConstantesFunciones.getClassesForeignKeysOfEstructura(new ArrayList<Classe>(),DeepLoadType.NONE);

				estructuraLogic.setEstructuras(tipopago_nm.estructuras);
				estructuraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CargoConstantesFunciones.getClassesForeignKeysOfCargo(new ArrayList<Classe>(),DeepLoadType.NONE);

				cargoLogic.setCargos(tipopago_nm.cargos);
				cargoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoPago_NM tipopago_nm,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoPago_NMLogicAdditional.updateTipoPago_NMToGet(tipopago_nm,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipopago_nm.setEmpresa(tipopago_nmDataAccess.getEmpresa(connexion,tipopago_nm));
		tipopago_nm.setEstructuras(tipopago_nmDataAccess.getEstructuras(connexion,tipopago_nm));
		tipopago_nm.setCargos(tipopago_nmDataAccess.getCargos(connexion,tipopago_nm));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipopago_nm.setEmpresa(tipopago_nmDataAccess.getEmpresa(connexion,tipopago_nm));
				continue;
			}

			if(clas.clas.equals(Estructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipopago_nm.setEstructuras(tipopago_nmDataAccess.getEstructuras(connexion,tipopago_nm));

				if(this.isConDeep) {
					EstructuraLogic estructuraLogic= new EstructuraLogic(this.connexion);
					estructuraLogic.setEstructuras(tipopago_nm.getEstructuras());
					ArrayList<Classe> classesLocal=EstructuraConstantesFunciones.getClassesForeignKeysOfEstructura(new ArrayList<Classe>(),DeepLoadType.NONE);
					estructuraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EstructuraConstantesFunciones.refrescarForeignKeysDescripcionesEstructura(estructuraLogic.getEstructuras());
					tipopago_nm.setEstructuras(estructuraLogic.getEstructuras());
				}

				continue;
			}

			if(clas.clas.equals(Cargo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipopago_nm.setCargos(tipopago_nmDataAccess.getCargos(connexion,tipopago_nm));

				if(this.isConDeep) {
					CargoLogic cargoLogic= new CargoLogic(this.connexion);
					cargoLogic.setCargos(tipopago_nm.getCargos());
					ArrayList<Classe> classesLocal=CargoConstantesFunciones.getClassesForeignKeysOfCargo(new ArrayList<Classe>(),DeepLoadType.NONE);
					cargoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CargoConstantesFunciones.refrescarForeignKeysDescripcionesCargo(cargoLogic.getCargos());
					tipopago_nm.setCargos(cargoLogic.getCargos());
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
			tipopago_nm.setEmpresa(tipopago_nmDataAccess.getEmpresa(connexion,tipopago_nm));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Estructura.class));
			tipopago_nm.setEstructuras(tipopago_nmDataAccess.getEstructuras(connexion,tipopago_nm));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cargo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cargo.class));
			tipopago_nm.setCargos(tipopago_nmDataAccess.getCargos(connexion,tipopago_nm));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipopago_nm.setEmpresa(tipopago_nmDataAccess.getEmpresa(connexion,tipopago_nm));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipopago_nm.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipopago_nm.setEstructuras(tipopago_nmDataAccess.getEstructuras(connexion,tipopago_nm));

		for(Estructura estructura:tipopago_nm.getEstructuras()) {
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(estructura,isDeep,deepLoadType,clases);
		}

		tipopago_nm.setCargos(tipopago_nmDataAccess.getCargos(connexion,tipopago_nm));

		for(Cargo cargo:tipopago_nm.getCargos()) {
			CargoLogic cargoLogic= new CargoLogic(connexion);
			cargoLogic.deepLoad(cargo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipopago_nm.setEmpresa(tipopago_nmDataAccess.getEmpresa(connexion,tipopago_nm));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipopago_nm.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipopago_nm.setEstructuras(tipopago_nmDataAccess.getEstructuras(connexion,tipopago_nm));

				for(Estructura estructura:tipopago_nm.getEstructuras()) {
					EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
					estructuraLogic.deepLoad(estructura,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cargo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipopago_nm.setCargos(tipopago_nmDataAccess.getCargos(connexion,tipopago_nm));

				for(Cargo cargo:tipopago_nm.getCargos()) {
					CargoLogic cargoLogic= new CargoLogic(connexion);
					cargoLogic.deepLoad(cargo,isDeep,deepLoadType,clases);
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
			tipopago_nm.setEmpresa(tipopago_nmDataAccess.getEmpresa(connexion,tipopago_nm));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipopago_nm.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Estructura.class));
			tipopago_nm.setEstructuras(tipopago_nmDataAccess.getEstructuras(connexion,tipopago_nm));

			for(Estructura estructura:tipopago_nm.getEstructuras()) {
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(estructura,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cargo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cargo.class));
			tipopago_nm.setCargos(tipopago_nmDataAccess.getCargos(connexion,tipopago_nm));

			for(Cargo cargo:tipopago_nm.getCargos()) {
				CargoLogic cargoLogic= new CargoLogic(connexion);
				cargoLogic.deepLoad(cargo,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoPago_NM tipopago_nm,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoPago_NMLogicAdditional.updateTipoPago_NMToSave(tipopago_nm,this.arrDatoGeneral);
			
TipoPago_NMDataAccess.save(tipopago_nm, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipopago_nm.getEmpresa(),connexion);

		for(Estructura estructura:tipopago_nm.getEstructuras()) {
			estructura.setid_tipo_pago__n_m(tipopago_nm.getId());
			EstructuraDataAccess.save(estructura,connexion);
		}

		for(Cargo cargo:tipopago_nm.getCargos()) {
			cargo.setid_tipo_pago__n_m(tipopago_nm.getId());
			CargoDataAccess.save(cargo,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipopago_nm.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(Estructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Estructura estructura:tipopago_nm.getEstructuras()) {
					estructura.setid_tipo_pago__n_m(tipopago_nm.getId());
					EstructuraDataAccess.save(estructura,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Cargo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cargo cargo:tipopago_nm.getCargos()) {
					cargo.setid_tipo_pago__n_m(tipopago_nm.getId());
					CargoDataAccess.save(cargo,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipopago_nm.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipopago_nm.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(Estructura estructura:tipopago_nm.getEstructuras()) {
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructura.setid_tipo_pago__n_m(tipopago_nm.getId());
			EstructuraDataAccess.save(estructura,connexion);
			estructuraLogic.deepSave(estructura,isDeep,deepLoadType,clases);
		}

		for(Cargo cargo:tipopago_nm.getCargos()) {
			CargoLogic cargoLogic= new CargoLogic(connexion);
			cargo.setid_tipo_pago__n_m(tipopago_nm.getId());
			CargoDataAccess.save(cargo,connexion);
			cargoLogic.deepSave(cargo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipopago_nm.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipopago_nm.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Estructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Estructura estructura:tipopago_nm.getEstructuras()) {
					EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
					estructura.setid_tipo_pago__n_m(tipopago_nm.getId());
					EstructuraDataAccess.save(estructura,connexion);
					estructuraLogic.deepSave(estructura,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cargo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cargo cargo:tipopago_nm.getCargos()) {
					CargoLogic cargoLogic= new CargoLogic(connexion);
					cargo.setid_tipo_pago__n_m(tipopago_nm.getId());
					CargoDataAccess.save(cargo,connexion);
					cargoLogic.deepSave(cargo,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoPago_NM.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipopago_nm,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoPago_NMConstantesFunciones.refrescarForeignKeysDescripcionesTipoPago_NM(tipopago_nm);
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
			this.deepLoad(this.tipopago_nm,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoPago_NMConstantesFunciones.refrescarForeignKeysDescripcionesTipoPago_NM(this.tipopago_nm);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoPago_NM.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipopago_nms!=null) {
				for(TipoPago_NM tipopago_nm:tipopago_nms) {
					this.deepLoad(tipopago_nm,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoPago_NMConstantesFunciones.refrescarForeignKeysDescripcionesTipoPago_NM(tipopago_nms);
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
			if(tipopago_nms!=null) {
				for(TipoPago_NM tipopago_nm:tipopago_nms) {
					this.deepLoad(tipopago_nm,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoPago_NMConstantesFunciones.refrescarForeignKeysDescripcionesTipoPago_NM(tipopago_nms);
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
			this.getNewConnexionToDeep(TipoPago_NM.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipopago_nm,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoPago_NM.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipopago_nms!=null) {
				for(TipoPago_NM tipopago_nm:tipopago_nms) {
					this.deepSave(tipopago_nm,isDeep,deepLoadType,clases);
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
			if(tipopago_nms!=null) {
				for(TipoPago_NM tipopago_nm:tipopago_nms) {
					this.deepSave(tipopago_nm,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoPago_NMsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoPago_NM.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoPago_NMConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoPago_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipopago_nms=tipopago_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPago_NMConstantesFunciones.refrescarForeignKeysDescripcionesTipoPago_NM(this.tipopago_nms);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoPago_NMsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoPago_NMConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoPago_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipopago_nms=tipopago_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoPago_NMConstantesFunciones.refrescarForeignKeysDescripcionesTipoPago_NM(this.tipopago_nms);
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
			if(TipoPago_NMConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPago_NMDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoPago_NM tipopago_nm,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoPago_NMConstantesFunciones.ISCONAUDITORIA) {
				if(tipopago_nm.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPago_NMDataAccess.TABLENAME, tipopago_nm.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoPago_NMConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoPago_NMLogic.registrarAuditoriaDetallesTipoPago_NM(connexion,tipopago_nm,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipopago_nm.getIsDeleted()) {
					/*if(!tipopago_nm.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoPago_NMDataAccess.TABLENAME, tipopago_nm.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoPago_NMLogic.registrarAuditoriaDetallesTipoPago_NM(connexion,tipopago_nm,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPago_NMDataAccess.TABLENAME, tipopago_nm.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipopago_nm.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoPago_NMDataAccess.TABLENAME, tipopago_nm.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoPago_NMConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoPago_NMLogic.registrarAuditoriaDetallesTipoPago_NM(connexion,tipopago_nm,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoPago_NM(Connexion connexion,TipoPago_NM tipopago_nm)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipopago_nm.getIsNew()||!tipopago_nm.getid_empresa().equals(tipopago_nm.getTipoPago_NMOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipopago_nm.getTipoPago_NMOriginal().getid_empresa()!=null)
				{
					strValorActual=tipopago_nm.getTipoPago_NMOriginal().getid_empresa().toString();
				}
				if(tipopago_nm.getid_empresa()!=null)
				{
					strValorNuevo=tipopago_nm.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPago_NMConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipopago_nm.getIsNew()||!tipopago_nm.getcodigo().equals(tipopago_nm.getTipoPago_NMOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipopago_nm.getTipoPago_NMOriginal().getcodigo()!=null)
				{
					strValorActual=tipopago_nm.getTipoPago_NMOriginal().getcodigo();
				}
				if(tipopago_nm.getcodigo()!=null)
				{
					strValorNuevo=tipopago_nm.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPago_NMConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipopago_nm.getIsNew()||!tipopago_nm.getnombre().equals(tipopago_nm.getTipoPago_NMOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipopago_nm.getTipoPago_NMOriginal().getnombre()!=null)
				{
					strValorActual=tipopago_nm.getTipoPago_NMOriginal().getnombre();
				}
				if(tipopago_nm.getnombre()!=null)
				{
					strValorNuevo=tipopago_nm.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoPago_NMConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoPago_NMRelacionesWithConnection(TipoPago_NM tipopago_nm,List<Estructura> estructuras,List<Cargo> cargos) throws Exception {

		if(!tipopago_nm.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoPago_NMRelacionesBase(tipopago_nm,estructuras,cargos,true);
		}
	}

	public void saveTipoPago_NMRelaciones(TipoPago_NM tipopago_nm,List<Estructura> estructuras,List<Cargo> cargos)throws Exception {

		if(!tipopago_nm.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoPago_NMRelacionesBase(tipopago_nm,estructuras,cargos,false);
		}
	}

	public void saveTipoPago_NMRelacionesBase(TipoPago_NM tipopago_nm,List<Estructura> estructuras,List<Cargo> cargos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoPago_NM-saveRelacionesWithConnection");}
	
			tipopago_nm.setEstructuras(estructuras);
			tipopago_nm.setCargos(cargos);

			this.setTipoPago_NM(tipopago_nm);

			if(TipoPago_NMLogicAdditional.validarSaveRelaciones(tipopago_nm,this)) {

				TipoPago_NMLogicAdditional.updateRelacionesToSave(tipopago_nm,this);

				if((tipopago_nm.getIsNew()||tipopago_nm.getIsChanged())&&!tipopago_nm.getIsDeleted()) {
					this.saveTipoPago_NM();
					this.saveTipoPago_NMRelacionesDetalles(estructuras,cargos);

				} else if(tipopago_nm.getIsDeleted()) {
					this.saveTipoPago_NMRelacionesDetalles(estructuras,cargos);
					this.saveTipoPago_NM();
				}

				TipoPago_NMLogicAdditional.updateRelacionesToSaveAfter(tipopago_nm,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			EstructuraConstantesFunciones.InicializarGeneralEntityAuxiliaresEstructuras(estructuras,true,true);
			CargoConstantesFunciones.InicializarGeneralEntityAuxiliaresCargos(cargos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoPago_NMRelacionesDetalles(List<Estructura> estructuras,List<Cargo> cargos)throws Exception {
		try {
	

			Long idTipoPago_NMActual=this.getTipoPago_NM().getId();

			EstructuraLogic estructuraLogic_Desde_TipoPago_NM=new EstructuraLogic();
			estructuraLogic_Desde_TipoPago_NM.setEstructuras(estructuras);

			estructuraLogic_Desde_TipoPago_NM.setConnexion(this.getConnexion());
			estructuraLogic_Desde_TipoPago_NM.setDatosCliente(this.datosCliente);

			for(Estructura estructura_Desde_TipoPago_NM:estructuraLogic_Desde_TipoPago_NM.getEstructuras()) {
				estructura_Desde_TipoPago_NM.setid_tipo_pago__n_m(idTipoPago_NMActual);

				estructuraLogic_Desde_TipoPago_NM.setEstructura(estructura_Desde_TipoPago_NM);
				estructuraLogic_Desde_TipoPago_NM.saveEstructura();
			}


			CargoLogic cargoLogic_Desde_TipoPago_NM=new CargoLogic();
			cargoLogic_Desde_TipoPago_NM.setCargos(cargos);

			cargoLogic_Desde_TipoPago_NM.setConnexion(this.getConnexion());
			cargoLogic_Desde_TipoPago_NM.setDatosCliente(this.datosCliente);

			for(Cargo cargo_Desde_TipoPago_NM:cargoLogic_Desde_TipoPago_NM.getCargos()) {
				cargo_Desde_TipoPago_NM.setid_tipo_pago__n_m(idTipoPago_NMActual);

				cargoLogic_Desde_TipoPago_NM.setCargo(cargo_Desde_TipoPago_NM);
				cargoLogic_Desde_TipoPago_NM.saveCargo();

				Long idCargoActual=cargo_Desde_TipoPago_NM.getId();

				AsistenciaMensualLogic asistenciamensualLogic_Desde_Cargo=new AsistenciaMensualLogic();

				if(cargo_Desde_TipoPago_NM.getAsistenciaMensuals()==null){
					cargo_Desde_TipoPago_NM.setAsistenciaMensuals(new ArrayList<AsistenciaMensual>());
				}

				asistenciamensualLogic_Desde_Cargo.setAsistenciaMensuals(cargo_Desde_TipoPago_NM.getAsistenciaMensuals());

				asistenciamensualLogic_Desde_Cargo.setConnexion(this.getConnexion());
				asistenciamensualLogic_Desde_Cargo.setDatosCliente(this.datosCliente);

				for(AsistenciaMensual asistenciamensual_Desde_Cargo:asistenciamensualLogic_Desde_Cargo.getAsistenciaMensuals()) {
					asistenciamensual_Desde_Cargo.setid_cargo(idCargoActual);
				}

				asistenciamensualLogic_Desde_Cargo.saveAsistenciaMensuals();

				EmpleadoEstructuraLogic empleadoestructuraLogic_Desde_Cargo=new EmpleadoEstructuraLogic();

				if(cargo_Desde_TipoPago_NM.getEmpleadoEstructuras()==null){
					cargo_Desde_TipoPago_NM.setEmpleadoEstructuras(new ArrayList<EmpleadoEstructura>());
				}

				empleadoestructuraLogic_Desde_Cargo.setEmpleadoEstructuras(cargo_Desde_TipoPago_NM.getEmpleadoEstructuras());

				empleadoestructuraLogic_Desde_Cargo.setConnexion(this.getConnexion());
				empleadoestructuraLogic_Desde_Cargo.setDatosCliente(this.datosCliente);

				for(EmpleadoEstructura empleadoestructura_Desde_Cargo:empleadoestructuraLogic_Desde_Cargo.getEmpleadoEstructuras()) {
					empleadoestructura_Desde_Cargo.setid_cargo(idCargoActual);
				}

				empleadoestructuraLogic_Desde_Cargo.saveEmpleadoEstructuras();

				EmpleadoLogic empleadoLogic_Desde_Cargo=new EmpleadoLogic();

				if(cargo_Desde_TipoPago_NM.getEmpleados()==null){
					cargo_Desde_TipoPago_NM.setEmpleados(new ArrayList<Empleado>());
				}

				empleadoLogic_Desde_Cargo.setEmpleados(cargo_Desde_TipoPago_NM.getEmpleados());

				empleadoLogic_Desde_Cargo.setConnexion(this.getConnexion());
				empleadoLogic_Desde_Cargo.setDatosCliente(this.datosCliente);

				for(Empleado empleado_Desde_Cargo:empleadoLogic_Desde_Cargo.getEmpleados()) {
					empleado_Desde_Cargo.setid_cargo(idCargoActual);

					empleadoLogic_Desde_Cargo.setEmpleado(empleado_Desde_Cargo);
					empleadoLogic_Desde_Cargo.saveEmpleado();
				}


				CargoLogic cargoLogicHijos_Desde_Cargo=new CargoLogic();

				if(cargo_Desde_TipoPago_NM.getCargos()==null){
					cargo_Desde_TipoPago_NM.setCargos(new ArrayList<Cargo>());
				}

				cargoLogicHijos_Desde_Cargo.setCargos(cargo_Desde_TipoPago_NM.getCargos());

				cargoLogicHijos_Desde_Cargo.setConnexion(this.getConnexion());
				cargoLogicHijos_Desde_Cargo.setDatosCliente(this.datosCliente);

				for(Cargo cargoHijos_Desde_Cargo:cargoLogicHijos_Desde_Cargo.getCargos()) {
					cargoHijos_Desde_Cargo.setid_cargo(idCargoActual);

					cargoLogicHijos_Desde_Cargo.setCargo(cargoHijos_Desde_Cargo);
					cargoLogicHijos_Desde_Cargo.saveCargo();
				}

			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoPago_NM(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoPago_NMConstantesFunciones.getClassesForeignKeysOfTipoPago_NM(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoPago_NM(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoPago_NMConstantesFunciones.getClassesRelationshipsOfTipoPago_NM(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
package com.bydan.erp.activosfijos.business.logic;

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
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.activosfijos.util.CuentaContaDetaGrupoActiConstantesFunciones;
import com.bydan.erp.activosfijos.util.CuentaContaDetaGrupoActiParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.CuentaContaDetaGrupoActiParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.CuentaContaDetaGrupoActi;
import com.bydan.erp.activosfijos.business.logic.CuentaContaDetaGrupoActiLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class CuentaContaDetaGrupoActiLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CuentaContaDetaGrupoActiLogic.class);
	
	protected CuentaContaDetaGrupoActiDataAccess cuentacontadetagrupoactiDataAccess; 	
	protected CuentaContaDetaGrupoActi cuentacontadetagrupoacti;
	protected List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis;
	protected Object cuentacontadetagrupoactiObject;	
	protected List<Object> cuentacontadetagrupoactisObject;
	
	public static ClassValidator<CuentaContaDetaGrupoActi> cuentacontadetagrupoactiValidator = new ClassValidator<CuentaContaDetaGrupoActi>(CuentaContaDetaGrupoActi.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CuentaContaDetaGrupoActiLogicAdditional cuentacontadetagrupoactiLogicAdditional=null;
	
	public CuentaContaDetaGrupoActiLogicAdditional getCuentaContaDetaGrupoActiLogicAdditional() {
		return this.cuentacontadetagrupoactiLogicAdditional;
	}
	
	public void setCuentaContaDetaGrupoActiLogicAdditional(CuentaContaDetaGrupoActiLogicAdditional cuentacontadetagrupoactiLogicAdditional) {
		try {
			this.cuentacontadetagrupoactiLogicAdditional=cuentacontadetagrupoactiLogicAdditional;
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
	
	
	
	
	public  CuentaContaDetaGrupoActiLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cuentacontadetagrupoactiDataAccess = new CuentaContaDetaGrupoActiDataAccess();
			
			this.cuentacontadetagrupoactis= new ArrayList<CuentaContaDetaGrupoActi>();
			this.cuentacontadetagrupoacti= new CuentaContaDetaGrupoActi();
			
			this.cuentacontadetagrupoactiObject=new Object();
			this.cuentacontadetagrupoactisObject=new ArrayList<Object>();
				
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
			
			this.cuentacontadetagrupoactiDataAccess.setConnexionType(this.connexionType);
			this.cuentacontadetagrupoactiDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CuentaContaDetaGrupoActiLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cuentacontadetagrupoactiDataAccess = new CuentaContaDetaGrupoActiDataAccess();
			this.cuentacontadetagrupoactis= new ArrayList<CuentaContaDetaGrupoActi>();
			this.cuentacontadetagrupoacti= new CuentaContaDetaGrupoActi();
			this.cuentacontadetagrupoactiObject=new Object();
			this.cuentacontadetagrupoactisObject=new ArrayList<Object>();
			
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
			
			this.cuentacontadetagrupoactiDataAccess.setConnexionType(this.connexionType);
			this.cuentacontadetagrupoactiDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CuentaContaDetaGrupoActi getCuentaContaDetaGrupoActi() throws Exception {	
		CuentaContaDetaGrupoActiLogicAdditional.checkCuentaContaDetaGrupoActiToGet(cuentacontadetagrupoacti,this.datosCliente,this.arrDatoGeneral);
		CuentaContaDetaGrupoActiLogicAdditional.updateCuentaContaDetaGrupoActiToGet(cuentacontadetagrupoacti,this.arrDatoGeneral);
		
		return cuentacontadetagrupoacti;
	}
		
	public void setCuentaContaDetaGrupoActi(CuentaContaDetaGrupoActi newCuentaContaDetaGrupoActi) {
		this.cuentacontadetagrupoacti = newCuentaContaDetaGrupoActi;
	}
	
	public CuentaContaDetaGrupoActiDataAccess getCuentaContaDetaGrupoActiDataAccess() {
		return cuentacontadetagrupoactiDataAccess;
	}
	
	public void setCuentaContaDetaGrupoActiDataAccess(CuentaContaDetaGrupoActiDataAccess newcuentacontadetagrupoactiDataAccess) {
		this.cuentacontadetagrupoactiDataAccess = newcuentacontadetagrupoactiDataAccess;
	}
	
	public List<CuentaContaDetaGrupoActi> getCuentaContaDetaGrupoActis() throws Exception {		
		this.quitarCuentaContaDetaGrupoActisNulos();
		
		CuentaContaDetaGrupoActiLogicAdditional.checkCuentaContaDetaGrupoActiToGets(cuentacontadetagrupoactis,this.datosCliente,this.arrDatoGeneral);
		
		for (CuentaContaDetaGrupoActi cuentacontadetagrupoactiLocal: cuentacontadetagrupoactis ) {
			CuentaContaDetaGrupoActiLogicAdditional.updateCuentaContaDetaGrupoActiToGet(cuentacontadetagrupoactiLocal,this.arrDatoGeneral);
		}
		
		return cuentacontadetagrupoactis;
	}
	
	public void setCuentaContaDetaGrupoActis(List<CuentaContaDetaGrupoActi> newCuentaContaDetaGrupoActis) {
		this.cuentacontadetagrupoactis = newCuentaContaDetaGrupoActis;
	}
	
	public Object getCuentaContaDetaGrupoActiObject() {	
		this.cuentacontadetagrupoactiObject=this.cuentacontadetagrupoactiDataAccess.getEntityObject();
		return this.cuentacontadetagrupoactiObject;
	}
		
	public void setCuentaContaDetaGrupoActiObject(Object newCuentaContaDetaGrupoActiObject) {
		this.cuentacontadetagrupoactiObject = newCuentaContaDetaGrupoActiObject;
	}
	
	public List<Object> getCuentaContaDetaGrupoActisObject() {		
		this.cuentacontadetagrupoactisObject=this.cuentacontadetagrupoactiDataAccess.getEntitiesObject();
		return this.cuentacontadetagrupoactisObject;
	}
		
	public void setCuentaContaDetaGrupoActisObject(List<Object> newCuentaContaDetaGrupoActisObject) {
		this.cuentacontadetagrupoactisObject = newCuentaContaDetaGrupoActisObject;
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
		
		if(this.cuentacontadetagrupoactiDataAccess!=null) {
			this.cuentacontadetagrupoactiDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaDetaGrupoActi.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cuentacontadetagrupoactiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cuentacontadetagrupoactiDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cuentacontadetagrupoacti = new  CuentaContaDetaGrupoActi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaDetaGrupoActi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cuentacontadetagrupoacti=cuentacontadetagrupoactiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentacontadetagrupoacti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(this.cuentacontadetagrupoacti);
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
		cuentacontadetagrupoacti = new  CuentaContaDetaGrupoActi();
		  		  
        try {
			
			cuentacontadetagrupoacti=cuentacontadetagrupoactiDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentacontadetagrupoacti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(this.cuentacontadetagrupoacti);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cuentacontadetagrupoacti = new  CuentaContaDetaGrupoActi();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaDetaGrupoActi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cuentacontadetagrupoacti=cuentacontadetagrupoactiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentacontadetagrupoacti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(this.cuentacontadetagrupoacti);
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
		cuentacontadetagrupoacti = new  CuentaContaDetaGrupoActi();
		  		  
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
		cuentacontadetagrupoacti = new  CuentaContaDetaGrupoActi();
		  		  
        try {
			
			cuentacontadetagrupoacti=cuentacontadetagrupoactiDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentacontadetagrupoacti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(this.cuentacontadetagrupoacti);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cuentacontadetagrupoacti = new  CuentaContaDetaGrupoActi();
		  		  
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
		cuentacontadetagrupoacti = new  CuentaContaDetaGrupoActi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaDetaGrupoActi.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cuentacontadetagrupoactiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentacontadetagrupoacti = new  CuentaContaDetaGrupoActi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cuentacontadetagrupoactiDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cuentacontadetagrupoacti = new  CuentaContaDetaGrupoActi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaDetaGrupoActi.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cuentacontadetagrupoactiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentacontadetagrupoacti = new  CuentaContaDetaGrupoActi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cuentacontadetagrupoactiDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cuentacontadetagrupoacti = new  CuentaContaDetaGrupoActi();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaDetaGrupoActi.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cuentacontadetagrupoactiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentacontadetagrupoacti = new  CuentaContaDetaGrupoActi();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cuentacontadetagrupoactiDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cuentacontadetagrupoactis = new  ArrayList<CuentaContaDetaGrupoActi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaDetaGrupoActi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CuentaContaDetaGrupoActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontadetagrupoactis=cuentacontadetagrupoactiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaContaDetaGrupoActi(cuentacontadetagrupoactis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(this.cuentacontadetagrupoactis);
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
		cuentacontadetagrupoactis = new  ArrayList<CuentaContaDetaGrupoActi>();
		  		  
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
		cuentacontadetagrupoactis = new  ArrayList<CuentaContaDetaGrupoActi>();
		  		  
        try {			
			CuentaContaDetaGrupoActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontadetagrupoactis=cuentacontadetagrupoactiDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCuentaContaDetaGrupoActi(cuentacontadetagrupoactis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(this.cuentacontadetagrupoactis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cuentacontadetagrupoactis = new  ArrayList<CuentaContaDetaGrupoActi>();
		  		  
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
		cuentacontadetagrupoactis = new  ArrayList<CuentaContaDetaGrupoActi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaDetaGrupoActi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CuentaContaDetaGrupoActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontadetagrupoactis=cuentacontadetagrupoactiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaContaDetaGrupoActi(cuentacontadetagrupoactis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(this.cuentacontadetagrupoactis);
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
		cuentacontadetagrupoactis = new  ArrayList<CuentaContaDetaGrupoActi>();
		  		  
        try {
			CuentaContaDetaGrupoActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontadetagrupoactis=cuentacontadetagrupoactiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaContaDetaGrupoActi(cuentacontadetagrupoactis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(this.cuentacontadetagrupoactis);
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
		cuentacontadetagrupoactis = new  ArrayList<CuentaContaDetaGrupoActi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaDetaGrupoActi.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContaDetaGrupoActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontadetagrupoactis=cuentacontadetagrupoactiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaContaDetaGrupoActi(cuentacontadetagrupoactis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(this.cuentacontadetagrupoactis);
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
		cuentacontadetagrupoactis = new  ArrayList<CuentaContaDetaGrupoActi>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContaDetaGrupoActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontadetagrupoactis=cuentacontadetagrupoactiDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaContaDetaGrupoActi(cuentacontadetagrupoactis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(this.cuentacontadetagrupoactis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cuentacontadetagrupoacti = new  CuentaContaDetaGrupoActi();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaDetaGrupoActi.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContaDetaGrupoActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontadetagrupoacti=cuentacontadetagrupoactiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaContaDetaGrupoActi(cuentacontadetagrupoacti);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(this.cuentacontadetagrupoacti);
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
		cuentacontadetagrupoacti = new  CuentaContaDetaGrupoActi();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContaDetaGrupoActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontadetagrupoacti=cuentacontadetagrupoactiDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaContaDetaGrupoActi(cuentacontadetagrupoacti);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(this.cuentacontadetagrupoacti);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cuentacontadetagrupoactis = new  ArrayList<CuentaContaDetaGrupoActi>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaDetaGrupoActi.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CuentaContaDetaGrupoActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontadetagrupoactis=cuentacontadetagrupoactiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaContaDetaGrupoActi(cuentacontadetagrupoactis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(this.cuentacontadetagrupoactis);
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
		cuentacontadetagrupoactis = new  ArrayList<CuentaContaDetaGrupoActi>();
		  		  
        try {
			CuentaContaDetaGrupoActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontadetagrupoactis=cuentacontadetagrupoactiDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaContaDetaGrupoActi(cuentacontadetagrupoactis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(this.cuentacontadetagrupoactis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCuentaContaDetaGrupoActisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cuentacontadetagrupoactis = new  ArrayList<CuentaContaDetaGrupoActi>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaDetaGrupoActi.class.getSimpleName()+"-getTodosCuentaContaDetaGrupoActisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContaDetaGrupoActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontadetagrupoactis=cuentacontadetagrupoactiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCuentaContaDetaGrupoActi(cuentacontadetagrupoactis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(this.cuentacontadetagrupoactis);
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
	
	public  void  getTodosCuentaContaDetaGrupoActis(String sFinalQuery,Pagination pagination)throws Exception {
		cuentacontadetagrupoactis = new  ArrayList<CuentaContaDetaGrupoActi>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContaDetaGrupoActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontadetagrupoactis=cuentacontadetagrupoactiDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCuentaContaDetaGrupoActi(cuentacontadetagrupoactis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(this.cuentacontadetagrupoactis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCuentaContaDetaGrupoActi(CuentaContaDetaGrupoActi cuentacontadetagrupoacti) throws Exception {
		Boolean estaValidado=false;
		
		if(cuentacontadetagrupoacti.getIsNew() || cuentacontadetagrupoacti.getIsChanged()) { 
			this.invalidValues = cuentacontadetagrupoactiValidator.getInvalidValues(cuentacontadetagrupoacti);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cuentacontadetagrupoacti);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCuentaContaDetaGrupoActi(List<CuentaContaDetaGrupoActi> CuentaContaDetaGrupoActis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CuentaContaDetaGrupoActi cuentacontadetagrupoactiLocal:cuentacontadetagrupoactis) {				
			estaValidadoObjeto=this.validarGuardarCuentaContaDetaGrupoActi(cuentacontadetagrupoactiLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCuentaContaDetaGrupoActi(List<CuentaContaDetaGrupoActi> CuentaContaDetaGrupoActis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCuentaContaDetaGrupoActi(cuentacontadetagrupoactis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCuentaContaDetaGrupoActi(CuentaContaDetaGrupoActi CuentaContaDetaGrupoActi) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCuentaContaDetaGrupoActi(cuentacontadetagrupoacti)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CuentaContaDetaGrupoActi cuentacontadetagrupoacti) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cuentacontadetagrupoacti.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CuentaContaDetaGrupoActiConstantesFunciones.getCuentaContaDetaGrupoActiLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cuentacontadetagrupoacti","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CuentaContaDetaGrupoActiConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CuentaContaDetaGrupoActiConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCuentaContaDetaGrupoActiWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaDetaGrupoActi.class.getSimpleName()+"-saveCuentaContaDetaGrupoActiWithConnection");connexion.begin();			
			
			CuentaContaDetaGrupoActiLogicAdditional.checkCuentaContaDetaGrupoActiToSave(this.cuentacontadetagrupoacti,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CuentaContaDetaGrupoActiLogicAdditional.updateCuentaContaDetaGrupoActiToSave(this.cuentacontadetagrupoacti,this.arrDatoGeneral);
			
			CuentaContaDetaGrupoActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cuentacontadetagrupoacti,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCuentaContaDetaGrupoActi();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCuentaContaDetaGrupoActi(this.cuentacontadetagrupoacti)) {
				CuentaContaDetaGrupoActiDataAccess.save(this.cuentacontadetagrupoacti, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cuentacontadetagrupoacti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CuentaContaDetaGrupoActiLogicAdditional.checkCuentaContaDetaGrupoActiToSaveAfter(this.cuentacontadetagrupoacti,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCuentaContaDetaGrupoActi();
			
			connexion.commit();			
			
			if(this.cuentacontadetagrupoacti.getIsDeleted()) {
				this.cuentacontadetagrupoacti=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCuentaContaDetaGrupoActi()throws Exception {	
		try {	
			
			CuentaContaDetaGrupoActiLogicAdditional.checkCuentaContaDetaGrupoActiToSave(this.cuentacontadetagrupoacti,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CuentaContaDetaGrupoActiLogicAdditional.updateCuentaContaDetaGrupoActiToSave(this.cuentacontadetagrupoacti,this.arrDatoGeneral);
			
			CuentaContaDetaGrupoActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cuentacontadetagrupoacti,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCuentaContaDetaGrupoActi(this.cuentacontadetagrupoacti)) {			
				CuentaContaDetaGrupoActiDataAccess.save(this.cuentacontadetagrupoacti, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cuentacontadetagrupoacti,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CuentaContaDetaGrupoActiLogicAdditional.checkCuentaContaDetaGrupoActiToSaveAfter(this.cuentacontadetagrupoacti,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cuentacontadetagrupoacti.getIsDeleted()) {
				this.cuentacontadetagrupoacti=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCuentaContaDetaGrupoActisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaDetaGrupoActi.class.getSimpleName()+"-saveCuentaContaDetaGrupoActisWithConnection");connexion.begin();			
			
			CuentaContaDetaGrupoActiLogicAdditional.checkCuentaContaDetaGrupoActiToSaves(cuentacontadetagrupoactis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCuentaContaDetaGrupoActis();
			
			Boolean validadoTodosCuentaContaDetaGrupoActi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CuentaContaDetaGrupoActi cuentacontadetagrupoactiLocal:cuentacontadetagrupoactis) {		
				if(cuentacontadetagrupoactiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CuentaContaDetaGrupoActiLogicAdditional.updateCuentaContaDetaGrupoActiToSave(cuentacontadetagrupoactiLocal,this.arrDatoGeneral);
	        	
				CuentaContaDetaGrupoActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cuentacontadetagrupoactiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCuentaContaDetaGrupoActi(cuentacontadetagrupoactiLocal)) {
					CuentaContaDetaGrupoActiDataAccess.save(cuentacontadetagrupoactiLocal, connexion);				
				} else {
					validadoTodosCuentaContaDetaGrupoActi=false;
				}
			}
			
			if(!validadoTodosCuentaContaDetaGrupoActi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CuentaContaDetaGrupoActiLogicAdditional.checkCuentaContaDetaGrupoActiToSavesAfter(cuentacontadetagrupoactis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCuentaContaDetaGrupoActis();
			
			connexion.commit();		
			
			this.quitarCuentaContaDetaGrupoActisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCuentaContaDetaGrupoActis()throws Exception {				
		 try {	
			CuentaContaDetaGrupoActiLogicAdditional.checkCuentaContaDetaGrupoActiToSaves(cuentacontadetagrupoactis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCuentaContaDetaGrupoActi=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CuentaContaDetaGrupoActi cuentacontadetagrupoactiLocal:cuentacontadetagrupoactis) {				
				if(cuentacontadetagrupoactiLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CuentaContaDetaGrupoActiLogicAdditional.updateCuentaContaDetaGrupoActiToSave(cuentacontadetagrupoactiLocal,this.arrDatoGeneral);
	        	
				CuentaContaDetaGrupoActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cuentacontadetagrupoactiLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCuentaContaDetaGrupoActi(cuentacontadetagrupoactiLocal)) {				
					CuentaContaDetaGrupoActiDataAccess.save(cuentacontadetagrupoactiLocal, connexion);				
				} else {
					validadoTodosCuentaContaDetaGrupoActi=false;
				}
			}
			
			if(!validadoTodosCuentaContaDetaGrupoActi) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CuentaContaDetaGrupoActiLogicAdditional.checkCuentaContaDetaGrupoActiToSavesAfter(cuentacontadetagrupoactis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCuentaContaDetaGrupoActisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CuentaContaDetaGrupoActiParameterReturnGeneral procesarAccionCuentaContaDetaGrupoActis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis,CuentaContaDetaGrupoActiParameterReturnGeneral cuentacontadetagrupoactiParameterGeneral)throws Exception {
		 try {	
			CuentaContaDetaGrupoActiParameterReturnGeneral cuentacontadetagrupoactiReturnGeneral=new CuentaContaDetaGrupoActiParameterReturnGeneral();
	
			CuentaContaDetaGrupoActiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cuentacontadetagrupoactis,cuentacontadetagrupoactiParameterGeneral,cuentacontadetagrupoactiReturnGeneral);
			
			return cuentacontadetagrupoactiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CuentaContaDetaGrupoActiParameterReturnGeneral procesarAccionCuentaContaDetaGrupoActisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis,CuentaContaDetaGrupoActiParameterReturnGeneral cuentacontadetagrupoactiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaDetaGrupoActi.class.getSimpleName()+"-procesarAccionCuentaContaDetaGrupoActisWithConnection");connexion.begin();			
			
			CuentaContaDetaGrupoActiParameterReturnGeneral cuentacontadetagrupoactiReturnGeneral=new CuentaContaDetaGrupoActiParameterReturnGeneral();
	
			CuentaContaDetaGrupoActiLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cuentacontadetagrupoactis,cuentacontadetagrupoactiParameterGeneral,cuentacontadetagrupoactiReturnGeneral);
			
			this.connexion.commit();
			
			return cuentacontadetagrupoactiReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CuentaContaDetaGrupoActiParameterReturnGeneral procesarEventosCuentaContaDetaGrupoActis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis,CuentaContaDetaGrupoActi cuentacontadetagrupoacti,CuentaContaDetaGrupoActiParameterReturnGeneral cuentacontadetagrupoactiParameterGeneral,Boolean isEsNuevoCuentaContaDetaGrupoActi,ArrayList<Classe> clases)throws Exception {
		 try {	
			CuentaContaDetaGrupoActiParameterReturnGeneral cuentacontadetagrupoactiReturnGeneral=new CuentaContaDetaGrupoActiParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cuentacontadetagrupoactiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CuentaContaDetaGrupoActiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cuentacontadetagrupoactis,cuentacontadetagrupoacti,cuentacontadetagrupoactiParameterGeneral,cuentacontadetagrupoactiReturnGeneral,isEsNuevoCuentaContaDetaGrupoActi,clases);
			
			return cuentacontadetagrupoactiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CuentaContaDetaGrupoActiParameterReturnGeneral procesarEventosCuentaContaDetaGrupoActisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis,CuentaContaDetaGrupoActi cuentacontadetagrupoacti,CuentaContaDetaGrupoActiParameterReturnGeneral cuentacontadetagrupoactiParameterGeneral,Boolean isEsNuevoCuentaContaDetaGrupoActi,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaDetaGrupoActi.class.getSimpleName()+"-procesarEventosCuentaContaDetaGrupoActisWithConnection");connexion.begin();			
			
			CuentaContaDetaGrupoActiParameterReturnGeneral cuentacontadetagrupoactiReturnGeneral=new CuentaContaDetaGrupoActiParameterReturnGeneral();
	
			cuentacontadetagrupoactiReturnGeneral.setCuentaContaDetaGrupoActi(cuentacontadetagrupoacti);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cuentacontadetagrupoactiReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CuentaContaDetaGrupoActiLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cuentacontadetagrupoactis,cuentacontadetagrupoacti,cuentacontadetagrupoactiParameterGeneral,cuentacontadetagrupoactiReturnGeneral,isEsNuevoCuentaContaDetaGrupoActi,clases);
			
			this.connexion.commit();
			
			return cuentacontadetagrupoactiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CuentaContaDetaGrupoActiParameterReturnGeneral procesarImportacionCuentaContaDetaGrupoActisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CuentaContaDetaGrupoActiParameterReturnGeneral cuentacontadetagrupoactiParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaDetaGrupoActi.class.getSimpleName()+"-procesarImportacionCuentaContaDetaGrupoActisWithConnection");connexion.begin();			
			
			CuentaContaDetaGrupoActiParameterReturnGeneral cuentacontadetagrupoactiReturnGeneral=new CuentaContaDetaGrupoActiParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cuentacontadetagrupoactis=new ArrayList<CuentaContaDetaGrupoActi>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cuentacontadetagrupoacti=new CuentaContaDetaGrupoActi();
				
				
				if(conColumnasBase) {this.cuentacontadetagrupoacti.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cuentacontadetagrupoacti.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.cuentacontadetagrupoactis.add(this.cuentacontadetagrupoacti);
			}
			
			this.saveCuentaContaDetaGrupoActis();
			
			this.connexion.commit();
			
			cuentacontadetagrupoactiReturnGeneral.setConRetornoEstaProcesado(true);
			cuentacontadetagrupoactiReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cuentacontadetagrupoactiReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCuentaContaDetaGrupoActisEliminados() throws Exception {				
		
		List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactisAux= new ArrayList<CuentaContaDetaGrupoActi>();
		
		for(CuentaContaDetaGrupoActi cuentacontadetagrupoacti:cuentacontadetagrupoactis) {
			if(!cuentacontadetagrupoacti.getIsDeleted()) {
				cuentacontadetagrupoactisAux.add(cuentacontadetagrupoacti);
			}
		}
		
		cuentacontadetagrupoactis=cuentacontadetagrupoactisAux;
	}
	
	public void quitarCuentaContaDetaGrupoActisNulos() throws Exception {				
		
		List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactisAux= new ArrayList<CuentaContaDetaGrupoActi>();
		
		for(CuentaContaDetaGrupoActi cuentacontadetagrupoacti : this.cuentacontadetagrupoactis) {
			if(cuentacontadetagrupoacti==null) {
				cuentacontadetagrupoactisAux.add(cuentacontadetagrupoacti);
			}
		}
		
		//this.cuentacontadetagrupoactis=cuentacontadetagrupoactisAux;
		
		this.cuentacontadetagrupoactis.removeAll(cuentacontadetagrupoactisAux);
	}
	
	public void getSetVersionRowCuentaContaDetaGrupoActiWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cuentacontadetagrupoacti.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cuentacontadetagrupoacti.getIsDeleted() || (cuentacontadetagrupoacti.getIsChanged()&&!cuentacontadetagrupoacti.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cuentacontadetagrupoactiDataAccess.getSetVersionRowCuentaContaDetaGrupoActi(connexion,cuentacontadetagrupoacti.getId());
				
				if(!cuentacontadetagrupoacti.getVersionRow().equals(timestamp)) {	
					cuentacontadetagrupoacti.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cuentacontadetagrupoacti.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCuentaContaDetaGrupoActi()throws Exception {	
		
		if(cuentacontadetagrupoacti.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cuentacontadetagrupoacti.getIsDeleted() || (cuentacontadetagrupoacti.getIsChanged()&&!cuentacontadetagrupoacti.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cuentacontadetagrupoactiDataAccess.getSetVersionRowCuentaContaDetaGrupoActi(connexion,cuentacontadetagrupoacti.getId());
			
			try {							
				if(!cuentacontadetagrupoacti.getVersionRow().equals(timestamp)) {	
					cuentacontadetagrupoacti.setVersionRow(timestamp);
				}
				
				cuentacontadetagrupoacti.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCuentaContaDetaGrupoActisWithConnection()throws Exception {	
		if(cuentacontadetagrupoactis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CuentaContaDetaGrupoActi cuentacontadetagrupoactiAux:cuentacontadetagrupoactis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cuentacontadetagrupoactiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cuentacontadetagrupoactiAux.getIsDeleted() || (cuentacontadetagrupoactiAux.getIsChanged()&&!cuentacontadetagrupoactiAux.getIsNew())) {
						
						timestamp=cuentacontadetagrupoactiDataAccess.getSetVersionRowCuentaContaDetaGrupoActi(connexion,cuentacontadetagrupoactiAux.getId());
						
						if(!cuentacontadetagrupoacti.getVersionRow().equals(timestamp)) {	
							cuentacontadetagrupoactiAux.setVersionRow(timestamp);
						}
								
						cuentacontadetagrupoactiAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCuentaContaDetaGrupoActis()throws Exception {	
		if(cuentacontadetagrupoactis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CuentaContaDetaGrupoActi cuentacontadetagrupoactiAux:cuentacontadetagrupoactis) {
					if(cuentacontadetagrupoactiAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cuentacontadetagrupoactiAux.getIsDeleted() || (cuentacontadetagrupoactiAux.getIsChanged()&&!cuentacontadetagrupoactiAux.getIsNew())) {
						
						timestamp=cuentacontadetagrupoactiDataAccess.getSetVersionRowCuentaContaDetaGrupoActi(connexion,cuentacontadetagrupoactiAux.getId());
						
						if(!cuentacontadetagrupoactiAux.getVersionRow().equals(timestamp)) {	
							cuentacontadetagrupoactiAux.setVersionRow(timestamp);
						}
						
													
						cuentacontadetagrupoactiAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CuentaContaDetaGrupoActiParameterReturnGeneral cargarCombosLoteForeignKeyCuentaContaDetaGrupoActiWithConnection(String finalQueryGlobalCuentaContable,String finalQueryGlobalDetalleGrupoActivoFijo) throws Exception {
		CuentaContaDetaGrupoActiParameterReturnGeneral  cuentacontadetagrupoactiReturnGeneral =new CuentaContaDetaGrupoActiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaDetaGrupoActi.class.getSimpleName()+"-cargarCombosLoteForeignKeyCuentaContaDetaGrupoActiWithConnection");connexion.begin();
			
			cuentacontadetagrupoactiReturnGeneral =new CuentaContaDetaGrupoActiParameterReturnGeneral();
			
			

			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			cuentacontadetagrupoactiReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<DetalleGrupoActivoFijo> detallegrupoactivofijosForeignKey=new ArrayList<DetalleGrupoActivoFijo>();
			DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic=new DetalleGrupoActivoFijoLogic();
			detallegrupoactivofijoLogic.setConnexion(this.connexion);
			detallegrupoactivofijoLogic.getDetalleGrupoActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleGrupoActivoFijo.equals("NONE")) {
				detallegrupoactivofijoLogic.getTodosDetalleGrupoActivoFijos(finalQueryGlobalDetalleGrupoActivoFijo,new Pagination());
				detallegrupoactivofijosForeignKey=detallegrupoactivofijoLogic.getDetalleGrupoActivoFijos();
			}

			cuentacontadetagrupoactiReturnGeneral.setdetallegrupoactivofijosForeignKey(detallegrupoactivofijosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cuentacontadetagrupoactiReturnGeneral;
	}
	
	public CuentaContaDetaGrupoActiParameterReturnGeneral cargarCombosLoteForeignKeyCuentaContaDetaGrupoActi(String finalQueryGlobalCuentaContable,String finalQueryGlobalDetalleGrupoActivoFijo) throws Exception {
		CuentaContaDetaGrupoActiParameterReturnGeneral  cuentacontadetagrupoactiReturnGeneral =new CuentaContaDetaGrupoActiParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cuentacontadetagrupoactiReturnGeneral =new CuentaContaDetaGrupoActiParameterReturnGeneral();
			
			

			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			cuentacontadetagrupoactiReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<DetalleGrupoActivoFijo> detallegrupoactivofijosForeignKey=new ArrayList<DetalleGrupoActivoFijo>();
			DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic=new DetalleGrupoActivoFijoLogic();
			detallegrupoactivofijoLogic.setConnexion(this.connexion);
			detallegrupoactivofijoLogic.getDetalleGrupoActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleGrupoActivoFijo.equals("NONE")) {
				detallegrupoactivofijoLogic.getTodosDetalleGrupoActivoFijos(finalQueryGlobalDetalleGrupoActivoFijo,new Pagination());
				detallegrupoactivofijosForeignKey=detallegrupoactivofijoLogic.getDetalleGrupoActivoFijos();
			}

			cuentacontadetagrupoactiReturnGeneral.setdetallegrupoactivofijosForeignKey(detallegrupoactivofijosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cuentacontadetagrupoactiReturnGeneral;
	}
	
	
	public void deepLoad(CuentaContaDetaGrupoActi cuentacontadetagrupoacti,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CuentaContaDetaGrupoActiLogicAdditional.updateCuentaContaDetaGrupoActiToGet(cuentacontadetagrupoacti,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cuentacontadetagrupoacti.setCuentaContable(cuentacontadetagrupoactiDataAccess.getCuentaContable(connexion,cuentacontadetagrupoacti));
		cuentacontadetagrupoacti.setDetalleGrupoActivoFijo(cuentacontadetagrupoactiDataAccess.getDetalleGrupoActivoFijo(connexion,cuentacontadetagrupoacti));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				cuentacontadetagrupoacti.setCuentaContable(cuentacontadetagrupoactiDataAccess.getCuentaContable(connexion,cuentacontadetagrupoacti));
				continue;
			}

			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				cuentacontadetagrupoacti.setDetalleGrupoActivoFijo(cuentacontadetagrupoactiDataAccess.getDetalleGrupoActivoFijo(connexion,cuentacontadetagrupoacti));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontadetagrupoacti.setCuentaContable(cuentacontadetagrupoactiDataAccess.getCuentaContable(connexion,cuentacontadetagrupoacti));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontadetagrupoacti.setDetalleGrupoActivoFijo(cuentacontadetagrupoactiDataAccess.getDetalleGrupoActivoFijo(connexion,cuentacontadetagrupoacti));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cuentacontadetagrupoacti.setCuentaContable(cuentacontadetagrupoactiDataAccess.getCuentaContable(connexion,cuentacontadetagrupoacti));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(cuentacontadetagrupoacti.getCuentaContable(),isDeep,deepLoadType,clases);
				
		cuentacontadetagrupoacti.setDetalleGrupoActivoFijo(cuentacontadetagrupoactiDataAccess.getDetalleGrupoActivoFijo(connexion,cuentacontadetagrupoacti));
		DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
		detallegrupoactivofijoLogic.deepLoad(cuentacontadetagrupoacti.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				cuentacontadetagrupoacti.setCuentaContable(cuentacontadetagrupoactiDataAccess.getCuentaContable(connexion,cuentacontadetagrupoacti));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentacontadetagrupoacti.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				cuentacontadetagrupoacti.setDetalleGrupoActivoFijo(cuentacontadetagrupoactiDataAccess.getDetalleGrupoActivoFijo(connexion,cuentacontadetagrupoacti));
				DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
				detallegrupoactivofijoLogic.deepLoad(cuentacontadetagrupoacti.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontadetagrupoacti.setCuentaContable(cuentacontadetagrupoactiDataAccess.getCuentaContable(connexion,cuentacontadetagrupoacti));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentacontadetagrupoacti.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontadetagrupoacti.setDetalleGrupoActivoFijo(cuentacontadetagrupoactiDataAccess.getDetalleGrupoActivoFijo(connexion,cuentacontadetagrupoacti));
			DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
			detallegrupoactivofijoLogic.deepLoad(cuentacontadetagrupoacti.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CuentaContaDetaGrupoActi cuentacontadetagrupoacti,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CuentaContaDetaGrupoActiLogicAdditional.updateCuentaContaDetaGrupoActiToSave(cuentacontadetagrupoacti,this.arrDatoGeneral);
			
CuentaContaDetaGrupoActiDataAccess.save(cuentacontadetagrupoacti, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		CuentaContableDataAccess.save(cuentacontadetagrupoacti.getCuentaContable(),connexion);

		DetalleGrupoActivoFijoDataAccess.save(cuentacontadetagrupoacti.getDetalleGrupoActivoFijo(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentacontadetagrupoacti.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				DetalleGrupoActivoFijoDataAccess.save(cuentacontadetagrupoacti.getDetalleGrupoActivoFijo(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		CuentaContableDataAccess.save(cuentacontadetagrupoacti.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(cuentacontadetagrupoacti.getCuentaContable(),isDeep,deepLoadType,clases);
				

		DetalleGrupoActivoFijoDataAccess.save(cuentacontadetagrupoacti.getDetalleGrupoActivoFijo(),connexion);
		DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
		detallegrupoactivofijoLogic.deepLoad(cuentacontadetagrupoacti.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentacontadetagrupoacti.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentacontadetagrupoacti.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				DetalleGrupoActivoFijoDataAccess.save(cuentacontadetagrupoacti.getDetalleGrupoActivoFijo(),connexion);
				DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
				detallegrupoactivofijoLogic.deepSave(cuentacontadetagrupoacti.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(CuentaContaDetaGrupoActi.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cuentacontadetagrupoacti,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(cuentacontadetagrupoacti);
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
			this.deepLoad(this.cuentacontadetagrupoacti,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(this.cuentacontadetagrupoacti);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CuentaContaDetaGrupoActi.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cuentacontadetagrupoactis!=null) {
				for(CuentaContaDetaGrupoActi cuentacontadetagrupoacti:cuentacontadetagrupoactis) {
					this.deepLoad(cuentacontadetagrupoacti,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(cuentacontadetagrupoactis);
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
			if(cuentacontadetagrupoactis!=null) {
				for(CuentaContaDetaGrupoActi cuentacontadetagrupoacti:cuentacontadetagrupoactis) {
					this.deepLoad(cuentacontadetagrupoacti,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(cuentacontadetagrupoactis);
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
			this.getNewConnexionToDeep(CuentaContaDetaGrupoActi.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cuentacontadetagrupoacti,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CuentaContaDetaGrupoActi.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cuentacontadetagrupoactis!=null) {
				for(CuentaContaDetaGrupoActi cuentacontadetagrupoacti:cuentacontadetagrupoactis) {
					this.deepSave(cuentacontadetagrupoacti,isDeep,deepLoadType,clases);
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
			if(cuentacontadetagrupoactis!=null) {
				for(CuentaContaDetaGrupoActi cuentacontadetagrupoacti:cuentacontadetagrupoactis) {
					this.deepSave(cuentacontadetagrupoacti,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCuentaContaDetaGrupoActisFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaDetaGrupoActi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,CuentaContaDetaGrupoActiConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			CuentaContaDetaGrupoActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontadetagrupoactis=cuentacontadetagrupoactiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(this.cuentacontadetagrupoactis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContaDetaGrupoActisFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,CuentaContaDetaGrupoActiConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			CuentaContaDetaGrupoActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontadetagrupoactis=cuentacontadetagrupoactiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(this.cuentacontadetagrupoactis);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaContaDetaGrupoActisFK_IdDetalleGrupoActivoFijoWithConnection(String sFinalQuery,Pagination pagination,Long id_detalle_grupo_activo_fijo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaDetaGrupoActi.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleGrupoActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleGrupoActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_grupo_activo_fijo,CuentaContaDetaGrupoActiConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleGrupoActivoFijo);

			CuentaContaDetaGrupoActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleGrupoActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontadetagrupoactis=cuentacontadetagrupoactiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(this.cuentacontadetagrupoactis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContaDetaGrupoActisFK_IdDetalleGrupoActivoFijo(String sFinalQuery,Pagination pagination,Long id_detalle_grupo_activo_fijo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleGrupoActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleGrupoActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_grupo_activo_fijo,CuentaContaDetaGrupoActiConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleGrupoActivoFijo);

			CuentaContaDetaGrupoActiLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleGrupoActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontadetagrupoactis=cuentacontadetagrupoactiDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContaDetaGrupoActiConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaDetaGrupoActi(this.cuentacontadetagrupoactis);
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
			if(CuentaContaDetaGrupoActiConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaContaDetaGrupoActiDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CuentaContaDetaGrupoActi cuentacontadetagrupoacti,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CuentaContaDetaGrupoActiConstantesFunciones.ISCONAUDITORIA) {
				if(cuentacontadetagrupoacti.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaContaDetaGrupoActiDataAccess.TABLENAME, cuentacontadetagrupoacti.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CuentaContaDetaGrupoActiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CuentaContaDetaGrupoActiLogic.registrarAuditoriaDetallesCuentaContaDetaGrupoActi(connexion,cuentacontadetagrupoacti,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cuentacontadetagrupoacti.getIsDeleted()) {
					/*if(!cuentacontadetagrupoacti.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CuentaContaDetaGrupoActiDataAccess.TABLENAME, cuentacontadetagrupoacti.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CuentaContaDetaGrupoActiLogic.registrarAuditoriaDetallesCuentaContaDetaGrupoActi(connexion,cuentacontadetagrupoacti,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaContaDetaGrupoActiDataAccess.TABLENAME, cuentacontadetagrupoacti.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cuentacontadetagrupoacti.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaContaDetaGrupoActiDataAccess.TABLENAME, cuentacontadetagrupoacti.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CuentaContaDetaGrupoActiConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CuentaContaDetaGrupoActiLogic.registrarAuditoriaDetallesCuentaContaDetaGrupoActi(connexion,cuentacontadetagrupoacti,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCuentaContaDetaGrupoActi(Connexion connexion,CuentaContaDetaGrupoActi cuentacontadetagrupoacti)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cuentacontadetagrupoacti.getIsNew()||!cuentacontadetagrupoacti.getid_cuenta_contable().equals(cuentacontadetagrupoacti.getCuentaContaDetaGrupoActiOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontadetagrupoacti.getCuentaContaDetaGrupoActiOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=cuentacontadetagrupoacti.getCuentaContaDetaGrupoActiOriginal().getid_cuenta_contable().toString();
				}
				if(cuentacontadetagrupoacti.getid_cuenta_contable()!=null)
				{
					strValorNuevo=cuentacontadetagrupoacti.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContaDetaGrupoActiConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontadetagrupoacti.getIsNew()||!cuentacontadetagrupoacti.getid_detalle_grupo_activo_fijo().equals(cuentacontadetagrupoacti.getCuentaContaDetaGrupoActiOriginal().getid_detalle_grupo_activo_fijo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontadetagrupoacti.getCuentaContaDetaGrupoActiOriginal().getid_detalle_grupo_activo_fijo()!=null)
				{
					strValorActual=cuentacontadetagrupoacti.getCuentaContaDetaGrupoActiOriginal().getid_detalle_grupo_activo_fijo().toString();
				}
				if(cuentacontadetagrupoacti.getid_detalle_grupo_activo_fijo()!=null)
				{
					strValorNuevo=cuentacontadetagrupoacti.getid_detalle_grupo_activo_fijo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContaDetaGrupoActiConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCuentaContaDetaGrupoActiRelacionesWithConnection(CuentaContaDetaGrupoActi cuentacontadetagrupoacti) throws Exception {

		if(!cuentacontadetagrupoacti.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCuentaContaDetaGrupoActiRelacionesBase(cuentacontadetagrupoacti,true);
		}
	}

	public void saveCuentaContaDetaGrupoActiRelaciones(CuentaContaDetaGrupoActi cuentacontadetagrupoacti)throws Exception {

		if(!cuentacontadetagrupoacti.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCuentaContaDetaGrupoActiRelacionesBase(cuentacontadetagrupoacti,false);
		}
	}

	public void saveCuentaContaDetaGrupoActiRelacionesBase(CuentaContaDetaGrupoActi cuentacontadetagrupoacti,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CuentaContaDetaGrupoActi-saveRelacionesWithConnection");}
	

			this.setCuentaContaDetaGrupoActi(cuentacontadetagrupoacti);

			if(CuentaContaDetaGrupoActiLogicAdditional.validarSaveRelaciones(cuentacontadetagrupoacti,this)) {

				CuentaContaDetaGrupoActiLogicAdditional.updateRelacionesToSave(cuentacontadetagrupoacti,this);

				if((cuentacontadetagrupoacti.getIsNew()||cuentacontadetagrupoacti.getIsChanged())&&!cuentacontadetagrupoacti.getIsDeleted()) {
					this.saveCuentaContaDetaGrupoActi();
					this.saveCuentaContaDetaGrupoActiRelacionesDetalles();

				} else if(cuentacontadetagrupoacti.getIsDeleted()) {
					this.saveCuentaContaDetaGrupoActiRelacionesDetalles();
					this.saveCuentaContaDetaGrupoActi();
				}

				CuentaContaDetaGrupoActiLogicAdditional.updateRelacionesToSaveAfter(cuentacontadetagrupoacti,this);

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
	
	
	private void saveCuentaContaDetaGrupoActiRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCuentaContaDetaGrupoActi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CuentaContaDetaGrupoActiConstantesFunciones.getClassesForeignKeysOfCuentaContaDetaGrupoActi(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaContaDetaGrupoActi(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CuentaContaDetaGrupoActiConstantesFunciones.getClassesRelationshipsOfCuentaContaDetaGrupoActi(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

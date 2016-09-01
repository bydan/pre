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
import com.bydan.erp.nomina.util.CargaFamiliar_NMConstantesFunciones;
import com.bydan.erp.nomina.util.CargaFamiliar_NMParameterReturnGeneral;
//import com.bydan.erp.nomina.util.CargaFamiliar_NMParameterGeneral;
import com.bydan.erp.nomina.business.entity.CargaFamiliar_NM;
import com.bydan.erp.nomina.business.logic.CargaFamiliar_NMLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class CargaFamiliar_NMLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CargaFamiliar_NMLogic.class);
	
	protected CargaFamiliar_NMDataAccess cargafamiliar_nmDataAccess; 	
	protected CargaFamiliar_NM cargafamiliar_nm;
	protected List<CargaFamiliar_NM> cargafamiliar_nms;
	protected Object cargafamiliar_nmObject;	
	protected List<Object> cargafamiliar_nmsObject;
	
	public static ClassValidator<CargaFamiliar_NM> cargafamiliar_nmValidator = new ClassValidator<CargaFamiliar_NM>(CargaFamiliar_NM.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CargaFamiliar_NMLogicAdditional cargafamiliar_nmLogicAdditional=null;
	
	public CargaFamiliar_NMLogicAdditional getCargaFamiliar_NMLogicAdditional() {
		return this.cargafamiliar_nmLogicAdditional;
	}
	
	public void setCargaFamiliar_NMLogicAdditional(CargaFamiliar_NMLogicAdditional cargafamiliar_nmLogicAdditional) {
		try {
			this.cargafamiliar_nmLogicAdditional=cargafamiliar_nmLogicAdditional;
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
	
	
	
	
	public  CargaFamiliar_NMLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cargafamiliar_nmDataAccess = new CargaFamiliar_NMDataAccess();
			
			this.cargafamiliar_nms= new ArrayList<CargaFamiliar_NM>();
			this.cargafamiliar_nm= new CargaFamiliar_NM();
			
			this.cargafamiliar_nmObject=new Object();
			this.cargafamiliar_nmsObject=new ArrayList<Object>();
				
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
			
			this.cargafamiliar_nmDataAccess.setConnexionType(this.connexionType);
			this.cargafamiliar_nmDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CargaFamiliar_NMLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cargafamiliar_nmDataAccess = new CargaFamiliar_NMDataAccess();
			this.cargafamiliar_nms= new ArrayList<CargaFamiliar_NM>();
			this.cargafamiliar_nm= new CargaFamiliar_NM();
			this.cargafamiliar_nmObject=new Object();
			this.cargafamiliar_nmsObject=new ArrayList<Object>();
			
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
			
			this.cargafamiliar_nmDataAccess.setConnexionType(this.connexionType);
			this.cargafamiliar_nmDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CargaFamiliar_NM getCargaFamiliar_NM() throws Exception {	
		CargaFamiliar_NMLogicAdditional.checkCargaFamiliar_NMToGet(cargafamiliar_nm,this.datosCliente,this.arrDatoGeneral);
		CargaFamiliar_NMLogicAdditional.updateCargaFamiliar_NMToGet(cargafamiliar_nm,this.arrDatoGeneral);
		
		return cargafamiliar_nm;
	}
		
	public void setCargaFamiliar_NM(CargaFamiliar_NM newCargaFamiliar_NM) {
		this.cargafamiliar_nm = newCargaFamiliar_NM;
	}
	
	public CargaFamiliar_NMDataAccess getCargaFamiliar_NMDataAccess() {
		return cargafamiliar_nmDataAccess;
	}
	
	public void setCargaFamiliar_NMDataAccess(CargaFamiliar_NMDataAccess newcargafamiliar_nmDataAccess) {
		this.cargafamiliar_nmDataAccess = newcargafamiliar_nmDataAccess;
	}
	
	public List<CargaFamiliar_NM> getCargaFamiliar_NMs() throws Exception {		
		this.quitarCargaFamiliar_NMsNulos();
		
		CargaFamiliar_NMLogicAdditional.checkCargaFamiliar_NMToGets(cargafamiliar_nms,this.datosCliente,this.arrDatoGeneral);
		
		for (CargaFamiliar_NM cargafamiliar_nmLocal: cargafamiliar_nms ) {
			CargaFamiliar_NMLogicAdditional.updateCargaFamiliar_NMToGet(cargafamiliar_nmLocal,this.arrDatoGeneral);
		}
		
		return cargafamiliar_nms;
	}
	
	public void setCargaFamiliar_NMs(List<CargaFamiliar_NM> newCargaFamiliar_NMs) {
		this.cargafamiliar_nms = newCargaFamiliar_NMs;
	}
	
	public Object getCargaFamiliar_NMObject() {	
		this.cargafamiliar_nmObject=this.cargafamiliar_nmDataAccess.getEntityObject();
		return this.cargafamiliar_nmObject;
	}
		
	public void setCargaFamiliar_NMObject(Object newCargaFamiliar_NMObject) {
		this.cargafamiliar_nmObject = newCargaFamiliar_NMObject;
	}
	
	public List<Object> getCargaFamiliar_NMsObject() {		
		this.cargafamiliar_nmsObject=this.cargafamiliar_nmDataAccess.getEntitiesObject();
		return this.cargafamiliar_nmsObject;
	}
		
	public void setCargaFamiliar_NMsObject(List<Object> newCargaFamiliar_NMsObject) {
		this.cargafamiliar_nmsObject = newCargaFamiliar_NMsObject;
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
		
		if(this.cargafamiliar_nmDataAccess!=null) {
			this.cargafamiliar_nmDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cargafamiliar_nmDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cargafamiliar_nmDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cargafamiliar_nm = new  CargaFamiliar_NM();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cargafamiliar_nm=cargafamiliar_nmDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cargafamiliar_nm,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nm);
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
		cargafamiliar_nm = new  CargaFamiliar_NM();
		  		  
        try {
			
			cargafamiliar_nm=cargafamiliar_nmDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cargafamiliar_nm,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nm);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cargafamiliar_nm = new  CargaFamiliar_NM();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cargafamiliar_nm=cargafamiliar_nmDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cargafamiliar_nm,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nm);
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
		cargafamiliar_nm = new  CargaFamiliar_NM();
		  		  
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
		cargafamiliar_nm = new  CargaFamiliar_NM();
		  		  
        try {
			
			cargafamiliar_nm=cargafamiliar_nmDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cargafamiliar_nm,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nm);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cargafamiliar_nm = new  CargaFamiliar_NM();
		  		  
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
		cargafamiliar_nm = new  CargaFamiliar_NM();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cargafamiliar_nmDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cargafamiliar_nm = new  CargaFamiliar_NM();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cargafamiliar_nmDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cargafamiliar_nm = new  CargaFamiliar_NM();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cargafamiliar_nmDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cargafamiliar_nm = new  CargaFamiliar_NM();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cargafamiliar_nmDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cargafamiliar_nm = new  CargaFamiliar_NM();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cargafamiliar_nmDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cargafamiliar_nm = new  CargaFamiliar_NM();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cargafamiliar_nmDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cargafamiliar_nms = new  ArrayList<CargaFamiliar_NM>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCargaFamiliar_NM(cargafamiliar_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nms);
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
		cargafamiliar_nms = new  ArrayList<CargaFamiliar_NM>();
		  		  
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
		cargafamiliar_nms = new  ArrayList<CargaFamiliar_NM>();
		  		  
        try {			
			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCargaFamiliar_NM(cargafamiliar_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nms);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cargafamiliar_nms = new  ArrayList<CargaFamiliar_NM>();
		  		  
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
		cargafamiliar_nms = new  ArrayList<CargaFamiliar_NM>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCargaFamiliar_NM(cargafamiliar_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nms);
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
		cargafamiliar_nms = new  ArrayList<CargaFamiliar_NM>();
		  		  
        try {
			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCargaFamiliar_NM(cargafamiliar_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nms);
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
		cargafamiliar_nms = new  ArrayList<CargaFamiliar_NM>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCargaFamiliar_NM(cargafamiliar_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nms);
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
		cargafamiliar_nms = new  ArrayList<CargaFamiliar_NM>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCargaFamiliar_NM(cargafamiliar_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nms);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cargafamiliar_nm = new  CargaFamiliar_NM();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliar_nm=cargafamiliar_nmDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCargaFamiliar_NM(cargafamiliar_nm);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nm);
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
		cargafamiliar_nm = new  CargaFamiliar_NM();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliar_nm=cargafamiliar_nmDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCargaFamiliar_NM(cargafamiliar_nm);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nm);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cargafamiliar_nms = new  ArrayList<CargaFamiliar_NM>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCargaFamiliar_NM(cargafamiliar_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nms);
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
		cargafamiliar_nms = new  ArrayList<CargaFamiliar_NM>();
		  		  
        try {
			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCargaFamiliar_NM(cargafamiliar_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nms);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCargaFamiliar_NMsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cargafamiliar_nms = new  ArrayList<CargaFamiliar_NM>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-getTodosCargaFamiliar_NMsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCargaFamiliar_NM(cargafamiliar_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nms);
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
	
	public  void  getTodosCargaFamiliar_NMs(String sFinalQuery,Pagination pagination)throws Exception {
		cargafamiliar_nms = new  ArrayList<CargaFamiliar_NM>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCargaFamiliar_NM(cargafamiliar_nms);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nms);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCargaFamiliar_NM(CargaFamiliar_NM cargafamiliar_nm) throws Exception {
		Boolean estaValidado=false;
		
		if(cargafamiliar_nm.getIsNew() || cargafamiliar_nm.getIsChanged()) { 
			this.invalidValues = cargafamiliar_nmValidator.getInvalidValues(cargafamiliar_nm);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cargafamiliar_nm);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCargaFamiliar_NM(List<CargaFamiliar_NM> CargaFamiliar_NMs) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CargaFamiliar_NM cargafamiliar_nmLocal:cargafamiliar_nms) {				
			estaValidadoObjeto=this.validarGuardarCargaFamiliar_NM(cargafamiliar_nmLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCargaFamiliar_NM(List<CargaFamiliar_NM> CargaFamiliar_NMs) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCargaFamiliar_NM(cargafamiliar_nms)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCargaFamiliar_NM(CargaFamiliar_NM CargaFamiliar_NM) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCargaFamiliar_NM(cargafamiliar_nm)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CargaFamiliar_NM cargafamiliar_nm) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cargafamiliar_nm.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CargaFamiliar_NMConstantesFunciones.getCargaFamiliar_NMLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cargafamiliar_nm","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CargaFamiliar_NMConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CargaFamiliar_NMConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCargaFamiliar_NMWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-saveCargaFamiliar_NMWithConnection");connexion.begin();			
			
			CargaFamiliar_NMLogicAdditional.checkCargaFamiliar_NMToSave(this.cargafamiliar_nm,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CargaFamiliar_NMLogicAdditional.updateCargaFamiliar_NMToSave(this.cargafamiliar_nm,this.arrDatoGeneral);
			
			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cargafamiliar_nm,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCargaFamiliar_NM();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCargaFamiliar_NM(this.cargafamiliar_nm)) {
				CargaFamiliar_NMDataAccess.save(this.cargafamiliar_nm, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cargafamiliar_nm,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CargaFamiliar_NMLogicAdditional.checkCargaFamiliar_NMToSaveAfter(this.cargafamiliar_nm,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCargaFamiliar_NM();
			
			connexion.commit();			
			
			if(this.cargafamiliar_nm.getIsDeleted()) {
				this.cargafamiliar_nm=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCargaFamiliar_NM()throws Exception {	
		try {	
			
			CargaFamiliar_NMLogicAdditional.checkCargaFamiliar_NMToSave(this.cargafamiliar_nm,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CargaFamiliar_NMLogicAdditional.updateCargaFamiliar_NMToSave(this.cargafamiliar_nm,this.arrDatoGeneral);
			
			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cargafamiliar_nm,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCargaFamiliar_NM(this.cargafamiliar_nm)) {			
				CargaFamiliar_NMDataAccess.save(this.cargafamiliar_nm, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cargafamiliar_nm,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CargaFamiliar_NMLogicAdditional.checkCargaFamiliar_NMToSaveAfter(this.cargafamiliar_nm,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cargafamiliar_nm.getIsDeleted()) {
				this.cargafamiliar_nm=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCargaFamiliar_NMsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-saveCargaFamiliar_NMsWithConnection");connexion.begin();			
			
			CargaFamiliar_NMLogicAdditional.checkCargaFamiliar_NMToSaves(cargafamiliar_nms,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCargaFamiliar_NMs();
			
			Boolean validadoTodosCargaFamiliar_NM=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CargaFamiliar_NM cargafamiliar_nmLocal:cargafamiliar_nms) {		
				if(cargafamiliar_nmLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CargaFamiliar_NMLogicAdditional.updateCargaFamiliar_NMToSave(cargafamiliar_nmLocal,this.arrDatoGeneral);
	        	
				CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cargafamiliar_nmLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCargaFamiliar_NM(cargafamiliar_nmLocal)) {
					CargaFamiliar_NMDataAccess.save(cargafamiliar_nmLocal, connexion);				
				} else {
					validadoTodosCargaFamiliar_NM=false;
				}
			}
			
			if(!validadoTodosCargaFamiliar_NM) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CargaFamiliar_NMLogicAdditional.checkCargaFamiliar_NMToSavesAfter(cargafamiliar_nms,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCargaFamiliar_NMs();
			
			connexion.commit();		
			
			this.quitarCargaFamiliar_NMsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCargaFamiliar_NMs()throws Exception {				
		 try {	
			CargaFamiliar_NMLogicAdditional.checkCargaFamiliar_NMToSaves(cargafamiliar_nms,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCargaFamiliar_NM=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CargaFamiliar_NM cargafamiliar_nmLocal:cargafamiliar_nms) {				
				if(cargafamiliar_nmLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CargaFamiliar_NMLogicAdditional.updateCargaFamiliar_NMToSave(cargafamiliar_nmLocal,this.arrDatoGeneral);
	        	
				CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cargafamiliar_nmLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCargaFamiliar_NM(cargafamiliar_nmLocal)) {				
					CargaFamiliar_NMDataAccess.save(cargafamiliar_nmLocal, connexion);				
				} else {
					validadoTodosCargaFamiliar_NM=false;
				}
			}
			
			if(!validadoTodosCargaFamiliar_NM) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CargaFamiliar_NMLogicAdditional.checkCargaFamiliar_NMToSavesAfter(cargafamiliar_nms,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCargaFamiliar_NMsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CargaFamiliar_NMParameterReturnGeneral procesarAccionCargaFamiliar_NMs(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CargaFamiliar_NM> cargafamiliar_nms,CargaFamiliar_NMParameterReturnGeneral cargafamiliar_nmParameterGeneral)throws Exception {
		 try {	
			CargaFamiliar_NMParameterReturnGeneral cargafamiliar_nmReturnGeneral=new CargaFamiliar_NMParameterReturnGeneral();
	
			CargaFamiliar_NMLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cargafamiliar_nms,cargafamiliar_nmParameterGeneral,cargafamiliar_nmReturnGeneral);
			
			return cargafamiliar_nmReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CargaFamiliar_NMParameterReturnGeneral procesarAccionCargaFamiliar_NMsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CargaFamiliar_NM> cargafamiliar_nms,CargaFamiliar_NMParameterReturnGeneral cargafamiliar_nmParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-procesarAccionCargaFamiliar_NMsWithConnection");connexion.begin();			
			
			CargaFamiliar_NMParameterReturnGeneral cargafamiliar_nmReturnGeneral=new CargaFamiliar_NMParameterReturnGeneral();
	
			CargaFamiliar_NMLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cargafamiliar_nms,cargafamiliar_nmParameterGeneral,cargafamiliar_nmReturnGeneral);
			
			this.connexion.commit();
			
			return cargafamiliar_nmReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CargaFamiliar_NMParameterReturnGeneral procesarEventosCargaFamiliar_NMs(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CargaFamiliar_NM> cargafamiliar_nms,CargaFamiliar_NM cargafamiliar_nm,CargaFamiliar_NMParameterReturnGeneral cargafamiliar_nmParameterGeneral,Boolean isEsNuevoCargaFamiliar_NM,ArrayList<Classe> clases)throws Exception {
		 try {	
			CargaFamiliar_NMParameterReturnGeneral cargafamiliar_nmReturnGeneral=new CargaFamiliar_NMParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cargafamiliar_nmReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CargaFamiliar_NMLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cargafamiliar_nms,cargafamiliar_nm,cargafamiliar_nmParameterGeneral,cargafamiliar_nmReturnGeneral,isEsNuevoCargaFamiliar_NM,clases);
			
			return cargafamiliar_nmReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CargaFamiliar_NMParameterReturnGeneral procesarEventosCargaFamiliar_NMsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CargaFamiliar_NM> cargafamiliar_nms,CargaFamiliar_NM cargafamiliar_nm,CargaFamiliar_NMParameterReturnGeneral cargafamiliar_nmParameterGeneral,Boolean isEsNuevoCargaFamiliar_NM,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-procesarEventosCargaFamiliar_NMsWithConnection");connexion.begin();			
			
			CargaFamiliar_NMParameterReturnGeneral cargafamiliar_nmReturnGeneral=new CargaFamiliar_NMParameterReturnGeneral();
	
			cargafamiliar_nmReturnGeneral.setCargaFamiliar_NM(cargafamiliar_nm);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cargafamiliar_nmReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CargaFamiliar_NMLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cargafamiliar_nms,cargafamiliar_nm,cargafamiliar_nmParameterGeneral,cargafamiliar_nmReturnGeneral,isEsNuevoCargaFamiliar_NM,clases);
			
			this.connexion.commit();
			
			return cargafamiliar_nmReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CargaFamiliar_NMParameterReturnGeneral procesarImportacionCargaFamiliar_NMsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CargaFamiliar_NMParameterReturnGeneral cargafamiliar_nmParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-procesarImportacionCargaFamiliar_NMsWithConnection");connexion.begin();			
			
			CargaFamiliar_NMParameterReturnGeneral cargafamiliar_nmReturnGeneral=new CargaFamiliar_NMParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cargafamiliar_nms=new ArrayList<CargaFamiliar_NM>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cargafamiliar_nm=new CargaFamiliar_NM();
				
				
				if(conColumnasBase) {this.cargafamiliar_nm.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cargafamiliar_nm.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.cargafamiliar_nm.setcedula(arrColumnas[iColumn++]);
				this.cargafamiliar_nm.setapellido(arrColumnas[iColumn++]);
				this.cargafamiliar_nm.setnombre(arrColumnas[iColumn++]);
			this.cargafamiliar_nm.setdireccion(arrColumnas[iColumn++]);
				this.cargafamiliar_nm.setfecha_nacimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.cargafamiliar_nm.setvalor_cupo(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.cargafamiliar_nms.add(this.cargafamiliar_nm);
			}
			
			this.saveCargaFamiliar_NMs();
			
			this.connexion.commit();
			
			cargafamiliar_nmReturnGeneral.setConRetornoEstaProcesado(true);
			cargafamiliar_nmReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cargafamiliar_nmReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCargaFamiliar_NMsEliminados() throws Exception {				
		
		List<CargaFamiliar_NM> cargafamiliar_nmsAux= new ArrayList<CargaFamiliar_NM>();
		
		for(CargaFamiliar_NM cargafamiliar_nm:cargafamiliar_nms) {
			if(!cargafamiliar_nm.getIsDeleted()) {
				cargafamiliar_nmsAux.add(cargafamiliar_nm);
			}
		}
		
		cargafamiliar_nms=cargafamiliar_nmsAux;
	}
	
	public void quitarCargaFamiliar_NMsNulos() throws Exception {				
		
		List<CargaFamiliar_NM> cargafamiliar_nmsAux= new ArrayList<CargaFamiliar_NM>();
		
		for(CargaFamiliar_NM cargafamiliar_nm : this.cargafamiliar_nms) {
			if(cargafamiliar_nm==null) {
				cargafamiliar_nmsAux.add(cargafamiliar_nm);
			}
		}
		
		//this.cargafamiliar_nms=cargafamiliar_nmsAux;
		
		this.cargafamiliar_nms.removeAll(cargafamiliar_nmsAux);
	}
	
	public void getSetVersionRowCargaFamiliar_NMWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cargafamiliar_nm.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cargafamiliar_nm.getIsDeleted() || (cargafamiliar_nm.getIsChanged()&&!cargafamiliar_nm.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cargafamiliar_nmDataAccess.getSetVersionRowCargaFamiliar_NM(connexion,cargafamiliar_nm.getId());
				
				if(!cargafamiliar_nm.getVersionRow().equals(timestamp)) {	
					cargafamiliar_nm.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cargafamiliar_nm.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCargaFamiliar_NM()throws Exception {	
		
		if(cargafamiliar_nm.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cargafamiliar_nm.getIsDeleted() || (cargafamiliar_nm.getIsChanged()&&!cargafamiliar_nm.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cargafamiliar_nmDataAccess.getSetVersionRowCargaFamiliar_NM(connexion,cargafamiliar_nm.getId());
			
			try {							
				if(!cargafamiliar_nm.getVersionRow().equals(timestamp)) {	
					cargafamiliar_nm.setVersionRow(timestamp);
				}
				
				cargafamiliar_nm.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCargaFamiliar_NMsWithConnection()throws Exception {	
		if(cargafamiliar_nms!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CargaFamiliar_NM cargafamiliar_nmAux:cargafamiliar_nms) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cargafamiliar_nmAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cargafamiliar_nmAux.getIsDeleted() || (cargafamiliar_nmAux.getIsChanged()&&!cargafamiliar_nmAux.getIsNew())) {
						
						timestamp=cargafamiliar_nmDataAccess.getSetVersionRowCargaFamiliar_NM(connexion,cargafamiliar_nmAux.getId());
						
						if(!cargafamiliar_nm.getVersionRow().equals(timestamp)) {	
							cargafamiliar_nmAux.setVersionRow(timestamp);
						}
								
						cargafamiliar_nmAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCargaFamiliar_NMs()throws Exception {	
		if(cargafamiliar_nms!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CargaFamiliar_NM cargafamiliar_nmAux:cargafamiliar_nms) {
					if(cargafamiliar_nmAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cargafamiliar_nmAux.getIsDeleted() || (cargafamiliar_nmAux.getIsChanged()&&!cargafamiliar_nmAux.getIsNew())) {
						
						timestamp=cargafamiliar_nmDataAccess.getSetVersionRowCargaFamiliar_NM(connexion,cargafamiliar_nmAux.getId());
						
						if(!cargafamiliar_nmAux.getVersionRow().equals(timestamp)) {	
							cargafamiliar_nmAux.setVersionRow(timestamp);
						}
						
													
						cargafamiliar_nmAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CargaFamiliar_NMParameterReturnGeneral cargarCombosLoteForeignKeyCargaFamiliar_NMWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoCargaFami,String finalQueryGlobalTipoGenero,String finalQueryGlobalEstadoCivil) throws Exception {
		CargaFamiliar_NMParameterReturnGeneral  cargafamiliar_nmReturnGeneral =new CargaFamiliar_NMParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-cargarCombosLoteForeignKeyCargaFamiliar_NMWithConnection");connexion.begin();
			
			cargafamiliar_nmReturnGeneral =new CargaFamiliar_NMParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cargafamiliar_nmReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			cargafamiliar_nmReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoCargaFami> tipocargafamisForeignKey=new ArrayList<TipoCargaFami>();
			TipoCargaFamiLogic tipocargafamiLogic=new TipoCargaFamiLogic();
			tipocargafamiLogic.setConnexion(this.connexion);
			tipocargafamiLogic.getTipoCargaFamiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCargaFami.equals("NONE")) {
				tipocargafamiLogic.getTodosTipoCargaFamis(finalQueryGlobalTipoCargaFami,new Pagination());
				tipocargafamisForeignKey=tipocargafamiLogic.getTipoCargaFamis();
			}

			cargafamiliar_nmReturnGeneral.settipocargafamisForeignKey(tipocargafamisForeignKey);


			List<TipoGenero> tipogenerosForeignKey=new ArrayList<TipoGenero>();
			TipoGeneroLogic tipogeneroLogic=new TipoGeneroLogic();
			tipogeneroLogic.setConnexion(this.connexion);
			tipogeneroLogic.getTipoGeneroDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGenero.equals("NONE")) {
				tipogeneroLogic.getTodosTipoGeneros(finalQueryGlobalTipoGenero,new Pagination());
				tipogenerosForeignKey=tipogeneroLogic.getTipoGeneros();
			}

			cargafamiliar_nmReturnGeneral.settipogenerosForeignKey(tipogenerosForeignKey);


			List<EstadoCivil> estadocivilsForeignKey=new ArrayList<EstadoCivil>();
			EstadoCivilLogic estadocivilLogic=new EstadoCivilLogic();
			estadocivilLogic.setConnexion(this.connexion);
			estadocivilLogic.getEstadoCivilDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoCivil.equals("NONE")) {
				estadocivilLogic.getTodosEstadoCivils(finalQueryGlobalEstadoCivil,new Pagination());
				estadocivilsForeignKey=estadocivilLogic.getEstadoCivils();
			}

			cargafamiliar_nmReturnGeneral.setestadocivilsForeignKey(estadocivilsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cargafamiliar_nmReturnGeneral;
	}
	
	public CargaFamiliar_NMParameterReturnGeneral cargarCombosLoteForeignKeyCargaFamiliar_NM(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoCargaFami,String finalQueryGlobalTipoGenero,String finalQueryGlobalEstadoCivil) throws Exception {
		CargaFamiliar_NMParameterReturnGeneral  cargafamiliar_nmReturnGeneral =new CargaFamiliar_NMParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cargafamiliar_nmReturnGeneral =new CargaFamiliar_NMParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cargafamiliar_nmReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			cargafamiliar_nmReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoCargaFami> tipocargafamisForeignKey=new ArrayList<TipoCargaFami>();
			TipoCargaFamiLogic tipocargafamiLogic=new TipoCargaFamiLogic();
			tipocargafamiLogic.setConnexion(this.connexion);
			tipocargafamiLogic.getTipoCargaFamiDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCargaFami.equals("NONE")) {
				tipocargafamiLogic.getTodosTipoCargaFamis(finalQueryGlobalTipoCargaFami,new Pagination());
				tipocargafamisForeignKey=tipocargafamiLogic.getTipoCargaFamis();
			}

			cargafamiliar_nmReturnGeneral.settipocargafamisForeignKey(tipocargafamisForeignKey);


			List<TipoGenero> tipogenerosForeignKey=new ArrayList<TipoGenero>();
			TipoGeneroLogic tipogeneroLogic=new TipoGeneroLogic();
			tipogeneroLogic.setConnexion(this.connexion);
			tipogeneroLogic.getTipoGeneroDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGenero.equals("NONE")) {
				tipogeneroLogic.getTodosTipoGeneros(finalQueryGlobalTipoGenero,new Pagination());
				tipogenerosForeignKey=tipogeneroLogic.getTipoGeneros();
			}

			cargafamiliar_nmReturnGeneral.settipogenerosForeignKey(tipogenerosForeignKey);


			List<EstadoCivil> estadocivilsForeignKey=new ArrayList<EstadoCivil>();
			EstadoCivilLogic estadocivilLogic=new EstadoCivilLogic();
			estadocivilLogic.setConnexion(this.connexion);
			estadocivilLogic.getEstadoCivilDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoCivil.equals("NONE")) {
				estadocivilLogic.getTodosEstadoCivils(finalQueryGlobalEstadoCivil,new Pagination());
				estadocivilsForeignKey=estadocivilLogic.getEstadoCivils();
			}

			cargafamiliar_nmReturnGeneral.setestadocivilsForeignKey(estadocivilsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cargafamiliar_nmReturnGeneral;
	}
	
	
	public void deepLoad(CargaFamiliar_NM cargafamiliar_nm,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CargaFamiliar_NMLogicAdditional.updateCargaFamiliar_NMToGet(cargafamiliar_nm,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cargafamiliar_nm.setEmpresa(cargafamiliar_nmDataAccess.getEmpresa(connexion,cargafamiliar_nm));
		cargafamiliar_nm.setEmpleado(cargafamiliar_nmDataAccess.getEmpleado(connexion,cargafamiliar_nm));
		cargafamiliar_nm.setTipoCargaFami(cargafamiliar_nmDataAccess.getTipoCargaFami(connexion,cargafamiliar_nm));
		cargafamiliar_nm.setTipoGenero(cargafamiliar_nmDataAccess.getTipoGenero(connexion,cargafamiliar_nm));
		cargafamiliar_nm.setEstadoCivil(cargafamiliar_nmDataAccess.getEstadoCivil(connexion,cargafamiliar_nm));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cargafamiliar_nm.setEmpresa(cargafamiliar_nmDataAccess.getEmpresa(connexion,cargafamiliar_nm));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				cargafamiliar_nm.setEmpleado(cargafamiliar_nmDataAccess.getEmpleado(connexion,cargafamiliar_nm));
				continue;
			}

			if(clas.clas.equals(TipoCargaFami.class)) {
				cargafamiliar_nm.setTipoCargaFami(cargafamiliar_nmDataAccess.getTipoCargaFami(connexion,cargafamiliar_nm));
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				cargafamiliar_nm.setTipoGenero(cargafamiliar_nmDataAccess.getTipoGenero(connexion,cargafamiliar_nm));
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				cargafamiliar_nm.setEstadoCivil(cargafamiliar_nmDataAccess.getEstadoCivil(connexion,cargafamiliar_nm));
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
			cargafamiliar_nm.setEmpresa(cargafamiliar_nmDataAccess.getEmpresa(connexion,cargafamiliar_nm));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargafamiliar_nm.setEmpleado(cargafamiliar_nmDataAccess.getEmpleado(connexion,cargafamiliar_nm));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCargaFami.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargafamiliar_nm.setTipoCargaFami(cargafamiliar_nmDataAccess.getTipoCargaFami(connexion,cargafamiliar_nm));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGenero.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargafamiliar_nm.setTipoGenero(cargafamiliar_nmDataAccess.getTipoGenero(connexion,cargafamiliar_nm));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoCivil.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargafamiliar_nm.setEstadoCivil(cargafamiliar_nmDataAccess.getEstadoCivil(connexion,cargafamiliar_nm));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cargafamiliar_nm.setEmpresa(cargafamiliar_nmDataAccess.getEmpresa(connexion,cargafamiliar_nm));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cargafamiliar_nm.getEmpresa(),isDeep,deepLoadType,clases);
				
		cargafamiliar_nm.setEmpleado(cargafamiliar_nmDataAccess.getEmpleado(connexion,cargafamiliar_nm));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(cargafamiliar_nm.getEmpleado(),isDeep,deepLoadType,clases);
				
		cargafamiliar_nm.setTipoCargaFami(cargafamiliar_nmDataAccess.getTipoCargaFami(connexion,cargafamiliar_nm));
		TipoCargaFamiLogic tipocargafamiLogic= new TipoCargaFamiLogic(connexion);
		tipocargafamiLogic.deepLoad(cargafamiliar_nm.getTipoCargaFami(),isDeep,deepLoadType,clases);
				
		cargafamiliar_nm.setTipoGenero(cargafamiliar_nmDataAccess.getTipoGenero(connexion,cargafamiliar_nm));
		TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
		tipogeneroLogic.deepLoad(cargafamiliar_nm.getTipoGenero(),isDeep,deepLoadType,clases);
				
		cargafamiliar_nm.setEstadoCivil(cargafamiliar_nmDataAccess.getEstadoCivil(connexion,cargafamiliar_nm));
		EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
		estadocivilLogic.deepLoad(cargafamiliar_nm.getEstadoCivil(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cargafamiliar_nm.setEmpresa(cargafamiliar_nmDataAccess.getEmpresa(connexion,cargafamiliar_nm));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cargafamiliar_nm.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				cargafamiliar_nm.setEmpleado(cargafamiliar_nmDataAccess.getEmpleado(connexion,cargafamiliar_nm));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(cargafamiliar_nm.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCargaFami.class)) {
				cargafamiliar_nm.setTipoCargaFami(cargafamiliar_nmDataAccess.getTipoCargaFami(connexion,cargafamiliar_nm));
				TipoCargaFamiLogic tipocargafamiLogic= new TipoCargaFamiLogic(connexion);
				tipocargafamiLogic.deepLoad(cargafamiliar_nm.getTipoCargaFami(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				cargafamiliar_nm.setTipoGenero(cargafamiliar_nmDataAccess.getTipoGenero(connexion,cargafamiliar_nm));
				TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
				tipogeneroLogic.deepLoad(cargafamiliar_nm.getTipoGenero(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				cargafamiliar_nm.setEstadoCivil(cargafamiliar_nmDataAccess.getEstadoCivil(connexion,cargafamiliar_nm));
				EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
				estadocivilLogic.deepLoad(cargafamiliar_nm.getEstadoCivil(),isDeep,deepLoadType,clases);				
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
			cargafamiliar_nm.setEmpresa(cargafamiliar_nmDataAccess.getEmpresa(connexion,cargafamiliar_nm));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cargafamiliar_nm.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargafamiliar_nm.setEmpleado(cargafamiliar_nmDataAccess.getEmpleado(connexion,cargafamiliar_nm));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(cargafamiliar_nm.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCargaFami.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargafamiliar_nm.setTipoCargaFami(cargafamiliar_nmDataAccess.getTipoCargaFami(connexion,cargafamiliar_nm));
			TipoCargaFamiLogic tipocargafamiLogic= new TipoCargaFamiLogic(connexion);
			tipocargafamiLogic.deepLoad(cargafamiliar_nm.getTipoCargaFami(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGenero.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargafamiliar_nm.setTipoGenero(cargafamiliar_nmDataAccess.getTipoGenero(connexion,cargafamiliar_nm));
			TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
			tipogeneroLogic.deepLoad(cargafamiliar_nm.getTipoGenero(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoCivil.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cargafamiliar_nm.setEstadoCivil(cargafamiliar_nmDataAccess.getEstadoCivil(connexion,cargafamiliar_nm));
			EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
			estadocivilLogic.deepLoad(cargafamiliar_nm.getEstadoCivil(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CargaFamiliar_NM cargafamiliar_nm,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CargaFamiliar_NMLogicAdditional.updateCargaFamiliar_NMToSave(cargafamiliar_nm,this.arrDatoGeneral);
			
CargaFamiliar_NMDataAccess.save(cargafamiliar_nm, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cargafamiliar_nm.getEmpresa(),connexion);

		EmpleadoDataAccess.save(cargafamiliar_nm.getEmpleado(),connexion);

		TipoCargaFamiDataAccess.save(cargafamiliar_nm.getTipoCargaFami(),connexion);

		TipoGeneroDataAccess.save(cargafamiliar_nm.getTipoGenero(),connexion);

		EstadoCivilDataAccess.save(cargafamiliar_nm.getEstadoCivil(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cargafamiliar_nm.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(cargafamiliar_nm.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCargaFami.class)) {
				TipoCargaFamiDataAccess.save(cargafamiliar_nm.getTipoCargaFami(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				TipoGeneroDataAccess.save(cargafamiliar_nm.getTipoGenero(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				EstadoCivilDataAccess.save(cargafamiliar_nm.getEstadoCivil(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cargafamiliar_nm.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cargafamiliar_nm.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(cargafamiliar_nm.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(cargafamiliar_nm.getEmpleado(),isDeep,deepLoadType,clases);
				

		TipoCargaFamiDataAccess.save(cargafamiliar_nm.getTipoCargaFami(),connexion);
		TipoCargaFamiLogic tipocargafamiLogic= new TipoCargaFamiLogic(connexion);
		tipocargafamiLogic.deepLoad(cargafamiliar_nm.getTipoCargaFami(),isDeep,deepLoadType,clases);
				

		TipoGeneroDataAccess.save(cargafamiliar_nm.getTipoGenero(),connexion);
		TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
		tipogeneroLogic.deepLoad(cargafamiliar_nm.getTipoGenero(),isDeep,deepLoadType,clases);
				

		EstadoCivilDataAccess.save(cargafamiliar_nm.getEstadoCivil(),connexion);
		EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
		estadocivilLogic.deepLoad(cargafamiliar_nm.getEstadoCivil(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cargafamiliar_nm.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(cargafamiliar_nm.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(cargafamiliar_nm.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(cargafamiliar_nm.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCargaFami.class)) {
				TipoCargaFamiDataAccess.save(cargafamiliar_nm.getTipoCargaFami(),connexion);
				TipoCargaFamiLogic tipocargafamiLogic= new TipoCargaFamiLogic(connexion);
				tipocargafamiLogic.deepSave(cargafamiliar_nm.getTipoCargaFami(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				TipoGeneroDataAccess.save(cargafamiliar_nm.getTipoGenero(),connexion);
				TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
				tipogeneroLogic.deepSave(cargafamiliar_nm.getTipoGenero(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				EstadoCivilDataAccess.save(cargafamiliar_nm.getEstadoCivil(),connexion);
				EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
				estadocivilLogic.deepSave(cargafamiliar_nm.getEstadoCivil(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(CargaFamiliar_NM.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cargafamiliar_nm,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(cargafamiliar_nm);
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
			this.deepLoad(this.cargafamiliar_nm,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nm);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CargaFamiliar_NM.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cargafamiliar_nms!=null) {
				for(CargaFamiliar_NM cargafamiliar_nm:cargafamiliar_nms) {
					this.deepLoad(cargafamiliar_nm,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(cargafamiliar_nms);
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
			if(cargafamiliar_nms!=null) {
				for(CargaFamiliar_NM cargafamiliar_nm:cargafamiliar_nms) {
					this.deepLoad(cargafamiliar_nm,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(cargafamiliar_nms);
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
			this.getNewConnexionToDeep(CargaFamiliar_NM.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cargafamiliar_nm,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CargaFamiliar_NM.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cargafamiliar_nms!=null) {
				for(CargaFamiliar_NM cargafamiliar_nm:cargafamiliar_nms) {
					this.deepSave(cargafamiliar_nm,isDeep,deepLoadType,clases);
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
			if(cargafamiliar_nms!=null) {
				for(CargaFamiliar_NM cargafamiliar_nm:cargafamiliar_nms) {
					this.deepSave(cargafamiliar_nm,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCargaFamiliar_NMsFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,CargaFamiliar_NMConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nms);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCargaFamiliar_NMsFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,CargaFamiliar_NMConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nms);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCargaFamiliar_NMsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CargaFamiliar_NMConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nms);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCargaFamiliar_NMsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CargaFamiliar_NMConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nms);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCargaFamiliar_NMsFK_IdEstadoCivilWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_civil)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoCivil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoCivil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_civil,CargaFamiliar_NMConstantesFunciones.IDESTADOCIVIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoCivil);

			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoCivil","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nms);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCargaFamiliar_NMsFK_IdEstadoCivil(String sFinalQuery,Pagination pagination,Long id_estado_civil)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoCivil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoCivil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_civil,CargaFamiliar_NMConstantesFunciones.IDESTADOCIVIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoCivil);

			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoCivil","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nms);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCargaFamiliar_NMsFK_IdTipoCargaFamiWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_carga_fami)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCargaFami= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCargaFami.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_carga_fami,CargaFamiliar_NMConstantesFunciones.IDTIPOCARGAFAMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCargaFami);

			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCargaFami","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nms);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCargaFamiliar_NMsFK_IdTipoCargaFami(String sFinalQuery,Pagination pagination,Long id_tipo_carga_fami)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCargaFami= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCargaFami.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_carga_fami,CargaFamiliar_NMConstantesFunciones.IDTIPOCARGAFAMI,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCargaFami);

			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCargaFami","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nms);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCargaFamiliar_NMsFK_IdTipoGeneroWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_genero)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CargaFamiliar_NM.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGenero= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGenero.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_genero,CargaFamiliar_NMConstantesFunciones.IDTIPOGENERO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGenero);

			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGenero","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nms);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCargaFamiliar_NMsFK_IdTipoGenero(String sFinalQuery,Pagination pagination,Long id_tipo_genero)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGenero= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGenero.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_genero,CargaFamiliar_NMConstantesFunciones.IDTIPOGENERO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGenero);

			CargaFamiliar_NMLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGenero","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cargafamiliar_nms=cargafamiliar_nmDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CargaFamiliar_NMConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar_NM(this.cargafamiliar_nms);
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
			if(CargaFamiliar_NMConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CargaFamiliar_NMDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CargaFamiliar_NM cargafamiliar_nm,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CargaFamiliar_NMConstantesFunciones.ISCONAUDITORIA) {
				if(cargafamiliar_nm.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CargaFamiliar_NMDataAccess.TABLENAME, cargafamiliar_nm.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CargaFamiliar_NMConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CargaFamiliar_NMLogic.registrarAuditoriaDetallesCargaFamiliar_NM(connexion,cargafamiliar_nm,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cargafamiliar_nm.getIsDeleted()) {
					/*if(!cargafamiliar_nm.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CargaFamiliar_NMDataAccess.TABLENAME, cargafamiliar_nm.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CargaFamiliar_NMLogic.registrarAuditoriaDetallesCargaFamiliar_NM(connexion,cargafamiliar_nm,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CargaFamiliar_NMDataAccess.TABLENAME, cargafamiliar_nm.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cargafamiliar_nm.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CargaFamiliar_NMDataAccess.TABLENAME, cargafamiliar_nm.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CargaFamiliar_NMConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CargaFamiliar_NMLogic.registrarAuditoriaDetallesCargaFamiliar_NM(connexion,cargafamiliar_nm,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCargaFamiliar_NM(Connexion connexion,CargaFamiliar_NM cargafamiliar_nm)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cargafamiliar_nm.getIsNew()||!cargafamiliar_nm.getid_empresa().equals(cargafamiliar_nm.getCargaFamiliar_NMOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargafamiliar_nm.getCargaFamiliar_NMOriginal().getid_empresa()!=null)
				{
					strValorActual=cargafamiliar_nm.getCargaFamiliar_NMOriginal().getid_empresa().toString();
				}
				if(cargafamiliar_nm.getid_empresa()!=null)
				{
					strValorNuevo=cargafamiliar_nm.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargaFamiliar_NMConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(cargafamiliar_nm.getIsNew()||!cargafamiliar_nm.getid_empleado().equals(cargafamiliar_nm.getCargaFamiliar_NMOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargafamiliar_nm.getCargaFamiliar_NMOriginal().getid_empleado()!=null)
				{
					strValorActual=cargafamiliar_nm.getCargaFamiliar_NMOriginal().getid_empleado().toString();
				}
				if(cargafamiliar_nm.getid_empleado()!=null)
				{
					strValorNuevo=cargafamiliar_nm.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargaFamiliar_NMConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(cargafamiliar_nm.getIsNew()||!cargafamiliar_nm.getid_tipo_carga_fami().equals(cargafamiliar_nm.getCargaFamiliar_NMOriginal().getid_tipo_carga_fami()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargafamiliar_nm.getCargaFamiliar_NMOriginal().getid_tipo_carga_fami()!=null)
				{
					strValorActual=cargafamiliar_nm.getCargaFamiliar_NMOriginal().getid_tipo_carga_fami().toString();
				}
				if(cargafamiliar_nm.getid_tipo_carga_fami()!=null)
				{
					strValorNuevo=cargafamiliar_nm.getid_tipo_carga_fami().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargaFamiliar_NMConstantesFunciones.IDTIPOCARGAFAMI,strValorActual,strValorNuevo);
			}	
			
			if(cargafamiliar_nm.getIsNew()||!cargafamiliar_nm.getid_tipo_genero().equals(cargafamiliar_nm.getCargaFamiliar_NMOriginal().getid_tipo_genero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargafamiliar_nm.getCargaFamiliar_NMOriginal().getid_tipo_genero()!=null)
				{
					strValorActual=cargafamiliar_nm.getCargaFamiliar_NMOriginal().getid_tipo_genero().toString();
				}
				if(cargafamiliar_nm.getid_tipo_genero()!=null)
				{
					strValorNuevo=cargafamiliar_nm.getid_tipo_genero().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargaFamiliar_NMConstantesFunciones.IDTIPOGENERO,strValorActual,strValorNuevo);
			}	
			
			if(cargafamiliar_nm.getIsNew()||!cargafamiliar_nm.getid_estado_civil().equals(cargafamiliar_nm.getCargaFamiliar_NMOriginal().getid_estado_civil()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargafamiliar_nm.getCargaFamiliar_NMOriginal().getid_estado_civil()!=null)
				{
					strValorActual=cargafamiliar_nm.getCargaFamiliar_NMOriginal().getid_estado_civil().toString();
				}
				if(cargafamiliar_nm.getid_estado_civil()!=null)
				{
					strValorNuevo=cargafamiliar_nm.getid_estado_civil().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargaFamiliar_NMConstantesFunciones.IDESTADOCIVIL,strValorActual,strValorNuevo);
			}	
			
			if(cargafamiliar_nm.getIsNew()||!cargafamiliar_nm.getcedula().equals(cargafamiliar_nm.getCargaFamiliar_NMOriginal().getcedula()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargafamiliar_nm.getCargaFamiliar_NMOriginal().getcedula()!=null)
				{
					strValorActual=cargafamiliar_nm.getCargaFamiliar_NMOriginal().getcedula();
				}
				if(cargafamiliar_nm.getcedula()!=null)
				{
					strValorNuevo=cargafamiliar_nm.getcedula() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargaFamiliar_NMConstantesFunciones.CEDULA,strValorActual,strValorNuevo);
			}	
			
			if(cargafamiliar_nm.getIsNew()||!cargafamiliar_nm.getapellido().equals(cargafamiliar_nm.getCargaFamiliar_NMOriginal().getapellido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargafamiliar_nm.getCargaFamiliar_NMOriginal().getapellido()!=null)
				{
					strValorActual=cargafamiliar_nm.getCargaFamiliar_NMOriginal().getapellido();
				}
				if(cargafamiliar_nm.getapellido()!=null)
				{
					strValorNuevo=cargafamiliar_nm.getapellido() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargaFamiliar_NMConstantesFunciones.APELLIDO,strValorActual,strValorNuevo);
			}	
			
			if(cargafamiliar_nm.getIsNew()||!cargafamiliar_nm.getnombre().equals(cargafamiliar_nm.getCargaFamiliar_NMOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargafamiliar_nm.getCargaFamiliar_NMOriginal().getnombre()!=null)
				{
					strValorActual=cargafamiliar_nm.getCargaFamiliar_NMOriginal().getnombre();
				}
				if(cargafamiliar_nm.getnombre()!=null)
				{
					strValorNuevo=cargafamiliar_nm.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargaFamiliar_NMConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(cargafamiliar_nm.getIsNew()||!cargafamiliar_nm.getdireccion().equals(cargafamiliar_nm.getCargaFamiliar_NMOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargafamiliar_nm.getCargaFamiliar_NMOriginal().getdireccion()!=null)
				{
					strValorActual=cargafamiliar_nm.getCargaFamiliar_NMOriginal().getdireccion();
				}
				if(cargafamiliar_nm.getdireccion()!=null)
				{
					strValorNuevo=cargafamiliar_nm.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargaFamiliar_NMConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(cargafamiliar_nm.getIsNew()||!cargafamiliar_nm.getfecha_nacimiento().equals(cargafamiliar_nm.getCargaFamiliar_NMOriginal().getfecha_nacimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargafamiliar_nm.getCargaFamiliar_NMOriginal().getfecha_nacimiento()!=null)
				{
					strValorActual=cargafamiliar_nm.getCargaFamiliar_NMOriginal().getfecha_nacimiento().toString();
				}
				if(cargafamiliar_nm.getfecha_nacimiento()!=null)
				{
					strValorNuevo=cargafamiliar_nm.getfecha_nacimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargaFamiliar_NMConstantesFunciones.FECHANACIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(cargafamiliar_nm.getIsNew()||!cargafamiliar_nm.getvalor_cupo().equals(cargafamiliar_nm.getCargaFamiliar_NMOriginal().getvalor_cupo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cargafamiliar_nm.getCargaFamiliar_NMOriginal().getvalor_cupo()!=null)
				{
					strValorActual=cargafamiliar_nm.getCargaFamiliar_NMOriginal().getvalor_cupo().toString();
				}
				if(cargafamiliar_nm.getvalor_cupo()!=null)
				{
					strValorNuevo=cargafamiliar_nm.getvalor_cupo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CargaFamiliar_NMConstantesFunciones.VALORCUPO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCargaFamiliar_NMRelacionesWithConnection(CargaFamiliar_NM cargafamiliar_nm) throws Exception {

		if(!cargafamiliar_nm.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCargaFamiliar_NMRelacionesBase(cargafamiliar_nm,true);
		}
	}

	public void saveCargaFamiliar_NMRelaciones(CargaFamiliar_NM cargafamiliar_nm)throws Exception {

		if(!cargafamiliar_nm.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCargaFamiliar_NMRelacionesBase(cargafamiliar_nm,false);
		}
	}

	public void saveCargaFamiliar_NMRelacionesBase(CargaFamiliar_NM cargafamiliar_nm,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CargaFamiliar_NM-saveRelacionesWithConnection");}
	

			this.setCargaFamiliar_NM(cargafamiliar_nm);

			if(CargaFamiliar_NMLogicAdditional.validarSaveRelaciones(cargafamiliar_nm,this)) {

				CargaFamiliar_NMLogicAdditional.updateRelacionesToSave(cargafamiliar_nm,this);

				if((cargafamiliar_nm.getIsNew()||cargafamiliar_nm.getIsChanged())&&!cargafamiliar_nm.getIsDeleted()) {
					this.saveCargaFamiliar_NM();
					this.saveCargaFamiliar_NMRelacionesDetalles();

				} else if(cargafamiliar_nm.getIsDeleted()) {
					this.saveCargaFamiliar_NMRelacionesDetalles();
					this.saveCargaFamiliar_NM();
				}

				CargaFamiliar_NMLogicAdditional.updateRelacionesToSaveAfter(cargafamiliar_nm,this);

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
	
	
	private void saveCargaFamiliar_NMRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCargaFamiliar_NM(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CargaFamiliar_NMConstantesFunciones.getClassesForeignKeysOfCargaFamiliar_NM(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCargaFamiliar_NM(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CargaFamiliar_NMConstantesFunciones.getClassesRelationshipsOfCargaFamiliar_NM(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

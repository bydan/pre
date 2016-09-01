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
package com.bydan.erp.puntoventa.business.logic;

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
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.puntoventa.util.CajaCierreConstantesFunciones;
import com.bydan.erp.puntoventa.util.CajaCierreParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.CajaCierreParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.CajaCierre;
import com.bydan.erp.puntoventa.business.logic.CajaCierreLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class CajaCierreLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CajaCierreLogic.class);
	
	protected CajaCierreDataAccess cajacierreDataAccess; 	
	protected CajaCierre cajacierre;
	protected List<CajaCierre> cajacierres;
	protected Object cajacierreObject;	
	protected List<Object> cajacierresObject;
	
	public static ClassValidator<CajaCierre> cajacierreValidator = new ClassValidator<CajaCierre>(CajaCierre.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CajaCierreLogicAdditional cajacierreLogicAdditional=null;
	
	public CajaCierreLogicAdditional getCajaCierreLogicAdditional() {
		return this.cajacierreLogicAdditional;
	}
	
	public void setCajaCierreLogicAdditional(CajaCierreLogicAdditional cajacierreLogicAdditional) {
		try {
			this.cajacierreLogicAdditional=cajacierreLogicAdditional;
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
	
	
	
	
	public  CajaCierreLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cajacierreDataAccess = new CajaCierreDataAccess();
			
			this.cajacierres= new ArrayList<CajaCierre>();
			this.cajacierre= new CajaCierre();
			
			this.cajacierreObject=new Object();
			this.cajacierresObject=new ArrayList<Object>();
				
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
			
			this.cajacierreDataAccess.setConnexionType(this.connexionType);
			this.cajacierreDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CajaCierreLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cajacierreDataAccess = new CajaCierreDataAccess();
			this.cajacierres= new ArrayList<CajaCierre>();
			this.cajacierre= new CajaCierre();
			this.cajacierreObject=new Object();
			this.cajacierresObject=new ArrayList<Object>();
			
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
			
			this.cajacierreDataAccess.setConnexionType(this.connexionType);
			this.cajacierreDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CajaCierre getCajaCierre() throws Exception {	
		CajaCierreLogicAdditional.checkCajaCierreToGet(cajacierre,this.datosCliente,this.arrDatoGeneral);
		CajaCierreLogicAdditional.updateCajaCierreToGet(cajacierre,this.arrDatoGeneral);
		
		return cajacierre;
	}
		
	public void setCajaCierre(CajaCierre newCajaCierre) {
		this.cajacierre = newCajaCierre;
	}
	
	public CajaCierreDataAccess getCajaCierreDataAccess() {
		return cajacierreDataAccess;
	}
	
	public void setCajaCierreDataAccess(CajaCierreDataAccess newcajacierreDataAccess) {
		this.cajacierreDataAccess = newcajacierreDataAccess;
	}
	
	public List<CajaCierre> getCajaCierres() throws Exception {		
		this.quitarCajaCierresNulos();
		
		CajaCierreLogicAdditional.checkCajaCierreToGets(cajacierres,this.datosCliente,this.arrDatoGeneral);
		
		for (CajaCierre cajacierreLocal: cajacierres ) {
			CajaCierreLogicAdditional.updateCajaCierreToGet(cajacierreLocal,this.arrDatoGeneral);
		}
		
		return cajacierres;
	}
	
	public void setCajaCierres(List<CajaCierre> newCajaCierres) {
		this.cajacierres = newCajaCierres;
	}
	
	public Object getCajaCierreObject() {	
		this.cajacierreObject=this.cajacierreDataAccess.getEntityObject();
		return this.cajacierreObject;
	}
		
	public void setCajaCierreObject(Object newCajaCierreObject) {
		this.cajacierreObject = newCajaCierreObject;
	}
	
	public List<Object> getCajaCierresObject() {		
		this.cajacierresObject=this.cajacierreDataAccess.getEntitiesObject();
		return this.cajacierresObject;
	}
		
	public void setCajaCierresObject(List<Object> newCajaCierresObject) {
		this.cajacierresObject = newCajaCierresObject;
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
		
		if(this.cajacierreDataAccess!=null) {
			this.cajacierreDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaCierre.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cajacierreDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cajacierreDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cajacierre = new  CajaCierre();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaCierre.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cajacierre=cajacierreDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajacierre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierre);
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
		cajacierre = new  CajaCierre();
		  		  
        try {
			
			cajacierre=cajacierreDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajacierre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierre);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cajacierre = new  CajaCierre();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaCierre.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cajacierre=cajacierreDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajacierre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierre);
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
		cajacierre = new  CajaCierre();
		  		  
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
		cajacierre = new  CajaCierre();
		  		  
        try {
			
			cajacierre=cajacierreDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajacierre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierre);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cajacierre = new  CajaCierre();
		  		  
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
		cajacierre = new  CajaCierre();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaCierre.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cajacierreDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cajacierre = new  CajaCierre();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cajacierreDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cajacierre = new  CajaCierre();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaCierre.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cajacierreDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cajacierre = new  CajaCierre();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cajacierreDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cajacierre = new  CajaCierre();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaCierre.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cajacierreDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cajacierre = new  CajaCierre();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cajacierreDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cajacierres = new  ArrayList<CajaCierre>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaCierre.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CajaCierreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajacierres=cajacierreDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaCierre(cajacierres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierres);
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
		cajacierres = new  ArrayList<CajaCierre>();
		  		  
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
		cajacierres = new  ArrayList<CajaCierre>();
		  		  
        try {			
			CajaCierreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajacierres=cajacierreDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCajaCierre(cajacierres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierres);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cajacierres = new  ArrayList<CajaCierre>();
		  		  
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
		cajacierres = new  ArrayList<CajaCierre>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaCierre.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CajaCierreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajacierres=cajacierreDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaCierre(cajacierres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierres);
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
		cajacierres = new  ArrayList<CajaCierre>();
		  		  
        try {
			CajaCierreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajacierres=cajacierreDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaCierre(cajacierres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierres);
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
		cajacierres = new  ArrayList<CajaCierre>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaCierre.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaCierreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajacierres=cajacierreDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajaCierre(cajacierres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierres);
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
		cajacierres = new  ArrayList<CajaCierre>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaCierreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajacierres=cajacierreDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajaCierre(cajacierres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierres);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cajacierre = new  CajaCierre();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaCierre.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaCierreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajacierre=cajacierreDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajaCierre(cajacierre);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierre);
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
		cajacierre = new  CajaCierre();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaCierreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajacierre=cajacierreDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajaCierre(cajacierre);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierre);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cajacierres = new  ArrayList<CajaCierre>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaCierre.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CajaCierreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajacierres=cajacierreDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaCierre(cajacierres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierres);
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
		cajacierres = new  ArrayList<CajaCierre>();
		  		  
        try {
			CajaCierreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajacierres=cajacierreDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaCierre(cajacierres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierres);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCajaCierresWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cajacierres = new  ArrayList<CajaCierre>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaCierre.class.getSimpleName()+"-getTodosCajaCierresWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaCierreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajacierres=cajacierreDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCajaCierre(cajacierres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierres);
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
	
	public  void  getTodosCajaCierres(String sFinalQuery,Pagination pagination)throws Exception {
		cajacierres = new  ArrayList<CajaCierre>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaCierreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajacierres=cajacierreDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCajaCierre(cajacierres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierres);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCajaCierre(CajaCierre cajacierre) throws Exception {
		Boolean estaValidado=false;
		
		if(cajacierre.getIsNew() || cajacierre.getIsChanged()) { 
			this.invalidValues = cajacierreValidator.getInvalidValues(cajacierre);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cajacierre);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCajaCierre(List<CajaCierre> CajaCierres) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CajaCierre cajacierreLocal:cajacierres) {				
			estaValidadoObjeto=this.validarGuardarCajaCierre(cajacierreLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCajaCierre(List<CajaCierre> CajaCierres) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCajaCierre(cajacierres)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCajaCierre(CajaCierre CajaCierre) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCajaCierre(cajacierre)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CajaCierre cajacierre) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cajacierre.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CajaCierreConstantesFunciones.getCajaCierreLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cajacierre","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CajaCierreConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CajaCierreConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCajaCierreWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaCierre.class.getSimpleName()+"-saveCajaCierreWithConnection");connexion.begin();			
			
			CajaCierreLogicAdditional.checkCajaCierreToSave(this.cajacierre,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CajaCierreLogicAdditional.updateCajaCierreToSave(this.cajacierre,this.arrDatoGeneral);
			
			CajaCierreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cajacierre,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCajaCierre();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCajaCierre(this.cajacierre)) {
				CajaCierreDataAccess.save(this.cajacierre, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cajacierre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CajaCierreLogicAdditional.checkCajaCierreToSaveAfter(this.cajacierre,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCajaCierre();
			
			connexion.commit();			
			
			if(this.cajacierre.getIsDeleted()) {
				this.cajacierre=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCajaCierre()throws Exception {	
		try {	
			
			CajaCierreLogicAdditional.checkCajaCierreToSave(this.cajacierre,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CajaCierreLogicAdditional.updateCajaCierreToSave(this.cajacierre,this.arrDatoGeneral);
			
			CajaCierreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cajacierre,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCajaCierre(this.cajacierre)) {			
				CajaCierreDataAccess.save(this.cajacierre, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cajacierre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CajaCierreLogicAdditional.checkCajaCierreToSaveAfter(this.cajacierre,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cajacierre.getIsDeleted()) {
				this.cajacierre=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCajaCierresWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaCierre.class.getSimpleName()+"-saveCajaCierresWithConnection");connexion.begin();			
			
			CajaCierreLogicAdditional.checkCajaCierreToSaves(cajacierres,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCajaCierres();
			
			Boolean validadoTodosCajaCierre=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CajaCierre cajacierreLocal:cajacierres) {		
				if(cajacierreLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CajaCierreLogicAdditional.updateCajaCierreToSave(cajacierreLocal,this.arrDatoGeneral);
	        	
				CajaCierreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cajacierreLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCajaCierre(cajacierreLocal)) {
					CajaCierreDataAccess.save(cajacierreLocal, connexion);				
				} else {
					validadoTodosCajaCierre=false;
				}
			}
			
			if(!validadoTodosCajaCierre) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CajaCierreLogicAdditional.checkCajaCierreToSavesAfter(cajacierres,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCajaCierres();
			
			connexion.commit();		
			
			this.quitarCajaCierresEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCajaCierres()throws Exception {				
		 try {	
			CajaCierreLogicAdditional.checkCajaCierreToSaves(cajacierres,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCajaCierre=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CajaCierre cajacierreLocal:cajacierres) {				
				if(cajacierreLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CajaCierreLogicAdditional.updateCajaCierreToSave(cajacierreLocal,this.arrDatoGeneral);
	        	
				CajaCierreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cajacierreLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCajaCierre(cajacierreLocal)) {				
					CajaCierreDataAccess.save(cajacierreLocal, connexion);				
				} else {
					validadoTodosCajaCierre=false;
				}
			}
			
			if(!validadoTodosCajaCierre) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CajaCierreLogicAdditional.checkCajaCierreToSavesAfter(cajacierres,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCajaCierresEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CajaCierreParameterReturnGeneral procesarAccionCajaCierres(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CajaCierre> cajacierres,CajaCierreParameterReturnGeneral cajacierreParameterGeneral)throws Exception {
		 try {	
			CajaCierreParameterReturnGeneral cajacierreReturnGeneral=new CajaCierreParameterReturnGeneral();
	
			CajaCierreLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cajacierres,cajacierreParameterGeneral,cajacierreReturnGeneral);
			
			return cajacierreReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CajaCierreParameterReturnGeneral procesarAccionCajaCierresWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CajaCierre> cajacierres,CajaCierreParameterReturnGeneral cajacierreParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaCierre.class.getSimpleName()+"-procesarAccionCajaCierresWithConnection");connexion.begin();			
			
			CajaCierreParameterReturnGeneral cajacierreReturnGeneral=new CajaCierreParameterReturnGeneral();
	
			CajaCierreLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cajacierres,cajacierreParameterGeneral,cajacierreReturnGeneral);
			
			this.connexion.commit();
			
			return cajacierreReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CajaCierreParameterReturnGeneral procesarEventosCajaCierres(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CajaCierre> cajacierres,CajaCierre cajacierre,CajaCierreParameterReturnGeneral cajacierreParameterGeneral,Boolean isEsNuevoCajaCierre,ArrayList<Classe> clases)throws Exception {
		 try {	
			CajaCierreParameterReturnGeneral cajacierreReturnGeneral=new CajaCierreParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cajacierreReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CajaCierreLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cajacierres,cajacierre,cajacierreParameterGeneral,cajacierreReturnGeneral,isEsNuevoCajaCierre,clases);
			
			return cajacierreReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CajaCierreParameterReturnGeneral procesarEventosCajaCierresWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CajaCierre> cajacierres,CajaCierre cajacierre,CajaCierreParameterReturnGeneral cajacierreParameterGeneral,Boolean isEsNuevoCajaCierre,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaCierre.class.getSimpleName()+"-procesarEventosCajaCierresWithConnection");connexion.begin();			
			
			CajaCierreParameterReturnGeneral cajacierreReturnGeneral=new CajaCierreParameterReturnGeneral();
	
			cajacierreReturnGeneral.setCajaCierre(cajacierre);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cajacierreReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CajaCierreLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cajacierres,cajacierre,cajacierreParameterGeneral,cajacierreReturnGeneral,isEsNuevoCajaCierre,clases);
			
			this.connexion.commit();
			
			return cajacierreReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CajaCierreParameterReturnGeneral procesarImportacionCajaCierresWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CajaCierreParameterReturnGeneral cajacierreParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaCierre.class.getSimpleName()+"-procesarImportacionCajaCierresWithConnection");connexion.begin();			
			
			CajaCierreParameterReturnGeneral cajacierreReturnGeneral=new CajaCierreParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cajacierres=new ArrayList<CajaCierre>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cajacierre=new CajaCierre();
				
				
				if(conColumnasBase) {this.cajacierre.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cajacierre.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.cajacierre.setfecha_cierre(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				//this.cajacierre.sethora_cierre(arrColumnas[iColumn++]);
				this.cajacierre.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.cajacierres.add(this.cajacierre);
			}
			
			this.saveCajaCierres();
			
			this.connexion.commit();
			
			cajacierreReturnGeneral.setConRetornoEstaProcesado(true);
			cajacierreReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cajacierreReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCajaCierresEliminados() throws Exception {				
		
		List<CajaCierre> cajacierresAux= new ArrayList<CajaCierre>();
		
		for(CajaCierre cajacierre:cajacierres) {
			if(!cajacierre.getIsDeleted()) {
				cajacierresAux.add(cajacierre);
			}
		}
		
		cajacierres=cajacierresAux;
	}
	
	public void quitarCajaCierresNulos() throws Exception {				
		
		List<CajaCierre> cajacierresAux= new ArrayList<CajaCierre>();
		
		for(CajaCierre cajacierre : this.cajacierres) {
			if(cajacierre==null) {
				cajacierresAux.add(cajacierre);
			}
		}
		
		//this.cajacierres=cajacierresAux;
		
		this.cajacierres.removeAll(cajacierresAux);
	}
	
	public void getSetVersionRowCajaCierreWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cajacierre.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cajacierre.getIsDeleted() || (cajacierre.getIsChanged()&&!cajacierre.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cajacierreDataAccess.getSetVersionRowCajaCierre(connexion,cajacierre.getId());
				
				if(!cajacierre.getVersionRow().equals(timestamp)) {	
					cajacierre.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cajacierre.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCajaCierre()throws Exception {	
		
		if(cajacierre.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cajacierre.getIsDeleted() || (cajacierre.getIsChanged()&&!cajacierre.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cajacierreDataAccess.getSetVersionRowCajaCierre(connexion,cajacierre.getId());
			
			try {							
				if(!cajacierre.getVersionRow().equals(timestamp)) {	
					cajacierre.setVersionRow(timestamp);
				}
				
				cajacierre.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCajaCierresWithConnection()throws Exception {	
		if(cajacierres!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CajaCierre cajacierreAux:cajacierres) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cajacierreAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cajacierreAux.getIsDeleted() || (cajacierreAux.getIsChanged()&&!cajacierreAux.getIsNew())) {
						
						timestamp=cajacierreDataAccess.getSetVersionRowCajaCierre(connexion,cajacierreAux.getId());
						
						if(!cajacierre.getVersionRow().equals(timestamp)) {	
							cajacierreAux.setVersionRow(timestamp);
						}
								
						cajacierreAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCajaCierres()throws Exception {	
		if(cajacierres!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CajaCierre cajacierreAux:cajacierres) {
					if(cajacierreAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cajacierreAux.getIsDeleted() || (cajacierreAux.getIsChanged()&&!cajacierreAux.getIsNew())) {
						
						timestamp=cajacierreDataAccess.getSetVersionRowCajaCierre(connexion,cajacierreAux.getId());
						
						if(!cajacierreAux.getVersionRow().equals(timestamp)) {	
							cajacierreAux.setVersionRow(timestamp);
						}
						
													
						cajacierreAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CajaCierreParameterReturnGeneral cargarCombosLoteForeignKeyCajaCierreWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCaja) throws Exception {
		CajaCierreParameterReturnGeneral  cajacierreReturnGeneral =new CajaCierreParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaCierre.class.getSimpleName()+"-cargarCombosLoteForeignKeyCajaCierreWithConnection");connexion.begin();
			
			cajacierreReturnGeneral =new CajaCierreParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cajacierreReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			cajacierreReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Caja> cajasForeignKey=new ArrayList<Caja>();
			CajaLogic cajaLogic=new CajaLogic();
			cajaLogic.setConnexion(this.connexion);
			cajaLogic.getCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCaja.equals("NONE")) {
				cajaLogic.getTodosCajas(finalQueryGlobalCaja,new Pagination());
				cajasForeignKey=cajaLogic.getCajas();
			}

			cajacierreReturnGeneral.setcajasForeignKey(cajasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cajacierreReturnGeneral;
	}
	
	public CajaCierreParameterReturnGeneral cargarCombosLoteForeignKeyCajaCierre(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCaja) throws Exception {
		CajaCierreParameterReturnGeneral  cajacierreReturnGeneral =new CajaCierreParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cajacierreReturnGeneral =new CajaCierreParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cajacierreReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			cajacierreReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Caja> cajasForeignKey=new ArrayList<Caja>();
			CajaLogic cajaLogic=new CajaLogic();
			cajaLogic.setConnexion(this.connexion);
			cajaLogic.getCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCaja.equals("NONE")) {
				cajaLogic.getTodosCajas(finalQueryGlobalCaja,new Pagination());
				cajasForeignKey=cajaLogic.getCajas();
			}

			cajacierreReturnGeneral.setcajasForeignKey(cajasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cajacierreReturnGeneral;
	}
	
	
	public void deepLoad(CajaCierre cajacierre,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CajaCierreLogicAdditional.updateCajaCierreToGet(cajacierre,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cajacierre.setEmpresa(cajacierreDataAccess.getEmpresa(connexion,cajacierre));
		cajacierre.setSucursal(cajacierreDataAccess.getSucursal(connexion,cajacierre));
		cajacierre.setCaja(cajacierreDataAccess.getCaja(connexion,cajacierre));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cajacierre.setEmpresa(cajacierreDataAccess.getEmpresa(connexion,cajacierre));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				cajacierre.setSucursal(cajacierreDataAccess.getSucursal(connexion,cajacierre));
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				cajacierre.setCaja(cajacierreDataAccess.getCaja(connexion,cajacierre));
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
			cajacierre.setEmpresa(cajacierreDataAccess.getEmpresa(connexion,cajacierre));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajacierre.setSucursal(cajacierreDataAccess.getSucursal(connexion,cajacierre));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajacierre.setCaja(cajacierreDataAccess.getCaja(connexion,cajacierre));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cajacierre.setEmpresa(cajacierreDataAccess.getEmpresa(connexion,cajacierre));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cajacierre.getEmpresa(),isDeep,deepLoadType,clases);
				
		cajacierre.setSucursal(cajacierreDataAccess.getSucursal(connexion,cajacierre));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cajacierre.getSucursal(),isDeep,deepLoadType,clases);
				
		cajacierre.setCaja(cajacierreDataAccess.getCaja(connexion,cajacierre));
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(cajacierre.getCaja(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cajacierre.setEmpresa(cajacierreDataAccess.getEmpresa(connexion,cajacierre));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cajacierre.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				cajacierre.setSucursal(cajacierreDataAccess.getSucursal(connexion,cajacierre));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(cajacierre.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				cajacierre.setCaja(cajacierreDataAccess.getCaja(connexion,cajacierre));
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepLoad(cajacierre.getCaja(),isDeep,deepLoadType,clases);				
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
			cajacierre.setEmpresa(cajacierreDataAccess.getEmpresa(connexion,cajacierre));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cajacierre.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajacierre.setSucursal(cajacierreDataAccess.getSucursal(connexion,cajacierre));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(cajacierre.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Caja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajacierre.setCaja(cajacierreDataAccess.getCaja(connexion,cajacierre));
			CajaLogic cajaLogic= new CajaLogic(connexion);
			cajaLogic.deepLoad(cajacierre.getCaja(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CajaCierre cajacierre,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CajaCierreLogicAdditional.updateCajaCierreToSave(cajacierre,this.arrDatoGeneral);
			
CajaCierreDataAccess.save(cajacierre, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cajacierre.getEmpresa(),connexion);

		SucursalDataAccess.save(cajacierre.getSucursal(),connexion);

		CajaDataAccess.save(cajacierre.getCaja(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cajacierre.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(cajacierre.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				CajaDataAccess.save(cajacierre.getCaja(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cajacierre.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cajacierre.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(cajacierre.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cajacierre.getSucursal(),isDeep,deepLoadType,clases);
				

		CajaDataAccess.save(cajacierre.getCaja(),connexion);
		CajaLogic cajaLogic= new CajaLogic(connexion);
		cajaLogic.deepLoad(cajacierre.getCaja(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cajacierre.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(cajacierre.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(cajacierre.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(cajacierre.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Caja.class)) {
				CajaDataAccess.save(cajacierre.getCaja(),connexion);
				CajaLogic cajaLogic= new CajaLogic(connexion);
				cajaLogic.deepSave(cajacierre.getCaja(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(CajaCierre.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cajacierre,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(cajacierre);
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
			this.deepLoad(this.cajacierre,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierre);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CajaCierre.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cajacierres!=null) {
				for(CajaCierre cajacierre:cajacierres) {
					this.deepLoad(cajacierre,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(cajacierres);
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
			if(cajacierres!=null) {
				for(CajaCierre cajacierre:cajacierres) {
					this.deepLoad(cajacierre,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(cajacierres);
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
			this.getNewConnexionToDeep(CajaCierre.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cajacierre,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CajaCierre.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cajacierres!=null) {
				for(CajaCierre cajacierre:cajacierres) {
					this.deepSave(cajacierre,isDeep,deepLoadType,clases);
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
			if(cajacierres!=null) {
				for(CajaCierre cajacierre:cajacierres) {
					this.deepSave(cajacierre,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCajaCierresFK_IdCajaWithConnection(String sFinalQuery,Pagination pagination,Long id_caja)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaCierre.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_caja,CajaCierreConstantesFunciones.IDCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCaja);

			CajaCierreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajacierres=cajacierreDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierres);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaCierresFK_IdCaja(String sFinalQuery,Pagination pagination,Long id_caja)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_caja,CajaCierreConstantesFunciones.IDCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCaja);

			CajaCierreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajacierres=cajacierreDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierres);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajaCierresFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaCierre.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CajaCierreConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CajaCierreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajacierres=cajacierreDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierres);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaCierresFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CajaCierreConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CajaCierreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajacierres=cajacierreDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierres);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajaCierresFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaCierre.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CajaCierreConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CajaCierreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajacierres=cajacierreDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierres);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaCierresFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CajaCierreConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CajaCierreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajacierres=cajacierreDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaCierreConstantesFunciones.refrescarForeignKeysDescripcionesCajaCierre(this.cajacierres);
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
			if(CajaCierreConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaCierreDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CajaCierre cajacierre,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CajaCierreConstantesFunciones.ISCONAUDITORIA) {
				if(cajacierre.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaCierreDataAccess.TABLENAME, cajacierre.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CajaCierreConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CajaCierreLogic.registrarAuditoriaDetallesCajaCierre(connexion,cajacierre,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cajacierre.getIsDeleted()) {
					/*if(!cajacierre.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CajaCierreDataAccess.TABLENAME, cajacierre.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CajaCierreLogic.registrarAuditoriaDetallesCajaCierre(connexion,cajacierre,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaCierreDataAccess.TABLENAME, cajacierre.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cajacierre.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaCierreDataAccess.TABLENAME, cajacierre.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CajaCierreConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CajaCierreLogic.registrarAuditoriaDetallesCajaCierre(connexion,cajacierre,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCajaCierre(Connexion connexion,CajaCierre cajacierre)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cajacierre.getIsNew()||!cajacierre.getid_empresa().equals(cajacierre.getCajaCierreOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajacierre.getCajaCierreOriginal().getid_empresa()!=null)
				{
					strValorActual=cajacierre.getCajaCierreOriginal().getid_empresa().toString();
				}
				if(cajacierre.getid_empresa()!=null)
				{
					strValorNuevo=cajacierre.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaCierreConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(cajacierre.getIsNew()||!cajacierre.getid_sucursal().equals(cajacierre.getCajaCierreOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajacierre.getCajaCierreOriginal().getid_sucursal()!=null)
				{
					strValorActual=cajacierre.getCajaCierreOriginal().getid_sucursal().toString();
				}
				if(cajacierre.getid_sucursal()!=null)
				{
					strValorNuevo=cajacierre.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaCierreConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(cajacierre.getIsNew()||!cajacierre.getid_caja().equals(cajacierre.getCajaCierreOriginal().getid_caja()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajacierre.getCajaCierreOriginal().getid_caja()!=null)
				{
					strValorActual=cajacierre.getCajaCierreOriginal().getid_caja().toString();
				}
				if(cajacierre.getid_caja()!=null)
				{
					strValorNuevo=cajacierre.getid_caja().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaCierreConstantesFunciones.IDCAJA,strValorActual,strValorNuevo);
			}	
			
			if(cajacierre.getIsNew()||!cajacierre.getfecha_cierre().equals(cajacierre.getCajaCierreOriginal().getfecha_cierre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajacierre.getCajaCierreOriginal().getfecha_cierre()!=null)
				{
					strValorActual=cajacierre.getCajaCierreOriginal().getfecha_cierre().toString();
				}
				if(cajacierre.getfecha_cierre()!=null)
				{
					strValorNuevo=cajacierre.getfecha_cierre().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaCierreConstantesFunciones.FECHACIERRE,strValorActual,strValorNuevo);
			}	
			
			if(cajacierre.getIsNew()||!cajacierre.gethora_cierre().equals(cajacierre.getCajaCierreOriginal().gethora_cierre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajacierre.getCajaCierreOriginal().gethora_cierre()!=null)
				{
					strValorActual=cajacierre.getCajaCierreOriginal().gethora_cierre().toString();
				}
				if(cajacierre.gethora_cierre()!=null)
				{
					strValorNuevo=cajacierre.gethora_cierre().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaCierreConstantesFunciones.HORACIERRE,strValorActual,strValorNuevo);
			}	
			
			if(cajacierre.getIsNew()||!cajacierre.getesta_activo().equals(cajacierre.getCajaCierreOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajacierre.getCajaCierreOriginal().getesta_activo()!=null)
				{
					strValorActual=cajacierre.getCajaCierreOriginal().getesta_activo().toString();
				}
				if(cajacierre.getesta_activo()!=null)
				{
					strValorNuevo=cajacierre.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaCierreConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCajaCierreRelacionesWithConnection(CajaCierre cajacierre) throws Exception {

		if(!cajacierre.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCajaCierreRelacionesBase(cajacierre,true);
		}
	}

	public void saveCajaCierreRelaciones(CajaCierre cajacierre)throws Exception {

		if(!cajacierre.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCajaCierreRelacionesBase(cajacierre,false);
		}
	}

	public void saveCajaCierreRelacionesBase(CajaCierre cajacierre,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CajaCierre-saveRelacionesWithConnection");}
	

			this.setCajaCierre(cajacierre);

			if(CajaCierreLogicAdditional.validarSaveRelaciones(cajacierre,this)) {

				CajaCierreLogicAdditional.updateRelacionesToSave(cajacierre,this);

				if((cajacierre.getIsNew()||cajacierre.getIsChanged())&&!cajacierre.getIsDeleted()) {
					this.saveCajaCierre();
					this.saveCajaCierreRelacionesDetalles();

				} else if(cajacierre.getIsDeleted()) {
					this.saveCajaCierreRelacionesDetalles();
					this.saveCajaCierre();
				}

				CajaCierreLogicAdditional.updateRelacionesToSaveAfter(cajacierre,this);

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
	
	
	private void saveCajaCierreRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCajaCierre(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CajaCierreConstantesFunciones.getClassesForeignKeysOfCajaCierre(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajaCierre(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CajaCierreConstantesFunciones.getClassesRelationshipsOfCajaCierre(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

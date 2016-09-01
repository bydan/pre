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
import com.bydan.erp.contabilidad.util.CuentaFlujoCajaConstantesFunciones;
import com.bydan.erp.contabilidad.util.CuentaFlujoCajaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.CuentaFlujoCajaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.CuentaFlujoCaja;
import com.bydan.erp.contabilidad.business.logic.CuentaFlujoCajaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class CuentaFlujoCajaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CuentaFlujoCajaLogic.class);
	
	protected CuentaFlujoCajaDataAccess cuentaflujocajaDataAccess; 	
	protected CuentaFlujoCaja cuentaflujocaja;
	protected List<CuentaFlujoCaja> cuentaflujocajas;
	protected Object cuentaflujocajaObject;	
	protected List<Object> cuentaflujocajasObject;
	
	public static ClassValidator<CuentaFlujoCaja> cuentaflujocajaValidator = new ClassValidator<CuentaFlujoCaja>(CuentaFlujoCaja.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CuentaFlujoCajaLogicAdditional cuentaflujocajaLogicAdditional=null;
	
	public CuentaFlujoCajaLogicAdditional getCuentaFlujoCajaLogicAdditional() {
		return this.cuentaflujocajaLogicAdditional;
	}
	
	public void setCuentaFlujoCajaLogicAdditional(CuentaFlujoCajaLogicAdditional cuentaflujocajaLogicAdditional) {
		try {
			this.cuentaflujocajaLogicAdditional=cuentaflujocajaLogicAdditional;
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
	
	
	
	
	public  CuentaFlujoCajaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cuentaflujocajaDataAccess = new CuentaFlujoCajaDataAccess();
			
			this.cuentaflujocajas= new ArrayList<CuentaFlujoCaja>();
			this.cuentaflujocaja= new CuentaFlujoCaja();
			
			this.cuentaflujocajaObject=new Object();
			this.cuentaflujocajasObject=new ArrayList<Object>();
				
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
			
			this.cuentaflujocajaDataAccess.setConnexionType(this.connexionType);
			this.cuentaflujocajaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CuentaFlujoCajaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cuentaflujocajaDataAccess = new CuentaFlujoCajaDataAccess();
			this.cuentaflujocajas= new ArrayList<CuentaFlujoCaja>();
			this.cuentaflujocaja= new CuentaFlujoCaja();
			this.cuentaflujocajaObject=new Object();
			this.cuentaflujocajasObject=new ArrayList<Object>();
			
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
			
			this.cuentaflujocajaDataAccess.setConnexionType(this.connexionType);
			this.cuentaflujocajaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CuentaFlujoCaja getCuentaFlujoCaja() throws Exception {	
		CuentaFlujoCajaLogicAdditional.checkCuentaFlujoCajaToGet(cuentaflujocaja,this.datosCliente,this.arrDatoGeneral);
		CuentaFlujoCajaLogicAdditional.updateCuentaFlujoCajaToGet(cuentaflujocaja,this.arrDatoGeneral);
		
		return cuentaflujocaja;
	}
		
	public void setCuentaFlujoCaja(CuentaFlujoCaja newCuentaFlujoCaja) {
		this.cuentaflujocaja = newCuentaFlujoCaja;
	}
	
	public CuentaFlujoCajaDataAccess getCuentaFlujoCajaDataAccess() {
		return cuentaflujocajaDataAccess;
	}
	
	public void setCuentaFlujoCajaDataAccess(CuentaFlujoCajaDataAccess newcuentaflujocajaDataAccess) {
		this.cuentaflujocajaDataAccess = newcuentaflujocajaDataAccess;
	}
	
	public List<CuentaFlujoCaja> getCuentaFlujoCajas() throws Exception {		
		this.quitarCuentaFlujoCajasNulos();
		
		CuentaFlujoCajaLogicAdditional.checkCuentaFlujoCajaToGets(cuentaflujocajas,this.datosCliente,this.arrDatoGeneral);
		
		for (CuentaFlujoCaja cuentaflujocajaLocal: cuentaflujocajas ) {
			CuentaFlujoCajaLogicAdditional.updateCuentaFlujoCajaToGet(cuentaflujocajaLocal,this.arrDatoGeneral);
		}
		
		return cuentaflujocajas;
	}
	
	public void setCuentaFlujoCajas(List<CuentaFlujoCaja> newCuentaFlujoCajas) {
		this.cuentaflujocajas = newCuentaFlujoCajas;
	}
	
	public Object getCuentaFlujoCajaObject() {	
		this.cuentaflujocajaObject=this.cuentaflujocajaDataAccess.getEntityObject();
		return this.cuentaflujocajaObject;
	}
		
	public void setCuentaFlujoCajaObject(Object newCuentaFlujoCajaObject) {
		this.cuentaflujocajaObject = newCuentaFlujoCajaObject;
	}
	
	public List<Object> getCuentaFlujoCajasObject() {		
		this.cuentaflujocajasObject=this.cuentaflujocajaDataAccess.getEntitiesObject();
		return this.cuentaflujocajasObject;
	}
		
	public void setCuentaFlujoCajasObject(List<Object> newCuentaFlujoCajasObject) {
		this.cuentaflujocajasObject = newCuentaFlujoCajasObject;
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
		
		if(this.cuentaflujocajaDataAccess!=null) {
			this.cuentaflujocajaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cuentaflujocajaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cuentaflujocajaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cuentaflujocaja = new  CuentaFlujoCaja();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cuentaflujocaja=cuentaflujocajaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocaja);
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
		cuentaflujocaja = new  CuentaFlujoCaja();
		  		  
        try {
			
			cuentaflujocaja=cuentaflujocajaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cuentaflujocaja = new  CuentaFlujoCaja();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cuentaflujocaja=cuentaflujocajaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocaja);
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
		cuentaflujocaja = new  CuentaFlujoCaja();
		  		  
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
		cuentaflujocaja = new  CuentaFlujoCaja();
		  		  
        try {
			
			cuentaflujocaja=cuentaflujocajaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cuentaflujocaja = new  CuentaFlujoCaja();
		  		  
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
		cuentaflujocaja = new  CuentaFlujoCaja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cuentaflujocajaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentaflujocaja = new  CuentaFlujoCaja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cuentaflujocajaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cuentaflujocaja = new  CuentaFlujoCaja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cuentaflujocajaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentaflujocaja = new  CuentaFlujoCaja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cuentaflujocajaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cuentaflujocaja = new  CuentaFlujoCaja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cuentaflujocajaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentaflujocaja = new  CuentaFlujoCaja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cuentaflujocajaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cuentaflujocajas = new  ArrayList<CuentaFlujoCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaflujocajas=cuentaflujocajaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaFlujoCaja(cuentaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocajas);
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
		cuentaflujocajas = new  ArrayList<CuentaFlujoCaja>();
		  		  
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
		cuentaflujocajas = new  ArrayList<CuentaFlujoCaja>();
		  		  
        try {			
			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaflujocajas=cuentaflujocajaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCuentaFlujoCaja(cuentaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocajas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cuentaflujocajas = new  ArrayList<CuentaFlujoCaja>();
		  		  
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
		cuentaflujocajas = new  ArrayList<CuentaFlujoCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaflujocajas=cuentaflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaFlujoCaja(cuentaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocajas);
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
		cuentaflujocajas = new  ArrayList<CuentaFlujoCaja>();
		  		  
        try {
			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaflujocajas=cuentaflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaFlujoCaja(cuentaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocajas);
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
		cuentaflujocajas = new  ArrayList<CuentaFlujoCaja>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaflujocajas=cuentaflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaFlujoCaja(cuentaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocajas);
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
		cuentaflujocajas = new  ArrayList<CuentaFlujoCaja>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaflujocajas=cuentaflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaFlujoCaja(cuentaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocajas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cuentaflujocaja = new  CuentaFlujoCaja();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaflujocaja=cuentaflujocajaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaFlujoCaja(cuentaflujocaja);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocaja);
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
		cuentaflujocaja = new  CuentaFlujoCaja();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaflujocaja=cuentaflujocajaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaFlujoCaja(cuentaflujocaja);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cuentaflujocajas = new  ArrayList<CuentaFlujoCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaflujocajas=cuentaflujocajaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaFlujoCaja(cuentaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocajas);
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
		cuentaflujocajas = new  ArrayList<CuentaFlujoCaja>();
		  		  
        try {
			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaflujocajas=cuentaflujocajaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaFlujoCaja(cuentaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocajas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCuentaFlujoCajasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cuentaflujocajas = new  ArrayList<CuentaFlujoCaja>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-getTodosCuentaFlujoCajasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaflujocajas=cuentaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCuentaFlujoCaja(cuentaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocajas);
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
	
	public  void  getTodosCuentaFlujoCajas(String sFinalQuery,Pagination pagination)throws Exception {
		cuentaflujocajas = new  ArrayList<CuentaFlujoCaja>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaflujocajas=cuentaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCuentaFlujoCaja(cuentaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocajas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCuentaFlujoCaja(CuentaFlujoCaja cuentaflujocaja) throws Exception {
		Boolean estaValidado=false;
		
		if(cuentaflujocaja.getIsNew() || cuentaflujocaja.getIsChanged()) { 
			this.invalidValues = cuentaflujocajaValidator.getInvalidValues(cuentaflujocaja);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cuentaflujocaja);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCuentaFlujoCaja(List<CuentaFlujoCaja> CuentaFlujoCajas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CuentaFlujoCaja cuentaflujocajaLocal:cuentaflujocajas) {				
			estaValidadoObjeto=this.validarGuardarCuentaFlujoCaja(cuentaflujocajaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCuentaFlujoCaja(List<CuentaFlujoCaja> CuentaFlujoCajas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCuentaFlujoCaja(cuentaflujocajas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCuentaFlujoCaja(CuentaFlujoCaja CuentaFlujoCaja) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCuentaFlujoCaja(cuentaflujocaja)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CuentaFlujoCaja cuentaflujocaja) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cuentaflujocaja.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CuentaFlujoCajaConstantesFunciones.getCuentaFlujoCajaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cuentaflujocaja","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CuentaFlujoCajaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CuentaFlujoCajaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCuentaFlujoCajaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-saveCuentaFlujoCajaWithConnection");connexion.begin();			
			
			CuentaFlujoCajaLogicAdditional.checkCuentaFlujoCajaToSave(this.cuentaflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CuentaFlujoCajaLogicAdditional.updateCuentaFlujoCajaToSave(this.cuentaflujocaja,this.arrDatoGeneral);
			
			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cuentaflujocaja,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCuentaFlujoCaja();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCuentaFlujoCaja(this.cuentaflujocaja)) {
				CuentaFlujoCajaDataAccess.save(this.cuentaflujocaja, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cuentaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CuentaFlujoCajaLogicAdditional.checkCuentaFlujoCajaToSaveAfter(this.cuentaflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCuentaFlujoCaja();
			
			connexion.commit();			
			
			if(this.cuentaflujocaja.getIsDeleted()) {
				this.cuentaflujocaja=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCuentaFlujoCaja()throws Exception {	
		try {	
			
			CuentaFlujoCajaLogicAdditional.checkCuentaFlujoCajaToSave(this.cuentaflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CuentaFlujoCajaLogicAdditional.updateCuentaFlujoCajaToSave(this.cuentaflujocaja,this.arrDatoGeneral);
			
			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cuentaflujocaja,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCuentaFlujoCaja(this.cuentaflujocaja)) {			
				CuentaFlujoCajaDataAccess.save(this.cuentaflujocaja, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cuentaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CuentaFlujoCajaLogicAdditional.checkCuentaFlujoCajaToSaveAfter(this.cuentaflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cuentaflujocaja.getIsDeleted()) {
				this.cuentaflujocaja=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCuentaFlujoCajasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-saveCuentaFlujoCajasWithConnection");connexion.begin();			
			
			CuentaFlujoCajaLogicAdditional.checkCuentaFlujoCajaToSaves(cuentaflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCuentaFlujoCajas();
			
			Boolean validadoTodosCuentaFlujoCaja=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CuentaFlujoCaja cuentaflujocajaLocal:cuentaflujocajas) {		
				if(cuentaflujocajaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CuentaFlujoCajaLogicAdditional.updateCuentaFlujoCajaToSave(cuentaflujocajaLocal,this.arrDatoGeneral);
	        	
				CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cuentaflujocajaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCuentaFlujoCaja(cuentaflujocajaLocal)) {
					CuentaFlujoCajaDataAccess.save(cuentaflujocajaLocal, connexion);				
				} else {
					validadoTodosCuentaFlujoCaja=false;
				}
			}
			
			if(!validadoTodosCuentaFlujoCaja) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CuentaFlujoCajaLogicAdditional.checkCuentaFlujoCajaToSavesAfter(cuentaflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCuentaFlujoCajas();
			
			connexion.commit();		
			
			this.quitarCuentaFlujoCajasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCuentaFlujoCajas()throws Exception {				
		 try {	
			CuentaFlujoCajaLogicAdditional.checkCuentaFlujoCajaToSaves(cuentaflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCuentaFlujoCaja=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CuentaFlujoCaja cuentaflujocajaLocal:cuentaflujocajas) {				
				if(cuentaflujocajaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CuentaFlujoCajaLogicAdditional.updateCuentaFlujoCajaToSave(cuentaflujocajaLocal,this.arrDatoGeneral);
	        	
				CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cuentaflujocajaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCuentaFlujoCaja(cuentaflujocajaLocal)) {				
					CuentaFlujoCajaDataAccess.save(cuentaflujocajaLocal, connexion);				
				} else {
					validadoTodosCuentaFlujoCaja=false;
				}
			}
			
			if(!validadoTodosCuentaFlujoCaja) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CuentaFlujoCajaLogicAdditional.checkCuentaFlujoCajaToSavesAfter(cuentaflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCuentaFlujoCajasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CuentaFlujoCajaParameterReturnGeneral procesarAccionCuentaFlujoCajas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CuentaFlujoCaja> cuentaflujocajas,CuentaFlujoCajaParameterReturnGeneral cuentaflujocajaParameterGeneral)throws Exception {
		 try {	
			CuentaFlujoCajaParameterReturnGeneral cuentaflujocajaReturnGeneral=new CuentaFlujoCajaParameterReturnGeneral();
	
			CuentaFlujoCajaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cuentaflujocajas,cuentaflujocajaParameterGeneral,cuentaflujocajaReturnGeneral);
			
			return cuentaflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CuentaFlujoCajaParameterReturnGeneral procesarAccionCuentaFlujoCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CuentaFlujoCaja> cuentaflujocajas,CuentaFlujoCajaParameterReturnGeneral cuentaflujocajaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-procesarAccionCuentaFlujoCajasWithConnection");connexion.begin();			
			
			CuentaFlujoCajaParameterReturnGeneral cuentaflujocajaReturnGeneral=new CuentaFlujoCajaParameterReturnGeneral();
	
			CuentaFlujoCajaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cuentaflujocajas,cuentaflujocajaParameterGeneral,cuentaflujocajaReturnGeneral);
			
			this.connexion.commit();
			
			return cuentaflujocajaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CuentaFlujoCajaParameterReturnGeneral procesarEventosCuentaFlujoCajas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CuentaFlujoCaja> cuentaflujocajas,CuentaFlujoCaja cuentaflujocaja,CuentaFlujoCajaParameterReturnGeneral cuentaflujocajaParameterGeneral,Boolean isEsNuevoCuentaFlujoCaja,ArrayList<Classe> clases)throws Exception {
		 try {	
			CuentaFlujoCajaParameterReturnGeneral cuentaflujocajaReturnGeneral=new CuentaFlujoCajaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cuentaflujocajaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CuentaFlujoCajaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cuentaflujocajas,cuentaflujocaja,cuentaflujocajaParameterGeneral,cuentaflujocajaReturnGeneral,isEsNuevoCuentaFlujoCaja,clases);
			
			return cuentaflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CuentaFlujoCajaParameterReturnGeneral procesarEventosCuentaFlujoCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CuentaFlujoCaja> cuentaflujocajas,CuentaFlujoCaja cuentaflujocaja,CuentaFlujoCajaParameterReturnGeneral cuentaflujocajaParameterGeneral,Boolean isEsNuevoCuentaFlujoCaja,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-procesarEventosCuentaFlujoCajasWithConnection");connexion.begin();			
			
			CuentaFlujoCajaParameterReturnGeneral cuentaflujocajaReturnGeneral=new CuentaFlujoCajaParameterReturnGeneral();
	
			cuentaflujocajaReturnGeneral.setCuentaFlujoCaja(cuentaflujocaja);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cuentaflujocajaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CuentaFlujoCajaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cuentaflujocajas,cuentaflujocaja,cuentaflujocajaParameterGeneral,cuentaflujocajaReturnGeneral,isEsNuevoCuentaFlujoCaja,clases);
			
			this.connexion.commit();
			
			return cuentaflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CuentaFlujoCajaParameterReturnGeneral procesarImportacionCuentaFlujoCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CuentaFlujoCajaParameterReturnGeneral cuentaflujocajaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-procesarImportacionCuentaFlujoCajasWithConnection");connexion.begin();			
			
			CuentaFlujoCajaParameterReturnGeneral cuentaflujocajaReturnGeneral=new CuentaFlujoCajaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cuentaflujocajas=new ArrayList<CuentaFlujoCaja>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cuentaflujocaja=new CuentaFlujoCaja();
				
				
				if(conColumnasBase) {this.cuentaflujocaja.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cuentaflujocaja.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.cuentaflujocaja.setnombre(arrColumnas[iColumn++]);
			this.cuentaflujocaja.setformula(arrColumnas[iColumn++]);
				this.cuentaflujocaja.setes_flujo_caja(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.cuentaflujocaja.setcon_agrupar(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.cuentaflujocajas.add(this.cuentaflujocaja);
			}
			
			this.saveCuentaFlujoCajas();
			
			this.connexion.commit();
			
			cuentaflujocajaReturnGeneral.setConRetornoEstaProcesado(true);
			cuentaflujocajaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cuentaflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCuentaFlujoCajasEliminados() throws Exception {				
		
		List<CuentaFlujoCaja> cuentaflujocajasAux= new ArrayList<CuentaFlujoCaja>();
		
		for(CuentaFlujoCaja cuentaflujocaja:cuentaflujocajas) {
			if(!cuentaflujocaja.getIsDeleted()) {
				cuentaflujocajasAux.add(cuentaflujocaja);
			}
		}
		
		cuentaflujocajas=cuentaflujocajasAux;
	}
	
	public void quitarCuentaFlujoCajasNulos() throws Exception {				
		
		List<CuentaFlujoCaja> cuentaflujocajasAux= new ArrayList<CuentaFlujoCaja>();
		
		for(CuentaFlujoCaja cuentaflujocaja : this.cuentaflujocajas) {
			if(cuentaflujocaja==null) {
				cuentaflujocajasAux.add(cuentaflujocaja);
			}
		}
		
		//this.cuentaflujocajas=cuentaflujocajasAux;
		
		this.cuentaflujocajas.removeAll(cuentaflujocajasAux);
	}
	
	public void getSetVersionRowCuentaFlujoCajaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cuentaflujocaja.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cuentaflujocaja.getIsDeleted() || (cuentaflujocaja.getIsChanged()&&!cuentaflujocaja.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cuentaflujocajaDataAccess.getSetVersionRowCuentaFlujoCaja(connexion,cuentaflujocaja.getId());
				
				if(!cuentaflujocaja.getVersionRow().equals(timestamp)) {	
					cuentaflujocaja.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cuentaflujocaja.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCuentaFlujoCaja()throws Exception {	
		
		if(cuentaflujocaja.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cuentaflujocaja.getIsDeleted() || (cuentaflujocaja.getIsChanged()&&!cuentaflujocaja.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cuentaflujocajaDataAccess.getSetVersionRowCuentaFlujoCaja(connexion,cuentaflujocaja.getId());
			
			try {							
				if(!cuentaflujocaja.getVersionRow().equals(timestamp)) {	
					cuentaflujocaja.setVersionRow(timestamp);
				}
				
				cuentaflujocaja.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCuentaFlujoCajasWithConnection()throws Exception {	
		if(cuentaflujocajas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CuentaFlujoCaja cuentaflujocajaAux:cuentaflujocajas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cuentaflujocajaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cuentaflujocajaAux.getIsDeleted() || (cuentaflujocajaAux.getIsChanged()&&!cuentaflujocajaAux.getIsNew())) {
						
						timestamp=cuentaflujocajaDataAccess.getSetVersionRowCuentaFlujoCaja(connexion,cuentaflujocajaAux.getId());
						
						if(!cuentaflujocaja.getVersionRow().equals(timestamp)) {	
							cuentaflujocajaAux.setVersionRow(timestamp);
						}
								
						cuentaflujocajaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCuentaFlujoCajas()throws Exception {	
		if(cuentaflujocajas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CuentaFlujoCaja cuentaflujocajaAux:cuentaflujocajas) {
					if(cuentaflujocajaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cuentaflujocajaAux.getIsDeleted() || (cuentaflujocajaAux.getIsChanged()&&!cuentaflujocajaAux.getIsNew())) {
						
						timestamp=cuentaflujocajaDataAccess.getSetVersionRowCuentaFlujoCaja(connexion,cuentaflujocajaAux.getId());
						
						if(!cuentaflujocajaAux.getVersionRow().equals(timestamp)) {	
							cuentaflujocajaAux.setVersionRow(timestamp);
						}
						
													
						cuentaflujocajaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CuentaFlujoCajaParameterReturnGeneral cargarCombosLoteForeignKeyCuentaFlujoCajaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalMes,String finalQueryGlobalDia,String finalQueryGlobalCuentaContable) throws Exception {
		CuentaFlujoCajaParameterReturnGeneral  cuentaflujocajaReturnGeneral =new CuentaFlujoCajaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-cargarCombosLoteForeignKeyCuentaFlujoCajaWithConnection");connexion.begin();
			
			cuentaflujocajaReturnGeneral =new CuentaFlujoCajaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cuentaflujocajaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			cuentaflujocajaReturnGeneral.setmessForeignKey(messForeignKey);


			List<Dia> diasForeignKey=new ArrayList<Dia>();
			DiaLogic diaLogic=new DiaLogic();
			diaLogic.setConnexion(this.connexion);
			diaLogic.getDiaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDia.equals("NONE")) {
				diaLogic.getTodosDias(finalQueryGlobalDia,new Pagination());
				diasForeignKey=diaLogic.getDias();
			}

			cuentaflujocajaReturnGeneral.setdiasForeignKey(diasForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			cuentaflujocajaReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cuentaflujocajaReturnGeneral;
	}
	
	public CuentaFlujoCajaParameterReturnGeneral cargarCombosLoteForeignKeyCuentaFlujoCaja(String finalQueryGlobalEmpresa,String finalQueryGlobalMes,String finalQueryGlobalDia,String finalQueryGlobalCuentaContable) throws Exception {
		CuentaFlujoCajaParameterReturnGeneral  cuentaflujocajaReturnGeneral =new CuentaFlujoCajaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cuentaflujocajaReturnGeneral =new CuentaFlujoCajaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cuentaflujocajaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			cuentaflujocajaReturnGeneral.setmessForeignKey(messForeignKey);


			List<Dia> diasForeignKey=new ArrayList<Dia>();
			DiaLogic diaLogic=new DiaLogic();
			diaLogic.setConnexion(this.connexion);
			diaLogic.getDiaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDia.equals("NONE")) {
				diaLogic.getTodosDias(finalQueryGlobalDia,new Pagination());
				diasForeignKey=diaLogic.getDias();
			}

			cuentaflujocajaReturnGeneral.setdiasForeignKey(diasForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			cuentaflujocajaReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cuentaflujocajaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyCuentaFlujoCajaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleCuentaFlujoCajaLogic detallecuentaflujocajaLogic=new DetalleCuentaFlujoCajaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyCuentaFlujoCajaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleCuentaFlujoCaja.class));
											
			

			detallecuentaflujocajaLogic.setConnexion(this.getConnexion());
			detallecuentaflujocajaLogic.setDatosCliente(this.datosCliente);
			detallecuentaflujocajaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(CuentaFlujoCaja cuentaflujocaja:this.cuentaflujocajas) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleCuentaFlujoCajaConstantesFunciones.getClassesForeignKeysOfDetalleCuentaFlujoCaja(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallecuentaflujocajaLogic.setDetalleCuentaFlujoCajas(cuentaflujocaja.detallecuentaflujocajas);
				detallecuentaflujocajaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(CuentaFlujoCaja cuentaflujocaja,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CuentaFlujoCajaLogicAdditional.updateCuentaFlujoCajaToGet(cuentaflujocaja,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cuentaflujocaja.setEmpresa(cuentaflujocajaDataAccess.getEmpresa(connexion,cuentaflujocaja));
		cuentaflujocaja.setMes(cuentaflujocajaDataAccess.getMes(connexion,cuentaflujocaja));
		cuentaflujocaja.setDia(cuentaflujocajaDataAccess.getDia(connexion,cuentaflujocaja));
		cuentaflujocaja.setCuentaContable(cuentaflujocajaDataAccess.getCuentaContable(connexion,cuentaflujocaja));
		cuentaflujocaja.setDetalleCuentaFlujoCajas(cuentaflujocajaDataAccess.getDetalleCuentaFlujoCajas(connexion,cuentaflujocaja));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cuentaflujocaja.setEmpresa(cuentaflujocajaDataAccess.getEmpresa(connexion,cuentaflujocaja));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				cuentaflujocaja.setMes(cuentaflujocajaDataAccess.getMes(connexion,cuentaflujocaja));
				continue;
			}

			if(clas.clas.equals(Dia.class)) {
				cuentaflujocaja.setDia(cuentaflujocajaDataAccess.getDia(connexion,cuentaflujocaja));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentaflujocaja.setCuentaContable(cuentaflujocajaDataAccess.getCuentaContable(connexion,cuentaflujocaja));
				continue;
			}

			if(clas.clas.equals(DetalleCuentaFlujoCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cuentaflujocaja.setDetalleCuentaFlujoCajas(cuentaflujocajaDataAccess.getDetalleCuentaFlujoCajas(connexion,cuentaflujocaja));

				if(this.isConDeep) {
					DetalleCuentaFlujoCajaLogic detallecuentaflujocajaLogic= new DetalleCuentaFlujoCajaLogic(this.connexion);
					detallecuentaflujocajaLogic.setDetalleCuentaFlujoCajas(cuentaflujocaja.getDetalleCuentaFlujoCajas());
					ArrayList<Classe> classesLocal=DetalleCuentaFlujoCajaConstantesFunciones.getClassesForeignKeysOfDetalleCuentaFlujoCaja(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallecuentaflujocajaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleCuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCuentaFlujoCaja(detallecuentaflujocajaLogic.getDetalleCuentaFlujoCajas());
					cuentaflujocaja.setDetalleCuentaFlujoCajas(detallecuentaflujocajaLogic.getDetalleCuentaFlujoCajas());
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
			cuentaflujocaja.setEmpresa(cuentaflujocajaDataAccess.getEmpresa(connexion,cuentaflujocaja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaflujocaja.setMes(cuentaflujocajaDataAccess.getMes(connexion,cuentaflujocaja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Dia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaflujocaja.setDia(cuentaflujocajaDataAccess.getDia(connexion,cuentaflujocaja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaflujocaja.setCuentaContable(cuentaflujocajaDataAccess.getCuentaContable(connexion,cuentaflujocaja));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleCuentaFlujoCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleCuentaFlujoCaja.class));
			cuentaflujocaja.setDetalleCuentaFlujoCajas(cuentaflujocajaDataAccess.getDetalleCuentaFlujoCajas(connexion,cuentaflujocaja));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cuentaflujocaja.setEmpresa(cuentaflujocajaDataAccess.getEmpresa(connexion,cuentaflujocaja));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cuentaflujocaja.getEmpresa(),isDeep,deepLoadType,clases);
				
		cuentaflujocaja.setMes(cuentaflujocajaDataAccess.getMes(connexion,cuentaflujocaja));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(cuentaflujocaja.getMes(),isDeep,deepLoadType,clases);
				
		cuentaflujocaja.setDia(cuentaflujocajaDataAccess.getDia(connexion,cuentaflujocaja));
		DiaLogic diaLogic= new DiaLogic(connexion);
		diaLogic.deepLoad(cuentaflujocaja.getDia(),isDeep,deepLoadType,clases);
				
		cuentaflujocaja.setCuentaContable(cuentaflujocajaDataAccess.getCuentaContable(connexion,cuentaflujocaja));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(cuentaflujocaja.getCuentaContable(),isDeep,deepLoadType,clases);
				

		cuentaflujocaja.setDetalleCuentaFlujoCajas(cuentaflujocajaDataAccess.getDetalleCuentaFlujoCajas(connexion,cuentaflujocaja));

		for(DetalleCuentaFlujoCaja detallecuentaflujocaja:cuentaflujocaja.getDetalleCuentaFlujoCajas()) {
			DetalleCuentaFlujoCajaLogic detallecuentaflujocajaLogic= new DetalleCuentaFlujoCajaLogic(connexion);
			detallecuentaflujocajaLogic.deepLoad(detallecuentaflujocaja,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cuentaflujocaja.setEmpresa(cuentaflujocajaDataAccess.getEmpresa(connexion,cuentaflujocaja));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cuentaflujocaja.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				cuentaflujocaja.setMes(cuentaflujocajaDataAccess.getMes(connexion,cuentaflujocaja));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(cuentaflujocaja.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Dia.class)) {
				cuentaflujocaja.setDia(cuentaflujocajaDataAccess.getDia(connexion,cuentaflujocaja));
				DiaLogic diaLogic= new DiaLogic(connexion);
				diaLogic.deepLoad(cuentaflujocaja.getDia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentaflujocaja.setCuentaContable(cuentaflujocajaDataAccess.getCuentaContable(connexion,cuentaflujocaja));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentaflujocaja.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleCuentaFlujoCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cuentaflujocaja.setDetalleCuentaFlujoCajas(cuentaflujocajaDataAccess.getDetalleCuentaFlujoCajas(connexion,cuentaflujocaja));

				for(DetalleCuentaFlujoCaja detallecuentaflujocaja:cuentaflujocaja.getDetalleCuentaFlujoCajas()) {
					DetalleCuentaFlujoCajaLogic detallecuentaflujocajaLogic= new DetalleCuentaFlujoCajaLogic(connexion);
					detallecuentaflujocajaLogic.deepLoad(detallecuentaflujocaja,isDeep,deepLoadType,clases);
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
			cuentaflujocaja.setEmpresa(cuentaflujocajaDataAccess.getEmpresa(connexion,cuentaflujocaja));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cuentaflujocaja.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaflujocaja.setMes(cuentaflujocajaDataAccess.getMes(connexion,cuentaflujocaja));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(cuentaflujocaja.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Dia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaflujocaja.setDia(cuentaflujocajaDataAccess.getDia(connexion,cuentaflujocaja));
			DiaLogic diaLogic= new DiaLogic(connexion);
			diaLogic.deepLoad(cuentaflujocaja.getDia(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaflujocaja.setCuentaContable(cuentaflujocajaDataAccess.getCuentaContable(connexion,cuentaflujocaja));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentaflujocaja.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleCuentaFlujoCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleCuentaFlujoCaja.class));
			cuentaflujocaja.setDetalleCuentaFlujoCajas(cuentaflujocajaDataAccess.getDetalleCuentaFlujoCajas(connexion,cuentaflujocaja));

			for(DetalleCuentaFlujoCaja detallecuentaflujocaja:cuentaflujocaja.getDetalleCuentaFlujoCajas()) {
				DetalleCuentaFlujoCajaLogic detallecuentaflujocajaLogic= new DetalleCuentaFlujoCajaLogic(connexion);
				detallecuentaflujocajaLogic.deepLoad(detallecuentaflujocaja,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CuentaFlujoCaja cuentaflujocaja,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CuentaFlujoCajaLogicAdditional.updateCuentaFlujoCajaToSave(cuentaflujocaja,this.arrDatoGeneral);
			
CuentaFlujoCajaDataAccess.save(cuentaflujocaja, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cuentaflujocaja.getEmpresa(),connexion);

		MesDataAccess.save(cuentaflujocaja.getMes(),connexion);

		DiaDataAccess.save(cuentaflujocaja.getDia(),connexion);

		CuentaContableDataAccess.save(cuentaflujocaja.getCuentaContable(),connexion);

		for(DetalleCuentaFlujoCaja detallecuentaflujocaja:cuentaflujocaja.getDetalleCuentaFlujoCajas()) {
			detallecuentaflujocaja.setid_cuenta_flujo_caja(cuentaflujocaja.getId());
			DetalleCuentaFlujoCajaDataAccess.save(detallecuentaflujocaja,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cuentaflujocaja.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(cuentaflujocaja.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Dia.class)) {
				DiaDataAccess.save(cuentaflujocaja.getDia(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentaflujocaja.getCuentaContable(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleCuentaFlujoCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleCuentaFlujoCaja detallecuentaflujocaja:cuentaflujocaja.getDetalleCuentaFlujoCajas()) {
					detallecuentaflujocaja.setid_cuenta_flujo_caja(cuentaflujocaja.getId());
					DetalleCuentaFlujoCajaDataAccess.save(detallecuentaflujocaja,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cuentaflujocaja.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cuentaflujocaja.getEmpresa(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(cuentaflujocaja.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(cuentaflujocaja.getMes(),isDeep,deepLoadType,clases);
				

		DiaDataAccess.save(cuentaflujocaja.getDia(),connexion);
		DiaLogic diaLogic= new DiaLogic(connexion);
		diaLogic.deepLoad(cuentaflujocaja.getDia(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cuentaflujocaja.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(cuentaflujocaja.getCuentaContable(),isDeep,deepLoadType,clases);
				

		for(DetalleCuentaFlujoCaja detallecuentaflujocaja:cuentaflujocaja.getDetalleCuentaFlujoCajas()) {
			DetalleCuentaFlujoCajaLogic detallecuentaflujocajaLogic= new DetalleCuentaFlujoCajaLogic(connexion);
			detallecuentaflujocaja.setid_cuenta_flujo_caja(cuentaflujocaja.getId());
			DetalleCuentaFlujoCajaDataAccess.save(detallecuentaflujocaja,connexion);
			detallecuentaflujocajaLogic.deepSave(detallecuentaflujocaja,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cuentaflujocaja.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(cuentaflujocaja.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(cuentaflujocaja.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(cuentaflujocaja.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Dia.class)) {
				DiaDataAccess.save(cuentaflujocaja.getDia(),connexion);
				DiaLogic diaLogic= new DiaLogic(connexion);
				diaLogic.deepSave(cuentaflujocaja.getDia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentaflujocaja.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentaflujocaja.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleCuentaFlujoCaja.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleCuentaFlujoCaja detallecuentaflujocaja:cuentaflujocaja.getDetalleCuentaFlujoCajas()) {
					DetalleCuentaFlujoCajaLogic detallecuentaflujocajaLogic= new DetalleCuentaFlujoCajaLogic(connexion);
					detallecuentaflujocaja.setid_cuenta_flujo_caja(cuentaflujocaja.getId());
					DetalleCuentaFlujoCajaDataAccess.save(detallecuentaflujocaja,connexion);
					detallecuentaflujocajaLogic.deepSave(detallecuentaflujocaja,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(CuentaFlujoCaja.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cuentaflujocaja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(cuentaflujocaja);
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
			this.deepLoad(this.cuentaflujocaja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CuentaFlujoCaja.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cuentaflujocajas!=null) {
				for(CuentaFlujoCaja cuentaflujocaja:cuentaflujocajas) {
					this.deepLoad(cuentaflujocaja,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(cuentaflujocajas);
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
			if(cuentaflujocajas!=null) {
				for(CuentaFlujoCaja cuentaflujocaja:cuentaflujocajas) {
					this.deepLoad(cuentaflujocaja,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(cuentaflujocajas);
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
			this.getNewConnexionToDeep(CuentaFlujoCaja.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cuentaflujocaja,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CuentaFlujoCaja.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cuentaflujocajas!=null) {
				for(CuentaFlujoCaja cuentaflujocaja:cuentaflujocajas) {
					this.deepSave(cuentaflujocaja,isDeep,deepLoadType,clases);
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
			if(cuentaflujocajas!=null) {
				for(CuentaFlujoCaja cuentaflujocaja:cuentaflujocajas) {
					this.deepSave(cuentaflujocaja,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCuentaFlujoCajasBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",CuentaFlujoCajaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaflujocajas=cuentaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaFlujoCajasBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",CuentaFlujoCajaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaflujocajas=cuentaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaFlujoCajasFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,CuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaflujocajas=cuentaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaFlujoCajasFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,CuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaflujocajas=cuentaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaFlujoCajasFK_IdDiaWithConnection(String sFinalQuery,Pagination pagination,Long id_dia)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_dia,CuentaFlujoCajaConstantesFunciones.IDDIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDia);

			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaflujocajas=cuentaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaFlujoCajasFK_IdDia(String sFinalQuery,Pagination pagination,Long id_dia)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_dia,CuentaFlujoCajaConstantesFunciones.IDDIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDia);

			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaflujocajas=cuentaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaFlujoCajasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CuentaFlujoCajaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaflujocajas=cuentaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaFlujoCajasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CuentaFlujoCajaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaflujocajas=cuentaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaFlujoCajasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,CuentaFlujoCajaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaflujocajas=cuentaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaFlujoCajasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,CuentaFlujoCajaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			CuentaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaflujocajas=cuentaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesCuentaFlujoCaja(this.cuentaflujocajas);
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
			if(CuentaFlujoCajaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaFlujoCajaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CuentaFlujoCaja cuentaflujocaja,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CuentaFlujoCajaConstantesFunciones.ISCONAUDITORIA) {
				if(cuentaflujocaja.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaFlujoCajaDataAccess.TABLENAME, cuentaflujocaja.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CuentaFlujoCajaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CuentaFlujoCajaLogic.registrarAuditoriaDetallesCuentaFlujoCaja(connexion,cuentaflujocaja,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cuentaflujocaja.getIsDeleted()) {
					/*if(!cuentaflujocaja.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CuentaFlujoCajaDataAccess.TABLENAME, cuentaflujocaja.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CuentaFlujoCajaLogic.registrarAuditoriaDetallesCuentaFlujoCaja(connexion,cuentaflujocaja,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaFlujoCajaDataAccess.TABLENAME, cuentaflujocaja.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cuentaflujocaja.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaFlujoCajaDataAccess.TABLENAME, cuentaflujocaja.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CuentaFlujoCajaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CuentaFlujoCajaLogic.registrarAuditoriaDetallesCuentaFlujoCaja(connexion,cuentaflujocaja,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCuentaFlujoCaja(Connexion connexion,CuentaFlujoCaja cuentaflujocaja)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cuentaflujocaja.getIsNew()||!cuentaflujocaja.getid_empresa().equals(cuentaflujocaja.getCuentaFlujoCajaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaflujocaja.getCuentaFlujoCajaOriginal().getid_empresa()!=null)
				{
					strValorActual=cuentaflujocaja.getCuentaFlujoCajaOriginal().getid_empresa().toString();
				}
				if(cuentaflujocaja.getid_empresa()!=null)
				{
					strValorNuevo=cuentaflujocaja.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaFlujoCajaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(cuentaflujocaja.getIsNew()||!cuentaflujocaja.getnombre().equals(cuentaflujocaja.getCuentaFlujoCajaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaflujocaja.getCuentaFlujoCajaOriginal().getnombre()!=null)
				{
					strValorActual=cuentaflujocaja.getCuentaFlujoCajaOriginal().getnombre();
				}
				if(cuentaflujocaja.getnombre()!=null)
				{
					strValorNuevo=cuentaflujocaja.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaFlujoCajaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(cuentaflujocaja.getIsNew()||!cuentaflujocaja.getid_mes().equals(cuentaflujocaja.getCuentaFlujoCajaOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaflujocaja.getCuentaFlujoCajaOriginal().getid_mes()!=null)
				{
					strValorActual=cuentaflujocaja.getCuentaFlujoCajaOriginal().getid_mes().toString();
				}
				if(cuentaflujocaja.getid_mes()!=null)
				{
					strValorNuevo=cuentaflujocaja.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaFlujoCajaConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(cuentaflujocaja.getIsNew()||!cuentaflujocaja.getid_dia().equals(cuentaflujocaja.getCuentaFlujoCajaOriginal().getid_dia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaflujocaja.getCuentaFlujoCajaOriginal().getid_dia()!=null)
				{
					strValorActual=cuentaflujocaja.getCuentaFlujoCajaOriginal().getid_dia().toString();
				}
				if(cuentaflujocaja.getid_dia()!=null)
				{
					strValorNuevo=cuentaflujocaja.getid_dia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaFlujoCajaConstantesFunciones.IDDIA,strValorActual,strValorNuevo);
			}	
			
			if(cuentaflujocaja.getIsNew()||!cuentaflujocaja.getid_cuenta_contable().equals(cuentaflujocaja.getCuentaFlujoCajaOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaflujocaja.getCuentaFlujoCajaOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=cuentaflujocaja.getCuentaFlujoCajaOriginal().getid_cuenta_contable().toString();
				}
				if(cuentaflujocaja.getid_cuenta_contable()!=null)
				{
					strValorNuevo=cuentaflujocaja.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(cuentaflujocaja.getIsNew()||!cuentaflujocaja.getformula().equals(cuentaflujocaja.getCuentaFlujoCajaOriginal().getformula()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaflujocaja.getCuentaFlujoCajaOriginal().getformula()!=null)
				{
					strValorActual=cuentaflujocaja.getCuentaFlujoCajaOriginal().getformula();
				}
				if(cuentaflujocaja.getformula()!=null)
				{
					strValorNuevo=cuentaflujocaja.getformula() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaFlujoCajaConstantesFunciones.FORMULA,strValorActual,strValorNuevo);
			}	
			
			if(cuentaflujocaja.getIsNew()||!cuentaflujocaja.getes_flujo_caja().equals(cuentaflujocaja.getCuentaFlujoCajaOriginal().getes_flujo_caja()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaflujocaja.getCuentaFlujoCajaOriginal().getes_flujo_caja()!=null)
				{
					strValorActual=cuentaflujocaja.getCuentaFlujoCajaOriginal().getes_flujo_caja().toString();
				}
				if(cuentaflujocaja.getes_flujo_caja()!=null)
				{
					strValorNuevo=cuentaflujocaja.getes_flujo_caja().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaFlujoCajaConstantesFunciones.ESFLUJOCAJA,strValorActual,strValorNuevo);
			}	
			
			if(cuentaflujocaja.getIsNew()||!cuentaflujocaja.getcon_agrupar().equals(cuentaflujocaja.getCuentaFlujoCajaOriginal().getcon_agrupar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaflujocaja.getCuentaFlujoCajaOriginal().getcon_agrupar()!=null)
				{
					strValorActual=cuentaflujocaja.getCuentaFlujoCajaOriginal().getcon_agrupar().toString();
				}
				if(cuentaflujocaja.getcon_agrupar()!=null)
				{
					strValorNuevo=cuentaflujocaja.getcon_agrupar().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaFlujoCajaConstantesFunciones.CONAGRUPAR,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCuentaFlujoCajaRelacionesWithConnection(CuentaFlujoCaja cuentaflujocaja,List<DetalleCuentaFlujoCaja> detallecuentaflujocajas) throws Exception {

		if(!cuentaflujocaja.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCuentaFlujoCajaRelacionesBase(cuentaflujocaja,detallecuentaflujocajas,true);
		}
	}

	public void saveCuentaFlujoCajaRelaciones(CuentaFlujoCaja cuentaflujocaja,List<DetalleCuentaFlujoCaja> detallecuentaflujocajas)throws Exception {

		if(!cuentaflujocaja.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCuentaFlujoCajaRelacionesBase(cuentaflujocaja,detallecuentaflujocajas,false);
		}
	}

	public void saveCuentaFlujoCajaRelacionesBase(CuentaFlujoCaja cuentaflujocaja,List<DetalleCuentaFlujoCaja> detallecuentaflujocajas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CuentaFlujoCaja-saveRelacionesWithConnection");}
	
			cuentaflujocaja.setDetalleCuentaFlujoCajas(detallecuentaflujocajas);

			this.setCuentaFlujoCaja(cuentaflujocaja);

			if(CuentaFlujoCajaLogicAdditional.validarSaveRelaciones(cuentaflujocaja,this)) {

				CuentaFlujoCajaLogicAdditional.updateRelacionesToSave(cuentaflujocaja,this);

				if((cuentaflujocaja.getIsNew()||cuentaflujocaja.getIsChanged())&&!cuentaflujocaja.getIsDeleted()) {
					this.saveCuentaFlujoCaja();
					this.saveCuentaFlujoCajaRelacionesDetalles(detallecuentaflujocajas);

				} else if(cuentaflujocaja.getIsDeleted()) {
					this.saveCuentaFlujoCajaRelacionesDetalles(detallecuentaflujocajas);
					this.saveCuentaFlujoCaja();
				}

				CuentaFlujoCajaLogicAdditional.updateRelacionesToSaveAfter(cuentaflujocaja,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleCuentaFlujoCajaConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleCuentaFlujoCajas(detallecuentaflujocajas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveCuentaFlujoCajaRelacionesDetalles(List<DetalleCuentaFlujoCaja> detallecuentaflujocajas)throws Exception {
		try {
	

			Long idCuentaFlujoCajaActual=this.getCuentaFlujoCaja().getId();

			DetalleCuentaFlujoCajaLogic detallecuentaflujocajaLogic_Desde_CuentaFlujoCaja=new DetalleCuentaFlujoCajaLogic();
			detallecuentaflujocajaLogic_Desde_CuentaFlujoCaja.setDetalleCuentaFlujoCajas(detallecuentaflujocajas);

			detallecuentaflujocajaLogic_Desde_CuentaFlujoCaja.setConnexion(this.getConnexion());
			detallecuentaflujocajaLogic_Desde_CuentaFlujoCaja.setDatosCliente(this.datosCliente);

			for(DetalleCuentaFlujoCaja detallecuentaflujocaja_Desde_CuentaFlujoCaja:detallecuentaflujocajaLogic_Desde_CuentaFlujoCaja.getDetalleCuentaFlujoCajas()) {
				detallecuentaflujocaja_Desde_CuentaFlujoCaja.setid_cuenta_flujo_caja(idCuentaFlujoCajaActual);
			}

			detallecuentaflujocajaLogic_Desde_CuentaFlujoCaja.saveDetalleCuentaFlujoCajas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCuentaFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CuentaFlujoCajaConstantesFunciones.getClassesForeignKeysOfCuentaFlujoCaja(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CuentaFlujoCajaConstantesFunciones.getClassesRelationshipsOfCuentaFlujoCaja(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

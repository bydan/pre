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
import com.bydan.erp.cartera.util.CuentaPorCobrarConstantesFunciones;
import com.bydan.erp.cartera.util.CuentaPorCobrarParameterReturnGeneral;
//import com.bydan.erp.cartera.util.CuentaPorCobrarParameterGeneral;
import com.bydan.erp.cartera.business.entity.CuentaPorCobrar;
import com.bydan.erp.cartera.business.logic.CuentaPorCobrarLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class CuentaPorCobrarLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CuentaPorCobrarLogic.class);
	
	protected CuentaPorCobrarDataAccess cuentaporcobrarDataAccess; 	
	protected CuentaPorCobrar cuentaporcobrar;
	protected List<CuentaPorCobrar> cuentaporcobrars;
	protected Object cuentaporcobrarObject;	
	protected List<Object> cuentaporcobrarsObject;
	
	public static ClassValidator<CuentaPorCobrar> cuentaporcobrarValidator = new ClassValidator<CuentaPorCobrar>(CuentaPorCobrar.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CuentaPorCobrarLogicAdditional cuentaporcobrarLogicAdditional=null;
	
	public CuentaPorCobrarLogicAdditional getCuentaPorCobrarLogicAdditional() {
		return this.cuentaporcobrarLogicAdditional;
	}
	
	public void setCuentaPorCobrarLogicAdditional(CuentaPorCobrarLogicAdditional cuentaporcobrarLogicAdditional) {
		try {
			this.cuentaporcobrarLogicAdditional=cuentaporcobrarLogicAdditional;
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
	
	
	
	
	public  CuentaPorCobrarLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cuentaporcobrarDataAccess = new CuentaPorCobrarDataAccess();
			
			this.cuentaporcobrars= new ArrayList<CuentaPorCobrar>();
			this.cuentaporcobrar= new CuentaPorCobrar();
			
			this.cuentaporcobrarObject=new Object();
			this.cuentaporcobrarsObject=new ArrayList<Object>();
				
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
			
			this.cuentaporcobrarDataAccess.setConnexionType(this.connexionType);
			this.cuentaporcobrarDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CuentaPorCobrarLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cuentaporcobrarDataAccess = new CuentaPorCobrarDataAccess();
			this.cuentaporcobrars= new ArrayList<CuentaPorCobrar>();
			this.cuentaporcobrar= new CuentaPorCobrar();
			this.cuentaporcobrarObject=new Object();
			this.cuentaporcobrarsObject=new ArrayList<Object>();
			
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
			
			this.cuentaporcobrarDataAccess.setConnexionType(this.connexionType);
			this.cuentaporcobrarDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CuentaPorCobrar getCuentaPorCobrar() throws Exception {	
		CuentaPorCobrarLogicAdditional.checkCuentaPorCobrarToGet(cuentaporcobrar,this.datosCliente,this.arrDatoGeneral);
		CuentaPorCobrarLogicAdditional.updateCuentaPorCobrarToGet(cuentaporcobrar,this.arrDatoGeneral);
		
		return cuentaporcobrar;
	}
		
	public void setCuentaPorCobrar(CuentaPorCobrar newCuentaPorCobrar) {
		this.cuentaporcobrar = newCuentaPorCobrar;
	}
	
	public CuentaPorCobrarDataAccess getCuentaPorCobrarDataAccess() {
		return cuentaporcobrarDataAccess;
	}
	
	public void setCuentaPorCobrarDataAccess(CuentaPorCobrarDataAccess newcuentaporcobrarDataAccess) {
		this.cuentaporcobrarDataAccess = newcuentaporcobrarDataAccess;
	}
	
	public List<CuentaPorCobrar> getCuentaPorCobrars() throws Exception {		
		this.quitarCuentaPorCobrarsNulos();
		
		CuentaPorCobrarLogicAdditional.checkCuentaPorCobrarToGets(cuentaporcobrars,this.datosCliente,this.arrDatoGeneral);
		
		for (CuentaPorCobrar cuentaporcobrarLocal: cuentaporcobrars ) {
			CuentaPorCobrarLogicAdditional.updateCuentaPorCobrarToGet(cuentaporcobrarLocal,this.arrDatoGeneral);
		}
		
		return cuentaporcobrars;
	}
	
	public void setCuentaPorCobrars(List<CuentaPorCobrar> newCuentaPorCobrars) {
		this.cuentaporcobrars = newCuentaPorCobrars;
	}
	
	public Object getCuentaPorCobrarObject() {	
		this.cuentaporcobrarObject=this.cuentaporcobrarDataAccess.getEntityObject();
		return this.cuentaporcobrarObject;
	}
		
	public void setCuentaPorCobrarObject(Object newCuentaPorCobrarObject) {
		this.cuentaporcobrarObject = newCuentaPorCobrarObject;
	}
	
	public List<Object> getCuentaPorCobrarsObject() {		
		this.cuentaporcobrarsObject=this.cuentaporcobrarDataAccess.getEntitiesObject();
		return this.cuentaporcobrarsObject;
	}
		
	public void setCuentaPorCobrarsObject(List<Object> newCuentaPorCobrarsObject) {
		this.cuentaporcobrarsObject = newCuentaPorCobrarsObject;
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
		
		if(this.cuentaporcobrarDataAccess!=null) {
			this.cuentaporcobrarDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cuentaporcobrarDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cuentaporcobrarDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cuentaporcobrar = new  CuentaPorCobrar();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cuentaporcobrar=cuentaporcobrarDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentaporcobrar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrar);
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
		cuentaporcobrar = new  CuentaPorCobrar();
		  		  
        try {
			
			cuentaporcobrar=cuentaporcobrarDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentaporcobrar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrar);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cuentaporcobrar = new  CuentaPorCobrar();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cuentaporcobrar=cuentaporcobrarDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentaporcobrar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrar);
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
		cuentaporcobrar = new  CuentaPorCobrar();
		  		  
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
		cuentaporcobrar = new  CuentaPorCobrar();
		  		  
        try {
			
			cuentaporcobrar=cuentaporcobrarDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentaporcobrar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrar);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cuentaporcobrar = new  CuentaPorCobrar();
		  		  
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
		cuentaporcobrar = new  CuentaPorCobrar();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cuentaporcobrarDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentaporcobrar = new  CuentaPorCobrar();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cuentaporcobrarDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cuentaporcobrar = new  CuentaPorCobrar();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cuentaporcobrarDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentaporcobrar = new  CuentaPorCobrar();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cuentaporcobrarDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cuentaporcobrar = new  CuentaPorCobrar();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cuentaporcobrarDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentaporcobrar = new  CuentaPorCobrar();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cuentaporcobrarDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cuentaporcobrars = new  ArrayList<CuentaPorCobrar>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaPorCobrar(cuentaporcobrars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
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
		cuentaporcobrars = new  ArrayList<CuentaPorCobrar>();
		  		  
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
		cuentaporcobrars = new  ArrayList<CuentaPorCobrar>();
		  		  
        try {			
			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCuentaPorCobrar(cuentaporcobrars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cuentaporcobrars = new  ArrayList<CuentaPorCobrar>();
		  		  
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
		cuentaporcobrars = new  ArrayList<CuentaPorCobrar>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaPorCobrar(cuentaporcobrars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
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
		cuentaporcobrars = new  ArrayList<CuentaPorCobrar>();
		  		  
        try {
			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaPorCobrar(cuentaporcobrars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
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
		cuentaporcobrars = new  ArrayList<CuentaPorCobrar>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaPorCobrar(cuentaporcobrars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
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
		cuentaporcobrars = new  ArrayList<CuentaPorCobrar>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaPorCobrar(cuentaporcobrars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cuentaporcobrar = new  CuentaPorCobrar();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaporcobrar=cuentaporcobrarDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaPorCobrar(cuentaporcobrar);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrar);
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
		cuentaporcobrar = new  CuentaPorCobrar();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaporcobrar=cuentaporcobrarDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaPorCobrar(cuentaporcobrar);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrar);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cuentaporcobrars = new  ArrayList<CuentaPorCobrar>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaporcobrars=cuentaporcobrarDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaPorCobrar(cuentaporcobrars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
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
		cuentaporcobrars = new  ArrayList<CuentaPorCobrar>();
		  		  
        try {
			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaporcobrars=cuentaporcobrarDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaPorCobrar(cuentaporcobrars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCuentaPorCobrarsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cuentaporcobrars = new  ArrayList<CuentaPorCobrar>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-getTodosCuentaPorCobrarsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCuentaPorCobrar(cuentaporcobrars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
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
	
	public  void  getTodosCuentaPorCobrars(String sFinalQuery,Pagination pagination)throws Exception {
		cuentaporcobrars = new  ArrayList<CuentaPorCobrar>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCuentaPorCobrar(cuentaporcobrars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCuentaPorCobrar(CuentaPorCobrar cuentaporcobrar) throws Exception {
		Boolean estaValidado=false;
		
		if(cuentaporcobrar.getIsNew() || cuentaporcobrar.getIsChanged()) { 
			this.invalidValues = cuentaporcobrarValidator.getInvalidValues(cuentaporcobrar);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cuentaporcobrar);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCuentaPorCobrar(List<CuentaPorCobrar> CuentaPorCobrars) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CuentaPorCobrar cuentaporcobrarLocal:cuentaporcobrars) {				
			estaValidadoObjeto=this.validarGuardarCuentaPorCobrar(cuentaporcobrarLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCuentaPorCobrar(List<CuentaPorCobrar> CuentaPorCobrars) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCuentaPorCobrar(cuentaporcobrars)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCuentaPorCobrar(CuentaPorCobrar CuentaPorCobrar) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCuentaPorCobrar(cuentaporcobrar)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CuentaPorCobrar cuentaporcobrar) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cuentaporcobrar.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CuentaPorCobrarConstantesFunciones.getCuentaPorCobrarLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cuentaporcobrar","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CuentaPorCobrarConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CuentaPorCobrarConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCuentaPorCobrarWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-saveCuentaPorCobrarWithConnection");connexion.begin();			
			
			CuentaPorCobrarLogicAdditional.checkCuentaPorCobrarToSave(this.cuentaporcobrar,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CuentaPorCobrarLogicAdditional.updateCuentaPorCobrarToSave(this.cuentaporcobrar,this.arrDatoGeneral);
			
			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cuentaporcobrar,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCuentaPorCobrar();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCuentaPorCobrar(this.cuentaporcobrar)) {
				CuentaPorCobrarDataAccess.save(this.cuentaporcobrar, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cuentaporcobrar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CuentaPorCobrarLogicAdditional.checkCuentaPorCobrarToSaveAfter(this.cuentaporcobrar,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCuentaPorCobrar();
			
			connexion.commit();			
			
			if(this.cuentaporcobrar.getIsDeleted()) {
				this.cuentaporcobrar=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCuentaPorCobrar()throws Exception {	
		try {	
			
			CuentaPorCobrarLogicAdditional.checkCuentaPorCobrarToSave(this.cuentaporcobrar,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CuentaPorCobrarLogicAdditional.updateCuentaPorCobrarToSave(this.cuentaporcobrar,this.arrDatoGeneral);
			
			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cuentaporcobrar,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCuentaPorCobrar(this.cuentaporcobrar)) {			
				CuentaPorCobrarDataAccess.save(this.cuentaporcobrar, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cuentaporcobrar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CuentaPorCobrarLogicAdditional.checkCuentaPorCobrarToSaveAfter(this.cuentaporcobrar,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cuentaporcobrar.getIsDeleted()) {
				this.cuentaporcobrar=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCuentaPorCobrarsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-saveCuentaPorCobrarsWithConnection");connexion.begin();			
			
			CuentaPorCobrarLogicAdditional.checkCuentaPorCobrarToSaves(cuentaporcobrars,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCuentaPorCobrars();
			
			Boolean validadoTodosCuentaPorCobrar=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CuentaPorCobrar cuentaporcobrarLocal:cuentaporcobrars) {		
				if(cuentaporcobrarLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CuentaPorCobrarLogicAdditional.updateCuentaPorCobrarToSave(cuentaporcobrarLocal,this.arrDatoGeneral);
	        	
				CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cuentaporcobrarLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCuentaPorCobrar(cuentaporcobrarLocal)) {
					CuentaPorCobrarDataAccess.save(cuentaporcobrarLocal, connexion);				
				} else {
					validadoTodosCuentaPorCobrar=false;
				}
			}
			
			if(!validadoTodosCuentaPorCobrar) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CuentaPorCobrarLogicAdditional.checkCuentaPorCobrarToSavesAfter(cuentaporcobrars,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCuentaPorCobrars();
			
			connexion.commit();		
			
			this.quitarCuentaPorCobrarsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCuentaPorCobrars()throws Exception {				
		 try {	
			CuentaPorCobrarLogicAdditional.checkCuentaPorCobrarToSaves(cuentaporcobrars,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCuentaPorCobrar=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CuentaPorCobrar cuentaporcobrarLocal:cuentaporcobrars) {				
				if(cuentaporcobrarLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CuentaPorCobrarLogicAdditional.updateCuentaPorCobrarToSave(cuentaporcobrarLocal,this.arrDatoGeneral);
	        	
				CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cuentaporcobrarLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCuentaPorCobrar(cuentaporcobrarLocal)) {				
					CuentaPorCobrarDataAccess.save(cuentaporcobrarLocal, connexion);				
				} else {
					validadoTodosCuentaPorCobrar=false;
				}
			}
			
			if(!validadoTodosCuentaPorCobrar) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CuentaPorCobrarLogicAdditional.checkCuentaPorCobrarToSavesAfter(cuentaporcobrars,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCuentaPorCobrarsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CuentaPorCobrarParameterReturnGeneral procesarAccionCuentaPorCobrars(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CuentaPorCobrar> cuentaporcobrars,CuentaPorCobrarParameterReturnGeneral cuentaporcobrarParameterGeneral)throws Exception {
		 try {	
			CuentaPorCobrarParameterReturnGeneral cuentaporcobrarReturnGeneral=new CuentaPorCobrarParameterReturnGeneral();
	
			CuentaPorCobrarLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cuentaporcobrars,cuentaporcobrarParameterGeneral,cuentaporcobrarReturnGeneral);
			
			return cuentaporcobrarReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CuentaPorCobrarParameterReturnGeneral procesarAccionCuentaPorCobrarsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CuentaPorCobrar> cuentaporcobrars,CuentaPorCobrarParameterReturnGeneral cuentaporcobrarParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-procesarAccionCuentaPorCobrarsWithConnection");connexion.begin();			
			
			CuentaPorCobrarParameterReturnGeneral cuentaporcobrarReturnGeneral=new CuentaPorCobrarParameterReturnGeneral();
	
			CuentaPorCobrarLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cuentaporcobrars,cuentaporcobrarParameterGeneral,cuentaporcobrarReturnGeneral);
			
			this.connexion.commit();
			
			return cuentaporcobrarReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CuentaPorCobrarParameterReturnGeneral procesarEventosCuentaPorCobrars(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CuentaPorCobrar> cuentaporcobrars,CuentaPorCobrar cuentaporcobrar,CuentaPorCobrarParameterReturnGeneral cuentaporcobrarParameterGeneral,Boolean isEsNuevoCuentaPorCobrar,ArrayList<Classe> clases)throws Exception {
		 try {	
			CuentaPorCobrarParameterReturnGeneral cuentaporcobrarReturnGeneral=new CuentaPorCobrarParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cuentaporcobrarReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CuentaPorCobrarLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cuentaporcobrars,cuentaporcobrar,cuentaporcobrarParameterGeneral,cuentaporcobrarReturnGeneral,isEsNuevoCuentaPorCobrar,clases);
			
			return cuentaporcobrarReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CuentaPorCobrarParameterReturnGeneral procesarEventosCuentaPorCobrarsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CuentaPorCobrar> cuentaporcobrars,CuentaPorCobrar cuentaporcobrar,CuentaPorCobrarParameterReturnGeneral cuentaporcobrarParameterGeneral,Boolean isEsNuevoCuentaPorCobrar,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-procesarEventosCuentaPorCobrarsWithConnection");connexion.begin();			
			
			CuentaPorCobrarParameterReturnGeneral cuentaporcobrarReturnGeneral=new CuentaPorCobrarParameterReturnGeneral();
	
			cuentaporcobrarReturnGeneral.setCuentaPorCobrar(cuentaporcobrar);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cuentaporcobrarReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CuentaPorCobrarLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cuentaporcobrars,cuentaporcobrar,cuentaporcobrarParameterGeneral,cuentaporcobrarReturnGeneral,isEsNuevoCuentaPorCobrar,clases);
			
			this.connexion.commit();
			
			return cuentaporcobrarReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CuentaPorCobrarParameterReturnGeneral procesarImportacionCuentaPorCobrarsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CuentaPorCobrarParameterReturnGeneral cuentaporcobrarParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-procesarImportacionCuentaPorCobrarsWithConnection");connexion.begin();			
			
			CuentaPorCobrarParameterReturnGeneral cuentaporcobrarReturnGeneral=new CuentaPorCobrarParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cuentaporcobrars=new ArrayList<CuentaPorCobrar>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cuentaporcobrar=new CuentaPorCobrar();
				
				
				if(conColumnasBase) {this.cuentaporcobrar.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cuentaporcobrar.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.cuentaporcobrar.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.cuentaporcobrar.setmonto(Double.parseDouble(arrColumnas[iColumn++]));
				this.cuentaporcobrar.setnumero_comprobante(arrColumnas[iColumn++]);
				this.cuentaporcobrar.setdebito(Double.parseDouble(arrColumnas[iColumn++]));
				this.cuentaporcobrar.setcredito(Double.parseDouble(arrColumnas[iColumn++]));
			this.cuentaporcobrar.setdetalle(arrColumnas[iColumn++]);
				
				this.cuentaporcobrars.add(this.cuentaporcobrar);
			}
			
			this.saveCuentaPorCobrars();
			
			this.connexion.commit();
			
			cuentaporcobrarReturnGeneral.setConRetornoEstaProcesado(true);
			cuentaporcobrarReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cuentaporcobrarReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCuentaPorCobrarsEliminados() throws Exception {				
		
		List<CuentaPorCobrar> cuentaporcobrarsAux= new ArrayList<CuentaPorCobrar>();
		
		for(CuentaPorCobrar cuentaporcobrar:cuentaporcobrars) {
			if(!cuentaporcobrar.getIsDeleted()) {
				cuentaporcobrarsAux.add(cuentaporcobrar);
			}
		}
		
		cuentaporcobrars=cuentaporcobrarsAux;
	}
	
	public void quitarCuentaPorCobrarsNulos() throws Exception {				
		
		List<CuentaPorCobrar> cuentaporcobrarsAux= new ArrayList<CuentaPorCobrar>();
		
		for(CuentaPorCobrar cuentaporcobrar : this.cuentaporcobrars) {
			if(cuentaporcobrar==null) {
				cuentaporcobrarsAux.add(cuentaporcobrar);
			}
		}
		
		//this.cuentaporcobrars=cuentaporcobrarsAux;
		
		this.cuentaporcobrars.removeAll(cuentaporcobrarsAux);
	}
	
	public void getSetVersionRowCuentaPorCobrarWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cuentaporcobrar.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cuentaporcobrar.getIsDeleted() || (cuentaporcobrar.getIsChanged()&&!cuentaporcobrar.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cuentaporcobrarDataAccess.getSetVersionRowCuentaPorCobrar(connexion,cuentaporcobrar.getId());
				
				if(!cuentaporcobrar.getVersionRow().equals(timestamp)) {	
					cuentaporcobrar.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cuentaporcobrar.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCuentaPorCobrar()throws Exception {	
		
		if(cuentaporcobrar.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cuentaporcobrar.getIsDeleted() || (cuentaporcobrar.getIsChanged()&&!cuentaporcobrar.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cuentaporcobrarDataAccess.getSetVersionRowCuentaPorCobrar(connexion,cuentaporcobrar.getId());
			
			try {							
				if(!cuentaporcobrar.getVersionRow().equals(timestamp)) {	
					cuentaporcobrar.setVersionRow(timestamp);
				}
				
				cuentaporcobrar.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCuentaPorCobrarsWithConnection()throws Exception {	
		if(cuentaporcobrars!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CuentaPorCobrar cuentaporcobrarAux:cuentaporcobrars) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cuentaporcobrarAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cuentaporcobrarAux.getIsDeleted() || (cuentaporcobrarAux.getIsChanged()&&!cuentaporcobrarAux.getIsNew())) {
						
						timestamp=cuentaporcobrarDataAccess.getSetVersionRowCuentaPorCobrar(connexion,cuentaporcobrarAux.getId());
						
						if(!cuentaporcobrar.getVersionRow().equals(timestamp)) {	
							cuentaporcobrarAux.setVersionRow(timestamp);
						}
								
						cuentaporcobrarAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCuentaPorCobrars()throws Exception {	
		if(cuentaporcobrars!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CuentaPorCobrar cuentaporcobrarAux:cuentaporcobrars) {
					if(cuentaporcobrarAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cuentaporcobrarAux.getIsDeleted() || (cuentaporcobrarAux.getIsChanged()&&!cuentaporcobrarAux.getIsNew())) {
						
						timestamp=cuentaporcobrarDataAccess.getSetVersionRowCuentaPorCobrar(connexion,cuentaporcobrarAux.getId());
						
						if(!cuentaporcobrarAux.getVersionRow().equals(timestamp)) {	
							cuentaporcobrarAux.setVersionRow(timestamp);
						}
						
													
						cuentaporcobrarAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CuentaPorCobrarParameterReturnGeneral cargarCombosLoteForeignKeyCuentaPorCobrarWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalEjercicio,String finalQueryGlobalMoneda,String finalQueryGlobalCliente,String finalQueryGlobalTransaccion,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalAsientoContable,String finalQueryGlobalFactura) throws Exception {
		CuentaPorCobrarParameterReturnGeneral  cuentaporcobrarReturnGeneral =new CuentaPorCobrarParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-cargarCombosLoteForeignKeyCuentaPorCobrarWithConnection");connexion.begin();
			
			cuentaporcobrarReturnGeneral =new CuentaPorCobrarParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cuentaporcobrarReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			cuentaporcobrarReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			cuentaporcobrarReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			cuentaporcobrarReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			cuentaporcobrarReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			cuentaporcobrarReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			cuentaporcobrarReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			cuentaporcobrarReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			cuentaporcobrarReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			cuentaporcobrarReturnGeneral.setfacturasForeignKey(facturasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cuentaporcobrarReturnGeneral;
	}
	
	public CuentaPorCobrarParameterReturnGeneral cargarCombosLoteForeignKeyCuentaPorCobrar(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalEjercicio,String finalQueryGlobalMoneda,String finalQueryGlobalCliente,String finalQueryGlobalTransaccion,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalAsientoContable,String finalQueryGlobalFactura) throws Exception {
		CuentaPorCobrarParameterReturnGeneral  cuentaporcobrarReturnGeneral =new CuentaPorCobrarParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cuentaporcobrarReturnGeneral =new CuentaPorCobrarParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cuentaporcobrarReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			cuentaporcobrarReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			cuentaporcobrarReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			cuentaporcobrarReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			cuentaporcobrarReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			cuentaporcobrarReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			cuentaporcobrarReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			cuentaporcobrarReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			cuentaporcobrarReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			cuentaporcobrarReturnGeneral.setfacturasForeignKey(facturasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cuentaporcobrarReturnGeneral;
	}
	
	
	public void deepLoad(CuentaPorCobrar cuentaporcobrar,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CuentaPorCobrarLogicAdditional.updateCuentaPorCobrarToGet(cuentaporcobrar,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cuentaporcobrar.setEmpresa(cuentaporcobrarDataAccess.getEmpresa(connexion,cuentaporcobrar));
		cuentaporcobrar.setSucursal(cuentaporcobrarDataAccess.getSucursal(connexion,cuentaporcobrar));
		cuentaporcobrar.setModulo(cuentaporcobrarDataAccess.getModulo(connexion,cuentaporcobrar));
		cuentaporcobrar.setEjercicio(cuentaporcobrarDataAccess.getEjercicio(connexion,cuentaporcobrar));
		cuentaporcobrar.setMoneda(cuentaporcobrarDataAccess.getMoneda(connexion,cuentaporcobrar));
		cuentaporcobrar.setCliente(cuentaporcobrarDataAccess.getCliente(connexion,cuentaporcobrar));
		cuentaporcobrar.setTransaccion(cuentaporcobrarDataAccess.getTransaccion(connexion,cuentaporcobrar));
		cuentaporcobrar.setTipoTransaccionModulo(cuentaporcobrarDataAccess.getTipoTransaccionModulo(connexion,cuentaporcobrar));
		cuentaporcobrar.setAsientoContable(cuentaporcobrarDataAccess.getAsientoContable(connexion,cuentaporcobrar));
		cuentaporcobrar.setFactura(cuentaporcobrarDataAccess.getFactura(connexion,cuentaporcobrar));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cuentaporcobrar.setEmpresa(cuentaporcobrarDataAccess.getEmpresa(connexion,cuentaporcobrar));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				cuentaporcobrar.setSucursal(cuentaporcobrarDataAccess.getSucursal(connexion,cuentaporcobrar));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				cuentaporcobrar.setModulo(cuentaporcobrarDataAccess.getModulo(connexion,cuentaporcobrar));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				cuentaporcobrar.setEjercicio(cuentaporcobrarDataAccess.getEjercicio(connexion,cuentaporcobrar));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				cuentaporcobrar.setMoneda(cuentaporcobrarDataAccess.getMoneda(connexion,cuentaporcobrar));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				cuentaporcobrar.setCliente(cuentaporcobrarDataAccess.getCliente(connexion,cuentaporcobrar));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				cuentaporcobrar.setTransaccion(cuentaporcobrarDataAccess.getTransaccion(connexion,cuentaporcobrar));
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				cuentaporcobrar.setTipoTransaccionModulo(cuentaporcobrarDataAccess.getTipoTransaccionModulo(connexion,cuentaporcobrar));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				cuentaporcobrar.setAsientoContable(cuentaporcobrarDataAccess.getAsientoContable(connexion,cuentaporcobrar));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				cuentaporcobrar.setFactura(cuentaporcobrarDataAccess.getFactura(connexion,cuentaporcobrar));
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
			cuentaporcobrar.setEmpresa(cuentaporcobrarDataAccess.getEmpresa(connexion,cuentaporcobrar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaporcobrar.setSucursal(cuentaporcobrarDataAccess.getSucursal(connexion,cuentaporcobrar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaporcobrar.setModulo(cuentaporcobrarDataAccess.getModulo(connexion,cuentaporcobrar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaporcobrar.setEjercicio(cuentaporcobrarDataAccess.getEjercicio(connexion,cuentaporcobrar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaporcobrar.setMoneda(cuentaporcobrarDataAccess.getMoneda(connexion,cuentaporcobrar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaporcobrar.setCliente(cuentaporcobrarDataAccess.getCliente(connexion,cuentaporcobrar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaporcobrar.setTransaccion(cuentaporcobrarDataAccess.getTransaccion(connexion,cuentaporcobrar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaporcobrar.setTipoTransaccionModulo(cuentaporcobrarDataAccess.getTipoTransaccionModulo(connexion,cuentaporcobrar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaporcobrar.setAsientoContable(cuentaporcobrarDataAccess.getAsientoContable(connexion,cuentaporcobrar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaporcobrar.setFactura(cuentaporcobrarDataAccess.getFactura(connexion,cuentaporcobrar));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cuentaporcobrar.setEmpresa(cuentaporcobrarDataAccess.getEmpresa(connexion,cuentaporcobrar));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cuentaporcobrar.getEmpresa(),isDeep,deepLoadType,clases);
				
		cuentaporcobrar.setSucursal(cuentaporcobrarDataAccess.getSucursal(connexion,cuentaporcobrar));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cuentaporcobrar.getSucursal(),isDeep,deepLoadType,clases);
				
		cuentaporcobrar.setModulo(cuentaporcobrarDataAccess.getModulo(connexion,cuentaporcobrar));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(cuentaporcobrar.getModulo(),isDeep,deepLoadType,clases);
				
		cuentaporcobrar.setEjercicio(cuentaporcobrarDataAccess.getEjercicio(connexion,cuentaporcobrar));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(cuentaporcobrar.getEjercicio(),isDeep,deepLoadType,clases);
				
		cuentaporcobrar.setMoneda(cuentaporcobrarDataAccess.getMoneda(connexion,cuentaporcobrar));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(cuentaporcobrar.getMoneda(),isDeep,deepLoadType,clases);
				
		cuentaporcobrar.setCliente(cuentaporcobrarDataAccess.getCliente(connexion,cuentaporcobrar));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(cuentaporcobrar.getCliente(),isDeep,deepLoadType,clases);
				
		cuentaporcobrar.setTransaccion(cuentaporcobrarDataAccess.getTransaccion(connexion,cuentaporcobrar));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(cuentaporcobrar.getTransaccion(),isDeep,deepLoadType,clases);
				
		cuentaporcobrar.setTipoTransaccionModulo(cuentaporcobrarDataAccess.getTipoTransaccionModulo(connexion,cuentaporcobrar));
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(cuentaporcobrar.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		cuentaporcobrar.setAsientoContable(cuentaporcobrarDataAccess.getAsientoContable(connexion,cuentaporcobrar));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(cuentaporcobrar.getAsientoContable(),isDeep,deepLoadType,clases);
				
		cuentaporcobrar.setFactura(cuentaporcobrarDataAccess.getFactura(connexion,cuentaporcobrar));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(cuentaporcobrar.getFactura(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cuentaporcobrar.setEmpresa(cuentaporcobrarDataAccess.getEmpresa(connexion,cuentaporcobrar));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cuentaporcobrar.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				cuentaporcobrar.setSucursal(cuentaporcobrarDataAccess.getSucursal(connexion,cuentaporcobrar));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(cuentaporcobrar.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				cuentaporcobrar.setModulo(cuentaporcobrarDataAccess.getModulo(connexion,cuentaporcobrar));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(cuentaporcobrar.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				cuentaporcobrar.setEjercicio(cuentaporcobrarDataAccess.getEjercicio(connexion,cuentaporcobrar));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(cuentaporcobrar.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				cuentaporcobrar.setMoneda(cuentaporcobrarDataAccess.getMoneda(connexion,cuentaporcobrar));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(cuentaporcobrar.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				cuentaporcobrar.setCliente(cuentaporcobrarDataAccess.getCliente(connexion,cuentaporcobrar));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cuentaporcobrar.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				cuentaporcobrar.setTransaccion(cuentaporcobrarDataAccess.getTransaccion(connexion,cuentaporcobrar));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(cuentaporcobrar.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				cuentaporcobrar.setTipoTransaccionModulo(cuentaporcobrarDataAccess.getTipoTransaccionModulo(connexion,cuentaporcobrar));
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepLoad(cuentaporcobrar.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				cuentaporcobrar.setAsientoContable(cuentaporcobrarDataAccess.getAsientoContable(connexion,cuentaporcobrar));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(cuentaporcobrar.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				cuentaporcobrar.setFactura(cuentaporcobrarDataAccess.getFactura(connexion,cuentaporcobrar));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(cuentaporcobrar.getFactura(),isDeep,deepLoadType,clases);				
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
			cuentaporcobrar.setEmpresa(cuentaporcobrarDataAccess.getEmpresa(connexion,cuentaporcobrar));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cuentaporcobrar.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaporcobrar.setSucursal(cuentaporcobrarDataAccess.getSucursal(connexion,cuentaporcobrar));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(cuentaporcobrar.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaporcobrar.setModulo(cuentaporcobrarDataAccess.getModulo(connexion,cuentaporcobrar));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(cuentaporcobrar.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaporcobrar.setEjercicio(cuentaporcobrarDataAccess.getEjercicio(connexion,cuentaporcobrar));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(cuentaporcobrar.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaporcobrar.setMoneda(cuentaporcobrarDataAccess.getMoneda(connexion,cuentaporcobrar));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(cuentaporcobrar.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaporcobrar.setCliente(cuentaporcobrarDataAccess.getCliente(connexion,cuentaporcobrar));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cuentaporcobrar.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaporcobrar.setTransaccion(cuentaporcobrarDataAccess.getTransaccion(connexion,cuentaporcobrar));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(cuentaporcobrar.getTransaccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaporcobrar.setTipoTransaccionModulo(cuentaporcobrarDataAccess.getTipoTransaccionModulo(connexion,cuentaporcobrar));
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
			tipotransaccionmoduloLogic.deepLoad(cuentaporcobrar.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaporcobrar.setAsientoContable(cuentaporcobrarDataAccess.getAsientoContable(connexion,cuentaporcobrar));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(cuentaporcobrar.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentaporcobrar.setFactura(cuentaporcobrarDataAccess.getFactura(connexion,cuentaporcobrar));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(cuentaporcobrar.getFactura(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CuentaPorCobrar cuentaporcobrar,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CuentaPorCobrarLogicAdditional.updateCuentaPorCobrarToSave(cuentaporcobrar,this.arrDatoGeneral);
			
CuentaPorCobrarDataAccess.save(cuentaporcobrar, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cuentaporcobrar.getEmpresa(),connexion);

		SucursalDataAccess.save(cuentaporcobrar.getSucursal(),connexion);

		ModuloDataAccess.save(cuentaporcobrar.getModulo(),connexion);

		EjercicioDataAccess.save(cuentaporcobrar.getEjercicio(),connexion);

		MonedaDataAccess.save(cuentaporcobrar.getMoneda(),connexion);

		ClienteDataAccess.save(cuentaporcobrar.getCliente(),connexion);

		TransaccionDataAccess.save(cuentaporcobrar.getTransaccion(),connexion);

		TipoTransaccionModuloDataAccess.save(cuentaporcobrar.getTipoTransaccionModulo(),connexion);

		AsientoContableDataAccess.save(cuentaporcobrar.getAsientoContable(),connexion);

		FacturaDataAccess.save(cuentaporcobrar.getFactura(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cuentaporcobrar.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(cuentaporcobrar.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(cuentaporcobrar.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(cuentaporcobrar.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(cuentaporcobrar.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(cuentaporcobrar.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(cuentaporcobrar.getTransaccion(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(cuentaporcobrar.getTipoTransaccionModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(cuentaporcobrar.getAsientoContable(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(cuentaporcobrar.getFactura(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cuentaporcobrar.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cuentaporcobrar.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(cuentaporcobrar.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cuentaporcobrar.getSucursal(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(cuentaporcobrar.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(cuentaporcobrar.getModulo(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(cuentaporcobrar.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(cuentaporcobrar.getEjercicio(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(cuentaporcobrar.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(cuentaporcobrar.getMoneda(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(cuentaporcobrar.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(cuentaporcobrar.getCliente(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(cuentaporcobrar.getTransaccion(),connexion);
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(cuentaporcobrar.getTransaccion(),isDeep,deepLoadType,clases);
				

		TipoTransaccionModuloDataAccess.save(cuentaporcobrar.getTipoTransaccionModulo(),connexion);
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(cuentaporcobrar.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(cuentaporcobrar.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(cuentaporcobrar.getAsientoContable(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(cuentaporcobrar.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(cuentaporcobrar.getFactura(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cuentaporcobrar.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(cuentaporcobrar.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(cuentaporcobrar.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(cuentaporcobrar.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(cuentaporcobrar.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(cuentaporcobrar.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(cuentaporcobrar.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(cuentaporcobrar.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(cuentaporcobrar.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(cuentaporcobrar.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(cuentaporcobrar.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(cuentaporcobrar.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(cuentaporcobrar.getTransaccion(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(cuentaporcobrar.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(cuentaporcobrar.getTipoTransaccionModulo(),connexion);
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepSave(cuentaporcobrar.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(cuentaporcobrar.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(cuentaporcobrar.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(cuentaporcobrar.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(cuentaporcobrar.getFactura(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(CuentaPorCobrar.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cuentaporcobrar,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(cuentaporcobrar);
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
			this.deepLoad(this.cuentaporcobrar,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrar);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CuentaPorCobrar.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cuentaporcobrars!=null) {
				for(CuentaPorCobrar cuentaporcobrar:cuentaporcobrars) {
					this.deepLoad(cuentaporcobrar,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(cuentaporcobrars);
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
			if(cuentaporcobrars!=null) {
				for(CuentaPorCobrar cuentaporcobrar:cuentaporcobrars) {
					this.deepLoad(cuentaporcobrar,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(cuentaporcobrars);
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
			this.getNewConnexionToDeep(CuentaPorCobrar.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cuentaporcobrar,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CuentaPorCobrar.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cuentaporcobrars!=null) {
				for(CuentaPorCobrar cuentaporcobrar:cuentaporcobrars) {
					this.deepSave(cuentaporcobrar,isDeep,deepLoadType,clases);
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
			if(cuentaporcobrars!=null) {
				for(CuentaPorCobrar cuentaporcobrar:cuentaporcobrars) {
					this.deepSave(cuentaporcobrar,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCuentaPorCobrarsFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,CuentaPorCobrarConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaPorCobrarsFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,CuentaPorCobrarConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaPorCobrarsFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,CuentaPorCobrarConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaPorCobrarsFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,CuentaPorCobrarConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaPorCobrarsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,CuentaPorCobrarConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaPorCobrarsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,CuentaPorCobrarConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaPorCobrarsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CuentaPorCobrarConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaPorCobrarsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CuentaPorCobrarConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaPorCobrarsFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,CuentaPorCobrarConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaPorCobrarsFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,CuentaPorCobrarConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaPorCobrarsFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,CuentaPorCobrarConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaPorCobrarsFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,CuentaPorCobrarConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaPorCobrarsFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,CuentaPorCobrarConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaPorCobrarsFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,CuentaPorCobrarConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaPorCobrarsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CuentaPorCobrarConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaPorCobrarsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CuentaPorCobrarConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaPorCobrarsFK_IdTipoTransaccionModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,CuentaPorCobrarConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaPorCobrarsFK_IdTipoTransaccionModulo(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,CuentaPorCobrarConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaPorCobrarsFK_IdTransaccionWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaPorCobrar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,CuentaPorCobrarConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaPorCobrarsFK_IdTransaccion(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,CuentaPorCobrarConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			CuentaPorCobrarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentaporcobrars=cuentaporcobrarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(this.cuentaporcobrars);
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
			if(CuentaPorCobrarConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaPorCobrarDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CuentaPorCobrar cuentaporcobrar,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CuentaPorCobrarConstantesFunciones.ISCONAUDITORIA) {
				if(cuentaporcobrar.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaPorCobrarDataAccess.TABLENAME, cuentaporcobrar.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CuentaPorCobrarConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CuentaPorCobrarLogic.registrarAuditoriaDetallesCuentaPorCobrar(connexion,cuentaporcobrar,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cuentaporcobrar.getIsDeleted()) {
					/*if(!cuentaporcobrar.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CuentaPorCobrarDataAccess.TABLENAME, cuentaporcobrar.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CuentaPorCobrarLogic.registrarAuditoriaDetallesCuentaPorCobrar(connexion,cuentaporcobrar,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaPorCobrarDataAccess.TABLENAME, cuentaporcobrar.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cuentaporcobrar.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaPorCobrarDataAccess.TABLENAME, cuentaporcobrar.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CuentaPorCobrarConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CuentaPorCobrarLogic.registrarAuditoriaDetallesCuentaPorCobrar(connexion,cuentaporcobrar,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCuentaPorCobrar(Connexion connexion,CuentaPorCobrar cuentaporcobrar)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cuentaporcobrar.getIsNew()||!cuentaporcobrar.getid_empresa().equals(cuentaporcobrar.getCuentaPorCobrarOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaporcobrar.getCuentaPorCobrarOriginal().getid_empresa()!=null)
				{
					strValorActual=cuentaporcobrar.getCuentaPorCobrarOriginal().getid_empresa().toString();
				}
				if(cuentaporcobrar.getid_empresa()!=null)
				{
					strValorNuevo=cuentaporcobrar.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaPorCobrarConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(cuentaporcobrar.getIsNew()||!cuentaporcobrar.getid_sucursal().equals(cuentaporcobrar.getCuentaPorCobrarOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaporcobrar.getCuentaPorCobrarOriginal().getid_sucursal()!=null)
				{
					strValorActual=cuentaporcobrar.getCuentaPorCobrarOriginal().getid_sucursal().toString();
				}
				if(cuentaporcobrar.getid_sucursal()!=null)
				{
					strValorNuevo=cuentaporcobrar.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaPorCobrarConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(cuentaporcobrar.getIsNew()||!cuentaporcobrar.getid_modulo().equals(cuentaporcobrar.getCuentaPorCobrarOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaporcobrar.getCuentaPorCobrarOriginal().getid_modulo()!=null)
				{
					strValorActual=cuentaporcobrar.getCuentaPorCobrarOriginal().getid_modulo().toString();
				}
				if(cuentaporcobrar.getid_modulo()!=null)
				{
					strValorNuevo=cuentaporcobrar.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaPorCobrarConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(cuentaporcobrar.getIsNew()||!cuentaporcobrar.getid_ejercicio().equals(cuentaporcobrar.getCuentaPorCobrarOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaporcobrar.getCuentaPorCobrarOriginal().getid_ejercicio()!=null)
				{
					strValorActual=cuentaporcobrar.getCuentaPorCobrarOriginal().getid_ejercicio().toString();
				}
				if(cuentaporcobrar.getid_ejercicio()!=null)
				{
					strValorNuevo=cuentaporcobrar.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaPorCobrarConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(cuentaporcobrar.getIsNew()||!cuentaporcobrar.getid_moneda().equals(cuentaporcobrar.getCuentaPorCobrarOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaporcobrar.getCuentaPorCobrarOriginal().getid_moneda()!=null)
				{
					strValorActual=cuentaporcobrar.getCuentaPorCobrarOriginal().getid_moneda().toString();
				}
				if(cuentaporcobrar.getid_moneda()!=null)
				{
					strValorNuevo=cuentaporcobrar.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaPorCobrarConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(cuentaporcobrar.getIsNew()||!cuentaporcobrar.getid_cliente().equals(cuentaporcobrar.getCuentaPorCobrarOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaporcobrar.getCuentaPorCobrarOriginal().getid_cliente()!=null)
				{
					strValorActual=cuentaporcobrar.getCuentaPorCobrarOriginal().getid_cliente().toString();
				}
				if(cuentaporcobrar.getid_cliente()!=null)
				{
					strValorNuevo=cuentaporcobrar.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaPorCobrarConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(cuentaporcobrar.getIsNew()||!cuentaporcobrar.getid_transaccion().equals(cuentaporcobrar.getCuentaPorCobrarOriginal().getid_transaccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaporcobrar.getCuentaPorCobrarOriginal().getid_transaccion()!=null)
				{
					strValorActual=cuentaporcobrar.getCuentaPorCobrarOriginal().getid_transaccion().toString();
				}
				if(cuentaporcobrar.getid_transaccion()!=null)
				{
					strValorNuevo=cuentaporcobrar.getid_transaccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaPorCobrarConstantesFunciones.IDTRANSACCION,strValorActual,strValorNuevo);
			}	
			
			if(cuentaporcobrar.getIsNew()||!cuentaporcobrar.getid_tipo_transaccion_modulo().equals(cuentaporcobrar.getCuentaPorCobrarOriginal().getid_tipo_transaccion_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaporcobrar.getCuentaPorCobrarOriginal().getid_tipo_transaccion_modulo()!=null)
				{
					strValorActual=cuentaporcobrar.getCuentaPorCobrarOriginal().getid_tipo_transaccion_modulo().toString();
				}
				if(cuentaporcobrar.getid_tipo_transaccion_modulo()!=null)
				{
					strValorNuevo=cuentaporcobrar.getid_tipo_transaccion_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaPorCobrarConstantesFunciones.IDTIPOTRANSACCIONMODULO,strValorActual,strValorNuevo);
			}	
			
			if(cuentaporcobrar.getIsNew()||!cuentaporcobrar.getid_asiento_contable().equals(cuentaporcobrar.getCuentaPorCobrarOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaporcobrar.getCuentaPorCobrarOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=cuentaporcobrar.getCuentaPorCobrarOriginal().getid_asiento_contable().toString();
				}
				if(cuentaporcobrar.getid_asiento_contable()!=null)
				{
					strValorNuevo=cuentaporcobrar.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaPorCobrarConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(cuentaporcobrar.getIsNew()||!cuentaporcobrar.getid_factura().equals(cuentaporcobrar.getCuentaPorCobrarOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaporcobrar.getCuentaPorCobrarOriginal().getid_factura()!=null)
				{
					strValorActual=cuentaporcobrar.getCuentaPorCobrarOriginal().getid_factura().toString();
				}
				if(cuentaporcobrar.getid_factura()!=null)
				{
					strValorNuevo=cuentaporcobrar.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaPorCobrarConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(cuentaporcobrar.getIsNew()||!cuentaporcobrar.getfecha().equals(cuentaporcobrar.getCuentaPorCobrarOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaporcobrar.getCuentaPorCobrarOriginal().getfecha()!=null)
				{
					strValorActual=cuentaporcobrar.getCuentaPorCobrarOriginal().getfecha().toString();
				}
				if(cuentaporcobrar.getfecha()!=null)
				{
					strValorNuevo=cuentaporcobrar.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaPorCobrarConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(cuentaporcobrar.getIsNew()||!cuentaporcobrar.getmonto().equals(cuentaporcobrar.getCuentaPorCobrarOriginal().getmonto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaporcobrar.getCuentaPorCobrarOriginal().getmonto()!=null)
				{
					strValorActual=cuentaporcobrar.getCuentaPorCobrarOriginal().getmonto().toString();
				}
				if(cuentaporcobrar.getmonto()!=null)
				{
					strValorNuevo=cuentaporcobrar.getmonto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaPorCobrarConstantesFunciones.MONTO,strValorActual,strValorNuevo);
			}	
			
			if(cuentaporcobrar.getIsNew()||!cuentaporcobrar.getnumero_comprobante().equals(cuentaporcobrar.getCuentaPorCobrarOriginal().getnumero_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaporcobrar.getCuentaPorCobrarOriginal().getnumero_comprobante()!=null)
				{
					strValorActual=cuentaporcobrar.getCuentaPorCobrarOriginal().getnumero_comprobante();
				}
				if(cuentaporcobrar.getnumero_comprobante()!=null)
				{
					strValorNuevo=cuentaporcobrar.getnumero_comprobante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaPorCobrarConstantesFunciones.NUMEROCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(cuentaporcobrar.getIsNew()||!cuentaporcobrar.getdebito().equals(cuentaporcobrar.getCuentaPorCobrarOriginal().getdebito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaporcobrar.getCuentaPorCobrarOriginal().getdebito()!=null)
				{
					strValorActual=cuentaporcobrar.getCuentaPorCobrarOriginal().getdebito().toString();
				}
				if(cuentaporcobrar.getdebito()!=null)
				{
					strValorNuevo=cuentaporcobrar.getdebito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaPorCobrarConstantesFunciones.DEBITO,strValorActual,strValorNuevo);
			}	
			
			if(cuentaporcobrar.getIsNew()||!cuentaporcobrar.getcredito().equals(cuentaporcobrar.getCuentaPorCobrarOriginal().getcredito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaporcobrar.getCuentaPorCobrarOriginal().getcredito()!=null)
				{
					strValorActual=cuentaporcobrar.getCuentaPorCobrarOriginal().getcredito().toString();
				}
				if(cuentaporcobrar.getcredito()!=null)
				{
					strValorNuevo=cuentaporcobrar.getcredito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaPorCobrarConstantesFunciones.CREDITO,strValorActual,strValorNuevo);
			}	
			
			if(cuentaporcobrar.getIsNew()||!cuentaporcobrar.getdetalle().equals(cuentaporcobrar.getCuentaPorCobrarOriginal().getdetalle()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentaporcobrar.getCuentaPorCobrarOriginal().getdetalle()!=null)
				{
					strValorActual=cuentaporcobrar.getCuentaPorCobrarOriginal().getdetalle();
				}
				if(cuentaporcobrar.getdetalle()!=null)
				{
					strValorNuevo=cuentaporcobrar.getdetalle() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaPorCobrarConstantesFunciones.DETALLE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCuentaPorCobrarRelacionesWithConnection(CuentaPorCobrar cuentaporcobrar) throws Exception {

		if(!cuentaporcobrar.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCuentaPorCobrarRelacionesBase(cuentaporcobrar,true);
		}
	}

	public void saveCuentaPorCobrarRelaciones(CuentaPorCobrar cuentaporcobrar)throws Exception {

		if(!cuentaporcobrar.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCuentaPorCobrarRelacionesBase(cuentaporcobrar,false);
		}
	}

	public void saveCuentaPorCobrarRelacionesBase(CuentaPorCobrar cuentaporcobrar,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CuentaPorCobrar-saveRelacionesWithConnection");}
	

			this.setCuentaPorCobrar(cuentaporcobrar);

			if(CuentaPorCobrarLogicAdditional.validarSaveRelaciones(cuentaporcobrar,this)) {

				CuentaPorCobrarLogicAdditional.updateRelacionesToSave(cuentaporcobrar,this);

				if((cuentaporcobrar.getIsNew()||cuentaporcobrar.getIsChanged())&&!cuentaporcobrar.getIsDeleted()) {
					this.saveCuentaPorCobrar();
					this.saveCuentaPorCobrarRelacionesDetalles();

				} else if(cuentaporcobrar.getIsDeleted()) {
					this.saveCuentaPorCobrarRelacionesDetalles();
					this.saveCuentaPorCobrar();
				}

				CuentaPorCobrarLogicAdditional.updateRelacionesToSaveAfter(cuentaporcobrar,this);

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
	
	
	private void saveCuentaPorCobrarRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCuentaPorCobrar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CuentaPorCobrarConstantesFunciones.getClassesForeignKeysOfCuentaPorCobrar(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaPorCobrar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CuentaPorCobrarConstantesFunciones.getClassesRelationshipsOfCuentaPorCobrar(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

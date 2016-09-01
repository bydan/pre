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
import com.bydan.erp.activosfijos.util.CuentaContaGastoDepreConstantesFunciones;
import com.bydan.erp.activosfijos.util.CuentaContaGastoDepreParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.CuentaContaGastoDepreParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.CuentaContaGastoDepre;
import com.bydan.erp.activosfijos.business.logic.CuentaContaGastoDepreLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class CuentaContaGastoDepreLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CuentaContaGastoDepreLogic.class);
	
	protected CuentaContaGastoDepreDataAccess cuentacontagastodepreDataAccess; 	
	protected CuentaContaGastoDepre cuentacontagastodepre;
	protected List<CuentaContaGastoDepre> cuentacontagastodepres;
	protected Object cuentacontagastodepreObject;	
	protected List<Object> cuentacontagastodepresObject;
	
	public static ClassValidator<CuentaContaGastoDepre> cuentacontagastodepreValidator = new ClassValidator<CuentaContaGastoDepre>(CuentaContaGastoDepre.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CuentaContaGastoDepreLogicAdditional cuentacontagastodepreLogicAdditional=null;
	
	public CuentaContaGastoDepreLogicAdditional getCuentaContaGastoDepreLogicAdditional() {
		return this.cuentacontagastodepreLogicAdditional;
	}
	
	public void setCuentaContaGastoDepreLogicAdditional(CuentaContaGastoDepreLogicAdditional cuentacontagastodepreLogicAdditional) {
		try {
			this.cuentacontagastodepreLogicAdditional=cuentacontagastodepreLogicAdditional;
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
	
	
	
	
	public  CuentaContaGastoDepreLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cuentacontagastodepreDataAccess = new CuentaContaGastoDepreDataAccess();
			
			this.cuentacontagastodepres= new ArrayList<CuentaContaGastoDepre>();
			this.cuentacontagastodepre= new CuentaContaGastoDepre();
			
			this.cuentacontagastodepreObject=new Object();
			this.cuentacontagastodepresObject=new ArrayList<Object>();
				
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
			
			this.cuentacontagastodepreDataAccess.setConnexionType(this.connexionType);
			this.cuentacontagastodepreDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CuentaContaGastoDepreLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cuentacontagastodepreDataAccess = new CuentaContaGastoDepreDataAccess();
			this.cuentacontagastodepres= new ArrayList<CuentaContaGastoDepre>();
			this.cuentacontagastodepre= new CuentaContaGastoDepre();
			this.cuentacontagastodepreObject=new Object();
			this.cuentacontagastodepresObject=new ArrayList<Object>();
			
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
			
			this.cuentacontagastodepreDataAccess.setConnexionType(this.connexionType);
			this.cuentacontagastodepreDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CuentaContaGastoDepre getCuentaContaGastoDepre() throws Exception {	
		CuentaContaGastoDepreLogicAdditional.checkCuentaContaGastoDepreToGet(cuentacontagastodepre,this.datosCliente,this.arrDatoGeneral);
		CuentaContaGastoDepreLogicAdditional.updateCuentaContaGastoDepreToGet(cuentacontagastodepre,this.arrDatoGeneral);
		
		return cuentacontagastodepre;
	}
		
	public void setCuentaContaGastoDepre(CuentaContaGastoDepre newCuentaContaGastoDepre) {
		this.cuentacontagastodepre = newCuentaContaGastoDepre;
	}
	
	public CuentaContaGastoDepreDataAccess getCuentaContaGastoDepreDataAccess() {
		return cuentacontagastodepreDataAccess;
	}
	
	public void setCuentaContaGastoDepreDataAccess(CuentaContaGastoDepreDataAccess newcuentacontagastodepreDataAccess) {
		this.cuentacontagastodepreDataAccess = newcuentacontagastodepreDataAccess;
	}
	
	public List<CuentaContaGastoDepre> getCuentaContaGastoDepres() throws Exception {		
		this.quitarCuentaContaGastoDepresNulos();
		
		CuentaContaGastoDepreLogicAdditional.checkCuentaContaGastoDepreToGets(cuentacontagastodepres,this.datosCliente,this.arrDatoGeneral);
		
		for (CuentaContaGastoDepre cuentacontagastodepreLocal: cuentacontagastodepres ) {
			CuentaContaGastoDepreLogicAdditional.updateCuentaContaGastoDepreToGet(cuentacontagastodepreLocal,this.arrDatoGeneral);
		}
		
		return cuentacontagastodepres;
	}
	
	public void setCuentaContaGastoDepres(List<CuentaContaGastoDepre> newCuentaContaGastoDepres) {
		this.cuentacontagastodepres = newCuentaContaGastoDepres;
	}
	
	public Object getCuentaContaGastoDepreObject() {	
		this.cuentacontagastodepreObject=this.cuentacontagastodepreDataAccess.getEntityObject();
		return this.cuentacontagastodepreObject;
	}
		
	public void setCuentaContaGastoDepreObject(Object newCuentaContaGastoDepreObject) {
		this.cuentacontagastodepreObject = newCuentaContaGastoDepreObject;
	}
	
	public List<Object> getCuentaContaGastoDepresObject() {		
		this.cuentacontagastodepresObject=this.cuentacontagastodepreDataAccess.getEntitiesObject();
		return this.cuentacontagastodepresObject;
	}
		
	public void setCuentaContaGastoDepresObject(List<Object> newCuentaContaGastoDepresObject) {
		this.cuentacontagastodepresObject = newCuentaContaGastoDepresObject;
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
		
		if(this.cuentacontagastodepreDataAccess!=null) {
			this.cuentacontagastodepreDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaGastoDepre.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cuentacontagastodepreDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cuentacontagastodepreDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cuentacontagastodepre = new  CuentaContaGastoDepre();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaGastoDepre.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cuentacontagastodepre=cuentacontagastodepreDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentacontagastodepre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(this.cuentacontagastodepre);
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
		cuentacontagastodepre = new  CuentaContaGastoDepre();
		  		  
        try {
			
			cuentacontagastodepre=cuentacontagastodepreDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentacontagastodepre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(this.cuentacontagastodepre);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cuentacontagastodepre = new  CuentaContaGastoDepre();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaGastoDepre.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cuentacontagastodepre=cuentacontagastodepreDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentacontagastodepre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(this.cuentacontagastodepre);
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
		cuentacontagastodepre = new  CuentaContaGastoDepre();
		  		  
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
		cuentacontagastodepre = new  CuentaContaGastoDepre();
		  		  
        try {
			
			cuentacontagastodepre=cuentacontagastodepreDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentacontagastodepre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(this.cuentacontagastodepre);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cuentacontagastodepre = new  CuentaContaGastoDepre();
		  		  
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
		cuentacontagastodepre = new  CuentaContaGastoDepre();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaGastoDepre.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cuentacontagastodepreDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentacontagastodepre = new  CuentaContaGastoDepre();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cuentacontagastodepreDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cuentacontagastodepre = new  CuentaContaGastoDepre();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaGastoDepre.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cuentacontagastodepreDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentacontagastodepre = new  CuentaContaGastoDepre();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cuentacontagastodepreDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cuentacontagastodepre = new  CuentaContaGastoDepre();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaGastoDepre.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cuentacontagastodepreDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentacontagastodepre = new  CuentaContaGastoDepre();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cuentacontagastodepreDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cuentacontagastodepres = new  ArrayList<CuentaContaGastoDepre>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaGastoDepre.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CuentaContaGastoDepreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontagastodepres=cuentacontagastodepreDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaContaGastoDepre(cuentacontagastodepres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(this.cuentacontagastodepres);
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
		cuentacontagastodepres = new  ArrayList<CuentaContaGastoDepre>();
		  		  
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
		cuentacontagastodepres = new  ArrayList<CuentaContaGastoDepre>();
		  		  
        try {			
			CuentaContaGastoDepreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontagastodepres=cuentacontagastodepreDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCuentaContaGastoDepre(cuentacontagastodepres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(this.cuentacontagastodepres);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cuentacontagastodepres = new  ArrayList<CuentaContaGastoDepre>();
		  		  
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
		cuentacontagastodepres = new  ArrayList<CuentaContaGastoDepre>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaGastoDepre.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CuentaContaGastoDepreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontagastodepres=cuentacontagastodepreDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaContaGastoDepre(cuentacontagastodepres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(this.cuentacontagastodepres);
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
		cuentacontagastodepres = new  ArrayList<CuentaContaGastoDepre>();
		  		  
        try {
			CuentaContaGastoDepreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontagastodepres=cuentacontagastodepreDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaContaGastoDepre(cuentacontagastodepres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(this.cuentacontagastodepres);
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
		cuentacontagastodepres = new  ArrayList<CuentaContaGastoDepre>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaGastoDepre.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContaGastoDepreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontagastodepres=cuentacontagastodepreDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaContaGastoDepre(cuentacontagastodepres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(this.cuentacontagastodepres);
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
		cuentacontagastodepres = new  ArrayList<CuentaContaGastoDepre>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContaGastoDepreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontagastodepres=cuentacontagastodepreDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaContaGastoDepre(cuentacontagastodepres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(this.cuentacontagastodepres);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cuentacontagastodepre = new  CuentaContaGastoDepre();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaGastoDepre.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContaGastoDepreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontagastodepre=cuentacontagastodepreDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaContaGastoDepre(cuentacontagastodepre);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(this.cuentacontagastodepre);
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
		cuentacontagastodepre = new  CuentaContaGastoDepre();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContaGastoDepreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontagastodepre=cuentacontagastodepreDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaContaGastoDepre(cuentacontagastodepre);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(this.cuentacontagastodepre);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cuentacontagastodepres = new  ArrayList<CuentaContaGastoDepre>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaGastoDepre.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CuentaContaGastoDepreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontagastodepres=cuentacontagastodepreDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaContaGastoDepre(cuentacontagastodepres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(this.cuentacontagastodepres);
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
		cuentacontagastodepres = new  ArrayList<CuentaContaGastoDepre>();
		  		  
        try {
			CuentaContaGastoDepreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontagastodepres=cuentacontagastodepreDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaContaGastoDepre(cuentacontagastodepres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(this.cuentacontagastodepres);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCuentaContaGastoDepresWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cuentacontagastodepres = new  ArrayList<CuentaContaGastoDepre>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaGastoDepre.class.getSimpleName()+"-getTodosCuentaContaGastoDepresWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContaGastoDepreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontagastodepres=cuentacontagastodepreDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCuentaContaGastoDepre(cuentacontagastodepres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(this.cuentacontagastodepres);
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
	
	public  void  getTodosCuentaContaGastoDepres(String sFinalQuery,Pagination pagination)throws Exception {
		cuentacontagastodepres = new  ArrayList<CuentaContaGastoDepre>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContaGastoDepreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontagastodepres=cuentacontagastodepreDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCuentaContaGastoDepre(cuentacontagastodepres);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(this.cuentacontagastodepres);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCuentaContaGastoDepre(CuentaContaGastoDepre cuentacontagastodepre) throws Exception {
		Boolean estaValidado=false;
		
		if(cuentacontagastodepre.getIsNew() || cuentacontagastodepre.getIsChanged()) { 
			this.invalidValues = cuentacontagastodepreValidator.getInvalidValues(cuentacontagastodepre);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cuentacontagastodepre);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCuentaContaGastoDepre(List<CuentaContaGastoDepre> CuentaContaGastoDepres) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CuentaContaGastoDepre cuentacontagastodepreLocal:cuentacontagastodepres) {				
			estaValidadoObjeto=this.validarGuardarCuentaContaGastoDepre(cuentacontagastodepreLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCuentaContaGastoDepre(List<CuentaContaGastoDepre> CuentaContaGastoDepres) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCuentaContaGastoDepre(cuentacontagastodepres)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCuentaContaGastoDepre(CuentaContaGastoDepre CuentaContaGastoDepre) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCuentaContaGastoDepre(cuentacontagastodepre)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CuentaContaGastoDepre cuentacontagastodepre) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cuentacontagastodepre.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CuentaContaGastoDepreConstantesFunciones.getCuentaContaGastoDepreLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cuentacontagastodepre","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CuentaContaGastoDepreConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CuentaContaGastoDepreConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCuentaContaGastoDepreWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaGastoDepre.class.getSimpleName()+"-saveCuentaContaGastoDepreWithConnection");connexion.begin();			
			
			CuentaContaGastoDepreLogicAdditional.checkCuentaContaGastoDepreToSave(this.cuentacontagastodepre,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CuentaContaGastoDepreLogicAdditional.updateCuentaContaGastoDepreToSave(this.cuentacontagastodepre,this.arrDatoGeneral);
			
			CuentaContaGastoDepreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cuentacontagastodepre,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCuentaContaGastoDepre();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCuentaContaGastoDepre(this.cuentacontagastodepre)) {
				CuentaContaGastoDepreDataAccess.save(this.cuentacontagastodepre, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cuentacontagastodepre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CuentaContaGastoDepreLogicAdditional.checkCuentaContaGastoDepreToSaveAfter(this.cuentacontagastodepre,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCuentaContaGastoDepre();
			
			connexion.commit();			
			
			if(this.cuentacontagastodepre.getIsDeleted()) {
				this.cuentacontagastodepre=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCuentaContaGastoDepre()throws Exception {	
		try {	
			
			CuentaContaGastoDepreLogicAdditional.checkCuentaContaGastoDepreToSave(this.cuentacontagastodepre,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CuentaContaGastoDepreLogicAdditional.updateCuentaContaGastoDepreToSave(this.cuentacontagastodepre,this.arrDatoGeneral);
			
			CuentaContaGastoDepreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cuentacontagastodepre,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCuentaContaGastoDepre(this.cuentacontagastodepre)) {			
				CuentaContaGastoDepreDataAccess.save(this.cuentacontagastodepre, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cuentacontagastodepre,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CuentaContaGastoDepreLogicAdditional.checkCuentaContaGastoDepreToSaveAfter(this.cuentacontagastodepre,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cuentacontagastodepre.getIsDeleted()) {
				this.cuentacontagastodepre=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCuentaContaGastoDepresWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaGastoDepre.class.getSimpleName()+"-saveCuentaContaGastoDepresWithConnection");connexion.begin();			
			
			CuentaContaGastoDepreLogicAdditional.checkCuentaContaGastoDepreToSaves(cuentacontagastodepres,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCuentaContaGastoDepres();
			
			Boolean validadoTodosCuentaContaGastoDepre=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CuentaContaGastoDepre cuentacontagastodepreLocal:cuentacontagastodepres) {		
				if(cuentacontagastodepreLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CuentaContaGastoDepreLogicAdditional.updateCuentaContaGastoDepreToSave(cuentacontagastodepreLocal,this.arrDatoGeneral);
	        	
				CuentaContaGastoDepreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cuentacontagastodepreLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCuentaContaGastoDepre(cuentacontagastodepreLocal)) {
					CuentaContaGastoDepreDataAccess.save(cuentacontagastodepreLocal, connexion);				
				} else {
					validadoTodosCuentaContaGastoDepre=false;
				}
			}
			
			if(!validadoTodosCuentaContaGastoDepre) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CuentaContaGastoDepreLogicAdditional.checkCuentaContaGastoDepreToSavesAfter(cuentacontagastodepres,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCuentaContaGastoDepres();
			
			connexion.commit();		
			
			this.quitarCuentaContaGastoDepresEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCuentaContaGastoDepres()throws Exception {				
		 try {	
			CuentaContaGastoDepreLogicAdditional.checkCuentaContaGastoDepreToSaves(cuentacontagastodepres,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCuentaContaGastoDepre=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CuentaContaGastoDepre cuentacontagastodepreLocal:cuentacontagastodepres) {				
				if(cuentacontagastodepreLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CuentaContaGastoDepreLogicAdditional.updateCuentaContaGastoDepreToSave(cuentacontagastodepreLocal,this.arrDatoGeneral);
	        	
				CuentaContaGastoDepreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cuentacontagastodepreLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCuentaContaGastoDepre(cuentacontagastodepreLocal)) {				
					CuentaContaGastoDepreDataAccess.save(cuentacontagastodepreLocal, connexion);				
				} else {
					validadoTodosCuentaContaGastoDepre=false;
				}
			}
			
			if(!validadoTodosCuentaContaGastoDepre) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CuentaContaGastoDepreLogicAdditional.checkCuentaContaGastoDepreToSavesAfter(cuentacontagastodepres,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCuentaContaGastoDepresEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CuentaContaGastoDepreParameterReturnGeneral procesarAccionCuentaContaGastoDepres(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CuentaContaGastoDepre> cuentacontagastodepres,CuentaContaGastoDepreParameterReturnGeneral cuentacontagastodepreParameterGeneral)throws Exception {
		 try {	
			CuentaContaGastoDepreParameterReturnGeneral cuentacontagastodepreReturnGeneral=new CuentaContaGastoDepreParameterReturnGeneral();
	
			CuentaContaGastoDepreLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cuentacontagastodepres,cuentacontagastodepreParameterGeneral,cuentacontagastodepreReturnGeneral);
			
			return cuentacontagastodepreReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CuentaContaGastoDepreParameterReturnGeneral procesarAccionCuentaContaGastoDepresWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CuentaContaGastoDepre> cuentacontagastodepres,CuentaContaGastoDepreParameterReturnGeneral cuentacontagastodepreParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaGastoDepre.class.getSimpleName()+"-procesarAccionCuentaContaGastoDepresWithConnection");connexion.begin();			
			
			CuentaContaGastoDepreParameterReturnGeneral cuentacontagastodepreReturnGeneral=new CuentaContaGastoDepreParameterReturnGeneral();
	
			CuentaContaGastoDepreLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cuentacontagastodepres,cuentacontagastodepreParameterGeneral,cuentacontagastodepreReturnGeneral);
			
			this.connexion.commit();
			
			return cuentacontagastodepreReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CuentaContaGastoDepreParameterReturnGeneral procesarEventosCuentaContaGastoDepres(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CuentaContaGastoDepre> cuentacontagastodepres,CuentaContaGastoDepre cuentacontagastodepre,CuentaContaGastoDepreParameterReturnGeneral cuentacontagastodepreParameterGeneral,Boolean isEsNuevoCuentaContaGastoDepre,ArrayList<Classe> clases)throws Exception {
		 try {	
			CuentaContaGastoDepreParameterReturnGeneral cuentacontagastodepreReturnGeneral=new CuentaContaGastoDepreParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cuentacontagastodepreReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CuentaContaGastoDepreLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cuentacontagastodepres,cuentacontagastodepre,cuentacontagastodepreParameterGeneral,cuentacontagastodepreReturnGeneral,isEsNuevoCuentaContaGastoDepre,clases);
			
			return cuentacontagastodepreReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CuentaContaGastoDepreParameterReturnGeneral procesarEventosCuentaContaGastoDepresWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CuentaContaGastoDepre> cuentacontagastodepres,CuentaContaGastoDepre cuentacontagastodepre,CuentaContaGastoDepreParameterReturnGeneral cuentacontagastodepreParameterGeneral,Boolean isEsNuevoCuentaContaGastoDepre,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaGastoDepre.class.getSimpleName()+"-procesarEventosCuentaContaGastoDepresWithConnection");connexion.begin();			
			
			CuentaContaGastoDepreParameterReturnGeneral cuentacontagastodepreReturnGeneral=new CuentaContaGastoDepreParameterReturnGeneral();
	
			cuentacontagastodepreReturnGeneral.setCuentaContaGastoDepre(cuentacontagastodepre);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cuentacontagastodepreReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CuentaContaGastoDepreLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cuentacontagastodepres,cuentacontagastodepre,cuentacontagastodepreParameterGeneral,cuentacontagastodepreReturnGeneral,isEsNuevoCuentaContaGastoDepre,clases);
			
			this.connexion.commit();
			
			return cuentacontagastodepreReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CuentaContaGastoDepreParameterReturnGeneral procesarImportacionCuentaContaGastoDepresWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CuentaContaGastoDepreParameterReturnGeneral cuentacontagastodepreParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaGastoDepre.class.getSimpleName()+"-procesarImportacionCuentaContaGastoDepresWithConnection");connexion.begin();			
			
			CuentaContaGastoDepreParameterReturnGeneral cuentacontagastodepreReturnGeneral=new CuentaContaGastoDepreParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cuentacontagastodepres=new ArrayList<CuentaContaGastoDepre>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cuentacontagastodepre=new CuentaContaGastoDepre();
				
				
				if(conColumnasBase) {this.cuentacontagastodepre.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cuentacontagastodepre.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.cuentacontagastodepres.add(this.cuentacontagastodepre);
			}
			
			this.saveCuentaContaGastoDepres();
			
			this.connexion.commit();
			
			cuentacontagastodepreReturnGeneral.setConRetornoEstaProcesado(true);
			cuentacontagastodepreReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cuentacontagastodepreReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCuentaContaGastoDepresEliminados() throws Exception {				
		
		List<CuentaContaGastoDepre> cuentacontagastodepresAux= new ArrayList<CuentaContaGastoDepre>();
		
		for(CuentaContaGastoDepre cuentacontagastodepre:cuentacontagastodepres) {
			if(!cuentacontagastodepre.getIsDeleted()) {
				cuentacontagastodepresAux.add(cuentacontagastodepre);
			}
		}
		
		cuentacontagastodepres=cuentacontagastodepresAux;
	}
	
	public void quitarCuentaContaGastoDepresNulos() throws Exception {				
		
		List<CuentaContaGastoDepre> cuentacontagastodepresAux= new ArrayList<CuentaContaGastoDepre>();
		
		for(CuentaContaGastoDepre cuentacontagastodepre : this.cuentacontagastodepres) {
			if(cuentacontagastodepre==null) {
				cuentacontagastodepresAux.add(cuentacontagastodepre);
			}
		}
		
		//this.cuentacontagastodepres=cuentacontagastodepresAux;
		
		this.cuentacontagastodepres.removeAll(cuentacontagastodepresAux);
	}
	
	public void getSetVersionRowCuentaContaGastoDepreWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cuentacontagastodepre.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cuentacontagastodepre.getIsDeleted() || (cuentacontagastodepre.getIsChanged()&&!cuentacontagastodepre.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cuentacontagastodepreDataAccess.getSetVersionRowCuentaContaGastoDepre(connexion,cuentacontagastodepre.getId());
				
				if(!cuentacontagastodepre.getVersionRow().equals(timestamp)) {	
					cuentacontagastodepre.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cuentacontagastodepre.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCuentaContaGastoDepre()throws Exception {	
		
		if(cuentacontagastodepre.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cuentacontagastodepre.getIsDeleted() || (cuentacontagastodepre.getIsChanged()&&!cuentacontagastodepre.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cuentacontagastodepreDataAccess.getSetVersionRowCuentaContaGastoDepre(connexion,cuentacontagastodepre.getId());
			
			try {							
				if(!cuentacontagastodepre.getVersionRow().equals(timestamp)) {	
					cuentacontagastodepre.setVersionRow(timestamp);
				}
				
				cuentacontagastodepre.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCuentaContaGastoDepresWithConnection()throws Exception {	
		if(cuentacontagastodepres!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CuentaContaGastoDepre cuentacontagastodepreAux:cuentacontagastodepres) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cuentacontagastodepreAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cuentacontagastodepreAux.getIsDeleted() || (cuentacontagastodepreAux.getIsChanged()&&!cuentacontagastodepreAux.getIsNew())) {
						
						timestamp=cuentacontagastodepreDataAccess.getSetVersionRowCuentaContaGastoDepre(connexion,cuentacontagastodepreAux.getId());
						
						if(!cuentacontagastodepre.getVersionRow().equals(timestamp)) {	
							cuentacontagastodepreAux.setVersionRow(timestamp);
						}
								
						cuentacontagastodepreAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCuentaContaGastoDepres()throws Exception {	
		if(cuentacontagastodepres!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CuentaContaGastoDepre cuentacontagastodepreAux:cuentacontagastodepres) {
					if(cuentacontagastodepreAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cuentacontagastodepreAux.getIsDeleted() || (cuentacontagastodepreAux.getIsChanged()&&!cuentacontagastodepreAux.getIsNew())) {
						
						timestamp=cuentacontagastodepreDataAccess.getSetVersionRowCuentaContaGastoDepre(connexion,cuentacontagastodepreAux.getId());
						
						if(!cuentacontagastodepreAux.getVersionRow().equals(timestamp)) {	
							cuentacontagastodepreAux.setVersionRow(timestamp);
						}
						
													
						cuentacontagastodepreAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CuentaContaGastoDepreParameterReturnGeneral cargarCombosLoteForeignKeyCuentaContaGastoDepreWithConnection(String finalQueryGlobalCuentaContable,String finalQueryGlobalGastoDepreciacion) throws Exception {
		CuentaContaGastoDepreParameterReturnGeneral  cuentacontagastodepreReturnGeneral =new CuentaContaGastoDepreParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaGastoDepre.class.getSimpleName()+"-cargarCombosLoteForeignKeyCuentaContaGastoDepreWithConnection");connexion.begin();
			
			cuentacontagastodepreReturnGeneral =new CuentaContaGastoDepreParameterReturnGeneral();
			
			

			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			cuentacontagastodepreReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<GastoDepreciacion> gastodepreciacionsForeignKey=new ArrayList<GastoDepreciacion>();
			GastoDepreciacionLogic gastodepreciacionLogic=new GastoDepreciacionLogic();
			gastodepreciacionLogic.setConnexion(this.connexion);
			gastodepreciacionLogic.getGastoDepreciacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGastoDepreciacion.equals("NONE")) {
				gastodepreciacionLogic.getTodosGastoDepreciacions(finalQueryGlobalGastoDepreciacion,new Pagination());
				gastodepreciacionsForeignKey=gastodepreciacionLogic.getGastoDepreciacions();
			}

			cuentacontagastodepreReturnGeneral.setgastodepreciacionsForeignKey(gastodepreciacionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cuentacontagastodepreReturnGeneral;
	}
	
	public CuentaContaGastoDepreParameterReturnGeneral cargarCombosLoteForeignKeyCuentaContaGastoDepre(String finalQueryGlobalCuentaContable,String finalQueryGlobalGastoDepreciacion) throws Exception {
		CuentaContaGastoDepreParameterReturnGeneral  cuentacontagastodepreReturnGeneral =new CuentaContaGastoDepreParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cuentacontagastodepreReturnGeneral =new CuentaContaGastoDepreParameterReturnGeneral();
			
			

			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			cuentacontagastodepreReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<GastoDepreciacion> gastodepreciacionsForeignKey=new ArrayList<GastoDepreciacion>();
			GastoDepreciacionLogic gastodepreciacionLogic=new GastoDepreciacionLogic();
			gastodepreciacionLogic.setConnexion(this.connexion);
			gastodepreciacionLogic.getGastoDepreciacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGastoDepreciacion.equals("NONE")) {
				gastodepreciacionLogic.getTodosGastoDepreciacions(finalQueryGlobalGastoDepreciacion,new Pagination());
				gastodepreciacionsForeignKey=gastodepreciacionLogic.getGastoDepreciacions();
			}

			cuentacontagastodepreReturnGeneral.setgastodepreciacionsForeignKey(gastodepreciacionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cuentacontagastodepreReturnGeneral;
	}
	
	
	public void deepLoad(CuentaContaGastoDepre cuentacontagastodepre,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CuentaContaGastoDepreLogicAdditional.updateCuentaContaGastoDepreToGet(cuentacontagastodepre,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cuentacontagastodepre.setCuentaContable(cuentacontagastodepreDataAccess.getCuentaContable(connexion,cuentacontagastodepre));
		cuentacontagastodepre.setGastoDepreciacion(cuentacontagastodepreDataAccess.getGastoDepreciacion(connexion,cuentacontagastodepre));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				cuentacontagastodepre.setCuentaContable(cuentacontagastodepreDataAccess.getCuentaContable(connexion,cuentacontagastodepre));
				continue;
			}

			if(clas.clas.equals(GastoDepreciacion.class)) {
				cuentacontagastodepre.setGastoDepreciacion(cuentacontagastodepreDataAccess.getGastoDepreciacion(connexion,cuentacontagastodepre));
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
			cuentacontagastodepre.setCuentaContable(cuentacontagastodepreDataAccess.getCuentaContable(connexion,cuentacontagastodepre));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GastoDepreciacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontagastodepre.setGastoDepreciacion(cuentacontagastodepreDataAccess.getGastoDepreciacion(connexion,cuentacontagastodepre));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cuentacontagastodepre.setCuentaContable(cuentacontagastodepreDataAccess.getCuentaContable(connexion,cuentacontagastodepre));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(cuentacontagastodepre.getCuentaContable(),isDeep,deepLoadType,clases);
				
		cuentacontagastodepre.setGastoDepreciacion(cuentacontagastodepreDataAccess.getGastoDepreciacion(connexion,cuentacontagastodepre));
		GastoDepreciacionLogic gastodepreciacionLogic= new GastoDepreciacionLogic(connexion);
		gastodepreciacionLogic.deepLoad(cuentacontagastodepre.getGastoDepreciacion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				cuentacontagastodepre.setCuentaContable(cuentacontagastodepreDataAccess.getCuentaContable(connexion,cuentacontagastodepre));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentacontagastodepre.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GastoDepreciacion.class)) {
				cuentacontagastodepre.setGastoDepreciacion(cuentacontagastodepreDataAccess.getGastoDepreciacion(connexion,cuentacontagastodepre));
				GastoDepreciacionLogic gastodepreciacionLogic= new GastoDepreciacionLogic(connexion);
				gastodepreciacionLogic.deepLoad(cuentacontagastodepre.getGastoDepreciacion(),isDeep,deepLoadType,clases);				
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
			cuentacontagastodepre.setCuentaContable(cuentacontagastodepreDataAccess.getCuentaContable(connexion,cuentacontagastodepre));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentacontagastodepre.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(GastoDepreciacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontagastodepre.setGastoDepreciacion(cuentacontagastodepreDataAccess.getGastoDepreciacion(connexion,cuentacontagastodepre));
			GastoDepreciacionLogic gastodepreciacionLogic= new GastoDepreciacionLogic(connexion);
			gastodepreciacionLogic.deepLoad(cuentacontagastodepre.getGastoDepreciacion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CuentaContaGastoDepre cuentacontagastodepre,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CuentaContaGastoDepreLogicAdditional.updateCuentaContaGastoDepreToSave(cuentacontagastodepre,this.arrDatoGeneral);
			
CuentaContaGastoDepreDataAccess.save(cuentacontagastodepre, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		CuentaContableDataAccess.save(cuentacontagastodepre.getCuentaContable(),connexion);

		GastoDepreciacionDataAccess.save(cuentacontagastodepre.getGastoDepreciacion(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentacontagastodepre.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(GastoDepreciacion.class)) {
				GastoDepreciacionDataAccess.save(cuentacontagastodepre.getGastoDepreciacion(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		CuentaContableDataAccess.save(cuentacontagastodepre.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(cuentacontagastodepre.getCuentaContable(),isDeep,deepLoadType,clases);
				

		GastoDepreciacionDataAccess.save(cuentacontagastodepre.getGastoDepreciacion(),connexion);
		GastoDepreciacionLogic gastodepreciacionLogic= new GastoDepreciacionLogic(connexion);
		gastodepreciacionLogic.deepLoad(cuentacontagastodepre.getGastoDepreciacion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentacontagastodepre.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentacontagastodepre.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GastoDepreciacion.class)) {
				GastoDepreciacionDataAccess.save(cuentacontagastodepre.getGastoDepreciacion(),connexion);
				GastoDepreciacionLogic gastodepreciacionLogic= new GastoDepreciacionLogic(connexion);
				gastodepreciacionLogic.deepSave(cuentacontagastodepre.getGastoDepreciacion(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(CuentaContaGastoDepre.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cuentacontagastodepre,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(cuentacontagastodepre);
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
			this.deepLoad(this.cuentacontagastodepre,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(this.cuentacontagastodepre);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CuentaContaGastoDepre.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cuentacontagastodepres!=null) {
				for(CuentaContaGastoDepre cuentacontagastodepre:cuentacontagastodepres) {
					this.deepLoad(cuentacontagastodepre,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(cuentacontagastodepres);
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
			if(cuentacontagastodepres!=null) {
				for(CuentaContaGastoDepre cuentacontagastodepre:cuentacontagastodepres) {
					this.deepLoad(cuentacontagastodepre,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(cuentacontagastodepres);
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
			this.getNewConnexionToDeep(CuentaContaGastoDepre.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cuentacontagastodepre,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CuentaContaGastoDepre.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cuentacontagastodepres!=null) {
				for(CuentaContaGastoDepre cuentacontagastodepre:cuentacontagastodepres) {
					this.deepSave(cuentacontagastodepre,isDeep,deepLoadType,clases);
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
			if(cuentacontagastodepres!=null) {
				for(CuentaContaGastoDepre cuentacontagastodepre:cuentacontagastodepres) {
					this.deepSave(cuentacontagastodepre,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCuentaContaGastoDepresFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaGastoDepre.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,CuentaContaGastoDepreConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			CuentaContaGastoDepreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontagastodepres=cuentacontagastodepreDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(this.cuentacontagastodepres);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContaGastoDepresFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,CuentaContaGastoDepreConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			CuentaContaGastoDepreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontagastodepres=cuentacontagastodepreDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(this.cuentacontagastodepres);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaContaGastoDepresFK_IdGastoDepreciacionWithConnection(String sFinalQuery,Pagination pagination,Long id_gasto_depreciacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContaGastoDepre.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGastoDepreciacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGastoDepreciacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_gasto_depreciacion,CuentaContaGastoDepreConstantesFunciones.IDGASTODEPRECIACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGastoDepreciacion);

			CuentaContaGastoDepreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGastoDepreciacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontagastodepres=cuentacontagastodepreDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(this.cuentacontagastodepres);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContaGastoDepresFK_IdGastoDepreciacion(String sFinalQuery,Pagination pagination,Long id_gasto_depreciacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGastoDepreciacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGastoDepreciacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_gasto_depreciacion,CuentaContaGastoDepreConstantesFunciones.IDGASTODEPRECIACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGastoDepreciacion);

			CuentaContaGastoDepreLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGastoDepreciacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontagastodepres=cuentacontagastodepreDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(this.cuentacontagastodepres);
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
			if(CuentaContaGastoDepreConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaContaGastoDepreDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CuentaContaGastoDepre cuentacontagastodepre,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CuentaContaGastoDepreConstantesFunciones.ISCONAUDITORIA) {
				if(cuentacontagastodepre.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaContaGastoDepreDataAccess.TABLENAME, cuentacontagastodepre.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CuentaContaGastoDepreConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CuentaContaGastoDepreLogic.registrarAuditoriaDetallesCuentaContaGastoDepre(connexion,cuentacontagastodepre,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cuentacontagastodepre.getIsDeleted()) {
					/*if(!cuentacontagastodepre.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CuentaContaGastoDepreDataAccess.TABLENAME, cuentacontagastodepre.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CuentaContaGastoDepreLogic.registrarAuditoriaDetallesCuentaContaGastoDepre(connexion,cuentacontagastodepre,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaContaGastoDepreDataAccess.TABLENAME, cuentacontagastodepre.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cuentacontagastodepre.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaContaGastoDepreDataAccess.TABLENAME, cuentacontagastodepre.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CuentaContaGastoDepreConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CuentaContaGastoDepreLogic.registrarAuditoriaDetallesCuentaContaGastoDepre(connexion,cuentacontagastodepre,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCuentaContaGastoDepre(Connexion connexion,CuentaContaGastoDepre cuentacontagastodepre)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cuentacontagastodepre.getIsNew()||!cuentacontagastodepre.getid_cuenta_contable().equals(cuentacontagastodepre.getCuentaContaGastoDepreOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontagastodepre.getCuentaContaGastoDepreOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=cuentacontagastodepre.getCuentaContaGastoDepreOriginal().getid_cuenta_contable().toString();
				}
				if(cuentacontagastodepre.getid_cuenta_contable()!=null)
				{
					strValorNuevo=cuentacontagastodepre.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContaGastoDepreConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontagastodepre.getIsNew()||!cuentacontagastodepre.getid_gasto_depreciacion().equals(cuentacontagastodepre.getCuentaContaGastoDepreOriginal().getid_gasto_depreciacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontagastodepre.getCuentaContaGastoDepreOriginal().getid_gasto_depreciacion()!=null)
				{
					strValorActual=cuentacontagastodepre.getCuentaContaGastoDepreOriginal().getid_gasto_depreciacion().toString();
				}
				if(cuentacontagastodepre.getid_gasto_depreciacion()!=null)
				{
					strValorNuevo=cuentacontagastodepre.getid_gasto_depreciacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContaGastoDepreConstantesFunciones.IDGASTODEPRECIACION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCuentaContaGastoDepreRelacionesWithConnection(CuentaContaGastoDepre cuentacontagastodepre) throws Exception {

		if(!cuentacontagastodepre.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCuentaContaGastoDepreRelacionesBase(cuentacontagastodepre,true);
		}
	}

	public void saveCuentaContaGastoDepreRelaciones(CuentaContaGastoDepre cuentacontagastodepre)throws Exception {

		if(!cuentacontagastodepre.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCuentaContaGastoDepreRelacionesBase(cuentacontagastodepre,false);
		}
	}

	public void saveCuentaContaGastoDepreRelacionesBase(CuentaContaGastoDepre cuentacontagastodepre,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CuentaContaGastoDepre-saveRelacionesWithConnection");}
	

			this.setCuentaContaGastoDepre(cuentacontagastodepre);

			if(CuentaContaGastoDepreLogicAdditional.validarSaveRelaciones(cuentacontagastodepre,this)) {

				CuentaContaGastoDepreLogicAdditional.updateRelacionesToSave(cuentacontagastodepre,this);

				if((cuentacontagastodepre.getIsNew()||cuentacontagastodepre.getIsChanged())&&!cuentacontagastodepre.getIsDeleted()) {
					this.saveCuentaContaGastoDepre();
					this.saveCuentaContaGastoDepreRelacionesDetalles();

				} else if(cuentacontagastodepre.getIsDeleted()) {
					this.saveCuentaContaGastoDepreRelacionesDetalles();
					this.saveCuentaContaGastoDepre();
				}

				CuentaContaGastoDepreLogicAdditional.updateRelacionesToSaveAfter(cuentacontagastodepre,this);

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
	
	
	private void saveCuentaContaGastoDepreRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCuentaContaGastoDepre(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CuentaContaGastoDepreConstantesFunciones.getClassesForeignKeysOfCuentaContaGastoDepre(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaContaGastoDepre(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CuentaContaGastoDepreConstantesFunciones.getClassesRelationshipsOfCuentaContaGastoDepre(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

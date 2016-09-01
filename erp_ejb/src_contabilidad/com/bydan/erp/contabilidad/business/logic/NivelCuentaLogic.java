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
import com.bydan.erp.contabilidad.util.NivelCuentaConstantesFunciones;
import com.bydan.erp.contabilidad.util.NivelCuentaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.NivelCuentaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.NivelCuenta;
import com.bydan.erp.contabilidad.business.logic.NivelCuentaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class NivelCuentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(NivelCuentaLogic.class);
	
	protected NivelCuentaDataAccess nivelcuentaDataAccess; 	
	protected NivelCuenta nivelcuenta;
	protected List<NivelCuenta> nivelcuentas;
	protected Object nivelcuentaObject;	
	protected List<Object> nivelcuentasObject;
	
	public static ClassValidator<NivelCuenta> nivelcuentaValidator = new ClassValidator<NivelCuenta>(NivelCuenta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected NivelCuentaLogicAdditional nivelcuentaLogicAdditional=null;
	
	public NivelCuentaLogicAdditional getNivelCuentaLogicAdditional() {
		return this.nivelcuentaLogicAdditional;
	}
	
	public void setNivelCuentaLogicAdditional(NivelCuentaLogicAdditional nivelcuentaLogicAdditional) {
		try {
			this.nivelcuentaLogicAdditional=nivelcuentaLogicAdditional;
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
	
	
	
	
	public  NivelCuentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.nivelcuentaDataAccess = new NivelCuentaDataAccess();
			
			this.nivelcuentas= new ArrayList<NivelCuenta>();
			this.nivelcuenta= new NivelCuenta();
			
			this.nivelcuentaObject=new Object();
			this.nivelcuentasObject=new ArrayList<Object>();
				
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
			
			this.nivelcuentaDataAccess.setConnexionType(this.connexionType);
			this.nivelcuentaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  NivelCuentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.nivelcuentaDataAccess = new NivelCuentaDataAccess();
			this.nivelcuentas= new ArrayList<NivelCuenta>();
			this.nivelcuenta= new NivelCuenta();
			this.nivelcuentaObject=new Object();
			this.nivelcuentasObject=new ArrayList<Object>();
			
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
			
			this.nivelcuentaDataAccess.setConnexionType(this.connexionType);
			this.nivelcuentaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public NivelCuenta getNivelCuenta() throws Exception {	
		NivelCuentaLogicAdditional.checkNivelCuentaToGet(nivelcuenta,this.datosCliente,this.arrDatoGeneral);
		NivelCuentaLogicAdditional.updateNivelCuentaToGet(nivelcuenta,this.arrDatoGeneral);
		
		return nivelcuenta;
	}
		
	public void setNivelCuenta(NivelCuenta newNivelCuenta) {
		this.nivelcuenta = newNivelCuenta;
	}
	
	public NivelCuentaDataAccess getNivelCuentaDataAccess() {
		return nivelcuentaDataAccess;
	}
	
	public void setNivelCuentaDataAccess(NivelCuentaDataAccess newnivelcuentaDataAccess) {
		this.nivelcuentaDataAccess = newnivelcuentaDataAccess;
	}
	
	public List<NivelCuenta> getNivelCuentas() throws Exception {		
		this.quitarNivelCuentasNulos();
		
		NivelCuentaLogicAdditional.checkNivelCuentaToGets(nivelcuentas,this.datosCliente,this.arrDatoGeneral);
		
		for (NivelCuenta nivelcuentaLocal: nivelcuentas ) {
			NivelCuentaLogicAdditional.updateNivelCuentaToGet(nivelcuentaLocal,this.arrDatoGeneral);
		}
		
		return nivelcuentas;
	}
	
	public void setNivelCuentas(List<NivelCuenta> newNivelCuentas) {
		this.nivelcuentas = newNivelCuentas;
	}
	
	public Object getNivelCuentaObject() {	
		this.nivelcuentaObject=this.nivelcuentaDataAccess.getEntityObject();
		return this.nivelcuentaObject;
	}
		
	public void setNivelCuentaObject(Object newNivelCuentaObject) {
		this.nivelcuentaObject = newNivelCuentaObject;
	}
	
	public List<Object> getNivelCuentasObject() {		
		this.nivelcuentasObject=this.nivelcuentaDataAccess.getEntitiesObject();
		return this.nivelcuentasObject;
	}
		
	public void setNivelCuentasObject(List<Object> newNivelCuentasObject) {
		this.nivelcuentasObject = newNivelCuentasObject;
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
		
		if(this.nivelcuentaDataAccess!=null) {
			this.nivelcuentaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			nivelcuentaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			nivelcuentaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		nivelcuenta = new  NivelCuenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			nivelcuenta=nivelcuentaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.nivelcuenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NivelCuentaConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuenta(this.nivelcuenta);
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
		nivelcuenta = new  NivelCuenta();
		  		  
        try {
			
			nivelcuenta=nivelcuentaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.nivelcuenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NivelCuentaConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuenta(this.nivelcuenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		nivelcuenta = new  NivelCuenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			nivelcuenta=nivelcuentaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.nivelcuenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NivelCuentaConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuenta(this.nivelcuenta);
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
		nivelcuenta = new  NivelCuenta();
		  		  
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
		nivelcuenta = new  NivelCuenta();
		  		  
        try {
			
			nivelcuenta=nivelcuentaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.nivelcuenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				NivelCuentaConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuenta(this.nivelcuenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		nivelcuenta = new  NivelCuenta();
		  		  
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
		nivelcuenta = new  NivelCuenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =nivelcuentaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		nivelcuenta = new  NivelCuenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=nivelcuentaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		nivelcuenta = new  NivelCuenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =nivelcuentaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		nivelcuenta = new  NivelCuenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=nivelcuentaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		nivelcuenta = new  NivelCuenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =nivelcuentaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		nivelcuenta = new  NivelCuenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=nivelcuentaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		nivelcuentas = new  ArrayList<NivelCuenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			NivelCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuentas=nivelcuentaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNivelCuenta(nivelcuentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuenta(this.nivelcuentas);
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
		nivelcuentas = new  ArrayList<NivelCuenta>();
		  		  
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
		nivelcuentas = new  ArrayList<NivelCuenta>();
		  		  
        try {			
			NivelCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuentas=nivelcuentaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarNivelCuenta(nivelcuentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuenta(this.nivelcuentas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		nivelcuentas = new  ArrayList<NivelCuenta>();
		  		  
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
		nivelcuentas = new  ArrayList<NivelCuenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			NivelCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuentas=nivelcuentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNivelCuenta(nivelcuentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuenta(this.nivelcuentas);
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
		nivelcuentas = new  ArrayList<NivelCuenta>();
		  		  
        try {
			NivelCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuentas=nivelcuentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNivelCuenta(nivelcuentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuenta(this.nivelcuentas);
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
		nivelcuentas = new  ArrayList<NivelCuenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuentas=nivelcuentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNivelCuenta(nivelcuentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuenta(this.nivelcuentas);
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
		nivelcuentas = new  ArrayList<NivelCuenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuentas=nivelcuentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNivelCuenta(nivelcuentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuenta(this.nivelcuentas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		nivelcuenta = new  NivelCuenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuenta=nivelcuentaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNivelCuenta(nivelcuenta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuenta(this.nivelcuenta);
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
		nivelcuenta = new  NivelCuenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuenta=nivelcuentaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarNivelCuenta(nivelcuenta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuenta(this.nivelcuenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		nivelcuentas = new  ArrayList<NivelCuenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuenta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			NivelCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuentas=nivelcuentaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNivelCuenta(nivelcuentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuenta(this.nivelcuentas);
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
		nivelcuentas = new  ArrayList<NivelCuenta>();
		  		  
        try {
			NivelCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuentas=nivelcuentaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarNivelCuenta(nivelcuentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuenta(this.nivelcuentas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosNivelCuentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		nivelcuentas = new  ArrayList<NivelCuenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuenta.class.getSimpleName()+"-getTodosNivelCuentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuentas=nivelcuentaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNivelCuenta(nivelcuentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuenta(this.nivelcuentas);
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
	
	public  void  getTodosNivelCuentas(String sFinalQuery,Pagination pagination)throws Exception {
		nivelcuentas = new  ArrayList<NivelCuenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			NivelCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			nivelcuentas=nivelcuentaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarNivelCuenta(nivelcuentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				NivelCuentaConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuenta(this.nivelcuentas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarNivelCuenta(NivelCuenta nivelcuenta) throws Exception {
		Boolean estaValidado=false;
		
		if(nivelcuenta.getIsNew() || nivelcuenta.getIsChanged()) { 
			this.invalidValues = nivelcuentaValidator.getInvalidValues(nivelcuenta);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(nivelcuenta);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarNivelCuenta(List<NivelCuenta> NivelCuentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(NivelCuenta nivelcuentaLocal:nivelcuentas) {				
			estaValidadoObjeto=this.validarGuardarNivelCuenta(nivelcuentaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarNivelCuenta(List<NivelCuenta> NivelCuentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNivelCuenta(nivelcuentas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarNivelCuenta(NivelCuenta NivelCuenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarNivelCuenta(nivelcuenta)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(NivelCuenta nivelcuenta) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+nivelcuenta.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=NivelCuentaConstantesFunciones.getNivelCuentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"nivelcuenta","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(NivelCuentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(NivelCuentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveNivelCuentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuenta.class.getSimpleName()+"-saveNivelCuentaWithConnection");connexion.begin();			
			
			NivelCuentaLogicAdditional.checkNivelCuentaToSave(this.nivelcuenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NivelCuentaLogicAdditional.updateNivelCuentaToSave(this.nivelcuenta,this.arrDatoGeneral);
			
			NivelCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.nivelcuenta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowNivelCuenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNivelCuenta(this.nivelcuenta)) {
				NivelCuentaDataAccess.save(this.nivelcuenta, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.nivelcuenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NivelCuentaLogicAdditional.checkNivelCuentaToSaveAfter(this.nivelcuenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNivelCuenta();
			
			connexion.commit();			
			
			if(this.nivelcuenta.getIsDeleted()) {
				this.nivelcuenta=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveNivelCuenta()throws Exception {	
		try {	
			
			NivelCuentaLogicAdditional.checkNivelCuentaToSave(this.nivelcuenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			NivelCuentaLogicAdditional.updateNivelCuentaToSave(this.nivelcuenta,this.arrDatoGeneral);
			
			NivelCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.nivelcuenta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarNivelCuenta(this.nivelcuenta)) {			
				NivelCuentaDataAccess.save(this.nivelcuenta, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.nivelcuenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			NivelCuentaLogicAdditional.checkNivelCuentaToSaveAfter(this.nivelcuenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.nivelcuenta.getIsDeleted()) {
				this.nivelcuenta=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveNivelCuentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuenta.class.getSimpleName()+"-saveNivelCuentasWithConnection");connexion.begin();			
			
			NivelCuentaLogicAdditional.checkNivelCuentaToSaves(nivelcuentas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowNivelCuentas();
			
			Boolean validadoTodosNivelCuenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NivelCuenta nivelcuentaLocal:nivelcuentas) {		
				if(nivelcuentaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NivelCuentaLogicAdditional.updateNivelCuentaToSave(nivelcuentaLocal,this.arrDatoGeneral);
	        	
				NivelCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),nivelcuentaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNivelCuenta(nivelcuentaLocal)) {
					NivelCuentaDataAccess.save(nivelcuentaLocal, connexion);				
				} else {
					validadoTodosNivelCuenta=false;
				}
			}
			
			if(!validadoTodosNivelCuenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NivelCuentaLogicAdditional.checkNivelCuentaToSavesAfter(nivelcuentas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowNivelCuentas();
			
			connexion.commit();		
			
			this.quitarNivelCuentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveNivelCuentas()throws Exception {				
		 try {	
			NivelCuentaLogicAdditional.checkNivelCuentaToSaves(nivelcuentas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosNivelCuenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(NivelCuenta nivelcuentaLocal:nivelcuentas) {				
				if(nivelcuentaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				NivelCuentaLogicAdditional.updateNivelCuentaToSave(nivelcuentaLocal,this.arrDatoGeneral);
	        	
				NivelCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),nivelcuentaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarNivelCuenta(nivelcuentaLocal)) {				
					NivelCuentaDataAccess.save(nivelcuentaLocal, connexion);				
				} else {
					validadoTodosNivelCuenta=false;
				}
			}
			
			if(!validadoTodosNivelCuenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			NivelCuentaLogicAdditional.checkNivelCuentaToSavesAfter(nivelcuentas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarNivelCuentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NivelCuentaParameterReturnGeneral procesarAccionNivelCuentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NivelCuenta> nivelcuentas,NivelCuentaParameterReturnGeneral nivelcuentaParameterGeneral)throws Exception {
		 try {	
			NivelCuentaParameterReturnGeneral nivelcuentaReturnGeneral=new NivelCuentaParameterReturnGeneral();
	
			NivelCuentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,nivelcuentas,nivelcuentaParameterGeneral,nivelcuentaReturnGeneral);
			
			return nivelcuentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public NivelCuentaParameterReturnGeneral procesarAccionNivelCuentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<NivelCuenta> nivelcuentas,NivelCuentaParameterReturnGeneral nivelcuentaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuenta.class.getSimpleName()+"-procesarAccionNivelCuentasWithConnection");connexion.begin();			
			
			NivelCuentaParameterReturnGeneral nivelcuentaReturnGeneral=new NivelCuentaParameterReturnGeneral();
	
			NivelCuentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,nivelcuentas,nivelcuentaParameterGeneral,nivelcuentaReturnGeneral);
			
			this.connexion.commit();
			
			return nivelcuentaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NivelCuentaParameterReturnGeneral procesarEventosNivelCuentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NivelCuenta> nivelcuentas,NivelCuenta nivelcuenta,NivelCuentaParameterReturnGeneral nivelcuentaParameterGeneral,Boolean isEsNuevoNivelCuenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			NivelCuentaParameterReturnGeneral nivelcuentaReturnGeneral=new NivelCuentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				nivelcuentaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NivelCuentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,nivelcuentas,nivelcuenta,nivelcuentaParameterGeneral,nivelcuentaReturnGeneral,isEsNuevoNivelCuenta,clases);
			
			return nivelcuentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public NivelCuentaParameterReturnGeneral procesarEventosNivelCuentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<NivelCuenta> nivelcuentas,NivelCuenta nivelcuenta,NivelCuentaParameterReturnGeneral nivelcuentaParameterGeneral,Boolean isEsNuevoNivelCuenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuenta.class.getSimpleName()+"-procesarEventosNivelCuentasWithConnection");connexion.begin();			
			
			NivelCuentaParameterReturnGeneral nivelcuentaReturnGeneral=new NivelCuentaParameterReturnGeneral();
	
			nivelcuentaReturnGeneral.setNivelCuenta(nivelcuenta);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				nivelcuentaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			NivelCuentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,nivelcuentas,nivelcuenta,nivelcuentaParameterGeneral,nivelcuentaReturnGeneral,isEsNuevoNivelCuenta,clases);
			
			this.connexion.commit();
			
			return nivelcuentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public NivelCuentaParameterReturnGeneral procesarImportacionNivelCuentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,NivelCuentaParameterReturnGeneral nivelcuentaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuenta.class.getSimpleName()+"-procesarImportacionNivelCuentasWithConnection");connexion.begin();			
			
			NivelCuentaParameterReturnGeneral nivelcuentaReturnGeneral=new NivelCuentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.nivelcuentas=new ArrayList<NivelCuenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.nivelcuenta=new NivelCuenta();
				
				
				if(conColumnasBase) {this.nivelcuenta.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.nivelcuenta.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.nivelcuenta.setnombre(arrColumnas[iColumn++]);
				
				this.nivelcuentas.add(this.nivelcuenta);
			}
			
			this.saveNivelCuentas();
			
			this.connexion.commit();
			
			nivelcuentaReturnGeneral.setConRetornoEstaProcesado(true);
			nivelcuentaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return nivelcuentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarNivelCuentasEliminados() throws Exception {				
		
		List<NivelCuenta> nivelcuentasAux= new ArrayList<NivelCuenta>();
		
		for(NivelCuenta nivelcuenta:nivelcuentas) {
			if(!nivelcuenta.getIsDeleted()) {
				nivelcuentasAux.add(nivelcuenta);
			}
		}
		
		nivelcuentas=nivelcuentasAux;
	}
	
	public void quitarNivelCuentasNulos() throws Exception {				
		
		List<NivelCuenta> nivelcuentasAux= new ArrayList<NivelCuenta>();
		
		for(NivelCuenta nivelcuenta : this.nivelcuentas) {
			if(nivelcuenta==null) {
				nivelcuentasAux.add(nivelcuenta);
			}
		}
		
		//this.nivelcuentas=nivelcuentasAux;
		
		this.nivelcuentas.removeAll(nivelcuentasAux);
	}
	
	public void getSetVersionRowNivelCuentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(nivelcuenta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((nivelcuenta.getIsDeleted() || (nivelcuenta.getIsChanged()&&!nivelcuenta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=nivelcuentaDataAccess.getSetVersionRowNivelCuenta(connexion,nivelcuenta.getId());
				
				if(!nivelcuenta.getVersionRow().equals(timestamp)) {	
					nivelcuenta.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				nivelcuenta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowNivelCuenta()throws Exception {	
		
		if(nivelcuenta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((nivelcuenta.getIsDeleted() || (nivelcuenta.getIsChanged()&&!nivelcuenta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=nivelcuentaDataAccess.getSetVersionRowNivelCuenta(connexion,nivelcuenta.getId());
			
			try {							
				if(!nivelcuenta.getVersionRow().equals(timestamp)) {	
					nivelcuenta.setVersionRow(timestamp);
				}
				
				nivelcuenta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowNivelCuentasWithConnection()throws Exception {	
		if(nivelcuentas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(NivelCuenta nivelcuentaAux:nivelcuentas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(nivelcuentaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(nivelcuentaAux.getIsDeleted() || (nivelcuentaAux.getIsChanged()&&!nivelcuentaAux.getIsNew())) {
						
						timestamp=nivelcuentaDataAccess.getSetVersionRowNivelCuenta(connexion,nivelcuentaAux.getId());
						
						if(!nivelcuenta.getVersionRow().equals(timestamp)) {	
							nivelcuentaAux.setVersionRow(timestamp);
						}
								
						nivelcuentaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowNivelCuentas()throws Exception {	
		if(nivelcuentas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(NivelCuenta nivelcuentaAux:nivelcuentas) {
					if(nivelcuentaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(nivelcuentaAux.getIsDeleted() || (nivelcuentaAux.getIsChanged()&&!nivelcuentaAux.getIsNew())) {
						
						timestamp=nivelcuentaDataAccess.getSetVersionRowNivelCuenta(connexion,nivelcuentaAux.getId());
						
						if(!nivelcuentaAux.getVersionRow().equals(timestamp)) {	
							nivelcuentaAux.setVersionRow(timestamp);
						}
						
													
						nivelcuentaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyNivelCuentaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuenta.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyNivelCuentaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(CuentaContable.class));
											
			

			cuentacontableLogic.setConnexion(this.getConnexion());
			cuentacontableLogic.setDatosCliente(this.datosCliente);
			cuentacontableLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(NivelCuenta nivelcuenta:this.nivelcuentas) {
				

				classes=new ArrayList<Classe>();
				classes=CuentaContableConstantesFunciones.getClassesForeignKeysOfCuentaContable(new ArrayList<Classe>(),DeepLoadType.NONE);

				cuentacontableLogic.setCuentaContables(nivelcuenta.cuentacontables);
				cuentacontableLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(NivelCuenta nivelcuenta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			NivelCuentaLogicAdditional.updateNivelCuentaToGet(nivelcuenta,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		nivelcuenta.setCuentaContables(nivelcuentaDataAccess.getCuentaContables(connexion,nivelcuenta));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				nivelcuenta.setCuentaContables(nivelcuentaDataAccess.getCuentaContables(connexion,nivelcuenta));

				if(this.isConDeep) {
					CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(this.connexion);
					cuentacontableLogic.setCuentaContables(nivelcuenta.getCuentaContables());
					ArrayList<Classe> classesLocal=CuentaContableConstantesFunciones.getClassesForeignKeysOfCuentaContable(new ArrayList<Classe>(),DeepLoadType.NONE);
					cuentacontableLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(cuentacontableLogic.getCuentaContables());
					nivelcuenta.setCuentaContables(cuentacontableLogic.getCuentaContables());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CuentaContable.class));
			nivelcuenta.setCuentaContables(nivelcuentaDataAccess.getCuentaContables(connexion,nivelcuenta));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		nivelcuenta.setCuentaContables(nivelcuentaDataAccess.getCuentaContables(connexion,nivelcuenta));

		for(CuentaContable cuentacontable:nivelcuenta.getCuentaContables()) {
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentacontable,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				nivelcuenta.setCuentaContables(nivelcuentaDataAccess.getCuentaContables(connexion,nivelcuenta));

				for(CuentaContable cuentacontable:nivelcuenta.getCuentaContables()) {
					CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
					cuentacontableLogic.deepLoad(cuentacontable,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CuentaContable.class));
			nivelcuenta.setCuentaContables(nivelcuentaDataAccess.getCuentaContables(connexion,nivelcuenta));

			for(CuentaContable cuentacontable:nivelcuenta.getCuentaContables()) {
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentacontable,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(NivelCuenta nivelcuenta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			NivelCuentaLogicAdditional.updateNivelCuentaToSave(nivelcuenta,this.arrDatoGeneral);
			
NivelCuentaDataAccess.save(nivelcuenta, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(CuentaContable cuentacontable:nivelcuenta.getCuentaContables()) {
			cuentacontable.setid_nivel_cuenta(nivelcuenta.getId());
			CuentaContableDataAccess.save(cuentacontable,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(CuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CuentaContable cuentacontable:nivelcuenta.getCuentaContables()) {
					cuentacontable.setid_nivel_cuenta(nivelcuenta.getId());
					CuentaContableDataAccess.save(cuentacontable,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(CuentaContable cuentacontable:nivelcuenta.getCuentaContables()) {
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontable.setid_nivel_cuenta(nivelcuenta.getId());
			CuentaContableDataAccess.save(cuentacontable,connexion);
			cuentacontableLogic.deepSave(cuentacontable,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(CuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CuentaContable cuentacontable:nivelcuenta.getCuentaContables()) {
					CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
					cuentacontable.setid_nivel_cuenta(nivelcuenta.getId());
					CuentaContableDataAccess.save(cuentacontable,connexion);
					cuentacontableLogic.deepSave(cuentacontable,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(NivelCuenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(nivelcuenta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NivelCuentaConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuenta(nivelcuenta);
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
			this.deepLoad(this.nivelcuenta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				NivelCuentaConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuenta(this.nivelcuenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(NivelCuenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(nivelcuentas!=null) {
				for(NivelCuenta nivelcuenta:nivelcuentas) {
					this.deepLoad(nivelcuenta,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					NivelCuentaConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuenta(nivelcuentas);
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
			if(nivelcuentas!=null) {
				for(NivelCuenta nivelcuenta:nivelcuentas) {
					this.deepLoad(nivelcuenta,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					NivelCuentaConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuenta(nivelcuentas);
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
			this.getNewConnexionToDeep(NivelCuenta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(nivelcuenta,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(NivelCuenta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(nivelcuentas!=null) {
				for(NivelCuenta nivelcuenta:nivelcuentas) {
					this.deepSave(nivelcuenta,isDeep,deepLoadType,clases);
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
			if(nivelcuentas!=null) {
				for(NivelCuenta nivelcuenta:nivelcuentas) {
					this.deepSave(nivelcuenta,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getNivelCuentaPorNombreWithConnection(String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,NivelCuenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,NivelCuentaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			nivelcuenta=nivelcuentaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.nivelcuenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				NivelCuentaConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuenta(this.nivelcuenta);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getNivelCuentaPorNombre(String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,NivelCuentaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			nivelcuenta=nivelcuentaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.nivelcuenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				NivelCuentaConstantesFunciones.refrescarForeignKeysDescripcionesNivelCuenta(this.nivelcuenta);
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
			if(NivelCuentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,NivelCuentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,NivelCuenta nivelcuenta,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(NivelCuentaConstantesFunciones.ISCONAUDITORIA) {
				if(nivelcuenta.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NivelCuentaDataAccess.TABLENAME, nivelcuenta.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NivelCuentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NivelCuentaLogic.registrarAuditoriaDetallesNivelCuenta(connexion,nivelcuenta,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(nivelcuenta.getIsDeleted()) {
					/*if(!nivelcuenta.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,NivelCuentaDataAccess.TABLENAME, nivelcuenta.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////NivelCuentaLogic.registrarAuditoriaDetallesNivelCuenta(connexion,nivelcuenta,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NivelCuentaDataAccess.TABLENAME, nivelcuenta.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(nivelcuenta.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,NivelCuentaDataAccess.TABLENAME, nivelcuenta.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(NivelCuentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////NivelCuentaLogic.registrarAuditoriaDetallesNivelCuenta(connexion,nivelcuenta,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesNivelCuenta(Connexion connexion,NivelCuenta nivelcuenta)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(nivelcuenta.getIsNew()||!nivelcuenta.getnombre().equals(nivelcuenta.getNivelCuentaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(nivelcuenta.getNivelCuentaOriginal().getnombre()!=null)
				{
					strValorActual=nivelcuenta.getNivelCuentaOriginal().getnombre();
				}
				if(nivelcuenta.getnombre()!=null)
				{
					strValorNuevo=nivelcuenta.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),NivelCuentaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveNivelCuentaRelacionesWithConnection(NivelCuenta nivelcuenta,List<CuentaContable> cuentacontables) throws Exception {

		if(!nivelcuenta.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNivelCuentaRelacionesBase(nivelcuenta,cuentacontables,true);
		}
	}

	public void saveNivelCuentaRelaciones(NivelCuenta nivelcuenta,List<CuentaContable> cuentacontables)throws Exception {

		if(!nivelcuenta.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveNivelCuentaRelacionesBase(nivelcuenta,cuentacontables,false);
		}
	}

	public void saveNivelCuentaRelacionesBase(NivelCuenta nivelcuenta,List<CuentaContable> cuentacontables,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("NivelCuenta-saveRelacionesWithConnection");}
	
			nivelcuenta.setCuentaContables(cuentacontables);

			this.setNivelCuenta(nivelcuenta);

				if((nivelcuenta.getIsNew()||nivelcuenta.getIsChanged())&&!nivelcuenta.getIsDeleted()) {
					this.saveNivelCuenta();
					this.saveNivelCuentaRelacionesDetalles(cuentacontables);

				} else if(nivelcuenta.getIsDeleted()) {
					this.saveNivelCuentaRelacionesDetalles(cuentacontables);
					this.saveNivelCuenta();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			CuentaContableConstantesFunciones.InicializarGeneralEntityAuxiliaresCuentaContables(cuentacontables,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveNivelCuentaRelacionesDetalles(List<CuentaContable> cuentacontables)throws Exception {
		try {
	

			Long idNivelCuentaActual=this.getNivelCuenta().getId();

			CuentaContableLogic cuentacontableLogic_Desde_NivelCuenta=new CuentaContableLogic();
			cuentacontableLogic_Desde_NivelCuenta.setCuentaContables(cuentacontables);

			cuentacontableLogic_Desde_NivelCuenta.setConnexion(this.getConnexion());
			cuentacontableLogic_Desde_NivelCuenta.setDatosCliente(this.datosCliente);

			for(CuentaContable cuentacontable_Desde_NivelCuenta:cuentacontableLogic_Desde_NivelCuenta.getCuentaContables()) {
				cuentacontable_Desde_NivelCuenta.setid_nivel_cuenta(idNivelCuentaActual);
			}

			cuentacontableLogic_Desde_NivelCuenta.saveCuentaContables();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfNivelCuenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NivelCuentaConstantesFunciones.getClassesForeignKeysOfNivelCuenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfNivelCuenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=NivelCuentaConstantesFunciones.getClassesRelationshipsOfNivelCuenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

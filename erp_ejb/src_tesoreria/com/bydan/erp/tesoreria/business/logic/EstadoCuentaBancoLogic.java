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
import com.bydan.erp.tesoreria.util.EstadoCuentaBancoConstantesFunciones;
import com.bydan.erp.tesoreria.util.EstadoCuentaBancoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.EstadoCuentaBancoParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.EstadoCuentaBanco;
//import com.bydan.erp.tesoreria.business.logic.EstadoCuentaBancoLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

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
public class EstadoCuentaBancoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoCuentaBancoLogic.class);
	
	protected EstadoCuentaBancoDataAccess estadocuentabancoDataAccess; 	
	protected EstadoCuentaBanco estadocuentabanco;
	protected List<EstadoCuentaBanco> estadocuentabancos;
	protected Object estadocuentabancoObject;	
	protected List<Object> estadocuentabancosObject;
	
	public static ClassValidator<EstadoCuentaBanco> estadocuentabancoValidator = new ClassValidator<EstadoCuentaBanco>(EstadoCuentaBanco.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
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
	
	
	
	
	public  EstadoCuentaBancoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadocuentabancoDataAccess = new EstadoCuentaBancoDataAccess();
			
			this.estadocuentabancos= new ArrayList<EstadoCuentaBanco>();
			this.estadocuentabanco= new EstadoCuentaBanco();
			
			this.estadocuentabancoObject=new Object();
			this.estadocuentabancosObject=new ArrayList<Object>();
				
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
			
			this.estadocuentabancoDataAccess.setConnexionType(this.connexionType);
			this.estadocuentabancoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoCuentaBancoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadocuentabancoDataAccess = new EstadoCuentaBancoDataAccess();
			this.estadocuentabancos= new ArrayList<EstadoCuentaBanco>();
			this.estadocuentabanco= new EstadoCuentaBanco();
			this.estadocuentabancoObject=new Object();
			this.estadocuentabancosObject=new ArrayList<Object>();
			
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
			
			this.estadocuentabancoDataAccess.setConnexionType(this.connexionType);
			this.estadocuentabancoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoCuentaBanco getEstadoCuentaBanco() throws Exception {	
		//EstadoCuentaBancoLogicAdditional.checkEstadoCuentaBancoToGet(estadocuentabanco,this.datosCliente,this.arrDatoGeneral);
		//EstadoCuentaBancoLogicAdditional.updateEstadoCuentaBancoToGet(estadocuentabanco,this.arrDatoGeneral);
		
		return estadocuentabanco;
	}
		
	public void setEstadoCuentaBanco(EstadoCuentaBanco newEstadoCuentaBanco) {
		this.estadocuentabanco = newEstadoCuentaBanco;
	}
	
	public EstadoCuentaBancoDataAccess getEstadoCuentaBancoDataAccess() {
		return estadocuentabancoDataAccess;
	}
	
	public void setEstadoCuentaBancoDataAccess(EstadoCuentaBancoDataAccess newestadocuentabancoDataAccess) {
		this.estadocuentabancoDataAccess = newestadocuentabancoDataAccess;
	}
	
	public List<EstadoCuentaBanco> getEstadoCuentaBancos() throws Exception {		
		this.quitarEstadoCuentaBancosNulos();
		
		//EstadoCuentaBancoLogicAdditional.checkEstadoCuentaBancoToGets(estadocuentabancos,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoCuentaBanco estadocuentabancoLocal: estadocuentabancos ) {
			//EstadoCuentaBancoLogicAdditional.updateEstadoCuentaBancoToGet(estadocuentabancoLocal,this.arrDatoGeneral);
		}
		
		return estadocuentabancos;
	}
	
	public void setEstadoCuentaBancos(List<EstadoCuentaBanco> newEstadoCuentaBancos) {
		this.estadocuentabancos = newEstadoCuentaBancos;
	}
	
	public Object getEstadoCuentaBancoObject() {	
		this.estadocuentabancoObject=this.estadocuentabancoDataAccess.getEntityObject();
		return this.estadocuentabancoObject;
	}
		
	public void setEstadoCuentaBancoObject(Object newEstadoCuentaBancoObject) {
		this.estadocuentabancoObject = newEstadoCuentaBancoObject;
	}
	
	public List<Object> getEstadoCuentaBancosObject() {		
		this.estadocuentabancosObject=this.estadocuentabancoDataAccess.getEntitiesObject();
		return this.estadocuentabancosObject;
	}
		
	public void setEstadoCuentaBancosObject(List<Object> newEstadoCuentaBancosObject) {
		this.estadocuentabancosObject = newEstadoCuentaBancosObject;
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
		
		if(this.estadocuentabancoDataAccess!=null) {
			this.estadocuentabancoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuentaBanco.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadocuentabancoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadocuentabancoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadocuentabanco = new  EstadoCuentaBanco();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuentaBanco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadocuentabanco=estadocuentabancoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadocuentabanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuentaBanco(this.estadocuentabanco);
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
		estadocuentabanco = new  EstadoCuentaBanco();
		  		  
        try {
			
			estadocuentabanco=estadocuentabancoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadocuentabanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuentaBanco(this.estadocuentabanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadocuentabanco = new  EstadoCuentaBanco();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuentaBanco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadocuentabanco=estadocuentabancoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadocuentabanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuentaBanco(this.estadocuentabanco);
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
		estadocuentabanco = new  EstadoCuentaBanco();
		  		  
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
		estadocuentabanco = new  EstadoCuentaBanco();
		  		  
        try {
			
			estadocuentabanco=estadocuentabancoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadocuentabanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuentaBanco(this.estadocuentabanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadocuentabanco = new  EstadoCuentaBanco();
		  		  
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
		estadocuentabanco = new  EstadoCuentaBanco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuentaBanco.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadocuentabancoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadocuentabanco = new  EstadoCuentaBanco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadocuentabancoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadocuentabanco = new  EstadoCuentaBanco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuentaBanco.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadocuentabancoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadocuentabanco = new  EstadoCuentaBanco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadocuentabancoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadocuentabanco = new  EstadoCuentaBanco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuentaBanco.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadocuentabancoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadocuentabanco = new  EstadoCuentaBanco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadocuentabancoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadocuentabancos = new  ArrayList<EstadoCuentaBanco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuentaBanco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocuentabancos=estadocuentabancoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoCuentaBanco(estadocuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuentaBanco(this.estadocuentabancos);
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
		estadocuentabancos = new  ArrayList<EstadoCuentaBanco>();
		  		  
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
		estadocuentabancos = new  ArrayList<EstadoCuentaBanco>();
		  		  
        try {			
			EstadoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocuentabancos=estadocuentabancoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoCuentaBanco(estadocuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuentaBanco(this.estadocuentabancos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadocuentabancos = new  ArrayList<EstadoCuentaBanco>();
		  		  
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
		estadocuentabancos = new  ArrayList<EstadoCuentaBanco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuentaBanco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocuentabancos=estadocuentabancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoCuentaBanco(estadocuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuentaBanco(this.estadocuentabancos);
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
		estadocuentabancos = new  ArrayList<EstadoCuentaBanco>();
		  		  
        try {
			EstadoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocuentabancos=estadocuentabancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoCuentaBanco(estadocuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuentaBanco(this.estadocuentabancos);
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
		estadocuentabancos = new  ArrayList<EstadoCuentaBanco>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuentaBanco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocuentabancos=estadocuentabancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoCuentaBanco(estadocuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuentaBanco(this.estadocuentabancos);
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
		estadocuentabancos = new  ArrayList<EstadoCuentaBanco>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocuentabancos=estadocuentabancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoCuentaBanco(estadocuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuentaBanco(this.estadocuentabancos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadocuentabanco = new  EstadoCuentaBanco();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuentaBanco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocuentabanco=estadocuentabancoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoCuentaBanco(estadocuentabanco);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuentaBanco(this.estadocuentabanco);
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
		estadocuentabanco = new  EstadoCuentaBanco();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocuentabanco=estadocuentabancoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoCuentaBanco(estadocuentabanco);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuentaBanco(this.estadocuentabanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosEstadoCuentaBancosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadocuentabancos = new  ArrayList<EstadoCuentaBanco>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuentaBanco.class.getSimpleName()+"-getTodosEstadoCuentaBancosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocuentabancos=estadocuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoCuentaBanco(estadocuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuentaBanco(this.estadocuentabancos);
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
	
	public  void  getTodosEstadoCuentaBancos(String sFinalQuery,Pagination pagination)throws Exception {
		estadocuentabancos = new  ArrayList<EstadoCuentaBanco>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocuentabancos=estadocuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoCuentaBanco(estadocuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuentaBanco(this.estadocuentabancos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoCuentaBanco(EstadoCuentaBanco estadocuentabanco) throws Exception {
		Boolean estaValidado=false;
		
		if(estadocuentabanco.getIsNew() || estadocuentabanco.getIsChanged()) { 
			this.invalidValues = estadocuentabancoValidator.getInvalidValues(estadocuentabanco);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadocuentabanco);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoCuentaBanco(List<EstadoCuentaBanco> EstadoCuentaBancos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoCuentaBanco estadocuentabancoLocal:estadocuentabancos) {				
			estaValidadoObjeto=this.validarGuardarEstadoCuentaBanco(estadocuentabancoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoCuentaBanco(List<EstadoCuentaBanco> EstadoCuentaBancos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoCuentaBanco(estadocuentabancos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoCuentaBanco(EstadoCuentaBanco EstadoCuentaBanco) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoCuentaBanco(estadocuentabanco)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoCuentaBanco estadocuentabanco) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadocuentabanco.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoCuentaBancoConstantesFunciones.getEstadoCuentaBancoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadocuentabanco","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoCuentaBancoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoCuentaBancoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoCuentaBancoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuentaBanco.class.getSimpleName()+"-saveEstadoCuentaBancoWithConnection");connexion.begin();			
			
			//EstadoCuentaBancoLogicAdditional.checkEstadoCuentaBancoToSave(this.estadocuentabanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoCuentaBancoLogicAdditional.updateEstadoCuentaBancoToSave(this.estadocuentabanco,this.arrDatoGeneral);
			
			EstadoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadocuentabanco,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoCuentaBanco();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoCuentaBanco(this.estadocuentabanco)) {
				EstadoCuentaBancoDataAccess.save(this.estadocuentabanco, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadocuentabanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoCuentaBancoLogicAdditional.checkEstadoCuentaBancoToSaveAfter(this.estadocuentabanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoCuentaBanco();
			
			connexion.commit();			
			
			if(this.estadocuentabanco.getIsDeleted()) {
				this.estadocuentabanco=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoCuentaBanco()throws Exception {	
		try {	
			
			//EstadoCuentaBancoLogicAdditional.checkEstadoCuentaBancoToSave(this.estadocuentabanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoCuentaBancoLogicAdditional.updateEstadoCuentaBancoToSave(this.estadocuentabanco,this.arrDatoGeneral);
			
			EstadoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadocuentabanco,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoCuentaBanco(this.estadocuentabanco)) {			
				EstadoCuentaBancoDataAccess.save(this.estadocuentabanco, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadocuentabanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoCuentaBancoLogicAdditional.checkEstadoCuentaBancoToSaveAfter(this.estadocuentabanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadocuentabanco.getIsDeleted()) {
				this.estadocuentabanco=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoCuentaBancosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuentaBanco.class.getSimpleName()+"-saveEstadoCuentaBancosWithConnection");connexion.begin();			
			
			//EstadoCuentaBancoLogicAdditional.checkEstadoCuentaBancoToSaves(estadocuentabancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoCuentaBancos();
			
			Boolean validadoTodosEstadoCuentaBanco=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoCuentaBanco estadocuentabancoLocal:estadocuentabancos) {		
				if(estadocuentabancoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoCuentaBancoLogicAdditional.updateEstadoCuentaBancoToSave(estadocuentabancoLocal,this.arrDatoGeneral);
	        	
				EstadoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadocuentabancoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoCuentaBanco(estadocuentabancoLocal)) {
					EstadoCuentaBancoDataAccess.save(estadocuentabancoLocal, connexion);				
				} else {
					validadoTodosEstadoCuentaBanco=false;
				}
			}
			
			if(!validadoTodosEstadoCuentaBanco) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoCuentaBancoLogicAdditional.checkEstadoCuentaBancoToSavesAfter(estadocuentabancos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoCuentaBancos();
			
			connexion.commit();		
			
			this.quitarEstadoCuentaBancosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoCuentaBancos()throws Exception {				
		 try {	
			//EstadoCuentaBancoLogicAdditional.checkEstadoCuentaBancoToSaves(estadocuentabancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoCuentaBanco=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoCuentaBanco estadocuentabancoLocal:estadocuentabancos) {				
				if(estadocuentabancoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoCuentaBancoLogicAdditional.updateEstadoCuentaBancoToSave(estadocuentabancoLocal,this.arrDatoGeneral);
	        	
				EstadoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadocuentabancoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoCuentaBanco(estadocuentabancoLocal)) {				
					EstadoCuentaBancoDataAccess.save(estadocuentabancoLocal, connexion);				
				} else {
					validadoTodosEstadoCuentaBanco=false;
				}
			}
			
			if(!validadoTodosEstadoCuentaBanco) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoCuentaBancoLogicAdditional.checkEstadoCuentaBancoToSavesAfter(estadocuentabancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoCuentaBancosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoCuentaBancoParameterReturnGeneral procesarAccionEstadoCuentaBancos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoCuentaBanco> estadocuentabancos,EstadoCuentaBancoParameterReturnGeneral estadocuentabancoParameterGeneral)throws Exception {
		 try {	
			EstadoCuentaBancoParameterReturnGeneral estadocuentabancoReturnGeneral=new EstadoCuentaBancoParameterReturnGeneral();
	
			
			return estadocuentabancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoCuentaBancoParameterReturnGeneral procesarAccionEstadoCuentaBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoCuentaBanco> estadocuentabancos,EstadoCuentaBancoParameterReturnGeneral estadocuentabancoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuentaBanco.class.getSimpleName()+"-procesarAccionEstadoCuentaBancosWithConnection");connexion.begin();			
			
			EstadoCuentaBancoParameterReturnGeneral estadocuentabancoReturnGeneral=new EstadoCuentaBancoParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return estadocuentabancoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoCuentaBancoParameterReturnGeneral procesarEventosEstadoCuentaBancos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoCuentaBanco> estadocuentabancos,EstadoCuentaBanco estadocuentabanco,EstadoCuentaBancoParameterReturnGeneral estadocuentabancoParameterGeneral,Boolean isEsNuevoEstadoCuentaBanco,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoCuentaBancoParameterReturnGeneral estadocuentabancoReturnGeneral=new EstadoCuentaBancoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadocuentabancoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return estadocuentabancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoCuentaBancoParameterReturnGeneral procesarEventosEstadoCuentaBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoCuentaBanco> estadocuentabancos,EstadoCuentaBanco estadocuentabanco,EstadoCuentaBancoParameterReturnGeneral estadocuentabancoParameterGeneral,Boolean isEsNuevoEstadoCuentaBanco,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuentaBanco.class.getSimpleName()+"-procesarEventosEstadoCuentaBancosWithConnection");connexion.begin();			
			
			EstadoCuentaBancoParameterReturnGeneral estadocuentabancoReturnGeneral=new EstadoCuentaBancoParameterReturnGeneral();
	
			estadocuentabancoReturnGeneral.setEstadoCuentaBanco(estadocuentabanco);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadocuentabancoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return estadocuentabancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoCuentaBancoParameterReturnGeneral procesarImportacionEstadoCuentaBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoCuentaBancoParameterReturnGeneral estadocuentabancoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuentaBanco.class.getSimpleName()+"-procesarImportacionEstadoCuentaBancosWithConnection");connexion.begin();			
			
			EstadoCuentaBancoParameterReturnGeneral estadocuentabancoReturnGeneral=new EstadoCuentaBancoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadocuentabancos=new ArrayList<EstadoCuentaBanco>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadocuentabanco=new EstadoCuentaBanco();
				
				
				if(conColumnasBase) {this.estadocuentabanco.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadocuentabanco.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadocuentabanco.setcodigo(arrColumnas[iColumn++]);
				this.estadocuentabanco.setnombre(arrColumnas[iColumn++]);
				this.estadocuentabanco.setes_defecto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.estadocuentabancos.add(this.estadocuentabanco);
			}
			
			this.saveEstadoCuentaBancos();
			
			this.connexion.commit();
			
			estadocuentabancoReturnGeneral.setConRetornoEstaProcesado(true);
			estadocuentabancoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadocuentabancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoCuentaBancosEliminados() throws Exception {				
		
		List<EstadoCuentaBanco> estadocuentabancosAux= new ArrayList<EstadoCuentaBanco>();
		
		for(EstadoCuentaBanco estadocuentabanco:estadocuentabancos) {
			if(!estadocuentabanco.getIsDeleted()) {
				estadocuentabancosAux.add(estadocuentabanco);
			}
		}
		
		estadocuentabancos=estadocuentabancosAux;
	}
	
	public void quitarEstadoCuentaBancosNulos() throws Exception {				
		
		List<EstadoCuentaBanco> estadocuentabancosAux= new ArrayList<EstadoCuentaBanco>();
		
		for(EstadoCuentaBanco estadocuentabanco : this.estadocuentabancos) {
			if(estadocuentabanco==null) {
				estadocuentabancosAux.add(estadocuentabanco);
			}
		}
		
		//this.estadocuentabancos=estadocuentabancosAux;
		
		this.estadocuentabancos.removeAll(estadocuentabancosAux);
	}
	
	public void getSetVersionRowEstadoCuentaBancoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadocuentabanco.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadocuentabanco.getIsDeleted() || (estadocuentabanco.getIsChanged()&&!estadocuentabanco.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadocuentabancoDataAccess.getSetVersionRowEstadoCuentaBanco(connexion,estadocuentabanco.getId());
				
				if(!estadocuentabanco.getVersionRow().equals(timestamp)) {	
					estadocuentabanco.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadocuentabanco.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoCuentaBanco()throws Exception {	
		
		if(estadocuentabanco.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadocuentabanco.getIsDeleted() || (estadocuentabanco.getIsChanged()&&!estadocuentabanco.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadocuentabancoDataAccess.getSetVersionRowEstadoCuentaBanco(connexion,estadocuentabanco.getId());
			
			try {							
				if(!estadocuentabanco.getVersionRow().equals(timestamp)) {	
					estadocuentabanco.setVersionRow(timestamp);
				}
				
				estadocuentabanco.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoCuentaBancosWithConnection()throws Exception {	
		if(estadocuentabancos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoCuentaBanco estadocuentabancoAux:estadocuentabancos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadocuentabancoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadocuentabancoAux.getIsDeleted() || (estadocuentabancoAux.getIsChanged()&&!estadocuentabancoAux.getIsNew())) {
						
						timestamp=estadocuentabancoDataAccess.getSetVersionRowEstadoCuentaBanco(connexion,estadocuentabancoAux.getId());
						
						if(!estadocuentabanco.getVersionRow().equals(timestamp)) {	
							estadocuentabancoAux.setVersionRow(timestamp);
						}
								
						estadocuentabancoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoCuentaBancos()throws Exception {	
		if(estadocuentabancos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoCuentaBanco estadocuentabancoAux:estadocuentabancos) {
					if(estadocuentabancoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadocuentabancoAux.getIsDeleted() || (estadocuentabancoAux.getIsChanged()&&!estadocuentabancoAux.getIsNew())) {
						
						timestamp=estadocuentabancoDataAccess.getSetVersionRowEstadoCuentaBanco(connexion,estadocuentabancoAux.getId());
						
						if(!estadocuentabancoAux.getVersionRow().equals(timestamp)) {	
							estadocuentabancoAux.setVersionRow(timestamp);
						}
						
													
						estadocuentabancoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(EstadoCuentaBanco estadocuentabanco,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//EstadoCuentaBancoLogicAdditional.updateEstadoCuentaBancoToGet(estadocuentabanco,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoCuentaBanco estadocuentabanco,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoCuentaBanco.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadocuentabanco,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuentaBanco(estadocuentabanco);
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
			this.deepLoad(this.estadocuentabanco,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuentaBanco(this.estadocuentabanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoCuentaBanco.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadocuentabancos!=null) {
				for(EstadoCuentaBanco estadocuentabanco:estadocuentabancos) {
					this.deepLoad(estadocuentabanco,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuentaBanco(estadocuentabancos);
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
			if(estadocuentabancos!=null) {
				for(EstadoCuentaBanco estadocuentabanco:estadocuentabancos) {
					this.deepLoad(estadocuentabanco,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuentaBanco(estadocuentabancos);
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
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEstadoCuentaBancoPorCodigoWithConnection(String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuentaBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoCuentaBancoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadocuentabanco=estadocuentabancoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadocuentabanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuentaBanco(this.estadocuentabanco);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoCuentaBancoPorCodigo(String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoCuentaBancoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadocuentabanco=estadocuentabancoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadocuentabanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuentaBanco(this.estadocuentabanco);
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
			if(EstadoCuentaBancoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoCuentaBancoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoCuentaBanco estadocuentabanco,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoCuentaBancoConstantesFunciones.ISCONAUDITORIA) {
				if(estadocuentabanco.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoCuentaBancoDataAccess.TABLENAME, estadocuentabanco.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoCuentaBancoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoCuentaBancoLogic.registrarAuditoriaDetallesEstadoCuentaBanco(connexion,estadocuentabanco,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadocuentabanco.getIsDeleted()) {
					/*if(!estadocuentabanco.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoCuentaBancoDataAccess.TABLENAME, estadocuentabanco.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoCuentaBancoLogic.registrarAuditoriaDetallesEstadoCuentaBanco(connexion,estadocuentabanco,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoCuentaBancoDataAccess.TABLENAME, estadocuentabanco.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadocuentabanco.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoCuentaBancoDataAccess.TABLENAME, estadocuentabanco.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoCuentaBancoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoCuentaBancoLogic.registrarAuditoriaDetallesEstadoCuentaBanco(connexion,estadocuentabanco,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoCuentaBanco(Connexion connexion,EstadoCuentaBanco estadocuentabanco)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadocuentabanco.getIsNew()||!estadocuentabanco.getcodigo().equals(estadocuentabanco.getEstadoCuentaBancoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadocuentabanco.getEstadoCuentaBancoOriginal().getcodigo()!=null)
				{
					strValorActual=estadocuentabanco.getEstadoCuentaBancoOriginal().getcodigo();
				}
				if(estadocuentabanco.getcodigo()!=null)
				{
					strValorNuevo=estadocuentabanco.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoCuentaBancoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadocuentabanco.getIsNew()||!estadocuentabanco.getnombre().equals(estadocuentabanco.getEstadoCuentaBancoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadocuentabanco.getEstadoCuentaBancoOriginal().getnombre()!=null)
				{
					strValorActual=estadocuentabanco.getEstadoCuentaBancoOriginal().getnombre();
				}
				if(estadocuentabanco.getnombre()!=null)
				{
					strValorNuevo=estadocuentabanco.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoCuentaBancoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(estadocuentabanco.getIsNew()||!estadocuentabanco.getes_defecto().equals(estadocuentabanco.getEstadoCuentaBancoOriginal().getes_defecto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadocuentabanco.getEstadoCuentaBancoOriginal().getes_defecto()!=null)
				{
					strValorActual=estadocuentabanco.getEstadoCuentaBancoOriginal().getes_defecto().toString();
				}
				if(estadocuentabanco.getes_defecto()!=null)
				{
					strValorNuevo=estadocuentabanco.getes_defecto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoCuentaBancoConstantesFunciones.ESDEFECTO,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoCuentaBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoCuentaBancoConstantesFunciones.getClassesForeignKeysOfEstadoCuentaBanco(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoCuentaBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoCuentaBancoConstantesFunciones.getClassesRelationshipsOfEstadoCuentaBanco(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

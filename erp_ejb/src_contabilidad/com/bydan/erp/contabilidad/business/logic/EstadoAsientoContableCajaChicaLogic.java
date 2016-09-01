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
import com.bydan.erp.contabilidad.util.EstadoAsientoContableCajaChicaConstantesFunciones;
import com.bydan.erp.contabilidad.util.EstadoAsientoContableCajaChicaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.EstadoAsientoContableCajaChicaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.EstadoAsientoContableCajaChica;
//import com.bydan.erp.contabilidad.business.logic.EstadoAsientoContableCajaChicaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class EstadoAsientoContableCajaChicaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoAsientoContableCajaChicaLogic.class);
	
	protected EstadoAsientoContableCajaChicaDataAccess estadoasientocontablecajachicaDataAccess; 	
	protected EstadoAsientoContableCajaChica estadoasientocontablecajachica;
	protected List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicas;
	protected Object estadoasientocontablecajachicaObject;	
	protected List<Object> estadoasientocontablecajachicasObject;
	
	public static ClassValidator<EstadoAsientoContableCajaChica> estadoasientocontablecajachicaValidator = new ClassValidator<EstadoAsientoContableCajaChica>(EstadoAsientoContableCajaChica.class);	
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
	
	
	
	
	public  EstadoAsientoContableCajaChicaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadoasientocontablecajachicaDataAccess = new EstadoAsientoContableCajaChicaDataAccess();
			
			this.estadoasientocontablecajachicas= new ArrayList<EstadoAsientoContableCajaChica>();
			this.estadoasientocontablecajachica= new EstadoAsientoContableCajaChica();
			
			this.estadoasientocontablecajachicaObject=new Object();
			this.estadoasientocontablecajachicasObject=new ArrayList<Object>();
				
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
			
			this.estadoasientocontablecajachicaDataAccess.setConnexionType(this.connexionType);
			this.estadoasientocontablecajachicaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoAsientoContableCajaChicaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadoasientocontablecajachicaDataAccess = new EstadoAsientoContableCajaChicaDataAccess();
			this.estadoasientocontablecajachicas= new ArrayList<EstadoAsientoContableCajaChica>();
			this.estadoasientocontablecajachica= new EstadoAsientoContableCajaChica();
			this.estadoasientocontablecajachicaObject=new Object();
			this.estadoasientocontablecajachicasObject=new ArrayList<Object>();
			
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
			
			this.estadoasientocontablecajachicaDataAccess.setConnexionType(this.connexionType);
			this.estadoasientocontablecajachicaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoAsientoContableCajaChica getEstadoAsientoContableCajaChica() throws Exception {	
		//EstadoAsientoContableCajaChicaLogicAdditional.checkEstadoAsientoContableCajaChicaToGet(estadoasientocontablecajachica,this.datosCliente,this.arrDatoGeneral);
		//EstadoAsientoContableCajaChicaLogicAdditional.updateEstadoAsientoContableCajaChicaToGet(estadoasientocontablecajachica,this.arrDatoGeneral);
		
		return estadoasientocontablecajachica;
	}
		
	public void setEstadoAsientoContableCajaChica(EstadoAsientoContableCajaChica newEstadoAsientoContableCajaChica) {
		this.estadoasientocontablecajachica = newEstadoAsientoContableCajaChica;
	}
	
	public EstadoAsientoContableCajaChicaDataAccess getEstadoAsientoContableCajaChicaDataAccess() {
		return estadoasientocontablecajachicaDataAccess;
	}
	
	public void setEstadoAsientoContableCajaChicaDataAccess(EstadoAsientoContableCajaChicaDataAccess newestadoasientocontablecajachicaDataAccess) {
		this.estadoasientocontablecajachicaDataAccess = newestadoasientocontablecajachicaDataAccess;
	}
	
	public List<EstadoAsientoContableCajaChica> getEstadoAsientoContableCajaChicas() throws Exception {		
		this.quitarEstadoAsientoContableCajaChicasNulos();
		
		//EstadoAsientoContableCajaChicaLogicAdditional.checkEstadoAsientoContableCajaChicaToGets(estadoasientocontablecajachicas,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoAsientoContableCajaChica estadoasientocontablecajachicaLocal: estadoasientocontablecajachicas ) {
			//EstadoAsientoContableCajaChicaLogicAdditional.updateEstadoAsientoContableCajaChicaToGet(estadoasientocontablecajachicaLocal,this.arrDatoGeneral);
		}
		
		return estadoasientocontablecajachicas;
	}
	
	public void setEstadoAsientoContableCajaChicas(List<EstadoAsientoContableCajaChica> newEstadoAsientoContableCajaChicas) {
		this.estadoasientocontablecajachicas = newEstadoAsientoContableCajaChicas;
	}
	
	public Object getEstadoAsientoContableCajaChicaObject() {	
		this.estadoasientocontablecajachicaObject=this.estadoasientocontablecajachicaDataAccess.getEntityObject();
		return this.estadoasientocontablecajachicaObject;
	}
		
	public void setEstadoAsientoContableCajaChicaObject(Object newEstadoAsientoContableCajaChicaObject) {
		this.estadoasientocontablecajachicaObject = newEstadoAsientoContableCajaChicaObject;
	}
	
	public List<Object> getEstadoAsientoContableCajaChicasObject() {		
		this.estadoasientocontablecajachicasObject=this.estadoasientocontablecajachicaDataAccess.getEntitiesObject();
		return this.estadoasientocontablecajachicasObject;
	}
		
	public void setEstadoAsientoContableCajaChicasObject(List<Object> newEstadoAsientoContableCajaChicasObject) {
		this.estadoasientocontablecajachicasObject = newEstadoAsientoContableCajaChicasObject;
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
		
		if(this.estadoasientocontablecajachicaDataAccess!=null) {
			this.estadoasientocontablecajachicaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContableCajaChica.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadoasientocontablecajachicaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadoasientocontablecajachicaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadoasientocontablecajachica = new  EstadoAsientoContableCajaChica();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContableCajaChica.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoasientocontablecajachica=estadoasientocontablecajachicaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoasientocontablecajachica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContableCajaChica(this.estadoasientocontablecajachica);
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
		estadoasientocontablecajachica = new  EstadoAsientoContableCajaChica();
		  		  
        try {
			
			estadoasientocontablecajachica=estadoasientocontablecajachicaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoasientocontablecajachica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContableCajaChica(this.estadoasientocontablecajachica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadoasientocontablecajachica = new  EstadoAsientoContableCajaChica();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContableCajaChica.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoasientocontablecajachica=estadoasientocontablecajachicaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoasientocontablecajachica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContableCajaChica(this.estadoasientocontablecajachica);
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
		estadoasientocontablecajachica = new  EstadoAsientoContableCajaChica();
		  		  
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
		estadoasientocontablecajachica = new  EstadoAsientoContableCajaChica();
		  		  
        try {
			
			estadoasientocontablecajachica=estadoasientocontablecajachicaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoasientocontablecajachica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContableCajaChica(this.estadoasientocontablecajachica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadoasientocontablecajachica = new  EstadoAsientoContableCajaChica();
		  		  
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
		estadoasientocontablecajachica = new  EstadoAsientoContableCajaChica();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContableCajaChica.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadoasientocontablecajachicaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoasientocontablecajachica = new  EstadoAsientoContableCajaChica();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadoasientocontablecajachicaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoasientocontablecajachica = new  EstadoAsientoContableCajaChica();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContableCajaChica.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadoasientocontablecajachicaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoasientocontablecajachica = new  EstadoAsientoContableCajaChica();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadoasientocontablecajachicaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoasientocontablecajachica = new  EstadoAsientoContableCajaChica();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContableCajaChica.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadoasientocontablecajachicaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoasientocontablecajachica = new  EstadoAsientoContableCajaChica();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadoasientocontablecajachicaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadoasientocontablecajachicas = new  ArrayList<EstadoAsientoContableCajaChica>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContableCajaChica.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoasientocontablecajachicas=estadoasientocontablecajachicaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoAsientoContableCajaChica(estadoasientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContableCajaChica(this.estadoasientocontablecajachicas);
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
		estadoasientocontablecajachicas = new  ArrayList<EstadoAsientoContableCajaChica>();
		  		  
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
		estadoasientocontablecajachicas = new  ArrayList<EstadoAsientoContableCajaChica>();
		  		  
        try {			
			EstadoAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoasientocontablecajachicas=estadoasientocontablecajachicaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoAsientoContableCajaChica(estadoasientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContableCajaChica(this.estadoasientocontablecajachicas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadoasientocontablecajachicas = new  ArrayList<EstadoAsientoContableCajaChica>();
		  		  
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
		estadoasientocontablecajachicas = new  ArrayList<EstadoAsientoContableCajaChica>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContableCajaChica.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoasientocontablecajachicas=estadoasientocontablecajachicaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoAsientoContableCajaChica(estadoasientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContableCajaChica(this.estadoasientocontablecajachicas);
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
		estadoasientocontablecajachicas = new  ArrayList<EstadoAsientoContableCajaChica>();
		  		  
        try {
			EstadoAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoasientocontablecajachicas=estadoasientocontablecajachicaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoAsientoContableCajaChica(estadoasientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContableCajaChica(this.estadoasientocontablecajachicas);
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
		estadoasientocontablecajachicas = new  ArrayList<EstadoAsientoContableCajaChica>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContableCajaChica.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoasientocontablecajachicas=estadoasientocontablecajachicaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoAsientoContableCajaChica(estadoasientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContableCajaChica(this.estadoasientocontablecajachicas);
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
		estadoasientocontablecajachicas = new  ArrayList<EstadoAsientoContableCajaChica>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoasientocontablecajachicas=estadoasientocontablecajachicaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoAsientoContableCajaChica(estadoasientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContableCajaChica(this.estadoasientocontablecajachicas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadoasientocontablecajachica = new  EstadoAsientoContableCajaChica();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContableCajaChica.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoasientocontablecajachica=estadoasientocontablecajachicaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoAsientoContableCajaChica(estadoasientocontablecajachica);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContableCajaChica(this.estadoasientocontablecajachica);
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
		estadoasientocontablecajachica = new  EstadoAsientoContableCajaChica();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoasientocontablecajachica=estadoasientocontablecajachicaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoAsientoContableCajaChica(estadoasientocontablecajachica);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContableCajaChica(this.estadoasientocontablecajachica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosEstadoAsientoContableCajaChicasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadoasientocontablecajachicas = new  ArrayList<EstadoAsientoContableCajaChica>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContableCajaChica.class.getSimpleName()+"-getTodosEstadoAsientoContableCajaChicasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoasientocontablecajachicas=estadoasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoAsientoContableCajaChica(estadoasientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContableCajaChica(this.estadoasientocontablecajachicas);
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
	
	public  void  getTodosEstadoAsientoContableCajaChicas(String sFinalQuery,Pagination pagination)throws Exception {
		estadoasientocontablecajachicas = new  ArrayList<EstadoAsientoContableCajaChica>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoasientocontablecajachicas=estadoasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoAsientoContableCajaChica(estadoasientocontablecajachicas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContableCajaChica(this.estadoasientocontablecajachicas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoAsientoContableCajaChica(EstadoAsientoContableCajaChica estadoasientocontablecajachica) throws Exception {
		Boolean estaValidado=false;
		
		if(estadoasientocontablecajachica.getIsNew() || estadoasientocontablecajachica.getIsChanged()) { 
			this.invalidValues = estadoasientocontablecajachicaValidator.getInvalidValues(estadoasientocontablecajachica);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadoasientocontablecajachica);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoAsientoContableCajaChica(List<EstadoAsientoContableCajaChica> EstadoAsientoContableCajaChicas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoAsientoContableCajaChica estadoasientocontablecajachicaLocal:estadoasientocontablecajachicas) {				
			estaValidadoObjeto=this.validarGuardarEstadoAsientoContableCajaChica(estadoasientocontablecajachicaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoAsientoContableCajaChica(List<EstadoAsientoContableCajaChica> EstadoAsientoContableCajaChicas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoAsientoContableCajaChica(estadoasientocontablecajachicas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoAsientoContableCajaChica(EstadoAsientoContableCajaChica EstadoAsientoContableCajaChica) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoAsientoContableCajaChica(estadoasientocontablecajachica)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoAsientoContableCajaChica estadoasientocontablecajachica) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadoasientocontablecajachica.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoAsientoContableCajaChicaConstantesFunciones.getEstadoAsientoContableCajaChicaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadoasientocontablecajachica","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoAsientoContableCajaChicaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoAsientoContableCajaChicaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoAsientoContableCajaChicaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContableCajaChica.class.getSimpleName()+"-saveEstadoAsientoContableCajaChicaWithConnection");connexion.begin();			
			
			//EstadoAsientoContableCajaChicaLogicAdditional.checkEstadoAsientoContableCajaChicaToSave(this.estadoasientocontablecajachica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoAsientoContableCajaChicaLogicAdditional.updateEstadoAsientoContableCajaChicaToSave(this.estadoasientocontablecajachica,this.arrDatoGeneral);
			
			EstadoAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoasientocontablecajachica,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoAsientoContableCajaChica();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoAsientoContableCajaChica(this.estadoasientocontablecajachica)) {
				EstadoAsientoContableCajaChicaDataAccess.save(this.estadoasientocontablecajachica, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadoasientocontablecajachica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoAsientoContableCajaChicaLogicAdditional.checkEstadoAsientoContableCajaChicaToSaveAfter(this.estadoasientocontablecajachica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoAsientoContableCajaChica();
			
			connexion.commit();			
			
			if(this.estadoasientocontablecajachica.getIsDeleted()) {
				this.estadoasientocontablecajachica=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoAsientoContableCajaChica()throws Exception {	
		try {	
			
			//EstadoAsientoContableCajaChicaLogicAdditional.checkEstadoAsientoContableCajaChicaToSave(this.estadoasientocontablecajachica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoAsientoContableCajaChicaLogicAdditional.updateEstadoAsientoContableCajaChicaToSave(this.estadoasientocontablecajachica,this.arrDatoGeneral);
			
			EstadoAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoasientocontablecajachica,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoAsientoContableCajaChica(this.estadoasientocontablecajachica)) {			
				EstadoAsientoContableCajaChicaDataAccess.save(this.estadoasientocontablecajachica, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadoasientocontablecajachica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoAsientoContableCajaChicaLogicAdditional.checkEstadoAsientoContableCajaChicaToSaveAfter(this.estadoasientocontablecajachica,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadoasientocontablecajachica.getIsDeleted()) {
				this.estadoasientocontablecajachica=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoAsientoContableCajaChicasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContableCajaChica.class.getSimpleName()+"-saveEstadoAsientoContableCajaChicasWithConnection");connexion.begin();			
			
			//EstadoAsientoContableCajaChicaLogicAdditional.checkEstadoAsientoContableCajaChicaToSaves(estadoasientocontablecajachicas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoAsientoContableCajaChicas();
			
			Boolean validadoTodosEstadoAsientoContableCajaChica=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoAsientoContableCajaChica estadoasientocontablecajachicaLocal:estadoasientocontablecajachicas) {		
				if(estadoasientocontablecajachicaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoAsientoContableCajaChicaLogicAdditional.updateEstadoAsientoContableCajaChicaToSave(estadoasientocontablecajachicaLocal,this.arrDatoGeneral);
	        	
				EstadoAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoasientocontablecajachicaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoAsientoContableCajaChica(estadoasientocontablecajachicaLocal)) {
					EstadoAsientoContableCajaChicaDataAccess.save(estadoasientocontablecajachicaLocal, connexion);				
				} else {
					validadoTodosEstadoAsientoContableCajaChica=false;
				}
			}
			
			if(!validadoTodosEstadoAsientoContableCajaChica) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoAsientoContableCajaChicaLogicAdditional.checkEstadoAsientoContableCajaChicaToSavesAfter(estadoasientocontablecajachicas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoAsientoContableCajaChicas();
			
			connexion.commit();		
			
			this.quitarEstadoAsientoContableCajaChicasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoAsientoContableCajaChicas()throws Exception {				
		 try {	
			//EstadoAsientoContableCajaChicaLogicAdditional.checkEstadoAsientoContableCajaChicaToSaves(estadoasientocontablecajachicas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoAsientoContableCajaChica=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoAsientoContableCajaChica estadoasientocontablecajachicaLocal:estadoasientocontablecajachicas) {				
				if(estadoasientocontablecajachicaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoAsientoContableCajaChicaLogicAdditional.updateEstadoAsientoContableCajaChicaToSave(estadoasientocontablecajachicaLocal,this.arrDatoGeneral);
	        	
				EstadoAsientoContableCajaChicaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoasientocontablecajachicaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoAsientoContableCajaChica(estadoasientocontablecajachicaLocal)) {				
					EstadoAsientoContableCajaChicaDataAccess.save(estadoasientocontablecajachicaLocal, connexion);				
				} else {
					validadoTodosEstadoAsientoContableCajaChica=false;
				}
			}
			
			if(!validadoTodosEstadoAsientoContableCajaChica) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoAsientoContableCajaChicaLogicAdditional.checkEstadoAsientoContableCajaChicaToSavesAfter(estadoasientocontablecajachicas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoAsientoContableCajaChicasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoAsientoContableCajaChicaParameterReturnGeneral procesarAccionEstadoAsientoContableCajaChicas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicas,EstadoAsientoContableCajaChicaParameterReturnGeneral estadoasientocontablecajachicaParameterGeneral)throws Exception {
		 try {	
			EstadoAsientoContableCajaChicaParameterReturnGeneral estadoasientocontablecajachicaReturnGeneral=new EstadoAsientoContableCajaChicaParameterReturnGeneral();
	
			
			return estadoasientocontablecajachicaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoAsientoContableCajaChicaParameterReturnGeneral procesarAccionEstadoAsientoContableCajaChicasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicas,EstadoAsientoContableCajaChicaParameterReturnGeneral estadoasientocontablecajachicaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContableCajaChica.class.getSimpleName()+"-procesarAccionEstadoAsientoContableCajaChicasWithConnection");connexion.begin();			
			
			EstadoAsientoContableCajaChicaParameterReturnGeneral estadoasientocontablecajachicaReturnGeneral=new EstadoAsientoContableCajaChicaParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return estadoasientocontablecajachicaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoAsientoContableCajaChicaParameterReturnGeneral procesarEventosEstadoAsientoContableCajaChicas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicas,EstadoAsientoContableCajaChica estadoasientocontablecajachica,EstadoAsientoContableCajaChicaParameterReturnGeneral estadoasientocontablecajachicaParameterGeneral,Boolean isEsNuevoEstadoAsientoContableCajaChica,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoAsientoContableCajaChicaParameterReturnGeneral estadoasientocontablecajachicaReturnGeneral=new EstadoAsientoContableCajaChicaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoasientocontablecajachicaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return estadoasientocontablecajachicaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoAsientoContableCajaChicaParameterReturnGeneral procesarEventosEstadoAsientoContableCajaChicasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicas,EstadoAsientoContableCajaChica estadoasientocontablecajachica,EstadoAsientoContableCajaChicaParameterReturnGeneral estadoasientocontablecajachicaParameterGeneral,Boolean isEsNuevoEstadoAsientoContableCajaChica,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContableCajaChica.class.getSimpleName()+"-procesarEventosEstadoAsientoContableCajaChicasWithConnection");connexion.begin();			
			
			EstadoAsientoContableCajaChicaParameterReturnGeneral estadoasientocontablecajachicaReturnGeneral=new EstadoAsientoContableCajaChicaParameterReturnGeneral();
	
			estadoasientocontablecajachicaReturnGeneral.setEstadoAsientoContableCajaChica(estadoasientocontablecajachica);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoasientocontablecajachicaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return estadoasientocontablecajachicaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoAsientoContableCajaChicaParameterReturnGeneral procesarImportacionEstadoAsientoContableCajaChicasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoAsientoContableCajaChicaParameterReturnGeneral estadoasientocontablecajachicaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContableCajaChica.class.getSimpleName()+"-procesarImportacionEstadoAsientoContableCajaChicasWithConnection");connexion.begin();			
			
			EstadoAsientoContableCajaChicaParameterReturnGeneral estadoasientocontablecajachicaReturnGeneral=new EstadoAsientoContableCajaChicaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadoasientocontablecajachicas=new ArrayList<EstadoAsientoContableCajaChica>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadoasientocontablecajachica=new EstadoAsientoContableCajaChica();
				
				
				if(conColumnasBase) {this.estadoasientocontablecajachica.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadoasientocontablecajachica.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadoasientocontablecajachica.setcodigo(arrColumnas[iColumn++]);
				this.estadoasientocontablecajachica.setnombre(arrColumnas[iColumn++]);
				
				this.estadoasientocontablecajachicas.add(this.estadoasientocontablecajachica);
			}
			
			this.saveEstadoAsientoContableCajaChicas();
			
			this.connexion.commit();
			
			estadoasientocontablecajachicaReturnGeneral.setConRetornoEstaProcesado(true);
			estadoasientocontablecajachicaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadoasientocontablecajachicaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoAsientoContableCajaChicasEliminados() throws Exception {				
		
		List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicasAux= new ArrayList<EstadoAsientoContableCajaChica>();
		
		for(EstadoAsientoContableCajaChica estadoasientocontablecajachica:estadoasientocontablecajachicas) {
			if(!estadoasientocontablecajachica.getIsDeleted()) {
				estadoasientocontablecajachicasAux.add(estadoasientocontablecajachica);
			}
		}
		
		estadoasientocontablecajachicas=estadoasientocontablecajachicasAux;
	}
	
	public void quitarEstadoAsientoContableCajaChicasNulos() throws Exception {				
		
		List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicasAux= new ArrayList<EstadoAsientoContableCajaChica>();
		
		for(EstadoAsientoContableCajaChica estadoasientocontablecajachica : this.estadoasientocontablecajachicas) {
			if(estadoasientocontablecajachica==null) {
				estadoasientocontablecajachicasAux.add(estadoasientocontablecajachica);
			}
		}
		
		//this.estadoasientocontablecajachicas=estadoasientocontablecajachicasAux;
		
		this.estadoasientocontablecajachicas.removeAll(estadoasientocontablecajachicasAux);
	}
	
	public void getSetVersionRowEstadoAsientoContableCajaChicaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadoasientocontablecajachica.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadoasientocontablecajachica.getIsDeleted() || (estadoasientocontablecajachica.getIsChanged()&&!estadoasientocontablecajachica.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadoasientocontablecajachicaDataAccess.getSetVersionRowEstadoAsientoContableCajaChica(connexion,estadoasientocontablecajachica.getId());
				
				if(!estadoasientocontablecajachica.getVersionRow().equals(timestamp)) {	
					estadoasientocontablecajachica.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadoasientocontablecajachica.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoAsientoContableCajaChica()throws Exception {	
		
		if(estadoasientocontablecajachica.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadoasientocontablecajachica.getIsDeleted() || (estadoasientocontablecajachica.getIsChanged()&&!estadoasientocontablecajachica.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadoasientocontablecajachicaDataAccess.getSetVersionRowEstadoAsientoContableCajaChica(connexion,estadoasientocontablecajachica.getId());
			
			try {							
				if(!estadoasientocontablecajachica.getVersionRow().equals(timestamp)) {	
					estadoasientocontablecajachica.setVersionRow(timestamp);
				}
				
				estadoasientocontablecajachica.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoAsientoContableCajaChicasWithConnection()throws Exception {	
		if(estadoasientocontablecajachicas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoAsientoContableCajaChica estadoasientocontablecajachicaAux:estadoasientocontablecajachicas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadoasientocontablecajachicaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoasientocontablecajachicaAux.getIsDeleted() || (estadoasientocontablecajachicaAux.getIsChanged()&&!estadoasientocontablecajachicaAux.getIsNew())) {
						
						timestamp=estadoasientocontablecajachicaDataAccess.getSetVersionRowEstadoAsientoContableCajaChica(connexion,estadoasientocontablecajachicaAux.getId());
						
						if(!estadoasientocontablecajachica.getVersionRow().equals(timestamp)) {	
							estadoasientocontablecajachicaAux.setVersionRow(timestamp);
						}
								
						estadoasientocontablecajachicaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoAsientoContableCajaChicas()throws Exception {	
		if(estadoasientocontablecajachicas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoAsientoContableCajaChica estadoasientocontablecajachicaAux:estadoasientocontablecajachicas) {
					if(estadoasientocontablecajachicaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoasientocontablecajachicaAux.getIsDeleted() || (estadoasientocontablecajachicaAux.getIsChanged()&&!estadoasientocontablecajachicaAux.getIsNew())) {
						
						timestamp=estadoasientocontablecajachicaDataAccess.getSetVersionRowEstadoAsientoContableCajaChica(connexion,estadoasientocontablecajachicaAux.getId());
						
						if(!estadoasientocontablecajachicaAux.getVersionRow().equals(timestamp)) {	
							estadoasientocontablecajachicaAux.setVersionRow(timestamp);
						}
						
													
						estadoasientocontablecajachicaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(EstadoAsientoContableCajaChica estadoasientocontablecajachica,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//EstadoAsientoContableCajaChicaLogicAdditional.updateEstadoAsientoContableCajaChicaToGet(estadoasientocontablecajachica,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoAsientoContableCajaChica estadoasientocontablecajachica,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoAsientoContableCajaChica.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadoasientocontablecajachica,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContableCajaChica(estadoasientocontablecajachica);
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
			this.deepLoad(this.estadoasientocontablecajachica,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContableCajaChica(this.estadoasientocontablecajachica);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoAsientoContableCajaChica.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadoasientocontablecajachicas!=null) {
				for(EstadoAsientoContableCajaChica estadoasientocontablecajachica:estadoasientocontablecajachicas) {
					this.deepLoad(estadoasientocontablecajachica,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContableCajaChica(estadoasientocontablecajachicas);
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
			if(estadoasientocontablecajachicas!=null) {
				for(EstadoAsientoContableCajaChica estadoasientocontablecajachica:estadoasientocontablecajachicas) {
					this.deepLoad(estadoasientocontablecajachica,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContableCajaChica(estadoasientocontablecajachicas);
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
	
	
	public void getEstadoAsientoContableCajaChicaPorCodigoWithConnection(String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoAsientoContableCajaChica.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoAsientoContableCajaChicaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadoasientocontablecajachica=estadoasientocontablecajachicaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadoasientocontablecajachica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContableCajaChica(this.estadoasientocontablecajachica);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoAsientoContableCajaChicaPorCodigo(String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoAsientoContableCajaChicaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadoasientocontablecajachica=estadoasientocontablecajachicaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadoasientocontablecajachica,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoAsientoContableCajaChicaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoAsientoContableCajaChica(this.estadoasientocontablecajachica);
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
			if(EstadoAsientoContableCajaChicaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoAsientoContableCajaChicaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoAsientoContableCajaChica estadoasientocontablecajachica,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoAsientoContableCajaChicaConstantesFunciones.ISCONAUDITORIA) {
				if(estadoasientocontablecajachica.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoAsientoContableCajaChicaDataAccess.TABLENAME, estadoasientocontablecajachica.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoAsientoContableCajaChicaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoAsientoContableCajaChicaLogic.registrarAuditoriaDetallesEstadoAsientoContableCajaChica(connexion,estadoasientocontablecajachica,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadoasientocontablecajachica.getIsDeleted()) {
					/*if(!estadoasientocontablecajachica.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoAsientoContableCajaChicaDataAccess.TABLENAME, estadoasientocontablecajachica.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoAsientoContableCajaChicaLogic.registrarAuditoriaDetallesEstadoAsientoContableCajaChica(connexion,estadoasientocontablecajachica,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoAsientoContableCajaChicaDataAccess.TABLENAME, estadoasientocontablecajachica.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadoasientocontablecajachica.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoAsientoContableCajaChicaDataAccess.TABLENAME, estadoasientocontablecajachica.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoAsientoContableCajaChicaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoAsientoContableCajaChicaLogic.registrarAuditoriaDetallesEstadoAsientoContableCajaChica(connexion,estadoasientocontablecajachica,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoAsientoContableCajaChica(Connexion connexion,EstadoAsientoContableCajaChica estadoasientocontablecajachica)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadoasientocontablecajachica.getIsNew()||!estadoasientocontablecajachica.getcodigo().equals(estadoasientocontablecajachica.getEstadoAsientoContableCajaChicaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoasientocontablecajachica.getEstadoAsientoContableCajaChicaOriginal().getcodigo()!=null)
				{
					strValorActual=estadoasientocontablecajachica.getEstadoAsientoContableCajaChicaOriginal().getcodigo();
				}
				if(estadoasientocontablecajachica.getcodigo()!=null)
				{
					strValorNuevo=estadoasientocontablecajachica.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoAsientoContableCajaChicaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadoasientocontablecajachica.getIsNew()||!estadoasientocontablecajachica.getnombre().equals(estadoasientocontablecajachica.getEstadoAsientoContableCajaChicaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoasientocontablecajachica.getEstadoAsientoContableCajaChicaOriginal().getnombre()!=null)
				{
					strValorActual=estadoasientocontablecajachica.getEstadoAsientoContableCajaChicaOriginal().getnombre();
				}
				if(estadoasientocontablecajachica.getnombre()!=null)
				{
					strValorNuevo=estadoasientocontablecajachica.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoAsientoContableCajaChicaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoAsientoContableCajaChica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoAsientoContableCajaChicaConstantesFunciones.getClassesForeignKeysOfEstadoAsientoContableCajaChica(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoAsientoContableCajaChica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoAsientoContableCajaChicaConstantesFunciones.getClassesRelationshipsOfEstadoAsientoContableCajaChica(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

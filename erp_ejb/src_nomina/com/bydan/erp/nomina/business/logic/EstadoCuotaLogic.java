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
import com.bydan.erp.nomina.util.EstadoCuotaConstantesFunciones;
import com.bydan.erp.nomina.util.EstadoCuotaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EstadoCuotaParameterGeneral;
import com.bydan.erp.nomina.business.entity.EstadoCuota;
import com.bydan.erp.nomina.business.logic.EstadoCuotaLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class EstadoCuotaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoCuotaLogic.class);
	
	protected EstadoCuotaDataAccess estadocuotaDataAccess; 	
	protected EstadoCuota estadocuota;
	protected List<EstadoCuota> estadocuotas;
	protected Object estadocuotaObject;	
	protected List<Object> estadocuotasObject;
	
	public static ClassValidator<EstadoCuota> estadocuotaValidator = new ClassValidator<EstadoCuota>(EstadoCuota.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoCuotaLogicAdditional estadocuotaLogicAdditional=null;
	
	public EstadoCuotaLogicAdditional getEstadoCuotaLogicAdditional() {
		return this.estadocuotaLogicAdditional;
	}
	
	public void setEstadoCuotaLogicAdditional(EstadoCuotaLogicAdditional estadocuotaLogicAdditional) {
		try {
			this.estadocuotaLogicAdditional=estadocuotaLogicAdditional;
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
	
	
	
	
	public  EstadoCuotaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadocuotaDataAccess = new EstadoCuotaDataAccess();
			
			this.estadocuotas= new ArrayList<EstadoCuota>();
			this.estadocuota= new EstadoCuota();
			
			this.estadocuotaObject=new Object();
			this.estadocuotasObject=new ArrayList<Object>();
				
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
			
			this.estadocuotaDataAccess.setConnexionType(this.connexionType);
			this.estadocuotaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoCuotaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadocuotaDataAccess = new EstadoCuotaDataAccess();
			this.estadocuotas= new ArrayList<EstadoCuota>();
			this.estadocuota= new EstadoCuota();
			this.estadocuotaObject=new Object();
			this.estadocuotasObject=new ArrayList<Object>();
			
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
			
			this.estadocuotaDataAccess.setConnexionType(this.connexionType);
			this.estadocuotaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoCuota getEstadoCuota() throws Exception {	
		EstadoCuotaLogicAdditional.checkEstadoCuotaToGet(estadocuota,this.datosCliente,this.arrDatoGeneral);
		EstadoCuotaLogicAdditional.updateEstadoCuotaToGet(estadocuota,this.arrDatoGeneral);
		
		return estadocuota;
	}
		
	public void setEstadoCuota(EstadoCuota newEstadoCuota) {
		this.estadocuota = newEstadoCuota;
	}
	
	public EstadoCuotaDataAccess getEstadoCuotaDataAccess() {
		return estadocuotaDataAccess;
	}
	
	public void setEstadoCuotaDataAccess(EstadoCuotaDataAccess newestadocuotaDataAccess) {
		this.estadocuotaDataAccess = newestadocuotaDataAccess;
	}
	
	public List<EstadoCuota> getEstadoCuotas() throws Exception {		
		this.quitarEstadoCuotasNulos();
		
		EstadoCuotaLogicAdditional.checkEstadoCuotaToGets(estadocuotas,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoCuota estadocuotaLocal: estadocuotas ) {
			EstadoCuotaLogicAdditional.updateEstadoCuotaToGet(estadocuotaLocal,this.arrDatoGeneral);
		}
		
		return estadocuotas;
	}
	
	public void setEstadoCuotas(List<EstadoCuota> newEstadoCuotas) {
		this.estadocuotas = newEstadoCuotas;
	}
	
	public Object getEstadoCuotaObject() {	
		this.estadocuotaObject=this.estadocuotaDataAccess.getEntityObject();
		return this.estadocuotaObject;
	}
		
	public void setEstadoCuotaObject(Object newEstadoCuotaObject) {
		this.estadocuotaObject = newEstadoCuotaObject;
	}
	
	public List<Object> getEstadoCuotasObject() {		
		this.estadocuotasObject=this.estadocuotaDataAccess.getEntitiesObject();
		return this.estadocuotasObject;
	}
		
	public void setEstadoCuotasObject(List<Object> newEstadoCuotasObject) {
		this.estadocuotasObject = newEstadoCuotasObject;
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
		
		if(this.estadocuotaDataAccess!=null) {
			this.estadocuotaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuota.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadocuotaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadocuotaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadocuota = new  EstadoCuota();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuota.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadocuota=estadocuotaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadocuota,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuota(this.estadocuota);
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
		estadocuota = new  EstadoCuota();
		  		  
        try {
			
			estadocuota=estadocuotaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadocuota,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuota(this.estadocuota);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadocuota = new  EstadoCuota();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuota.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadocuota=estadocuotaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadocuota,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuota(this.estadocuota);
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
		estadocuota = new  EstadoCuota();
		  		  
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
		estadocuota = new  EstadoCuota();
		  		  
        try {
			
			estadocuota=estadocuotaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadocuota,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuota(this.estadocuota);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadocuota = new  EstadoCuota();
		  		  
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
		estadocuota = new  EstadoCuota();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuota.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadocuotaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadocuota = new  EstadoCuota();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadocuotaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadocuota = new  EstadoCuota();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuota.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadocuotaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadocuota = new  EstadoCuota();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadocuotaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadocuota = new  EstadoCuota();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuota.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadocuotaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadocuota = new  EstadoCuota();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadocuotaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadocuotas = new  ArrayList<EstadoCuota>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuota.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocuotas=estadocuotaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoCuota(estadocuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuota(this.estadocuotas);
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
		estadocuotas = new  ArrayList<EstadoCuota>();
		  		  
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
		estadocuotas = new  ArrayList<EstadoCuota>();
		  		  
        try {			
			EstadoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocuotas=estadocuotaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoCuota(estadocuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuota(this.estadocuotas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadocuotas = new  ArrayList<EstadoCuota>();
		  		  
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
		estadocuotas = new  ArrayList<EstadoCuota>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuota.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocuotas=estadocuotaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoCuota(estadocuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuota(this.estadocuotas);
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
		estadocuotas = new  ArrayList<EstadoCuota>();
		  		  
        try {
			EstadoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocuotas=estadocuotaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoCuota(estadocuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuota(this.estadocuotas);
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
		estadocuotas = new  ArrayList<EstadoCuota>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuota.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocuotas=estadocuotaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoCuota(estadocuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuota(this.estadocuotas);
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
		estadocuotas = new  ArrayList<EstadoCuota>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocuotas=estadocuotaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoCuota(estadocuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuota(this.estadocuotas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadocuota = new  EstadoCuota();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuota.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocuota=estadocuotaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoCuota(estadocuota);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuota(this.estadocuota);
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
		estadocuota = new  EstadoCuota();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocuota=estadocuotaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoCuota(estadocuota);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuota(this.estadocuota);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadocuotas = new  ArrayList<EstadoCuota>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuota.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocuotas=estadocuotaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoCuota(estadocuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuota(this.estadocuotas);
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
		estadocuotas = new  ArrayList<EstadoCuota>();
		  		  
        try {
			EstadoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocuotas=estadocuotaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoCuota(estadocuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuota(this.estadocuotas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoCuotasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadocuotas = new  ArrayList<EstadoCuota>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuota.class.getSimpleName()+"-getTodosEstadoCuotasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocuotas=estadocuotaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoCuota(estadocuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuota(this.estadocuotas);
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
	
	public  void  getTodosEstadoCuotas(String sFinalQuery,Pagination pagination)throws Exception {
		estadocuotas = new  ArrayList<EstadoCuota>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadocuotas=estadocuotaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoCuota(estadocuotas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuota(this.estadocuotas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoCuota(EstadoCuota estadocuota) throws Exception {
		Boolean estaValidado=false;
		
		if(estadocuota.getIsNew() || estadocuota.getIsChanged()) { 
			this.invalidValues = estadocuotaValidator.getInvalidValues(estadocuota);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadocuota);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoCuota(List<EstadoCuota> EstadoCuotas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoCuota estadocuotaLocal:estadocuotas) {				
			estaValidadoObjeto=this.validarGuardarEstadoCuota(estadocuotaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoCuota(List<EstadoCuota> EstadoCuotas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoCuota(estadocuotas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoCuota(EstadoCuota EstadoCuota) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoCuota(estadocuota)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoCuota estadocuota) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadocuota.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoCuotaConstantesFunciones.getEstadoCuotaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadocuota","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoCuotaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoCuotaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoCuotaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuota.class.getSimpleName()+"-saveEstadoCuotaWithConnection");connexion.begin();			
			
			EstadoCuotaLogicAdditional.checkEstadoCuotaToSave(this.estadocuota,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoCuotaLogicAdditional.updateEstadoCuotaToSave(this.estadocuota,this.arrDatoGeneral);
			
			EstadoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadocuota,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoCuota();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoCuota(this.estadocuota)) {
				EstadoCuotaDataAccess.save(this.estadocuota, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadocuota,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoCuotaLogicAdditional.checkEstadoCuotaToSaveAfter(this.estadocuota,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoCuota();
			
			connexion.commit();			
			
			if(this.estadocuota.getIsDeleted()) {
				this.estadocuota=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoCuota()throws Exception {	
		try {	
			
			EstadoCuotaLogicAdditional.checkEstadoCuotaToSave(this.estadocuota,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoCuotaLogicAdditional.updateEstadoCuotaToSave(this.estadocuota,this.arrDatoGeneral);
			
			EstadoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadocuota,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoCuota(this.estadocuota)) {			
				EstadoCuotaDataAccess.save(this.estadocuota, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadocuota,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoCuotaLogicAdditional.checkEstadoCuotaToSaveAfter(this.estadocuota,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadocuota.getIsDeleted()) {
				this.estadocuota=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoCuotasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuota.class.getSimpleName()+"-saveEstadoCuotasWithConnection");connexion.begin();			
			
			EstadoCuotaLogicAdditional.checkEstadoCuotaToSaves(estadocuotas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoCuotas();
			
			Boolean validadoTodosEstadoCuota=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoCuota estadocuotaLocal:estadocuotas) {		
				if(estadocuotaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoCuotaLogicAdditional.updateEstadoCuotaToSave(estadocuotaLocal,this.arrDatoGeneral);
	        	
				EstadoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadocuotaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoCuota(estadocuotaLocal)) {
					EstadoCuotaDataAccess.save(estadocuotaLocal, connexion);				
				} else {
					validadoTodosEstadoCuota=false;
				}
			}
			
			if(!validadoTodosEstadoCuota) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoCuotaLogicAdditional.checkEstadoCuotaToSavesAfter(estadocuotas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoCuotas();
			
			connexion.commit();		
			
			this.quitarEstadoCuotasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoCuotas()throws Exception {				
		 try {	
			EstadoCuotaLogicAdditional.checkEstadoCuotaToSaves(estadocuotas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoCuota=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoCuota estadocuotaLocal:estadocuotas) {				
				if(estadocuotaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoCuotaLogicAdditional.updateEstadoCuotaToSave(estadocuotaLocal,this.arrDatoGeneral);
	        	
				EstadoCuotaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadocuotaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoCuota(estadocuotaLocal)) {				
					EstadoCuotaDataAccess.save(estadocuotaLocal, connexion);				
				} else {
					validadoTodosEstadoCuota=false;
				}
			}
			
			if(!validadoTodosEstadoCuota) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoCuotaLogicAdditional.checkEstadoCuotaToSavesAfter(estadocuotas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoCuotasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoCuotaParameterReturnGeneral procesarAccionEstadoCuotas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoCuota> estadocuotas,EstadoCuotaParameterReturnGeneral estadocuotaParameterGeneral)throws Exception {
		 try {	
			EstadoCuotaParameterReturnGeneral estadocuotaReturnGeneral=new EstadoCuotaParameterReturnGeneral();
	
			EstadoCuotaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadocuotas,estadocuotaParameterGeneral,estadocuotaReturnGeneral);
			
			return estadocuotaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoCuotaParameterReturnGeneral procesarAccionEstadoCuotasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoCuota> estadocuotas,EstadoCuotaParameterReturnGeneral estadocuotaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuota.class.getSimpleName()+"-procesarAccionEstadoCuotasWithConnection");connexion.begin();			
			
			EstadoCuotaParameterReturnGeneral estadocuotaReturnGeneral=new EstadoCuotaParameterReturnGeneral();
	
			EstadoCuotaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadocuotas,estadocuotaParameterGeneral,estadocuotaReturnGeneral);
			
			this.connexion.commit();
			
			return estadocuotaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoCuotaParameterReturnGeneral procesarEventosEstadoCuotas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoCuota> estadocuotas,EstadoCuota estadocuota,EstadoCuotaParameterReturnGeneral estadocuotaParameterGeneral,Boolean isEsNuevoEstadoCuota,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoCuotaParameterReturnGeneral estadocuotaReturnGeneral=new EstadoCuotaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadocuotaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoCuotaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadocuotas,estadocuota,estadocuotaParameterGeneral,estadocuotaReturnGeneral,isEsNuevoEstadoCuota,clases);
			
			return estadocuotaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoCuotaParameterReturnGeneral procesarEventosEstadoCuotasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoCuota> estadocuotas,EstadoCuota estadocuota,EstadoCuotaParameterReturnGeneral estadocuotaParameterGeneral,Boolean isEsNuevoEstadoCuota,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuota.class.getSimpleName()+"-procesarEventosEstadoCuotasWithConnection");connexion.begin();			
			
			EstadoCuotaParameterReturnGeneral estadocuotaReturnGeneral=new EstadoCuotaParameterReturnGeneral();
	
			estadocuotaReturnGeneral.setEstadoCuota(estadocuota);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadocuotaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoCuotaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadocuotas,estadocuota,estadocuotaParameterGeneral,estadocuotaReturnGeneral,isEsNuevoEstadoCuota,clases);
			
			this.connexion.commit();
			
			return estadocuotaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoCuotaParameterReturnGeneral procesarImportacionEstadoCuotasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoCuotaParameterReturnGeneral estadocuotaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuota.class.getSimpleName()+"-procesarImportacionEstadoCuotasWithConnection");connexion.begin();			
			
			EstadoCuotaParameterReturnGeneral estadocuotaReturnGeneral=new EstadoCuotaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadocuotas=new ArrayList<EstadoCuota>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadocuota=new EstadoCuota();
				
				
				if(conColumnasBase) {this.estadocuota.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadocuota.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadocuota.setcodigo(arrColumnas[iColumn++]);
				this.estadocuota.setnombre(arrColumnas[iColumn++]);
				
				this.estadocuotas.add(this.estadocuota);
			}
			
			this.saveEstadoCuotas();
			
			this.connexion.commit();
			
			estadocuotaReturnGeneral.setConRetornoEstaProcesado(true);
			estadocuotaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadocuotaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoCuotasEliminados() throws Exception {				
		
		List<EstadoCuota> estadocuotasAux= new ArrayList<EstadoCuota>();
		
		for(EstadoCuota estadocuota:estadocuotas) {
			if(!estadocuota.getIsDeleted()) {
				estadocuotasAux.add(estadocuota);
			}
		}
		
		estadocuotas=estadocuotasAux;
	}
	
	public void quitarEstadoCuotasNulos() throws Exception {				
		
		List<EstadoCuota> estadocuotasAux= new ArrayList<EstadoCuota>();
		
		for(EstadoCuota estadocuota : this.estadocuotas) {
			if(estadocuota==null) {
				estadocuotasAux.add(estadocuota);
			}
		}
		
		//this.estadocuotas=estadocuotasAux;
		
		this.estadocuotas.removeAll(estadocuotasAux);
	}
	
	public void getSetVersionRowEstadoCuotaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadocuota.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadocuota.getIsDeleted() || (estadocuota.getIsChanged()&&!estadocuota.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadocuotaDataAccess.getSetVersionRowEstadoCuota(connexion,estadocuota.getId());
				
				if(!estadocuota.getVersionRow().equals(timestamp)) {	
					estadocuota.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadocuota.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoCuota()throws Exception {	
		
		if(estadocuota.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadocuota.getIsDeleted() || (estadocuota.getIsChanged()&&!estadocuota.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadocuotaDataAccess.getSetVersionRowEstadoCuota(connexion,estadocuota.getId());
			
			try {							
				if(!estadocuota.getVersionRow().equals(timestamp)) {	
					estadocuota.setVersionRow(timestamp);
				}
				
				estadocuota.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoCuotasWithConnection()throws Exception {	
		if(estadocuotas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoCuota estadocuotaAux:estadocuotas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadocuotaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadocuotaAux.getIsDeleted() || (estadocuotaAux.getIsChanged()&&!estadocuotaAux.getIsNew())) {
						
						timestamp=estadocuotaDataAccess.getSetVersionRowEstadoCuota(connexion,estadocuotaAux.getId());
						
						if(!estadocuota.getVersionRow().equals(timestamp)) {	
							estadocuotaAux.setVersionRow(timestamp);
						}
								
						estadocuotaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoCuotas()throws Exception {	
		if(estadocuotas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoCuota estadocuotaAux:estadocuotas) {
					if(estadocuotaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadocuotaAux.getIsDeleted() || (estadocuotaAux.getIsChanged()&&!estadocuotaAux.getIsNew())) {
						
						timestamp=estadocuotaDataAccess.getSetVersionRowEstadoCuota(connexion,estadocuotaAux.getId());
						
						if(!estadocuotaAux.getVersionRow().equals(timestamp)) {	
							estadocuotaAux.setVersionRow(timestamp);
						}
						
													
						estadocuotaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoCuotaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			CuotaLogic cuotaLogic=new CuotaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuota.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoCuotaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Cuota.class));
											
			

			cuotaLogic.setConnexion(this.getConnexion());
			cuotaLogic.setDatosCliente(this.datosCliente);
			cuotaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoCuota estadocuota:this.estadocuotas) {
				

				classes=new ArrayList<Classe>();
				classes=CuotaConstantesFunciones.getClassesForeignKeysOfCuota(new ArrayList<Classe>(),DeepLoadType.NONE);

				cuotaLogic.setCuotas(estadocuota.cuotas);
				cuotaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoCuota estadocuota,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoCuotaLogicAdditional.updateEstadoCuotaToGet(estadocuota,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadocuota.setCuotas(estadocuotaDataAccess.getCuotas(connexion,estadocuota));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cuota.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadocuota.setCuotas(estadocuotaDataAccess.getCuotas(connexion,estadocuota));

				if(this.isConDeep) {
					CuotaLogic cuotaLogic= new CuotaLogic(this.connexion);
					cuotaLogic.setCuotas(estadocuota.getCuotas());
					ArrayList<Classe> classesLocal=CuotaConstantesFunciones.getClassesForeignKeysOfCuota(new ArrayList<Classe>(),DeepLoadType.NONE);
					cuotaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(cuotaLogic.getCuotas());
					estadocuota.setCuotas(cuotaLogic.getCuotas());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cuota.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cuota.class));
			estadocuota.setCuotas(estadocuotaDataAccess.getCuotas(connexion,estadocuota));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadocuota.setCuotas(estadocuotaDataAccess.getCuotas(connexion,estadocuota));

		for(Cuota cuota:estadocuota.getCuotas()) {
			CuotaLogic cuotaLogic= new CuotaLogic(connexion);
			cuotaLogic.deepLoad(cuota,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cuota.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadocuota.setCuotas(estadocuotaDataAccess.getCuotas(connexion,estadocuota));

				for(Cuota cuota:estadocuota.getCuotas()) {
					CuotaLogic cuotaLogic= new CuotaLogic(connexion);
					cuotaLogic.deepLoad(cuota,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cuota.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cuota.class));
			estadocuota.setCuotas(estadocuotaDataAccess.getCuotas(connexion,estadocuota));

			for(Cuota cuota:estadocuota.getCuotas()) {
				CuotaLogic cuotaLogic= new CuotaLogic(connexion);
				cuotaLogic.deepLoad(cuota,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoCuota estadocuota,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoCuotaLogicAdditional.updateEstadoCuotaToSave(estadocuota,this.arrDatoGeneral);
			
EstadoCuotaDataAccess.save(estadocuota, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Cuota cuota:estadocuota.getCuotas()) {
			cuota.setid_estado_cuota(estadocuota.getId());
			CuotaDataAccess.save(cuota,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Cuota.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cuota cuota:estadocuota.getCuotas()) {
					cuota.setid_estado_cuota(estadocuota.getId());
					CuotaDataAccess.save(cuota,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Cuota cuota:estadocuota.getCuotas()) {
			CuotaLogic cuotaLogic= new CuotaLogic(connexion);
			cuota.setid_estado_cuota(estadocuota.getId());
			CuotaDataAccess.save(cuota,connexion);
			cuotaLogic.deepSave(cuota,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Cuota.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cuota cuota:estadocuota.getCuotas()) {
					CuotaLogic cuotaLogic= new CuotaLogic(connexion);
					cuota.setid_estado_cuota(estadocuota.getId());
					CuotaDataAccess.save(cuota,connexion);
					cuotaLogic.deepSave(cuota,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EstadoCuota.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadocuota,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuota(estadocuota);
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
			this.deepLoad(this.estadocuota,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuota(this.estadocuota);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoCuota.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadocuotas!=null) {
				for(EstadoCuota estadocuota:estadocuotas) {
					this.deepLoad(estadocuota,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuota(estadocuotas);
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
			if(estadocuotas!=null) {
				for(EstadoCuota estadocuota:estadocuotas) {
					this.deepLoad(estadocuota,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuota(estadocuotas);
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
			this.getNewConnexionToDeep(EstadoCuota.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadocuota,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoCuota.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadocuotas!=null) {
				for(EstadoCuota estadocuota:estadocuotas) {
					this.deepSave(estadocuota,isDeep,deepLoadType,clases);
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
			if(estadocuotas!=null) {
				for(EstadoCuota estadocuota:estadocuotas) {
					this.deepSave(estadocuota,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEstadoCuotaPorCodigoWithConnection(String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoCuota.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoCuotaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadocuota=estadocuotaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadocuota,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuota(this.estadocuota);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoCuotaPorCodigo(String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoCuotaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadocuota=estadocuotaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadocuota,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoCuotaConstantesFunciones.refrescarForeignKeysDescripcionesEstadoCuota(this.estadocuota);
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
			if(EstadoCuotaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoCuotaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoCuota estadocuota,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoCuotaConstantesFunciones.ISCONAUDITORIA) {
				if(estadocuota.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoCuotaDataAccess.TABLENAME, estadocuota.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoCuotaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoCuotaLogic.registrarAuditoriaDetallesEstadoCuota(connexion,estadocuota,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadocuota.getIsDeleted()) {
					/*if(!estadocuota.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoCuotaDataAccess.TABLENAME, estadocuota.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoCuotaLogic.registrarAuditoriaDetallesEstadoCuota(connexion,estadocuota,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoCuotaDataAccess.TABLENAME, estadocuota.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadocuota.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoCuotaDataAccess.TABLENAME, estadocuota.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoCuotaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoCuotaLogic.registrarAuditoriaDetallesEstadoCuota(connexion,estadocuota,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoCuota(Connexion connexion,EstadoCuota estadocuota)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadocuota.getIsNew()||!estadocuota.getcodigo().equals(estadocuota.getEstadoCuotaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadocuota.getEstadoCuotaOriginal().getcodigo()!=null)
				{
					strValorActual=estadocuota.getEstadoCuotaOriginal().getcodigo();
				}
				if(estadocuota.getcodigo()!=null)
				{
					strValorNuevo=estadocuota.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoCuotaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadocuota.getIsNew()||!estadocuota.getnombre().equals(estadocuota.getEstadoCuotaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadocuota.getEstadoCuotaOriginal().getnombre()!=null)
				{
					strValorActual=estadocuota.getEstadoCuotaOriginal().getnombre();
				}
				if(estadocuota.getnombre()!=null)
				{
					strValorNuevo=estadocuota.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoCuotaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoCuotaRelacionesWithConnection(EstadoCuota estadocuota,List<Cuota> cuotas) throws Exception {

		if(!estadocuota.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoCuotaRelacionesBase(estadocuota,cuotas,true);
		}
	}

	public void saveEstadoCuotaRelaciones(EstadoCuota estadocuota,List<Cuota> cuotas)throws Exception {

		if(!estadocuota.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoCuotaRelacionesBase(estadocuota,cuotas,false);
		}
	}

	public void saveEstadoCuotaRelacionesBase(EstadoCuota estadocuota,List<Cuota> cuotas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoCuota-saveRelacionesWithConnection");}
	
			estadocuota.setCuotas(cuotas);

			this.setEstadoCuota(estadocuota);

				if((estadocuota.getIsNew()||estadocuota.getIsChanged())&&!estadocuota.getIsDeleted()) {
					this.saveEstadoCuota();
					this.saveEstadoCuotaRelacionesDetalles(cuotas);

				} else if(estadocuota.getIsDeleted()) {
					this.saveEstadoCuotaRelacionesDetalles(cuotas);
					this.saveEstadoCuota();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			CuotaConstantesFunciones.InicializarGeneralEntityAuxiliaresCuotas(cuotas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoCuotaRelacionesDetalles(List<Cuota> cuotas)throws Exception {
		try {
	

			Long idEstadoCuotaActual=this.getEstadoCuota().getId();

			CuotaLogic cuotaLogic_Desde_EstadoCuota=new CuotaLogic();
			cuotaLogic_Desde_EstadoCuota.setCuotas(cuotas);

			cuotaLogic_Desde_EstadoCuota.setConnexion(this.getConnexion());
			cuotaLogic_Desde_EstadoCuota.setDatosCliente(this.datosCliente);

			for(Cuota cuota_Desde_EstadoCuota:cuotaLogic_Desde_EstadoCuota.getCuotas()) {
				cuota_Desde_EstadoCuota.setid_estado_cuota(idEstadoCuotaActual);
			}

			cuotaLogic_Desde_EstadoCuota.saveCuotas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoCuota(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoCuotaConstantesFunciones.getClassesForeignKeysOfEstadoCuota(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoCuota(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoCuotaConstantesFunciones.getClassesRelationshipsOfEstadoCuota(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

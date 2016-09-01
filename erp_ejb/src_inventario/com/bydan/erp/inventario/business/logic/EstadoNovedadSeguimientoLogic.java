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
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.util.EstadoNovedadSeguimientoConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoNovedadSeguimientoParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoNovedadSeguimientoParameterGeneral;
import com.bydan.erp.inventario.business.entity.EstadoNovedadSeguimiento;
//import com.bydan.erp.inventario.business.logic.EstadoNovedadSeguimientoLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class EstadoNovedadSeguimientoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoNovedadSeguimientoLogic.class);
	
	protected EstadoNovedadSeguimientoDataAccess estadonovedadseguimientoDataAccess; 	
	protected EstadoNovedadSeguimiento estadonovedadseguimiento;
	protected List<EstadoNovedadSeguimiento> estadonovedadseguimientos;
	protected Object estadonovedadseguimientoObject;	
	protected List<Object> estadonovedadseguimientosObject;
	
	public static ClassValidator<EstadoNovedadSeguimiento> estadonovedadseguimientoValidator = new ClassValidator<EstadoNovedadSeguimiento>(EstadoNovedadSeguimiento.class);	
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
	
	
	
	
	public  EstadoNovedadSeguimientoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadonovedadseguimientoDataAccess = new EstadoNovedadSeguimientoDataAccess();
			
			this.estadonovedadseguimientos= new ArrayList<EstadoNovedadSeguimiento>();
			this.estadonovedadseguimiento= new EstadoNovedadSeguimiento();
			
			this.estadonovedadseguimientoObject=new Object();
			this.estadonovedadseguimientosObject=new ArrayList<Object>();
				
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
			
			this.estadonovedadseguimientoDataAccess.setConnexionType(this.connexionType);
			this.estadonovedadseguimientoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoNovedadSeguimientoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadonovedadseguimientoDataAccess = new EstadoNovedadSeguimientoDataAccess();
			this.estadonovedadseguimientos= new ArrayList<EstadoNovedadSeguimiento>();
			this.estadonovedadseguimiento= new EstadoNovedadSeguimiento();
			this.estadonovedadseguimientoObject=new Object();
			this.estadonovedadseguimientosObject=new ArrayList<Object>();
			
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
			
			this.estadonovedadseguimientoDataAccess.setConnexionType(this.connexionType);
			this.estadonovedadseguimientoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoNovedadSeguimiento getEstadoNovedadSeguimiento() throws Exception {	
		//EstadoNovedadSeguimientoLogicAdditional.checkEstadoNovedadSeguimientoToGet(estadonovedadseguimiento,this.datosCliente,this.arrDatoGeneral);
		//EstadoNovedadSeguimientoLogicAdditional.updateEstadoNovedadSeguimientoToGet(estadonovedadseguimiento,this.arrDatoGeneral);
		
		return estadonovedadseguimiento;
	}
		
	public void setEstadoNovedadSeguimiento(EstadoNovedadSeguimiento newEstadoNovedadSeguimiento) {
		this.estadonovedadseguimiento = newEstadoNovedadSeguimiento;
	}
	
	public EstadoNovedadSeguimientoDataAccess getEstadoNovedadSeguimientoDataAccess() {
		return estadonovedadseguimientoDataAccess;
	}
	
	public void setEstadoNovedadSeguimientoDataAccess(EstadoNovedadSeguimientoDataAccess newestadonovedadseguimientoDataAccess) {
		this.estadonovedadseguimientoDataAccess = newestadonovedadseguimientoDataAccess;
	}
	
	public List<EstadoNovedadSeguimiento> getEstadoNovedadSeguimientos() throws Exception {		
		this.quitarEstadoNovedadSeguimientosNulos();
		
		//EstadoNovedadSeguimientoLogicAdditional.checkEstadoNovedadSeguimientoToGets(estadonovedadseguimientos,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoNovedadSeguimiento estadonovedadseguimientoLocal: estadonovedadseguimientos ) {
			//EstadoNovedadSeguimientoLogicAdditional.updateEstadoNovedadSeguimientoToGet(estadonovedadseguimientoLocal,this.arrDatoGeneral);
		}
		
		return estadonovedadseguimientos;
	}
	
	public void setEstadoNovedadSeguimientos(List<EstadoNovedadSeguimiento> newEstadoNovedadSeguimientos) {
		this.estadonovedadseguimientos = newEstadoNovedadSeguimientos;
	}
	
	public Object getEstadoNovedadSeguimientoObject() {	
		this.estadonovedadseguimientoObject=this.estadonovedadseguimientoDataAccess.getEntityObject();
		return this.estadonovedadseguimientoObject;
	}
		
	public void setEstadoNovedadSeguimientoObject(Object newEstadoNovedadSeguimientoObject) {
		this.estadonovedadseguimientoObject = newEstadoNovedadSeguimientoObject;
	}
	
	public List<Object> getEstadoNovedadSeguimientosObject() {		
		this.estadonovedadseguimientosObject=this.estadonovedadseguimientoDataAccess.getEntitiesObject();
		return this.estadonovedadseguimientosObject;
	}
		
	public void setEstadoNovedadSeguimientosObject(List<Object> newEstadoNovedadSeguimientosObject) {
		this.estadonovedadseguimientosObject = newEstadoNovedadSeguimientosObject;
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
		
		if(this.estadonovedadseguimientoDataAccess!=null) {
			this.estadonovedadseguimientoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadSeguimiento.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadonovedadseguimientoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadonovedadseguimientoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadonovedadseguimiento = new  EstadoNovedadSeguimiento();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadSeguimiento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadonovedadseguimiento=estadonovedadseguimientoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadonovedadseguimiento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoNovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadSeguimiento(this.estadonovedadseguimiento);
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
		estadonovedadseguimiento = new  EstadoNovedadSeguimiento();
		  		  
        try {
			
			estadonovedadseguimiento=estadonovedadseguimientoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadonovedadseguimiento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoNovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadSeguimiento(this.estadonovedadseguimiento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadonovedadseguimiento = new  EstadoNovedadSeguimiento();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadSeguimiento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadonovedadseguimiento=estadonovedadseguimientoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadonovedadseguimiento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoNovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadSeguimiento(this.estadonovedadseguimiento);
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
		estadonovedadseguimiento = new  EstadoNovedadSeguimiento();
		  		  
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
		estadonovedadseguimiento = new  EstadoNovedadSeguimiento();
		  		  
        try {
			
			estadonovedadseguimiento=estadonovedadseguimientoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadonovedadseguimiento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoNovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadSeguimiento(this.estadonovedadseguimiento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadonovedadseguimiento = new  EstadoNovedadSeguimiento();
		  		  
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
		estadonovedadseguimiento = new  EstadoNovedadSeguimiento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadSeguimiento.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadonovedadseguimientoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadonovedadseguimiento = new  EstadoNovedadSeguimiento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadonovedadseguimientoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadonovedadseguimiento = new  EstadoNovedadSeguimiento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadSeguimiento.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadonovedadseguimientoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadonovedadseguimiento = new  EstadoNovedadSeguimiento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadonovedadseguimientoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadonovedadseguimiento = new  EstadoNovedadSeguimiento();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadSeguimiento.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadonovedadseguimientoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadonovedadseguimiento = new  EstadoNovedadSeguimiento();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadonovedadseguimientoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadonovedadseguimientos = new  ArrayList<EstadoNovedadSeguimiento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadSeguimiento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoNovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonovedadseguimientos=estadonovedadseguimientoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoNovedadSeguimiento(estadonovedadseguimientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadSeguimiento(this.estadonovedadseguimientos);
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
		estadonovedadseguimientos = new  ArrayList<EstadoNovedadSeguimiento>();
		  		  
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
		estadonovedadseguimientos = new  ArrayList<EstadoNovedadSeguimiento>();
		  		  
        try {			
			EstadoNovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonovedadseguimientos=estadonovedadseguimientoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoNovedadSeguimiento(estadonovedadseguimientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadSeguimiento(this.estadonovedadseguimientos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadonovedadseguimientos = new  ArrayList<EstadoNovedadSeguimiento>();
		  		  
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
		estadonovedadseguimientos = new  ArrayList<EstadoNovedadSeguimiento>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadSeguimiento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoNovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonovedadseguimientos=estadonovedadseguimientoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoNovedadSeguimiento(estadonovedadseguimientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadSeguimiento(this.estadonovedadseguimientos);
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
		estadonovedadseguimientos = new  ArrayList<EstadoNovedadSeguimiento>();
		  		  
        try {
			EstadoNovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonovedadseguimientos=estadonovedadseguimientoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoNovedadSeguimiento(estadonovedadseguimientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadSeguimiento(this.estadonovedadseguimientos);
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
		estadonovedadseguimientos = new  ArrayList<EstadoNovedadSeguimiento>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadSeguimiento.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoNovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonovedadseguimientos=estadonovedadseguimientoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoNovedadSeguimiento(estadonovedadseguimientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadSeguimiento(this.estadonovedadseguimientos);
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
		estadonovedadseguimientos = new  ArrayList<EstadoNovedadSeguimiento>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoNovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonovedadseguimientos=estadonovedadseguimientoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoNovedadSeguimiento(estadonovedadseguimientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadSeguimiento(this.estadonovedadseguimientos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadonovedadseguimiento = new  EstadoNovedadSeguimiento();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadSeguimiento.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoNovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonovedadseguimiento=estadonovedadseguimientoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoNovedadSeguimiento(estadonovedadseguimiento);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadSeguimiento(this.estadonovedadseguimiento);
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
		estadonovedadseguimiento = new  EstadoNovedadSeguimiento();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoNovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonovedadseguimiento=estadonovedadseguimientoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoNovedadSeguimiento(estadonovedadseguimiento);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadSeguimiento(this.estadonovedadseguimiento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosEstadoNovedadSeguimientosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadonovedadseguimientos = new  ArrayList<EstadoNovedadSeguimiento>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadSeguimiento.class.getSimpleName()+"-getTodosEstadoNovedadSeguimientosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoNovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonovedadseguimientos=estadonovedadseguimientoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoNovedadSeguimiento(estadonovedadseguimientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadSeguimiento(this.estadonovedadseguimientos);
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
	
	public  void  getTodosEstadoNovedadSeguimientos(String sFinalQuery,Pagination pagination)throws Exception {
		estadonovedadseguimientos = new  ArrayList<EstadoNovedadSeguimiento>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoNovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadonovedadseguimientos=estadonovedadseguimientoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoNovedadSeguimiento(estadonovedadseguimientos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoNovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadSeguimiento(this.estadonovedadseguimientos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoNovedadSeguimiento(EstadoNovedadSeguimiento estadonovedadseguimiento) throws Exception {
		Boolean estaValidado=false;
		
		if(estadonovedadseguimiento.getIsNew() || estadonovedadseguimiento.getIsChanged()) { 
			this.invalidValues = estadonovedadseguimientoValidator.getInvalidValues(estadonovedadseguimiento);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadonovedadseguimiento);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoNovedadSeguimiento(List<EstadoNovedadSeguimiento> EstadoNovedadSeguimientos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoNovedadSeguimiento estadonovedadseguimientoLocal:estadonovedadseguimientos) {				
			estaValidadoObjeto=this.validarGuardarEstadoNovedadSeguimiento(estadonovedadseguimientoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoNovedadSeguimiento(List<EstadoNovedadSeguimiento> EstadoNovedadSeguimientos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoNovedadSeguimiento(estadonovedadseguimientos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoNovedadSeguimiento(EstadoNovedadSeguimiento EstadoNovedadSeguimiento) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoNovedadSeguimiento(estadonovedadseguimiento)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoNovedadSeguimiento estadonovedadseguimiento) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadonovedadseguimiento.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoNovedadSeguimientoConstantesFunciones.getEstadoNovedadSeguimientoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadonovedadseguimiento","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoNovedadSeguimientoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoNovedadSeguimientoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoNovedadSeguimientoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadSeguimiento.class.getSimpleName()+"-saveEstadoNovedadSeguimientoWithConnection");connexion.begin();			
			
			//EstadoNovedadSeguimientoLogicAdditional.checkEstadoNovedadSeguimientoToSave(this.estadonovedadseguimiento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoNovedadSeguimientoLogicAdditional.updateEstadoNovedadSeguimientoToSave(this.estadonovedadseguimiento,this.arrDatoGeneral);
			
			EstadoNovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadonovedadseguimiento,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoNovedadSeguimiento();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoNovedadSeguimiento(this.estadonovedadseguimiento)) {
				EstadoNovedadSeguimientoDataAccess.save(this.estadonovedadseguimiento, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadonovedadseguimiento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoNovedadSeguimientoLogicAdditional.checkEstadoNovedadSeguimientoToSaveAfter(this.estadonovedadseguimiento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoNovedadSeguimiento();
			
			connexion.commit();			
			
			if(this.estadonovedadseguimiento.getIsDeleted()) {
				this.estadonovedadseguimiento=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoNovedadSeguimiento()throws Exception {	
		try {	
			
			//EstadoNovedadSeguimientoLogicAdditional.checkEstadoNovedadSeguimientoToSave(this.estadonovedadseguimiento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoNovedadSeguimientoLogicAdditional.updateEstadoNovedadSeguimientoToSave(this.estadonovedadseguimiento,this.arrDatoGeneral);
			
			EstadoNovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadonovedadseguimiento,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoNovedadSeguimiento(this.estadonovedadseguimiento)) {			
				EstadoNovedadSeguimientoDataAccess.save(this.estadonovedadseguimiento, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadonovedadseguimiento,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoNovedadSeguimientoLogicAdditional.checkEstadoNovedadSeguimientoToSaveAfter(this.estadonovedadseguimiento,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadonovedadseguimiento.getIsDeleted()) {
				this.estadonovedadseguimiento=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoNovedadSeguimientosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadSeguimiento.class.getSimpleName()+"-saveEstadoNovedadSeguimientosWithConnection");connexion.begin();			
			
			//EstadoNovedadSeguimientoLogicAdditional.checkEstadoNovedadSeguimientoToSaves(estadonovedadseguimientos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoNovedadSeguimientos();
			
			Boolean validadoTodosEstadoNovedadSeguimiento=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoNovedadSeguimiento estadonovedadseguimientoLocal:estadonovedadseguimientos) {		
				if(estadonovedadseguimientoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoNovedadSeguimientoLogicAdditional.updateEstadoNovedadSeguimientoToSave(estadonovedadseguimientoLocal,this.arrDatoGeneral);
	        	
				EstadoNovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadonovedadseguimientoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoNovedadSeguimiento(estadonovedadseguimientoLocal)) {
					EstadoNovedadSeguimientoDataAccess.save(estadonovedadseguimientoLocal, connexion);				
				} else {
					validadoTodosEstadoNovedadSeguimiento=false;
				}
			}
			
			if(!validadoTodosEstadoNovedadSeguimiento) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoNovedadSeguimientoLogicAdditional.checkEstadoNovedadSeguimientoToSavesAfter(estadonovedadseguimientos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoNovedadSeguimientos();
			
			connexion.commit();		
			
			this.quitarEstadoNovedadSeguimientosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoNovedadSeguimientos()throws Exception {				
		 try {	
			//EstadoNovedadSeguimientoLogicAdditional.checkEstadoNovedadSeguimientoToSaves(estadonovedadseguimientos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoNovedadSeguimiento=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoNovedadSeguimiento estadonovedadseguimientoLocal:estadonovedadseguimientos) {				
				if(estadonovedadseguimientoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoNovedadSeguimientoLogicAdditional.updateEstadoNovedadSeguimientoToSave(estadonovedadseguimientoLocal,this.arrDatoGeneral);
	        	
				EstadoNovedadSeguimientoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadonovedadseguimientoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoNovedadSeguimiento(estadonovedadseguimientoLocal)) {				
					EstadoNovedadSeguimientoDataAccess.save(estadonovedadseguimientoLocal, connexion);				
				} else {
					validadoTodosEstadoNovedadSeguimiento=false;
				}
			}
			
			if(!validadoTodosEstadoNovedadSeguimiento) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoNovedadSeguimientoLogicAdditional.checkEstadoNovedadSeguimientoToSavesAfter(estadonovedadseguimientos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoNovedadSeguimientosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoNovedadSeguimientoParameterReturnGeneral procesarAccionEstadoNovedadSeguimientos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoNovedadSeguimiento> estadonovedadseguimientos,EstadoNovedadSeguimientoParameterReturnGeneral estadonovedadseguimientoParameterGeneral)throws Exception {
		 try {	
			EstadoNovedadSeguimientoParameterReturnGeneral estadonovedadseguimientoReturnGeneral=new EstadoNovedadSeguimientoParameterReturnGeneral();
	
			
			return estadonovedadseguimientoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoNovedadSeguimientoParameterReturnGeneral procesarAccionEstadoNovedadSeguimientosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoNovedadSeguimiento> estadonovedadseguimientos,EstadoNovedadSeguimientoParameterReturnGeneral estadonovedadseguimientoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadSeguimiento.class.getSimpleName()+"-procesarAccionEstadoNovedadSeguimientosWithConnection");connexion.begin();			
			
			EstadoNovedadSeguimientoParameterReturnGeneral estadonovedadseguimientoReturnGeneral=new EstadoNovedadSeguimientoParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return estadonovedadseguimientoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoNovedadSeguimientoParameterReturnGeneral procesarEventosEstadoNovedadSeguimientos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoNovedadSeguimiento> estadonovedadseguimientos,EstadoNovedadSeguimiento estadonovedadseguimiento,EstadoNovedadSeguimientoParameterReturnGeneral estadonovedadseguimientoParameterGeneral,Boolean isEsNuevoEstadoNovedadSeguimiento,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoNovedadSeguimientoParameterReturnGeneral estadonovedadseguimientoReturnGeneral=new EstadoNovedadSeguimientoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadonovedadseguimientoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return estadonovedadseguimientoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoNovedadSeguimientoParameterReturnGeneral procesarEventosEstadoNovedadSeguimientosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoNovedadSeguimiento> estadonovedadseguimientos,EstadoNovedadSeguimiento estadonovedadseguimiento,EstadoNovedadSeguimientoParameterReturnGeneral estadonovedadseguimientoParameterGeneral,Boolean isEsNuevoEstadoNovedadSeguimiento,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadSeguimiento.class.getSimpleName()+"-procesarEventosEstadoNovedadSeguimientosWithConnection");connexion.begin();			
			
			EstadoNovedadSeguimientoParameterReturnGeneral estadonovedadseguimientoReturnGeneral=new EstadoNovedadSeguimientoParameterReturnGeneral();
	
			estadonovedadseguimientoReturnGeneral.setEstadoNovedadSeguimiento(estadonovedadseguimiento);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadonovedadseguimientoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return estadonovedadseguimientoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoNovedadSeguimientoParameterReturnGeneral procesarImportacionEstadoNovedadSeguimientosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoNovedadSeguimientoParameterReturnGeneral estadonovedadseguimientoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoNovedadSeguimiento.class.getSimpleName()+"-procesarImportacionEstadoNovedadSeguimientosWithConnection");connexion.begin();			
			
			EstadoNovedadSeguimientoParameterReturnGeneral estadonovedadseguimientoReturnGeneral=new EstadoNovedadSeguimientoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadonovedadseguimientos=new ArrayList<EstadoNovedadSeguimiento>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadonovedadseguimiento=new EstadoNovedadSeguimiento();
				
				
				if(conColumnasBase) {this.estadonovedadseguimiento.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadonovedadseguimiento.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadonovedadseguimiento.setcodigo(arrColumnas[iColumn++]);
				this.estadonovedadseguimiento.setnombre(arrColumnas[iColumn++]);
				
				this.estadonovedadseguimientos.add(this.estadonovedadseguimiento);
			}
			
			this.saveEstadoNovedadSeguimientos();
			
			this.connexion.commit();
			
			estadonovedadseguimientoReturnGeneral.setConRetornoEstaProcesado(true);
			estadonovedadseguimientoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadonovedadseguimientoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoNovedadSeguimientosEliminados() throws Exception {				
		
		List<EstadoNovedadSeguimiento> estadonovedadseguimientosAux= new ArrayList<EstadoNovedadSeguimiento>();
		
		for(EstadoNovedadSeguimiento estadonovedadseguimiento:estadonovedadseguimientos) {
			if(!estadonovedadseguimiento.getIsDeleted()) {
				estadonovedadseguimientosAux.add(estadonovedadseguimiento);
			}
		}
		
		estadonovedadseguimientos=estadonovedadseguimientosAux;
	}
	
	public void quitarEstadoNovedadSeguimientosNulos() throws Exception {				
		
		List<EstadoNovedadSeguimiento> estadonovedadseguimientosAux= new ArrayList<EstadoNovedadSeguimiento>();
		
		for(EstadoNovedadSeguimiento estadonovedadseguimiento : this.estadonovedadseguimientos) {
			if(estadonovedadseguimiento==null) {
				estadonovedadseguimientosAux.add(estadonovedadseguimiento);
			}
		}
		
		//this.estadonovedadseguimientos=estadonovedadseguimientosAux;
		
		this.estadonovedadseguimientos.removeAll(estadonovedadseguimientosAux);
	}
	
	public void getSetVersionRowEstadoNovedadSeguimientoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadonovedadseguimiento.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadonovedadseguimiento.getIsDeleted() || (estadonovedadseguimiento.getIsChanged()&&!estadonovedadseguimiento.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadonovedadseguimientoDataAccess.getSetVersionRowEstadoNovedadSeguimiento(connexion,estadonovedadseguimiento.getId());
				
				if(!estadonovedadseguimiento.getVersionRow().equals(timestamp)) {	
					estadonovedadseguimiento.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadonovedadseguimiento.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoNovedadSeguimiento()throws Exception {	
		
		if(estadonovedadseguimiento.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadonovedadseguimiento.getIsDeleted() || (estadonovedadseguimiento.getIsChanged()&&!estadonovedadseguimiento.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadonovedadseguimientoDataAccess.getSetVersionRowEstadoNovedadSeguimiento(connexion,estadonovedadseguimiento.getId());
			
			try {							
				if(!estadonovedadseguimiento.getVersionRow().equals(timestamp)) {	
					estadonovedadseguimiento.setVersionRow(timestamp);
				}
				
				estadonovedadseguimiento.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoNovedadSeguimientosWithConnection()throws Exception {	
		if(estadonovedadseguimientos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoNovedadSeguimiento estadonovedadseguimientoAux:estadonovedadseguimientos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadonovedadseguimientoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadonovedadseguimientoAux.getIsDeleted() || (estadonovedadseguimientoAux.getIsChanged()&&!estadonovedadseguimientoAux.getIsNew())) {
						
						timestamp=estadonovedadseguimientoDataAccess.getSetVersionRowEstadoNovedadSeguimiento(connexion,estadonovedadseguimientoAux.getId());
						
						if(!estadonovedadseguimiento.getVersionRow().equals(timestamp)) {	
							estadonovedadseguimientoAux.setVersionRow(timestamp);
						}
								
						estadonovedadseguimientoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoNovedadSeguimientos()throws Exception {	
		if(estadonovedadseguimientos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoNovedadSeguimiento estadonovedadseguimientoAux:estadonovedadseguimientos) {
					if(estadonovedadseguimientoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadonovedadseguimientoAux.getIsDeleted() || (estadonovedadseguimientoAux.getIsChanged()&&!estadonovedadseguimientoAux.getIsNew())) {
						
						timestamp=estadonovedadseguimientoDataAccess.getSetVersionRowEstadoNovedadSeguimiento(connexion,estadonovedadseguimientoAux.getId());
						
						if(!estadonovedadseguimientoAux.getVersionRow().equals(timestamp)) {	
							estadonovedadseguimientoAux.setVersionRow(timestamp);
						}
						
													
						estadonovedadseguimientoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(EstadoNovedadSeguimiento estadonovedadseguimiento,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//EstadoNovedadSeguimientoLogicAdditional.updateEstadoNovedadSeguimientoToGet(estadonovedadseguimiento,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoNovedadSeguimiento estadonovedadseguimiento,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoNovedadSeguimiento.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadonovedadseguimiento,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoNovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadSeguimiento(estadonovedadseguimiento);
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
			this.deepLoad(this.estadonovedadseguimiento,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoNovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadSeguimiento(this.estadonovedadseguimiento);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoNovedadSeguimiento.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadonovedadseguimientos!=null) {
				for(EstadoNovedadSeguimiento estadonovedadseguimiento:estadonovedadseguimientos) {
					this.deepLoad(estadonovedadseguimiento,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoNovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadSeguimiento(estadonovedadseguimientos);
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
			if(estadonovedadseguimientos!=null) {
				for(EstadoNovedadSeguimiento estadonovedadseguimiento:estadonovedadseguimientos) {
					this.deepLoad(estadonovedadseguimiento,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoNovedadSeguimientoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoNovedadSeguimiento(estadonovedadseguimientos);
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
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoNovedadSeguimientoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoNovedadSeguimientoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoNovedadSeguimiento estadonovedadseguimiento,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoNovedadSeguimientoConstantesFunciones.ISCONAUDITORIA) {
				if(estadonovedadseguimiento.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoNovedadSeguimientoDataAccess.TABLENAME, estadonovedadseguimiento.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoNovedadSeguimientoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoNovedadSeguimientoLogic.registrarAuditoriaDetallesEstadoNovedadSeguimiento(connexion,estadonovedadseguimiento,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadonovedadseguimiento.getIsDeleted()) {
					/*if(!estadonovedadseguimiento.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoNovedadSeguimientoDataAccess.TABLENAME, estadonovedadseguimiento.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoNovedadSeguimientoLogic.registrarAuditoriaDetallesEstadoNovedadSeguimiento(connexion,estadonovedadseguimiento,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoNovedadSeguimientoDataAccess.TABLENAME, estadonovedadseguimiento.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadonovedadseguimiento.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoNovedadSeguimientoDataAccess.TABLENAME, estadonovedadseguimiento.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoNovedadSeguimientoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoNovedadSeguimientoLogic.registrarAuditoriaDetallesEstadoNovedadSeguimiento(connexion,estadonovedadseguimiento,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoNovedadSeguimiento(Connexion connexion,EstadoNovedadSeguimiento estadonovedadseguimiento)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadonovedadseguimiento.getIsNew()||!estadonovedadseguimiento.getcodigo().equals(estadonovedadseguimiento.getEstadoNovedadSeguimientoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadonovedadseguimiento.getEstadoNovedadSeguimientoOriginal().getcodigo()!=null)
				{
					strValorActual=estadonovedadseguimiento.getEstadoNovedadSeguimientoOriginal().getcodigo();
				}
				if(estadonovedadseguimiento.getcodigo()!=null)
				{
					strValorNuevo=estadonovedadseguimiento.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoNovedadSeguimientoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadonovedadseguimiento.getIsNew()||!estadonovedadseguimiento.getnombre().equals(estadonovedadseguimiento.getEstadoNovedadSeguimientoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadonovedadseguimiento.getEstadoNovedadSeguimientoOriginal().getnombre()!=null)
				{
					strValorActual=estadonovedadseguimiento.getEstadoNovedadSeguimientoOriginal().getnombre();
				}
				if(estadonovedadseguimiento.getnombre()!=null)
				{
					strValorNuevo=estadonovedadseguimiento.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoNovedadSeguimientoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoNovedadSeguimiento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoNovedadSeguimientoConstantesFunciones.getClassesForeignKeysOfEstadoNovedadSeguimiento(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoNovedadSeguimiento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoNovedadSeguimientoConstantesFunciones.getClassesRelationshipsOfEstadoNovedadSeguimiento(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

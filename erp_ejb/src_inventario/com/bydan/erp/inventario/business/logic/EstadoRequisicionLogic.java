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
import com.bydan.erp.inventario.util.EstadoRequisicionConstantesFunciones;
import com.bydan.erp.inventario.util.EstadoRequisicionParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EstadoRequisicionParameterGeneral;
import com.bydan.erp.inventario.business.entity.EstadoRequisicion;
import com.bydan.erp.inventario.business.logic.EstadoRequisicionLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class EstadoRequisicionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoRequisicionLogic.class);
	
	protected EstadoRequisicionDataAccess estadorequisicionDataAccess; 	
	protected EstadoRequisicion estadorequisicion;
	protected List<EstadoRequisicion> estadorequisicions;
	protected Object estadorequisicionObject;	
	protected List<Object> estadorequisicionsObject;
	
	public static ClassValidator<EstadoRequisicion> estadorequisicionValidator = new ClassValidator<EstadoRequisicion>(EstadoRequisicion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoRequisicionLogicAdditional estadorequisicionLogicAdditional=null;
	
	public EstadoRequisicionLogicAdditional getEstadoRequisicionLogicAdditional() {
		return this.estadorequisicionLogicAdditional;
	}
	
	public void setEstadoRequisicionLogicAdditional(EstadoRequisicionLogicAdditional estadorequisicionLogicAdditional) {
		try {
			this.estadorequisicionLogicAdditional=estadorequisicionLogicAdditional;
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
	
	
	
	
	public  EstadoRequisicionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadorequisicionDataAccess = new EstadoRequisicionDataAccess();
			
			this.estadorequisicions= new ArrayList<EstadoRequisicion>();
			this.estadorequisicion= new EstadoRequisicion();
			
			this.estadorequisicionObject=new Object();
			this.estadorequisicionsObject=new ArrayList<Object>();
				
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
			
			this.estadorequisicionDataAccess.setConnexionType(this.connexionType);
			this.estadorequisicionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoRequisicionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadorequisicionDataAccess = new EstadoRequisicionDataAccess();
			this.estadorequisicions= new ArrayList<EstadoRequisicion>();
			this.estadorequisicion= new EstadoRequisicion();
			this.estadorequisicionObject=new Object();
			this.estadorequisicionsObject=new ArrayList<Object>();
			
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
			
			this.estadorequisicionDataAccess.setConnexionType(this.connexionType);
			this.estadorequisicionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoRequisicion getEstadoRequisicion() throws Exception {	
		EstadoRequisicionLogicAdditional.checkEstadoRequisicionToGet(estadorequisicion,this.datosCliente,this.arrDatoGeneral);
		EstadoRequisicionLogicAdditional.updateEstadoRequisicionToGet(estadorequisicion,this.arrDatoGeneral);
		
		return estadorequisicion;
	}
		
	public void setEstadoRequisicion(EstadoRequisicion newEstadoRequisicion) {
		this.estadorequisicion = newEstadoRequisicion;
	}
	
	public EstadoRequisicionDataAccess getEstadoRequisicionDataAccess() {
		return estadorequisicionDataAccess;
	}
	
	public void setEstadoRequisicionDataAccess(EstadoRequisicionDataAccess newestadorequisicionDataAccess) {
		this.estadorequisicionDataAccess = newestadorequisicionDataAccess;
	}
	
	public List<EstadoRequisicion> getEstadoRequisicions() throws Exception {		
		this.quitarEstadoRequisicionsNulos();
		
		EstadoRequisicionLogicAdditional.checkEstadoRequisicionToGets(estadorequisicions,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoRequisicion estadorequisicionLocal: estadorequisicions ) {
			EstadoRequisicionLogicAdditional.updateEstadoRequisicionToGet(estadorequisicionLocal,this.arrDatoGeneral);
		}
		
		return estadorequisicions;
	}
	
	public void setEstadoRequisicions(List<EstadoRequisicion> newEstadoRequisicions) {
		this.estadorequisicions = newEstadoRequisicions;
	}
	
	public Object getEstadoRequisicionObject() {	
		this.estadorequisicionObject=this.estadorequisicionDataAccess.getEntityObject();
		return this.estadorequisicionObject;
	}
		
	public void setEstadoRequisicionObject(Object newEstadoRequisicionObject) {
		this.estadorequisicionObject = newEstadoRequisicionObject;
	}
	
	public List<Object> getEstadoRequisicionsObject() {		
		this.estadorequisicionsObject=this.estadorequisicionDataAccess.getEntitiesObject();
		return this.estadorequisicionsObject;
	}
		
	public void setEstadoRequisicionsObject(List<Object> newEstadoRequisicionsObject) {
		this.estadorequisicionsObject = newEstadoRequisicionsObject;
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
		
		if(this.estadorequisicionDataAccess!=null) {
			this.estadorequisicionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRequisicion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadorequisicionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadorequisicionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadorequisicion = new  EstadoRequisicion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRequisicion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadorequisicion=estadorequisicionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadorequisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRequisicion(this.estadorequisicion);
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
		estadorequisicion = new  EstadoRequisicion();
		  		  
        try {
			
			estadorequisicion=estadorequisicionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadorequisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRequisicion(this.estadorequisicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadorequisicion = new  EstadoRequisicion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRequisicion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadorequisicion=estadorequisicionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadorequisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRequisicion(this.estadorequisicion);
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
		estadorequisicion = new  EstadoRequisicion();
		  		  
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
		estadorequisicion = new  EstadoRequisicion();
		  		  
        try {
			
			estadorequisicion=estadorequisicionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadorequisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRequisicion(this.estadorequisicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadorequisicion = new  EstadoRequisicion();
		  		  
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
		estadorequisicion = new  EstadoRequisicion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRequisicion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadorequisicionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadorequisicion = new  EstadoRequisicion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadorequisicionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadorequisicion = new  EstadoRequisicion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRequisicion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadorequisicionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadorequisicion = new  EstadoRequisicion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadorequisicionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadorequisicion = new  EstadoRequisicion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRequisicion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadorequisicionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadorequisicion = new  EstadoRequisicion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadorequisicionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadorequisicions = new  ArrayList<EstadoRequisicion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRequisicion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorequisicions=estadorequisicionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoRequisicion(estadorequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRequisicion(this.estadorequisicions);
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
		estadorequisicions = new  ArrayList<EstadoRequisicion>();
		  		  
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
		estadorequisicions = new  ArrayList<EstadoRequisicion>();
		  		  
        try {			
			EstadoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorequisicions=estadorequisicionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoRequisicion(estadorequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRequisicion(this.estadorequisicions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadorequisicions = new  ArrayList<EstadoRequisicion>();
		  		  
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
		estadorequisicions = new  ArrayList<EstadoRequisicion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRequisicion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorequisicions=estadorequisicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoRequisicion(estadorequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRequisicion(this.estadorequisicions);
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
		estadorequisicions = new  ArrayList<EstadoRequisicion>();
		  		  
        try {
			EstadoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorequisicions=estadorequisicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoRequisicion(estadorequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRequisicion(this.estadorequisicions);
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
		estadorequisicions = new  ArrayList<EstadoRequisicion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRequisicion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorequisicions=estadorequisicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoRequisicion(estadorequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRequisicion(this.estadorequisicions);
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
		estadorequisicions = new  ArrayList<EstadoRequisicion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorequisicions=estadorequisicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoRequisicion(estadorequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRequisicion(this.estadorequisicions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadorequisicion = new  EstadoRequisicion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRequisicion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorequisicion=estadorequisicionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoRequisicion(estadorequisicion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRequisicion(this.estadorequisicion);
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
		estadorequisicion = new  EstadoRequisicion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorequisicion=estadorequisicionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoRequisicion(estadorequisicion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRequisicion(this.estadorequisicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadorequisicions = new  ArrayList<EstadoRequisicion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRequisicion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorequisicions=estadorequisicionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoRequisicion(estadorequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRequisicion(this.estadorequisicions);
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
		estadorequisicions = new  ArrayList<EstadoRequisicion>();
		  		  
        try {
			EstadoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorequisicions=estadorequisicionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoRequisicion(estadorequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRequisicion(this.estadorequisicions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoRequisicionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadorequisicions = new  ArrayList<EstadoRequisicion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRequisicion.class.getSimpleName()+"-getTodosEstadoRequisicionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorequisicions=estadorequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoRequisicion(estadorequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRequisicion(this.estadorequisicions);
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
	
	public  void  getTodosEstadoRequisicions(String sFinalQuery,Pagination pagination)throws Exception {
		estadorequisicions = new  ArrayList<EstadoRequisicion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadorequisicions=estadorequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoRequisicion(estadorequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRequisicion(this.estadorequisicions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoRequisicion(EstadoRequisicion estadorequisicion) throws Exception {
		Boolean estaValidado=false;
		
		if(estadorequisicion.getIsNew() || estadorequisicion.getIsChanged()) { 
			this.invalidValues = estadorequisicionValidator.getInvalidValues(estadorequisicion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadorequisicion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoRequisicion(List<EstadoRequisicion> EstadoRequisicions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoRequisicion estadorequisicionLocal:estadorequisicions) {				
			estaValidadoObjeto=this.validarGuardarEstadoRequisicion(estadorequisicionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoRequisicion(List<EstadoRequisicion> EstadoRequisicions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoRequisicion(estadorequisicions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoRequisicion(EstadoRequisicion EstadoRequisicion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoRequisicion(estadorequisicion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoRequisicion estadorequisicion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadorequisicion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoRequisicionConstantesFunciones.getEstadoRequisicionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadorequisicion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoRequisicionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoRequisicionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoRequisicionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRequisicion.class.getSimpleName()+"-saveEstadoRequisicionWithConnection");connexion.begin();			
			
			EstadoRequisicionLogicAdditional.checkEstadoRequisicionToSave(this.estadorequisicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoRequisicionLogicAdditional.updateEstadoRequisicionToSave(this.estadorequisicion,this.arrDatoGeneral);
			
			EstadoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadorequisicion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoRequisicion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoRequisicion(this.estadorequisicion)) {
				EstadoRequisicionDataAccess.save(this.estadorequisicion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadorequisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoRequisicionLogicAdditional.checkEstadoRequisicionToSaveAfter(this.estadorequisicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoRequisicion();
			
			connexion.commit();			
			
			if(this.estadorequisicion.getIsDeleted()) {
				this.estadorequisicion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoRequisicion()throws Exception {	
		try {	
			
			EstadoRequisicionLogicAdditional.checkEstadoRequisicionToSave(this.estadorequisicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoRequisicionLogicAdditional.updateEstadoRequisicionToSave(this.estadorequisicion,this.arrDatoGeneral);
			
			EstadoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadorequisicion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoRequisicion(this.estadorequisicion)) {			
				EstadoRequisicionDataAccess.save(this.estadorequisicion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadorequisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoRequisicionLogicAdditional.checkEstadoRequisicionToSaveAfter(this.estadorequisicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadorequisicion.getIsDeleted()) {
				this.estadorequisicion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoRequisicionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRequisicion.class.getSimpleName()+"-saveEstadoRequisicionsWithConnection");connexion.begin();			
			
			EstadoRequisicionLogicAdditional.checkEstadoRequisicionToSaves(estadorequisicions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoRequisicions();
			
			Boolean validadoTodosEstadoRequisicion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoRequisicion estadorequisicionLocal:estadorequisicions) {		
				if(estadorequisicionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoRequisicionLogicAdditional.updateEstadoRequisicionToSave(estadorequisicionLocal,this.arrDatoGeneral);
	        	
				EstadoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadorequisicionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoRequisicion(estadorequisicionLocal)) {
					EstadoRequisicionDataAccess.save(estadorequisicionLocal, connexion);				
				} else {
					validadoTodosEstadoRequisicion=false;
				}
			}
			
			if(!validadoTodosEstadoRequisicion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoRequisicionLogicAdditional.checkEstadoRequisicionToSavesAfter(estadorequisicions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoRequisicions();
			
			connexion.commit();		
			
			this.quitarEstadoRequisicionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoRequisicions()throws Exception {				
		 try {	
			EstadoRequisicionLogicAdditional.checkEstadoRequisicionToSaves(estadorequisicions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoRequisicion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoRequisicion estadorequisicionLocal:estadorequisicions) {				
				if(estadorequisicionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoRequisicionLogicAdditional.updateEstadoRequisicionToSave(estadorequisicionLocal,this.arrDatoGeneral);
	        	
				EstadoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadorequisicionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoRequisicion(estadorequisicionLocal)) {				
					EstadoRequisicionDataAccess.save(estadorequisicionLocal, connexion);				
				} else {
					validadoTodosEstadoRequisicion=false;
				}
			}
			
			if(!validadoTodosEstadoRequisicion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoRequisicionLogicAdditional.checkEstadoRequisicionToSavesAfter(estadorequisicions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoRequisicionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoRequisicionParameterReturnGeneral procesarAccionEstadoRequisicions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoRequisicion> estadorequisicions,EstadoRequisicionParameterReturnGeneral estadorequisicionParameterGeneral)throws Exception {
		 try {	
			EstadoRequisicionParameterReturnGeneral estadorequisicionReturnGeneral=new EstadoRequisicionParameterReturnGeneral();
	
			EstadoRequisicionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadorequisicions,estadorequisicionParameterGeneral,estadorequisicionReturnGeneral);
			
			return estadorequisicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoRequisicionParameterReturnGeneral procesarAccionEstadoRequisicionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoRequisicion> estadorequisicions,EstadoRequisicionParameterReturnGeneral estadorequisicionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRequisicion.class.getSimpleName()+"-procesarAccionEstadoRequisicionsWithConnection");connexion.begin();			
			
			EstadoRequisicionParameterReturnGeneral estadorequisicionReturnGeneral=new EstadoRequisicionParameterReturnGeneral();
	
			EstadoRequisicionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadorequisicions,estadorequisicionParameterGeneral,estadorequisicionReturnGeneral);
			
			this.connexion.commit();
			
			return estadorequisicionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoRequisicionParameterReturnGeneral procesarEventosEstadoRequisicions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoRequisicion> estadorequisicions,EstadoRequisicion estadorequisicion,EstadoRequisicionParameterReturnGeneral estadorequisicionParameterGeneral,Boolean isEsNuevoEstadoRequisicion,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoRequisicionParameterReturnGeneral estadorequisicionReturnGeneral=new EstadoRequisicionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadorequisicionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoRequisicionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadorequisicions,estadorequisicion,estadorequisicionParameterGeneral,estadorequisicionReturnGeneral,isEsNuevoEstadoRequisicion,clases);
			
			return estadorequisicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoRequisicionParameterReturnGeneral procesarEventosEstadoRequisicionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoRequisicion> estadorequisicions,EstadoRequisicion estadorequisicion,EstadoRequisicionParameterReturnGeneral estadorequisicionParameterGeneral,Boolean isEsNuevoEstadoRequisicion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRequisicion.class.getSimpleName()+"-procesarEventosEstadoRequisicionsWithConnection");connexion.begin();			
			
			EstadoRequisicionParameterReturnGeneral estadorequisicionReturnGeneral=new EstadoRequisicionParameterReturnGeneral();
	
			estadorequisicionReturnGeneral.setEstadoRequisicion(estadorequisicion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadorequisicionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoRequisicionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadorequisicions,estadorequisicion,estadorequisicionParameterGeneral,estadorequisicionReturnGeneral,isEsNuevoEstadoRequisicion,clases);
			
			this.connexion.commit();
			
			return estadorequisicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoRequisicionParameterReturnGeneral procesarImportacionEstadoRequisicionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoRequisicionParameterReturnGeneral estadorequisicionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRequisicion.class.getSimpleName()+"-procesarImportacionEstadoRequisicionsWithConnection");connexion.begin();			
			
			EstadoRequisicionParameterReturnGeneral estadorequisicionReturnGeneral=new EstadoRequisicionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadorequisicions=new ArrayList<EstadoRequisicion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadorequisicion=new EstadoRequisicion();
				
				
				if(conColumnasBase) {this.estadorequisicion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadorequisicion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadorequisicion.setcodigo(arrColumnas[iColumn++]);
				this.estadorequisicion.setnombre(arrColumnas[iColumn++]);
				
				this.estadorequisicions.add(this.estadorequisicion);
			}
			
			this.saveEstadoRequisicions();
			
			this.connexion.commit();
			
			estadorequisicionReturnGeneral.setConRetornoEstaProcesado(true);
			estadorequisicionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadorequisicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoRequisicionsEliminados() throws Exception {				
		
		List<EstadoRequisicion> estadorequisicionsAux= new ArrayList<EstadoRequisicion>();
		
		for(EstadoRequisicion estadorequisicion:estadorequisicions) {
			if(!estadorequisicion.getIsDeleted()) {
				estadorequisicionsAux.add(estadorequisicion);
			}
		}
		
		estadorequisicions=estadorequisicionsAux;
	}
	
	public void quitarEstadoRequisicionsNulos() throws Exception {				
		
		List<EstadoRequisicion> estadorequisicionsAux= new ArrayList<EstadoRequisicion>();
		
		for(EstadoRequisicion estadorequisicion : this.estadorequisicions) {
			if(estadorequisicion==null) {
				estadorequisicionsAux.add(estadorequisicion);
			}
		}
		
		//this.estadorequisicions=estadorequisicionsAux;
		
		this.estadorequisicions.removeAll(estadorequisicionsAux);
	}
	
	public void getSetVersionRowEstadoRequisicionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadorequisicion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadorequisicion.getIsDeleted() || (estadorequisicion.getIsChanged()&&!estadorequisicion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadorequisicionDataAccess.getSetVersionRowEstadoRequisicion(connexion,estadorequisicion.getId());
				
				if(!estadorequisicion.getVersionRow().equals(timestamp)) {	
					estadorequisicion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadorequisicion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoRequisicion()throws Exception {	
		
		if(estadorequisicion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadorequisicion.getIsDeleted() || (estadorequisicion.getIsChanged()&&!estadorequisicion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadorequisicionDataAccess.getSetVersionRowEstadoRequisicion(connexion,estadorequisicion.getId());
			
			try {							
				if(!estadorequisicion.getVersionRow().equals(timestamp)) {	
					estadorequisicion.setVersionRow(timestamp);
				}
				
				estadorequisicion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoRequisicionsWithConnection()throws Exception {	
		if(estadorequisicions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoRequisicion estadorequisicionAux:estadorequisicions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadorequisicionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadorequisicionAux.getIsDeleted() || (estadorequisicionAux.getIsChanged()&&!estadorequisicionAux.getIsNew())) {
						
						timestamp=estadorequisicionDataAccess.getSetVersionRowEstadoRequisicion(connexion,estadorequisicionAux.getId());
						
						if(!estadorequisicion.getVersionRow().equals(timestamp)) {	
							estadorequisicionAux.setVersionRow(timestamp);
						}
								
						estadorequisicionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoRequisicions()throws Exception {	
		if(estadorequisicions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoRequisicion estadorequisicionAux:estadorequisicions) {
					if(estadorequisicionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadorequisicionAux.getIsDeleted() || (estadorequisicionAux.getIsChanged()&&!estadorequisicionAux.getIsNew())) {
						
						timestamp=estadorequisicionDataAccess.getSetVersionRowEstadoRequisicion(connexion,estadorequisicionAux.getId());
						
						if(!estadorequisicionAux.getVersionRow().equals(timestamp)) {	
							estadorequisicionAux.setVersionRow(timestamp);
						}
						
													
						estadorequisicionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoRequisicionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			RequisicionCompraLogic requisicioncompraLogic=new RequisicionCompraLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRequisicion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoRequisicionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(RequisicionCompra.class));
											
			

			requisicioncompraLogic.setConnexion(this.getConnexion());
			requisicioncompraLogic.setDatosCliente(this.datosCliente);
			requisicioncompraLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoRequisicion estadorequisicion:this.estadorequisicions) {
				

				classes=new ArrayList<Classe>();
				classes=RequisicionCompraConstantesFunciones.getClassesForeignKeysOfRequisicionCompra(new ArrayList<Classe>(),DeepLoadType.NONE);

				requisicioncompraLogic.setRequisicionCompras(estadorequisicion.requisicioncompraCompras);
				requisicioncompraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoRequisicion estadorequisicion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoRequisicionLogicAdditional.updateEstadoRequisicionToGet(estadorequisicion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadorequisicion.setRequisicionCompraCompras(estadorequisicionDataAccess.getRequisicionCompraCompras(connexion,estadorequisicion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(RequisicionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadorequisicion.setRequisicionCompraCompras(estadorequisicionDataAccess.getRequisicionCompraCompras(connexion,estadorequisicion));

				if(this.isConDeep) {
					RequisicionCompraLogic requisicioncompraLogic= new RequisicionCompraLogic(this.connexion);
					requisicioncompraLogic.setRequisicionCompras(estadorequisicion.getRequisicionCompraCompras());
					ArrayList<Classe> classesLocal=RequisicionCompraConstantesFunciones.getClassesForeignKeysOfRequisicionCompra(new ArrayList<Classe>(),DeepLoadType.NONE);
					requisicioncompraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RequisicionCompraConstantesFunciones.refrescarForeignKeysDescripcionesRequisicionCompra(requisicioncompraLogic.getRequisicionCompras());
					estadorequisicion.setRequisicionCompraCompras(requisicioncompraLogic.getRequisicionCompras());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RequisicionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RequisicionCompra.class));
			estadorequisicion.setRequisicionCompraCompras(estadorequisicionDataAccess.getRequisicionCompraCompras(connexion,estadorequisicion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadorequisicion.setRequisicionCompraCompras(estadorequisicionDataAccess.getRequisicionCompraCompras(connexion,estadorequisicion));

		for(RequisicionCompra requisicioncompra:estadorequisicion.getRequisicionCompraCompras()) {
			RequisicionCompraLogic requisicioncompraLogic= new RequisicionCompraLogic(connexion);
			requisicioncompraLogic.deepLoad(requisicioncompra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(RequisicionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadorequisicion.setRequisicionCompraCompras(estadorequisicionDataAccess.getRequisicionCompraCompras(connexion,estadorequisicion));

				for(RequisicionCompra requisicioncompra:estadorequisicion.getRequisicionCompraCompras()) {
					RequisicionCompraLogic requisicioncompraLogic= new RequisicionCompraLogic(connexion);
					requisicioncompraLogic.deepLoad(requisicioncompra,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RequisicionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RequisicionCompra.class));
			estadorequisicion.setRequisicionCompraCompras(estadorequisicionDataAccess.getRequisicionCompraCompras(connexion,estadorequisicion));

			for(RequisicionCompra requisicioncompra:estadorequisicion.getRequisicionCompraCompras()) {
				RequisicionCompraLogic requisicioncompraLogic= new RequisicionCompraLogic(connexion);
				requisicioncompraLogic.deepLoad(requisicioncompra,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoRequisicion estadorequisicion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoRequisicionLogicAdditional.updateEstadoRequisicionToSave(estadorequisicion,this.arrDatoGeneral);
			
EstadoRequisicionDataAccess.save(estadorequisicion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(RequisicionCompra requisicioncompra:estadorequisicion.getRequisicionCompraCompras()) {
			requisicioncompra.setid_estado_requisicion_compra(estadorequisicion.getId());
			RequisicionCompraDataAccess.save(requisicioncompra,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(RequisicionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RequisicionCompra requisicioncompra:estadorequisicion.getRequisicionCompraCompras()) {
					requisicioncompra.setid_estado_requisicion_compra(estadorequisicion.getId());
					RequisicionCompraDataAccess.save(requisicioncompra,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(RequisicionCompra requisicioncompra:estadorequisicion.getRequisicionCompraCompras()) {
			RequisicionCompraLogic requisicioncompraLogic= new RequisicionCompraLogic(connexion);
			requisicioncompra.setid_estado_requisicion_compra(estadorequisicion.getId());
			RequisicionCompraDataAccess.save(requisicioncompra,connexion);
			requisicioncompraLogic.deepSave(requisicioncompra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(RequisicionCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RequisicionCompra requisicioncompra:estadorequisicion.getRequisicionCompraCompras()) {
					RequisicionCompraLogic requisicioncompraLogic= new RequisicionCompraLogic(connexion);
					requisicioncompra.setid_estado_requisicion_compra(estadorequisicion.getId());
					RequisicionCompraDataAccess.save(requisicioncompra,connexion);
					requisicioncompraLogic.deepSave(requisicioncompra,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EstadoRequisicion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadorequisicion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRequisicion(estadorequisicion);
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
			this.deepLoad(this.estadorequisicion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRequisicion(this.estadorequisicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoRequisicion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadorequisicions!=null) {
				for(EstadoRequisicion estadorequisicion:estadorequisicions) {
					this.deepLoad(estadorequisicion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRequisicion(estadorequisicions);
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
			if(estadorequisicions!=null) {
				for(EstadoRequisicion estadorequisicion:estadorequisicions) {
					this.deepLoad(estadorequisicion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRequisicion(estadorequisicions);
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
			this.getNewConnexionToDeep(EstadoRequisicion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadorequisicion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoRequisicion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadorequisicions!=null) {
				for(EstadoRequisicion estadorequisicion:estadorequisicions) {
					this.deepSave(estadorequisicion,isDeep,deepLoadType,clases);
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
			if(estadorequisicions!=null) {
				for(EstadoRequisicion estadorequisicion:estadorequisicions) {
					this.deepSave(estadorequisicion,isDeep,deepLoadType,clases);
				}		
			}
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
			if(EstadoRequisicionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoRequisicionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoRequisicion estadorequisicion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoRequisicionConstantesFunciones.ISCONAUDITORIA) {
				if(estadorequisicion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoRequisicionDataAccess.TABLENAME, estadorequisicion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoRequisicionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoRequisicionLogic.registrarAuditoriaDetallesEstadoRequisicion(connexion,estadorequisicion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadorequisicion.getIsDeleted()) {
					/*if(!estadorequisicion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoRequisicionDataAccess.TABLENAME, estadorequisicion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoRequisicionLogic.registrarAuditoriaDetallesEstadoRequisicion(connexion,estadorequisicion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoRequisicionDataAccess.TABLENAME, estadorequisicion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadorequisicion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoRequisicionDataAccess.TABLENAME, estadorequisicion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoRequisicionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoRequisicionLogic.registrarAuditoriaDetallesEstadoRequisicion(connexion,estadorequisicion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoRequisicion(Connexion connexion,EstadoRequisicion estadorequisicion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadorequisicion.getIsNew()||!estadorequisicion.getcodigo().equals(estadorequisicion.getEstadoRequisicionOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadorequisicion.getEstadoRequisicionOriginal().getcodigo()!=null)
				{
					strValorActual=estadorequisicion.getEstadoRequisicionOriginal().getcodigo();
				}
				if(estadorequisicion.getcodigo()!=null)
				{
					strValorNuevo=estadorequisicion.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoRequisicionConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadorequisicion.getIsNew()||!estadorequisicion.getnombre().equals(estadorequisicion.getEstadoRequisicionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadorequisicion.getEstadoRequisicionOriginal().getnombre()!=null)
				{
					strValorActual=estadorequisicion.getEstadoRequisicionOriginal().getnombre();
				}
				if(estadorequisicion.getnombre()!=null)
				{
					strValorNuevo=estadorequisicion.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoRequisicionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoRequisicionRelacionesWithConnection(EstadoRequisicion estadorequisicion,List<RequisicionCompra> requisicioncompraCompras) throws Exception {

		if(!estadorequisicion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoRequisicionRelacionesBase(estadorequisicion,requisicioncompraCompras,true);
		}
	}

	public void saveEstadoRequisicionRelaciones(EstadoRequisicion estadorequisicion,List<RequisicionCompra> requisicioncompraCompras)throws Exception {

		if(!estadorequisicion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoRequisicionRelacionesBase(estadorequisicion,requisicioncompraCompras,false);
		}
	}

	public void saveEstadoRequisicionRelacionesBase(EstadoRequisicion estadorequisicion,List<RequisicionCompra> requisicioncompraCompras,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoRequisicion-saveRelacionesWithConnection");}
	
			estadorequisicion.setRequisicionCompraCompras(requisicioncompraCompras);

			this.setEstadoRequisicion(estadorequisicion);

				if((estadorequisicion.getIsNew()||estadorequisicion.getIsChanged())&&!estadorequisicion.getIsDeleted()) {
					this.saveEstadoRequisicion();
					this.saveEstadoRequisicionRelacionesDetalles(requisicioncompraCompras);

				} else if(estadorequisicion.getIsDeleted()) {
					this.saveEstadoRequisicionRelacionesDetalles(requisicioncompraCompras);
					this.saveEstadoRequisicion();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			RequisicionCompraConstantesFunciones.InicializarGeneralEntityAuxiliaresRequisicionCompras(requisicioncompraCompras,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoRequisicionRelacionesDetalles(List<RequisicionCompra> requisicioncompraCompras)throws Exception {
		try {
	

			Long idEstadoRequisicionActual=this.getEstadoRequisicion().getId();

			RequisicionCompraLogic requisicioncompraCompraLogic_Desde_EstadoRequisicion=new RequisicionCompraLogic();
			requisicioncompraCompraLogic_Desde_EstadoRequisicion.setRequisicionCompras(requisicioncompraCompras);

			requisicioncompraCompraLogic_Desde_EstadoRequisicion.setConnexion(this.getConnexion());
			requisicioncompraCompraLogic_Desde_EstadoRequisicion.setDatosCliente(this.datosCliente);

			for(RequisicionCompra requisicioncompra_Desde_EstadoRequisicion:requisicioncompraCompraLogic_Desde_EstadoRequisicion.getRequisicionCompras()) {
				requisicioncompra_Desde_EstadoRequisicion.setid_estado_requisicion_compra(idEstadoRequisicionActual);

				requisicioncompraCompraLogic_Desde_EstadoRequisicion.setRequisicionCompra(requisicioncompra_Desde_EstadoRequisicion);
				requisicioncompraCompraLogic_Desde_EstadoRequisicion.saveRequisicionCompra();

				Long idRequisicionCompraActual=requisicioncompra_Desde_EstadoRequisicion.getId();

				DetalleRequisicionCompraLogic detallerequisicioncompraLogic_Desde_RequisicionCompra=new DetalleRequisicionCompraLogic();

				if(requisicioncompra_Desde_EstadoRequisicion.getDetalleRequisicionCompras()==null){
					requisicioncompra_Desde_EstadoRequisicion.setDetalleRequisicionCompras(new ArrayList<DetalleRequisicionCompra>());
				}

				detallerequisicioncompraLogic_Desde_RequisicionCompra.setDetalleRequisicionCompras(requisicioncompra_Desde_EstadoRequisicion.getDetalleRequisicionCompras());

				detallerequisicioncompraLogic_Desde_RequisicionCompra.setConnexion(this.getConnexion());
				detallerequisicioncompraLogic_Desde_RequisicionCompra.setDatosCliente(this.datosCliente);

				for(DetalleRequisicionCompra detallerequisicioncompra_Desde_RequisicionCompra:detallerequisicioncompraLogic_Desde_RequisicionCompra.getDetalleRequisicionCompras()) {
					detallerequisicioncompra_Desde_RequisicionCompra.setid_requisicion_compra(idRequisicionCompraActual);
				}

				detallerequisicioncompraLogic_Desde_RequisicionCompra.saveDetalleRequisicionCompras();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoRequisicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoRequisicionConstantesFunciones.getClassesForeignKeysOfEstadoRequisicion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoRequisicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoRequisicionConstantesFunciones.getClassesRelationshipsOfEstadoRequisicion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
